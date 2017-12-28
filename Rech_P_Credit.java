//Rech_P_Credit.java

import com.ms.wfc.app.*;
import com.ms.wfc.core.*;
import com.ms.wfc.ui.*;
import com.ms.wfc.data.*;
import com.ms.wfc.data.ui.*;

public class Rech_P_Credit extends Form
{

    public void dispose()
    {
        super.dispose();
        components.dispose();
    }
	
    public Rech_P_Credit()
    {
        // Required for Visual J++ Form Designer support
        initForm();
        
        this.show();
        this.update();
		editNo_credit.setText("0");

        //TODO: Add any constructor code after initForm call
    }    

    public void formClose(Event e)
    {
        Application.exit();
    }    

    
    void handleADOException(Exception e)
    {
        e.printStackTrace();
        MessageBox.show( e.toString(), "Rech_P_Credit" );
    }

	
	
	
private void button1_click(Object source, Event e)
{
		
		DataSource fin = new DataSource();
		DataBinder display = new DataBinder();
		
    try
	 {
		int ncred = (Integer.valueOf(editNo_credit.getText()).intValue());
		if(editNo_credit.getText().equals("0"))
		{MessageBox.show("Veuillez Entrer le Numéro de Paiement de Crédit à Rechercher  S.V.P !","Champ de Recheche à Remplir",MessageBox.ICONERROR);
		 }
		else
		{   
		    fin.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		    fin.setCommandText("select * from Credit where No_credit = "+editNo_credit.getText()+"");			  			
            fin.begin();
			
			if(String.valueOf(fin.getRecordset().getRecordCount()).equals("0"))
			   {MessageBox.show("Desolé,le Paiement de Crédit Numéro << "+editNo_credit.getText()+" >> est Introuvable !", " Recherche Echouée ",MessageBox.ICONSTOP);
		     	 editNo_credit.setText("0");
			    }
			 else
			 {
			     display.setDataSource(fin);
				 display.setBindings(new DataBinding[]{
									 
							    new DataBinding(editRef_tit,"text","Ref_tit"),
							    new DataBinding(editDate_Remb,"text","Date_Remb"),
							    new DataBinding(editNom_prenom,"text","Nom_prenom"),
							    new DataBinding(editNif,"text","Nif"),
								new DataBinding(editNo_cheque,"text","No_cheque"),
							    new DataBinding(editBanque,"text","Banque"),
							    new DataBinding(editMont_paye,"text","Mont_paye"),		  				 				  
									  });
				  
				 
								editRef_tit.setVisible(true);
							    editDate_Remb.setVisible(true);
							    editNom_prenom.setVisible(true);
							    editNif.setVisible(true);
								editNo_cheque.setVisible(true);
							    editBanque.setVisible(true);
							    editMont_paye.setVisible(true);
								
								pan3.setVisible(true);	
								label3.setVisible(true);
								labelRef_tit.setVisible(true);
							    labelDate_Remb.setVisible(true);
							    labelNom_prenom.setVisible(true);
							    labelNif.setVisible(true);
								labelNo_cheque.setVisible(true);
							    labelBanque.setVisible(true);
							    labelMont_paye.setVisible(true);
								group1.setVisible(true);
									
				                 button1.setEnabled(false);
								 			  
			    }
		       }
	        }
          catch(NumberFormatException k){
		   MessageBox.show("Le Champ < Numéro de Paiement de Crédit > est de Type Numérique, Entrez le Numéro à Nouveau S.V.P  !","Données Incompatibles");
		   editNo_credit.setText("0");
		  }	
			
	 }
private void button2_click(Object source, Event e)
	{
								editNo_credit.setText("0");
	                            editRef_tit.setVisible(false);
							    editDate_Remb.setVisible(false);
							    editNom_prenom.setVisible(false);
							    editNif.setVisible(false);
								editNo_cheque.setVisible(false);
							    editBanque.setVisible(false);
							    editMont_paye.setVisible(false);
								pan3.setVisible(false);	
								
								
								group1.setVisible(false);	
								label3.setVisible(false);
								labelRef_tit.setVisible(false);
							    labelDate_Remb.setVisible(false);
							    labelNom_prenom.setVisible(false);
							    labelNif.setVisible(false);
								labelNo_cheque.setVisible(false);
							    labelBanque.setVisible(false);
							    labelMont_paye.setVisible(false);
									
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

private void Rech_P_Credit_click(Object source, Event e)
{
	
}



/**
 * NOTE: The following code is required by the Visual J++ form
 * designer.  It can be modified using the form editor.  Do not
 * modify it using the code editor.
 */
Container components = new Container();
Panel panel1 = new Panel();
GroupBox group1 = new GroupBox();
Label label3 = new Label();
Edit editNo_credit = new Edit();
Label labelRef_tit = new Label();
Edit editRef_tit = new Edit();
Label labelDate_Remb = new Label();
Edit editDate_Remb = new Edit();
Label labelNom_prenom = new Label();
Edit editNom_prenom = new Edit();
Label labelNif = new Label();
Edit editNif = new Edit();
Label labelNo_cheque = new Label();
Edit editNo_cheque = new Edit();
Label labelBanque = new Label();
Edit editBanque = new Edit();
Label labelMont_paye = new Label();
Edit editMont_paye = new Edit();
PictureBox pictureBox6 = new PictureBox();
Label label2 = new Label();
Label labelNo_Avis = new Label();
Label label1 = new Label();
GroupBox groupBox1 = new GroupBox();
PictureBox button1 = new PictureBox();
Panel panel2 = new Panel();
Panel pan3 = new Panel();
PictureBox pictureBox1 = new PictureBox();
PictureBox pictureBox3 = new PictureBox();
PictureBox pictureBox4 = new PictureBox();
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

	IResourceManager resources = new ResourceManager(this, "Rech_P_Credit");
	this.setLocation(new Point(7, 7));
	this.setText("Recherche d\'un Remboursement ");
	this.setAutoScaleBaseSize(new Point(5, 13));
	this.setAutoScroll(true);
	this.setBorderStyle(FormBorderStyle.NONE);
	this.setClientSize(new Point(601, 428));
	this.setMaximizeBox(false);
	this.setStartPosition(FormStartPosition.CENTER_SCREEN);
	this.addOnClick(new EventHandler(this.Rech_P_Credit_click));

	panel1.setBackColor(new Color(0, 192, 192));
	panel1.setEnabled(false);
	panel1.setLocation(new Point(4, 381));
	panel1.setSize(new Point(584, 40));
	panel1.setTabIndex(23);
	panel1.setText("panel1");
	panel1.setBorderStyle(BorderStyle.FIXED_3D);

	group1.setLocation(new Point(123, 151));
	group1.setSize(new Point(344, 216));
	group1.setTabIndex(24);
	group1.setTabStop(false);
	group1.setText("");
	group1.setVisible(false);

	label3.setBackColor(Color.AQUA);
	label3.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, true, false, false, CharacterSet.DEFAULT, 0));
	label3.setForeColor(new Color(255, 255, 192));
	label3.setLocation(new Point(336, 198));
	label3.setSize(new Point(86, 16));
	label3.setTabIndex(1);
	label3.setTabStop(false);
	label3.setText("JJ / MM / AA");
	label3.setVisible(false);
	label3.setBorderStyle(BorderStyle.FIXED_3D);

	editNo_credit.setAnchor(ControlAnchor.TOPLEFTRIGHT);
	editNo_credit.setLocation(new Point(260, 113));
	editNo_credit.setSize(new Point(89, 20));
	editNo_credit.setTabIndex(0);
	editNo_credit.setText("");
	editNo_credit.setMultiline(true);

	labelRef_tit.setBackColor(Color.CONTROL);
	labelRef_tit.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
	labelRef_tit.setLocation(new Point(130, 167));
	labelRef_tit.setSize(new Point(200, 20));
	labelRef_tit.setTabIndex(6);
	labelRef_tit.setTabStop(false);
	labelRef_tit.setText("No Police d\'Assurance du Titulaire");
	labelRef_tit.setVisible(false);
	labelRef_tit.setBorderStyle(BorderStyle.FIXED_3D);

	editRef_tit.setAnchor(ControlAnchor.TOPLEFTRIGHT);
	editRef_tit.setLocation(new Point(335, 167));
	editRef_tit.setSize(new Point(129, 20));
	editRef_tit.setTabIndex(7);
	editRef_tit.setText("");
	editRef_tit.setVisible(false);
	editRef_tit.setMultiline(true);
	editRef_tit.setReadOnly(true);

	labelDate_Remb.setBackColor(Color.CONTROL);
	labelDate_Remb.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
	labelDate_Remb.setLocation(new Point(130, 215));
	labelDate_Remb.setSize(new Point(200, 20));
	labelDate_Remb.setTabIndex(8);
	labelDate_Remb.setTabStop(false);
	labelDate_Remb.setText("Date de Remboursement");
	labelDate_Remb.setVisible(false);
	labelDate_Remb.setBorderStyle(BorderStyle.FIXED_3D);

	editDate_Remb.setAnchor(ControlAnchor.TOPLEFTRIGHT);
	editDate_Remb.setEnabled(false);
	editDate_Remb.setLocation(new Point(335, 215));
	editDate_Remb.setSize(new Point(129, 20));
	editDate_Remb.setTabIndex(9);
	editDate_Remb.setText("");
	editDate_Remb.setVisible(false);
	editDate_Remb.setMaxLength(10);
	editDate_Remb.setMultiline(true);

	labelNom_prenom.setBackColor(Color.CONTROL);
	labelNom_prenom.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
	labelNom_prenom.setLocation(new Point(130, 239));
	labelNom_prenom.setSize(new Point(200, 20));
	labelNom_prenom.setTabIndex(10);
	labelNom_prenom.setTabStop(false);
	labelNom_prenom.setText("Personne Remboursée");
	labelNom_prenom.setVisible(false);
	labelNom_prenom.setBorderStyle(BorderStyle.FIXED_3D);

	editNom_prenom.setAnchor(ControlAnchor.TOPLEFTRIGHT);
	editNom_prenom.setEnabled(false);
	editNom_prenom.setLocation(new Point(335, 239));
	editNom_prenom.setSize(new Point(129, 20));
	editNom_prenom.setTabIndex(11);
	editNom_prenom.setText("");
	editNom_prenom.setVisible(false);
	editNom_prenom.setMaxLength(50);
	editNom_prenom.setMultiline(true);

	labelNif.setBackColor(Color.CONTROL);
	labelNif.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
	labelNif.setLocation(new Point(130, 263));
	labelNif.setSize(new Point(200, 20));
	labelNif.setTabIndex(12);
	labelNif.setTabStop(false);
	labelNif.setText("Nif");
	labelNif.setVisible(false);
	labelNif.setBorderStyle(BorderStyle.FIXED_3D);

	editNif.setAnchor(ControlAnchor.TOPLEFTRIGHT);
	editNif.setEnabled(false);
	editNif.setLocation(new Point(335, 263));
	editNif.setSize(new Point(129, 20));
	editNif.setTabIndex(13);
	editNif.setText("");
	editNif.setVisible(false);
	editNif.setMaxLength(15);
	editNif.setMultiline(true);

	labelNo_cheque.setBackColor(Color.CONTROL);
	labelNo_cheque.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
	labelNo_cheque.setLocation(new Point(130, 287));
	labelNo_cheque.setSize(new Point(200, 20));
	labelNo_cheque.setTabIndex(15);
	labelNo_cheque.setTabStop(false);
	labelNo_cheque.setText("No du Chèque");
	labelNo_cheque.setVisible(false);
	labelNo_cheque.setBorderStyle(BorderStyle.FIXED_3D);

	editNo_cheque.setAnchor(ControlAnchor.TOPLEFTRIGHT);
	editNo_cheque.setEnabled(false);
	editNo_cheque.setLocation(new Point(335, 287));
	editNo_cheque.setSize(new Point(129, 20));
	editNo_cheque.setTabIndex(16);
	editNo_cheque.setText("");
	editNo_cheque.setVisible(false);
	editNo_cheque.setMultiline(true);

	labelBanque.setBackColor(Color.CONTROL);
	labelBanque.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
	labelBanque.setLocation(new Point(130, 311));
	labelBanque.setSize(new Point(200, 20));
	labelBanque.setTabIndex(17);
	labelBanque.setTabStop(false);
	labelBanque.setText("Banque");
	labelBanque.setVisible(false);
	labelBanque.setBorderStyle(BorderStyle.FIXED_3D);

	editBanque.setAnchor(ControlAnchor.TOPLEFTRIGHT);
	editBanque.setEnabled(false);
	editBanque.setLocation(new Point(335, 313));
	editBanque.setSize(new Point(129, 20));
	editBanque.setTabIndex(18);
	editBanque.setText("");
	editBanque.setVisible(false);
	editBanque.setMaxLength(50);
	editBanque.setMultiline(true);

	labelMont_paye.setBackColor(Color.CONTROL);
	labelMont_paye.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
	labelMont_paye.setLocation(new Point(130, 337));
	labelMont_paye.setSize(new Point(200, 20));
	labelMont_paye.setTabIndex(20);
	labelMont_paye.setTabStop(false);
	labelMont_paye.setText("Montant   Payé");
	labelMont_paye.setVisible(false);
	labelMont_paye.setBorderStyle(BorderStyle.FIXED_3D);

	editMont_paye.setAnchor(ControlAnchor.TOPLEFTRIGHT);
	editMont_paye.setEnabled(false);
	editMont_paye.setLocation(new Point(335, 337));
	editMont_paye.setSize(new Point(129, 20));
	editMont_paye.setTabIndex(21);
	editMont_paye.setText("");
	editMont_paye.setVisible(false);
	editMont_paye.setMultiline(true);

	pictureBox6.setLocation(new Point(33, 17));
	pictureBox6.setSize(new Point(88, 80));
	pictureBox6.setTabIndex(5);
	pictureBox6.setTabStop(false);
	pictureBox6.setText("pictureBox2");
	pictureBox6.setBorderStyle(BorderStyle.FIXED_3D);
	pictureBox6.setImage((Bitmap)resources.getObject("pictureBox6_image"));
	pictureBox6.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

	label2.setBackColor(new Color(255, 255, 192));
	label2.setFont(new Font("Verdana", 12.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
	label2.setForeColor(Color.AQUA);
	label2.setLocation(new Point(192, 7));
	label2.setSize(new Point(328, 24));
	label2.setTabIndex(25);
	label2.setTabStop(false);
	label2.setText("Recherche  d\'un Remboursement");
	label2.setBorderStyle(BorderStyle.FIXED_3D);
	label2.setTextAlign(HorizontalAlignment.CENTER);

	labelNo_Avis.setBackColor(new Color(255, 255, 192));
	labelNo_Avis.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
	labelNo_Avis.setForeColor(Color.BLACK);
	labelNo_Avis.setLocation(new Point(73, 113));
	labelNo_Avis.setSize(new Point(184, 20));
	labelNo_Avis.setTabIndex(2);
	labelNo_Avis.setTabStop(false);
	labelNo_Avis.setText("Le No de Remboursement");
	labelNo_Avis.setBorderStyle(BorderStyle.FIXED_3D);

	label1.setLocation(new Point(65, 95));
	label1.setSize(new Point(472, 8));
	label1.setTabIndex(14);
	label1.setTabStop(false);
	label1.setText("");

	groupBox1.setBackColor(new Color(0, 192, 192));
	groupBox1.setLocation(new Point(65, 96));
	groupBox1.setSize(new Point(464, 48));
	groupBox1.setTabIndex(19);
	groupBox1.setTabStop(false);
	groupBox1.setText("");

	button1.setBackColor(Color.AQUA);
	button1.setLocation(new Point(288, 11));
	button1.setSize(new Point(32, 32));
	button1.setTabIndex(0);
	button1.setTabStop(false);
	button1.setText("pictureBox2");
	button1.setBorderStyle(BorderStyle.FIXED_3D);
	button1.setImage((Icon)resources.getObject("button1_image"));
	button1.addOnClick(new EventHandler(this.button1_click));

	panel2.setLocation(new Point(392, 32));
	panel2.setSize(new Point(88, 24));
	panel2.setTabIndex(0);
	panel2.setText("panel2");

	pan3.setLocation(new Point(32, 149));
	pan3.setSize(new Point(528, 224));
	pan3.setTabIndex(26);
	pan3.setText("panel3");
	pan3.setVisible(false);
	pan3.setBorderStyle(BorderStyle.FIXED_3D);

	pictureBox1.setLocation(new Point(56, 4));
	pictureBox1.setSize(new Point(88, 80));
	pictureBox1.setTabIndex(22);
	pictureBox1.setTabStop(false);
	pictureBox1.setText("pictureBox1");
	pictureBox1.setBorderStyle(BorderStyle.FIXED_3D);
	pictureBox1.setImage((Bitmap)resources.getObject("pictureBox1_image"));
	pictureBox1.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

	pictureBox3.setLocation(new Point(146, 4));
	pictureBox3.setSize(new Point(416, 32));
	pictureBox3.setTabIndex(4);
	pictureBox3.setTabStop(false);
	pictureBox3.setText("pictureBox2");
	pictureBox3.setBorderStyle(BorderStyle.FIXED_3D);
	pictureBox3.setImage((Bitmap)resources.getObject("pictureBox3_image"));
	pictureBox3.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

	pictureBox4.setLocation(new Point(22, 386));
	pictureBox4.setSize(new Point(544, 32));
	pictureBox4.setTabIndex(3);
	pictureBox4.setTabStop(false);
	pictureBox4.setText("pictureBox2");
	pictureBox4.setBorderStyle(BorderStyle.FIXED_3D);
	pictureBox4.setImage((Bitmap)resources.getObject("pictureBox4_image"));
	pictureBox4.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

	button2.setBackColor(Color.AQUA);
	button2.setLocation(new Point(406, 107));
	button2.setSize(new Point(30, 32));
	button2.setTabIndex(27);
	button2.setTabStop(false);
	button2.setText("pictureBox5");
	button2.setBorderStyle(BorderStyle.FIXED_3D);
	button2.setImage((Icon)resources.getObject("button2_image"));
	button2.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);
	button2.addOnClick(new EventHandler(this.button2_click));

	button3.setBackColor(Color.AQUA);
	button3.setLocation(new Point(456, 107));
	button3.setSize(new Point(30, 32));
	button3.setTabIndex(28);
	button3.setTabStop(false);
	button3.setText("pictureBox7");
	button3.setBorderStyle(BorderStyle.FIXED_3D);
	button3.setImage((Icon)resources.getObject("button3_image"));
	button3.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);
	button3.addOnClick(new EventHandler(this.button3_click));

	this.setNewControls(new Control[] {
						button3, 
						button2, 
						pictureBox4, 
						pictureBox1, 
						pictureBox6, 
						label2, 
						panel1, 
						label3, 
						label1, 
						labelNo_Avis, 
						labelRef_tit, 
						editRef_tit, 
						labelDate_Remb, 
						editDate_Remb, 
						labelNom_prenom, 
						editNom_prenom, 
						labelNif, 
						editNif, 
						labelNo_cheque, 
						editNo_cheque, 
						labelBanque, 
						editBanque, 
						labelMont_paye, 
						editMont_paye, 
						editNo_credit, 
						groupBox1, 
						group1, 
						pan3, 
						pictureBox3});
	group1.setNewControls(new Control[] {
						  panel2});
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
        Application.run( new Rech_P_Credit() );
    }
}
