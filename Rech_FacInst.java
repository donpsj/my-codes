import com.ms.wfc.app.*;
import com.ms.wfc.core.*;
import com.ms.wfc.ui.*;
import com.ms.wfc.data.*;
import com.ms.wfc.data.ui.*;

/**
 * This class can take a variable number of parameters on the command
 * line. Program execution begins with the main() method. The class
 * constructor is not invoked unless an object of type 'Rech_FacInst'
 * created in the main() method.
 */
public class Rech_FacInst extends Form
{
	public Rech_FacInst()
	{
		super();

		// Required for Visual J++ Form Designer support
		initForm();		

		// TODO: Add any constructor code after initForm call
		
		      editNo_facture.setText("0");
			  editRef_admi.setText("0");
			  editRef_comp.setText("");
			  editPoupo.setText("0.00"); 
			  editAmbu.setText("0.00"); 
			  editRed_x.setText("0.00");  
			  editHonor_1.setText("0.00");  
			  
			  editDivers.setText("0.00"); 
			  editChamb.setText("0.00"); 
			  editPharm.setText("0.00"); 
			  editLabo.setText("0.00");  
			  editSop.setText("0.00");  
			  editX_ray.setText("0.00");  
			  editDeliv.setText("0.00"); 
			  editOxyg.setText("0.00"); 
			  editSalle_urg.setText("0.00");  
			  editEkg.setText("0.00"); 
			 sono.setText("0.00");  
			  edit1.setText("");
			  editCharge_tot.setText("0.00"); 
	}

	/**
	 * Rech_FacInst overrides dispose so it can clean up the
	 * component list.
	 */
	public void dispose()
	{
		super.dispose();
		components.dispose();
	}

	private void button1_click(Object source, Event e)
	{   DataSource fin = new DataSource();
		DataBinder display = new DataBinder();
			
  try{
		int nfac = (Integer.valueOf(editNo_facture.getText()).intValue());
		
		if(editNo_facture.getText().equals("0"))
		{MessageBox.show("Veuillez Entrer le Numéro de la Facture à Rechercher S.V.P !","Champ de Recheche à Remplir ",MessageBox.ICONERROR);
		 }
		else
		{   
		    fin.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		    fin.setCommandText("select * from Fac_Inst where No_facture = "+editNo_facture.getText()+"");			  			
            fin.begin();
			
			if(String.valueOf(fin.getRecordset().getRecordCount()).equals("0"))
			   {MessageBox.show("Désolé, La Facture Numéro << "+editNo_facture.getText()+" >> est Introuvable !", " Recherche Echouée ",MessageBox.ICONSTOP);
		     	 editNo_facture.setText("0");
			    }
			else
			{     
				  display.setDataSource(fin);
				  display.setBindings(new DataBinding[]{
									 
							    new DataBinding(editRef_admi,"text","Ref_Serv"),
							    new DataBinding(editRef_comp,"text","Ref_Inst"),
							    new DataBinding(editChamb,"text","Chamb"),
							    new DataBinding(editPharm,"text","Pharm"),
								new DataBinding(editLabo,"text","Labo"),
									  
								new DataBinding(editSop,"text","Sop"),
								new DataBinding(editX_ray,"text","X_ray"),	
								new DataBinding(editDeliv,"text","Deliv"),
								new DataBinding(editOxyg,"text","Oxyg"),	
								new DataBinding(editSalle_urg,"text","Salle_urg"),
								new DataBinding(editEkg,"text","Ekg"),
							    new DataBinding(editPoupo,"text","Poupo"),
								new DataBinding(editAmbu,"text","ambu"),
								new DataBinding(editRed_x,"text","Red_x"),
								new DataBinding(editHonor_1,"text","Honor_1"),
							    new DataBinding(sono,"text","Sonogra"),
								new DataBinding(editDivers,"text","Divers"),
								new DataBinding(editCharge_tot,"text","Charge_tot"),
							    new DataBinding(edit1,"text","Paye"),
													 				  
									  });
	                  }
		           }
                }
  
           catch(NumberFormatException k){
		   MessageBox.show("Le Champ < Numéro de la Facture> est de Type Numérique, Entrez le Numéro à Nouveau S.V.P  !","Données Incompatibles",MessageBox.ICONERROR);
		   editNo_facture.setText("0");
		  }	

	}

