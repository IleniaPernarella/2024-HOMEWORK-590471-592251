package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;
import java.util.HashMap;

import it.uniroma3.diadia.CaricatoreLabirinto;
import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;
import it.uniroma3.diadia.personaggi.Strega;

public class Labirinto {

	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;



	/**
	 * Crea tutte le stanze e le porte di collegamento
	 */
	public void creaStanze() {

		/* crea gli attrezzi */
		Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo sasso = new Attrezzo("sasso",2);
		Attrezzo torcia = new Attrezzo("torcia",4);
		Attrezzo chiave = new Attrezzo("chiave",1);
		Attrezzo martello = new Attrezzo("martello",3);

		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		StanzaMagica aulaN18 = new StanzaMagica("Aula N18");
		StanzaBuia bagno = new StanzaBuia("Bagno");
		StanzaBloccata ufficio = new StanzaBloccata("Ufficio","chiave","nord");


		AbstractPersonaggio Strega= new Strega("Strega Morgana","Strega cattiva");


		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);
		aulaN18.impostaStanzaAdiacente("nord",aulaN11);
		aulaN11.impostaStanzaAdiacente("sud", aulaN18);
		bagno.impostaStanzaAdiacente("sud", aulaN11);
		aulaN11.impostaStanzaAdiacente("nord", bagno);
		aulaN10.impostaStanzaAdiacente("sud", ufficio);
		ufficio.impostaStanzaAdiacente("nord", aulaN10);


		/* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		atrio.addAttrezzo(martello);
		aulaN18.addAttrezzo(sasso);
		bagno.addAttrezzo(torcia);
		ufficio.addAttrezzo(chiave);



		//pone i personaggi
		laboratorio.setPersonaggio(Strega);

		// il gioco comincia nell'atrio
		stanzaCorrente = atrio;  
		stanzaVincente = biblioteca;
	}


	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}


	public Labirinto(String nomeFile)  {
		
		CaricatoreLabirinto c=null;
		
		try {
			c = new CaricatoreLabirinto(nomeFile);
			
		} catch (FileNotFoundException e) {
	
			e.printStackTrace();
		}
		
		
		try {	
			c.carica();
			
		} catch (FormatoFileNonValidoException e) {
			
			e.printStackTrace();
		}
		
		
		this.stanzaCorrente = c.getStanzaIniziale();
		this.stanzaVincente = c.getStanzaVincente();
	}
	
	
	public class LabirintoBuilder {

		private Labirinto labirinto= new Labirinto("Labirinto1.txt");
		HashMap<String,Stanza> listaStanze = new HashMap<>();
		Stanza ultimaStanza;

		public LabirintoBuilder addStanzaIniziale(String stanza) {
			this.ultimaStanza = new Stanza(stanza);
			this.listaStanze.put(stanza,ultimaStanza);
			this.labirinto.setStanzaCorrente(ultimaStanza);	
			return this;
		}

		public LabirintoBuilder addStanzaVincente(String stanza) {
			
			this.ultimaStanza = new Stanza (stanza);
			this.listaStanze.put(stanza,this.ultimaStanza);
			this.labirinto.setStanzaVincente(this.ultimaStanza);	
			return this;
		}

		public Labirinto getLabirinto() {
			return this.labirinto;
		}
		
		
		public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso) {
			
			
			this.ultimaStanza.addAttrezzo(new Attrezzo(nomeAttrezzo,peso));
				
			return this;
		}
		
		public LabirintoBuilder addAdiacenza(String corrente, String adiacente, String direzione) {
			
			
			this.listaStanze.get(corrente).impostaStanzaAdiacente(direzione, this.listaStanze.get(adiacente));
			
			return this;
			
		}
		
		public HashMap<String,Stanza> getListaStanze() {
			return  this.listaStanze;
		}
		
		public LabirintoBuilder addStanza(String stanza) {
			
			this.ultimaStanza = new Stanza(stanza);
			this.listaStanze.put(stanza,this.ultimaStanza);
			return this;
		}
		
	}


}
