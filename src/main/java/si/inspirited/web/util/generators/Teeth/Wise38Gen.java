package si.inspirited.web.util.generators.Teeth;

import si.inspirited.persistence.model.registry.enums.Localizations;
import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class Wise38Gen {

    public Tooth initNew() {

        Tooth wisdom38 = new Tooth();
        wisdom38.setIndex(38);
        wisdom38.setName(Teeth.WISDOM_TOOTH);

        List<Surfaces> wisdom38Surfaces = new ArrayList<>();
        wisdom38Surfaces.add(Surfaces.MEDIAL);
        wisdom38Surfaces.add(Surfaces.DISTAl);
        wisdom38Surfaces.add(Surfaces.BUCCAL);
        wisdom38Surfaces.add(Surfaces.LINGUAL);
        wisdom38Surfaces.add(Surfaces.CHEWING);
        wisdom38.setSurfaces(wisdom38Surfaces);

        Root root38a = new Root();
        Channel channel38a1 = new Channel();
        List<Localizations> channel38a1Localizations = new ArrayList<>();
        channel38a1Localizations.add(Localizations.MEDIAL);
        channel38a1Localizations.add(Localizations.BUCCAL);
        channel38a1.setLocalizations(channel38a1Localizations);
        Channel channel38a2 = new Channel();
        List<Localizations> channel38a2Localizations = new ArrayList<>();
        channel38a2Localizations.add(Localizations.MEDIAL);
        channel38a2Localizations.add(Localizations.LINGUAL);
        channel38a2.setLocalizations(channel38a2Localizations);
        List<Channel> channels38a = new ArrayList();
        channels38a.add(channel38a1);
        channels38a.add(channel38a2);
        root38a.setChannels(channels38a);

        List<Localizations> root38aLocalizations = new ArrayList<>();
        root38aLocalizations.add(Localizations.MEDIAL);
        root38a.setLocalizations(root38aLocalizations);

        Root root38b = new Root();
        Channel channel38b1 = new Channel();
        List<Localizations> channel38b1Localizations = new ArrayList<>();
        channel38b1Localizations.add(Localizations.DISTAL);
        channel38b1Localizations.add(Localizations.BUCCAL);
        channel38b1.setLocalizations(channel38b1Localizations);
        Channel channel38b2 = new Channel();
        List<Localizations> channel38b2Localizations = new ArrayList<>();
        channel38b2Localizations.add(Localizations.DISTAL);
        channel38b2Localizations.add(Localizations.LINGUAL);
        channel38b2.setLocalizations(channel38b2Localizations);
        List<Channel> channels38b = new ArrayList();
        channels38b.add(channel38b1);
        channels38b.add(channel38b2);
        root38b.setChannels(channels38b);

        List<Localizations> root38bLocalizations = new ArrayList<>();
        root38bLocalizations.add(Localizations.DISTAL);
        root38b.setLocalizations(root38bLocalizations);

        List<Channel> wisdom38totChann = new ArrayList<>();
        wisdom38totChann.addAll(channels38a);
        wisdom38totChann.addAll(channels38b);
        wisdom38.setChannels(wisdom38totChann);

        List<Root> wisdom38TotRoots = new ArrayList<>();
        wisdom38TotRoots.add(root38a);
        wisdom38TotRoots.add(root38b);
        wisdom38.setRoots(wisdom38TotRoots);

        return wisdom38;
    }
}
