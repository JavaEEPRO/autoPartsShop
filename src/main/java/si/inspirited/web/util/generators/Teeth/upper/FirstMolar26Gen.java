package si.inspirited.web.util.generators.Teeth.upper;

import si.inspirited.persistence.model.registry.enums.Localizations;
import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class FirstMolar26Gen {

    public Tooth initNew() {
        Tooth firstMolar26 = new Tooth();
        firstMolar26.setIndex(26);
        firstMolar26.setName(Teeth.FIRST_MOLAR);

        List<Surfaces> firstMolar26Surfaces = new ArrayList<>();
        firstMolar26Surfaces.add(Surfaces.MEDIAL);
        firstMolar26Surfaces.add(Surfaces.DISTAl);
        firstMolar26Surfaces.add(Surfaces.BUCCAL);
        firstMolar26Surfaces.add(Surfaces.LINGUAL);
        firstMolar26Surfaces.add(Surfaces.CHEWING);
        firstMolar26.setSurfaces(firstMolar26Surfaces);

        Root root26a = new Root();
        Channel channel26a1 = new Channel();

        List<Localizations> channel26a1Localizations = new ArrayList<>();
        channel26a1Localizations.add(Localizations.MEDIAL);
        channel26a1Localizations.add(Localizations.LINGUAL);
        channel26a1.setLocalizations(channel26a1Localizations);
        Channel channel26a2 = new Channel();
        List<Localizations> channel26a2Localizations = new ArrayList<>();
        channel26a2Localizations.add(Localizations.MEDIAL);
        channel26a2Localizations.add(Localizations.BUCCAL);
        channel26a2.setLocalizations(channel26a2Localizations);

        List<Channel> channels26a = new ArrayList();
        channels26a.add(channel26a1);
        channels26a.add(channel26a2);
        root26a.setChannels(channels26a);

        List<Localizations> root26aLocalizations = new ArrayList<>();
        root26aLocalizations.add(Localizations.MEDIAL);
        root26aLocalizations.add(Localizations.BUCCAL);
        root26a.setLocalizations(root26aLocalizations);

        Root root26b = new Root();
        Channel channel26b1 = new Channel();

//        List<Localizations> channel26b1Localizations = new ArrayList<>();
//        channel26b1Localizations.add(Localizations.MEDIAL);
//        channel26b1Localizations.add(Localizations.BUCCAL);
//        channel26b1.setLocalizations(channel26b1Localizations);
//        Channel channel26b2 = new Channel();
//        List<Localizations> channel26b2Localizations = new ArrayList<>();
//        channel26b2Localizations.add(Localizations.MEDIAL);
//        channel26b2Localizations.add(Localizations.LINGUAL);
//        channel26b2.setLocalizations(channel26b2Localizations);

        List<Channel> channels26b = new ArrayList();
        channels26b.add(channel26b1);
        //channels26b.add(channel26b2);
        root26b.setChannels(channels26b);

        List<Localizations> root26bLocalizations = new ArrayList<>();
        root26bLocalizations.add(Localizations.DISTAL);
        root26bLocalizations.add(Localizations.BUCCAL);
        root26b.setLocalizations(root26bLocalizations);


        Root root26c = new Root();
        Channel channel26c1 = new Channel();

//        List<Localizations> channel26c1Localizations = new ArrayList<>();
//        channel26c1Localizations.add(Localizations.MEDIAL);
//        channel26c1Localizations.add(Localizations.BUCCAL);
//        channel26c1.setLocalizations(channel26c1Localizations);
//        Channel channel26c2 = new Channel();
//        List<Localizations> channel26c2Localizations = new ArrayList<>();
//        channel26c2Localizations.add(Localizations.MEDIAL);
//        channel26c2Localizations.add(Localizations.LINGUAL);
//        channel26c2.setLocalizations(channel26c2Localizations);

        List<Channel> channels26c = new ArrayList();
        channels26c.add(channel26c1);
        //channels26c.add(channel26c2);
        root26c.setChannels(channels26c);

        List<Localizations> root26cLocalizations = new ArrayList<>();
        root26cLocalizations.add(Localizations.LINGUAL);
        root26c.setLocalizations(root26cLocalizations);

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

        return firstMolar26;
    }
}
