-- Double dash means comment line.
-- Bir komutu mouse ile karartıp 'run' edebilirsin.

------ SQL Komutları ------
---- Create:
-- herhangi veri tabanı bileşenini oluşturmak 
-- için kullanılır
----create table -> tablo oluşturmak için
--kullanılır.
---- serial -> otomatik sayı tip Integer(32 bit)
---- bigserial -> otomatik sayıt tip long (64 bit)
---- primary key -> bir tablo içinde bir değeri
-- tanımlayan, aramalarda O(1) (karmaşıklık)
-- da bulunmasını
-- sağlayan benzersiz kayıt anahtarı.
-- id(Identity) -> data kimliği. Benzersiz değer
create table tblmusteri(
	id bigserial primary key, -- bu kimliklendirme otomatik olmaktadır.
	ad varchar(100),
	soyad varchar(100),
	email varchar(255),
	telefon varchar(20),
	yas int,
	cinsiyet varchar(20),
	createdate bigint default EXTRACT(epoch from now()) * 1000,
	updatedate bigint default EXTRACT(epoch from now()) * 1000,
	state int default 1 -- 0 -> silinmiş, 1 -> aktif
)

create table tbladres(
	id bigserial primary key,
	musteriid bigint references tblmusteri(id), -- Foreign Key (F.K.) - ilişkilendirdik başka tabloyla
	il varchar(50),
	ilce varchar(50),
	mahalle varchar(50),
	adres varchar(150),
	createdate bigint default EXTRACT(epoch from now()) * 1000,
	updatedate bigint default EXTRACT(epoch from now()) * 1000,
	state int default 1 -- 0 -> silinmiş, 1 -> aktif
)

create table tblborc(
	id bigserial primary key,
	musteriid bigint references tblmusteri(id),
	borc double precision default 0,
	createdate bigint default EXTRACT(epoch from now()) * 1000,
	updatedate bigint default EXTRACT(epoch from now()) * 1000,
	state int default 1 -- 0 -> silinmiş, 1 -> aktif
)

create table tblsatis(
	id bigserial primary key,
	musteriid bigint references tblmusteri(id),
	geneltoplamfiyat double precision,
	odenen double precision,
	kalan double precision,
	satistarihi bigint,
	createdate bigint default EXTRACT(epoch from now()) * 1000,
	updatedate bigint default EXTRACT(epoch from now()) * 1000,
	state int default 1 -- 0 -> silinmiş, 1 -> aktif
)

create table tblodemeturu(
	id bigserial primary key,
	tur	varchar(100),
	createdate bigint default EXTRACT(epoch from now()) * 1000,
	updatedate bigint default EXTRACT(epoch from now()) * 1000,
	state int default 1 -- 0 -> silinmiş, 1 -> aktif
)

create table tblodeme(
	id bigserial primary key,
	musteriid bigint references tblmusteri(id),
	satisid bigint references tblsatis(id),
	odemeturuid bigint references tblodemeturu(id),
	tutar double precision,
	tarih bigint,
	aciklama varchar(500),
	createdate bigint default EXTRACT(epoch from now()) * 1000,
	updatedate bigint default EXTRACT(epoch from now()) * 1000,
	state int default 1 -- 0 -> silinmiş, 1 -> aktif
)

create table tblurun(
	id bigserial primary key,
	ad varchar(200),
	marka varchar(200),
	model varchar(200),
	fiyat double precision,
	stok int,
	kdv int,
	iskonto int,
	createdate bigint default EXTRACT(epoch from now()) * 1000,
	updatedate bigint default EXTRACT(epoch from now()) * 1000,
	state int default 1 -- 0 -> silinmiş, 1 -> aktif
)

create table tblsepet(
	id bigserial primary key,
	urunid bigint references tblurun(id),
	satisid bigint references tblsatis(id),
	fiyat double precision,
	adet int,
	toplamfiyat double precision,
	createdate bigint default EXTRACT(epoch from now()) * 1000,
	updatedate bigint default EXTRACT(epoch from now()) * 1000,
	state int default 1 -- 0 -> silinmiş, 1 -> aktif
)
----------------------------------------------------------------
----------------------------------------------------------------

