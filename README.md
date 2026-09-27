# Tugas PBO Personal Makeup Organizer & Tracker

Nama: Ghaida Suci Nahiza  
Kelas: B  
NIM: 2509116077

## 1. Deskripsi Singkat Program
Personal Makeup Organizer & Tracker adalah program berbasis Java (Console/CLI) yang dirancang untuk mengelola inventaris produk kosmetik/makeup sekaligus memantau kelayakan pakai produk berdasarkan standar **PAO (*Period After Opening*)**. Program ini membantu pengguna mencatat produk makeup di meja rias, membedakan karakteristik bentuknya (cair atau padat), dan melacak apakah produk tersebut masih aman digunakan atau sudah melewati masa kedaluwarsa PAO.

Program memiliki empat menu utama, yaitu **Tambah Produk Makeup Baru, Lihat Semua Koleksi Meja Rias, Cek Produk Kedaluwarsa, dan Keluar**. Pada menu Tambah Produk, pengguna dapat memilih jenis kosmetik (cair dengan jenis aplikator atau padat dengan jenis tekstur) serta memasukkan detail bulan/tahun pertama kali dibuka beserta durasi PAO. Pada menu Lihat Koleksi, sistem menampilkan seluruh data produk secara polimorfis. Pada menu Cek Kedaluwarsa, sistem menghitung durasi pemakaian secara otomatis berdasarkan bulan dan tahun acuan saat ini.

Program ini mengimplementasikan konsep dasar **Pemrograman Berorientasi Objek (PBO)** seperti *Inheritance*, *Encapsulation*, dan *Polymorphism (Method Overriding)*, serta menggunakan `ArrayList` dinamis untuk menyimpan objek kosmetik selama program berjalan. Data yang digunakan dalam program bersifat sementara dan akan kembali ke data awal ketika program ditutup.

---
## 2. Tujuan Program
Program ini dibuat untuk memenuhi tugas mata kuliah Pemrograman Berorientasi Objek dengan menerapkan pengelolaan data dan logika objek pada sistem inventaris kosmetik. Tujuan dari program ini adalah:
- Memudahkan pencatatan koleksi produk makeup ke dalam kategori terstruktur (cair dan padat).
- Membantu pengguna memantau masa kedaluwarsa PAO (*Period After Opening*) agar terhindar dari pemakaian kosmetik yang berisiko merusak kulit.
- Mengimplementasikan konsep pewarisan (*Inheritance*) dan pemanggilan konstruktor superclass (`super`) antara kelas induk kosmetik dengan varian bentuknya.
- Menerapkan konsep polimorfisme melalui *Method Overriding* untuk menampilkan karakteristik unik produk secara dinamis.
- Mengelola penyimpanan data objek sementara selama aplikasi berjalan dengan memanfaatkan konsep `ArrayList`.

---
## 3. Struktur Program
Program ini terdiri dari beberapa class yang terbagi ke dalam *package* `model` dan *package* `main`.

| No. | Class | Fungsi |
|---|---|---|
| 1 | `main.Main.java` | Menjalankan program utama (*main method*), menampilkan menu navigasi CLI, menerima input pengguna via `Scanner`, mengatur alur fitur aplikasi, serta menginisialisasi data awal koleksi. |
| 2 | `model.ProdukMakeup.java` | Menjadi kelas induk (*superclass*) yang menyimpan atribut dasar produk (nama, merek, bulan buka, tahun buka, masa PAO), serta menyediakan kalkulasi kedaluwarsa (`isExpired`) dan tampilan informasi dasar produk. |
| 3 | `model.MakeupCair.java` | Merupakan kelas turunan (*subclass*) dari `ProdukMakeup` yang merepresentasikan kosmetik bertipe cair (seperti foundation, mascara, lip tint) dengan atribut tambahan berupa jenis aplikator. |
| 4 | `model.MakeupPadat.java` | Merupakan kelas turunan (*subclass*) dari `ProdukMakeup` yang merepresentasikan kosmetik bertipe padat (seperti compact powder, eyeshadow) dengan atribut tambahan berupa jenis tekstur. |

---
## 4. Hubungan Antarclass
Class `Main` menerima input dari pengguna dan mengelola objek-objek model (`MakeupCair` dan `MakeupPadat` yang merupakan turunan dari `ProdukMakeup`) yang disimpan menggunakan `ArrayList`.

```text
├── Source Packages
│   ├── main
│   │   └── Main.java
│   └── model
│       ├── MakeupCair.java
│       ├── MakeupPadat.java
│       └── ProdukMakeup.java
├── Test Packages
├── Dependencies
├── Java Dependencies
└── Project Files
```

---
## 5. Menu Program
```text
==========================================
    PERSONAL MAKEUP ORGANIZER & TRACKER    
==========================================
1. Tambah Produk Makeup Baru
2. Lihat Semua Koleksi Meja Rias
3. Cek Produk Kedaluwarsa
4. Keluar
Pilih menu (1-4): 
```

