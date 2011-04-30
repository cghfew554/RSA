package view;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.RSA;

import controller.Controller;
import controller.RSAController;

public class MainWindow extends JFrame implements Observer{


	private static final long serialVersionUID = 1L;
	private RSAController RSAC = null;
	
	private JButton encryptButton;
	private JButton decryptButton;
	private JButton crackButton;
	private JButton generatePublicKeyButton;
	private JButton clearButton;
	
	private JLabel primeALabel;
	private JLabel primeBLabel;
	private JLabel moduloNLabel;
	private JLabel moduloZLabel;
	private JLabel publicKeyLabel;
	private JLabel privateKeyLabel;
	
	public JTextField primeATextField;
	public JTextField primeBTextField;
	public JTextField moduloNTextField;
	public JTextField moduloZTextField;
	public JTextField publicKeyTextField;
	public JTextField privateKeyTextField;
	
	private JLabel plainTextLabel;
	private JLabel encryptedTextLabel;
	
	public JTextField plainTextTextField;
	public JTextField encryptedTextTextField;
	
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
		this.encryptButton.setActionCommand("encrypt");
		this.encryptButton.addActionListener(this.RSAC);
		
		this.decryptButton = new JButton("Decrypt");
		this.decryptButton.setActionCommand("decrypt");
		this.decryptButton.addActionListener(this.RSAC);
		
		this.crackButton   = new JButton("Crack");
		this.crackButton.setActionCommand("crack");
		this.crackButton.addActionListener(this.RSAC);
		
		this.generatePublicKeyButton = new JButton("Public key");
		this.generatePublicKeyButton.setActionCommand("publicKey");
		this.generatePublicKeyButton.addActionListener(this.RSAC);
		
		this.clearButton = new JButton("Clear");
		this.clearButton.setActionCommand("clear");
		this.clearButton.addActionListener(this.RSAC);
		
		buttons.add(this.crackButton);
		buttons.add(this.generatePublicKeyButton);
		buttons.add(encryptButton);
		buttons.add(decryptButton);
		buttons.add(this.clearButton);
		
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
	
		if(arg0 instanceof RSA)
		{
			
			this.primeATextField.setText(Integer.toString(((RSA) arg0).getPrimeA()));
			this.primeBTextField.setText(Integer.toString(((RSA) arg0).getPrimeB()));
			
			this.moduloNTextField.setText(Integer.toString(((RSA) arg0).getN()));
			this.moduloZTextField.setText(Integer.toString(((RSA) arg0).getZ()));
			
			this.publicKeyTextField.setText(Integer.toString(((RSA) arg0).getPublicKey()));
			this.privateKeyTextField.setText(Integer.toString(((RSA) arg0).getPrivateKey()));
			
			this.plainTextTextField.setText(((RSA) arg0).getPlainMessage());
			this.encryptedTextTextField.setText(((RSA) arg0).getEncryptedMessage());
			
			
		}
		
	}

	
}