--- CRUD
--- Create
--- Read
--- Update
--- Delete
-------
--- INSERT INTO -> var olan bir tabloya kayıt eklemek
--- 1- ekleme yapacağınız tablo adını doğru girmelisiniz.
--- 2- tablo alanlarını istediğiniz sırada yazabilirsiniz.
--- 3- istediğiniz alanları yazabilirsiniz.
--- 4- bu alanlara atanılacak(eklenecek) değerleri(values) yazıyorsunuz.
--- 5- String tip alanlar ''(tek tırnak içinde) yazılır.
--- 6- Time, TimeStamp alanlar ''
--- 7- Int, Long alanlar sayısal ifade edilir.
insert into tblmusteri(ad, soyad, email, yas)
	values('Ali', 'HOCA', 'ali@gmail.com', 34)
--- 8- Eğer aynı anda birden fazla kayıt eklemek istiyorsanız
---	   virgülle ayırarak kayıtları girebilirsiniz.
insert into tblmusteri(ad, soyad, cinsiyet, yas, email, telefon)
	values ('Bahar', 'TEKİN', 'K', 27, 'bahar@gmail.com', '0 555 333 4455'),
	('Deniz', 'BAŞ', 'E', 54, 'deniz@gmail.com', '0 555 467 3412'),
	('Esma', 'KALIN', 'K', 43, 'esma@gmail.com', '0 555 858 4343')

--- UPDATE -> tabloda güncelleme yapmak	
--- 1- güncelleme yapılacak tablo seçilir.
--- 2- güncelleme istenilen alan ya da alanlar yazılır.
--- 3- birden fazla alan virgül ile ayrılarak yazılır.
--- 4- güncelleme yapılacak kayıt seçilmelidir.
--- DİKKAT!!! Güncelleme ciddi bir iştir. Eğer güncellenecek kayıt 
--- özellikle belirtilmez ise ('where' ile), tüm kayıtlarınız override
--- edilerek güncellenir. Veri kaybı olur.
update tblmusteri set telefon ='0 555 444 2211' where id= 1

update tblmusteri set cinsiyet='E', state=0 where id=2

--- DELETE -> var olan bir kaydı silmek.
--- 1- silinecek kaydın bulunduğu tablo adı yazılır.
--- 2- silinecek kaydın id'si belirtilir.
--- DİKKAT!!! eğer silinecek kayıt id'si belirtilmez ise tüm kayıtlar silinir.
delete from tblmusteri where id=5

-----------------------------------------------------------------
------ DB SORGU ÇALIŞTIRMA (ÖNEMLİ !!!) -------------------------
---- SELECT -> kendisine iletilen datayı tablo olarak dönmeye meyillidir.
select 'selam arkadaşlar'
select 45 + 32
select Now() -- veritabanının üzerinde çalıştığı sunucunun tarihini verir
------------
---- AS -> takma ad
select 'işlem tmm' as RESULT -- kolon başlığını 'result' olarak yazar
select 6+9 as toplam
-------------
---- Tablolarda select komutunun çalıştırılması
---- * her şey (tüm kolonlar) demektir
select * from tblmusteri
---- tablodaki alanları tek tek seçebiliriz:
select ad,soyad,telefon from tblmusteri
select ad as musteri_adi, soyad as musteri_soyadi from tblmusteri

select * from
(select ad as musteri_adi, soyad as musteri_soyadi from tblmusteri) as mst -- mst bir değişken; parantez içindeki şeyi temsil ediyo.
-----------------------------------------------------------------
---- SORGULARDA KISITLAMALARA GİTMEK
select * from tblmusteri
select * from tblmusteri where id<65
select * from tblmusteri where id>210 and id<219
select * from tblmusteri where id=345 or id=877 -- brings two rows
select * from tblmusteri where yas=70
select * from tblmusteri where yas>65

---- ORDER BY -> SIRALAMA YAPAR
----      	 	 biz belirtmedikçe sıralama yönü A..Z, 0..9 şeklindedir.
select * from tblmusteri order by ad
select * from tblmusteri order by ad asc
select * from tblmusteri order by ad desc
-----------------------------------------------------------------

