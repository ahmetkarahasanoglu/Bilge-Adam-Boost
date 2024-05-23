
-- Çalışanlarda(employees) 'title_of_couresty' alanı 'Dr.' olanların isim ve soy 
-- ismini getirelim; kolon isimleri 'ad' diğeri de 'soyad' olsun
select first_name as ad, last_name as soyad 
from employees
where title_of_courtesy='Dr.'

select * from employees

-- Territories sayısını bulalım
select count(*) from territories

-- Çalışan sayısını bulalım
select count(*) from employees

-- Çalışan erkek sayısı
select count(*) from employees
where title_of_courtesy='Mr.'

-- Çalışan kadın sayısı
select count(*) from employees
where title_of_courtesy='Mrs.' or title_of_courtesy='Ms.' -- or:
-- or, by using 'in':
select count(*) from employees
where title_of_courtesy in ('Mrs.', 'Ms.')

-- 'Region'ı 'Eastern' olan territories'lerin sayisini bulunuz:
select count(*) from territories where region_id=(
	select region_id from region where region_description='Eastern'
)
   -- or, by using 'inner join':
select count(*) from territories 
inner join region on territories.region_id=region.region_id
where region.region_description='Eastern'

-- Çalışanların doğum tarihi 1960-05-05'ten büyük olanları bulunuz
select * from employees where birth_date>'1960-05-05'

-- Çalışanların yaş ortalamasını bulunuz.
SELECT AVG(EXTRACT(YEAR FROM age(now(), birth_date))) AS average_age
FROM employees;

SELECT AVG(now()::date - birth_date)/365 AS average_age 
FROM employees 

-- Çalışanların en yaşlı ve en genç olanını bulalım:
select * from employees
order by (EXTRACT(YEAR FROM age(now(), birth_date))) ASC
LIMIT 1

select * from employees
order by (EXTRACT(YEAR FROM age(now(), birth_date))) DESC
LIMIT 1

   -- or,
select (now()::date-birth_date)/365 as "en yasli" from employees 
order by employees.birth_date asc limit 1

-- Employees tablosunda kaç farklı title-of-courtesy olduğunu bulunuz.
select count(distinct title_of_courtesy) from employees
-- Employees tablosunda, çalışanlar kaç farklı şehirde çalışıyorlar?
select count(distinct city) from employees

-- Çalışanların soy isim uzunluğu 6'dan küçük olanların isimlerini küçük, soy isimlerini büyük ve ilk 3 harfini yazdıran sorgu.
SELECT LOWER(first_name) AS first_name_lower, 
       UPPER(SUBSTRING(last_name, 1, 3)) AS last_name_upper
FROM employees
WHERE LENGTH(last_name) < 6;

select left(last_name, 3) from employees

-- Products tablosundan kdv dahil ve kdv hariç fiyatları ile beraber ürünlerin
--   isimlerini getiriniz; kolon isimleri kdv dahil ve kdv hariç olsun(%18)
select product_name, unit_price as "kdv hariç fiyat", unit_price*118/100 as "kdv dahil fiyat" 
from products
-- kdv(%18) miktarı 10 liranın altında olanları getirin
select *, unit_price*18/100 as "kdv tutari" from products
where unit_price*18/100 < 10

-- Soru: Products tablosunda en pahalı ürünün adını yazdırınız.
   -- 1.yöntem:
select product_id, product_name, unit_price from products
where unit_price=(
	select max(unit_price) from products
)
   -- 2.yöntem:
select product_id, product_name, unit_price from products
order by unit_price desc
limit 1
   -- 3.yöntem:
SELECT product_name, MAX(unit_price) AS max_price
FROM products
GROUP BY product_name
ORDER BY max_price DESC
LIMIT 1;

-- Soru: Aynı kategorideki ürünlerin toplam fiyatlarını getirelim:
select category_id, sum(unit_price) from products -- select [the grouped field, and a function]
group by category_id

