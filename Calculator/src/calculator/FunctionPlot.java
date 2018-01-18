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

public class FunctionPlot {

	private JFrame frmPlot;
	
	private int posX = SimpleCalculator.getPosX();
	private int posY = SimpleCalculator.getPosY();

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
		
		JLabel lblPic = new JLabel();
		lblPic.setBackground(Color.BLACK);
		lblPic.setBounds(10, 55, 500, 300);
		lblPic.setVisible(true);
		frmPlot.getContentPane().add(lblPic);
		
		JButton btnCalculate = new JButton("Show");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				double[] a = new double[361];
				double[] b = new double[361];
				
				for(int j = 0; j <= 360; j++) {
					a[j] = Math.cos(j);
					b[j] = j;
				}
				
				PlotXY(a, b);				
				
				lblPic.setIcon(new ImageIcon("C:\\Users\\geisk\\Desktop\\XYPlot.jpeg"));
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
		
		try {
			ChartUtilities.saveChartAsJPEG(
				new File("C:\\Users\\geisk\\Desktop\\XYPlot.jpeg"),
				chart,
				500,
				300
			);
		} catch(Exception e) {
			System.out.println("Error");
		}
		
	}
}