---- LIMIT [miktar] -> postgresql için
---- TOP -> pl/sql - MsSQL 
---- örn: 18 yaşında olan ilk 3 müşterinin ad ve soyad bilgisi:
select * from tblmusteri where yas=18 ORDER BY ad LIMIT 3

-----------------------------------------------------------------
---- Soru: 50 yaşından büyük ve erkek olanların ilk 5'ini listeleyin.
select * from tblmusteri 
where yas>50 and cinsiyet='Male' 
LIMIT 5
-----------------------------------------------------------------

select * from tblmusteri where id>500 and id<764
-- peki şunu nasıl getiririz: id: 4,24,345,32,23,24,442,2,23,78,98,789,890,990
-- IN([Array Values])
select * from tblmusteri where id IN(4,24,345,32,23,24,442,2,23,78,98,789,890,990)
--  '--> means: where id equals these (the array) -> bring them all
-----------------------------------------------------------------

---- LIKE '[Aranan ifade]'
select * from tblmusteri where ad like 'Riley'
select * from tblmusteri where ad = 'Riley'
---- [ % ] -> aranan ifadelerde kelimenin tamamını yazmadan kalan 
----		  kısımlarını ifade eden joker karakter kullanılabilir.
select * from tblmusteri where ad like 'Ri%' --> 'Ri' ile başlayanları getirir.
select * from tblmusteri where ad like '%ley' --> 'ley' ile bitenler
select * from tblmusteri where ad like '%ile%' --> içerisinde 'ile' geçenler
---- [ _ ] -> sadece bir karakter yerine geçen joker karakter.
select * from tblmusteri where ad like '_a%' --> ikinci harfi a olanları getir.
select * from tblmusteri where ad like '_a_a%' --> ikinci ve dördüncü karakteri 'a' olan, devamında herhangi bir şey olan isimleri getir.
select * from tblmusteri where ad like '_a_a' -->ikinci ve dördüncü karakteri 'a' olan 4 harfli isimleri getir.
-----------------------------------------------------------------

-- Soru: soyadında 'ld' geçen kadınların listesini bulunuz:
select * from tblmusteri where cinsiyet='Female' and soyad like '%ld%'

-- Soru: borcu 100.000 üzerinde olan müşterilerin id'sini bul
select musteriid from tblborc where borc>100000 --> sadece 'musteriid' kolonunu getirir

-- BİR TABLODAKİ VERİYİ KULLANARAK BAŞKA TABLODAN VERİ ÇEKME:
-- Burda tblborc tablosunu kullanarak tblmusteri'den veri çekecez.
-- Soru: borcu 1.000.000'un altında olan müşterilerin ad ve soyadlarını getir:
-- Not: select sonucunda tek bir kayıt geliyor ise 'in' içinde liste
--		olarak kullanılabilir. Dikkat !!!: tekli değil de çoklu (birden
--		fazla kolon) geliyor ise bu komut çalışmaz, kafası karışır - 
--		o yüzden 'select *' değil de 'select musteriid' şeklinde
--		kullancaz:
select * from tblmusteri where id in(
select musteriid from tblborc where borc<1000000
)
-----------------------------------------------------------------

-- BETWEEN:
-- [Alan Adı] BETWEEN [Değer] and [Değer]
-- 'and' 'or' yerine belli aralıkları filtrelemek için kullandığımız komut
-- Not: Tarihlerle çalışırken şu şekilde yapıyoruz:
-- select * from musteri where tarih between '16-01-2023' and '18-01-2023'
select * from tblmusteri where id>100 and id<120
select * from tblmusteri where id BETWEEN 100 and 120
-----------------------------------------------------------------

-- NULL Kontrolü Yapmak:
-- NULL, NOT NULL, IS NOT NULL
-- Tablolarda bazen girilmeyen bilgilerin olduğu kayıtlar vardır.
select * from tblurun where marka is null
select * from tblurun where marka is not null

update tblurun set marka = 'A Marka' where id in (5,54,6,99,14,120,25)
-----------------------------------------------------------------

