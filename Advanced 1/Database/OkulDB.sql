-- ogrenci tablosunu oluşturalım
-- id, isim, yas, kayıttarihi
-- kurs tablosu oluşturalım; isim, açıldığı tarih, öğretmen(her
--	  kursun 1 tane öğretmeni olsun.
create table ogrenci(
id bigserial primary key,
isim varchar(20),
yas int,
kayit_tarihi bigint default EXTRACT(epoch from now()) * 1000, --> Millisecond time
kayıt_tarihi2 timestamp without time zone DEFAULT now(),   --> Timestamp normal time
kayıt_tarihi3 timestamp with time zone DEFAULT now()
)

CREATE TABLE IF NOT EXISTS public.ogretmen( -- Otomatik oluşturma (kolon özelliklerini girerek) yapıp script'i aldık buraya (çok da önemli değil)
    id bigint NOT NULL DEFAULT nextval('ogretmen_id_seq'::regclass),
    name character varying COLLATE pg_catalog."default" NOT NULL,
    yas integer,
    kayit_tarihi bigint DEFAULT (EXTRACT(epoch FROM now()) * (1000)::numeric),
    kayit_tarihi2 timestamp without time zone DEFAULT now(),
    kayit_tarihi3 timestamp with time zone DEFAULT now(),
    CONSTRAINT ogretmen_pkey PRIMARY KEY (id)
)

create table if not exists kurs(
	id bigserial primary key,
	isim varchar,
	acilisTarihi bigint default EXTRACT(epoch from now()) * 1000,
	ogretmen_id bigint references ogretmen(id) -- Foreign Key (F.K.)
)