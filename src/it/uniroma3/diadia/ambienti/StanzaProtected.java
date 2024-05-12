package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;


public class StanzaProtected {

	static final protected int NUMERO_MASSIMO_DIREZIONI = 4;
	static final protected int NUMERO_MASSIMO_ATTREZZI = 10;

	protected String nome;
	protected Set<Attrezzo>attrezzi;
	protected int numeroAttrezzi;
	protected Map<String,StanzaProtected>stanzeAdiacenti;
	protected int numeroStanzeAdiacenti;
	

	
	public StanzaProtected(String nome) {
		this.nome = nome;
		this.numeroStanzeAdiacenti = 0;
		this.numeroAttrezzi = 0;
		this.attrezzi=new HashSet<Attrezzo>();
		this.stanzeAdiacenti=new HashMap<String,StanzaProtected>();
	}

	
	public void impostaStanzaAdiacente(String direzione, StanzaProtected stanza) {


		this.stanzeAdiacenti.put(direzione, stanza);
		if(this.numeroStanzeAdiacenti<NUMERO_MASSIMO_DIREZIONI)
			this.numeroStanzeAdiacenti++;
	}

	
	public StanzaProtected getStanzaAdiacente(String direzione) {

		return stanzeAdiacenti.get(direzione);
	}

	
	
	public String getNome() {
		return this.nome;
	}

	
	
	public String getDescrizione() {
		return this.toString();
	}

	
	
	public Set<Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
			this.attrezzi.add(attrezzo);
			this.numeroAttrezzi++;
			return true;
				
		}
		else {
			return false;
		}
	}

	
	
	public String toString() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");

		Set<String> direzioni=stanzeAdiacenti.keySet();
		Iterator<String> it=direzioni.iterator();

		while(it.hasNext()) {
			risultato.append(" " + it.next());
		}
		risultato.append("\nAttrezzi nella stanza: ");

		Iterator<Attrezzo> it2=attrezzi.iterator();
		while(it2.hasNext()) {
			risultato.append(it2.next().toString()+" ");
		}

		return risultato.toString();
	}

	
	
	public boolean hasAttrezzo(String nomeAttrezzo) {

		return attrezzi.contains(this.getAttrezzo(nomeAttrezzo));

	}

	
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {

		Iterator<Attrezzo> it=attrezzi.iterator();

		Attrezzo a = null;
		Attrezzo b=null;
		if(nomeAttrezzo!=null)
			while(it.hasNext()) {

				b=it.next();

				if(b.getNome().equals(nomeAttrezzo))
					return b;
			}

		return a;
	}

	
	

	public boolean removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a=null;
		if(nomeAttrezzo!=null) {
			if(this.hasAttrezzo(nomeAttrezzo)) {
				a= this.getAttrezzo(nomeAttrezzo);
				return this.attrezzi.remove(a);
			}
		}

		return false;
	}
	
	
	public int getNumeroStanzeAdiacenti() {
		return numeroStanzeAdiacenti;
	}

	public int getNumeroAttrezzi() {
		return numeroAttrezzi;
	}

	@Override
	public int hashCode() {
		return this.nome.hashCode()+this.numeroAttrezzi+this.numeroStanzeAdiacenti;
	}

	@Override
	public boolean equals(Object o) {

		StanzaProtected that=(StanzaProtected)o;

		return this.nome.equals(that.getNome()) && this.numeroAttrezzi==that.getNumeroAttrezzi() &&
				this.numeroStanzeAdiacenti == that.getNumeroStanzeAdiacenti();
	}

	

}