-- COALESCE: null olan alanlarda bizim belirlediğimiz başka bir değer
--	  		 gösterir.
--			 Veritabanında güncelleme yapmaz, sadece gösterimde etkisi
--			 vardır.
--			 Sadece postgreSql'de kullanılır.
--			 Sql genel kullanımı: ifNull şeklindedir.
--			 Ms-SQL'de ise isNull şeklindedir.
select id, ad, coalesce(marka,'BOŞ') as marka, coalesce(stok, 0) as stok from tblurun

-----------------------------------------------------------------
-- COUNT -> belirttiğiniz sütundaki datanın adedini verir (satır sayısı)
select count(*) from tblsatis where kalan>5000 --> 'kalan' odemesi 5000'den fazla olan kaç kayıt olduğunu getirir.
-- Belli bir sütunu saydırmak istiyorsanız sütun adını yazarsınız.
-- Ancak eğer içinde null kayıtlar var ise bunları saymayacaktır.
select count(musteriid) from tblsatis --> 200 sonucunu verdi.
-----------------------------------------------------------------

-- MIN - MAX: belirtilen bir sütundaki min ve max değerleri döner.
select MIN(odenen) from tblsatis 
select MAX(odenen) from tblsatis 
-- en az ödeme yapan kişi kimdir?:
select * from tblmusteri where id = (
	select musteriid from tblsatis where odenen = (
		select MIN(odenen) from tblsatis
	)
)
-----------------------------------------------------------------

-- AVG: ortalama bulmak için kullanılır.
select AVG(adet) from tblsepet where urunid=55
-----------------------------------------------------------------

-- SUM, istenilen sütundaki kayıtları toplar.
-- Örn: bu zamana kadar kasamıza giren toplam nakit para ne kadardır?
select SUM(toplamfiyat) from tblsepet
select * from tblmusteri
-----------------------------------------------------------------

-- CONCAT(a,b,...n) -> birleştirmek için kullanılır:
select concat(ad, ' ', soyad) as ad_soyad from tblmusteri

-- LENGTH([kolon adı]):  kolon adı verilen ifadenin uzunluğunu getirir
select length(ad), ad from tblmusteri order by length(ad)
select length(ad), ad from tblmusteri order by length(ad), ad --> Önce adın uzunluğuna göre sırala, uzunlukları aynı olanları ada göre sırala (a'dan z'ye)
select length(ad), ad from tblmusteri order by length(ad) desc, ad
-----------------------------------------------------------------

-- TRIM: ifadenin başındaki ve sonundaki boşlukları alır.
select trim(ad from) tblmusteri
-- UPPER: kolon adı verilen dataları büyük harfe çevirir:
select upper(ad) from tblmusteri
-- REVERSE: kelimeyi tersten yazdırır
select reverse(ad) from tblmusteri
-----------------------------------------------------------------

-- DISTINCT: Benzersiz olan kayıtları gösterir.
-- Örn: Şimdiye kadar kaç müşteriye satış yaptık?
select count(distinct musteriid) from tblsatis 
-- or, another way without using distinct:
select count(*) from tblmusteri where id in (select musteriid from tblsatis)
-----------------------------------------------------------------

-- GROUP BY, HAVING: Gruplanan alanda, aynı olan verileri tek satıra
--					 getirerek (gruplayarak), diğer bir sonuç sütununda da bu
--					 satırlara ait, diğer belirtilen alanın (örneğin
--					 fiyat) SUM, COUNT, AVG, MIN, MAX gibi fonksiyonlarla
--					 sonucu gösterir.
--					 'Having' yardımcı komuttur, 'where' gibi kullanılır.
-- Örn: satılan ürünlerin adetleri nelerdir?
select urunid, SUM(adet), SUM(toplamfiyat) from tblsepet group by urunid
select urunid, AVG(adet) from tblsepet group by urunid
select urunid, MAX(adet) from tblsepet group by urunid
select urunid, COUNT(urunid) from tblsepet group by urunid -- ürünün kaç kez sepete eklendiğini gösterir.
-- Satış adedi 100'ün üzerinde olan ürünlerin adetleri listesini bulunuz:
select urunid, SUM(adet) as satis_adedi 
from tblsepet
group by urunid 
having sum(adet)>400 and urunid>50
order by SUM(adet) desc

