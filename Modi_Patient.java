//Modi_Patient.java

import com.ms.wfc.app.*;
import com.ms.wfc.core.*;
import com.ms.wfc.ui.*;
import com.ms.wfc.data.*;
import com.ms.wfc.data.ui.*;

public class Modi_Patient extends Form
{   public String c1 = new String();
	public String c2 = new String();
	public String c3 = new String();

    public void dispose()
    {
        super.dispose();
        components.dispose();
    }
	
    public Modi_Patient()
    {
        // Required for Visual J++ Form Designer support
        initForm();
        
        this.show();
        this.update();
		edit1.setText("");
		edit2.setText("");
		edit3.setText("");
	    editNo_dossier.setText("0");

        //TODO: Add any constructor code after initForm call
    }    

    public void formClose(Event e)
    {
        Application.exit();
    }    

    
    void handleADOException(Exception e)
    {
        e.printStackTrace();
        MessageBox.show( e.toString(), "Modi_Patient" );
    }

	private void button1_click(Object source, Event e)
	{   
	
	try{	
		int ndo = (Integer.valueOf(editNo_dossier.getText()).intValue());
		if(editNo_dossier.getText().equals("0"))
		{MessageBox.show("Veuillez entrer le Numéro de dossier Du Patient S.V.P !","Champ de Recheche à Remplir");
		 }
		else
		{   DataSource fin = new DataSource();
		    fin.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		    fin.setCommandText("select * from Patient where No_dossier = "+editNo_dossier.getText()+"");			  			
            fin.begin();
			
			if(String.valueOf(fin.getRecordset().getRecordCount()).equals("0"))
			   {MessageBox.show("Desolé, Vous ne Pouvez Modifier les Données De ce Patient, Car le Numéro de Dossier  << "+editNo_dossier.getText()+" >>  n'Existe pas !", " Opération Illégale",MessageBox.ICONSTOP);
		     	 editNo_dossier.setText("0");
			    }
			else
			{     DataBinder display = new DataBinder();
				  display.setDataSource(fin);
				  display.setBindings(new DataBinding[]{
									  new DataBinding(editDate_inscri,"text","Date_inscri"),
							    new DataBinding(editNom,"text","Nom"),
							    new DataBinding(editPrenom,"text","Prenom"),
							    new DataBinding(editSexe,"text","sexe"),
							    new DataBinding(editAdresse,"text","Adresse"),
								new DataBinding(editPhone_1,"text","Phone_1"),
								new DataBinding(editPhone_2,"text","Phone_2"),
								new DataBinding(editRef_titul,"text","Ref_titul"),
								new DataBinding(nif2,"text","Ref_titul2"),
								 						
								 					   });
				  
				  
											
				               c1=editAdresse.getText();
							   c2=editPhone_1.getText();
				               c3=editPhone_2.getText();
							   
							   editNom.setVisible(true);
							   editPrenom.setVisible(true);
							   editSexe.setVisible(true);
							   editAdresse.setVisible(true);
							   editPhone_1.setVisible(true);
							   editPhone_2.setVisible(true);
							   editRef_titul.setVisible(true);
							   nif2.setVisible(true);
							   
							   labelNom.setVisible(true);
							   labelPrenom.setVisible(true);
							   labelSexe.setVisible(true);
							   labelAdresse.setVisible(true);
							   labelPhone_1.setVisible(true);
							   labelPhone_2.setVisible(true);
							   labelRef_titul.setVisible(true);
							   lnif2.setVisible(true);
							   
							   group2.setVisible(true);
							  							  							   
							   panel1.setVisible(true);
							   button2.setVisible(true);
							   button3.setVisible(true);
							   button3.setEnabled(true);
							   button1.setEnabled(false);
							   button5.setEnabled(false);
							   
							   group1.setVisible(true);
							   label6.setVisible(true);
							   
							   label1.setVisible(true);
							   label2.setVisible(true);
							   label3.setVisible(true);
							   
							   edit1.setVisible(true);
							   edit2.setVisible(true);
							   edit3.setVisible(true);
							   p1.setVisible(true);
							   			   				   
				
			}
			}
	    }
	catch(NumberFormatException ez)
             {  MessageBox.show("Attention! Le Numéro de Dossier Du Patient Doit être un Nombre ","Données Incompatibles",MessageBox.ICONERROR);

              }
	}
	
	

