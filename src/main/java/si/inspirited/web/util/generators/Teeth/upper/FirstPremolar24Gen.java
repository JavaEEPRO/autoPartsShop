package si.inspirited.web.util.generators.Teeth.upper;

import si.inspirited.persistence.model.registry.enums.Localizations;
import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class FirstPremolar24Gen {

    public Tooth initNew() {

        Tooth firstPremolar24 = new Tooth();
        firstPremolar24.setIndex(24);
        firstPremolar24.setName(Teeth.FIRST_PREMOLAR);

        List<Surfaces> firstPremolar24Surfaces = new ArrayList<>();
        firstPremolar24Surfaces.add(Surfaces.MEDIAL);
        firstPremolar24Surfaces.add(Surfaces.DISTAl);
        firstPremolar24Surfaces.add(Surfaces.BUCCAL);
        firstPremolar24Surfaces.add(Surfaces.LINGUAL);
        firstPremolar24Surfaces.add(Surfaces.CHEWING);
        firstPremolar24.setSurfaces(firstPremolar24Surfaces);

        Root root24a = new Root();
        Channel channel24a1 = new Channel();
        List<Channel> channels24a = new ArrayList();
        channels24a.add(channel24a1);
        root24a.setChannels(channels24a);

        List<Localizations> root24aLocalizations = new ArrayList<>();
        root24aLocalizations.add(Localizations.LABIAL);
        root24a.setLocalizations(root24aLocalizations);

        Root root24b = new Root();
        Channel channel24b1 = new Channel();
        List<Channel> channels24b = new ArrayList();
        channels24b.add(channel24b1);
        root24b.setChannels(channels24b);

        List<Localizations> root24bLocalizations = new ArrayList<>();
        root24bLocalizations.add(Localizations.LINGUAL);
        root24b.setLocalizations(root24bLocalizations);

        List<Channel> firstPremolar24totChann = new ArrayList<>();
        firstPremolar24totChann.addAll(channels24a);
        firstPremolar24totChann.addAll(channels24b);
        firstPremolar24.setChannels(firstPremolar24totChann);

        List<Root> firstPremolar24TotRoots = new ArrayList<>();
        firstPremolar24TotRoots.add(root24a);
        firstPremolar24TotRoots.add(root24b);
        firstPremolar24.setRoots(firstPremolar24TotRoots);

        return firstPremolar24;
    }
}
