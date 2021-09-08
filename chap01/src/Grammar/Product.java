package Grammar;

class Tv{
	private String model;
	
	Tv(){
		this.model="d";
	}
}

public class Product<T,M> {
	private T kind;
	private M model;
	
	public T getKind() {
		return this.kind;
	}
	public M getModel() {
		return this.model;
	}
	
	public void setKind(T kind) {
		this.kind=kind;
	}
	public void setModel(M model) {
		this.model=model;
	}
	
	public static void main(String[] args) {
		Product<Tv, String> product1 = new Product<Tv, String>();
		product1.setKind(new Tv());
		product1.setModel("½º¸¶Æ®Tv");
		Tv tv = product1.getKind();
		String tvModel = product1.getModel();
		
		
	}
}

