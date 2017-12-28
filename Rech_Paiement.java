//Rech_Paiement.java
import com.ms.wfc.app.*;
import com.ms.wfc.core.*;
import com.ms.wfc.ui.*;
import com.ms.wfc.data.*;
import com.ms.wfc.data.ui.*;


public class Rech_Paiement extends Form
{

    public void dispose()
    {
        super.dispose();
        components.dispose();
    }
	
    public Rech_Paiement()
    {
        // Required for Visual J++ Form Designer support
        initForm();
        
        this.show();
        this.update();
		editNo_recu.setText("0");
		editDate.setText("");
		editRef_comp.setText("");
		editRef_fact.setText("0");
		editRef_titul.setText("0");
		editNo_cheque.setText("0");
		editBanque.setText("");
		editSom_recue.setText("0");

        //TODO: Add any constructor code after initForm call
    }    

    public void formClose(Event e)
    {
        Application.exit();
    }    

    
    void handleADOException(Exception e)
    {
        e.printStackTrace();
        MessageBox.show( e.toString(), "Rech_Paiement" );
    }

	private void button1_click(Object source, Event e)
	{
		DataSource find = new DataSource();
		DataBinder display = new DataBinder();
		
 try
 {		int nrec = (Integer.valueOf(editNo_recu.getText()).intValue());
		
		if(editNo_recu.getText().equals("0"))
		{MessageBox.show("Veuillez Entrer le Numéro du Paiement à Rechercher S.V.P !","Champ de Recheche à Remplir",MessageBox.ICONERROR);
		 }
		else
		{   
		    find.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		    find.setCommandText("select * from Reception where No_recu = "+editNo_recu.getText()+"");			  			
            find.begin();
			
			if(String.valueOf(find.getRecordset().getRecordCount()).equals("0"))
			   {MessageBox.show("Desolé,Le Paiement Numéro  << "+editNo_recu.getText()+" >> est Introuvable !", " Recherche Echouée ",MessageBox.ICONSTOP);
		     	editNo_recu.setText("0");
			    }
			else
				
			{
				display.setDataSource(find);
				  display.setBindings(new DataBinding[]{
									 
							    new DataBinding(editDate,"text","Date"),
							    new DataBinding(editRef_comp,"text","Ref_comp"),
							    new DataBinding(editRef_fact,"text","Ref_fact"),
							    new DataBinding(editRef_titul,"text","Ref_titul"),
								new DataBinding(editNo_cheque,"text","No_cheque"),
																				
								new DataBinding(editBanque,"text","Banque"),
								new DataBinding(editSom_recue,"text","Som_recue"),
								  				 				  
									  });
					
			
			     }
		
	        }
         }
 
	       catch(NumberFormatException k){
		   MessageBox.show("Le Champ < Numéro de Paiement > est de Type Numérique, Entrez le Numéro à Nouveau S.V.P  !","Données Incompatibles",MessageBox.ICONERROR);
		   editNo_recu.setText("0");
		  }	
	
				
		
	}

	private void button3_click(Object source, Event e)
	{
		int choi;
		choi=MessageBox.show("Etes-vous sur de vouloir abandonner l'opération?", "Abandon",MessageBox.YESNO);
	    if(choi==MessageBox.IDYES)   
		{ hide();
		}
	}

	private void button2_click(Object source, Event e)
	{
		editNo_recu.setText("0");
		editDate.setText("");
		editRef_comp.setText("");
		editRef_fact.setText("0");
		editRef_titul.setText("0");
		editNo_cheque.setText("0");
		editBanque.setText("");
		editSom_recue.setText("0");
	}

	

	

	/**
	 * NOTE: The following code is required by the Visual J++ form
	 * designer.  It can be modified using the form editor.  Do not
	 * modify it using the code editor.
	 */
	Container components = new Container();
	PictureBox button3 = new PictureBox();
	Label labelNo_recu = new Label();
	Edit editNo_recu = new Edit();
	Label labelDate = new Label();
	Edit editDate = new Edit();
	Label labelRef_comp = new Label();
	Edit editRef_comp = new Edit();
	Label labelRef_fact = new Label();
	Edit editRef_fact = new Edit();
	Label labelRef_titul = new Label();
	Edit editRef_titul = new Edit();
	Label labelNo_cheque = new Label();
	Edit editNo_cheque = new Edit();
	Label labelBanque = new Label();
	Edit editBanque = new Edit();
	Label labelSom_recue = new Label();
	Edit editSom_recue = new Edit();
	Panel panel1 = new Panel();
	GroupBox groupBox1 = new GroupBox();
	GroupBox groupBox2 = new GroupBox();
	Label label1 = new Label();
	PictureBox pictureBox6 = new PictureBox();
	Label label2 = new Label();
	Label label3 = new Label();
	PictureBox pictureBox1 = new PictureBox();
	PictureBox pictureBox2 = new PictureBox();
	PictureBox button1 = new PictureBox();
	PictureBox pictureBox4 = new PictureBox();
	PictureBox button2 = new PictureBox();

