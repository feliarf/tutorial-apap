package apap.tutorial.shapee.model;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="store")
public class StoreModel implements Serializable, Comparable<StoreModel>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(max = 10)
    @Column(name="name", nullable = false)
    private String nama;

    @NotNull
    @Size(max = 30)
    @Column(name="keterangan", nullable = false)
    private String keterangan;

    @Column(name="followers")
    private int followers;

    @OneToMany(mappedBy = "storeModel", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductModel> listProduct;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public List<ProductModel> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<ProductModel> listProduct) {
        this.listProduct = listProduct;
    }

    public int compareTo(StoreModel anotherStore){
        return this.nama.compareTo(anotherStore.nama);
    }
}





