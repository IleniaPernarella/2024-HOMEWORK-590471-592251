package it.uniroma3.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

class TestGiocatore {
	
	Giocatore giocatore;
	Borsa borsa;
	
	@BeforeEach
	public void setUp() {
		giocatore = new Giocatore();
		borsa = new Borsa();
	}
	
	
	@Test
	void testGetSetBorsa() {
		giocatore.setBorsa(borsa);
		
		assertEquals(borsa,giocatore.getBorsa());
	}

}
