package gui.einstieg;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

public class SchereSteinPapier extends SuperGUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Integer SCHERE = 0;
	private final Integer STEIN = 1;
	private final Integer PAPIER = 2;
	private final Integer[] SELECTIONS = { SCHERE, STEIN, PAPIER };
	private final String[] SELECTION_NAMES = { "SCHERE", "STEIN", "PAPIER" };
	private final String SETGAMES = "Spielanzahl: ";
	private final String REMAINING_GAMES = "Verbleibende Spiele: ";

	private Integer playerWins = 0;
	private Integer pcWins = 0;
	private Integer pBarValue = 0;

	private Integer gamesAmount;
	private Integer remainingGames;

	private boolean isGameAmountSet = false;
	private boolean isCheatAktive = false;

	private JButton btnEnde;
	private JButton btnPSchere;
	private JButton btnPStein;
	private JButton btnPPapier;

	private JLabel lblTSpielerWahl;
	private JLabel lblTPCWahl;
	private JLabel lblSiegeP;
	private JLabel lblSiegePC;
	private JLabel lblPCWahl;
	private JLabel lblPlayerWins;
	private JLabel lblPcWins;
	private JLabel lblDraw;
	private JLabel lblCheatAnzeige;
	private JLabel lblGameAmounts;
	private JLabel lblRemainingGameAmounts;
	private JButton btnGameFestlegen;

	private JToggleButton tglbtnCheat;

	private JProgressBar progressBar;

	private JTextField textGameAmount;

	public SchereSteinPapier() {
		super("Schere Stein Papier");
	}

	public void initKomponenten() {

		// Buttons
		btnEnde = new JButton("Beenden");
		btnEnde.setBounds(399, 330, 175, 20);
		btnEnde.addActionListener(e -> {
			try {
				quit();
			} catch (NullPointerException ex) {
			}
		});

		btnPSchere = new JButton("Schere");
		btnPSchere.setCursor(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));
		btnPSchere.setFont(new Font("Miriam", Font.BOLD, 20));
		btnPSchere.setBounds(10, 88, 200, 80);
		btnPSchere.addActionListener(e -> compareSelects(SCHERE));

		btnPStein = new JButton("Stein");
		btnPStein.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		btnPStein.setFont(new Font("Miriam", Font.BOLD, 20));
		btnPStein.setBounds(10, 179, 200, 80);
		btnPStein.addActionListener(e -> compareSelects(STEIN));

		btnPPapier = new JButton("Papier");
		btnPPapier.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPPapier.setFont(new Font("Miriam", Font.BOLD, 20));
		btnPPapier.setBounds(10, 270, 200, 80);
		btnPPapier.addActionListener(e -> compareSelects(PAPIER));

		btnGameFestlegen = new JButton("Games festlegen");
		btnGameFestlegen.setBounds(220, 330, 175, 20);
		btnGameFestlegen.addActionListener(e -> prepareGame());
		// Buttons ENDE

		// Labels
		lblTSpielerWahl = new JLabel("SpielerWahl");
		lblTSpielerWahl.setHorizontalAlignment(SwingConstants.CENTER);
		lblTSpielerWahl.setFont(new Font("Miriam", Font.BOLD, 20));
		lblTSpielerWahl.setBounds(10, 11, 200, 66);

		lblTPCWahl = new JLabel("Computerwahl");
		lblTPCWahl.setHorizontalAlignment(SwingConstants.CENTER);
		lblTPCWahl.setFont(new Font("Miriam", Font.BOLD, 20));
		lblTPCWahl.setBounds(373, 11, 201, 66);

		lblSiegeP = new JLabel("Siege Spieler");
		lblSiegeP.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiegeP.setFont(new Font("Miriam", Font.PLAIN, 12));
		lblSiegeP.setBounds(220, 26, 70, 40);

		lblSiegePC = new JLabel("Siege PC");
		lblSiegePC.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiegePC.setFont(new Font("Miriam", Font.PLAIN, 12));
		lblSiegePC.setBounds(300, 26, 70, 40);

		lblPCWahl = new JLabel("");
		lblPCWahl.setHorizontalAlignment(SwingConstants.CENTER);
		lblPCWahl.setBorder(UIManager.getBorder("CheckBox.border"));
		lblPCWahl.setFont(new Font("Miriam", Font.BOLD, 20));
		lblPCWahl.setBounds(373, 88, 201, 66);

		lblPlayerWins = new JLabel();
		lblPlayerWins.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerWins.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPlayerWins.setBorder(UIManager.getBorder("Spinner.border"));
		lblPlayerWins.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPlayerWins.setBounds(220, 58, 70, 80);
		lblPlayerWins.setText("0");

		lblPcWins = new JLabel();
		lblPcWins.setHorizontalAlignment(SwingConstants.CENTER);
		lblPcWins.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPcWins.setBorder(UIManager.getBorder("Spinner.border"));
		lblPcWins.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPcWins.setBounds(300, 58, 70, 80);
		lblPcWins.setText("0");

		lblDraw = new JLabel();
		lblDraw.setText("");
		lblDraw.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDraw.setHorizontalAlignment(SwingConstants.CENTER);
		lblDraw.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDraw.setBorder(UIManager.getBorder("Spinner.border"));
		lblDraw.setBounds(219, 149, 151, 83);

		lblCheatAnzeige = new JLabel("Cheat: INAKTIV");
		lblCheatAnzeige.setBounds(373, 193, 201, 14);

		lblGameAmounts = new JLabel("");
		lblGameAmounts.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameAmounts.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		lblGameAmounts.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)),
				new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		lblGameAmounts.setBounds(220, 240, 175, 37);

		lblRemainingGameAmounts = new JLabel("");
		lblRemainingGameAmounts.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemainingGameAmounts.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		lblRemainingGameAmounts.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)),
				new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		lblRemainingGameAmounts.setBounds(399, 240, 175, 37);
		getContentPane().setLayout(null);
		// Labels ENDE

		// Textfields
		textGameAmount = new JTextField();
		textGameAmount.setBounds(220, 307, 175, 20);
		getContentPane().add(textGameAmount);
		textGameAmount.setColumns(10);

		tglbtnCheat = new JToggleButton("Cheat Knopf");
		tglbtnCheat.setBounds(373, 209, 201, 23);
		tglbtnCheat.addActionListener(e -> checkIfCheatAktive());

		progressBar = new JProgressBar();
		progressBar.setBounds(220, 288, 354, 15);
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);

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
		getContentPane().add(lblDraw);
		getContentPane().add(progressBar);
		getContentPane().add(lblCheatAnzeige);

		getContentPane().add(tglbtnCheat);

		getContentPane().add(btnGameFestlegen);
		getContentPane().add(lblGameAmounts);
		getContentPane().add(lblRemainingGameAmounts);

	}

	public Integer selectForPc() {
		Integer pcSelection = (int) (Math.random() * 3);
		lblPCWahl.setText(SELECTION_NAMES[pcSelection]);
		return SELECTIONS[pcSelection];
	}

	public void compareSelects(Integer playerInput) {

		if (isGameAmountSet) {
			Integer pcInput = selectForPc();
			remainingGames--;
			lblDraw.setText("");
			pBarValue++;
			progressBar.setValue(pBarValue);
			if (isCheatAktive) {
				if (playerInput == 2) {
					pcInput = 0;
				} else {
					pcInput = playerInput + 1;
				}
			}
			if (playerInput == pcInput) {
				lblDraw.setText("UNENTSCHIEDEN");
				finalizeRound();
			} else if (playerInput == 0 && pcInput == 2 || playerInput == 1 && pcInput == 0
					|| playerInput == 2 && pcInput == 1) {
				printResults(true);
			} else {
				printResults(false);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Bitte erst Spielezahl festlegen!", "FEHLER",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public void printResults(boolean playerWin) {
		if (playerWin) {
			playerWins++;
			lblPlayerWins.setText(playerWins.toString());
			finalizeRound();
		} else {
			pcWins++;
			lblPcWins.setText(pcWins.toString());
			finalizeRound();
		}
	}

	private void checkIfCheatAktive() {
		if (tglbtnCheat.isSelected()) {
			lblCheatAnzeige.setText("Cheat: AKTIVE");
			isCheatAktive = true;
		} else {
			lblCheatAnzeige.setText("Cheat: INAKTIVE");
			isCheatAktive = false;
		}
	}

	private void prepareGame() {
		try {
			gamesAmount = Integer.parseInt(textGameAmount.getText());
			remainingGames = gamesAmount;

			lblGameAmounts.setText(SETGAMES + gamesAmount.toString());
			lblRemainingGameAmounts.setText(REMAINING_GAMES + gamesAmount.toString());

			progressBar.setMaximum(gamesAmount);
			isGameAmountSet = true;

			btnGameFestlegen.setVisible(false);
			getContentPane().remove(btnGameFestlegen);

			textGameAmount.setVisible(false);
			getContentPane().remove(textGameAmount);

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Bitte eine gültige Nummer festlegen!", "FEHLER",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void finalizeRound() {
		lblRemainingGameAmounts.setText(REMAINING_GAMES + remainingGames.toString());
		if (pBarValue == gamesAmount) {
			quit();
		}
	}

	private void quit() throws NullPointerException {
		try {
			JOptionPane.showMessageDialog(null,
					"Spiel mit " + gamesAmount + " Runden wird beendet :\nSpieler hat: " + playerWins
							+ " Spiele gewonnen\nComputer hat: " + pcWins + " Spiele gewonnen\n"
							+ (gamesAmount - playerWins - pcWins) + " Spiele waren unentschieden",
					"Game Over", JOptionPane.ERROR_MESSAGE);
		} finally {
			destroyWindow();
		}

	}

	@Override
	protected void destroyWindow() {
		this.dispose();
		new MainWindow();

	}
}
