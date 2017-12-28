//Paiement_Titulaire.java

import com.ms.wfc.app.*;
import com.ms.wfc.core.*;
import com.ms.wfc.ui.*;
import com.ms.wfc.data.*;
import com.ms.wfc.data.ui.*;

public class Paiement_Titulaire extends Form
{          boolean r2;
	      public String vdate = new String();
          
          

    public void btnAdd_Click(Object sender, Event evt)
    {
        try
        {   hide();
		    Application.run(new Paiement_Titulaire());
            /*dataSource1.getRecordset().cancelUpdate();
            dataSource1.getRecordset().addNew();
            m_bAddNew = true;
            btnAdd.setEnabled( false );
			btnUpdate.setEnabled(true);
			editNom.setText("");
			banque.setText("");
			editMontant.setText("0.00");
			edit3.setText("0");
			editRef_pol.setText("");
			editNo_cheq.setText("0");
			jour.setText("");
			mois.setText("");
			an.setText("");*/
           
        }
        catch (Exception e)
        {
            handleADOException(e);
        }
    }
   

    public void btnUpdate_Click(Object sender, Event evt)
    {      
		  Connection cit = new Connection();
		  Recordset titul = new Recordset();
		    
		  DataSource rec = new DataSource();
		  rec.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		  rec.setCommandText("select * from Titulaire where Nif = '"+editRef_pol.getText()+"'");	
		  rec.begin();
		  if(String.valueOf(rec.getRecordset().getRecordCount()).equals("1"))
		    { DataBinder display = new DataBinder();
				  display.setDataSource(rec);
				  display.setBindings(new DataBinding[]{
							    new DataBinding(edit1,"text","Nom"),
							    new DataBinding(edit2,"text","Prenom"),
							    new DataBinding(edit3,"text","Charge"),
								  });
			
		   }  		  		  
		          
	  try
		 {      int nchq = (Integer.valueOf(editNo_cheq.getText()).intValue());
		        double sold = (Double.valueOf(edit3.getText())).doubleValue();
		        double somp = (Double.valueOf(editMontant.getText())).doubleValue();
		        double rest;
		  
			if(jour.getText().equals("")||mois.getText().equals("")||an.getText().equals(""))
			{MessageBox.show("Entrez la Date sous la Forme :'jj  MM  AA '  S.V.P","Champ Vide",MessageBox.ICONERROR);
			}
			else
			if(jour.getText().equals("31")&&(mois.getText().equals("02")||mois.getText().equals("04")||mois.getText().equals("06")||mois.getText().equals("09")||mois.getText().equals("11")))
					{ MessageBox.show("Ce mois ne Porte pas 31 Jours","Données Incompatibles",MessageBox.ICONERROR);
					}
			else
				if(mois.getText().equals("02")&&jour.getText().equals("30"))
				 {  MessageBox.show("Le Mois de Février Porte  29 Jours au Maximum","Données Incompatibles",MessageBox.ICONERROR);
				 }	
			else
				if(editRef_pol.getText().equals(""))
				 {  MessageBox.show("Veuillez Entrer Le NIF du Titulaire ","Champ Vide",MessageBox.ICONERROR);
				 }	
			else
				if(editNom.getText().equals(""))
				{  MessageBox.show("Veuillez Entrer Le Nom Complet S.V.P ","Champ Vide",MessageBox.ICONERROR);
				 }
			else
				if(r2==true)
				 {   if(editNo_cheq.getText().equals("0"))
					  { MessageBox.show("Veuillez Entrer Le Numéro du Chèque S.V.P ","Champ Vide",MessageBox.ICONERROR);
				      } 
					  else
					     if(banque.getText().equals(""))
							 {  MessageBox.show("Veuillez Choisir La Banque Appropriée au Chèque  S.V.P ","Champ Vide",MessageBox.ICONERROR);
				              }
						  else
						     if(banque.getText().compareTo("")!=0)
							 {r2=false;   
							 }
			       }
			  else
				if(editMontant.getText().equals("0.00"))
					{  MessageBox.show("Veuillez Entrer Le Montant Versé  S.V.P ","Champ Vide",MessageBox.ICONERROR);
				    }
			   else
			if(String.valueOf(rec.getRecordset().getRecordCount()).equals("0"))
			   {MessageBox.show("Desolé le Titulaire Identifié au NIF << "+editRef_pol.getText()+" >> n'Existe pas ", "Données Introuvables", MessageBox.ICONWARNING);
			   }
			 			  
			 else
		    {  int resul=MessageBox.show(" Etes-Vous sur que ce Versement est du Titulaire << "+edit1.getText()+"  "+edit2.getText()+" >> ? Sinon, Vérifiez le NIF de ce Dernier S.V.P ", "Moment Décisif ",MessageBox.YESNO);
			   if(resul==MessageBox.IDYES)
				{	
			    	    
				 vdate = jour.getSelectedItem()+ "/" + mois.getSelectedItem()+ "/" +"20"+""+an.getText();
		        editDate_paie.setText(String.valueOf(vdate));
			    rest=sold-somp;
			    this.setCursor( Cursor.WAIT );
                dataBinder1.commitChanges();
                dataSource1.getRecordset().update();
			
				  cit.setConnectionString("dsn=HAH;uid=genial;pwd=genial");
				  cit.open();
				  titul.setActiveConnection(cit);
				  titul.setSource("Update Titulaire set Charge ="+rest+" where  Nif = '"+editRef_pol.getText()+"'");
				  titul.open();
				  if(rest<0)
			      {  rest=rest*-1;
					 MessageBox.show("Félicitations, l'Ancienne Ballance de <"+edit1.getText()+" "+edit2.getText()+"> était  de << "+sold+"  Gdes >> , Maintenant l'Hopital Devra lui Rembourser La Somme de << "+rest+" Gdes >>","Confirmation",MessageBox.ICONINFORMATION);
				  }
				  else
					  if(rest>0)
					  { MessageBox.show("Félicitations, l'Ancienne Ballance de <"+edit1.getText()+" "+edit2.getText()+"> était  de << "+sold+" Gdes >>, sa Nouvelle Balance est de << "+rest+" Gdes >>", "Confirmation",MessageBox.ICONINFORMATION);
					  }
				  else
					  if(rest==0)
						   { MessageBox.show("Félicitations, le Titulaire <"+edit1.getText()+" "+edit2.getText()+">  ne doit plus à l'Hopital car,sa Nouvelle Balance est de << "+rest+" Gdes >>  ", "Confirmation ",MessageBox.ICONINFORMATION);
					  }
                   
				  btnUpdate.setEnabled(false);
				  btnAdd.setEnabled(true);
				  
            if( m_bAddNew )
            { dataSource1.requery();
              dataSource1.getRecordset().moveLast();
            }
			 		
		 }
	 
	  }}
	  catch(NumberFormatException e){
		MessageBox.show("Attention, Le Montant Doit être un Nombre!", " Données Incompatibles",MessageBox.ICONERROR);
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
	
    public Paiement_Titulaire()
    {
        // Required for Visual J++ Form Designer support
        initForm();
        
        this.show();
        this.update();
		    dataSource1.getRecordset().cancelUpdate();
            dataSource1.getRecordset().addNew();
            m_bAddNew = true;
            btnAdd.setEnabled( false );
			editNom.setText("");
			editRef_pol.setText("");
			editNo_cheq.setText("0");
			banque.setText("");
			editMontant.setText("0.00");
			edit3.setText("0");
			jour.setText("");
			mois.setText("");
			an.setText("");

        //TODO: Add any constructor code after initForm call
    }    

    public void formClose(Event e)
    {
        Application.exit();
    }    

    
    void handleADOException(Exception e)
    {
        e.printStackTrace();
        MessageBox.show( e.toString(), "Paiement_Titulaire" );
    }

	private void radio1_checkedChanged(Object source, Event e)
	{
		boolean r1=radio1.getChecked();
		
		if(r1==true)
		{editNo_cheq.setEnabled(false);
		 banque.setEnabled(false);
		}
	}

	private void radio2_checkedChanged(Object source, Event e)
	{
		r2=radio2.getChecked();
        if(r2==true)
		{editNo_cheq.setEnabled(true);
		  banque.setEnabled(true);
		}
	}

	/**
	 * NOTE: The following code is required by the Visual J++ form
	 * designer.  It can be modified using the form editor.  Do not
	 * modify it using the code editor.
	 */
	Container components = new Container();
	DataSource dataSource1 = new DataSource(components);
	DataBinder dataBinder1 = new DataBinder(components);
	Label labelNo_paie = new Label();
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
	RadioButton radio1 = new RadioButton();
	Label labelMontant = new Label();
	Edit editMontant = new Edit();
	Button btnAdd = new Button();
	Button btnUpdate = new Button();
	Button btnClose = new Button();
	Panel panel1 = new Panel();
	Label label3 = new Label();
	ComboBox jour = new ComboBox();
	ComboBox mois = new ComboBox();
	Edit an = new Edit();
	ComboBox banque = new ComboBox();
	RadioButton radio2 = new RadioButton();
	Edit edit3 = new Edit();
	Edit edit2 = new Edit();
	Edit edit1 = new Edit();
	Label label4 = new Label();
	Label label1 = new Label();
	Panel panel2 = new Panel();
	GroupBox groupBox1 = new GroupBox();
	PictureBox pictureBox6 = new PictureBox();
	PictureBox pictureBox1 = new PictureBox();
	Label label2 = new Label();
	PictureBox pictureBox2 = new PictureBox();
	GroupBox groupBox2 = new GroupBox();
	PictureBox pictureBox3 = new PictureBox();
	PictureBox pictureBox4 = new PictureBox();

	private void initForm()
	{
		// REMARQUE : cette feuille stocke des informations sur les ressources
		// dans un fichier externe. Ne modifiez le paramètre de chaîne d'aucun
		// appel de fonction resources.getObject(). Par exemple,
		// ne modifiez pas "foo1_location" dans la ligne de code
		// suivante, même si le nom de l'objet Foo change : 
		//	 foo1.setLocation((Point)resources.getObject("foo1_location"));

		IResourceManager resources = new ResourceManager(this, "Paiement_Titulaire");
		this.setLocation(new Point(7, 7));
		this.setText("Paiement d\'un Titulaire  Assuré");
		this.setAutoScaleBaseSize(new Point(5, 13));
		this.setAutoScroll(true);
		this.setBorderStyle(FormBorderStyle.NONE);
		this.setClientSize(new Point(500, 452));
		this.setMaximizeBox(false);
		this.setStartPosition(FormStartPosition.CENTER_SCREEN);

		dataSource1.setConnectionString("Provider=MSDASQL.1;Persist Security Info=False;Extended Properties=\"dsn=HAH;uid=genial;DBQ=C:\\ASSURE.MDB\"");
		dataSource1.setCommandText("select No_paie, Date_paie, Ref_titul, Nom, No_cheq, Banque, Montant from Paiement");
		dataSource1.setSort(null);
		dataSource1.setStayInSync(true);
		dataSource1.setUserId(null);
		dataSource1.setPassword(null);
		/* @designTimeOnly dataSource1.setLocation(new Point(8, 96)); */

		labelNo_paie.setBackColor(Color.CONTROL);
		labelNo_paie.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNo_paie.setLocation(new Point(125, 109));
		labelNo_paie.setSize(new Point(120, 20));
		labelNo_paie.setTabIndex(13);
		labelNo_paie.setTabStop(false);
		labelNo_paie.setText("No de Paiement");
		labelNo_paie.setBorderStyle(BorderStyle.FIXED_3D);

		editNo_paie.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNo_paie.setEnabled(false);
		editNo_paie.setLocation(new Point(256, 109));
		editNo_paie.setSize(new Point(127, 20));
		editNo_paie.setTabIndex(15);
		editNo_paie.setText("11");
		editNo_paie.setReadOnly(true);

		labelDate_paie.setBackColor(Color.CONTROL);
		labelDate_paie.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelDate_paie.setLocation(new Point(125, 153));
		labelDate_paie.setSize(new Point(120, 20));
		labelDate_paie.setTabIndex(16);
		labelDate_paie.setTabStop(false);
		labelDate_paie.setText("Date de Paiement");
		labelDate_paie.setBorderStyle(BorderStyle.FIXED_3D);

		editDate_paie.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editDate_paie.setLocation(new Point(382, 149));
		editDate_paie.setSize(new Point(6, 20));
		editDate_paie.setTabIndex(17);
		editDate_paie.setText("2003-06-04 00:00:00");
		editDate_paie.setVisible(false);
		editDate_paie.setMaxLength(10);
		editDate_paie.setMultiline(true);

		labelRef_pol.setBackColor(Color.CONTROL);
		labelRef_pol.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelRef_pol.setLocation(new Point(96, 230));
		labelRef_pol.setSize(new Point(168, 20));
		labelRef_pol.setTabIndex(18);
		labelRef_pol.setTabStop(false);
		labelRef_pol.setText(" NIF Du Titulaire");
		labelRef_pol.setBorderStyle(BorderStyle.FIXED_3D);

		editRef_pol.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRef_pol.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		editRef_pol.setForeColor(Color.AQUA);
		editRef_pol.setLocation(new Point(271, 231));
		editRef_pol.setSize(new Point(127, 20));
		editRef_pol.setTabIndex(4);
		editRef_pol.setText("003-066-059-2");
		editRef_pol.setCharacterCasing(CharacterCasing.UPPER);
		editRef_pol.setMaxLength(13);

		labelNom.setBackColor(Color.CONTROL);
		labelNom.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNom.setLocation(new Point(96, 260));
		labelNom.setSize(new Point(168, 20));
		labelNom.setTabIndex(19);
		labelNom.setTabStop(false);
		labelNom.setText("Nom");
		labelNom.setBorderStyle(BorderStyle.FIXED_3D);

		editNom.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNom.setLocation(new Point(271, 261));
		editNom.setSize(new Point(127, 20));
		editNom.setTabIndex(5);
		editNom.setText("Prince Gary");
		editNom.setMaxLength(50);

		labelNo_cheq.setBackColor(Color.CONTROL);
		labelNo_cheq.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNo_cheq.setLocation(new Point(96, 290));
		labelNo_cheq.setSize(new Point(168, 20));
		labelNo_cheq.setTabIndex(20);
		labelNo_cheq.setTabStop(false);
		labelNo_cheq.setText("No du Chèque");
		labelNo_cheq.setBorderStyle(BorderStyle.FIXED_3D);

		editNo_cheq.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNo_cheq.setEnabled(false);
		editNo_cheq.setLocation(new Point(271, 291));
		editNo_cheq.setSize(new Point(127, 20));
		editNo_cheq.setTabIndex(6);
		editNo_cheq.setText("0");

		labelBanque.setBackColor(Color.CONTROL);
		labelBanque.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelBanque.setLocation(new Point(97, 321));
		labelBanque.setSize(new Point(168, 20));
		labelBanque.setTabIndex(21);
		labelBanque.setTabStop(false);
		labelBanque.setText("Banque");
		labelBanque.setBorderStyle(BorderStyle.FIXED_3D);

		radio1.setLocation(new Point(302, 189));
		radio1.setSize(new Point(48, 23));
		radio1.setTabIndex(25);
		radio1.setTabStop(true);
		radio1.setText("Cash");
		radio1.setChecked(true);
		radio1.addOnCheckedChanged(new EventHandler(this.radio1_checkedChanged));

		labelMontant.setBackColor(Color.CONTROL);
		labelMontant.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelMontant.setLocation(new Point(97, 351));
		labelMontant.setSize(new Point(168, 20));
		labelMontant.setTabIndex(22);
		labelMontant.setTabStop(false);
		labelMontant.setText("Montant");
		labelMontant.setBorderStyle(BorderStyle.FIXED_3D);

		editMontant.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editMontant.setLocation(new Point(271, 352));
		editMontant.setSize(new Point(127, 20));
		editMontant.setTabIndex(8);
		editMontant.setText("1000");

		btnAdd.setLocation(new Point(12, 6));
		btnAdd.setSize(new Point(65, 25));
		btnAdd.setTabIndex(0);
		btnAdd.setText("&Nouveau");
		btnAdd.addOnClick(new EventHandler(this.btnAdd_Click));

		btnUpdate.setLocation(new Point(218, 6));
		btnUpdate.setSize(new Point(65, 25));
		btnUpdate.setTabIndex(1);
		btnUpdate.setText("&Enregistrer");
		btnUpdate.addOnClick(new EventHandler(this.btnUpdate_Click));

		btnClose.setLocation(new Point(410, 6));
		btnClose.setSize(new Point(65, 25));
		btnClose.setTabIndex(2);
		btnClose.setText("&Fermer");
		btnClose.addOnClick(new EventHandler(this.btnClose_Click));

		panel1.setBackColor(new Color(0, 192, 192));
		panel1.setDock(ControlDock.BOTTOM);
		panel1.setLocation(new Point(0, 412));
		panel1.setSize(new Point(500, 40));
		panel1.setTabIndex(23);
		panel1.setText("");
		panel1.setBorderStyle(BorderStyle.FIXED_3D);

		label3.setBackColor(Color.AQUA);
		label3.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, true, false, false, CharacterSet.DEFAULT, 0));
		label3.setForeColor(new Color(255, 255, 192));
		label3.setLocation(new Point(256, 137));
		label3.setSize(new Point(144, 16));
		label3.setTabIndex(12);
		label3.setTabStop(false);
		label3.setText(" JJ    /   MM    /  AA");
		label3.setBorderStyle(BorderStyle.FIXED_3D);

		jour.setLocation(new Point(256, 153));
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

		mois.setLocation(new Point(305, 153));
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

		an.setLocation(new Point(351, 153));
		an.setSize(new Point(48, 20));
		an.setTabIndex(3);
		an.setText("");
		an.setMaxLength(2);

		banque.setEnabled(false);
		banque.setLocation(new Point(271, 319));
		banque.setSize(new Point(120, 21));
		banque.setTabIndex(7);
		banque.setText("");
		banque.setMaxLength(50);
		banque.setItems(new Object[] {
						"UNIBANK", 
						"SOGEBANK", 
						"BRH", 
						"BNC", 
						"BUH", 
						"CAPITAL BANK", 
						"SCOTIABANK", 
						"SOCABANK", 
						"PROMOBANK", 
						"CITIBANK", 
						"BPH", 
						""});

		dataBinder1.setDataSource(dataSource1);
		dataBinder1.setDataMember("");
		dataBinder1.setBindings(new DataBinding[] {
								new DataBinding(editNo_paie, "Text", "No_paie", null), 
								new DataBinding(editDate_paie, "Text", "Date_paie", null), 
								new DataBinding(editNom, "Text", "Nom", null), 
								new DataBinding(editNo_cheq, "Text", "No_cheq", null), 
								new DataBinding(editMontant, "Text", "Montant", null), 
								new DataBinding(banque, "Text", "Banque", null), 
								new DataBinding(editRef_pol, "Text", "Ref_titul", null)});
		/* @designTimeOnly dataBinder1.setLocation(new Point(8, 120)); */

		radio2.setLocation(new Point(358, 189));
		radio2.setSize(new Point(64, 23));
		radio2.setTabIndex(24);
		radio2.setText("Chèque");
		radio2.addOnCheckedChanged(new EventHandler(this.radio2_checkedChanged));

		edit3.setLocation(new Point(16, 188));
		edit3.setSize(new Point(24, 20));
		edit3.setTabIndex(29);
		edit3.setText("edit3");
		edit3.setVisible(false);

		edit2.setLocation(new Point(16, 163));
		edit2.setSize(new Point(24, 20));
		edit2.setTabIndex(28);
		edit2.setText("edit2");
		edit2.setVisible(false);

		edit1.setLocation(new Point(16, 143));
		edit1.setSize(new Point(16, 20));
		edit1.setTabIndex(26);
		edit1.setText("edit1");
		edit1.setVisible(false);

		label4.setBackColor(Color.YELLOW);
		label4.setForeColor(Color.BLACK);
		label4.setLocation(new Point(385, 110));
		label4.setSize(new Point(24, 16));
		label4.setTabIndex(14);
		label4.setTabStop(false);
		label4.setText("Auto");
		label4.setTextAlign(HorizontalAlignment.CENTER);

		label1.setBackColor(new Color(255, 255, 192));
		label1.setFont(new Font("Verdana", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label1.setForeColor(Color.AQUA);
		label1.setLocation(new Point(177, 192));
		label1.setSize(new Point(112, 16));
		label1.setTabIndex(30);
		label1.setTabStop(false);
		label1.setText(" Type de Paiement");
		label1.setBorderStyle(BorderStyle.FIXED_3D);

		panel2.setLocation(new Point(57, 223));
		panel2.setSize(new Point(376, 160));
		panel2.setTabIndex(31);
		panel2.setText("panel2");
		panel2.setBorderStyle(BorderStyle.FIXED_3D);

		groupBox1.setLocation(new Point(122, 92));
		groupBox1.setSize(new Point(312, 88));
		groupBox1.setTabIndex(32);
		groupBox1.setTabStop(false);
		groupBox1.setText("");

		pictureBox6.setLocation(new Point(56, 14));
		pictureBox6.setSize(new Point(88, 80));
		pictureBox6.setTabIndex(9);
		pictureBox6.setTabStop(false);
		pictureBox6.setText("pictureBox2");
		pictureBox6.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox6.setImage((Bitmap)resources.getObject("pictureBox6_image"));
		pictureBox6.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox1.setLocation(new Point(74, 2));
		pictureBox1.setSize(new Point(88, 80));
		pictureBox1.setTabIndex(27);
		pictureBox1.setTabStop(false);
		pictureBox1.setText("pictureBox1");
		pictureBox1.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox1.setImage((Bitmap)resources.getObject("pictureBox1_image"));
		pictureBox1.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		label2.setBackColor(new Color(255, 255, 192));
		label2.setFont(new Font("Verdana", 14.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label2.setForeColor(Color.AQUA);
		label2.setLocation(new Point(197, 6));
		label2.setSize(new Point(256, 23));
		label2.setTabIndex(35);
		label2.setTabStop(false);
		label2.setText("Paiement d\'un Titulaire");
		label2.setBorderStyle(BorderStyle.FIXED_3D);
		label2.setTextAlign(HorizontalAlignment.CENTER);

		pictureBox2.setLocation(new Point(164, 2));
		pictureBox2.setSize(new Point(320, 32));
		pictureBox2.setTabIndex(0);
		pictureBox2.setTabStop(false);
		pictureBox2.setText("pictureBox2");
		pictureBox2.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox2.setImage((Bitmap)resources.getObject("pictureBox2_image"));
		pictureBox2.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		groupBox2.setLocation(new Point(169, 181));
		groupBox2.setSize(new Point(264, 33));
		groupBox2.setTabIndex(36);
		groupBox2.setTabStop(false);
		groupBox2.setText("");

		pictureBox3.setLocation(new Point(67, 229));
		pictureBox3.setSize(new Point(16, 142));
		pictureBox3.setTabIndex(10);
		pictureBox3.setTabStop(false);
		pictureBox3.setText("pictureBox2");
		pictureBox3.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox3.setImage((Bitmap)resources.getObject("pictureBox3_image"));
		pictureBox3.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox4.setLocation(new Point(408, 230));
		pictureBox4.setSize(new Point(16, 142));
		pictureBox4.setTabIndex(11);
		pictureBox4.setTabStop(false);
		pictureBox4.setText("pictureBox2");
		pictureBox4.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox4.setImage((Bitmap)resources.getObject("pictureBox4_image"));
		pictureBox4.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		this.setNewControls(new Control[] {
							pictureBox3, 
							pictureBox4, 
							label2, 
							pictureBox1, 
							pictureBox6, 
							label1, 
							label4, 
							edit1, 
							edit2, 
							edit3, 
							radio2, 
							radio1, 
							banque, 
							an, 
							mois, 
							jour, 
							label3, 
							panel1, 
							labelNo_paie, 
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
							labelMontant, 
							editMontant, 
							panel2, 
							groupBox1, 
							pictureBox2, 
							groupBox2});
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
        Application.run( new Paiement_Titulaire() );
    }
}
