import com.ms.wfc.app.*;
import com.ms.wfc.core.*;
import com.ms.wfc.ui.*;
import com.ms.wfc.data.*;
import com.ms.wfc.data.ui.*;
/**
 * This class can take a variable number of parameters on the command
 * line. Program execution begins with the main() method. The class
 * constructor is not invoked unless an object of type 'Rech_Services'
 * created in the main() method.
 */
public class Rech_Services extends Form
{   
	DataSource fi = new DataSource();
	DataBinder disp = new DataBinder();
	public Rech_Services()
	{
		super();

		// Required for Visual J++ Form Designer support
		initForm();		

		     editNom.setText("");
			 editNDos.setText("0");
			 editMedecin1.setText("");
			 editMedecin2.setText("");
			 editRef_Inst.setText("");
			 serv.setText("");
			 date1.setText("");
			 date2.setText("");
			 editNo.setText("0");
			 
		// TODO: Add any constructor code after initForm call
	}

	/**
	 * Rech_Services overrides dispose so it can clean up the
	 * component list.
	 */
	public void dispose()
	{
		super.dispose();
		components.dispose();
	}

	 

	private void Rech_click(Object source, Event e)
	{
					
     try{
		int nfac = (Integer.valueOf(editNo.getText()).intValue());
		
		if(editNo.getText().equals("0"))
		{MessageBox.show("Veuillez Entrer le Numéro du Service à Rechercher S.V.P !","Champ de Recheche à Remplir ",MessageBox.ICONERROR);
		 }
		else
		{   
		    fi.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		    fi.setCommandText("select * from Service where Nserv = "+editNo.getText()+"");			  			
            fi.begin();
			
			if(String.valueOf(fi.getRecordset().getRecordCount()).equals("0"))
			   {MessageBox.show("Désolé, Le Service Numéro << "+editNo.getText()+" >> est Introuvable !", " Recherche Echouée ",MessageBox.ICONSTOP);
		     	 editNo.setText("0");
			    }
			else
			{     
				  disp.setDataSource(fi);
				  disp.setBindings(new DataBinding[]{
									 
							    new DataBinding(date1,"text","date1"),
							    new DataBinding(date2,"text","date2"),
							    new DataBinding(serv,"text","Type"),
							    new DataBinding(editNom,"text","Nom"),
								new DataBinding(editNDos,"text","NDos"),
									  
								new DataBinding(editMedecin1,"text","Medecin1"),
								new DataBinding(editMedecin2,"text","Medecin2"),	
								new DataBinding(editRef_Inst,"text","Ref_Inst"),
								      
									  });
	                  }
		           }
                }
  
           catch(NumberFormatException k){
		   MessageBox.show("Le Champ < Numéro du Service >  est de Type Numérique, Entrez le Numéro à Nouveau S.V.P  !","Données Incompatibles",MessageBox.ICONERROR);
		   editNo.setText("0");
		  }	
		
	}

	private void Nouv_click(Object source, Event e)
	{
		     editNom.setText("");
			 editNDos.setText("0");
			 editMedecin1.setText("");
			 editMedecin2.setText("");
			 editRef_Inst.setText("");
			 serv.setText("");
			 date1.setText("");
			 date2.setText("");
			 editNo.setText("0");
	}

