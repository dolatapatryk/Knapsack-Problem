package implementation;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Greedy implements Algorithm {
	private Item[] container;
	private Item[] knapsack;
	
	
	public Greedy() throws NumberFormatException, IOException {
		this.container = load(this.container);
	}

	@Override
	public int[][] solveProblem(Item[] container) {
		
		
	}

	@Override
	public Item[] load(Item[] container) throws NumberFormatException, IOException {
		String file = "data.txt";
		BufferedInputStream data = new BufferedInputStream(new FileInputStream(file));
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

	@Override
	public void writeSolution(int[][] tab, Item[] container, Item[] knapsack) {

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

}
