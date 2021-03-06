package com.rothlin.hwz.Junit.Part1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FractionInterface extends Remote {
	
	// Setter and getter
	public int getZaehler() throws RemoteException;
	public int getNenner() throws RemoteException;
	
	public void setZaehler(int zaehler) throws RemoteException;
	public void setNenner(int nenner) throws RemoteException;
	public void setBruch(int zaehler, int nenner) throws RemoteException;
		
	// toString methods
	//public String toString() throws RemoteException;
	public String toStringGekuerzt() throws RemoteException;
	public double toStringAsDecimal() throws RemoteException;
	
	public String toString(FractionInterface a) throws RemoteException;				// should be static
	public String toStringGekuerzt(FractionInterface a) throws RemoteException;		// should be static
	public double toStringAsDecimal(FractionInterface a) throws RemoteException;		// should be static
	
	
	// Business Methoden
	// -----------------
	
	public boolean SetUserInput(String UserInput) throws RemoteException;
	public double divToDecimal() throws RemoteException;
	  
	// common methods   
	public void parseBruch(String bruchStr) throws RemoteException;
	
	// Operations
	public FractionInterface operation(String opStr) throws RemoteException;
	
	public FractionInterface add(FractionInterface summand2) throws RemoteException;
	public FractionInterface add(FractionInterface summand1, FractionInterface summand2) throws RemoteException;	// should be static

	public FractionInterface sub(FractionInterface minuend) throws RemoteException;
	public FractionInterface sub(FractionInterface sutrahend, FractionInterface minuend) throws RemoteException;	// should be static
	
	public FractionInterface mul(FractionInterface factor2) throws RemoteException;
	public FractionInterface mul(FractionInterface factor1, FractionInterface factor2) throws RemoteException;		// should be static
	
  
	public FractionInterface div(FractionInterface dividend, FractionInterface divisor) throws RemoteException;		// should be static
	
	public FractionInterface kuerzen() throws RemoteException;
	public FractionInterface kuerzen(FractionInterface a) throws RemoteException;	  // should be static

	public FractionInterface kehrwert() throws RemoteException;
	public FractionInterface kehrwert(FractionInterface a) throws RemoteException;	  // should be static
	
}
