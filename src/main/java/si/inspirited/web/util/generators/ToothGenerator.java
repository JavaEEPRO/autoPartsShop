package si.inspirited.web.util.generators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import si.inspirited.persistence.model.registry.teeth.Tooth;
import si.inspirited.web.util.generators.Teeth.*;
import si.inspirited.web.util.generators.Teeth.upper.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ToothGenerator {


    @Qualifier("messageSource")
    @Autowired
    private MessageSource messages;

    public List<Tooth> generateNewDentition(Locale currentLocale) {

        List<Tooth> res = new ArrayList<>();

        //

        Wise18Gen wise18Gen = new Wise18Gen();
        Tooth wisdom18 = wise18Gen.initNew();

        SecMolar17Gen secMolar17Gen = new SecMolar17Gen();
        Tooth secondMolar17 = secMolar17Gen.initNew();

        FirstMolar16Gen firstMolar16Gen = new FirstMolar16Gen();
        Tooth firstMolar16 = firstMolar16Gen.initNew();


        SecPremolar15Gen secPremolar15Gen = new SecPremolar15Gen();
        Tooth secondPremolar15 = secPremolar15Gen.initNew();


        FirstPremolar14Gen firstPremolar14Gen = new FirstPremolar14Gen();
        Tooth firstPremolar14 = firstPremolar14Gen.initNew();


//====================================================== front ==============================================


        Fang13Gen fang13Gen = new Fang13Gen();
        Tooth fang13 = fang13Gen.initNew();

        MedCutter12Gen medCutter12Gen = new MedCutter12Gen();
        Tooth medialCutter12 = medCutter12Gen.initNew();

        CentrCut11Gen centrCut11Gen = new CentrCut11Gen();
        Tooth centralCutter11 = centrCut11Gen.initNew();




        CentrCut21Gen centCut21Gen = new CentrCut21Gen();
        Tooth centralCutter21 = centCut21Gen.initNew();

        MedCutter22Gen medCutter22Gen = new MedCutter22Gen();
        Tooth medialCutter22 = medCutter22Gen.initNew();

        Fang23Gen fang23Gen = new Fang23Gen();
        Tooth fang23 = fang23Gen.initNew();


//==================================================== end of front ==============================================



        FirstPremolar24Gen firstPremolar24Gen = new FirstPremolar24Gen();
        Tooth firstPremolar24 = firstPremolar24Gen.initNew();

        SecPremolar25Gen secPremolar25Gen = new SecPremolar25Gen();
        Tooth secondPremolar25 = secPremolar25Gen.initNew();

        FirstMolar26Gen firstMolar26Gen = new FirstMolar26Gen();
        Tooth firstMolar26 = firstMolar26Gen.initNew();

        SecMolar27Gen secMolar27Gen = new SecMolar27Gen();
        Tooth secondMolar27 = secMolar27Gen.initNew();

        Wise28Gen wise28Gen = new Wise28Gen();
        Tooth wisdom28 = wise28Gen.initNew();

        //end of upper teeth


//======================================================= molars ==============================================
        Wise38Gen wise38Gen = new Wise38Gen();
        Tooth wisdom38 = wise38Gen.initNew();

        SecMolar37Gen secMolar37Gen = new SecMolar37Gen();
        Tooth secondMolar37 = secMolar37Gen.initNew();
        //secondMolar37.setDescription(messages.getMessage("description.teeth.d7", new Object[0], currentLocale));

        FirstMolar36Gen firstMolar36Gen = new FirstMolar36Gen();
        Tooth firstMolar36 = firstMolar36Gen.initNew();
        //firstMolar36.setDescription(messages.getMessage("description.teeth.d6", new Object[0], currentLocale));
//==================================================== end of molars ==========================================


//===================================================== premolars ==============================================
        SecPremolar35Gen secPremolar35Gen = new SecPremolar35Gen();
        Tooth secondPremolar35 = secPremolar35Gen.initNew();

        FirstPremolar34Gen firstPremolar34Gen = new FirstPremolar34Gen();
        Tooth firstPremolar34 = firstPremolar34Gen.initNew();
//================================================= end of premolars ==============================================


//====================================================== front ==============================================

        Fang33Gen fang33Gen = new Fang33Gen();
        Tooth fang33 = fang33Gen.initNew();

        MedCutter32Gen medCutter32Gen = new MedCutter32Gen();
        Tooth medialCutter32 = medCutter32Gen.initNew();

        CentrCut31Gen centrCut31Gen = new CentrCut31Gen();
        Tooth centralCutter31 = centrCut31Gen.initNew();


        CentrCut41Gen centrCut41Gen = new CentrCut41Gen();
        Tooth centralCutter41 = centrCut41Gen.initNew();

        MedCutter42Gen medCutter42Gen = new MedCutter42Gen();
        Tooth medialCutter42 = medCutter42Gen.initNew();

        Fang43Gen fang43Gen = new Fang43Gen();
        Tooth fang43 = fang43Gen.initNew();

//==================================================== end of front ==============================================

//===================================================== premolars ==============================================

        FirstPremolar44Gen firstPremolar44Gen = new FirstPremolar44Gen();
        Tooth firstPremolar44 = firstPremolar44Gen.initNew();

        SecPremolar45Gen secPremolar45Gen = new SecPremolar45Gen();
        Tooth secondPremolar45 = secPremolar45Gen.initNew();
//================================================= end of premolars ==============================================

//======================================================= molars ==============================================
        FirstMolar46Gen firstMolar46Gen = new FirstMolar46Gen();
        Tooth firstMolar46 = firstMolar46Gen.initNew();
 //       firstMolar46.setDescription(messages.getMessage("description.teeth.d6", new Object[0], currentLocale));

        SecMolar47Gen secMolar47Gen = new SecMolar47Gen();
        Tooth secondMolar47 = secMolar47Gen.initNew();
 //       secondMolar47.setDescription(messages.getMessage("description.teeth.d7", new Object[0], currentLocale));

        Wise48Gen wise48Gen = new Wise48Gen();
        Tooth wisdom48 = wise48Gen.initNew();

//==================================================== end of molars ==========================================



        //
        res.add(wisdom18);
        res.add(secondMolar17);
        res.add(firstMolar16);
        res.add(secondPremolar15);
        res.add(firstPremolar14);
        res.add(fang13);
        res.add(medialCutter12);
        res.add(centralCutter11);
        res.add(centralCutter21);
        res.add(medialCutter22);
        res.add(fang23);
        res.add(firstPremolar24);
        res.add(secondPremolar25);
        res.add(firstMolar26);
        res.add(secondMolar27);
        res.add(wisdom28);
        //
        res.add(wisdom38);
        res.add(secondMolar37);
        res.add(firstMolar36);
        res.add(secondPremolar35);
        res.add(firstPremolar34);
        res.add(fang33);
        res.add(medialCutter32);
        res.add(centralCutter31);
        res.add(centralCutter41);
        res.add(medialCutter42);
        res.add(fang43);
        res.add(firstPremolar44);
        res.add(secondPremolar45);
        res.add(firstMolar46);
        res.add(secondMolar47);
        res.add(wisdom48);

        return res;
    }


}
