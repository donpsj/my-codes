//Modi_Titulaire.java

import com.ms.wfc.app.*;
import com.ms.wfc.core.*;
import com.ms.wfc.ui.*;
import com.ms.wfc.data.*;
import com.ms.wfc.data.ui.*;

public class Modi_Titulaire extends Form
{   public String c1 = new String();
	public String c2 = new String();
	public String c3 = new String();
	public String c4 = new String();
	public String c5 = new String();
	public String c6 = new String();

    public void dispose()
    {
        super.dispose();
        components.dispose();
    }
	
    public Modi_Titulaire()
    {
        // Required for Visual J++ Form Designer support
        initForm();
        
        this.show();
        this.update();
		
		 editNo_assur.setText("");
		 editNo_assur.selectAll();
		 edit1.setText("");
		 edit2.setText("");
		 edit3.setText("");
		 Etat.setText("");
		 edit5.setText("");
		 Comp.setText("");
		 editNo_assur.selectAll();
		 Etat.setVisible(false);
		 button2.setVisible(false);
		 button3.setVisible(false);
		 panel1.setVisible(false);
		 group1.setVisible(false);
		 group2.setVisible(false);
		 
		 
		 

        //TODO: Add any constructor code after initForm call
    }    

    public void formClose(Event e)
    {
        Application.exit();
    }    

    
    void handleADOException(Exception e)
    {
        e.printStackTrace();
        MessageBox.show( e.toString(), "Modi_Titulaire" );
    }

	private void button1_click(Object source, Event e)
	{
		if(editNo_assur.getText().equals(""))
		{MessageBox.show("Veuillez Entrer le NIF du Titulaire S.V.P !","Champ de Recheche à Remplir",MessageBox.ICONERROR);
		 }
		else
		{   DataSource find = new DataSource();
		    find.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		    find.setCommandText("select * from Titulaire where Nif = '"+editNo_assur.getText()+"'");			  			
            find.begin();
			
			if(String.valueOf(find.getRecordset().getRecordCount()).equals("0"))
			   {MessageBox.show("Desolé, Vous ne Pouvez Modifier les Données De ce Titulaire, Car le NIF << '"+editNo_assur.getText()+"' >>, n'Existe pas !", " Opération Illégale",MessageBox.ICONSTOP);
		     	 editNo_assur.setText("");
			    }
			else
			{	
			      DataBinder display = new DataBinder();
				  display.setDataSource(find);
				  display.setBindings(new DataBinding[]{
							    new DataBinding(editNom,"text","Nom"),
							    new DataBinding(editPrenom,"text","Prenom"),
							    new DataBinding(editSexe,"text","sexe"),
							    new DataBinding(editAdresse,"text","Adresse"),
								new DataBinding(editPhone_1,"text","Phone_1"),
								new DataBinding(editPhone_2,"text","Phone_2"),
								new DataBinding(editEtat_mat,"text","Etat_mat"),	
								new DataBinding(editEmployeur,"text","Employeur"),
							    new DataBinding(editNif,"text","Nif"),
								new DataBinding(editCharge,"text","Charge"),
								new DataBinding(editRef_comp,"text","Ref_comp"),
								 					   });
				               c1=editAdresse.getText();
							   c2=editPhone_1.getText();
				               c3=editPhone_2.getText();
							   c4=editEtat_mat.getText();
							   c5=editEmployeur.getText();
							   c6=editRef_comp.getText();
							   
							   button1.setEnabled(false);
							   
							   label6.setVisible(true);
							   labelNom.setVisible(true);
							   labelPrenom.setVisible(true);
							   labelSexe.setVisible(true);
							   labelAdresse.setVisible(true);
							   labelPhone_1.setVisible(true);
							   labelPhone_2.setVisible(true);
							   labelEtat_mat.setVisible(true);
							   labelEmployeur.setVisible(true);
							   labelNif.setVisible(true);
							   labelCharge.setVisible(true);
							   labelRef_comp.setVisible(true);
									   
							   editNom.setVisible(true);
							   editPrenom.setVisible(true);
							   editSexe.setVisible(true);
							   editAdresse.setVisible(true);
							   editPhone_1.setVisible(true);
							   editPhone_2.setVisible(true);
							   editEtat_mat.setVisible(true);
							   editEmployeur.setVisible(true);
							   editNif.setVisible(true);
							   editCharge.setVisible(true);
							   editRef_comp.setVisible(true);
									
							   label1.setVisible(true);
							   label2.setVisible(true);
							   label3.setVisible(true);
							   label4.setVisible(true);
							   label5.setVisible(true);
							   labelComp.setVisible(true);
							   
							   group1.setVisible(true);
		                       group2.setVisible(true);
							   
							   edit1.setVisible(true);
							   edit2.setVisible(true);
							   edit3.setVisible(true);
							   Etat.setVisible(true);
							   edit5.setVisible(true);
							   Comp.setVisible(true);
								
	  
							   
							   button2.setVisible(true);
							   button3.setVisible(true);
							   button3.setEnabled(true);
		                       button4.setVisible(true);
							   button5.setEnabled(false);
		                       panel1.setVisible(true);
		 
				                 
								
										
			        }
	     	}
			
			
	  }

