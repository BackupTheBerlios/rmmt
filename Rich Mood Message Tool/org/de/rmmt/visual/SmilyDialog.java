package org.de.rmmt.visual;

import java.util.Properties;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;

public class SmilyDialog {

	private Shell sShell = null;
	private Label label[] = null;
	private Text text;
	private Button ok;
	private Button cancel;
	private String return_value = "";
	private Shell s;
	private Properties props;
	
	public SmilyDialog(Properties props, Shell s){
		this.props = props;
		this.s = s;
	}
	
	/**
	 * This method initializes sShell
	 */
	private void createSShell() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.verticalSpacing = 0;
		gridLayout.marginWidth = 2;
		gridLayout.marginHeight = 2;
		gridLayout.numColumns = 10;
		sShell = new Shell(s, SWT.DIALOG_TRIM | SWT.PRIMARY_MODAL);
		sShell.setText(props.getProperty("Title_Smily"));
		sShell.setLayout(gridLayout);
		sShell.setSize(new Point(300, 252));
		sShell.setImage(new Image(sShell.getDisplay(),MainWindow.class.getResourceAsStream("icon.png")));
		label = new Label[86];
		for(int i = 1; i <= 9; i++){
			label[i] = new Label(sShell, SWT.NONE);
			label[i].setImage(new Image(sShell.getDisplay(), SmilyDialog.class.getResourceAsStream("animated/00"+ i+ ".png")));
		}
		for(int i = 10; i < 86; i++){
			label[i] = new Label(sShell, SWT.NONE);
			label[i].setImage(new Image(sShell.getDisplay(), SmilyDialog.class.getResourceAsStream("animated/0"+ i+ ".png")));
		}
		new Label(sShell, SWT.NONE);
		new Label(sShell, SWT.NONE);
		new Label(sShell, SWT.NONE);
		new Label(sShell, SWT.NONE);
		new Label(sShell, SWT.NONE);
		text = new Text(sShell, SWT.NONE);
		GridData gd = new GridData();
		gd.horizontalSpan = 10;
		//gd.verticalSpan = 10;
		gd.widthHint = 280;
		gd.heightHint = 20;
		text.setLayoutData(gd);
		for(int i = 0; i < 86; i++){
			addListener(i);
		}
		cancel = new Button(sShell, SWT.PUSH);
		ok = new Button(sShell, SWT.PUSH);
		GridData gd2 = new GridData();
		gd2.horizontalSpan = 5;
		gd2.heightHint = 25;
		gd2.widthHint = 60;
		ok.setLayoutData(gd2);
		cancel.setLayoutData(gd2);
		ok.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				return_value = text.getText();
				sShell.dispose();
			}
		});
		cancel.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				sShell.dispose();
			}
		});
		ok.setText(props.getProperty("Ok"));
		cancel.setText(props.getProperty("Abbrechen"));
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
	
	private void addListener(int n){
		switch (n){
			case 0:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"smile\">:-)</SS>");
					}
				});
				break;
			}
			
			case 1:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"sad\">:(</SS>");
					}
				});
				break;
			}

			case 2:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"laugh\">:D</SS>");
					}
				});
				break;
			}

			case 3:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"cool\">8)</SS>");
					}
				});
				break;
			}

			case 4:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"surprised\">:O</SS>");
					}
				});
				break;
			}

			case 5:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"wink\">;-)</SS>");
					}
				});
				break;
			}

			case 6:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"cry\">;(</SS>");
					}
				});
				break;
			}

			case 7:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"sweat\">(sweat)</SS>");
					}
				});
				break;
			}

			case 8:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"speechless\">:|</SS>");
					}
				});
				break;
			}

			case 9:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"kiss\">:*</SS>");
					}
				});
				break;
			}

			case 10:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"tongueout\">:P</SS>");
					}
				});
				break;
			}

			case 11:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"blush\">(blush)</SS>");
					}
				});
				break;
			}

			case 12:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"wonder\">:^)</SS>");
					}
				});
				break;
			}

			case 13:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"sleepy\">|-)</SS>");
					}
				});
				break;
			}

			case 14:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"dull\">|-(</SS>");
					}
				});
				break;
			}

			case 15:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"inlove\">(inlove)</SS>");
					}
				});
				break;
			}

			case 16:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"eg\">]:)</SS>");
					}
				});
				break;
			}

			case 17:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"talk\">(talk)</SS>");
					}
				});
				break;
			}

			case 18:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"yawn\">(yawn)</SS>");
					}
				});
				break;
			}

			case 19:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"puke\">(puke)</SS>");
					}
				});
				break;
			}

			case 20:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"doh\">(doh)</SS>");
					}
				});
				break;
			}

			case 21:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"angry\">:@</SS>");
					}
				});
				break;
			}

			case 22:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"wasntme\">(wasntme)</SS>");
					}
				});
				break;
			}

			case 23:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"party\">(party)</SS>");
					}
				});
				break;
			}

			case 24:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"worry\">:S</SS>");
					}
				});
				break;
			}

			case 25:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"mmm\">(mm)</SS>");
					}
				});
				break;
			}

			case 26:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"nerdy\">8-|</SS>");
					}
				});
				break;
			}

			case 27:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"lipssealed\">:x</SS>");
					}
				});
				break;
			}

			case 28:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"hi\">(hi)</SS>");
					}
				});
				break;
			}

			case 29:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"call\">(call)</SS>");
					}
				});
				break;
			}

			case 30:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"devil\">(devil></SS>");
					}
				});
				break;
			}

			case 31:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"angel\">(angel)</SS>");
					}
				});
				break;
			}

			case 32:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"envy\">(envy)</SS>");
					}
				});
				break;
			}

			case 33:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"wait\">(wait)</SS>");
					}
				});
				break;
			}

			case 34:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"hug\">(hug)</SS>");
					}
				});
				break;
			}

			case 35:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"makeup\">(makeup)</SS>");
					}
				});
				break;
			}

			case 36:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"giggle\">(chuckle)</SS>");
					}
				});
				break;
			}

			case 37:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"clap\">(clap)</SS>");
					}
				});
				break;
			}

			case 38:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"think\">(think)</SS>");
					}
				});
				break;
			}

			case 39:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"bow\">(bow)</SS>");
					}
				});
				break;
			}

			case 40:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"rofl\">(rofl)</SS>");
					}
				});
				break;
			}

			case 41:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"whew\">(whew)</SS>");
					}
				});
				break;
			}

			case 42:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"happy\">(happy)</SS>");
					}
				});
				break;
			}

			case 43:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"smirk\">(smirk)</SS>");
					}
				});
				break;
			}
			case 44:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"nod\">(nod)</SS>");
					}
				});
				break;
			}
			
			case 45:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"shake\">(shake)</SS>");
					}
				});
				break;
			}

			case 46:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"punch\">(punch)</SS>");
					}
				});
				break;
			}

			case 47:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"emo\">(emo)</SS>");
					}
				});
				break;
			}

			case 48:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"yes\">(y)</SS>");
					}
				});
				break;
			}

			case 49:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"no\">(n)</SS>");
					}
				});
				break;
			}

			case 50:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"handshake\">(handshake)</SS>");
					}
				});
				break;
			}

			case 51:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"skype\">(skype)</SS>");
					}
				});
				break;
			}

			case 52:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"heart\">(h)</SS>");
					}
				});
				break;
			}

			case 53:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"brokenheart\">(u)/SS>");
					}
				});
				break;
			}

			case 54:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"mail\">(e)</SS>");
					}
				});
				break;
			}

			case 55:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"flower\">(F)</SS>");
					}
				});
				break;
			}

			case 56:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"rain\">(rain)</SS>");
					}
				});
				break;
			}

			case 57:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"sun\">(sun)</SS>");
					}
				});
				break;
			}

			case 58:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"time\">(O)</SS>");
					}
				});
				break;
			}

			case 59:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"music\">(music)</SS>");
					}
				});
				break;
			}

			case 60:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"film\">(~)</SS>");
					}
				});
				break;
			}

			case 61:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"phone\">(mp)</SS>");
					}
				});
				break;
			}

			case 62:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"coffe\">(coffe)</SS>");
					}
				});
				break;
			}

			case 63:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"pizza\">(pizza)</SS>");
					}
				});
				break;
			}

			case 64:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"cash\">(cash)</SS>");
					}
				});
				break;
			}

			case 65:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"flex\">(flex)</SS>");
					}
				});
				break;
			}

			case 66:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"cake\">(^)</SS>");
					}
				});
				break;
			}

			case 67:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"beer\">(beer)</SS>");
					}
				});
				break;
			}

			case 68:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"drink\">(d)</SS>");
					}
				});
				break;
			}

			case 69:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"dance\">(dance)</SS>");
					}
				});
				break;
			}

			case 70:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"ninja\">(ninja)</SS>");
					}
				});
				break;
			}

			case 71:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"star\">(*)</SS>");
					}
				});
				break;
			}

			case 72:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"mooning\">(mooning)</SS>");
					}
				});
				break;
			}

			case 73:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"finger\">(finger)</SS>");
					}
				});
				break;
			}

			case 74:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"bandit\">(bandit)</SS>");
					}
				});
				break;
			}

			case 75:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"drunk\">(drunk)</SS>");
					}
				});
				break;
			}

			case 76:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"smoking\">(smoking)</SS>");
					}
				});
				break;
			}

			case 77:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"tovio\">(tovio)</SS>");
					}
				});
				break;
			}

			case 78:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"drunk\">(drunk)</SS>");
					}
				});
				break;
			}

			case 79:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"headbang\">(headbang)</SS>");
					}
				});
				break;
			}

			case 80:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"poolparty\">(poolparty)</SS>");
					}
				});
				break;
			}

			case 81:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"swear\">(swear)</SS>");
					}
				});
				break;
			}

			case 82:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"bug\">(bug)</SS>");
					}
				});
				break;
			}

			case 83:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"fubar\">(fubar)</SS>");
					}
				});
				break;
			}

			case 84:{
				label[n+1].addMouseListener(new MouseAdapter(){
					public void mouseDown(MouseEvent e) {
						text.setText(text.getText() + "<SS type=\"tmi\">(tmi)</SS>");
					}
				});
				break;
			}
		}
	}
}