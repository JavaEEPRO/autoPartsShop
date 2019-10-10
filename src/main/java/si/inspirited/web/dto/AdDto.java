package si.inspirited.web.dto;

import si.inspirited.persistence.model.uniqueEntities.Photo;

import java.util.Collection;

public class AdDto {

    //@NotNull
    //@Size(min = 1, message = "{Size.userDto.firstName}")
    private String name;

    private String kind;

    private String categories; //OPT!!!

    private String description;

    //@NotNull
    //@Size(min = 1, message = "{Size.userDto.lastName}")
    private String body;

    private Collection<Photo> photos;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
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

    public Collection<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Collection<Photo> photos) {
        this.photos = photos;
    }
}
