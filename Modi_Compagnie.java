//Modi_Compagnie.java

import com.ms.wfc.app.*;
import com.ms.wfc.core.*;
import com.ms.wfc.ui.*;
import com.ms.wfc.data.*;
import com.ms.wfc.data.ui.*;

public class Modi_Compagnie extends Form
{    String c1 =new String();
	 String c2 =new String();
	 String c3 =new String();
	 String c4 =new String();
	 String c5 =new String();
	 	   
    public void dispose() 
    {
        super.dispose();
        components.dispose();
    }
	
    public Modi_Compagnie()
    {
        // Required for Visual J++ Form Designer support
        initForm();
        
        this.show();
        this.update();
		 edit1.setText("");
		 edit2.setText("");
		 edit3.setText("");
		 edit4.setText("");
		 edit5.setText("");
		 edit6.setText("");

        //TODO: Add any constructor code after initForm call
    }    

    public void formClose(Event e)
    {
        Application.exit();
    }    

    
    void handleADOException(Exception e)
    {
        e.printStackTrace();
        MessageBox.show( e.toString(), "Modi_Compagnie" );
    }

	private void button1_click(Object source, Event e)
	{
	  if(edit1.getText().equals(""))
		{MessageBox.show("Veuillez Entrer Le Nom de la Compagnie d'Assurance S.V.P !"," Champ de Recheche à Remplir",MessageBox.ICONERROR);
		
		}
		else
		{   DataSource find = new DataSource();
		    find.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		    find.setCommandText("select * from Compagnie where Nom = '"+edit1.getText()+"'");			  			
            find.begin();
			
			if(String.valueOf(find.getRecordset().getRecordCount()).equals("0"))
			   {MessageBox.show("Désolé, Vous ne Pouvez Modifier les Donneées de la Compagnie '"+edit1.getText()+"',Car elle n'Esxiste pas !", " Opération Illégale",MessageBox.ICONSTOP);
		     	 edit1.setText("");
			    }
			else
			{     DataBinder display = new DataBinder();
				  display.setDataSource(find);
				  display.setBindings(new DataBinding[]{
							    new DataBinding(editNom,"text","Nom"),
							    new DataBinding(editAdresse,"text","Adresse"),
							    new DataBinding(editPhone_1,"text","Phone_1"),
							    new DataBinding(editPhone_2,"text","Phone_2"),
								new DataBinding(editEmail,"text","Email"),
								new DataBinding(editSite_web,"text","Site_web"),
								new DataBinding(editCharge_totale,"text","Charge_totale"),	  
							    					   });
				               c1=editAdresse.getText();
							   c2=editPhone_1.getText();
				               c3=editPhone_2.getText();
							   c4=editEmail.getText();
							   c5=editSite_web.getText();
				                 
								 labelNom.setVisible(true);
								 labelAdresse.setVisible(true);
								 labelPhone_1.setVisible(true);
								 labelPhone_2.setVisible(true);
								 labelEmail.setVisible(true);
								 labelSite_web.setVisible(true);
								 labelCharge_totale.setVisible(true);
								 								 							 
								 editNom.setVisible(true);
							     editAdresse.setVisible(true);
							     editPhone_1.setVisible(true);
							     editPhone_2.setVisible(true);
								 editEmail.setVisible(true);
							     editSite_web.setVisible(true);
								 editCharge_totale.setVisible(true);
								 
								 label2.setVisible(true);
								 label3.setVisible(true);
								 label4.setVisible(true);
								 label5.setVisible(true);
								 label6.setVisible(true);
								 label7.setVisible(true);
								 
								 edit2.setVisible(true);
							     edit3.setVisible(true);
							     edit4.setVisible(true);
							     edit5.setVisible(true);
								 edit6.setVisible(true);
							     
								 panel1.setVisible(true);
								 button2.setVisible(true);
								 button5.setEnabled(false);
								 button4.setVisible(true);
								 button1.setEnabled(false);
								 button3.setEnabled(true);
								 button3.setVisible(true);
								 g1.setVisible(true);
								 g2.setVisible(true);
							     p1.setVisible(true);
									 
										
			}
		}
	}

	

