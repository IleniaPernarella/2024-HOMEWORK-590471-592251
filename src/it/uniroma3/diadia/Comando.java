package it.uniroma3.diadia;



/**
 * Questa classe modella un comando.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * (Ad es. alla riga digitata dall'utente "vai nord"
 *  corrisponde un comando di nome "vai" e parametro "nord").
 *
 * @author  docente di POO
 * @version base
 */

public class Comando {
	
    private String nome;
    private String parametro;
    IOConsole IO = new IOConsole();

    public Comando(String istruzione) {
		
		
		// prima parola: nome del comando
		
			this.nome = IO.parola(istruzione); 

		// seconda parola: eventuale parametro
		
			this.parametro = IO.parametro(istruzione);
	
		}
		

    public String getNome() {
        return this.nome;
    }

    public String getParametro() {
        return this.parametro;
    }

    public boolean sconosciuto() {
        return (this.nome == null);
    }
}