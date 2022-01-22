import java.awt.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import models.Patient;

public class PatientPanel extends JPanel {
			  
	    private static final long serialVersionUID = 1L;
	    private static PatientDAO patientDAO;
	    
	    private List<String> tableColumns = Arrays.asList("id","First Name","Last Name","Date of birth","Vaccine","Nbrdose");
	    private List<Patient> patientList;
	    
	    public PatientPanel() {
	    	
	    	patientDAO = new PatientDAO();	
	    	patientList = patientDAO.getListPatients();
	      
	        this.setBackground(Color.darkGray);
	  
	        List<Object[]> data = new ArrayList<Object[]>();
	        
	        for (int i = 0; i < patientList.size(); i++) {
	            Object[] value = new Object[6];
	            value[0] = String.valueOf(patientList.get(i).getId());
	            value[1] = patientList.get(i).getFirstname();
	            value[2] = patientList.get(i).getLastname();
	            value[3] = patientList.get(i).getDatebirth().toString();
	            value[4] = patientList.get(i).getnamevaccine();
	            value[5] = String.valueOf(patientList.get(i).getNbrdose());
	            data.add(value);
	        }
	        
	        JTable table = new JTable(new PatientTableModel(tableColumns,data));
	        table.setShowGrid(true);
	        table.setShowVerticalLines(true);
	        JScrollPane pane = new JScrollPane(table);
	        this.add(pane);  
	        this.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));        
	    }
	    
	    public static class PatientTableModel extends AbstractTableModel {

			private static final long serialVersionUID = 1L;
				private List<Object[]> data;
		        private List<String> columnNames;

		        public PatientTableModel(List<String> columnNames, List<Object[]> data) {
		            super();
		            this.columnNames = columnNames;
		            this.data = data;
		        }

		        @Override
		        public int getRowCount() {
		            return data.size();
		        }

		        @Override
		        public int getColumnCount() {
		            return columnNames.size();
		        }

		        @Override
		        public String getColumnName(int column) {
		            return columnNames.get(column);
		        }

		        @Override
		        public Object getValueAt(int rowIndex, int columnIndex) {
		            return data.get(rowIndex)[columnIndex];
		        }

		    }    
}

