package si.inspirited.web.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import si.inspirited.persistence.model.registry.Doctor;
import si.inspirited.persistence.model.registry.Patient;
import si.inspirited.persistence.model.registry.PatientExamination;
import si.inspirited.persistence.model.registry.teeth.Tooth;
import si.inspirited.service.IPatientService;
import si.inspirited.web.dto.PatientDto;
import si.inspirited.web.dto.PatientRsrch1Dto;
import si.inspirited.web.util.ColumnFilter;
import si.inspirited.web.util.OnPrefixResponse;
import si.inspirited.web.util.generators.ToothGenerator;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.*;

@Controller
public class PatientController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private IPatientService patientService;

    @Autowired
    private Environment env;

    /*test*/

    @RequestMapping(value = "/h0me", method = RequestMethod.GET)
    public ModelAndView justHome() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("x", 123);
        modelAndView.setViewName("h0me");

        return modelAndView;
    }
    /*end of test*/

    @RequestMapping(value = "/patient/new", method = RequestMethod.GET)
    public ModelAndView newPatient(final HttpServletRequest request,
                                   final CookieLocaleResolver clr,
                                   final ModelAndView modelAndView) {

        LOGGER.debug("Rendering newPatient page.");
        Locale currentLocale = clr.resolveLocale(request);

        final PatientDto patientDto = new PatientDto();
        modelAndView.addObject("patient", patientDto);
        modelAndView.setViewName("newPatient");

        return modelAndView;
    }

    @RequestMapping(value="patient/new", method= RequestMethod.POST)
    public ModelAndView persistPatient(@Valid
                                       final PatientDto patientDto,
                                       final ModelAndView modelAndView,
                                       final HttpServletRequest request,
                                       final CookieLocaleResolver clr) {

        //System.out.println(patientDto.isNew());

        Patient res;
        res = patientService.persistNewPatient(patientDto);

        modelAndView.setViewName("newPatient");


        return modelAndView;
    }


    @RequestMapping(value = "/card/{regNumb}", method = RequestMethod.GET)
    public ModelAndView getCardByRegNumb(  @PathVariable
                                           long regNumb,
                                           final HttpServletRequest request,
                                           final CookieLocaleResolver clr,
                                           final ModelAndView modelAndView) {

        PatientDto patientDto = parsePatient(patientService.findByRegistryNumber(regNumb));

        //System.out.println(patientDto.isNew());

        modelAndView.addObject("patient", patientDto);
        modelAndView.setViewName("card");
        return modelAndView;
    }


    @RequestMapping(value = "/card/new", method = RequestMethod.GET)
    public ModelAndView initCreateCardForm(final HttpServletRequest request,
                                   final CookieLocaleResolver clr,
                                   final ModelAndView modelAndView) {

        LOGGER.debug("Rendering 'card' page in context of initCreateCardForm(...)");
        Locale currentLocale = clr.resolveLocale(request);

        final PatientDto patientDto = new PatientDto();
        final PatientRsrch1Dto patientRsrch1 = new PatientRsrch1Dto();
        patientDto.setGender(true);                         //default is man=true

        //System.out.println(patientDto.isNew());

        LocalDateTime localDateTime = LocalDateTime.now();
        patientDto.setYear(localDateTime.getYear());

        Long generatedVal;
        int criticalCounter = 0;
        while(isRegNumberAlreadyInUse(generatedVal = generateNewRegistryNumber())) {criticalCounter++;}
        patientDto.setRegistryNumber(generatedVal);
        //patientDto.setRegistryNumber(generateNewRegistryNumber());

        modelAndView.addObject("patient", patientDto);

        /*test*/

        /*internal test*/
        //patientDto.getTeeth().contains(si.inspirited.persistence.model.registry.enums.Surfaces.CHEWING);
        /*end of internal test*/

        List<PatientExamination> ex = new ArrayList<>();
        PatientExamination e = new PatientExamination();
        PatientExamination e2 = new PatientExamination();
        PatientExamination e3 = new PatientExamination();
        PatientExamination e4 = new PatientExamination();

        Doctor doc = new Doctor();
        Doctor doc2 = new Doctor();
        doc.setName("Гац М М");
        e.setDoctor(doc);
        e2.setDoctor(doc);
        e.setPlannedToStart(LocalDateTime.of(2020, 02, 03, 12, 45));
        e.setPlannedToFinish(LocalDateTime.of(2020, 02, 03, 13, 45));
        e.setStarted(LocalDateTime.of(2020, 02, 03, 13, 05));
        e.setFinished(LocalDateTime.of(2020, 02, 03, 14, 02));

        e2.setPlannedToStart(LocalDateTime.of(2018, 02, 03, 12, 45));
        e2.setPlannedToFinish(LocalDateTime.of(2018, 02, 03, 13, 45));
        e2.setStarted(LocalDateTime.of(2018, 02, 03, 13, 05));
        e2.setFinished(LocalDateTime.of(2018, 02, 03, 14, 02));

        e2.setPlannedToStart(LocalDateTime.of(2011, 02, 03, 03, 45));
        e2.setPlannedToFinish(LocalDateTime.of(2011, 02, 03, 13, 45));
        e2.setStarted(LocalDateTime.of(2011, 02, 03, 13, 05));
        e2.setFinished(LocalDateTime.of(2011, 02, 03, 14, 02));

        e.setShowAffected(true);
        ex.add(e);
        ex.add(e2);
        doc2.setName("Чедрик Катерина Михайлівна");
        e3.setDoctor(doc2);
        ex.add(e3);
        patientRsrch1.setExaminations(ex);

        /*internal test*/

        /*end of internal test*/

        modelAndView.addObject("dateTimeNowMinusWeek", LocalDateTime.now().minusDays(Long.parseLong(env.getProperty("editable.expires"))));

        patientDto.setTeeth(new ToothGenerator().generateNewDentition(currentLocale));

        List<Tooth> upperTeeth = new ArrayList<>();
        List<Tooth> downTeeth = new ArrayList<>();

        for(int i = 0; i < 16; i++) {
            upperTeeth.add(patientDto.getTeeth().get(i)!=null? patientDto.getTeeth().get(i) : new Tooth());
            downTeeth.add(patientDto.getTeeth().get(i+16)!=null? patientDto.getTeeth().get(i+16) : new Tooth());
        }

        modelAndView.addObject("patientRsrch1", patientRsrch1);
        modelAndView.addObject("upperTeeth", upperTeeth);
        modelAndView.addObject("downTeeth", downTeeth);
        modelAndView.addObject("criticalCounter", criticalCounter); // param used for debug only
        modelAndView.setViewName("card");

        return modelAndView;
    }



    @RequestMapping(value = "/card/save", method = RequestMethod.POST)
    public ModelAndView persistCard(@Valid
                                    final PatientDto patientDto,
                                    final ModelAndView modelAndView,
                                    final HttpServletRequest request,
                                    final CookieLocaleResolver clr) {



        Patient res;
        Long id;
        res = patientService.persistNewPatient(patientDto);
        if (res != null) {patientDto.setId(res.getId());}

        //System.out.println(res.isNew());

        modelAndView.addObject("patient", patientDto);

        if (res != null && res.getId() > 0) { id = res.getId(); }
        else { id = 0L;}
        modelAndView.addObject("id", id);



        modelAndView.setViewName("card");

        return modelAndView;
    }

    @RequestMapping(value = "/ambulCard/new", method = RequestMethod.GET)
    public ModelAndView initCreateAmbulatoryCardForm(final HttpServletRequest request,
                                           final CookieLocaleResolver clr,
                                           final ModelAndView modelAndView) {

        LOGGER.debug("Rendering 'ambulatoryCard' page in context of initCreateAmbulatoryCardForm(...)");
        //Locale currentLocale = clr.resolveLocale(request);

        final PatientDto patientDto = new PatientDto();

        LocalDateTime localDateTime = LocalDateTime.now();
        patientDto.setYear(localDateTime.getYear());
        Long generatedVal;
        while(isRegNumberAlreadyInUse(generatedVal = generateNewRegistryNumber())) {
            patientDto.setRegistryNumber(generatedVal);
        }


        modelAndView.addObject("patient", patientDto);
        modelAndView.setViewName("ambulatoryCard");

        return modelAndView;
    }

    @RequestMapping(value = "ambulCard/new", method = RequestMethod.POST)
    public ModelAndView persistAmbulatoryCard(@Valid
                                              final PatientDto patientDto,
                                              final ModelAndView modelAndView,
                                              final HttpServletRequest request,
                                              final CookieLocaleResolver clr) {

        Patient res;
        Long id = 0L;

        res = patientService.persistNewPatient(patientDto);
        if (res != null && res.getId() <= 0) {
            id = res.getId();
        }

        modelAndView.addObject("id", id);
        modelAndView.setViewName("ambulatoryCard");

        return modelAndView;
    }


    
    //util

    private Random rnd = new Random();

    private Long generateNewRegistryNumber() {
        Long res = rnd.nextLong();
        if (res < 0) { res = res * -1; }
        Long BILLION = 1000000000000000000L;
        int COEFFICIENT = Integer.parseInt(env.getProperty("reg.number.coefficient"));
        if (COEFFICIENT < 1) { COEFFICIENT = 1; }
        if (COEFFICIENT > 11) { COEFFICIENT = 11; }

        for (int i = 1; i < COEFFICIENT; i++) {
            BILLION = BILLION/10;
        }
        res = res/ BILLION;

        LocalDateTime localDateTime = LocalDateTime.now();

        Integer year = localDateTime.getYear();
        String sYear = "" + year;

        Integer month = localDateTime.getMonth().getValue();
        String sMonth = "" + month;
        if (sMonth.length() < 2) { sMonth = "0" + sMonth; }

        Integer day = localDateTime.getDayOfMonth();
        String sDay = "" + day;
        if (sDay.length() < 2) { sDay = "0" + sDay; }

        String complex = sYear + sMonth + sDay + res;
        return Long.parseLong(complex);
    }

    private boolean isRegNumberAlreadyInUse(Long number) {      //possibly narrow place
        Patient res;
        res = patientService.findByRegistryNumber(number);
        if (res != null) { return true; }
        return false;
    }



    @RequestMapping(value="/getCards", method = RequestMethod.POST)
    @ResponseBody
    public String getCards(

            //String firstName = (String)request.getAttribute("first_operand");

                           @RequestBody
                           String firstName) {

        System.out.println(firstName);
        //patientService.findByFirstName();
        return "just a simple test";
    }




