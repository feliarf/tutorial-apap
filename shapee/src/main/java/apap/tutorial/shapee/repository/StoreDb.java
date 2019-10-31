package apap.tutorial.shapee.repository;
import apap.tutorial.shapee.model.StoreModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;


public interface StoreDb extends JpaRepository<StoreModel, Long>{
    Optional<StoreModel> findById(Long id);
    List<StoreModel> findAllByOrderByNamaAsc();
}
