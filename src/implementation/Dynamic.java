package implementation;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Dynamic implements Algorithm {
	private Item[] container;
	
	public Dynamic() throws NumberFormatException, IOException {
		load(this.container);
		
	}

	@Override
	public void solveProblem() {
		
		
	}

	@Override
	public void load(Item[] container) throws NumberFormatException, IOException {
		String file = "data.txt";
		BufferedInputStream data = new BufferedInputStream(new FileInputStream(file));
		Scanner in = new Scanner(data);
		Main.n = in.nextInt();
		Main.b = in.nextInt();
		container = new Item[Main.n];
		for(int i=0;i<Main.n;i++) {
			container[i] = new Item(i+1,in.nextInt(),in.nextInt());
		}
		for(int i=0;i<Main.n;i++) {
			System.out.println(container[i]);
		}
	}

	@Override
	public void writeSolution() {
		
		
	}

	public Item[] getContainer() {
		return container;
	}

	public void setContainer(Item[] container) {
		this.container = container;
	}

}
