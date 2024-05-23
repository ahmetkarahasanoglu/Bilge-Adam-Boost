create table kullanici_tbl(
	id bigserial primary key,
	ad varchar(50),
	soyad varchar(50),
	email varchar(50),
	telefon varchar(50),
	password varchar(32) check (length(password) >= 6 and length(password) <=32)
)

create table urun_tbl(
	id bigserial primary key,
	ad varchar(50),
	fiyat double precision,
	skt DATE NULL
)

create table urunyorum_tbl(
	id bigserial primary key,
	yorum varchar(500),
	yorum_tarihi DATE default now(),
	urun_id bigint references urun_tbl(id),
	kullanici_id bigint references kullanici_tbl(id)
)