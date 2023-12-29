package lab2;

import java.util.ArrayList;
import java.util.Scanner;

public class Act1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();

		System.out.print("Enter a sequence of values (Enter 0 to stop): ");
		int n = 0;
		while (true) {
			n = input.nextInt();
			if (n == 0)
				break;
			list.add(n);
		}

		Integer mx = max(list);
		System.out.println((mx == null) ? "Your list is empty..." : "The maximum value is " + mx);
	}

	public static Integer max(ArrayList<Integer> list) {
		if (list == null || list.size() == 0)
			return null;

		int max = list.get(0);
		for (int i = 1; i < list.size(); i++)
			max = (max < (list.get(i))) ? list.get(i) : max;

		return max;
	}

}
