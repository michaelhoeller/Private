package gui.einstieg;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Battleships extends SuperGUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String[] LETTERS = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
	private final String[] NUMBERS = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", };
	private final Integer[][] OWN_SHIPS = new Integer[10][10];
	private final Integer[][] ENEMY_SHIPS = new Integer[10][10];

	private JPanel pnlGameArea;
	private JPanel pnlOwnShips;
	private JPanel pnlEnemyShips;

	private JButton[] buttonPlayerField;
	private JButton[] buttonEnemyField;
	private JPanel pnlLetters2;
	private JPanel pnlLetters3;
	private JPanel pnlLetters1;
	private JPanel pnlLetters4;

	public Battleships() {
		super("Battleships");
		this.setSize(1024, 768);
		this.setLocationRelativeTo(null);

		pnlGameArea = new JPanel();
		pnlGameArea.setBounds(503, 11, 495, 495);
		pnlGameArea.setLayout(null);

		pnlEnemyShips = new JPanel();
		pnlEnemyShips.setBounds(579, 30, 400, 400);
		pnlEnemyShips.setLayout(new GridLayout(11, 11, 5, 5));

		pnlOwnShips = new JPanel();
		pnlOwnShips.setBounds(30, 30, 400, 400);
		pnlOwnShips.setLayout(new GridLayout(11, 11, 5, 5));

		pnlGameArea.add(pnlEnemyShips);
		pnlGameArea.add(pnlOwnShips);

		pnlLetters1 = new JPanel();
		pnlLetters1.setBounds(10, 11, 15, 400);
		pnlLetters1.setLayout(new GridLayout(0, 1, 0, -25));

		pnlLetters2 = new JPanel();
		pnlLetters2.setBounds(30, 11, 400, 10);
		pnlLetters2.setLayout(new GridLayout(1, 0, 5, 0));

		pnlLetters3 = new JPanel();
		pnlLetters3.setBounds(579, 11, 400, 10);
		pnlLetters3.setLayout(new GridLayout(1, 0, 10, 0));

		pnlLetters4 = new JPanel();
		pnlLetters4.setBounds(984, 11, 15, 400);
		pnlLetters4.setLayout(new GridLayout(0, 1, 0, -25));

		pnlGameArea.add(pnlLetters1);
		pnlGameArea.add(pnlLetters2);
		pnlGameArea.add(pnlLetters3);
		pnlGameArea.add(pnlLetters4);
		getContentPane().add(pnlGameArea);
		getContentPane().add(pnlGameArea);

		for (int i = 0; i < getButtonEnemyField().length; i++) {
			pnlOwnShips.add(buttonEnemyField[i]);
		}
		for (int i = 0; i < getButtonPlayerField().length; i++) {
			pnlEnemyShips.add(buttonPlayerField[i]);
		}
		fillNumberPanels(pnlLetters1);
		fillLetterPanels(pnlLetters2);
		fillLetterPanels(pnlLetters3);
		fillNumberPanels(pnlLetters4);

	}

	public void fillLetterPanels(JPanel pnl) {
		for (int i = 0; i < LETTERS.length; i++) {
			JLabel temp = new JLabel();
			temp.setHorizontalAlignment(SwingConstants.CENTER);
			temp.setText(LETTERS[i]);
			pnl.add(temp);
		}
	}

	public void fillNumberPanels(JPanel pnl) {
		for (int i = 0; i < NUMBERS.length; i++) {
			JLabel temp = new JLabel();
			temp.setHorizontalAlignment(SwingConstants.CENTER);
			temp.setText(NUMBERS[i]);
			pnl.add(temp);
		}
	}

	@Override
	protected void initKomponenten() {
		setButtonEnemyField(new JButton[100]);
		setButtonPlayerField(new JButton[100]);
		for (int i = 0; i < getButtonEnemyField().length; i++) {
			buttonEnemyField[i] = new JButton();
		}
		for (int i = 0; i < buttonPlayerField.length; i++) {
			buttonPlayerField[i] = new JButton();
		}
	}

	public JButton[] getButtonPlayerField() {
		return buttonPlayerField;
	}

	public void setButtonPlayerField(JButton[] buttonPlayerField) {
		this.buttonPlayerField = buttonPlayerField;
	}

	public JButton[] getButtonEnemyField() {
		return buttonEnemyField;
	}

	public void setButtonEnemyField(JButton[] buttonEnemyField) {
		this.buttonEnemyField = buttonEnemyField;
	}

	public Integer[][] getOWN_SHIPS() {
		return OWN_SHIPS;
	}

	public Integer[][] getENEMY_SHIPS() {
		return ENEMY_SHIPS;
	}

	@Override
	protected void destroyWindow() {
		this.dispose();
		new MainWindow();
	}
}
