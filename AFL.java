package automat;

import java.io.IOException;
import java.util.Scanner;

public class AFL {
	static int q0 = 0, apartineAlfabet;
	static boolean raspunsFinal = false;

	public static void main(String[] args) throws IOException {
		System.out.println("Esti in faza " + q0);
		String verify = "";
		String cuvant = verifyAlphabet(verify);
		if (apartineAlfabet == 1) { // variabila apartineAlfabet este calculata la linia 41
			for (int i = 0; i <= cuvant.length() - 1; i++) { // aplic functia transition pentru fiecare litera a
																// cuvantului
				transition(q0, cuvant.charAt(i)); // transition modifica totodata boolean-ul raspunFinal
			}
		}
		apartine(raspunsFinal);
	}

	public static String verifyAlphabet(String cuvant) {
		boolean corect = true; // Variabila creata cu scopul de a afisa o singura data String-ul eroare/aprobat
		String aprobat = "Cuvantul dat apartine alfabetului dat.";
		String eroare = "Cuvantul dat nu apartine alfabetului dat.";
		Scanner input = new Scanner(System.in);
		System.out.println("Spune-mi un cuvant: "); // iau cuvantul de la tastatura ( liniile 24-27)
		cuvant = input.next();
		input.close();
		for (int i = 0; i <= cuvant.length() - 1; i++) {
			char verifyString = cuvant.charAt(i); // aleg fiecare litera in parte din cuvant
			if (verifyString >= 'a' && verifyString <= 'b') { // daca cuvantul contine doar a sau b corect ramane true
				corect = true;
			} else {
				corect = false;
				break;
			}
		}
		if (corect == true) {
			System.out.println(aprobat);
			apartineAlfabet = q0 + 1;
		} else {
			System.out.println(eroare);
			System.out.println("Ai ramas in faza 0");
		}
		return cuvant;
	}

	public static void transition(int stare, char l) { // functia de tranzitie
		if (stare == 0 && l == 'a') {
			q0 = 1;
			System.out.println("Esti in starea " + q0);
		}
		if (stare == 0 && l == 'b') {
			q0 = 0;
			System.out.println("Esti in starea " + q0);
		}
		if (stare == 1 && l == 'a') {
			q0 = 2;
			System.out.println("Esti in starea " + q0);
		}
		if (stare == 1 && l == 'b') {
			q0 = 0;
			System.out.println("Esti in starea " + q0);
		}
		if (stare == 2 && l == 'a') {
			q0 = 2;
			System.out.println("Esti in starea " + q0);
		}
		if (stare == 2 && l == 'b') {
			q0 = 3;
			raspunsFinal = true;
			System.out.println("Esti in starea " + q0 + " adica finala");
		}
	}

	public static void apartine(boolean apartine) { // raspunsul final
		if (apartine == true) {
			System.out.println("Apartine limbajului dat");
		}
		if (apartine == false) {
			System.out.println("Nu apartine limbajului dat");
		}
	}
}