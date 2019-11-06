package apap.tutorial.shapee.service;

import apap.tutorial.shapee.model.ProductModel;

import java.util.List;

public interface ProductRestService {
    ProductModel addProduct(ProductModel product);
    ProductModel updateProduct(Long idStore, ProductModel productModelUpdate);
    ProductModel getProductByIdProduct(Long idProduct);
    List<ProductModel> retrieveListProductModel();
    void deleteProduct(Long idProduct);
}
