package code;
/*
 * TurnFriendly-Project
 *
 * $Header: /cvs/turnfriendly/src/com/turnfriendly/util/ResourceFinder.java,v 1.3 2015-09-25 07:59:30 jschuler Exp $
 * $Revision: 1.3 $
 * $Date: 2015-09-25 07:59:30 $
 * Created on 21.11.2006 
 * ====================================================================
 *
 * Copyright (c) 2002-2015 Fiprox AG.  
 * All rights reserved.
 */


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;


/**
 * @author hkuhn
 *
 */
public class ResourceFinder {

	public static Properties findProperties(String filename) {
			InputStream is = null;
	        Properties props = new Properties();
	        try {
	        	is = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
	        }
	        catch (Exception e) {
	        	e.printStackTrace();
			}
	        if(is == null) {
	        	 try {
	        		 is = ResourceFinder.class.getResourceAsStream(filename);
	             }
	             catch (Exception e) {
	            	 e.printStackTrace();
	     		}
	        	
	        }
	        if(is == null) {
	       	 try {
	       		 is = ResourceFinder.class.getClassLoader().getResourceAsStream(filename);
	            }
	            catch (Exception e) {
	            	e.printStackTrace();
	    		}
	       	
	       }
	        try {
	            if(is != null) {
	                is = new BufferedInputStream(is);
	//                System.out.println("the specified file : '" + filename + "' from the class resource path.");
	            } else {
	                is = new BufferedInputStream(new FileInputStream(filename));
	//                System.out.println("the specified file : '" + filename + "'");
	            }
	            props.load(is);
	        } catch (IOException ioe) {
	            throw new RuntimeException("Properties file: '"
	                    + filename + "' could not be read.", ioe);
	        }
	        finally {
	        	if(is != null)
	        		try { is.close(); } catch(IOException ignore) {}
	        }
			return props;
	}

	public static URL findResourceAsUrl(String filename) {
		URL url = null;
		try {
			url = Thread.currentThread().getContextClassLoader().getResource(filename);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		if (url == null) {
			try {
				url = ResourceFinder.class.getResource(filename);
			}
			catch (Exception e) {
				e.printStackTrace();
			}

		}
		if (url == null) {
			try {
				url = ResourceFinder.class.getClassLoader().getResource(filename);
			}
			catch (Exception e) {
				e.printStackTrace();
			}

		}

		if (url != null) {
			return url;
			// System.out.println("the specified file : '" + filename + "' from the class resource path.");
		}
		else {
			System.out.println("the specified file : '" + filename + "' could not be found from the class resource path.");
		}

		return url;
	}
}