//    @RequestMapping(value="/last", method = RequestMethod.POST)
//    public JsonViewResponseBodyAdvice last() {
//        return new JsonViewResponseBodyAdvice();
//    }
    @RequestMapping(value = "/last", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getOnPrefixResponse(@RequestBody String[] prefixes)     //ColumnFilter[] filters)
    {
        var prefix = prefixes[0];

        System.out.println(prefix);
        List<Patient> patients = patientService.findAllByLastNameStartsWithOrderByLastName(prefix);

        OnPrefixResponse onPrefixResponse = new OnPrefixResponse();
        onPrefixResponse.size = patients.size();
        onPrefixResponse.values = new String[onPrefixResponse.size];
        String [] res = new String[onPrefixResponse.size];
        //res[0] = "test";
        //res[1] = "love";
        //res[2] = "peace";

        for(int i =0; i < onPrefixResponse.size; i++) {
            Patient p = patients.get(i);

            onPrefixResponse.values[i] = p.getLastName() + ' ' + p.getFirstName()+ ' '
                    + p.getSecondName() + ' ' +p.getBirthDay() + '[' +p.getAddress() + ']'
                    + p.getYear() + ' ' + p.getClinicName() + '[' + p.getClinicAddress() + ']'
                    + p.getClinicEdrpou() +' '+ p.getRegistryNumber() + ' ' + p.isGender() + ' '
                    + p.getPhone() + '[' + p.getDiagnosis() + ']' + p.getComplaints() + '['
                    + p.getTransferredAndConcomitantDiseases() + ']' + p.getGrowthOfPresentDisease();
        }

        //onPrefixResponse.values = res;

        //System.out.println(filters);//do something
        //var filter = filters[0];
        //var value = filter.column;
        ColumnFilter newFilter = new ColumnFilter();
        //newFilter.column=value;
        newFilter.filterType="7";
        newFilter.values = new String[1];
        //List res = new ArrayList<ColumnFilter>();//userService.getAll();
        //res.add(newFilter);

        //return newFilter;

        //new friendly extension)))
        ObjectMapper mapper = new ObjectMapper();
        String s="";
        try {
            s = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(onPrefixResponse);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //end of new friendly extension)))

        return s;
    }



    @RequestMapping(value = "/test", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String test(@RequestBody ColumnFilter[] filters) {


        System.out.println(filters);//do something

        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
         Object obj;


         class TestObj {
            String name;
            String variable;
         }

         TestObj o = new TestObj();
         o.name="i am test object";
         o.variable="i am test value";




         obj = "\"jobject\":\"i am java object\"";
         String s="\"word\":\"sWord\"";
         String l="\"simpleVal\"";
        try {
            s = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        // s = "{" + s+","+obj + "}";
        return s;
    }


    private PatientDto parsePatient(Patient patient) {
        PatientDto res = new PatientDto();

        res.setId(patient.getId());

        res.setClinicName(patient.getClinicName());
        res.setClinicAddress(patient.getClinicAddress());
        res.setClinicEdrpou(patient.getClinicEdrpou());

        res.setRegistryNumber(patient.getRegistryNumber());
        res.setYear(patient.getYear());

        res.setLastName(patient.getLastName());
        res.setFirstName(patient.getFirstName());
        res.setSecondName(patient.getSecondName());

        res.setGender(patient.isGender());
        res.setBirthDay(patient.getBirthDay());

        res.setAddress(patient.getAddress());
        res.setPhone(patient.getPhone());

        res.setDiagnosis(patient.getDiagnosis());
        res.setComplaints(patient.getComplaints());
        res.setTransferredAndConcomitantDiseases(patient.getTransferredAndConcomitantDiseases());
        res.setGrowthOfPresentDisease(patient.getGrowthOfPresentDisease());

     return res;
    }

    private Patient parsePatientDto(PatientDto patient) {
        Patient res = new Patient();

        if (patient.getId() > 0) { res.setId(patient.getId()); }

        res.setClinicName(patient.getClinicName());
        res.setClinicAddress(patient.getClinicAddress());
        res.setClinicEdrpou(patient.getClinicEdrpou());

        res.setYear(patient.getYear());
        res.setRegistryNumber(patient.getRegistryNumber());

        res.setLastName(patient.getLastName());
        res.setSecondName(patient.getSecondName());
        res.setFirstName(patient.getFirstName());

        res.setGender(patient.isGender());
        res.setBirthDay(patient.getBirthDay());

        res.setPhone(patient.getPhone());
        res.setAddress(patient.getAddress());

        res.setDiagnosis(patient.getDiagnosis());
        res.setComplaints(patient.getComplaints());
        res.setTransferredAndConcomitantDiseases(patient.getTransferredAndConcomitantDiseases());
        res.setGrowthOfPresentDisease(patient.getGrowthOfPresentDisease());

        return res;
    }
}
