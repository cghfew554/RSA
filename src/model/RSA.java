package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;

public class RSA extends Observable{
	private int primeA = 0;
	private int primeB = 0;
	
	
	Collection<Integer> primes;
	HashMap<Integer, RSAKeys> keys;
	
	private int privateKey = 0;
	private int publicKey = 0;
	
	private int moduloN = 0;
	
	private String plainText = "";
	private String encryptedText = "";
	
	public RSA(){
		
		this.primes = new ArrayList<Integer>();
		this.keys   = new HashMap<Integer, RSAKeys>();
		
		 for ( int i = 2; i <= 1000; i++ )
		   {
		     if ( isPrime ( i ) )
		    	 this.primes.add(i);
		     
		   }
		 
		 Iterator<Integer> i = this.primes.iterator();
		 
		 //TODO optimize algorithm
		 while(i.hasNext())
		 {
			 int primeAa = i.next();
			 
			 Iterator<Integer> b = this.primes.iterator();
			 
			 while(b.hasNext())
			 {
				 int primeBb = b.next();
				 System.out.println("PrimeBb : "+primeBb + " ");
				 this.keys.put((primeAa*primeBb), new RSAKeys(primeAa, primeBb));
				 System.out.println("Public key :" + (primeAa*primeBb) + " private key pair :"+ primeAa +" : "+primeBb);
			 }
		 }
	
		
		 
	}
	

	
	/**
	 * E is relative prime to Z, so gcd(e,z) = 1
	 * 
	 * @require this.getN() != 0;
	 * 			
	 */
	public void generateE()
	{
		
			for(int i = 2; i < this.getN(); i++)
			{
				if(GCD(i, this.getZ()) == 1){
					this.publicKey = i;
					break;
				}
			}
		
		this.notifyObserversSync();
		

	}
	
	/**
	 * Calculates the GCD of a and b
	 * 
	 * @param a
	 * @param b
	 * @return the GCD of a and b
	 */
	private int GCD(int a, int b)
	{
		
		/*recursion basic step*/
		if(b==0)
			return a;
		else/*recursive step*/
			return GCD(b, a%b);
	}
	
	/**
	 * D is the inverse of E in ring Zn
	 * 
	 * @require this.getN() != 0;
	 * 			this.publicKey != 0;
	 */
	public void calculateD()
	{
		
		for(int i = 0; i < this.getN() ; i++)
		{
			if((i*this.publicKey) % this.getN() == 1){
				System.out.println("private :" + i);
				this.privateKey = i;
				break;
			}
		}
		
		this.notifyObserversSync();
	}
	
	
	/**
	 * Checks if a number is a prime number
	 * 
	 * @require prime =< 1000
	 * @param prime
	 * @return true if it is a prime and false if not
	 */
	public boolean isPrime(int prime)
	{
		boolean isPrime = true;
		
		
		for(int i = 2; i < prime; i++)
		{
			if(prime % i == 0)
			{
				isPrime = false;
				break;
			}
		}
		
		return isPrime;
		
	}
	
	/**
	 * Set prime a
	 * 
	 * @require prime <= 1000
	 * @param prime a prime numbers 
	 */
	public void setPrimeA(int prime){
		if(prime <= 1000 && this.isPrime(prime))
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
	 * @require prime <= 1000
	 * @param prime a prime numbers 
	 */
	public void setPrimeB(int prime){
		if(prime <= 1000 && this.isPrime(prime))
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
		return this.moduloN;
	}
	
	public void setN(int n)
	{
		this.moduloN = n;
		
		this.notifyObserversSync();
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
	
	/**
	 * Get the public RSA key
	 * 
	 * @ensure result >= 0;
	 * @return public RSA key
	 */
	public int getPublicKey(){
		
		
		return this.publicKey;	
	
	}
	
	public void setPublicKey(int key)
	{
		this.publicKey = key;
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
		
		return this.privateKey;
	}
	
	public void setPrivateKey(int key)
	{
		this.privateKey = key;
	}
	
	/**
	 * Notify all observers 
	 */
	public void notifyObserversSync()
	{
		
		synchronized(this)
		{
			
			this.setChanged();
			this.notifyObservers(this);
		}
	}
	
	public String getEncryptedMessage()
	{
		return this.encryptedText;
	}
	
	
	public String getPlainMessage()
	{
		return this.plainText;
	}
	
	public void encrypt(String message)
	{
		System.out.println(message);
		if(this.getPublicKey() != 0 && this.getN() != 0){
			this.plainText = message;
			this.encryptedText = "";
		
			for(int i = 0; i < message.length(); i++)
			{
				char oneLetter = message.charAt(i);
			
				int encryptedLetter = oneLetter^(this.getPublicKey()) % this.getN();
							
				this.encryptedText += Integer.toString(encryptedLetter) + " ";
				
			
			}
			
			this.notifyObserversSync();
		}
		
	}
	
	public void crack(int pk, int moduloN)
	{
		//TODO cracking...;)
	}
	
	public void decrypt(String message)
	{
		System.out.println("decrypting....");
		if(this.getN() != 0 && this.getPrivateKey() != 0){
			
			System.out.println("d2..");
			String[] messageParts = message.split(" ");
		
		this.plainText = "";
		this.encryptedText = message;
		
			for(int i = 0; i < messageParts.length; i++)
			{
				int oneLetterEncrypted = Integer.parseInt(messageParts[i]);
			
				int oneLetterDecrypted = oneLetterEncrypted^(this.getPrivateKey()) % this.getN();
			
				this.plainText += Character.toString((char)oneLetterDecrypted);
					
			
				System.out.println((char)oneLetterDecrypted);
			}
		
			this.notifyObserversSync();
		}
	}
}
