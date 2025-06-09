# 1. Inheritance:
pada folder model terdapat file java Person-Admin-Member. Person.java sebagai class induk sementara admin.java dan member.java sebagai class turunannya. 

Alasan: Karena pada admin dan member memiliki atribut yang sama yaitu atribut nama, email dan nomor hp, sehingga sebaiknya dibuat 1 class induk yg merepresentasikan keduanya yaitu class induk Person yg memiliki atribut nama, email dan nomor hp. anak class admin dan member hanya perlu mengextends person sehingga kedua turunan class tsb memiliki atribut yg sama denan person.

# 2. Encapsulation 
Buka Folder Model, di file Book.java.
Encapsulation adalah menyembunyikan detail implementasi dari luar kelas dan hanya menyediakan akses melalui metode tertentu (getter/setter).
Contoh menyembunyikan di Book.java:
```
    private String id;
    private String title;
    private String category;
    private String author;
    private String released;
    private String photo;
    private CheckBox select;
```
karena private, sehingga tersembunyi dan hanya dapat diakses melalui getter, contohnya:
```
public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }

    public String getReleased() {
        return released;
    }

    public String getPhoto() {
        return photo;
    }

    public CheckBox getSelect() {
        return select;
    }
```

# 3. Polymorphism
- Di folder Model- lalu file Member.java, terdapat contstructor nya ad 2, itu overriding polymorpihsm
- jadi constructor Member itu namanya sama, tapi parameternya beda, sehingga bisa outputnya beda, disesuaikan sama nama parameternya

# 4. Adapter
Digunakan untuk printer, di package adapter, dan model printer.java
-	Abstraksi Akses Hardware
Adapter menyembunyikan kompleksitas teknis komunikasi langsung dengan printer (misalnya via Bluetooth, USB, atau serial port). Kamu cukup memanggil metode seperti printBarcode(String id) tanpa perlu tahu bagaimana karakter dikirim ke printer.
-	 Dukungan Beragam Tipe Printer
Dengan adapter, kamu bisa mengganti merek atau model printer (misalnya dari Epson ke RPP02) tanpa mengubah kode utama. Cukup ubah isi adapter sesuai driver atau protokol baru.

# 5. Composite
Penerapan composite ada di setial file .fxml. setiap komponen grafis terdiri dari hierarkis. Misalnya pada sidebar di tiap file .fxml, tersusun atas elemen paling dasar yaitu, anchor pane, lalu ada vbox dan di dalamnya terdapat button. 
Jadi cara membuktikannya, kalau vbox di hapus, maka semua tombol di dalam vbox akan hilang.

# 6. Decorator
Ada pada reserveController

# 7. Thread
Pada reserveCOntroller.java. Jadi saat mengeprint dilakukan di latar belakang  sehingga sistem tidak perlu menunggi prose print selesai untuk melakukan aktovitas lainnya

# 8. Singleton
Penerapannya di setiap file di folder Database, pada tiap fungsi diawali db.getConnection();
Dan diakhir fungsi terdapat db.closeConnection(); artinya, setelah fungsi dijalankan, maka akses di database diputus agar database diakses pada saat diperlukan saja (saat fungsi dijalankan).
