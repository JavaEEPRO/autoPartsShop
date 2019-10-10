package si.inspirited.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import si.inspirited.persistence.model.User;
import si.inspirited.persistence.model.uniqueEntities.Ad;
import si.inspirited.web.dto.AdDto;
import si.inspirited.web.error.AdAlreadyExistException;

import java.util.Collection;
import java.util.Optional;

public interface IAdService {

    Ad persistNewAd(AdDto adDto, User user) throws AdAlreadyExistException;

    Optional<Ad> getAdByID(long id);

    void saveAd(Ad ad);

    void deleteAd(Ad ad);

    Ad findByName(String name);

    Collection<Ad> findByUser(User user);

    Page<Ad> findPaginated(Pageable pageable);
}
