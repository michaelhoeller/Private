package gui.einstieg;

import javax.swing.JFrame;

public abstract class SuperGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SuperGUI(String title) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);
		setTitle(title);
		initKomponenten();
		setVisible(true);
	}

	protected abstract void initKomponenten();

	protected abstract void destroyWindow();

}
