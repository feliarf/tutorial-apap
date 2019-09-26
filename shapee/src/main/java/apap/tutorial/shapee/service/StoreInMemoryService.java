package apap.tutorial.shapee.service;

import apap.tutorial.shapee.model.StoreModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StoreInMemoryService implements StoreService{

    private List<StoreModel> listStore;

    public StoreInMemoryService(){
        listStore = new ArrayList<>();
    }

    @Override
    public StoreModel getStoreById(Long id) {
        return null;
    }

    @Override
    public void addStore(StoreModel store){
        listStore.add(store);
    }

    @Override
    public List<StoreModel> getStoreList(){
        return listStore;
    }

    @Override
    public StoreModel changeStore(StoreModel storeModel) {
        return null;
    }

    @Override
    public String delete(StoreModel store) {
        return null;
    }

    /*@Override
    public void deleteStore(StoreModel store){
        listStore.remove(store);
    }*/

    /*@Override
    public StoreModel getStoreById(String IdStore){
        for (int i=0 ; i<listStore.size(); i++){
            if(listStore.get(i).getId().equals(IdStore)){
                return listStore.get(i);
            }
        }
        return null;
    }*/
}
