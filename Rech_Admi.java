//Rech_Admi.java

import com.ms.wfc.app.*;
import com.ms.wfc.core.*;
import com.ms.wfc.ui.*;
import com.ms.wfc.data.*;
import com.ms.wfc.data.ui.*;

public class Rech_Admi extends Form
{

	
	private void button1_click(Object source, Event e)
	{   DataSource fin = new DataSource();
		DataBinder display = new DataBinder();
		
	
    try{
		int nad = (Integer.valueOf(editNo_admi.getText()).intValue());
		
		if(editNo_admi.getText().equals("0"))
		{MessageBox.show("Veuillez Entrer le Numéro de l'Admission à Rechercher S.V.P !","Champ de Recheche à Remplir ",MessageBox.ICONERROR);
		 }
		else
		{   
		    fin.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		    fin.setCommandText("select * from Admission where No_admi= "+editNo_admi.getText()+"");			  			
            fin.begin();
			
			if(String.valueOf(fin.getRecordset().getRecordCount()).equals("0"))
			   {MessageBox.show("Désolé, L'Admission Numéro << "+editNo_admi.getText()+" >> est Introuvable !", " Recherche Echouée ",MessageBox.ICONWARNING);
		     	 editNo_admi.setText("0");
			    }
			else
			{     
				  display.setDataSource(fin);
				  display.setBindings(new DataBinding[]{
															     							
							    new DataBinding(editDate,"text","Date"),
								new DataBinding(editRef_dossier,"text","Ref_dossier"),
								new DataBinding(editChambre,"text","Chambre"),
								new DataBinding(editRef_titul,"text","Ref_titul"),
							    new DataBinding(editDoc_trait_1,"text","Doc_trait_1"),
								new DataBinding(editDoc_trait_2,"text","Doc_trait_2"),
							   	new DataBinding(editDoc_trait_3,"text","Doc_trait_3"),
								new DataBinding(editDate_exeat,"text","Date_exeat"),
								new DataBinding(tit2,"text","Nifp"),
							    new DataBinding(editCredit_patient,"text","Credit_patient"),
													 				  
									  });
				  
				  
				  
				                editDate.setVisible(true); 
								editRef_dossier.setVisible(true); 
								editChambre.setVisible(true); 
								editRef_titul.setVisible(true);  
							    editDoc_trait_1.setVisible(true);  
								editDoc_trait_2.setVisible(true); 
							    editDoc_trait_3.setVisible(true);  
								editDate_exeat.setVisible(true); 
								tit2.setVisible(true);  
							    editCredit_patient.setVisible(true); 
								
								labelDate.setVisible(true); 
								labelRef_dossier.setVisible(true); 
								labelChambre.setVisible(true); 
								labelRef_titul.setVisible(true);  
							    labelDoc_trait_1.setVisible(true);  
								labelDoc_trait_2.setVisible(true); 
							    labelDoc_trait_3.setVisible(true);  
								labelDate_exeat.setVisible(true); 
								ltit2.setVisible(true);  
							    labelCredit_patient.setVisible(true);  
								label2.setVisible(true); 
								label3.setVisible(true);
								group.setVisible(true);
								
								button1.setEnabled(false);
								button2.setEnabled(true);
																								
				  		  
				  
	                  }
		           }
                }
  
           catch(NumberFormatException k){
		   MessageBox.show("Le Champ < Numéro de l'Admission > est de Type Numérique, Entrez le Numéro à Nouveau S.V.P  !","Données Incompatibles",MessageBox.ICONERROR);
		   editNo_admi.setText("0");
		  }	

	}


    public void btnClose_Click(Object sender, Event evt)
    {
        Application.exit();
    }

    boolean    m_bAddNew;
    public void dispose()
    {
        super.dispose();
        components.dispose();
    }
	
    public Rech_Admi()
    {
        // Required for Visual J++ Form Designer support
        initForm();
        
        this.show();
        this.update();
		editNo_admi.setText("0");

        //TODO: Add any constructor code after initForm call
    }    

