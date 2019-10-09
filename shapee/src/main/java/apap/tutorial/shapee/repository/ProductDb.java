package apap.tutorial.shapee.repository;

import apap.tutorial.shapee.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProductDb extends JpaRepository<ProductModel, Long> {
    List<ProductModel> findByStoreModelId(Long storeId);
    Optional<ProductModel> findById(Long id);
    List<ProductModel> findByStoreModelIdOrderByHargaAsc(Long storeId);
}
