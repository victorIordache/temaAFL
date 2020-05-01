package automat;

import java.io.IOException;
import java.util.Scanner;

public class AFL {
	static int q0 = 0, q1;
	static int q2;

	public static void main(String[] args) throws IOException {
		System.out.println("Esti in faza " + q0);
		String verify = "";
		String cuvant = verifyAlphabet(verify);
		if (q1 == 1) {
			System.out.println("Esti in faza" + " " + q1);
			verifyOmega(cuvant);
		}
	}

	public static String verifyAlphabet(String cuvant) {
		boolean corect = true;   // Variabila creata cu scopul de a afisa o singura data String-ul eroare/aprobat
		String aprobat = "Cuvantul dat apartine alfabetului dat.";
		String eroare = "Cuvantul dat nu apartine alfabetului dat.";
		Scanner input = new Scanner(System.in);
		System.out.println("Spune-mi un cuvant: "); // iau cuvantul de la tastatura ( liniile 24-27)
		cuvant = input.next();
		input.close();
		for (int i = 0; i <= cuvant.length() - 1; i++) {
			char verifyString = cuvant.charAt(i);
			if (verifyString >= 'a' && verifyString <= 'b') {  // daca cuvantul contine doar a sau b corect ramane true
				corect = true;
			} else {
				corect = false;
				break;
			}
		}
		if (corect == true) {
			System.out.println(aprobat);
			q1 = q0 + 1;
		} else {
			System.out.println(eroare);
			System.out.println("Ai ramas in faza 0");
		}
		return cuvant;
	}

	public static void verifyOmega(String cuvant) {
		boolean limbaj = false;  // Variabila creata cu scopul de a afisa o singura data String-urile de la final
		for (int i = 1; i <= cuvant.length() - 4; i++) { // citirea o fac doar in interior, evit prima si ultima litera a.i. cuvintele de tipul aab,aba etc.. sa nu fie admisibile
			if (cuvant.charAt(i) == 'a' && cuvant.charAt(i + 1) == 'a' && cuvant.charAt(i + 2) == 'b') {
				limbaj = true;
				q2 = q0 + 2;
				break;
			}
		}
		if (limbaj == true) {
			System.out.println("Cuvantul dat apartine limbajului dat");
			System.out.println("Esti in faza" + " " + q2 + " adica finala");
		} else {
			System.out.println("Cuvantul dat nu apartine limbajului dat");
			System.out.println("Ai ramas la faza " + q1);
		}
	}
}
