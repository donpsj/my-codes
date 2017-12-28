//Paiement_Credit.java

import com.ms.wfc.app.*;
import com.ms.wfc.core.*;
import com.ms.wfc.ui.*;
import com.ms.wfc.data.*;
import com.ms.wfc.data.ui.*;

public class Paiement_Credit extends Form
{  public String vdate = new String();

    public void btnAdd_Click(Object sender, Event evt)
    {
        try
        {    hide();
			 Application.run(new Paiement_Credit());
           /* dataSource1.getRecordset().cancelUpdate();
            dataSource1.getRecordset().addNew();
            m_bAddNew = true;
            btnAdd.setEnabled( false );
			edit1.setText("");
			edit2.setText("");
			edit3.setText("0");
			editRef_tit.setText("");
		    editNo_cheque.setText("0");
		    editMont_paye.setText("0.00");
			jour.setText("");
			mois.setText("");
			an.setText("");
			 btnUpdate.setEnabled( true );*/
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
		  double somchq,sold,rest;
		  int nchq;   
		  sold=0.00;
		
           String st1 = new String();
		   String st2 = new String();
		   String st3 = new String();
		
		
		  
		  DataSource rec = new DataSource();
		  rec.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		  rec.setCommandText("select * from Titulaire where Nif = '"+editRef_tit.getText()+"'");	
		  rec.begin();
		  
		  if(String.valueOf(rec.getRecordset().getRecordCount()).equals("1"))
		  
		  {      DataBinder display = new DataBinder();
				  display.setDataSource(rec);
				  display.setBindings(new DataBinding[]{
							    new DataBinding(edit1,"text","Nom"),
							    new DataBinding(edit2,"text","Prenom"),
							    new DataBinding(edit3,"text","Charge"),
								  });
				  
		  sold = (Double.valueOf(edit3.getText())).doubleValue();
	     }
		
		
		try
		  {  
			  nchq = (Integer.valueOf(editNo_cheque.getText()).intValue());
		      somchq = (Double.valueOf(editMont_paye.getText())).doubleValue();
			  rest=sold+somchq;  
			 
			if(editRef_tit.getText().equals(""))
			{MessageBox.show("Entrez le NIF du Titulaire en Question  S.V.P","Champ Vide",MessageBox.ICONERROR);
			}
			else
			if(jour.getText().equals("")||mois.getText().equals("")||an.getText().equals(""))
			{MessageBox.show("Entrez la Date sous la Forme :'JJ  MM  AA '  S.V.P","Champ Vide",MessageBox.ICONERROR);
			}
			else
			if(jour.getText().equals("31")&&(mois.getText().equals("02")||mois.getText().equals("04")||mois.getText().equals("06")||mois.getText().equals("09")||mois.getText().equals("11")))
					{ MessageBox.show("Ce Mois ne Porte pas 31 Jours","Champ Vide",MessageBox.ICONERROR);
					}
			else
				if(mois.getText().equals("02")&&jour.getText().equals("30"))
				 {  MessageBox.show("Le Mois de Février Porte  29 jours au Maximum","Champ Vide",MessageBox.ICONERROR);
				 }	
			else
			    if(editNom_prenom.getText().equals(""))
		     	{MessageBox.show(" Veuillez Entrer le Nom Complet du Receveur S.V.P","Champ Vide",MessageBox.ICONERROR);
			    }
			else
				if(editNif.getText().equals(""))
			    {MessageBox.show(" Veuillez Entrer le Nif du Receveur S.V.P","Champ Vide",MessageBox.ICONERROR);
			     }
			/*else
				if(editNo_cheque.getText().equals("0"))
			     {MessageBox.show(" Veuillez Entrer le Numéro du Chèque émis S.V.P","Champ Vide",MessageBox.ICONERROR);
			      }
			else
			   if(banque.getText().equals(""))
			  {MessageBox.show(" Veuillez Choisir la Banque Appropriée au Chèque émis S.V.P","Champ Vide",MessageBox.ICONERROR);
			  }*/
			 
			else
              if(editMont_paye.getText().equals("0.00"))
			  {MessageBox.show(" Veuillez Entrer le Montant du Chèque émis S.V.P","Champ Vide",MessageBox.ICONERROR);
			  }
			  else
				 if((somchq>1000)&& (banque.getText().equals("")||editNo_cheque.getText().equals("0")))
				 {MessageBox.show("Le Montant dépasse 1,000 Gourdes, Il Faut un Chèque. Veuillez Entrer son Numéro et la Banque d'Emission S.V.P","Champ Vide",MessageBox.ICONERROR);
				 }
		    else
			if(String.valueOf(rec.getRecordset().getRecordCount()).equals("0"))
			   {MessageBox.show("Désolé le Titulaire Identifié au NIF << "+editRef_tit.getText()+" >> n'Existe pas ", "Données Introuvables", MessageBox.ICONWARNING);
			   }
			else
			  if(sold>0)
			   {MessageBox.show("Désolé, le Titulaire << "+edit1.getText()+" "+edit2.getText()+" >> a une Charge de << "+sold+"  Gdes >>", "Opération  Illégale",MessageBox.ICONWARNING);
			   }
		  else
			 if(rest>0)
			  {   
				 MessageBox.show("Désolé, L'Hôpital ne Doit au Titulaire < "+edit1.getText()+" "+edit2.getText()+" > que << "+sold+"  Gdes >>", "Opération  Illégale",MessageBox.ICONWARNING);
		   	  }
									  
		  else
		{    
		   int resul=MessageBox.show(" Etes-Vous sur que ce Remboursement se Fait au Compte du Titulaire << "+edit1.getText()+"  "+edit2.getText()+" >> ? Sinon, Vérifiez le NIF de ce Dernier S.V.P ", "Moment Décisif ",MessageBox.YESNO);
			if(resul==MessageBox.IDYES)
			 {			  
			  vdate = jour.getSelectedItem()+ "/" + mois.getSelectedItem()+ "/" +"20"+""+an.getText();
		      editDate_Remb.setText(String.valueOf(vdate));
			 				  
			  this.setCursor( Cursor.WAIT );
               dataBinder1.commitChanges();
               dataSource1.getRecordset().update();
			      cit.setConnectionString("dsn=HAH;uid=genial;pwd=genial");
				  cit.open();
				  titul.setActiveConnection(cit);
				  titul.setSource("Update Titulaire set Charge ="+rest+" where  Nif ='"+editRef_tit.getText()+"'");
				  titul.open();
				  
				  if(rest<0)
			      {  rest=rest*-1;
					 MessageBox.show("Félicitations, l'Ancien Solde de <"+edit1.getText()+" "+edit2.getText()+"> était  de <<"+sold+" >>Gdes , Maintenant l'Hopital Devra lui Rembourser La Somme de <<"+rest+" Gdes>>","Confirmation",MessageBox.ICONINFORMATION);
				   }
				  else
					if(rest==0)  
				     { MessageBox.show("Felicitations! l'Hôpital ne Doit que  << "+rest+" Gde>>  à  <"+edit1.getText()+" "+edit2.getText()+">  ", " Confirmation",MessageBox.ICONINFORMATION);
				      
					}	
				  
				  btnAdd.setEnabled(true);
				  btnUpdate.setEnabled(false);
			
			if( m_bAddNew )
            {
                dataSource1.requery();
                
                dataSource1.getRecordset().moveLast();
            }
	    	}
		  } }
		
		catch(NumberFormatException e){
		MessageBox.show("Attention, Le Numéro du Chèque et le Montant Payé Doivent être des Nombres!", " Données Incompatibles",MessageBox.ICONERROR);
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
	
    public Paiement_Credit()
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
		editRef_tit.setText("");
		editNo_cheque.setText("0");
		editMont_paye.setText("0.00");
		edit1.setText("");
		edit2.setText("");
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
        MessageBox.show( e.toString(), "Paiement_Credit" );
    }

	/**
	 * NOTE: The following code is required by the Visual J++ form
	 * designer.  It can be modified using the form editor.  Do not
	 * modify it using the code editor.
	 */
	Container components = new Container();
	DataSource dataSource1 = new DataSource(components);
	DataBinder dataBinder1 = new DataBinder(components);
	Label labelNo_credit = new Label();
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
	ComboBox banque = new ComboBox();
	Label labelMont_paye = new Label();
	Edit editMont_paye = new Edit();
	Button btnAdd = new Button();
	Edit edit1 = new Edit();
	Button btnUpdate = new Button();
	Button btnClose = new Button();
	Panel panel1 = new Panel();
	Label label3 = new Label();
	ComboBox jour = new ComboBox();
	ComboBox mois = new ComboBox();
	Edit an = new Edit();
	Label label4 = new Label();
	Edit edit2 = new Edit();
	Edit edit3 = new Edit();
	GroupBox groupBox1 = new GroupBox();
	PictureBox pictureBox6 = new PictureBox();
	Label label1 = new Label();
	PictureBox pictureBox1 = new PictureBox();
	Panel panel2 = new Panel();
	PictureBox pictureBox2 = new PictureBox();
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

		IResourceManager resources = new ResourceManager(this, "Paiement_Credit");
		this.setLocation(new Point(7, 7));
		this.setText("Remboursement d\'un Patient Assuré");
		this.setAutoScaleBaseSize(new Point(5, 13));
		this.setAutoScroll(true);
		this.setBorderStyle(FormBorderStyle.NONE);
		this.setClientSize(new Point(600, 452));
		this.setMaximizeBox(false);
		this.setStartPosition(FormStartPosition.CENTER_SCREEN);

		dataSource1.setConnectionString("Provider=MSDASQL.1;Persist Security Info=False;Extended Properties=\"dsn=HAH;uid=genial;DBQ=C:\\ASSURE.MDB\";Initial Catalog=C:\\ASSURE");
		dataSource1.setCommandText("select No_credit, Ref_titul, Date_Remb, Nom_prenom, Nif, No_cheque, Banque, Mont_paye from Credit");
		dataSource1.setSort(null);
		dataSource1.setStayInSync(true);
		dataSource1.setUserId(null);
		dataSource1.setPassword(null);
		/* @designTimeOnly dataSource1.setLocation(new Point(472, 80)); */

		labelNo_credit.setBackColor(Color.CONTROL);
		labelNo_credit.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNo_credit.setLocation(new Point(138, 156));
		labelNo_credit.setSize(new Point(168, 20));
		labelNo_credit.setTabIndex(15);
		labelNo_credit.setTabStop(false);
		labelNo_credit.setText("No de Remboursement");
		labelNo_credit.setBorderStyle(BorderStyle.FIXED_3D);

		editNo_credit.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNo_credit.setEnabled(false);
		editNo_credit.setLocation(new Point(312, 156));
		editNo_credit.setSize(new Point(128, 20));
		editNo_credit.setTabIndex(16);
		editNo_credit.setText("");
		editNo_credit.setReadOnly(true);

		labelRef_tit.setBackColor(Color.CONTROL);
		labelRef_tit.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelRef_tit.setLocation(new Point(137, 182));
		labelRef_tit.setSize(new Point(168, 20));
		labelRef_tit.setTabIndex(17);
		labelRef_tit.setTabStop(false);
		labelRef_tit.setText("NIF du Titulaire");
		labelRef_tit.setBorderStyle(BorderStyle.FIXED_3D);

		editRef_tit.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRef_tit.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		editRef_tit.setForeColor(Color.AQUA);
		editRef_tit.setLocation(new Point(312, 181));
		editRef_tit.setSize(new Point(128, 20));
		editRef_tit.setTabIndex(1);
		editRef_tit.setText("");
		editRef_tit.setMaxLength(13);

		labelDate_Remb.setBackColor(Color.CONTROL);
		labelDate_Remb.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelDate_Remb.setLocation(new Point(136, 223));
		labelDate_Remb.setSize(new Point(168, 20));
		labelDate_Remb.setTabIndex(18);
		labelDate_Remb.setTabStop(false);
		labelDate_Remb.setText("Date de Remboursement");
		labelDate_Remb.setBorderStyle(BorderStyle.FIXED_3D);

		editDate_Remb.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editDate_Remb.setLocation(new Point(32, 228));
		editDate_Remb.setSize(new Point(32, 20));
		editDate_Remb.setTabIndex(19);
		editDate_Remb.setText("");
		editDate_Remb.setVisible(false);
		editDate_Remb.setMaxLength(10);
		editDate_Remb.setMultiline(true);

		labelNom_prenom.setBackColor(Color.CONTROL);
		labelNom_prenom.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNom_prenom.setLocation(new Point(136, 246));
		labelNom_prenom.setSize(new Point(168, 20));
		labelNom_prenom.setTabIndex(20);
		labelNom_prenom.setTabStop(false);
		labelNom_prenom.setText("Nom /  Prénom du Receveur");
		labelNom_prenom.setBorderStyle(BorderStyle.FIXED_3D);

		editNom_prenom.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNom_prenom.setLocation(new Point(312, 246));
		editNom_prenom.setSize(new Point(152, 20));
		editNom_prenom.setTabIndex(5);
		editNom_prenom.setText("");
		editNom_prenom.setMaxLength(50);

		labelNif.setBackColor(Color.CONTROL);
		labelNif.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNif.setLocation(new Point(136, 268));
		labelNif.setSize(new Point(168, 20));
		labelNif.setTabIndex(21);
		labelNif.setTabStop(false);
		labelNif.setText("Nif du Receveur");
		labelNif.setBorderStyle(BorderStyle.FIXED_3D);

		editNif.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNif.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		editNif.setLocation(new Point(312, 268));
		editNif.setSize(new Point(152, 20));
		editNif.setTabIndex(6);
		editNif.setText("");
		editNif.setMaxLength(13);

		labelNo_cheque.setBackColor(Color.CONTROL);
		labelNo_cheque.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNo_cheque.setLocation(new Point(136, 313));
		labelNo_cheque.setSize(new Point(168, 20));
		labelNo_cheque.setTabIndex(22);
		labelNo_cheque.setTabStop(false);
		labelNo_cheque.setText("No du chèque");
		labelNo_cheque.setBorderStyle(BorderStyle.FIXED_3D);

		editNo_cheque.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNo_cheque.setLocation(new Point(312, 312));
		editNo_cheque.setSize(new Point(152, 20));
		editNo_cheque.setTabIndex(8);
		editNo_cheque.setText("");

		labelBanque.setBackColor(Color.CONTROL);
		labelBanque.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelBanque.setLocation(new Point(136, 336));
		labelBanque.setSize(new Point(168, 20));
		labelBanque.setTabIndex(23);
		labelBanque.setTabStop(false);
		labelBanque.setText("Banque");
		labelBanque.setBorderStyle(BorderStyle.FIXED_3D);

		banque.setLocation(new Point(312, 336));
		banque.setSize(new Point(144, 21));
		banque.setTabIndex(9);
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

		labelMont_paye.setBackColor(Color.CONTROL);
		labelMont_paye.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelMont_paye.setLocation(new Point(136, 291));
		labelMont_paye.setSize(new Point(168, 20));
		labelMont_paye.setTabIndex(24);
		labelMont_paye.setTabStop(false);
		labelMont_paye.setText("Montant Payé");
		labelMont_paye.setBorderStyle(BorderStyle.FIXED_3D);

		editMont_paye.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editMont_paye.setLocation(new Point(312, 290));
		editMont_paye.setSize(new Point(152, 20));
		editMont_paye.setTabIndex(7);
		editMont_paye.setText("");

		dataBinder1.setDataSource(dataSource1);
		dataBinder1.setDataMember("");
		dataBinder1.setBindings(new DataBinding[] {
								new DataBinding(editNo_credit, "Text", "No_credit", null), 
								new DataBinding(editRef_tit, "Text", "Ref_titul", null), 
								new DataBinding(editDate_Remb, "Text", "Date_Remb", null), 
								new DataBinding(editNom_prenom, "Text", "Nom_prenom", null), 
								new DataBinding(editNif, "Text", "Nif", null), 
								new DataBinding(editNo_cheque, "Text", "No_cheque", null), 
								new DataBinding(editMont_paye, "Text", "Mont_paye", null), 
								new DataBinding(banque, "Text", "Banque", null)});
		/* @designTimeOnly dataBinder1.setLocation(new Point(472, 56)); */

		btnAdd.setLocation(new Point(40, 6));
		btnAdd.setSize(new Point(65, 25));
		btnAdd.setTabIndex(0);
		btnAdd.setText("&Nouveau");
		btnAdd.addOnClick(new EventHandler(this.btnAdd_Click));

		edit1.setLocation(new Point(26, 294));
		edit1.setSize(new Point(32, 20));
		edit1.setTabIndex(28);
		edit1.setText("edit1");
		edit1.setVisible(false);

		btnUpdate.setLocation(new Point(265, 6));
		btnUpdate.setSize(new Point(65, 25));
		btnUpdate.setTabIndex(1);
		btnUpdate.setText("&Enregistrer");
		btnUpdate.addOnClick(new EventHandler(this.btnUpdate_Click));

		btnClose.setLocation(new Point(464, 6));
		btnClose.setSize(new Point(65, 25));
		btnClose.setTabIndex(2);
		btnClose.setText("&Fermer");
		btnClose.addOnClick(new EventHandler(this.btnClose_Click));

		panel1.setBackColor(new Color(0, 192, 192));
		panel1.setDock(ControlDock.BOTTOM);
		panel1.setLocation(new Point(0, 412));
		panel1.setSize(new Point(600, 40));
		panel1.setTabIndex(25);
		panel1.setText("");
		panel1.setBorderStyle(BorderStyle.FIXED_3D);

		label3.setBackColor(Color.AQUA);
		label3.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, true, false, false, CharacterSet.DEFAULT, 0));
		label3.setForeColor(new Color(255, 255, 192));
		label3.setLocation(new Point(314, 206));
		label3.setSize(new Point(144, 16));
		label3.setTabIndex(13);
		label3.setTabStop(false);
		label3.setText(" JJ    /   MM    /  AA");
		label3.setBorderStyle(BorderStyle.FIXED_3D);

