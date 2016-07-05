/**
 * Problem Statement
    	Wolf Sothe and Cat Snuke are playing a card game. The game is played with exactly 100 cards. 
    	The cards are numbered from 1 to 100. The game is played as follows:
First, Cat Snuke chooses the goal: an integer N between 1 and 100, inclusive.
Then, Wolf Sothe chooses exactly K of the 100 cards and gives the chosen cards to Snuke.
Next, Cat Snuke may throw some of those K cards away. 
He may choose any subset of cards he was given, possibly none or all of them.
Finally, Cat Snuke may write minus signs onto any subset of the cards he still holds. 
For example, if he currently has the cards {1,3,4,7}, he may alter them to {-1,3,4,-7}.
At the end of the game, Snuke computes the sum of the numbers on his cards (with the added minus signs). Snuke wins the game if the sum is exactly equal to the goal number N. Otherwise, Sothe wins.



Your task is to help Wolf Sothe win the game. 
We are now in step 2 of the game. You are given the int N chosen by Snuke and the int K that specifies the number
 of cards you have to give to Snuke. 
 Choose those K cards in such a way that Snuke will be unable to win the game.
  If you can do that, return a int[] with K elements: the numbers on the chosen cards.
   If there are multiple solutions, you may return any of them.
    If there is no solution, return an empty int[] instead.
    
    Definition
    	
Class:	WolfCardGame
Method:	createAnswer
Parameters:	int, int
Returns:	int[]
Method signature:	int[] createAnswer(int N, int K)
(be sure your method is public)
    
 
Constraints
-	N will be between 1 and 100, inclusive.
-	K will be between 1 and 15, inclusive.
 
Examples
0)	
    	
20
4
Returns: {1, 2, 3, 4 }
If we give Snuke cards with numbers 1, 2, 3, and 4 on them, the largest sum he can form is 1+2+3+4 = 10. Thus, he cannot reach N=20 and we win.
1)	
    	
40
1
Returns: {39 }
2)	
    	
97
6
Returns: {7, 68, 9, 10, 62, 58 }
3)	
    	
2
12
Returns: {33, 69, 42, 45, 96, 15, 57, 12, 93, 9, 54, 99 }

 */

package topcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WolfCardGame {
	
	/*
	 * Not sure if this is a solution. Gonna have to think about it some more..
	 */
	public static void main(String...args) {
		System.out.println(Arrays.toString(createAnswer(30, 15)));

	}
	
	public static int[] createAnswer(int N, int K) {
		int[] solution = new int[K];
		if (K < N/2) {
			for(int i = 0 ; i < K; i++) {
				solution[i] = i+1;
			}
		} else {
			int cnt = 0;
			for(int i = N+1; cnt < K; i += (N+1), cnt += 1) {
				solution[cnt] = i % 100;
			}
		}
		return solution;
		
		
	}

}
