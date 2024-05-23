-- CommentApp'de her tabloya 2'şer tane veri ekleyelim (kod ile).

insert into kullanici_tbl(ad,soyad, email,telefon,password)
		values('Ahmet', 'Kara', 'ahmet@gmail.com', '0 555 333 4455', '123456'),
			  ('Serdar', 'Güçlü', 'serdar@gmail.com', '0532 444 3322', '987654321')
		
insert into urun_tbl(ad, fiyat, skt)
		values('Yoghurt', 45.95, '2025-06-21'),
			  ('Meyve Suyu', 33.85, '2025-04-29')
		
insert into urunyorum_tbl(yorum, yorum_tarihi, urun_id, kullanici_id)
		values('Çok güzel, tavsiye ederim.', '2023-03-15', 1, 3)
		values('Berbat', '2023-07-19', 1, 3)
		values('İdare eder', '2023-09-23', 3, 3)
		
delete from urunyorum_tbl where yorum='Berbat'

delete from kullanici_tbl where id=3

update urunyorum_tbl set yorum='Fena değil' where yorum='İdare eder'