	private void button5_click(Object source, Event e)
	{
		editNo_dossier.setText("0");
		editNo_dossier.selectAll();
	}

	private void button4_click(Object source, Event e)
	{
		int choi;
		choi=MessageBox.show("Etes-vous sur de Vouloir Abandonner l'Opération?", "Abandon",MessageBox.YESNO);
	    if(choi==MessageBox.IDYES)   
		{ hide();
		}
	}

	private void button3_click(Object source, Event e)
	{         Connection pat = new Connection();
	           Recordset mpat = new Recordset();
		       int choix; 
		    
		
		      if(edit1.getText().equals(""))
			        {
				     edit1.setText(c1);
			         } 
			   if(edit2.getText().equals(""))
			   {edit2.setText(c2);
			   } 
			         
				if(edit3.getText().equals(""))
			      { edit3.setText(c3);   
				   } 
			try
			{		    choix=MessageBox.show("Etes-vous Sur de Vouloir Modifier ces Données?", "Moment de Décision",MessageBox.YESNO);
				          if(choix==MessageBox.IDYES)   
						  {  pat.setConnectionString("dsn=HAH;uid=genial;pwd=genial");
				             pat.open();
							 mpat.setActiveConnection(pat);
				             mpat.setSource("Update Patient set Adresse ='"+edit1.getText()+"' where No_dossier = "+editNo_dossier.getText()+"");
				             mpat.open();
							MessageBox.show("Bravo! Les modifications pour le Dossier No  << "+editNo_dossier.getText()+" >> sont effectuées ","Mises à jour Réussies"); 
						    button3.setEnabled(false);
							
						  }
						  
		    	}
			
			catch(com.ms.wfc.data.AdoException ex)
             {  MessageBox.show("Attention! Doublez les Aprostrophes dans les Champs qui les Contiennent puis, Essayez à Nouveau la Modification","Données Incompatibles",MessageBox.ICONERROR);

              }
				
		
	}

	private void button2_click(Object source, Event e)
	{              
		                        edit1.setText("");
		                        edit2.setText("");
		                        edit3.setText("");
								editNo_dossier.setText("0");
		
		                       labelNom.setVisible(false);
							   labelPrenom.setVisible(false);
							   labelSexe.setVisible(false);
							   labelAdresse.setVisible(false);
							   labelPhone_1.setVisible(false);
							   labelPhone_2.setVisible(false);
							   labelRef_titul.setVisible(false);
							   lnif2.setVisible(false);
							   group2.setVisible(false);
							   
							   editNom.setVisible(false);
							   editPrenom.setVisible(false);
							   editSexe.setVisible(false);
							   editAdresse.setVisible(false);
							   editPhone_1.setVisible(false);
							   editPhone_2.setVisible(false);
							   editRef_titul.setVisible(false);
							   nif2.setVisible(false);
							    
							   
							   panel1.setVisible(false);
							   button2.setVisible(false);
							   button3.setVisible(false);
							   
							   button1.setEnabled(true);
							   button5.setEnabled(true);
							   
							   group1.setVisible(false);
							   label6.setVisible(false);
							   
							   label1.setVisible(false);
							   label2.setVisible(false);
							   label3.setVisible(false);
							   
							   edit1.setVisible(false);
							   edit2.setVisible(false);
							   edit3.setVisible(false);
							  
							   p1.setVisible(false);
							   
	}

	private void pictureBox3_click(Object source, Event e)
	{
		
	}