	private void button5_click(Object source, Event e)
	{editNo_assur.setText("");    
	}

	private void button4_click(Object source, Event e)
	{
		int choi;
		choi=MessageBox.show("Etes-vous sur de Vouloir Abandonner l'Opération?", "Abandon",MessageBox.YESNO);
	    if(choi==MessageBox.IDYES)   
		{ hide();
		}
	}

	private void button2_click(Object source, Event e)
	{
		 editNo_assur.setText("");
		 editNo_assur.selectAll();
		 edit1.setText("");
		 edit2.setText("");
		 edit3.setText("");
		 Etat.setText("");
		 edit5.setText("");
		  Comp.setText("");
		 button5.setEnabled(true);
		 button1.setEnabled(true);
		 button2.setVisible(false);
		 button3.setVisible(false);
		panel1.setVisible(false);
		group1.setVisible(false);
		group2.setVisible(false);
		 		         
	   label6.setVisible(false);
	   labelNom.setVisible(false);
       labelPrenom.setVisible(false);
	   labelSexe.setVisible(false);
	   labelAdresse.setVisible(false);
	   labelPhone_1.setVisible(false);
	   labelPhone_2.setVisible(false);
	   labelEtat_mat.setVisible(false);
	   labelEmployeur.setVisible(false);
	   labelNif.setVisible(false);
	   labelCharge.setVisible(false);
	   labelRef_comp.setVisible(false);
	  
	   editNom.setVisible(false);
	   editPrenom.setVisible(false);
	   editSexe.setVisible(false);
	   editAdresse.setVisible(false);
	   editPhone_1.setVisible(false);
	   editPhone_2.setVisible(false);
	   editEtat_mat.setVisible(false);
	   editEmployeur.setVisible(false);
	   editNif.setVisible(false);
	   editCharge.setVisible(false);
	   editRef_comp.setVisible(false);
	   Comp.setVisible(false);
								
	   labelComp.setVisible(false);
	   label1.setVisible(false);
	   label2.setVisible(false);
	   label3.setVisible(false);
	   label4.setVisible(false);
	   label5.setVisible(false);
				   
	   edit1.setVisible(false);
	   edit2.setVisible(false);
	   edit3.setVisible(false);
	   Etat.setVisible(false);
	   edit5.setVisible(false);
	    
		
	}

