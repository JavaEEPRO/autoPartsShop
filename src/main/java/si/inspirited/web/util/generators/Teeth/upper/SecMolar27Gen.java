package si.inspirited.web.util.generators.Teeth.upper;

import si.inspirited.persistence.model.registry.enums.Localizations;
import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class SecMolar27Gen {

    public Tooth initNew() {
        Tooth secondMolar27 = new Tooth();
        secondMolar27.setIndex(27);
        secondMolar27.setName(Teeth.SECOND_MOLAR);

        List<Surfaces> secondMolar27Surfaces = new ArrayList<>();
        secondMolar27Surfaces.add(Surfaces.MEDIAL);
        secondMolar27Surfaces.add(Surfaces.DISTAl);
        secondMolar27Surfaces.add(Surfaces.BUCCAL);
        secondMolar27Surfaces.add(Surfaces.LINGUAL);
        secondMolar27Surfaces.add(Surfaces.CHEWING);
        secondMolar27.setSurfaces(secondMolar27Surfaces);

        Root root27a = new Root();
        Channel channel27a1 = new Channel();

        List<Localizations> channel27a1Localizations = new ArrayList<>();
        channel27a1Localizations.add(Localizations.MEDIAL);
        channel27a1Localizations.add(Localizations.LINGUAL);
        channel27a1.setLocalizations(channel27a1Localizations);
        Channel channel27a2 = new Channel();
        List<Localizations> channel27a2Localizations = new ArrayList<>();
        channel27a2Localizations.add(Localizations.MEDIAL);
        channel27a2Localizations.add(Localizations.BUCCAL);
        channel27a2.setLocalizations(channel27a2Localizations);

        List<Channel> channels27a = new ArrayList();
        channels27a.add(channel27a1);
        channels27a.add(channel27a2);
        root27a.setChannels(channels27a);

        List<Localizations> root27aLocalizations = new ArrayList<>();
        root27aLocalizations.add(Localizations.MEDIAL);
        root27aLocalizations.add(Localizations.BUCCAL);
        root27a.setLocalizations(root27aLocalizations);

        Root root27b = new Root();
        Channel channel27b1 = new Channel();

//        List<Localizations> channel27b1Localizations = new ArrayList<>();
//        channel27b1Localizations.add(Localizations.MEDIAL);
//        channel27b1Localizations.add(Localizations.BUCCAL);
//        channel27b1.setLocalizations(channel27b1Localizations);
//        Channel channel27b2 = new Channel();
//        List<Localizations> channel27b2Localizations = new ArrayList<>();
//        channel27b2Localizations.add(Localizations.MEDIAL);
//        channel27b2Localizations.add(Localizations.LINGUAL);
//        channel27b2.setLocalizations(channel27b2Localizations);

        List<Channel> channels27b = new ArrayList();
        channels27b.add(channel27b1);
        //channels27b.add(channel27b2);
        root27b.setChannels(channels27b);

        List<Localizations> root27bLocalizations = new ArrayList<>();
        root27bLocalizations.add(Localizations.DISTAL);
        root27bLocalizations.add(Localizations.BUCCAL);
        root27b.setLocalizations(root27bLocalizations);

        Root root27c = new Root();
        Channel channel27c1 = new Channel();

//        List<Localizations> channel27c1Localizations = new ArrayList<>();
//        channel27c1Localizations.add(Localizations.MEDIAL);
//        channel27c1Localizations.add(Localizations.BUCCAL);
//        channel27c1.setLocalizations(channel27c1Localizations);
//        Channel channel27c2 = new Channel();
//        List<Localizations> channel27c2Localizations = new ArrayList<>();
//        channel27c2Localizations.add(Localizations.MEDIAL);
//        channel27c2Localizations.add(Localizations.LINGUAL);
//        channel27c2.setLocalizations(channel27c2Localizations);

        List<Channel> channels27c = new ArrayList();
        channels27c.add(channel27c1);
        //channels27c.add(channel27c2);
        root27c.setChannels(channels27c);

        List<Localizations> root27cLocalizations = new ArrayList<>();
        root27cLocalizations.add(Localizations.LINGUAL);
        root27c.setLocalizations(root27cLocalizations);

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

        return secondMolar27;
    }
}
