package si.inspirited.service;

import si.inspirited.persistence.model.uniqueEntities.UserPhoto;

public interface IUserPhotoService {
    //photo uploader

    UserPhoto saveAnotherUserPhoto(UserPhoto userPhoto);

    //boolean removeUserPhotoCompletely(Url or Id);
    //boolean removeUserPhotoLinksOnly(Url or Id);
}
