package taksi_app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Durak {
	
	private List<Taksi> taksiler;
	static private Queue<Long> musteriIDleriKuyrugu;
	
	// CONSTRUCTOR:
	public Durak() {
		this.taksiler = new ArrayList<>();
		musteriIDleriKuyrugu = new LinkedList<>();
		musteriOlustur();
		taksiOlustur();
	}

	// GETTERS:
	public List<Taksi> getTaksiler() {
		return taksiler;
	}

	public static Queue<Long> getMusteriIDleriKuyrugu() {
		return musteriIDleriKuyrugu;
	}
	
	private void musteriOlustur() {
		for(long i=1; i<=100; i++) {
			musteriIDleriKuyrugu.add(i);
		}
	}
	
	private void taksiOlustur() {
		for(int i=1; i<=10; i++) {
			this.taksiler.add(new Taksi());
		}
	}
	
}