	private void initForm()
	{
		// REMARQUE : cette feuille stocke des informations sur les ressources
		// dans un fichier externe. Ne modifiez le paramètre de chaîne d'aucun
		// appel de fonction resources.getObject(). Par exemple,
		// ne modifiez pas "foo1_location" dans la ligne de code
		// suivante, même si le nom de l'objet Foo change : 
		//	 foo1.setLocation((Point)resources.getObject("foo1_location"));

		IResourceManager resources = new ResourceManager(this, "Rech_Paiement");
		this.setLocation(new Point(7, 7));
		this.setText("Recherche de Paiement d\'une Compagnie");
		this.setAutoScaleBaseSize(new Point(5, 13));
		this.setAutoScroll(true);
		this.setBorderStyle(FormBorderStyle.NONE);
		this.setClientSize(new Point(501, 431));
		this.setMaximizeBox(false);
		this.setStartPosition(FormStartPosition.CENTER_SCREEN);

		button3.setBackColor(Color.AQUA);
		button3.setLocation(new Point(401, 136));
		button3.setSize(new Point(30, 32));
		button3.setTabIndex(25);
		button3.setTabStop(false);
		button3.setText("pictureBox3");
		button3.setBorderStyle(BorderStyle.FIXED_3D);
		button3.setImage((Icon)resources.getObject("button3_image"));
		button3.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);
		button3.addOnClick(new EventHandler(this.button3_click));

		labelNo_recu.setBackColor(new Color(255, 255, 192));
		labelNo_recu.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNo_recu.setForeColor(Color.BLACK);
		labelNo_recu.setLocation(new Point(18, 144));
		labelNo_recu.setSize(new Point(200, 20));
		labelNo_recu.setTabIndex(1);
		labelNo_recu.setTabStop(false);
		labelNo_recu.setText("Le No de Paiement à Rechercher");
		labelNo_recu.setBorderStyle(BorderStyle.FIXED_3D);

		editNo_recu.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNo_recu.setLocation(new Point(224, 144));
		editNo_recu.setSize(new Point(81, 20));
		editNo_recu.setTabIndex(2);
		editNo_recu.setText("");
		editNo_recu.setMultiline(true);

		labelDate.setBackColor(Color.CONTROL);
		labelDate.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelDate.setLocation(new Point(67, 206));
		labelDate.setSize(new Point(152, 20));
		labelDate.setTabIndex(3);
		labelDate.setTabStop(false);
		labelDate.setText("Date de Paiement");
		labelDate.setBorderStyle(BorderStyle.FIXED_3D);

		editDate.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editDate.setEnabled(false);
		editDate.setLocation(new Point(226, 206));
		editDate.setSize(new Point(121, 20));
		editDate.setTabIndex(4);
		editDate.setText("");
		editDate.setMaxLength(10);
		editDate.setMultiline(true);

		labelRef_comp.setBackColor(Color.CONTROL);
		labelRef_comp.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelRef_comp.setLocation(new Point(67, 230));
		labelRef_comp.setSize(new Point(152, 20));
		labelRef_comp.setTabIndex(7);
		labelRef_comp.setTabStop(false);
		labelRef_comp.setText("Le Nom de la Compagnie");
		labelRef_comp.setBorderStyle(BorderStyle.FIXED_3D);

		editRef_comp.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRef_comp.setLocation(new Point(226, 230));
		editRef_comp.setSize(new Point(200, 20));
		editRef_comp.setTabIndex(8);
		editRef_comp.setText("");
		editRef_comp.setMaxLength(50);
		editRef_comp.setMultiline(true);
		editRef_comp.setReadOnly(true);

