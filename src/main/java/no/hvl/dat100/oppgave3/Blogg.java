package no.hvl.dat100.oppgave3;

import no.hvl.dat100.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggTabell;
    private int nesteLedige;

	public Blogg() {
		innleggTabell = new Innlegg[20];
        nesteLedige = 0;
	}

	public Blogg(int lengde) {
		innleggTabell = new Innlegg[lengde];
        nesteLedige = 0;
	}

	public int getAntall() {
		return nesteLedige;
	}
	
	public Innlegg[] getSamling() {
        return innleggTabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {

        for (int i = 0; i < nesteLedige; i++) {
            if (innleggTabell[i].erLik(innlegg)){
                return i;
            }
        }

        return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		return finnInnlegg(innlegg) != -1;
	}

	public boolean ledigPlass() {
		return nesteLedige < innleggTabell.length;

	}
	
	public boolean leggTil(Innlegg innlegg) {
        boolean inserted = true;

        if (nesteLedige >= innleggTabell.length) {
            System.out.println("add innlegg does not work because the list is full");
            inserted = false;
            return inserted;
        } else if (innleggTabell[nesteLedige] == null) {
            innleggTabell[nesteLedige] = innlegg;
        }

        do {
            nesteLedige++;
        } while (nesteLedige < innleggTabell.length && innleggTabell[nesteLedige] != null);

        return inserted;
	}
	@Override
	public String toString() {
        String toStringVar = Integer.toString(nesteLedige) + "\n";
        for (int i = 0 ; i < nesteLedige; i++) {
            toStringVar += innleggTabell[i].toString(); // kanskje <h2> osv her for oppagve 6?
        }

        return toStringVar;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {

        if (nesteLedige == innleggTabell.length) {
            Innlegg[] temp = new Innlegg[innleggTabell.length*2];

            for (int i = 0; i < innleggTabell.length; i++) {
                temp[i] = innleggTabell[i];
            }

            innleggTabell = temp;
        }
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		if (nesteLedige >= innleggTabell.length) {
            utvid();
            return leggTil(innlegg);
        } else {
            return leggTil(innlegg);
        }
		
	}
	
	public boolean slett(Innlegg innlegg) {

        for (int i = 0; i < nesteLedige; i++) {
            if (innleggTabell[i].getId() == innlegg.getId()) {
                nesteLedige --;
                innleggTabell[i] = null;
                System.out.println("Innlegget med id-en: " + innlegg.getId() + " er slettet. \n");

                for (int j = i; j < innleggTabell.length - 1; j++) {
                    if (innleggTabell[j+1] != null) {
                        innleggTabell[j] = innleggTabell[j + 1];
                    } else if(innleggTabell[j] != null && innleggTabell[j+1] == null) {
                        innleggTabell[j] = null;
                        break;
                    }
                }
                return true;
            }
        }
        return false;
	}
	
	public int[] search(String user, String ord) {
		
		int[] idsUntrimmed = new int[nesteLedige];

        int j = 0;

        for (int i = 0; i < nesteLedige; i++) {
            if (innleggTabell[i].toString().contains(ord) && innleggTabell[i].getBruker().equals(user)) {
                idsUntrimmed[j] = innleggTabell[i].getId();
                j++;
            }
        }

        int[] idsTrimmed = new int[j];

        for(int i = 0; i < j; i++) {
            idsTrimmed[i] = idsUntrimmed[i];
        }

        return idsTrimmed;

	}
}