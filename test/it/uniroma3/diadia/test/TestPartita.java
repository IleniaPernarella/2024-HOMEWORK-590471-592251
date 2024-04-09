package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

class TestPartita {

	private Partita partita;
	private Stanza stanza;
	
	@BeforeEach
	public void setUp() {
	partita = new Partita();
	stanza = new Stanza("n11");
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", partita.getLabirinto().getStanzaVincente().getNome());
	}
	
	@Test
	public void testGetStanzaIniziale() {
		assertEquals("Atrio", partita.getLabirinto().getStanzaCorrente().getNome());
	}
	
	@Test
	public void testSetStanzaCorrente() {
		partita.getLabirinto().setStanzaCorrente(stanza);
		assertEquals(stanza, partita.getLabirinto().getStanzaCorrente());
	}

	@Test
	public void testPartitaFinita() {
		
		assertFalse(partita.isFinita());
	}

}
