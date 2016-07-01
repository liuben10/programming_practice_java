package main;

import java.awt.Point;
import java.util.Random;
import java.util.Scanner;

public class a {
	private static final double M = 0;
	static Object Q;

	public static double a()
	{
		//public static void main(String []args){
		Scanner reader = new Scanner(System.in);
		System.out.println("enter the no.:");
		int k = reader.nextInt();
		String str = Integer.toBinaryString(k);
		int n = str.length();
		Point P = new Point();
		Random r = new Random();
		int s = r.nextInt(50)+1;
		int Ls = Integer.toBinaryString(s).length();

		int L = n/Ls;
		int Lr = n%Ls;
		int Sr = s>>(Ls-Lr);
		int Mr = 0;
		double Q = Mr;
		for(int i = 0;i<L;i++){
			Q = (Math.pow(2, Ls)*Q);
			//int M;
			Q=Q+M;
		}
		return Q;
	}

	public void Q() {
		// TODO Auto-generated method stub

	}

}