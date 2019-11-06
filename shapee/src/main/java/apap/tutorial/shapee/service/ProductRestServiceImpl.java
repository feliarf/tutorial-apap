package apap.tutorial.shapee.service;

import apap.tutorial.shapee.model.ProductModel;
import apap.tutorial.shapee.repository.ProductDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductRestServiceImpl implements ProductRestService {
    @Autowired
    ProductDb productDb;

    @Override
    public ProductModel addProduct(ProductModel product) {
        return productDb.save(product);
    }

    @Override
    public ProductModel updateProduct(Long idProduct, ProductModel productModelUpdate) {
        ProductModel product = getProductByIdProduct(idProduct);
        product.setNama(productModelUpdate.getNama());
        product.setHarga(productModelUpdate.getHarga());
        product.setStok(productModelUpdate.getStok());
        product.setDeskripsi(productModelUpdate.getDeskripsi());
        return productDb.save(product);
    }

    @Override
    public ProductModel getProductByIdProduct(Long idProduct) {
        return productDb.findById(idProduct).get();
    }

    @Override
    public List<ProductModel> retrieveListProductModel() {
        return productDb.findAll();
    }

    @Override
    public void deleteProduct(Long idProduct) {
        ProductModel product = getProductByIdProduct(idProduct);
        productDb.delete(product);

    }

}
