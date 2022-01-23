
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ArticleFenetre extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L; 
	public Panel1 containerPanel;
	private JButton boutonEnvoi;
	
	private JPanel containerPanel2;
	private JButton boutonRetour;	
	public ArticleFenetre()
    {
		containerPanel = new Panel1();
		boutonEnvoi = new JButton("envoyer");
		
		containerPanel.add(boutonEnvoi);
		boutonEnvoi.setBounds(50, 220, 100, 30);
		boutonEnvoi.addActionListener(this);
		
		containerPanel2 = new JPanel();
		containerPanel2.setBackground(Color.blue);
		boutonRetour = new JButton("Retour");
		containerPanel2.add(boutonRetour);
		boutonRetour.addActionListener(this);
		
		this.setTitle("Article");
		this.setSize(400,350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(containerPanel.getContenu());
		this.setVisible(true);
	}
	
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent ae)
	{	
		try {
			if(ae.getSource()== this.boutonEnvoi)
			{
				String user = this.containerPanel.userTextField.getText().toString();
				String hash = generateMD5Hash(this.containerPanel.passwordField.getText().toString());
				if(hash.equals("f71dbe52628a3f83a77ab494817525c6") && user.equals("toto")) {
					this.changerView();
				}
			}
			if(ae.getSource()==this.boutonRetour)
			{
				this.changerView2();
			}
		}
		catch (Exception e) {
			System.err.println("Veuillez contrôler vos saisies");
		}
		
	}
	
	public void changerView() {
		this.setContentPane(this.containerPanel2);
		this.revalidate();
	}
	public void changerView2() {
		this.setContentPane(containerPanel.getContenu());
		this.revalidate();
	}

	
	public static void main(String[] args)
	{
		new ArticleFenetre();
    }
	
	/**
	 *  src https://howtodoinjava.com/java/java-security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/
	 * @param passwordToHash
	 * @return
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
		return generatedPassword  ;
	}

}
