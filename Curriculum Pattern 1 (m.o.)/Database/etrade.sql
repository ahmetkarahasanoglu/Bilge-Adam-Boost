-- !!!! THERE IS NO DATA IN THIS DATABASE. SO, THESE CODES WON'T WORK.

select * from address where cityid in (select id from cities where city='ANKARA');
select * from address where cityid in (select id from cities where city like 'A%');

-- users tablosunda ismi n ile başlayanlar ve cinsiyeti kadın olanları getiren sorgu
select * from users where (namesurname like 'n%' or namesurname lkie 'N%') and gender = 'K';
select * from users where namesurname ilike 'n%' and gender 'K'; -- ilike: like anahtar kelimesinin equalsIgnoreCase'li olarak kullanımıdır.

-- users tablosunda name surname içinde 'az' geçen users'ları döndüren sorgu
select * from users where namesurname ilike '%az%';

-- namesurname'i 'a' ile başlayanların siparişlerini(orders) getiren sorgu
select * from orders where userid in (
	select id from users where namesurname ilike 'a%'
)
--------------------------------------------------------------------

-- Soru: id'si 2 ile 12 arasındaki şehirlere ait olan towns'ları getiren sorguyu yazınız.
select towns from towns where cityid BETWEEN 2 and 12;
-- Soru: id'si 2 ile 12 arasındaki şehirlere ait olan towns'ların şehir isimlerini getiren sorguyu yazınız.
select * from cities where id in (select cityid from towns where cityid BETWEEN  2 and 12);
-- cities tablosunda 'ANKARA' ismini küçültelim 'ankara' ile güncelleyelim.
update cities set city='ankara' where city='ANKARA'
update cities set city=(select lower(city) from cities where city='ANKARA') where city='ANKARA'
-- payments tablosunda paymenttotal 2000'den büyük olanlara 200 tl indirim yapalım, bunu da tabloda güncelleyelim
update payments set paymenttotal=(paymenttotal-200) where paymenttotal>2000

--------------------------------------------------------------------
--------------------------------------------------------------------
-- LEFT JOIN: Soldaki tabloyu tamamen alır. Sağdaki tabloda eşleşen
-- 			  yerleri getirir, eşleşmeyen yerleri de 'null' gösterir
--			  sağdaki tabloda.
select * from towns 
left join cities ON towns.cityid=cities.id

-- FULL JOIN: 'left join' ve 'right join'i birlikte yapar. İki kümenin
--			  birleşim kümesidir. (Her iki tabloda da null olan
--			  satırlar olabilir.)