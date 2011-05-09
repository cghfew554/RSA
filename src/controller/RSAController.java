package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.RSA;

import view.MainWindow;

public class RSAController implements Controller,  ActionListener{

	public MainWindow window = null;
	public RSA rsa = null;
	
	public RSAController()
	{
		this.window = new MainWindow(this);
		this.rsa = new RSA();
		
		this.rsa.addObserver(this.window);
		
		this.window.update(this.rsa, "");
		
		this.window.showMainWindow();
	}
	
	public MainWindow getWindow()
	{
		return this.window;
	}
	
	public RSA getRSAModel()
	{
		return this.rsa;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("crack")){
			int publicKey = Integer.parseInt(this.window.publicKeyTextField.getText());
			int moduloN = Integer.parseInt(this.window.moduloNTextField.getText());
			String encryptedText = this.window.encryptedTextTextField.getText();
			
			
			this.rsa.reset();
			
			// this.rsa.setN(moduloN); 
			// this.rsa.setPublicKey(publicKey);
			this.rsa.crack(publicKey, moduloN);
			
			this.rsa.decrypt(encryptedText);
			
		}else if(e.getActionCommand().equals("encrypt"))
		{
			String text = this.window.plainTextTextField.getText();
			
			int publicKey = Integer.parseInt(this.window.publicKeyTextField.getText());
			int moduloN = Integer.parseInt(this.window.moduloNTextField.getText());
						
			this.rsa.setN(moduloN); 
			this.rsa.setPublicKey(publicKey);
			
			this.rsa.encrypt(text);
			
		}else if(e.getActionCommand().equals("decrypt"))
		{
			
			String text = this.window.encryptedTextTextField.getText();
			
			//set the values from the view into the model
			int moduloN = Integer.parseInt(this.window.moduloNTextField.getText());
			int privateKey = Integer.parseInt(this.window.privateKeyTextField.getText());
			
			this.rsa.setPrivateKey(privateKey);
			
			this.rsa.setN(moduloN);
			
			this.rsa.decrypt(text);
		}else if(e.getActionCommand().equals("publicKey"))
		{
			//set the values from the view into the model
			int primeA = Integer.parseInt(this.window.primeATextField.getText());
			int primeB = Integer.parseInt(this.window.primeBTextField.getText());
			
			if(primeA > 1)
				this.rsa.setPrimeA(primeA);
			
			if(primeB > 1)
				this.rsa.setPrimeB(primeB);
			
			this.rsa.setN(primeA*primeB); //set the modulo
			this.rsa.generateE(); //generate public key
			this.rsa.calculateD(); //calculate private key
			
		}else if(e.getActionCommand().equals("clear"))
		{
			this.rsa.reset();
			
		}
		
	}
	
	
}
