package it.uniroma3.diadia;
import java.util.Scanner;

public class IOConsole implements IO {
	
	
	private Scanner scannerDiLinee;
	
	public IOConsole(Scanner scannerDiLinee) {
		this.scannerDiLinee=scannerDiLinee;
	}
		
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	
	public String leggiRiga() {
		
		
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
		 scannerDiLinee = new Scanner(msg);
		if(scannerDiLinee.hasNext())
		msg = scannerDiLinee.next();
		//scannerDiLinee.close();
		return msg;
	}
	
	public String parametro(String msg) {
		 scannerDiLinee = new Scanner(msg);
		
		if(scannerDiLinee.hasNext()) 
		msg = scannerDiLinee.next();
		
		if(scannerDiLinee.hasNext())
		msg = scannerDiLinee.next();
		
		//scannerDiLinee.close();
		return msg;
	}
}
