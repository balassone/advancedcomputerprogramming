package client;

import dispatcher.*;

import java.io.*;

public class Actuator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*
		 * uso: 		java client.Actuator IP porta
		 * per es.:		java client.Actuator 127.0.0.1 8000
		 */

		
		IDispatcher dispatcher = new DispatcherProxy ( args[0], Integer.valueOf( args[1]) );
		int cmd=0;
		
		try{
			FileOutputStream fileOut = new FileOutputStream ( "./cmdlog.txt");
			PrintStream outStream = new PrintStream ( fileOut );
			
			while ( true ){
				
				cmd = dispatcher.getCmd();
				System.out.println ("[ACT] ricevuto comando # " + cmd );
				outStream.println ( "comando = "+ cmd);
				
				Thread.sleep( 5000 );	
			} 
				
		}catch ( IOException e ){
			e.printStackTrace();
		}catch ( InterruptedException i ){
			i.printStackTrace();
		}
		
	
	}

}