-- Soru: Ülkelere göre müşteri sayılarını veren sorgu.
select country, count(*)
from customers
group by country

-- Soru: Her kategoride kaç ürün vardır?
select category_id, count(*)
from products
group by category_id

-- Soru: Her bir tarihte ne kadar sipariş yapılmış (orders tablosundan)?
select order_date, count(*) from orders
group by order_date

select * from orders

-- Soru: Her bir tarihde hangi ülkeden kaç tane sipariş yapılmış(orders tablosundan)?
select order_date, ship_country, count(*) from orders
group by order_date, ship_country
order by order_date

-- Soru: products tablosunda her kategoriden en düşük ve en yüksek unit_price'lara sahip ürünleri getirelim
select category_id, max(unit_price) as most_expensive, min(unit_price) as cheapest 
from products
group by category_id
order by category_id

-- Soru: indirim oranı 0.1'den büyük olanların ürün sayısı toplamını getiriniz (order_details tablosundan)
select * from order_details

select discount, sum(quantity)
from order_details
where discount>0.1
group by discount

select discount, sum(quantity)
from order_details
group by discount
having discount>0.1 -- having: grupladıktan sonra bir koşul koymaya yarar.

-- İndirim oranı 0.1'den büyük olanlardan her bir indirim oranının ürün sayısı toplamı 4350'den büyük olanları getirelim (order_details tablosundan)
select discount, sum(quantity) as total_number_of_products_for_a_discount_rate 
from order_details
where discount>0.1
group by discount having sum(quantity) > 4350
order by discount

   -- 2. yöntem:
select discount, sum(quantity) 
from order_details 
group by discount having discount>0.1 and sum(quantity)>4350

-- Soru: A ile başlayan ülkelerdeki (her bir ülkenin ayrı ayrı) müşteri sayısını getiriniz (customers tablosundan)
select country, count(*) from customers 
where country ilike 'A%'
group by country
   -- 2. yöntem:
select country, count(*) from customers 
group by country having country ilike 'A%'

select * from customers

------------------------------------------------------------------
------------------------------------------------------------------
-- Soru: Hangi tedarikçi hangi ürünleri sağlıyor?
select * from products;
select * from suppliers;

select sup.company_name, pro.product_name from products as pro
inner join suppliers as sup on sup.supplier_id = pro.supplier_id
order by company_name

-- Soru: Beverages kategorisinden kaç farklı ürün var?
select * from products;
select * from categories;

select count(*) from products as pro
inner join categories as cat on cat.category_id=pro.category_id
where cat.category_name='Beverages'

-- Soru: Her kategoride kaçar farklı ürün vardır?
select category_name, count(*) from products as pro
inner join categories as cat on cat.category_id=pro.category_id
group by cat.category_name

-- Soru: Her tedarikçi kaç tane ürün satıyor?
select * from suppliers;
select * from products;

select sup.company_name, sup.contact_name, count(pro.product_name) from products as pro
inner join suppliers as sup on sup.supplier_id=pro.supplier_id
group by sup.company_name, sup.contact_name
order by company_name, contact_name

-- Soru: Bir siparişte toplam kaç adet ürün satılmış ve hangi id'li müşteri almış?
select * from orders;
select * from order_details;

select o_d.order_id, o.customer_id, sum(o_d.quantity) from orders as o
inner join order_details as o_d on o.order_id=o_d.order_id
group by o_d.order_id, o.customer_id
order by customer_id
   -- or, by using 'natural join':
select o_d.order_id, o.customer_id, sum(o_d.quantity) from orders as o
natural join order_details as o_d
group by o_d.order_id, o.customer_id
order by customer_id

-- Soru: Hangi çalışan hangi bölgeden/bölgelerden sorumludur? (firstname lastname territory_description)
select * from employees;
select * from employee_territories; -- 'Many to Many' --> ara tablo tutuluyor bu yüzden (employee_territories), burda tekrar eden kayıtlar tutuluyor
select * from territories;

