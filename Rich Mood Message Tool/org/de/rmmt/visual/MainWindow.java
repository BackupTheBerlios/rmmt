package org.de.rmmt.visual;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Properties;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Button;

import com.skype.connector.Connector;

public class MainWindow {
	
	private Shell sShell = null;
	private Menu menuBar = null;
	private Text textArea = null;
	private Display display;
	private Button bold = null;
	private Button italic = null;
	private Button underlined = null;
	private Button color_button = null;
	private String language = null;
	private Button link = null;
	private Button HTML = null;
	private Button blinking = null;
	private Properties props;
	private Button smilys = null;
	private Button ok = null;
	private Button laden = null;
	private Button center = null;

	public MainWindow(String language, Properties props){
		this.language = language;
		this.props = props;
	}
	
	public void show(){
		createSShell();
		
		sShell.open();
		try{
			while (!sShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		display.dispose();
	}
	
	/**
	 * This method initializes sShell
	 */
	private void createSShell() {
		display = new Display();
		sShell = new Shell();
		sShell.setText(props.getProperty("Titel"));
		sShell.setSize(new Point(417, 290));
		sShell.setLayout(null);
		sShell.setImage(new Image(display,MainWindow.class.getResourceAsStream("icon.png")));
		textArea = new Text(sShell, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.H_SCROLL);
		textArea.setBounds(new Rectangle(0, 63, 411, 130));
		bold = new Button(sShell, SWT.NONE);
		bold.setBounds(new Rectangle(0, 0, 28, 28));
		italic = new Button(sShell, SWT.NONE);
		italic.setBounds(new Rectangle(33, 0, 28, 28));
		underlined = new Button(sShell, SWT.NONE);
		underlined.setBounds(new Rectangle(66, 0, 28, 28));
		blinking = new Button(sShell, SWT.NONE);
		blinking.setBounds(new Rectangle(99, 0, 66, 28));
		blinking.setText(props.getProperty("Blinkend"));
		italic.setImage(new Image(display,MainWindow.class.getResourceAsStream(language+ "/k.gif")));
		bold.setImage(new Image(display,MainWindow.class.getResourceAsStream(language+ "/f.gif")));
		underlined.setImage(new Image(display,MainWindow.class.getResourceAsStream(language+ "/u.gif")));
		color_button = new Button(sShell, SWT.NONE);
		color_button.setBounds(new Rectangle(300, 0, 62, 28));
		color_button.setText(props.getProperty("Farbe"));
		link = new Button(sShell, SWT.NONE);
		link.setBounds(new Rectangle(175, 0, 45, 28));
		link.setText(props.getProperty("Link"));
		HTML = new Button(sShell, SWT.NONE);
		HTML.setBounds(new Rectangle(229, 0, 62, 28));
		HTML.setText(props.getProperty("HTML"));
		smilys = new Button(sShell, SWT.NONE);
		smilys.setBounds(new Rectangle(0, 32, 62, 28));
		smilys.setText(props.getProperty("Smilys"));
		ok = new Button(sShell, SWT.NONE);
		ok.setBounds(new Rectangle(279, 200, 85, 24));
		ok.setText(props.getProperty("Übernehmen"));
		laden = new Button(sShell, SWT.NONE);
		laden.setBounds(new Rectangle(118, 200, 99, 24));
		laden.setText(props.getProperty("Laden"));
		center = new Button(sShell, SWT.NONE);
		center.setBounds(new Rectangle(71, 32, 75, 28));
		center.setText(props.getProperty("Center"));
		
		italic.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				appendText("<i></i>");
			}
		});
		bold.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				appendText("<b></b>");
			}
		});
		underlined.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				appendText("<u></u>");
			}
		});
		blinking.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				appendText("<blink></blink>");
			}
		});
		link.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				display.asyncExec(new Runnable(){
					public void run(){
						final String s = new LinkDialog(props, sShell).show();
						display.syncExec(new Runnable(){
							public void run(){
								appendText(s);
							}
						});						
					}
				});
			}
		});
		smilys.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				display.asyncExec(new Runnable(){
					public void run(){
						final String s = new SmilyDialog(props, sShell).show();
						display.syncExec(new Runnable(){
							public void run(){
								appendText(s);
							}
						});						
					}
				});
			}
		});
		color_button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {	
				display.asyncExec(new Runnable(){
					public void run(){
						ColorDialog cd = new ColorDialog(sShell, SWT.NONE);
						RGB rgb = cd.open();
						if(rgb != null){
							final String hex = Integer.toHexString( new Color(rgb.red, rgb.green, rgb.blue).getRGB() & 0x00ffffff);
							appendText("<font color=\"#"+ hex+ "\"></font>");
						}							
					}
				});
			}
		});
		HTML.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				appendText("<html></html>");
			}
		});
		center.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				appendText("<center></center>");
			}
		});
		ok.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				updateMoodMessage(textArea.getText());
			}
		});
		laden.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				display.asyncExec(new Runnable(){
					public void run() {
						try{
							textArea.setText(Connector.getInstance().execute("GET PROFILE RICH_MOOD_TEXT", "PROFILE").substring(23));
						}
						catch(Exception e){
							ErrorDialog.displayError(e);
						}
					}
				});
			}
		});
		
		menuBar = new Menu(sShell, SWT.BAR);
		initalizeMenuBar();
		sShell.setMenuBar(menuBar);
	}
	
	private void initalizeMenuBar(){
		/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
		 * * * * * * * * * * * * * D A T E I * * * * * * * * * * * * *
		 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
		MenuItem datei = new MenuItem(menuBar, SWT.CASCADE);
		datei.setText(props.getProperty("Datei"));
		Menu dateim = new Menu(sShell, SWT.DROP_DOWN);
		datei.setMenu(dateim);
		
		MenuItem oeffnen = new MenuItem(dateim, SWT.PUSH);
		oeffnen.setText(props.getProperty("Öffnen"));
		oeffnen.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new Thread(){
					public void run(){
						display.asyncExec(new Runnable(){
							public void run(){
								FileDialog fd = new FileDialog(sShell, SWT.OPEN);
								fd.setFilterExtensions(new String[]{"*.txt"});
								fd.setFilterNames(new String[]{props.getProperty("textdesc")});
								String s = fd.open();
								if(s != null){
									try{
										FileInputStream fin = new FileInputStream(s);
										BufferedReader in = new BufferedReader(new InputStreamReader(fin));
										textArea.setText("");
										String text = "";
										while(in.ready()){
											text = text.concat(in.readLine());
										}
										textArea.setText(text);
										in.close();
									}
									catch(IOException e){
										ErrorDialog.displayError(e);
									}
								}
							}
						});
					}
				}.start();
				display.asyncExec(new Runnable(){
					public void run(){
				
					}
				});
			}
		});
		
		MenuItem speichern = new MenuItem(dateim, SWT.PUSH);
		speichern.setText(props.getProperty("Speichern"));
		speichern.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new Thread(){
					public void run(){
						display.asyncExec(new Runnable(){
							public void run(){
								FileDialog fd = new FileDialog(sShell, SWT.SAVE);
								fd.setFilterExtensions(new String[]{"*.txt"});
								fd.setFilterNames(new String[]{props.getProperty("textdesc")});
								String s = fd.open();
								if(s != null){
									try{
										FileOutputStream fout = new FileOutputStream(s);
										PrintWriter out = new PrintWriter(fout);
										out.print(textArea.getText());
										out.flush();
										out.close();
										fout.close();
									}
									catch(IOException e){
										ErrorDialog.displayError(e);
									}
								}
							}
						});
					}
				}.start();
				display.asyncExec(new Runnable(){
					public void run(){
				
					}
				});
			}
		});
		
		new MenuItem(dateim,SWT.SEPARATOR);
		
		MenuItem beenden = new MenuItem(dateim, SWT.PUSH);
		beenden.setText(props.getProperty("Beenden"));
		beenden.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				display.asyncExec(new Runnable(){
					public void run(){
						sShell.dispose();
					}
				});
			}
		});
		
		
		/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
		 * * * * * * * * * * * * * H I L F E * * * * * * * * * * * * * 
		 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
		MenuItem help = new MenuItem(menuBar, SWT.CASCADE);
		help.setText(props.getProperty("Hilfe"));
		Menu helpm = new Menu(sShell, SWT.DROP_DOWN);
		help.setMenu(helpm);
		
		MenuItem ueber = new MenuItem(helpm, SWT.PUSH);
		ueber.setText(props.getProperty("Ueber"));
		ueber.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				display.asyncExec(new Runnable(){
					public void run(){
						new About(props, sShell).show();
					}
				});
			}
		});
	}
	
	private void appendText(String text){
		if(text != null){
			String current_text = textArea.getText();
			current_text = current_text.concat(text);
			textArea.setText(current_text);
		}
	}
	
	private void updateMoodMessage(final String s){
		new Thread(){
			public void run(){
				try{
					System.out.println(Connector.getInstance().connect());
					Connector.getInstance().execute("SET PROFILE RICH_MOOD_TEXT "+ s, "PROFILE");
				}
				catch(Exception e){
					ErrorDialog.displayError(e, props.getProperty("Error_MOOD"));
				}
			}
		}.start();
	}

}