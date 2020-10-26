package com.rothlin.hwz.Junit.Part1;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.rothlin.hwz.Junit.Part1.Fraction_RMI_Definitions;

public class Fraction_RMI_Server {

	public static void main(String[] args) throws RemoteException, AlreadyBoundException {
		
		Registry registry = LocateRegistry.createRegistry(Fraction_RMI_Definitions.RMI_PORT);
// Create Remote Objects		
		Fraction impl = new Fraction();
		registry.bind(Fraction_RMI_Definitions.RMI_ID,impl);
		
		Fraction impl2 = new Fraction();
		registry.bind(Fraction_RMI_Definitions.RMI_ID2,impl2);
		
		Fraction impl3 = new Fraction();
		registry.bind(Fraction_RMI_Definitions.RMI_ID3,impl3);
		
		System.out.println("Server has been started!");
	}
}