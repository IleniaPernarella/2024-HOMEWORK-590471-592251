package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	String nomeAttrezzo;
	@Override
	public void esegui(Partita partita) {
		
		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if(attrezzo!=null) {


			if(partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo)) {

				partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
				partita.getIo().mostraMessaggio("Attrezzo "+nomeAttrezzo + " posato");
			}
			else {
				partita.getIo().mostraMessaggio("Impossibile posare l'attrezzo");
			}
		}else {
			partita.getIo().mostraMessaggio("Impossibile posare l'attrezzo");
		}

	}

	@Override
	public void setParametro(String parametro) {
		 this.nomeAttrezzo=parametro;

	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

	@Override
	public String getNome() {
		return "posa";
	}

}
