package apap.tutorial.shapee.controller;

import apap.tutorial.shapee.model.ProductModel;
import apap.tutorial.shapee.model.StoreModel;
import apap.tutorial.shapee.service.ProductService;
import apap.tutorial.shapee.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @Qualifier("storeServiceImpl")
    @Autowired
    StoreService storeService;

    @RequestMapping(value = "product/add/{storeId}", method = RequestMethod.GET)
    private String addProductFormPage(@PathVariable(value = "storeId") Long storeId, Model model){
        ProductModel product = new ProductModel();
        StoreModel store = storeService.getStoreById(storeId);
        product.setStoreModel(store);
        model.addAttribute("product", product);
        return "form-add-product";
    }

    @RequestMapping(value = "product/add", method = RequestMethod.POST)
    private String addProductSubmit(@ModelAttribute ProductModel productModel, Model model){
        productService.addProduct(productModel);
        model.addAttribute("nama", productModel.getNama());
        return "add-product";
    }

    @RequestMapping(value="product/change/{idProduct}", method = RequestMethod.GET)
    public String changeProductFormPage(@PathVariable String idProduct, Model model){
         try {
             //Mengambil existing data source
             ProductModel existingProduct = productService.getProductById(Long.parseLong(idProduct));
             model.addAttribute("product", existingProduct);
             return "form-change-product";
         }
         catch (Exception e){
             return "not-found-error";
         }
    }

    //API yang digunakan untuk submit form change store
    @RequestMapping(value="product/change/{idProduct}", method = RequestMethod.POST)
    public String changeProductSubmit(@PathVariable Long idProduct, @ModelAttribute ProductModel product, Model model){
        ProductModel newStoreData = productService.changeProduct(product);
        model.addAttribute("product", newStoreData);
        return "change-product";
    }

    @RequestMapping(value = "/product/delete/{idProduct}")
    public String deleteProduct (@PathVariable String idProduct, Model model){
         try {
             ProductModel product = productService.getProductById(Long.parseLong(idProduct));
             String namaProduct = productService.delete(product);
             model.addAttribute("nama", namaProduct);
             return "delete-product";
         }
         catch (Exception e){
             return "not-found-error";
         }
    }

    @RequestMapping(value = "product/change")
    public String noInputChange(){
        return "not-found-error";
    }

    @RequestMapping(value = "product/delete")
    public String noInputDelete(){
        return "not-found-error";
    }

}
