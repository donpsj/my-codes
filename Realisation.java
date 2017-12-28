import com.ms.wfc.app.*;
import com.ms.wfc.core.*;
import com.ms.wfc.ui.*;
import com.ms.wfc.html.*;

/**
 * This class can take a variable number of parameters on the command
 * line. Program execution begins with the main() method. The class
 * constructor is not invoked unless an object of type 'Realisation'
 * created in the main() method.
 */
public class Realisation extends Form
{
	public Realisation()
	{
		super();

		// Required for Visual J++ Form Designer support
		initForm();		

		// TODO: Add any constructor code after initForm call
	}

	/**
	 * Realisation overrides dispose so it can clean up the
	 * component list.
	 */
	public void dispose()
	{
		super.dispose();
		components.dispose();
	}

	private void button1_click(Object source, Event e)
	{
		hide();
	}

	/**
	 * NOTE: The following code is required by the Visual J++ form
	 * designer.  It can be modified using the form editor.  Do not
	 * modify it using the code editor.
	 */
	Container components = new Container();
	Button button1 = new Button();
	Panel panel1 = new Panel();
	Label label1 = new Label();
	Label label2 = new Label();
	Label label3 = new Label();
	Label label4 = new Label();
	Label label5 = new Label();
	Label label6 = new Label();
	Label label7 = new Label();
	Label label8 = new Label();
	Label label9 = new Label();
	PictureBox pictureBox3 = new PictureBox();
	Label label11 = new Label();
	Label label12 = new Label();
	Label label13 = new Label();
	PictureBox pictureBox6 = new PictureBox();
	PictureBox pictureBox1 = new PictureBox();

