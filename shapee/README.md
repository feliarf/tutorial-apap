# Tutorial APAP
## Authors

* **Felia Risky Faizal** - *1706984581* - *A*

---
## Tutorial 1
### What I have learned today
(Masukkan pertanyaan yang diikuti jawaban di setiap nomor, contoh seperti dibawah. Anda juga boleh
menambahkan catatan apapun dibagian ini)
#### Github

-   Pertanyaan 1: Cobalah untuk menambahkan sebuah store dengan mengakses link
    berikut:ttp://localhost:8080/store/add?idStore=1&nama=shapipi&keterangan=Toko%20Elektronik&followers=100
    >terjadi error saat membuka link karena view add-store yang berfungsi untuk menampilkan output belum dibuat


-   Pertanyaan 2: Cobalah untuk menambahkan sebuah store dengan mengakses link berikut: http://localhost:8080/store/add?idStore=3&nama=shapipi&keterangan=Toko%20Elektronik
    >Terjadi error saat mengakses link berikut karena terdapat parameter yang belum ditambahkan yaitu followers

-   Pertanyaan 3: Jika Papa APAP ingin melihat store shapee, link apa yang harus diakses? link yang harus diakses adalah 
    >cara mengaksesnya adalah http://localhost:8080/store/view?idStore=1 atau http://localhost:8080/store/view/idStore/1
    (asumsi : papa apap ingin melihat salah satu toko yang sudah dibuat yaitu shapee)


