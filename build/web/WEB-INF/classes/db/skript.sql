drop database if exists homestay;
create database homestay;
use homestay;

create table Kamar(
  id_kamar int not null primary key auto_increment,
  type_kamar char(100),
  harga varchar(100),
  fasilitas varchar(100),
  stock int
);

create table Tamu (
  id_tamu int not null primary key auto_increment,
  nama_tamu char(100),
  kartu_identitas char(100),
  no_telp int
);

create table Pegawai (
  id_pegawai int not null primary key auto_increment,
  nama_pegawai char(100)
);

create table transaksi_pesan_kamar(
  id_pesan int not null primary key auto_increment,
  tgl_masuk date,
  tgl_keluar date,
  tamu_id int,
  pegawai_id int,
  foreign key (tamu_id) references Tamu(id_tamu),
  foreign key (pegawai_id) references Pegawai(id_pegawai)
);

create table item_transaksi_pesan(
  id_transaksi int not null primary key auto_increment,
  transaksi_pesan_id int,
  kamar_id int,
  foreign key (transaksi_pesan_id) references transaksi_pesan_kamar(id_pesan),
  foreign key (kamar_id) references Kamar(id_kamar)
);

create table Pembayaran(
  id_pembayaran int not null primary key auto_increment,
  lama_sewa int,
  tanggal_keluar date,
  total_biaya int,
  id_bayarpesan int,
  foreign key (id_bayarpesan) references transaksi_pesan_kamar(id_pesan)
);

create table pengaturan(
    id int not null primary key,
    jumlah_hari_pesan int
);

-- CONTOH PROJEK PAK PIETER
insert into pengaturan values(0,0);