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