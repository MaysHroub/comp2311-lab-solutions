package lab3;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Act1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Number> list = new ArrayList<>();
		
		System.out.print("Enter 10 integers: ");
		for (int i = 0; i < 10; i++) 
			list.add(in.nextInt());
		
		shuffle(list);
		for (Number n : list) 
			System.out.print(n + " ");
	}
	
	public static void shuffle(ArrayList<Number> list) {
		Random rand = new Random();
		int index;
		Number temp;
		for (int i = 0; i < list.size(); i++) {
			index = rand.nextInt(list.size()); // or (int) (Math.random()*list.size())
			temp = list.get(index);
			list.set(index, list.get(i));
			list.set(i, temp);
		}
	}

}
