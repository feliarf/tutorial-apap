package apap.tutorial.shapee.service;

import apap.tutorial.shapee.model.StoreModel;
import apap.tutorial.shapee.repository.StoreDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class StoreServiceImpl implements StoreService {

    @Autowired
    StoreDb storeDb;

    @Override
    public StoreModel getStoreById(Long id) {
        return storeDb.findById(id).get();
    }

    @Override
    public void addStore(StoreModel storeModel) {
        storeDb.save(storeModel);
    }

    @Override
    public List<StoreModel> getStoreList() {
        return storeDb.findAll();
    }

    @Override
    public StoreModel changeStore(StoreModel store) {
        //Mengambil objek store yang akan diubah dari database
        StoreModel targetStore = storeDb.findById(store.getId()).get();

        //Mengubah Atribut
        targetStore.setNama(store.getNama());
        targetStore.setKeterangan(store.getKeterangan());
        storeDb.save(targetStore);
        return targetStore;
    }

    @Override
    public String delete(StoreModel store) {
        String nama = store.getNama();
        storeDb.delete(store);
        return nama;
    }
}
