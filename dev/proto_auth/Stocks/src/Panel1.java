import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Panel1{

	JPanel p = new JPanel();
	
	JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
	
	public Panel1() {
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
	
	public String getPW() {
		return passwordField.toString();
	}

	public void add(JButton boutonEnvoi) {
		p.add(boutonEnvoi);
	}
	
	public JPanel getContenu() {
		return p;
	}
}