	private void initForm()
	{
		// REMARQUE : cette feuille stocke des informations sur les ressources
		// dans un fichier externe. Ne modifiez le paramètre de chaîne d'aucun
		// appel de fonction resources.getObject(). Par exemple,
		// ne modifiez pas "foo1_location" dans la ligne de code
		// suivante, même si le nom de l'objet Foo change : 
		//	 foo1.setLocation((Point)resources.getObject("foo1_location"));

		IResourceManager resources = new ResourceManager(this, "Realisation");
		this.setBackColor(Color.BLACK);
		this.setText("Realisation du Programme");
		this.setAutoScaleBaseSize(new Point(5, 13));
		this.setBorderStyle(FormBorderStyle.NONE);
		this.setClientSize(new Point(524, 275));
		this.setMaximizeBox(false);
		this.setMinimizeBox(false);
		this.setStartPosition(FormStartPosition.CENTER_SCREEN);

		button1.setDock(ControlDock.BOTTOM);
		button1.setFont(new Font("AdLib BT", 11.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		button1.setLocation(new Point(0, 235));
		button1.setSize(new Point(524, 40));
		button1.setTabIndex(1);
		button1.setText("CLIQUEZ ICI POUR FERMER LA FENETRE");
		button1.addOnClick(new EventHandler(this.button1_click));

		panel1.setBackColor(Color.WHITE);
		panel1.setLocation(new Point(16, 40));
		panel1.setSize(new Point(488, 192));
		panel1.setTabIndex(2);
		panel1.setText("panel1");
		panel1.setBorderStyle(BorderStyle.FIXED_3D);

		label1.setBackColor(new Color(192, 255, 192));
		label1.setLocation(new Point(16, -24));
		label1.setSize(new Point(328, 16));
		label1.setTabIndex(0);
		label1.setTabStop(false);
		label1.setText("label1");
		label1.setBorderStyle(BorderStyle.FIXED_3D);

		label2.setBackColor(new Color(0, 192, 192));
		label2.setFont(new Font("MS Serif", 10.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label2.setLocation(new Point(53, 15));
		label2.setSize(new Point(408, 16));
		label2.setTabIndex(4);
		label2.setTabStop(false);
		label2.setText("LE SGPA  EST REALISE PAR LE GROUPE GENIAL");
		label2.setBorderStyle(BorderStyle.FIXED_3D);
		label2.setTextAlign(HorizontalAlignment.CENTER);

		label3.setBackColor(new Color(0, 192, 192));
		label3.setFont(new Font("MS Sans Serif", 10.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label3.setLocation(new Point(-2, 0));
		label3.setSize(new Point(224, 20));
		label3.setTabIndex(11);
		label3.setTabStop(false);
		label3.setText("NOM  ET PRENOM");
		label3.setBorderStyle(BorderStyle.FIXED_SINGLE);

		label4.setBackColor(new Color(0, 192, 192));
		label4.setFont(new Font("MS Sans Serif", 10.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label4.setLocation(new Point(265, -1));
		label4.setSize(new Point(224, 20));
		label4.setTabIndex(1);
		label4.setTabStop(false);
		label4.setText("  ADRESSE   ELECTRONIQUE");
		label4.setBorderStyle(BorderStyle.FIXED_SINGLE);

		label5.setBackColor(new Color(192, 255, 192));
		label5.setFont(new Font("MS Sans Serif", 10.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label5.setLocation(new Point(6, 94));
		label5.setSize(new Point(210, 20));
		label5.setTabIndex(10);
		label5.setTabStop(false);
		label5.setText("DESRUISSEAUX   WESLEY");
		label5.setBorderStyle(BorderStyle.FIXED_SINGLE);

		label6.setBackColor(new Color(192, 255, 192));
		label6.setFont(new Font("MS Sans Serif", 10.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label6.setLocation(new Point(6, 158));
		label6.setSize(new Point(210, 20));
		label6.setTabIndex(2);
		label6.setTabStop(false);
		label6.setText("SIMILUS   JOSE");
		label6.setBorderStyle(BorderStyle.FIXED_SINGLE);

		label7.setBackColor(new Color(255, 255, 192));
		label7.setFont(new Font("MS Sans Serif", 10.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		label7.setForeColor(new Color(192, 64, 0));
		label7.setLocation(new Point(273, 62));
		label7.setSize(new Point(210, 20));
		label7.setTabIndex(9);
		label7.setTabStop(false);
		label7.setText("doripsj@yahoo.com");
		label7.setBorderStyle(BorderStyle.FIXED_SINGLE);

		label8.setBackColor(new Color(192, 255, 192));
		label8.setFont(new Font("MS Sans Serif", 10.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label8.setLocation(new Point(6, 126));
		label8.setSize(new Point(210, 20));
		label8.setTabIndex(5);
		label8.setTabStop(false);
		label8.setText("MARDIGRAS  VENETTE");
		label8.setBorderStyle(BorderStyle.FIXED_SINGLE);

		label9.setBackColor(new Color(192, 255, 192));
		label9.setFont(new Font("MS Sans Serif", 10.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label9.setLocation(new Point(6, 62));
		label9.setSize(new Point(210, 20));
		label9.setTabIndex(4);
		label9.setTabStop(false);
		label9.setText("DORISCA    SALNAVE-FILS");
		label9.setBorderStyle(BorderStyle.FIXED_SINGLE);

		pictureBox3.setLocation(new Point(16, 8));
		pictureBox3.setSize(new Point(488, 32));
		pictureBox3.setTabIndex(3);
		pictureBox3.setTabStop(false);
		pictureBox3.setText("pictureBox2");
		pictureBox3.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox3.setImage((Bitmap)resources.getObject("pictureBox3_image"));
		pictureBox3.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		label11.setBackColor(new Color(255, 255, 192));
		label11.setFont(new Font("MS Sans Serif", 10.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		label11.setForeColor(new Color(192, 64, 0));
		label11.setLocation(new Point(274, 126));
		label11.setSize(new Point(210, 20));
		label11.setTabIndex(8);
		label11.setTabStop(false);
		label11.setText("nettou@yahoo.com");
		label11.setBorderStyle(BorderStyle.FIXED_SINGLE);

		label12.setBackColor(new Color(255, 255, 192));
		label12.setFont(new Font("MS Sans Serif", 10.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		label12.setForeColor(new Color(192, 64, 0));
		label12.setLocation(new Point(274, 158));
		label12.setSize(new Point(210, 20));
		label12.setTabIndex(7);
		label12.setTabStop(false);
		label12.setText("josepsj@yahoo.com");
		label12.setBorderStyle(BorderStyle.FIXED_SINGLE);

		label13.setBackColor(new Color(255, 255, 192));
		label13.setFont(new Font("MS Sans Serif", 10.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		label13.setForeColor(new Color(192, 64, 0));
		label13.setLocation(new Point(273, 94));
		label13.setSize(new Point(210, 20));
		label13.setTabIndex(6);
		label13.setTabStop(false);
		label13.setText("wewes56@yahoo.com");
		label13.setBorderStyle(BorderStyle.FIXED_SINGLE);

		pictureBox6.setLocation(new Point(238, 40));
		pictureBox6.setSize(new Point(48, 192));
		pictureBox6.setTabIndex(0);
		pictureBox6.setTabStop(false);
		pictureBox6.setText("pictureBox2");
		pictureBox6.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox6.setImage((Bitmap)resources.getObject("pictureBox6_image"));
		pictureBox6.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox1.setLocation(new Point(0, 19));
		pictureBox1.setSize(new Point(488, 32));
		pictureBox1.setTabIndex(3);
		pictureBox1.setTabStop(false);
		pictureBox1.setText("pictureBox2");
		pictureBox1.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox1.setImage((Bitmap)resources.getObject("pictureBox1_image"));
		pictureBox1.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		this.setNewControls(new Control[] {
							label2, 
							button1, 
							pictureBox3, 
							pictureBox6, 
							panel1});
		panel1.setNewControls(new Control[] {
							  pictureBox1, 
							  label3, 
							  label13, 
							  label12, 
							  label11, 
							  label9, 
							  label8, 
							  label7, 
							  label6, 
							  label5, 
							  label4, 
							  label1});
	}

	/**
	 * The main entry point for the application. 
	 *
	 * @param args Array of parameters passed to the application
	 * via the command line.
	 */
	public static void main(String args[])
	{
		Application.run(new Realisation());
	}
}
