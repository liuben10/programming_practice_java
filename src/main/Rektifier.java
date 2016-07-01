package main;

public class Rektifier {

	public static void main(String[] args) {
		int lines = 1;
		while (lines <= Integer.parseInt(args[0])){ 
			for (int x = 0; x < lines; x += 1){ 
				System.out.print("*");
			}
			lines += 1;
			System.out.println();
		}
	}
}