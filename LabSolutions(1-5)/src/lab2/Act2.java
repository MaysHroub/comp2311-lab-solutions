package lab2;

import java.util.ArrayList;
import java.util.Scanner;


public class Act2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		
		System.out.print("Enter 10 values: ");
		for (int i = 0; i < 10; i++)
			list.add(input.nextInt());

		removeDuplicate(list);
		for (int n : list)
			System.out.print(n + " ");
	}

	public static void removeDuplicate(ArrayList<Integer> list) {
		if (list == null) return;
		
		for (int i = 0; i < list.size(); i++) {
			int n = list.get(i);
			for (int j = i+1; j < list.size(); ) 
				if (n == list.get(j))
					list.remove(j);
				else
					j++;
		}
	}
}




















