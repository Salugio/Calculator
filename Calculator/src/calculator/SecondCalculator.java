package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class SecondCalculator {

	private JFrame frame;
	
	private int posX = SimpleCalculator.getPosX();;
	private int posY = SimpleCalculator.getPosY();

	/**
	 * Launch the application.
	 */
	public static void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondCalculator window = new SecondCalculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SecondCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(posX, posY, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
