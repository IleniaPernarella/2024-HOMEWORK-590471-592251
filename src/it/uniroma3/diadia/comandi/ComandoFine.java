package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando {

	@Override
	public void esegui(Partita partita) {
		partita.getIo().mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
		partita.setFinita();
	}

	
	public void setParametro(String parametro) {

	}

	
	public String getParametro() {
		return null;
	}

	@Override
	public String getNome() {
		return "fine";
	}

}
