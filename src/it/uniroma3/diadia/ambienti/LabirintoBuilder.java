package it.uniroma3.diadia.ambienti;

import java.util.HashMap;


import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {

	private Labirinto labirinto= new Labirinto();
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