	private void button3_click(Object source, Event e)
	{
		      Connection cop = new Connection();
	           Recordset top = new Recordset();
		       int choix; 
			  
			   
		try
		{ if(edit1.getText().equals(""))
			        {
				     edit1.setText(c1);
			         } 
			   if(edit2.getText().equals(""))
			   {edit2.setText(c2);
			   } 
			         
				if(edit3.getText().equals(""))
			      { edit3.setText(c3);   
				   } 
			 
				 if(Etat.getText().equals(""))
			       {
				    Etat.setText(c4);
			       } 
			  
				   if(edit5.getText().equals(""))
			        {
				    edit5.setText(c5);
			       }
				   if(Comp.getText().equals(""))
				   {Comp.setText(c6);
				   }
			
			DataSource find = new DataSource();
		    find.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		    find.setCommandText("select * from Compagnie where Nom = '"+Comp.getText()+"'");			  			
            find.begin();
			
			if(String.valueOf(find.getRecordset().getRecordCount()).equals("0"))
			   {MessageBox.show("Désolé,la Compagnie << '"+Comp.getText()+"' >> n'Esxiste pas, Veuillez l'Inscrire d'abord !", " Opération Illégale",MessageBox.ICONSTOP);
		     	 Comp.setText("");
			    }
			else
			{      choix=MessageBox.show("Etes-vous sur de vouloir modifier ces données?", "Moment de Décision",MessageBox.YESNO);
				          if(choix==MessageBox.IDYES)   
						  {  cop.setConnectionString("dsn=HAH;uid=genial;pwd=genial");
				             cop.open();
							 top.setActiveConnection(cop);
				             top.setSource("Update Titulaire set Adresse ='"+edit1.getText()+"',Phone_1='"+edit2.getText()+"',Phone_2='"+edit3.getText()+"',Etat_mat='"+Etat.getText()+"',Employeur='"+edit5.getText()+"',Ref_comp='"+Comp.getText()+"' where Nif = '"+editNo_assur.getText()+"'");
				             top.open();
							MessageBox.show("Bravo! Les Modifications pour le Titulaire Identifié NIF << "+editNo_assur.getText()+" >> Sont Effectuées ","Mises à jour Réussies"); 
						    button3.setEnabled(false);
							
						  }
							
			}
		}
				
		catch(com.ms.wfc.data.AdoException ex)
             {  MessageBox.show("Attention! Doublez les Aprostrophes Dans les Champs qui les Contiennent puis, Essayez à Nouveau la Modification","Données Incompatibles",MessageBox.ICONERROR);

             }
								   
		}

	private void editNo_assur_textChanged(Object source, Event e)
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
	Label labelNif = new Label();
	Edit editNif = new Edit();
	Label labelNo_assur = new Label();
	Edit editNo_assur = new Edit();
	Label labelRef_comp = new Label();
	Edit editRef_comp = new Edit();
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
	Label labelEtat_mat = new Label();
	Edit editEtat_mat = new Edit();
	Label labelEmployeur = new Label();
	Edit editEmployeur = new Edit();
	Label labelCharge = new Label();
	Edit editCharge = new Edit();
	Label label1 = new Label();
	Edit edit1 = new Edit();
	Label label2 = new Label();
	Edit edit2 = new Edit();
	Label label3 = new Label();
	Edit edit3 = new Edit();
	Label label4 = new Label();
	ComboBox Etat = new ComboBox();
	Label label5 = new Label();
	Edit edit5 = new Edit();
	Button button1 = new Button();
	Label label6 = new Label();
	Panel panel1 = new Panel();
	Button button2 = new Button();
	Button button3 = new Button();
	Button button4 = new Button();
	Button button5 = new Button();
	GroupBox groupBox1 = new GroupBox();
	GroupBox group2 = new GroupBox();
	GroupBox group1 = new GroupBox();
	PictureBox pictureBox6 = new PictureBox();
	PictureBox pictureBox1 = new PictureBox();
	Label label7 = new Label();
	PictureBox pictureBox4 = new PictureBox();
	Label label8 = new Label();
	Edit Comp = new Edit();
	Label labelComp = new Label();

