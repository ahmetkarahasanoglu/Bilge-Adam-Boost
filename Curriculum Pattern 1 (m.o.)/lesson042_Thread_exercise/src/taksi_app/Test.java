package taksi_app;

public class Test {

	public static void main(String[] args) {
		
		Durak durak = new Durak();
		
		durak.getTaksiler().forEach(x -> new Thread(x).start());
		
	}//MAIN ENDS HERE -----

}//CLASS ENDS HERE -----
