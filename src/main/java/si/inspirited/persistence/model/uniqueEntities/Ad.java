package si.inspirited.persistence.model.uniqueEntities;

import si.inspirited.persistence.model.User;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "inf_ad")
public class Ad {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name; //title

    @ManyToOne
    private User user;  //Au+hor

    private Date creationDate;
    private Date expiryDate;

    @OneToOne
    private Kind kind;

    //@LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(fetch = FetchType.LAZY) //mappedBy = "inf_category")
    @JoinTable(name = "inf_ads_categories", joinColumns = @JoinColumn(name = "inf_ad_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "inf_category_id", referencedColumnName = "id"))
    private Collection<Category> categories;

    private String description;

    private String body;

    private String address;

    @OneToOne
    private Photo mainPhoto;

    //@LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(fetch = FetchType.LAZY) //mappedBy = "inf_photo")
    @JoinTable(name = "inf_ads_photos", joinColumns = @JoinColumn(name = "inf_ad_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "inf_photo_id", referencedColumnName = "id"))
    private Collection<Photo> photos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    public Collection<Category> getCategories() {
        return categories;
    }

    public void setCategories(Collection<Category> categories) {
        this.categories = categories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Photo getMainPhoto() {
        return mainPhoto;
    }

    public void setMainPhoto(Photo mainPhoto) {
        this.mainPhoto = mainPhoto;
    }

    public Collection<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Collection<Photo> photos) {
        this.photos = photos;
    }
}
