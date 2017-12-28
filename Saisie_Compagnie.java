//Saisie_Compagnie.java

import com.ms.wfc.app.*;
import com.ms.wfc.core.*;
import com.ms.wfc.ui.*;
import com.ms.wfc.data.*;
import com.ms.wfc.data.ui.*;

public class Saisie_Compagnie extends Form
{

    public void btnAdd_Click(Object sender, Event evt)
    {
        try
        {
            dataSource1.getRecordset().cancelUpdate();
            dataSource1.getRecordset().addNew();
            m_bAddNew = true;
            btnAdd.setEnabled( false );
			btnUpdate.setEnabled( true );
			editNom.setText("");
			editAdresse.setText("");
		    editEmail.setText("");
		    editPhone_1.setText("");
		    editPhone_2.setText("");
		    editSite_web.setText("");
             
        }
        catch (Exception e)
        {
            handleADOException(e);
        }
    }

    public void btnUpdate_Click(Object sender, Event evt)
    {    
		DataSource rech = new DataSource();
		rech.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		rech.setCommandText("select * from Compagnie where Nom = '"+editNom.getText()+"'");			  			
        rech.begin();
	
		try
        {  	   
			
           if(editNom.getText().equals(""))
			{MessageBox.show("Veuillez Entrer le Nom de la Compagnie d'Assurance S.V.P !","Champ Vide",MessageBox.ICONERROR);
			}
			else
			   if(editAdresse.getText().equals(""))
			   {  MessageBox.show("Veuillez Entrer l'Adresse de la Compagnie d'Assurance S.V.P !","Champ Vide",MessageBox.ICONERROR);
			   }	  
			else
			  if(editPhone_1.getText().equals(""))
			  {MessageBox.show("Veuillez Entrer, Au Moins, un Numéro de Téléphone de la Compagnie d'Assurance S.V.P !","Champ Vide",MessageBox.ICONERROR);
			  }  	
			else
			  if(String.valueOf(rech.getRecordset().getRecordCount()).equals("1"))
			   {MessageBox.show("Désolé la Compagnie '"+editNom.getText()+"' est déjà inscrite !","Opération Illégale",MessageBox.ICONSTOP);
				editNom.setText("");
		        editAdresse.setText("");
		        editEmail.setText("");
		        editPhone_1.setText("");
		        editPhone_2.setText("");
		        editSite_web.setText("");
				}
		           
		  else
		 {     this.setCursor( Cursor.WAIT );
               dataBinder1.commitChanges();
               dataSource1.getRecordset().update();
			   dataSource1.getRecordset().moveLast();
			   MessageBox.show("Felicitations !! L'inscription de la Compagnie << "+editNom.getText()+" >> est Réussie ", " Confirmation",MessageBox.ICONINFORMATION);
			 
             if( m_bAddNew )
              {
                dataSource1.requery();
                dataSource1.getRecordset().moveLast();
               }
			btnAdd.setEnabled( true );
			btnUpdate.setEnabled( false );
		     }
		  }
	 
        catch (Exception e)
        {
            handleADOException(e);
            if( m_bAddNew )
            {
                this.setCursor( Cursor.DEFAULT );
                return;
            }
            else
                dataSource1.getRecordset().cancelUpdate();
        }

        this.setCursor( Cursor.DEFAULT );
        m_bAddNew = false;
       
         }

    public void btnClose_Click(Object sender, Event evt)
    {
        hide();
    }

    boolean    m_bAddNew;
    public void dispose()
    {
        super.dispose();
        components.dispose();
    }
	
    public Saisie_Compagnie()
    {
        // Required for Visual J++ Form Designer support
        initForm();
        
        this.show();
        this.update();
		   dataSource1.getRecordset().cancelUpdate();
            dataSource1.getRecordset().addNew();
            btnAdd.setEnabled( false );
			editNom.setText("");
			editAdresse.setText("");
		    editEmail.setText("");
		    editPhone_1.setText("");
		    editPhone_2.setText("");
		    editSite_web.setText("");

        //TODO: Add any constructor code after initForm call
    }    

