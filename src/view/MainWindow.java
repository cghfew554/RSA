package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.Controller;
import controller.RSAController;

public class MainWindow extends JFrame implements Observer {


	private static final long serialVersionUID = 1L;
	private RSAController RSAC = null;
	
	private JButton encryptButton;
	private JButton decryptButton;

	private JPanel buttonsPanel;
	
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
		
		this.encryptButton = new JButton("Encrypt");
		this.encryptButton.setSize(100, 20);
		this.decryptButton = new JButton("Decrypt");
		this.decryptButton.setSize(100, 20);
		
		
		this.buttonsPanel = new JPanel();
		this.buttonsPanel.setSize(250, 20);
		
		this.buttonsPanel.add(this.encryptButton);
		
		
		
		this.setSize(350, 350);
		
		
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
