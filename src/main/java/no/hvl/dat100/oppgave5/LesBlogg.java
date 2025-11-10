package no.hvl.dat100.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.*;
import no.hvl.dat100.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
        Blogg blogg = null;

        try {

            Scanner scanner = null;

            if (filnavn.contains(".dat")) {
                scanner = new Scanner(new File (mappe + "\\" + filnavn));
            } else {
                scanner = new Scanner(new File (mappe + "\\" + filnavn + ".dat"));
            }

            int antall = Integer.parseInt(scanner.nextLine());
            blogg = new Blogg(antall);

            while (scanner.hasNextLine()) {
                String type = scanner.nextLine();
                int id = Integer.parseInt(scanner.nextLine());
                String bruker = scanner.nextLine();
                String dato = scanner.nextLine();
                int likes = Integer.parseInt(scanner.nextLine());
                String tekst = scanner.nextLine();
                if (type.equals(BILDE)) {
                    String url = scanner.nextLine();
                    blogg.leggTil(new Bilde(id, bruker, dato, tekst, url));
                } else {
                    blogg.leggTil(new Tekst(id, bruker, dato, tekst));
                }
            }

            scanner.close();

        } catch (FileNotFoundException ex) {

        }
        return blogg;
	}
}
