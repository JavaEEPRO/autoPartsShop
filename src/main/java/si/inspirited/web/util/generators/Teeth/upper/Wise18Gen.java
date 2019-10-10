package si.inspirited.web.util.generators.Teeth.upper;

import si.inspirited.persistence.model.registry.enums.Localizations;
import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class Wise18Gen {

    public Tooth initNew() {

        Tooth wisdom18 = new Tooth();
        wisdom18.setIndex(18);
        wisdom18.setName(Teeth.WISDOM_TOOTH);

        List<Surfaces> wisdom18Surfaces = new ArrayList<>();
        wisdom18Surfaces.add(Surfaces.MEDIAL);
        wisdom18Surfaces.add(Surfaces.DISTAl);
        wisdom18Surfaces.add(Surfaces.BUCCAL);
        wisdom18Surfaces.add(Surfaces.LINGUAL);
        wisdom18Surfaces.add(Surfaces.CHEWING);
        wisdom18.setSurfaces(wisdom18Surfaces);

        Root root18a = new Root();
        Channel channel18a1 = new Channel();

        List<Localizations> channel18a1Localizations = new ArrayList<>();
        channel18a1Localizations.add(Localizations.MEDIAL);
        channel18a1Localizations.add(Localizations.LINGUAL);
        channel18a1.setLocalizations(channel18a1Localizations);
        Channel channel18a2 = new Channel();
        List<Localizations> channel18a2Localizations = new ArrayList<>();
        channel18a2Localizations.add(Localizations.MEDIAL);
        channel18a2Localizations.add(Localizations.BUCCAL);
        channel18a2.setLocalizations(channel18a2Localizations);

        List<Channel> channels18a = new ArrayList();
        channels18a.add(channel18a1);
        channels18a.add(channel18a2);
        root18a.setChannels(channels18a);

        List<Localizations> root18aLocalizations = new ArrayList<>();
        root18aLocalizations.add(Localizations.MEDIAL);
        root18aLocalizations.add(Localizations.BUCCAL);
        root18a.setLocalizations(root18aLocalizations);

        Root root18b = new Root();
        Channel channel18b1 = new Channel();

//        List<Localizations> channel18b1Localizations = new ArrayList<>();
//        channel18b1Localizations.add(Localizations.DISTAL);
//        channel18b1Localizations.add(Localizations.BUCCAL);
//        channel18b1.setLocalizations(channel18b1Localizations);
//        Channel channel18b2 = new Channel();
//        List<Localizations> channel18b2Localizations = new ArrayList<>();
//        channel18b2Localizations.add(Localizations.DISTAL);
//        channel18b2Localizations.add(Localizations.LINGUAL);
//        channel18b2.setLocalizations(channel18b2Localizations);

        List<Channel> channels18b = new ArrayList();
        channels18b.add(channel18b1);
        //channels18b.add(channel18b2);
        root18b.setChannels(channels18b);

        List<Localizations> root18bLocalizations = new ArrayList<>();
        root18bLocalizations.add(Localizations.DISTAL);
        root18bLocalizations.add(Localizations.BUCCAL);
        root18b.setLocalizations(root18bLocalizations);

        Root root18c = new Root();
        Channel channel18c1 = new Channel();

//        List<Localizations> channel18c1Localizations = new ArrayList<>();
//        channel18c1Localizations.add(Localizations.DISTAL);
//        channel18c1Localizations.add(Localizations.BUCCAL);
//        channel18c1.setLocalizations(channel18c1Localizations);
//        Channel channel18c2 = new Channel();
//        List<Localizations> channel18c2Localizations = new ArrayList<>();
//        channel18c2Localizations.add(Localizations.DISTAL);
//        channel18c2Localizations.add(Localizations.LINGUAL);
//        channel18c2.setLocalizations(channel18c2Localizations);

        List<Channel> channels18c = new ArrayList();
        channels18c.add(channel18c1);
        //channels18c.add(channel18c2);
        root18c.setChannels(channels18c);

        List<Localizations> root18cLocalizations = new ArrayList<>();
        root18cLocalizations.add(Localizations.LINGUAL);
        root18c.setLocalizations(root18cLocalizations);

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

        return wisdom18;
    }
}
