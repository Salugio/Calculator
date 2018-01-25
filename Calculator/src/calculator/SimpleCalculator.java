package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class SimpleCalculator {

	private JFrame frmSimpleCalculator;
	private JTextField textField;
	
	private String operation;
	private double firstNumber;
	private double answer;
	
	private static int posX = 550;
	private static int posY = 350;
	
	/**
	 * Launch the application.
	 */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleCalculator window = new SimpleCalculator();
					window.frmSimpleCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SimpleCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSimpleCalculator = new JFrame();
		frmSimpleCalculator.getContentPane().setForeground(Color.BLACK);
		frmSimpleCalculator.getContentPane().setBackground(Color.GRAY);
		frmSimpleCalculator.setTitle("Simple Calc");
		frmSimpleCalculator.setResizable(false);
		frmSimpleCalculator.setBounds(posX, posY, 255, 455);
		frmSimpleCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSimpleCalculator.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setEditable(false);
		textField.setBounds(10, 11, 230, 40);
		frmSimpleCalculator.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		//============================== Row 1 ==============================
		
		JButton btnBackSpace = new JButton("<");
		btnBackSpace.setToolTipText("Back space");
		btnBackSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().isEmpty()) {
					String EnterNumber = textField.getText();
					EnterNumber = EnterNumber.substring(0, EnterNumber.length() - 1);
					textField.setText(EnterNumber);
				}
			}
		});
		btnBackSpace.setForeground(Color.BLACK);
		btnBackSpace.setBackground(Color.LIGHT_GRAY);
		btnBackSpace.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBackSpace.setBounds(10, 62, 50, 50);
		frmSimpleCalculator.getContentPane().add(btnBackSpace);
		
		JButton btnClear = new JButton("C");
		btnClear.setToolTipText("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
			}
		});
		btnClear.setForeground(Color.BLACK);
		btnClear.setBackground(Color.LIGHT_GRAY);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnClear.setBounds(70, 62, 50, 50);
		frmSimpleCalculator.getContentPane().add(btnClear);
		
		JButton btnPlusMinus = new JButton("\u00B1");
		btnPlusMinus.setToolTipText("Plus Minus");
		btnPlusMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textField.getText();
				if(EnterNumber.startsWith("-")) {
					EnterNumber = EnterNumber.substring(1, EnterNumber.length());
				} else {
					EnterNumber = "-" + EnterNumber;
				}
				textField.setText(EnterNumber);
			}
		});
		btnPlusMinus.setForeground(Color.BLACK);
		btnPlusMinus.setBackground(Color.LIGHT_GRAY);
		btnPlusMinus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPlusMinus.setBounds(130, 62, 50, 50);
		frmSimpleCalculator.getContentPane().add(btnPlusMinus);
		
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operation = "+";
				firstNumber = Double.parseDouble(textField.getText());
				textField.setText(null);
			}
		});
		btnPlus.setForeground(Color.BLACK);
		btnPlus.setBackground(Color.LIGHT_GRAY);
		btnPlus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPlus.setBounds(190, 62, 50, 50);
		frmSimpleCalculator.getContentPane().add(btnPlus);
		
		
		//============================== Row 2 ==============================
		
		JButton btn7 = new JButton("7");
		btn7.setForeground(Color.BLACK);
		btn7.setBackground(Color.LIGHT_GRAY);
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textField.getText() + btn7.getText();
				textField.setText(EnterNumber);
			}
		});
		btn7.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn7.setBounds(10, 123, 50, 50);
		frmSimpleCalculator.getContentPane().add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setForeground(Color.BLACK);
		btn8.setBackground(Color.LIGHT_GRAY);
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textField.getText() + btn8.getText();
				textField.setText(EnterNumber);
			}
		});
		btn8.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn8.setBounds(70, 123, 50, 50);
		frmSimpleCalculator.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setForeground(Color.BLACK);
		btn9.setBackground(Color.LIGHT_GRAY);
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textField.getText() + btn9.getText();
				textField.setText(EnterNumber);
			}
		});
		btn9.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn9.setBounds(130, 123, 50, 50);
		frmSimpleCalculator.getContentPane().add(btn9);
		
		JButton btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operation = "-";
				firstNumber = Double.parseDouble(textField.getText());
				textField.setText(null);
			}
		});
		btnMinus.setForeground(Color.BLACK);
		btnMinus.setBackground(Color.LIGHT_GRAY);
		btnMinus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMinus.setBounds(190, 123, 50, 50);
		frmSimpleCalculator.getContentPane().add(btnMinus);
		
		
		//============================== Row 3 ==============================
		
		JButton btn4 = new JButton("4");
		btn4.setForeground(Color.BLACK);
		btn4.setBackground(Color.LIGHT_GRAY);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textField.getText() + btn4.getText();
				textField.setText(EnterNumber);
			}
		});
		btn4.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn4.setBounds(10, 184, 50, 50);
		frmSimpleCalculator.getContentPane().add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setForeground(Color.BLACK);
		btn5.setBackground(Color.LIGHT_GRAY);
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textField.getText() + btn5.getText();
				textField.setText(EnterNumber);
			}
		});
		btn5.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn5.setBounds(70, 184, 50, 50);
		frmSimpleCalculator.getContentPane().add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setForeground(Color.BLACK);
		btn6.setBackground(Color.LIGHT_GRAY);
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textField.getText() + btn6.getText();
				textField.setText(EnterNumber);
			}
		});
		btn6.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn6.setBounds(130, 184, 50, 50);
		frmSimpleCalculator.getContentPane().add(btn6);
		
		JButton btnMult = new JButton("*");
		btnMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operation = "*";
				firstNumber = Double.parseDouble(textField.getText());
				textField.setText(null);
			}
		});
		btnMult.setForeground(Color.BLACK);
		btnMult.setBackground(Color.LIGHT_GRAY);
		btnMult.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMult.setBounds(190, 184, 50, 50);
		frmSimpleCalculator.getContentPane().add(btnMult);
		
		
		//============================== Row 4 ==============================
		
		JButton btn1 = new JButton("1");
		btn1.setForeground(Color.BLACK);
		btn1.setBackground(Color.LIGHT_GRAY);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textField.getText() + btn1.getText();
				textField.setText(EnterNumber);
			}
		});
		btn1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn1.setBounds(10, 245, 50, 50);
		frmSimpleCalculator.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setForeground(Color.BLACK);
		btn2.setBackground(Color.LIGHT_GRAY);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textField.getText() + btn2.getText();
				textField.setText(EnterNumber);
			}
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn2.setBounds(70, 245, 50, 50);
		frmSimpleCalculator.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setForeground(Color.BLACK);
		btn3.setBackground(Color.LIGHT_GRAY);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = textField.getText() + btn3.getText();
				textField.setText(EnterNumber);
			}
		});
		btn3.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn3.setBounds(130, 245, 50, 50);
		frmSimpleCalculator.getContentPane().add(btn3);
		
		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operation = "/";
				firstNumber = Double.parseDouble(textField.getText());
				textField.setText(null);
			}
		});
		btnDiv.setForeground(Color.BLACK);
		btnDiv.setBackground(Color.LIGHT_GRAY);
		btnDiv.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDiv.setBounds(190, 245, 50, 50);
		frmSimpleCalculator.getContentPane().add(btnDiv);
		
		
		//============================== Row 4 ==============================
		
		JButton btn0 = new JButton("0");
		btn0.setForeground(Color.BLACK);
		btn0.setBackground(Color.LIGHT_GRAY);
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String EnterNumber = textField.getText() + btn0.getText();
				textField.setText(EnterNumber);
			}
		});
		btn0.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn0.setBounds(10, 306, 50, 50);
		frmSimpleCalculator.getContentPane().add(btn0);
		
		JButton btnDot = new JButton(".");
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().contains(".")) {
					String num = textField.getText() + ".";
					textField.setText(num);
				}
			}
		});
		btnDot.setForeground(Color.BLACK);
		btnDot.setBackground(Color.LIGHT_GRAY);
		btnDot.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDot.setBounds(70, 306, 50, 50);
		frmSimpleCalculator.getContentPane().add(btnDot);
		
		JButton btnEqual = new JButton("=");
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double secondNumber = Double.parseDouble(textField.getText());
				
				if(operation.equals("+")) {
					answer = firstNumber + secondNumber;
					textField.setText(String.valueOf(answer));
				} else if(operation.equals("-")) {
					answer = firstNumber - secondNumber;
					textField.setText(String.valueOf(answer));
				} else if(operation.equals("*")) {
					answer = firstNumber * secondNumber;
					textField.setText(String.valueOf(answer));
				} else if(operation.equals("/")) {
					answer = firstNumber / secondNumber;
					textField.setText(String.valueOf(answer));
				}
			}
		});
		btnEqual.setForeground(Color.BLACK);
		btnEqual.setBackground(Color.LIGHT_GRAY);
		btnEqual.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEqual.setBounds(130, 306, 110, 50);
		frmSimpleCalculator.getContentPane().add(btnEqual);		
		
		
		
		//============================ Radio Buttons ===========================
		
		JRadioButton rdbtnSimpleCalculator = new JRadioButton("Simple Calculator");
		rdbtnSimpleCalculator.setSelected(true);
		rdbtnSimpleCalculator.setForeground(Color.WHITE);
		rdbtnSimpleCalculator.setBackground(Color.GRAY);
		rdbtnSimpleCalculator.setBounds(10, 363, 130, 23);
		frmSimpleCalculator.getContentPane().add(rdbtnSimpleCalculator);
		
		JRadioButton rdbtnSecondCalculator = new JRadioButton("Second Calculator");
		rdbtnSecondCalculator.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				SecondCalculator.run();
				frmSimpleCalculator.dispose();
			}
		});
		rdbtnSecondCalculator.setForeground(Color.WHITE);
		rdbtnSecondCalculator.setBackground(Color.GRAY);
		rdbtnSecondCalculator.setBounds(10, 389, 130, 23);
		frmSimpleCalculator.getContentPane().add(rdbtnSecondCalculator);
		
		JRadioButton rdbtnPlot = new JRadioButton("Plot");		
		rdbtnPlot.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				FunctionPlot.run();
				frmSimpleCalculator.dispose();
			}
		});
		rdbtnPlot.setForeground(Color.WHITE);
		rdbtnPlot.setBackground(Color.GRAY);
		rdbtnPlot.setBounds(140, 363, 100, 23);
		frmSimpleCalculator.getContentPane().add(rdbtnPlot);
		
		ButtonGroup CalculatorChoice = new ButtonGroup();
		CalculatorChoice.add(rdbtnSimpleCalculator);
		CalculatorChoice.add(rdbtnSecondCalculator);
		
	}
	
	public static int getPosX() {
		return posX;
	}
	
	public static int getPosY() {
		return posY;
	}
}