	/**
	 * NOTE: The following code is required by the Visual J++ form
	 * designer.  It can be modified using the form editor.  Do not
	 * modify it using the code editor.
	 */
	Container components = new Container();
	DataSource dataSource1 = new DataSource(components);
	DataBinder dataBinder1 = new DataBinder(components);
	Label labelNo_dossier = new Label();
	Edit editNo_dossier = new Edit();
	Label labelDate_inscri = new Label();
	Edit editDate_inscri = new Edit();
	Label labelNom = new Label();
	Edit editNom = new Edit();
	Label labelPrenom = new Label();
	Edit editPrenom = new Edit();
	Label labelSexe = new Label();
	Edit editSexe = new Edit();
	Label labelAdresse = new Label();
	Edit editAdresse = new Edit();
	Label labelPhone_1 = new Label();
	Edit editPhone_1 = new Edit();
	Label labelPhone_2 = new Label();
	Edit editPhone_2 = new Edit();
	Label labelRef_titul = new Label();
	Edit editRef_titul = new Edit();
	Edit edit3 = new Edit();
	Label label3 = new Label();
	Edit edit2 = new Edit();
	Label label2 = new Label();
	Edit edit1 = new Edit();
	Label label1 = new Label();
	Button button1 = new Button();
	Button button2 = new Button();
	Button button3 = new Button();
	Button button4 = new Button();
	Button button5 = new Button();
	Panel panel1 = new Panel();
	Label label6 = new Label();
	GroupBox group1 = new GroupBox();
	GroupBox group2 = new GroupBox();
	Label label4 = new Label();
	GroupBox groupBox1 = new GroupBox();
	PictureBox pictureBox6 = new PictureBox();
	PictureBox pictureBox1 = new PictureBox();
	Label label5 = new Label();
	PictureBox pictureBox2 = new PictureBox();
	PictureBox p1 = new PictureBox();
	Edit nif2 = new Edit();
	Label lnif2 = new Label();

