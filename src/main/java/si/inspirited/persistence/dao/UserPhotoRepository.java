package si.inspirited.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import si.inspirited.persistence.model.uniqueEntities.UserPhoto;

public interface UserPhotoRepository extends JpaRepository<UserPhoto, Long> {


    UserPhoto findByUrl(String url);

    @Override
    void delete(UserPhoto userPhoto);

    @Override
    UserPhoto save(UserPhoto userPhoto);
}