-   Pertanyaan 4: Tambahkan 1 contoh store lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/store/view-all, apa yang akan ditampilkan? Sertakan juga bukti screenshotmu yang ditampilkan adalah list semua data-data toko yang sebelumnya telah dibuat
    > ![](https://i.ibb.co/zXh3Xwz/Capture.png)

### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda sudah mengerti
dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [ ] Apa perbedaan coding pada matkul APAP dengan matkul coding yang sebelumnya telah dipelajari?
- [ ] Bagaimana cara penggunaan framework Spring Boot?
- [ ] Bagaimana cara menyambungkan Java dengan HTML?
- [ ] Apa maksudnya whitelabel error page?


(Anda dapat membuat tampilan code dalam README.md menjadi lebih baik. Cari tahu lebih dalam
tentang penulisan README.md pada github pada link
[berikut](https://help.github.com/en/articles/basic-writing-and-formatting-syntax))

---

## Tutorial 2
### What I have learned today
Jawablah pertanyaan dibawah ini pada file readme.
1.  Pada class ProductDb, terdapat method findByStoreModelId, apakah kegunaan dari method
    tersebut?
    - Method tersebut berguna untuk mencari list produk dari suatu store dengan memanfaatkan
    id dari store tersebut
2.  Pada class StoreController, jelaskan perbedaan method addStoreFormPage dan
    addStoreSubmit?
    - method addStoreFromPage merupakan suatu method yang berfungsi untuk menampilkan form untunk menambahkan nama sedangkan
    method addStoreSubmit merupakan method yang berfungsi untuk menyimpan data-data yang diisikan dalam form dan membuat objek store. 
    Selain itu, 
    RequestMethod dari addStoreFromPage adalah GET, dan RequestedMethod dari addStoreSubmit adalah POST.
3.  Jelaskan kegunaan dari JPA Repository
    - JPA Repository berguna untuk membantu penggunaan operasi CRUD pada database dengan cara memanfaatkan fungsi yang 
    terdapat pada JPA Repository.
4.  Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara StoreModel dan
    ProductModel dibuat?
    - bagian yang menjelaskan relasi antara StoreModel dan ProductModel yaitu 
      - ketika membuat atribut listProduct pada class StoreModel. Pada saat membuat atribut tersebut juga ditambahkan annotation OneToMany yang berarti relai
    dari StoreModel ke ProductModel adalah One To Many
      - ketika membuat atribut storeModel pada class ProductModel. Pada saat membuat atribut tersebut terdapat
      annotation ManyToOne yang berarti relasi dari ProductModel ke StoreModel adalah Many To One
5.  Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER
       - FetchType.LAZY : digunakan untuk me-load suatu objek jika dibutuhkan via getter method
       - FetchType.EAGER : digunakan untuk me-load suatu objek ketika objek parent diload
       - CascadeType.ALL : digunakan untuk membuat suatu objek dimana jika objek tersebut dihapus maka objek yang 
                            merefer ke objek tersebut juga akan terhapus.
                            
---

## Tutorial 4
### What I have learned today
Jawablah pertanyaan dibawah ini pada file readme.
1. Jelaskan yang anda pelajari dari melakukan latihan nomor 2, dan jelaskan tahapan bagaimana
anda menyelesaikan latihan nomor 2
    - yang saya pelajari dari latihan nomor dua adalah membuat suatu fragment atau suatu bagian kecil dari html
    yang dapat digunakan dalam file HTML lain. Tahapan yang saya lakukan untuk menyelesaikannya yaitu 
        1. Menambahkan pageTitle pada tag nav berikut <nav th:fragment="navbar (pageTitle)" class="navbar navbar-expand-lg navbar-light bg-light">
        supaya judul navbar pada setiap halaman dapat disesuaikan dengan value dari halaman tersebut
        2. Menambahkan lagi pageTitle pada tag a berikut <a class="navbar-brand" href="#" th:text="${pageTitle}"></a>
        3. Mengisi pageTitle pada tag nav berikut <nav th:replace="fragments/fragment :: navbar (pageTitle='View Store')"></nav>
        sesuai dengan fungsi halamannya
2. Jelaskan yang anda pelajari dari latihan nomor 3, dan jelaskan tahapan bagaimana anda
menyelesaikan latihan nomor 3
3. Jelaskan perbedaan th:include dan th:replace
    - th:include dan th:replace dan digunakan untuk memasukkan suatu bagian dari halaman lain sebagai fragments.
    perbedaan dari th:include dan th:replace yaitu untuk th:include dapat digunakan untuk
    menempatkan fragment ke dalam <div> tag, sedangkan th:replace dapat digunakan untuk mengganti content
    yang berada di dalam div menjadi isi dari fragment tersebut
4. Jelaskan bagaimana penggunaan th:object beserta tujuannya
    - penggunaan th:object dilakukan saat terdapat beberapa input(contohnya form) lalu input tersebut dibuat menjadi suatu
    objek dan akan disimpan pada th:object tersebut.
    
---

## Tutorial 5
### What I have learned today
1. Jelaskan bagian mana saja dari test yang dibuat pada latihan no 2 adalah given, when, dan and
then.
    - Given :
       Mulai dari inisiasi objek storemodel (generatedummyproductmodel) hingga bagian when(when yang mendefinisikan
       sesuatu yang dikembalikan oleh database).
    - When :
        pada bagian when yang berisi interaksi dan kondisi yang akan diuji(storeService.getStoreById(1L) yang menampilkan
                                                                           objek Store dengan id 1)
    - Then :
        bagian verify dan mockMvc beserta dengan .andExpect yang ada pada mockMvc
        
2. Jelaskan perbedaan line coverage dan logic coverage.
    - Line coverage merupakan jumlah baris code yang telah dilakukan telah dilakukan proses testing. Sedangkan untuk 
    logic coverage adalah pengujian struktur internal code. Truth asssignment untuk suatu expression diverifikasi oleh
    test ini. 
    
3. Pada keadaan ideal, apa yang seharusnya dibuat terlebih dahulu, code atau unit test? Mengapa
seperti itu? Apa akibatnya jika urutannya dibalik, adakah risiko tak terlihat yang mungkin
terjadi?
    - Menurut saya akan lebih baik jika test yang dibuat terlebih dahulu karena pada test kita telah
    mendefinisikan output apa yang diinginkan sehingga saat kita membuat code kita sudah mengetahui hasil apa yang
    harus dicapai dan kita lebih fokus untuk membuat code yang sesuai dengan output. Apabila urutannya dibalik
    maka output yang akan menyesuaikan test dan test tersebut kurang berfungsi sebagai mana tujuan utama pembuatan test sehingga
    bisa saja terdapat hasil yang tidak sesuai dengan yang diharapkan
    
4. [Bonus] Jelaskan mengapa pada latihan no 3, main class spring tidak diikutsertakan ke dalam
perhitungan coverage? Apa saja yang dapat menyebabkan suatu class dapat di-exclude dari
perhitungan code coverage.
    - Proses testing dilakukan dengan membuat sebuah unit testing. Main class tidak diikutsertakan dalam proses testing karena code pada main class
merupakan proses yang dijalankan secara keseluruhan sehingga jika dilakukan testing maka akan menjadi
sangat kompleks.
Alasan mengapa suatu class dapat diexclude yaitu:
        1. Primitive models dan Data Transfer Objects tidak termasuk ke perhitungan coverage karena keduanya sudah masuk ke 
    perhitungan secara tidak langsung
        2. exclude class tidak dapat dibuat test
