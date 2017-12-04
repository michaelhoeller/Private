package code;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class ResourceFinder {

	public static Properties findProperties(String filename) {
		InputStream is = null;
		Properties props = new Properties();
		try {
			is = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (is == null) {
			try {
				is = ResourceFinder.class.getResourceAsStream(filename);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		if (is == null) {
			try {
				is = ResourceFinder.class.getClassLoader().getResourceAsStream(filename);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		try {
			if (is != null) {
				is = new BufferedInputStream(is);
				// System.out.println("the specified file : '" + filename + "' from the class
				// resource path.");
			} else {
				is = new BufferedInputStream(new FileInputStream(filename));
				// System.out.println("the specified file : '" + filename + "'");
			}
			props.load(is);
		} catch (IOException ioe) {
			throw new RuntimeException("Properties file: '" + filename + "' could not be read.", ioe);
		} finally {
			if (is != null)
				try {
					is.close();
				} catch (IOException ignore) {
				}
		}
		return props;
	}

	public static URL findResourceAsUrl(String filename) {
		URL url = null;
		try {
			url = Thread.currentThread().getContextClassLoader().getResource(filename);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (url == null) {
			try {
				url = ResourceFinder.class.getResource(filename);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		if (url == null) {
			try {
				url = ResourceFinder.class.getClassLoader().getResource(filename);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if (url != null) {
			return url;
			// System.out.println("the specified file : '" + filename + "' from the class
			// resource path.");
		} else {
			System.out.println(
					"the specified file : '" + filename + "' could not be found from the class resource path.");
		}

		return url;
	}
}