### 1. Tambah Produk Makeup Baru
Digunakan untuk menambahkan produk kosmetik baru ke dalam koleksi. Pengguna memilih kategori tipe terlebih dahulu:
- **Pilihan 1 (Makeup Cair)**: Mengisi nama produk, merek, bulan pertama buka (1-12), tahun pertama buka, masa PAO dalam bulan, dan jenis aplikator (*Pump / Doe-foot / Pipet*).
- **Pilihan 2 (Makeup Padat)**: Mengisi nama produk, merek, bulan pertama buka (1-12), tahun pertama buka, masa PAO dalam bulan, dan tekstur (*Matte / Shimmer / Baked*).

Setelah seluruh data diisi, sistem menampilkan pesan `-> Produk berhasil ditambahkan!`.

### 2. Lihat Semua Koleksi Meja Rias
Digunakan untuk menampilkan seluruh daftar koleksi makeup yang tersimpan di dalam `ArrayList`. Jika daftar masih kosong, sistem menampilkan pesan `"Belum ada produk di meja rias."`. Jika ada, sistem akan menampilkan rincian nomor urut produk, nama, merek, tanggal dibuka, masa PAO, bentuk/tipe, serta aplikator/tekstur secara otomatis.

### 3. Cek Produk Kedaluwarsa
Digunakan untuk mengevaluasi kelayakan seluruh produk kosmetik berdasarkan waktu saat ini. Pengguna memasukkan data bulan (1-12) dan tahun saat ini. Sistem akan menghitung selisih bulan dan mencetak status:
- `[AMAN] [Nama Produk] ([Merek]) masih layak pakai.` jika total bulan pakai belum melewati masa PAO.
- `[BUANG] [Nama Produk] ([Merek]) sudah lewat masa PAO!` jika total bulan pakai melebihi masa PAO.
- Jika tidak ada produk yang melewati batas PAO, sistem menambahkan keterangan `"Semua koleksi masih aman digunakan."`.

### 4. Keluar
Digunakan untuk menghentikan loop aplikasi, menutup objek `Scanner`, dan mengakhiri jalannya program dengan menampilkan pesan `"Program selesai. Sampai jumpa!"`.

---
## 6. Konsep PBO dan Kegunaan Kode

| No. | Konsep PBO | Penerapan dalam Program | Kegunaan |
|---|---|---|---|
| 1 | Class dan Object | `ProdukMakeup`, `MakeupCair`, `MakeupPadat` | Menggambarkan barang kosmetik fisik sebagai objek terstruktur dalam sistem dengan atribut dan perilaku yang terdefinisi. |
| 2 | Inheritance (Pewarisan) | `MakeupCair extends ProdukMakeup` dan `MakeupPadat extends ProdukMakeup` | Atribut dasar seperti nama, merek, bulan buka, tahun buka, dan PAO cukup dibuat sekali di class induk `ProdukMakeup`, lalu diwarisi oleh subclass. |
| 3 | Polymorphism (Method Overriding) | `@Override public void infoProduk()` pada subclass | Menyesuaikan isi method `infoProduk()` di subclass untuk mencetak atribut unik (aplikator atau tekstur) bersamaan dengan method induk. |
| 4 | Encapsulation | Atribut dibuat `private` dan diakses melalui getter / method internal | Menjaga agar data atribut tidak dapat diubah langsung secara bebas dari luar class dan menjaga integritas data. |
| 5 | Penyimpanan Koleksi Dinamis | `ArrayList<ProdukMakeup> koleksi = new ArrayList<>();` | Menampung kumpulan objek polimorfis (`MakeupCair` dan `MakeupPadat`) dalam satu daftar yang dapat bertambah secara fleksibel. |

### Penjelasan dan Snippet Kode

#### 1. Class dan Object
Program menggunakan class untuk menggambarkan produk kosmetik. Objek baru dibentuk menggunakan kata kunci `new` baik saat inisialisasi default maupun saat input dari pengguna.
```java
koleksi.add(new MakeupCair("Fit Me Matte Foundation", "Maybelline", 1, 2025, 12, "Pump"));
koleksi.add(new MakeupPadat("Colorfit Velvet Powder", "Wardah", 5, 2025, 24, "Matte Powder"));
```
Kode di atas membuat objek nyata dari class `MakeupCair` dan `MakeupPadat` lalu menyimpannya ke dalam list koleksi.

