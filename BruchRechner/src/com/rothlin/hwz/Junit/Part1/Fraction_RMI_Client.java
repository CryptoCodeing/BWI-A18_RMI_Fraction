package com.rothlin.hwz.Junit.Part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Fraction_RMI_Client {

	public static void main(String[] args) throws RemoteException, NotBoundException, IOException {	

		while(true) 
		{
// Create Instance of Remote Object
		    Registry registry = LocateRegistry.getRegistry(Fraction_RMI_Definitions.RMI_ServerHost, Fraction_RMI_Definitions.RMI_PORT);
	        FractionInterface remote = (FractionInterface) registry.lookup(Fraction_RMI_Definitions.RMI_ID);
	        
	       String UserInput  = "";	        
	        while(UserInput == "") 
	        {	        	
// Ask User to type in Fraction       
System.out.println("Bitte  Bruch Ihrer Wahl eintippen. Zum Beispiel [12345/45] oder [31222123/44523434342438].");
System.out.println("Klicken Sie Enter und der Bruch wird Ihnen in dezimaler Schreibweise dargestellt:");
	       
// Get User Input, validate and create Fraction from User Input and 
	        		BufferedReader Console = new BufferedReader (new InputStreamReader (System.in));	      	        					
	        		UserInput = Console.readLine();	 // NOT a .NET Function 
	        		       		
	        	if (!remote.SetUserInput(UserInput))
	        	{
	        		System.out.println("Ihre Eingabe [" + UserInput + "] ist ungültig.");
	        		UserInput = "";
	        	}	           							
	       	}	        
System.out.println("");
System.out.println("");
System.out.println("");
System.out.println("------------------------------------------------------------------------------------------------------------------------");
System.out.println("");           
// show User dividend and divisor
System.out.println("Zaehler Ihres Input" + " = " + remote.getZaehler() + " ; Nenner Ihres Input = " + remote.getNenner());   
System.out.println("");

// Convert Fraction to Decimal Number and show User 						
System.out.println("Bruch in Dezimal Schreibweise = " + remote.divToDecimal());   
System.out.println("");
System.out.println("------------------------------------------------------------------------------------------------------------------------");
System.out.println("");
System.out.println("");
System.out.println("");
		

//Test Stuff
//System.out.println("TEST");					
////Instance Remoteobject 2
//	    Registry registry2 = LocateRegistry.getRegistry(Fraction_RMI_Definitions.RMI_ServerHost, Fraction_RMI_Definitions.RMI_PORT);
//      FractionInterface remote2 = (FractionInterface) registry2.lookup(Fraction_RMI_Definitions.RMI_ID2);
//
////Instance Remoteobject 3
//	    Registry registry3 = LocateRegistry.getRegistry(Fraction_RMI_Definitions.RMI_ServerHost, Fraction_RMI_Definitions.RMI_PORT);
//      FractionInterface remote3 = (FractionInterface) registry3.lookup(Fraction_RMI_Definitions.RMI_ID3);

	      // remote = remote.parseBruch("1/2");
	       //remote.setBruch(100,100);	        
//           remote2.setBruch(1000,100);
//	       remote3.setBruch(100,100); 
//	        
//System.out.println("Remote Bruch:  " + remote.getZaehler()  + "/" + remote.getNenner() );
//System.out.println("Remote2 Bruch: " + remote2.getZaehler() + "/" + remote2.getNenner());
//System.out.println("Remote3 Bruch: " + remote3.getZaehler() + "/" + remote3.getNenner());
//	       
//	       remote3 = remote3.mul(remote2);
//System.out.println("Remote3 Zaehler(nach Mulitplikation mit Remote2 Objekt) " + remote3.getZaehler());
		}   	       	  		
}
	
}