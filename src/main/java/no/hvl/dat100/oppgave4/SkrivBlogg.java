package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

        PrintWriter writer = null;
        try {
            if (filnavn.contains(".dat")) {
                writer = new PrintWriter(mappe + "\\" + filnavn);
            } else {
                writer = new PrintWriter(mappe + "\\" + filnavn + ".dat");
            }

            writer.println("Denne er bugga \n" + samling);

        } catch (FileNotFoundException e) {
            return false;

        } finally {
            if (writer != null) {
                writer.close();
            }
        }

        return true;
	}
}