		jour.setLocation(new Point(313, 223));
		jour.setSize(new Point(48, 21));
		jour.setTabIndex(2);
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

		mois.setLocation(new Point(361, 223));
		mois.setSize(new Point(48, 21));
		mois.setTabIndex(3);
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

		an.setLocation(new Point(409, 223));
		an.setSize(new Point(48, 20));
		an.setTabIndex(4);
		an.setText("");
		an.setMaxLength(2);

		label4.setBackColor(Color.YELLOW);
		label4.setForeColor(Color.BLACK);
		label4.setLocation(new Point(443, 157));
		label4.setSize(new Point(24, 16));
		label4.setTabIndex(14);
		label4.setTabStop(false);
		label4.setText("Auto");
		label4.setTextAlign(HorizontalAlignment.CENTER);

		edit2.setLocation(new Point(18, 272));
		edit2.setSize(new Point(40, 20));
		edit2.setTabIndex(30);
		edit2.setText("edit2");
		edit2.setVisible(false);

		edit3.setLocation(new Point(26, 250));
		edit3.setSize(new Point(32, 20));
		edit3.setTabIndex(29);
		edit3.setText("edit3");
		edit3.setVisible(false);

		groupBox1.setLocation(new Point(118, 136));
		groupBox1.setSize(new Point(360, 232));
		groupBox1.setTabIndex(33);
		groupBox1.setTabStop(false);
		groupBox1.setText("");

