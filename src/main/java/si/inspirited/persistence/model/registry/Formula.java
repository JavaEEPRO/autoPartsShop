package si.inspirited.persistence.model.registry;

import si.inspirited.persistence.model.registry.teeth.Tooth;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Formula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    Patient patient;

    LocalDateTime whenSnapshotted;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "formulas_all_teeth", joinColumns = @JoinColumn(name = "formulas_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "teeth_id", referencedColumnName = "id"))
    List<Tooth> presentNow;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "formulas_bearing_teeth", joinColumns = @JoinColumn(name = "formulas_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "bearing_teeth_id", referencedColumnName = "id"))
    List<Tooth> forBearingThisConstruction;

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

    public List<Tooth> getPresentNow() {
        return presentNow;
    }

    public void setPresentNow(List<Tooth> presentNow) {
        this.presentNow = presentNow;
    }

    public List<Tooth> getForBearingThisConstruction() {
        return forBearingThisConstruction;
    }

    public void setForBearingThisConstruction(List<Tooth> forBearingThisConstruction) {
        this.forBearingThisConstruction = forBearingThisConstruction;
    }

    public LocalDateTime getWhenSnapshotted() {
        return whenSnapshotted;
    }

    public void setWhenSnapshotted(LocalDateTime whenSnapshotted) {
        this.whenSnapshotted = whenSnapshotted;
    }
}