	private void Ferm_click(Object source, Event e)
	{
		int choi;
		choi=MessageBox.show("Etes-vous sur de vouloir Abandonner la Recherche?", "Abandon",MessageBox.YESNO);
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
	GroupBox groupBox1 = new GroupBox();
	Edit editRef_Inst = new Edit();
	Label labelRef_Inst = new Label();
	Label labelDate2 = new Label();
	Edit editMedecin2 = new Edit();
	Label labelMedecin2 = new Label();
	Edit editMedecin1 = new Edit();
	Label labelMedecin1 = new Label();
	Edit editNDos = new Edit();
	Label labelNDos = new Label();
	Edit editNom = new Edit();
	Label labelNom = new Label();
	Label labelType = new Label();
	Edit serv = new Edit();
	Label labelDate1 = new Label();
	Edit editNo = new Edit();
	PictureBox pictureBox2 = new PictureBox();
	Label label1 = new Label();
	PictureBox pictureBox6 = new PictureBox();
	PictureBox pictureBox1 = new PictureBox();
	Edit date1 = new Edit();
	Edit date2 = new Edit();
	PictureBox pictureBox4 = new PictureBox();
	Panel panel1 = new Panel();
	PictureBox pictureBox3 = new PictureBox();
	GroupBox groupBox2 = new GroupBox();
	Label labelNo_Avis = new Label();
	Label label2 = new Label();
	PictureBox Rech = new PictureBox();
	PictureBox Nouv = new PictureBox();
	PictureBox Ferm = new PictureBox();

	private void initForm()
	{
		// REMARQUE : cette feuille stocke des informations sur les ressources
		// dans un fichier externe. Ne modifiez le paramètre de chaîne d'aucun
		// appel de fonction resources.getObject(). Par exemple,
		// ne modifiez pas "foo1_location" dans la ligne de code
		// suivante, même si le nom de l'objet Foo change : 
		//	 foo1.setLocation((Point)resources.getObject("foo1_location"));

		IResourceManager resources = new ResourceManager(this, "Rech_Services");
		this.setText("Recherche d\'un Service");
		this.setAutoScaleBaseSize(new Point(5, 13));
		this.setBorderStyle(FormBorderStyle.NONE);
		this.setClientSize(new Point(536, 405));
		this.setStartPosition(FormStartPosition.CENTER_SCREEN);

		groupBox1.setLocation(new Point(11, 179));
		groupBox1.setSize(new Point(504, 144));
		groupBox1.setTabIndex(5);
		groupBox1.setTabStop(false);
		groupBox1.setText("");

		editRef_Inst.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRef_Inst.setLocation(new Point(347, 261));
		editRef_Inst.setSize(new Point(158, 20));
		editRef_Inst.setTabIndex(6);
		editRef_Inst.setText("");
		editRef_Inst.setCharacterCasing(CharacterCasing.UPPER);
		editRef_Inst.setMaxLength(50);
		editRef_Inst.setMultiline(true);
		editRef_Inst.setReadOnly(true);

		labelRef_Inst.setBackColor(Color.CONTROL);
		labelRef_Inst.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelRef_Inst.setLocation(new Point(263, 261));
		labelRef_Inst.setSize(new Point(80, 20));
		labelRef_Inst.setTabIndex(7);
		labelRef_Inst.setTabStop(false);
		labelRef_Inst.setText("Institution");
		labelRef_Inst.setBorderStyle(BorderStyle.FIXED_3D);

		labelDate2.setBackColor(Color.CONTROL);
		labelDate2.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelDate2.setLocation(new Point(19, 214));
		labelDate2.setSize(new Point(96, 20));
		labelDate2.setTabIndex(10);
		labelDate2.setTabStop(false);
		labelDate2.setText("Date Sortie");
		labelDate2.setBorderStyle(BorderStyle.FIXED_3D);

		editMedecin2.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editMedecin2.setLocation(new Point(346, 233));
		editMedecin2.setSize(new Point(158, 20));
		editMedecin2.setTabIndex(13);
		editMedecin2.setText("");
		editMedecin2.setMaxLength(50);
		editMedecin2.setMultiline(true);
		editMedecin2.setReadOnly(true);

		labelMedecin2.setBackColor(Color.CONTROL);
		labelMedecin2.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelMedecin2.setLocation(new Point(262, 232));
		labelMedecin2.setSize(new Point(80, 20));
		labelMedecin2.setTabIndex(16);
		labelMedecin2.setTabStop(false);
		labelMedecin2.setText("Medecin2");
		labelMedecin2.setBorderStyle(BorderStyle.FIXED_3D);

		editMedecin1.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editMedecin1.setLocation(new Point(346, 209));
		editMedecin1.setSize(new Point(158, 20));
		editMedecin1.setTabIndex(14);
		editMedecin1.setText("");
		editMedecin1.setMaxLength(50);
		editMedecin1.setMultiline(true);
		editMedecin1.setReadOnly(true);

		labelMedecin1.setBackColor(Color.CONTROL);
		labelMedecin1.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelMedecin1.setLocation(new Point(262, 208));
		labelMedecin1.setSize(new Point(80, 20));
		labelMedecin1.setTabIndex(17);
		labelMedecin1.setTabStop(false);
		labelMedecin1.setText("Medecin1");
		labelMedecin1.setBorderStyle(BorderStyle.FIXED_3D);

		editNDos.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNDos.setLocation(new Point(118, 297));
		editNDos.setSize(new Point(126, 20));
		editNDos.setTabIndex(12);
		editNDos.setText("");
		editNDos.setMultiline(true);
		editNDos.setReadOnly(true);

		labelNDos.setBackColor(Color.CONTROL);
		labelNDos.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNDos.setLocation(new Point(19, 297));
		labelNDos.setSize(new Point(96, 20));
		labelNDos.setTabIndex(18);
		labelNDos.setTabStop(false);
		labelNDos.setText("No de Dossier");
		labelNDos.setBorderStyle(BorderStyle.FIXED_3D);

		editNom.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNom.setLocation(new Point(118, 273));
		editNom.setSize(new Point(126, 20));
		editNom.setTabIndex(8);
		editNom.setText("");
		editNom.setMaxLength(50);
		editNom.setMultiline(true);
		editNom.setReadOnly(true);

		labelNom.setBackColor(Color.CONTROL);
		labelNom.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNom.setLocation(new Point(19, 273));
		labelNom.setSize(new Point(96, 20));
		labelNom.setTabIndex(19);
		labelNom.setTabStop(false);
		labelNom.setText("Nom et Prénom");
		labelNom.setBorderStyle(BorderStyle.FIXED_3D);

		labelType.setBackColor(Color.CONTROL);
		labelType.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelType.setLocation(new Point(19, 249));
		labelType.setSize(new Point(96, 20));
		labelType.setTabIndex(20);
		labelType.setTabStop(false);
		labelType.setText("Type Service");
		labelType.setBorderStyle(BorderStyle.FIXED_3D);

		serv.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		serv.setLocation(new Point(117, 249));
		serv.setSize(new Point(126, 20));
		serv.setTabIndex(24);
		serv.setText("");
		serv.setMultiline(true);
		serv.setReadOnly(true);

		labelDate1.setBackColor(Color.CONTROL);
		labelDate1.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelDate1.setLocation(new Point(19, 190));
		labelDate1.setSize(new Point(96, 20));
		labelDate1.setTabIndex(22);
		labelDate1.setTabStop(false);
		labelDate1.setText("Date Service");
		labelDate1.setBorderStyle(BorderStyle.FIXED_3D);

		editNo.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNo.setLocation(new Point(166, 149));
		editNo.setSize(new Point(94, 20));
		editNo.setTabIndex(3);
		editNo.setText("");
		editNo.setMaxLength(10);

		pictureBox2.setLocation(new Point(74, 2));
		pictureBox2.setSize(new Point(392, 32));
		pictureBox2.setTabIndex(2);
		pictureBox2.setTabStop(false);
		pictureBox2.setText("pictureBox2");
		pictureBox2.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox2.setImage((Bitmap)resources.getObject("pictureBox2_image"));
		pictureBox2.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		label1.setBackColor(new Color(255, 255, 192));
		label1.setFont(new Font("Verdana", 14.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label1.setForeColor(Color.AQUA);
		label1.setLocation(new Point(138, 5));
		label1.setSize(new Point(248, 24));
		label1.setTabIndex(25);
		label1.setTabStop(false);
		label1.setText("Recherche d\'un Service");
		label1.setBorderStyle(BorderStyle.FIXED_3D);
		label1.setTextAlign(HorizontalAlignment.CENTER);

		pictureBox6.setLocation(new Point(13, 50));
		pictureBox6.setSize(new Point(88, 80));
		pictureBox6.setTabIndex(26);
		pictureBox6.setTabStop(false);
		pictureBox6.setText("pictureBox2");
		pictureBox6.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox6.setImage((Bitmap)resources.getObject("pictureBox6_image"));
		pictureBox6.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox1.setLocation(new Point(31, 35));
		pictureBox1.setSize(new Point(88, 80));
		pictureBox1.setTabIndex(27);
		pictureBox1.setTabStop(false);
		pictureBox1.setText("pictureBox1");
		pictureBox1.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox1.setImage((Bitmap)resources.getObject("pictureBox1_image"));
		pictureBox1.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		date1.setLocation(new Point(117, 190));
		date1.setSize(new Point(119, 20));
		date1.setTabIndex(4);
		date1.setText("");
		date1.setMaxLength(2);
		date1.setReadOnly(true);

		date2.setLocation(new Point(117, 214));
		date2.setSize(new Point(119, 20));
		date2.setTabIndex(9);
		date2.setText("");
		date2.setMaxLength(2);
		date2.setReadOnly(true);

		pictureBox4.setLocation(new Point(242, 186));
		pictureBox4.setSize(new Point(16, 136));
		pictureBox4.setTabIndex(15);
		pictureBox4.setTabStop(false);
		pictureBox4.setText("pictureBox2");
		pictureBox4.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox4.setImage((Bitmap)resources.getObject("pictureBox4_image"));
		pictureBox4.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		panel1.setBackColor(new Color(0, 192, 192));
		panel1.setLocation(new Point(12, 332));
		panel1.setSize(new Point(502, 38));
		panel1.setTabIndex(21);
		panel1.setText("panel1");
		panel1.setBorderStyle(BorderStyle.FIXED_3D);

		pictureBox3.setLocation(new Point(27, 2));
		pictureBox3.setSize(new Point(440, 30));
		pictureBox3.setTabIndex(0);
		pictureBox3.setTabStop(false);
		pictureBox3.setText("pictureBox4");
		pictureBox3.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox3.setImage((Bitmap)resources.getObject("pictureBox3_image"));
		pictureBox3.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		groupBox2.setBackColor(new Color(0, 192, 192));
		groupBox2.setLocation(new Point(10, 133));
		groupBox2.setSize(new Point(504, 48));
		groupBox2.setTabIndex(28);
		groupBox2.setTabStop(false);
		groupBox2.setText("");

		labelNo_Avis.setBackColor(new Color(255, 255, 192));
		labelNo_Avis.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNo_Avis.setForeColor(Color.BLACK);
		labelNo_Avis.setLocation(new Point(16, 149));
		labelNo_Avis.setSize(new Point(144, 20));
		labelNo_Avis.setTabIndex(11);
		labelNo_Avis.setTabStop(false);
		labelNo_Avis.setText("Le No du Service");
		labelNo_Avis.setBorderStyle(BorderStyle.FIXED_3D);

		label2.setLocation(new Point(4, 131));
		label2.setSize(new Point(512, 8));
		label2.setTabIndex(23);
		label2.setTabStop(false);
		label2.setText("");

		Rech.setBackColor(Color.AQUA);
		Rech.setLocation(new Point(263, 146));
		Rech.setSize(new Point(30, 32));
		Rech.setTabIndex(29);
		Rech.setTabStop(false);
		Rech.setText("pictureBox3");
		Rech.setBorderStyle(BorderStyle.FIXED_3D);
		Rech.setImage((Icon)resources.getObject("Rech_image"));
		Rech.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);
		Rech.addOnClick(new EventHandler(this.Rech_click));

		Nouv.setBackColor(Color.AQUA);
		Nouv.setLocation(new Point(335, 146));
		Nouv.setSize(new Point(30, 32));
		Nouv.setTabIndex(0);
		Nouv.setTabStop(false);
		Nouv.setText("pictureBox3");
		Nouv.setBorderStyle(BorderStyle.FIXED_3D);
		Nouv.setImage((Icon)resources.getObject("Nouv_image"));
		Nouv.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);
		Nouv.addOnClick(new EventHandler(this.Nouv_click));

		Ferm.setBackColor(Color.AQUA);
		Ferm.setLocation(new Point(407, 146));
		Ferm.setSize(new Point(30, 32));
		Ferm.setTabIndex(1);
		Ferm.setTabStop(false);
		Ferm.setText("pictureBox3");
		Ferm.setBorderStyle(BorderStyle.FIXED_3D);
		Ferm.setImage((Icon)resources.getObject("Ferm_image"));
		Ferm.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);
		Ferm.addOnClick(new EventHandler(this.Ferm_click));

		this.setNewControls(new Control[] {
							label2, 
							editNo, 
							Ferm, 
							Nouv, 
							Rech, 
							labelNo_Avis, 
							groupBox2, 
							panel1, 
							pictureBox4, 
							date2, 
							date1, 
							pictureBox1, 
							pictureBox6, 
							label1, 
							pictureBox2, 
							labelDate1, 
							serv, 
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
							labelRef_Inst, 
							editRef_Inst, 
							groupBox1});
		panel1.setNewControls(new Control[] {
							  pictureBox3});
	}

	/**
	 * The main entry point for the application. 
	 *
	 * @param args Array of parameters passed to the application
	 * via the command line.
	 */
	public static void main(String args[])
	{
		Application.run(new Rech_Services());
	}
}
