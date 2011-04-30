package view;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;
import controller.RSAController;

public class MainWindow extends JFrame implements Observer {


	private static final long serialVersionUID = 1L;
	private RSAController RSAC = null;
	
	private JButton encryptButton;
	private JButton decryptButton;
	private JButton crackButton;
	
	private JLabel primeALabel;
	private JLabel primeBLabel;
	private JLabel moduloNLabel;
	private JLabel moduloZLabel;
	private JLabel publicKeyLabel;
	private JLabel privateKeyLabel;
	
	private JTextField primeATextField;
	private JTextField primeBTextField;
	private JTextField moduloNTextField;
	private JTextField moduloZTextField;
	private JTextField publicKeyTextField;
	private JTextField privateKeyTextField;
	
	private JLabel plainTextLabel;
	private JLabel encryptedTextLabel;
	
	private JTextField plainTextTextField;
	private JTextField encryptedTextTextField;
	
	private JPanel layout;
	
	public MainWindow(Controller c)
	{
		if(c instanceof RSAController)
			this.RSAC = (RSAController) c;
		
		
		if(RSAC != null){
			this.createWindow();
		}
	}
	
	private void createWindow()
	{
		
		this.layout = new JPanel(new GridLayout(3,0));
		
		JPanel settings = new JPanel(new GridLayout(3, 1));
		
		this.primeALabel = new JLabel("Priemgetal a:");
		this.primeBLabel = new JLabel("Priemgetal b:");
		this.moduloNLabel = new JLabel("Modulo n:");
		this.moduloZLabel = new JLabel("Modulo z:");
		this.publicKeyLabel = new JLabel("Public key:");
		this.privateKeyLabel = new JLabel("Private key:");
		
		this.primeATextField = new JTextField();
		this.primeBTextField = new JTextField();
		this.moduloNTextField = new JTextField();
		this.moduloZTextField = new JTextField();
		this.publicKeyTextField = new JTextField();
		this.privateKeyTextField = new JTextField();
		
		
		settings.add(this.primeALabel);
		settings.add(this.primeATextField);
		
		settings.add(this.primeBLabel);
		settings.add(this.primeBTextField);
		
		settings.add(this.moduloNLabel);
		settings.add(this.moduloNTextField);
		
		settings.add(this.moduloZLabel);
		settings.add(this.moduloZTextField);
		
		settings.add(this.privateKeyLabel);
		settings.add(this.privateKeyTextField);
		
		settings.add(this.publicKeyLabel);
		settings.add(this.publicKeyTextField);
		
		settings.setSize(600, 100);
		
		
		this.layout.add(settings);
		
		JPanel buttons = new JPanel(new GridLayout(1,0));
		
		this.encryptButton = new JButton("Encrypt");
		this.decryptButton = new JButton("Decrypt");
		this.crackButton   = new JButton("Crack");
		
		buttons.add(this.crackButton);
		buttons.add(encryptButton);
		buttons.add(decryptButton);

		this.layout.add(buttons);
		
		JPanel text = new JPanel(new GridLayout(4,1));
		
		this.plainTextLabel = new JLabel("Plain text:");
		this.plainTextTextField = new JTextField();
		
		this.encryptedTextLabel = new JLabel("Encrypted text:");
		this.encryptedTextTextField = new JTextField();
		
		text.add(this.plainTextLabel);
		text.add(this.plainTextTextField);
		
		text.add(this.encryptedTextLabel);
		text.add(this.encryptedTextTextField);
		
		this.layout.add(text);

		this.add(this.layout);
		
		
		this.setSize(600, 600);
		
		
		
	}
	
	public void showMainWindow()
	{
		this.setVisible(true);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
