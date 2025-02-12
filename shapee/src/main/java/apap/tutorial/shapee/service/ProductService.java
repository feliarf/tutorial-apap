package apap.tutorial.shapee.service;

import apap.tutorial.shapee.model.ProductModel;

import java.util.List;

public interface ProductService {
    void addProduct(ProductModel product);
    List<ProductModel> findAllProductByStoreId(Long storeId);
    ProductModel getProductById(Long id);
    ProductModel changeProduct(ProductModel productModel);
    void deleteProduct(ProductModel product);

    List<ProductModel> getListProductOrderByHargaAsc(Long id);
}
