package implementation;

public class Item {
	int key;
	int value;
	int weight;
	double ratio;
	
	public Item(int key, int value, int weight) {
		this.key = key;
		this.value = value;
		this.weight = weight;
		this.ratio = (double)this.value/this.weight;
	}
	
	public String toString() {
		return key+". item: value: "+value+" weight: "+weight+" ratio: "+ratio;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}
}
