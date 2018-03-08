package implementation;

import java.io.IOException;

public interface Algorithm {
	public void solveProblem(Item[] container, int[][] tab);
	public void load(Item[] container) throws NumberFormatException, IOException;
	public void writeSolution(int[][] tab, Item[] container, Item[] knapsack);
}
