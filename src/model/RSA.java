package model;

import java.util.Observable;

public class RSA extends Observable{
	private int primeA = 0;
	private int primeB = 0;
	
	
	private int privateKey = 0;
	private int publicKey = 0;
	
	public RSA(){
		
	}
	
	/**
	 * Set prime a
	 * 
	 * @require prime > 1 && prime = //TODO math definition of primes
	 * @param prime a prime numbers 
	 */
	public void setPrimeA(int prime){
		this.primeA = prime;
		
		this.notifyObserversSync();
		
	}
	
	/**
	 * Get prime a
	 * 
	 * @ensure result >= 0;
	 * @return prime a
	 */
	public int getPrimeA()
	{
		return this.primeA;
	}
	
	/**
	 * Set prime b
	 * 
	 * @require prime > 1 && prime = //TODO math definition of primes
	 * @param prime a prime numbers 
	 */
	public void setPrimeB(int prime){
		this.primeB = prime;
		
		this.notifyObserversSync();
	}
	
	/**
	 * Get prime b
	 * 
	 * @ensure result >= 0;
	 * @return prime b
	 */
	public int getPrimeB()
	{
		return this.primeB;
	}
	
	/**
	 * Get the n modulo 
	 * 
	 * @ensure result >= 0 
	 * @return integer
	 */
	public int getN()
	{
		return this.getPrimeA()*this.getPrimeB();
	}
	
	/**
	 * Get the z modulo
	 * 
	 * 
	 * @ensure result = (this.getPrimeB() -1)*(this.getPrimeA() - 1) 
	 * @return integer 
	 */
	public int getZ()
	{
		return (this.getPrimeA() - 1)*(this.getPrimeB() - 1);
	}
	
	public int getPublicKey(){
		if(this.publicKey == 0)
			this.calculatePublicKey();
		
		return this.publicKey;
		
	}
	
	/**
	 * Calculates a public key that is relative prime to Z
	 * 
	 * @require this.getZ() != 0;
	 * @ensure this.getPublicKey() != 0;
	 * 
	 */
	public void calculatePublicKey()
	{
		//TODO research for relative prime libs in java
		
	
	}
	
	/**
	 * Calculates a private key where the publicKey * privateKey modulo this.getZ() = 1;
	 * 
	 * @require this.getPublicKey() != 0
	 * 			this.getZ() != 0;
	 * @ensure result != 0;
	 * 
	 * @return private key for decryption
	 */
	public int getPrivateKey()
	{
		if(this.privateKey == 0)
			this.calculatePrivateKey();
		
		return this.privateKey;
	}
	
	/**
	 * calculates a private key
	 */
	public void calculatePrivateKey()
	{
		
	
	}
	
	public void notifyObserversSync()
	{
		
		synchronized(this)
		{
			
			this.setChanged();
			this.notifyObservers(this);
		}
	}
	
}
