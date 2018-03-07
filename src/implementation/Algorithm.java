package implementation;

import java.io.IOException;

public interface Algorithm {
	public void solveProblem();
	public void load(Item[] container) throws NumberFormatException, IOException;
	public void writeSolution();
}
