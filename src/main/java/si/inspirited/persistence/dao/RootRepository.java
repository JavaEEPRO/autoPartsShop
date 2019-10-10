package si.inspirited.persistence.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.List;

public interface RootRepository extends JpaRepository<Root, Long> {

    Root findByTooth(Tooth tooth);

    @Override
    void delete(Root root);

    @Override
    List<Root> findAll(Sort sort);
}
