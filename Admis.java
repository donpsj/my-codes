//Admis.java

import com.ms.wfc.app.*;
import com.ms.wfc.core.*;
import com.ms.wfc.ui.*;
import com.ms.wfc.data.*;
import com.ms.wfc.data.ui.*;

public class Admis extends Form
{     public String vdate = new String();
	  public String vdate1 = new String();
	  double charg;
	  int pass;

    public void btnAdd_Click(Object sender, Event evt)
    {
        try
        {   hide();
		    Application.run(new Admis());
            /*dataSource1.getRecordset().cancelUpdate();
            dataSource1.getRecordset().addNew();
            m_bAddNew = true;
            btnAdd.setEnabled( false );
			btnUpdate.setEnabled( true );
			editRef_titul.setText("");
			editRef_dossier.setText("0");
		    editChambre.setText("");
			editDoc_trait_1.setText("");
			editNb_jours.setText("0");
			edit1.setText("0");
			editCredit_patient.setText("0");
			
			      jour.setText(""); 
		           mois.setText("");
		           an.setText(""); 
           
			       jour1.setText(""); 
		           mois1.setText("");
		           an1.setText(""); */
        }
        catch (Exception e)
        {
            handleADOException(e);
        }
    }

   

 public void btnUpdate_Click(Object sender, Event evt)
 {  try
	{
        
	    double credit = (Double.valueOf(editCredit_patient.getText())).doubleValue();
		int rdos = (Integer.valueOf(editRef_dossier.getText()).intValue());
		
		
		vdate = jour.getSelectedItem()+ "/" + mois.getSelectedItem()+ "/" +"20"+""+an.getText();
		            editDate.setText(String.valueOf(vdate));
			 
			        vdate1 = jour1.getSelectedItem()+ "/" + mois1.getSelectedItem()+ "/" +"20"+""+an1.getText();
			        editDate_exeat.setText(String.valueOf(vdate1));
					
					
					
		
		DataSource tit = new DataSource();
		DataSource pat = new DataSource();
				
		
		pat.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		pat.setCommandText("select * from Patient where No_dossier = "+rdos+"");			   			
        pat.begin();
		
		if(String.valueOf(pat.getRecordset().getRecordCount()).equals("1"))
		    {     DataBinder dispat = new DataBinder();
				  dispat.setDataSource(pat);
				  dispat.setBindings(new DataBinding[]{
							          new DataBinding(editRef_titul,"text","Ref_titul"),
									  new DataBinding(nif2,"text","Ref_titul2"),
									  new DataBinding(n1,"text","Nom"),
									  new DataBinding(p1,"text","Prenom"),
								                                        });
			   
				tit.setConnectionString("dsn=hah;uid=genial;pwd=genial");
		        tit.setCommandText("select * from Titulaire where Nif = '"+editRef_titul.getText()+"'");			   			
                tit.begin();
				
		  if(String.valueOf(tit.getRecordset().getRecordCount()).equals("1"))
		    {     DataBinder display = new DataBinder();
				  display.setDataSource(tit);
				  display.setBindings(new DataBinding[]{
							          new DataBinding(edit1,"text","Charge"),
									  new DataBinding(edit2,"text","Nom"),
									  new DataBinding(edit3,"text","Prenom"),
								                                        });
			   } 
		  
	     	}
		 double charg = (Double.valueOf(edit1.getText())).doubleValue();					 					   
	        
		  if(jour.getText().equals("")||mois.getText().equals("")||an.getText().equals(""))
			{MessageBox.show("Entrez la Date d'Admission sous la Forme :'jj MM yy '","Champ Vide",MessageBox.ICONERROR);
			 }
		  else
		   if(editRef_dossier.getText().equals("0"))
				{MessageBox.show("Entrez le Numéro de Dossier du Patient ","Champ Vide",MessageBox.ICONERROR);
			     }
			else
				if(editChambre.getText().equals(""))
				{MessageBox.show("Entrez la Chambre du Patient ","Champ Vide",MessageBox.ICONERROR);
			     }
			else
				if(editDoc_trait_1.getText().equals(""))
				{MessageBox.show("Entrez  au Moins un Docteur Traitant ","Champ Vide",MessageBox.ICONERROR);
			     }
			
			else
				if(jour1.getText().equals("")||mois1.getText().equals("")||an1.getText().equals(""))
			  {
					MessageBox.show("Entrez la Date d'Exeat sous la Forme :'jj :  MM :  yy '","Champ Vide",MessageBox.ICONERROR);
			   }
			else
			   if(jour.getText().compareTo(jour1.getText())==0 && mois.getText().compareTo(mois1.getText())==0&& an.getText().compareTo(an1.getText())==0)
			   {   MessageBox.show("La Date d'Exeat ne peut être égale à la Date d'Admission","Champ Vide",MessageBox.ICONERROR);
			       jour1.setText(""); 
		           mois1.setText("");
		           an1.setText("");   }
			   else
				   if(jour.getText().compareTo(jour1.getText())>0 && mois.getText().compareTo(mois1.getText())>0 && an.getText().compareTo(an1.getText())>=0)
			   {   MessageBox.show("La Date d'Exeat ne peut être Inférieure à la Date d'Admission","Champ Vide",MessageBox.ICONERROR);
			       jour1.setText(""); 
		           mois1.setText("");
		           an1.setText("");   }
				
			   		
			 	else
				  if( jour.getText().equals("31")&&(mois.getText().equals("02")||mois.getText().equals("04")||mois.getText().equals("06")||mois.getText().equals("09")||mois.getText().equals("11")))
					{ MessageBox.show("Dans la Date d'Admission , le Mois ne Porte pas 31 jours","Données Incompatibles",MessageBox.ICONERROR);
					}
				else
					 if(mois.getText().equals("02")&&jour.getText().equals("30"))
					 {  MessageBox.show("Dans la Date d'Admission, le Mois de Février Porte  29 Jours au Maximum","Données Incompatibles",MessageBox.ICONERROR);
					 }	
			    else
				    if( jour1.getText().equals("31")&&(mois1.getText().equals("02")||mois1.getText().equals("04")||mois1.getText().equals("06")||mois1.getText().equals("09")||mois1.getText().equals("11")))
					{ MessageBox.show("Dans la Date d'Exeat, le Mois ne Porte pas 31 Jours","Données Incompatibles",MessageBox.ICONERROR);
					}
				else
					 if(mois1.getText().equals("02")&&jour1.getText().equals("30"))
					 {  MessageBox.show("Dans la Date d'Exeat, le Mois de Février Porte  29 Jours au Maximum","Données Incompatibles",MessageBox.ICONERROR);
					 }
			    else
					if(String.valueOf(pat.getRecordset().getRecordCount()).equals("0"))
			          {   MessageBox.show("Désolé,le Patient Identifié au No de Dossier << '"+editRef_dossier.getText()+"' >> n'est pas Inscrit, Vérifiez le No de Dossier S.V.P"," Données Introuvables ",MessageBox.ICONERROR);
						        
						    }
				else
				if(String.valueOf(tit.getRecordset().getRecordCount()).equals("1"))
				  {int res =MessageBox.show(" Etes-Vous Sur que le Patient << "+n1.getText()+"  "+p1.getText()+" ? >> est un Dépendant du 1er Titulaire << "+edit2.getText()+ "  "+edit3.getText() +" >> ?", "Moment Décisif",MessageBox.YESNO);
				   			
				   if(res==MessageBox.IDYES)
					{ 
					   if(charg>0)
					    {int choi;
		                 choi=MessageBox.show("Attention Le Titulaire<<"+edit2.getText()+"  "+edit3.getText()+">>  a une Dette de <<"+charg+">> Gdes, Voulez-vous Valider l'Admission ?", "Moment Désicif",MessageBox.YESNO);
						  if(choi==MessageBox.IDYES) 
						  { this.setCursor( Cursor.WAIT );
                            dataBinder1.commitChanges();
                            dataSource1.getRecordset().update();
							
								
							     if( m_bAddNew )
                                 {
                                   dataSource1.requery();
                                   dataSource1.getRecordset().moveLast();
			                       }
			               
		                     MessageBox.show("Felicitations !! L'Admission du Patient est Réussie, Mais avec une Dette de << "+charg+" >> Gdes.  ", " Confirmation",MessageBox.ICONINFORMATION);	
		                     btnAdd.setEnabled( true );
		                     btnUpdate.setEnabled( false );
						  }
					   }
				   else			   		
					{  this.setCursor( Cursor.WAIT );
                       dataBinder1.commitChanges();
                       dataSource1.getRecordset().update();
       	            
                     if( m_bAddNew )
                      {
                     dataSource1.requery();
                     dataSource1.getRecordset().moveLast();
			           }
					 
		          MessageBox.show("Felicitations !! L'Admission du Patient est Réussie.", " Confirmation",MessageBox.ICONINFORMATION);	
		          btnAdd.setEnabled( true );
		          btnUpdate.setEnabled( false );
	            }
            }
			}
	       }
      
	
	     catch(NumberFormatException e){
		   MessageBox.show("Attention ! Un ou Plusieurs Champs Numériques Contiennent des Données Incompatibles, Veuillez les Vérifier  S.V.P !", " Données Incompatibles",MessageBox.ICONERROR);
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
	
    public Admis()
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
	    editRef_titul.setText("");
		editRef_dossier.setText("0");
		editChambre.setText("");
		editDoc_trait_1.setText("");
		edit1.setText("0");
		jour.setText(""); 
		mois.setText("");
		editCredit_patient.setText("0");
		           an.setText(""); 
           	       jour1.setText(""); 
		           mois1.setText("");
		           an1.setText(""); 
           

        //TODO: Add any constructor code after initForm call
    }    

    public void formClose(Event e)
    {
        Application.exit();
    }    

    
    void handleADOException(Exception e)
    {
        e.printStackTrace();
        MessageBox.show( e.toString(), "Admis" );
    }

	private void pictureBox4_click(Object source, Event e)
	{
		
	}

	private void Admis_click(Object source, Event e)
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
	Label labelNo_admi = new Label();
	Edit editNo_admi = new Edit();
	Label labelDate = new Label();
	Edit editDate_exeat = new Edit();
	Label labelRef_titul = new Label();
	Edit editRef_titul = new Edit();
	Label labelRef_dossier = new Label();
	Edit editRef_dossier = new Edit();
	Label labelChambre = new Label();
	Edit editChambre = new Edit();
	Label labelDoc_trait_1 = new Label();
	Edit editDoc_trait_1 = new Edit();
	Label labelDoc_trait_2 = new Label();
	Edit editDoc_trait_2 = new Edit();
	Label labelDoc_trait_3 = new Label();
	Edit editDoc_trait_3 = new Edit();
	Label labelNb_jours = new Label();
	Edit nif2 = new Edit();
	Label labelDate_exeat = new Label();
	Edit editDate = new Edit();
	Label labelCredit_patient = new Label();
	Edit editCredit_patient = new Edit();
	Button btnAdd = new Button();
	Button btnUpdate = new Button();
	Button btnClose = new Button();
	Panel panel1 = new Panel();
	ComboBox jour = new ComboBox();
	ComboBox mois = new ComboBox();
	Edit an = new Edit();
	ComboBox jour1 = new ComboBox();
	ComboBox mois1 = new ComboBox();
	Edit an1 = new Edit();
	PictureBox pictureBox1 = new PictureBox();
	Panel panel2 = new Panel();
	Label label1 = new Label();
	Label label2 = new Label();
	Label label4 = new Label();
	Edit edit1 = new Edit();
	Edit edit2 = new Edit();
	Edit edit3 = new Edit();
	Label label7 = new Label();
	PictureBox pictureBox4 = new PictureBox();
	PictureBox pictureBox3 = new PictureBox();
	PictureBox pictureBox2 = new PictureBox();
	Edit n1 = new Edit();
	Edit p1 = new Edit();
	Label label3 = new Label();
	Label label5 = new Label();
	Label label6 = new Label();

	private void initForm()
	{
		// REMARQUE : cette feuille stocke des informations sur les ressources
		// dans un fichier externe. Ne modifiez le paramètre de chaîne d'aucun
		// appel de fonction resources.getObject(). Par exemple,
		// ne modifiez pas "foo1_location" dans la ligne de code
		// suivante, même si le nom de l'objet Foo change : 
		//	 foo1.setLocation((Point)resources.getObject("foo1_location"));

		IResourceManager resources = new ResourceManager(this, "Admis");
		this.setLocation(new Point(7, 7));
		this.setText("Admission d\'un Patient Assuré");
		this.setAutoScaleBaseSize(new Point(5, 13));
		this.setAutoScroll(true);
		this.setBorderStyle(FormBorderStyle.NONE);
		this.setClientSize(new Point(506, 437));
		this.setMaximizeBox(false);
		this.setStartPosition(FormStartPosition.CENTER_SCREEN);
		this.addOnClick(new EventHandler(this.Admis_click));

		dataSource1.setConnectionString("Provider=MSDASQL.1;Persist Security Info=False;Extended Properties=\"dsn=HAH;uid=genial;DBQ=C:\\ASSURE.MDB\";Initial Catalog=C:\\ASSURE");
		dataSource1.setCommandText("select No_admi, Date, Ref_titul,Nifp, Ref_dossier, Chambre, Doc_trait_1, Doc_trait_2, Doc_trait_3, Date_exeat, Credit_patient from Admission ORDER by No_admi");
		dataSource1.setSort(null);
		dataSource1.setStayInSync(true);
		dataSource1.setUserId(null);
		dataSource1.setPassword(null);
		/* @designTimeOnly dataSource1.setLocation(new Point(104, 40)); */

		labelNo_admi.setBackColor(Color.CONTROL);
		labelNo_admi.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNo_admi.setLocation(new Point(48, 92));
		labelNo_admi.setSize(new Point(152, 20));
		labelNo_admi.setTabIndex(23);
		labelNo_admi.setTabStop(false);
		labelNo_admi.setText("No de l\'Admission");
		labelNo_admi.setBorderStyle(BorderStyle.FIXED_3D);

		editNo_admi.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editNo_admi.setEnabled(false);
		editNo_admi.setLocation(new Point(208, 88));
		editNo_admi.setSize(new Point(120, 20));
		editNo_admi.setTabIndex(24);
		editNo_admi.setText("67");
		editNo_admi.setReadOnly(true);

		labelDate.setBackColor(Color.CONTROL);
		labelDate.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelDate.setLocation(new Point(48, 128));
		labelDate.setSize(new Point(152, 20));
		labelDate.setTabIndex(25);
		labelDate.setTabStop(false);
		labelDate.setText("Date de L\'admission");
		labelDate.setBorderStyle(BorderStyle.FIXED_3D);

		editDate_exeat.setLocation(new Point(376, 320));
		editDate_exeat.setSize(new Point(16, 20));
		editDate_exeat.setTabIndex(17);
		editDate_exeat.setText("2003-11-04 00:00:00");
		editDate_exeat.setVisible(false);
		editDate_exeat.setMaxLength(10);

		labelRef_titul.setBackColor(Color.CONTROL);
		labelRef_titul.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelRef_titul.setLocation(new Point(48, 152));
		labelRef_titul.setSize(new Point(152, 20));
		labelRef_titul.setTabIndex(26);
		labelRef_titul.setTabStop(false);
		labelRef_titul.setText("NIF du 1er Titulaire");
		labelRef_titul.setBorderStyle(BorderStyle.FIXED_3D);

		editRef_titul.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRef_titul.setFont(new Font("MS Sans Serif", 10.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		editRef_titul.setForeColor(Color.AQUA);
		editRef_titul.setLocation(new Point(208, 152));
		editRef_titul.setSize(new Point(120, 23));
		editRef_titul.setTabIndex(14);
		editRef_titul.setText("219122");
		editRef_titul.setCharacterCasing(CharacterCasing.UPPER);
		editRef_titul.setMaxLength(13);
		editRef_titul.setReadOnly(true);

		labelRef_dossier.setBackColor(Color.CONTROL);
		labelRef_dossier.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelRef_dossier.setLocation(new Point(48, 201));
		labelRef_dossier.setSize(new Point(152, 20));
		labelRef_dossier.setTabIndex(27);
		labelRef_dossier.setTabStop(false);
		labelRef_dossier.setText("No de Dossier du Patient");
		labelRef_dossier.setBorderStyle(BorderStyle.FIXED_3D);

		editRef_dossier.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editRef_dossier.setLocation(new Point(208, 200));
		editRef_dossier.setSize(new Point(168, 20));
		editRef_dossier.setTabIndex(4);
		editRef_dossier.setText("219122");

		labelChambre.setBackColor(Color.CONTROL);
		labelChambre.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelChambre.setLocation(new Point(48, 225));
		labelChambre.setSize(new Point(152, 20));
		labelChambre.setTabIndex(28);
		labelChambre.setTabStop(false);
		labelChambre.setText("No de la Chambre");
		labelChambre.setBorderStyle(BorderStyle.FIXED_3D);

		editChambre.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editChambre.setLocation(new Point(208, 225));
		editChambre.setSize(new Point(109, 20));
		editChambre.setTabIndex(5);
		editChambre.setText("119");

		labelDoc_trait_1.setBackColor(Color.CONTROL);
		labelDoc_trait_1.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelDoc_trait_1.setLocation(new Point(48, 249));
		labelDoc_trait_1.setSize(new Point(152, 20));
		labelDoc_trait_1.setTabIndex(29);
		labelDoc_trait_1.setTabStop(false);
		labelDoc_trait_1.setText("Docteur 1");
		labelDoc_trait_1.setBorderStyle(BorderStyle.FIXED_3D);

		editDoc_trait_1.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editDoc_trait_1.setLocation(new Point(208, 249));
		editDoc_trait_1.setSize(new Point(216, 20));
		editDoc_trait_1.setTabIndex(6);
		editDoc_trait_1.setText("Jean Robert Charles");
		editDoc_trait_1.setMaxLength(50);

		labelDoc_trait_2.setBackColor(Color.CONTROL);
		labelDoc_trait_2.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelDoc_trait_2.setLocation(new Point(48, 273));
		labelDoc_trait_2.setSize(new Point(152, 20));
		labelDoc_trait_2.setTabIndex(30);
		labelDoc_trait_2.setTabStop(false);
		labelDoc_trait_2.setText("Docteur 2");
		labelDoc_trait_2.setBorderStyle(BorderStyle.FIXED_3D);

		editDoc_trait_2.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editDoc_trait_2.setLocation(new Point(208, 273));
		editDoc_trait_2.setSize(new Point(216, 20));
		editDoc_trait_2.setTabIndex(7);
		editDoc_trait_2.setText("");
		editDoc_trait_2.setMaxLength(50);

		labelDoc_trait_3.setBackColor(Color.CONTROL);
		labelDoc_trait_3.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelDoc_trait_3.setLocation(new Point(48, 297));
		labelDoc_trait_3.setSize(new Point(152, 20));
		labelDoc_trait_3.setTabIndex(31);
		labelDoc_trait_3.setTabStop(false);
		labelDoc_trait_3.setText("Docteur 3");
		labelDoc_trait_3.setBorderStyle(BorderStyle.FIXED_3D);

		editDoc_trait_3.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editDoc_trait_3.setLocation(new Point(208, 297));
		editDoc_trait_3.setSize(new Point(216, 20));
		editDoc_trait_3.setTabIndex(8);
		editDoc_trait_3.setText("");
		editDoc_trait_3.setMaxLength(50);

		labelNb_jours.setBackColor(Color.CONTROL);
		labelNb_jours.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelNb_jours.setLocation(new Point(48, 176));
		labelNb_jours.setSize(new Point(152, 20));
		labelNb_jours.setTabIndex(32);
		labelNb_jours.setTabStop(false);
		labelNb_jours.setText("NIF du  2me  Titulaire");
		labelNb_jours.setBorderStyle(BorderStyle.FIXED_3D);

		nif2.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		nif2.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		nif2.setForeColor(new Color(0, 0, 128));
		nif2.setLocation(new Point(208, 176));
		nif2.setSize(new Point(120, 20));
		nif2.setTabIndex(15);
		nif2.setText("");
		nif2.setMaxLength(13);
		nif2.setReadOnly(true);

		labelDate_exeat.setBackColor(Color.CONTROL);
		labelDate_exeat.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelDate_exeat.setLocation(new Point(48, 320));
		labelDate_exeat.setSize(new Point(152, 20));
		labelDate_exeat.setTabIndex(33);
		labelDate_exeat.setTabStop(false);
		labelDate_exeat.setText("Date d\'Exeat");
		labelDate_exeat.setBorderStyle(BorderStyle.FIXED_3D);

		editDate.setLocation(new Point(376, 128));
		editDate.setSize(new Point(16, 20));
		editDate.setTabIndex(18);
		editDate.setText("2003-10-27 00:00:00");
		editDate.setVisible(false);
		editDate.setMaxLength(50);

		labelCredit_patient.setBackColor(Color.CONTROL);
		labelCredit_patient.setFont(new Font("MS Sans Serif", 8.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		labelCredit_patient.setLocation(new Point(48, 344));
		labelCredit_patient.setSize(new Point(152, 20));
		labelCredit_patient.setTabIndex(34);
		labelCredit_patient.setTabStop(false);
		labelCredit_patient.setText("Credit du patient");
		labelCredit_patient.setBorderStyle(BorderStyle.FIXED_3D);

		editCredit_patient.setAnchor(ControlAnchor.TOPLEFTRIGHT);
		editCredit_patient.setLocation(new Point(208, 344));
		editCredit_patient.setSize(new Point(168, 20));
		editCredit_patient.setTabIndex(12);
		editCredit_patient.setText("0");

		dataBinder1.setDataSource(dataSource1);
		dataBinder1.setDataMember("");
		dataBinder1.setBindings(new DataBinding[] {
								new DataBinding(editNo_admi, "Text", "No_admi", null), 
								new DataBinding(editRef_titul, "Text", "Ref_titul", null), 
								new DataBinding(nif2, "Text", "Nifp", null), 
								new DataBinding(editRef_dossier, "Text", "Ref_dossier", null), 
								new DataBinding(editChambre, "Text", "Chambre", null), 
								new DataBinding(editDoc_trait_1, "Text", "Doc_trait_1", null), 
								new DataBinding(editDoc_trait_2, "Text", "Doc_trait_2", null), 
								new DataBinding(editDoc_trait_3, "Text", "Doc_trait_3", null), 
								new DataBinding(editCredit_patient, "Text", "Credit_patient", null), 
								new DataBinding(editDate, "Text", "Date", null), 
								new DataBinding(editDate_exeat, "Text", "Date_exeat", null)});
		/* @designTimeOnly dataBinder1.setLocation(new Point(280, 48)); */

		btnAdd.setLocation(new Point(24, 4));
		btnAdd.setSize(new Point(70, 20));
		btnAdd.setTabIndex(0);
		btnAdd.setText("&Nouveau");
		btnAdd.addOnClick(new EventHandler(this.btnAdd_Click));

		btnUpdate.setLocation(new Point(200, 4));
		btnUpdate.setSize(new Point(70, 20));
		btnUpdate.setTabIndex(1);
		btnUpdate.setText("&Enregistrer");
		btnUpdate.addOnClick(new EventHandler(this.btnUpdate_Click));

		btnClose.setLocation(new Point(336, 5));
		btnClose.setSize(new Point(70, 20));
		btnClose.setTabIndex(2);
		btnClose.setText("&Fermer");
		btnClose.addOnClick(new EventHandler(this.btnClose_Click));

		panel1.setBackColor(new Color(0, 192, 192));
		panel1.setDock(ControlDock.BOTTOM);
		panel1.setLocation(new Point(0, 397));
		panel1.setSize(new Point(506, 40));
		panel1.setTabIndex(35);
		panel1.setText("");
		panel1.setBorderStyle(BorderStyle.FIXED_3D);

		jour.setLocation(new Point(208, 128));
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

		mois.setLocation(new Point(264, 128));
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

		an.setLocation(new Point(312, 128));
		an.setSize(new Point(40, 20));
		an.setTabIndex(3);
		an.setText("");
		an.setMaxLength(2);

		jour1.setLocation(new Point(208, 320));
		jour1.setSize(new Point(48, 21));
		jour1.setTabIndex(9);
		jour1.setText("Le Jour");
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

		mois1.setLocation(new Point(262, 320));
		mois1.setSize(new Point(48, 21));
		mois1.setTabIndex(10);
		mois1.setText("Le Mois");
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

		an1.setLocation(new Point(315, 320));
		an1.setSize(new Point(40, 20));
		an1.setTabIndex(11);
		an1.setText("");
		an1.setMaxLength(2);

		pictureBox1.setLocation(new Point(12, 1));
		pictureBox1.setSize(new Point(88, 80));
		pictureBox1.setTabIndex(38);
		pictureBox1.setTabStop(false);
		pictureBox1.setText("pictureBox1");
		pictureBox1.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox1.setImage((Bitmap)resources.getObject("pictureBox1_image"));
		pictureBox1.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		panel2.setLocation(new Point(12, 85));
		panel2.setSize(new Point(472, 288));
		panel2.setTabIndex(36);
		panel2.setText("panel2");
		panel2.setBorderStyle(BorderStyle.FIXED_3D);

		label1.setBackColor(new Color(255, 255, 192));
		label1.setFont(new Font("Verdana", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		label1.setForeColor(Color.AQUA);
		label1.setLocation(new Point(134, 5));
		label1.setSize(new Point(272, 24));
		label1.setTabIndex(37);
		label1.setTabStop(false);
		label1.setText("Inscription d\'une Admission");
		label1.setBorderStyle(BorderStyle.FIXED_3D);
		label1.setTextAlign(HorizontalAlignment.CENTER);

		label2.setLocation(new Point(208, 112));
		label2.setSize(new Point(144, 16));
		label2.setTabIndex(22);
		label2.setTabStop(false);
		label2.setText(" JOUR        MOIS       ANNEE");
		label2.setBorderStyle(BorderStyle.FIXED_SINGLE);

		label4.setBackColor(Color.YELLOW);
		label4.setForeColor(Color.BLACK);
		label4.setLocation(new Point(332, 88));
		label4.setSize(new Point(24, 16));
		label4.setTabIndex(21);
		label4.setTabStop(false);
		label4.setText("Auto");
		label4.setTextAlign(HorizontalAlignment.CENTER);

		edit1.setLocation(new Point(232, 56));
		edit1.setSize(new Point(16, 20));
		edit1.setTabIndex(39);
		edit1.setText("edit1");
		edit1.setVisible(false);

		edit2.setLocation(new Point(208, 56));
		edit2.setSize(new Point(16, 20));
		edit2.setTabIndex(41);
		edit2.setText("edit2");
		edit2.setVisible(false);

		edit3.setLocation(new Point(256, 56));
		edit3.setSize(new Point(16, 20));
		edit3.setTabIndex(40);
		edit3.setText("edit3");
		edit3.setVisible(false);

		label7.setBackColor(Color.AQUA);
		label7.setForeColor(Color.WHITE);
		label7.setLocation(new Point(330, 258));
		label7.setSize(new Point(24, 16));
		label7.setTabIndex(0);
		label7.setTabStop(false);
		label7.setText("Num");
		label7.setTextAlign(HorizontalAlignment.CENTER);

		pictureBox4.setLocation(new Point(102, 2));
		pictureBox4.setSize(new Point(336, 32));
		pictureBox4.setTabIndex(0);
		pictureBox4.setTabStop(false);
		pictureBox4.setText("pictureBox2");
		pictureBox4.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox4.setImage((Bitmap)resources.getObject("pictureBox4_image"));
		pictureBox4.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);
		pictureBox4.addOnClick(new EventHandler(this.pictureBox4_click));

		pictureBox3.setLocation(new Point(20, 92));
		pictureBox3.setSize(new Point(16, 272));
		pictureBox3.setTabIndex(16);
		pictureBox3.setTabStop(false);
		pictureBox3.setText("pictureBox2");
		pictureBox3.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox3.setImage((Bitmap)resources.getObject("pictureBox3_image"));
		pictureBox3.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		pictureBox2.setLocation(new Point(462, 96));
		pictureBox2.setSize(new Point(16, 272));
		pictureBox2.setTabIndex(13);
		pictureBox2.setTabStop(false);
		pictureBox2.setText("pictureBox2");
		pictureBox2.setBorderStyle(BorderStyle.FIXED_3D);
		pictureBox2.setImage((Bitmap)resources.getObject("pictureBox2_image"));
		pictureBox2.setSizeMode(PictureBoxSizeMode.STRETCH_IMAGE);

		n1.setLocation(new Point(383, 40));
		n1.setSize(new Point(32, 20));
		n1.setTabIndex(45);
		n1.setText("");
		n1.setVisible(false);

		p1.setLocation(new Point(424, 40));
		p1.setSize(new Point(24, 20));
		p1.setTabIndex(44);
		p1.setText("");
		p1.setVisible(false);

		label3.setFont(new Font("MS Serif", 7.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		label3.setForeColor(new Color(192, 0, 0));
		label3.setLocation(new Point(343, 93));
		label3.setSize(new Point(96, 16));
		label3.setTabIndex(1);
		label3.setTabStop(false);
		label3.setText(" Double Assurance");

		label5.setBackColor(Color.YELLOW);
		label5.setForeColor(Color.BLACK);
		label5.setLocation(new Point(330, 154));
		label5.setSize(new Point(24, 16));
		label5.setTabIndex(20);
		label5.setTabStop(false);
		label5.setText("Auto");
		label5.setTextAlign(HorizontalAlignment.CENTER);

		label6.setBackColor(Color.YELLOW);
		label6.setForeColor(Color.BLACK);
		label6.setLocation(new Point(330, 177));
		label6.setSize(new Point(24, 16));
		label6.setTabIndex(19);
		label6.setTabStop(false);
		label6.setText("Auto");
		label6.setTextAlign(HorizontalAlignment.CENTER);

		this.setNewControls(new Control[] {
							label6, 
							label5, 
							p1, 
							n1, 
							pictureBox2, 
							pictureBox3, 
							editDate_exeat, 
							editDate, 
							edit3, 
							edit2, 
							edit1, 
							label4, 
							label2, 
							label1, 
							pictureBox1, 
							an1, 
							mois1, 
							jour1, 
							an, 
							mois, 
							jour, 
							panel1, 
							labelNo_admi, 
							editNo_admi, 
							labelDate, 
							labelRef_titul, 
							editRef_titul, 
							labelRef_dossier, 
							editRef_dossier, 
							labelChambre, 
							editChambre, 
							labelDoc_trait_1, 
							editDoc_trait_1, 
							labelDoc_trait_2, 
							editDoc_trait_2, 
							labelDoc_trait_3, 
							editDoc_trait_3, 
							labelNb_jours, 
							nif2, 
							labelDate_exeat, 
							labelCredit_patient, 
							editCredit_patient, 
							panel2, 
							pictureBox4});
		panel1.setNewControls(new Control[] {
							  btnAdd, 
							  btnUpdate, 
							  btnClose});
		panel2.setNewControls(new Control[] {
							  label3, 
							  label7});

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
        Application.run( new Admis() );
    }
}
