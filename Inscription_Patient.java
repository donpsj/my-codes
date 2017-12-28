//Inscription_Patient.java

import com.ms.wfc.app.*;
import com.ms.wfc.core.*;
import com.ms.wfc.ui.*;
import com.ms.wfc.data.*;
import com.ms.wfc.data.ui.*;

public class Inscription_Patient extends Form
{      
    public void btnAdd_Click(Object sender, Event evt)
    {   
		try
        {
            dataSource1.getRecordset().cancelUpdate();
            dataSource1.getRecordset().addNew();
            m_bAddNew = true;           
            btnAdd.setEnabled( false );
			btnUpdate.setEnabled(true);
		    editNom.setText("");
           editPrenom.setText("");
		   sexe.setText("");
		   editAdresse.setText("");
		   editPhone_1.setText("");
		   editPhone_2.setText("");
		   editNo_dossier.setText("0");
		   editRef_titul.setText("");
		   nif2.setText("");
            
           }
        catch (Exception e)
        {
            handleADOException(e);
        }
    }

    
    public void btnUpdate_Click(Object sender, Event evt)
    {   DataSource rec1 = new DataSource();
		DataSource rec = new DataSource();
		DataSource rdos = new DataSource();
		 int tit2=10;
		
		rec.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		rec.setCommandText("select * from Titulaire where Nif = '"+editRef_titul.getText()+"'");			  			
        rec.begin();
		
		    rec1.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		    rec1.setCommandText("select * from Titulaire where Nif = '"+nif2.getText()+"'");			  			
            rec1.begin();
			if(nif2.getText().equals(""))
				tit2=0;
			else
				tit2=1;
			
		rdos.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		rdos.setCommandText("select * from Patient where No_dossier = "+editNo_dossier.getText()+"");			  			
        rdos.begin();
			
		try
        {  
				
		   int ndos = (Integer.valueOf(editNo_dossier.getText()).intValue());
						
			if(editNom.getText().equals(""))
		   {MessageBox.show("Veuillez Entrer le Nom du Patient s.v.p","Champ Vide",MessageBox.ICONERROR);
		   }
		   else
			   if(editPrenom.getText().equals(""))
		   {MessageBox.show("Veuillez Entrer le Prénom du Patient s.v.p","Champ Vide",MessageBox.ICONERROR);
		   }
		   else
			   if(sexe.getText().equals(""))
		   {MessageBox.show("Veuillez Choisir le Sexe  du Patient s.v.p","Champ Vide",MessageBox.ICONERROR);
		   }
		   else
			   if(editAdresse.getText().equals(""))
		   {MessageBox.show("Veuillez Entrer l'Adresse  du Patient s.v.p","Champ Vide",MessageBox.ICONERROR);
		   }
		   else
			   if(editPhone_1.getText().equals(""))
		   {MessageBox.show("Veuillez Entrer au Moins un Numéro de Téléphone du Patient s.v.p","Champ Vide",MessageBox.ICONERROR);
		   }
		   else
			  if(editRef_titul.getText().equals(""))
		         {MessageBox.show("Veuillez Entrer le NIF du 1er Titulaire s.v.p","Champ Vide",MessageBox.ICONERROR);
		          }
		   else
			   if(editNo_dossier.getText().equals("0"))
		   {MessageBox.show("Veuillez Entrer le Numéro du Dossier  du Patient s.v.p","Champ Vide",MessageBox.ICONERROR);
		   }
		   	   
		   else
			  if(String.valueOf(rec.getRecordset().getRecordCount()).equals("0"))
			     {MessageBox.show("Désolé Le 1er Titulaire Identifié au NIF < '"+editRef_titul.getText()+"' > n'Existe pas, Vérifiez le NIF S.V.P !", " Données Introuvables",MessageBox.ICONWARNING);
				  }
			  else
				 if(tit2==1 && (String.valueOf(rec1.getRecordset().getRecordCount()).equals("0")))
			     {MessageBox.show("Désolé Le 2me Titulaire Identifié au NIF < '"+nif2.getText()+"' > n'Existe pas, Vérifiez le NIF S.V.P !", " Données Introuvables",MessageBox.ICONWARNING);
				  nif2.setText("");
				  }
				 else
					 if(nif2.getText().compareTo(editRef_titul.getText())==0)
					 { MessageBox.show("Désolé  Les Deux Titulaires ne Peuvent être Identifiés  au même NIF < '"+nif2.getText()+"' >, Vérifiez les NIF S.V.P !", " Opération Illégale ",MessageBox.ICONWARNING);
					 }
			     else
				    if(String.valueOf(rdos.getRecordset().getRecordCount()).equals("1")) 
					{ MessageBox.show("Désolé, Le Patient Identifié au Dossier No "+ndos+" est déjà inscrit! Vérifiez le No du Dossier S.V.P ", " Opération Illégale ",MessageBox.ICONWARNING);
					}
		   else
		   {  if(String.valueOf(rec.getRecordset().getRecordCount()).equals("1") && String.valueOf(rec1.getRecordset().getRecordCount()).equals("1"))
			  { 
				  DataBinder verifier = new DataBinder();
				  verifier.setDataSource(rec);
				  verifier.setBindings(new DataBinding[]{
							    new DataBinding(n1,"text","Nom"),
							    new DataBinding(p1,"text","Prenom"),
		
									   });
				  
				  DataBinder verifier1 = new DataBinder();
				  verifier1.setDataSource(rec1);
				  verifier1.setBindings(new DataBinding[]{
							    new DataBinding(ntit2,"text","Nom"),
							    new DataBinding(ptit2,"text","Prenom"),
		
									   });
					  			  
				 int res=MessageBox.show(" Etes-Vous Sur que ce Patient est Bénéficiaire des Titulaires : << "+n1.getText()+"  "+p1.getText()+" ? >> et << "+ntit2.getText()+"  "+ptit2.getText()+" ? >> ", "Moment Décisif ",MessageBox.YESNO);
			     if(res==MessageBox.IDYES)
				 {  this.setCursor( Cursor.WAIT );
                    dataBinder1.commitChanges();
                   dataSource1.getRecordset().update();
				   MessageBox.show("Felicitations !! L'inscription du Patient << "+editNom.getText()+"  "+editPrenom.getText()+" >> est Réussie ", " Confirmation",MessageBox.ICONINFORMATION);

                               
		         btnAdd.setEnabled( true );
			     btnUpdate.setEnabled(false);
								 
				 }
			    }
			else
			 if(String.valueOf(rec.getRecordset().getRecordCount()).equals("1") && String.valueOf(rec1.getRecordset().getRecordCount()).equals("0"))
			 {
				 DataBinder verifier = new DataBinder();
				  verifier.setDataSource(rec);
				  verifier.setBindings(new DataBinding[]{
							    new DataBinding(n1,"text","Nom"),
							    new DataBinding(p1,"text","Prenom"),
		
									   });
			  int resul=MessageBox.show(" Etes-Vous Sur ce Patient est Bénéficiaire du Titulaire: << "+n1.getText()+"  "+p1.getText()+" ? >> ", "Moment Décisif ",MessageBox.YESNO);
			  if(resul==MessageBox.IDYES)
				{
				 			
                 this.setCursor( Cursor.WAIT );
                 dataBinder1.commitChanges();
                 dataSource1.getRecordset().update();
				 MessageBox.show("Felicitations !! L'inscription du Patient << "+editNom.getText()+"  "+editPrenom.getText()+" >> est Réussie ", " Confirmation",MessageBox.ICONINFORMATION);

                               
		         btnAdd.setEnabled( true );
			     btnUpdate.setEnabled(false);
			  }
			 }
		   }
		 }
		
		catch(NumberFormatException e){
		MessageBox.show("Attention, Le Numéro de Dossier du Patient Doit être un Nombre!", " Données Incompatibles",MessageBox.ICONERROR);
		}
        catch (Exception e)
        {
            handleADOException(e);
            if( m_bAddNew )
            {
                this.setCursor( Cursor.DEFAULT );
                return;
            }
            else
                dataSource1.getRecordset().cancelUpdate();
        }

        this.setCursor( Cursor.DEFAULT );
        m_bAddNew = false;       
         
    }

