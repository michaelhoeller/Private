package gui.einstieg;

import javax.swing.JButton;

public class MainWindow extends SuperGUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton btnWrfelstatistik;
	private JButton btnSchereSteinPapier;
	private JButton btnTicTacToe;
	private JButton btnTicTacToePC;

	public MainWindow() {
		super("Main Menu");

	}

	@Override
	protected void initKomponenten() {
		getContentPane().setLayout(null);

		btnWrfelstatistik = new JButton("Würfelstatistik");
		btnWrfelstatistik.setBounds(10, 11, 200, 80);
		btnWrfelstatistik.addActionListener(e -> startWuerfelStatistik());

		btnSchereSteinPapier = new JButton("Schere Stein Papier");
		btnSchereSteinPapier.setBounds(10, 102, 200, 80);
		btnSchereSteinPapier.addActionListener(e -> startSchereSteinPapier());

		btnTicTacToe = new JButton("Tic Tac Toe HOTSEAT");
		btnTicTacToe.setBounds(10, 193, 200, 40);
		btnTicTacToe.addActionListener(e -> startTicTacToe(true));

		btnTicTacToePC = new JButton("Tic Tac Toe PC");
		btnTicTacToePC.setBounds(10, 244, 200, 40);
		btnTicTacToePC.addActionListener(e -> startTicTacToe(false));

		getContentPane().add(btnSchereSteinPapier);
		getContentPane().add(btnWrfelstatistik);
		getContentPane().add(btnTicTacToe);
		getContentPane().add(btnTicTacToePC);

	}

	private void startWuerfelStatistik() {
		this.dispose();
		new WuerfelStatistikDlg();
	}

	private void startSchereSteinPapier() {
		this.dispose();
		new SchereSteinPapier();
	}

	private void startTicTacToe(boolean playerEnemy) {
		this.dispose();
		new TicTacToe(playerEnemy);
	}

	@Override
	protected void destroyWindow() {
		System.exit(0);
	}

	public static void main(String[] args) {
		new MainWindow();
	}
}
