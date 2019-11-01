package apap.tutorial.shapee.restcontroller;

import apap.tutorial.shapee.model.ProductModel;
import apap.tutorial.shapee.model.StoreModel;
import apap.tutorial.shapee.rest.Setting;
import apap.tutorial.shapee.service.ProductRestService;
import apap.tutorial.shapee.service.StoreRestService;
import apap.tutorial.shapee.service.StoreService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
@JsonIgnoreProperties(value = "store", allowSetters = true)
public class ProductRestController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ProductRestService productRestService;

    @Autowired
    StoreRestService storeRestService;

    @PostMapping(value = "/product")
    private ProductModel createProduct(@Valid @RequestBody ProductModel productModel, StoreModel storeModel, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,"Request body has invalid type or missing field");
        }else{

            productModel.setStoreModel(storeRestService.getStoreByIdStore(8L));
            return productRestService.addProduct(productModel);
        }
    }

    @PutMapping(value = "/product/{productId}")
    private ResponseEntity<String> updateProduct(
            @PathVariable(value = "productId") Long productId,
            @RequestBody ProductModel product
    ){
        try{
            ProductModel productModel = productRestService.updateProduct(productId, product);
            return ResponseEntity.ok("Product update success");
        }
        catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"ID Product " + productId + " Not Found");
        }
    }

    @GetMapping(value="/product/{productId}")
    private ProductModel retrieveProduct(@PathVariable("productId")Long idProduct){
        try{
            return productRestService.getProductByIdProduct(idProduct);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ID Product " + idProduct + " NotFound"
            );
        }
    }

    @GetMapping(value = "/products")
    private List<ProductModel> retrieveListProduct(){
        return
                productRestService.retrieveListProductModel();
    }

    @DeleteMapping(value = "/product/{productId}")
    private ResponseEntity<String> deleteStore(@PathVariable("idProduct")Long idProduct){
        try{
            productRestService.deleteProduct(idProduct);
            return ResponseEntity.ok("Product has been deleted");
        }catch(NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"Product with ID" + idProduct + "Not Found");
        }
    }

    @GetMapping("/product-etsy")
    private String getProductEtsy(@RequestParam("keywords") String keywords) {
        String url = Setting.etsyUrl + "&&keywords=" + keywords;

        return restTemplate.getForObject(url, String.class);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


}
