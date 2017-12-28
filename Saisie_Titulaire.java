//Saisie_Titulaire.java

import com.ms.wfc.app.*;
import com.ms.wfc.core.*;
import com.ms.wfc.ui.*;
import com.ms.wfc.data.*;
import com.ms.wfc.data.ui.*;

public class Saisie_Titulaire extends Form
{
   public void btnAdd_Click(Object sender, Event evt)
    {
        try
        {
            dataSource1.getRecordset().cancelUpdate();
            dataSource1.getRecordset().addNew();
            btnAdd.setEnabled( false );
			btnUpdate.setEnabled(true );
			editNom.setText("");
			editPrenom.setText("");
			sexe.setText("");
			etat.setText("");
			editAdresse.setText("");
			editPhone_1.setText("");
			editNif.setText("");
			editNo_assur.setText("");
			editRef_comp.setText("");
			editEmployeur.setText("");
			n1.setText("");p1.setText("");
			            
        }
        catch (Exception e)
        {
            handleADOException(e);
        }
    }


    public void btnUpdate_Click(Object sender, Event evt)
    {    int resul;
		
		DataSource rech = new DataSource();
		DataSource re = new DataSource();
	try
	{
		DataSource rec = new DataSource();
		rech.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		rech.setCommandText("select * from Compagnie where Nom = '"+editRef_comp.getText()+"'");	
		rech.begin();
		
			
		re.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		re.setCommandText("select * from Titulaire where Nif = '"+editNif.getText()+"'");	
		re.begin();
		
		
		
		if(editNom.getText().equals(""))
		{MessageBox.show("Veuillez Entrer le Nom du Titulaire S.V.P !  ex: Pierre ","Champ Vide",MessageBox.ICONERROR);
		}
		else 
		  if(editPrenom.getText().equals(""))
		  {MessageBox.show("Veuillez Entrer le Prénom du Titulaire S.V.P !  ex: Merlin ","Champ Vide",MessageBox.ICONERROR);
		  }
		else
			if(sexe.getText().equals(""))
				{MessageBox.show("Veuillez Choisir le sexe du Titulaire S.V.P ! M  ou  F ","Champ Vide",MessageBox.ICONERROR);
		     }
		else
			if(etat.getText().equals(""))
				{MessageBox.show("Veuillez Choisir le Statut Matrimonial du Titulaire S.V.P ! ","Champ Vide",MessageBox.ICONERROR);
		     }
		else
			if(editAdresse.getText().equals(""))
			  {MessageBox.show("Veuillez Inscrire l'Adresse  du Titulaire S.V.P ! ","Champ Vide",MessageBox.ICONERROR);
			  }
		else
			if(editPhone_1.getText().equals(""))
			  {MessageBox.show("Veuillez Inscrire, au moins, Un Numero de Téléphone du Titulaire S.V.P ! ","Champ Vide",MessageBox.ICONERROR);
			  }
		else
			if(editNif.getText().equals(""))
			  {MessageBox.show("Veuillez Entrer le NIF du Titulaire S.V.P ! ","Champ Vide",MessageBox.ICONERROR);
			  }
		else
			if(editRef_comp.getText().equals(""))
			  {MessageBox.show("Veuillez Entrer le Nom de la Compagnie d'Assurance du Titulaire S.V.P ! ","Champ Vide",MessageBox.ICONERROR);
			  }
		else
			if(editEmployeur.getText().equals(""))
			  {MessageBox.show("Veuillez Entrer le Nom de l'Entreprise pour Laquelle  le Titulaire Travaille S.V.P ! ","Champ Vide",MessageBox.ICONERROR);
			  }
		  else
			if(String.valueOf(re.getRecordset().getRecordCount()).equals("1"))
			   {   DataBinder verifier = new DataBinder();
				    verifier.setDataSource(re);
				    verifier.setBindings(new DataBinding[]{
							    new DataBinding(n1,"text","Nom"),
							    new DataBinding(p1,"text","Prenom"),
		
									   });
										
				MessageBox.show("Désolé le NIF < "+editNif.getText()+" > est déjà Inscrit, Il Correspond au Titulaire < "+n1.getText()+"  "+p1.getText()+" >. Vérifiez le NIF S.V.P","Opération Illégale",MessageBox.ICONSTOP);
			   }
		  else
		if(String.valueOf(rech.getRecordset().getRecordCount()).equals("0"))
			   {resul=MessageBox.show("Desolé la Compagnie << "+editRef_comp.getText()+" >> n'est pas Inscrite !, Voulez-vous l'Inscrire Maintenant ?", "Opération  Interrompue",MessageBox.YESNO);
				if(resul==MessageBox.IDYES)
				{Application.run(new Saisie_Compagnie());
				 rech.close();
				}
				else
				editRef_comp.setText("");
				}
		
	    else
	     {
          this.setCursor( Cursor.WAIT );
            dataBinder1.commitChanges();
            dataSource1.getRecordset().update();
			MessageBox.show("Félicitations ! L'inscription du Titulaire <<"+editNom.getText()+"  "+editPrenom.getText()+" >> a Réussi ", " Confirmation",MessageBox.ICONINFORMATION);

            if( m_bAddNew )
            {
                dataSource1.requery();
                
                dataSource1.getRecordset().moveLast();
            }
			 
			btnAdd.setEnabled( true );
			btnUpdate.setEnabled(false );
						
		   }
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
    
	
    public Saisie_Titulaire()
    {
        // Required for Visual J++ Form Designer support
        initForm();
        
        this.show();
        this.update();
		   dataSource1.getRecordset().cancelUpdate();
           dataSource1.getRecordset().addNew();
            btnAdd.setEnabled( false );
			btnUpdate.setEnabled(true );
			editNom.setText("");
			editPrenom.setText("");
			sexe.setText("");
			etat.setText("");
			editAdresse.setText("");
			editPhone_1.setText("");
			editNif.setText("");
			editNo_assur.setText("");
			editRef_comp.setText("");
			editEmployeur.setText("");
			n1.setText("");p1.setText("");

        //TODO: Add any constructor code after initForm call
    }    

    public void formClose(Event e)
    {
        Application.exit();
    }    

    
    void handleADOException(Exception e)
    {
        e.printStackTrace();
        MessageBox.show( e.toString(), "Saisie_Titulaire" );
    }

	/**
	 * NOTE: The following code is required by the Visual J++ form
	 * designer.  It can be modified using the form editor.  Do not
	 * modify it using the code editor.
	 */
	Container components = new Container();
	GroupBox groupBox2 = new GroupBox();
	ComboBox etat = new ComboBox();
	ComboBox sexe = new ComboBox();
	GroupBox groupBox1 = new GroupBox();
	Label label1 = new Label();
	Button btnClose = new Button();
	Button btnUpdate = new Button();
	Button btnAdd = new Button();
	Panel panel1 = new Panel();
	Edit editEmployeur = new Edit();
	Label labelEmployeur = new Label();
	Edit editRef_comp = new Edit();
	Label labelRef_comp = new Label();
	Edit editNo_assur = new Edit();
	Label labelNo_assur = new Label();
	Edit editNif = new Edit();
	Label labelNif = new Label();
	Edit editPhone_2 = new Edit();
	Label labelPhone_2 = new Label();
	Edit editPhone_1 = new Edit();
	Label labelPhone_1 = new Label();
	Edit editAdresse = new Edit();
	Label labelAdresse = new Label();
	Label labelEtat_mat = new Label();
	Label labelNom = new Label();
	Edit editNom = new Edit();
	Label labelPrenom = new Label();
	Edit editPrenom = new Edit();
	Label labelSexe = new Label();
	DataBinder dataBinder1 = new DataBinder(components);
	DataSource dataSource1 = new DataSource(components);
	PictureBox pictureBox6 = new PictureBox();
	PictureBox pictureBox3 = new PictureBox();
	Panel panel3 = new Panel();
	PictureBox pictureBox1 = new PictureBox();
	PictureBox pictureBox2 = new PictureBox();
	Edit n1 = new Edit();
	Edit p1 = new Edit();

	private void initForm()
	{
		// REMARQUE : cette feuille stocke des informations sur les ressources
		// dans un fichier externe. Ne modifiez le paramètre de chaîne d'aucun
		// appel de fonction resources.getObject(). Par exemple,
		// ne modifiez pas "foo1_location" dans la ligne de code
		// suivante, même si le nom de l'objet Foo change : 
		//	 foo1.setLocation((Point)resources.getObject("foo1_location"));

		IResourceManager resources = new ResourceManager(this, "Saisie_Titulaire");
		this.setLocation(new Point(7, 7));
		this.setText("Inscription d\'un Titulaire Assuré ");
		this.setAutoScaleBaseSize(new Point(5, 13));
		this.setAutoScroll(true);
		this.setBorderStyle(FormBorderStyle.NONE);
		this.setClientSize(new Point(600, 452));
		this.setMaximizeBox(false);
		this.setStartPosition(FormStartPosition.CENTER_SCREEN);

		groupBox2.setLocation(new Point(307, 143));
		groupBox2.setSize(new Point(264, 192));
		groupBox2.setTabIndex(29);
		groupBox2.setTabStop(false);
		groupBox2.setText("");

		etat.setLocation(new Point(130, 243));
		etat.setSize(new Point(80, 21));
		etat.setTabIndex(3);
		etat.setText(" ");
		etat.setItemHeight(13);
		etat.setMaxLength(50);
		etat.setItems(new Object[] {
					  "Célibataire", 
					  "Marié", 
					  "Divorcé", 
					  "Veuf", 
					  "Union libre"});

		sexe.setLocation(new Point(130, 215));
		sexe.setSize(new Point(80, 21));
		sexe.setTabIndex(2);
		sexe.setText(" ");
		sexe.setItemHeight(13);
		sexe.setMaxLength(2);
		sexe.setItems(new Object[] {
					  "M", 
					  "F"});

		groupBox1.setLocation(new Point(16, 143));
		groupBox1.setSize(new Point(272, 192));
		groupBox1.setTabIndex(28);
		groupBox1.setTabStop(false);
		groupBox1.setText("");

		label1.setBackColor(new Color(255, 255, 192));
		label1.setFont(new Font("Verdana", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		label1.setForeColor(Color.AQUA);
		label1.setLocation(new Point(100, 7));
		label1.setSize(new Point(384, 23));
		label1.setTabIndex(27);
		label1.setTabStop(false);
		label1.setText("Inscription d\'un Titulaire  Assuré");
		label1.setBorderStyle(BorderStyle.FIXED_3D);
		label1.setTextAlign(HorizontalAlignment.CENTER);

		btnClose.setLocation(new Point(460, 8));
		btnClose.setSize(new Point(70, 30));
		btnClose.setTabIndex(2);
		btnClose.setText("Fermer");
		btnClose.addOnClick(new EventHandler(this.btnClose_Click));

		btnUpdate.setLocation(new Point(248, 8));
		btnUpdate.setSize(new Point(70, 30));
		btnUpdate.setTabIndex(1);
		btnUpdate.setText("Enregistrer");
		btnUpdate.addOnClick(new EventHandler(this.btnUpdate_Click));

		btnAdd.setLocation(new Point(12, 8));
		btnAdd.setSize(new Point(70, 30));
		btnAdd.setTabIndex(0);
		btnAdd.setText("Nouveau");
		btnAdd.addOnClick(new EventHandler(this.btnAdd_Click));

		panel1.setBackColor(new Color(0, 192, 192));
		panel1.setDock(ControlDock.BOTTOM);
		panel1.setLocation(new Point(0, 402));
		panel1.setSize(new Point(600, 50));
		panel1.setTabIndex(26);
		panel1.setText("");
		panel1.setBorderStyle(BorderStyle.FIXED_3D);

		editEmployeur.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editEmployeur.setLocation(new Point(426, 302));
		editEmployeur.setSize(new Point(136, 20));
		editEmployeur.setTabIndex(11);
		editEmployeur.setText(" ");
		editEmployeur.setCharacterCasing(CharacterCasing.UPPER);
		editEmployeur.setMaxLength(50);

		labelEmployeur.setBackColor(Color.CONTROL);
		labelEmployeur.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelEmployeur.setLocation(new Point(314, 303));
		labelEmployeur.setSize(new Point(105, 23));
		labelEmployeur.setTabIndex(24);
		labelEmployeur.setTabStop(false);
		labelEmployeur.setText("Employeur");
		labelEmployeur.setBorderStyle(BorderStyle.FIXED_3D);

		editRef_comp.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRef_comp.setLocation(new Point(426, 273));
		editRef_comp.setSize(new Point(136, 20));
		editRef_comp.setTabIndex(9);
		editRef_comp.setText(" ");
		editRef_comp.setCharacterCasing(CharacterCasing.UPPER);
		editRef_comp.setMaxLength(50);

		labelRef_comp.setBackColor(Color.CONTROL);
		labelRef_comp.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelRef_comp.setLocation(new Point(314, 274));
		labelRef_comp.setSize(new Point(105, 23));
		labelRef_comp.setTabIndex(23);
		labelRef_comp.setTabStop(false);
		labelRef_comp.setText("Compagnie d\'Ass");
		labelRef_comp.setBorderStyle(BorderStyle.FIXED_3D);

		editNo_assur.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNo_assur.setLocation(new Point(426, 244));
		editNo_assur.setSize(new Point(120, 20));
		editNo_assur.setTabIndex(8);
		editNo_assur.setText(" ");
		editNo_assur.setCharacterCasing(CharacterCasing.UPPER);
		editNo_assur.setMaxLength(30);

		labelNo_assur.setBackColor(Color.CONTROL);
		labelNo_assur.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNo_assur.setLocation(new Point(314, 245));
		labelNo_assur.setSize(new Point(105, 23));
		labelNo_assur.setTabIndex(22);
		labelNo_assur.setTabStop(false);
		labelNo_assur.setText("No Police");
		labelNo_assur.setBorderStyle(BorderStyle.FIXED_3D);

		editNif.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNif.setFont(new Font("MS Serif", 10.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		editNif.setForeColor(Color.AQUA);
		editNif.setLocation(new Point(426, 216));
		editNif.setSize(new Point(120, 23));
		editNif.setTabIndex(7);
		editNif.setText(" ");
		editNif.setAcceptsReturn(false);
		editNif.setAcceptsTab(true);
		editNif.setAutoSize(false);
		editNif.setMaxLength(13);
		editNif.setWordWrap(false);

		labelNif.setBackColor(Color.CONTROL);
		labelNif.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNif.setLocation(new Point(314, 216));
		labelNif.setSize(new Point(105, 23));
		labelNif.setTabIndex(21);
		labelNif.setTabStop(false);
		labelNif.setText("NIF");
		labelNif.setBorderStyle(BorderStyle.FIXED_3D);

		editPhone_2.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editPhone_2.setLocation(new Point(425, 189));
		editPhone_2.setSize(new Point(120, 20));
		editPhone_2.setTabIndex(6);
		editPhone_2.setText(" ");
		editPhone_2.setMaxLength(15);

		labelPhone_2.setBackColor(Color.CONTROL);
		labelPhone_2.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelPhone_2.setLocation(new Point(314, 188));
		labelPhone_2.setSize(new Point(105, 23));
		labelPhone_2.setTabIndex(20);
		labelPhone_2.setTabStop(false);
		labelPhone_2.setText("Phone_2");
		labelPhone_2.setBorderStyle(BorderStyle.FIXED_3D);

		editPhone_1.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editPhone_1.setLocation(new Point(424, 161));
		editPhone_1.setSize(new Point(120, 20));
		editPhone_1.setTabIndex(5);
		editPhone_1.setText(" ");
		editPhone_1.setMaxLength(15);

		labelPhone_1.setBackColor(Color.CONTROL);
		labelPhone_1.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelPhone_1.setLocation(new Point(314, 161));
		labelPhone_1.setSize(new Point(105, 23));
		labelPhone_1.setTabIndex(19);
		labelPhone_1.setTabStop(false);
		labelPhone_1.setText("Phone_1");
		labelPhone_1.setBorderStyle(BorderStyle.FIXED_3D);

		editAdresse.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editAdresse.setLocation(new Point(129, 271));
		editAdresse.setSize(new Point(152, 20));
		editAdresse.setTabIndex(4);
		editAdresse.setText(" ");
		editAdresse.setMaxLength(50);

		labelAdresse.setBackColor(Color.CONTROL);
		labelAdresse.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelAdresse.setLocation(new Point(20, 271));
		labelAdresse.setSize(new Point(105, 23));
		labelAdresse.setTabIndex(16);
		labelAdresse.setTabStop(false);
		labelAdresse.setText("Adresse");
		labelAdresse.setBorderStyle(BorderStyle.FIXED_3D);

		labelEtat_mat.setBackColor(Color.CONTROL);
		labelEtat_mat.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelEtat_mat.setLocation(new Point(20, 243));
		labelEtat_mat.setSize(new Point(105, 23));
		labelEtat_mat.setTabIndex(15);
		labelEtat_mat.setTabStop(false);
		labelEtat_mat.setText("Etat Matrimonial");
		labelEtat_mat.setBorderStyle(BorderStyle.FIXED_3D);

		labelNom.setBackColor(Color.CONTROL);
		labelNom.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNom.setLocation(new Point(20, 159));
		labelNom.setSize(new Point(105, 23));
		labelNom.setTabIndex(10);
		labelNom.setTabStop(false);
		labelNom.setText("Nom");
		labelNom.setBorderStyle(BorderStyle.FIXED_3D);

		editNom.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNom.setLocation(new Point(130, 160));
		editNom.setSize(new Point(152, 20));
		editNom.setTabIndex(0);
		editNom.setText(" ");
		editNom.setMaxLength(50);

		labelPrenom.setBackColor(Color.CONTROL);
		labelPrenom.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelPrenom.setLocation(new Point(20, 186));
		labelPrenom.setSize(new Point(105, 23));
		labelPrenom.setTabIndex(12);
		labelPrenom.setTabStop(false);
		labelPrenom.setText("Prénom");
		labelPrenom.setBorderStyle(BorderStyle.FIXED_3D);

		editPrenom.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editPrenom.setLocation(new Point(130, 188));
		editPrenom.setSize(new Point(152, 20));
		editPrenom.setTabIndex(1);
		editPrenom.setText(" ");
		editPrenom.setMaxLength(50);

		labelSexe.setBackColor(Color.CONTROL);
		labelSexe.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelSexe.setLocation(new Point(20, 215));
		labelSexe.setSize(new Point(105, 23));
		labelSexe.setTabIndex(14);
		labelSexe.setTabStop(false);
		labelSexe.setText("Sexe");
		labelSexe.setBorderStyle(BorderStyle.FIXED_3D);

		dataSource1.setConnectionString("PROVIDER=MSDASQL;dsn=HAH;uid=genial;pwd=genial;DBQ=C:\\ASSURE.MDB");
		dataSource1.setCommandText("select Nif, No_assur, Ref_comp, Nom, Prenom, Sexe, Adresse, Phone_1, Phone_2, Etat_mat, Employeur from Titulaire ORDER by Nom");
		dataSource1.setSort(null);
		dataSource1.setStayInSync(true);
		dataSource1.setUserId(null);
		dataSource1.setPassword(null);
		/* @designTimeOnly dataSource1.setLocation(new Point(384, 40)); */

		dataBinder1.setDataSource(dataSource1);
		dataBinder1.setDataMember("");
		dataBinder1.setBindings(new DataBinding[] {
								new DataBinding(editNom, "Text", "Nom", null), 
								new DataBinding(editNif, "Text", "Nif", null), 
								new DataBinding(editNo_assur, "Text", "No_assur", null), 
								new DataBinding(editRef_comp, "Text", "Ref_comp", null), 
								new DataBinding(editPrenom, "Text", "Prenom", null), 
								new DataBinding(sexe, "Text", "Sexe", null), 
								new DataBinding(editAdresse, "Text", "Adresse", null), 
								new DataBinding(editPhone_1, "Text", "Phone_1", null), 
								new DataBinding(editPhone_2, "Text", "Phone_2", null), 
								new DataBinding(editEmployeur, "Text", "Employeur", null)});
		/* @designTimeOnly dataBinder1.setLocation(new Point(488, 40)); */

		pictureBox6.setLocation(new Point(8, 52));
		pictureBox6.setSize(new Point(88, 80));
		pictureBox6.setTabIndex(18);
		pictureBox6.setTabStop(false);
		pictureBox6.setText("pictureBox2");
		pictureBox6.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox6.setImage((Bitmap)resources.getObject("pictureBox6_image"));
		pictureBox6.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox3.setLocation(new Point(290, 149));
		pictureBox3.setSize(new Point(16, 186));
		pictureBox3.setTabIndex(13);
		pictureBox3.setTabStop(false);
		pictureBox3.setText("pictureBox2");
		pictureBox3.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox3.setImage((Bitmap)resources.getObject("pictureBox3_image"));
		pictureBox3.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		panel3.setLocation(new Point(8, 135));
		panel3.setSize(new Point(576, 224));
		panel3.setTabIndex(30);
		panel3.setText("panel3");
		panel3.setBorderStyle(BorderStyle.FIXED_3D);

		pictureBox1.setLocation(new Point(31, 39));
		pictureBox1.setSize(new Point(88, 80));
		pictureBox1.setTabIndex(25);
		pictureBox1.setTabStop(false);
		pictureBox1.setText("pictureBox1");
		pictureBox1.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox1.setImage((Bitmap)resources.getObject("pictureBox1_image"));
		pictureBox1.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox2.setLocation(new Point(8, 3));
		pictureBox2.setSize(new Point(560, 32));
		pictureBox2.setTabIndex(17);
		pictureBox2.setTabStop(false);
		pictureBox2.setText("pictureBox2");
		pictureBox2.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox2.setImage((Bitmap)resources.getObject("pictureBox2_image"));
		pictureBox2.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		n1.setLocation(new Point(168, 96));
		n1.setSize(new Point(32, 20));
		n1.setTabIndex(34);
		n1.setText("");
		n1.setVisible(false);

		p1.setLocation(new Point(216, 96));
		p1.setSize(new Point(32, 20));
		p1.setTabIndex(33);
		p1.setText("");
		p1.setVisible(false);

		this.setNewControls(new Control[] {
							etat, 
							p1, 
							n1, 
							pictureBox1, 
							pictureBox6, 
							pictureBox3, 
							sexe, 
							label1, 
							panel1, 
							editEmployeur, 
							labelEmployeur, 
							editRef_comp, 
							labelRef_comp, 
							editNo_assur, 
							labelNo_assur, 
							editNif, 
							labelNif, 
							editPhone_2, 
							labelPhone_2, 
							editPhone_1, 
							labelPhone_1, 
							editAdresse, 
							labelAdresse, 
							labelEtat_mat, 
							labelSexe, 
							editPrenom, 
							labelPrenom, 
							editNom, 
							labelNom, 
							groupBox1, 
							groupBox2, 
							panel3, 
							pictureBox2});
		panel1.setNewControls(new Control[] {
							  btnClose, 
							  btnUpdate, 
							  btnAdd});

		dataBinder1.begin();
		dataSource1.begin();
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
        Application.run( new Saisie_Titulaire() );
    }
}
