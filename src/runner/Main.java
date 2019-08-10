/**
 * 
 */
package runner;

import java.util.Scanner;

import logic.AksesMySql;
import logic.Soal1;

/**
 * @author petersam
 */
public class Main {
	public static void main(String[] args) throws Exception {
		System.out.println("Opsi(1/2/3/4):");
		System.out.println("1. Insert Database");
		System.out.println("2. Read Database");
		System.out.println("3. Delete Database");
		System.out.println("4. Dismiss");
		
		Scanner s = new Scanner(System.in);
		String opsi = s.next();
		if (opsi.equals("1")) {
			System.out.println("<---Insert Database--->");
			System.out.print("Panjang array: ");
			int pjgArray = s.nextInt();
			int[] angka = new int[pjgArray];
			String input = "";
			for (int i = 0; i < pjgArray; i++) {
				System.out.print("Nilai ke-" + (i+1) + ": ");
				angka[i] = s.nextInt();
				input = input + String.valueOf(angka[i])+ "|";
			}
			int maks = angka[0];
			int min = angka[0];
			for (int i = 0; i < angka.length; i++) {
				if (angka[i]<min) {
					min = angka[i];
				}
				if (angka[i]>maks) {
					maks = angka[i];
				}
			}
			System.out.println("Angka terbesar: "+ maks);
			System.out.println("Angka terkecil: "+ min);
			AksesMySql dao = new AksesMySql();
			dao.writeDatabase(input, maks, min);
			System.out.println("end...");
		}
		else if (opsi.equals("2")) {
			System.out.println("<---Read Database--->");
			AksesMySql dao = new AksesMySql();
			dao.readDatabase();
			System.out.println("end...");
		}
		else if (opsi.equals("3")) {
			System.out.println("<---Delete Database--->");
			AksesMySql dao = new AksesMySql();
			dao.deleteDatabase();
			System.out.println("end...");
		}
		else {
			System.out.println("end...");
		}
	}

}
