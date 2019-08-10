package logic;

import java.util.Scanner;

public class Soal4 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Masukan: ");
		String input = s.next();
		
		try {
			int angka = Integer.valueOf(input);
			System.out.print(input + " adalah angka");
		} catch (Exception e) {
			System.out.print(input + " bukan angka");
		}
		
	}
}
