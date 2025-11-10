package no.hvl.dat100.oppgave2;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Tekst extends Innlegg {

	private String tekst;
	
	public Tekst () {
		
	}
	
	public Tekst(int id, String bruker, String dato, String tekst) {
		this(id,bruker,dato,0,tekst);
	}
	
	public Tekst(int id, String bruker, String dato, int likes, String tekst) {
		super(id,bruker,dato,likes);
        this.tekst = tekst;
	}
	
	public String getTekst() {
		return this.tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

    @Override
    public String toString() {
        return "TEKST\n" + getToStringData();
    }

    // This method returns ONLY the data, not the TEKST label
    protected String getToStringData() {
        return super.toString() + tekst + "\n";
    }
	
	// Metoden nedenfor er kun for valgfri oppgave 6
    @Override
	public String toHTML() {
		return super.toHTML() + "\n<p>" + tekst + "</p>\n";
	}
}
