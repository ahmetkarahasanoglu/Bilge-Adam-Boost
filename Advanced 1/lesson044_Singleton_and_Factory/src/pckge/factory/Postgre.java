package pckge.factory;
/**
 * Bu sınıfa public yazmadık. Sadece bulunduğu paket içerisinden
 * erişilebilir. Başka paketten erişilemez.
 * Bu sınıftan nesne üretmek de 'DatabaseFactory' sınıfı
 * üzerinden yapılacak. 'test' paketinde bunu uygulayacaz.
 */
class Postgre implements ILogger {

	public void log(String ex) {
		System.out.println(ex + "-->postgreye loglandı");
	}

}