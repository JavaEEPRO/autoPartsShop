package si.inspirited.web.util.generators.Teeth.upper;

import si.inspirited.persistence.model.registry.enums.Localizations;
import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class FirstPremolar14Gen {

    public Tooth initNew() {

        Tooth firstPremolar14 = new Tooth();
        firstPremolar14.setIndex(14);
        firstPremolar14.setName(Teeth.FIRST_PREMOLAR);

        List<Surfaces> firstPremolar14Surfaces = new ArrayList<>();
        firstPremolar14Surfaces.add(Surfaces.MEDIAL);
        firstPremolar14Surfaces.add(Surfaces.DISTAl);
        firstPremolar14Surfaces.add(Surfaces.BUCCAL);
        firstPremolar14Surfaces.add(Surfaces.LINGUAL);
        firstPremolar14Surfaces.add(Surfaces.CHEWING);
        firstPremolar14.setSurfaces(firstPremolar14Surfaces);

        Root root14a = new Root();
        Channel channel14a1 = new Channel();
        List<Channel> channels14a = new ArrayList();
        channels14a.add(channel14a1);
        root14a.setChannels(channels14a);

        List<Localizations> root14aLocalizations = new ArrayList<>();
        root14aLocalizations.add(Localizations.LABIAL);
        root14a.setLocalizations(root14aLocalizations);

        Root root14b = new Root();
        Channel channel14b1 = new Channel();
        List<Channel> channels14b = new ArrayList();
        channels14b.add(channel14b1);
        root14b.setChannels(channels14b);

        List<Localizations> root14bLocalizations = new ArrayList<>();
        root14bLocalizations.add(Localizations.LINGUAL);
        root14b.setLocalizations(root14bLocalizations);

        List<Channel> firstPremolar14totChann = new ArrayList<>();
        firstPremolar14totChann.addAll(channels14a);
        firstPremolar14totChann.addAll(channels14b);
        firstPremolar14.setChannels(firstPremolar14totChann);

        List<Root> firstPremolar14TotRoots = new ArrayList<>();
        firstPremolar14TotRoots.add(root14a);
        firstPremolar14TotRoots.add(root14b);
        firstPremolar14.setRoots(firstPremolar14TotRoots);

        return firstPremolar14;
    }
}
