package apap.tutorial.shapee.service;
import apap.tutorial.shapee.model.ProductModel;
import apap.tutorial.shapee.model.StoreModel;
import apap.tutorial.shapee.repository.ProductDb;
import apap.tutorial.shapee.repository.StoreDb;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {
    @InjectMocks
    ProductService productService = new ProductServiceImpl();
    @Mock
    ProductDb productDb;

    @Test
    public void whenAddValidProductItShouldCallProductRepositorySave() {
        ProductModel newProduct = new ProductModel();
        newProduct.setNama("baju");
        newProduct.setHarga(BigInteger.valueOf(1000));
        newProduct.setStok(BigInteger.valueOf(1));
        productService.addProduct(newProduct);
        verify(productDb, times(1)).save(newProduct);
    }

    @Test
    public void whenGetProductByIdCalledByExistingDataItShouldReturnCorrectData() {
        ProductModel returnedData = new ProductModel();
        returnedData.setNama("Baju");
        returnedData.setId(Long.valueOf(1));
        returnedData.setHarga(BigInteger.valueOf(1000));
        returnedData.setStok(BigInteger.valueOf(1));
        when(productDb.findById(1L)).thenReturn(Optional.of(returnedData));
        ProductModel dataFromServiceCall = productService.getProductById(Long.valueOf(1L));
        verify(productDb, times(1)).findById(1L);
        assertNotNull(dataFromServiceCall);
        ProductModel dataFromOptional = dataFromServiceCall;
        assertEquals("Baju", dataFromOptional.getNama());
        assertEquals(Long.valueOf(1), dataFromOptional.getId());
        assertEquals(BigInteger.valueOf(1000), dataFromOptional.getHarga());
        assertEquals(BigInteger.valueOf(1), dataFromOptional.getStok());
    }

    @Test
    public void whenChangeSProductCalledItShouldChangeProductData() {
        ProductModel updatedData = new ProductModel();
        updatedData.setNama("Baju");
        updatedData.setId(Long.valueOf(1));
        updatedData.setHarga(BigInteger.valueOf(1000));
        updatedData.setStok(BigInteger.valueOf(1));
        when(productDb.findById(1L)).thenReturn(Optional.of(updatedData) );
        when(productService.changeProduct(updatedData)).thenReturn(updatedData);
        ProductModel dataFromServiceCall = productService.changeProduct(updatedData);
        assertEquals("Baju",dataFromServiceCall.getNama() );
        assertEquals(Long.valueOf(1), dataFromServiceCall.getId());
        assertEquals(BigInteger.valueOf(1000), dataFromServiceCall.getHarga());
        assertEquals(BigInteger.valueOf(1), dataFromServiceCall.getStok());
    }

    @Test
    public void whenDeleteProductCalledItShouldDeleteTheProduct(){
        ProductModel newProduct = new ProductModel();
        newProduct.setNama("baju");
        newProduct.setHarga(BigInteger.valueOf(1000));
        newProduct.setStok(BigInteger.valueOf(1));
        productService.addProduct(newProduct);
        productService.deleteProduct(newProduct);
        verify(productDb, times(1)).delete(newProduct);
    }

    @Test
    public void whenGetListProductOrderByHargaAscItShouldReturnListSortedProduct() {
        List<ProductModel> allProductInTheDatabase = new ArrayList<>();
        for (int loopTimes = 3 ; loopTimes > 0; loopTimes--) {
            allProductInTheDatabase.add(new ProductModel());
        }
        when(productService.getListProductOrderByHargaAsc(1L)).thenReturn(allProductInTheDatabase);
        List<ProductModel> dataFromServiceCall = productService.getListProductOrderByHargaAsc(1L);
        assertEquals(3, dataFromServiceCall.size());
        verify(productDb, times(1)).findByStoreModelIdOrderByHargaAsc(1L);
    }

    @Test
    public void whenGetProductListCalledItShouldReturnProduct() {
        List<ProductModel> allProductInTheDatabase = new ArrayList<>();
        for (int loopTimes = 3 ; loopTimes > 0; loopTimes--) {
            allProductInTheDatabase.add(new ProductModel());
        }
        when(productService.findAllProductByStoreId(1L)).thenReturn(allProductInTheDatabase);
        List<ProductModel> dataFromServiceCall = productService.findAllProductByStoreId(1L);
        assertEquals(3, dataFromServiceCall.size());
        verify(productDb, times(1)).findByStoreModelId(1L);
    }




}
