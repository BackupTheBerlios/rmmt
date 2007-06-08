package org.de.rmmt.visual;

import java.awt.Desktop;
import java.net.URI;
import java.util.Properties;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Link;

public class About {

	private Shell sShell = null;  //  @jve:decl-index=0:visual-constraint="10,10"
	private Label skype_logo = null;
	private Label skype_legal = null;
	private Label skype_extra = null;
	private Label copyright = null;
	private Properties props;
	private Shell s;
	private Link link = null;

	public About(Properties props, Shell s){
		this.props = props;
		this.s = s;
	}
	
	public About(){}
	
	/**
	 * This method initializes sShell
	 */
	private void createSShell() {
		sShell = new Shell(s, SWT.DIALOG_TRIM | SWT.PRIMARY_MODAL);
		sShell.setText(props.getProperty("Ueber"));
		sShell.setSize(new Point(300, 312));
		sShell.setImage(new Image(sShell.getDisplay(),MainWindow.class.getResourceAsStream("icon.png")));
		sShell.setLayout(null);
		skype_logo = new Label(sShell, SWT.NONE);
		skype_logo.setBounds(new Rectangle(0, 128, 128, 128));
		skype_logo.setImage(new Image(Display.getCurrent(), About.class.getResourceAsStream("skype.png")));
		skype_legal = new Label(sShell, SWT.NONE);
		skype_legal.setBounds(new Rectangle(129, 128, 161, 128));
		skype_legal.setText(props.getProperty("Skype_Legal"));
		skype_extra = new Label(sShell, SWT.NONE);
		skype_extra.setBounds(new Rectangle(0, 0, 128, 128));
		skype_extra.setImage(new Image(Display.getCurrent(), About.class.getResourceAsStream("services.png")));
		copyright = new Label(sShell, SWT.NONE);
		copyright.setBounds(new Rectangle(129, 0, 161, 128));
		copyright.setText(props.getProperty("Copyright"));
		
		link = new Link(sShell, SWT.NONE);
		link.setBounds(new Rectangle(33, 260, 218, 17));
		link.setText("<a href=\"http://forum.meinskype.de/ftopic4492.html\">http://forum.meinskype.de/ftopic4492.html</a>");
		link.addSelectionListener(new SelectionListener(){
			public void widgetDefaultSelected(SelectionEvent e) {
			}
			public void widgetSelected(SelectionEvent e) {
				try{
					Desktop.getDesktop().browse(new URI("http://forum.meinskype.de/ftopic4492.html"));
				}
				catch(Exception f){
					ErrorDialog.displayError(f);
				}
			}
		});
	}
	
	public void show(){
		createSShell();
		
		sShell.open();
		Display display = sShell.getDisplay();
		while (!sShell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

}
