package si.inspirited.persistence.model.registry;

import si.inspirited.persistence.model.registry.enums.Localizations;
import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.VerticalLocalizations;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import javax.persistence.*;
import java.util.List;

@Entity
public class Target {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    Patient patient;

    @ManyToOne
    Doctor doctor;

    @ManyToOne
    Tooth tooth;

    @ElementCollection(targetClass = Localizations.class)
    @Column(name = "localizations", nullable = false)
    @Enumerated(EnumType.STRING)
    List<Surfaces> surfaces;

    @ElementCollection(targetClass = Localizations.class)
    @Column(name = "localizations", nullable = false)
    @Enumerated(EnumType.STRING)
    List<Localizations> localizations;

    @Enumerated(EnumType.STRING)
    VerticalLocalizations verticalLocalization;



    Boolean rootTargeted;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "targets_roots", joinColumns = @JoinColumn(name = "targets_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "roots_id", referencedColumnName = "id"))
    List<Root> roots;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "targets_channels", joinColumns = @JoinColumn(name = "targets_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "channels_id", referencedColumnName = "id"))
    List<Channel> channels;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "target_commits", joinColumns = @JoinColumn(name = "target_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "commits_id", referencedColumnName = "id"))
    List<Commit> targetHistory;

    //

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Tooth getTooth() {
        return tooth;
    }

    public void setTooth(Tooth tooth) {
        this.tooth = tooth;
    }

    public List<Surfaces> getSurfaces() {
        return surfaces;
    }

    public void setSurfaces(List<Surfaces> surfaces) {
        this.surfaces = surfaces;
    }

    public List<Localizations> getLocalizations() {
        return localizations;
    }

    public void setLocalizations(List<Localizations> localizations) {
        this.localizations = localizations;
    }

    public VerticalLocalizations getVerticalLocalization() {
        return verticalLocalization;
    }

    public void setVerticalLocalization(VerticalLocalizations verticalLocalization) {
        this.verticalLocalization = verticalLocalization;
    }

    public Boolean getRootTargeted() {
        return rootTargeted;
    }

    public void setRootTargeted(Boolean rootTargeted) {
        this.rootTargeted = rootTargeted;
    }

    public List<Root> getRoots() {
        return roots;
    }

    public void setRoots(List<Root> roots) {
        this.roots = roots;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    public List<Commit> getTargetHistory() {
        return targetHistory;
    }

    public void setTargetHistory(List<Commit> targetHistory) {
        this.targetHistory = targetHistory;
    }
}
