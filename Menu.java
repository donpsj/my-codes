import com.ms.wfc.app.*;
import com.ms.wfc.core.*;
import com.ms.wfc.ui.*;
import com.ms.wfc.html.*;

/**
 * This class can take a variable number of parameters on the command
 * line. Program execution begins with the main() method. The class
 * constructor is not invoked unless an object of type 'Form1' is
 * created in the main() method.
 */
public class Menu extends Form
{ 
   
	public Menu()
	{
		// Required for Visual J++ Form Designer support
		initForm();	
		SplashScreen splash = new SplashScreen(
									"SGPA",
									"Version 1.2",
									"Copyright ©2003, "
										+ "",
									"Hôpital Adventiste d'Haïti, ( HAH )",
									"Par la Compagnie:",
									""); 
		splash.setLogoImage("final.jpg");
		splash.setSplashBackground("acceuil.jpg");
		splash.showSplash(5100);

		// TODO: Add any constructor code after initForm call
	}

	/**
	 * Form1 overrides dispose so it can clean up the
	 * component list.
	 */
	public void dispose()
	{
		super.dispose();
		components.dispose();
	}

	

	private void menuItem6_click(Object source, Event e)
	{
		Application.run(new Saisie_Compagnie());
	}

	private void menuItem3_click(Object source, Event e)
	{
		Application.run(new Saisie_Titulaire());
	}

	private void menuItem4_click(Object source, Event e)
	{
		Application.run(new Inscription_Patient());
	}

	private void menuItem5_click(Object source, Event e)
	{
		Application.run(new Admis());
	}

	  

	private void menuItem12_click(Object source, Event e)
	{
		Application.run(new Admis());
	}

	private void menuItem13_click(Object source, Event e)
	{
		Application.run(new Facturer());
	}

	private void menuItem14_click(Object source, Event e)
	{
		Application.run(new Avis_Reception());
	}

	private void menuItem15_click(Object source, Event e)
	{
		Application.run(new Paiement());
	}

	
	private void menuItem8_click(Object source, Event e)
	{
		Application.run(new Modi_Compagnie());
		
	}

	private void menuItem10_click(Object source, Event e)
	{  Application.run(new Modi_Patient());
		
	}

	private void menuItem9_click(Object source, Event e)
	{
		Application.run(new Modi_Titulaire());
	}

	private void menuItem19_click(Object source, Event e)
	{
		Application.run(new Rech_Paiement());
	}

	private void menuItem20_click(Object source, Event e)
	{
		Application.run(new Rech_Avis());
	}

	private void menuItem21_click(Object source, Event e)
	{
		Application.run(new Rech_Facture());
	}

	private void menuItem17_click(Object source, Event e)
	{
		Application.run(new Paiement_Credit());
	}

	 
	private void menuItem22_click(Object source, Event e)
	{
		Application.run(new Rech_P_Credit());
	}

	private void menuItem24_click(Object source, Event e)
	{
		Application.run(new Paiement_Titulaire());
	}

	private void menuItem23_click(Object source, Event e)
	{
		      Application.run(new Rech_P_Balance());
	}

	private void menuItem11_click(Object source, Event e)
	{
	    Application.run(new Rech_Admi());	
	}

	private void menuItem25_click(Object source, Event e)
	{   int sorti;
		 sorti=MessageBox.show(" Voulez-vous Vraiment Quitter le SGPA ?", "Abandon",MessageBox.YESNO + MessageBox.ICONSTOP);
				if(sorti==MessageBox.IDYES)
				{Application.exit();
				  
				}
	 	}

			
	

	private void menuItem26_click(Object source, Event e)
	{
		Application.run(new Realisation());	
	}

	private void menuItem29_click(Object source, Event e)
	{
	  		Application.run(new Inscription());
	}

	private void menuItem30_click(Object source, Event e)
	{
				Application.run(new Services());
	}
	

	private void menuItem31_click(Object source, Event e)
	{
		Application.run(new Facture_Institution());
	}

