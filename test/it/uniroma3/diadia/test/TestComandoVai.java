package it.uniroma3.diadia.test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.ComandoVai;

class TestComandoVai {
	
	private IO io;
	private Partita partita;
	private ComandoVai vai;
	private Stanza stanza1;
	private Stanza stanza2;
	
	@BeforeEach
	public void setUp() {

		io=new IOConsole();
		partita=new Partita(io);
		vai=new ComandoVai();
		stanza1=new Stanza("stanza1");
		stanza2=new Stanza("stanza2");
		
		stanza1.impostaStanzaAdiacente("sud", stanza2);
		stanza2.impostaStanzaAdiacente("nord", stanza1);
		
		partita.setStanzaCorrente(stanza1);


	}
	
	@Test
	void testEseguiDirezioneNulla() {
		
		vai.setParametro(null);
		vai.esegui(partita);
		assertEquals(stanza1,partita.getStanzaCorrente());
	}
	
	
	@Test
	void testEseguiDirezioneGiusta() {
		
		vai.setParametro("sud");
		vai.esegui(partita);
		assertEquals(stanza2,partita.getStanzaCorrente());
	}
	
	
	@Test
	void testEseguiDirezioneInesistente() {
		
		vai.setParametro("est");
		vai.esegui(partita);
		assertEquals(stanza1,partita.getStanzaCorrente());
	}

}
