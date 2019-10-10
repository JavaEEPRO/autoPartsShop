package si.inspirited.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import si.inspirited.persistence.model.uniqueEntities.Kind;

public interface KindRepository extends JpaRepository<Kind, Long> {

    Kind findByName(String name);

    @Override
    void delete(Kind kind);
}
