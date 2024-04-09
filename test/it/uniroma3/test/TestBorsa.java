package it.uniroma3.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class TestBorsa {
	
	Borsa borsa;
	Attrezzo attrezzo;
	
	@BeforeEach
	public void setUp() {
		
		borsa = new Borsa(10);
		attrezzo = new Attrezzo("osso",2);
		
	}
	
	
	@Test
	void testAddAttrezzoBorsaVuota(){
		
		borsa.addAttrezzo(attrezzo);
		assertEquals(attrezzo,borsa.getAttrezzo("osso"));
	}
	
	@Test
	void testAddAttrezzoBorsaPiena(){
		
		Attrezzo attrezzo1=new Attrezzo("pistola",10);
		borsa.addAttrezzo(attrezzo1);
		
		assertFalse(borsa.addAttrezzo(attrezzo));
	}
	
	@Test
	void testRemoveAttrezzo() {

		borsa.addAttrezzo(attrezzo);
		borsa.removeAttrezzo("osso");
		
		assertTrue(borsa.isEmpty());
	}
	
	@Test
	void testRemoveAttrezzoBorsaVuota() {
		
		assertEquals(null,borsa.removeAttrezzo("osso"));
	}

	@Test
	void testRemoveAttrezzoBorsaPienaAttrezzoInesistente() {
		
		borsa.addAttrezzo(attrezzo);
		borsa.addAttrezzo(attrezzo);
		borsa.addAttrezzo(attrezzo);
		borsa.addAttrezzo(attrezzo);
		borsa.addAttrezzo(attrezzo);
		borsa.addAttrezzo(attrezzo);
		borsa.addAttrezzo(attrezzo);
		borsa.addAttrezzo(attrezzo);
		borsa.addAttrezzo(attrezzo);
		borsa.addAttrezzo(attrezzo);		
		
		assertEquals(null,borsa.removeAttrezzo("pistola"));
	}
}
