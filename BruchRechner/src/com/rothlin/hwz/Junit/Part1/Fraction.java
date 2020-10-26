package com.rothlin.hwz.Junit.Part1;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Fraction extends UnicastRemoteObject implements FractionInterface {

		private static final long serialVersionUID = 1L;
		
		private int nenner;
		private int zaehler;
		
		//getter and setters
		public int getZaehler()             {	return zaehler;         }
		public int getNenner()              {	return nenner;          }
		
		public void setZaehler(int zaehler) {	this.zaehler = zaehler; } 
		public void setNenner(int nenner)   {	this.nenner = nenner;   }         

		public void setBruch(int zaehler, int nenner) throws RemoteException {
			if ((zaehler > 0) && (nenner > 0)) {
				this.zaehler = zaehler;
				this.nenner = nenner;
			} else {
				this.zaehler = zaehler;
			}
		}
		
		//ToString methods
		public String toString(FractionInterface a) throws RemoteException {
			if (a.getNenner() == 1) {
				return "" + a.getZaehler();
			} else {
				return a.getZaehler() + "/" + a.getNenner();
			}
		}

		public String toStringGekuerzt() throws RemoteException                     { return toStringGekuerzt(this);}
		public double toStringAsDecimal() throws RemoteException                    { return toStringAsDecimal(this);}
		public String toStringGekuerzt(FractionInterface a) throws RemoteException  { return toString(a.kuerzen());}
		public double toStringAsDecimal(FractionInterface a) throws RemoteException { return 1.0 * a.getZaehler() / a.getNenner();}
		
	
		//Constructors
		public Fraction() throws RemoteException { setBruch(0, 1);                                                            }
		public Fraction(FractionInterface a) throws RemoteException { setBruch(a.getZaehler(), a.getNenner());                                   }
		public Fraction(String a) throws RemoteException { FractionInterface b = parseBruch(a); setBruch(b.getZaehler(), b.getNenner()); }
		public Fraction(int zaehler, int nenner) throws RemoteException { setBruch(zaehler, nenner);                                                 }
		public Fraction(int zaehler) throws RemoteException { setBruch(zaehler, 1) ;} 
		
		
		//Business methods
//Selfmade		
		@Override
		public boolean isUserInputValid(String UserInput) throws RemoteException {
			
		if(UserInput.equals("///"))
    	{
return false;	
    	}
			
		if (UserInput.isEmpty()) 
		{		
return false;
		}	
		
		if (UserInput.length() != 3)
		{
return false;
		}
		
		if (UserInput.charAt(1) != '/')					
		{		
return false;
		}
		
		String UserInputReplace = UserInput.replace("/", "0");
		try
		{
			Integer.parseInt(UserInputReplace);
		}
	  catch (NumberFormatException nfe) 
		{
	        return false;
	    }			
// If we reach this point Input is Valid	
		return true;
        }
		
		@Override
		public double divToDecimal() throws RemoteException 
		{		
			double resultDecimal = 0.0d;
 			
			resultDecimal = ((Double.valueOf(zaehler))/Double.valueOf(nenner)); 

			return resultDecimal;
		}
		
// Existing		
		public FractionInterface parseBruch(String bruchStr) throws RemoteException {
	        bruchStr = bruchStr.replaceAll("\\s+","");
	        Pattern p = Pattern.compile("(\\d+)(?:/(\\d+))?");
	        Matcher m = p.matcher(bruchStr);
	        if (m.matches()) {
	            String[] fractionParts = bruchStr.split("/");
	            int zaehler = Integer.parseInt(fractionParts[0]);
				
	            int nenner = 1;
	            if (fractionParts.length >= 2) {
	                nenner = Integer.parseInt(fractionParts[1]);
	            }
	            return new Fraction(zaehler,nenner);
	        } else {
	            throw new IllegalArgumentException();
	        }
	    }
		
		public FractionInterface add (FractionInterface summand2) throws RemoteException   { return add(this, summand2);}
		public FractionInterface add (FractionInterface summand1, FractionInterface summand2) throws RemoteException {
			int resNenner = summand1.getNenner() * summand2.getNenner();
			int resZaehler = summand1.getZaehler() * summand2.getNenner() + summand2.getZaehler() * summand2.getNenner();
			return new Fraction(resZaehler, resNenner);}
		
		public FractionInterface sub(FractionInterface minuend) throws RemoteException        { return sub(this);}

		public FractionInterface mul(FractionInterface factor2) throws RemoteException {
			return mul(this, factor2);	}	
		public FractionInterface mul(FractionInterface factor1, FractionInterface factor2) throws RemoteException {
			int resZaehler = factor1.getZaehler() * factor2.getZaehler();
			int resNenner  = factor1.getNenner()  * factor2.getNenner();
			return new Fraction(resZaehler, resNenner);		
		}
		
		
// NOT implemented methods
		@Override
		public FractionInterface operation(String opStr) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public FractionInterface sub(FractionInterface sutrahend, FractionInterface minuend) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}		
		@Override
		public FractionInterface div(FractionInterface dividend, FractionInterface divisor) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}				
		@Override
		public FractionInterface kuerzen() throws RemoteException {			
			return null;
		}
		@Override
		public FractionInterface kuerzen(FractionInterface a) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public FractionInterface kehrwert() throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public FractionInterface kehrwert(FractionInterface a) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		//public FractionInterface div(FractionInterface divisor) throws RemoteException   { return new Fraction(0,1); }
		//public FractionInterface div(FractionInterface dividend, FractionInterface divisor) throws RemoteException { return new Fraction(0,1); }
		//public FractionInterface kuerzen() throws RemoteException                     { return new Fraction(0,1); }
		//public FractionInterface kuerzen(BruchInterface a) throws RemoteException     { return new Fraction(0,1); }
		//public FractionInterface kehrwert() throws RemoteException                    { return new Fraction(0,1); }
		//public FractionInterface kehrwert(FractionInterface a) throws RemoteException    { return new Fraction(0,1); }

}
