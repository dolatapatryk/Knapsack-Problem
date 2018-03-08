package implementation;

import java.util.Comparator;

public class Compare implements Comparator<Item> {

	@Override
	public int compare(Item arg0, Item arg1) {
		if(arg1==null) return -1;
		if(arg0.getRatio()>arg1.getRatio()) return 1;
		else if(arg0.getRatio()<arg1.getRatio()) return -1;
		else return 0;
	}

}
