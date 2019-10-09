package apap.tutorial.shapee.service;

import apap.tutorial.shapee.model.ProductModel;
import apap.tutorial.shapee.repository.ProductDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDb productDb;

    @Override
    public void addProduct(ProductModel product) {
        productDb.save(product);
    }

    @Override
    public List<ProductModel> findAllProductByStoreId(Long storeId) {

        return productDb.findByStoreModelId(storeId);
    }

    @Override
    public ProductModel getProductById(Long id) {
        return productDb.findById(id).get();
    }

    @Override
    public ProductModel changeProduct(ProductModel product) {
        ProductModel targetProduct = productDb.findById(product.getId()).get();

        targetProduct.setNama(product.getNama());
        targetProduct.setHarga(product.getHarga());
        targetProduct.setStok(product.getStok());
        targetProduct.setDeskripsi(product.getDeskripsi());
        productDb.save(targetProduct);
        return targetProduct;

    }

    @Override
    public void deleteProduct(ProductModel product) {
        productDb.delete(product);
    }

    @Override
    public List<ProductModel> getListProductOrderByHargaAsc(Long id) {
        return productDb.findByStoreModelIdOrderByHargaAsc(id);
    }

}
