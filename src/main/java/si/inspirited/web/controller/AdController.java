package si.inspirited.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import si.inspirited.persistence.model.Pager;
import si.inspirited.persistence.model.User;
import si.inspirited.persistence.model.uniqueEntities.Ad;
import si.inspirited.persistence.model.uniqueEntities.Photo;
import si.inspirited.persistence.model.uniqueEntities.UserPhoto;
import si.inspirited.service.IAdService;
import si.inspirited.service.IUserPhotoService;
import si.inspirited.service.IUserService;
import si.inspirited.web.dto.AdDto;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class AdController {

    public AdController() {
        unsavedButLoadedPhotos = new ArrayList<>();
        tempUnsavedButLoadedPhotos = new ArrayList<>();
        tempPhotoUrls = new ArrayList<>();
    }


    @Autowired
    private Environment env;

    @Autowired
    private IAdService adService;

    @Autowired
    private IUserPhotoService userPhotoService;

    @Autowired
    private IUserService userService;

    private List<UserPhoto> unsavedButLoadedPhotos;
    private List<UserPhoto> tempUnsavedButLoadedPhotos;
    private List<String> tempPhotoUrls;

    //parameters for paginator
    private static final int BUTTONS_TO_SHOW = 5;
    private static final int INITIAL_PAGE = 1;
    private static final int INITIAL_PAGE_SIZE = 5;
    private static final int[] PAGE_SIZES = {5, 10, 20};

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/createAd", method = RequestMethod.GET)
    public ModelAndView createAd(final HttpServletRequest request, final CookieLocaleResolver clr, final ModelAndView modelAndView) {

        LOGGER.debug("Rendering createAd page.");

        Locale currentLocale = clr.resolveLocale(request);

        final AdDto adDto = new AdDto();
        modelAndView.addObject("ad", adDto);
        modelAndView.addObject("currentLocale", currentLocale);
        modelAndView.setViewName("createAd");
        //return "createAd";
        return modelAndView;
    }







    @RequestMapping(value = "/createAd", method = RequestMethod.POST)
    public ModelAndView registerUserAccount(@ModelAttribute("ad")
                                                //@AuthenticationPrincipal User user,
                                                @Valid final AdDto adDto, final HttpServletRequest request, final CookieLocaleResolver clr, final Errors errors, final ModelAndView modelAndView) {
        //LOGGER.debug("Persisting Ad with information: [entity: {} title: {} description: {}]", adDto, adDto.getName(), adDto.getDescription());

        //User user = //(User)
        //Object obj = new Object();
        //obj= SecurityContextHolder.getContext().getAuthentication().getCredentials();
        //User user = (User) obj;

        User user = new User();

        //boolean isUser = SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains("USER");

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Collection authorities = authentication.getAuthorities();
//        for(Object authority : authorities) {
//            System.out.println(authority);
//        }

        //boolean auth = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
        //if ((SecurityContextHolder.getContext().getAuthentication()).getClass() == String.class)


        //if(!hasRoleUser(authorities))
        if ( !hasRole("USER") ) {user = userService.findUserByEmail("test@test.com");}//userRepository.findByEmail("test@test.com");}
        else {user = userService.findUserByEmail(((UserDetails)(SecurityContextHolder.getContext().getAuthentication()).getPrincipal()).getUsername());}

        LOGGER.debug("Persisting Ad with information: [entity: {} title: {} description: {} user: {}", adDto, adDto.getName(), adDto.getDescription(), user);


        if (!unsavedButLoadedPhotos.isEmpty()) {
            Collection<Photo> res = new ArrayList<>();

            for (UserPhoto userPhoto : unsavedButLoadedPhotos) {
                Photo photo = new Photo();
                //photo.setId(userPhoto.getId());
                photo.setUrl(userPhoto.getUrl());
                res.add(photo);
            }

            adDto.setPhotos(res);
            tempUnsavedButLoadedPhotos = unsavedButLoadedPhotos;
            tempPhotoUrls.clear();
            unsavedButLoadedPhotos.clear();
        }

        Locale currentLocale = clr.resolveLocale(request);

        modelAndView.addObject("currentLocale", currentLocale);
        modelAndView.addObject("ad", adDto);
        modelAndView.setViewName("createAd");

        //User user = userRepository.findByEmail(userDetails.getUsername());
        final Ad persisted = adService.persistNewAd(adDto, user);
        user.ads.add(persisted);
        userService.saveRegisteredUser(user);
        if (persisted == null) {
            //result.rejectValue("email", "message.regError");
            //return new ModelAndView("createAd", "ad", adDto);
            return modelAndView;
        }
        //try {
           // final String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
            //eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, clr.resolveLocale(request), appUrl));
        //} catch (final Exception ex) {
          //  LOGGER.warn("Unable to persist ad", ex);
            //return new ModelAndView("emailError", "user", adDto);
        //}
        //return new ModelAndView("createAd", "ad", adDto);
        return modelAndView;
    }



           @RequestMapping(value="/ads")
    public ModelAndView list(final HttpServletRequest request, final CookieLocaleResolver clr, final Errors errors,
                             final ModelAndView modelAndView,
                             @RequestParam("page") Optional<Integer> page,
                             @RequestParam("pageSize") Optional<Integer> size) {



        int currentPage = page.orElse(INITIAL_PAGE);
        if ( currentPage == 0 ) { currentPage = INITIAL_PAGE; modelAndView.addObject("page", INITIAL_PAGE);
        } else {modelAndView.addObject("page", currentPage);}
        int pageSize = size.orElse(INITIAL_PAGE_SIZE);

        Page<Ad> adPage = adService.findPaginated(PageRequest.of(currentPage - 1, pageSize));

        //adPage.toList().get(0).getPhotos().
        if ( adPage.isEmpty() ) { currentPage --; adPage = adService.findPaginated(PageRequest.of(currentPage - 1, pageSize));}

        Pager pager = new Pager(adPage.getTotalPages(), currentPage, BUTTONS_TO_SHOW);
        modelAndView.addObject("pager", pager);

        modelAndView.addObject("adPage", adPage);

           int totalPages = adPage.getTotalPages();
           if (totalPages > 0) {
               List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                       .boxed()
                       .collect(Collectors.toList());
               modelAndView.addObject("pageNumbers", pageNumbers);
           }

           modelAndView.addObject("pageSize", pageSize);


        modelAndView.addObject("cntr", 0);

        modelAndView.setViewName("index");

        return modelAndView;
    }



           @RequestMapping(value = "/savePhoto", method = RequestMethod.POST)
           @ResponseBody
    public String SavePhoto(@RequestParam("file") MultipartFile[] files) {

        String name = "name";
        LOGGER.debug("Saving photos from drop zone to gallery on server");

        User currentUser;

        if ( !hasRole("USER") ) {currentUser = userService.findUserByEmail("test@test.com");}//userRepository.findByEmail("test@test.com");}
        else {currentUser = userService.findUserByEmail(((UserDetails)(SecurityContextHolder.getContext().getAuthentication()).getPrincipal()).getUsername());}


        String subFolder = currentUser.getEmail();
        subFolder = subFolder.replace(".", "_");

        String prefix = env.getProperty("uploadPhoto.folder.subPrefix") + subFolder + "/";

        File dir = new File(prefix);
        if (!dir.exists()) {dir.mkdir();}



            if (!files[0].isEmpty()) {

                for (MultipartFile file : files) {

                    String origFileName = file.getOriginalFilename();
                    String extension = "";
                    if(origFileName!=null){ extension = origFileName.substring(origFileName.indexOf("."));}
                    String currentPhotoUrl;
                    try {
                        byte[] bytes = file.getBytes();
                        BufferedOutputStream stream =
                                new BufferedOutputStream(new FileOutputStream(new File(currentPhotoUrl = (prefix + generateNewPhotoName() + extension))));//file.getOriginalFilename())));
                        stream.write(bytes);
                        stream.close();
                        tempPhotoUrls.add(currentPhotoUrl);             //OPT state of controller bean

                        UserPhoto currentUserPhoto = new UserPhoto();
                        currentUserPhoto.setUrl(currentPhotoUrl);
                        currentUserPhoto = userPhotoService.saveAnotherUserPhoto(currentUserPhoto);
                        currentUser.userPhotos.add(currentUserPhoto);
                        unsavedButLoadedPhotos.add(currentUserPhoto);   //OPT state of controller bean
                        userService.saveRegisteredUser(currentUser);
                        name = origFileName + " => " + currentPhotoUrl;
                        return "Вы удачно загрузили " + origFileName + " в " + currentPhotoUrl + " - uploaded !";
                    } catch (Exception e) {
                        return "Вам не удалось загрузить " + name + " => " + e.getMessage();
                    }

                }

            } else{
                return "Вам не удалось загрузить " + name + " потому что файл пустой.";
            }

        return "";
    }


    //util
    private UUID generateNewPhotoName() {
        return UUID.randomUUID();
    }


    private boolean hasRole(String role) {    //Collection<? extends GrantedAuthority> authorities, String role) {
        String currentRole = "ROLE_";
        if ( role != null ) {currentRole += role;}
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        for (GrantedAuthority authority : authorities) {

            if ( currentRole.equalsIgnoreCase(authority.getAuthority()) ) {
                return true;
            }
        }
        return false;
    }
}

