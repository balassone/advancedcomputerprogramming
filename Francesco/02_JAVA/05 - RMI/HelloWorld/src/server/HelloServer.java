package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloServer {
	public static void main(String[] args) {
		try {
			HelloServerImplEreditarieta obj_e = new HelloServerImplEreditarieta();
			Registry registry = LocateRegistry.getRegistry();
			
			registry.rebind("Hello", obj_e);
			System.err.println("Server ready!");
		} catch(Exception e) {
			System.err.println("Exception: "+e.toString());
			e.printStackTrace();
		}
	}
}
