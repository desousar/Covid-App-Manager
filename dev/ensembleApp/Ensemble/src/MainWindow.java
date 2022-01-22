

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame implements ActionListener
{
    private static final long serialVersionUID = 1L; 
    
    public JPanel patientPanel;
    private JButton stockViewButton = new JButton("Stock"); 
    private JPanel stockPanel;
    private JButton vaccineViewButton = new JButton("Vaccination");   
    private JPanel statPanel;
    private JButton statViewButton = new JButton("Statistics");
    
    public MainWindow()
    {
        this.setTitle("Ensemble");
        this.setSize(600,600);     
    
        stockViewButton.addActionListener(this);
        vaccineViewButton.addActionListener(this);
        statViewButton.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        displayStockView(); //affichage stock view par défaut
        
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {    
        try {
            if(ae.getSource()== this.stockViewButton)
            {
                this.displayStockView();
            }
            if(ae.getSource()==this.vaccineViewButton)
            {
                this.displayVaccineView();
            }
            if(ae.getSource()==this.statViewButton)
            {
                this.displayStatsView();
            }
        }
        catch (Exception e) {
            System.err.println("err");
        }
        
    }
    
    public void displayStockView() {
    	 stockPanel = new StockPanel();
         stockPanel.add(vaccineViewButton);
         stockPanel.add(statViewButton);
        this.setContentPane(this.stockPanel);
        this.revalidate();
    }
    
    public void displayVaccineView() {
    	patientPanel = new PatientPanel();
    	patientPanel.add(stockViewButton);
    	patientPanel.add(statViewButton);
    	this.setContentPane(this.patientPanel);
        this.revalidate();
    }
    
    public void displayStatsView() {
    	statPanel = new StatisticsPanel();
    	statPanel.add(vaccineViewButton);
    	statPanel.add(stockViewButton);
    	
    	this.setContentPane(this.statPanel);
        this.revalidate();
    }

    public static void main(String[] args)
    {
        new MainWindow();
    }
}