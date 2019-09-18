package apap.tutorial.shapee.service;

import apap.tutorial.shapee.model.StoreModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreInMemoryService implements StoreService{

    private List<StoreModel> listStore;

    public StoreInMemoryService(){
        listStore = new ArrayList<>();
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
    public void deleteStore(StoreModel store){
        listStore.remove(store);
    }

    @Override
    public StoreModel getStoreById(String IdStore){
        for (int i=0 ; i<listStore.size(); i++){
            if(listStore.get(i).getId().equals(IdStore)){
                return listStore.get(i);
            }
        }
        return null;
    }
}
