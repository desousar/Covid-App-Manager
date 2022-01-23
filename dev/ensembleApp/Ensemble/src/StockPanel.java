import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
	JTextField vaccTextField = new JTextField();
	JButton vaccDelButton = new JButton("Delete");
	
	JLabel gelLabel = new JLabel("Gel");
	JLabel gelAmountLabel = new JLabel("00000");
	JButton gelAddButton = new JButton("Add");
	JTextField gelTextField = new JTextField();
	JButton gelDelButton = new JButton("Delete");
	
	JLabel maskLabel = new JLabel("Mask");
	JLabel maskAmountLabel = new JLabel("00000");
	JButton maskAddButton = new JButton("Add");
	JTextField maskTextField = new JTextField();
	JButton maskDelButton = new JButton("Delete");
	
	JLabel clovesLabel = new JLabel("Cloves");
	JLabel clovesAmountLabel = new JLabel("00000");
	JButton clovesAddButton = new JButton("Add");
	JTextField clovesTextField = new JTextField();
	JButton clovesDelButton = new JButton("Delete");
	
	JLabel overallLabel = new JLabel("Overall");
	JLabel overallAmountLabel = new JLabel("00000");
	JButton overallAddButton = new JButton("Add");
	JTextField overallTextField = new JTextField();
	JButton overallDelButton = new JButton("Delete");
	
    public StockPanel() throws IOException {
		p.setLayout(new BorderLayout());
		StockDAO stockDAO = new StockDAO();	
		
		
		JPanel titleLayout = new JPanel();
		titleLayout.setLayout(new BorderLayout());
		BufferedImage myPicture = ImageIO.read(new File("Image1.png"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		BufferedImage myPicture2 = ImageIO.read(new File("Image2.png"));
		JLabel picLabel2 = new JLabel(new ImageIcon(myPicture2));
		
		JPanel img1 = new JPanel();
		img1.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));
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
        
        JPanel clovesLayout = new JPanel();
        clovesLayout.setLayout(new FlowLayout());
        clovesLayout.add(clovesLabel);
        clovesLayout.add(clovesAmountLabel);
        col1Layout.add(clovesLayout);
        
        JPanel overallLayout = new JPanel();
        overallLayout.setLayout(new FlowLayout());
        overallLayout.add(overallLabel);
        overallLayout.add(overallAmountLabel);
        col1Layout.add(overallLayout);
        
        
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
        
        JPanel cloves2Layout = new JPanel();
        cloves2Layout.setLayout(new FlowLayout());
        clovesTextField.setColumns(5);
        cloves2Layout.add(clovesAddButton);
        cloves2Layout.add(clovesTextField);
        cloves2Layout.add(clovesDelButton);
        int cloves = stockDAO.getStockOf("cloves");
        clovesAmountLabel.setText(String.valueOf(cloves));
        clovesAddButton.addActionListener(this);
        clovesDelButton.addActionListener(this);
        col2Layout.add(cloves2Layout);
        
        JPanel overall2Layout = new JPanel();
        overall2Layout.setLayout(new FlowLayout());
        overallTextField.setColumns(5);
        overall2Layout.add(overallAddButton);
        overall2Layout.add(overallTextField);
        overall2Layout.add(overallDelButton);
        int overall = stockDAO.getStockOf("overall");
        overallAmountLabel.setText(String.valueOf(overall));
        overallAddButton.addActionListener(this);
        overallDelButton.addActionListener(this);
        col2Layout.add(overall2Layout);
        
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
		else if(e.getSource() == clovesAddButton || e.getSource() == clovesDelButton) {
			int amount = Integer.valueOf(clovesTextField.getText().toString());
			if(e.getSource() == clovesDelButton) {
				amount*=-1;
			}
			stockDAO.setStockOf("cloves", amount);
			int cloves = stockDAO.getStockOf("cloves");
			clovesAmountLabel.setText(String.valueOf(cloves));
			clovesTextField.setText("");
		}
		else if(e.getSource() == overallAddButton || e.getSource() == overallDelButton) {
			int amount = Integer.valueOf(overallTextField.getText().toString());
			if(e.getSource() == overallDelButton) {
				amount*=-1;
			}
			stockDAO.setStockOf("overall", amount);
			int overall = stockDAO.getStockOf("overall");
			overallAmountLabel.setText(String.valueOf(overall));
			overallTextField.setText("");
		}
	}
}