	private void button2_click(Object source, Event e)
	{   
		 edit1.setText("");
		 edit2.setText("");
		 edit3.setText("");
		 edit4.setText("");
		 edit5.setText("");
		 edit6.setText("");
			
		labelNom.setVisible(false);
		labelAdresse.setVisible(false);
	    labelPhone_1.setVisible(false);
		labelPhone_2.setVisible(false);
		labelEmail.setVisible(false);
		labelSite_web.setVisible(false);
		labelCharge_totale.setVisible(false);
								 								 							 
		editNom.setVisible(false);
		editAdresse.setVisible(false);
		editPhone_1.setVisible(false);
		editPhone_2.setVisible(false);
		editEmail.setVisible(false);
		editSite_web.setVisible(false);
		editCharge_totale.setVisible(false);
								 
		label2.setVisible(false);
		label3.setVisible(false);
		label4.setVisible(false);
		label5.setVisible(false);
		label6.setVisible(false);
		label7.setVisible(false);
								 
		edit2.setVisible(false);
		edit3.setVisible(false);
		edit4.setVisible(false);
		edit5.setVisible(false);
	    edit6.setVisible(false);
							     
		panel1.setVisible(false);
		button1.setEnabled(true);
		button2.setVisible(false);
		button3.setVisible(false);
		button5.setEnabled(true);
		
		g1.setVisible(false);
		g2.setVisible(false);
		p1.setVisible(false);
		
		
	}

	private void button3_click(Object source, Event e)
	{          Connection co = new Connection();
	           Recordset to = new Recordset();
		       int ch; 
			   
			   if(edit2.getText().equals(""))
			   {edit2.setText(c1);
				
			   } 
			         
				if(edit3.getText().equals(""))
			      { edit3.setText(c2);   
				   } 
			 
				 if(edit4.getText().equals(""))
			       {
				    edit4.setText(c3);
			       } 
			  
				   if(edit5.getText().equals(""))
			        {
				    edit5.setText(c4);
			       }
			  
			       if(edit6.getText().equals(""))
			        {
				     edit6.setText(c5);
			         } 
			    try
				{
				       ch=MessageBox.show("Etes-vous sur de vouloir modifier ces données?", "Moment de Décision",MessageBox.YESNO);
				          if(ch==MessageBox.IDYES)   
						  {  co.setConnectionString("dsn=HAH;uid=genial;pwd=genial");
				             co.open();
							 to.setActiveConnection(co);
							 to.setSource("Update Compagnie set Adresse = '"+edit2.getText()+"',Phone_1='" +edit3.getText()+"',Phone_2='"+edit4.getText()+"',Email='"+edit5.getText()+"',Site_web='"+edit6.getText()+"' where Nom ='"+edit1.getText()+"'");
							 to.open();
							 MessageBox.show("Bravo! Les Modifications pour la Compagnie << "+edit1.getText()+" >> sont Effectuées ","Mises à jour Réussies",MessageBox.ICONINFORMATION); 
						     button3.setEnabled(false);
							}
			
				}
				
				catch(com.ms.wfc.data.AdoException ex)
                 {  MessageBox.show("Attention! Doublez les Aprostrophes Dans les Champs qui les Contiennent puis, Essayez à Nouveau la Modification","Données Incompatibles",MessageBox.ICONERROR);

                 }
 
		      }
	
	private void button4_click(Object source, Event e)
	{
		int choi;
		choi=MessageBox.show("Etes-vous sur de vouloir abandonner l'opération?", "Abandon",MessageBox.YESNO);
	    if(choi==MessageBox.IDYES)   
		{ hide();
		}
	}

	private void button5_click(Object source, Event e)
	{
		edit1.setText("");
	}

	

