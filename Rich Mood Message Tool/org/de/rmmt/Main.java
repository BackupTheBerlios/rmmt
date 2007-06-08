package org.de.rmmt;

import java.util.Properties;

import org.de.rmmt.visual.ErrorDialog;
import org.de.rmmt.visual.LanguageChooser;
import org.de.rmmt.visual.MainWindow;

public class Main {
	public static void main(String args[]){
		System.out.println(System.getProperty("os.version"));
		Properties props = new Properties();
		try{
			String lang = new LanguageChooser().show().toLowerCase();
			if(lang != null && (!lang.equals(""))){
				props.load(Main.class.getResourceAsStream(lang+ ".lang"));
				new MainWindow(lang, props).show();
			}
			System.exit(0);
		}
		catch(Exception e){
			e.printStackTrace();
			ErrorDialog.displayError(e);
		}
	}
}