select e.first_name, e.last_name, t.territory_description from employees as e
inner join employee_territories as e_t on e.employee_id=e_t.employee_id
inner join territories as t on e_t.territory_id=t.territory_id
order by e.first_name, e.last_name
   -- or, by using 'natural join':
select e.first_name, e.last_name, t.territory_description from employees as e
natural join employee_territories as e_t
natural join territories as t
order by e.first_name, e.last_name

-- Her bir çalışan kaç bölgeden sorumludur?
select e.first_name, e.last_name, count(t.territory_description) from employees as e
inner join employee_territories as e_t on e.employee_id=e_t.employee_id
inner join territories as t on e_t.territory_id=t.territory_id
group by  e.first_name, e.last_name
order by e.first_name, e.last_name
-- Her bir çalışanın toplam sattığı ürün adedi (quantity) nedir?
select * from employees;
select * from orders;
select * from order_details;

select e.employee_id, e.first_name, e.last_name, sum(o_d.quantity) as toplam_sattigi_urun_adedi 
from employees as e
inner join orders as o on e.employee_id=o.employee_id
inner join order_details as o_d on o_d.order_id=o.order_id
group by e.employee_id, e.first_name, e.last_name
order by employee_id

-- VIEW Örnek: Product'larla category'leri birleştiren tablonun view'ini yazalım: product_categories_view
create view vwproduct_categories as
select * from products
natural join categories

select * from vwproduct_categories
------------------------------------------------------------------

-- Ürünlere göre tedarikçi view'i oluşturalım: product name, company name, city, country - alanlarını gösterelim.
select * from products;
select * from suppliers;

create view vw_urunlere_gore_tedarikciler as
select pro.product_name, sup.company_name, sup.city, sup.country from products as pro
inner join suppliers as sup on sup.supplier_id=pro.supplier_id

select * from vw_urunlere_gore_tedarikciler

-- Bir ülkede satılan ürün (çeşit) sayısını getiren sorguyu yazalım
select country, count(product_name) 
from vw_urunlere_gore_tedarikciler
group by country

-- Bir view oluşturalım, şu tablolardan: employees - customers - order_details.
-- başka tabloları da kullanmamız lazım, kendiniz bulacaksınız.
-- view'in alanları şunlar olsun: orderid, employeeid, firstname,
-- lastname, customerid, companyname, country, orderdate, productname,
-- quantity, unit price, discount
select * from employees
select * from customers
select * from order_details
select * from orders
select * from products
	

CREATE VIEW vw_employee_customer_order_products AS
SELECT
    o.order_id,
    e.employee_id,
    e.first_name AS employee_firstname,
    e.last_name AS employee_lastname,
    cu.customer_id,
    cu.company_name,
    cu.country,
    o.order_date,
    p.product_name,
    od.quantity,
    od.unit_price,
    od.discount
FROM orders o
JOIN employees e ON o.employee_id = e.employee_id
JOIN customers cu ON o.customer_id = cu.customer_id
JOIN order_details od ON o.order_id = od.order_id
JOIN products p ON od.product_id = p.product_id;

select * from vw_employee_customer_order_products

-- Soru: Her bir çalışanın toplam satış adedi (toplamda kaç parça
-- 		 ürün sattığı)'nı getiren sorguyu yazınız.
select employee_firstname, employee_lastname, sum(quantity) as total_quantity_sold
from vw_employee_customer_order_products
group by employee_firstname, employee_lastname
-- 5000 parçadan fazla satış yapan çalışanları getiren sorgu
select employee_firstname, employee_lastname, sum(quantity) as total_quantity_sold
from vw_employee_customer_order_products
group by employee_firstname, employee_lastname
having sum(quantity)>5000


------------------------------------------------------------------
------------------- PROCEDURE ------------------------------------
------------------------------------------------------------------
-- procedure'leri genelde 'crud' işlemleri için kullanıyormuşuz.
create or replace PROCEDURE procedureIsmi() -- eğer parametre alıyorsa parametreleri tanımlayacağız.
LANGUAGE plpgsql
as
$$
begin
	-- kod bloğu buraya yazılır