	/**
	 * NOTE: The following code is required by the Visual J++ form
	 * designer.  It can be modified using the form editor.  Do not
	 * modify it using the code editor.
	 */
	Container components = new Container();
	Edit edit1 = new Edit();
	Label label1 = new Label();
	Label labelNom = new Label();
	Edit editNom = new Edit();
	Label labelAdresse = new Label();
	Edit editAdresse = new Edit();
	Label labelPhone_1 = new Label();
	Edit editPhone_1 = new Edit();
	Label labelPhone_2 = new Label();
	Edit editPhone_2 = new Edit();
	Label labelEmail = new Label();
	Edit editEmail = new Edit();
	Label labelSite_web = new Label();
	Edit editSite_web = new Edit();
	Label labelCharge_totale = new Label();
	Edit editCharge_totale = new Edit();
	Label label2 = new Label();
	Edit edit2 = new Edit();
	Label label3 = new Label();
	Edit edit3 = new Edit();
	Label label4 = new Label();
	Edit edit4 = new Edit();
	Label label5 = new Label();
	Edit edit5 = new Edit();
	Label label6 = new Label();
	Edit edit6 = new Edit();
	Button button1 = new Button();
	Panel panel1 = new Panel();
	Button button2 = new Button();
	Button button3 = new Button();
	Button button4 = new Button();
	Label label7 = new Label();
	PictureBox pictureBox1 = new PictureBox();
	Label label8 = new Label();
	Button button5 = new Button();
	GroupBox groupBox1 = new GroupBox();
	GroupBox g1 = new GroupBox();
	GroupBox g2 = new GroupBox();
	PictureBox pictureBox4 = new PictureBox();
	PictureBox pictureBox6 = new PictureBox();
	PictureBox p1 = new PictureBox();

