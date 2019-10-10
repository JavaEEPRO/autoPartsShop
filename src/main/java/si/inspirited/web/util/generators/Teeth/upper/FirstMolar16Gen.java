package si.inspirited.web.util.generators.Teeth.upper;

import si.inspirited.persistence.model.registry.enums.Localizations;
import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class FirstMolar16Gen {

    public Tooth initNew() {

        Tooth firstMolar16 = new Tooth();
        firstMolar16.setIndex(16);
        firstMolar16.setName(Teeth.FIRST_MOLAR);

        List<Surfaces> firstMolar16Surfaces = new ArrayList<>();
        firstMolar16Surfaces.add(Surfaces.MEDIAL);
        firstMolar16Surfaces.add(Surfaces.DISTAl);
        firstMolar16Surfaces.add(Surfaces.BUCCAL);
        firstMolar16Surfaces.add(Surfaces.LINGUAL);
        firstMolar16Surfaces.add(Surfaces.CHEWING);
        firstMolar16.setSurfaces(firstMolar16Surfaces);

        Root root16a = new Root();
        Channel channel16a1 = new Channel();

        List<Localizations> channel16a1Localizations = new ArrayList<>();
        channel16a1Localizations.add(Localizations.MEDIAL);
        channel16a1Localizations.add(Localizations.LINGUAL);
        channel16a1.setLocalizations(channel16a1Localizations);
        Channel channel16a2 = new Channel();
        List<Localizations> channel16a2Localizations = new ArrayList<>();
        channel16a2Localizations.add(Localizations.MEDIAL);
        channel16a2Localizations.add(Localizations.BUCCAL);
        channel16a2.setLocalizations(channel16a2Localizations);

        List<Channel> channels16a = new ArrayList();
        channels16a.add(channel16a1);
        channels16a.add(channel16a2);
        root16a.setChannels(channels16a);

        List<Localizations> root16aLocalizations = new ArrayList<>();
        root16aLocalizations.add(Localizations.MEDIAL);
        root16aLocalizations.add(Localizations.BUCCAL);
        root16a.setLocalizations(root16aLocalizations);

        Root root16b = new Root();
        Channel channel16b1 = new Channel();


//        List<Localizations> channel16b1Localizations = new ArrayList<>();
//        channel16b1Localizations.add(Localizations.MEDIAL);
//        channel16b1Localizations.add(Localizations.BUCCAL);
//        channel16b1.setLocalizations(channel16b1Localizations);
//        Channel channel16b2 = new Channel();
//        List<Localizations> channel16b2Localizations = new ArrayList<>();
//        channel16b2Localizations.add(Localizations.MEDIAL);
//        channel16b2Localizations.add(Localizations.LINGUAL);
//        channel16b2.setLocalizations(channel16b2Localizations);

        List<Channel> channels16b = new ArrayList();
        channels16b.add(channel16b1);
        //channels16b.add(channel16b2);
        root16b.setChannels(channels16b);

        List<Localizations> root16bLocalizations = new ArrayList<>();
        root16bLocalizations.add(Localizations.DISTAL);
        root16bLocalizations.add(Localizations.BUCCAL);
        root16b.setLocalizations(root16bLocalizations);

        Root root16c = new Root();
        Channel channel16c1 = new Channel();

//        List<Localizations> channel16c1Localizations = new ArrayList<>();
//        channel16c1Localizations.add(Localizations.MEDIAL);
//        channel16c1Localizations.add(Localizations.BUCCAL);
//        channel16c1.setLocalizations(channel16c1Localizations);
//        Channel channel16c2 = new Channel();
//        List<Localizations> channel16c2Localizations = new ArrayList<>();
//        channel16c2Localizations.add(Localizations.MEDIAL);
//        channel16c2Localizations.add(Localizations.LINGUAL);
//        channel16c2.setLocalizations(channel16c2Localizations);

        List<Channel> channels16c = new ArrayList();
        channels16c.add(channel16c1);
        //channels16c.add(channel16c2);
        root16c.setChannels(channels16c);

        List<Localizations> root16cLocalizations = new ArrayList<>();
        root16cLocalizations.add(Localizations.LINGUAL);
        root16c.setLocalizations(root16cLocalizations);

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

        return firstMolar16;
    }
}
