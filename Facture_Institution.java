//Facture_Institution.java

import com.ms.wfc.app.*;
import com.ms.wfc.core.*;
import com.ms.wfc.ui.*;
import com.ms.wfc.data.*;
import com.ms.wfc.data.ui.*;

public class Facture_Institution extends Form
{    
    public void btnAdd_Click(Object sender, Event evt)
    {
       try
        {   hide();
		    Application.run(new Facture_Institution());
		    dataSource1.getRecordset().addNew();
            m_bAddNew = true;
            dataSource1.getRecordset().cancelUpdate();
			editCharge_tot.setVisible(false);
            btnAdd.setEnabled( false );
			btnUpdate.setEnabled(true);
			 
			  labelRef_Inst.setVisible(false);
			  editRef_Inst.setVisible(false);
			  editRef_serv.setText("0");
			  editRef_Inst.setText("");
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
		
		int noserv = (Integer.valueOf(editRef_serv.getText()).intValue());
	 
		
		psj.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		psj.setCommandText("select * from Service where Nserv = "+editRef_serv.getText()+"");			   			
        psj.begin();
		
		if(String.valueOf(psj.getRecordset().getRecordCount()).equals("1"))
			   {
				  display.setDataSource(psj);
				  display.setBindings(new DataBinding[]{
															     							
							    new DataBinding(refinst,"text","Ref_Inst"),
							    new DataBinding(refnom,"text","Nom"),
								
																				  
									  	  });
				  editRef_Inst.setText(refinst.getText());
							  
		  }
									  
		try{	
		fac.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		fac.setCommandText("select * from Fac_Inst where Ref_Serv = "+noserv+"");			   			
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
		   				
		   
			if(editRef_serv.getText().equals("0"))
		   {MessageBox.show("Veuillez Entrer le Numéro du Service Bénéficié  S.V.P !"," Champ  Vide",MessageBox.ICONERROR);
		  	}
		   else
			 if(String.valueOf(psj.getRecordset().getRecordCount()).equals("0"))
			  {MessageBox.show("Désolé, le Service Numéro '"+editRef_serv.getText()+"' n'Existe pas !", " Données Introuvables",MessageBox.ICONWARNING);
			   psj.close();        
			  }
			 else
				if(String.valueOf(fac.getRecordset().getRecordCount()).equals("1"))
		      {MessageBox.show("Désolé, Une Institution a déjà été Facturée pour le Service Numéro < "+editRef_serv.getText()+" > ", "Opération Illégale",MessageBox.ICONSTOP);
		    	fac.close();}
			   
		  else
		  { 			
			double ftot = fchamb+fpharm+flabo+foxy+fsop+fray+fdeliv+fsal+fekg+fpoupo+fambu+fxred+fhonor1+fsono+fdivers; 
			  
			int resul=MessageBox.show(" Etes-Vous sur de Facturer l'Institution  << "+editRef_Inst.getText()+" Pour le Service donné à  "+refnom.getText()+",  et Dont la somme de la Facture est de "+ ftot + " Gdes >> ? Sinon, Vérifiez le No du Service Ainsi que les Frais de la Facture S.V.P ", "Moment Décisif ",MessageBox.YESNO);
			if(resul==MessageBox.IDYES)
			  { 
					
			String tot=new String();
			tot=String.valueOf(ftot);
			editCharge_tot.setText(tot);
			editCharge_tot.setEnabled(false);
			editCharge_tot.setVisible(true);
			
					 			
			Connection co = new Connection();
			Recordset ti = new Recordset();
			
			Connection co1 = new Connection();
			Recordset ti1 = new Recordset();
								
			psj1.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		    psj1.setCommandText("select * from Institution where Nom = '"+editRef_Inst.getText()+"'");			   			
            psj1.begin();
					
            this.setCursor( Cursor.WAIT );
            dataBinder1.commitChanges();
            dataSource1.getRecordset().update();
			 
											
			DataBinder db = new DataBinder();
			db.setDataSource(psj1);
			db.setBindings(new DataBinding[]{
							   new DataBinding(edit1,"text","Charge"),
									   
							   });
						
			double danbal=Double.valueOf(edit1.getText()).doubleValue();
			double nouvbal;
			nouvbal=danbal+ftot;
			co1.setConnectionString("dsn=HAH;uid=genial;pwd=genial");
			co1.open();
			ti1.setActiveConnection(co1);
			ti1.setSource("Update Institution set Charge="+nouvbal+" where Nom = '"+editRef_Inst.getText()+"'");
			ti1.open();
			
			labelRef_Inst.setVisible(true);
			editRef_Inst.setVisible(true);
			MessageBox.show("Felicitations!  Facturation du Service Numéro << "+editRef_serv.getText()+" >> Pour l'Institution << "+editRef_Inst.getText()+" >>  Réussie ! ", " Confirmation",MessageBox.ICONINFORMATION);			 
			 		
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

	
    public Facture_Institution()
    {
        // Required for Visual J++ Form Designer support
        initForm();
        
        this.show();
        this.update();
			      
			  		 			 
		    dataSource1.getRecordset().addNew();
            m_bAddNew = true;
            btnAdd.setEnabled( false );
			
			 
			  editCharge_tot.setVisible(false);			
			  labelRef_Inst.setVisible(false);
			  editRef_Inst.setVisible(false);
			  editRef_serv.setText("0");
			  editRef_Inst.setText("");
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
        MessageBox.show( e.toString(), "Facture_Institution" );
    }

	private void Facture_Institution_click(Object source, Event e)
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
	Edit editRef_serv = new Edit();
	Label labelRef_Inst = new Label();
	Edit editRef_Inst = new Edit();
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
	Edit refnom = new Edit();
	Edit refinst = new Edit();
	PictureBox pictureBox1 = new PictureBox();
	Label label1 = new Label();
	Label label4 = new Label();
	PictureBox pictureBox4 = new PictureBox();
	PictureBox pictureBox2 = new PictureBox();
	Label label5 = new Label();
	Label label2 = new Label();
	Edit sono = new Edit();
	DataSource dataSource1 = new DataSource(components);
	DataBinder dataBinder1 = new DataBinder(components);
	Edit edit1 = new Edit();
	PictureBox pictureBox3 = new PictureBox();
	PictureBox pictureBox7 = new PictureBox();

	private void initForm()
	{
		// REMARQUE : cette feuille stocke des informations sur les ressources
		// dans un fichier externe. Ne modifiez le paramètre de chaîne d'aucun
		// appel de fonction resources.getObject(). Par exemple,
		// ne modifiez pas "foo1_location" dans la ligne de code
		// suivante, même si le nom de l'objet Foo change : 
		//	 foo1.setLocation((Point)resources.getObject("foo1_location"));

		IResourceManager resources = new ResourceManager(this, "Facture_Institution");
		this.setText("Facturation d\'une Institution");
		this.setAutoScaleBaseSize(new Point(5, 13));
		this.setBorderStyle(FormBorderStyle.NONE);
		this.setClientSize(new Point(602, 450));
		this.setStartPosition(FormStartPosition.CENTER_SCREEN);

		labelNo_facture.setBackColor(Color.CONTROL);
		labelNo_facture.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNo_facture.setLocation(new Point(20, 128));
		labelNo_facture.setSize(new Point(72, 20));
		labelNo_facture.setTabIndex(21);
		labelNo_facture.setTabStop(false);
		labelNo_facture.setText("No_facture");
		labelNo_facture.setBorderStyle(BorderStyle.FIXED_3D);

		editNo_facture.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNo_facture.setEnabled(false);
		editNo_facture.setLocation(new Point(95, 128));
		editNo_facture.setSize(new Point(72, 20));
		editNo_facture.setTabIndex(22);
		editNo_facture.setText("1");
		editNo_facture.setReadOnly(true);

		labelNo_admi.setBackColor(Color.CONTROL);
		labelNo_admi.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNo_admi.setLocation(new Point(20, 152));
		labelNo_admi.setSize(new Point(72, 20));
		labelNo_admi.setTabIndex(23);
		labelNo_admi.setTabStop(false);
		labelNo_admi.setText("No_Service");
		labelNo_admi.setBorderStyle(BorderStyle.FIXED_3D);

		editRef_serv.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRef_serv.setLocation(new Point(96, 152));
		editRef_serv.setSize(new Point(72, 20));
		editRef_serv.setTabIndex(1);
		editRef_serv.setText("1");

		labelRef_Inst.setBackColor(Color.CONTROL);
		labelRef_Inst.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelRef_Inst.setLocation(new Point(26, 184));
		labelRef_Inst.setSize(new Point(168, 20));
		labelRef_Inst.setTabIndex(24);
		labelRef_Inst.setTabStop(false);
		labelRef_Inst.setText("Nom de l\'Institution");
		labelRef_Inst.setBorderStyle(BorderStyle.FIXED_3D);
		labelRef_Inst.setTextAlign(HorizontalAlignment.CENTER);

		editRef_Inst.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRef_Inst.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		editRef_Inst.setLocation(new Point(26, 208));
		editRef_Inst.setSize(new Point(168, 20));
		editRef_Inst.setTabIndex(25);
		editRef_Inst.setText("CAD");
		editRef_Inst.setVisible(false);
		editRef_Inst.setCharacterCasing(CharacterCasing.UPPER);
		editRef_Inst.setMaxLength(50);
		editRef_Inst.setReadOnly(true);

		labelChamb.setBackColor(Color.CONTROL);
		labelChamb.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelChamb.setLocation(new Point(208, 128));
		labelChamb.setSize(new Point(85, 20));
		labelChamb.setTabIndex(26);
		labelChamb.setTabStop(false);
		labelChamb.setText("Chambre");
		labelChamb.setBorderStyle(BorderStyle.FIXED_3D);

		editChamb.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editChamb.setLocation(new Point(296, 128));
		editChamb.setSize(new Point(92, 20));
		editChamb.setTabIndex(2);
		editChamb.setText("0");
		editChamb.setTextAlign(HorizontalAlignment.RIGHT);

		labelPharm.setBackColor(Color.CONTROL);
		labelPharm.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelPharm.setLocation(new Point(208, 152));
		labelPharm.setSize(new Point(85, 20));
		labelPharm.setTabIndex(27);
		labelPharm.setTabStop(false);
		labelPharm.setText("Pharmacie");
		labelPharm.setBorderStyle(BorderStyle.FIXED_3D);

		editPharm.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editPharm.setLocation(new Point(296, 152));
		editPharm.setSize(new Point(92, 20));
		editPharm.setTabIndex(3);
		editPharm.setText("623");
		editPharm.setTextAlign(HorizontalAlignment.RIGHT);

		labelLabo.setBackColor(Color.CONTROL);
		labelLabo.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelLabo.setLocation(new Point(208, 176));
		labelLabo.setSize(new Point(85, 20));
		labelLabo.setTabIndex(28);
		labelLabo.setTabStop(false);
		labelLabo.setText("Laboratoire");
		labelLabo.setBorderStyle(BorderStyle.FIXED_3D);

		editLabo.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editLabo.setLocation(new Point(296, 176));
		editLabo.setSize(new Point(92, 20));
		editLabo.setTabIndex(4);
		editLabo.setText("450");
		editLabo.setTextAlign(HorizontalAlignment.RIGHT);

		labelSop.setBackColor(Color.CONTROL);
		labelSop.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelSop.setLocation(new Point(208, 200));
		labelSop.setSize(new Point(85, 20));
		labelSop.setTabIndex(29);
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
		labelX_ray.setTabIndex(30);
		labelX_ray.setTabStop(false);
		labelX_ray.setText("X_ray");
		labelX_ray.setBorderStyle(BorderStyle.FIXED_3D);

		editX_ray.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editX_ray.setLocation(new Point(296, 224));
		editX_ray.setSize(new Point(92, 20));
		editX_ray.setTabIndex(6);
		editX_ray.setText("455");
		editX_ray.setTextAlign(HorizontalAlignment.RIGHT);

		labelDeliv.setBackColor(Color.CONTROL);
		labelDeliv.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelDeliv.setLocation(new Point(208, 248));
		labelDeliv.setSize(new Point(85, 20));
		labelDeliv.setTabIndex(31);
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
		labelOxyg.setTabIndex(32);
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
		labelSalle_urg.setTabIndex(33);
		labelSalle_urg.setTabStop(false);
		labelSalle_urg.setText("Salle_urgence");
		labelSalle_urg.setBorderStyle(BorderStyle.FIXED_3D);

		editSalle_urg.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editSalle_urg.setLocation(new Point(296, 296));
		editSalle_urg.setSize(new Point(92, 20));
		editSalle_urg.setTabIndex(9);
		editSalle_urg.setText("225");
		editSalle_urg.setTextAlign(HorizontalAlignment.RIGHT);

		labelEkg.setBackColor(Color.CONTROL);
		labelEkg.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelEkg.setLocation(new Point(208, 320));
		labelEkg.setSize(new Point(85, 20));
		labelEkg.setTabIndex(34);
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
		labelPoupo.setTabIndex(35);
		labelPoupo.setTabStop(false);
		labelPoupo.setText("Pouponière");
		labelPoupo.setBorderStyle(BorderStyle.FIXED_3D);

		editPoupo.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editPoupo.setLocation(new Point(296, 344));
		editPoupo.setSize(new Point(92, 20));
		editPoupo.setTabIndex(12);
		editPoupo.setText("0");
		editPoupo.setTextAlign(HorizontalAlignment.RIGHT);

		labelAmbu.setBackColor(Color.CONTROL);
		labelAmbu.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelAmbu.setLocation(new Point(400, 128));
		labelAmbu.setSize(new Point(85, 20));
		labelAmbu.setTabIndex(36);
		labelAmbu.setTabStop(false);
		labelAmbu.setText("Ambulance");
		labelAmbu.setBorderStyle(BorderStyle.FIXED_3D);

		labelRed_x.setBackColor(Color.CONTROL);
		labelRed_x.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelRed_x.setLocation(new Point(400, 152));
		labelRed_x.setSize(new Point(85, 20));
		labelRed_x.setTabIndex(37);
		labelRed_x.setTabStop(false);
		labelRed_x.setText("Red Cross");
		labelRed_x.setBorderStyle(BorderStyle.FIXED_3D);

		editAmbu.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editAmbu.setLocation(new Point(488, 128));
		editAmbu.setSize(new Point(92, 20));
		editAmbu.setTabIndex(13);
		editAmbu.setText("0");
		editAmbu.setTextAlign(HorizontalAlignment.RIGHT);

		labelHonor_1.setBackColor(Color.CONTROL);
		labelHonor_1.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelHonor_1.setLocation(new Point(400, 176));
		labelHonor_1.setSize(new Point(85, 20));
		labelHonor_1.setTabIndex(38);
		labelHonor_1.setTabStop(false);
		labelHonor_1.setText("Honoraire");
		labelHonor_1.setBorderStyle(BorderStyle.FIXED_3D);

		editRed_x.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRed_x.setLocation(new Point(488, 152));
		editRed_x.setSize(new Point(92, 20));
		editRed_x.setTabIndex(14);
		editRed_x.setText("0");
		editRed_x.setTextAlign(HorizontalAlignment.RIGHT);

		labelDivers.setBackColor(Color.CONTROL);
		labelDivers.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelDivers.setLocation(new Point(400, 224));
		labelDivers.setSize(new Point(85, 20));
		labelDivers.setTabIndex(40);
		labelDivers.setTabStop(false);
		labelDivers.setText("Divers");
		labelDivers.setBorderStyle(BorderStyle.FIXED_3D);

		editHonor_1.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editHonor_1.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		editHonor_1.setLocation(new Point(488, 176));
		editHonor_1.setSize(new Point(92, 20));
		editHonor_1.setTabIndex(15);
		editHonor_1.setText("0");
		editHonor_1.setTextAlign(HorizontalAlignment.RIGHT);

		labelCharge_tot.setBackColor(Color.CONTROL);
		labelCharge_tot.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelCharge_tot.setLocation(new Point(400, 346));
		labelCharge_tot.setSize(new Point(85, 20));
		labelCharge_tot.setTabIndex(41);
		labelCharge_tot.setTabStop(false);
		labelCharge_tot.setText("Charge_totale");
		labelCharge_tot.setBorderStyle(BorderStyle.FIXED_3D);

		panel1.setBackColor(new Color(0, 192, 192));
		panel1.setDock(ControlDock.BOTTOM);
		panel1.setLocation(new Point(0, 410));
		panel1.setSize(new Point(602, 40));
		panel1.setTabIndex(42);
		panel1.setText("");
		panel1.setBorderStyle(BorderStyle.FIXED_3D);

		btnAdd.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		btnAdd.setLocation(new Point(38, 6));
		btnAdd.setSize(new Point(70, 25));
		btnAdd.setTabIndex(0);
		btnAdd.setText("&Nouveau");
		btnAdd.addOnClick(new EventHandler(this.btnAdd_Click));

		btnUpdate.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		btnUpdate.setLocation(new Point(262, 6));
		btnUpdate.setSize(new Point(70, 25));
		btnUpdate.setTabIndex(1);
		btnUpdate.setText("&Enregistrer");
		btnUpdate.addOnClick(new EventHandler(this.btnUpdate_Click));

		btnClose.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		btnClose.setLocation(new Point(480, 6));
		btnClose.setSize(new Point(70, 25));
		btnClose.setTabIndex(2);
		btnClose.setText("&Fermer");
		btnClose.addOnClick(new EventHandler(this.btnClose_Click));

		editCharge_tot.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editCharge_tot.setLocation(new Point(488, 346));
		editCharge_tot.setSize(new Point(92, 20));
		editCharge_tot.setTabIndex(46);
		editCharge_tot.setText("1753");
		editCharge_tot.setTextAlign(HorizontalAlignment.RIGHT);

		editDivers.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editDivers.setLocation(new Point(488, 224));
		editDivers.setSize(new Point(92, 20));
		editDivers.setTabIndex(17);
		editDivers.setText("0");
		editDivers.setTextAlign(HorizontalAlignment.RIGHT);

		panel3.setLocation(new Point(5, 96));
		panel3.setSize(new Point(592, 296));
		panel3.setTabIndex(43);
		panel3.setText("panel3");
		panel3.setBorderStyle(BorderStyle.FIXED_3D);

		refnom.setLocation(new Point(32, 192));
		refnom.setSize(new Point(56, 20));
		refnom.setTabIndex(1);
		refnom.setText("edit2");
		refnom.setVisible(false);

		refinst.setLocation(new Point(32, 160));
		refinst.setSize(new Point(56, 20));
		refinst.setTabIndex(0);
		refinst.setText("edit1");
		refinst.setVisible(false);

		pictureBox1.setLocation(new Point(9, 11));
		pictureBox1.setSize(new Point(88, 80));
		pictureBox1.setTabIndex(45);
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
		label1.setTabIndex(44);
		label1.setTabStop(false);
		label1.setText("Facturation d\'une  Institution");
		label1.setBorderStyle(BorderStyle.FIXED_3D);
		label1.setTextAlign(HorizontalAlignment.CENTER);

		label4.setBackColor(Color.YELLOW);
		label4.setForeColor(Color.BLACK);
		label4.setLocation(new Point(170, 129));
		label4.setSize(new Point(24, 16));
		label4.setTabIndex(19);
		label4.setTabStop(false);
		label4.setText("Auto");
		label4.setTextAlign(HorizontalAlignment.CENTER);

		pictureBox4.setLocation(new Point(100, 11));
		pictureBox4.setSize(new Point(480, 40));
		pictureBox4.setTabIndex(18);
		pictureBox4.setTabStop(false);
		pictureBox4.setText("pictureBox2");
		pictureBox4.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox4.setImage((Bitmap)resources.getObject("pictureBox4_image"));
		pictureBox4.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox2.setLocation(new Point(390, 128));
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
		label5.setTabIndex(20);
		label5.setTabStop(false);
		label5.setText("Num");
		label5.setTextAlign(HorizontalAlignment.CENTER);

		label2.setBackColor(Color.CONTROL);
		label2.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		label2.setLocation(new Point(400, 200));
		label2.setSize(new Point(85, 20));
		label2.setTabIndex(39);
		label2.setTabStop(false);
		label2.setText("Sonographie");
		label2.setBorderStyle(BorderStyle.FIXED_3D);

		sono.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		sono.setForeColor(Color.BLACK);
		sono.setLocation(new Point(488, 200));
		sono.setSize(new Point(92, 20));
		sono.setTabIndex(16);
		sono.setText("0");
		sono.setTextAlign(HorizontalAlignment.RIGHT);

		dataSource1.setConnectionString("Provider=MSDASQL.1;Persist Security Info=False;User ID=genial;Data Source=HAH;Initial Catalog=c:\\ASSURE");
		dataSource1.setCommandText("select No_facture, Ref_Serv,Ref_Inst, Chamb, Pharm, Labo, Sop, X_ray, Deliv, Oxyg, Salle_urg, Ekg, Poupo, Ambu, Red_x, Honor_1,Sonogra, Divers,Charge_tot from Fac_Inst ORDER by No_facture");
		dataSource1.setSort(null);
		dataSource1.setStayInSync(true);
		dataSource1.setUserId(null);
		dataSource1.setPassword(null);
		/* @designTimeOnly dataSource1.setLocation(new Point(112, 64)); */

		dataBinder1.setDataSource(dataSource1);
		dataBinder1.setDataMember("");
		dataBinder1.setBindings(new DataBinding[] {
								new DataBinding(editNo_facture, "Text", "No_facture", null), 
								new DataBinding(editRef_serv, "Text", "Ref_Serv", null), 
								new DataBinding(editRef_Inst, "Text", "Ref_Inst", null), 
								new DataBinding(editChamb, "Text", "Chamb", null), 
								new DataBinding(editPharm, "Text", "Pharm", null), 
								new DataBinding(editLabo, "Text", "Labo", null), 
								new DataBinding(editSop, "Text", "Sop", null), 
								new DataBinding(editX_ray, "Text", "X_ray", null), 
								new DataBinding(editDeliv, "Text", "Deliv", null), 
								new DataBinding(editOxyg, "Text", "Oxyg", null), 
								new DataBinding(editSalle_urg, "Text", "Salle_urg", null), 
								new DataBinding(editEkg, "Text", "Ekg", null), 
								new DataBinding(editPoupo, "Text", "Poupo", null), 
								new DataBinding(editAmbu, "Text", "Ambu", null), 
								new DataBinding(editRed_x, "Text", "Red_x", null), 
								new DataBinding(editHonor_1, "Text", "Honor_1", null), 
								new DataBinding(sono, "Text", "Sonogra", null), 
								new DataBinding(editDivers, "Text", "Divers", null), 
								new DataBinding(editCharge_tot, "Text", "Charge_tot", null)});
		/* @designTimeOnly dataBinder1.setLocation(new Point(216, 64)); */

		edit1.setLocation(new Point(40, 224));
		edit1.setSize(new Point(48, 20));
		edit1.setTabIndex(2);
		edit1.setText("edit1");
		edit1.setVisible(false);

		pictureBox3.setLocation(new Point(40, 240));
		pictureBox3.setSize(new Point(128, 106));
		pictureBox3.setTabIndex(11);
		pictureBox3.setTabStop(false);
		pictureBox3.setText("pictureBox2");
		pictureBox3.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox3.setImage((Bitmap)resources.getObject("pictureBox3_image"));
		pictureBox3.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox7.setLocation(new Point(6, 16));
		pictureBox7.setSize(new Point(576, 272));
		pictureBox7.setTabIndex(3);
		pictureBox7.setTabStop(false);
		pictureBox7.setText("pictureBox2");
		pictureBox7.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox7.setImage((Bitmap)resources.getObject("pictureBox7_image"));
		pictureBox7.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

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
							editRef_Inst, 
							labelRef_Inst, 
							editRef_serv, 
							labelNo_admi, 
							editNo_facture, 
							labelNo_facture, 
							panel3, 
							pictureBox4, 
							pictureBox3});
		panel1.setNewControls(new Control[] {
							  btnClose, 
							  btnUpdate, 
							  btnAdd});
		panel3.setNewControls(new Control[] {
							  pictureBox7, 
							  edit1, 
							  refnom, 
							  refinst});

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
        Application.run( new Facture_Institution() );
    }
}
 
