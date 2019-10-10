package si.inspirited.web.util.generators.Teeth.upper;

import si.inspirited.persistence.model.registry.enums.Localizations;
import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class SecMolar17Gen {

    public Tooth initNew() {
        Tooth secondMolar17 = new Tooth();
        secondMolar17.setIndex(17);
        secondMolar17.setName(Teeth.SECOND_MOLAR);

        List<Surfaces> secondMolar17Surfaces = new ArrayList<>();
        secondMolar17Surfaces.add(Surfaces.MEDIAL);
        secondMolar17Surfaces.add(Surfaces.DISTAl);
        secondMolar17Surfaces.add(Surfaces.BUCCAL);
        secondMolar17Surfaces.add(Surfaces.LINGUAL);
        secondMolar17Surfaces.add(Surfaces.CHEWING);
        secondMolar17.setSurfaces(secondMolar17Surfaces);

        Root root17a = new Root();
        Channel channel17a1 = new Channel();

        List<Localizations> channel17a1Localizations = new ArrayList<>();
        channel17a1Localizations.add(Localizations.MEDIAL);
        channel17a1Localizations.add(Localizations.LINGUAL);
        channel17a1.setLocalizations(channel17a1Localizations);
        Channel channel17a2 = new Channel();
        List<Localizations> channel17a2Localizations = new ArrayList<>();
        channel17a2Localizations.add(Localizations.MEDIAL);
        channel17a2Localizations.add(Localizations.BUCCAL);
        channel17a2.setLocalizations(channel17a2Localizations);

        List<Channel> channels17a = new ArrayList();
        channels17a.add(channel17a1);
        channels17a.add(channel17a2);
        root17a.setChannels(channels17a);

        List<Localizations> root17aLocalizations = new ArrayList<>();
        root17aLocalizations.add(Localizations.MEDIAL);
        root17aLocalizations.add(Localizations.BUCCAL);
        root17a.setLocalizations(root17aLocalizations);

        Root root17b = new Root();
        Channel channel17b1 = new Channel();

//        List<Localizations> channel17b1Localizations = new ArrayList<>();
//        channel17b1Localizations.add(Localizations.MEDIAL);
//        channel17b1Localizations.add(Localizations.BUCCAL);
//        channel17b1.setLocalizations(channel17b1Localizations);
//        Channel channel17b2 = new Channel();
//        List<Localizations> channel17b2Localizations = new ArrayList<>();
//        channel17b2Localizations.add(Localizations.MEDIAL);
//        channel17b2Localizations.add(Localizations.LINGUAL);
//        channel17b2.setLocalizations(channel17b2Localizations);

        List<Channel> channels17b = new ArrayList();
        channels17b.add(channel17b1);
        //channels17b.add(channel17b2);
        root17b.setChannels(channels17b);

        List<Localizations> root17bLocalizations = new ArrayList<>();
        root17bLocalizations.add(Localizations.DISTAL);
        root17bLocalizations.add(Localizations.BUCCAL);
        root17b.setLocalizations(root17bLocalizations);

        Root root17c = new Root();
        Channel channel17c1 = new Channel();

//        List<Localizations> channel17c1Localizations = new ArrayList<>();
//        channel17c1Localizations.add(Localizations.MEDIAL);
//        channel17c1Localizations.add(Localizations.BUCCAL);
//        channel17c1.setLocalizations(channel17c1Localizations);
//        Channel channel17c2 = new Channel();
//        List<Localizations> channel17c2Localizations = new ArrayList<>();
//        channel17c2Localizations.add(Localizations.MEDIAL);
//        channel17c2Localizations.add(Localizations.LINGUAL);
//        channel17c2.setLocalizations(channel17c2Localizations);

        List<Channel> channels17c = new ArrayList();
        channels17c.add(channel17c1);
        //channels17c.add(channel17c2);
        root17c.setChannels(channels17c);

        List<Localizations> root17cLocalizations = new ArrayList<>();
        root17cLocalizations.add(Localizations.LINGUAL);
        root17c.setLocalizations(root17cLocalizations);

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

        return secondMolar17;
    }
}
