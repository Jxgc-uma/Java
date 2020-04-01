package prDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PruebaDatos {

	private static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		List<String> mis_datos = new ArrayList<String>();
		while (true) {
			mis_datos.add(scan.next());
			if (scan.next() != ".") {
				mis_datos.add(scan.next());
				break;
			}
		}
		System.out.println(mis_datos);
	}

}
