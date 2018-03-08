package implementation;

import java.io.IOException;

public interface Algorithm {
	public int[][] solveProblem(Item[] container, int[][] tab);
	public Item[] load(Item[] container) throws NumberFormatException, IOException;
	public void writeSolution(int[][] tab, Item[] container, Item[] knapsack);
}
