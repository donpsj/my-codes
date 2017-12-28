//Paiement.java

import com.ms.wfc.app.*;
import com.ms.wfc.core.*;
import com.ms.wfc.ui.*;
import com.ms.wfc.data.*;
import com.ms.wfc.data.ui.*;

public class Paiement extends Form
{  
      public String vdate = new String();
	  double dif=0; 
	  double nchargetit=0;
	  double retour=0;
	  double credisom=0;
	  
	  DataSource tit = new DataSource();
	  Connection fa = new Connection();
		         Recordset ta = new Recordset();
			    
			     Connection cop = new Connection();
				 Recordset top = new Recordset();
								
				Connection cit = new Connection();
				Recordset titul = new Recordset();
				
				Connection cit1 = new Connection();
				Recordset titul1 = new Recordset();

    public void btnAdd_Click(Object sender, Event evt)
    {    
        try
        {   hide();
		    Application.run(new Paiement());
           /* dataSource1.getRecordset().cancelUpdate();
            dataSource1.getRecordset().addNew();
            m_bAddNew = true;
            btnAdd.setEnabled( false );
			btnUpdate.setEnabled( true );
			editRef_comp.setText("");
			editSom_recue.setText("0.00");
			editRef_titul.setText("");
			editRef_fact.setText("0");
			editNo_cheque.setText("0");
			jour.setText(""); 
		    mois.setText("");
			an.setText("");
			edit1.setText("0.00");
			edit2.setText("0.00");
			edit3.setText("0.00");
			edit4.setText("0");*/
			 
             
        }
        catch (Exception e)
        {
            handleADOException(e);
        }
    }

     
    public void btnUpdate_Click(Object sender, Event evt)
    {		
		
		try
		{
		     int nc = (Integer.valueOf(editNo_cheque.getText()).intValue());
		     int nf = (Integer.valueOf(editRef_fact.getText()).intValue());
			 double som = (Double.valueOf(editSom_recue.getText())).doubleValue();
		     
		     DataSource com = new DataSource();
		     com.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		     DataSource fac = new DataSource();
		     DataSource ad = new DataSource();
			 DataSource pf = new DataSource();
		
		    fac.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		    fac.setCommandText("select * from Facture where No_facture = "+nf+"");			   			
            fac.begin();
			
			if(String.valueOf(fac.getRecordset().getRecordCount()).equals("1"))
			   { DataBinder db1 = new DataBinder();
			    db1.setDataSource(fac);
			    db1.setBindings(new DataBinding[]{
							    new DataBinding(edit1,"text","Charge_tot"),
							    new DataBinding(edit4,"text","Ref_admi"),
							    new DataBinding(edit5,"text","Paye"),
							    new DataBinding(editRef_comp,"text","Ref_comp"),
						   });
					
			 
			DataSource dt = new DataSource();
			DataBinder dispt = new DataBinder();
			DataBinder dispad = new DataBinder();
			
			ad.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		    ad.setCommandText("select * from Admission where No_admi = "+edit4.getText()+"");			   			
            ad.begin();
				  dispad.setDataSource(ad);
				  dispad.setBindings(new DataBinding[]{
												     							
							    new DataBinding(rt,"text","Ref_titul"),
								new DataBinding(credit,"text","Credit_patient"),
									            
										  
									  	  });
               
			  								  
			dt.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		    dt.setCommandText("select * from Titulaire where Nif = '"+rt.getText()+"'");			   			
            dt.begin();
				  dispt.setDataSource(dt);
				  dispt.setBindings(new DataBinding[]{
												     							
							    new DataBinding(nt,"text","Nom"),
								new DataBinding(pt,"text","Prenom"),
																	  
					  	  });
							
		
	   }	
					
			 int nad = (Integer.valueOf(edit4.getText()).intValue());
			 double balfacture=Double.valueOf(edit1.getText()).doubleValue();						
			 double cred = Double.valueOf(credit.getText()).doubleValue();						
			  
			if(jour.getText().equals("")||mois.getText().equals("")||an.getText().equals(""))
			{MessageBox.show("Entrez la Date sous la Forme :'JJ  MM  AA '  S.V.P","Champ Vide",MessageBox.ICONERROR);
			}
			else
			if(jour.getText().equals("31")&&(mois.getText().equals("02")||mois.getText().equals("04")||mois.getText().equals("06")||mois.getText().equals("09")||mois.getText().equals("11")))
					{ MessageBox.show("Ce Mois ne Porte pas 31 jours","Données Incompatibles",MessageBox.ICONERROR);
					}
			else
				if(mois.getText().equals("02")&&jour.getText().equals("30"))
				 {  MessageBox.show("Le Mois de Février Porte  29 jours au Maximum","Données Incompatibles",MessageBox.ICONERROR);
				 }	
			 else
               if(editRef_fact.getText().equals("0"))
			    {MessageBox.show("Veuillez Entrer le Numéro de la Facture à Payer S.V.P","Champ Vide",MessageBox.ICONERROR);
				 }
			 else
				 if(editNo_cheque.getText().equals("0"))
			    {MessageBox.show("Veuillez Entrer le Numéro du Chèque Reçu S.V.P","Champ Vide",MessageBox.ICONERROR);
				 }
			   else
				  if(banque.getText().equals(""))
			    {MessageBox.show("Veuillez Choisir la Banque Appropriée au Chèque S.V.P","Champ Vide",MessageBox.ICONERROR);
				 }
			  else
				  if(editSom_recue.getText().equals("0.00")||editSom_recue.getText().equals("0.0")||editSom_recue.getText().equals("0"))
			    {MessageBox.show("Veuillez Entrer la Somme du Chèque Reçu S.V.P","Champ Vide",MessageBox.ICONERROR);
				 }
			  else
				if(String.valueOf(fac.getRecordset().getRecordCount()).equals("0"))
			          {MessageBox.show("Désolé,la Facture No < "+editRef_fact.getText()+" > n'existe pas !", " Données Introuvables",MessageBox.ICONWARNING);
				  fac.close();      
				 }
			 else
				if(edit5.getText().equals("Oui"))
				{MessageBox.show("Désolé,la Facture No < "+editRef_fact.getText()+" >est déjà Payée !", "Opération Illégale ",MessageBox.ICONSTOP);
				} 
			  else
				if(som>balfacture)
				{MessageBox.show("La Somme Reçue ne Peut être Supérieure au Montant de cette Facture qui est :<< "+balfacture+" Gdes >>","Données Incompatibles",MessageBox.ICONERROR);
				   }
		         
			 else
			 { 
			     pf.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		         pf.setCommandText("select * from Reception where Ref_ad = "+edit4.getText()+"");			   			
                 pf.begin();
			   int resul=MessageBox.show(" Etes-Vous Sur que ce Chèque de << "+editRef_comp.getText()+" >> Est pour le Compte du Titulaire << "+nt.getText()+"  "+pt.getText()+" >> Identifié au No << '"+rt.getText()+"'>> ? Sinon, Vérifiez le No de la Facture S.V.P ", "Moment Décisif ",MessageBox.YESNO);
			   if(resul==MessageBox.IDYES)
				{	
			  	  
				ad.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		        ad.setCommandText("select * from Admission where No_admi = "+nad+"");			   			
                ad.begin();
				
				DataBinder dtit = new DataBinder();
				dtit.setDataSource(ad);
				dtit.setBindings(new DataBinding[]{
							     
							     new DataBinding(editRef_titul,"text","Ref_titul"),
								 new DataBinding(balad,"text","Balance"),
							   				   					   });
				    double blad=Double.valueOf(balad.getText()).doubleValue();						
	           
				
				tit.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		        tit.setCommandText("select * from Titulaire where Nif = '"+editRef_titul.getText()+"'");			   			
                tit.begin();
				
				DataBinder dbn = new DataBinder();
				dbn.setDataSource(tit);
				dbn.setBindings(new DataBinding[]{
							     new DataBinding(edit6,"text","Nom"),
								  new DataBinding(edit7,"text","Prenom"),
							   					   });
														        
		        com.setCommandText("select * from Compagnie where Nom = '"+editRef_comp.getText()+"'");			   			
                com.begin();
											
				DataBinder db2 = new DataBinder();
				db2.setDataSource(com);
				db2.setBindings(new DataBinding[]{
							   new DataBinding(edit2,"text","Charge_totale"),
							   
							   });

				double anbalcomp=Double.valueOf(edit2.getText()).doubleValue();				
				DataBinder db3 = new DataBinder();
				db3.setDataSource(tit);
				db3.setBindings(new DataBinding[]{
							   new DataBinding(edit3,"text","Charge"),
							   
							   });
				
				
				double anchargetit=Double.valueOf(edit3.getText()).doubleValue();
				double nbalcomp = anbalcomp - balfacture;
				String etat="Oui";
			 
							
				vdate = jour.getSelectedItem()+ "/" + mois.getSelectedItem()+ "/" +"20"+""+an.getText();
		        editDate.setText(String.valueOf(vdate));
			   	 			 
			 	this.setCursor( Cursor.WAIT );
                dataBinder1.commitChanges();
                dataSource1.getRecordset().update();
				
				fa.setConnectionString("dsn=HAH;uid=genial;pwd=genial");
				fa.open();
				ta.setActiveConnection(fa);
				ta.setSource("Update Facture set Paye ='"+etat+"' where No_facture ="+editRef_fact.getText()+"");
				ta.open();
								
				cop.setConnectionString("dsn=HAH;uid=genial;pwd=genial");
				cop.open();
				top.setActiveConnection(cop);
				top.setSource("Update Compagnie set Charge_totale ="+nbalcomp+" where Nom = '"+editRef_comp.getText()+"'");
				top.open();
				
				if(som < balfacture){
				  	  dif = balfacture - som;
					  credisom=som+cred;
					  if(cred>0)
					   {dif=balfacture-credisom;
						 }
					 				 
					if(String.valueOf(pf.getRecordset().getRecordCount()).equals("1")&& blad>=0 )
					{ dif= som*0.20 - som;
					 }
				    nchargetit = anchargetit + dif;
								   
				  cit.setConnectionString("dsn=HAH;uid=genial;pwd=genial");
				  cit.open();
				  titul.setActiveConnection(cit);
				  titul.setSource("Update Titulaire set Charge ="+nchargetit+" where Nif = '"+editRef_titul.getText()+"'");
				  titul.open();
				  
				  cit1.setConnectionString("dsn=HAH;uid=genial;pwd=genial");
				  cit1.open();
				  titul1.setActiveConnection(cit1);
				  titul1.setSource("Update Admission set Balance ="+dif+" where No_admi = "+nad+"");
				  titul1.open();
				  }
			  else
			   	if(balfacture == som){
			       { dif =-cred;
				    if(String.valueOf(pf.getRecordset().getRecordCount()).equals("1")&& blad>=0 )
				    { dif= som*0.20-som;
				     }
				   nchargetit = anchargetit+dif;
				   cit.setConnectionString("dsn=HAH;uid=genial;pwd=genial");
				  cit.open();
				  titul.setActiveConnection(cit);
				  titul.setSource("Update Titulaire set Charge ="+nchargetit+" where Nif = '"+editRef_titul.getText()+"'");
				  titul.open();
				  
				  cit1.setConnectionString("dsn=HAH;uid=genial;pwd=genial");
				  cit1.open();
				  titul1.setActiveConnection(cit1);
				  titul1.setSource("Update Admission set Balance ="+dif+" where No_admi = "+nad+"");
				  titul1.open();
				  }
								  
				  
			}
							 
			   		 
			 		 
			  if( m_bAddNew )
               {
                dataSource1.requery();
                dataSource1.getRecordset().moveLast();
                 }
			 			  
			   if(nchargetit<0 && ((String.valueOf(pf.getRecordset().getRecordCount()).equals("1"))) )
			   { MessageBox.show("Felicitations! Le Paiement de la Compagnie << "+editRef_comp.getText()+" >>  Pour le Titulaire << "+edit6.getText()+"  "+edit7.getText()+">> est Effectué, Mais l'Hopital devra lui Rembourser << "+-1*nchargetit+" Gdes>>.  Car sa Balance Précedente était de  <<"+edit3.getText()+" Gdes >>  et les 20% de frais sont :"+0.20*som +" Gdes ! ", " Confirmation",MessageBox.ICONINFORMATION);			  
			   }
			   else
				   if(nchargetit<0 && ((String.valueOf(pf.getRecordset().getRecordCount()).equals("0"))) )
			   { MessageBox.show("Felicitations! Le Paiement de la Compagnie << "+editRef_comp.getText()+" >>  Pour le Titulaire << "+edit6.getText()+"  "+edit7.getText()+">> est Effectué, Mais l'Hopital devra lui Rembourser << "+-1*nchargetit+" Gdes>>.  Car sa Balance Précedente était de  <<"+edit3.getText()+" Gdes >> ", " Confirmation",MessageBox.ICONINFORMATION);			  
			   }
			  else
			  if(dif==0)
			  {MessageBox.show("Felicitations! Le Paiement de la Compagnie << "+editRef_comp.getText()+" >>  Pour le Titulaire << "+edit6.getText()+"  "+edit7.getText()+">> est Effectué ! ", " Confirmation",MessageBox.ICONINFORMATION);			  
			  }
			  else
			   if(dif>0 )
			   { MessageBox.show("Felicitations! Le Paiement de la Compagnie << "+editRef_comp.getText()+" >>  Pour le Titulaire << "+edit6.getText()+"  "+edit7.getText()+">> est Effectué, Mais avec une Balance de << "+dif+" Gdes>> ! ", " Confirmation",MessageBox.ICONINFORMATION);			  
			   }
			  
			  btnUpdate.setEnabled(false);
			  btnAdd.setEnabled( true );
		  }
			 }
		}
	
		 catch (NumberFormatException e){
		 MessageBox.show("Attention,les Champs << Numéro de Facture >>   << No du Chèque >> et << Somme Reçue >> Doivent être des Nombres!", " Données Incompatibles",MessageBox.ICONERROR);	
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
	
    public Paiement()
    {
        // Required for Visual J++ Form Designer support
        initForm();
        
        this.show();
        this.update();
		    dataSource1.getRecordset().cancelUpdate();
            dataSource1.getRecordset().addNew();
		     m_bAddNew = true;
			btnAdd.setEnabled( false );
			editRef_comp.setText("");
			editSom_recue.setText("0.00");
			editRef_titul.setText("");
			editRef_fact.setText("0");
			editNo_cheque.setText("0");
			jour.setText(""); 
		    mois.setText("");
			an.setText("");
			edit1.setText("0.00");
			edit2.setText("0.00");
			edit3.setText("0.00");
			edit4.setText("0");
			credit.setText("0.00");
			
			
        //TODO: Add any constructor code after initForm call
        }    

    public void formClose(Event e)
    {
        Application.exit();
    }    

    
    void handleADOException(Exception e)
    {
        e.printStackTrace();
        MessageBox.show( e.toString(), "Paiement" );
    }

	/**
	 * NOTE: The following code is required by the Visual J++ form
	 * designer.  It can be modified using the form editor.  Do not
	 * modify it using the code editor.
	 */
	Container components = new Container();
	Label labelNo_recu = new Label();
	Edit editNo_recu = new Edit();
	Label labelDate = new Label();
	Edit editDate = new Edit();
	GroupBox groupBox1 = new GroupBox();
	Edit editRef_comp = new Edit();
	Edit editRef_titul = new Edit();
	Label labelRef_fact = new Label();
	Edit editRef_fact = new Edit();
	Label labelNo_cheque = new Label();
	Edit editNo_cheque = new Edit();
	ComboBox mois = new ComboBox();
	Label labelBanque = new Label();
	Label labelSom_recue = new Label();
	Edit an = new Edit();
	ComboBox jour = new ComboBox();
	Edit editSom_recue = new Edit();
	Panel panel1 = new Panel();
	Button btnAdd = new Button();
	Button btnUpdate = new Button();
	Button btnClose = new Button();
	Edit edit1 = new Edit();
	ComboBox banque = new ComboBox();
	DataSource dataSource1 = new DataSource(components);
	DataBinder dataBinder1 = new DataBinder(components);
	Edit edit3 = new Edit();
	Edit edit2 = new Edit();
	Edit edit4 = new Edit();
	Edit edit5 = new Edit();
	GroupBox groupBox2 = new GroupBox();
	Panel panel2 = new Panel();
	PictureBox pictureBox6 = new PictureBox();
	Label label1 = new Label();
	PictureBox pictureBox4 = new PictureBox();
	PictureBox pictureBox3 = new PictureBox();
	Panel panel5 = new Panel();
	Edit edit6 = new Edit();
	Edit edit7 = new Edit();
	Label label2 = new Label();
	Label label4 = new Label();
	PictureBox pictureBox1 = new PictureBox();
	PictureBox pictureBox2 = new PictureBox();
	Edit rt = new Edit();
	Edit nt = new Edit();
	Edit pt = new Edit();
	Edit balad = new Edit();
	Edit credit = new Edit();

	private void initForm()
	{
		// REMARQUE : cette feuille stocke des informations sur les ressources
		// dans un fichier externe. Ne modifiez le paramètre de chaîne d'aucun
		// appel de fonction resources.getObject(). Par exemple,
		// ne modifiez pas "foo1_location" dans la ligne de code
		// suivante, même si le nom de l'objet Foo change : 
		//	 foo1.setLocation((Point)resources.getObject("foo1_location"));

		IResourceManager resources = new ResourceManager(this, "Paiement");
		this.setText("Reception de Chèque  d\'une Compagnie d\'Assurance");
		this.setAutoScaleBaseSize(new Point(5, 13));
		this.setBorderStyle(FormBorderStyle.NONE);
		this.setClientSize(new Point(473, 436));
		this.setMaximizeBox(false);
		this.setStartPosition(FormStartPosition.CENTER_SCREEN);

		labelNo_recu.setBackColor(Color.CONTROL);
		labelNo_recu.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNo_recu.setLocation(new Point(36, 153));
		labelNo_recu.setSize(new Point(100, 20));
		labelNo_recu.setTabIndex(12);
		labelNo_recu.setTabStop(false);
		labelNo_recu.setText("No_Paiement");
		labelNo_recu.setBorderStyle(BorderStyle.FIXED_3D);

		editNo_recu.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNo_recu.setEnabled(false);
		editNo_recu.setFont(new Font("MS Sans Serif", 10.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		editNo_recu.setLocation(new Point(140, 154));
		editNo_recu.setSize(new Point(96, 23));
		editNo_recu.setTabIndex(13);
		editNo_recu.setText("");
		editNo_recu.setMaxLength(20);
		editNo_recu.setReadOnly(true);

		labelDate.setBackColor(Color.CONTROL);
		labelDate.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelDate.setLocation(new Point(36, 205));
		labelDate.setSize(new Point(100, 20));
		labelDate.setTabIndex(14);
		labelDate.setTabStop(false);
		labelDate.setText("Date Paiement");
		labelDate.setBorderStyle(BorderStyle.FIXED_3D);

		editDate.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editDate.setLocation(new Point(80, 244));
		editDate.setSize(new Point(48, 16));
		editDate.setTabIndex(15);
		editDate.setText("");
		editDate.setVisible(false);
		editDate.setMaxLength(10);
		editDate.setMultiline(true);

		groupBox1.setBackColor(Color.SCROLLBAR);
		groupBox1.setLocation(new Point(24, 136));
		groupBox1.setSize(new Point(272, 96));
		groupBox1.setTabIndex(29);
		groupBox1.setTabStop(false);
		groupBox1.setText("");

		editRef_comp.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRef_comp.setLocation(new Point(400, 140));
		editRef_comp.setSize(new Point(56, 20));
		editRef_comp.setTabIndex(16);
		editRef_comp.setText("");
		editRef_comp.setVisible(false);
		editRef_comp.setCharacterCasing(CharacterCasing.UPPER);
		editRef_comp.setMaxLength(50);
		editRef_comp.setMultiline(true);

		editRef_titul.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRef_titul.setLocation(new Point(344, 196));
		editRef_titul.setSize(new Point(88, 20));
		editRef_titul.setTabIndex(17);
		editRef_titul.setText("");
		editRef_titul.setVisible(false);
		editRef_titul.setMaxLength(13);
		editRef_titul.setMultiline(true);

		labelRef_fact.setBackColor(Color.CONTROL);
		labelRef_fact.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelRef_fact.setLocation(new Point(160, 249));
		labelRef_fact.setSize(new Point(144, 20));
		labelRef_fact.setTabIndex(18);
		labelRef_fact.setTabStop(false);
		labelRef_fact.setText("No de la Facture Payée");
		labelRef_fact.setBorderStyle(BorderStyle.FIXED_3D);

		editRef_fact.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRef_fact.setLocation(new Point(307, 249));
		editRef_fact.setSize(new Point(128, 20));
		editRef_fact.setTabIndex(4);
		editRef_fact.setText("");

		labelNo_cheque.setBackColor(Color.CONTROL);
		labelNo_cheque.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNo_cheque.setLocation(new Point(160, 273));
		labelNo_cheque.setSize(new Point(144, 20));
		labelNo_cheque.setTabIndex(19);
		labelNo_cheque.setTabStop(false);
		labelNo_cheque.setText("No du Chèque Reçu");
		labelNo_cheque.setBorderStyle(BorderStyle.FIXED_3D);

		editNo_cheque.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNo_cheque.setLocation(new Point(307, 272));
		editNo_cheque.setSize(new Point(128, 20));
		editNo_cheque.setTabIndex(5);
		editNo_cheque.setText("");
		editNo_cheque.setMaxLength(30);

		mois.setLocation(new Point(188, 204));
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

		labelBanque.setBackColor(Color.CONTROL);
		labelBanque.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelBanque.setLocation(new Point(160, 297));
		labelBanque.setSize(new Point(144, 20));
		labelBanque.setTabIndex(20);
		labelBanque.setTabStop(false);
		labelBanque.setText("Banque");
		labelBanque.setBorderStyle(BorderStyle.FIXED_3D);

		labelSom_recue.setBackColor(Color.CONTROL);
		labelSom_recue.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelSom_recue.setLocation(new Point(160, 321));
		labelSom_recue.setSize(new Point(144, 20));
		labelSom_recue.setTabIndex(21);
		labelSom_recue.setTabStop(false);
		labelSom_recue.setText("Somme_recue");
		labelSom_recue.setBorderStyle(BorderStyle.FIXED_3D);

		an.setLocation(new Point(236, 204));
		an.setSize(new Point(48, 20));
		an.setTabIndex(3);
		an.setText("");
		an.setMaxLength(2);

		jour.setLocation(new Point(140, 204));
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

		editSom_recue.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editSom_recue.setLocation(new Point(307, 321));
		editSom_recue.setSize(new Point(128, 20));
		editSom_recue.setTabIndex(7);
		editSom_recue.setText("");

		panel1.setBackColor(new Color(0, 192, 192));
		panel1.setDock(ControlDock.BOTTOM);
		panel1.setLocation(new Point(0, 396));
		panel1.setSize(new Point(473, 40));
		panel1.setTabIndex(22);
		panel1.setText("");
		panel1.setBorderStyle(BorderStyle.FIXED_3D);

		btnAdd.setLocation(new Point(31, 5));
		btnAdd.setSize(new Point(65, 25));
		btnAdd.setTabIndex(0);
		btnAdd.setText("&Nouveau");
		btnAdd.addOnClick(new EventHandler(this.btnAdd_Click));

		btnUpdate.setLocation(new Point(195, 5));
		btnUpdate.setSize(new Point(65, 25));
		btnUpdate.setTabIndex(1);
		btnUpdate.setText("&Enregistrer");
		btnUpdate.addOnClick(new EventHandler(this.btnUpdate_Click));

		btnClose.setLocation(new Point(360, 6));
		btnClose.setSize(new Point(65, 25));
		btnClose.setTabIndex(2);
		btnClose.setText("&Fermer");
		btnClose.addOnClick(new EventHandler(this.btnClose_Click));

		edit1.setLocation(new Point(24, 264));
		edit1.setSize(new Point(32, 20));
		edit1.setTabIndex(23);
		edit1.setText("");
		edit1.setVisible(false);

		banque.setLocation(new Point(307, 297));
		banque.setSize(new Point(128, 21));
		banque.setTabIndex(6);
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

		dataSource1.setConnectionString("Provider=MSDASQL.1;Persist Security Info=False;Extended Properties=\"dsn=HAH;uid=genial;DBQ=C:\\ASSURE.MDB\";Initial Catalog=C:\\ASSURE");
		dataSource1.setCommandText("select No_recu, Date, Ref_comp, Ref_titul, Ref_fact, Ref_ad,No_cheque, Banque, Som_recue from Reception");
		dataSource1.setSort(null);
		dataSource1.setStayInSync(true);
		dataSource1.setUserId(null);
		dataSource1.setPassword(null);
		/* @designTimeOnly dataSource1.setLocation(new Point(216, 72)); */

		edit3.setLocation(new Point(64, 264));
		edit3.setSize(new Point(32, 20));
		edit3.setTabIndex(26);
		edit3.setText("");
		edit3.setVisible(false);

		edit2.setLocation(new Point(344, 140));
		edit2.setSize(new Point(50, 20));
		edit2.setTabIndex(24);
		edit2.setText("");
		edit2.setVisible(false);

		edit4.setLocation(new Point(24, 240));
		edit4.setSize(new Point(48, 20));
		edit4.setTabIndex(25);
		edit4.setText("");
		edit4.setVisible(false);

		dataBinder1.setDataSource(dataSource1);
		dataBinder1.setDataMember("");
		dataBinder1.setBindings(new DataBinding[] {
								new DataBinding(editNo_recu, "Text", "No_recu", null), 
								new DataBinding(editDate, "Text", "Date", null), 
								new DataBinding(editRef_comp, "Text", "Ref_comp", null), 
								new DataBinding(editRef_titul, "Text", "Ref_titul", null), 
								new DataBinding(editRef_fact, "Text", "Ref_fact", null), 
								new DataBinding(editNo_cheque, "Text", "No_cheque", null), 
								new DataBinding(editSom_recue, "Text", "Som_recue", null), 
								new DataBinding(banque, "Text", "Banque", null), 
								new DataBinding(edit4, "Text", "Ref_ad", null)});
		/* @designTimeOnly dataBinder1.setLocation(new Point(312, 72)); */

		edit5.setLocation(new Point(344, 168));
		edit5.setSize(new Point(48, 20));
		edit5.setTabIndex(28);
		edit5.setText("");
		edit5.setVisible(false);

		groupBox2.setLocation(new Point(152, 232));
		groupBox2.setSize(new Point(288, 112));
		groupBox2.setTabIndex(30);
		groupBox2.setTabStop(false);
		groupBox2.setText("");

		panel2.setLocation(new Point(10, 133));
		panel2.setSize(new Point(448, 232));
		panel2.setTabIndex(31);
		panel2.setText("panel2");
		panel2.setBorderStyle(BorderStyle.FIXED_3D);

		pictureBox6.setLocation(new Point(10, 49));
		pictureBox6.setSize(new Point(88, 80));
		pictureBox6.setTabIndex(8);
		pictureBox6.setTabStop(false);
		pictureBox6.setText("pictureBox2");
		pictureBox6.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox6.setImage((Bitmap)resources.getObject("pictureBox6_image"));
		pictureBox6.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		label1.setBackColor(new Color(255, 255, 192));
		label1.setFont(new Font("Verdana", 10.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label1.setForeColor(Color.AQUA);
		label1.setLocation(new Point(41, 5));
		label1.setSize(new Point(384, 24));
		label1.setTabIndex(32);
		label1.setTabStop(false);
		label1.setText("Reception de Chèque d\'une Compagnie d\'Assurance");
		label1.setBorderStyle(BorderStyle.FIXED_3D);
		label1.setTextAlign(HorizontalAlignment.CENTER);

		pictureBox4.setLocation(new Point(135, 238));
		pictureBox4.setSize(new Point(16, 106));
		pictureBox4.setTabIndex(9);
		pictureBox4.setTabStop(false);
		pictureBox4.setText("pictureBox2");
		pictureBox4.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox4.setImage((Bitmap)resources.getObject("pictureBox4_image"));
		pictureBox4.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox3.setLocation(new Point(300, 141));
		pictureBox3.setSize(new Point(16, 91));
		pictureBox3.setTabIndex(10);
		pictureBox3.setTabStop(false);
		pictureBox3.setText("pictureBox2");
		pictureBox3.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox3.setImage((Bitmap)resources.getObject("pictureBox3_image"));
		pictureBox3.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		panel5.setLocation(new Point(144, 236));
		panel5.setSize(new Point(168, 0));
		panel5.setTabIndex(35);
		panel5.setText("panel5");

		edit6.setLocation(new Point(8, 152));
		edit6.setSize(new Point(40, 20));
		edit6.setTabIndex(0);
		edit6.setText("");
		edit6.setVisible(false);

		edit7.setLocation(new Point(56, 152));
		edit7.setSize(new Point(40, 20));
		edit7.setTabIndex(1);
		edit7.setText("");
		edit7.setVisible(false);

		label2.setLocation(new Point(114, 52));
		label2.setSize(new Point(144, 16));
		label2.setTabIndex(0);
		label2.setTabStop(false);
		label2.setText(" JOUR        MOIS       ANNEE");
		label2.setBorderStyle(BorderStyle.FIXED_SINGLE);

		label4.setBackColor(Color.YELLOW);
		label4.setForeColor(Color.BLACK);
		label4.setLocation(new Point(238, 155));
		label4.setSize(new Point(24, 16));
		label4.setTabIndex(11);
		label4.setTabStop(false);
		label4.setText("Auto");
		label4.setTextAlign(HorizontalAlignment.CENTER);

		pictureBox1.setLocation(new Point(28, 37));
		pictureBox1.setSize(new Point(88, 80));
		pictureBox1.setTabIndex(27);
		pictureBox1.setTabStop(false);
		pictureBox1.setText("pictureBox1");
		pictureBox1.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox1.setImage((Bitmap)resources.getObject("pictureBox1_image"));
		pictureBox1.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox2.setLocation(new Point(10, 2));
		pictureBox2.setSize(new Point(448, 32));
		pictureBox2.setTabIndex(0);
		pictureBox2.setTabStop(false);
		pictureBox2.setText("pictureBox2");
		pictureBox2.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox2.setImage((Bitmap)resources.getObject("pictureBox2_image"));
		pictureBox2.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		rt.setLocation(new Point(8, 184));
		rt.setSize(new Point(40, 20));
		rt.setTabIndex(2);
		rt.setText("");
		rt.setVisible(false);

		nt.setLocation(new Point(56, 184));
		nt.setSize(new Point(40, 20));
		nt.setTabIndex(3);
		nt.setText("");
		nt.setVisible(false);

		pt.setLocation(new Point(8, 208));
		pt.setSize(new Point(32, 20));
		pt.setTabIndex(4);
		pt.setText("");
		pt.setVisible(false);

		balad.setLocation(new Point(72, 208));
		balad.setSize(new Point(16, 20));
		balad.setTabIndex(5);
		balad.setText("edit8");
		balad.setVisible(false);

		credit.setLocation(new Point(392, 32));
		credit.setSize(new Point(32, 20));
		credit.setTabIndex(6);
		credit.setText("");
		credit.setVisible(false);

		this.setNewControls(new Control[] {
							pictureBox4, 
							pictureBox3, 
							pictureBox1, 
							pictureBox6, 
							label4, 
							panel5, 
							label1, 
							edit5, 
							edit4, 
							edit2, 
							edit3, 
							banque, 
							edit1, 
							panel1, 
							editSom_recue, 
							jour, 
							an, 
							labelSom_recue, 
							labelBanque, 
							mois, 
							editNo_cheque, 
							labelNo_cheque, 
							editRef_fact, 
							labelRef_fact, 
							editRef_titul, 
							editRef_comp, 
							editDate, 
							labelDate, 
							editNo_recu, 
							labelNo_recu, 
							groupBox1, 
							groupBox2, 
							panel2, 
							pictureBox2});
		groupBox1.setNewControls(new Control[] {
								 label2});
		panel1.setNewControls(new Control[] {
							  btnClose, 
							  btnUpdate, 
							  btnAdd});
		panel2.setNewControls(new Control[] {
							  credit, 
							  balad, 
							  pt, 
							  nt, 
							  rt, 
							  edit7, 
							  edit6});

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
    
	/**
	 * NOTE: The following code is required by the Visual J++ form
	 * designer.  It can be modified using the form editor.  Do not
	 * modify it using the code editor.
	 */
public static void main(String args[])
    {
        Application.run( new Paiement() );
    }
}