	private void button2_click(Object source, Event e)
	{
		      editNo_facture.setText("0");
			  editRef_admi.setText("0");
			  editRef_comp.setText("");
			  editPoupo.setText("0.00"); 
			  editAmbu.setText("0.00"); 
			  editRed_x.setText("0.00");  
			  editHonor_1.setText("0.00");  
			  
			  editDivers.setText("0.00"); 
			  editChamb.setText("0.00"); 
			  editPharm.setText("0.00"); 
			  editLabo.setText("0.00");  
			  editSop.setText("0.00");  
			  editX_ray.setText("0.00");  
			  editDeliv.setText("0.00"); 
			  editOxyg.setText("0.00"); 
			  editSalle_urg.setText("0.00");  
			  editEkg.setText("0.00");
			  sono.setText("0.00");  
			  edit1.setText("");
			  editCharge_tot.setText("0.00"); 
	}

	private void button3_click(Object source, Event e)
	{
		int choi;
		choi=MessageBox.show("Etes-vous sur de vouloir abandonner l'opération?", "Abandon",MessageBox.YESNO);
	    if(choi==MessageBox.IDYES)   
		{ hide();
		}
	}

	



	

	/**
	 * NOTE: The following code is required by the Visual J++ form
	 * designer.  It can be modified using the form editor.  Do not
	 * modify it using the code editor.
	 */
	Container components = new Container();
	Panel panel3 = new Panel();
	Edit edit4 = new Edit();
	Label label1 = new Label();
	Edit editNo_facture = new Edit();
	PictureBox pictureBox5 = new PictureBox();
	Label labelNo_facture = new Label();
	PictureBox button2 = new PictureBox();
	Label labelNo_admi = new Label();
	Edit editRef_admi = new Edit();
	Label labelRef_comp = new Label();
	Edit editRef_comp = new Edit();
	Label labelChamb = new Label();
	Edit editChamb = new Edit();
	Label labelPharm = new Label();
	Edit editPharm = new Edit();
	Label labelLabo = new Label();
	Edit editLabo = new Edit();
	Label labelSop = new Label();
	Edit editSop = new Edit();
	Label labelX_ray = new Label();
	Edit editX_ray = new Edit();
	Label labelDeliv = new Label();
	Edit editDeliv = new Edit();
	Label labelOxyg = new Label();
	Edit editOxyg = new Edit();
	Label labelSalle_urg = new Label();
	Edit editSalle_urg = new Edit();
	Label labelEkg = new Label();
	Edit editEkg = new Edit();
	Label labelPoupo = new Label();
	Edit editPoupo = new Edit();
	Label labelAmbu = new Label();
	Label labelRed_x = new Label();
	Edit editAmbu = new Edit();
	Label labelHonor_1 = new Label();
	Edit editRed_x = new Edit();
	Label labelDivers = new Label();
	Edit editHonor_1 = new Edit();
	Label labelCharge_tot = new Label();
	Edit editCharge_tot = new Edit();
	Edit editDivers = new Edit();
	PictureBox button3 = new PictureBox();
	Edit edit1 = new Edit();
	PictureBox pictureBox6 = new PictureBox();
	Label label2 = new Label();
	Panel panel1 = new Panel();
	GroupBox groupBox3 = new GroupBox();
	PictureBox pictureBox1 = new PictureBox();
	PictureBox pictureBox2 = new PictureBox();
	PictureBox button1 = new PictureBox();
	PictureBox pictureBox4 = new PictureBox();
	Label label4 = new Label();
	Edit sono = new Edit();
	PictureBox pictureBox7 = new PictureBox();

