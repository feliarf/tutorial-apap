package apap.tutorial.shapee.service;
import java.util.List;
import java.util.Optional;

import apap.tutorial.shapee.model.StoreModel;

public interface StoreService {

    //Method untuk mendapatkan data store berdasarkan id
    StoreModel getStoreById(long id);

    //Method untuk menambah store
    void addStore(StoreModel storeModel);

    //Method untuk mendapatkan data semua store yang tersimpan
    List<StoreModel> getStoreList();

    //Method untuk mengubah data store
    StoreModel changeStore(StoreModel storeModel);

    String delete(StoreModel store);
}