		labelRef_fact.setBackColor(Color.CONTROL);
		labelRef_fact.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelRef_fact.setLocation(new Point(67, 254));
		labelRef_fact.setSize(new Point(152, 20));
		labelRef_fact.setTabIndex(9);
		labelRef_fact.setTabStop(false);
		labelRef_fact.setText("No de la Facture Payée");
		labelRef_fact.setBorderStyle(BorderStyle.FIXED_3D);

		editRef_fact.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRef_fact.setLocation(new Point(226, 254));
		editRef_fact.setSize(new Point(121, 20));
		editRef_fact.setTabIndex(10);
		editRef_fact.setText("");
		editRef_fact.setMultiline(true);
		editRef_fact.setReadOnly(true);

		labelRef_titul.setBackColor(Color.CONTROL);
		labelRef_titul.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelRef_titul.setLocation(new Point(67, 278));
		labelRef_titul.setSize(new Point(152, 20));
		labelRef_titul.setTabIndex(11);
		labelRef_titul.setTabStop(false);
		labelRef_titul.setText("La Référence  du Titulaire");
		labelRef_titul.setBorderStyle(BorderStyle.FIXED_3D);

		editRef_titul.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRef_titul.setLocation(new Point(226, 278));
		editRef_titul.setSize(new Point(121, 20));
		editRef_titul.setTabIndex(12);
		editRef_titul.setText("");
		editRef_titul.setMultiline(true);
		editRef_titul.setReadOnly(true);

		labelNo_cheque.setBackColor(Color.CONTROL);
		labelNo_cheque.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNo_cheque.setLocation(new Point(67, 302));
		labelNo_cheque.setSize(new Point(152, 20));
		labelNo_cheque.setTabIndex(13);
		labelNo_cheque.setTabStop(false);
		labelNo_cheque.setText("Le No du chèque Reçu");
		labelNo_cheque.setBorderStyle(BorderStyle.FIXED_3D);

		editNo_cheque.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNo_cheque.setEnabled(false);
		editNo_cheque.setLocation(new Point(226, 302));
		editNo_cheque.setSize(new Point(121, 20));
		editNo_cheque.setTabIndex(14);
		editNo_cheque.setText("");
		editNo_cheque.setMultiline(true);

		labelBanque.setBackColor(Color.CONTROL);
		labelBanque.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelBanque.setLocation(new Point(67, 326));
		labelBanque.setSize(new Point(152, 20));
		labelBanque.setTabIndex(15);
		labelBanque.setTabStop(false);
		labelBanque.setText("Banque ");
		labelBanque.setBorderStyle(BorderStyle.FIXED_3D);

		editBanque.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editBanque.setEnabled(false);
		editBanque.setLocation(new Point(226, 326));
		editBanque.setSize(new Point(121, 20));
		editBanque.setTabIndex(16);
		editBanque.setText("");
		editBanque.setMaxLength(50);
		editBanque.setMultiline(true);

		labelSom_recue.setBackColor(Color.CONTROL);
		labelSom_recue.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelSom_recue.setLocation(new Point(67, 350));
		labelSom_recue.setSize(new Point(152, 20));
		labelSom_recue.setTabIndex(17);
		labelSom_recue.setTabStop(false);
		labelSom_recue.setText("Montant du Chèque Reçu");
		labelSom_recue.setBorderStyle(BorderStyle.FIXED_3D);

		editSom_recue.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editSom_recue.setEnabled(false);
		editSom_recue.setLocation(new Point(226, 350));
		editSom_recue.setSize(new Point(121, 20));
		editSom_recue.setTabIndex(18);
		editSom_recue.setText("");
		editSom_recue.setMultiline(true);

		panel1.setBackColor(new Color(0, 192, 192));
		panel1.setLocation(new Point(7, 387));
		panel1.setSize(new Point(480, 38));
		panel1.setTabIndex(19);
		panel1.setText("panel1");
		panel1.setBorderStyle(BorderStyle.FIXED_3D);

		groupBox1.setLocation(new Point(51, 174));
		groupBox1.setSize(new Point(392, 208));
		groupBox1.setTabIndex(20);
		groupBox1.setTabStop(false);
		groupBox1.setText("");

		groupBox2.setBackColor(new Color(0, 192, 192));
		groupBox2.setLocation(new Point(9, 126));
		groupBox2.setSize(new Point(472, 48));
		groupBox2.setTabIndex(21);
		groupBox2.setTabStop(false);
		groupBox2.setText("");

