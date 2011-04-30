package controller;

import model.RSAEncrypt;
import view.MainWindow;

public class RSAController implements Controller{

	public MainWindow window = null;
	public RSAEncrypt encryption = null;
	
	public RSAController()
	{
		this.window = new MainWindow(this);
		this.encryption = new RSAEncrypt();
		
		this.encryption.addObserver(window);
		
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
	
	
}
