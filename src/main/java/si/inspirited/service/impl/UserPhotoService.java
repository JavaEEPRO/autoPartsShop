package si.inspirited.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import si.inspirited.persistence.dao.UserPhotoRepository;
import si.inspirited.persistence.model.uniqueEntities.UserPhoto;
import si.inspirited.service.IUserPhotoService;

@Service
@Transactional
public class UserPhotoService implements IUserPhotoService {

    // photo uploader

    @Autowired
    UserPhotoRepository userPhotoRepository;

    @Override
    public UserPhoto saveAnotherUserPhoto(UserPhoto userPhoto) {
        UserPhoto res = new UserPhoto();
        if (userPhoto!=null) {res = userPhotoRepository.save(userPhoto);}
        return res;
    }
}