	private void initForm()
	{
		// REMARQUE : cette feuille stocke des informations sur les ressources
		// dans un fichier externe. Ne modifiez le paramètre de chaîne d'aucun
		// appel de fonction resources.getObject(). Par exemple,
		// ne modifiez pas "foo1_location" dans la ligne de code
		// suivante, même si le nom de l'objet Foo change : 
		//	 foo1.setLocation((Point)resources.getObject("foo1_location"));

		IResourceManager resources = new ResourceManager(this, "Rech_FacInst");
		this.setText("Recherche  d\'une  Facture");
		this.setAutoScaleBaseSize(new Point(5, 13));
		this.setBorderStyle(FormBorderStyle.NONE);
		this.setClientSize(new Point(601, 423));
		this.setMaximizeBox(false);
		this.setStartPosition(FormStartPosition.CENTER_SCREEN);

		panel3.setBackColor(Color.ACTIVEBORDER);
		panel3.setLocation(new Point(8, 136));
		panel3.setSize(new Point(584, 248));
		panel3.setTabIndex(3);
		panel3.setText("panel3");
		panel3.setBorderStyle(BorderStyle.FIXED_3D);

		edit4.setLocation(new Point(128, 112));
		edit4.setSize(new Point(56, 20));
		edit4.setTabIndex(0);
		edit4.setText("edit4");
		edit4.setVisible(false);

		label1.setBackColor(Color.CONTROL);
		label1.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label1.setForeColor(new Color(128, 0, 0));
		label1.setLocation(new Point(41, 351));
		label1.setSize(new Point(64, 20));
		label1.setTabIndex(43);
		label1.setTabStop(false);
		label1.setText(" Payée");
		label1.setBorderStyle(BorderStyle.FIXED_3D);

		editNo_facture.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNo_facture.setLocation(new Point(21, 185));
		editNo_facture.setSize(new Point(105, 20));
		editNo_facture.setTabIndex(6);
		editNo_facture.setText("27");
		editNo_facture.setMaxLength(10);

		pictureBox5.setLocation(new Point(387, 150));
		pictureBox5.setSize(new Point(12, 214));
		pictureBox5.setTabIndex(5);
		pictureBox5.setTabStop(false);
		pictureBox5.setText("pictureBox2");
		pictureBox5.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox5.setImage((Bitmap)resources.getObject("pictureBox5_image"));
		pictureBox5.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		labelNo_facture.setBackColor(Color.AQUA);
		labelNo_facture.setFont(new Font("MS Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNo_facture.setForeColor(Color.WHITE);
		labelNo_facture.setLocation(new Point(22, 154));
		labelNo_facture.setSize(new Point(168, 20));
		labelNo_facture.setTabIndex(4);
		labelNo_facture.setTabStop(false);
		labelNo_facture.setText("No de la Facture à Rechercher");
		labelNo_facture.setBorderStyle(BorderStyle.FIXED_3D);

		button2.setBackColor(Color.AQUA);
		button2.setLocation(new Point(22, 215));
		button2.setSize(new Point(40, 40));
		button2.setTabIndex(0);
		button2.setTabStop(false);
		button2.setText("pictureBox3");
		button2.setBorderStyle(BorderStyle.FIXED_3D);
		button2.setImage((Icon)resources.getObject("button2_image"));
		button2.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);
		button2.addOnClick(new EventHandler(this.button2_click));

		labelNo_admi.setBackColor(Color.CONTROL);
		labelNo_admi.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNo_admi.setLocation(new Point(22, 280));
		labelNo_admi.setSize(new Point(80, 20));
		labelNo_admi.setTabIndex(9);
		labelNo_admi.setTabStop(false);
		labelNo_admi.setText("No Service");
		labelNo_admi.setBorderStyle(BorderStyle.FIXED_3D);

		editRef_admi.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRef_admi.setLocation(new Point(103, 280));
		editRef_admi.setSize(new Point(88, 20));
		editRef_admi.setTabIndex(10);
		editRef_admi.setText("10");
		editRef_admi.setMultiline(true);
		editRef_admi.setReadOnly(true);

		labelRef_comp.setBackColor(Color.CONTROL);
		labelRef_comp.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelRef_comp.setLocation(new Point(22, 304));
		labelRef_comp.setSize(new Point(168, 20));
		labelRef_comp.setTabIndex(11);
		labelRef_comp.setTabStop(false);
		labelRef_comp.setText("Nom de l\'Institution");
		labelRef_comp.setVisible(false);
		labelRef_comp.setBorderStyle(BorderStyle.FIXED_3D);
		labelRef_comp.setTextAlign(HorizontalAlignment.CENTER);

		editRef_comp.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRef_comp.setLocation(new Point(23, 328));
		editRef_comp.setSize(new Point(168, 20));
		editRef_comp.setTabIndex(12);
		editRef_comp.setText("INASSA");
		editRef_comp.setCharacterCasing(CharacterCasing.UPPER);
		editRef_comp.setMaxLength(50);
		editRef_comp.setReadOnly(true);

		labelChamb.setBackColor(Color.CONTROL);
		labelChamb.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelChamb.setLocation(new Point(209, 152));
		labelChamb.setSize(new Point(85, 20));
		labelChamb.setTabIndex(13);
		labelChamb.setTabStop(false);
		labelChamb.setText(" Chambre");
		labelChamb.setBorderStyle(BorderStyle.FIXED_3D);

		editChamb.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editChamb.setEnabled(false);
		editChamb.setLocation(new Point(297, 152));
		editChamb.setSize(new Point(88, 20));
		editChamb.setTabIndex(15);
		editChamb.setText("2500");
		editChamb.setTextAlign(HorizontalAlignment.RIGHT);

		labelPharm.setBackColor(Color.CONTROL);
		labelPharm.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelPharm.setLocation(new Point(209, 176));
		labelPharm.setSize(new Point(85, 20));
		labelPharm.setTabIndex(16);
		labelPharm.setTabStop(false);
		labelPharm.setText(" Pharmacie");
		labelPharm.setBorderStyle(BorderStyle.FIXED_3D);

		editPharm.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editPharm.setEnabled(false);
		editPharm.setLocation(new Point(297, 176));
		editPharm.setSize(new Point(88, 20));
		editPharm.setTabIndex(17);
		editPharm.setText("500");
		editPharm.setTextAlign(HorizontalAlignment.RIGHT);

		labelLabo.setBackColor(Color.CONTROL);
		labelLabo.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelLabo.setLocation(new Point(209, 200));
		labelLabo.setSize(new Point(85, 20));
		labelLabo.setTabIndex(18);
		labelLabo.setTabStop(false);
		labelLabo.setText(" Laboratoire");
		labelLabo.setBorderStyle(BorderStyle.FIXED_3D);

		editLabo.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editLabo.setEnabled(false);
		editLabo.setLocation(new Point(297, 200));
		editLabo.setSize(new Point(88, 20));
		editLabo.setTabIndex(19);
		editLabo.setText("0");
		editLabo.setTextAlign(HorizontalAlignment.RIGHT);

		labelSop.setBackColor(Color.CONTROL);
		labelSop.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelSop.setLocation(new Point(209, 224));
		labelSop.setSize(new Point(85, 20));
		labelSop.setTabIndex(20);
		labelSop.setTabStop(false);
		labelSop.setText("Sop");
		labelSop.setBorderStyle(BorderStyle.FIXED_3D);

		editSop.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editSop.setEnabled(false);
		editSop.setLocation(new Point(297, 224));
		editSop.setSize(new Point(88, 20));
		editSop.setTabIndex(21);
		editSop.setText("0");
		editSop.setTextAlign(HorizontalAlignment.RIGHT);

		labelX_ray.setBackColor(Color.CONTROL);
		labelX_ray.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelX_ray.setLocation(new Point(209, 248));
		labelX_ray.setSize(new Point(85, 20));
		labelX_ray.setTabIndex(22);
		labelX_ray.setTabStop(false);
		labelX_ray.setText("X_ray");
		labelX_ray.setBorderStyle(BorderStyle.FIXED_3D);

		editX_ray.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editX_ray.setEnabled(false);
		editX_ray.setLocation(new Point(297, 248));
		editX_ray.setSize(new Point(88, 20));
		editX_ray.setTabIndex(23);
		editX_ray.setText("0");
		editX_ray.setTextAlign(HorizontalAlignment.RIGHT);

		labelDeliv.setBackColor(Color.CONTROL);
		labelDeliv.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelDeliv.setLocation(new Point(209, 272));
		labelDeliv.setSize(new Point(85, 20));
		labelDeliv.setTabIndex(24);
		labelDeliv.setTabStop(false);
		labelDeliv.setText("Delivery");
		labelDeliv.setBorderStyle(BorderStyle.FIXED_3D);

		editDeliv.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editDeliv.setEnabled(false);
		editDeliv.setLocation(new Point(297, 272));
		editDeliv.setSize(new Point(88, 20));
		editDeliv.setTabIndex(25);
		editDeliv.setText("0");
		editDeliv.setTextAlign(HorizontalAlignment.RIGHT);

		labelOxyg.setBackColor(Color.CONTROL);
		labelOxyg.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelOxyg.setLocation(new Point(209, 296));
		labelOxyg.setSize(new Point(85, 20));
		labelOxyg.setTabIndex(26);
		labelOxyg.setTabStop(false);
		labelOxyg.setText("Oxygène");
		labelOxyg.setBorderStyle(BorderStyle.FIXED_3D);

		editOxyg.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editOxyg.setEnabled(false);
		editOxyg.setLocation(new Point(297, 296));
		editOxyg.setSize(new Point(88, 20));
		editOxyg.setTabIndex(27);
		editOxyg.setText("0");
		editOxyg.setTextAlign(HorizontalAlignment.RIGHT);

		labelSalle_urg.setBackColor(Color.CONTROL);
		labelSalle_urg.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelSalle_urg.setLocation(new Point(209, 320));
		labelSalle_urg.setSize(new Point(85, 20));
		labelSalle_urg.setTabIndex(28);
		labelSalle_urg.setTabStop(false);
		labelSalle_urg.setText("Salle_urgence");
		labelSalle_urg.setBorderStyle(BorderStyle.FIXED_3D);

		editSalle_urg.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editSalle_urg.setEnabled(false);
		editSalle_urg.setLocation(new Point(297, 320));
		editSalle_urg.setSize(new Point(88, 20));
		editSalle_urg.setTabIndex(30);
		editSalle_urg.setText("0");
		editSalle_urg.setTextAlign(HorizontalAlignment.RIGHT);

		labelEkg.setBackColor(Color.CONTROL);
		labelEkg.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelEkg.setLocation(new Point(209, 344));
		labelEkg.setSize(new Point(85, 20));
		labelEkg.setTabIndex(31);
		labelEkg.setTabStop(false);
		labelEkg.setText("Ekg");
		labelEkg.setBorderStyle(BorderStyle.FIXED_3D);

		editEkg.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editEkg.setEnabled(false);
		editEkg.setLocation(new Point(297, 344));
		editEkg.setSize(new Point(88, 20));
		editEkg.setTabIndex(32);
		editEkg.setText("0");
		editEkg.setTextAlign(HorizontalAlignment.RIGHT);

		labelPoupo.setBackColor(Color.CONTROL);
		labelPoupo.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelPoupo.setLocation(new Point(401, 152));
		labelPoupo.setSize(new Point(85, 20));
		labelPoupo.setTabIndex(33);
		labelPoupo.setTabStop(false);
		labelPoupo.setText(" Pouponière");
		labelPoupo.setBorderStyle(BorderStyle.FIXED_3D);

		editPoupo.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editPoupo.setEnabled(false);
		editPoupo.setLocation(new Point(489, 152));
		editPoupo.setSize(new Point(93, 20));
		editPoupo.setTabIndex(34);
		editPoupo.setText("");
		editPoupo.setTextAlign(HorizontalAlignment.RIGHT);

		labelAmbu.setBackColor(Color.CONTROL);
		labelAmbu.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelAmbu.setLocation(new Point(401, 176));
		labelAmbu.setSize(new Point(85, 20));
		labelAmbu.setTabIndex(35);
		labelAmbu.setTabStop(false);
		labelAmbu.setText(" Ambulance");
		labelAmbu.setBorderStyle(BorderStyle.FIXED_3D);

		labelRed_x.setBackColor(Color.CONTROL);
		labelRed_x.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelRed_x.setLocation(new Point(401, 200));
		labelRed_x.setSize(new Point(85, 20));
		labelRed_x.setTabIndex(36);
		labelRed_x.setTabStop(false);
		labelRed_x.setText(" Red_x");
		labelRed_x.setBorderStyle(BorderStyle.FIXED_3D);

		editAmbu.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editAmbu.setEnabled(false);
		editAmbu.setLocation(new Point(489, 176));
		editAmbu.setSize(new Point(93, 20));
		editAmbu.setTabIndex(37);
		editAmbu.setText("");
		editAmbu.setTextAlign(HorizontalAlignment.RIGHT);

		labelHonor_1.setBackColor(Color.CONTROL);
		labelHonor_1.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelHonor_1.setLocation(new Point(401, 224));
		labelHonor_1.setSize(new Point(85, 20));
		labelHonor_1.setTabIndex(38);
		labelHonor_1.setTabStop(false);
		labelHonor_1.setText(" Honoraire");
		labelHonor_1.setBorderStyle(BorderStyle.FIXED_3D);

		editRed_x.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRed_x.setEnabled(false);
		editRed_x.setLocation(new Point(489, 200));
		editRed_x.setSize(new Point(93, 20));
		editRed_x.setTabIndex(39);
		editRed_x.setText("");
		editRed_x.setTextAlign(HorizontalAlignment.RIGHT);

		labelDivers.setBackColor(Color.CONTROL);
		labelDivers.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelDivers.setLocation(new Point(401, 248));
		labelDivers.setSize(new Point(85, 20));
		labelDivers.setTabIndex(41);
		labelDivers.setTabStop(false);
		labelDivers.setText(" Divers");
		labelDivers.setBorderStyle(BorderStyle.FIXED_3D);

		editHonor_1.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editHonor_1.setEnabled(false);
		editHonor_1.setLocation(new Point(489, 224));
		editHonor_1.setSize(new Point(93, 20));
		editHonor_1.setTabIndex(42);
		editHonor_1.setText("");
		editHonor_1.setTextAlign(HorizontalAlignment.RIGHT);

		labelCharge_tot.setBackColor(Color.CONTROL);
		labelCharge_tot.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelCharge_tot.setLocation(new Point(400, 344));
		labelCharge_tot.setSize(new Point(85, 20));
		labelCharge_tot.setTabIndex(44);
		labelCharge_tot.setTabStop(false);
		labelCharge_tot.setText("Charge Totale");
		labelCharge_tot.setBorderStyle(BorderStyle.FIXED_3D);

		editCharge_tot.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editCharge_tot.setEnabled(false);
		editCharge_tot.setLocation(new Point(489, 344));
		editCharge_tot.setSize(new Point(93, 20));
		editCharge_tot.setTabIndex(46);
		editCharge_tot.setText("4500");
		editCharge_tot.setTextAlign(HorizontalAlignment.RIGHT);

		editDivers.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editDivers.setEnabled(false);
		editDivers.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		editDivers.setLocation(new Point(489, 247));
		editDivers.setSize(new Point(93, 20));
		editDivers.setTabIndex(47);
		editDivers.setText("");
		editDivers.setTextAlign(HorizontalAlignment.RIGHT);

		button3.setBackColor(Color.AQUA);
		button3.setLocation(new Point(86, 215));
		button3.setSize(new Point(40, 40));
		button3.setTabIndex(1);
		button3.setTabStop(false);
		button3.setText("pictureBox3");
		button3.setBorderStyle(BorderStyle.FIXED_3D);
		button3.setImage((Icon)resources.getObject("button3_image"));
		button3.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);
		button3.addOnClick(new EventHandler(this.button3_click));

		edit1.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		edit1.setEnabled(false);
		edit1.setLocation(new Point(107, 351));
		edit1.setSize(new Point(56, 20));
		edit1.setTabIndex(45);
		edit1.setText("");
		edit1.setTextAlign(HorizontalAlignment.RIGHT);

		pictureBox6.setLocation(new Point(9, 46));
		pictureBox6.setSize(new Point(88, 80));
		pictureBox6.setTabIndex(8);
		pictureBox6.setTabStop(false);
		pictureBox6.setText("pictureBox2");
		pictureBox6.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox6.setImage((Bitmap)resources.getObject("pictureBox6_image"));
		pictureBox6.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		label2.setBackColor(new Color(255, 255, 192));
		label2.setFont(new Font("Verdana", 14.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label2.setForeColor(Color.AQUA);
		label2.setLocation(new Point(54, 3));
		label2.setSize(new Point(472, 24));
		label2.setTabIndex(48);
		label2.setTabStop(false);
		label2.setText("Recherche  d\'une  Facture d\'une Institution");
		label2.setBorderStyle(BorderStyle.FIXED_3D);
		label2.setTextAlign(HorizontalAlignment.CENTER);

		panel1.setBackColor(new Color(0, 192, 192));
		panel1.setLocation(new Point(7, 387));
		panel1.setSize(new Point(576, 32));
		panel1.setTabIndex(49);
		panel1.setText("panel1");
		panel1.setBorderStyle(BorderStyle.FIXED_3D);

		groupBox3.setLocation(new Point(16, 164));
		groupBox3.setSize(new Point(0, 32));
		groupBox3.setTabIndex(50);
		groupBox3.setTabStop(false);
		groupBox3.setText("groupBox3");

		pictureBox1.setLocation(new Point(32, 33));
		pictureBox1.setSize(new Point(88, 80));
		pictureBox1.setTabIndex(29);
		pictureBox1.setTabStop(false);
		pictureBox1.setText("pictureBox1");
		pictureBox1.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox1.setImage((Bitmap)resources.getObject("pictureBox1_image"));
		pictureBox1.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox2.setLocation(new Point(8, 0));
		pictureBox2.setSize(new Point(568, 32));
		pictureBox2.setTabIndex(7);
		pictureBox2.setTabStop(false);
		pictureBox2.setText("pictureBox2");
		pictureBox2.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox2.setImage((Bitmap)resources.getObject("pictureBox2_image"));
		pictureBox2.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		button1.setBackColor(Color.AQUA);
		button1.setLocation(new Point(142, 180));
		button1.setSize(new Point(40, 40));
		button1.setTabIndex(51);
		button1.setTabStop(false);
		button1.setText("pictureBox3");
		button1.setBorderStyle(BorderStyle.FIXED_3D);
		button1.setImage((Icon)resources.getObject("button1_image"));
		button1.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);
		button1.addOnClick(new EventHandler(this.button1_click));

		pictureBox4.setLocation(new Point(17, 2));
		pictureBox4.setSize(new Point(536, 24));
		pictureBox4.setTabIndex(0);
		pictureBox4.setTabStop(false);
		pictureBox4.setText("pictureBox4");
		pictureBox4.setImage((Bitmap)resources.getObject("pictureBox4_image"));
		pictureBox4.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		label4.setBackColor(Color.CONTROL);
		label4.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label4.setLocation(new Point(401, 272));
		label4.setSize(new Point(85, 20));
		label4.setTabIndex(40);
		label4.setTabStop(false);
		label4.setText(" Sonographie");
		label4.setBorderStyle(BorderStyle.FIXED_3D);

		sono.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		sono.setForeColor(Color.BLACK);
		sono.setLocation(new Point(489, 272));
		sono.setSize(new Point(93, 20));
		sono.setTabIndex(2);
		sono.setText("");
		sono.setTextAlign(HorizontalAlignment.RIGHT);

		pictureBox7.setLocation(new Point(16, 144));
		pictureBox7.setSize(new Point(576, 232));
		pictureBox7.setTabIndex(14);
		pictureBox7.setTabStop(false);
		pictureBox7.setText("pictureBox2");
		pictureBox7.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox7.setImage((Bitmap)resources.getObject("pictureBox7_image"));
		pictureBox7.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		this.setNewControls(new Control[] {
							button3, 
							button2, 
							sono, 
							label4, 
							pictureBox5, 
							button1, 
							pictureBox1, 
							pictureBox6, 
							editNo_facture, 
							groupBox3, 
							panel1, 
							label2, 
							edit1, 
							label1, 
							editDivers, 
							editCharge_tot, 
							labelCharge_tot, 
							editHonor_1, 
							labelDivers, 
							editRed_x, 
							labelHonor_1, 
							editAmbu, 
							labelRed_x, 
							labelAmbu, 
							editPoupo, 
							labelPoupo, 
							editEkg, 
							labelEkg, 
							editSalle_urg, 
							labelSalle_urg, 
							editOxyg, 
							labelOxyg, 
							editDeliv, 
							labelDeliv, 
							editX_ray, 
							labelX_ray, 
							editSop, 
							labelSop, 
							editLabo, 
							labelLabo, 
							editPharm, 
							labelPharm, 
							editChamb, 
							labelChamb, 
							editRef_comp, 
							labelRef_comp, 
							editRef_admi, 
							labelNo_admi, 
							labelNo_facture, 
							pictureBox2, 
							pictureBox7, 
							panel3});
		panel3.setNewControls(new Control[] {
							  edit4});
		panel1.setNewControls(new Control[] {
							  pictureBox4});
	}

	/**
	 * The main entry point for the application. 
	 *
	 * @param args Array of parameters passed to the application
	 * via the command line.
	 */
	public static void main(String args[])
	{
		Application.run(new Rech_FacInst());
	}
}