	private void initForm()
	{
		// REMARQUE : cette feuille stocke des informations sur les ressources
		// dans un fichier externe. Ne modifiez le paramètre de chaîne d'aucun
		// appel de fonction resources.getObject(). Par exemple,
		// ne modifiez pas "foo1_location" dans la ligne de code
		// suivante, même si le nom de l'objet Foo change : 
		//	 foo1.setLocation((Point)resources.getObject("foo1_location"));

		IResourceManager resources = new ResourceManager(this, "Modi_Patient");
		this.setLocation(new Point(7, 7));
		this.setText("Modification des Coordonnées d\'un Patient Assuré");
		this.setAutoScaleBaseSize(new Point(5, 13));
		this.setAutoScroll(true);
		this.setBorderStyle(FormBorderStyle.NONE);
		this.setClientSize(new Point(600, 424));
		this.setMaximizeBox(false);
		this.setStartPosition(FormStartPosition.CENTER_SCREEN);

		dataSource1.setConnectionString("PROVIDER=MSDASQL;dsn=HAH;uid=genial;pwd=genial;DBQ=C:\\ASSURE.MDB");
		dataSource1.setCommandText("select No_dossier, Date_inscri, Nom, Prenom, Sexe, Adresse, Phone_1, Phone_2, Ref_titul from Patient");
		dataSource1.setSort(null);
		dataSource1.setStayInSync(true);
		dataSource1.setUserId(null);
		dataSource1.setPassword(null);
		/* @designTimeOnly dataSource1.setLocation(new Point(328, 56)); */

		labelNo_dossier.setBackColor(new Color(255, 255, 192));
		labelNo_dossier.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNo_dossier.setLocation(new Point(40, 141));
		labelNo_dossier.setSize(new Point(232, 20));
		labelNo_dossier.setTabIndex(6);
		labelNo_dossier.setTabStop(false);
		labelNo_dossier.setText(" Entrez le Numéro de Dossier du Patient  ");
		labelNo_dossier.setBorderStyle(BorderStyle.FIXED_3D);

		editNo_dossier.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNo_dossier.setLocation(new Point(280, 141));
		editNo_dossier.setSize(new Point(80, 20));
		editNo_dossier.setTabIndex(7);
		editNo_dossier.setText("1220");
		editNo_dossier.setMultiline(true);

		labelDate_inscri.setBackColor(Color.CONTROL);
		labelDate_inscri.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelDate_inscri.setLocation(new Point(48, 185));
		labelDate_inscri.setSize(new Point(108, 20));
		labelDate_inscri.setTabIndex(8);
		labelDate_inscri.setTabStop(false);
		labelDate_inscri.setText("Date_inscri");
		labelDate_inscri.setVisible(false);
		labelDate_inscri.setBorderStyle(BorderStyle.FIXED_3D);

		editDate_inscri.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editDate_inscri.setEnabled(false);
		editDate_inscri.setLocation(new Point(161, 185));
		editDate_inscri.setSize(new Point(128, 20));
		editDate_inscri.setTabIndex(9);
		editDate_inscri.setText("Date_inscri");
		editDate_inscri.setVisible(false);
		editDate_inscri.setMultiline(true);

		labelNom.setBackColor(Color.CONTROL);
		labelNom.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNom.setLocation(new Point(48, 207));
		labelNom.setSize(new Point(108, 20));
		labelNom.setTabIndex(10);
		labelNom.setTabStop(false);
		labelNom.setText("Nom");
		labelNom.setVisible(false);
		labelNom.setBorderStyle(BorderStyle.FIXED_3D);

		editNom.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNom.setEnabled(false);
		editNom.setLocation(new Point(161, 207));
		editNom.setSize(new Point(128, 20));
		editNom.setTabIndex(11);
		editNom.setText("Prince");
		editNom.setVisible(false);
		editNom.setMaxLength(50);
		editNom.setMultiline(true);

		labelPrenom.setBackColor(Color.CONTROL);
		labelPrenom.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelPrenom.setLocation(new Point(48, 229));
		labelPrenom.setSize(new Point(108, 20));
		labelPrenom.setTabIndex(12);
		labelPrenom.setTabStop(false);
		labelPrenom.setText("Prenom");
		labelPrenom.setVisible(false);
		labelPrenom.setBorderStyle(BorderStyle.FIXED_3D);

		editPrenom.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editPrenom.setEnabled(false);
		editPrenom.setLocation(new Point(161, 229));
		editPrenom.setSize(new Point(128, 20));
		editPrenom.setTabIndex(13);
		editPrenom.setText("Marie Maude");
		editPrenom.setVisible(false);
		editPrenom.setMaxLength(50);
		editPrenom.setMultiline(true);

		labelSexe.setBackColor(Color.CONTROL);
		labelSexe.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelSexe.setLocation(new Point(48, 251));
		labelSexe.setSize(new Point(108, 20));
		labelSexe.setTabIndex(14);
		labelSexe.setTabStop(false);
		labelSexe.setText("Sexe");
		labelSexe.setVisible(false);
		labelSexe.setBorderStyle(BorderStyle.FIXED_3D);

		editSexe.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editSexe.setEnabled(false);
		editSexe.setLocation(new Point(161, 251));
		editSexe.setSize(new Point(128, 20));
		editSexe.setTabIndex(15);
		editSexe.setText("");
		editSexe.setVisible(false);
		editSexe.setMaxLength(1);
		editSexe.setMultiline(true);

		labelAdresse.setBackColor(Color.CONTROL);
		labelAdresse.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelAdresse.setLocation(new Point(48, 273));
		labelAdresse.setSize(new Point(108, 20));
		labelAdresse.setTabIndex(19);
		labelAdresse.setTabStop(false);
		labelAdresse.setText("Adresse");
		labelAdresse.setVisible(false);
		labelAdresse.setBorderStyle(BorderStyle.FIXED_3D);

		editAdresse.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editAdresse.setLocation(new Point(161, 273));
		editAdresse.setSize(new Point(128, 20));
		editAdresse.setTabIndex(20);
		editAdresse.setText("Delmas 65 # 12");
		editAdresse.setVisible(false);
		editAdresse.setMaxLength(50);
		editAdresse.setMultiline(true);
		editAdresse.setReadOnly(true);

		labelPhone_1.setBackColor(Color.CONTROL);
		labelPhone_1.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelPhone_1.setLocation(new Point(48, 295));
		labelPhone_1.setSize(new Point(108, 20));
		labelPhone_1.setTabIndex(22);
		labelPhone_1.setTabStop(false);
		labelPhone_1.setText("Phone_1");
		labelPhone_1.setVisible(false);
		labelPhone_1.setBorderStyle(BorderStyle.FIXED_3D);

		editPhone_1.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editPhone_1.setLocation(new Point(161, 295));
		editPhone_1.setSize(new Point(128, 20));
		editPhone_1.setTabIndex(23);
		editPhone_1.setText("249-4589");
		editPhone_1.setVisible(false);
		editPhone_1.setMaxLength(15);
		editPhone_1.setMultiline(true);
		editPhone_1.setReadOnly(true);

		labelPhone_2.setBackColor(Color.CONTROL);
		labelPhone_2.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelPhone_2.setLocation(new Point(48, 317));
		labelPhone_2.setSize(new Point(108, 20));
		labelPhone_2.setTabIndex(24);
		labelPhone_2.setTabStop(false);
		labelPhone_2.setText("Phone_2");
		labelPhone_2.setVisible(false);
		labelPhone_2.setBorderStyle(BorderStyle.FIXED_3D);

		editPhone_2.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editPhone_2.setLocation(new Point(161, 317));
		editPhone_2.setSize(new Point(128, 20));
		editPhone_2.setTabIndex(27);
		editPhone_2.setText("");
		editPhone_2.setVisible(false);
		editPhone_2.setMaxLength(15);
		editPhone_2.setMultiline(true);
		editPhone_2.setReadOnly(true);

		labelRef_titul.setBackColor(new Color(255, 255, 192));
		labelRef_titul.setFont(new Font("Verdana", 9.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelRef_titul.setForeColor(Color.AQUA);
		labelRef_titul.setLocation(new Point(48, 343));
		labelRef_titul.setSize(new Point(128, 22));
		labelRef_titul.setTabIndex(29);
		labelRef_titul.setTabStop(false);
		labelRef_titul.setText("NIF  1er Titulaire");
		labelRef_titul.setVisible(false);
		labelRef_titul.setBorderStyle(BorderStyle.FIXED_3D);

		editRef_titul.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRef_titul.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		editRef_titul.setForeColor(Color.AQUA);
		editRef_titul.setLocation(new Point(177, 344));
		editRef_titul.setSize(new Point(112, 20));
		editRef_titul.setTabIndex(30);
		editRef_titul.setText("003-066-059-2");
		editRef_titul.setVisible(false);
		editRef_titul.setMaxLength(13);
		editRef_titul.setMultiline(true);
		editRef_titul.setReadOnly(true);

		dataBinder1.setDataSource(dataSource1);
		dataBinder1.setDataMember("");
		dataBinder1.setBindings(new DataBinding[] {
								new DataBinding(editNo_dossier, "Text", "No_dossier", null), 
								new DataBinding(editNom, "Text", "Nom", null), 
								new DataBinding(editPrenom, "Text", "Prenom", null), 
								new DataBinding(editSexe, "Text", "Sexe", null), 
								new DataBinding(editAdresse, "Text", "Adresse", null), 
								new DataBinding(editPhone_1, "Text", "Phone_1", null), 
								new DataBinding(editPhone_2, "Text", "Phone_2", null), 
								new DataBinding(editRef_titul, "Text", "Ref_titul", null)});
		/* @designTimeOnly dataBinder1.setLocation(new Point(424, 56)); */

		edit3.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		edit3.setLocation(new Point(431, 337));
		edit3.setSize(new Point(136, 20));
		edit3.setTabIndex(3);
		edit3.setText("");
		edit3.setVisible(false);
		edit3.setMaxLength(15);

		label3.setBackColor(Color.CONTROL);
		label3.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label3.setLocation(new Point(327, 337));
		label3.setSize(new Point(100, 20));
		label3.setTabIndex(18);
		label3.setTabStop(false);
		label3.setText("Phone_2");
		label3.setVisible(false);
		label3.setBorderStyle(BorderStyle.FIXED_3D);

		edit2.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		edit2.setLocation(new Point(431, 313));
		edit2.setSize(new Point(136, 20));
		edit2.setTabIndex(2);
		edit2.setText("");
		edit2.setVisible(false);
		edit2.setMaxLength(15);

		label2.setBackColor(Color.CONTROL);
		label2.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label2.setLocation(new Point(327, 313));
		label2.setSize(new Point(100, 20));
		label2.setTabIndex(17);
		label2.setTabStop(false);
		label2.setText("Phone_1");
		label2.setVisible(false);
		label2.setBorderStyle(BorderStyle.FIXED_3D);

		edit1.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		edit1.setLocation(new Point(431, 289));
		edit1.setSize(new Point(136, 20));
		edit1.setTabIndex(1);
		edit1.setText("");
		edit1.setVisible(false);
		edit1.setMaxLength(50);

		label1.setBackColor(Color.CONTROL);
		label1.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label1.setLocation(new Point(327, 289));
		label1.setSize(new Point(100, 20));
		label1.setTabIndex(16);
		label1.setTabStop(false);
		label1.setText("Adresse");
		label1.setVisible(false);
		label1.setBorderStyle(BorderStyle.FIXED_3D);

		button1.setLocation(new Point(367, 142));
		button1.setSize(new Point(70, 20));
		button1.setTabIndex(31);
		button1.setText("&Rechercher");
		button1.addOnClick(new EventHandler(this.button1_click));

		button2.setLocation(new Point(312, 384));
		button2.setSize(new Point(60, 20));
		button2.setTabIndex(32);
		button2.setText("&Nouveau");
		button2.setVisible(false);
		button2.addOnClick(new EventHandler(this.button2_click));

		button3.setLocation(new Point(504, 384));
		button3.setSize(new Point(60, 20));
		button3.setTabIndex(33);
		button3.setText("&Modifier");
		button3.setVisible(false);
		button3.addOnClick(new EventHandler(this.button3_click));

		button4.setLocation(new Point(517, 142));
		button4.setSize(new Point(60, 20));
		button4.setTabIndex(34);
		button4.setText("&Fermer");
		button4.addOnClick(new EventHandler(this.button4_click));

		button5.setLocation(new Point(442, 142));
		button5.setSize(new Point(70, 20));
		button5.setTabIndex(35);
		button5.setText("&Annuler");
		button5.addOnClick(new EventHandler(this.button5_click));

		panel1.setBackColor(new Color(0, 192, 192));
		panel1.setLocation(new Point(303, 376));
		panel1.setSize(new Point(270, 40));
		panel1.setTabIndex(36);
		panel1.setText("panel1");
		panel1.setVisible(false);
		panel1.setBorderStyle(BorderStyle.FIXED_3D);

		label6.setBackColor(Color.AQUA);
		label6.setFont(new Font("MS Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label6.setForeColor(Color.WHITE);
		label6.setLocation(new Point(327, 248));
		label6.setSize(new Point(240, 16));
		label6.setTabIndex(37);
		label6.setTabStop(false);
		label6.setText("Veuillez entrer les nouvelles données ici S.V.P");
		label6.setVisible(false);
		label6.setBorderStyle(BorderStyle.FIXED_3D);

		group1.setLocation(new Point(319, 235));
		group1.setSize(new Point(256, 128));
		group1.setTabIndex(38);
		group1.setTabStop(false);
		group1.setText("");
		group1.setVisible(false);

		group2.setLocation(new Point(26, 172));
		group2.setSize(new Point(272, 240));
		group2.setTabIndex(42);
		group2.setTabStop(false);
		group2.setText("");
		group2.setVisible(false);

		label4.setLocation(new Point(24, 125));
		label4.setSize(new Point(560, 8));
		label4.setTabIndex(21);
		label4.setTabStop(false);
		label4.setText("");

		groupBox1.setBackColor(new Color(0, 192, 192));
		groupBox1.setLocation(new Point(24, 125));
		groupBox1.setSize(new Point(560, 48));
		groupBox1.setTabIndex(25);
		groupBox1.setTabStop(false);
		groupBox1.setText("");

		pictureBox6.setLocation(new Point(24, 50));
		pictureBox6.setSize(new Point(88, 80));
		pictureBox6.setTabIndex(4);
		pictureBox6.setTabStop(false);
		pictureBox6.setText("pictureBox2");
		pictureBox6.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox6.setImage((Bitmap)resources.getObject("pictureBox6_image"));
		pictureBox6.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox1.setLocation(new Point(42, 38));
		pictureBox1.setSize(new Point(88, 80));
		pictureBox1.setTabIndex(26);
		pictureBox1.setTabStop(false);
		pictureBox1.setText("pictureBox1");
		pictureBox1.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox1.setImage((Bitmap)resources.getObject("pictureBox1_image"));
		pictureBox1.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		label5.setBackColor(new Color(255, 255, 192));
		label5.setFont(new Font("Verdana", 14.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label5.setForeColor(Color.AQUA);
		label5.setLocation(new Point(83, 7));
		label5.setSize(new Point(440, 23));
		label5.setTabIndex(41);
		label5.setTabStop(false);
		label5.setText("Modification des Coordonnées d\'un Patient");
		label5.setBorderStyle(BorderStyle.FIXED_3D);

		pictureBox2.setLocation(new Point(24, 3));
		pictureBox2.setSize(new Point(560, 32));
		pictureBox2.setTabIndex(0);
		pictureBox2.setTabStop(false);
		pictureBox2.setText("pictureBox2");
		pictureBox2.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox2.setImage((Bitmap)resources.getObject("pictureBox2_image"));
		pictureBox2.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		p1.setLocation(new Point(301, 177));
		p1.setSize(new Point(16, 188));
		p1.setTabIndex(5);
		p1.setTabStop(false);
		p1.setText("pictureBox2");
		p1.setVisible(false);
		p1.setBorderStyle(BorderStyle.FIXED_3D);
		p1.setImage((Bitmap)resources.getObject("p1_image"));
		p1.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);
		p1.addOnClick(new EventHandler(this.pictureBox3_click));

		nif2.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		nif2.setForeColor(new Color(0, 0, 128));
		nif2.setLocation(new Point(151, 203));
		nif2.setSize(new Point(112, 20));
		nif2.setTabIndex(0);
		nif2.setText("45");
		nif2.setVisible(false);
		nif2.setReadOnly(true);

		lnif2.setBackColor(new Color(255, 255, 192));
		lnif2.setFont(new Font("Verdana", 9.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		lnif2.setForeColor(new Color(0, 0, 128));
		lnif2.setLocation(new Point(48, 375));
		lnif2.setSize(new Point(128, 22));
		lnif2.setTabIndex(28);
		lnif2.setTabStop(false);
		lnif2.setText("NIF  2me Titulaire");
		lnif2.setVisible(false);
		lnif2.setBorderStyle(BorderStyle.FIXED_3D);

		this.setNewControls(new Control[] {
							lnif2, 
							p1, 
							label5, 
							pictureBox1, 
							pictureBox6, 
							label4, 
							label6, 
							button5, 
							button4, 
							button3, 
							button2, 
							button1, 
							edit3, 
							label3, 
							edit2, 
							label2, 
							edit1, 
							label1, 
							labelNo_dossier, 
							editNo_dossier, 
							labelNom, 
							editNom, 
							labelPrenom, 
							editPrenom, 
							labelSexe, 
							editSexe, 
							labelAdresse, 
							editAdresse, 
							labelPhone_1, 
							editPhone_1, 
							labelPhone_2, 
							editPhone_2, 
							labelRef_titul, 
							editRef_titul, 
							editDate_inscri, 
							labelDate_inscri, 
							panel1, 
							group1, 
							groupBox1, 
							pictureBox2, 
							group2});
		group2.setNewControls(new Control[] {
							  nif2});

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
        Application.run( new Modi_Patient() );
    }
}
