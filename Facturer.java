//Facturer.java

import com.ms.wfc.app.*;
import com.ms.wfc.core.*;
import com.ms.wfc.ui.*;
import com.ms.wfc.data.*;
import com.ms.wfc.data.ui.*;

public class Facturer extends Form
{   public String rcomp = new String();
	public String  schamb = new String();
	public String  spharm = new String();
	public String  slabo = new String();
	public String  sadmi = new String();  
	public String  ssop = new String();  
	public String  sray = new String();  
	public String  sdeliv = new String();  
	public String  soxy =  new String();  
	public String  ssal = new String();  
	public String  sekg = new String();  
	public String  spoupo = new String();  
	public String  sambu = new String();  
	public String  sxred = new String();  
	public String  shonor1 = new String();  
	public String  ssono = new String();  
	public String sdivers = new String();  
	public String snip = new String();
	public String sdos = new String();
	
	

    public void btnAdd_Click(Object sender, Event evt)
    {
       try
        {   hide();
		    Application.run(new Facturer());
		     editCharge_tot.setVisible(false);
		     dataSource1.getRecordset().addNew();
             m_bAddNew = true;
             dataSource1.getRecordset().cancelUpdate();
             btnAdd.setEnabled( false );
			 btnUpdate.setEnabled(true);
			
			  labelRef_comp.setVisible(false);
			  editRef_comp.setVisible(false);
			  editRef_admi.setText("0");
			  editRef_comp.setText("");
			  editPoupo.setText("0.00"); 
			  editAmbu.setText("0.00"); 
			  editRed_x.setText("0.00");  
			  editHonor_1.setText("0.00");  
			  editDivers.setText("0.00"); 
			  editChamb.setText("0.00"); 
			  editPharm.setText("0.00"); 
			  editLabo.setText("0.00");  
			  editSop.setText("0.00");  
			  editX_ray.setText("0.00");  
			  editDeliv.setText("0.00"); 
			  editOxyg.setText("0.00"); 
			  editSalle_urg.setText("0.00");  
			  editEkg.setText("0.00");  
			  sono.setText("0.00"); 
			  editCharge_tot.setText("0.00");
		  
        }
        catch (Exception e)
        {
            handleADOException(e);
        }

    }

    
    public void btnUpdate_Click(Object sender, Event evt)
    {   
	
		DataSource psj = new DataSource();
		DataSource fac = new DataSource();
		DataSource psj1 = new DataSource();
		DataSource titu = new DataSource();
		DataBinder display = new DataBinder();
		
		int nadmi = (Integer.valueOf(editRef_admi.getText()).intValue());
		int dou=0;
		
		psj.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		psj.setCommandText("select * from Admission where No_admi = "+editRef_admi.getText()+"");			   			
        psj.begin();
		
		if(String.valueOf(psj.getRecordset().getRecordCount()).equals("1"))
			   {
				  display.setDataSource(psj);
				  display.setBindings(new DataBinding[]{
															     							
							    new DataBinding(refp,"text","Ref_dossier"),
							    new DataBinding(reft,"text","Ref_titul"),
								new DataBinding(reft2,"text","Nifp"),
																				  
									  	  });
				  
			
			DataSource dp = new DataSource();
		    DataSource dt = new DataSource();
			DataSource dt2 = new DataSource();
			DataBinder disp = new DataBinder();
			DataBinder disp2 = new DataBinder();
			DataBinder dispt = new DataBinder();
			rdos.setText(refp.getText());
			dp.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		    dp.setCommandText("select * from Patient where No_dossier = "+refp.getText()+"");			   			
            dp.begin();
				  disp.setDataSource(dp);
				  disp.setBindings(new DataBinding[]{
												     							
							    new DataBinding(np,"text","Nom"),
								new DataBinding(pp,"text","Prenom"),
																								  
									  	  });
				  Nif.setText(reft.getText());
				  snip=reft2.getText();
				    
			dt.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		    dt.setCommandText("select * from Titulaire where Nif = '"+reft.getText()+"'");			   			
            dt.begin();
				  dispt.setDataSource(dt);
				  dispt.setBindings(new DataBinding[]{
												     							
							    new DataBinding(nt,"text","Nom"),
								new DataBinding(pt,"text","Prenom"),
																	  
					  	  });
		 
			if(reft2.getText().compareTo("")!=0)	  
			{dt2.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		     dt2.setCommandText("select * from Titulaire where Nif = '"+reft2.getText()+"'");			   			
             dt2.begin();
				  disp2.setDataSource(dt2);
				  disp2.setBindings(new DataBinding[]{
												     							
							    new DataBinding(comp2,"text","Ref_comp"),
								
																	  
					  	  });
				  dou=1;
			
			}
				  
						  
		  }
									  
		try{	
		fac.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		fac.setCommandText("select * from Facture where Ref_admi = "+nadmi+"");			   			
        fac.begin();
	 				
	       							
		   double fchamb = (Double.valueOf(editChamb.getText())).doubleValue();
		   double fpharm = (Double.valueOf(editPharm.getText())).doubleValue();
		   double flabo = (Double.valueOf(editLabo.getText())).doubleValue();
		   double fsop = (Double.valueOf(editSop.getText())).doubleValue();
		   double fray = (Double.valueOf(editX_ray.getText())).doubleValue();
		   double fdeliv = (Double.valueOf(editDeliv.getText())).doubleValue();
		   double foxy = (Double.valueOf(editOxyg.getText())).doubleValue();
		   double fsal = (Double.valueOf(editSalle_urg.getText())).doubleValue();
		   double fekg = (Double.valueOf(editEkg.getText())).doubleValue();
		   double fpoupo = (Double.valueOf(editPoupo.getText())).doubleValue();
		   double fambu = (Double.valueOf(editAmbu.getText())).doubleValue();
		   double fxred = (Double.valueOf(editRed_x.getText())).doubleValue();
		   double fhonor1 = (Double.valueOf(editHonor_1.getText())).doubleValue();
		   double fsono = (Double.valueOf(sono.getText())).doubleValue();
		   double fdivers = (Double.valueOf(editDivers.getText())).doubleValue(); 
		   				
		   
			if(editRef_admi.getText().equals("0"))
		   {MessageBox.show("Veuillez Entrer le Numéro d'Admission  S.V.P !"," Champ  Vide",MessageBox.ICONERROR);
		  	}
		   else
			if(editChamb.getText().equals("0.00"))
			{MessageBox.show("Veuillez Entrer au Moins les Frais de la Chambre Utilisée  S.V.P!"," Champ  Vide",MessageBox.ICONERROR);
			} 
	       else
			 if(String.valueOf(psj.getRecordset().getRecordCount()).equals("0"))
			  {MessageBox.show("Désolé, l'Admission Numéro '"+editRef_admi.getText()+"' n'Existe pas !", " Données Introuvables",MessageBox.ICONWARNING);
			   psj.close();        
			  }
			 else
				if(dou==0 && String.valueOf(fac.getRecordset().getRecordCount()).equals("1"))
		      {MessageBox.show("Désolé, Une Compagnie a déjà été Facturée pour l'Admission Numéro < "+editRef_admi.getText()+" > ", "Opération Illégale",MessageBox.ICONSTOP);
		    	fac.close();}
			  else
				 if(dou==1 && String.valueOf(fac.getRecordset().getRecordCount()).equals("2"))
		      {MessageBox.show("Désolé, Deux Compagnies ont déjà été Facturées pour 'Admission Numéro < "+editRef_admi.getText()+" > !", "Opération Illégale",MessageBox.ICONSTOP);
		    	fac.close();}
		  else
		  { 			
			double ftot = fchamb+fpharm+flabo+foxy+fsop+fray+fdeliv+fsal+fekg+fpoupo+fambu+fxred+fhonor1+fsono+fdivers; 
			  
			int resul=MessageBox.show(" Etes-Vous sur de facturer l'Admission du Patient << "+np.getText()+"  "+pp.getText()+" >>, Dépendant du 1er Titulaire << "+nt.getText()+"  "+pt.getText()+" >>  et que que la somme de la Facture est de "+ ftot + " Gdes >> ? Sinon, Vérifiez le No de l'Admission  Ainsi que les Frais de la Facture S.V.P ", "Moment Décisif ",MessageBox.YESNO);
			if(resul==MessageBox.IDYES)
			  { 
					
			String tot=new String();
			tot=String.valueOf(ftot);
			editCharge_tot.setText(tot);
			editCharge_tot.setEnabled(false);
			editCharge_tot.setVisible(true);
			
			
			sadmi = editRef_admi.getText();
			schamb = editChamb.getText();
			spharm = editPharm.getText();
			slabo = editLabo.getText();
			ssop = editSop.getText();
			sray = editX_ray.getText();
			sdeliv = editDeliv.getText();
			soxy = editOxyg.getText();
			ssal = editSalle_urg.getText();
			sekg = editEkg.getText();
		    spoupo = editPoupo.getText();
		    sambu = editAmbu.getText();
		    sxred = editRed_x.getText();
		    shonor1 = editHonor_1.getText();
		    ssono = sono.getText();
		    sdivers = editDivers.getText(); 
		    sdos = refp.getText();
			
			Connection co = new Connection();
			Recordset ti = new Recordset();
			
			Connection co1 = new Connection();
			Recordset ti1 = new Recordset();
			
			DataBinder dbad = new DataBinder();
			dbad.setDataSource(psj);
			dbad.setBindings(new DataBinding[]{
							   new DataBinding(edit4,"text","Ref_titul"),
									   
							   });
			
			
			titu.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		    titu.setCommandText("select * from Titulaire where Nif = '"+edit4.getText()+"'");			   			
            titu.begin();
			
			DataBinder dbtit = new DataBinder();
			dbtit.setDataSource(titu);
			dbtit.setBindings(new DataBinding[]{
							   new DataBinding(editRef_comp,"text","Ref_comp"),
									   
							   });
			psj1.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		    psj1.setCommandText("select * from Compagnie where Nom = '"+editRef_comp.getText()+"'");			   			
            psj1.begin();
					
            this.setCursor( Cursor.WAIT );
            dataBinder1.commitChanges();
            dataSource1.getRecordset().update();
			 
											
			DataBinder db = new DataBinder();
			db.setDataSource(psj1);
			db.setBindings(new DataBinding[]{
							   new DataBinding(edit1,"text","Charge_totale"),
									   
							   });
						
			double danbal=Double.valueOf(edit1.getText()).doubleValue();
			double nouvbal;
			nouvbal=danbal+ftot;
			co1.setConnectionString("dsn=HAH;uid=genial;pwd=genial");
			co1.open();
			ti1.setActiveConnection(co1);
			ti1.setSource("Update Compagnie set Charge_totale ="+nouvbal+" where Nom = '"+editRef_comp.getText()+"'");
			ti1.open();
			
			labelRef_comp.setVisible(true);
			editRef_comp.setVisible(true);
			MessageBox.show("Felicitations!  Facturation de l'Admission Numéro << "+editRef_admi.getText()+" >> Pour la Compagnie << "+editRef_comp.getText()+" >>  Réussie ! ", " Confirmation",MessageBox.ICONINFORMATION);			 
			 		   
			if(dou==1)
		    {	
			  dataSource1.getRecordset().addNew();
              m_bAddNew = true;
			 editRef_admi.setText(sadmi);
			 editChamb.setText(schamb);
			 editPharm.setText(spharm);
			 editLabo.setText(slabo);
			 editSop.setText(ssop);
			 editX_ray.setText(sray);
			 editDeliv.setText(sdeliv);
			 editOxyg.setText(soxy);
			 editSalle_urg.setText(ssal);
			 editEkg.setText(sekg);
		     editPoupo.setText(spoupo);
		     editAmbu.setText(sambu);
			 editRed_x.setText(sxred);
		     editHonor_1.setText(shonor1);
		     sono.setText(ssono);
		     editDivers.setText(sdivers); 
		     editCharge_tot.setText(tot);
			 Nif.setText(snip);
			 editRef_comp.setText(comp2.getText());
			 rdos.setText(sdos);
			 
			MessageBox.show("Attention! la Compagnie << "+editRef_comp.getText()+" >> Sera Aussi Facturée", " Confirmation",MessageBox.ICONINFORMATION);			 			
			 
			this.setCursor( Cursor.WAIT );
            dataBinder1.commitChanges();
            dataSource1.getRecordset().update();
			 
			psj1.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		    psj1.setCommandText("select * from Compagnie where Nom = '"+comp2.getText()+"'");			   			
            psj1.begin();
			             			 
			db.setDataSource(psj1);
			db.setBindings(new DataBinding[]{
							   new DataBinding(edit1,"text","Charge_totale"),
									   
							   });
						
			danbal=Double.valueOf(edit1.getText()).doubleValue();
			nouvbal=danbal+ftot;
			 
			ti1.setSource("Update Compagnie set Charge_totale ="+nouvbal+" where Nom = '"+editRef_comp.getText()+"'");
			ti1.open();
			editCharge_tot.setEnabled(false);
			editCharge_tot.setVisible(true);
			 						
		  }
			
			
			if( m_bAddNew )
            {
                dataSource1.requery();
                dataSource1.getRecordset().moveLast();
              }
			
			btnAdd.setEnabled( true );
		    btnUpdate.setEnabled( false );
		
			
		 }
	  }
		
	 }
	  	
	    catch(NumberFormatException e){
		MessageBox.show("Attention, Tous les Frais Doivent être des Nombres!", " Données Incompatibles",MessageBox.ICONERROR);
	}	
		catch (Exception e){
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

	
    public Facturer()
    {
        // Required for Visual J++ Form Designer support
        initForm();
        
        this.show();
        this.update();
		
		      
		      dataSource1.getRecordset().addNew();
              m_bAddNew = true;
              btnAdd.setEnabled( false );
			 
			  editCharge_tot.setVisible(false);
			  labelRef_comp.setVisible(false);
			  editRef_comp.setVisible(false);
			  editRef_admi.setText("0");
			  editRef_comp.setText("");
			  editPoupo.setText("0.00"); 
			  editAmbu.setText("0.00"); 
			  editRed_x.setText("0.00");  
			  editHonor_1.setText("0.00");  
			  editDivers.setText("0.00"); 
			  editChamb.setText("0.00"); 
			  editPharm.setText("0.00"); 
			  editLabo.setText("0.00");  
			  editSop.setText("0.00");  
			  editX_ray.setText("0.00");  
			  editDeliv.setText("0.00"); 
			  editOxyg.setText("0.00"); 
			  editSalle_urg.setText("0.00");  
			  editEkg.setText("0.00"); 
			  sono.setText("0.00"); 
			  editCharge_tot.setText("0.00");
		
        //TODO: Add any constructor code after initForm call
    }    

    public void formClose(Event e)
    {
        Application.exit();
    }    

    
    void handleADOException(Exception e)
    {
        e.printStackTrace();
        MessageBox.show( e.toString(), "Facturer" );
    }

	private void editNo_facture_textChanged(Object source, Event e)
	{
		
	}

	/**
	 * NOTE: The following code is required by the Visual J++ form
	 * designer.  It can be modified using the form editor.  Do not
	 * modify it using the code editor.
	 */
	Container components = new Container();
	Label labelNo_facture = new Label();
	Edit editNo_facture = new Edit();
	Label labelNo_admi = new Label();
	Edit editRef_admi = new Edit();
	Label labelRef_comp = new Label();
	Edit editRef_comp = new Edit();
	Label labelChamb = new Label();
	Edit editChamb = new Edit();
	Label labelPharm = new Label();
	Edit editPharm = new Edit();
	Label labelLabo = new Label();
	Edit editLabo = new Edit();
	Label labelSop = new Label();
	Edit editSop = new Edit();
	Label labelX_ray = new Label();
	Edit editX_ray = new Edit();
	Label labelDeliv = new Label();
	Edit editDeliv = new Edit();
	Label labelOxyg = new Label();
	Edit editOxyg = new Edit();
	Label labelSalle_urg = new Label();
	Edit editSalle_urg = new Edit();
	Label labelEkg = new Label();
	Edit editEkg = new Edit();
	Label labelPoupo = new Label();
	Edit editPoupo = new Edit();
	Label labelAmbu = new Label();
	Label labelRed_x = new Label();
	Edit editAmbu = new Edit();
	Label labelHonor_1 = new Label();
	Edit editRed_x = new Edit();
	Label labelDivers = new Label();
	Edit editHonor_1 = new Edit();
	Label labelCharge_tot = new Label();
	Panel panel1 = new Panel();
	Button btnAdd = new Button();
	Button btnUpdate = new Button();
	Button btnClose = new Button();
	Edit editCharge_tot = new Edit();
	Edit editDivers = new Edit();
	Panel panel3 = new Panel();
	Edit edit3 = new Edit();
	Edit edit2 = new Edit();
	Edit edit1 = new Edit();
	DataSource dataSource1 = new DataSource(components);
	DataBinder dataBinder1 = new DataBinder(components);
	PictureBox pictureBox1 = new PictureBox();
	Label label1 = new Label();
	Edit edit4 = new Edit();
	Label label4 = new Label();
	PictureBox pictureBox4 = new PictureBox();
	PictureBox pictureBox2 = new PictureBox();
	Label label5 = new Label();
	Label label2 = new Label();
	Edit sono = new Edit();
	Edit refp = new Edit();
	Edit reft = new Edit();
	Edit np = new Edit();
	Edit pp = new Edit();
	Edit nt = new Edit();
	Edit pt = new Edit();
	Edit reft2 = new Edit();
	Edit comp2 = new Edit();
	Edit Nif = new Edit();
	Edit rdos = new Edit();
	PictureBox pictureBox3 = new PictureBox();

	private void initForm()
	{
		// REMARQUE : cette feuille stocke des informations sur les ressources
		// dans un fichier externe. Ne modifiez le paramètre de chaîne d'aucun
		// appel de fonction resources.getObject(). Par exemple,
		// ne modifiez pas "foo1_location" dans la ligne de code
		// suivante, même si le nom de l'objet Foo change : 
		//	 foo1.setLocation((Point)resources.getObject("foo1_location"));

		IResourceManager resources = new ResourceManager(this, "Facturer");
		this.setText("Facturation d\'une Compagnie");
		this.setAutoScaleBaseSize(new Point(5, 13));
		this.setBorderStyle(FormBorderStyle.NONE);
		this.setClientSize(new Point(602, 450));
		this.setStartPosition(FormStartPosition.CENTER_SCREEN);

		labelNo_facture.setBackColor(Color.CONTROL);
		labelNo_facture.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNo_facture.setLocation(new Point(20, 128));
		labelNo_facture.setSize(new Point(72, 20));
		labelNo_facture.setTabIndex(20);
		labelNo_facture.setTabStop(false);
		labelNo_facture.setText("No_facture");
		labelNo_facture.setBorderStyle(BorderStyle.FIXED_3D);

		editNo_facture.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNo_facture.setEnabled(false);
		editNo_facture.setLocation(new Point(95, 128));
		editNo_facture.setSize(new Point(72, 20));
		editNo_facture.setTabIndex(21);
		editNo_facture.setText("88");
		editNo_facture.setReadOnly(true);
		editNo_facture.addOnTextChanged(new EventHandler(this.editNo_facture_textChanged));

		labelNo_admi.setBackColor(Color.CONTROL);
		labelNo_admi.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNo_admi.setLocation(new Point(20, 152));
		labelNo_admi.setSize(new Point(72, 20));
		labelNo_admi.setTabIndex(22);
		labelNo_admi.setTabStop(false);
		labelNo_admi.setText("No_admi");
		labelNo_admi.setBorderStyle(BorderStyle.FIXED_3D);

		editRef_admi.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRef_admi.setLocation(new Point(96, 152));
		editRef_admi.setSize(new Point(72, 20));
		editRef_admi.setTabIndex(1);
		editRef_admi.setText("67");

		labelRef_comp.setBackColor(Color.CONTROL);
		labelRef_comp.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelRef_comp.setLocation(new Point(21, 185));
		labelRef_comp.setSize(new Point(168, 20));
		labelRef_comp.setTabIndex(23);
		labelRef_comp.setTabStop(false);
		labelRef_comp.setText("Nom de la Compagnie");
		labelRef_comp.setBorderStyle(BorderStyle.FIXED_3D);

		editRef_comp.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRef_comp.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		editRef_comp.setLocation(new Point(21, 208));
		editRef_comp.setSize(new Point(168, 20));
		editRef_comp.setTabIndex(24);
		editRef_comp.setText("INASSA");
		editRef_comp.setVisible(false);
		editRef_comp.setCharacterCasing(CharacterCasing.UPPER);
		editRef_comp.setMaxLength(50);
		editRef_comp.setReadOnly(true);

		labelChamb.setBackColor(Color.CONTROL);
		labelChamb.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelChamb.setLocation(new Point(208, 128));
		labelChamb.setSize(new Point(85, 20));
		labelChamb.setTabIndex(25);
		labelChamb.setTabStop(false);
		labelChamb.setText("Chambre");
		labelChamb.setBorderStyle(BorderStyle.FIXED_3D);

		editChamb.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editChamb.setLocation(new Point(296, 128));
		editChamb.setSize(new Point(92, 20));
		editChamb.setTabIndex(2);
		editChamb.setText("4000");
		editChamb.setTextAlign(HorizontalAlignment.RIGHT);

		labelPharm.setBackColor(Color.CONTROL);
		labelPharm.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelPharm.setLocation(new Point(208, 152));
		labelPharm.setSize(new Point(85, 20));
		labelPharm.setTabIndex(26);
		labelPharm.setTabStop(false);
		labelPharm.setText("Pharmacie");
		labelPharm.setBorderStyle(BorderStyle.FIXED_3D);

		editPharm.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editPharm.setLocation(new Point(296, 152));
		editPharm.setSize(new Point(92, 20));
		editPharm.setTabIndex(3);
		editPharm.setText("5190");
		editPharm.setTextAlign(HorizontalAlignment.RIGHT);

		labelLabo.setBackColor(Color.CONTROL);
		labelLabo.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelLabo.setLocation(new Point(208, 176));
		labelLabo.setSize(new Point(85, 20));
		labelLabo.setTabIndex(27);
		labelLabo.setTabStop(false);
		labelLabo.setText("Laboratoire");
		labelLabo.setBorderStyle(BorderStyle.FIXED_3D);

		editLabo.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editLabo.setLocation(new Point(296, 176));
		editLabo.setSize(new Point(92, 20));
		editLabo.setTabIndex(4);
		editLabo.setText("1635");
		editLabo.setTextAlign(HorizontalAlignment.RIGHT);

		labelSop.setBackColor(Color.CONTROL);
		labelSop.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelSop.setLocation(new Point(208, 200));
		labelSop.setSize(new Point(85, 20));
		labelSop.setTabIndex(28);
		labelSop.setTabStop(false);
		labelSop.setText("Sop");
		labelSop.setBorderStyle(BorderStyle.FIXED_3D);

		editSop.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editSop.setLocation(new Point(296, 200));
		editSop.setSize(new Point(92, 20));
		editSop.setTabIndex(5);
		editSop.setText("0");
		editSop.setTextAlign(HorizontalAlignment.RIGHT);

		labelX_ray.setBackColor(Color.CONTROL);
		labelX_ray.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelX_ray.setLocation(new Point(208, 224));
		labelX_ray.setSize(new Point(85, 20));
		labelX_ray.setTabIndex(29);
		labelX_ray.setTabStop(false);
		labelX_ray.setText("X_ray");
		labelX_ray.setBorderStyle(BorderStyle.FIXED_3D);

		editX_ray.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editX_ray.setLocation(new Point(296, 224));
		editX_ray.setSize(new Point(92, 20));
		editX_ray.setTabIndex(6);
		editX_ray.setText("0");
		editX_ray.setTextAlign(HorizontalAlignment.RIGHT);

		labelDeliv.setBackColor(Color.CONTROL);
		labelDeliv.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelDeliv.setLocation(new Point(208, 248));
		labelDeliv.setSize(new Point(85, 20));
		labelDeliv.setTabIndex(30);
		labelDeliv.setTabStop(false);
		labelDeliv.setText("Delivery");
		labelDeliv.setBorderStyle(BorderStyle.FIXED_3D);

		editDeliv.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editDeliv.setLocation(new Point(296, 248));
		editDeliv.setSize(new Point(92, 20));
		editDeliv.setTabIndex(7);
		editDeliv.setText("0");
		editDeliv.setTextAlign(HorizontalAlignment.RIGHT);

		labelOxyg.setBackColor(Color.CONTROL);
		labelOxyg.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelOxyg.setLocation(new Point(208, 272));
		labelOxyg.setSize(new Point(85, 20));
		labelOxyg.setTabIndex(31);
		labelOxyg.setTabStop(false);
		labelOxyg.setText("Oxygène");
		labelOxyg.setBorderStyle(BorderStyle.FIXED_3D);

		editOxyg.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editOxyg.setLocation(new Point(296, 272));
		editOxyg.setSize(new Point(92, 20));
		editOxyg.setTabIndex(8);
		editOxyg.setText("0");
		editOxyg.setTextAlign(HorizontalAlignment.RIGHT);

		labelSalle_urg.setBackColor(Color.CONTROL);
		labelSalle_urg.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelSalle_urg.setLocation(new Point(208, 296));
		labelSalle_urg.setSize(new Point(85, 20));
		labelSalle_urg.setTabIndex(32);
		labelSalle_urg.setTabStop(false);
		labelSalle_urg.setText("Salle_urgence");
		labelSalle_urg.setBorderStyle(BorderStyle.FIXED_3D);

		editSalle_urg.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editSalle_urg.setLocation(new Point(296, 296));
		editSalle_urg.setSize(new Point(92, 20));
		editSalle_urg.setTabIndex(9);
		editSalle_urg.setText("0");
		editSalle_urg.setTextAlign(HorizontalAlignment.RIGHT);

		labelEkg.setBackColor(Color.CONTROL);
		labelEkg.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelEkg.setLocation(new Point(208, 320));
		labelEkg.setSize(new Point(85, 20));
		labelEkg.setTabIndex(33);
		labelEkg.setTabStop(false);
		labelEkg.setText("Ekg");
		labelEkg.setBorderStyle(BorderStyle.FIXED_3D);

		editEkg.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editEkg.setLocation(new Point(296, 320));
		editEkg.setSize(new Point(92, 20));
		editEkg.setTabIndex(10);
		editEkg.setText("0");
		editEkg.setTextAlign(HorizontalAlignment.RIGHT);

		labelPoupo.setBackColor(Color.CONTROL);
		labelPoupo.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelPoupo.setLocation(new Point(208, 344));
		labelPoupo.setSize(new Point(85, 20));
		labelPoupo.setTabIndex(34);
		labelPoupo.setTabStop(false);
		labelPoupo.setText("Pouponière");
		labelPoupo.setBorderStyle(BorderStyle.FIXED_3D);

		editPoupo.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editPoupo.setLocation(new Point(296, 344));
		editPoupo.setSize(new Point(92, 20));
		editPoupo.setTabIndex(11);
		editPoupo.setText("0");
		editPoupo.setTextAlign(HorizontalAlignment.RIGHT);

		labelAmbu.setBackColor(Color.CONTROL);
		labelAmbu.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelAmbu.setLocation(new Point(400, 128));
		labelAmbu.setSize(new Point(85, 20));
		labelAmbu.setTabIndex(35);
		labelAmbu.setTabStop(false);
		labelAmbu.setText("Ambulance");
		labelAmbu.setBorderStyle(BorderStyle.FIXED_3D);

		labelRed_x.setBackColor(Color.CONTROL);
		labelRed_x.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelRed_x.setLocation(new Point(400, 152));
		labelRed_x.setSize(new Point(85, 20));
		labelRed_x.setTabIndex(36);
		labelRed_x.setTabStop(false);
		labelRed_x.setText("Red Cross");
		labelRed_x.setBorderStyle(BorderStyle.FIXED_3D);

		editAmbu.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editAmbu.setLocation(new Point(488, 128));
		editAmbu.setSize(new Point(92, 20));
		editAmbu.setTabIndex(12);
		editAmbu.setText("0");
		editAmbu.setTextAlign(HorizontalAlignment.RIGHT);

		labelHonor_1.setBackColor(Color.CONTROL);
		labelHonor_1.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelHonor_1.setLocation(new Point(400, 176));
		labelHonor_1.setSize(new Point(85, 20));
		labelHonor_1.setTabIndex(37);
		labelHonor_1.setTabStop(false);
		labelHonor_1.setText("Honoraire");
		labelHonor_1.setBorderStyle(BorderStyle.FIXED_3D);

		editRed_x.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRed_x.setLocation(new Point(488, 152));
		editRed_x.setSize(new Point(92, 20));
		editRed_x.setTabIndex(13);
		editRed_x.setText("0");
		editRed_x.setTextAlign(HorizontalAlignment.RIGHT);

		labelDivers.setBackColor(Color.CONTROL);
		labelDivers.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelDivers.setLocation(new Point(400, 222));
		labelDivers.setSize(new Point(85, 20));
		labelDivers.setTabIndex(39);
		labelDivers.setTabStop(false);
		labelDivers.setText("Divers");
		labelDivers.setBorderStyle(BorderStyle.FIXED_3D);

		editHonor_1.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editHonor_1.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		editHonor_1.setLocation(new Point(488, 176));
		editHonor_1.setSize(new Point(92, 20));
		editHonor_1.setTabIndex(14);
		editHonor_1.setText("0");
		editHonor_1.setTextAlign(HorizontalAlignment.RIGHT);

		labelCharge_tot.setBackColor(Color.CONTROL);
		labelCharge_tot.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelCharge_tot.setLocation(new Point(400, 344));
		labelCharge_tot.setSize(new Point(85, 20));
		labelCharge_tot.setTabIndex(40);
		labelCharge_tot.setTabStop(false);
		labelCharge_tot.setText("Charge_totale");
		labelCharge_tot.setBorderStyle(BorderStyle.FIXED_3D);

		panel1.setBackColor(new Color(0, 192, 192));
		panel1.setDock(ControlDock.BOTTOM);
		panel1.setLocation(new Point(0, 410));
		panel1.setSize(new Point(602, 40));
		panel1.setTabIndex(41);
		panel1.setText("");
		panel1.setBorderStyle(BorderStyle.FIXED_3D);

		btnAdd.setLocation(new Point(38, 6));
		btnAdd.setSize(new Point(70, 25));
		btnAdd.setTabIndex(0);
		btnAdd.setText("&Nouveau");
		btnAdd.addOnClick(new EventHandler(this.btnAdd_Click));

		btnUpdate.setLocation(new Point(262, 6));
		btnUpdate.setSize(new Point(70, 25));
		btnUpdate.setTabIndex(1);
		btnUpdate.setText("&Enregistrer");
		btnUpdate.addOnClick(new EventHandler(this.btnUpdate_Click));

		btnClose.setLocation(new Point(480, 6));
		btnClose.setSize(new Point(70, 25));
		btnClose.setTabIndex(2);
		btnClose.setText("&Fermer");
		btnClose.addOnClick(new EventHandler(this.btnClose_Click));

		editCharge_tot.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editCharge_tot.setLocation(new Point(488, 344));
		editCharge_tot.setSize(new Point(92, 20));
		editCharge_tot.setTabIndex(47);
		editCharge_tot.setText("10825");
		editCharge_tot.setTextAlign(HorizontalAlignment.RIGHT);

		editDivers.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editDivers.setLocation(new Point(488, 224));
		editDivers.setSize(new Point(92, 20));
		editDivers.setTabIndex(16);
		editDivers.setText("0");
		editDivers.setTextAlign(HorizontalAlignment.RIGHT);

		panel3.setLocation(new Point(8, 96));
		panel3.setSize(new Point(592, 296));
		panel3.setTabIndex(42);
		panel3.setText("panel3");
		panel3.setBorderStyle(BorderStyle.FIXED_3D);

		edit3.setLocation(new Point(88, 240));
		edit3.setSize(new Point(32, 20));
		edit3.setTabIndex(2);
		edit3.setText("edit3");
		edit3.setVisible(false);

		edit2.setLocation(new Point(24, 264));
		edit2.setSize(new Point(40, 20));
		edit2.setTabIndex(1);
		edit2.setText("edit2");
		edit2.setVisible(false);

		edit1.setLocation(new Point(80, 216));
		edit1.setSize(new Point(16, 20));
		edit1.setTabIndex(0);
		edit1.setText("edit1");
		edit1.setVisible(false);

		dataSource1.setConnectionString("Provider=MSDASQL.1;Persist Security Info=False;Extended Properties=\"DSN=HAH;DBQ=c:\\ASSURE.MDB;DefaultDir=c:;DriverId=25;FIL=MS Access;MaxBufferSize=2048;PageTimeout=5;UID=admin;\";Initial Catalog=C:\\ASSURE");
		dataSource1.setCommandText("select No_facture, Ref_admi,Nif_tit,Rf_dos, Ref_comp, Chamb, Pharm, Labo, Sop, X_ray, Deliv, Oxyg, Salle_urg, Ekg, Poupo, Ambu, Red_x, Honor_1, Honor_2, Honor_3,Sonogra, Divers,Divers1,Divers2,Charge_tot from Facture ORDER by No_facture");
		dataSource1.setSort(null);
		dataSource1.setAsyncFetch(true);
		dataSource1.setStayInSync(true);
		dataSource1.setUserId(null);
		dataSource1.setPassword(null);
		/* @designTimeOnly dataSource1.setLocation(new Point(384, 64)); */

		pictureBox1.setLocation(new Point(9, 11));
		pictureBox1.setSize(new Point(88, 80));
		pictureBox1.setTabIndex(46);
		pictureBox1.setTabStop(false);
		pictureBox1.setText("pictureBox1");
		pictureBox1.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox1.setImage((Bitmap)resources.getObject("pictureBox1_image"));
		pictureBox1.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		label1.setBackColor(new Color(255, 255, 192));
		label1.setFont(new Font("Verdana", 14.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label1.setForeColor(Color.AQUA);
		label1.setLocation(new Point(120, 18));
		label1.setSize(new Point(440, 24));
		label1.setTabIndex(43);
		label1.setTabStop(false);
		label1.setText("Facturation d\'une Compagnie d\'Assurance");
		label1.setBorderStyle(BorderStyle.FIXED_3D);
		label1.setTextAlign(HorizontalAlignment.CENTER);

		edit4.setLocation(new Point(32, 216));
		edit4.setSize(new Point(16, 20));
		edit4.setTabIndex(3);
		edit4.setText("edit4");
		edit4.setVisible(false);

		label4.setBackColor(Color.YELLOW);
		label4.setForeColor(Color.BLACK);
		label4.setLocation(new Point(170, 129));
		label4.setSize(new Point(24, 16));
		label4.setTabIndex(18);
		label4.setTabStop(false);
		label4.setText("Auto");
		label4.setTextAlign(HorizontalAlignment.CENTER);

		pictureBox4.setLocation(new Point(100, 11));
		pictureBox4.setSize(new Point(480, 40));
		pictureBox4.setTabIndex(17);
		pictureBox4.setTabStop(false);
		pictureBox4.setText("pictureBox2");
		pictureBox4.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox4.setImage((Bitmap)resources.getObject("pictureBox4_image"));
		pictureBox4.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox2.setLocation(new Point(390, 127));
		pictureBox2.setSize(new Point(8, 240));
		pictureBox2.setTabIndex(0);
		pictureBox2.setTabStop(false);
		pictureBox2.setText("pictureBox2");
		pictureBox2.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox2.setImage((Bitmap)resources.getObject("pictureBox2_image"));
		pictureBox2.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		label5.setBackColor(Color.AQUA);
		label5.setForeColor(Color.WHITE);
		label5.setLocation(new Point(170, 152));
		label5.setSize(new Point(24, 16));
		label5.setTabIndex(19);
		label5.setTabStop(false);
		label5.setText("Num");
		label5.setTextAlign(HorizontalAlignment.CENTER);

		label2.setBackColor(Color.CONTROL);
		label2.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label2.setLocation(new Point(400, 200));
		label2.setSize(new Point(85, 20));
		label2.setTabIndex(38);
		label2.setTabStop(false);
		label2.setText("Sonographie");
		label2.setBorderStyle(BorderStyle.FIXED_3D);

		sono.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		sono.setForeColor(Color.BLACK);
		sono.setLocation(new Point(488, 200));
		sono.setSize(new Point(92, 20));
		sono.setTabIndex(15);
		sono.setText("0");
		sono.setTextAlign(HorizontalAlignment.RIGHT);

		refp.setLocation(new Point(8, 216));
		refp.setSize(new Point(16, 20));
		refp.setTabIndex(4);
		refp.setText("");
		refp.setVisible(false);

		reft.setLocation(new Point(56, 216));
		reft.setSize(new Point(16, 20));
		reft.setTabIndex(5);
		reft.setText("");
		reft.setVisible(false);

		np.setLocation(new Point(8, 240));
		np.setSize(new Point(16, 20));
		np.setTabIndex(6);
		np.setText("");
		np.setVisible(false);

		pp.setLocation(new Point(8, 264));
		pp.setSize(new Point(8, 20));
		pp.setTabIndex(7);
		pp.setText("");
		pp.setVisible(false);

		nt.setLocation(new Point(72, 240));
		nt.setSize(new Point(8, 20));
		nt.setTabIndex(8);
		nt.setText("");
		nt.setVisible(false);

		pt.setLocation(new Point(72, 264));
		pt.setSize(new Point(8, 20));
		pt.setTabIndex(9);
		pt.setText("");
		pt.setVisible(false);

		reft2.setLocation(new Point(88, 264));
		reft2.setSize(new Point(32, 20));
		reft2.setTabIndex(10);
		reft2.setText("reft2");
		reft2.setVisible(false);

		comp2.setLocation(new Point(32, 240));
		comp2.setSize(new Point(24, 20));
		comp2.setTabIndex(12);
		comp2.setText("edit6");
		comp2.setVisible(false);

		Nif.setLocation(new Point(112, 160));
		Nif.setSize(new Point(24, 20));
		Nif.setTabIndex(13);
		Nif.setText("005-576-139-6");
		Nif.setVisible(false);
		Nif.setMaxLength(13);

		rdos.setLocation(new Point(128, 192));
		rdos.setSize(new Point(16, 20));
		rdos.setTabIndex(14);
		rdos.setText("219122");
		rdos.setVisible(false);

		dataBinder1.setDataSource(dataSource1);
		dataBinder1.setDataMember("");
		dataBinder1.setBindings(new DataBinding[] {
								new DataBinding(editNo_facture, "Text", "No_facture", null), 
								new DataBinding(editRef_comp, "Text", "Ref_comp", null), 
								new DataBinding(editChamb, "Text", "Chamb", null), 
								new DataBinding(editPharm, "Text", "Pharm", null), 
								new DataBinding(editLabo, "Text", "Labo", null), 
								new DataBinding(editSop, "Text", "Sop", null), 
								new DataBinding(editX_ray, "Text", "X_ray", null), 
								new DataBinding(editDeliv, "Text", "Deliv", null), 
								new DataBinding(editOxyg, "Text", "Oxyg", null), 
								new DataBinding(editSalle_urg, "Text", "Salle_urg", null), 
								new DataBinding(editEkg, "Text", "Ekg", null), 
								new DataBinding(editCharge_tot, "Text", "Charge_tot", null), 
								new DataBinding(editHonor_1, "Text", "Honor_1", null), 
								new DataBinding(editDivers, "Text", "Divers", null), 
								new DataBinding(editRef_admi, "Text", "Ref_admi", null), 
								new DataBinding(Nif, "Text", "Nif_tit", null), 
								new DataBinding(rdos, "Text", "Rf_dos", null), 
								new DataBinding(editRed_x, "Text", "Red_x", null), 
								new DataBinding(editPoupo, "Text", "Poupo", null), 
								new DataBinding(editAmbu, "Text", "Ambu", null), 
								new DataBinding(sono, "Text", "Sonogra", null)});
		/* @designTimeOnly dataBinder1.setLocation(new Point(488, 64)); */

		pictureBox3.setLocation(new Point(8, 16));
		pictureBox3.setSize(new Point(576, 280));
		pictureBox3.setTabIndex(11);
		pictureBox3.setTabStop(false);
		pictureBox3.setText("pictureBox2");
		pictureBox3.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox3.setImage((Bitmap)resources.getObject("pictureBox3_image"));
		pictureBox3.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		this.setNewControls(new Control[] {
							sono, 
							label2, 
							label5, 
							pictureBox2, 
							label4, 
							label1, 
							pictureBox1, 
							editDivers, 
							editCharge_tot, 
							panel1, 
							labelCharge_tot, 
							editHonor_1, 
							labelDivers, 
							editRed_x, 
							labelHonor_1, 
							editAmbu, 
							labelRed_x, 
							labelAmbu, 
							editPoupo, 
							labelPoupo, 
							editEkg, 
							labelEkg, 
							editSalle_urg, 
							labelSalle_urg, 
							editOxyg, 
							labelOxyg, 
							editDeliv, 
							labelDeliv, 
							editX_ray, 
							labelX_ray, 
							editSop, 
							labelSop, 
							editLabo, 
							labelLabo, 
							editPharm, 
							labelPharm, 
							editChamb, 
							labelChamb, 
							editRef_comp, 
							labelRef_comp, 
							editRef_admi, 
							labelNo_admi, 
							editNo_facture, 
							labelNo_facture, 
							panel3, 
							pictureBox4});
		panel1.setNewControls(new Control[] {
							  btnClose, 
							  btnUpdate, 
							  btnAdd});
		panel3.setNewControls(new Control[] {
							  pictureBox3, 
							  rdos, 
							  Nif, 
							  comp2, 
							  reft2, 
							  pt, 
							  nt, 
							  pp, 
							  np, 
							  reft, 
							  refp, 
							  edit4, 
							  edit1, 
							  edit2, 
							  edit3});

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
        Application.run( new Facturer() );
    }
}
 