    public void formClose(Event e)
    {
        Application.exit();
    }    

    
    void handleADOException(Exception e)
    {
        e.printStackTrace();
        MessageBox.show( e.toString(), "Saisie_Compagnie" );
    }

	/**
	 * NOTE: The following code is required by the Visual J++ form
	 * designer.  It can be modified using the form editor.  Do not
	 * modify it using the code editor.
	 */
	Container components = new Container();
	DataSource dataSource1 = new DataSource(components);
	DataBinder dataBinder1 = new DataBinder(components);
	Edit editPhone_1 = new Edit();
	Label labelPhone_1 = new Label();
	Label labelPhone_2 = new Label();
	Edit editPhone_2 = new Edit();
	Label labelEmail = new Label();
	Button btnClose = new Button();
	Edit editEmail = new Edit();
	Button btnUpdate = new Button();
	Label labelSite_web = new Label();
	Button btnAdd = new Button();
	Edit editSite_web = new Edit();
	Panel panel1 = new Panel();
	Edit editNom = new Edit();
	Label label1 = new Label();
	Label labelAdresse = new Label();
	Edit editAdresse = new Edit();
	Label labelNom = new Label();
	PictureBox pictureBox6 = new PictureBox();
	Panel panel2 = new Panel();
	GroupBox groupBox1 = new GroupBox();
	PictureBox pictureBox4 = new PictureBox();
	PictureBox pictureBox3 = new PictureBox();
	PictureBox pictureBox1 = new PictureBox();
	PictureBox pictureBox2 = new PictureBox();

