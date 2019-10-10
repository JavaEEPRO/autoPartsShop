package si.inspirited.persistence.model.uniqueEntities;

import javax.persistence.*;

@Entity
@Table(name = "inf_photo")
public class Photo {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String url;

//    private Boolean isUsersMain;
//    private Boolean isAds

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
