package org.de.rmmt.visual;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Button;

public class LanguageChooser {

	private Shell sShell = null;  //  @jve:decl-index=0:visual-constraint="10,10"
	private Label label = null;
	private CCombo cCombo = null;
	private Button button = null;
	private Display display;
	private String return_value = "German";

	/**
	 * This method initializes sShell
	 */
	private void createSShell() {
		display = new Display();
		sShell = new Shell(display, SWT.DIALOG_TRIM);
		sShell.setText("Language");
		sShell.setSize(new Point(300, 101));
		sShell.setLayout(null);
		sShell.setImage(new Image(display,MainWindow.class.getResourceAsStream("icon.png")));
		label = new Label(sShell, SWT.NONE);
		label.setBounds(new Rectangle(0, 0, 291, 17));
		label.setText("Please select your language!");
		cCombo = new CCombo(sShell, SWT.NONE);
		cCombo.setBounds(new Rectangle(0, 18, 292, 21));
		cCombo.add("English");
		cCombo.add("German");
		cCombo.setEditable(false);
		cCombo.select(1);
		button = new Button(sShell, SWT.NONE);
		button.setBounds(new Rectangle(103, 40, 57, 24));
		button.setText("OK");
		cCombo.addSelectionListener(new SelectionListener(){
			public void widgetDefaultSelected(SelectionEvent e) {
			}
			public void widgetSelected(SelectionEvent e) {
				return_value = cCombo.getItem(cCombo.getSelectionIndex());
			}
		});
		button.addSelectionListener(new SelectionListener(){
			public void widgetDefaultSelected(SelectionEvent e) {
			}
			public void widgetSelected(SelectionEvent e) {
				sShell.dispose();
			}
		});
	}
	
	public String show(){
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
		
		return return_value;
	}

}
