public class Printer {
	
	private char maker;
	private String printerType;
	private String color;
	private int model;
	private int price;
	
	public Printer (char ma, int m, String c, String t, int p) {
		setMaker(ma);
		setPrinterType(t);
		setColor(c);
		setModel(m);
		setPrice(p);
	}

	public char getMaker(){
		return maker;
	}

	public void setMaker(char m){
		this.maker = m;
	}
	
	public String getPrinterType() {
		return printerType;
	}

	public void setPrinterType(String printerType) {
		this.printerType = printerType;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}

	public int getPrice(){
		return price;
	}

	public void setPrice(int p){
		this.price = p;
	}
	
}
