package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

public class Main {
	// Lokale IP adresse
	// public static void main(String a[]) {
	//
	// try {
	// InetAddress ipAddr = InetAddress.getLocalHost();
	// System.out.println(ipAddr.getHostAddress());
	// } catch (UnknownHostException ex) {
	// ex.printStackTrace();
	// }
	// }

	public static void main(String[] arguments) {
		getIpAdress();
		new ServerGUI(8080);
		new ClientGUI(getIpAdress(), 1500);
	}

	/**
	 * Gets the Internet IP - Adress. If there is no internet connection it gets the
	 * local instead.
	 */
	public static String getIpAdress() {
		String systemIpAddress = "";
		try {
			URL url_name = new URL("http://bot.whatismyipaddress.com");
			BufferedReader sc = new BufferedReader(new InputStreamReader(url_name.openStream()));
			systemIpAddress = sc.readLine().trim();
			if (!(systemIpAddress.length() > 0)) {
				try {
					InetAddress localhost = InetAddress.getLocalHost();
					System.out.println((localhost.getHostAddress()).trim());
					systemIpAddress = (localhost.getHostAddress()).trim();
				} catch (Exception e1) {
					systemIpAddress = "Cannot Execute Properly";
				}
			}
		} catch (Exception e2) {
			systemIpAddress = "Cannot Execute Properly";
		}
		System.out.println("Your IP Address: " + systemIpAddress + "\n");
		return systemIpAddress;
	}

}
