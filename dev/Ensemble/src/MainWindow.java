
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.imageio.ImageIO;

public class MainWindow extends JFrame implements ActionListener
{
    private static final long serialVersionUID = 1L; 
    
    private AuthPanel authPanel;
    private JButton authButton = new JButton("Connect");
    
    public PatientPanel patientPanel;
    private JButton stockViewButton = new JButton("Stock Management"); 
    private StockPanel stockPanel;
    private JButton vaccineViewButton = new JButton("Vaccination Delivery");   
    private StatisticsPanel statPanel;
    private JButton statViewButton = new JButton("Statistics");
    
    public MainWindow() throws IOException
    {
    	
    	//setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("Covid_Vaccines_Manager.png")));
    	BufferedImage image = null;
        try {
            image = ImageIO.read(new File("Covid_Vaccines_Manager-logo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.setIconImage(image);
    	
        this.setTitle("Covid Vaccines Manager");
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
				try {
					DriverManager.getConnection(GlobalDAO.URL, GlobalDAO.LOGIN, GlobalDAO.PASS);
				} catch (Exception ee) {
					ee.printStackTrace();
					this.authPanel.reset();
				}
				
				if(checkAccount(user, hash)) {
					authButton.setText("Loading...");
					this.displayStockView();
				}else {
					this.authPanel.reset();
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
    
    public void displayAuthView() throws IOException {
    	authPanel = new AuthPanel();
    	JPanel buttonLayout = new JPanel();
    	buttonLayout.setOpaque(false);
   	 	buttonLayout.setLayout(new FlowLayout(FlowLayout.CENTER,25,25));
   	 	buttonLayout.add(authButton);
    	authPanel.addLayout(buttonLayout);
       this.setContentPane(this.authPanel.getContenu());
       this.revalidate();
   }
    
    public void displayStockView() throws IOException {
    	 stockPanel = new StockPanel();
    	 JPanel buttonLayout = new JPanel();
    	 buttonLayout.setLayout(new FlowLayout(FlowLayout.CENTER,50,25));
    	 buttonLayout.add(vaccineViewButton);
    	 buttonLayout.add(statViewButton);
    	 stockPanel.addLayout(buttonLayout);
    	 getContentPane().removeAll();
    	 this.setContentPane(this.stockPanel.getContenu());
        getContentPane().revalidate();
        getContentPane().repaint();
    }
    
    public void displayVaccineView() throws IOException {
    	patientPanel = new PatientPanel();
    	JPanel buttonLayout = new JPanel();
   	 	buttonLayout.setLayout(new FlowLayout(FlowLayout.CENTER,50,25));
   	 	buttonLayout.add(stockViewButton);
   	 	buttonLayout.add(statViewButton);
   	 	patientPanel.addLayout(buttonLayout);
    	this.setContentPane(this.patientPanel.getContenu());
        this.revalidate();
    }
    
    public void displayStatsView() throws IOException {
    	statPanel = new StatisticsPanel();
    	JPanel buttonLayout = new JPanel();
   	 	buttonLayout.setLayout(new FlowLayout(FlowLayout.CENTER,50,25));
   	 	buttonLayout.add(vaccineViewButton);
   	 	buttonLayout.add(stockViewButton);
   	 	statPanel.addLayout(buttonLayout);
    	this.setContentPane(this.statPanel);
        this.revalidate();
    }

    public static void main(String[] args) throws IOException
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