package logic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Soal3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		String kata = "berkesinambungan";
		char[] huruf = kata.toCharArray();
		for (Character ch : huruf) {
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}
		System.out.println("Kata: " + kata);
		System.out.println("Duplikat:");
		Set<Character> keys = map.keySet();
		for (Character ch : keys) {
			if (map.get(ch) > 1) {
				System.out.println(ch + ": " + map.get(ch));
			}
		}
	}

}
