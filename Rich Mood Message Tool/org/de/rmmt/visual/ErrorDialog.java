package org.de.rmmt.visual;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;

public class ErrorDialog {

	public static final int OK = 1;
	public static final int CANCEL = 0;
	private static int return_value;

	public static void main(String args[]){
		displayError("Test");
		try{
			if(0/0==-1)
				return;
		}
		catch(Exception e){
			displayError(e);
		}
	}
	
	public static int displayError(final String error) {
		Thread t = new Thread(){
			public void run(){
				System.out.println(error);
				final Display display = new Display();
				GridData gridData = new GridData();
				gridData.horizontalSpan = 2;
				GridLayout gridLayout = new GridLayout();
				gridLayout.numColumns = 2;
				gridLayout.marginHeight = 0;
				gridLayout.marginWidth = 0;
				gridLayout.verticalSpacing = 0;
				gridLayout.horizontalSpacing = 0;
				final Shell sShell = new Shell(display, SWT.TITLE);
				sShell.setText("Error!");
				sShell.setLayout(gridLayout);
				Label label = new Label(sShell, SWT.NONE);
				label.setText(error);
				label.setLayoutData(gridData);
				Button ok = new Button(sShell, SWT.NONE);
				ok.setText("OK");
				ok.addMouseListener(new MouseListener(){
					public void mouseDoubleClick(MouseEvent e) {
					}
					public void mouseDown(MouseEvent e) {
					}
					public void mouseUp(MouseEvent e) {
						return_value = OK;
						display.asyncExec(new Runnable(){
							public void run() {
								sShell.dispose();
							}
						});
					}
				});
				ok.addMouseListener(new MouseListener(){
					public void mouseDoubleClick(MouseEvent e) {
					}
					public void mouseDown(MouseEvent e) {
					}
					public void mouseUp(MouseEvent e) {
						return_value = CANCEL;
						display.asyncExec(new Runnable(){
							public void run() {
								sShell.dispose();
							}
						});
					}
				});
				sShell.pack();
				
				sShell.open();
				while (!sShell.isDisposed()) {
					if (!display.readAndDispatch())
						display.sleep();
				}
				display.dispose();
			}
		};
		t.start();
		try{
			t.join();
		}
		catch(InterruptedException e){}
		
		return return_value;
	}
	
	public static int displayError(Throwable arg){
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		arg.printStackTrace(pw);
		pw.flush();
		sw.flush();
		return displayError(sw.getBuffer().toString());
	}
	
	public static int displayError(Throwable arg, String arg2){
		String error = arg2 + "\n";
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		arg.printStackTrace(pw);
		pw.flush();
		sw.flush();
		error = error + sw.getBuffer().toString();
		return displayError(error);
	}

}