    public void formClose(Event e)
    {
        Application.exit();
    }    

    
    void handleADOException(Exception e)
    {
        e.printStackTrace();
        MessageBox.show( e.toString(), "Rech_Admi" );
    }

	private void Rech_Admi_click(Object source, Event e)
	{
		
	}


	private void button2_click(Object source, Event e)
	{						    editNo_admi.setText("0");
		                        editDate.setVisible(false); 
								editRef_dossier.setVisible(false); 
								editChambre.setVisible(false); 
								editRef_titul.setVisible(false);  
							    editDoc_trait_1.setVisible(false);  
								editDoc_trait_2.setVisible(false); 
							    editDoc_trait_3.setVisible(false);  
								editDate_exeat.setVisible(false); 
								tit2.setVisible(false);  
							    editCredit_patient.setVisible(false); 
								
								labelDate.setVisible(false); 
								labelRef_dossier.setVisible(false); 
								labelChambre.setVisible(false); 
								labelRef_titul.setVisible(false);  
							    labelDoc_trait_1.setVisible(false);  
								labelDoc_trait_2.setVisible(false); 
							    labelDoc_trait_3.setVisible(false);  
								labelDate_exeat.setVisible(false); 
								ltit2.setVisible(false);  
							    labelCredit_patient.setVisible(false);  
								label2.setVisible(false); 
								label3.setVisible(false);
								group.setVisible(false);
								button1.setEnabled(true);
								 
	}

	private void button3_click(Object source, Event e)
	{
		int choi;
		choi=MessageBox.show("Etes-vous sur de Vouloir Abandonner l'Opération?", "Abandon",MessageBox.YESNO);
	    if(choi==MessageBox.IDYES)   
		{ hide();
		}
	}

	private void groupBox1_enter(Object source, Event e)
	{
		
	}

	/**
	 * NOTE: The following code is required by the Visual J++ form
	 * designer.  It can be modified using the form editor.  Do not
	 * modify it using the code editor.
	 */
	Container components = new Container();
	Panel panel1 = new Panel();
	GroupBox group = new GroupBox();
	GroupBox groupBox1 = new GroupBox();
	Edit editNo_admi = new Edit();
	Label labelDate = new Label();
	Edit editDate = new Edit();
	Label labelRef_dossier = new Label();
	Edit editRef_dossier = new Edit();
	Label labelChambre = new Label();
	Edit editChambre = new Edit();
	Label labelRef_titul = new Label();
	Edit editRef_titul = new Edit();
	Label labelDoc_trait_1 = new Label();
	Edit editDoc_trait_1 = new Edit();
	Label labelDoc_trait_2 = new Label();
	Edit editDoc_trait_2 = new Edit();
	Label labelDoc_trait_3 = new Label();
	Edit editDoc_trait_3 = new Edit();
	Label ltit2 = new Label();
	Edit tit2 = new Edit();
	Label labelDate_exeat = new Label();
	Edit editDate_exeat = new Edit();
	Label labelCredit_patient = new Label();
	Edit editCredit_patient = new Edit();
	Label label1 = new Label();
	Label label3 = new Label();
	Label label2 = new Label();
	Label labelNo_Avis = new Label();
	PictureBox pictureBox6 = new PictureBox();
	Label label4 = new Label();
	PictureBox pictureBox1 = new PictureBox();
	Label label5 = new Label();
	PictureBox pictureBox2 = new PictureBox();
	PictureBox pictureBox3 = new PictureBox();
	PictureBox button1 = new PictureBox();
	PictureBox button2 = new PictureBox();
	PictureBox button3 = new PictureBox();