#### 2. Inheritance (Pewarisan)
`MakeupCair` dan `MakeupPadat` adalah class turunan dari superclass `ProdukMakeup`.
```java
public class MakeupCair extends ProdukMakeup {
    private String aplikator;
}

public class MakeupPadat extends ProdukMakeup {
    private String tekstur;
}
```
Kata kunci `extends ProdukMakeup` membuat subclass mewarisi atribut dan method milik `ProdukMakeup`. Pada konstruktor, pemanggilan `super(...)` meneruskan parameter ke konstruktor superclass:
```java
public MakeupCair(String nama, String merek, int bulanBuka, int tahunBuka, int masaPaoBulan, String aplikator) {
    super(nama, merek, bulanBuka, tahunBuka, masaPaoBulan);
    this.aplikator = aplikator;
}
```
Dengan demikian, kode inisialisasi data umum tidak perlu ditulis ulang.

#### 3. Polymorphism (Method Overriding)
Subclass menimpa (*override*) method `infoProduk()` milik superclass untuk melengkapi keterangan khusus masing-masing tipe.
```java
@Override
public void infoProduk() {
    super.infoProduk();
    System.out.println("Bentuk/Tipe : Cair (Liquid)");
    System.out.println("Aplikator   : " + aplikator);
}
```
Pemanggilan `super.infoProduk()` mengeksekusi cetak data dasar terlebih dahulu, kemudian diikuti oleh cetak informasi spesifik jenis produk.

#### 4. Encapsulation
Atribut pada class dibuat `private` sehingga data terlindungi dari modifikasi langsung di luar class.
```java
private String nama;
private String merek;
private int bulanBuka;
private int tahunBuka;
private int masaPaoBulan;
```
Data dibaca menggunakan method getter seperti `getNama()` dan `getMerek()`, sedangkan pengecekan status kedaluwarsa dibungkus dalam method `isExpired()`:
```java
public boolean isExpired(int bulanSekarang, int tahunSekarang) {
    int totalBulanPakai = (tahunSekarang - tahunBuka) * 12 + (bulanSekarang - bulanBuka);
    return totalBulanPakai > masaPaoBulan;
}
```
Perhitungan selisih bulan diproses di dalam method tersebut dan mengembalikan nilai *boolean* (`true`/`false`).

#### 5. Penyimpanan Data dengan ArrayList
Program memanfaatkan `ArrayList` bertipe polimorfis `ProdukMakeup` untuk menampung seluruh produk.
```java
ArrayList<ProdukMakeup> koleksi = new ArrayList<>();
```
Objek baru dapat ditambahkan saat program berjalan menggunakan method `.add()`:
```java
koleksi.add(new MakeupCair(nama, merek, bln, thn, pao, aplikator));
```
Seluruh data yang tersimpan di dalam `ArrayList` ini bersifat sementara selama sesi program aktif.

---
## 7. Demo Program

### 1. Menu Utama
<img width="176" height="75" alt="image" src="https://github.com/user-attachments/assets/e104e3ee-3131-49ae-9ea8-a04a83ae3c5a" />


Tampilan awal program saat dijalankan. Sistem menampilkan judul **PERSONAL MAKEUP ORGANIZER & TRACKER** beserta empat pilihan menu yang dapat dipilih pengguna.

---
### 2. Tambah Produk Makeup Baru
<img width="250" height="141" alt="image" src="https://github.com/user-attachments/assets/1b52882d-7531-4bfb-a098-f674d4d6169a" />


Pada bagian ini, pengguna memilih **Menu 1 (Tambah Produk Makeup Baru)**. Pengguna memilih tipe produk (1 untuk Cair, 2 untuk Padat), mengisi nama, merek, bulan dan tahun kemasan dibuka, masa PAO dalam bulan, serta jenis aplikator atau tekstur. Setelah berhasil, sistem menampilkan pesan `-> Produk berhasil ditambahkan!`.

---
### 3. Lihat Semua Koleksi Meja Rias
<img width="150" height="160" alt="image" src="https://github.com/user-attachments/assets/06de433e-690c-4bbc-87c3-b9fd0e4a59fd" />


Pada bagian ini, pengguna memilih **Menu 2 (Lihat Semua Koleksi Meja Rias)**. Sistem menampilkan seluruh koleksi yang tersimpan di dalam `ArrayList`, lengkap dengan nama produk, merek, tanggal dibuka, masa PAO, bentuk/tipe, serta aplikator atau tekstur.

---
### 4. Cek Produk Kedaluwarsa
<img width="302" height="105" alt="image" src="https://github.com/user-attachments/assets/e25545b8-b3f0-47e5-9218-e9d993ae17fa" />


Pada bagian ini, pengguna memilih **Menu 3 (Cek Produk Kedaluwarsa)**. Sistem meminta input bulan dan tahun saat ini, kemudian menghitung durasi pemakaian dan menampilkan status apakah produk masih `[AMAN]` atau sudah `[BUANG]`.

---
### 5. Keluar
<img width="134" height="22" alt="image" src="https://github.com/user-attachments/assets/590d456d-cda4-43ce-970a-a5d5afff9f57" />


Pada bagian ini, pengguna memilih **Menu 4 (Keluar)**. Sistem menampilkan pesan penutup `Program selesai. Sampai jumpa!` dan aplikasi berhenti berjalan.
