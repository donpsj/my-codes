//Rech_P_Balance.java

import com.ms.wfc.app.*;
import com.ms.wfc.core.*;
import com.ms.wfc.ui.*;
import com.ms.wfc.data.*;
import com.ms.wfc.data.ui.*;

public class Rech_P_Balance extends Form
{

    public void dispose()
    {
        super.dispose();
        components.dispose();
    }
	
    public Rech_P_Balance()
    {
        // Required for Visual J++ Form Designer support
        initForm();
        
        this.show();
        this.update();
		editNo_paie.setText("0");
        //TODO: Add any constructor code after initForm call
    }    

    public void formClose(Event e)
    {
        Application.exit();
    }    

    
    void handleADOException(Exception e)
    {
        e.printStackTrace();
        MessageBox.show( e.toString(), "Rech_P_Balance" );
    }

	private void button1_click(Object source, Event e)
	{   DataSource fin = new DataSource();
		DataBinder display = new DataBinder();
		
		
		
	try{
		int nbal = (Integer.valueOf(editNo_paie.getText()).intValue());
		if(editNo_paie.getText().equals("0"))
		{MessageBox.show("Veuillez Entrer le Numéro de Paiement de Balance à Rechercher  S.V.P !","Champ de Recheche à Remplir",MessageBox.ICONERROR);
		 }
		else
		{   
		    fin.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		    fin.setCommandText("select * from Paiement where No_paie = "+editNo_paie.getText()+"");			  			
            fin.begin();
			
			if(String.valueOf(fin.getRecordset().getRecordCount()).equals("0"))
			   {MessageBox.show("Desolé,lePaiement de Crédit Numéro << "+editNo_paie.getText()+" >> est Introuvable !", " Recherche Echouée ",MessageBox.ICONSTOP);
		     	 editNo_paie.setText("0");
			    }
			 else
			 {
			     display.setDataSource(fin);
				 display.setBindings(new DataBinding[]{
									 
							    new DataBinding(editDate_paie,"text","Date_paie"),
							    new DataBinding(editRef_pol,"text","Ref_titul"),
							    new DataBinding(editNom,"text","Nom"),
								new DataBinding(editNo_cheq,"text","No_cheq"),
							    new DataBinding(editBanque,"text","Banque"),
							    new DataBinding(editMontant,"text","Montant"),		  				 				  
									  });
				               
					 			labelDate_paie.setVisible(true);
                                labelRef_pol.setVisible(true);
								labelNom.setVisible(true);
								labelNo_cheq.setVisible(true);
								labelBanque.setVisible(true);
								labelMontant.setVisible(true);
				 
				      
								
					 			editDate_paie.setVisible(true);
                                editRef_pol.setVisible(true);
								editNom.setVisible(true);
								editNo_cheq.setVisible(true);
								editBanque.setVisible(true);
								editMontant.setVisible(true);
								group2.setVisible(true);
								panel2.setVisible(true);
								button1.setEnabled(false);
						 
			       }
		        }
	       }
	      catch(NumberFormatException k){
		   MessageBox.show("Le Champ < Numéro de Paiement de Balance > est de Type Numérique, Entrez le Numéro à Nouveau S.V.P  !","Données Incompatibles",MessageBox.ICONERROR);
		   editNo_paie.setText("0");
		  }	
	
	
	}

	private void button2_click(Object source, Event e)
	{
		                        editNo_paie.setText("0");
								labelDate_paie.setVisible(false);
                                labelRef_pol.setVisible(false);
								labelNom.setVisible(false);
								labelNo_cheq.setVisible(false);
								labelBanque.setVisible(false);
								labelMontant.setVisible(false);
				     						
					 			editDate_paie.setVisible(false);
                                editRef_pol.setVisible(false);
								editNom.setVisible(false);
								editNo_cheq.setVisible(false);
								editBanque.setVisible(false);
								editMontant.setVisible(false);
								group2.setVisible(false);
								panel2.setVisible(false);
								button1.setEnabled(true);
	}

