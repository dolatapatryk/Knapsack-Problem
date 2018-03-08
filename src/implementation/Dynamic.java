package implementation;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Dynamic implements Algorithm {
	private Item[] container;
	private Item[] knapsack;
	private int[][] tab; 
	
	public Dynamic() throws NumberFormatException, IOException {
		this.container = load(this.container);
		this.tab = solveProblem(this.container,this.tab);
		writeSolution(this.tab,this.container,this.knapsack);
	}

	@Override
	public int[][] solveProblem(Item[] container, int[][] tab) {
		
		tab = new int[Main.n+1][Main.b+1];
		int i;
		for (i = 0; i <= Main.n; i++) {
			tab[i][0] = 0;
		}
		for (i = 0; i <= Main.b; i++) {
			tab[0][i] = 0;
		}

		for (i = 1; i <= Main.n; i++) {
			for (int j = 0; j <= Main.b; j++) {
				if (container[i - 1].weight > j) {
					tab[i][j] = tab[i - 1][j];
				}
				if (container[i - 1].weight <= j) {
					tab[i][j] = max(tab[i - 1][j], tab[i - 1][j - container[i - 1].weight] + container[i - 1].value);
				}
			}
		}
		return tab;
	}

	private int max(int i, int j) {
		int max = i;
		if(j>max)  max = j;
		return max;
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
		return container;
		
	}

	@Override
	public void writeSolution(int[][] tab, Item[] container, Item[] knapsack ) {
		int y = Main.n;
		int z = Main.b;
		int m =0;
		int value = 0, weight = 0;
		knapsack = new Item[Main.n];
		while (y > 0 && z > 0) {
		if (tab[y][z] != tab[y - 1][z]) {
			knapsack[m++] = container[y - 1];
			y--;
			z = z - container[y].weight;
		}
		else {
			y--;
		}
	}
		System.out.println("***DYNAMIC SOLUTION***");
		for(int i=0;i<m;i++) {
			System.out.println(knapsack[i]);
			value+=knapsack[i].value;
			weight+=knapsack[i].weight;
		}
		System.out.println("Value: "+value);
		System.out.println("Weight: "+weight+"\n");
		
	}

	public Item[] getContainer() {
		return container;
	}

	public void setContainer(Item[] container) {
		this.container = container;
	}

	public int[][] getTab() {
		return tab;
	}

	public void setTab(int[][] tab) {
		this.tab = tab;
	}

}
