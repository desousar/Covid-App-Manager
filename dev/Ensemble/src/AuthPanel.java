import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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
    
    public AuthPanel() throws IOException {
		
		p.setLayout(new BorderLayout());
		
		JPanel titleLayout = new JPanel();
		titleLayout.setOpaque(false);
		titleLayout.setLayout(new BorderLayout());
		BufferedImage myPicture = ImageIO.read(new File("Covid_Vaccines_Manager.png"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		BufferedImage myPicture2 = ImageIO.read(new File("Image2.png"));
		JLabel picLabel2 = new JLabel(new ImageIcon(myPicture2));
		
		JPanel img1 = new JPanel();
		img1.setOpaque(false);
		img1.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		JPanel img2 = new JPanel();
		img2.setOpaque(false);
		img2.setLayout(new FlowLayout(FlowLayout.RIGHT,20,20));
		
		img1.add(picLabel);
		img2.add(picLabel2);
		
		titleLayout.add(img1, BorderLayout.LINE_START);
		titleLayout.add(img2, BorderLayout.LINE_END);
		
		
        JPanel corpsLayout = new JPanel();
        corpsLayout.setOpaque(false);
        corpsLayout.setLayout(new BorderLayout());
        
        JPanel listPane = new JPanel();
        listPane.setOpaque(false);
		listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));
        
        JPanel userLayout = new JPanel();
        userLayout.setOpaque(false);
        userLayout.setLayout(new FlowLayout());
        userLayout.add(userLabel);
        userLayout.add(userTextField);
        userTextField.setColumns(15);
        listPane.add(userLayout);
        
        JPanel pwLayout = new JPanel();
        pwLayout.setOpaque(false);
        pwLayout.setLayout(new FlowLayout());
        pwLayout.add(passwordLabel);
        pwLayout.add(passwordField);
        passwordField.setColumns(15);
        pwLayout.setPreferredSize(null);
        listPane.add(pwLayout);
        
        corpsLayout.add(listPane, BorderLayout.NORTH);
        p.add(titleLayout,BorderLayout.PAGE_START);
        p.add(corpsLayout, BorderLayout.CENTER);

        p.setBackground(new Color(179, 230, 255));
    }
    
    public String getUser() {
		return userTextField.getText().toString();
	}
    @SuppressWarnings("deprecation")
	public String getPW() {
		return passwordField.getText().toString();
	}
    
    public void reset() {
    	userTextField.setText("");
    	passwordField.setText("");
    }

	public void add(JButton bouton) {
		p.add(bouton);
	}
	public void addLayout(JPanel layout) {
		p.add(layout, BorderLayout.PAGE_END);
	}
	
	public JPanel getContenu() {
		return p;
	}
}
