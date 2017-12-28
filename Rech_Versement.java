import com.ms.wfc.app.*;
import com.ms.wfc.core.*;
import com.ms.wfc.ui.*;
import com.ms.wfc.data.*;
import com.ms.wfc.data.ui.*;
/**
 * This class can take a variable number of parameters on the command
 * line. Program execution begins with the main() method. The class
 * constructor is not invoked unless an object of type 'Rech_Versement'
 * created in the main() method.
 */
public class Rech_Versement extends Form
{   
	DataSource fi = new DataSource();
	DataBinder disp = new DataBinder();
	public Rech_Versement()
	{
		super();

		// Required for Visual J++ Form Designer support
		initForm();		

		// TODO: Add any constructor code after initForm call
	}

	/**
	 * Rech_Versement overrides dispose so it can clean up the
	 * component list.
	 */
	public void dispose()
	{
		super.dispose();
		components.dispose();
	}

private void Rech_click(Object source, Event e)
{
	
	try
	{   int nfac = (Integer.valueOf(editNo_recu.getText()).intValue());
		
		if(editNo_recu.getText().equals("0"))
		{MessageBox.show("Veuillez Entrer le Numéro du Paiement à Rechercher S.V.P !","Champ de Recheche à Remplir ",MessageBox.ICONERROR);
		 }
		else
		{   
		    fi.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		    fi.setCommandText("select * from Versement where Np = "+editNo_recu.getText()+"");			  			
            fi.begin();
			
			if(String.valueOf(fi.getRecordset().getRecordCount()).equals("0"))
			   {MessageBox.show("Désolé, Le Paiement Numéro << "+editNo_recu.getText()+" >> est Introuvable !", " Recherche Echouée ",MessageBox.ICONSTOP);
		     	 editNo_recu.setText("0");
			    }
			else
			{     
				  disp.setDataSource(fi);
				  disp.setBindings(new DataBinding[]{
									 
							    new DataBinding(editRef_Inst,"text","Instit"),
							    new DataBinding(date,"text","Date"),
							    new DataBinding(editRef_fact,"text","Ref_Fac"),
							    new DataBinding(editNo_cheque,"text","Nochq"),
								new DataBinding(banque,"text","Banque"),
									  
								new DataBinding(som,"text","Montant"),
								
								
								      
									  });
	                  }
		           }
	         }
	
  
           catch(NumberFormatException k){
		   MessageBox.show("Le Champ < Numéro du Service >  est de Type Numérique, Entrez le Numéro à Nouveau S.V.P  !","Données Incompatibles",MessageBox.ICONERROR);
		    editNo_recu.setText("0");
			}
	
   }

private void Nouv_click(Object source, Event e)
{
	editNo_recu.setText("0");
	editRef_Inst.setText("");
	date.setText("");
	editRef_fact.setText("0");
	editNo_cheque.setText("0");
	banque.setText("");
	som.setText("0");
								
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
Edit date = new Edit();
Edit som = new Edit();
ComboBox banque = new ComboBox();
Label labelSom_recue = new Label();
Label labelBanque = new Label();
Edit editNo_cheque = new Edit();
Label labelNo_cheque = new Label();
Edit editRef_fact = new Edit();
Label labelRef_fact = new Label();
Edit editRef_Inst = new Edit();
Label labelDate = new Label();
ComboBox mois = new ComboBox();
GroupBox groupBox1 = new GroupBox();
GroupBox groupBox2 = new GroupBox();
ComboBox jour = new ComboBox();
Label label1 = new Label();
Label label4 = new Label();
PictureBox pictureBox3 = new PictureBox();
Panel panel2 = new Panel();
Panel panel5 = new Panel();
PictureBox pictureBox2 = new PictureBox();
PictureBox pictureBox4 = new PictureBox();
PictureBox pictureBox1 = new PictureBox();
Label label2 = new Label();
Label label3 = new Label();
PictureBox pictureBox6 = new PictureBox();
PictureBox pictureBox5 = new PictureBox();
GroupBox groupBox3 = new GroupBox();
Edit editNo_recu = new Edit();
Label labelNo_recu = new Label();
Panel panel1 = new Panel();
PictureBox pictureBox7 = new PictureBox();
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

	IResourceManager resources = new ResourceManager(this, "Rech_Versement");
	this.setText("Recherche d\'un Paiement d\'une Institution");
	this.setAutoScaleBaseSize(new Point(5, 13));
	this.setBorderStyle(FormBorderStyle.NONE);
	this.setClientSize(new Point(502, 449));
	this.setStartPosition(FormStartPosition.CENTER_SCREEN);

	date.setLocation(new Point(159, 224));
	date.setSize(new Point(80, 20));
	date.setTabIndex(8);
	date.setText("");
	date.setMaxLength(2);

	som.setAnchor(ControlAnchor.TOPLEFTRIGHT);
	som.setLocation(new Point(328, 340));
	som.setSize(new Point(127, 20));
	som.setTabIndex(12);
	som.setText("150");

	banque.setLocation(new Point(328, 316));
	banque.setSize(new Point(128, 21));
	banque.setTabIndex(9);
	banque.setText("SOGEBANK");
	banque.setMaxLength(50);
	banque.setItems(new Object[] {
					"UNIBANK", 
					"SOGEBANK", 
					"BRH", 
					"BNC", 
					"BUH", 
					"CAPITAL BANK", 
					"SCOTIABANK", 
					"SOCABANK", 
					"PROMOBANK", 
					"CITIBANK", 
					"BPH", 
					""});

	labelSom_recue.setBackColor(Color.CONTROL);
	labelSom_recue.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
	labelSom_recue.setLocation(new Point(181, 340));
	labelSom_recue.setSize(new Point(144, 20));
	labelSom_recue.setTabIndex(29);
	labelSom_recue.setTabStop(false);
	labelSom_recue.setText("Somme_recue");
	labelSom_recue.setBorderStyle(BorderStyle.FIXED_3D);

	labelBanque.setBackColor(Color.CONTROL);
	labelBanque.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
	labelBanque.setLocation(new Point(181, 316));
	labelBanque.setSize(new Point(144, 20));
	labelBanque.setTabIndex(27);
	labelBanque.setTabStop(false);
	labelBanque.setText("Banque");
	labelBanque.setBorderStyle(BorderStyle.FIXED_3D);

	editNo_cheque.setAnchor(ControlAnchor.TOPLEFTRIGHT);
	editNo_cheque.setLocation(new Point(328, 291));
	editNo_cheque.setSize(new Point(127, 20));
	editNo_cheque.setTabIndex(15);
	editNo_cheque.setText("545");
	editNo_cheque.setMaxLength(30);

	labelNo_cheque.setBackColor(Color.CONTROL);
	labelNo_cheque.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
	labelNo_cheque.setLocation(new Point(181, 292));
	labelNo_cheque.setSize(new Point(144, 20));
	labelNo_cheque.setTabIndex(24);
	labelNo_cheque.setTabStop(false);
	labelNo_cheque.setText("No du Chèque Reçu");
	labelNo_cheque.setBorderStyle(BorderStyle.FIXED_3D);

	editRef_fact.setAnchor(ControlAnchor.TOPLEFTRIGHT);
	editRef_fact.setLocation(new Point(328, 268));
	editRef_fact.setSize(new Point(127, 20));
	editRef_fact.setTabIndex(14);
	editRef_fact.setText("4");

	labelRef_fact.setBackColor(Color.CONTROL);
	labelRef_fact.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
	labelRef_fact.setLocation(new Point(181, 268));
	labelRef_fact.setSize(new Point(144, 20));
	labelRef_fact.setTabIndex(23);
	labelRef_fact.setTabStop(false);
	labelRef_fact.setText("No de la Facture Payée");
	labelRef_fact.setBorderStyle(BorderStyle.FIXED_3D);

	editRef_Inst.setAnchor(ControlAnchor.TOPLEFTRIGHT);
	editRef_Inst.setLocation(new Point(159, 200));
	editRef_Inst.setSize(new Point(143, 20));
	editRef_Inst.setTabIndex(22);
	editRef_Inst.setText("UNAH");
	editRef_Inst.setVisible(false);
	editRef_Inst.setCharacterCasing(CharacterCasing.UPPER);
	editRef_Inst.setMaxLength(50);
	editRef_Inst.setMultiline(true);

	labelDate.setBackColor(Color.CONTROL);
	labelDate.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
	labelDate.setLocation(new Point(57, 225));
	labelDate.setSize(new Point(100, 20));
	labelDate.setTabIndex(21);
	labelDate.setTabStop(false);
	labelDate.setText("Date Paiement");
	labelDate.setBorderStyle(BorderStyle.FIXED_3D);

	mois.setLocation(new Point(234, 265));
	mois.setSize(new Point(48, 21));
	mois.setTabIndex(4);
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

	groupBox1.setBackColor(Color.SCROLLBAR);
	groupBox1.setLocation(new Point(45, 190));
	groupBox1.setSize(new Point(272, 64));
	groupBox1.setTabIndex(19);
	groupBox1.setTabStop(false);
	groupBox1.setText("");

	groupBox2.setLocation(new Point(173, 251));
	groupBox2.setSize(new Point(288, 112));
	groupBox2.setTabIndex(18);
	groupBox2.setTabStop(false);
	groupBox2.setText("");

	jour.setLocation(new Point(186, 265));
	jour.setSize(new Point(48, 21));
	jour.setTabIndex(2);
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

	label1.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
	label1.setLocation(new Point(12, 11));
	label1.setSize(new Point(100, 20));
	label1.setTabIndex(0);
	label1.setTabStop(false);
	label1.setText("Institution");
	label1.setBorderStyle(BorderStyle.FIXED_3D);

	label4.setBackColor(Color.YELLOW);
	label4.setForeColor(Color.BLACK);
	label4.setLocation(new Point(284, 216));
	label4.setSize(new Point(24, 16));
	label4.setTabIndex(16);
	label4.setTabStop(false);
	label4.setText("Auto");
	label4.setTextAlign(HorizontalAlignment.CENTER);

	pictureBox3.setLocation(new Point(346, 202));
	pictureBox3.setSize(new Point(16, 91));
	pictureBox3.setTabIndex(10);
	pictureBox3.setTabStop(false);
	pictureBox3.setText("pictureBox2");
	pictureBox3.setBorderStyle(BorderStyle.FIXED_3D);
	pictureBox3.setImage((Bitmap)resources.getObject("pictureBox3_image"));
	pictureBox3.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

	panel2.setLocation(new Point(16, 185));
	panel2.setSize(new Point(464, 184));
	panel2.setTabIndex(17);
	panel2.setText("panel2");
	panel2.setBorderStyle(BorderStyle.FIXED_3D);

	panel5.setLocation(new Point(165, 255));
	panel5.setSize(new Point(168, 0));
	panel5.setTabIndex(30);
	panel5.setText("panel5");

	pictureBox2.setLocation(new Point(317, 197));
	pictureBox2.setSize(new Point(144, 56));
	pictureBox2.setTabIndex(13);
	pictureBox2.setTabStop(false);
	pictureBox2.setText("pictureBox2");
	pictureBox2.setBorderStyle(BorderStyle.FIXED_3D);
	pictureBox2.setImage((Bitmap)resources.getObject("pictureBox2_image"));
	pictureBox2.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

	pictureBox4.setLocation(new Point(44, 257));
	pictureBox4.setSize(new Point(128, 106));
	pictureBox4.setTabIndex(11);
	pictureBox4.setTabStop(false);
	pictureBox4.setText("pictureBox2");
	pictureBox4.setBorderStyle(BorderStyle.FIXED_3D);
	pictureBox4.setImage((Bitmap)resources.getObject("pictureBox4_image"));
	pictureBox4.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

	pictureBox1.setLocation(new Point(16, 0));
	pictureBox1.setSize(new Point(464, 32));
	pictureBox1.setTabIndex(6);
	pictureBox1.setTabStop(false);
	pictureBox1.setText("pictureBox2");
	pictureBox1.setBorderStyle(BorderStyle.FIXED_3D);
	pictureBox1.setImage((Bitmap)resources.getObject("pictureBox1_image"));
	pictureBox1.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

	label2.setLocation(new Point(16, 130));
	label2.setSize(new Point(472, 8));
	label2.setTabIndex(25);
	label2.setTabStop(false);
	label2.setText("");

	label3.setBackColor(new Color(255, 255, 192));
	label3.setFont(new Font("Verdana", 10.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
	label3.setForeColor(Color.AQUA);
	label3.setLocation(new Point(59, 4));
	label3.setSize(new Point(384, 22));
	label3.setTabIndex(32);
	label3.setTabStop(false);
	label3.setText("Recherche  d\'un Paiement d\'une Institution");
	label3.setBorderStyle(BorderStyle.FIXED_3D);
	label3.setTextAlign(HorizontalAlignment.CENTER);

	pictureBox6.setLocation(new Point(17, 47));
	pictureBox6.setSize(new Point(88, 80));
	pictureBox6.setTabIndex(7);
	pictureBox6.setTabStop(false);
	pictureBox6.setText("pictureBox2");
	pictureBox6.setBorderStyle(BorderStyle.FIXED_3D);
	pictureBox6.setImage((Bitmap)resources.getObject("pictureBox6_image"));
	pictureBox6.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

	pictureBox5.setLocation(new Point(34, 34));
	pictureBox5.setSize(new Point(88, 80));
	pictureBox5.setTabIndex(31);
	pictureBox5.setTabStop(false);
	pictureBox5.setText("pictureBox1");
	pictureBox5.setBorderStyle(BorderStyle.FIXED_3D);
	pictureBox5.setImage((Bitmap)resources.getObject("pictureBox5_image"));
	pictureBox5.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

	groupBox3.setBackColor(new Color(0, 192, 192));
	groupBox3.setLocation(new Point(16, 131));
	groupBox3.setSize(new Point(464, 48));
	groupBox3.setTabIndex(26);
	groupBox3.setTabStop(false);
	groupBox3.setText("");

	editNo_recu.setAnchor(ControlAnchor.TOPLEFTRIGHT);
	editNo_recu.setLocation(new Point(228, 149));
	editNo_recu.setSize(new Point(80, 20));
	editNo_recu.setTabIndex(5);
	editNo_recu.setText("");
	editNo_recu.setMaxLength(10);
	editNo_recu.setMultiline(true);

	labelNo_recu.setBackColor(new Color(255, 255, 192));
	labelNo_recu.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
	labelNo_recu.setForeColor(Color.BLACK);
	labelNo_recu.setLocation(new Point(22, 148));
	labelNo_recu.setSize(new Point(200, 20));
	labelNo_recu.setTabIndex(3);
	labelNo_recu.setTabStop(false);
	labelNo_recu.setText("Le No du Paiement à Rechercher");
	labelNo_recu.setBorderStyle(BorderStyle.FIXED_3D);

	panel1.setBackColor(new Color(0, 192, 192));
	panel1.setLocation(new Point(15, 374));
	panel1.setSize(new Point(464, 38));
	panel1.setTabIndex(20);
	panel1.setText("panel1");
	panel1.setBorderStyle(BorderStyle.FIXED_3D);

	pictureBox7.setLocation(new Point(10, 2));
	pictureBox7.setSize(new Point(440, 30));
	pictureBox7.setTabIndex(0);
	pictureBox7.setTabStop(false);
	pictureBox7.setText("pictureBox4");
	pictureBox7.setBorderStyle(BorderStyle.FIXED_3D);
	pictureBox7.setImage((Bitmap)resources.getObject("pictureBox7_image"));
	pictureBox7.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

	Rech.setBackColor(Color.AQUA);
	Rech.setLocation(new Point(309, 144));
	Rech.setSize(new Point(30, 32));
	Rech.setTabIndex(28);
	Rech.setTabStop(false);
	Rech.setText("pictureBox3");
	Rech.setBorderStyle(BorderStyle.FIXED_3D);
	Rech.setImage((Icon)resources.getObject("Rech_image"));
	Rech.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);
	Rech.addOnClick(new EventHandler(this.Rech_click));

	Nouv.setBackColor(Color.AQUA);
	Nouv.setLocation(new Point(372, 144));
	Nouv.setSize(new Point(30, 32));
	Nouv.setTabIndex(0);
	Nouv.setTabStop(false);
	Nouv.setText("pictureBox3");
	Nouv.setBorderStyle(BorderStyle.FIXED_3D);
	Nouv.setImage((Icon)resources.getObject("Nouv_image"));
	Nouv.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);
	Nouv.addOnClick(new EventHandler(this.Nouv_click));

	Ferm.setBackColor(Color.AQUA);
	Ferm.setLocation(new Point(432, 144));
	Ferm.setSize(new Point(30, 32));
	Ferm.setTabIndex(1);
	Ferm.setTabStop(false);
	Ferm.setText("pictureBox3");
	Ferm.setBorderStyle(BorderStyle.FIXED_3D);
	Ferm.setImage((Icon)resources.getObject("Ferm_image"));
	Ferm.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);
	Ferm.addOnClick(new EventHandler(this.Ferm_click));

	this.setNewControls(new Control[] {
						Ferm, 
						Nouv, 
						Rech, 
						panel1, 
						label2, 
						labelNo_recu, 
						editNo_recu, 
						groupBox3, 
						pictureBox5, 
						pictureBox6, 
						label3, 
						pictureBox1, 
						pictureBox4, 
						pictureBox2, 
						panel5, 
						banque, 
						som, 
						date, 
						labelSom_recue, 
						labelBanque, 
						editNo_cheque, 
						labelNo_cheque, 
						editRef_fact, 
						labelRef_fact, 
						editRef_Inst, 
						labelDate, 
						groupBox1, 
						groupBox2, 
						panel2, 
						label4, 
						pictureBox3, 
						mois, 
						jour});
	groupBox1.setNewControls(new Control[] {
							 label1});
	panel1.setNewControls(new Control[] {
						  pictureBox7});
}

	/**
	 * The main entry point for the application. 
	 *
	 * @param args Array of parameters passed to the application
	 * via the command line.
	 */
	public static void main(String args[])
	{
		Application.run(new Rech_Versement());
	}
}
