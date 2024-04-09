package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

class TestLabirinto {

	Labirinto labirinto;
	Stanza stanza;
	
	@BeforeEach
	public void setUp() {
		
		labirinto = new Labirinto();
		stanza = new Stanza("n11");
	}
	
	@Test
	void testGetSetStanzaCorrente() {
		labirinto.setStanzaCorrente(stanza);
		
		assertEquals(stanza,labirinto.getStanzaCorrente());
	}

}
