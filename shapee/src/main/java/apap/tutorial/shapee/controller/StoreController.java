package apap.tutorial.shapee.controller;

import apap.tutorial.shapee.model.ProductModel;
import apap.tutorial.shapee.model.StoreModel;
import apap.tutorial.shapee.service.ProductService;
import apap.tutorial.shapee.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
public class StoreController {
    @Qualifier("storeServiceImpl")
    @Autowired
    private StoreService storeService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    private String home(){ return "home"; }

    //URL Mapping View
    //API yang digunakan untuk mengakses halaman add store
    @RequestMapping(value = "/store/add", method = RequestMethod.GET)
    public String addStoreFormPage(Model model){
        StoreModel newStore = new StoreModel();
        newStore.setFollowers(0);
        model.addAttribute("store", newStore);
        return "form-add-store";
    }
            //(
            //Request parameter untuk dipass
            //@RequestParam(value= "idStore", required=true) String idStore,
            //@RequestParam(value= "nama", required=true) String nama,
            //@RequestParam(value= "keterangan", required=true) String keterangan,
            //@RequestParam(value= "followers", required=true) int followers,
            //Model model
            //) {

        //Membuat objek store model
        //StoreModel store = new StoreModel(idStore, nama, keterangan, followers);

        //Memanggil service addStore
        //storeService.addStore(store);

        //Memasukkan attribute nama pada view template dengan variable nama
        //model.addAttribute("nama", nama);

        //Return view template add-store
        //return "add-store"; //ini untuk html

        @RequestMapping(value="/store/add", method = RequestMethod.POST)
        private String addStoreSubmit(@ModelAttribute StoreModel store, Model model){
            storeService.addStore(store);
            model.addAttribute("nama", store.getNama());
            return "add-store";
        }


        //API untuk mengakses halaman view store
        @RequestMapping("/store/view")
        public String view(
                //Request Parameter untuk dipass
                @RequestParam(value="idStore") String idStore, Model model
                ){
            try {
                //Mengambil objek store yang dituju berdasarkan id
                StoreModel store = storeService.getStoreById(Long.parseLong(idStore));

                //Add objek store ke "store" untuk dirender
                model.addAttribute("store", store);

                List<ProductModel> productList = productService.findAllProductByStoreId(store.getId());
                model.addAttribute("productList", productList);
                model.addAttribute("isProductListEmpty", productList.isEmpty());

                //Return view template view-store
                return "view-store";
            }
            catch (Exception e){
                return "not-found-error";
            }
        }

        //API yang digunakan untuk menuju halaman form change store
        @RequestMapping(value="store/change/{idStore}", method = RequestMethod.GET)
        public String changeStoreFormPage(@PathVariable String idStore, Model model){
            try {
                //Mengambil existing data source
                StoreModel existingStore = storeService.getStoreById(Long.parseLong(idStore));
                model.addAttribute("store", existingStore);
                return "form-change-store";
            }
            catch (Exception e){
                return "not-found-error";
            }
        }

        //API yang digunakan untuk submit form change store
        @RequestMapping(value="store/change/{idStore}", method = RequestMethod.POST)
        public String changeStoreFormSubmit(@PathVariable Long idStore, @ModelAttribute StoreModel store, Model model){
            StoreModel newStoreData = storeService.changeStore(store);
            model.addAttribute("store", newStoreData);
            return "change-store";
        }

        @RequestMapping(value = "/store/view-all")
        public String viewAll (Model model){
        //Mengambil data semua objek store yang ada
            List<StoreModel> storeList = storeService.getStoreList();
            //untuk sort
            Collections.sort(storeList);
            //add objek store ke "storeList" untuk dirender
            model.addAttribute("storeList", storeList);
            return "view-all-store";
        }

        @RequestMapping(value = "/store/delete/{idStore}")
        public String deleteStore (@PathVariable String idStore, Model model){
            try {
                StoreModel store = storeService.getStoreById(Long.parseLong(idStore));
                String namaStore = storeService.delete(store);
                model.addAttribute("nama", namaStore);
                return "delete-store";
            }
            catch (Exception e){
                return "not-found-error";
            }
        }

        @RequestMapping(value = "store/change")
        public String noInputChange(){
            return "not-found-error";
        }

        @RequestMapping(value = "store/delete")
        public String noInputDelete(){
            return "not-found-error";
        }


        //URL Mapping viewAll
        /*@RequestMapping(value="/store/view-all")
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
        return "delete-keterangan";*/

}

