package apap.tutorial.shapee.service;
import java.util.List;
import apap.tutorial.shapee.model.StoreModel;

public interface StoreService {

    //Method untuk menambah store
    void addStore(StoreModel Store);

    //Method untuk mendapatkan data semua store yang tersimpan
    List<StoreModel> getStoreList();

    //Method untuk mendapatkan data store berdasarkan id
    StoreModel getStoreById(String IdStore);

    void deleteStore(StoreModel Store);
}
