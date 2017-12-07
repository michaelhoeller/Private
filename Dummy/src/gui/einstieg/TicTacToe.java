package gui.einstieg;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class TicTacToe extends SuperGUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static int[][] WINCOMBINATIONS = new int[][] { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 },
			{ 1, 4, 7 }, { 2, 5, 8 }, { 0, 4, 8 }, { 2, 4, 6 } };

	private JButton buttons[] = new JButton[9];
	private int roundCounter = 0;
	private int again;
	private boolean win = false;
	private String letter;
	private boolean isPlayerEnemy;

	public TicTacToe(boolean playerEnemy) {
		super("Tic Tac Toe");
		isPlayerEnemy = playerEnemy;
		this.setLayout(new GridLayout(3, 3));
		this.setBackground(Color.white);
		// this.pack();
		this.setSize(500, 500);
		for (int i = 0; i <= 8; i++) {
			buttons[i] = new MyButton();
			this.add(buttons[i]);
		}
	}

	private class MyButton extends JButton implements ActionListener {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyButton() {
			letter = " ";
			setFont(new Font("Dialog", 1, 60));
			setText(letter);
			addActionListener(this);
		}

		public void actionPerformed(ActionEvent e) {

			if (isPlayerEnemy) {
				if ((roundCounter % 2) == 0 && getText().equals(" ") && win == false) {
					letter = "X";
					roundCounter = roundCounter + 1;
				} else if ((roundCounter % 2) == 1 && getText().equals(" ") && win == false) {
					letter = "O";
					roundCounter = roundCounter + 1;
				}
				setText(letter);
				checkWin();
				askUser();
			} else {
				letter = "X";
				roundCounter = roundCounter + 1;
				setText(letter);
				pcTurn();
				checkWin();
				askUser();
			}
		}

		private void pcTurn() {
			for (int i = 0; i < buttons.length; i++) {
				int temp = (int) (Math.random() * buttons.length);
				if (buttons[temp].getText().equals(" ")) {
					buttons[temp].setText("O");
					break;
				}
			}
		}
	}

	public void clearButtons() {

		for (int i = 0; i <= 8; i++) {
			buttons[i].setText(" ");
		}
		roundCounter = 0;
	}

	private void checkWin() {
		for (int i = 0; i <= 7; i++) {
			if (buttons[WINCOMBINATIONS[i][0]].getText().equals(buttons[WINCOMBINATIONS[i][1]].getText())
					&& buttons[WINCOMBINATIONS[i][1]].getText().equals(buttons[WINCOMBINATIONS[i][2]].getText())
					&& buttons[WINCOMBINATIONS[i][0]].getText() != " ") {
				win = true;
			}
		}
	}

	private void askUser() {
		if (win == true) {
			again = JOptionPane.showConfirmDialog(null, letter + " wins the game!  Do you want to play again?",
					letter + "won!", JOptionPane.YES_NO_OPTION);

		} else if (roundCounter == 9 && win == false) {
			again = JOptionPane.showConfirmDialog(null, "The game was tie!  Do you want to play again?", "Tie game!",
					JOptionPane.YES_NO_OPTION);
			win = true;
		}

		if (again == JOptionPane.YES_OPTION && win == true) {
			clearButtons();
			win = false;
		} else if (again == JOptionPane.NO_OPTION) {
			destroyWindow();
		}
	}

	@Override
	protected void initKomponenten() {

	}

	@Override
	protected void destroyWindow() {
		this.dispose();
		new MainWindow();

	}
}