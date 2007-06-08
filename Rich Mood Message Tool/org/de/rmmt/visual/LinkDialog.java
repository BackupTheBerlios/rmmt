package org.de.rmmt.visual;

import java.util.Properties;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class LinkDialog {

	private Shell sShell = null;  //  @jve:decl-index=0:visual-constraint="10,10"
	private Label url = null;
	private Text url_text = null;
	private Label text = null;
	private Text text_text = null;
	private Button button = null;
	private Button button1 = null;
	private Properties props = null;
	//private Display display = null;
	private String return_value = "";
	private Shell shell;
	
	public LinkDialog(Properties props, Shell shell){
		this.props = props;
		this.shell = shell;
	}

	/**
	 * This method initializes sShell
	 */
	private void createSShell() {
		sShell = new Shell(shell, SWT.DIALOG_TRIM | SWT.PRIMARY_MODAL);
		sShell.setText(props.getProperty("Titel_URL"));
		sShell.setSize(new Point(300, 151));
		sShell.setLayout(null);
		sShell.setImage(new Image(sShell.getDisplay(),MainWindow.class.getResourceAsStream("icon.png")));
		url = new Label(sShell, SWT.NONE);
		url.setBounds(new Rectangle(2, 0, 289, 20));
		url.setText(props.getProperty("URL"));
		url_text = new Text(sShell, SWT.BORDER);
		url_text.setBounds(new Rectangle(0, 22, 291, 20));
		text = new Label(sShell, SWT.NONE);
		text.setBounds(new Rectangle(2, 44, 289, 20));
		text.setText(props.getProperty("Text"));
		text_text = new Text(sShell, SWT.BORDER);
		text_text.setBounds(new Rectangle(0, 66, 291, 20));
		button = new Button(sShell, SWT.NONE);
		button.setBounds(new Rectangle(15, 91, 71, 24));
		button.setText(props.getProperty("Abbrechen"));
		button1 = new Button(sShell, SWT.NONE);
		button1.setBounds(new Rectangle(165, 91, 71, 24));
		button1.setText(props.getProperty("Ok"));
		button1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				return_value = "<a href=\""+ url_text.getText()+ 
					"\" alt=\""+ text_text.getText()+ "\">"
					+ text_text.getText()+"</a>";
				sShell.dispose();
			}
		});
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				sShell.dispose();
			}
		});
	}
	
	public String show(){
		createSShell();
		
		sShell.open();
		Display display = sShell.getDisplay();
		while (!sShell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		return return_value;
	}

}
