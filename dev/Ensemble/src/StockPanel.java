import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StockPanel implements ActionListener{
	JPanel p = new JPanel();
	
	JLabel matmanage = new JLabel("Material management");
	
	JLabel vaccLabel = new JLabel("Vaccine");
	JLabel vaccAmountLabel = new JLabel("00000");
	JButton vaccAddButton = new JButton("Add");
	JButton vaccDelButton = new JButton("Delete");
	JTextField vaccTextField = new JTextField();
	
	JLabel gelLabel = new JLabel("Gel");
	JLabel gelAmountLabel = new JLabel("00000");
	JButton gelAddButton = new JButton("Add");
	JButton gelDelButton = new JButton("Delete");
	JTextField gelTextField = new JTextField();
	
	JLabel maskLabel = new JLabel("Mask");
	JLabel maskAmountLabel = new JLabel("00000");
	JButton maskAddButton = new JButton("Add");
	JButton maskDelButton = new JButton("Delete");
	JTextField maskTextField = new JTextField();
	
	JLabel glovesLabel = new JLabel("Gloves");
	JLabel glovesAmountLabel = new JLabel("00000");
	JButton glovesAddButton = new JButton("Add");
	JButton glovesDelButton = new JButton("Delete");
	JTextField glovesTextField = new JTextField();
	
	JLabel gownLabel = new JLabel("Gown");
	JLabel gownAmountLabel = new JLabel("00000");
	JButton gownAddButton = new JButton("Add");
	JButton gownDelButton = new JButton("Delete");
	JTextField gownTextField = new JTextField();
	
    public StockPanel() throws IOException {
		p.setLayout(new BorderLayout());
		StockDAO stockDAO = new StockDAO();	
		
		
		JPanel titleLayout = new JPanel();
		titleLayout.setLayout(new BorderLayout());
		BufferedImage myPicture = ImageIO.read(new File("Covid_Vaccines_Manager.png"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		BufferedImage myPicture2 = ImageIO.read(new File("Image2.png"));
		JLabel picLabel2 = new JLabel(new ImageIcon(myPicture2));
		
		JPanel img1 = new JPanel();
		img1.setLayout(new FlowLayout(FlowLayout.LEFT,20,0));
		JPanel img2 = new JPanel();
		img2.setLayout(new FlowLayout(FlowLayout.RIGHT,20,20));
		
		img1.add(picLabel);
		img2.add(picLabel2);
		
		titleLayout.add(img1, BorderLayout.LINE_START);
		titleLayout.add(img2, BorderLayout.LINE_END);
		 
		JPanel listPane = new JPanel();
		listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));
		
		JPanel littletitleLayout = new JPanel();
		littletitleLayout.setLayout(new FlowLayout(FlowLayout.CENTER,0,20));
		littletitleLayout.add(matmanage);
		matmanage.setFont(new Font(matmanage.getFont().getName(), Font.PLAIN, 40));
		
		JPanel corpsLayout = new JPanel();
		corpsLayout.setLayout(new GridLayout(1,2));
		
        JPanel col1Layout = new JPanel();
        col1Layout.setLayout(new GridLayout(5,1));
		
        JPanel vaccLayout = new JPanel();
        vaccLayout.setLayout(new FlowLayout());
        vaccLayout.add(vaccLabel);
		vaccLayout.add(vaccAmountLabel);
		col1Layout.add(vaccLayout);
        
		JPanel gelLayout = new JPanel();
        gelLayout.setLayout(new FlowLayout());
        gelLayout.add(gelLabel);
        gelLayout.add(gelAmountLabel);
        col1Layout.add(gelLayout);
        
        JPanel maskLayout = new JPanel();
        maskLayout.setLayout(new FlowLayout());
        maskLayout.add(maskLabel);
        maskLayout.add(maskAmountLabel);
        col1Layout.add(maskLayout);
        
        JPanel glovesLayout = new JPanel();
        glovesLayout.setLayout(new FlowLayout());
        glovesLayout.add(glovesLabel);
        glovesLayout.add(glovesAmountLabel);
        col1Layout.add(glovesLayout);
        
        JPanel gownLayout = new JPanel();
        gownLayout.setLayout(new FlowLayout());
        gownLayout.add(gownLabel);
        gownLayout.add(gownAmountLabel);
        col1Layout.add(gownLayout);
        
        
        JPanel col2Layout = new JPanel();
        col2Layout.setLayout(new GridLayout(5,1));
        
        JPanel vacc2Layout = new JPanel();
        vacc2Layout.setLayout(new FlowLayout());
		vaccTextField.setColumns(5);
		vacc2Layout.add(vaccAddButton);
		vacc2Layout.add(vaccTextField);
		vacc2Layout.add(vaccDelButton);
        int vacc = stockDAO.getStockOf("vaccine");
        vaccAmountLabel.setText(String.valueOf(vacc));
        vaccAddButton.addActionListener(this);
        vaccDelButton.addActionListener(this);
        col2Layout.add(vacc2Layout);
        
        JPanel gel2Layout = new JPanel();
        gel2Layout.setLayout(new FlowLayout());
        gelTextField.setColumns(5);
        gel2Layout.add(gelAddButton);
        gel2Layout.add(gelTextField);
        gel2Layout.add(gelDelButton);
        int gel = stockDAO.getStockOf("gel");
        gelAmountLabel.setText(String.valueOf(gel));
        gelAddButton.addActionListener(this);
        gelDelButton.addActionListener(this);
        col2Layout.add(gel2Layout);
        
        JPanel mask2Layout = new JPanel();
        mask2Layout.setLayout(new FlowLayout());
        maskTextField.setColumns(5);
        mask2Layout.add(maskAddButton);
        mask2Layout.add(maskTextField);
        mask2Layout.add(maskDelButton);
        int mask = stockDAO.getStockOf("mask");
        maskAmountLabel.setText(String.valueOf(mask));
        maskAddButton.addActionListener(this);
        maskDelButton.addActionListener(this);
        col2Layout.add(mask2Layout);
        
        JPanel gloves2Layout = new JPanel();
        gloves2Layout.setLayout(new FlowLayout());
        glovesTextField.setColumns(5);
        gloves2Layout.add(glovesAddButton);
        gloves2Layout.add(glovesTextField);
        gloves2Layout.add(glovesDelButton);
        int gloves = stockDAO.getStockOf("gloves");
        glovesAmountLabel.setText(String.valueOf(gloves));
        glovesAddButton.addActionListener(this);
        glovesDelButton.addActionListener(this);
        col2Layout.add(gloves2Layout);
        
        JPanel gown2Layout = new JPanel();
        gown2Layout.setLayout(new FlowLayout());
        gownTextField.setColumns(5);
        gown2Layout.add(gownAddButton);
        gown2Layout.add(gownTextField);
        gown2Layout.add(gownDelButton);
        int gown = stockDAO.getStockOf("gown");
        gownAmountLabel.setText(String.valueOf(gown));
        gownAddButton.addActionListener(this);
        gownDelButton.addActionListener(this);
        col2Layout.add(gown2Layout);
        
        corpsLayout.add(col1Layout);
        corpsLayout.add(col2Layout);
        
        listPane.add(littletitleLayout);
        listPane.add(corpsLayout);
        
        p.add(titleLayout,BorderLayout.PAGE_START);
        p.add(listPane,BorderLayout.CENTER);
    }
    
	public void add(JButton boutonEnvoi) {
		p.add(boutonEnvoi);
	}
	public void addLayout(JPanel layout) {
		p.add(layout, BorderLayout.PAGE_END);
	}
	public JPanel getContenu() {
		return p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		StockDAO stockDAO = new StockDAO();
		if(e.getSource() == vaccAddButton || e.getSource() == vaccDelButton) {
			int amount = Integer.valueOf(vaccTextField.getText().toString());
			if(e.getSource() == vaccDelButton) {
				amount*=-1;
			}
			stockDAO.setStockOf("vaccine", amount);
			int vacc = stockDAO.getStockOf("vaccine");
	        vaccAmountLabel.setText(String.valueOf(vacc));
	        vaccTextField.setText("");
		}
		else if(e.getSource() == gelAddButton || e.getSource() == gelDelButton) {
			int amount = Integer.valueOf(gelTextField.getText().toString());
			if(e.getSource() == gelDelButton) {
				amount*=-1;
			}
			stockDAO.setStockOf("gel", amount);
			int gel = stockDAO.getStockOf("gel");
			gelAmountLabel.setText(String.valueOf(gel));
			gelTextField.setText("");
		}
		else if(e.getSource() == maskAddButton || e.getSource() == maskDelButton) {
			int amount = Integer.valueOf(maskTextField.getText().toString());
			if(e.getSource() == maskDelButton) {
				amount*=-1;
			}
			stockDAO.setStockOf("mask", amount);
			int mask = stockDAO.getStockOf("mask");
			maskAmountLabel.setText(String.valueOf(mask));
			maskTextField.setText("");
		}
		else if(e.getSource() == glovesAddButton || e.getSource() == glovesDelButton) {
			int amount = Integer.valueOf(glovesTextField.getText().toString());
			if(e.getSource() == glovesDelButton) {
				amount*=-1;
			}
			stockDAO.setStockOf("gloves", amount);
			int gloves = stockDAO.getStockOf("gloves");
			glovesAmountLabel.setText(String.valueOf(gloves));
			glovesTextField.setText("");
		}
		else if(e.getSource() == gownAddButton || e.getSource() == gownDelButton) {
			int amount = Integer.valueOf(gownTextField.getText().toString());
			if(e.getSource() == gownDelButton) {
				amount*=-1;
			}
			stockDAO.setStockOf("gown", amount);
			int gown = stockDAO.getStockOf("gown");
			gownAmountLabel.setText(String.valueOf(gown));
			gownTextField.setText("");
		}
	}
}