    public void btnClose_Click(Object sender, Event evt)
    {
        hide();
    }

    boolean    m_bAddNew;
	
    public void dispose()
    {
        super.dispose();
        components.dispose();
    }

    public Inscription_Patient()
    {
        // Required for Visual J++ Form Designer support
        initForm();
        
        this.show();
        this.update();
		
		    dataSource1.getRecordset().cancelUpdate();
            dataSource1.getRecordset().addNew();
            m_bAddNew = true;           
            btnAdd.setEnabled( false );
			btnUpdate.setEnabled(true);
			editNom.setText("");
            editPrenom.setText("");
		   sexe.setText("");
		   editAdresse.setText("");
		   editPhone_1.setText("");
		   editPhone_2.setText("");
		   editNo_dossier.setText("0");
		   editRef_titul.setText("");
		   nif2.setText("");
			
        //TODO: Add any constructor code after initForm call
    }    

    public void formClose(Event e)
    {
        Application.exit();
    }    

    
    void handleADOException(Exception e)
    {
        e.printStackTrace();
        MessageBox.show( e.toString(), "Inscription_Patient" );
    }

	/**
	 * NOTE: The following code is required by the Visual J++ form
	 * designer.  It can be modified using the form editor.  Do not
	 * modify it using the code editor.
	 */
	Container components = new Container();
	DataSource dataSource1 = new DataSource(components);
	DataBinder dataBinder1 = new DataBinder(components);
	Label labelNom = new Label();
	Edit editNom = new Edit();
	Label labelPrenom = new Label();
	Edit editPrenom = new Edit();
	Label labelSexe = new Label();
	ComboBox sexe = new ComboBox();
	Label labelAdresse = new Label();
	Edit editAdresse = new Edit();
	Label labelPhone_1 = new Label();
	Edit editPhone_1 = new Edit();
	Label labelPhone_2 = new Label();
	Edit editPhone_2 = new Edit();
	Label labelRef_titul = new Label();
	Edit editRef_titul = new Edit();
	Label labelNo_dossier = new Label();
	Edit editNo_dossier = new Edit();
	Button btnAdd = new Button();
	Button btnUpdate = new Button();
	Button btnClose = new Button();
	Panel panel1 = new Panel();
	Panel panel2 = new Panel();
	PictureBox pictureBox1 = new PictureBox();
	Label label1 = new Label();
	PictureBox pictureBox2 = new PictureBox();
	PictureBox pictureBox3 = new PictureBox();
	PictureBox pictureBox4 = new PictureBox();
	PictureBox pictureBox6 = new PictureBox();
	Edit n1 = new Edit();
	Edit p1 = new Edit();
	Label label2 = new Label();
	Edit nif2 = new Edit();
	Label label3 = new Label();
	Edit ntit2 = new Edit();
	Edit ptit2 = new Edit();

