package implementation;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Greedy{
	private Item[] container;
	private Item[] knapsack;
	private int amount;  //final number of items in knapsack
	
	public Greedy() throws NumberFormatException, IOException {
		this.amount = 0;
		this.container = load(this.container);
		this.knapsack = solveProblem(this.container);
		writeSolution(this.knapsack);
	}

	public Item[] solveProblem(Item[] container) {
		knapsack = new Item[Main.n];
		int weight = 0; //current weight in knapsack
		int value = 0; //current value in knapsack
		for (int i = 0; i < Main.n; i++) {
			if (container[i].getWeight() + weight <= Main.b) {
				knapsack[amount++] = container[i];
				weight += container[i].getWeight();
				value += container[i].getValue();
			}
		}
		return knapsack;
		
	}

	public Item[] load(Item[] container) throws NumberFormatException, IOException {
		String file = "data.txt";
		BufferedInputStream data = new BufferedInputStream(new FileInputStream(file));
		@SuppressWarnings("resource")
		Scanner in = new Scanner(data);
		Main.n = in.nextInt();
		Main.b = in.nextInt();
		container = new Item[Main.n];
		for(int i=0;i<Main.n;i++) {
			container[i] = new Item(i+1,in.nextInt(),in.nextInt());
		}
		Compare comp = new Compare();
		Arrays.sort(container,comp);
		return container;
	}

	public void writeSolution(Item[] knapsack) {
		int value = 0;
		int weight = 0;
		System.out.println("***GREEDY SOLUTION*** ");
		for(int i=0;i<amount;i++) {
			System.out.println(knapsack[i]);
			value+=knapsack[i].getValue();
			weight+=knapsack[i].getWeight();
		}
		System.out.println("Value: "+value);
		System.out.println("Weight: "+weight);
	}
	
	

	public Item[] getContainer() {
		return container;
	}

	public void setContainer(Item[] container) {
		this.container = container;
	}

	public Item[] getKnapsack() {
		return knapsack;
	}

	public void setKnapsack(Item[] knapsack) {
		this.knapsack = knapsack;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
