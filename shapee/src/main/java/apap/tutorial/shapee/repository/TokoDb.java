package apap.tutorial.shapee.repository;

import apap.tutorial.shapee.model.StoreModel;
import apap.tutorial.shapee.model.TokoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokoDb extends JpaRepository<TokoModel, Long> {
    TokoModel findByBranch(String branch);
}
