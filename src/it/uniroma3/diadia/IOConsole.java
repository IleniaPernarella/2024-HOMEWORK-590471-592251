package it.uniroma3.diadia;
import java.util.Scanner;

public class IOConsole implements IO {
	
	private String comando;
		
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	
	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		//scannerDiLinee.close();
		return riga;
	}
	
	/*public boolean hasRiga(String msg) {
		Scanner scannerDiLinee = new Scanner(msg);
		boolean riga = scannerDiLinee.hasNext();
		//scannerDiLinee.close();
		return riga;
	}*/
	
	public String parola(String msg) {
		Scanner scannerDiLinee = new Scanner(msg);
		if(scannerDiLinee.hasNext())
		msg = scannerDiLinee.next();
		//scannerDiLinee.close();
		return msg;
	}
	
	public String parametro(String msg) {
		Scanner scannerDiLinee = new Scanner(msg);
		
		if(scannerDiLinee.hasNext()) 
		msg = scannerDiLinee.next();
		
		if(scannerDiLinee.hasNext())
		msg = scannerDiLinee.next();
		
		//scannerDiLinee.close();
		return msg;
	}
}