-----------------------------------------------------------------
----------- UYGULAMA İÇİN GEREKLİ SORGULAR ----------------------
-----------------------------------------------------------------
-- Soru 1) daha önce hiç satış yapılmamış müşterimiz var mı?
select * from tblmusteri where id NOT in (select musteriid from tblsatis)
select * from tblmusteri
-- Soru 2) borcu en çok olan müşterinin en fazla satın aldığı ürün nedir?
select * from tblsepet where satisid in(
	select id from tblsatis where musteriid = (
	select musteriid from tblborc where musteriid in(
	select distinct(musteriid) from tblsatis)
order by borc desc limit 1
)
)
group by urunid
order by sum(adet) desc
limit 1
-- Soru 3) Daha önce hiç satılmamış ürünlerin listesini bulunuz.
select * from tblurun where id NOT in(
	select urunid from tblsepet 
)
-- Soru 4) En çok satışı yapılan ilk 3 ürünü hangi müşteriler satın almıştır?
SELECT * 
FROM tblmusteri 
WHERE id IN (
    SELECT musteriid 
    FROM tblsatis 
    WHERE id IN (
        SELECT satisid 
        FROM tblsepet 
        WHERE urunid IN (
            SELECT urunid 
            FROM tblsepet 
            GROUP BY urunid 
            ORDER BY SUM(adet) DESC 
            LIMIT 3
        )
    )
)

-----------------------------------------------------------------
-----------------------------------------------------------------
------ JOIN (TABLOLARI BİRBİRİNE BAĞLAMAK) ----------------------
-----------------------------------------------------------------
-- [INNER] [LEFT - RIGHT - CROSS - NATURAL]  [OUTER] [JOIN]
-- inner join -> iki tablonun kesişim kümesi
-- '--> 'join' and 'inner join' do the same thing

select * from tblmusteri --> 1000 kayıt var.
select * from tblsatis --> 200 kayıt var.

select * from tblmusteri
inner join tblsatis on tblmusteri.id=tblsatis.musteriid -- tblmusteri ve tblsatis tablolarını birleştiriyoruz. tblmusteri.id ile tblsatis.musteriid alanları üzerinden.
-- '--> 200 kayıt geldi. Kesişmeyen müşteri kayıtları (800 tane) dışarda kaldı. Sadece kesişim kümesi geldi.
----

select * from tblurun --> 150 kayıt
select * from tblsepet --> 3.000 kayıt
select * from tblsatis --> 200 kayıt
select * from tblmusteri --> 1000 kayıt
-- Ürün, Sepet, Satış, Müşteri Tablolarını birleştirelim (3'ünün kesişim kümesi):
select * from tblurun
inner join tblsepet on tblsepet.urunid=tblurun.id
inner join tblsatis on tblsatis.id = tblsepet.satisid
inner join tblmusteri on tblmusteri.id = tblsatis.musteriid
-- '-->3.000 kayıt getirdi bu birleştirme.

-- istediğimiz alanları ilk satırımızda yazıp getirebiliriz (birleştirilmiş tablo):
select tblmusteri.ad, tblurun.ad, tblsepet.adet from tblurun
inner join tblsepet on tblsepet.urunid=tblurun.id
inner join tblsatis on tblsatis.id = tblsepet.satisid
inner join tblmusteri on tblmusteri.id = tblsatis.musteriid
-----------------------------------------------------------------

-- Left Join: öncelikli olarak yazılan, yani join ifadesinin solunda
-- 			  kalan tabloyu önceleyerek listeleme yapar. Dolayısıyla
--			  soldaki kümenin alanının içinde kalan kısmı gösterir
--			  (buna iki kümenin kesişim kısmı da dahildir).
--			  Eğer sağdaki kümede, aynı foreign key değerinde birden
--			  fazla kayıt varsa, soldaki kümenin satırını tekrar 
--			  ederek gösterir.
--			  Eğer sağ kümede, sol kümenin foreign key değerine
--			  tekabül eden kayıt yoksa, sağ kümenin alanlarını
--			  'null' olarak gösterir.
select * from tblmusteri --> 1.000 kayıt
select * from tblsatis --> 200 kayıt

select * from tblmusteri
left join tblsatis ON tblsatis.musteriid = tblmusteri.id
-- '--> 1021 kayıt getirdi.

-- *** Right Join: join'in sağında kalan tabloyu önceleyerek gösterir.
--				   Sağdaki kümenin alanının içinde kalan kısmı gösterir.
select * from tblmusteri
right join tblsatis ON tblsatis.musteriid = tblmusteri.id -- 200 kayıt getirdi. Bir satış birden fazla müşteriye yapılamadığı için bu tabloda tekrar eden satır olmaz.

-- Outer: 'left' yerine 'left outer'; 'right' yerine 'right outer' yazsak da bir şey değişmez. Outer'ın burda bir işlevi yok.

-- *** Natural Join -> iki tabloda foreign key ile aynı alan adı 
-- 					   üzerinden bağlanılan tablolarda kullanılır.

-----------------------------------------------------------------
-------- PROJE İÇİN GEREKLİ SORULAR (RAPOR) ---------------------
-----------------------------------------------------------------
-- 1) Borcu olan müşterilerin listesi.
select * from tblmusteri
join tblborc on tblborc.musteriid = tblmusteri.id
where tblborc.borc>0 --> borcunu 0'layanları göstermesin.
-- or, we can select some specific columns:
select tblmusteri.id, tblmusteri.ad, tblborc.borc from tblmusteri
join tblborc on tblborc.musteriid = tblmusteri.id
-- using abbreviations:
select m.id, m.ad, m.soyad, m.email, m.telefon, m.state, b.borc
from tblborc as b
inner join tblmusteri as m on m.id = b.musteriid
where b.borc>0