	private void initForm()
	{
		// REMARQUE : cette feuille stocke des informations sur les ressources
		// dans un fichier externe. Ne modifiez le paramètre de chaîne d'aucun
		// appel de fonction resources.getObject(). Par exemple,
		// ne modifiez pas "foo1_location" dans la ligne de code
		// suivante, même si le nom de l'objet Foo change : 
		//	 foo1.setLocation((Point)resources.getObject("foo1_location"));

		IResourceManager resources = new ResourceManager(this, "Modi_Compagnie");
		this.setLocation(new Point(7, 7));
		this.setText("Modification des Coordonnées d\'une Compagnie ");
		this.setAutoScaleBaseSize(new Point(5, 13));
		this.setAutoScroll(true);
		this.setBorderStyle(FormBorderStyle.NONE);
		this.setClientSize(new Point(592, 423));
		this.setMaximizeBox(false);
		this.setStartPosition(FormStartPosition.CENTER_SCREEN);

		edit1.setLocation(new Point(35, 152));
		edit1.setSize(new Point(248, 20));
		edit1.setTabIndex(29);
		edit1.setText("");
		edit1.setCharacterCasing(CharacterCasing.UPPER);

		label1.setBackColor(new Color(255, 255, 192));
		label1.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label1.setLocation(new Point(27, 124));
		label1.setSize(new Point(512, 24));
		label1.setTabIndex(30);
		label1.setTabStop(false);
		label1.setText("Entrez le Nom de la Compagnie  Pour laquelle vous voulez faire des mises à jour");
		label1.setBorderStyle(BorderStyle.FIXED_3D);
		label1.setTextAlign(HorizontalAlignment.CENTER);

		labelNom.setBackColor(Color.CONTROL);
		labelNom.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNom.setLocation(new Point(31, 191));
		labelNom.setSize(new Point(100, 20));
		labelNom.setTabIndex(14);
		labelNom.setTabStop(false);
		labelNom.setText("Nom");
		labelNom.setVisible(false);
		labelNom.setBorderStyle(BorderStyle.FIXED_3D);

		editNom.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNom.setEnabled(false);
		editNom.setLocation(new Point(136, 191));
		editNom.setSize(new Point(144, 20));
		editNom.setTabIndex(15);
		editNom.setText("");
		editNom.setVisible(false);
		editNom.setMaxLength(50);
		editNom.setReadOnly(true);

		labelAdresse.setBackColor(Color.CONTROL);
		labelAdresse.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelAdresse.setLocation(new Point(31, 215));
		labelAdresse.setSize(new Point(100, 20));
		labelAdresse.setTabIndex(16);
		labelAdresse.setTabStop(false);
		labelAdresse.setText("Adresse");
		labelAdresse.setVisible(false);
		labelAdresse.setBorderStyle(BorderStyle.FIXED_3D);

		editAdresse.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editAdresse.setLocation(new Point(136, 216));
		editAdresse.setSize(new Point(144, 20));
		editAdresse.setTabIndex(17);
		editAdresse.setText("");
		editAdresse.setVisible(false);
		editAdresse.setMaxLength(50);
		editAdresse.setReadOnly(true);

		labelPhone_1.setBackColor(Color.CONTROL);
		labelPhone_1.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelPhone_1.setLocation(new Point(31, 239));
		labelPhone_1.setSize(new Point(100, 20));
		labelPhone_1.setTabIndex(18);
		labelPhone_1.setTabStop(false);
		labelPhone_1.setText("Phone_1");
		labelPhone_1.setVisible(false);
		labelPhone_1.setBorderStyle(BorderStyle.FIXED_3D);

		editPhone_1.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editPhone_1.setLocation(new Point(136, 240));
		editPhone_1.setSize(new Point(144, 20));
		editPhone_1.setTabIndex(19);
		editPhone_1.setText("");
		editPhone_1.setVisible(false);
		editPhone_1.setMaxLength(12);
		editPhone_1.setReadOnly(true);

		labelPhone_2.setBackColor(Color.CONTROL);
		labelPhone_2.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelPhone_2.setLocation(new Point(31, 264));
		labelPhone_2.setSize(new Point(100, 20));
		labelPhone_2.setTabIndex(20);
		labelPhone_2.setTabStop(false);
		labelPhone_2.setText("Phone_2");
		labelPhone_2.setVisible(false);
		labelPhone_2.setBorderStyle(BorderStyle.FIXED_3D);

		editPhone_2.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editPhone_2.setLocation(new Point(136, 264));
		editPhone_2.setSize(new Point(144, 20));
		editPhone_2.setTabIndex(21);
		editPhone_2.setText("");
		editPhone_2.setVisible(false);
		editPhone_2.setMaxLength(12);
		editPhone_2.setReadOnly(true);

		labelEmail.setBackColor(Color.CONTROL);
		labelEmail.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelEmail.setLocation(new Point(31, 288));
		labelEmail.setSize(new Point(100, 20));
		labelEmail.setTabIndex(22);
		labelEmail.setTabStop(false);
		labelEmail.setText("Email");
		labelEmail.setVisible(false);
		labelEmail.setBorderStyle(BorderStyle.FIXED_3D);

		editEmail.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editEmail.setLocation(new Point(136, 288));
		editEmail.setSize(new Point(144, 20));
		editEmail.setTabIndex(23);
		editEmail.setText("");
		editEmail.setVisible(false);
		editEmail.setMaxLength(50);
		editEmail.setReadOnly(true);

		labelSite_web.setBackColor(Color.CONTROL);
		labelSite_web.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelSite_web.setLocation(new Point(31, 312));
		labelSite_web.setSize(new Point(100, 20));
		labelSite_web.setTabIndex(24);
		labelSite_web.setTabStop(false);
		labelSite_web.setText("Site_web");
		labelSite_web.setVisible(false);
		labelSite_web.setBorderStyle(BorderStyle.FIXED_3D);

		editSite_web.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editSite_web.setLocation(new Point(136, 312));
		editSite_web.setSize(new Point(144, 20));
		editSite_web.setTabIndex(26);
		editSite_web.setText("");
		editSite_web.setVisible(false);
		editSite_web.setMaxLength(50);
		editSite_web.setReadOnly(true);

		labelCharge_totale.setBackColor(Color.CONTROL);
		labelCharge_totale.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelCharge_totale.setLocation(new Point(31, 336));
		labelCharge_totale.setSize(new Point(100, 20));
		labelCharge_totale.setTabIndex(27);
		labelCharge_totale.setTabStop(false);
		labelCharge_totale.setText("Charge_totale");
		labelCharge_totale.setVisible(false);
		labelCharge_totale.setBorderStyle(BorderStyle.FIXED_3D);

		editCharge_totale.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editCharge_totale.setEnabled(false);
		editCharge_totale.setLocation(new Point(136, 336));
		editCharge_totale.setSize(new Point(144, 20));
		editCharge_totale.setTabIndex(28);
		editCharge_totale.setText("");
		editCharge_totale.setVisible(false);
		editCharge_totale.setReadOnly(true);

		label2.setBackColor(Color.CONTROL);
		label2.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label2.setLocation(new Point(320, 239));
		label2.setSize(new Point(110, 20));
		label2.setTabIndex(6);
		label2.setTabStop(false);
		label2.setText("Adresse");
		label2.setVisible(false);
		label2.setBorderStyle(BorderStyle.FIXED_3D);

		edit2.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		edit2.setLocation(new Point(436, 239));
		edit2.setSize(new Point(144, 20));
		edit2.setTabIndex(1);
		edit2.setText(" ");
		edit2.setVisible(false);
		edit2.setMaxLength(50);
		edit2.setWordWrap(false);

		label3.setBackColor(Color.CONTROL);
		label3.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label3.setLocation(new Point(320, 263));
		label3.setSize(new Point(110, 20));
		label3.setTabIndex(10);
		label3.setTabStop(false);
		label3.setText("Phone_1");
		label3.setVisible(false);
		label3.setBorderStyle(BorderStyle.FIXED_3D);

		edit3.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		edit3.setLocation(new Point(436, 264));
		edit3.setSize(new Point(144, 20));
		edit3.setTabIndex(2);
		edit3.setText(" ");
		edit3.setVisible(false);
		edit3.setMaxLength(12);

		label4.setBackColor(Color.CONTROL);
		label4.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label4.setLocation(new Point(320, 288));
		label4.setSize(new Point(110, 20));
		label4.setTabIndex(11);
		label4.setTabStop(false);
		label4.setText("Phone_2");
		label4.setVisible(false);
		label4.setBorderStyle(BorderStyle.FIXED_3D);

		edit4.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		edit4.setLocation(new Point(436, 288));
		edit4.setSize(new Point(144, 20));
		edit4.setTabIndex(3);
		edit4.setText("");
		edit4.setVisible(false);
		edit4.setMaxLength(12);

		label5.setBackColor(Color.CONTROL);
		label5.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label5.setLocation(new Point(321, 312));
		label5.setSize(new Point(110, 20));
		label5.setTabIndex(12);
		label5.setTabStop(false);
		label5.setText("Email");
		label5.setVisible(false);
		label5.setBorderStyle(BorderStyle.FIXED_3D);

		edit5.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		edit5.setLocation(new Point(436, 312));
		edit5.setSize(new Point(144, 20));
		edit5.setTabIndex(4);
		edit5.setText("");
		edit5.setVisible(false);
		edit5.setMaxLength(50);

		label6.setBackColor(Color.CONTROL);
		label6.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label6.setLocation(new Point(321, 336));
		label6.setSize(new Point(110, 20));
		label6.setTabIndex(13);
		label6.setTabStop(false);
		label6.setText("Site_web");
		label6.setVisible(false);
		label6.setBorderStyle(BorderStyle.FIXED_3D);

		edit6.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		edit6.setLocation(new Point(436, 336));
		edit6.setSize(new Point(144, 20));
		edit6.setTabIndex(5);
		edit6.setText("");
		edit6.setVisible(false);
		edit6.setMaxLength(50);

		button1.setLocation(new Point(287, 152));
		button1.setSize(new Point(70, 20));
		button1.setTabIndex(31);
		button1.setText("Rechercher");
		button1.addOnClick(new EventHandler(this.button1_click));

		panel1.setBackColor(new Color(0, 192, 192));
		panel1.setLocation(new Point(304, 376));
		panel1.setSize(new Point(264, 40));
		panel1.setTabIndex(32);
		panel1.setText("panel1");
		panel1.setVisible(false);
		panel1.setBorderStyle(BorderStyle.FIXED_3D);

		button2.setLocation(new Point(7, 8));
		button2.setSize(new Point(60, 23));
		button2.setTabIndex(0);
		button2.setText("&Nouveau");
		button2.setVisible(false);
		button2.addOnClick(new EventHandler(this.button2_click));

		button3.setLocation(new Point(192, 8));
		button3.setSize(new Point(60, 23));
		button3.setTabIndex(1);
		button3.setText("&Modifier");
		button3.setVisible(false);
		button3.addOnClick(new EventHandler(this.button3_click));

		button4.setLocation(new Point(454, 152));
		button4.setSize(new Point(70, 20));
		button4.setTabIndex(9);
		button4.setText("&Fermer");
		button4.addOnClick(new EventHandler(this.button4_click));

		label7.setBackColor(Color.AQUA);
		label7.setFont(new Font("MS Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label7.setForeColor(Color.WHITE);
		label7.setLocation(new Point(323, 216));
		label7.setSize(new Point(256, 16));
		label7.setTabIndex(34);
		label7.setTabStop(false);
		label7.setText("Veuillez entrer les nouvelles données ici S.V.P");
		label7.setVisible(false);
		label7.setBorderStyle(BorderStyle.FIXED_3D);

		pictureBox1.setLocation(new Point(43, 33));
		pictureBox1.setSize(new Point(88, 80));
		pictureBox1.setTabIndex(33);
		pictureBox1.setTabStop(false);
		pictureBox1.setText("pictureBox1");
		pictureBox1.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox1.setImage((Bitmap)resources.getObject("pictureBox1_image"));
		pictureBox1.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		label8.setBackColor(new Color(255, 255, 192));
		label8.setFont(new Font("Verdana", 14.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label8.setForeColor(Color.AQUA);
		label8.setLocation(new Point(55, 3));
		label8.setSize(new Point(496, 24));
		label8.setTabIndex(35);
		label8.setTabStop(false);
		label8.setText("Modification des Coordonnées d\'une Compagnie");
		label8.setBorderStyle(BorderStyle.FIXED_3D);
		label8.setTextAlign(HorizontalAlignment.CENTER);

		button5.setLocation(new Point(370, 154));
		button5.setSize(new Point(70, 20));
		button5.setTabIndex(36);
		button5.setText("&Annuler");
		button5.addOnClick(new EventHandler(this.button5_click));

		groupBox1.setBackColor(new Color(0, 192, 192));
		groupBox1.setLocation(new Point(27, 125));
		groupBox1.setSize(new Point(512, 56));
		groupBox1.setTabIndex(25);
		groupBox1.setTabStop(false);
		groupBox1.setText("");

		g1.setLocation(new Point(26, 178));
		g1.setSize(new Point(264, 184));
		g1.setTabIndex(37);
		g1.setTabStop(false);
		g1.setText("");
		g1.setVisible(false);

		g2.setLocation(new Point(316, 202));
		g2.setSize(new Point(272, 160));
		g2.setTabIndex(38);
		g2.setTabStop(false);
		g2.setText("");
		g2.setVisible(false);

		pictureBox4.setLocation(new Point(28, 0));
		pictureBox4.setSize(new Point(552, 32));
		pictureBox4.setTabIndex(8);
		pictureBox4.setTabStop(false);
		pictureBox4.setText("pictureBox2");
		pictureBox4.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox4.setImage((Bitmap)resources.getObject("pictureBox4_image"));
		pictureBox4.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox6.setLocation(new Point(27, 42));
		pictureBox6.setSize(new Point(88, 80));
		pictureBox6.setTabIndex(0);
		pictureBox6.setTabStop(false);
		pictureBox6.setText("pictureBox2");
		pictureBox6.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox6.setImage((Bitmap)resources.getObject("pictureBox6_image"));
		pictureBox6.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		p1.setLocation(new Point(296, 183));
		p1.setSize(new Point(16, 180));
		p1.setTabIndex(7);
		p1.setTabStop(false);
		p1.setText("pictureBox2");
		p1.setVisible(false);
		p1.setBorderStyle(BorderStyle.FIXED_3D);
		p1.setImage((Bitmap)resources.getObject("p1_image"));
		p1.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		this.setNewControls(new Control[] {
							p1, 
							button5, 
							label7, 
							button4, 
							label8, 
							pictureBox1, 
							button1, 
							label1, 
							edit1, 
							edit6, 
							label6, 
							edit5, 
							label5, 
							edit4, 
							label4, 
							edit3, 
							label3, 
							edit2, 
							label2, 
							labelNom, 
							editNom, 
							labelAdresse, 
							editAdresse, 
							labelPhone_1, 
							editPhone_1, 
							labelPhone_2, 
							editPhone_2, 
							labelEmail, 
							editEmail, 
							labelSite_web, 
							editSite_web, 
							labelCharge_totale, 
							editCharge_totale, 
							panel1, 
							groupBox1, 
							g1, 
							g2, 
							pictureBox4, 
							pictureBox6});
		panel1.setNewControls(new Control[] {
							  button3, 
							  button2});
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
        Application.run( new Modi_Compagnie() );
    }
}
