import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class StatisticsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StatisticsPanel() throws IOException {
		
		this.setLayout(new BorderLayout());
		
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
		
		//--**--
		
		JPanel colLayout = new JPanel();
        colLayout.setLayout(new GridLayout(1,2,10,10));
        
		StockDAO stockDAO = new StockDAO();
        DecimalFormat numberFormat = new DecimalFormat("#.0");
		
		final DefaultPieDataset pieDataset = new DefaultPieDataset();
		int v = stockDAO.getStockOf("vaccine");
		int ge = stockDAO.getStockOf("gel");
		int m = stockDAO.getStockOf("mask");
		int o = stockDAO.getStockOf("gown");
		int gl = stockDAO.getStockOf("gloves");
        pieDataset.setValue("Vaccine "+ v, v);
        pieDataset.setValue("Gel "+ ge, ge);
        pieDataset.setValue("Mask "+ m, m);
        pieDataset.setValue("Gown "+ o, o);
        pieDataset.setValue("Gloves "+ gl, gl);
        final JFreeChart pieChart = ChartFactory.createPieChart("Current Stock", pieDataset, true, false, false);
        final ChartPanel cPanel = new ChartPanel(pieChart) {
			private static final long serialVersionUID = 1L;
			@Override
            public Dimension getPreferredSize() {
                return new Dimension(400, (int)(400 * 0.62));
            }
        };
        cPanel.setMaximumSize(getMaximumSize());
        colLayout.add(cPanel);
        
        //----
        
        final DefaultPieDataset pieDataset2 = new DefaultPieDataset();
        PatientDAO patientDAO = new PatientDAO();	
        int one = patientDAO.getAmountPersWithNbrDose("1");
        int two = patientDAO.getAmountPersWithNbrDose("2");
        int three = patientDAO.getAmountPersWithNbrDose("3");
        int four = patientDAO.getAmountPersWithNbrDose("4");
        int five = patientDAO.getAmountPersWithNbrDose("5");
        double tot = one+two+three+four+five;
        String onep = numberFormat.format(one/tot*100);
        String twop = numberFormat.format(two/tot*100);
        String threep = numberFormat.format(three/tot*100);
        String fourp = numberFormat.format(four/tot*100);
        String fivep = numberFormat.format(five/tot*100);
        pieDataset2.setValue("Dose 1: "+onep+"%", one);
        pieDataset2.setValue("Dose 2: "+twop+"%", two);
        pieDataset2.setValue("Dose 3: "+threep+"%", three);
        pieDataset2.setValue("Dose 4: "+fourp+"%", four);
        pieDataset2.setValue("Dose 5: "+fivep+"%", five);
        final JFreeChart pieChart2 = ChartFactory.createPieChart("Patient management", pieDataset2, true, false, false);
        final ChartPanel cPanel2 = new ChartPanel(pieChart2) {
			private static final long serialVersionUID = 1L;
			@Override
            public Dimension getPreferredSize() {
                return new Dimension(400, (int)(400 * 0.62));
            }
        };
        cPanel2.setMaximumSize(getMaximumSize());
        colLayout.add(cPanel2);
        
        this.add(titleLayout,BorderLayout.PAGE_START);
        this.add(colLayout,BorderLayout.CENTER);
	}
	public void addLayout(JPanel layout) {
		this.add(layout, BorderLayout.PAGE_END);
	}
}
