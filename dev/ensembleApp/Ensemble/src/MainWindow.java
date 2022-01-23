

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame implements ActionListener
{
    private static final long serialVersionUID = 1L; 
    
    private AuthPanel authPanel;
    private JButton authButton = new JButton("Connect");
    
    public JPanel patientPanel;
    private JButton stockViewButton = new JButton("Stock"); 
    private JPanel stockPanel;
    private JButton vaccineViewButton = new JButton("Vaccination");   
    private JPanel statPanel;
    private JButton statViewButton = new JButton("Statistics");
    
    public MainWindow()
    {
        this.setTitle("Ensemble");
        this.setSize(1000,600);     
    
        authButton.addActionListener(this);
        stockViewButton.addActionListener(this);
        vaccineViewButton.addActionListener(this);
        statViewButton.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        displayAuthView(); //affichage Auth View par défaut
        
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {    
        try {
        	if(ae.getSource()== this.authButton)
			{
				String user = this.authPanel.getUser();
				String hash = generateMD5Hash(this.authPanel.getPW());
				if(checkAccount(user, hash)) {
					this.displayStockView();
				}
			}
        	else if(ae.getSource()== this.stockViewButton)
            {
                this.displayStockView();
            }
        	else if(ae.getSource()==this.vaccineViewButton)
            {
                this.displayVaccineView();
            }
        	else if(ae.getSource()==this.statViewButton)
            {
                this.displayStatsView();
            }
        }
        catch (Exception e) {
            System.err.println("err");
        }
        
    }
    
    public void displayAuthView() {
    	authPanel = new AuthPanel();
    	authPanel.add(authButton);
    	authButton.setBounds(50, 220, 100, 30);
       this.setContentPane(this.authPanel.getContenu());
       this.revalidate();
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
    
    
    /**
	 *  src https://howtodoinjava.com/java/java-security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/
	 * @param passwordToHash
	 * @return generatedPassword
	 */
	public String generateMD5Hash(String passwordToHash ) {
		String generatedPassword = null;
		try 
	    {
	      // Create MessageDigest instance for MD5
	      MessageDigest md = MessageDigest.getInstance("MD5");

	      // Add password bytes to digest
	      md.update(passwordToHash.getBytes());

	      // Get the hash's bytes
	      byte[] bytes = md.digest();

	      // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
	      StringBuilder sb = new StringBuilder();
	      for (int i = 0; i < bytes.length; i++) {
	        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	      }

	      // Get complete hashed password in hex format
	      generatedPassword = sb.toString();
	    } catch (NoSuchAlgorithmException e) {
	      e.printStackTrace();
	    }
		return generatedPassword;
	}
	
	public boolean checkAccount(String user, String pw){
		AuthDAO authDAO = new AuthDAO();	
		return authDAO.findUser(user, pw);
	}
}