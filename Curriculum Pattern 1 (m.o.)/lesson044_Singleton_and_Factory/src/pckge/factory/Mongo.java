package pckge.factory;
/**
 * Bu sınıfa public yazmadık. Sadece bulunduğu paket içerisinden
 * erişilebilir. Başka paketten erişilemez.
 * Bu sınıftan nesne üretmek de 'DatabaseFactory' sınıfı
 * üzerinden yapılacak. 'test' paketinde bunu uygulayacaz.
 */
class Mongo implements ILogger {

	public void log(String ex) {

		System.out.println(ex + "-->mongoyo loglandı");
	}

}
