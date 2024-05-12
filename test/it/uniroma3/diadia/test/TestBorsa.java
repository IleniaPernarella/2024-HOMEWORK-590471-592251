package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

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
		attrezzo = new Attrezzo("osso",1);

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

	@Test
	void testInserimentoAttrezzoDuplicato() {

		borsa.addAttrezzo(attrezzo);


		assertFalse(borsa.addAttrezzo(attrezzo));
	}

	@Test
	void testOrdinamentoPerPeso() {

		Attrezzo attrezzo1=new Attrezzo("pistola",4);
		Attrezzo attrezzo2=new Attrezzo("libro",2);
		Attrezzo attrezzo3=new Attrezzo("sasso",2);

		borsa.addAttrezzo(attrezzo);
		borsa.addAttrezzo(attrezzo1);
		borsa.addAttrezzo(attrezzo2);
		borsa.addAttrezzo(attrezzo3);



		assertEquals("osso", borsa.getContenutoOrdinatoPerPeso().get(0).getNome());
		assertEquals("libro", borsa.getContenutoOrdinatoPerPeso().get(1).getNome());
		assertEquals("sasso", borsa.getContenutoOrdinatoPerPeso().get(2).getNome());
		assertEquals("pistola", borsa.getContenutoOrdinatoPerPeso().get(3).getNome());
	}

	@Test
	void testOrdinamentoPerNome() {

		Attrezzo attrezzo1=new Attrezzo("pistola",4);
		Attrezzo attrezzo2=new Attrezzo("libro",2);
		Attrezzo attrezzo3=new Attrezzo("sasso",2);

		borsa.addAttrezzo(attrezzo);
		borsa.addAttrezzo(attrezzo1);
		borsa.addAttrezzo(attrezzo2);
		borsa.addAttrezzo(attrezzo3);

		Iterator<Attrezzo> it= borsa.getContenutoOrdinatoPerNome().iterator();


		assertEquals("libro", it.next().getNome());
		assertEquals("osso", it.next().getNome());
		assertEquals("pistola", it.next().getNome());
		assertEquals("sasso", it.next().getNome());

	}

	@Test
	void testOrdinamentoRaggruppatoPerPeso() {

		Attrezzo attrezzo1=new Attrezzo("pistola",4);
		Attrezzo attrezzo2=new Attrezzo("libro",2);
		Attrezzo attrezzo3=new Attrezzo("sasso",2);

		borsa.addAttrezzo(attrezzo);
		borsa.addAttrezzo(attrezzo1);
		borsa.addAttrezzo(attrezzo2);
		borsa.addAttrezzo(attrezzo3);


		Iterator<Attrezzo> it = borsa.getContenutoRaggruppatoPerPeso().get(1).iterator();

		assertEquals("osso", it.next().getNome());
		it = borsa.getContenutoRaggruppatoPerPeso().get(2).iterator();

		assertEquals("sasso", it.next().getNome());
		assertEquals("libro", it.next().getNome());
		
		it = borsa.getContenutoRaggruppatoPerPeso().get(4).iterator();

		assertEquals("pistola", it.next().getNome());

	}
	
	@Test
	void testOrdinamentoSortedSetPerPeso() {

		Attrezzo attrezzo1=new Attrezzo("pistola",4);
		Attrezzo attrezzo2=new Attrezzo("libro",2);
		Attrezzo attrezzo3=new Attrezzo("sasso",2);

		borsa.addAttrezzo(attrezzo);
		borsa.addAttrezzo(attrezzo1);
		borsa.addAttrezzo(attrezzo2);
		borsa.addAttrezzo(attrezzo3);

		Iterator<Attrezzo> it= borsa.getSortedSetOrdinatoPerPeso().iterator();


		assertEquals("osso", it.next().getNome());
		assertEquals("libro", it.next().getNome());
		assertEquals("sasso", it.next().getNome());
		assertEquals("pistola", it.next().getNome());

	}
}