	private void button3_click(Object source, Event e)
	{
		 int choi;
		choi=MessageBox.show("Etes-vous sur de Vouloir Abandonner la Recherche?", "Abandon",MessageBox.YESNO);
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
	Button b = new Button();
	Label label1 = new Label();
	Panel panel1 = new Panel();
	Edit editNo_paie = new Edit();
	Label labelDate_paie = new Label();
	Edit editDate_paie = new Edit();
	Label labelRef_pol = new Label();
	Edit editRef_pol = new Edit();
	Label labelNom = new Label();
	Edit editNom = new Edit();
	Label labelNo_cheq = new Label();
	Edit editNo_cheq = new Edit();
	Label labelBanque = new Label();
	Edit editBanque = new Edit();
	Label labelMontant = new Label();
	Edit editMontant = new Edit();
	GroupBox groupBox1 = new GroupBox();
	Label labelNo_Avis = new Label();
	PictureBox button2 = new PictureBox();
	GroupBox group2 = new GroupBox();
	Label label3 = new Label();
	PictureBox button1 = new PictureBox();
	PictureBox pictureBox6 = new PictureBox();
	PictureBox pictureBox2 = new PictureBox();
	Panel panel2 = new Panel();
	PictureBox pictureBox3 = new PictureBox();
	Label label2 = new Label();
	PictureBox pictureBox4 = new PictureBox();
	PictureBox button3 = new PictureBox();

	private void initForm()
	{
		// REMARQUE : cette feuille stocke des informations sur les ressources
		// dans un fichier externe. Ne modifiez le paramètre de chaîne d'aucun
		// appel de fonction resources.getObject(). Par exemple,
		// ne modifiez pas "foo1_location" dans la ligne de code
		// suivante, même si le nom de l'objet Foo change : 
		//	 foo1.setLocation((Point)resources.getObject("foo1_location"));

		IResourceManager resources = new ResourceManager(this, "Rech_P_Balance");
		this.setLocation(new Point(7, 7));
		this.setText("Recherche d\'un Paiement d\'un Titulaire");
		this.setAutoScaleBaseSize(new Point(5, 13));
		this.setAutoScroll(true);
		this.setBorderStyle(FormBorderStyle.NONE);
		this.setClientSize(new Point(600, 428));
		this.setMaximizeBox(false);
		this.setStartPosition(FormStartPosition.CENTER_SCREEN);

		b.setLocation(new Point(467, 141));
		b.setSize(new Point(52, 21));
		b.setTabIndex(15);
		b.setText("&Fermer");
		b.addOnClick(new EventHandler(this.button3_click));

		label1.setLocation(new Point(61, 123));
		label1.setSize(new Point(472, 8));
		label1.setTabIndex(17);
		label1.setTabStop(false);
		label1.setText("");

		panel1.setBackColor(new Color(0, 192, 192));
		panel1.setLocation(new Point(8, 384));
		panel1.setSize(new Point(576, 40));
		panel1.setTabIndex(20);
		panel1.setText("panel1");
		panel1.setVisible(false);
		panel1.setBorderStyle(BorderStyle.FIXED_3D);

		editNo_paie.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNo_paie.setLocation(new Point(259, 142));
		editNo_paie.setSize(new Point(80, 20));
		editNo_paie.setTabIndex(0);
		editNo_paie.setText("");
		editNo_paie.setMultiline(true);

		labelDate_paie.setBackColor(Color.CONTROL);
		labelDate_paie.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelDate_paie.setLocation(new Point(153, 219));
		labelDate_paie.setSize(new Point(168, 20));
		labelDate_paie.setTabIndex(5);
		labelDate_paie.setTabStop(false);
		labelDate_paie.setText("Date du Paiement");
		labelDate_paie.setVisible(false);
		labelDate_paie.setBorderStyle(BorderStyle.FIXED_3D);

		editDate_paie.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editDate_paie.setEnabled(false);
		editDate_paie.setLocation(new Point(328, 221));
		editDate_paie.setSize(new Point(96, 20));
		editDate_paie.setTabIndex(6);
		editDate_paie.setText("");
		editDate_paie.setVisible(false);
		editDate_paie.setMaxLength(10);
		editDate_paie.setMultiline(true);

		labelRef_pol.setBackColor(Color.CONTROL);
		labelRef_pol.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelRef_pol.setLocation(new Point(153, 243));
		labelRef_pol.setSize(new Point(168, 20));
		labelRef_pol.setTabIndex(7);
		labelRef_pol.setTabStop(false);
		labelRef_pol.setText("Nif du 1er Titulaire");
		labelRef_pol.setVisible(false);
		labelRef_pol.setBorderStyle(BorderStyle.FIXED_3D);

		editRef_pol.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRef_pol.setLocation(new Point(328, 243));
		editRef_pol.setSize(new Point(128, 20));
		editRef_pol.setTabIndex(8);
		editRef_pol.setText("");
		editRef_pol.setVisible(false);
		editRef_pol.setReadOnly(true);

		labelNom.setBackColor(Color.CONTROL);
		labelNom.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNom.setLocation(new Point(152, 267));
		labelNom.setSize(new Point(168, 20));
		labelNom.setTabIndex(9);
		labelNom.setTabStop(false);
		labelNom.setText("Nom");
		labelNom.setVisible(false);
		labelNom.setBorderStyle(BorderStyle.FIXED_3D);

		editNom.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNom.setEnabled(false);
		editNom.setLocation(new Point(327, 266));
		editNom.setSize(new Point(128, 20));
		editNom.setTabIndex(10);
		editNom.setText("");
		editNom.setVisible(false);
		editNom.setMaxLength(50);
		editNom.setMultiline(true);

		labelNo_cheq.setBackColor(Color.CONTROL);
		labelNo_cheq.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNo_cheq.setLocation(new Point(152, 291));
		labelNo_cheq.setSize(new Point(168, 20));
		labelNo_cheq.setTabIndex(11);
		labelNo_cheq.setTabStop(false);
		labelNo_cheq.setText("No du Chèque");
		labelNo_cheq.setVisible(false);
		labelNo_cheq.setBorderStyle(BorderStyle.FIXED_3D);

		editNo_cheq.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNo_cheq.setEnabled(false);
		editNo_cheq.setLocation(new Point(326, 290));
		editNo_cheq.setSize(new Point(128, 20));
		editNo_cheq.setTabIndex(12);
		editNo_cheq.setText("");
		editNo_cheq.setVisible(false);
		editNo_cheq.setMultiline(true);

		labelBanque.setBackColor(Color.CONTROL);
		labelBanque.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelBanque.setLocation(new Point(152, 315));
		labelBanque.setSize(new Point(168, 20));
		labelBanque.setTabIndex(13);
		labelBanque.setTabStop(false);
		labelBanque.setText("Banque");
		labelBanque.setVisible(false);
		labelBanque.setBorderStyle(BorderStyle.FIXED_3D);

		editBanque.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editBanque.setEnabled(false);
		editBanque.setLocation(new Point(326, 316));
		editBanque.setSize(new Point(128, 20));
		editBanque.setTabIndex(14);
		editBanque.setText("");
		editBanque.setVisible(false);
		editBanque.setMaxLength(50);
		editBanque.setMultiline(true);

		labelMontant.setBackColor(Color.CONTROL);
		labelMontant.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelMontant.setLocation(new Point(152, 339));
		labelMontant.setSize(new Point(168, 20));
		labelMontant.setTabIndex(16);
		labelMontant.setTabStop(false);
		labelMontant.setText("Montant");
		labelMontant.setVisible(false);
		labelMontant.setBorderStyle(BorderStyle.FIXED_3D);

		editMontant.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editMontant.setEnabled(false);
		editMontant.setLocation(new Point(326, 340));
		editMontant.setSize(new Point(128, 20));
		editMontant.setTabIndex(18);
		editMontant.setText("");
		editMontant.setVisible(false);
		editMontant.setMultiline(true);

		groupBox1.setBackColor(new Color(0, 192, 192));
		groupBox1.setLocation(new Point(61, 125));
		groupBox1.setSize(new Point(464, 48));
		groupBox1.setTabIndex(19);
		groupBox1.setTabStop(false);
		groupBox1.setText("");

		labelNo_Avis.setBackColor(new Color(255, 255, 192));
		labelNo_Avis.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNo_Avis.setForeColor(Color.BLACK);
		labelNo_Avis.setLocation(new Point(104, 142));
		labelNo_Avis.setSize(new Point(152, 20));
		labelNo_Avis.setTabIndex(2);
		labelNo_Avis.setTabStop(false);
		labelNo_Avis.setText(" Entrez le No de Paiement ");
		labelNo_Avis.setBorderStyle(BorderStyle.FIXED_3D);

		button2.setBackColor(Color.AQUA);
		button2.setLocation(new Point(388, 136));
		button2.setSize(new Point(30, 32));
		button2.setTabIndex(25);
		button2.setTabStop(false);
		button2.setText("pictureBox1");
		button2.setBorderStyle(BorderStyle.FIXED_3D);
		button2.setImage((Icon)resources.getObject("button2_image"));
		button2.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);
		button2.addOnClick(new EventHandler(this.button2_click));

		group2.setLocation(new Point(121, 183));
		group2.setSize(new Point(344, 184));
		group2.setTabIndex(21);
		group2.setTabStop(false);
		group2.setText("");
		group2.setVisible(false);

		label3.setBackColor(Color.AQUA);
		label3.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, true, false, false, CharacterSet.DEFAULT, 0));
		label3.setForeColor(new Color(255, 255, 192));
		label3.setLocation(new Point(328, 202));
		label3.setSize(new Point(86, 16));
		label3.setTabIndex(1);
		label3.setTabStop(false);
		label3.setText("JJ / MM / AA");
		label3.setVisible(false);
		label3.setBorderStyle(BorderStyle.FIXED_3D);

		button1.setBackColor(Color.AQUA);
		button1.setLocation(new Point(282, 12));
		button1.setSize(new Point(30, 32));
		button1.setTabIndex(0);
		button1.setTabStop(false);
		button1.setText("pictureBox1");
		button1.setBorderStyle(BorderStyle.FIXED_3D);
		button1.setImage((Icon)resources.getObject("button1_image"));
		button1.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);
		button1.addOnClick(new EventHandler(this.button1_click));

		pictureBox6.setLocation(new Point(37, 48));
		pictureBox6.setSize(new Point(88, 80));
		pictureBox6.setTabIndex(4);
		pictureBox6.setTabStop(false);
		pictureBox6.setText("pictureBox2");
		pictureBox6.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox6.setImage((Bitmap)resources.getObject("pictureBox6_image"));
		pictureBox6.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox2.setLocation(new Point(60, 35));
		pictureBox2.setSize(new Point(88, 80));
		pictureBox2.setTabIndex(22);
		pictureBox2.setTabStop(false);
		pictureBox2.setText("pictureBox1");
		pictureBox2.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox2.setImage((Bitmap)resources.getObject("pictureBox2_image"));
		pictureBox2.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		panel2.setLocation(new Point(36, 178));
		panel2.setSize(new Point(520, 200));
		panel2.setTabIndex(23);
		panel2.setText("panel2");
		panel2.setVisible(false);
		panel2.setBorderStyle(BorderStyle.FIXED_3D);

		pictureBox3.setLocation(new Point(37, 1));
		pictureBox3.setSize(new Point(520, 32));
		pictureBox3.setTabIndex(3);
		pictureBox3.setTabStop(false);
		pictureBox3.setText("pictureBox2");
		pictureBox3.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox3.setImage((Bitmap)resources.getObject("pictureBox3_image"));
		pictureBox3.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		label2.setBackColor(new Color(255, 255, 192));
		label2.setFont(new Font("Verdana", 14.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label2.setForeColor(Color.AQUA);
		label2.setLocation(new Point(104, 5));
		label2.setSize(new Point(392, 23));
		label2.setTabIndex(24);
		label2.setTabStop(false);
		label2.setText("Recherche de Paiement d\'un Titulaire");
		label2.setBorderStyle(BorderStyle.FIXED_3D);

		pictureBox4.setLocation(new Point(17, 2));
		pictureBox4.setSize(new Point(536, 32));
		pictureBox4.setTabIndex(0);
		pictureBox4.setTabStop(false);
		pictureBox4.setText("pictureBox4");
		pictureBox4.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox4.setImage((Bitmap)resources.getObject("pictureBox4_image"));
		pictureBox4.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		button3.setBackColor(Color.AQUA);
		button3.setLocation(new Point(424, 136));
		button3.setSize(new Point(30, 32));
		button3.setTabIndex(26);
		button3.setTabStop(false);
		button3.setText("pictureBox1");
		button3.setBorderStyle(BorderStyle.FIXED_3D);
		button3.setImage((Icon)resources.getObject("button3_image"));
		button3.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);
		button3.addOnClick(new EventHandler(this.button3_click));

		this.setNewControls(new Control[] {
							button3, 
							button2, 
							label2, 
							pictureBox3, 
							pictureBox2, 
							pictureBox6, 
							label3, 
							panel1, 
							labelNo_Avis, 
							label1, 
							editNo_paie, 
							labelDate_paie, 
							editDate_paie, 
							labelRef_pol, 
							editRef_pol, 
							labelNom, 
							editNom, 
							labelNo_cheq, 
							editNo_cheq, 
							labelBanque, 
							editBanque, 
							labelMontant, 
							editMontant, 
							groupBox1, 
							group2, 
							panel2, 
							b});
		panel1.setNewControls(new Control[] {
							  pictureBox4});
		groupBox1.setNewControls(new Control[] {
								 button1});
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
        Application.run( new Rech_P_Balance() );
    }
}
