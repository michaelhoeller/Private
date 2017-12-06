package gui.einstieg;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MachEnde extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer throwAmount;

	private JTextField textField;

	private JButton btnEnde;
	private JButton btnStatistikAnzeigen;
	private JButton btnGo;

	private JLabel lbTBeschreibung;
	private JLabel lblTFestgelegteWrfelzahl;
	private JLabel lbThrowAmountDisplay;

	private JLabel lblTAnzahl;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	private JLabel lblTAmount;
	private JLabel lblShow1;
	private JLabel lblShow2;
	private JLabel lblShow3;
	private JLabel lblShow4;
	private JLabel lblShow5;
	private JLabel lblShow6;

	private JLabel lblCalculating;

	final JProgressBar progressBar = new JProgressBar();

	public MachEnde() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setTitle("Mach ein Ende!");
		initKomponenten();
		setVisible(true);
	}

	private void initKomponenten() {
		getContentPane().setLayout(null);

		btnEnde = new JButton("Beenden");
		btnEnde.setBounds(199, 230, 175, 20);

		btnStatistikAnzeigen = new JButton("Würfelzahl festlegen");
		btnStatistikAnzeigen.setBounds(199, 73, 175, 20);
		btnStatistikAnzeigen.addActionListener(saveThrowAmount);

		btnGo = new JButton("Würfeln!");
		btnGo.setBounds(199, 104, 175, 20);
		btnGo.addActionListener(doWuerfeling);

		lbTBeschreibung = new JLabel("Bitte Würfelanzahl eingeben");
		lbTBeschreibung.setBounds(10, 11, 175, 20);
		btnEnde.addActionListener(quit);

		lblTFestgelegteWrfelzahl = new JLabel("Festgelegte Würfelzahl");
		lblTFestgelegteWrfelzahl.setBounds(209, 11, 175, 20);

		lbThrowAmountDisplay = new JLabel("2147483647");
		lbThrowAmountDisplay.setBounds(209, 42, 175, 20);

		lblTAnzahl = new JLabel("Anzahl");
		lblTAnzahl.setBounds(10, 76, 46, 14);

		lbl1 = new JLabel("1:");
		lbl1.setBounds(10, 104, 46, 14);

		lbl2 = new JLabel("2:");
		lbl2.setBounds(10, 129, 46, 14);

		lbl3 = new JLabel("3:");
		lbl3.setBounds(10, 154, 46, 14);

		lbl4 = new JLabel("4:");
		lbl4.setBounds(10, 179, 46, 14);

		lbl5 = new JLabel("5:");
		lbl5.setBounds(10, 204, 46, 14);

		lbl6 = new JLabel("6:");
		lbl6.setBounds(10, 229, 46, 14);

		lblTAmount = new JLabel("Häufigkeit");
		lblTAmount.setBounds(66, 76, 72, 14);

		lblShow1 = new JLabel();
		lblShow1.setBackground(SystemColor.textHighlight);
		lblShow1.setOpaque(true);
		lblShow1.setBounds(66, 104, 72, 14);

		lblShow2 = new JLabel();
		lblShow2.setBackground(SystemColor.textHighlight);
		lblShow2.setOpaque(true);
		lblShow2.setBounds(66, 129, 72, 14);

		lblShow3 = new JLabel();
		lblShow3.setBackground(SystemColor.textHighlight);
		lblShow3.setOpaque(true);
		lblShow3.setBounds(66, 154, 72, 14);

		lblShow4 = new JLabel();
		lblShow4.setBackground(SystemColor.textHighlight);
		lblShow4.setOpaque(true);
		lblShow4.setBounds(66, 179, 72, 14);

		lblShow5 = new JLabel();
		lblShow5.setBackground(SystemColor.textHighlight);
		lblShow5.setOpaque(true);
		lblShow5.setBounds(66, 204, 72, 14);

		lblShow6 = new JLabel();
		lblShow6.setBackground(SystemColor.textHighlight);
		lblShow6.setOpaque(true);
		lblShow6.setBounds(66, 229, 72, 14);

		lblCalculating = new JLabel("Calculating...");
		lblCalculating.setVisible(false);
		lblCalculating.setBounds(199, 154, 175, 20);

		textField = new JTextField();
		textField.setBounds(10, 42, 175, 20);
		textField.setColumns(10);
		textField.setToolTipText("Nur positive ganze Zahlen eingeben!");

		// progressBar = new JProgressBar();
		progressBar.setBounds(199, 175, 175, 18);
		progressBar.setMaximum(0);
		progressBar.setMaximum(1000000);
		progressBar.setValue(0);

		// Module hinzufügen
		getContentPane().add(btnStatistikAnzeigen);
		getContentPane().add(btnEnde);
		getContentPane().add(btnGo);
		getContentPane().add(lbTBeschreibung);
		getContentPane().add(lbThrowAmountDisplay);
		getContentPane().add(lblTFestgelegteWrfelzahl);
		getContentPane().add(lblTAnzahl);
		getContentPane().add(lbl1);
		getContentPane().add(lbl2);
		getContentPane().add(lbl3);
		getContentPane().add(lbl4);
		getContentPane().add(lbl5);
		getContentPane().add(lbl6);
		getContentPane().add(lblTAmount);
		getContentPane().add(lblShow1);
		getContentPane().add(lblShow2);
		getContentPane().add(lblShow3);
		getContentPane().add(lblShow4);
		getContentPane().add(lblShow5);
		getContentPane().add(lblShow6);
		getContentPane().add(lblCalculating);
		getContentPane().add(textField);
		getContentPane().add(progressBar);

	}

	public static void main(String[] args) {
		new MachEnde();
	}

	ActionListener saveThrowAmount = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				throwAmount = Integer.parseInt(textField.getText());
				if (throwAmount < 0) {
					throw new NumberFormatException();
				}
				lbThrowAmountDisplay.setText(throwAmount.toString());
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Bitte eine gültige Zahl eingeben!", "WARNING",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	};

	ActionListener doWuerfeling = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			final int max = 6;
			final int min = 1;
			lblCalculating.setVisible(true);
			final Integer throwAmountfromField = Integer.parseInt(lbThrowAmountDisplay.getText());
			progressBar.setValue(0);
			progressBar.setMaximum(throwAmountfromField);

			try {
				if (throwAmountfromField <= 0) {
					throw new NumberFormatException();
				}

				Integer[] numberCounter = new Integer[max];

				for (int i = 0; i < numberCounter.length; i++) {
					numberCounter[i] = 0;
				}

				JLabel[] labelList = { lblShow1, lblShow2, lblShow3, lblShow4, lblShow5, lblShow6 };

				for (int i = 0; i < throwAmountfromField; i++) {
					final int percent = i;
					int temp = (int) ((Math.random() * max) + min);
					numberCounter[temp - 1]++;
					try {
						SwingUtilities.invokeLater(new Runnable() {

							@Override
							public void run() {
								progressBar.setValue(percent);
							}
						});
					} catch (Exception e3) {
					}

				}
				for (int i = 0; i < numberCounter.length; i++) {
					labelList[i].setText(numberCounter[i].toString());
				}

			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Bitte vorher eine gültige Zahl festlegen!", "WARNING",
						JOptionPane.ERROR_MESSAGE);
			}
			lblCalculating.setVisible(false);
		}

	};

	ActionListener quit = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);

		}
	};

}
