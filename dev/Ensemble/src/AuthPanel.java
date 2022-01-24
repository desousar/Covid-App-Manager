import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AuthPanel {
	JPanel p = new JPanel();
	
	JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JLabel dbLabel = new JLabel("database port");
    private JTextField userTextField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JTextField dbField = new JTextField();
    
    public AuthPanel() {
		
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		
		JPanel centreLayout = new JPanel();
		centreLayout.setLayout(new FlowLayout(FlowLayout.CENTER,0,50));
		
        JPanel corpsLayout = new JPanel();
        corpsLayout.setLayout(new BoxLayout(corpsLayout, BoxLayout.PAGE_AXIS));
        
        JPanel userLayout = new JPanel();
        userLayout.setLayout(new FlowLayout());
        userLayout.add(userLabel);
        userLayout.add(userTextField);
        userTextField.setColumns(15);
        corpsLayout.add(userLayout);
        
        JPanel pwLayout = new JPanel();
        pwLayout.setLayout(new FlowLayout());
        pwLayout.add(passwordLabel);
        pwLayout.add(passwordField);
        passwordField.setColumns(15);
        corpsLayout.add(pwLayout);
        
        JPanel dbLayout = new JPanel();
        dbLayout.setLayout(new FlowLayout());
        dbLayout.add(dbLabel);
        dbLayout.add(dbField);
        dbField.setColumns(15);
        corpsLayout.add(dbLayout);
        
        centreLayout.add(corpsLayout);
        p.add(centreLayout);
    }
    
    public String getUser() {
		return userTextField.getText().toString();
	}
    @SuppressWarnings("deprecation")
	public String getPW() {
		return passwordField.getText().toString();
	}
    public String getDbPort() {
		return dbField.getText().toString();
	}
    
    public void reset() {
    	userTextField.setText("");
    	passwordField.setText("");
    	dbField.setText("");
    }

	public void add(JButton bouton) {
		p.add(bouton);
	}
	public void addLayout(JPanel layout) {
		p.add(layout);
	}
	
	public JPanel getContenu() {
		return p;
	}
}
