package si.inspirited.web.dto;

import si.inspirited.persistence.model.registry.Doctor;
import si.inspirited.persistence.model.registry.Imprint;
import si.inspirited.persistence.model.registry.PatientExamination;
import si.inspirited.persistence.model.registry.pagesObj.PatientRsrch1;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.List;

public class PatientDto {



    Long id;

    String clinicName;
    String clinicAddress;
    Integer clinicEdrpou;


    Long registryNumber;

    /*new fields added*/
    String currentDoctor;


    Integer year;           //created

    String firstName;       //имя
    String secondName;      //отчество
    String lastName;        //фамилия

    boolean gender;         //true=men

    LocalDateTime birthDay;
    String strReprOfBirthDay;

    String address;

    String phone;

    String diagnosis;

    String complaints;

    String transferredAndConcomitantDiseases;
    String growthOfPresentDisease;





    /*new fields added*/

    Boolean suffersPain;

    String xraysDir;        // xray's directory, where to look for on remote machine, VISIODENT IMAGING сat.#


    List<Doctor> doctors;


    List<Imprint> imprints;


    List<Tooth> teeth;


    List<Root> roots;


    List<Channel> channels;


    public List<PatientExamination> examinations; //visits



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

        String res;
        String year = ("" + birthDay.getYear()).substring(2);
        String month = "" + birthDay.getMonth().getValue();
        if (month.length() < 2) { month = "0" + month; }
        String day = "" + birthDay.getDayOfMonth();
        if (day.length() < 2) { day = "0" + day; }

        res = day + month + year;

        this.strReprOfBirthDay = res;
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

    public String getCurrentDoctor() {
        return currentDoctor;
    }

    public void setCurrentDoctor(String currentDoctor) {
        this.currentDoctor = currentDoctor;
    }


    public Boolean getSuffersPain() {
        return suffersPain;
    }

    public void setSuffersPain(Boolean suffersPain) {
        this.suffersPain = suffersPain;
    }

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

    public List<PatientExamination> getExaminations() {
        return examinations;
    }

    public void setExaminations(List<PatientExamination> examinations) {
        this.examinations = examinations;
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


    public String getStrReprOfBirthDay() {
//        String res;
//        String year = ("" + birthDay.getYear()).substring(2);
//        String month = "" + birthDay.getMonth().getValue();
//        String day = "" + birthDay.getDayOfMonth();
//
//        res = year + month + day;
//
//        return res;

        return strReprOfBirthDay;
    }

    public void setStrReprOfBirthDay(String stringReprOfBirthDay) {
        LocalDateTime res;

        String prefix = "19";

        String year = stringReprOfBirthDay.substring(4);
        int iYear = Integer.parseInt(year);
        if (iYear < 36) {prefix = "20";}

        year = prefix + year;

        String month = stringReprOfBirthDay.substring(2,4);
        if (month.length() < 2) { month = "0" + month; }
        String day = stringReprOfBirthDay.substring(0,2);
        if (day.length() < 2) { day = "0" + day; }
        res = LocalDateTime.parse(year + "-" + month + "-" + day + "T00:00:00.000");



        //("" + birthDay.getYear()).substring(2);
//        String month = "" + birthDay.getMonth().getValue();
//        String day = "" + birthDay.getDayOfMonth();
//
//        res = year + month + day;

        this.birthDay = res;
        this.strReprOfBirthDay = stringReprOfBirthDay;
    }
}