-- *** VIEW ***
-- Hazır sorgu olarak kaydetmek (view). View'ler hazır sorgularımız için kayıt tutar.
create view vwborclumusterilistesi
as select m.id, m.ad, m.soyad, m.email, m.telefon, m.state, b.borc
from tblborc as b
inner join tblmusteri as m on m.id = b.musteriid
where b.borc>0

-- View'i çağırmak:
select * from vwborclumusterilistesi

select * from vwborclumusterilistesi where ad like 'N%' -- adı 'N' ile başlayan müşterilerin borcu

-- 2) Belli bir günde satılan ürünlerin listesi
create view vwsatilanurunlistesi as
select tblurun.ad, tblurun.stok, tblurun.fiyat, tblsatis.createdate 
from tblsatis
join tblsepet on tblsatis.id=tblsepet.satisid
join tblurun on tblsepet.urunid = tblurun.id

select * from vwsatilanurunlistesi
where createdate = 1707681109158

-- 3) Bu ay kredi kartı ile yapılan ödemelerin listesi
create view vwodemeturlerinegoreodemelistesi as
select tblodemeturu.tur, tblodeme.musteriid, tblodeme.tutar
from tblodeme
inner join tblodemeturu on tblodeme.odemeturuid = tblodemeturu.id

select * from vwodemeturlerinegoreodemelistesi
where tur='KREDIKARTI'

select m.id, m.ad, m.soyad, od.tur, od.tutar from tblmusteri as m
inner join vwodemeturlerinegoreodemelistesi as od
ON m.id = od.musteriid

-- 4) Borçlu müşteriler en çok hangi ürünü satın almıştır?
-- my solution:
select tblsepet.urunid, tblurun.ad, sum(adet) as toplam_adet from tblborc
inner join tblmusteri ON tblborc.musteriid = tblmusteri.id
inner join tblsatis ON tblmusteri.id = tblsatis.musteriid
inner join tblsepet ON tblsatis.id = tblsepet.satisid
inner join tblurun ON tblsepet.urunid = tblurun.id
where tblborc.borc>0
group by tblsepet.urunid, tblurun.ad
order by sum(adet) desc

-- hocanın çözümü:
create view vwborclumusterilerinencoksatinaldigiurunlistesi as
select bm.id, bm.ad, bm.soyad, se.urunid, se.adet
from vwborclumusterilistesi as bm
inner join tblsatis as sa ON sa.musteriid = bm.id
inner join tblsepet as se ON se.satisid = sa.id

