package si.inspirited.persistence.model.registry;

import si.inspirited.persistence.model.registry.pagesObj.PatientRsrch1;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Patient {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    Boolean suffersPain;

    String clinicName;
    String clinicAddress;
    Integer clinicEdrpou;

    Long registryNumber;

    /*new fields added*/

    String xraysDir;        // xray's directory, where to look for on remote machine, VISIODENT IMAGING сat.#

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "patients_doctors", joinColumns = @JoinColumn(name = "patients_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "doctors_id", referencedColumnName = "id"))
    List<Doctor> doctors;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "patient_imprints", joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "imprints_id", referencedColumnName = "id"))
    List<Imprint> imprints;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "patient_tooth", joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "tooth_id", referencedColumnName = "id"))
    List<Tooth> teeth;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "patient_roots", joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "roots_id", referencedColumnName = "id"))
    List<Root> roots;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "patient_channels", joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "channels_id", referencedColumnName = "id"))
    List<Channel> channels;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "patient_examinations", joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "examinations_id", referencedColumnName = "id"))
    public List<PatientExamination> examinations; //visits

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "index_patients_doctors", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "inf_user_photo_id", referencedColumnName = "id"))
//    Collection<User> doctors;
    /*end of new fields added*/

    Integer year;           //created

    String firstName;       //имя
    String secondName;      //отчество
    String lastName;        //фамилия

    boolean gender;         //true=men

    LocalDateTime birthDay;

    String address;

    String phone;

    String diagnosis;

    String complaints;

    String transferredAndConcomitantDiseases;
    String growthOfPresentDisease;


    //end of the first page

    //#2
    @OneToOne
    PatientRsrch1 patientRsrch1;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public String getClinicAddress() {
        return clinicAddress;
    }

    public void setClinicAddress(String clinicAddress) {
        this.clinicAddress = clinicAddress;
    }

    public Integer getClinicEdrpou() {
        return clinicEdrpou;
    }

    public void setClinicEdrpou(Integer clinicEdrpou) {
        this.clinicEdrpou = clinicEdrpou;
    }

    public Long getRegistryNumber() {
        return registryNumber;
    }

    public void setRegistryNumber(Long registryNumber) {
        this.registryNumber = registryNumber;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }


    public LocalDateTime getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDateTime birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getComplaints() {
        return complaints;
    }

    public void setComplaints(String complaints) {
        this.complaints = complaints;
    }

    public String getTransferredAndConcomitantDiseases() {
        return transferredAndConcomitantDiseases;
    }

    public void setTransferredAndConcomitantDiseases(String transferredAndConcomitantDiseases) {
        this.transferredAndConcomitantDiseases = transferredAndConcomitantDiseases;
    }

    public String getGrowthOfPresentDisease() {
        return growthOfPresentDisease;
    }

    public void setGrowthOfPresentDisease(String growthOfPresentDisease) {
        this.growthOfPresentDisease = growthOfPresentDisease;
    }




    //new fields added

    public String getXraysDir() {
        return xraysDir;
    }

    public void setXraysDir(String xraysDir) {
        this.xraysDir = xraysDir;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

//    public Collection<String> getDoctors() {
//        return doctors;
//    }
//
//    public void setDoctors(Collection<String> doctors) {
//        this.doctors = doctors;
//    }

    public List<PatientExamination> getExaminations() {
        return examinations;
    }

    public void setExaminations(List<PatientExamination> examinations) {
        this.examinations = examinations;
    }


    public Boolean isSuffersPain() {
        return suffersPain;
    }

    public Boolean getSuffersPain() {
        return suffersPain;
    }

    public void setSuffersPain(Boolean suffersPain) {
        this.suffersPain = suffersPain;
    }


    public List<Imprint> getImprints() {
        return imprints;
    }

    public void setImprints(List<Imprint> imprints) {
        this.imprints = imprints;
    }

    public List<Tooth> getTeeth() {
        return teeth;
    }

    public void setTeeth(List<Tooth> teeth) {
        this.teeth = teeth;
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


    public PatientRsrch1 getPatientRsrch1() {
        return patientRsrch1;
    }

    public void setPatientRsrch1(PatientRsrch1 patientRsrch1) {
        this.patientRsrch1 = patientRsrch1;
    }

    //
    public boolean isNew() {
        return this.id == null;
    }
}