end;$$
------------------------------------------------------------------
------------------- FUNCTION  ------------------------------------
------------------------------------------------------------------
create or replace FUNCTION fonksiyonIsmi() -- eğer parametre alıyorsa parametreleri tanımlayacağız.
returns int -- burda return type belirliyoruz (int, varchar, tablo bile olabilir)
LANGUAGE plpgsql
as
$$
begin
declare
	-- değişkenlerimiz varsa bu blokta tanımlıyoruz.
	sayi integer;
	isim varchar := 'Mustafa'; -- default değer atama
begin
	-- fonksiyonun gövdesi
	return sayi; -- burda fonskiyonumuzun return değerini yazıyoruz.
end;$$

-- Soru: Yeni bir procedure yaratın. Bu procedure dışarıdan bir name
-- 		 alsın. Bu name ile yeni bir category oluştursun.
create or replace PROCEDURE yeni_category_olustur(yeni_id bigint, isim varchar)
LANGUAGE plpgsql
as
$$
begin
	insert into categories(category_id, category_name, description)
	values(yeni_id, isim, 'yeni_aciklama');
end;$$

CALL yeni_category_olustur(88, 'benim_yeni_kate');

select * from categories

-- Soru: Son oluşturduğumuz kategoriyi silen procedure oluşturun.
create or replace PROCEDURE kategori_sil(the_id bigint)
LANGUAGE plpgsql
as
$$
begin
	delete from categories where category_id=the_id;
end;$$

CALL kategori_sil(88);

select * from categories

-- Soru: employee tablosuna int türünde bir age kolonu ekledik. 
--		 yaş hesaplama procedur'u yazalım.
create or replace PROCEDURE yas_hesapla()
LANGUAGE plpgsql
as
$$
begin
	update employees set age = (now()::date - birth_date)/365
end;$$

call yas_hesapla;

select * from employees

------------------------------------------------------------------
-- Employee tablosunda 'age' kolonunun hepsini null yapıp daha sonra
-- yaş hesaplayan procedure yazıp 'age' kolonunu dolduralım.
update employees set age = null;

select employee_id, first_name, age from employees;

create or replace PROCEDURE yasHesapla3()
language plpgsql
as
$$
declare
	sayac integer := 0;
begin
	while sayac<10 loop
	update employees set age=(now()::date - birth_date)/365 where employee_id=sayac;
	sayac := sayac+1;
	end loop;
end;$$

call yasHesapla3()

select employee_id, first_name, age from employees;
-----
-- Yukarıdaki procedure oluşturma işlemini 'for' loop ile daha dinamik
-- bir şekilde (tablo satır sayısını 'count(*)' ile hesaplayarak) yapalım:
create or replace PROCEDURE yasHesapla4()
language plpgsql
as
$$
declare
	lastId integer ;
begin
	select count(*) into lastId from employees; -- pay att: 'into lastId' (assigning count(*) to lastId)
	for counter in 1..lastId loop -- this time we used 'for' loop, instead of a 'while' loop. counter of the loop will start from 1 to lastId variable's value
	update employees set age=(now()::date - birth_date)/365 where employee_id=counter;
	end loop;
end;$$

call yasHesapla4()

select employee_id, first_name, age from employees;

-- Soru: Bir kdv hesapla fonksiyonu yazalım. Dışardan bir değer 
--		 girilecek, bunun kdv'li fiyatını (%18) hesaplayıp geri
--		 dönecek, daha sonra biz bu fonksiyonu select sorgumuzda
--		 kullanalım, product tablosundan ürünleri çekerken 
--		 unitprice'ları ve kdv'li fiyatlarını yazdıralım.

-- teacher's code:
create or replace function kdvHesapla(fiyat double precision)
returns double precision 
language plpgsql
as 
$$
begin
	fiyat=fiyat*1.18;
	return fiyat;
end;$$

