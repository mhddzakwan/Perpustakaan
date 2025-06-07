# 1. Inheritance:
pada Person-Admin-Member. Person sebagai class induk sementara admin dan member sebagai class turunannya

# 2. Encapsulation 
Terdapat disemua file di folder Model (getter-setter dan atribut private)
# 3. Polymorphism
- Di package Model- Member.java, contstructor nya ad 2, itu overriding polymorpihsm

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
