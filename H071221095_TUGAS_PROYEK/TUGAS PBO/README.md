pada kelas App berisi method main untuk menjalankan aplikasi

#config
pada kelas MyConfig terdapat URL, USER, PASS, digunakan agar mengatur koneksi ke database Mysql

#control
pada kelas ControlDatabase yaitu berfungsi untuk pengontrol akses, di dalam kelas ini terdapat beberapa method

#layout, terdapat 5 kelas :
pada kelas Menu terdapat 2 method static yaitu showMenu() dan SelectMenu(). method showMenu() untuk menampilkan menu utama aplikasi yaitu "Welcome To Toko Salsa" dan method SelectMenu() untuk menampilkan apa yang pengguna pilih 

pada kelas ReadData yaitu menggunakan scanner untuk menampilkan data produk dan menu. selain scanner, juga terdapat switch untuk menentukan tindakan yang akan dilakukan berdasarkan apa yang di input. Jika menginput nomor 1, program akan memanggil method showMenu() dari kelas Menu. Jika menginput nomor 2, program akan mencetak pesan "SAMPAI JUMPA KEMBALI" dan kemudian keluar dari program menggunakan System.exit(). Jika menginput nomor selain 1 atau 2, program akan mencetak pesan "MAAF MENU YANG DIPILIH TIDAK TERSEDIA" dan kemudian memanggil kembali method showReadData() untuk menampilkan ulang data dan opsi menu.

pada kelas InsertData yaitu berfungsi untuk memasukkan data produk ke dalam database. Method showInsertData() menampilkan pesan kepada pengguna dan mengambil input untuk nama produk, harga produk, dan jumlah produk menggunakan objek Scanner. Kemudian disimpan dalam variabel name, harga, dan jumlah.

pada kelas Update Data yaitu berfungsi untuk mengupdate data produk dalam sebuah sistem aplikasi. Terdapat method showUpdateData(String nama), method ini menampilkan menu untuk memilih produk yang ingin diubah. Setelah pengguna memilih produk, method showEditNama(), showEditHarga(), atau showEditStok() akan dipanggil tergantung apa yang di input. Dan terdapat method showEditNama(String nama) untuk menampilkan informasi produk yang dipilih dan meminta pengguna untuk memasukkan data yang baru. 

pada kelas DeleteData yaitu berfungsi untuk menghapus data dari database

#models
pada kelas Produk yaitu berfungsi untuk mempresentasikan produk dalam sebuah program