//Rech_Avis.java

import com.ms.wfc.app.*;
import com.ms.wfc.core.*;
import com.ms.wfc.ui.*;
import com.ms.wfc.data.*;
import com.ms.wfc.data.ui.*;

public class Rech_Avis extends Form
{

    public void dispose()
    {
        super.dispose();
        components.dispose();
    }
	
    public Rech_Avis()
    {
        // Required for Visual J++ Form Designer support
        initForm();
        
        this.show();
        this.update();
		editNo_Avis.setText("0");
		editRef_Facture.setText("0");
		editDate_Recep.setText("");
		editReceveur.setText("");
		editProjection.setText("");

        //TODO: Add any constructor code after initForm call
    }    

    public void formClose(Event e)
    {
        Application.exit();
    }    

    
    void handleADOException(Exception e)
    {
        e.printStackTrace();
        MessageBox.show( e.toString(), "Rech_Avis" );
    }

   private void button1_click(Object source, Event e)
	{
		DataSource fin = new DataSource();
		DataBinder display = new DataBinder();
	
	try
	{  int navis = (Integer.valueOf(editNo_Avis.getText()).intValue());
		
		if(editNo_Avis.getText().equals("0"))
		{MessageBox.show("Veuillez Entrer le Numéro de l'Avis de Reception à Rechercher S.V.P !","Champ de Recheche à Remplir",MessageBox.ICONERROR);
		 }
		else
		{   
		    fin.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		    fin.setCommandText("select * from Avis where No_Avis = "+editNo_Avis.getText()+"");			  			
            fin.begin();
			
			if(String.valueOf(fin.getRecordset().getRecordCount()).equals("0"))
			   {MessageBox.show("Désolé,le Numéro d'Avis de Reception  <<"+editNo_Avis.getText()+">> est Introuvable !", " Recherche Echouée ",MessageBox.ICONSTOP);
		     	 editNo_Avis.setText("0");
			    }
			 else
			 {
			     display.setDataSource(fin);
				  display.setBindings(new DataBinding[]{
									 
							    new DataBinding(editRef_Facture,"text","Ref_Facture"),
							    new DataBinding(editDate_Recep,"text","Date_Recep"),
							    new DataBinding(editReceveur,"text","Receveur"),
							    new DataBinding(editProjection,"text","Projection"),
										  				 				  
									  });
				 
				 
				 
			    }
	        	}
		  	}
	       catch(NumberFormatException k){
		   MessageBox.show("Le Champ < Numéro de l'Avis de Reception > est de Type Numérique, Entrez le Numéro à Nouveau S.V.P  !","Données Incompatibles");
		   editNo_Avis.setText("0");
		  }	
	}

	private void button2_click(Object source, Event e)
	{
		editNo_Avis.setText("0");
		editRef_Facture.setText("0");
		editDate_Recep.setText("");
		editReceveur.setText("");
		editProjection.setText("");
			
	}

	private void button3_click(Object source, Event e)
	{
		int choi;
		choi=MessageBox.show("Etes-vous sur de Vouloir Abandonner l'Opération?", "Abandon",MessageBox.YESNO);
	    if(choi==MessageBox.IDYES)   
		{ hide();
		}
	}

	private void Rech_Avis_click(Object source, Event e)
	{
		
	}

	

