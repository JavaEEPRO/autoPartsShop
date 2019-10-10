package si.inspirited.web.util.generators.Teeth;

import si.inspirited.persistence.model.registry.enums.Localizations;
import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class SecMolar37Gen {

    public Tooth initNew() {

        Tooth secondMolar37 = new Tooth();
        secondMolar37.setIndex(37);
        secondMolar37.setName(Teeth.SECOND_MOLAR);

        List<Surfaces> secondMolar37Surfaces = new ArrayList<>();
        secondMolar37Surfaces.add(Surfaces.MEDIAL);
        secondMolar37Surfaces.add(Surfaces.DISTAl);
        secondMolar37Surfaces.add(Surfaces.BUCCAL);
        secondMolar37Surfaces.add(Surfaces.LINGUAL);
        secondMolar37Surfaces.add(Surfaces.CHEWING);
        secondMolar37.setSurfaces(secondMolar37Surfaces);

        Root root37a = new Root();
        Channel channel37a1 = new Channel();
        List<Localizations> channel37a1Localizations = new ArrayList<>();
        channel37a1Localizations.add(Localizations.MEDIAL);
        channel37a1Localizations.add(Localizations.BUCCAL);
        channel37a1.setLocalizations(channel37a1Localizations);
        Channel channel37a2 = new Channel();
        List<Localizations> channel37a2Localizations = new ArrayList<>();
        channel37a2Localizations.add(Localizations.MEDIAL);
        channel37a2Localizations.add(Localizations.LINGUAL);
        channel37a2.setLocalizations(channel37a2Localizations);
        List<Channel> channels37a = new ArrayList();
        channels37a.add(channel37a1);
        channels37a.add(channel37a2);
        root37a.setChannels(channels37a);

        List<Localizations> root37aLocalizations = new ArrayList<>();
        root37aLocalizations.add(Localizations.MEDIAL);
        root37a.setLocalizations(root37aLocalizations);

        Root root37b = new Root();
        Channel channel37b1 = new Channel();
        List<Localizations> channel37b1Localizations = new ArrayList<>();
        channel37b1Localizations.add(Localizations.DISTAL);
        channel37b1Localizations.add(Localizations.BUCCAL);
        channel37b1.setLocalizations(channel37b1Localizations);
        Channel channel37b2 = new Channel();
        List<Localizations> channel37b2Localizations = new ArrayList<>();
        channel37b2Localizations.add(Localizations.DISTAL);
        channel37b2Localizations.add(Localizations.LINGUAL);
        channel37b2.setLocalizations(channel37b2Localizations);
        List<Channel> channels37b = new ArrayList();
        channels37b.add(channel37b1);
        channels37b.add(channel37b2);
        root37b.setChannels(channels37b);

        List<Localizations> root37bLocalizations = new ArrayList<>();
        root37bLocalizations.add(Localizations.DISTAL);
        root37b.setLocalizations(root37bLocalizations);

        List<Channel> secondMolar37totChann = new ArrayList<>();
        secondMolar37totChann.addAll(channels37a);
        secondMolar37totChann.addAll(channels37b);
        secondMolar37.setChannels(secondMolar37totChann);

        List<Root> secondMolar37TotRoots = new ArrayList<>();
        secondMolar37TotRoots.add(root37a);
        secondMolar37TotRoots.add(root37b);
        secondMolar37.setRoots(secondMolar37TotRoots);

        return secondMolar37;
    }
}
