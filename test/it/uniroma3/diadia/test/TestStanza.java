package it.uniroma3.diadia.test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class TestStanza {

	private Attrezzo attrezzo;
	private Attrezzo attrezzo1;
	private Stanza stanza;

	
	@BeforeEach
	public void setUp() {
	attrezzo = new Attrezzo("osso",4);
	attrezzo1 = new Attrezzo("pistola",5);
	stanza = new Stanza("n11");
	}


	@Test
	public void testAggiuntaAttrezzoStanzaPiena() {
		
		stanza.addAttrezzo(attrezzo);
		stanza.addAttrezzo(attrezzo);
		stanza.addAttrezzo(attrezzo);
		stanza.addAttrezzo(attrezzo);
		stanza.addAttrezzo(attrezzo);
		stanza.addAttrezzo(attrezzo);
		stanza.addAttrezzo(attrezzo);
		stanza.addAttrezzo(attrezzo);
		stanza.addAttrezzo(attrezzo);
		stanza.addAttrezzo(attrezzo);

		assertFalse(stanza.addAttrezzo(attrezzo));
	}
	
	@Test
	public void testAggiuntaAttrezzoStanzaVuota() {
		
		assertTrue(stanza.addAttrezzo(attrezzo));
	}
	
	@Test
	public void testAggiuntaAttrezoStanzaMeta() {
		
		stanza.addAttrezzo(attrezzo);
		stanza.addAttrezzo(attrezzo);
		stanza.addAttrezzo(attrezzo);
		stanza.addAttrezzo(attrezzo);
		
		assertTrue(stanza.addAttrezzo(attrezzo));
	}
	
	@Test
	public void testRicercaAttrezzoCercatoETrovato() {
		stanza.addAttrezzo(attrezzo);
		assertTrue(stanza.hasAttrezzo("osso"));
	}
	
	@Test
	public void testNonEsistenzaAttrzzo1() {
		stanza.addAttrezzo(attrezzo1);
		stanza.addAttrezzo(attrezzo1);
		stanza.addAttrezzo(attrezzo1);
		stanza.addAttrezzo(attrezzo1);
		stanza.addAttrezzo(attrezzo1);
		
		assertFalse(stanza.hasAttrezzo("osso"));
	}
	
	@Test
	public void testAggiuntaStanzaAdiacente() {
		Stanza stanza2 = new Stanza("n12");
		stanza2.impostaStanzaAdiacente("nord",stanza2);
		
		assertEquals(stanza2,stanza2.getStanzaAdiacente("nord"));
	}
	
}



