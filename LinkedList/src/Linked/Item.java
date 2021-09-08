package Linked;

public class Item implements KeyValue{

	private int key;
	private int val;
	
	//constructors  if there is no k and v then key value = -1
	Item(int k, int v){
		key= k;
		val = v;
	}
	Item(int k){
		key = k;
	}
	Item(){
		key=-1;
	}
	
	@Override
	public int GetKey() {
		return key;
	}

	@Override
	public int GetValue() {
		return val;
	}
	
}
