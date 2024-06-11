package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando {
	String nomeAttrezzo;


	@Override
	public void esegui(Partita partita) {


		Attrezzo attrezzo = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);

		if(partita.getLabirinto().getStanzaCorrente().removeAttrezzo(nomeAttrezzo)) {


			if(partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)) {
				partita.getIo().mostraMessaggio("Attrezzo " +nomeAttrezzo + " aggiunto nella borsa");

				partita.getLabirinto().getStanzaCorrente().removeAttrezzo(nomeAttrezzo);
			}
			else {
				partita.getIo().mostraMessaggio("Impossibile prendere l'attrezzo");
				partita.getStanzaCorrente().addAttrezzo(attrezzo);
			}
		}
		else {
			partita.getIo().mostraMessaggio(nomeAttrezzo+" non presente in stanza");
		}

	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;

	}

	public String getParametro() {
		return this.nomeAttrezzo;
	}

	@Override
	public String getNome() {
		return "prendi";
	}

}
