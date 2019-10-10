package si.inspirited.persistence.model.registry;

import si.inspirited.persistence.model.registry.teeth.Tooth;

import javax.persistence.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Xray {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    LocalDateTime taken;

    URL img;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "xrays_teeth", joinColumns = @JoinColumn(name = "xray_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "tooth_id", referencedColumnName = "id"))
    List<Tooth> teeth;

    String message;

    //

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTaken() {
        return taken;
    }

    public void setTaken(LocalDateTime taken) {
        this.taken = taken;
    }

    public URL getImg() {
        return img;
    }

    public void setImg(URL img) {
        this.img = img;
    }

    public List<Tooth> getTeeth() {
        return teeth;
    }

    public void setTeeth(List<Tooth> teeth) {
        this.teeth = teeth;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
