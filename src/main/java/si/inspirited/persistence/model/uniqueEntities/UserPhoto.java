package si.inspirited.persistence.model.uniqueEntities;

import javax.persistence.*;

@Entity
@Table(name = "inf_user_photo")
public class UserPhoto {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String url;

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
