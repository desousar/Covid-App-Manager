import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AuthPanel {
	JPanel p = new JPanel();
	
	JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    private JTextField userTextField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    
    public AuthPanel() {
    	p.setBackground(Color.PINK);
		
		p.setLayout(null);
		userLabel.setBounds(50, 100, 100, 30);
        passwordLabel.setBounds(50, 170, 100, 30);
        userTextField.setBounds(150, 100, 150, 30);
        passwordField.setBounds(150, 170, 150, 30);
		
        p.add(userLabel);
        p.add(passwordLabel);
        p.add(userTextField);
        p.add(passwordField);
    }
    
    public String getUser() {
		return userTextField.getText().toString();
	}
    @SuppressWarnings("deprecation")
	public String getPW() {
		return passwordField.getText().toString();
	}

	public void add(JButton boutonEnvoi) {
		p.add(boutonEnvoi);
	}
	
	public JPanel getContenu() {
		return p;
	}
}