	private void menuItem32_click(Object source, Event e)
	{
		Application.run(new Paiement_Institution());
		
	}

	private void menuItem35_click(Object source, Event e)
	{
	   Application.run(new Rech_Services());	
	}

	private void menuItem36_click(Object source, Event e)
	{
		Application.run(new Rech_FacInst());	
	}

	private void menuItem37_click(Object source, Event e)
	{
		Application.run(new Rech_Versement());	
	}

	/**
	 * NOTE: The following code is required by the Visual J++ form
	 * designer.  It can be modified using the form editor.  Do not
	 * modify it using the code editor.
	 */
	Container components = new Container();
	Panel panel1 = new Panel();
	MainMenu mainMenu1 = new MainMenu();
	MenuItem menuItem17 = new MenuItem();
	MenuItem menuItem16 = new MenuItem();
	MenuItem menuItem1 = new MenuItem();
	PictureBox pictureBox4 = new PictureBox();
	StatusBarPanel statusBarPanel1 = new StatusBarPanel();
	StatusBarPanel statusBarPanel2 = new StatusBarPanel();
	MenuItem menuItem6 = new MenuItem();
	MenuItem menuItem5 = new MenuItem();
	PictureBox pictureBox1 = new PictureBox();
	MenuItem menuItem18 = new MenuItem();
	MenuItem menuItem19 = new MenuItem();
	MenuItem menuItem20 = new MenuItem();
	MenuItem menuItem10 = new MenuItem();
	MenuItem menuItem11 = new MenuItem();
	MenuItem menuItem12 = new MenuItem();
	MenuItem menuItem13 = new MenuItem();
	MenuItem menuItem9 = new MenuItem();
	MenuItem menuItem14 = new MenuItem();
	MenuItem menuItem15 = new MenuItem();
	MenuItem menuItem8 = new MenuItem();
	MenuItem menuItem4 = new MenuItem();
	MenuItem menuItem7 = new MenuItem();
	Label label1 = new Label();
	MenuItem menuItem2 = new MenuItem();
	MenuItem menuItem3 = new MenuItem();
	MenuItem menuItem21 = new MenuItem();
	MenuItem menuItem39 = new MenuItem();
	MenuItem menuItem40 = new MenuItem();
	PictureBox pictureBox3 = new PictureBox();
	PictureBox pictureBox5 = new PictureBox();
	MenuItem menuItem22 = new MenuItem();
	MenuItem menuItem23 = new MenuItem();
	MenuItem menuItem24 = new MenuItem();
	MenuItem menuItem25 = new MenuItem();
	PictureBox pictureBox6 = new PictureBox();
	PictureBox pictureBox7 = new PictureBox();
	MenuItem menuItem26 = new MenuItem();
	MenuItem menuItem27 = new MenuItem();
	MenuItem menuItem28 = new MenuItem();
	MenuItem menuItem29 = new MenuItem();
	MenuItem menuItem30 = new MenuItem();
	MenuItem menuItem31 = new MenuItem();
	MenuItem menuItem32 = new MenuItem();
	MenuItem menuItem33 = new MenuItem();
	MenuItem menuItem34 = new MenuItem();
	MenuItem menuItem35 = new MenuItem();
	MenuItem menuItem36 = new MenuItem();
	MenuItem menuItem37 = new MenuItem();

