package calculator;

import java.awt.EventQueue;
import java.io.File;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class FunctionPlot {

	private JFrame frmPlot;
	
	private int posX = SimpleCalculator.getPosX();
	private int posY = SimpleCalculator.getPosY();
	
	private String plotName = null;
	private String pathImage = "plotImages\\";

	private JComboBox<String> comboBox;
	private JLabel lblPic;
	
	/**
	 * Launch the application.
	 */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FunctionPlot window = new FunctionPlot();
					window.frmPlot.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FunctionPlot() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPlot = new JFrame();
		frmPlot.getContentPane().setBackground(Color.GRAY);
		frmPlot.setBounds(posX, posY, 540, 489);
		frmPlot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlot.getContentPane().setLayout(null);
		frmPlot.setTitle("Function Plot");
		
		lblPic = new JLabel();
		lblPic.setBackground(Color.BLACK);
		lblPic.setBounds(10, 55, 500, 300);
		lblPic.setVisible(true);
		frmPlot.getContentPane().add(lblPic);
		
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 22));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Choose function", "x\u00B3", "x\u00B2", "sqrt(x)", "log(x)+1", "cos(x)", "sin(x)"}));
		comboBox.setBounds(115, 11, 250, 35);
		frmPlot.getContentPane().add(comboBox);
		
		JButton btnCalculate = new JButton("Show");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				choseAndPlot();
			}
		});
		btnCalculate.setBounds(10, 11, 90, 35);
		frmPlot.getContentPane().add(btnCalculate);
		
		JRadioButton rdbtnSimpleCalculator = new JRadioButton("Simple Calculator");
		rdbtnSimpleCalculator.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				SimpleCalculator.run();
				frmPlot.dispose();
			}
		});
		rdbtnSimpleCalculator.setForeground(Color.WHITE);
		rdbtnSimpleCalculator.setBackground(Color.GRAY);
		rdbtnSimpleCalculator.setBounds(10, 396, 130, 23);
		frmPlot.getContentPane().add(rdbtnSimpleCalculator);
		
		JRadioButton rdbtnSecondCalculator = new JRadioButton("Second Calculator");
		rdbtnSecondCalculator.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				SecondCalculator.run();
				frmPlot.dispose();
			}
		});
		rdbtnSecondCalculator.setForeground(Color.WHITE);
		rdbtnSecondCalculator.setBackground(Color.GRAY);
		rdbtnSecondCalculator.setBounds(142, 396, 130, 23);
		frmPlot.getContentPane().add(rdbtnSecondCalculator);
		
		JRadioButton rdbtnPlot = new JRadioButton("Plot");
		rdbtnPlot.setSelected(true);
		rdbtnPlot.setForeground(Color.WHITE);
		rdbtnPlot.setBackground(Color.GRAY);
		rdbtnPlot.setBounds(274, 396, 130, 23);
		frmPlot.getContentPane().add(rdbtnPlot);
		
		ButtonGroup choice = new ButtonGroup();
		choice.add(rdbtnSimpleCalculator);
		choice.add(rdbtnSecondCalculator);
		choice.add(rdbtnPlot);
		
	}
	
	/**
	 * Creates a JPEG File with the Graph
	 */
	public void PlotXY(double[] x, double[] y) {
	
		XYSeries series = new XYSeries("Graph");
		for(int i = 0; i < x.length; i++) {
			series.add(x[i], y[i]);
		}
		
		XYSeriesCollection dataSet = new XYSeriesCollection();
		dataSet.addSeries(series);
		
		JFreeChart chart = ChartFactory.createXYLineChart(
				"XY Chart",
				"x-axis",
				"y-axis",
				dataSet,
				PlotOrientation.VERTICAL,
				true,
				true,
				false
		);
		
		if(!comboBox.getSelectedItem().equals("Choose function")) {
			try {
				ChartUtilities.saveChartAsJPEG(
					new File(getPlotName()),
					chart,
					500,
					300
				);
			} catch(Exception e) {
				System.out.println("Error");
			}
		}
	}
	
	/**
	 * Method to chose and plot a function by clicking on JButton "Show"
	 */
	public void choseAndPlot() {
		double[] a = new double[101];
		double[] b = new double[101];
		String functionChoice = comboBox.getSelectedItem().toString();
		String plotName = null;
		
		switch(functionChoice) {
			case "x\u00B3":
				for(int j = 0; j <= 100; j++) {
					a[j] = j;
					b[j] = Math.pow(j, 3);
					plotName = pathImage + "x3Plot.jpeg";
					setPlotName(plotName);
				}
				break;
			
			case "x\u00B2":
				for(int j = 0; j <= 100; j++) {
					a[j] = j;
					b[j] = Math.pow(j, 2);
					plotName = pathImage + "x2Plot.jpeg";
					setPlotName(plotName);
				}
				break;
				
			case "sqrt(x)":
				for(int j = 0; j <= 100; j++) {
					a[j] = j;
					b[j] = Math.pow(j, 0.5);
					plotName = pathImage + "sqrtPlot.jpeg";
					setPlotName(plotName);
				}
				break;
				
			case "log(x)+1":
				for(int j = 0; j <= 100; j++) {
					a[j] = j;
					b[j] = Math.log10(j+1);
					plotName = pathImage + "log+1.jpeg";
					setPlotName(plotName);
				}
				break;
			
			case "cos(x)":
				for(int j = 0; j <= 100; j++) {
					a[j] = j;
					b[j] = Math.cos(j);
					plotName = pathImage + "cos.jpeg";
					setPlotName(plotName);
				}
				break;
				
			case "sin(x)":
				for(int j = 0; j <= 100; j++) {
					a[j] = j;
					b[j] = Math.sin(j);
					plotName = pathImage + "sin.jpeg";
					setPlotName(plotName);
				}
				break;
		}
		
		PlotXY(a, b);				
		
		lblPic.setIcon(new ImageIcon(plotName));
	}
	
	/**
	 * Setter for plotName
	 */
	public void setPlotName(String plotName) {
		this.plotName = plotName;
	}
	
	/**
	 * Getter for plotName
	 */
	public String getPlotName() {
		return plotName;
	}
}