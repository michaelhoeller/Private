package gui.einstieg;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SchereSteinPapier extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final Integer SCHERE = 1;
	public static final Integer STEIN = 2;
	public static final Integer PAPIER = 3;

	private static int playerSelect;
	private static int computerSelect;

	private JButton btnEnde;
	private JButton btnPSchere;
	private JButton btnPStein;
	private JButton btnPPapier;

	private static JLabel lblTSpielerWahl;
	private static JLabel lblTPCWahl;
	private static JLabel lblSiegeP;
	private static JLabel lblSiegePC;
	private static JLabel lblPCWahl;
	private static JLabel lblPlayerWins;
	private static JLabel lblPcWins;

	public SchereSteinPapier() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setTitle("Schere Stein Papier");
		initKomponenten();
		setVisible(true);
	}

	private void initKomponenten() {
		getContentPane().setLayout(null);

		btnEnde = new JButton("Beenden");
		btnEnde.setBounds(399, 330, 175, 20);
		btnEnde.addActionListener(e -> quit());

		btnPSchere = new JButton("Schere");
		btnPSchere.setFont(new Font("Miriam", Font.BOLD, 20));
		btnPSchere.setBounds(10, 88, 200, 80);
		btnPSchere.addActionListener(e -> selectSchere());

		btnPStein = new JButton("Stein");
		btnPStein.setFont(new Font("Miriam", Font.BOLD, 20));
		btnPStein.setBounds(10, 179, 200, 80);
		btnPStein.addActionListener(e -> selectStein());

		btnPPapier = new JButton("Papier");
		btnPPapier.setFont(new Font("Miriam", Font.BOLD, 20));
		btnPPapier.setBounds(10, 270, 200, 80);
		btnPPapier.addActionListener(e -> selectPapier());

		lblTSpielerWahl = new JLabel("SpielerWahl");
		lblTSpielerWahl.setFont(new Font("Miriam", Font.BOLD, 20));
		lblTSpielerWahl.setBounds(10, 11, 200, 66);

		lblTPCWahl = new JLabel("Computerwahl");
		lblTPCWahl.setFont(new Font("Miriam", Font.BOLD, 20));
		lblTPCWahl.setBounds(363, 11, 211, 66);

		lblSiegeP = new JLabel("Siege Spieler");
		lblSiegeP.setFont(new Font("Miriam", Font.PLAIN, 12));
		lblSiegeP.setBounds(220, 128, 70, 40);

		lblSiegePC = new JLabel("Siege PC");
		lblSiegePC.setFont(new Font("Miriam", Font.PLAIN, 12));
		lblSiegePC.setBounds(301, 128, 70, 40);

		lblPCWahl = new JLabel("");
		lblPCWahl.setFont(new Font("Miriam", Font.BOLD, 20));
		lblPCWahl.setBounds(363, 88, 175, 66);

		lblPlayerWins = new JLabel("");
		lblPlayerWins.setBounds(220, 179, 70, 80);

		lblPcWins = new JLabel("");
		lblPcWins.setBounds(301, 179, 70, 80);

		// Add components to Pane

		getContentPane().add(btnPPapier);
		getContentPane().add(btnPSchere);
		getContentPane().add(btnPStein);
		getContentPane().add(btnEnde);
		getContentPane().add(lblTSpielerWahl);
		getContentPane().add(lblTPCWahl);
		getContentPane().add(lblSiegeP);
		getContentPane().add(lblSiegePC);
		getContentPane().add(lblPCWahl);
		getContentPane().add(lblPlayerWins);
		getContentPane().add(lblPcWins);
	}

	public static void main(String[] args) {
		new SchereSteinPapier();
	}

	public static void selectSchere() {
		playerSelect = SCHERE;
		compareSelects();
	}

	public static void selectStein() {
		playerSelect = STEIN;
		compareSelects();
	}

	public static void selectPapier() {
		playerSelect = PAPIER;
		compareSelects();
	}

	public static void selectForPc() {
		computerSelect = (int) (Math.random() * 3) + 1;
	}

	public static void compareSelects() {
		selectForPc();

		printResults(false);
	}

	public static void printResults(boolean playerWin) {
		if (playerWin) {
			Integer temp = (Integer.parseInt(lblSiegeP.getText()) + 1);
			lblSiegeP.setText(temp.toString());
		} else {
			Integer temp = (Integer.parseInt(lblSiegePC.getText()) + 1);
			lblSiegePC.setText(temp.toString());
		}
	}

	public static void quit() {
		System.exit(0);
	}

}