select product_id, product_name, unit_price, kdvhesapla(unit_price) as kdvli_fiyat from products

-- my code:
create or replace function kdvhesapla2(price real)
returns real
language plpgsql
as
$$
declare
	kdvlifiyat real; -- 'real': is a variable type. the 'unit_price' column of 'products' table is of 'real' variable type. 'real' is a floating-point number that stores single precision floating-point numbers.
begin
	kdvlifiyat = price * 1.18;
	return kdvlifiyat;
end;$$
	
select product_id, product_name, unit_price, kdvhesapla(unit_price) as kdvli_fiyat from products

-- Soru: Kdv hesaplayacağız. category'si 'Beverages' olanların kdv'si
--		 (%15), 'Seafood' (%10), diğerleri (%18).
select * from products
select * from categories

create or replace function kdv_hesapla_farkli_urunler(fiyat double precision, category_name varchar)
returns double precision 
language plpgsql
as 
$$
DECLARE
	kdvli_fiyat double precision;
begin
	if category_name = 'Beverages' THEN
		kdvli_fiyat := fiyat * 1.15;
	elseif category_name = 'Seafood' THEN
		kdvli_fiyat := fiyat * 1.10;
	else
		kdvli_fiyat := fiyat * 1.18;
	end if;	
	return kdvli_fiyat;
end;$$

select product_id, product_name, pro.category_id, category_name, unit_price, kdv_hesapla_farkli_urunler(unit_price, category_name) as kdvli_fiyat 
from products pro
inner join categories as cat on pro.category_id=cat.category_id
-- başka bir yöntem (en sondaki select bloğunda inner join kullanmadan. Ve kdv hesaplama fonksiyonunun içerisine kategory_id gönderip, daha sonra metodun gövdesinde bu kategori_id'yi kullanarak 'categories' tablosundan 'category_name' alanını çektik ve bunu 'kategori' değişkenimize atadık):
create or replace function kdv_hesapla_farkli_urunler2(fiyat double precision, kategori_id bigint)
returns double precision 
language plpgsql
as 
$$
DECLARE
	kategori varchar;
	kdvli_fiyat double precision;
begin
	select category_name into kategori from categories where categories.category_id = kategori_id;
	if kategori = 'Beverages' THEN
		kdvli_fiyat := fiyat * 1.15;
	elseif kategori = 'Seafood' THEN
		kdvli_fiyat := fiyat * 1.10;
	else
		kdvli_fiyat := fiyat * 1.18;
	end if;	
	return kdvli_fiyat;
end;$$

select product_name, category_id, unit_price, kdv_hesapla_farkli_urunler2(unit_price, category_id) from products as pro

-- Soru: employee id alacağız, daha sonra bu çalışanın kaç parça 
-- 		 ürün sattığını bulacağız.
select * from orders
select * from order_details

	-- my code:
create or replace function kac_parca_sattigi(employee_id_no smallint)
returns smallint
language plpgsql
as
$$
DECLARE
	parca_adedi smallint;
begin
	select sum(quantity) into parca_adedi from order_details as o_d 
	inner join orders as o on o_d.order_id=o.order_id	
	group by o.employee_id
	having o.employee_id=employee_id_no;
	return parca_adedi;
end;$$

SELECT employee_id, last_name, kac_parca_sattigi(employee_id) AS total_sold
FROM employees;

	-- chat gpt:
CREATE OR REPLACE FUNCTION kac_parca_sattigi(employee_id_no smallint)
RETURNS smallint
LANGUAGE plpgsql
AS $$
DECLARE
	parca_adedi smallint := 0;
BEGIN
	SELECT COALESCE(SUM(od.quantity), 0) INTO parca_adedi
	FROM order_details od
	INNER JOIN orders o ON od.order_id = o.order_id
	WHERE o.employee_id = employee_id_no;

	RETURN parca_adedi;
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		RETURN 0;
END;
$$;

SELECT employee_id, last_name, kac_parca_sattigi(employee_id) AS total_sold
FROM employees;

	