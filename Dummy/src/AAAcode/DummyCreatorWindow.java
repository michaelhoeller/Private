package AAAcode;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;

public class DummyCreatorWindow {

	private JFrame frmDummyGeneratorV;
	private JTextField textFieldSaveLocation;
	private JTextField textFieldDummyAmount;
	static JProgressBar progressBar = new JProgressBar(0, 1000000 );

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					DummyCreatorWindow window = new DummyCreatorWindow();
					window.frmDummyGeneratorV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DummyCreatorWindow() {
		initialize();
	}

	static class ButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 1; i <= progressBar.getMaximum(); ++i) {
						final int j = i;

						SwingUtilities.invokeLater(new Runnable() {
							@Override
							public void run() {
								progressBar.setValue(j);
								System.out.println("Test " + j);
								// try {
								// Thread.sleep(10);
								// } catch (InterruptedException e) {
								// // TODO Auto-generated catch block
								// e.printStackTrace();
								// }
							}
						});
					}
				}
			}).start();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDummyGeneratorV = new JFrame();
		frmDummyGeneratorV.setResizable(false);
		frmDummyGeneratorV.setBackground(new Color(0, 255, 127));
		frmDummyGeneratorV.setForeground(new Color(0, 0, 0));
		frmDummyGeneratorV.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		frmDummyGeneratorV.setTitle("Dummy Generator V1.0");
		frmDummyGeneratorV.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(DummyCreatorWindow.class.getResource("/recourses/elite-dangerous-logo_grey.png")));
		frmDummyGeneratorV.getContentPane().setBackground(new Color(176, 196, 222));

		JButton btnCreate = new JButton("Dummys Generieren");
		btnCreate.setForeground(new Color(0, 0, 0));
		btnCreate.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnCreate.setBackground(new Color(46, 139, 87));
		btnCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Main.doStuff(textFieldSaveLocation.getText(), Integer.parseInt(textFieldDummyAmount.getText()));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		progressBar.setForeground(new Color(0, 0, 0));

		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(new ButtonActionListener());

		btnAbbrechen.setForeground(Color.BLACK);
		btnAbbrechen.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		btnAbbrechen.setBackground(new Color(255, 69, 0));

		JLabel labelTitel = new JLabel("Dummy-Generator f\u00FCr User/Stakeholder");
		labelTitel.setFont(new Font("Segoe UI", Font.BOLD, 20));

		JLabel labelSaveLocation = new JLabel("Speicherort der Dummy Datei");
		labelSaveLocation.setFont(new Font("Segoe UI", Font.PLAIN, 16));

		JLabel lblAnzahl = new JLabel("Anzahl der gew\u00FCnschten Dummys");
		lblAnzahl.setFont(new Font("Segoe UI", Font.PLAIN, 16));

		textFieldSaveLocation = new JTextField();
		textFieldSaveLocation.setText("C://Users/Administrator/Desktop/DummyFile.sql");// C:\Users\Administrator\Desktop
		textFieldSaveLocation.setColumns(10);

		textFieldDummyAmount = new JTextField();
		textFieldDummyAmount.setColumns(10);

		JToggleButton tglbtnUserGenerieren = new JToggleButton("User generieren");
		tglbtnUserGenerieren.setSelected(true);
		tglbtnUserGenerieren.setFont(new Font("Segoe UI", Font.PLAIN, 16));

		JToggleButton tglbtnStakeholderGenerieren = new JToggleButton("Stakeholder generieren");
		tglbtnStakeholderGenerieren.setFont(new Font("Segoe UI", Font.PLAIN, 16));

		tglbtnUserGenerieren.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (tglbtnUserGenerieren.isSelected() == false) {
					tglbtnStakeholderGenerieren.setSelected(true);
				} else if (tglbtnUserGenerieren.isSelected() == true) {
					tglbtnStakeholderGenerieren.setSelected(false);
				}

			}
		});

		tglbtnStakeholderGenerieren.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (tglbtnStakeholderGenerieren.isSelected() == false) {
					tglbtnUserGenerieren.setSelected(true);
				} else if (tglbtnStakeholderGenerieren.isSelected() == true) {
					tglbtnUserGenerieren.setSelected(false);
				}

			}
		});

		GroupLayout groupLayout = new GroupLayout(frmDummyGeneratorV.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup().addComponent(btnAbbrechen)
														.addPreferredGap(ComponentPlacement.RELATED, 462,
																Short.MAX_VALUE)
														.addComponent(btnCreate))
												.addComponent(progressBar, GroupLayout.DEFAULT_SIZE, 774,
														Short.MAX_VALUE)
												.addComponent(labelTitel, GroupLayout.DEFAULT_SIZE, 774,
														Short.MAX_VALUE))
										.addContainerGap())
								.addGroup(
										groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
														.addComponent(labelSaveLocation, GroupLayout.PREFERRED_SIZE,
																220, GroupLayout.PREFERRED_SIZE)
														.addComponent(textFieldDummyAmount)
														.addComponent(lblAnzahl, GroupLayout.PREFERRED_SIZE, 220,
																Short.MAX_VALUE)
														.addComponent(textFieldSaveLocation))
												.addPreferredGap(ComponentPlacement.RELATED, 298, Short.MAX_VALUE)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(tglbtnStakeholderGenerieren,
																GroupLayout.PREFERRED_SIZE, 225,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(tglbtnUserGenerieren, GroupLayout.PREFERRED_SIZE,
																225, GroupLayout.PREFERRED_SIZE))
												.addGap(24)))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(labelTitel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE).addGap(37)
						.addComponent(labelSaveLocation).addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(textFieldSaveLocation, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(lblAnzahl, GroupLayout.PREFERRED_SIZE, 22,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(textFieldDummyAmount,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(tglbtnUserGenerieren, GroupLayout.PREFERRED_SIZE, 82,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(tglbtnStakeholderGenerieren, GroupLayout.PREFERRED_SIZE, 82,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
						.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnCreate)
								.addComponent(btnAbbrechen))
						.addContainerGap()));
		frmDummyGeneratorV.getContentPane().setLayout(groupLayout);
		frmDummyGeneratorV.setBounds(100, 100, 800, 600);
		frmDummyGeneratorV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
