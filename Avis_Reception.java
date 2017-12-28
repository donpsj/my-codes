    //Avis_Reception.java

import com.ms.wfc.app.*;
import com.ms.wfc.core.*;
import com.ms.wfc.ui.*;
import com.ms.wfc.data.*;
import com.ms.wfc.data.ui.*;

public class Avis_Reception extends Form
{     public String vdate = new String();
	  public String vdate1 = new String();
	   
	  
	 	  
	public void btnAdd_Click(Object sender, Event evt)
    {  	
		try
        {  
			hide();
		    Application.run(new Avis_Reception());
		   dataSource1.getRecordset().addNew();
           m_bAddNew = true;
		   btnAdd.setEnabled( false );
		   btnUpdate.setEnabled(true );
		   jour.setText(""); 
		    mois.setText("");
			an.setText("");
			jour1.setText(""); 
		    mois1.setText("");
		    an1.setText("");
			editRef_Facture.setText("0");
			editReceveur.setText("");	
		  }
				
        catch (Exception e)
        {
            handleADOException(e);
        }
       }
     
    public void btnUpdate_Click(Object sender, Event evt)
    {   		  	
		DataSource psj = new DataSource();
		psj.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		psj.setCommandText("select * from Facture where No_facture = "+editRef_Facture.getText()+"");			   			
        psj.begin();
		
		DataSource ps = new DataSource();
		ps.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		ps.setCommandText("select * from Avis where Ref_Facture = "+editRef_Facture.getText()+"");			   			
        ps.begin();
		try
        {  
			int nfact = (Integer.valueOf(editRef_Facture.getText()).intValue());
			
			if(jour.getText().equals("")||mois.getText().equals("")||an.getText().equals(""))
			{MessageBox.show("Entrez la Date De Reception sous la Forme :'JJ MM AA '","Champ Vide",MessageBox.ICONERROR);
			}
			else
				if(editRef_Facture.getText().equals("0"))
			{MessageBox.show("Entrez le Numéro de la Facture S.V.P '","Champ Vide",MessageBox.ICONERROR);
			}
			 
			else
				if(editReceveur.getText().equals(""))
			{MessageBox.show("Entrez le Nom du Receveur S.V.P '","Champ Vide",MessageBox.ICONERROR);
			}
			else
				if(jour1.getText().equals("")||mois1.getText().equals("")||an1.getText().equals(""))
			{
					MessageBox.show("Entrez la Date Projetée Sous la Forme :'JJ MM AA '","Champ Vide",MessageBox.ICONERROR);
			}						
			else
			   if(jour.getText().compareTo(jour1.getText())==0 && mois.getText().compareTo(mois1.getText())==0&& an.getText().compareTo(an1.getText())==0)
			   {   MessageBox.show("La Date Projetée ne Peut être égale a la Date de Reception","Champ Vide",MessageBox.ICONERROR);
			       jour1.setText(""); 
		           mois1.setText("");
		           an1.setText("");   }
			   else
				   if(jour.getText().compareTo(jour1.getText())>0 && mois.getText().compareTo(mois1.getText())>0 && an.getText().compareTo(an1.getText())>=0)
			   {   MessageBox.show("La Date Projetée ne Peut être Inférieure à la Date de Reception","Données Incompatibles",MessageBox.ICONERROR);
			       jour1.setText(""); 
		           mois1.setText("");
		           an1.setText("");   }
							    			 					
			 	else
				  if( jour.getText().equals("31")&&(mois.getText().equals("02")||mois.getText().equals("04")||mois.getText().equals("06")||mois.getText().equals("09")||mois.getText().equals("11")))
					{ MessageBox.show("Dans la Date de Reception de la Facture, le Mois ne Porte pas 31 jours","Données Incompatibles",MessageBox.ICONERROR);
					}
				else
					 if(mois.getText().equals("02")&&jour.getText().equals("30"))
					 {  MessageBox.show("Dans la Date de Reception de la Facture, le Mois de Février Porte  29 Jours au Maximum","Champ Vide",MessageBox.ICONERROR);
					 }	
			    else
				    if( jour1.getText().equals("31")&&(mois1.getText().equals("02")||mois1.getText().equals("04")||mois1.getText().equals("06")||mois1.getText().equals("09")||mois1.getText().equals("11")))
					{ MessageBox.show("Dans la Date de Projection, le Mois ne Porte pas 31 jours","Données Incompatibles",MessageBox.ICONERROR);
					}
				else
					 if(mois1.getText().equals("02")&&jour1.getText().equals("30"))
					 {  MessageBox.show("Dans la date de projection, le mois de Février Porte  29 jours au maximum","Données Incompatibles",MessageBox.ICONERROR);
					 }	
				 else
					if(String.valueOf(psj.getRecordset().getRecordCount()).equals("0"))
			          {MessageBox.show("Desolé, La Facture Numéro << "+editRef_Facture.getText()+" >> n'existe pas !", " Données Introuvables",MessageBox.ICONERROR);
				       psj.close();
				      }
					else
					 
					if(String.valueOf(ps.getRecordset().getRecordCount()).equals("1"))
			          {MessageBox.show("Desolé la Facture Numéro <<"+editRef_Facture.getText()+">> a été déjà Livrée !", " Opérations  Illégales",MessageBox.ICONSTOP);
				       ps.close();
				      }
     			else
				{	
			    vdate = jour.getSelectedItem()+ "/" + mois.getSelectedItem()+ "/" +"20"+""+an.getText();
		        editDate_Recep.setText(String.valueOf(vdate));
			 
			   vdate1 = jour1.getSelectedItem()+ "/" + mois1.getSelectedItem()+ "/" +"20"+""+an1.getText();
			   editProjection.setText(String.valueOf(vdate1));
			  				   
			   this.setCursor( Cursor.WAIT );
               dataBinder1.commitChanges();
               dataSource1.getRecordset().update();

             if( m_bAddNew )
             {
                dataSource1.requery();
                dataSource1.getRecordset().moveLast();
             }
			 MessageBox.show("Felicitations !! La Facture Numéro<< "+editRef_Facture.getText()+" >> a été Délivrée ", " Confirmation",MessageBox.ICONINFORMATION);
              
			  btnAdd.setEnabled( true );
		      btnUpdate.setEnabled(false );
			  }
		   }
		
		catch (NumberFormatException e ){
		 MessageBox.show("Attention, le Numéro Doit être un Nombre Entier!", " Données Incompatibles",MessageBox.ICONERROR);
		 }
	        catch (Exception e)
		{   handleADOException(e);
					 
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
	
    public Avis_Reception()
    {
        // Required for Visual J++ Form Designer support
        initForm();
        
        this.show();
        this.update();
		dataSource1.getRecordset().addNew();
        m_bAddNew = true;
		btnAdd.setEnabled( false );
		btnUpdate.setEnabled(true );
		jour.setText(""); 
		mois.setText("");
		an.setText("");
		jour1.setText(""); 
		mois1.setText("");
		an1.setText("");
		editRef_Facture.setText("0");
		editReceveur.setText("");	  
	  

        //TODO: Add any constructor code after initForm call
    }    

    public void formClose(Event e)
    {
       hide();
    }    

    
    void handleADOException(Exception e)
    {
        e.printStackTrace();
        MessageBox.show( e.toString(), "Avis_Reception" );
    }

	private void Avis_Reception_click(Object source, Event e)
	{
	
	 	 		
	}

	private void pictureBox1_click(Object source, Event e)
	{
		
	}

	/**
	 * NOTE: The following code is required by the Visual J++ form
	 * designer.  It can be modified using the form editor.  Do not
	 * modify it using the code editor.
	 */
	Container components = new Container();
	DataSource dataSource1 = new DataSource(components);
	DataBinder dataBinder1 = new DataBinder(components);
	Label labelNo_Avis = new Label();
	Edit editNo_Avis = new Edit();
	Label labelDate_Recep = new Label();
	Edit editDate_Recep = new Edit();
	Label labelRef_Facture = new Label();
	Edit editRef_Facture = new Edit();
	Label labelReceveur = new Label();
	Edit editReceveur = new Edit();
	Label labelProjection = new Label();
	Edit editProjection = new Edit();
	Button btnAdd = new Button();
	Button btnUpdate = new Button();
	Button btnClose = new Button();
	Panel panel1 = new Panel();
	ComboBox mois = new ComboBox();
	ComboBox jour = new ComboBox();
	Edit an = new Edit();
	Label label1 = new Label();
	Label label2 = new Label();
	ComboBox jour1 = new ComboBox();
	ComboBox mois1 = new ComboBox();
	Edit an1 = new Edit();
	Panel panel2 = new Panel();
	PictureBox pictureBox1 = new PictureBox();
	Label label3 = new Label();
	Label label4 = new Label();
	PictureBox pictureBox3 = new PictureBox();
	PictureBox pictureBox2 = new PictureBox();
	PictureBox pictureBox4 = new PictureBox();
	PictureBox pictureBox6 = new PictureBox();

	private void initForm()
	{
		// REMARQUE : cette feuille stocke des informations sur les ressources
		// dans un fichier externe. Ne modifiez le paramètre de chaîne d'aucun
		// appel de fonction resources.getObject(). Par exemple,
		// ne modifiez pas "foo1_location" dans la ligne de code
		// suivante, même si le nom de l'objet Foo change : 
		//	 foo1.setLocation((Point)resources.getObject("foo1_location"));

		IResourceManager resources = new ResourceManager(this, "Avis_Reception");
		this.setForeColor(Color.BLACK);
		this.setLocation(new Point(7, 7));
		this.setText("Avis de Reception");
		this.setAutoScaleBaseSize(new Point(5, 13));
		this.setBorderStyle(FormBorderStyle.NONE);
		this.setClientSize(new Point(470, 380));
		this.setMaximizeBox(false);
		this.setStartPosition(FormStartPosition.CENTER_SCREEN);
		this.addOnClick(new EventHandler(this.Avis_Reception_click));

		dataSource1.setConnectionString("Provider=MSDASQL.1;Persist Security Info=False;Extended Properties=\"DSN=HAH;DBQ=c:\\ASSURE.MDB;DefaultDir=c:;DriverId=25;FIL=MS Access;MaxBufferSize=2048;PageTimeout=5;UID=admin;\"");
		dataSource1.setCommandText("select No_Avis, Date_Recep, Ref_Facture, Receveur, Projection from Avis");
		dataSource1.setSort(null);
		dataSource1.setStayInSync(true);
		dataSource1.setUserId(null);
		dataSource1.setPassword(null);
		/* @designTimeOnly dataSource1.setLocation(new Point(352, 80)); */

		labelNo_Avis.setBackColor(Color.CONTROL);
		labelNo_Avis.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNo_Avis.setLocation(new Point(52, 158));
		labelNo_Avis.setSize(new Point(160, 20));
		labelNo_Avis.setTabIndex(10);
		labelNo_Avis.setTabStop(false);
		labelNo_Avis.setText("No de l\'Avis de Reception");
		labelNo_Avis.setBorderStyle(BorderStyle.FIXED_3D);

		editNo_Avis.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNo_Avis.setEnabled(false);
		editNo_Avis.setLocation(new Point(218, 157));
		editNo_Avis.setSize(new Point(71, 20));
		editNo_Avis.setTabIndex(13);
		editNo_Avis.setText("");
		editNo_Avis.setReadOnly(true);

		labelDate_Recep.setBackColor(Color.CONTROL);
		labelDate_Recep.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelDate_Recep.setLocation(new Point(52, 204));
		labelDate_Recep.setSize(new Point(192, 20));
		labelDate_Recep.setTabIndex(14);
		labelDate_Recep.setTabStop(false);
		labelDate_Recep.setText("Date de Reception de la Facture");
		labelDate_Recep.setBorderStyle(BorderStyle.FIXED_3D);

		editDate_Recep.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editDate_Recep.setLocation(new Point(352, 120));
		editDate_Recep.setSize(new Point(55, 20));
		editDate_Recep.setTabIndex(15);
		editDate_Recep.setText("");
		editDate_Recep.setVisible(false);
		editDate_Recep.setAcceptsTab(true);
		editDate_Recep.setMaxLength(20);
		editDate_Recep.setMultiline(true);

		labelRef_Facture.setBackColor(Color.CONTROL);
		labelRef_Facture.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelRef_Facture.setLocation(new Point(52, 230));
		labelRef_Facture.setSize(new Point(192, 20));
		labelRef_Facture.setTabIndex(16);
		labelRef_Facture.setTabStop(false);
		labelRef_Facture.setText("No de la Facture Reçue");
		labelRef_Facture.setBorderStyle(BorderStyle.FIXED_3D);

		editRef_Facture.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRef_Facture.setLocation(new Point(251, 230));
		editRef_Facture.setSize(new Point(153, 20));
		editRef_Facture.setTabIndex(4);
		editRef_Facture.setText("");
		editRef_Facture.setAutoSize(false);

		labelReceveur.setBackColor(Color.CONTROL);
		labelReceveur.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelReceveur.setLocation(new Point(52, 256));
		labelReceveur.setSize(new Point(192, 20));
		labelReceveur.setTabIndex(17);
		labelReceveur.setTabStop(false);
		labelReceveur.setText("Le Nom du Receveur");
		labelReceveur.setBorderStyle(BorderStyle.FIXED_3D);

		editReceveur.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editReceveur.setLocation(new Point(251, 255));
		editReceveur.setSize(new Point(153, 20));
		editReceveur.setTabIndex(5);
		editReceveur.setText("");
		editReceveur.setMaxLength(50);

		labelProjection.setBackColor(Color.CONTROL);
		labelProjection.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelProjection.setLocation(new Point(53, 296));
		labelProjection.setSize(new Point(192, 20));
		labelProjection.setTabIndex(18);
		labelProjection.setTabStop(false);
		labelProjection.setText("Date Projetée");
		labelProjection.setBorderStyle(BorderStyle.FIXED_3D);

		editProjection.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editProjection.setLocation(new Point(224, 120));
		editProjection.setSize(new Point(63, 16));
		editProjection.setTabIndex(19);
		editProjection.setText("");
		editProjection.setVisible(false);
		editProjection.setMaxLength(20);
		editProjection.setMultiline(true);

		dataBinder1.setDataSource(dataSource1);
		dataBinder1.setDataMember("");
		dataBinder1.setBindings(new DataBinding[] {
								new DataBinding(editRef_Facture, "Text", "Ref_Facture", null), 
								new DataBinding(editReceveur, "Text", "Receveur", null), 
								new DataBinding(editProjection, "Text", "Projection", null), 
								new DataBinding(editDate_Recep, "Text", "Date_Recep", null), 
								new DataBinding(editNo_Avis, "Text", "No_Avis", null)});
		/* @designTimeOnly dataBinder1.setLocation(new Point(240, 80)); */

		btnAdd.setLocation(new Point(8, 2));
		btnAdd.setSize(new Point(70, 30));
		btnAdd.setTabIndex(0);
		btnAdd.setText("&Nouveau");
		btnAdd.addOnClick(new EventHandler(this.btnAdd_Click));

		btnUpdate.setLocation(new Point(192, 2));
		btnUpdate.setSize(new Point(70, 30));
		btnUpdate.setTabIndex(1);
		btnUpdate.setText("&Enregistrer");
		btnUpdate.addOnClick(new EventHandler(this.btnUpdate_Click));

		btnClose.setLocation(new Point(376, 2));
		btnClose.setSize(new Point(70, 30));
		btnClose.setTabIndex(2);
		btnClose.setText("&Fermer");
		btnClose.addOnClick(new EventHandler(this.btnClose_Click));

		panel1.setBackColor(new Color(0, 192, 192));
		panel1.setDock(ControlDock.BOTTOM);
		panel1.setLocation(new Point(0, 340));
		panel1.setSize(new Point(470, 40));
		panel1.setTabIndex(20);
		panel1.setText("");
		panel1.setBorderStyle(BorderStyle.FIXED_3D);

		mois.setLocation(new Point(301, 204));
		mois.setSize(new Point(48, 21));
		mois.setTabIndex(2);
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

		jour.setLocation(new Point(252, 204));
		jour.setSize(new Point(48, 21));
		jour.setTabIndex(1);
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

		an.setLocation(new Point(351, 204));
		an.setSize(new Point(48, 20));
		an.setTabIndex(3);
		an.setText("");
		an.setMaxLength(2);

		label1.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, true, false, false, CharacterSet.DEFAULT, 0));
		label1.setLocation(new Point(252, 188));
		label1.setSize(new Point(146, 14));
		label1.setTabIndex(22);
		label1.setTabStop(false);
		label1.setText(" JOUR       MOIS      ANNEE");
		label1.setBorderStyle(BorderStyle.FIXED_3D);

		label2.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, true, false, false, CharacterSet.DEFAULT, 0));
		label2.setLocation(new Point(251, 280));
		label2.setSize(new Point(146, 14));
		label2.setTabIndex(21);
		label2.setTabStop(false);
		label2.setText(" JOUR       MOIS      ANNEE");
		label2.setBorderStyle(BorderStyle.FIXED_3D);

		jour1.setLocation(new Point(251, 296));
		jour1.setSize(new Point(48, 21));
		jour1.setTabIndex(6);
		jour1.setText("");
		jour1.setItems(new Object[] {
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

		mois1.setLocation(new Point(300, 296));
		mois1.setSize(new Point(48, 21));
		mois1.setTabIndex(7);
		mois1.setText("");
		mois1.setItems(new Object[] {
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

		an1.setLocation(new Point(349, 296));
		an1.setSize(new Point(48, 20));
		an1.setTabIndex(8);
		an1.setText("");
		an1.setMaxLength(2);

		panel2.setLocation(new Point(32, 152));
		panel2.setSize(new Point(400, 176));
		panel2.setTabIndex(23);
		panel2.setText("panel2");
		panel2.setBorderStyle(BorderStyle.FIXED_3D);

		pictureBox1.setLocation(new Point(51, 47));
		pictureBox1.setSize(new Point(88, 80));
		pictureBox1.setTabIndex(27);
		pictureBox1.setTabStop(false);
		pictureBox1.setText("pictureBox1");
		pictureBox1.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox1.setImage((Bitmap)resources.getObject("pictureBox1_image"));
		pictureBox1.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);
		pictureBox1.addOnClick(new EventHandler(this.pictureBox1_click));

		label3.setBackColor(new Color(255, 255, 192));
		label3.setFont(new Font("Verdana", 14.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label3.setForeColor(Color.AQUA);
		label3.setLocation(new Point(64, 13));
		label3.setSize(new Point(352, 24));
		label3.setTabIndex(26);
		label3.setTabStop(false);
		label3.setText("Avis de Reception d\'une Facture");
		label3.setBorderStyle(BorderStyle.FIXED_3D);
		label3.setTextAlign(HorizontalAlignment.CENTER);

		label4.setBackColor(Color.YELLOW);
		label4.setForeColor(Color.BLACK);
		label4.setLocation(new Point(258, 6));
		label4.setSize(new Point(24, 16));
		label4.setTabIndex(0);
		label4.setTabStop(false);
		label4.setText("Auto");
		label4.setTextAlign(HorizontalAlignment.CENTER);

		pictureBox3.setLocation(new Point(440, 152));
		pictureBox3.setSize(new Point(16, 176));
		pictureBox3.setTabIndex(12);
		pictureBox3.setTabStop(false);
		pictureBox3.setText("pictureBox2");
		pictureBox3.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox3.setImage((Bitmap)resources.getObject("pictureBox3_image"));
		pictureBox3.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox2.setLocation(new Point(8, 152));
		pictureBox2.setSize(new Point(16, 176));
		pictureBox2.setTabIndex(11);
		pictureBox2.setTabStop(false);
		pictureBox2.setText("pictureBox2");
		pictureBox2.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox2.setImage((Bitmap)resources.getObject("pictureBox2_image"));
		pictureBox2.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox4.setLocation(new Point(32, 10));
		pictureBox4.setSize(new Point(416, 32));
		pictureBox4.setTabIndex(9);
		pictureBox4.setTabStop(false);
		pictureBox4.setText("pictureBox2");
		pictureBox4.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox4.setImage((Bitmap)resources.getObject("pictureBox4_image"));
		pictureBox4.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox6.setLocation(new Point(32, 68));
		pictureBox6.setSize(new Point(88, 80));
		pictureBox6.setTabIndex(0);
		pictureBox6.setTabStop(false);
		pictureBox6.setText("pictureBox2");
		pictureBox6.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox6.setImage((Bitmap)resources.getObject("pictureBox6_image"));
		pictureBox6.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		this.setNewControls(new Control[] {
							pictureBox2, 
							pictureBox3, 
							label2, 
							label3, 
							pictureBox1, 
							an1, 
							mois1, 
							jour1, 
							label1, 
							an, 
							jour, 
							mois, 
							panel1, 
							labelNo_Avis, 
							editNo_Avis, 
							labelDate_Recep, 
							labelRef_Facture, 
							editRef_Facture, 
							labelReceveur, 
							editReceveur, 
							labelProjection, 
							editProjection, 
							editDate_Recep, 
							panel2, 
							pictureBox4, 
							pictureBox6});
		panel1.setNewControls(new Control[] {
							  btnAdd, 
							  btnUpdate, 
							  btnClose});
		panel2.setNewControls(new Control[] {
							  label4});

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
        Application.run( new Avis_Reception() );
    }
}
