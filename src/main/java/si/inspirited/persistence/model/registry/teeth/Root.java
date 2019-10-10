package si.inspirited.persistence.model.registry.teeth;

import si.inspirited.persistence.model.registry.Target;
import si.inspirited.persistence.model.registry.enums.Localizations;

import javax.persistence.*;
import java.util.List;

@Entity
public class Root {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    Tooth tooth;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "root_channels", joinColumns = @JoinColumn(name = "root_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "channels_id", referencedColumnName = "id"))
    List<Channel> channels;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "targets_roots", joinColumns = @JoinColumn(name = "roots_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "targets_id", referencedColumnName = "id"))
    List<Target> targets;

    @ElementCollection(targetClass = Localizations.class)
    @Column(name = "localizations", nullable = false)
    @Enumerated(EnumType.STRING)
    List<Localizations> localizations;

    Boolean absentCompletelly;

    //


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tooth getTooth() {
        return tooth;
    }

    public void setTooth(Tooth tooth) {
        this.tooth = tooth;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    public List<Localizations> getLocalizations() {
        return localizations;
    }

    public void setLocalizations(List<Localizations> localizations) {
        this.localizations = localizations;
    }

    public Boolean getAbsentCompletelly() {
        return absentCompletelly;
    }

    public void setAbsentCompletelly(Boolean absentCompletelly) {
        this.absentCompletelly = absentCompletelly;
    }
}
