//Inscription.java

import com.ms.wfc.app.*;
import com.ms.wfc.core.*;
import com.ms.wfc.ui.*;
import com.ms.wfc.data.*;
import com.ms.wfc.data.ui.*;

public class Inscription extends Form
{

    public void btnAdd_Click(Object sender, Event evt)
    {
        try
        {    dataSource1.getRecordset().cancelUpdate();
            dataSource1.getRecordset().addNew();
            m_bAddNew = true;
            btnAdd.setEnabled( false );
			btnUpdate.setEnabled( true );
            editNom.setText("");
			editAdresse.setText("");
			editPhone.setText("");
			editMail.setText("");
			editWeb.setText("");
			
             
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
		rech.setCommandText("select * from Institution where Nom = '"+editNom.getText()+"'");			  			
        rech.begin();
		try
        {
			if(editNom.getText().equals(""))
			{MessageBox.show("Veuillez Entrer le Nom de l'Institution S.V.P !","Champ Vide",MessageBox.ICONERROR);
			}
			else
			   if(editAdresse.getText().equals(""))
			   {  MessageBox.show("Veuillez Entrer l'Adresse de l'Institution S.V.P !","Champ Vide",MessageBox.ICONERROR);
			   }	  
			else
			  if(editPhone.getText().equals(""))
			  {MessageBox.show("Veuillez Entrer le Numéro de Téléphone de l'Institution S.V.P !","Champ Vide",MessageBox.ICONERROR);
			  }  	
			else
			  if(String.valueOf(rech.getRecordset().getRecordCount()).equals("1"))
			   {MessageBox.show("Désolé l'Institution '"+editNom.getText()+"' est déjà inscrite !","Opération Illégale",MessageBox.ICONSTOP);
				editNom.setText("");
		        editAdresse.setText("");
		        editMail.setText("");
		        editPhone.setText("");
		        editWeb.setText("");
				}
		  else
		  { this.setCursor( Cursor.WAIT );
            dataBinder1.commitChanges();
            dataSource1.getRecordset().update();
			MessageBox.show("Felicitations !! L'inscription de l'Institution << "+editNom.getText()+" >> est faite ", " Confirmation",MessageBox.ICONINFORMATION);

            if( m_bAddNew )
            {
                dataSource1.requery();
                dataSource1.getRecordset().moveLast();
            }
			btnAdd.setEnabled( true );
			btnUpdate.setEnabled( false );
		  }   }
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
	
    public Inscription()
    {
        // Required for Visual J++ Form Designer support
        initForm();
         	
        this.show();
        this.update();

		    dataSource1.getRecordset().cancelUpdate();
            dataSource1.getRecordset().addNew();
            m_bAddNew = true;
            btnAdd.setEnabled( false );
			btnUpdate.setEnabled( true );
            editNom.setText("");
			editAdresse.setText("");
			editPhone.setText("");
			editMail.setText("");
			editWeb.setText("");
        //TODO: Add any constructor code after initForm call
    }    

    public void formClose(Event e)
    {
       hide();
    }    

    
    void handleADOException(Exception e)
    {
        e.printStackTrace();
        MessageBox.show( e.toString(), "Inscription" );
    }

	/**
	 * NOTE: The following code is required by the Visual J++ form
	 * designer.  It can be modified using the form editor.  Do not
	 * modify it using the code editor.
	 */
	Container components = new Container();
	DataSource dataSource1 = new DataSource(components);
	DataBinder dataBinder1 = new DataBinder(components);
	Label labelNom = new Label();
	Edit editNom = new Edit();
	Label labelAdresse = new Label();
	Edit editAdresse = new Edit();
	Label labelPhone = new Label();
	Edit editPhone = new Edit();
	Label labelMail = new Label();
	Edit editMail = new Edit();
	Label labelWeb = new Label();
	Edit editWeb = new Edit();
	PictureBox pictureBox4 = new PictureBox();
	Panel panel2 = new Panel();
	Button btnAdd = new Button();
	PictureBox pictureBox1 = new PictureBox();
	Button btnUpdate = new Button();
	Button btnClose = new Button();
	Panel panel1 = new Panel();
	Label label1 = new Label();
	PictureBox pictureBox3 = new PictureBox();
	PictureBox pictureBox2 = new PictureBox();

	private void initForm()
	{
		// REMARQUE : cette feuille stocke des informations sur les ressources
		// dans un fichier externe. Ne modifiez le paramètre de chaîne d'aucun
		// appel de fonction resources.getObject(). Par exemple,
		// ne modifiez pas "foo1_location" dans la ligne de code
		// suivante, même si le nom de l'objet Foo change : 
		//	 foo1.setLocation((Point)resources.getObject("foo1_location"));

		IResourceManager resources = new ResourceManager(this, "Inscription");
		this.setLocation(new Point(7, 7));
		this.setText("Inscription d\'une institution");
		this.setAutoScaleBaseSize(new Point(5, 13));
		this.setAutoScroll(true);
		this.setBorderStyle(FormBorderStyle.NONE);
		this.setClientSize(new Point(478, 345));
		this.setStartPosition(FormStartPosition.CENTER_SCREEN);

		dataSource1.setConnectionString("PROVIDER=MSDASQL;dsn=HAH;uid=genial;pwd=genial;DBQ=C:\\ASSURE.MDB");
		dataSource1.setCommandText("select Nom, Adresse, Phone, Mail, Web, Charge from Institution");
		dataSource1.setSort(null);
		dataSource1.setStayInSync(true);
		dataSource1.setUserId(null);
		dataSource1.setPassword(null);
		/* @designTimeOnly dataSource1.setLocation(new Point(248, 72)); */

		labelNom.setBackColor(Color.CONTROL);
		labelNom.setFont(new Font("MS Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNom.setLocation(new Point(96, 117));
		labelNom.setSize(new Point(88, 20));
		labelNom.setTabIndex(1);
		labelNom.setTabStop(false);
		labelNom.setText("Nom");
		labelNom.setBorderStyle(BorderStyle.FIXED_3D);

		editNom.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNom.setLocation(new Point(190, 116));
		editNom.setSize(new Point(176, 20));
		editNom.setTabIndex(2);
		editNom.setText("UNAH");
		editNom.setCharacterCasing(CharacterCasing.UPPER);
		editNom.setMaxLength(50);
		editNom.setMultiline(true);

		labelAdresse.setBackColor(Color.CONTROL);
		labelAdresse.setFont(new Font("MS Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelAdresse.setLocation(new Point(96, 141));
		labelAdresse.setSize(new Point(88, 20));
		labelAdresse.setTabIndex(3);
		labelAdresse.setTabStop(false);
		labelAdresse.setText("Adresse");
		labelAdresse.setBorderStyle(BorderStyle.FIXED_3D);

		editAdresse.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editAdresse.setLocation(new Point(189, 141));
		editAdresse.setSize(new Point(176, 20));
		editAdresse.setTabIndex(4);
		editAdresse.setText("Diquini 63");
		editAdresse.setMaxLength(50);
		editAdresse.setMultiline(true);

		labelPhone.setBackColor(Color.CONTROL);
		labelPhone.setFont(new Font("MS Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelPhone.setLocation(new Point(96, 165));
		labelPhone.setSize(new Point(88, 20));
		labelPhone.setTabIndex(5);
		labelPhone.setTabStop(false);
		labelPhone.setText("Phone");
		labelPhone.setBorderStyle(BorderStyle.FIXED_3D);

		editPhone.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editPhone.setLocation(new Point(189, 165));
		editPhone.setSize(new Point(176, 20));
		editPhone.setTabIndex(6);
		editPhone.setText("");
		editPhone.setMaxLength(50);
		editPhone.setMultiline(true);

		labelMail.setBackColor(Color.CONTROL);
		labelMail.setFont(new Font("MS Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelMail.setLocation(new Point(96, 190));
		labelMail.setSize(new Point(88, 20));
		labelMail.setTabIndex(7);
		labelMail.setTabStop(false);
		labelMail.setText("Mail");
		labelMail.setBorderStyle(BorderStyle.FIXED_3D);

		editMail.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editMail.setLocation(new Point(189, 190));
		editMail.setSize(new Point(176, 20));
		editMail.setTabIndex(8);
		editMail.setText("");
		editMail.setMaxLength(50);
		editMail.setMultiline(true);

		labelWeb.setBackColor(Color.CONTROL);
		labelWeb.setFont(new Font("MS Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelWeb.setLocation(new Point(96, 215));
		labelWeb.setSize(new Point(88, 20));
		labelWeb.setTabIndex(9);
		labelWeb.setTabStop(false);
		labelWeb.setText("Web");
		labelWeb.setBorderStyle(BorderStyle.FIXED_3D);

		editWeb.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editWeb.setLocation(new Point(189, 215));
		editWeb.setSize(new Point(176, 20));
		editWeb.setTabIndex(10);
		editWeb.setText("");
		editWeb.setMaxLength(50);
		editWeb.setMultiline(true);

		dataBinder1.setDataSource(dataSource1);
		dataBinder1.setDataMember("");
		dataBinder1.setBindings(new DataBinding[] {
								new DataBinding(editNom, "Text", "Nom", null), 
								new DataBinding(editAdresse, "Text", "Adresse", null), 
								new DataBinding(editPhone, "Text", "Phone", null), 
								new DataBinding(editMail, "Text", "Mail", null), 
								new DataBinding(editWeb, "Text", "Web", null)});
		/* @designTimeOnly dataBinder1.setLocation(new Point(352, 72)); */

		pictureBox4.setLocation(new Point(96, 9));
		pictureBox4.setSize(new Point(336, 32));
		pictureBox4.setTabIndex(0);
		pictureBox4.setTabStop(false);
		pictureBox4.setText("pictureBox2");
		pictureBox4.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox4.setImage((Bitmap)resources.getObject("pictureBox4_image"));
		pictureBox4.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		panel2.setLocation(new Point(6, 104));
		panel2.setSize(new Point(456, 152));
		panel2.setTabIndex(14);
		panel2.setText("panel2");
		panel2.setBorderStyle(BorderStyle.FIXED_3D);

		btnAdd.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		btnAdd.setLocation(new Point(10, 8));
		btnAdd.setSize(new Point(70, 30));
		btnAdd.setTabIndex(0);
		btnAdd.setText("&Nouveau");
		btnAdd.addOnClick(new EventHandler(this.btnAdd_Click));

		pictureBox1.setLocation(new Point(6, 8));
		pictureBox1.setSize(new Point(88, 80));
		pictureBox1.setTabIndex(18);
		pictureBox1.setTabStop(false);
		pictureBox1.setText("pictureBox1");
		pictureBox1.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox1.setImage((Bitmap)resources.getObject("pictureBox1_image"));
		pictureBox1.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		btnUpdate.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		btnUpdate.setLocation(new Point(205, 8));
		btnUpdate.setSize(new Point(70, 30));
		btnUpdate.setTabIndex(1);
		btnUpdate.setText("&Enregistrer");
		btnUpdate.addOnClick(new EventHandler(this.btnUpdate_Click));

		btnClose.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		btnClose.setLocation(new Point(380, 8));
		btnClose.setSize(new Point(70, 30));
		btnClose.setTabIndex(2);
		btnClose.setText("&Fermer");
		btnClose.addOnClick(new EventHandler(this.btnClose_Click));

		panel1.setBackColor(new Color(0, 192, 192));
		panel1.setDock(ControlDock.BOTTOM);
		panel1.setLocation(new Point(0, 295));
		panel1.setSize(new Point(478, 50));
		panel1.setTabIndex(13);
		panel1.setText("");
		panel1.setBorderStyle(BorderStyle.FIXED_3D);

		label1.setBackColor(new Color(255, 255, 192));
		label1.setFont(new Font("Verdana", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		label1.setForeColor(Color.AQUA);
		label1.setLocation(new Point(128, 12));
		label1.setSize(new Point(272, 24));
		label1.setTabIndex(17);
		label1.setTabStop(false);
		label1.setText("Inscription d\'une Institution");
		label1.setBorderStyle(BorderStyle.FIXED_3D);
		label1.setTextAlign(HorizontalAlignment.CENTER);

		pictureBox3.setLocation(new Point(33, 104));
		pictureBox3.setSize(new Point(24, 152));
		pictureBox3.setTabIndex(12);
		pictureBox3.setTabStop(false);
		pictureBox3.setText("pictureBox2");
		pictureBox3.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox3.setImage((Bitmap)resources.getObject("pictureBox3_image"));
		pictureBox3.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox2.setLocation(new Point(403, 104));
		pictureBox2.setSize(new Point(24, 152));
		pictureBox2.setTabIndex(11);
		pictureBox2.setTabStop(false);
		pictureBox2.setText("pictureBox2");
		pictureBox2.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox2.setImage((Bitmap)resources.getObject("pictureBox2_image"));
		pictureBox2.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		this.setNewControls(new Control[] {
							pictureBox2, 
							pictureBox3, 
							label1, 
							pictureBox4, 
							pictureBox1, 
							panel1, 
							labelNom, 
							editNom, 
							labelAdresse, 
							editAdresse, 
							labelPhone, 
							editPhone, 
							labelMail, 
							editMail, 
							labelWeb, 
							editWeb, 
							panel2});
		panel1.setNewControls(new Control[] {
							  btnAdd, 
							  btnUpdate, 
							  btnClose});

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
        Application.run( new Inscription() );
    }
}