select urunid, sum(adet) as toplam_adet
from vwborclumusterilerinencoksatinaldigiurunlistesi
group by urunid
order by toplam_adet desc
limit 5

-----------------------------------------------------------------
---------- YAZILIM KODLARI YAZMAK - POSTGRE SQL -----------------
-----------------------------------------------------------------
do$$
declare
---  değişken tanımlamak için kullanılan alanımız.
begin
--- gövde, kodların yazıldığı alan
end; $$

---------
---------
-- for loop
do $$
declare
	counter INT;
begin
	for counter in 1..5 loop
		raise notice 'selam......: %', counter;
	end loop;
	-- '--> for(int counter=1; counter<5; counter++) {
	-- 			System.out.println("selam.....: " + counter);
	--		}

begin
	for counter in 1..50 loop
		insert into tbladres(musteriid, il, ilce, mahalle)
		values(counter, 'Ankara', 'Merkez', 'Kızılay');
	end loop;
end;
end $$

select * from tbladres

---------
---------
do $$
declare
	sayac integer; -- değişken tanımlama: [name] [datatype]
	sayac2 integer:= 2; -- assigning initial value to variable
begin
	sayac := 0;
	while sayac<10 loop
		raise notice 'döngü devam ediyorrrr';
		sayac2:= sayac2 + sayac;
		sayac := sayac + 1;
	end loop;
	raise notice 'sayac2 son deger....: %', sayac2;
end;$$

---------
---------
-- IF
do $$
declare
	sayi1 integer := 3;
	sayi2 integer := 4;
begin
	if sayi1 > sayi2 then
		raise notice '1. sayı büyüktür';
	elseif sayi2 > sayi1 then
		raise notice '2. sayı büyüktür';
	else
		raise notice 'iki sayı eşittir.';
	end if;
end;
$$

---------------------------------------------------------------
--------- PROCEDURE --> void metot'lar gibi çalışır.
---------------------------------------------------------------
create procedure ekranayazdir()
language plpgsql
as
$$
begin
	raise notice 'Ekran çıktısı';
end;
$$
--- procedure'ler 'call' ile çağrım yapılır.
select * from tbladres
call ekranayazdir();
---------

create procedure dongukadaryazdir(adet integer)
language plpgsql
as
$$
declare
	sayac integer := 0;
begin
	while sayac<adet loop -- 'adet' değişkenini dışardan almıştık (yukarda 'create procedure' satırında yapmıştık)
		raise notice 'döngüüüüüü';
		sayac := sayac + 1;
	end loop;
end; $$

call dongukadaryazdir(10);



create procedure editnulladres(id integer)
language plpgsql
as
$$
begin
	update tbladres set il='Ankara', ilce='Merkez', mahalle='Kızılay'
	where id = id;
end;
$$
select * from tbladres
call editnulladres(1)
---------------------------------------------------------------
---------------------------------------------------------------

-- FUNCTION -> işlem sonucunda bir şey return edebilirsiniz.
--			   Çağırma işlemini 'select' ile yapabilirsiniz.
------

-- ödeme türüne göre yapılan ödeme ortalamasını bulan fonksiyonu yazalım.
select * from tblodeme
select * from tblodemeturu

create function getodemeortalamasi(odemeturuadi varchar)
returns double precision 
language plpgsql
as
$$
declare
	odemeturid bigint := 0;
	odemesayisi integer := 0;
	toplamtutar double precision := 0;
	ortalama double precision := 0;
begin
	select id into odemeturid from tblodemeturu where tur = odemeturuadi;
	select count(tutar) into odemesayisi from tblodeme where odemeturuid=odemeturid;
	--raise notice 'ödeme sayisi....: %', odemesayisi;
	select sum(tutar) into toplamtutar from tblodeme where odemeturuid=odemeturid;
	raise notice 'ödeme sayisi....: %', toplamtutar;
	--ortalama := toplamtutar / odemesayisi;
	return ortalama;
end;
$$

select count(tutar) from tblodeme where odemeturuid=2;
select getodemeortalamasi('CEK');
-- '--> burası biraz manüel oldu, hesap makinesiyle hesaplayıp sağlamasını yapmaya çalıştık falan. (üst iki satır)
	