		pictureBox6.setLocation(new Point(85, 49));
		pictureBox6.setSize(new Point(88, 80));
		pictureBox6.setTabIndex(10);
		pictureBox6.setTabStop(false);
		pictureBox6.setText("pictureBox2");
		pictureBox6.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox6.setImage((Bitmap)resources.getObject("pictureBox6_image"));
		pictureBox6.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		label1.setBackColor(new Color(255, 255, 192));
		label1.setFont(new Font("Verdana", 14.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label1.setForeColor(Color.AQUA);
		label1.setLocation(new Point(116, 5));
		label1.setSize(new Point(392, 24));
		label1.setTabIndex(26);
		label1.setTabStop(false);
		label1.setText("Remboursement  D\'un Patient  Assuré");
		label1.setBorderStyle(BorderStyle.FIXED_3D);
		label1.setTextAlign(HorizontalAlignment.CENTER);

		pictureBox1.setLocation(new Point(103, 37));
		pictureBox1.setSize(new Point(88, 80));
		pictureBox1.setTabIndex(27);
		pictureBox1.setTabStop(false);
		pictureBox1.setText("pictureBox1");
		pictureBox1.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox1.setImage((Bitmap)resources.getObject("pictureBox1_image"));
		pictureBox1.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		panel2.setLocation(new Point(85, 132));
		panel2.setSize(new Point(424, 248));
		panel2.setTabIndex(34);
		panel2.setText("panel2");
		panel2.setBorderStyle(BorderStyle.FIXED_3D);

		pictureBox2.setLocation(new Point(85, 2));
		pictureBox2.setSize(new Point(456, 32));
		pictureBox2.setTabIndex(0);
		pictureBox2.setTabStop(false);
		pictureBox2.setText("pictureBox2");
		pictureBox2.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox2.setImage((Bitmap)resources.getObject("pictureBox2_image"));
		pictureBox2.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox3.setLocation(new Point(95, 136));
		pictureBox3.setSize(new Point(16, 240));
		pictureBox3.setTabIndex(12);
		pictureBox3.setTabStop(false);
		pictureBox3.setText("pictureBox2");
		pictureBox3.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox3.setImage((Bitmap)resources.getObject("pictureBox3_image"));
		pictureBox3.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox4.setLocation(new Point(484, 136));
		pictureBox4.setSize(new Point(16, 240));
		pictureBox4.setTabIndex(11);
		pictureBox4.setTabStop(false);
		pictureBox4.setText("pictureBox2");
		pictureBox4.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox4.setImage((Bitmap)resources.getObject("pictureBox4_image"));
		pictureBox4.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		this.setNewControls(new Control[] {
							pictureBox4, 
							pictureBox3, 
							pictureBox1, 
							pictureBox6, 
							label1, 
							label3, 
							edit3, 
							edit2, 
							edit1, 
							banque, 
							label4, 
							an, 
							mois, 
							jour, 
							panel1, 
							labelNo_credit, 
							editNo_credit, 
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
							labelMont_paye, 
							editMont_paye, 
							groupBox1, 
							panel2, 
							pictureBox2});
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
        Application.run( new Paiement_Credit() );
    }
}