	private void initForm()
	{
		// REMARQUE : cette feuille stocke des informations sur les ressources
		// dans un fichier externe. Ne modifiez le paramètre de chaîne d'aucun
		// appel de fonction resources.getObject(). Par exemple,
		// ne modifiez pas "foo1_location" dans la ligne de code
		// suivante, même si le nom de l'objet Foo change : 
		//	 foo1.setLocation((Point)resources.getObject("foo1_location"));

		IResourceManager resources = new ResourceManager(this, "Modi_Titulaire");
		this.setLocation(new Point(7, 7));
		this.setText("Modification des Coordonnées d\'un Titulaire Assuré");
		this.setAutoScaleBaseSize(new Point(5, 13));
		this.setAutoScroll(true);
		this.setBorderStyle(FormBorderStyle.NONE);
		this.setClientSize(new Point(599, 428));
		this.setMaximizeBox(false);
		this.setStartPosition(FormStartPosition.CENTER_SCREEN);

		dataSource1.setConnectionString("PROVIDER=MSDASQL;dsn=HAH;uid=genial;pwd=genial;DBQ=C:\\ASSURE.MDB");
		dataSource1.setCommandText("select Nif, No_assur, Ref_comp, Nom, Prenom, Sexe, Adresse, Phone_1, Phone_2, Etat_mat, Employeur, Charge from Titulaire ORDER by Nom");
		dataSource1.setSort(null);
		dataSource1.setStayInSync(true);
		dataSource1.setUserId(null);
		dataSource1.setPassword(null);
		/* @designTimeOnly dataSource1.setLocation(new Point(304, 160)); */

		labelNif.setBackColor(Color.CONTROL);
		labelNif.setLocation(new Point(41, 325));
		labelNif.setSize(new Point(100, 20));
		labelNif.setTabIndex(7);
		labelNif.setTabStop(false);
		labelNif.setText("Nif du Titulaire");
		labelNif.setVisible(false);
		labelNif.setBorderStyle(BorderStyle.FIXED_3D);

		editNif.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNif.setLocation(new Point(151, 325));
		editNif.setSize(new Point(143, 20));
		editNif.setTabIndex(8);
		editNif.setText("003-066-059-2");
		editNif.setVisible(false);
		editNif.setMaxLength(13);
		editNif.setMultiline(true);
		editNif.setReadOnly(true);

		labelNo_assur.setBackColor(new Color(255, 255, 192));
		labelNo_assur.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNo_assur.setLocation(new Point(38, 109));
		labelNo_assur.setSize(new Point(168, 20));
		labelNo_assur.setTabIndex(10);
		labelNo_assur.setTabStop(false);
		labelNo_assur.setText("Le NIF du Titulaire ");
		labelNo_assur.setBorderStyle(BorderStyle.FIXED_3D);

		editNo_assur.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNo_assur.setLocation(new Point(214, 109));
		editNo_assur.setSize(new Point(120, 20));
		editNo_assur.setTabIndex(11);
		editNo_assur.setText("");
		editNo_assur.setCharacterCasing(CharacterCasing.UPPER);
		editNo_assur.setMaxLength(30);
		editNo_assur.setWordWrap(false);
		editNo_assur.addOnTextChanged(new EventHandler(this.editNo_assur_textChanged));

		labelRef_comp.setBackColor(Color.CONTROL);
		labelRef_comp.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelRef_comp.setLocation(new Point(40, 373));
		labelRef_comp.setSize(new Point(248, 18));
		labelRef_comp.setTabIndex(12);
		labelRef_comp.setTabStop(false);
		labelRef_comp.setText("Compagnie d\'Assurance");
		labelRef_comp.setVisible(false);
		labelRef_comp.setBorderStyle(BorderStyle.FIXED_3D);
		labelRef_comp.setTextAlign(HorizontalAlignment.CENTER);

		editRef_comp.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRef_comp.setEnabled(false);
		editRef_comp.setLocation(new Point(39, 395));
		editRef_comp.setSize(new Point(255, 20));
		editRef_comp.setTabIndex(13);
		editRef_comp.setText("INASSA");
		editRef_comp.setVisible(false);
		editRef_comp.setMaxLength(50);
		editRef_comp.setMultiline(true);
		editRef_comp.setTextAlign(HorizontalAlignment.CENTER);

		labelNom.setBackColor(Color.CONTROL);
		labelNom.setLocation(new Point(41, 147));
		labelNom.setSize(new Point(100, 20));
		labelNom.setTabIndex(14);
		labelNom.setTabStop(false);
		labelNom.setText("Nom");
		labelNom.setVisible(false);
		labelNom.setBorderStyle(BorderStyle.FIXED_3D);

		editNom.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNom.setEnabled(false);
		editNom.setLocation(new Point(151, 147));
		editNom.setSize(new Point(143, 20));
		editNom.setTabIndex(15);
		editNom.setText("Prince");
		editNom.setVisible(false);
		editNom.setMaxLength(50);
		editNom.setMultiline(true);

		labelPrenom.setBackColor(Color.CONTROL);
		labelPrenom.setLocation(new Point(41, 169));
		labelPrenom.setSize(new Point(100, 20));
		labelPrenom.setTabIndex(16);
		labelPrenom.setTabStop(false);
		labelPrenom.setText("Prenom");
		labelPrenom.setVisible(false);
		labelPrenom.setBorderStyle(BorderStyle.FIXED_3D);

		editPrenom.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editPrenom.setEnabled(false);
		editPrenom.setLocation(new Point(151, 169));
		editPrenom.setSize(new Point(143, 20));
		editPrenom.setTabIndex(17);
		editPrenom.setText("Guichard");
		editPrenom.setVisible(false);
		editPrenom.setMaxLength(50);
		editPrenom.setMultiline(true);

		labelSexe.setBackColor(Color.CONTROL);
		labelSexe.setLocation(new Point(41, 191));
		labelSexe.setSize(new Point(100, 20));
		labelSexe.setTabIndex(18);
		labelSexe.setTabStop(false);
		labelSexe.setText("Sexe");
		labelSexe.setVisible(false);
		labelSexe.setBorderStyle(BorderStyle.FIXED_3D);

		editSexe.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editSexe.setEnabled(false);
		editSexe.setLocation(new Point(151, 191));
		editSexe.setSize(new Point(55, 20));
		editSexe.setTabIndex(19);
		editSexe.setText("M");
		editSexe.setVisible(false);
		editSexe.setMaxLength(2);
		editSexe.setMultiline(true);

		labelAdresse.setBackColor(Color.CONTROL);
		labelAdresse.setLocation(new Point(41, 213));
		labelAdresse.setSize(new Point(100, 20));
		labelAdresse.setTabIndex(25);
		labelAdresse.setTabStop(false);
		labelAdresse.setText("Adresse");
		labelAdresse.setVisible(false);
		labelAdresse.setBorderStyle(BorderStyle.FIXED_3D);

		editAdresse.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editAdresse.setEnabled(false);
		editAdresse.setLocation(new Point(151, 213));
		editAdresse.setSize(new Point(143, 20));
		editAdresse.setTabIndex(27);
		editAdresse.setText("Delams 65 # 12");
		editAdresse.setVisible(false);
		editAdresse.setMaxLength(50);
		editAdresse.setMultiline(true);

		labelPhone_1.setBackColor(Color.CONTROL);
		labelPhone_1.setLocation(new Point(41, 235));
		labelPhone_1.setSize(new Point(100, 20));
		labelPhone_1.setTabIndex(28);
		labelPhone_1.setTabStop(false);
		labelPhone_1.setText("Phone_1");
		labelPhone_1.setVisible(false);
		labelPhone_1.setBorderStyle(BorderStyle.FIXED_3D);

		editPhone_1.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editPhone_1.setEnabled(false);
		editPhone_1.setLocation(new Point(151, 235));
		editPhone_1.setSize(new Point(143, 20));
		editPhone_1.setTabIndex(29);
		editPhone_1.setText("246-5866");
		editPhone_1.setVisible(false);
		editPhone_1.setMaxLength(15);
		editPhone_1.setMultiline(true);

		labelPhone_2.setBackColor(Color.CONTROL);
		labelPhone_2.setLocation(new Point(41, 257));
		labelPhone_2.setSize(new Point(100, 20));
		labelPhone_2.setTabIndex(30);
		labelPhone_2.setTabStop(false);
		labelPhone_2.setText("Phone_2");
		labelPhone_2.setVisible(false);
		labelPhone_2.setBorderStyle(BorderStyle.FIXED_3D);

		editPhone_2.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editPhone_2.setEnabled(false);
		editPhone_2.setLocation(new Point(151, 257));
		editPhone_2.setSize(new Point(143, 20));
		editPhone_2.setTabIndex(31);
		editPhone_2.setText("");
		editPhone_2.setVisible(false);
		editPhone_2.setMaxLength(15);
		editPhone_2.setMultiline(true);

		labelEtat_mat.setBackColor(Color.CONTROL);
		labelEtat_mat.setLocation(new Point(41, 279));
		labelEtat_mat.setSize(new Point(100, 20));
		labelEtat_mat.setTabIndex(32);
		labelEtat_mat.setTabStop(false);
		labelEtat_mat.setText("Etat Matrimonial");
		labelEtat_mat.setVisible(false);
		labelEtat_mat.setBorderStyle(BorderStyle.FIXED_3D);

		editEtat_mat.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editEtat_mat.setEnabled(false);
		editEtat_mat.setLocation(new Point(151, 279));
		editEtat_mat.setSize(new Point(143, 20));
		editEtat_mat.setTabIndex(33);
		editEtat_mat.setText("Célibataire");
		editEtat_mat.setVisible(false);
		editEtat_mat.setMaxLength(50);
		editEtat_mat.setMultiline(true);

		labelEmployeur.setBackColor(Color.CONTROL);
		labelEmployeur.setLocation(new Point(41, 301));
		labelEmployeur.setSize(new Point(100, 20));
		labelEmployeur.setTabIndex(34);
		labelEmployeur.setTabStop(false);
		labelEmployeur.setText("Employeur");
		labelEmployeur.setVisible(false);
		labelEmployeur.setBorderStyle(BorderStyle.FIXED_3D);

		editEmployeur.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editEmployeur.setEnabled(false);
		editEmployeur.setLocation(new Point(151, 301));
		editEmployeur.setSize(new Point(143, 20));
		editEmployeur.setTabIndex(35);
		editEmployeur.setText("MNSJ");
		editEmployeur.setVisible(false);
		editEmployeur.setMaxLength(50);
		editEmployeur.setMultiline(true);

		labelCharge.setBackColor(Color.CONTROL);
		labelCharge.setLocation(new Point(41, 349));
		labelCharge.setSize(new Point(100, 20));
		labelCharge.setTabIndex(36);
		labelCharge.setTabStop(false);
		labelCharge.setText("Charge");
		labelCharge.setVisible(false);
		labelCharge.setBorderStyle(BorderStyle.FIXED_3D);

		editCharge.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editCharge.setEnabled(false);
		editCharge.setLocation(new Point(151, 348));
		editCharge.setSize(new Point(107, 20));
		editCharge.setTabIndex(37);
		editCharge.setText("0");
		editCharge.setVisible(false);
		editCharge.setMultiline(true);

		dataBinder1.setDataSource(dataSource1);
		dataBinder1.setDataMember("");
		dataBinder1.setBindings(new DataBinding[] {
								new DataBinding(editNif, "Text", "Nif", null), 
								new DataBinding(editNo_assur, "Text", "No_assur", null), 
								new DataBinding(editRef_comp, "Text", "Ref_comp", null), 
								new DataBinding(editNom, "Text", "Nom", null), 
								new DataBinding(editPrenom, "Text", "Prenom", null), 
								new DataBinding(editSexe, "Text", "Sexe", null), 
								new DataBinding(editAdresse, "Text", "Adresse", null), 
								new DataBinding(editPhone_1, "Text", "Phone_1", null), 
								new DataBinding(editPhone_2, "Text", "Phone_2", null), 
								new DataBinding(editEtat_mat, "Text", "Etat_mat", null), 
								new DataBinding(editEmployeur, "Text", "Employeur", null), 
								new DataBinding(editCharge, "Text", "Charge", null)});
		/* @designTimeOnly dataBinder1.setLocation(new Point(304, 138)); */

		label1.setBackColor(Color.CONTROL);
		label1.setLocation(new Point(309, 221));
		label1.setSize(new Point(88, 20));
		label1.setTabIndex(20);
		label1.setTabStop(false);
		label1.setText("Adresse");
		label1.setVisible(false);
		label1.setBorderStyle(BorderStyle.FIXED_3D);

		edit1.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		edit1.setLocation(new Point(401, 221));
		edit1.setSize(new Point(159, 20));
		edit1.setTabIndex(1);
		edit1.setText("Adresse");
		edit1.setVisible(false);
		edit1.setMaxLength(50);

		label2.setBackColor(Color.CONTROL);
		label2.setLocation(new Point(309, 244));
		label2.setSize(new Point(88, 20));
		label2.setTabIndex(21);
		label2.setTabStop(false);
		label2.setText("Phone_1");
		label2.setVisible(false);
		label2.setBorderStyle(BorderStyle.FIXED_3D);

		edit2.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		edit2.setLocation(new Point(401, 244));
		edit2.setSize(new Point(159, 20));
		edit2.setTabIndex(2);
		edit2.setText("Phone_1");
		edit2.setVisible(false);
		edit2.setMaxLength(15);

		label3.setBackColor(Color.CONTROL);
		label3.setLocation(new Point(309, 267));
		label3.setSize(new Point(88, 20));
		label3.setTabIndex(22);
		label3.setTabStop(false);
		label3.setText("Phone_2");
		label3.setVisible(false);
		label3.setBorderStyle(BorderStyle.FIXED_3D);

		edit3.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		edit3.setLocation(new Point(401, 266));
		edit3.setSize(new Point(159, 20));
		edit3.setTabIndex(3);
		edit3.setText("Phone_2");
		edit3.setVisible(false);
		edit3.setMaxLength(15);

		label4.setBackColor(Color.CONTROL);
		label4.setLocation(new Point(309, 290));
		label4.setSize(new Point(88, 20));
		label4.setTabIndex(23);
		label4.setTabStop(false);
		label4.setText("Etat_mat");
		label4.setVisible(false);
		label4.setBorderStyle(BorderStyle.FIXED_3D);

		Etat.setLocation(new Point(401, 290));
		Etat.setSize(new Point(159, 21));
		Etat.setTabIndex(4);
		Etat.setText("");
		Etat.setItems(new Object[] {
					  "Célibataire", 
					  "Marié", 
					  "Divorcé", 
					  "Veuf"});

		label5.setBackColor(Color.CONTROL);
		label5.setLocation(new Point(309, 314));
		label5.setSize(new Point(88, 20));
		label5.setTabIndex(24);
		label5.setTabStop(false);
		label5.setText("Employeur");
		label5.setVisible(false);
		label5.setBorderStyle(BorderStyle.FIXED_3D);

		edit5.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		edit5.setLocation(new Point(401, 314));
		edit5.setSize(new Point(159, 20));
		edit5.setTabIndex(5);
		edit5.setText("Employeur");
		edit5.setVisible(false);
		edit5.setMaxLength(50);

		button1.setLocation(new Point(349, 109));
		button1.setSize(new Point(72, 20));
		button1.setTabIndex(38);
		button1.setText("Rechercher");
		button1.addOnClick(new EventHandler(this.button1_click));

		label6.setBackColor(Color.AQUA);
		label6.setFont(new Font("MS Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label6.setForeColor(Color.WHITE);
		label6.setLocation(new Point(309, 193));
		label6.setSize(new Point(240, 16));
		label6.setTabIndex(39);
		label6.setTabStop(false);
		label6.setText("Veuillez entrer les nouvelles données ici S.V.P");
		label6.setVisible(false);
		label6.setBorderStyle(BorderStyle.FIXED_3D);

		panel1.setBackColor(new Color(0, 192, 192));
		panel1.setLocation(new Point(299, 381));
		panel1.setSize(new Point(264, 40));
		panel1.setTabIndex(40);
		panel1.setText("panel1");
		panel1.setBorderStyle(BorderStyle.FIXED_3D);

		button2.setLocation(new Point(8, 8));
		button2.setSize(new Point(60, 20));
		button2.setTabIndex(0);
		button2.setText("&Nouveau");
		button2.addOnClick(new EventHandler(this.button2_click));

		button3.setLocation(new Point(192, 8));
		button3.setSize(new Point(60, 20));
		button3.setTabIndex(1);
		button3.setText("&Modifier");
		button3.addOnClick(new EventHandler(this.button3_click));

		button4.setLocation(new Point(498, 109));
		button4.setSize(new Point(56, 20));
		button4.setTabIndex(9);
		button4.setText("&Fermer");
		button4.addOnClick(new EventHandler(this.button4_click));

		button5.setLocation(new Point(432, 109));
		button5.setSize(new Point(56, 20));
		button5.setTabIndex(41);
		button5.setText("&Annuler");
		button5.addOnClick(new EventHandler(this.button5_click));

		groupBox1.setBackColor(new Color(0, 192, 192));
		groupBox1.setForeColor(new Color(0, 192, 192));
		groupBox1.setLocation(new Point(32, 96));
		groupBox1.setSize(new Point(528, 40));
		groupBox1.setTabIndex(42);
		groupBox1.setTabStop(false);
		groupBox1.setText("");

		group2.setLocation(new Point(32, 134));
		group2.setSize(new Point(264, 288));
		group2.setTabIndex(43);
		group2.setTabStop(false);
		group2.setText("");
		group2.setVisible(false);

		group1.setLocation(new Point(299, 176));
		group1.setSize(new Point(264, 184));
		group1.setTabIndex(44);
		group1.setTabStop(false);
		group1.setText("");
		group1.setVisible(false);

		pictureBox6.setLocation(new Point(32, 18));
		pictureBox6.setSize(new Point(88, 80));
		pictureBox6.setTabIndex(0);
		pictureBox6.setTabStop(false);
		pictureBox6.setText("pictureBox2");
		pictureBox6.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox6.setImage((Bitmap)resources.getObject("pictureBox6_image"));
		pictureBox6.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox1.setLocation(new Point(50, 6));
		pictureBox1.setSize(new Point(88, 80));
		pictureBox1.setTabIndex(26);
		pictureBox1.setTabStop(false);
		pictureBox1.setText("pictureBox1");
		pictureBox1.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox1.setImage((Bitmap)resources.getObject("pictureBox1_image"));
		pictureBox1.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		label7.setBackColor(new Color(255, 255, 192));
		label7.setFont(new Font("Verdana", 11.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label7.setForeColor(Color.AQUA);
		label7.setLocation(new Point(174, 10));
		label7.setSize(new Point(368, 23));
		label7.setTabIndex(48);
		label7.setTabStop(false);
		label7.setText("Modification des Coordonnées d\'un Titulaire");
		label7.setBorderStyle(BorderStyle.FIXED_3D);
		label7.setTextAlign(HorizontalAlignment.CENTER);

		pictureBox4.setLocation(new Point(141, 6));
		pictureBox4.setSize(new Point(440, 32));
		pictureBox4.setTabIndex(6);
		pictureBox4.setTabStop(false);
		pictureBox4.setText("pictureBox2");
		pictureBox4.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox4.setImage((Bitmap)resources.getObject("pictureBox4_image"));
		pictureBox4.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		label8.setLocation(new Point(32, 94));
		label8.setSize(new Point(528, 8));
		label8.setTabIndex(47);
		label8.setTabStop(false);
		label8.setText("");

		Comp.setLocation(new Point(102, 160));
		Comp.setSize(new Point(159, 20));
		Comp.setTabIndex(1);
		Comp.setText("");
		Comp.setVisible(false);
		Comp.setCharacterCasing(CharacterCasing.UPPER);

		labelComp.setLocation(new Point(9, 161));
		labelComp.setSize(new Point(88, 20));
		labelComp.setTabIndex(0);
		labelComp.setTabStop(false);
		labelComp.setText("Compagnie");
		labelComp.setVisible(false);
		labelComp.setBorderStyle(BorderStyle.FIXED_3D);

		this.setNewControls(new Control[] {
							label8, 
							label7, 
							pictureBox1, 
							pictureBox6, 
							button4, 
							Etat, 
							button5, 
							panel1, 
							label6, 
							button1, 
							edit5, 
							label5, 
							label4, 
							edit3, 
							label3, 
							edit2, 
							label2, 
							edit1, 
							label1, 
							labelNif, 
							editNif, 
							labelNo_assur, 
							editNo_assur, 
							labelRef_comp, 
							editRef_comp, 
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
							labelEtat_mat, 
							editEtat_mat, 
							labelEmployeur, 
							editEmployeur, 
							labelCharge, 
							editCharge, 
							groupBox1, 
							group2, 
							group1, 
							pictureBox4});
		panel1.setNewControls(new Control[] {
							  button3, 
							  button2});
		group1.setNewControls(new Control[] {
							  labelComp, 
							  Comp});

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
        Application.run( new Modi_Titulaire() );
    }
}
