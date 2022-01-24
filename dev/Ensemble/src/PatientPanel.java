import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.text.DefaultFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import models.Patient;

public class PatientPanel implements ActionListener {
			  
		JPanel own = new JPanel();

	    private static PatientDAO patientDAO;
	    private static JTable patientsTable;
	  
	    private JTextField firstname;
	    private JTextField lastname;   
	    private JDatePickerImpl datePicker;
	    private JTextField namevaccine;
	    
	    private JTextField nbrDose;

	    private JButton addRowButton = new JButton("Add");	    
	    private String [] tableColumns = {"Id","First Name","Last Name","Date of birth","Vaccine","Nbrdose"};
	    private JScrollPane scrollPane;
	    private List<Patient> patientList;
	  
	    
	    public PatientPanel() throws IOException {
	    	own.setLayout(new BorderLayout());
	    	
	    	JPanel titleLayout = new JPanel();
			titleLayout.setLayout(new BorderLayout());
			BufferedImage myPicture = ImageIO.read(new File("Image1.png"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			BufferedImage myPicture2 = ImageIO.read(new File("Image2.png"));
			JLabel picLabel2 = new JLabel(new ImageIcon(myPicture2));
			
			JPanel img1 = new JPanel();
			img1.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
			JPanel img2 = new JPanel();
			img2.setLayout(new FlowLayout(FlowLayout.RIGHT,20,20));
			
			img1.add(picLabel);
			img2.add(picLabel2);
			
			titleLayout.add(img1, BorderLayout.LINE_START);
			titleLayout.add(img2, BorderLayout.LINE_END);
	    	
	    	JPanel formpanel = new JPanel();

	    	addRowButton.addActionListener(this);
	    	
	    	initTableData();
	     
	        JLabel firstnamelabel = new JLabel("First Name");
	        firstname = new JTextField(5);
	        firstname.setToolTipText("First name");
	        
	        JLabel lastnamelabel = new JLabel("Last Name");
	        lastname = new JTextField(5);
	        lastname.setToolTipText("Last name");
	        
	        JLabel namevaccinelabel = new JLabel("Vaccine");
	        namevaccine = new JTextField(5);
	        namevaccine.setToolTipText("Vaccine");
	        
	        JLabel nbrDoselabel = new JLabel("Nbrdose");
	        nbrDose = new JTextField(5);
	        nbrDose.setToolTipText("Number of doses");
	        
	        JLabel birthDatelabel = new JLabel("Birth date");
	       
			UtilDateModel calmodel = new UtilDateModel();

			Properties p = new Properties();
			p.put("text.today", "Today");
			p.put("text.month", "Month");
			p.put("text.year", "Year");
			JDatePanelImpl datePanel = new JDatePanelImpl(calmodel, p);
						 
			datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
	  
	       
	        formpanel.add(firstnamelabel);
	        formpanel.add(firstname);
	      
	        formpanel.add(lastnamelabel);
	        formpanel.add(lastname);
	        
	        formpanel.add(birthDatelabel);
	        formpanel.add(datePicker);
	        formpanel.add(namevaccinelabel);
	        formpanel.add(namevaccine);
	        
	        formpanel.add(nbrDoselabel);
	        formpanel.add(nbrDose);
	        
	        formpanel.add(addRowButton);

	        JPanel contenu = new JPanel();
	        contenu.setLayout(new BoxLayout(contenu, BoxLayout.PAGE_AXIS));
	        
	        contenu.add(scrollPane);
	        contenu.add(formpanel);
	        
	        own.add(titleLayout,BorderLayout.PAGE_START);
	        //own.add(scrollPane,BorderLayout.NORTH);	  
	        own.add(contenu,BorderLayout.CENTER);
	      
	    }
	    
	    public Object[][] getPatientsData(){
	    	patientDAO = new PatientDAO();   	
	    	patientList = patientDAO.getListPatients(); 	
	    
	        Object[][] data = new Object[patientList.size()][6];
	        
	        for (int i = 0; i < patientList.size(); i++) {
	            data[i][0] = patientList.get(i).getId();
	            data[i][1] = patientList.get(i).getFirstname();
	            data[i][2] = patientList.get(i).getLastname();
	            data[i][3] = patientList.get(i).getDatebirth().toString();
	            data[i][4] = patientList.get(i).getnamevaccine();
	            data[i][5] = patientList.get(i).getNbrdose();         
	        }
	        return data;
	    }
	    
	    public void updatePatientTable() {
	    	 DefaultTableModel updatedModel = new DefaultTableModel(getPatientsData(),tableColumns);       
		     patientsTable.setModel(updatedModel);
	    }
	    public void initTableData() {
	    	    	
	    	DefaultTableModel model = new DefaultTableModel(getPatientsData(), tableColumns);
	        patientsTable = new JTable(model);
	        scrollPane = new  JScrollPane(patientsTable);	      
	        TableColumnModel colmodel = patientsTable.getColumnModel();        
	        TableColumn col = colmodel.getColumn(5);      	           
	        col.setCellEditor(new SpinnerEditor());  
	       	           
	    }
	    
		@Override
		public void actionPerformed(ActionEvent e) {
			
			//todo: check inputs formatting && sql erroers		
			java.util.Date date = (java.util.Date) datePicker.getModel().getValue();
			java.sql.Date dt = new java.sql.Date(date.getTime());
			patientDAO.addPatient(new Patient(firstname.getText(),lastname.getText(), dt,namevaccine.getText(),Integer.valueOf(nbrDose.getText())));        
			updatePatientTable();
	 
		}  
		
		public class DateLabelFormatter extends AbstractFormatter {

	        /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private String datePattern = "yyyy-MM-dd";
	        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

	        @Override
	        public Object stringToValue(String text) throws ParseException {
	            return dateFormatter.parseObject(text);
	        }

	        @Override
	        public String valueToString(Object value) throws ParseException {
	            if (value != null) {
	                Calendar cal = (Calendar) value;
	                return dateFormatter.format(cal.getTime());
	            }

	            return "";
	        }

	    }
	    
	    public static class SpinnerEditor extends DefaultCellEditor
	    {
	        
			private static final long serialVersionUID = 1L;
			JSpinner sp;		
			int selected_row;
	        DefaultEditor defaultEditor;
	        JTextField text;
	                
	        public SpinnerEditor() {
	        	
	            super(new JTextField());
	            sp = new JSpinner();
	            JComponent comp = sp.getEditor();
	            JFormattedTextField field = (JFormattedTextField) comp.getComponent(0);
	            DefaultFormatter formatter = (DefaultFormatter) field.getFormatter();
	            formatter.setCommitsOnValidEdit(true);
	            sp.addChangeListener(new ChangeListener() {

	                @Override
	                public void stateChanged(ChangeEvent e) {          	
	                	patientDAO.updatePatientDose((int)patientsTable.getModel().getValueAt(selected_row, 0),(int)sp.getValue());
	                }
	            });
	                
	            defaultEditor = ((DefaultEditor)sp.getEditor());
	            text = defaultEditor.getTextField();
	        }
	   
	        public Component getTableCellEditorComponent(JTable table, Object 
	        value, boolean isSelected, int row, int column) 
	        {
	        	selected_row = row;
	            sp.setValue(value);    
	            return sp;
	        }
	       
	        public Object getCellEditorValue() {
	            return sp.getValue();
	        }
	    }
			
	    public void add(JButton boutonEnvoi) {
			own.add(boutonEnvoi);
		}
		public void addLayout(JPanel layout) {
			own.add(layout, BorderLayout.PAGE_END);
		}
		public JPanel getContenu() {
			return own;
		}
		
}

