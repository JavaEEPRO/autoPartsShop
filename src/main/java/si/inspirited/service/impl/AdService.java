package si.inspirited.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import si.inspirited.persistence.dao.*;
import si.inspirited.persistence.model.User;
import si.inspirited.persistence.model.uniqueEntities.Ad;
import si.inspirited.persistence.model.uniqueEntities.Category;
import si.inspirited.persistence.model.uniqueEntities.Photo;
import si.inspirited.service.IAdService;
import si.inspirited.web.dto.AdDto;
import si.inspirited.web.error.AdAlreadyExistException;

import java.util.*;

//import java.awt.print.Pageable;

@Service
@Transactional
public class AdService implements IAdService {

    @Autowired
    private AdRepository adRepository;

    @Autowired
    private KindRepository kindRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Ad persistNewAd(AdDto adDto, User user) throws AdAlreadyExistException {


        if (nameExists(adDto.getName())) {                               //OPT (if this check is not really necessary)
            throw new AdAlreadyExistException("There is an ad with same name: " + adDto.getName());
        }
        /*if (kindNotExists(adDto.getKind())) {                            //OPT (if this check is not really necessary)
            throw new KindNotExistException("There is no kind found with name: " + adDto.getKind());
        }
        if (categoryNotExists(adDto.getCategories())) {                  //OPT (if this check is not really necessary)
            throw new KindNotExistException("There is no category found with name: " + adDto.getCategories());
        }*/
        //
        // User user = (User) SecurityContextHolder.getContext().getAuthentication().getCredentials();



        Ad ad = new Ad();

        ad.setUser(user);




        ad.setName(adDto.getName());
        ad.setKind(kindRepository.findByName(adDto.getKind()));

        Collection<Category> c = new ArrayList<>();
        c.add(categoryRepository.findByName(adDto.getCategories()));
        ad.setCategories(c);

        ad.setDescription(adDto.getDescription());
        ad.setBody(adDto.getBody());
        ad.setExpiryDate(new Date(2019, 6, 1));  //OPT!!!


        List<Photo> forSave = new ArrayList<>();
        List<Photo> process = (List)adDto.getPhotos();

        if ( process != null ) {
            for (Photo photo : process) {
                Photo persistedPhoto = photoRepository.save(photo);
                forSave.add(persistedPhoto);
            }
        }

        ad.setPhotos(forSave);

        ad = adRepository.save(ad);

        return ad;
    }

    @Override
    public Optional<Ad> getAdByID(long id) {
        return Optional.empty();
    }

    @Override
    public void saveAd(Ad ad) {

    }

    @Override
    public void deleteAd(Ad ad) {

    }

    @Override
    public Ad findByName(String name) {
        return null;
    }

    @Override
    public Collection<Ad> findByUser(User user) {
        return null;
    }


    //utils
    private boolean nameExists(final String name) {
        return adRepository.findByName(name) != null;
    }

    private boolean kindNotExists(final String name) {
        return kindRepository.findByName(name) != null;
    }

    private boolean categoryNotExists(final String name) {
        return categoryRepository.findByName(name) != null;
    }




    // pageable


    public Page<Ad> findPaginated(Pageable pageable) {

        final List<Ad> ads = adRepository.findAll();
        Collections.reverse(ads);

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Ad> list;

        if (ads.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, ads.size());
            list = ads.subList(startItem, toIndex);
        }

        Page<Ad> adPage
                = new PageImpl<Ad>(list, PageRequest.of(currentPage, pageSize), ads.size());

        return adPage;
    }
}
