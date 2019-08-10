package logic;

import java.util.Scanner;
import java.sql.*;

public class Soal1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		System.out.print("Panjang array: ");
		int pjgArray = s.nextInt();
		int[] angka = new int[pjgArray];
		for (int i = 0; i < pjgArray; i++) {
			System.out.print("Nilai ke-" + (i+1) + ": ");
			angka[i] = s.nextInt();
		}
		cariMinMaks(angka);
	}
	
	public static void cariMinMaks(int[] angka) {
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
	}
}