	private void initForm()
	{
		// REMARQUE : cette feuille stocke des informations sur les ressources
		// dans un fichier externe. Ne modifiez le paramètre de chaîne d'aucun
		// appel de fonction resources.getObject(). Par exemple,
		// ne modifiez pas "foo1_location" dans la ligne de code
		// suivante, même si le nom de l'objet Foo change : 
		//	 foo1.setLocation((Point)resources.getObject("foo1_location"));

		IResourceManager resources = new ResourceManager(this, "Inscription_Patient");
		this.setLocation(new Point(7, 7));
		this.setText("Inscription d\' un Patient Assuré");
		this.setAutoScaleBaseSize(new Point(5, 13));
		this.setAutoScroll(true);
		this.setBorderStyle(FormBorderStyle.NONE);
		this.setClientSize(new Point(530, 432));
		this.setStartPosition(FormStartPosition.CENTER_SCREEN);

		dataSource1.setConnectionString("Provider=MSDASQL.1;Persist Security Info=False;Extended Properties=\"dsn=HAH;uid=genial;DBQ=C:\\ASSURE.MDB\";Initial Catalog=C:\\ASSURE");
		dataSource1.setCommandText("select Nom, Prenom, Sexe, Adresse, Phone_1, Phone_2, Ref_titul,Ref_titul2, No_dossier from Patient ORDER by Nom");
		dataSource1.setSort(null);
		dataSource1.setStayInSync(true);
		dataSource1.setUserId(null);
		dataSource1.setPassword(null);
		/* @designTimeOnly dataSource1.setLocation(new Point(344, 56)); */

		labelNom.setBackColor(Color.CONTROL);
		labelNom.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNom.setLocation(new Point(97, 140));
		labelNom.setSize(new Point(120, 22));
		labelNom.setTabIndex(12);
		labelNom.setTabStop(false);
		labelNom.setText("Nom");
		labelNom.setBorderStyle(BorderStyle.FIXED_3D);

		editNom.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNom.setLocation(new Point(223, 142));
		editNom.setSize(new Point(188, 20));
		editNom.setTabIndex(1);
		editNom.setText("");
		editNom.setMaxLength(50);

		labelPrenom.setBackColor(Color.CONTROL);
		labelPrenom.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelPrenom.setLocation(new Point(96, 166));
		labelPrenom.setSize(new Point(120, 22));
		labelPrenom.setTabIndex(13);
		labelPrenom.setTabStop(false);
		labelPrenom.setText("Prénom");
		labelPrenom.setBorderStyle(BorderStyle.FIXED_3D);

		editPrenom.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editPrenom.setLocation(new Point(223, 168));
		editPrenom.setSize(new Point(188, 20));
		editPrenom.setTabIndex(2);
		editPrenom.setText("");
		editPrenom.setMaxLength(50);

		labelSexe.setBackColor(Color.CONTROL);
		labelSexe.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelSexe.setLocation(new Point(96, 192));
		labelSexe.setSize(new Point(120, 22));
		labelSexe.setTabIndex(14);
		labelSexe.setTabStop(false);
		labelSexe.setText("Sexe");
		labelSexe.setBorderStyle(BorderStyle.FIXED_3D);

		sexe.setLocation(new Point(223, 193));
		sexe.setSize(new Point(56, 21));
		sexe.setTabIndex(3);
		sexe.setText("");
		sexe.setItems(new Object[] {
					  "M", 
					  "F"});

		labelAdresse.setBackColor(Color.CONTROL);
		labelAdresse.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelAdresse.setLocation(new Point(96, 218));
		labelAdresse.setSize(new Point(120, 22));
		labelAdresse.setTabIndex(15);
		labelAdresse.setTabStop(false);
		labelAdresse.setText("Adresse");
		labelAdresse.setBorderStyle(BorderStyle.FIXED_3D);

		editAdresse.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editAdresse.setLocation(new Point(223, 220));
		editAdresse.setSize(new Point(188, 20));
		editAdresse.setTabIndex(4);
		editAdresse.setText("");
		editAdresse.setMaxLength(50);

		labelPhone_1.setBackColor(Color.CONTROL);
		labelPhone_1.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelPhone_1.setLocation(new Point(96, 244));
		labelPhone_1.setSize(new Point(120, 22));
		labelPhone_1.setTabIndex(16);
		labelPhone_1.setTabStop(false);
		labelPhone_1.setText("Phone_1");
		labelPhone_1.setBorderStyle(BorderStyle.FIXED_3D);

		editPhone_1.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editPhone_1.setLocation(new Point(223, 245));
		editPhone_1.setSize(new Point(120, 20));
		editPhone_1.setTabIndex(5);
		editPhone_1.setText("");
		editPhone_1.setMaxLength(15);

		labelPhone_2.setBackColor(Color.CONTROL);
		labelPhone_2.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelPhone_2.setLocation(new Point(96, 270));
		labelPhone_2.setSize(new Point(120, 22));
		labelPhone_2.setTabIndex(17);
		labelPhone_2.setTabStop(false);
		labelPhone_2.setText("Phone_2");
		labelPhone_2.setBorderStyle(BorderStyle.FIXED_3D);

		editPhone_2.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editPhone_2.setLocation(new Point(223, 271));
		editPhone_2.setSize(new Point(120, 20));
		editPhone_2.setTabIndex(6);
		editPhone_2.setText("");
		editPhone_2.setMaxLength(15);

		labelRef_titul.setBackColor(Color.CONTROL);
		labelRef_titul.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelRef_titul.setLocation(new Point(96, 297));
		labelRef_titul.setSize(new Point(120, 22));
		labelRef_titul.setTabIndex(18);
		labelRef_titul.setTabStop(false);
		labelRef_titul.setText("NIF du 1er Titulaire");
		labelRef_titul.setBorderStyle(BorderStyle.FIXED_3D);

		editRef_titul.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRef_titul.setFont(new Font("MS Sans Serif", 10.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		editRef_titul.setForeColor(Color.AQUA);
		editRef_titul.setLocation(new Point(223, 295));
		editRef_titul.setSize(new Point(120, 23));
		editRef_titul.setTabIndex(7);
		editRef_titul.setText("");
		editRef_titul.setCharacterCasing(CharacterCasing.UPPER);
		editRef_titul.setMaxLength(13);

		labelNo_dossier.setBackColor(Color.CONTROL);
		labelNo_dossier.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNo_dossier.setLocation(new Point(97, 350));
		labelNo_dossier.setSize(new Point(120, 22));
		labelNo_dossier.setTabIndex(19);
		labelNo_dossier.setTabStop(false);
		labelNo_dossier.setText("No de Dossier");
		labelNo_dossier.setBorderStyle(BorderStyle.FIXED_3D);

		editNo_dossier.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNo_dossier.setLocation(new Point(223, 350));
		editNo_dossier.setSize(new Point(120, 20));
		editNo_dossier.setTabIndex(9);
		editNo_dossier.setText("");
		editNo_dossier.setMaxLength(20);

		btnAdd.setLocation(new Point(40, 7));
		btnAdd.setSize(new Point(72, 25));
		btnAdd.setTabIndex(0);
		btnAdd.setText("&Nouveau");
		btnAdd.addOnClick(new EventHandler(this.btnAdd_Click));

		btnUpdate.setLocation(new Point(208, 8));
		btnUpdate.setSize(new Point(72, 25));
		btnUpdate.setTabIndex(1);
		btnUpdate.setText("&Enregistrer");
		btnUpdate.addOnClick(new EventHandler(this.btnUpdate_Click));

		btnClose.setLocation(new Point(399, 8));
		btnClose.setSize(new Point(72, 25));
		btnClose.setTabIndex(2);
		btnClose.setText("&Fermer");
		btnClose.addOnClick(new EventHandler(this.btnClose_Click));

		panel1.setBackColor(new Color(0, 192, 192));
		panel1.setDock(ControlDock.BOTTOM);
		panel1.setLocation(new Point(0, 392));
		panel1.setSize(new Point(530, 40));
		panel1.setTabIndex(20);
		panel1.setText("");
		panel1.setBorderStyle(BorderStyle.FIXED_3D);

		panel2.setLocation(new Point(64, 130));
		panel2.setSize(new Point(424, 248));
		panel2.setTabIndex(21);
		panel2.setText("panel2");
		panel2.setBorderStyle(BorderStyle.FIXED_3D);

		pictureBox1.setLocation(new Point(82, 35));
		pictureBox1.setSize(new Point(88, 80));
		pictureBox1.setTabIndex(23);
		pictureBox1.setTabStop(false);
		pictureBox1.setText("pictureBox1");
		pictureBox1.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox1.setImage((Bitmap)resources.getObject("pictureBox1_image"));
		pictureBox1.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		label1.setBackColor(new Color(255, 255, 192));
		label1.setFont(new Font("Verdana", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		label1.setForeColor(Color.AQUA);
		label1.setLocation(new Point(117, 7));
		label1.setSize(new Point(296, 24));
		label1.setTabIndex(22);
		label1.setTabStop(false);
		label1.setText("Inscription d\'un Patient Assuré");
		label1.setBorderStyle(BorderStyle.FIXED_3D);
		label1.setTextAlign(HorizontalAlignment.CENTER);

		pictureBox2.setLocation(new Point(401, 3));
		pictureBox2.setSize(new Point(16, 240));
		pictureBox2.setTabIndex(0);
		pictureBox2.setTabStop(false);
		pictureBox2.setText("pictureBox2");
		pictureBox2.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox2.setImage((Bitmap)resources.getObject("pictureBox2_image"));
		pictureBox2.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox3.setLocation(new Point(69, 134));
		pictureBox3.setSize(new Point(16, 240));
		pictureBox3.setTabIndex(11);
		pictureBox3.setTabStop(false);
		pictureBox3.setText("pictureBox2");
		pictureBox3.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox3.setImage((Bitmap)resources.getObject("pictureBox3_image"));
		pictureBox3.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox4.setLocation(new Point(63, 4));
		pictureBox4.setSize(new Point(400, 32));
		pictureBox4.setTabIndex(10);
		pictureBox4.setTabStop(false);
		pictureBox4.setText("pictureBox2");
		pictureBox4.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox4.setImage((Bitmap)resources.getObject("pictureBox4_image"));
		pictureBox4.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox6.setLocation(new Point(64, 47));
		pictureBox6.setSize(new Point(88, 80));
		pictureBox6.setTabIndex(0);
		pictureBox6.setTabStop(false);
		pictureBox6.setText("pictureBox2");
		pictureBox6.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox6.setImage((Bitmap)resources.getObject("pictureBox6_image"));
		pictureBox6.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		n1.setLocation(new Point(192, 104));
		n1.setSize(new Point(40, 20));
		n1.setTabIndex(25);
		n1.setText("");
		n1.setVisible(false);

		p1.setLocation(new Point(240, 104));
		p1.setSize(new Point(32, 20));
		p1.setTabIndex(24);
		p1.setText("");
		p1.setVisible(false);

		label2.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label2.setLocation(new Point(30, 191));
		label2.setSize(new Point(120, 22));
		label2.setTabIndex(1);
		label2.setTabStop(false);
		label2.setText("NIF du 2me Titulaire");
		label2.setBorderStyle(BorderStyle.FIXED_3D);

		nif2.setFont(new Font("MS Sans Serif", 10.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		nif2.setForeColor(new Color(0, 0, 128));
		nif2.setLocation(new Point(224, 320));
		nif2.setSize(new Point(120, 23));
		nif2.setTabIndex(8);
		nif2.setText("");
		nif2.setMaxLength(13);

		dataBinder1.setDataSource(dataSource1);
		dataBinder1.setDataMember("");
		dataBinder1.setBindings(new DataBinding[] {
								new DataBinding(editNom, "Text", "Nom", null), 
								new DataBinding(editPrenom, "Text", "Prenom", null), 
								new DataBinding(editAdresse, "Text", "Adresse", null), 
								new DataBinding(editPhone_1, "Text", "Phone_1", null), 
								new DataBinding(editPhone_2, "Text", "Phone_2", null), 
								new DataBinding(editRef_titul, "Text", "Ref_titul", null), 
								new DataBinding(editNo_dossier, "Text", "No_dossier", null), 
								new DataBinding(nif2, "Text", "Ref_titul2", null)});
		/* @designTimeOnly dataBinder1.setLocation(new Point(216, 56)); */

		label3.setBackColor(Color.AQUA);
		label3.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label3.setForeColor(new Color(255, 255, 128));
		label3.setLocation(new Point(281, 194));
		label3.setSize(new Point(112, 16));
		label3.setTabIndex(2);
		label3.setTabStop(false);
		label3.setText("Double  Assurance");
		label3.setBorderStyle(BorderStyle.FIXED_3D);

		ntit2.setLocation(new Point(304, 104));
		ntit2.setSize(new Point(32, 20));
		ntit2.setTabIndex(29);
		ntit2.setText("edit1");
		ntit2.setVisible(false);

		ptit2.setLocation(new Point(345, 101));
		ptit2.setSize(new Point(32, 20));
		ptit2.setTabIndex(28);
		ptit2.setText("edit2");
		ptit2.setVisible(false);

		this.setNewControls(new Control[] {
							nif2, 
							ptit2, 
							ntit2, 
							p1, 
							n1, 
							pictureBox3, 
							label1, 
							pictureBox1, 
							sexe, 
							panel1, 
							labelNom, 
							editNom, 
							labelPrenom, 
							editPrenom, 
							labelSexe, 
							labelAdresse, 
							editAdresse, 
							labelPhone_1, 
							editPhone_1, 
							labelPhone_2, 
							editPhone_2, 
							labelRef_titul, 
							editRef_titul, 
							labelNo_dossier, 
							editNo_dossier, 
							panel2, 
							pictureBox4, 
							pictureBox6});
		panel1.setNewControls(new Control[] {
							  btnAdd, 
							  btnUpdate, 
							  btnClose});
		panel2.setNewControls(new Control[] {
							  label3, 
							  label2, 
							  pictureBox2});

		dataSource1.begin();
		dataBinder1.begin();
	}
    //NOTE: End of form designer support code.

    /**
    * The main entry point for the application.
    *
    * @param args Array of parameters passed to the application
    * via the command line.
    */
    public static void main(String args[])
    {
        Application.run( new Inscription_Patient() );
    }
}
