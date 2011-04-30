package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.RSAEncrypt;
import view.MainWindow;

public class RSAController implements Controller,  ActionListener{

	public MainWindow window = null;
	public RSAEncrypt encryption = null;
	
	public RSAController()
	{
		this.window = new MainWindow(this);
		this.encryption = new RSAEncrypt();
		
		this.encryption.addObserver(this.window);
		
		this.window.update(this.encryption, "");
		
		this.window.showMainWindow();
	}
	
	public MainWindow getWindow()
	{
		return this.window;
	}
	
	public RSAEncrypt getEncryptionModel()
	{
		return this.encryption;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("crack")){
			System.out.println("crack");
		}else if(e.getActionCommand().equals("encrypt"))
		{
			
			//set the values from the view into the model
			int primeA = Integer.parseInt(this.window.primeATextField.getText());
			int primeB = Integer.parseInt(this.window.primeBTextField.getText());
			
			if(primeA > 1)
				this.encryption.setPrimeA(primeA);
			
			if(primeB > 1)
				this.encryption.setPrimeB(primeB);
			
			
		}else if(e.getActionCommand().equals("decrypt"))
		{
			System.out.println("decrypt");
		}
		
	}
	
	
}
