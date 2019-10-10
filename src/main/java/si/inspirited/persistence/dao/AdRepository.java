package si.inspirited.persistence.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import si.inspirited.persistence.model.uniqueEntities.Ad;

import java.util.List;

public interface AdRepository extends JpaRepository<Ad, Long> {

    Ad findByName(String name);

    @Override
    void delete(Ad ad);

    @Override
    List<Ad> findAll(Sort sort);
}