	private void initForm()
	{
		// REMARQUE : cette feuille stocke des informations sur les ressources
		// dans un fichier externe. Ne modifiez le paramètre de chaîne d'aucun
		// appel de fonction resources.getObject(). Par exemple,
		// ne modifiez pas "foo1_location" dans la ligne de code
		// suivante, même si le nom de l'objet Foo change : 
		//	 foo1.setLocation((Point)resources.getObject("foo1_location"));

		IResourceManager resources = new ResourceManager(this, "Saisie_Compagnie");
		this.setLocation(new Point(7, 7));
		this.setText("Inscription d\'une  Compagnie  d\'Assurance");
		this.setAutoScaleBaseSize(new Point(5, 13));
		this.setAutoScroll(true);
		this.setBorderStyle(FormBorderStyle.NONE);
		this.setClientSize(new Point(475, 452));
		this.setMaximizeBox(false);
		this.setStartPosition(FormStartPosition.CENTER_SCREEN);

		dataSource1.setConnectionString("PROVIDER=MSDASQL;dsn=HAH;uid=genial;pwd=genial;DBQ=C:\\ASSURE.MDB");
		dataSource1.setCommandText("select Nom, Adresse, Phone_1, Phone_2, Email, Site_web from Compagnie ORDER by Nom");
		dataSource1.setSort(null);
		dataSource1.setStayInSync(true);
		dataSource1.setUserId(null);
		dataSource1.setPassword(null);
		/* @designTimeOnly dataSource1.setLocation(new Point(264, 80)); */

		editPhone_1.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editPhone_1.setLocation(new Point(156, 224));
		editPhone_1.setSize(new Point(158, 20));
		editPhone_1.setTabIndex(3);
		editPhone_1.setText("2254710");
		editPhone_1.setMaxLength(12);

		labelPhone_1.setBackColor(Color.CONTROL);
		labelPhone_1.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelPhone_1.setLocation(new Point(41, 225));
		labelPhone_1.setSize(new Point(110, 23));
		labelPhone_1.setTabIndex(10);
		labelPhone_1.setTabStop(false);
		labelPhone_1.setText(" Phone_1");
		labelPhone_1.setBorderStyle(BorderStyle.FIXED_3D);

		labelPhone_2.setBackColor(Color.CONTROL);
		labelPhone_2.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelPhone_2.setLocation(new Point(41, 253));
		labelPhone_2.setSize(new Point(110, 23));
		labelPhone_2.setTabIndex(13);
		labelPhone_2.setTabStop(false);
		labelPhone_2.setText(" Phone_2");
		labelPhone_2.setBorderStyle(BorderStyle.FIXED_3D);

		editPhone_2.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editPhone_2.setLocation(new Point(156, 252));
		editPhone_2.setSize(new Point(158, 20));
		editPhone_2.setTabIndex(4);
		editPhone_2.setText("");
		editPhone_2.setMaxLength(12);

		labelEmail.setBackColor(Color.CONTROL);
		labelEmail.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelEmail.setLocation(new Point(41, 282));
		labelEmail.setSize(new Point(110, 23));
		labelEmail.setTabIndex(14);
		labelEmail.setTabStop(false);
		labelEmail.setText(" Email");
		labelEmail.setBorderStyle(BorderStyle.FIXED_3D);

		btnClose.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		btnClose.setLocation(new Point(372, 8));
		btnClose.setSize(new Point(70, 30));
		btnClose.setTabIndex(2);
		btnClose.setText("&Fermer");
		btnClose.addOnClick(new EventHandler(this.btnClose_Click));

		editEmail.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editEmail.setLocation(new Point(157, 281));
		editEmail.setSize(new Point(222, 20));
		editEmail.setTabIndex(5);
		editEmail.setText("");
		editEmail.setMaxLength(50);

		btnUpdate.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		btnUpdate.setLocation(new Point(200, 8));
		btnUpdate.setSize(new Point(70, 30));
		btnUpdate.setTabIndex(1);
		btnUpdate.setText("&Enregistrer");
		btnUpdate.addOnClick(new EventHandler(this.btnUpdate_Click));

		labelSite_web.setBackColor(Color.CONTROL);
		labelSite_web.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelSite_web.setLocation(new Point(41, 312));
		labelSite_web.setSize(new Point(110, 23));
		labelSite_web.setTabIndex(15);
		labelSite_web.setTabStop(false);
		labelSite_web.setText(" Site_web");
		labelSite_web.setBorderStyle(BorderStyle.FIXED_3D);

		btnAdd.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		btnAdd.setLocation(new Point(12, 8));
		btnAdd.setSize(new Point(70, 30));
		btnAdd.setTabIndex(0);
		btnAdd.setText("&Nouveau");
		btnAdd.addOnClick(new EventHandler(this.btnAdd_Click));

		editSite_web.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editSite_web.setLocation(new Point(159, 311));
		editSite_web.setSize(new Point(222, 20));
		editSite_web.setTabIndex(6);
		editSite_web.setText("");
		editSite_web.setMaxLength(50);

		panel1.setBackColor(new Color(0, 192, 192));
		panel1.setDock(ControlDock.BOTTOM);
		panel1.setLocation(new Point(0, 402));
		panel1.setSize(new Point(475, 50));
		panel1.setTabIndex(16);
		panel1.setText("");
		panel1.setBorderStyle(BorderStyle.FIXED_3D);

		editNom.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNom.setLocation(new Point(156, 165));
		editNom.setSize(new Point(270, 20));
		editNom.setTabIndex(1);
		editNom.setText("ABC");
		editNom.setCharacterCasing(CharacterCasing.UPPER);
		editNom.setMaxLength(50);

		label1.setBackColor(new Color(255, 255, 192));
		label1.setFont(new Font("Verdana", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		label1.setForeColor(Color.AQUA);
		label1.setLocation(new Point(38, 17));
		label1.setSize(new Point(392, 24));
		label1.setTabIndex(17);
		label1.setTabStop(false);
		label1.setText("Inscription d\'une Compagnie d\'Assurance");
		label1.setBorderStyle(BorderStyle.FIXED_3D);
		label1.setTextAlign(HorizontalAlignment.CENTER);

		labelAdresse.setBackColor(Color.CONTROL);
		labelAdresse.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelAdresse.setLocation(new Point(41, 194));
		labelAdresse.setSize(new Point(110, 23));
		labelAdresse.setTabIndex(9);
		labelAdresse.setTabStop(false);
		labelAdresse.setText(" Adresse");
		labelAdresse.setBorderStyle(BorderStyle.FIXED_3D);

		editAdresse.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editAdresse.setLocation(new Point(156, 193));
		editAdresse.setSize(new Point(270, 20));
		editAdresse.setTabIndex(2);
		editAdresse.setText("");
		editAdresse.setMaxLength(50);

		dataBinder1.setDataSource(dataSource1);
		dataBinder1.setDataMember("");
		dataBinder1.setBindings(new DataBinding[] {
								new DataBinding(editNom, "Text", "Nom", null), 
								new DataBinding(editAdresse, "Text", "Adresse", null), 
								new DataBinding(editPhone_1, "Text", "Phone_1", null), 
								new DataBinding(editPhone_2, "Text", "Phone_2", null), 
								new DataBinding(editEmail, "Text", "Email", null), 
								new DataBinding(editSite_web, "Text", "Site_web", null)});
		/* @designTimeOnly dataBinder1.setLocation(new Point(360, 80)); */

		labelNom.setBackColor(Color.CONTROL);
		labelNom.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNom.setLocation(new Point(41, 165));
		labelNom.setSize(new Point(110, 23));
		labelNom.setTabIndex(0);
		labelNom.setTabStop(false);
		labelNom.setText(" Nom");
		labelNom.setBorderStyle(BorderStyle.FIXED_3D);

		pictureBox6.setLocation(new Point(7, 64));
		pictureBox6.setSize(new Point(88, 80));
		pictureBox6.setTabIndex(12);
		pictureBox6.setTabStop(false);
		pictureBox6.setText("pictureBox2");
		pictureBox6.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox6.setImage((Bitmap)resources.getObject("pictureBox6_image"));
		pictureBox6.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		panel2.setLocation(new Point(7, 149));
		panel2.setSize(new Point(456, 216));
		panel2.setTabIndex(18);
		panel2.setText("panel2");
		panel2.setBorderStyle(BorderStyle.FIXED_3D);

		groupBox1.setBackColor(Color.ACTIVEBORDER);
		groupBox1.setLocation(new Point(35, 154));
		groupBox1.setSize(new Point(400, 200));
		groupBox1.setTabIndex(22);
		groupBox1.setTabStop(false);
		groupBox1.setText("");

		pictureBox4.setLocation(new Point(441, 161));
		pictureBox4.setSize(new Point(16, 193));
		pictureBox4.setTabIndex(7);
		pictureBox4.setTabStop(false);
		pictureBox4.setText("pictureBox2");
		pictureBox4.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox4.setImage((Bitmap)resources.getObject("pictureBox4_image"));
		pictureBox4.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox3.setLocation(new Point(14, 161));
		pictureBox3.setSize(new Point(16, 193));
		pictureBox3.setTabIndex(8);
		pictureBox3.setTabStop(false);
		pictureBox3.setText("pictureBox2");
		pictureBox3.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox3.setImage((Bitmap)resources.getObject("pictureBox3_image"));
		pictureBox3.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox1.setLocation(new Point(30, 51));
		pictureBox1.setSize(new Point(88, 80));
		pictureBox1.setTabIndex(21);
		pictureBox1.setTabStop(false);
		pictureBox1.setText("pictureBox1");
		pictureBox1.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox1.setImage((Bitmap)resources.getObject("pictureBox1_image"));
		pictureBox1.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox2.setLocation(new Point(7, 13));
		pictureBox2.setSize(new Point(456, 32));
		pictureBox2.setTabIndex(11);
		pictureBox2.setTabStop(false);
		pictureBox2.setText("pictureBox2");
		pictureBox2.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox2.setImage((Bitmap)resources.getObject("pictureBox2_image"));
		pictureBox2.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		this.setNewControls(new Control[] {
							pictureBox4, 
							pictureBox3, 
							pictureBox1, 
							pictureBox6, 
							label1, 
							panel1, 
							editSite_web, 
							labelSite_web, 
							editEmail, 
							labelEmail, 
							editPhone_2, 
							labelPhone_2, 
							editPhone_1, 
							labelPhone_1, 
							editAdresse, 
							labelAdresse, 
							editNom, 
							labelNom, 
							groupBox1, 
							panel2, 
							pictureBox2});
		panel1.setNewControls(new Control[] {
							  btnClose, 
							  btnUpdate, 
							  btnAdd});

		dataSource1.begin();
		dataBinder1.begin();
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
        Application.run( new Saisie_Compagnie() );
    }
}
