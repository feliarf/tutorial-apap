package apap.tutorial.shapee.controller;

import apap.tutorial.shapee.model.StoreModel;
import apap.tutorial.shapee.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StoreController {
    @Autowired
    private StoreService storeService;

    //URL Mapping View
    @RequestMapping("/store/add")
    public String add(
            //Request parameter untuk dipass
            @RequestParam(value= "idStore", required=true) String idStore,
            @RequestParam(value= "nama", required=true) String nama,
            @RequestParam(value= "keterangan", required=true) String keterangan,
            @RequestParam(value= "followers", required=true) int followers,
            Model model
            ) {

        //Membuat objek store model
        StoreModel store = new StoreModel(idStore, nama, keterangan, followers);

        //Memanggil service addStore
        storeService.addStore(store);

        //Memasukkan attribute nama pada view template dengan variable nama
        model.addAttribute("nama", nama);

        //Return view template add-store
        return "add-store"; //ini untuk html

        }

        //URL Mapping View
        @RequestMapping("/store/view")
        public String view(
                //Request Parameter untuk dipass
                @RequestParam(value="idStore") String idStore, Model model
                ){

            //Mengambil objek store yang dituju berdasarkan id
            StoreModel store = storeService.getStoreById(idStore);

            //Add objek store ke "store" untuk dirender
            model.addAttribute("store", store);

            //Return view template view-store
            return "view-store";
        }

        //URL Mapping viewAll
        @RequestMapping(value="/store/view-all")
        public String viewAll(Model model){
            //Mengambil data semua objek restoran yang ada
            List<StoreModel> storeList = storeService.getStoreList();

            //Add objek store ke "storeList" untuk dirender
            model.addAttribute("storeList", storeList);

            //Return view template view-all-store
            return "view-all-store";
        }

        @GetMapping(value = "/store/view/id-store/{idStore}")
        public String viewWithRequestParam(
                @PathVariable(value = "idStore")
                        String idStore,
                Model model) {
            StoreModel store = storeService.getStoreById(idStore);

            //Add objek store ke "store" untuk dirender
            model.addAttribute("store", store);

            //Return view template view-store
            return "view-store";
        }

    @GetMapping(value = "/store/update/id-store/{idStore}/keterangan/{keterangan}")
    public String updateWithRequestParam(
            @PathVariable(value = "idStore")
                    String idStore,
            @PathVariable(value = "keterangan")
                    String keterangan,
            Model model) {
        StoreModel toko = storeService.getStoreById(idStore);
        if(toko != null){
            toko.setKeterangan(keterangan);
        }
        model.addAttribute("store", toko);
        return "updateKeterangan";
    }

    @GetMapping(value = "/store/delete/id/{idStore}")
    public String deleteWithRequestParam(
            @PathVariable(value = "idStore")
                    String idStore,
            Model model) {

        StoreModel store = storeService.getStoreById(idStore);
        boolean cekStore = false;
        if(store != null){
            cekStore =  true;
            storeService.deleteStore(store);
        }
        model.addAttribute("cekStore",cekStore );

        //Return view template view-store
        return "delete-keterangan";
    }



}

