package com.koo.utils;

import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.image.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

public class CommonUtils {
	private static Logger LOGGER = Logger.getLogger(CommonUtils.class);

	public static BufferedImage resize(BufferedImage image, int width, int height) {
		BufferedImage resizeImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D grap = resizeImage.createGraphics();
		grap.drawImage(image, 0, 0, width, height, null);
		grap.dispose();
		return resizeImage;
	}

	public static BufferedReader executeProcess(String[] cmdArray, String[] env, String... args)
			throws IOException, InterruptedException {
		Process proc;
		LOGGER.info("Running proc with name " + cmdArray[0]);

		if (args != null) {
			proc = Runtime.getRuntime().exec(cmdArray, env, new File(args[0]));
		} else {
			proc = Runtime.getRuntime().exec(cmdArray, env);
		}

		proc.waitFor();
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));

		LOGGER.info("Output is " + stdInput.toString());

		return stdInput;
	}

	public static BufferedReader executeProcess(String cmdProcess) throws IOException, InterruptedException {
		LOGGER.info("Running proc with name " + cmdProcess);
		Process proc = Runtime.getRuntime().exec(cmdProcess);
		proc.waitFor();
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		LOGGER.info("Output is " + stdInput.toString());
		return stdInput;
	}

	public static void copyTextToClipboard(String text) {
		StringSelection selection = new StringSelection(text);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, selection);
		LOGGER.info("Text " + text + " is copied to Clipborad");
	}
	
	// function to generate a random string of length n
	public static String getAlphaString(int n)
    {
  
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                                    
  
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
  
        for (int i = 0; i < n; i++) {
  
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                = (int)(AlphaNumericString.length()
                        * Math.random());
  
            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                          .charAt(index));
        }
  
        return sb.toString();
    }
    
	public static String getAlphaNumericString(int n)
    {
  
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz";
  
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
  
        for (int i = 0; i < n; i++) {
  
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                = (int)(AlphaNumericString.length()
                        * Math.random());
  
            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                          .charAt(index));
        }
  
        return sb.toString();
    }
	
	public static String generateNumericNumber(int n)
    {
  
        // chose a Character random from this String
        String AlphaNumericString =  "0123456789";
                                  
                                   
  
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);
  
        for (int i = 0; i < n; i++) {
  
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                = (int)(AlphaNumericString.length()
                        * Math.random());
  
            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                          .charAt(index));
        }
  
        return sb.toString();
    }
	public static boolean isLinux(){
	    String os = System.getProperty("os.name");  
	    return os.toLowerCase().indexOf("linux") >= 0;
	}

	public static boolean isWindows(){
	    String os = System.getProperty("os.name");
	    return os.toLowerCase().indexOf("windows") >= 0;
	}
	
	public static void runCommand(String... command) {
	    ProcessBuilder processBuilder = new ProcessBuilder().command(command);
	    processBuilder.directory(new File("C:/"));
	 
	    try {
	        Process process = processBuilder.start();
	 
	        //read the output
	        InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream());
	        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
	        String output = null;
	        while ((output = bufferedReader.readLine()) != null) {
	            System.out.println(output);
	        }
	 
	        //wait for the process to complete
	        process.waitFor();
	 
	        //close the resources
	        bufferedReader.close();
	        process.destroy();
	 
	    } catch (IOException | InterruptedException e) {
	        e.printStackTrace();
	    }
	}

}
