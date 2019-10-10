package si.inspirited.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import si.inspirited.persistence.model.uniqueEntities.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

    Photo findByUrl(String url);

    @Override
    void delete(Photo photo);


}