	private void initForm()
	{
		// REMARQUE : cette feuille stocke des informations sur les ressources
		// dans un fichier externe. Ne modifiez le paramètre de chaîne d'aucun
		// appel de fonction resources.getObject(). Par exemple,
		// ne modifiez pas "foo1_location" dans la ligne de code
		// suivante, même si le nom de l'objet Foo change : 
		//	 foo1.setLocation((Point)resources.getObject("foo1_location"));

		IResourceManager resources = new ResourceManager(this, "Rech_Admi");
		this.setLocation(new Point(7, 7));
		this.setText("Recherche d\'une Admission");
		this.setAutoScaleBaseSize(new Point(5, 13));
		this.setAutoScroll(true);
		this.setBorderStyle(FormBorderStyle.NONE);
		this.setClientSize(new Point(600, 431));
		this.setMaximizeBox(false);
		this.setStartPosition(FormStartPosition.CENTER_SCREEN);
		this.addOnClick(new EventHandler(this.Rech_Admi_click));

		panel1.setBackColor(new Color(0, 192, 192));
		panel1.setLocation(new Point(4, 375));
		panel1.setSize(new Point(584, 48));
		panel1.setTabIndex(33);
		panel1.setText("panel1");
		panel1.setBorderStyle(BorderStyle.FIXED_3D);

		group.setLocation(new Point(14, 173));
		group.setSize(new Point(568, 192));
		group.setTabIndex(32);
		group.setTabStop(false);
		group.setText("");
		group.setVisible(false);

		groupBox1.setBackColor(new Color(0, 192, 192));
		groupBox1.setLocation(new Point(75, 123));
		groupBox1.setSize(new Point(456, 48));
		groupBox1.setTabIndex(25);
		groupBox1.setTabStop(false);
		groupBox1.setText("");
		groupBox1.addOnEnter(new EventHandler(this.groupBox1_enter));

		editNo_admi.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNo_admi.setLocation(new Point(231, 140));
		editNo_admi.setSize(new Point(80, 20));
		editNo_admi.setTabIndex(5);
		editNo_admi.setText("");

		labelDate.setBackColor(Color.CONTROL);
		labelDate.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelDate.setLocation(new Point(20, 201));
		labelDate.setSize(new Point(176, 20));
		labelDate.setTabIndex(8);
		labelDate.setTabStop(false);
		labelDate.setText(" Date d\'Admission");
		labelDate.setVisible(false);
		labelDate.setBorderStyle(BorderStyle.FIXED_3D);

		editDate.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editDate.setEnabled(false);
		editDate.setLocation(new Point(197, 201));
		editDate.setSize(new Point(104, 20));
		editDate.setTabIndex(10);
		editDate.setText("");
		editDate.setVisible(false);
		editDate.setMaxLength(50);
		editDate.setMultiline(true);

		labelRef_dossier.setBackColor(Color.CONTROL);
		labelRef_dossier.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelRef_dossier.setLocation(new Point(20, 224));
		labelRef_dossier.setSize(new Point(176, 20));
		labelRef_dossier.setTabIndex(11);
		labelRef_dossier.setTabStop(false);
		labelRef_dossier.setText(" No Dossier");
		labelRef_dossier.setVisible(false);
		labelRef_dossier.setBorderStyle(BorderStyle.FIXED_3D);

		editRef_dossier.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRef_dossier.setLocation(new Point(197, 223));
		editRef_dossier.setSize(new Point(104, 20));
		editRef_dossier.setTabIndex(12);
		editRef_dossier.setText("");
		editRef_dossier.setVisible(false);
		editRef_dossier.setMultiline(true);
		editRef_dossier.setReadOnly(true);

		labelChambre.setBackColor(Color.CONTROL);
		labelChambre.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelChambre.setLocation(new Point(20, 246));
		labelChambre.setSize(new Point(176, 20));
		labelChambre.setTabIndex(13);
		labelChambre.setTabStop(false);
		labelChambre.setText(" No de la Chambre");
		labelChambre.setVisible(false);
		labelChambre.setBorderStyle(BorderStyle.FIXED_3D);

		editChambre.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editChambre.setEnabled(false);
		editChambre.setLocation(new Point(197, 245));
		editChambre.setSize(new Point(104, 20));
		editChambre.setTabIndex(14);
		editChambre.setText("");
		editChambre.setVisible(false);
		editChambre.setMultiline(true);

		labelRef_titul.setBackColor(Color.CONTROL);
		labelRef_titul.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelRef_titul.setLocation(new Point(20, 268));
		labelRef_titul.setSize(new Point(176, 20));
		labelRef_titul.setTabIndex(16);
		labelRef_titul.setTabStop(false);
		labelRef_titul.setText("NIF du 1er Titulaire");
		labelRef_titul.setVisible(false);
		labelRef_titul.setBorderStyle(BorderStyle.FIXED_3D);

		editRef_titul.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRef_titul.setLocation(new Point(197, 267));
		editRef_titul.setSize(new Point(104, 20));
		editRef_titul.setTabIndex(17);
		editRef_titul.setText("");
		editRef_titul.setVisible(false);
		editRef_titul.setMaxLength(30);
		editRef_titul.setMultiline(true);
		editRef_titul.setReadOnly(true);

		labelDoc_trait_1.setBackColor(Color.CONTROL);
		labelDoc_trait_1.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelDoc_trait_1.setLocation(new Point(341, 200));
		labelDoc_trait_1.setSize(new Point(88, 20));
		labelDoc_trait_1.setTabIndex(18);
		labelDoc_trait_1.setTabStop(false);
		labelDoc_trait_1.setText(" Médecin_1");
		labelDoc_trait_1.setVisible(false);
		labelDoc_trait_1.setBorderStyle(BorderStyle.FIXED_3D);

		editDoc_trait_1.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editDoc_trait_1.setEnabled(false);
		editDoc_trait_1.setLocation(new Point(429, 200));
		editDoc_trait_1.setSize(new Point(144, 20));
		editDoc_trait_1.setTabIndex(19);
		editDoc_trait_1.setText("");
		editDoc_trait_1.setVisible(false);
		editDoc_trait_1.setMaxLength(50);
		editDoc_trait_1.setMultiline(true);

		labelDoc_trait_2.setBackColor(Color.CONTROL);
		labelDoc_trait_2.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelDoc_trait_2.setLocation(new Point(341, 224));
		labelDoc_trait_2.setSize(new Point(88, 20));
		labelDoc_trait_2.setTabIndex(20);
		labelDoc_trait_2.setTabStop(false);
		labelDoc_trait_2.setText(" Médecin_2");
		labelDoc_trait_2.setVisible(false);
		labelDoc_trait_2.setBorderStyle(BorderStyle.FIXED_3D);

		editDoc_trait_2.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editDoc_trait_2.setEnabled(false);
		editDoc_trait_2.setLocation(new Point(429, 224));
		editDoc_trait_2.setSize(new Point(144, 20));
		editDoc_trait_2.setTabIndex(22);
		editDoc_trait_2.setText("");
		editDoc_trait_2.setVisible(false);
		editDoc_trait_2.setMaxLength(50);
		editDoc_trait_2.setMultiline(true);

		labelDoc_trait_3.setBackColor(Color.CONTROL);
		labelDoc_trait_3.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelDoc_trait_3.setLocation(new Point(341, 248));
		labelDoc_trait_3.setSize(new Point(88, 20));
		labelDoc_trait_3.setTabIndex(23);
		labelDoc_trait_3.setTabStop(false);
		labelDoc_trait_3.setText(" Médecin_3");
		labelDoc_trait_3.setVisible(false);
		labelDoc_trait_3.setBorderStyle(BorderStyle.FIXED_3D);

		editDoc_trait_3.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editDoc_trait_3.setEnabled(false);
		editDoc_trait_3.setLocation(new Point(429, 248));
		editDoc_trait_3.setSize(new Point(144, 20));
		editDoc_trait_3.setTabIndex(24);
		editDoc_trait_3.setText("");
		editDoc_trait_3.setVisible(false);
		editDoc_trait_3.setMaxLength(50);
		editDoc_trait_3.setMultiline(true);

		ltit2.setBackColor(Color.CONTROL);
		ltit2.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		ltit2.setLocation(new Point(19, 291));
		ltit2.setSize(new Point(176, 20));
		ltit2.setTabIndex(15);
		ltit2.setTabStop(false);
		ltit2.setText("NIF du 2e Titulaire");
		ltit2.setVisible(false);
		ltit2.setBorderStyle(BorderStyle.FIXED_3D);

		tit2.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		tit2.setLocation(new Point(197, 290));
		tit2.setSize(new Point(104, 20));
		tit2.setTabIndex(27);
		tit2.setText("");
		tit2.setVisible(false);
		tit2.setMultiline(true);
		tit2.setReadOnly(true);

		labelDate_exeat.setBackColor(Color.CONTROL);
		labelDate_exeat.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelDate_exeat.setLocation(new Point(20, 336));
		labelDate_exeat.setSize(new Point(176, 20));
		labelDate_exeat.setTabIndex(28);
		labelDate_exeat.setTabStop(false);
		labelDate_exeat.setText(" Date d\'Exeat");
		labelDate_exeat.setVisible(false);
		labelDate_exeat.setBorderStyle(BorderStyle.FIXED_3D);

		editDate_exeat.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editDate_exeat.setEnabled(false);
		editDate_exeat.setLocation(new Point(199, 336));
		editDate_exeat.setSize(new Point(94, 20));
		editDate_exeat.setTabIndex(29);
		editDate_exeat.setText("");
		editDate_exeat.setVisible(false);
		editDate_exeat.setMultiline(true);

		labelCredit_patient.setBackColor(Color.CONTROL);
		labelCredit_patient.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelCredit_patient.setLocation(new Point(339, 288));
		labelCredit_patient.setSize(new Point(104, 20));
		labelCredit_patient.setTabIndex(30);
		labelCredit_patient.setTabStop(false);
		labelCredit_patient.setText("Crédit du Patient");
		labelCredit_patient.setVisible(false);
		labelCredit_patient.setBorderStyle(BorderStyle.FIXED_3D);

		editCredit_patient.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editCredit_patient.setEnabled(false);
		editCredit_patient.setLocation(new Point(472, 288));
		editCredit_patient.setSize(new Point(94, 20));
		editCredit_patient.setTabIndex(31);
		editCredit_patient.setText("");
		editCredit_patient.setVisible(false);
		editCredit_patient.setMultiline(true);

		label1.setLocation(new Point(75, 121));
		label1.setSize(new Point(456, 8));
		label1.setTabIndex(21);
		label1.setTabStop(false);
		label1.setText("");

		label3.setBackColor(Color.AQUA);
		label3.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, true, false, false, CharacterSet.DEFAULT, 0));
		label3.setForeColor(new Color(255, 255, 192));
		label3.setLocation(new Point(199, 320));
		label3.setSize(new Point(86, 16));
		label3.setTabIndex(7);
		label3.setTabStop(false);
		label3.setText("JJ / MM / AA");
		label3.setVisible(false);
		label3.setBorderStyle(BorderStyle.FIXED_3D);

		label2.setBackColor(Color.AQUA);
		label2.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, true, false, false, CharacterSet.DEFAULT, 0));
		label2.setForeColor(new Color(255, 255, 192));
		label2.setLocation(new Point(197, 183));
		label2.setSize(new Point(86, 16));
		label2.setTabIndex(6);
		label2.setTabStop(false);
		label2.setText("JJ / MM / AA");
		label2.setVisible(false);
		label2.setBorderStyle(BorderStyle.FIXED_3D);

		labelNo_Avis.setBackColor(new Color(255, 255, 192));
		labelNo_Avis.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNo_Avis.setForeColor(Color.BLACK);
		labelNo_Avis.setLocation(new Point(81, 139));
		labelNo_Avis.setSize(new Point(144, 20));
		labelNo_Avis.setTabIndex(9);
		labelNo_Avis.setTabStop(false);
		labelNo_Avis.setText("Le No de l\'Admission");
		labelNo_Avis.setBorderStyle(BorderStyle.FIXED_3D);
		labelNo_Avis.setTextAlign(HorizontalAlignment.CENTER);

		pictureBox6.setLocation(new Point(13, 47));
		pictureBox6.setSize(new Point(88, 80));
		pictureBox6.setTabIndex(3);
		pictureBox6.setTabStop(false);
		pictureBox6.setText("pictureBox2");
		pictureBox6.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox6.setImage((Bitmap)resources.getObject("pictureBox6_image"));
		pictureBox6.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		label4.setBackColor(new Color(255, 255, 192));
		label4.setFont(new Font("Verdana", 14.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label4.setForeColor(Color.AQUA);
		label4.setLocation(new Point(138, 4));
		label4.setSize(new Point(328, 22));
		label4.setTabIndex(34);
		label4.setTabStop(false);
		label4.setText("Recherche   d\'une   Admission");
		label4.setBorderStyle(BorderStyle.FIXED_3D);
		label4.setTextAlign(HorizontalAlignment.CENTER);

		pictureBox1.setLocation(new Point(36, 34));
		pictureBox1.setSize(new Point(88, 80));
		pictureBox1.setTabIndex(26);
		pictureBox1.setTabStop(false);
		pictureBox1.setText("pictureBox1");
		pictureBox1.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox1.setImage((Bitmap)resources.getObject("pictureBox1_image"));
		pictureBox1.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		label5.setLocation(new Point(78, 123));
		label5.setSize(new Point(440, 0));
		label5.setTabIndex(35);
		label5.setTabStop(false);
		label5.setText("label5");

		pictureBox2.setLocation(new Point(13, 0));
		pictureBox2.setSize(new Point(568, 32));
		pictureBox2.setTabIndex(2);
		pictureBox2.setTabStop(false);
		pictureBox2.setText("pictureBox2");
		pictureBox2.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox2.setImage((Bitmap)resources.getObject("pictureBox2_image"));
		pictureBox2.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox3.setLocation(new Point(15, 383));
		pictureBox3.setSize(new Point(560, 32));
		pictureBox3.setTabIndex(4);
		pictureBox3.setTabStop(false);
		pictureBox3.setText("pictureBox2");
		pictureBox3.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox3.setImage((Bitmap)resources.getObject("pictureBox3_image"));
		pictureBox3.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		button1.setBackColor(Color.AQUA);
		button1.setLocation(new Point(328, 136));
		button1.setSize(new Point(30, 32));
		button1.setTabIndex(36);
		button1.setTabStop(false);
		button1.setText("pictureBox3");
		button1.setBorderStyle(BorderStyle.FIXED_3D);
		button1.setImage((Icon)resources.getObject("button1_image"));
		button1.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);
		button1.addOnClick(new EventHandler(this.button1_click));

		button2.setBackColor(Color.AQUA);
		button2.setLocation(new Point(376, 136));
		button2.setSize(new Point(30, 32));
		button2.setTabIndex(0);
		button2.setTabStop(false);
		button2.setText("pictureBox3");
		button2.setBorderStyle(BorderStyle.FIXED_3D);
		button2.setImage((Icon)resources.getObject("button2_image"));
		button2.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);
		button2.addOnClick(new EventHandler(this.button2_click));

		button3.setBackColor(Color.AQUA);
		button3.setLocation(new Point(424, 136));
		button3.setSize(new Point(30, 32));
		button3.setTabIndex(1);
		button3.setTabStop(false);
		button3.setText("pictureBox3");
		button3.setBorderStyle(BorderStyle.FIXED_3D);
		button3.setImage((Icon)resources.getObject("button3_image"));
		button3.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);
		button3.addOnClick(new EventHandler(this.button3_click));

		this.setNewControls(new Control[] {
							ltit2, 
							button3, 
							button2, 
							button1, 
							pictureBox3, 
							label5, 
							pictureBox1, 
							pictureBox6, 
							label4, 
							panel1, 
							label2, 
							label3, 
							editNo_admi, 
							label1, 
							labelNo_Avis, 
							labelDate, 
							editDate, 
							labelRef_dossier, 
							editRef_dossier, 
							labelChambre, 
							editChambre, 
							labelRef_titul, 
							editRef_titul, 
							labelDoc_trait_1, 
							editDoc_trait_1, 
							labelDoc_trait_2, 
							editDoc_trait_2, 
							labelDoc_trait_3, 
							editDoc_trait_3, 
							tit2, 
							labelDate_exeat, 
							editDate_exeat, 
							labelCredit_patient, 
							editCredit_patient, 
							group, 
							groupBox1, 
							pictureBox2});
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
        Application.run( new Rech_Admi() );
    }
}