		label1.setLocation(new Point(8, 124));
		label1.setSize(new Point(480, 8));
		label1.setTabIndex(22);
		label1.setTabStop(false);
		label1.setText("");

		pictureBox6.setLocation(new Point(9, 49));
		pictureBox6.setSize(new Point(88, 80));
		pictureBox6.setTabIndex(6);
		pictureBox6.setTabStop(false);
		pictureBox6.setText("pictureBox2");
		pictureBox6.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox6.setImage((Bitmap)resources.getObject("pictureBox6_image"));
		pictureBox6.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		label2.setBackColor(new Color(255, 255, 192));
		label2.setFont(new Font("Verdana", 12.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label2.setForeColor(Color.AQUA);
		label2.setLocation(new Point(49, 5));
		label2.setSize(new Point(376, 23));
		label2.setTabIndex(23);
		label2.setTabStop(false);
		label2.setText("Recherche de Paiement d\'une Compagnie");
		label2.setBorderStyle(BorderStyle.FIXED_3D);
		label2.setTextAlign(HorizontalAlignment.CENTER);

		label3.setBackColor(Color.AQUA);
		label3.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, true, false, false, CharacterSet.DEFAULT, 0));
		label3.setForeColor(new Color(255, 255, 192));
		label3.setLocation(new Point(176, 14));
		label3.setSize(new Point(110, 16));
		label3.setTabIndex(0);
		label3.setTabStop(false);
		label3.setText("JJ / MM / AA");
		label3.setBorderStyle(BorderStyle.FIXED_3D);

		pictureBox1.setLocation(new Point(32, 36));
		pictureBox1.setSize(new Point(88, 80));
		pictureBox1.setTabIndex(24);
		pictureBox1.setTabStop(false);
		pictureBox1.setText("pictureBox1");
		pictureBox1.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox1.setImage((Bitmap)resources.getObject("pictureBox1_image"));
		pictureBox1.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox2.setLocation(new Point(9, 1));
		pictureBox2.setSize(new Point(456, 32));
		pictureBox2.setTabIndex(5);
		pictureBox2.setTabStop(false);
		pictureBox2.setText("pictureBox2");
		pictureBox2.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox2.setImage((Bitmap)resources.getObject("pictureBox2_image"));
		pictureBox2.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		button1.setBackColor(Color.AQUA);
		button1.setLocation(new Point(308, 136));
		button1.setSize(new Point(32, 32));
		button1.setTabIndex(0);
		button1.setTabStop(false);
		button1.setText("pictureBox2");
		button1.setBorderStyle(BorderStyle.FIXED_3D);
		button1.setImage((Icon)resources.getObject("button1_image"));
		button1.addOnClick(new EventHandler(this.button1_click));

		pictureBox4.setLocation(new Point(17, 3));
		pictureBox4.setSize(new Point(440, 30));
		pictureBox4.setTabIndex(0);
		pictureBox4.setTabStop(false);
		pictureBox4.setText("pictureBox4");
		pictureBox4.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox4.setImage((Bitmap)resources.getObject("pictureBox4_image"));
		pictureBox4.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		button2.setBackColor(Color.AQUA);
		button2.setLocation(new Point(356, 136));
		button2.setSize(new Point(30, 32));
		button2.setTabIndex(26);
		button2.setTabStop(false);
		button2.setText("pictureBox5");
		button2.setBorderStyle(BorderStyle.FIXED_3D);
		button2.setImage((Icon)resources.getObject("button2_image"));
		button2.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);
		button2.addOnClick(new EventHandler(this.button2_click));

		this.setNewControls(new Control[] {
							button2, 
							button3, 
							button1, 
							pictureBox1, 
							pictureBox6, 
							label2, 
							label1, 
							panel1, 
							labelNo_recu, 
							editNo_recu, 
							labelDate, 
							editDate, 
							labelRef_comp, 
							editRef_comp, 
							labelRef_fact, 
							editRef_fact, 
							labelRef_titul, 
							editRef_titul, 
							labelNo_cheque, 
							editNo_cheque, 
							labelBanque, 
							editBanque, 
							labelSom_recue, 
							editSom_recue, 
							groupBox1, 
							groupBox2, 
							pictureBox2});
		panel1.setNewControls(new Control[] {
							  pictureBox4});
		groupBox1.setNewControls(new Control[] {
								 label3});
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
        Application.run( new Rech_Paiement() );
    }
}
