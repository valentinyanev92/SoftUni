package _14_Reflection_Exercises.P01_HarvestingFields;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String command = scanner.nextLine();
		while (!command.equals("HARVEST")) {
			Printer.print(command);
			command = scanner.nextLine();
		}
	}
}
