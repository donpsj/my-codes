//Services.java

import com.ms.wfc.app.*;
import com.ms.wfc.core.*;
import com.ms.wfc.ui.*;
import com.ms.wfc.data.*;
import com.ms.wfc.data.ui.*;

public class Services extends Form
{  boolean type2=false;
   boolean r1=false;
   boolean r2=false;
    public String vdate = new String();
	public String vdate2 = new String();
    
    public void btnAdd_Click(Object sender, Event evt)
    {
        try
        {   hide();
			Application.run(new Services());
            
			/*dataSource1.getRecordset().cancelUpdate();
            dataSource1.getRecordset().addNew();
            m_bAddNew = true;
             btnAdd.setEnabled( false );
			 btnUpdate.setEnabled( true );
			 jour2.setEnabled(false);
		     mois2.setEnabled(false);
		     an2.setEnabled(false);
			 jour.setText("");
		     mois.setText("");
		     an.setText("");
			 editNom.setText("");
			 editNDos.setText("0");
			 editMedecin1.setText("");
			 editRef_Inst.setText("");
			 vdate="";
			 vdate2="";
			 radio1.getChecked();*/
		 
		}
           
        catch (Exception e)
        {
            handleADOException(e);
        }
		
	}

     

	 
	private void btnUpdate_click(Object source, Event e)
	{
		DataSource rech = new DataSource();
		rech.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		rech.setCommandText("select * from Institution where Nom = '"+editRef_Inst.getText()+"'");			  			
        rech.begin();
		
		try{    
			 int ndos = (Integer.valueOf(editNDos.getText()).intValue());
			 vdate = jour.getSelectedItem()+ "/" + mois.getSelectedItem()+ "/" +"20"+""+an.getText();
		     editDate1.setText(String.valueOf(vdate));
			 vdate2 = jour2.getSelectedItem()+ "/" + mois2.getSelectedItem()+ "/" +"20"+""+an2.getText();
			 editDate2.setText(String.valueOf(vdate2));
			 				
			if(jour.getText().equals("")||mois.getText().equals("")||an.getText().equals(""))
			{MessageBox.show("Entrez la Date sous la Forme :'jj  MM  AA '  S.V.P","Champ Vide",MessageBox.ICONERROR);
			}
			else
			if(jour.getText().equals("31")&&(mois.getText().equals("02")||mois.getText().equals("04")||mois.getText().equals("06")||mois.getText().equals("09")||mois.getText().equals("11")))
					{ MessageBox.show("Ce mois ne Porte pas 31 Jours","Données Incompatibles",MessageBox.ICONERROR);
					}
			else
				if(mois.getText().equals("02")&&(jour.getText().equals("30")||jour2.getText().equals("31")))
				 {  MessageBox.show("Le Mois de Février Porte  29 Jours au Maximum","Données Incompatibles",MessageBox.ICONERROR);
				 }	
			else
				if(editNom.getText().equals(""))
				 {  MessageBox.show("Veuillez Entrer Le Nom Complet du Bénéficiaire ","Champ Vide",MessageBox.ICONERROR);
				 }
			else
			    if(editMedecin1.getText().equals(""))
				 {  MessageBox.show("Veuillez Entrer au Moins Le Nom d'un Médecin ","Champ Vide",MessageBox.ICONERROR);
				 }
		 	else
			   if(editRef_Inst.getText().equals(""))
				 {  MessageBox.show("Veuillez Entrer le Nom de l'Institution ","Champ Vide",MessageBox.ICONERROR);
				 }
			else
				if(String.valueOf(rech.getRecordset().getRecordCount()).equals("0"))
			   {MessageBox.show("Désolé l'Institution '"+editRef_Inst.getText()+"'n'existe pas. Vérifiez le Nom à Nouveau ou, Inscrivez la D'abord !","Opération Illégale",MessageBox.ICONSTOP);
				}
			 else
			 { if(type2==true)
				  {  if(jour2.getText().equals("")||mois2.getText().equals("")||an2.getText().equals(""))
			        {MessageBox.show("Entrez la Date de Sortie  sous la Forme :'jj  MM  AA '  S.V.P","Champ Vide",MessageBox.ICONERROR);
			         }
			       else
			       if(jour2.getText().equals("31")&&(mois2.getText().equals("02")||mois2.getText().equals("04")||mois2.getText().equals("06")||mois2.getText().equals("09")||mois2.getText().equals("11")))
					{ MessageBox.show("Dans la Date de Sortie, le mois ne Porte pas 31 Jours","Données Incompatibles",MessageBox.ICONERROR);
					}
			        else
				     if(mois2.getText().equals("02")&&(jour2.getText().equals("30")||jour2.getText().equals("31")))
				     {  MessageBox.show("Dans la Date de Sortie, Le Mois de Février Porte  29 Jours au Maximum","Données Incompatibles",MessageBox.ICONERROR);
				      }	
				    else
						
				      if(jour.getText().compareTo(jour2.getText())>0 && mois.getText().compareTo(mois2.getText())>0 && an.getText().compareTo(an2.getText())>=0)
			           {   MessageBox.show("La Date de Sortie ne peut être Inférieure à la Date d'Entrée ","Champ Vide",MessageBox.ICONERROR);
			            }
					  }
			          
			            if(type2==false)
						{ editDate2.setText(String.valueOf(vdate));
						}
			          					  
		              this.setCursor( Cursor.WAIT );
                      dataBinder1.commitChanges();
                      dataSource1.getRecordset().update();
			          MessageBox.show("Felicitations !! L'inscription du service est faite ", " Confirmation",MessageBox.ICONINFORMATION);
			 
                      if( m_bAddNew )
                       {
                       dataSource1.requery();
                       dataSource1.getRecordset().moveLast();
                         }
			             btnAdd.setEnabled( true );
			             btnUpdate.setEnabled( false );
			           }
			          }
					 
				 
		catch(NumberFormatException g){
		MessageBox.show("Attention, Le Numéro de Dossier Doit être un Nombre, sinon remplacez par (zéro) 0!", " Données Incompatibles",MessageBox.ICONERROR);
	     }	
			
        catch (Exception k)
        {
            handleADOException(k);
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
  
    public void formClose(Event e)
    {
        Application.exit();
    }    

   boolean    m_bAddNew;
    public void dispose()
    {
        super.dispose();
        components.dispose();
    }
    
     
	
	public Services()
    {
        // Required for Visual J++ Form Designer support
        initForm();
        		  
        this.show();
        this.update();
		dataSource1.getRecordset().cancelUpdate();
            dataSource1.getRecordset().addNew();
            m_bAddNew = true;
             btnAdd.setEnabled( false );
			 btnUpdate.setEnabled( true );
			 jour2.setEnabled(false);
		     mois2.setEnabled(false);
		     an2.setEnabled(false);
			 type2=false;
			 jour.setText("");
		     mois.setText("");
		     an.setText("");
			 editNom.setText("");
			 editNDos.setText("0");
			 editMedecin1.setText("");
			 editRef_Inst.setText("");
			 Type.setText("Consultation/Autres");
			 radio1.getChecked();
				 

        //TODO: Add any constructor code after initForm call
    }    

	 
    
    void handleADOException(Exception e)
    {
        e.printStackTrace();
        MessageBox.show( e.toString(), "Inscription" );
    }
	
 private void radio1_checkedChanged(Object source, Event e)
	{
		boolean r1=radio1.getChecked();
		if(r1==true)
		{jour2.setEnabled(false);
		 mois2.setEnabled(false);
		 an2.setEnabled(false);
		 Type.setText("Consultation/Autres");
		 type2=false;
		}
		else
			type2=true;
	}

	private void radio2_checkedChanged(Object source, Event e)
	{
		r2=radio2.getChecked();
        if(r2==true)
		{jour2.setEnabled(true);
		 mois2.setEnabled(true);
		 an2.setEnabled(true);
		 jour2.setText("");
		 mois2.setText("");
		 an2.setText("");
		 Type.setText("Hospitalisation");
		 type2=true;
		}
		else
			type2=false;
	}

	 

	private void Services_click(Object source, Event e)
	{
		
	}

	private void btnFermer_click(Object source, Event e)
	{
		hide();
	}

	/**
	 * NOTE: The following code is required by the Visual J++ form
	 * designer.  It can be modified using the form editor.  Do not
	 * modify it using the code editor.
	 */
	Container components = new Container();
	DataSource dataSource1 = new DataSource(components);
	DataBinder dataBinder1 = new DataBinder(components);
	Label labelNo = new Label();
	Edit editNo = new Edit();
	Label labelDate1 = new Label();
	Edit editDate1 = new Edit();
	Label labelType = new Label();
	PictureBox pictureBox4 = new PictureBox();
	Label labelNom = new Label();
	Edit editNom = new Edit();
	Label labelNDos = new Label();
	Edit editNDos = new Edit();
	Label labelMedecin1 = new Label();
	Edit editMedecin1 = new Edit();
	Label labelMedecin2 = new Label();
	Edit editMedecin2 = new Edit();
	Label labelDate2 = new Label();
	Edit editDate2 = new Edit();
	Label labelRef_Inst = new Label();
	Edit editRef_Inst = new Edit();
	Button btnAdd = new Button();
	Button btnFermer = new Button();
	Button btnUpdate = new Button();
	Panel panel1 = new Panel();
	GroupBox groupBox1 = new GroupBox();
	PictureBox pictureBox2 = new PictureBox();
	Label label1 = new Label();
	PictureBox pictureBox1 = new PictureBox();
	PictureBox pictureBox6 = new PictureBox();
	Label label3 = new Label();
	ComboBox jour = new ComboBox();
	ComboBox mois = new ComboBox();
	Edit an = new Edit();
	Edit an2 = new Edit();
	ComboBox jour2 = new ComboBox();
	ComboBox mois2 = new ComboBox();
	Label label2 = new Label();
	Edit Type = new Edit();
	RadioButton radio1 = new RadioButton();
	RadioButton radio2 = new RadioButton();

	private void initForm()
	{
		// REMARQUE : cette feuille stocke des informations sur les ressources
		// dans un fichier externe. Ne modifiez le paramètre de chaîne d'aucun
		// appel de fonction resources.getObject(). Par exemple,
		// ne modifiez pas "foo1_location" dans la ligne de code
		// suivante, même si le nom de l'objet Foo change : 
		//	 foo1.setLocation((Point)resources.getObject("foo1_location"));

		IResourceManager resources = new ResourceManager(this, "Services");
		this.setLocation(new Point(7, 7));
		this.setText("Inscription d\'un Service");
		this.setAutoScaleBaseSize(new Point(5, 13));
		this.setAutoScroll(true);
		this.setBorderStyle(FormBorderStyle.NONE);
		this.setClientSize(new Point(533, 401));
		this.setStartPosition(FormStartPosition.CENTER_SCREEN);
		this.addOnClick(new EventHandler(this.Services_click));

		dataSource1.setConnectionString("Provider=MSDASQL.1;Persist Security Info=False;Data Source=HAH;Initial Catalog=c:\\ASSURE");
		dataSource1.setCommandText("select Nserv, Date1, Type, Nom, NDos, Medecin1, Medecin2, Date2, Ref_Inst from Service");
		dataSource1.setSort(null);
		dataSource1.setStayInSync(true);
		dataSource1.setUserId(null);
		dataSource1.setPassword(null);
		/* @designTimeOnly dataSource1.setLocation(new Point(256, 153)); */

		labelNo.setBackColor(Color.CONTROL);
		labelNo.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNo.setLocation(new Point(10, 157));
		labelNo.setSize(new Point(56, 20));
		labelNo.setTabIndex(12);
		labelNo.setTabStop(false);
		labelNo.setText("No");
		labelNo.setBorderStyle(BorderStyle.FIXED_3D);

		editNo.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNo.setEnabled(false);
		editNo.setLocation(new Point(68, 157));
		editNo.setSize(new Point(105, 20));
		editNo.setTabIndex(13);
		editNo.setText("8");
		editNo.setReadOnly(true);

		labelDate1.setBackColor(Color.CONTROL);
		labelDate1.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelDate1.setLocation(new Point(17, 206));
		labelDate1.setSize(new Point(96, 20));
		labelDate1.setTabIndex(14);
		labelDate1.setTabStop(false);
		labelDate1.setText("Date");
		labelDate1.setBorderStyle(BorderStyle.FIXED_3D);

		editDate1.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editDate1.setLocation(new Point(19, 187));
		editDate1.setSize(new Point(40, 16));
		editDate1.setTabIndex(15);
		editDate1.setText("2004-03-02 00:00:00");
		editDate1.setVisible(false);
		editDate1.setMultiline(true);

		labelType.setBackColor(Color.CONTROL);
		labelType.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelType.setLocation(new Point(16, 240));
		labelType.setSize(new Point(96, 20));
		labelType.setTabIndex(17);
		labelType.setTabStop(false);
		labelType.setText("Type Service");
		labelType.setBorderStyle(BorderStyle.FIXED_3D);

		pictureBox4.setLocation(new Point(239, 183));
		pictureBox4.setSize(new Point(16, 136));
		pictureBox4.setTabIndex(16);
		pictureBox4.setTabStop(false);
		pictureBox4.setText("pictureBox2");
		pictureBox4.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox4.setImage((Bitmap)resources.getObject("pictureBox4_image"));
		pictureBox4.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		labelNom.setBackColor(Color.CONTROL);
		labelNom.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNom.setLocation(new Point(16, 270));
		labelNom.setSize(new Point(96, 20));
		labelNom.setTabIndex(18);
		labelNom.setTabStop(false);
		labelNom.setText("Nom et Prénom");
		labelNom.setBorderStyle(BorderStyle.FIXED_3D);

		editNom.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNom.setLocation(new Point(115, 270));
		editNom.setSize(new Point(127, 20));
		editNom.setTabIndex(4);
		editNom.setText("louis");
		editNom.setMaxLength(50);
		editNom.setMultiline(true);

		labelNDos.setBackColor(Color.CONTROL);
		labelNDos.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNDos.setLocation(new Point(16, 294));
		labelNDos.setSize(new Point(96, 20));
		labelNDos.setTabIndex(19);
		labelNDos.setTabStop(false);
		labelNDos.setText("No de Dossier");
		labelNDos.setBorderStyle(BorderStyle.FIXED_3D);

		editNDos.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNDos.setLocation(new Point(115, 294));
		editNDos.setSize(new Point(127, 20));
		editNDos.setTabIndex(5);
		editNDos.setText("0");
		editNDos.setMultiline(true);

		labelMedecin1.setBackColor(Color.CONTROL);
		labelMedecin1.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelMedecin1.setLocation(new Point(259, 205));
		labelMedecin1.setSize(new Point(80, 20));
		labelMedecin1.setTabIndex(23);
		labelMedecin1.setTabStop(false);
		labelMedecin1.setText("Medecin1");
		labelMedecin1.setBorderStyle(BorderStyle.FIXED_3D);

		editMedecin1.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editMedecin1.setLocation(new Point(343, 206));
		editMedecin1.setSize(new Point(161, 20));
		editMedecin1.setTabIndex(6);
		editMedecin1.setText("larsen");
		editMedecin1.setMaxLength(50);
		editMedecin1.setMultiline(true);

		labelMedecin2.setBackColor(Color.CONTROL);
		labelMedecin2.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelMedecin2.setLocation(new Point(259, 229));
		labelMedecin2.setSize(new Point(80, 20));
		labelMedecin2.setTabIndex(24);
		labelMedecin2.setTabStop(false);
		labelMedecin2.setText("Medecin2");
		labelMedecin2.setBorderStyle(BorderStyle.FIXED_3D);

		editMedecin2.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editMedecin2.setLocation(new Point(343, 230));
		editMedecin2.setSize(new Point(161, 20));
		editMedecin2.setTabIndex(7);
		editMedecin2.setText("");
		editMedecin2.setMaxLength(50);
		editMedecin2.setMultiline(true);

		labelDate2.setBackColor(Color.CONTROL);
		labelDate2.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelDate2.setLocation(new Point(259, 270));
		labelDate2.setSize(new Point(80, 20));
		labelDate2.setTabIndex(25);
		labelDate2.setTabStop(false);
		labelDate2.setText("Date Sortie");
		labelDate2.setBorderStyle(BorderStyle.FIXED_3D);

		editDate2.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editDate2.setLocation(new Point(298, 253));
		editDate2.setSize(new Point(47, 16));
		editDate2.setTabIndex(26);
		editDate2.setText("1900-01-01 00:00:00");
		editDate2.setVisible(false);
		editDate2.setMultiline(true);

		labelRef_Inst.setBackColor(Color.CONTROL);
		labelRef_Inst.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelRef_Inst.setLocation(new Point(259, 294));
		labelRef_Inst.setSize(new Point(80, 20));
		labelRef_Inst.setTabIndex(27);
		labelRef_Inst.setTabStop(false);
		labelRef_Inst.setText("Institution");
		labelRef_Inst.setBorderStyle(BorderStyle.FIXED_3D);

		editRef_Inst.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRef_Inst.setLocation(new Point(344, 294));
		editRef_Inst.setSize(new Point(161, 20));
		editRef_Inst.setTabIndex(11);
		editRef_Inst.setText("UNAH");
		editRef_Inst.setCharacterCasing(CharacterCasing.UPPER);
		editRef_Inst.setMaxLength(50);
		editRef_Inst.setMultiline(true);

		btnAdd.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		btnAdd.setLocation(new Point(6, 6));
		btnAdd.setSize(new Point(70, 30));
		btnAdd.setTabIndex(1);
		btnAdd.setText("&Nouveau");
		btnAdd.addOnClick(new EventHandler(this.btnAdd_Click));

		btnFermer.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		btnFermer.setLocation(new Point(440, 8));
		btnFermer.setSize(new Point(70, 30));
		btnFermer.setTabIndex(2);
		btnFermer.setText("&Fermer");
		btnFermer.addOnClick(new EventHandler(this.btnFermer_click));

		btnUpdate.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		btnUpdate.setLocation(new Point(232, 6));
		btnUpdate.setSize(new Point(70, 30));
		btnUpdate.setTabIndex(0);
		btnUpdate.setText("&Enregistrer");
		btnUpdate.addOnClick(new EventHandler(this.btnUpdate_click));

		panel1.setBackColor(new Color(0, 192, 192));
		panel1.setDock(ControlDock.BOTTOM);
		panel1.setLocation(new Point(0, 353));
		panel1.setSize(new Point(533, 48));
		panel1.setTabIndex(28);
		panel1.setText("");
		panel1.setBorderStyle(BorderStyle.FIXED_3D);

		groupBox1.setLocation(new Point(8, 176));
		groupBox1.setSize(new Point(504, 144));
		groupBox1.setTabIndex(29);
		groupBox1.setTabStop(false);
		groupBox1.setText("");

		pictureBox2.setLocation(new Point(120, 3));
		pictureBox2.setSize(new Point(392, 32));
		pictureBox2.setTabIndex(0);
		pictureBox2.setTabStop(false);
		pictureBox2.setText("pictureBox2");
		pictureBox2.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox2.setImage((Bitmap)resources.getObject("pictureBox2_image"));
		pictureBox2.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		label1.setBackColor(new Color(255, 255, 192));
		label1.setFont(new Font("Verdana", 14.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label1.setForeColor(Color.AQUA);
		label1.setLocation(new Point(188, 6));
		label1.setSize(new Point(248, 24));
		label1.setTabIndex(33);
		label1.setTabStop(false);
		label1.setText("Inscription d\'un Service");
		label1.setBorderStyle(BorderStyle.FIXED_3D);
		label1.setTextAlign(HorizontalAlignment.CENTER);

		pictureBox1.setLocation(new Point(29, 35));
		pictureBox1.setSize(new Point(88, 80));
		pictureBox1.setTabIndex(32);
		pictureBox1.setTabStop(false);
		pictureBox1.setText("pictureBox1");
		pictureBox1.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox1.setImage((Bitmap)resources.getObject("pictureBox1_image"));
		pictureBox1.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox6.setLocation(new Point(11, 47));
		pictureBox6.setSize(new Point(88, 80));
		pictureBox6.setTabIndex(20);
		pictureBox6.setTabStop(false);
		pictureBox6.setText("pictureBox2");
		pictureBox6.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox6.setImage((Bitmap)resources.getObject("pictureBox6_image"));
		pictureBox6.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		label3.setBackColor(Color.AQUA);
		label3.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, true, false, false, CharacterSet.DEFAULT, 0));
		label3.setForeColor(new Color(255, 255, 192));
		label3.setLocation(new Point(116, 189));
		label3.setSize(new Point(110, 16));
		label3.setTabIndex(22);
		label3.setTabStop(false);
		label3.setText(" JJ   /  MM  /  AA");
		label3.setBorderStyle(BorderStyle.FIXED_3D);

		jour.setLocation(new Point(116, 205));
		jour.setSize(new Point(40, 21));
		jour.setTabIndex(1);
		jour.setText("");
		jour.setItems(new Object[] {
					  "01", 
					  "02", 
					  "03", 
					  "04", 
					  "05", 
					  "06", 
					  "07", 
					  "08", 
					  "09", 
					  "10", 
					  "11", 
					  "12", 
					  "13", 
					  "14", 
					  "15", 
					  "16", 
					  "17", 
					  "18", 
					  "19", 
					  "20", 
					  "21", 
					  "22", 
					  "23", 
					  "24", 
					  "25", 
					  "26", 
					  "27", 
					  "28", 
					  "29", 
					  "30", 
					  "31"});

		mois.setLocation(new Point(157, 205));
		mois.setSize(new Point(40, 21));
		mois.setTabIndex(2);
		mois.setText("");
		mois.setItems(new Object[] {
					  "01", 
					  "02", 
					  "03", 
					  "04", 
					  "05", 
					  "06", 
					  "07", 
					  "08", 
					  "09", 
					  "10", 
					  "11", 
					  "12"});

		an.setLocation(new Point(198, 205));
		an.setSize(new Point(27, 20));
		an.setTabIndex(3);
		an.setText("");
		an.setMaxLength(2);

		an2.setLocation(new Point(426, 267));
		an2.setSize(new Point(27, 20));
		an2.setTabIndex(10);
		an2.setText("");
		an2.setMaxLength(2);

		jour2.setLocation(new Point(344, 267));
		jour2.setSize(new Point(40, 21));
		jour2.setTabIndex(8);
		jour2.setText("");
		jour2.setItems(new Object[] {
					   "01", 
					   "02", 
					   "03", 
					   "04", 
					   "05", 
					   "06", 
					   "07", 
					   "08", 
					   "09", 
					   "10", 
					   "11", 
					   "12", 
					   "13", 
					   "14", 
					   "15", 
					   "16", 
					   "17", 
					   "18", 
					   "19", 
					   "20", 
					   "21", 
					   "22", 
					   "23", 
					   "24", 
					   "25", 
					   "26", 
					   "27", 
					   "28", 
					   "29", 
					   "30", 
					   "31"});

		mois2.setLocation(new Point(385, 267));
		mois2.setSize(new Point(40, 21));
		mois2.setTabIndex(9);
		mois2.setText("");
		mois2.setItems(new Object[] {
					   "01", 
					   "02", 
					   "03", 
					   "04", 
					   "05", 
					   "06", 
					   "07", 
					   "08", 
					   "09", 
					   "10", 
					   "11", 
					   "12"});

		label2.setBackColor(Color.AQUA);
		label2.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, true, false, false, CharacterSet.DEFAULT, 0));
		label2.setForeColor(new Color(255, 255, 192));
		label2.setLocation(new Point(344, 251));
		label2.setSize(new Point(110, 16));
		label2.setTabIndex(21);
		label2.setTabStop(false);
		label2.setText(" JJ   /  MM  /  AA");
		label2.setBorderStyle(BorderStyle.FIXED_3D);

		Type.setLocation(new Point(55, 9));
		Type.setSize(new Point(24, 20));
		Type.setTabIndex(0);
		Type.setText("Consultation/Autres");
		Type.setVisible(false);
		Type.setMaxLength(50);

		dataBinder1.setDataSource(dataSource1);
		dataBinder1.setDataMember("");
		dataBinder1.setBindings(new DataBinding[] {
								new DataBinding(editDate1, "Text", "Date1", null), 
								new DataBinding(editNom, "Text", "Nom", null), 
								new DataBinding(editNDos, "Text", "NDos", null), 
								new DataBinding(editMedecin1, "Text", "Medecin1", null), 
								new DataBinding(editMedecin2, "Text", "Medecin2", null), 
								new DataBinding(editDate2, "Text", "Date2", null), 
								new DataBinding(editRef_Inst, "Text", "Ref_Inst", null), 
								new DataBinding(Type, "Text", "Type", null), 
								new DataBinding(editNo, "Text", "Nserv", null)});
		/* @designTimeOnly dataBinder1.setLocation(new Point(360, 160)); */

		radio1.setFont(new Font("MS Serif", 7.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		radio1.setLocation(new Point(105, 59));
		radio1.setSize(new Point(128, 16));
		radio1.setTabIndex(1);
		radio1.setTabStop(true);
		radio1.setText("Consultation/Autres");
		radio1.setChecked(true);
		radio1.addOnCheckedChanged(new EventHandler(this.radio1_checkedChanged));

		radio2.setFont(new Font("MS Serif", 7.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		radio2.setLocation(new Point(106, 76));
		radio2.setSize(new Point(104, 16));
		radio2.setTabIndex(2);
		radio2.setText("Hospitalisation");
		radio2.addOnCheckedChanged(new EventHandler(this.radio2_checkedChanged));

		this.setNewControls(new Control[] {
							pictureBox4, 
							an2, 
							jour2, 
							mois2, 
							label2, 
							an, 
							mois, 
							jour, 
							label3, 
							pictureBox1, 
							pictureBox6, 
							label1, 
							pictureBox2, 
							panel1, 
							labelNo, 
							editNo, 
							labelDate1, 
							editDate1, 
							labelType, 
							labelNom, 
							editNom, 
							labelNDos, 
							editNDos, 
							labelMedecin1, 
							editMedecin1, 
							labelMedecin2, 
							editMedecin2, 
							labelDate2, 
							editDate2, 
							labelRef_Inst, 
							editRef_Inst, 
							groupBox1});
		panel1.setNewControls(new Control[] {
							  btnAdd, 
							  btnFermer, 
							  btnUpdate});
		groupBox1.setNewControls(new Control[] {
								 radio2, 
								 radio1, 
								 Type});

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
        Application.run( new Services() );
    }
}
