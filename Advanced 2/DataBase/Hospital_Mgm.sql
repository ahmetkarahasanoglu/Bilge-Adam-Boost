-- ERD'de ok giren (referans alınan) tabloları daha üstlere yazıyorum.
create table tbl_patient(
	id serial primary key NOT NULL,
	name varchar(50) NOT NULL,
	date_of_birth date NOT NULL,
	gender varchar(15) NOT NULL,
	address varchar(150),
	phone varchar(50),
	createdate bigint default EXTRACT(epoch from now()) * 1000,
	updatedate bigint default EXTRACT(epoch from now()) * 1000,
	state int default 1 -- 0 -> silinmiş, 1 -> aktif
)

create table tbl_department(
	id serial primary key NOT NULL,
	department_name varchar(50) NOT NULL,
	description varchar(100),
	createdate bigint default EXTRACT(epoch from now()) * 1000,
	updatedate bigint default EXTRACT(epoch from now()) * 1000,
	state int default 1
)

create table tbl_doctor(
	id serial primary key NOT NULL,
	name varchar(50) NOT NULL,
	specialization varchar(50) NOT NULL,
	phone varchar(20),
	department_id int references tbl_department(id),
	createdate bigint default EXTRACT(epoch from now()) * 1000,
	updatedate bigint default EXTRACT(epoch from now()) * 1000,
	state int default 1
)

create table tbl_appointment(
	id serial primary key NOT NULL,
	patient_id int references tbl_patient(id) NOT NULL,
	doctor_id int references tbl_doctor(id) NOT NULL,
	appointment_date date NOT NULL,
	appointment_time time NOT NULL,
	createdate bigint default EXTRACT(epoch from now()) * 1000,
	updatedate bigint default EXTRACT(epoch from now()) * 1000,
	state int default 1
)

create table tbl_medical_record(
	id serial primary key NOT NULL,
	patient_id int NOT NULL references tbl_patient(id),
	doctor_id int NOT NULL references tbl_doctor(id),
	diagnosis varchar(150),
	prescription varchar(200),
	date_of_medical_record date,
	createdate bigint default EXTRACT(epoch from now()) * 1000,
	updatedate bigint default EXTRACT(epoch from now()) * 1000,
	state int default 1
)