	/**
	 * NOTE: The following code is required by the Visual J++ form
	 * designer.  It can be modified using the form editor.  Do not
	 * modify it using the code editor.
	 */
	Container components = new Container();
	Label labelNo_Avis = new Label();
	Edit editNo_Avis = new Edit();
	Label labelRef_Facture = new Label();
	Edit editRef_Facture = new Edit();
	Label labelDate_Recep = new Label();
	Edit editDate_Recep = new Edit();
	Label labelReceveur = new Label();
	Edit editReceveur = new Edit();
	Label labelProjection = new Label();
	Edit editProjection = new Edit();
	GroupBox groupBox1 = new GroupBox();
	Label label1 = new Label();
	GroupBox groupBox2 = new GroupBox();
	Label label3 = new Label();
	Label label2 = new Label();
	Panel panel1 = new Panel();
	Label label4 = new Label();
	PictureBox pictureBox6 = new PictureBox();
	PictureBox pictureBox1 = new PictureBox();
	PictureBox pictureBox2 = new PictureBox();
	Panel panel2 = new Panel();
	PictureBox pictureBox4 = new PictureBox();
	PictureBox button2 = new PictureBox();
	PictureBox button3 = new PictureBox();
	PictureBox button1 = new PictureBox();

	private void initForm()
	{
		// REMARQUE : cette feuille stocke des informations sur les ressources
		// dans un fichier externe. Ne modifiez le paramètre de chaîne d'aucun
		// appel de fonction resources.getObject(). Par exemple,
		// ne modifiez pas "foo1_location" dans la ligne de code
		// suivante, même si le nom de l'objet Foo change : 
		//	 foo1.setLocation((Point)resources.getObject("foo1_location"));

		IResourceManager resources = new ResourceManager(this, "Rech_Avis");
		this.setLocation(new Point(7, 7));
		this.setText("Recherche d\'un  Avis  de Reception");
		this.setAutoScaleBaseSize(new Point(5, 13));
		this.setAutoScroll(true);
		this.setBorderStyle(FormBorderStyle.NONE);
		this.setClientSize(new Point(500, 424));
		this.setMaximizeBox(false);
		this.setStartPosition(FormStartPosition.CENTER_SCREEN);
		this.addOnClick(new EventHandler(this.Rech_Avis_click));

		labelNo_Avis.setBackColor(new Color(255, 255, 192));
		labelNo_Avis.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNo_Avis.setForeColor(Color.BLACK);
		labelNo_Avis.setLocation(new Point(26, 145));
		labelNo_Avis.setSize(new Point(176, 20));
		labelNo_Avis.setTabIndex(7);
		labelNo_Avis.setTabStop(false);
		labelNo_Avis.setText("Le No de l\'avis de Reception");
		labelNo_Avis.setBorderStyle(BorderStyle.FIXED_3D);

		editNo_Avis.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNo_Avis.setLocation(new Point(205, 145));
		editNo_Avis.setSize(new Point(80, 20));
		editNo_Avis.setTabIndex(8);
		editNo_Avis.setText("");
		editNo_Avis.setMultiline(true);

		labelRef_Facture.setBackColor(Color.CONTROL);
		labelRef_Facture.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelRef_Facture.setLocation(new Point(92, 209));
		labelRef_Facture.setSize(new Point(160, 20));
		labelRef_Facture.setTabIndex(9);
		labelRef_Facture.setTabStop(false);
		labelRef_Facture.setText("No de la Facture Livrée ");
		labelRef_Facture.setBorderStyle(BorderStyle.FIXED_3D);

		editRef_Facture.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRef_Facture.setEnabled(false);
		editRef_Facture.setLocation(new Point(258, 208));
		editRef_Facture.setSize(new Point(96, 20));
		editRef_Facture.setTabIndex(10);
		editRef_Facture.setText("");
		editRef_Facture.setMultiline(true);

		labelDate_Recep.setBackColor(Color.CONTROL);
		labelDate_Recep.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelDate_Recep.setLocation(new Point(92, 259));
		labelDate_Recep.setSize(new Point(160, 20));
		labelDate_Recep.setTabIndex(11);
		labelDate_Recep.setTabStop(false);
		labelDate_Recep.setText("Date de Livraison");
		labelDate_Recep.setBorderStyle(BorderStyle.FIXED_3D);

		editDate_Recep.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editDate_Recep.setEnabled(false);
		editDate_Recep.setLocation(new Point(258, 258));
		editDate_Recep.setSize(new Point(96, 20));
		editDate_Recep.setTabIndex(12);
		editDate_Recep.setText("");
		editDate_Recep.setMaxLength(20);
		editDate_Recep.setMultiline(true);

		labelReceveur.setBackColor(Color.CONTROL);
		labelReceveur.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelReceveur.setLocation(new Point(92, 288));
		labelReceveur.setSize(new Point(160, 20));
		labelReceveur.setTabIndex(13);
		labelReceveur.setTabStop(false);
		labelReceveur.setText("Receveur de la Facture");
		labelReceveur.setBorderStyle(BorderStyle.FIXED_3D);

		editReceveur.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editReceveur.setEnabled(false);
		editReceveur.setLocation(new Point(258, 288));
		editReceveur.setSize(new Point(96, 20));
		editReceveur.setTabIndex(14);
		editReceveur.setText("");
		editReceveur.setMaxLength(50);
		editReceveur.setMultiline(true);

		labelProjection.setBackColor(Color.CONTROL);
		labelProjection.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelProjection.setLocation(new Point(92, 339));
		labelProjection.setSize(new Point(160, 20));
		labelProjection.setTabIndex(15);
		labelProjection.setTabStop(false);
		labelProjection.setText("Date de Projection");
		labelProjection.setBorderStyle(BorderStyle.FIXED_3D);

		editProjection.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editProjection.setEnabled(false);
		editProjection.setLocation(new Point(258, 339));
		editProjection.setSize(new Point(96, 20));
		editProjection.setTabIndex(16);
		editProjection.setText("");
		editProjection.setMaxLength(20);
		editProjection.setMultiline(true);

		groupBox1.setBackColor(new Color(0, 192, 192));
		groupBox1.setLocation(new Point(18, 128));
		groupBox1.setSize(new Point(456, 48));
		groupBox1.setTabIndex(17);
		groupBox1.setTabStop(false);
		groupBox1.setText("");

		label1.setLocation(new Point(18, 126));
		label1.setSize(new Point(464, 8));
		label1.setTabIndex(18);
		label1.setTabStop(false);
		label1.setText("");

		groupBox2.setLocation(new Point(78, 188));
		groupBox2.setSize(new Point(336, 176));
		groupBox2.setTabIndex(19);
		groupBox2.setTabStop(false);
		groupBox2.setText("");

		label3.setBackColor(Color.AQUA);
		label3.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, true, false, false, CharacterSet.DEFAULT, 0));
		label3.setForeColor(new Color(255, 255, 192));
		label3.setLocation(new Point(259, 240));
		label3.setSize(new Point(86, 16));
		label3.setTabIndex(6);
		label3.setTabStop(false);
		label3.setText("JJ / MM / AA");
		label3.setBorderStyle(BorderStyle.FIXED_3D);

		label2.setBackColor(Color.AQUA);
		label2.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, true, false, false, CharacterSet.DEFAULT, 0));
		label2.setForeColor(new Color(255, 255, 192));
		label2.setLocation(new Point(260, 321));
		label2.setSize(new Point(86, 16));
		label2.setTabIndex(3);
		label2.setTabStop(false);
		label2.setText("JJ / MM / AA");
		label2.setBorderStyle(BorderStyle.FIXED_3D);

		panel1.setBackColor(new Color(0, 192, 192));
		panel1.setLocation(new Point(6, 380));
		panel1.setSize(new Point(480, 40));
		panel1.setTabIndex(20);
		panel1.setText("panel1");
		panel1.setBorderStyle(BorderStyle.FIXED_3D);

		label4.setBackColor(new Color(255, 255, 192));
		label4.setFont(new Font("Verdana", 14.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label4.setForeColor(Color.AQUA);
		label4.setLocation(new Point(67, 7));
		label4.setSize(new Point(360, 23));
		label4.setTabIndex(21);
		label4.setTabStop(false);
		label4.setText("Recherche d\'Un  Avis de Reception");
		label4.setBorderStyle(BorderStyle.FIXED_3D);
		label4.setTextAlign(HorizontalAlignment.CENTER);

		pictureBox6.setLocation(new Point(18, 51));
		pictureBox6.setSize(new Point(88, 80));
		pictureBox6.setTabIndex(5);
		pictureBox6.setTabStop(false);
		pictureBox6.setText("pictureBox2");
		pictureBox6.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox6.setImage((Bitmap)resources.getObject("pictureBox6_image"));
		pictureBox6.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox1.setLocation(new Point(41, 38));
		pictureBox1.setSize(new Point(88, 80));
		pictureBox1.setTabIndex(22);
		pictureBox1.setTabStop(false);
		pictureBox1.setText("pictureBox1");
		pictureBox1.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox1.setImage((Bitmap)resources.getObject("pictureBox1_image"));
		pictureBox1.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox2.setLocation(new Point(18, 3));
		pictureBox2.setSize(new Point(456, 32));
		pictureBox2.setTabIndex(0);
		pictureBox2.setTabStop(false);
		pictureBox2.setText("pictureBox2");
		pictureBox2.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox2.setImage((Bitmap)resources.getObject("pictureBox2_image"));
		pictureBox2.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		panel2.setLocation(new Point(18, 184));
		panel2.setSize(new Point(456, 184));
		panel2.setTabIndex(23);
		panel2.setText("panel2");
		panel2.setBorderStyle(BorderStyle.FIXED_3D);

		pictureBox4.setLocation(new Point(25, 385));
		pictureBox4.setSize(new Point(440, 32));
		pictureBox4.setTabIndex(4);
		pictureBox4.setTabStop(false);
		pictureBox4.setText("pictureBox2");
		pictureBox4.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox4.setImage((Bitmap)resources.getObject("pictureBox4_image"));
		pictureBox4.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		button2.setBackColor(Color.AQUA);
		button2.setLocation(new Point(335, 139));
		button2.setSize(new Point(30, 32));
		button2.setTabIndex(1);
		button2.setTabStop(false);
		button2.setText("pictureBox3");
		button2.setBorderStyle(BorderStyle.FIXED_3D);
		button2.setImage((Icon)resources.getObject("button2_image"));
		button2.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);
		button2.addOnClick(new EventHandler(this.button2_click));

		button3.setBackColor(Color.AQUA);
		button3.setLocation(new Point(381, 139));
		button3.setSize(new Point(30, 32));
		button3.setTabIndex(2);
		button3.setTabStop(false);
		button3.setText("pictureBox3");
		button3.setBorderStyle(BorderStyle.FIXED_3D);
		button3.setImage((Icon)resources.getObject("button3_image"));
		button3.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);
		button3.addOnClick(new EventHandler(this.button3_click));

		button1.setLocation(new Point(288, 139));
		button1.setSize(new Point(30, 32));
		button1.setTabIndex(24);
		button1.setTabStop(false);
		button1.setText("pictureBox3");
		button1.setBorderStyle(BorderStyle.FIXED_3D);
		button1.setImage((Icon)resources.getObject("button1_image"));
		button1.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);
		button1.addOnClick(new EventHandler(this.button1_click));

		this.setNewControls(new Control[] {
							button1, 
							button3, 
							button2, 
							pictureBox4, 
							pictureBox1, 
							pictureBox6, 
							label4, 
							panel1, 
							label2, 
							label3, 
							label1, 
							labelNo_Avis, 
							editNo_Avis, 
							labelRef_Facture, 
							editRef_Facture, 
							labelDate_Recep, 
							editDate_Recep, 
							labelReceveur, 
							editReceveur, 
							labelProjection, 
							editProjection, 
							groupBox1, 
							groupBox2, 
							pictureBox2, 
							panel2});
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
        Application.run( new Rech_Avis() );
    }
}
