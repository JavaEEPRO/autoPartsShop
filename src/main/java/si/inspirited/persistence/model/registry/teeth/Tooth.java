package si.inspirited.persistence.model.registry.teeth;

import si.inspirited.persistence.model.registry.*;
import si.inspirited.persistence.model.registry.enums.Localizations;
import si.inspirited.persistence.model.registry.enums.State;
import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Tooth {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    Patient patient;

    boolean painful;

    @Enumerated(EnumType.STRING)
    Teeth name;
    Integer index;

    String description;

    @Enumerated(EnumType.STRING)
    State currentState;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tooth_targets", joinColumns = @JoinColumn(name = "tooth_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "targets_id", referencedColumnName = "id"))
    List<Target> targets;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tooth_commits", joinColumns = @JoinColumn(name = "tooth_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "commits_id", referencedColumnName = "id"))
    List<Commit> toothHistory;

    Boolean absentCompletelly;                  // true if tooth is removed at all

    Boolean brokenButRoot;
    LocalDateTime forPinImprintTaken;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "xrays_teeth", joinColumns = @JoinColumn(name = "tooth_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "xray_id", referencedColumnName = "id"))
    List<Xray> xrays;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "examinations_teeth", joinColumns = @JoinColumn(name = "tooth_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "examination_id", referencedColumnName = "id"))
    List<PatientExamination> examinationsWhenWasTargetted;

    //

    @ElementCollection(targetClass = Localizations.class)
    @Column(name = "localizations", nullable = false)
    @Enumerated(EnumType.STRING)
    List<Surfaces> surfaces;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tooth_roots", joinColumns = @JoinColumn(name = "tooth_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "root_id", referencedColumnName = "id"))
    List<Root> roots;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tooth_channels", joinColumns = @JoinColumn(name = "tooth_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "channel_id", referencedColumnName = "id"))
    List<Channel> channels;

    public boolean frontal;

    public boolean isForPinImprintTakenYet() {
        return forPinImprintTaken != null;
    }


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

    public boolean isPainful() {
        return painful;
    }

    public void setPainful(boolean painful) {
        this.painful = painful;
    }

    public Teeth getName() {
        return name;
    }

    public void setName(Teeth name) {
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Target> getTargets() {
        return targets;
    }

    public void setTargets(List<Target> targets) {
        this.targets = targets;
    }

    public List<Commit> getToothHistory() {
        return toothHistory;
    }

    public void setToothHistory(List<Commit> toothHistory) {
        this.toothHistory = toothHistory;
    }

    public Boolean getAbsentCompletelly() {
        return absentCompletelly;
    }

    public void setAbsentCompletelly(Boolean absentCompletelly) {
        this.absentCompletelly = absentCompletelly;
    }

    public Boolean getBrokenButRoot() {
        return brokenButRoot;
    }

    public void setBrokenButRoot(Boolean brokenButRoot) {
        this.brokenButRoot = brokenButRoot;
    }

    public LocalDateTime getForPinImprintTaken() {
        return forPinImprintTaken;
    }

    public void setForPinImprintTaken(LocalDateTime forPinImprintTaken) {
        this.forPinImprintTaken = forPinImprintTaken;
    }

    public List<Xray> getXrays() {
        return xrays;
    }

    public void setXrays(List<Xray> xrays) {
        this.xrays = xrays;
    }

    public List<PatientExamination> getExaminationsWhenWasTargetted() {
        return examinationsWhenWasTargetted;
    }

    public void setExaminationsWhenWasTargetted(List<PatientExamination> examinationsWhenWasTargetted) {
        this.examinationsWhenWasTargetted = examinationsWhenWasTargetted;
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

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public List<Surfaces> getSurfaces() {
        return surfaces;
    }

    public void setSurfaces(List<Surfaces> surfaces) {
        this.surfaces = surfaces;
    }

    public boolean isFrontal() {
//        return frontal;
        return !surfaces.contains(Surfaces.CHEWING);
    }

    public void setFrontal(boolean frontal) {
        this.frontal = frontal;
    }

    /*
    *
        Tooth wisdom18 = new Tooth();
            wisdom18.setIndex(18);
            wisdom18.setName(Teeth.WISDOM_TOOTH);

            Root root18a = new Root();
            Channel channel18a1 = new Channel();
            List<Channel> channels18a = new ArrayList();
            channels18a.add(channel18a1);
            root18a.setChannels(channels18a);

            Root root18b = new Root();
            Channel channel18b1 = new Channel();
            List<Channel> channels18b = new ArrayList();
            channels18b.add(channel18b1);
            root18b.setChannels(channels18b);

            Root root18c = new Root();
            Channel channel18c1 = new Channel();
            List<Channel> channels18c = new ArrayList();
            channels18c.add(channel18c1);
            root18c.setChannels(channels18c);

            List<Channel> wisdom18totChann = new ArrayList<>();
            wisdom18totChann.addAll(channels18a);
            wisdom18totChann.addAll(channels18b);
            wisdom18totChann.addAll(channels18c);
            wisdom18.setChannels(wisdom18totChann);

            List<Root> wisdom18TotRoots = new ArrayList<>();
            wisdom18TotRoots.add(root18a);
            wisdom18TotRoots.add(root18b);
            wisdom18TotRoots.add(root18c);
            wisdom18.setRoots(wisdom18TotRoots);


        Tooth secondMolar17 = new Tooth();
            secondMolar17.setIndex(17);
            secondMolar17.setName(Teeth.SECOND_MOLAR);

            Root root17a = new Root();
            Channel channel17a1 = new Channel();
            List<Channel> channels17a = new ArrayList();
            channels17a.add(channel17a1);
            root17a.setChannels(channels17a);

            Root root17b = new Root();
            Channel channel17b1 = new Channel();
            List<Channel> channels17b = new ArrayList();
            channels17b.add(channel17b1);
            root17b.setChannels(channels17b);

            Root root17c = new Root();
            Channel channel17c1 = new Channel();
            List<Channel> channels17c = new ArrayList();
            channels17c.add(channel17c1);
            root17c.setChannels(channels17c);

            List<Channel> secondMolar17totChann = new ArrayList<>();
            secondMolar17totChann.addAll(channels17a);
            secondMolar17totChann.addAll(channels17b);
            secondMolar17totChann.addAll(channels17c);
            secondMolar17.setChannels(secondMolar17totChann);

            List<Root> secondMolar17TotRoots = new ArrayList<>();
            secondMolar17TotRoots.add(root17a);
            secondMolar17TotRoots.add(root17b);
            secondMolar17TotRoots.add(root17c);
            secondMolar17.setRoots(secondMolar17TotRoots);

        Tooth firstMolar16 = new Tooth();
            firstMolar16.setIndex(16);
            firstMolar16.setName(Teeth.FIRST_MOLAR);

            Root root16a = new Root();
            Channel channel16a1 = new Channel();
            List<Channel> channels16a = new ArrayList();
            channels16a.add(channel16a1);
            root16a.setChannels(channels16a);

            Root root16b = new Root();
            Channel channel16b1 = new Channel();
            List<Channel> channels16b = new ArrayList();
            channels16b.add(channel16b1);
            root16b.setChannels(channels16b);

            Root root16c = new Root();
            Channel channel16c1 = new Channel();
            List<Channel> channels16c = new ArrayList();
            channels16c.add(channel16c1);
            root16c.setChannels(channels16c);

            List<Channel> firstMolar16totChann = new ArrayList<>();
            firstMolar16totChann.addAll(channels16a);
            firstMolar16totChann.addAll(channels16b);
            firstMolar16totChann.addAll(channels16c);
            firstMolar16.setChannels(firstMolar16totChann);

            List<Root> firstMolar16TotRoots = new ArrayList<>();
            firstMolar16TotRoots.add(root16a);
            firstMolar16TotRoots.add(root16b);
            firstMolar16TotRoots.add(root16c);
            firstMolar16.setRoots(firstMolar16TotRoots);


        Tooth secondPremolar15 = new Tooth();
            secondPremolar15.setIndex(15);
            secondPremolar15.setName(Teeth.SECOND_PREMOLAR);

            Root root15a = new Root();
            Channel channel15a1 = new Channel();
            List<Channel> channels15a = new ArrayList();
            channels15a.add(channel15a1);
            root15a.setChannels(channels15a);

            List<Channel> secondPremolar15totChann = new ArrayList<>();
            secondPremolar15totChann.addAll(channels15a);
            secondPremolar15.setChannels(secondPremolar15totChann);

            List<Root> secondPremolar15TotRoots = new ArrayList<>();
            secondPremolar15TotRoots.add(root15a);
            secondPremolar15.setRoots(secondPremolar15TotRoots);


        Tooth firstPremolar14 = new Tooth();
            firstPremolar14.setIndex(14);
            firstPremolar14.setName(Teeth.FIRST_PREMOLAR);

            Root root14a = new Root();
            Channel channel14a1 = new Channel();
            List<Channel> channels14a = new ArrayList();
            channels14a.add(channel14a1);
            root14a.setChannels(channels14a);

            Root root14b = new Root();
            Channel channel14b1 = new Channel();
            List<Channel> channels14b = new ArrayList();
            channels14b.add(channel14b1);
            root14b.setChannels(channels14b);

            List<Channel> firstPremolar14totChann = new ArrayList<>();
            firstPremolar14totChann.addAll(channels14a);
            firstPremolar14totChann.addAll(channels14b);
            firstPremolar14.setChannels(firstPremolar14totChann);

            List<Root> firstPremolar14TotRoots = new ArrayList<>();
            firstPremolar14TotRoots.add(root14a);
            firstPremolar14TotRoots.add(root14b);
            firstPremolar14.setRoots(firstPremolar14TotRoots);


        Tooth fang13 = new Tooth();
            fang13.setIndex(13);
            fang13.setName(Teeth.FANG);

            Root root13a = new Root();
            Channel channel13a1 = new Channel();
            List<Channel> channels13a = new ArrayList();
            channels13a.add(channel13a1);
            root13a.setChannels(channels13a);

            List<Channel> fang13totChann = new ArrayList<>();
            fang13totChann.addAll(channels13a);
            fang13.setChannels(fang13totChann);

            List<Root> fang13TotRoots = new ArrayList<>();
            fang13TotRoots.add(root13a);
            fang13.setRoots(fang13TotRoots);

        Tooth medialCutter12 = new Tooth();
            medialCutter12.setIndex(12);
            medialCutter12.setName(Teeth.MEDIAL_CUTTER);

            Root root12a = new Root();
            Channel channel12a1 = new Channel();
            List<Channel> channels12a = new ArrayList();
            channels12a.add(channel12a1);
            root12a.setChannels(channels12a);

            List<Channel> medialCutter12totChann = new ArrayList<>();
            medialCutter12totChann.addAll(channels12a);
            medialCutter12.setChannels(medialCutter12totChann);

            List<Root> medialCutter12TotRoots = new ArrayList<>();
            medialCutter12TotRoots.add(root12a);
            medialCutter12.setRoots(medialCutter12TotRoots);

        Tooth centralCutter11 = new Tooth();
            centralCutter11.setIndex(11);
            centralCutter11.setName(Teeth.CENTRAL_CUTTER);

            Root root11a = new Root();
            Channel channel11a1 = new Channel();
            List<Channel> channels11a = new ArrayList();
            channels11a.add(channel11a1);
            root11a.setChannels(channels11a);

            List<Channel> centralCutter11totChann = new ArrayList<>();
            centralCutter11totChann.addAll(channels11a);
            centralCutter11.setChannels(centralCutter11totChann);

            List<Root> centralCutter11TotRoots = new ArrayList<>();
            centralCutter11TotRoots.add(root11a);
            centralCutter11.setRoots(centralCutter11TotRoots);

        Tooth centralCutter21 = new Tooth();
            centralCutter21.setIndex(21);
            centralCutter21.setName(Teeth.CENTRAL_CUTTER);

            Root root21a = new Root();
            Channel channel21a1 = new Channel();
            List<Channel> channels21a = new ArrayList();
            channels21a.add(channel21a1);
            root21a.setChannels(channels21a);

            List<Channel> centralCutter21totChann = new ArrayList<>();
            centralCutter21totChann.addAll(channels21a);
            centralCutter21.setChannels(centralCutter21totChann);

            List<Root> centralCutter21TotRoots = new ArrayList<>();
            centralCutter21TotRoots.add(root21a);
            centralCutter21.setRoots(centralCutter21TotRoots);


        Tooth medialCutter22 = new Tooth();
            medialCutter22.setIndex(22);
            medialCutter22.setName(Teeth.MEDIAL_CUTTER);

            Root root22a = new Root();
            Channel channel22a1 = new Channel();
            List<Channel> channels22a = new ArrayList();
            channels22a.add(channel22a1);
            root22a.setChannels(channels22a);

            List<Channel> medialCutter22totChann = new ArrayList<>();
            medialCutter22totChann.addAll(channels22a);
            medialCutter22.setChannels(medialCutter22totChann);

            List<Root> medialCutter22TotRoots = new ArrayList<>();
            medialCutter22TotRoots.add(root22a);
            medialCutter22.setRoots(medialCutter22TotRoots);

        Tooth fang23 = new Tooth();
            fang23.setIndex(23);
            fang23.setName(Teeth.FANG);

            Root root23a = new Root();
            Channel channel23a1 = new Channel();
            List<Channel> channels23a = new ArrayList();
            channels23a.add(channel23a1);
            root23a.setChannels(channels23a);

            List<Channel> fang23totChann = new ArrayList<>();
            fang23totChann.addAll(channels23a);
            fang23.setChannels(fang23totChann);

            List<Root> fang23TotRoots = new ArrayList<>();
            fang23TotRoots.add(root23a);
            fang23.setRoots(fang23TotRoots);




        Tooth firstPremolar24 = new Tooth();
            firstPremolar24.setIndex(24);
            firstPremolar24.setName(Teeth.FIRST_PREMOLAR);

            Root root24a = new Root();
            Channel channel24a1 = new Channel();
            List<Channel> channels24a = new ArrayList();
            channels24a.add(channel24a1);
            root24a.setChannels(channels24a);

            Root root24b = new Root();
            Channel channel24b1 = new Channel();
            List<Channel> channels24b = new ArrayList();
            channels24b.add(channel24b1);
            root24b.setChannels(channels24b);

            List<Channel> firstPremolar24totChann = new ArrayList<>();
            firstPremolar24totChann.addAll(channels24a);
            firstPremolar24totChann.addAll(channels24b);
            firstPremolar24.setChannels(firstPremolar24totChann);

            List<Root> firstPremolar24TotRoots = new ArrayList<>();
            firstPremolar24TotRoots.add(root24a);
            firstPremolar24TotRoots.add(root24b);
            firstPremolar24.setRoots(firstPremolar24TotRoots);



        Tooth secondPremolar25 = new Tooth();
            secondPremolar25.setIndex(25);
            secondPremolar25.setName(Teeth.SECOND_PREMOLAR);

            Root root25a = new Root();
            Channel channel25a1 = new Channel();
            List<Channel> channels25a = new ArrayList();
            channels25a.add(channel25a1);
            root25a.setChannels(channels25a);

            List<Channel> secondPremolar25totChann = new ArrayList<>();
            secondPremolar25totChann.addAll(channels25a);
            secondPremolar25.setChannels(secondPremolar25totChann);

            List<Root> secondPremolar25TotRoots = new ArrayList<>();
            secondPremolar25TotRoots.add(root25a);
            secondPremolar25.setRoots(secondPremolar25TotRoots);



        Tooth firstMolar26 = new Tooth();
            firstMolar26.setIndex(26);
            firstMolar26.setName(Teeth.FIRST_MOLAR);

            Root root26a = new Root();
            Channel channel26a1 = new Channel();
            List<Channel> channels26a = new ArrayList();
            channels26a.add(channel26a1);
            root26a.setChannels(channels26a);

            Root root26b = new Root();
            Channel channel26b1 = new Channel();
            List<Channel> channels26b = new ArrayList();
            channels26b.add(channel26b1);
            root26b.setChannels(channels26b);

            Root root26c = new Root();
            Channel channel26c1 = new Channel();
            List<Channel> channels26c = new ArrayList();
            channels26c.add(channel26c1);
            root26c.setChannels(channels26c);

            List<Channel> firstMolar26totChann = new ArrayList<>();
            firstMolar26totChann.addAll(channels26a);
            firstMolar26totChann.addAll(channels26b);
            firstMolar26totChann.addAll(channels26c);
            firstMolar26.setChannels(firstMolar26totChann);

            List<Root> firstMolar26TotRoots = new ArrayList<>();
            firstMolar26TotRoots.add(root26a);
            firstMolar26TotRoots.add(root26b);
            firstMolar26TotRoots.add(root26c);
            firstMolar26.setRoots(firstMolar26TotRoots);



        Tooth secondMolar27 = new Tooth();
            secondMolar27.setIndex(27);
            secondMolar27.setName(Teeth.SECOND_MOLAR);

            Root root27a = new Root();
            Channel channel27a1 = new Channel();
            List<Channel> channels27a = new ArrayList();
            channels27a.add(channel27a1);
            root27a.setChannels(channels27a);

            Root root27b = new Root();
            Channel channel27b1 = new Channel();
            List<Channel> channels27b = new ArrayList();
            channels27b.add(channel27b1);
            root27b.setChannels(channels27b);

            Root root27c = new Root();
            Channel channel27c1 = new Channel();
            List<Channel> channels27c = new ArrayList();
            channels27c.add(channel27c1);
            root27c.setChannels(channels27c);

            List<Channel> secondMolar27totChann = new ArrayList<>();
            secondMolar27totChann.addAll(channels27a);
            secondMolar27totChann.addAll(channels27b);
            secondMolar27totChann.addAll(channels27c);
            secondMolar27.setChannels(secondMolar27totChann);

            List<Root> secondMolar27TotRoots = new ArrayList<>();
            secondMolar27TotRoots.add(root27a);
            secondMolar27TotRoots.add(root27b);
            secondMolar27TotRoots.add(root27c);
            secondMolar27.setRoots(secondMolar27TotRoots);


        Tooth wisdom28 = new Tooth();
            wisdom28.setIndex(28);
            wisdom28.setName(Teeth.WISDOM_TOOTH);

            Root root28a = new Root();
            Channel channel28a1 = new Channel();
            List<Channel> channels28a = new ArrayList();
            channels28a.add(channel28a1);
            root28a.setChannels(channels28a);

            Root root28b = new Root();
            Channel channel28b1 = new Channel();
            List<Channel> channels28b = new ArrayList();
            channels28b.add(channel28b1);
            root28b.setChannels(channels28b);

            Root root28c = new Root();
            Channel channel28c1 = new Channel();
            List<Channel> channels28c = new ArrayList();
            channels28c.add(channel28c1);
            root28c.setChannels(channels28c);

            List<Channel> wisdom28totChann = new ArrayList<>();
            wisdom28totChann.addAll(channels28a);
            wisdom28totChann.addAll(channels28b);
            wisdom28totChann.addAll(channels28c);
            wisdom28.setChannels(wisdom28totChann);

            List<Root> wisdom28TotRoots = new ArrayList<>();
            wisdom28TotRoots.add(root28a);
            wisdom28TotRoots.add(root28b);
            wisdom28TotRoots.add(root28c);
            wisdom28.setRoots(wisdom28TotRoots);
    * */
}