	private void initForm()
	{
		// REMARQUE : cette feuille stocke des informations sur les ressources
		// dans un fichier externe. Ne modifiez le paramètre de chaîne d'aucun
		// appel de fonction resources.getObject(). Par exemple,
		// ne modifiez pas "foo1_location" dans la ligne de code
		// suivante, même si le nom de l'objet Foo change : 
		//	 foo1.setLocation((Point)resources.getObject("foo1_location"));

		IResourceManager resources = new ResourceManager(this, "Menu");
		panel1.setBackColor(new Color(0, 192, 192));
		panel1.setCursor(Cursor.APPSTARTING);
		panel1.setDock(ControlDock.FILL);
		panel1.setSize((Point)resources.getObject("panel1_size"));
		panel1.setTabIndex(resources.getInt("panel1_tabIndex"));
		panel1.setText(resources.getString("panel1_text"));

		menuItem17.setText(resources.getString("menuItem17_text"));
		menuItem17.addOnClick(new EventHandler(this.menuItem17_click));

		menuItem16.setText(resources.getString("menuItem16_text"));

		pictureBox4.setCursor(Cursor.APPSTARTING);
		pictureBox4.setLocation((Point)resources.getObject("pictureBox4_location"));
		pictureBox4.setSize((Point)resources.getObject("pictureBox4_size"));
		pictureBox4.setTabIndex(resources.getInt("pictureBox4_tabIndex"));
		pictureBox4.setTabStop(false);
		pictureBox4.setText(resources.getString("pictureBox4_text"));
		pictureBox4.setImage((Bitmap)resources.getObject("pictureBox4_image"));
		pictureBox4.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		statusBarPanel1.setIcon((Icon)resources.getObject("statusBarPanel1_icon"));
		statusBarPanel1.setStyle(StatusBarPanelStyle.OWNERDRAW);
		statusBarPanel1.setText(resources.getString("statusBarPanel1_text"));

		statusBarPanel2.setIcon((Icon)resources.getObject("statusBarPanel2_icon"));
		statusBarPanel2.setText(resources.getString("statusBarPanel2_text"));

		menuItem6.setText(resources.getString("menuItem6_text"));
		menuItem6.addOnClick(new EventHandler(this.menuItem6_click));

		menuItem5.setText(resources.getString("menuItem5_text"));
		menuItem5.addOnClick(new EventHandler(this.menuItem5_click));

		pictureBox1.setCursor(Cursor.APPSTARTING);
		pictureBox1.setLocation((Point)resources.getObject("pictureBox1_location"));
		pictureBox1.setSize((Point)resources.getObject("pictureBox1_size"));
		pictureBox1.setTabIndex(resources.getInt("pictureBox1_tabIndex"));
		pictureBox1.setTabStop(false);
		pictureBox1.setText(resources.getString("pictureBox1_text"));
		pictureBox1.setImage((Bitmap)resources.getObject("pictureBox1_image"));
		pictureBox1.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		menuItem19.setText(resources.getString("menuItem19_text"));
		menuItem19.addOnClick(new EventHandler(this.menuItem19_click));

		menuItem20.setText(resources.getString("menuItem20_text"));
		menuItem20.addOnClick(new EventHandler(this.menuItem20_click));

		menuItem10.setText(resources.getString("menuItem10_text"));
		menuItem10.addOnClick(new EventHandler(this.menuItem10_click));

		menuItem11.setText(resources.getString("menuItem11_text"));
		menuItem11.addOnClick(new EventHandler(this.menuItem11_click));

		menuItem13.setText(resources.getString("menuItem13_text"));
		menuItem13.addOnClick(new EventHandler(this.menuItem13_click));

		menuItem9.setText(resources.getString("menuItem9_text"));
		menuItem9.addOnClick(new EventHandler(this.menuItem9_click));

		menuItem14.setText(resources.getString("menuItem14_text"));
		menuItem14.addOnClick(new EventHandler(this.menuItem14_click));

		menuItem12.setMenuItems(new MenuItem[] {
								menuItem13, 
								menuItem14});
		menuItem12.setText(resources.getString("menuItem12_text"));
		menuItem12.addOnClick(new EventHandler(this.menuItem12_click));

		menuItem15.setText(resources.getString("menuItem15_text"));
		menuItem15.addOnClick(new EventHandler(this.menuItem15_click));

		menuItem8.setText(resources.getString("menuItem8_text"));
		menuItem8.addOnClick(new EventHandler(this.menuItem8_click));

		menuItem4.setText(resources.getString("menuItem4_text"));
		menuItem4.addOnClick(new EventHandler(this.menuItem4_click));

		label1.setBackColor(Color.WHITE);
		label1.setCursor(Cursor.APPSTARTING);
		label1.setDock(ControlDock.TOP);
		label1.setFont((Font)resources.getObject("label1_font"));
		label1.setForeColor(new Color(0, 192, 192));
		label1.setSize((Point)resources.getObject("label1_size"));
		label1.setTabIndex(resources.getInt("label1_tabIndex"));
		label1.setTabStop(false);
		label1.setText(resources.getString("label1_text"));
		label1.setBorderStyle(BorderStyle.FIXED_3D);
		label1.setTextAlign(HorizontalAlignment.CENTER);

		menuItem3.setText(resources.getString("menuItem3_text"));
		menuItem3.addOnClick(new EventHandler(this.menuItem3_click));

		menuItem21.setText(resources.getString("menuItem21_text"));
		menuItem21.addOnClick(new EventHandler(this.menuItem21_click));

		menuItem39.setText(resources.getString("menuItem39_text"));

		menuItem1.setMenuItems(new MenuItem[] {
							   menuItem6, 
							   menuItem3, 
							   menuItem4, 
							   menuItem5, 
							   menuItem39});
		menuItem1.setText(resources.getString("menuItem1_text"));

		pictureBox3.setCursor(Cursor.ARROW);
		pictureBox3.setLocation((Point)resources.getObject("pictureBox3_location"));
		pictureBox3.setSize((Point)resources.getObject("pictureBox3_size"));
		pictureBox3.setTabIndex(resources.getInt("pictureBox3_tabIndex"));
		pictureBox3.setTabStop(false);
		pictureBox3.setText(resources.getString("pictureBox3_text"));
		pictureBox3.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox3.setImage((Bitmap)resources.getObject("pictureBox3_image"));
		pictureBox3.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox5.setCursor(Cursor.APPSTARTING);
		pictureBox5.setLocation((Point)resources.getObject("pictureBox5_location"));
		pictureBox5.setSize((Point)resources.getObject("pictureBox5_size"));
		pictureBox5.setTabIndex(resources.getInt("pictureBox5_tabIndex"));
		pictureBox5.setTabStop(false);
		pictureBox5.setText(resources.getString("pictureBox5_text"));
		pictureBox5.setImage((Bitmap)resources.getObject("pictureBox5_image"));

		menuItem22.setText(resources.getString("menuItem22_text"));
		menuItem22.addOnClick(new EventHandler(this.menuItem22_click));

		menuItem23.setText(resources.getString("menuItem23_text"));
		menuItem23.addOnClick(new EventHandler(this.menuItem23_click));

		menuItem18.setMenuItems(new MenuItem[] {
								menuItem19, 
								menuItem20, 
								menuItem21, 
								menuItem22, 
								menuItem23, 
								menuItem11});
		menuItem18.setText(resources.getString("menuItem18_text"));

		menuItem24.setText(resources.getString("menuItem24_text"));
		menuItem24.addOnClick(new EventHandler(this.menuItem24_click));

		menuItem7.setMenuItems(new MenuItem[] {
							   menuItem12, 
							   menuItem16, 
							   menuItem15, 
							   menuItem17, 
							   menuItem24});
		menuItem7.setText(resources.getString("menuItem7_text"));

		menuItem25.setText(resources.getString("menuItem25_text"));
		menuItem25.addOnClick(new EventHandler(this.menuItem25_click));

		pictureBox6.setCursor(Cursor.APPSTARTING);
		pictureBox6.setLocation((Point)resources.getObject("pictureBox6_location"));
		pictureBox6.setSize((Point)resources.getObject("pictureBox6_size"));
		pictureBox6.setTabIndex(resources.getInt("pictureBox6_tabIndex"));
		pictureBox6.setTabStop(false);
		pictureBox6.setText(resources.getString("pictureBox6_text"));
		pictureBox6.setImage((Bitmap)resources.getObject("pictureBox6_image"));
		pictureBox6.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox7.setCursor(Cursor.APPSTARTING);
		pictureBox7.setLocation((Point)resources.getObject("pictureBox7_location"));
		pictureBox7.setSize((Point)resources.getObject("pictureBox7_size"));
		pictureBox7.setTabIndex(resources.getInt("pictureBox7_tabIndex"));
		pictureBox7.setTabStop(false);
		pictureBox7.setText(resources.getString("pictureBox7_text"));
		pictureBox7.setImage((Bitmap)resources.getObject("pictureBox7_image"));
		pictureBox7.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		menuItem26.setText(resources.getString("menuItem26_text"));
		menuItem26.addOnClick(new EventHandler(this.menuItem26_click));

		menuItem27.setText(resources.getString("menuItem27_text"));

		menuItem2.setMenuItems(new MenuItem[] {
							   menuItem26, 
							   menuItem27, 
							   menuItem25});
		menuItem2.setText(resources.getString("menuItem2_text"));

		menuItem29.setText(resources.getString("menuItem29_text"));
		menuItem29.addOnClick(new EventHandler(this.menuItem29_click));

		menuItem30.setText(resources.getString("menuItem30_text"));
		menuItem30.addOnClick(new EventHandler(this.menuItem30_click));

		menuItem31.setText(resources.getString("menuItem31_text"));
		menuItem31.addOnClick(new EventHandler(this.menuItem31_click));

		menuItem32.setText(resources.getString("menuItem32_text"));
		menuItem32.addOnClick(new EventHandler(this.menuItem32_click));

		menuItem33.setText(resources.getString("menuItem33_text"));

		menuItem40.setMenuItems(new MenuItem[] {
								menuItem8, 
								menuItem9, 
								menuItem10, 
								menuItem33});
		menuItem40.setText(resources.getString("menuItem40_text"));

		menuItem35.setText(resources.getString("menuItem35_text"));
		menuItem35.addOnClick(new EventHandler(this.menuItem35_click));

		menuItem36.setText(resources.getString("menuItem36_text"));
		menuItem36.addOnClick(new EventHandler(this.menuItem36_click));

		menuItem37.setText(resources.getString("menuItem37_text"));
		menuItem37.addOnClick(new EventHandler(this.menuItem37_click));

		menuItem34.setMenuItems(new MenuItem[] {
								menuItem35, 
								menuItem36, 
								menuItem37});
		menuItem34.setText(resources.getString("menuItem34_text"));

		menuItem28.setMenuItems(new MenuItem[] {
								menuItem29, 
								menuItem30, 
								menuItem31, 
								menuItem32, 
								menuItem34});
		menuItem28.setText(resources.getString("menuItem28_text"));

		mainMenu1.setMenuItems(new MenuItem[] {
							   menuItem1, 
							   menuItem40, 
							   menuItem7, 
							   menuItem18, 
							   menuItem28, 
							   menuItem2});
		/* @designTimeOnly mainMenu1.setLocation((Point)resources.getObject("mainMenu1_location")); */

		this.setCursor(Cursor.ARROW);
		this.setText(resources.getString("this_text"));
		this.setAutoScaleBaseSize(new Point(5, 13));
		this.setBorderStyle(FormBorderStyle.FIXED_SINGLE);
		this.setClientSize((Point)resources.getObject("this_clientSize"));
		this.setHelpButton(resources.getBoolean("this_helpButton"));
		this.setIcon((Icon)resources.getObject("this_icon"));
		this.setKeyPreview(true);
		this.setMaximizeBox(resources.getBoolean("this_maximizeBox"));
		this.setIsMDIContainer(true);
		this.setMenu(mainMenu1);
		this.setStartPosition(FormStartPosition.CENTER_SCREEN);
		/* @designTimeOnly this.setLocalizable(true); */

		this.setNewControls(new Control[] {
							panel1, 
							pictureBox3});
		panel1.setNewControls(new Control[] {
							  pictureBox7, 
							  pictureBox6, 
							  pictureBox4, 
							  pictureBox1, 
							  label1, 
							  pictureBox5});
	}

	/**
	 * The main entry point for the application. 
	 *
	 * @param args Array of parameters passed to the application
	 * via the command line.
	 */
	public static void main(String args[])
	{
		Application.run(new Menu());
	}
}
