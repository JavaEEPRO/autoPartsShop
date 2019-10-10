package si.inspirited.web.util.generators.Teeth;

import si.inspirited.persistence.model.registry.enums.Localizations;
import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class FirstMolar46Gen {

    public Tooth initNew() {

    Tooth firstMolar46 = new Tooth();
            firstMolar46.setIndex(46);
            firstMolar46.setName(Teeth.FIRST_MOLAR);

        List<Surfaces> firstMolar46Surfaces = new ArrayList<>();
        firstMolar46Surfaces.add(Surfaces.MEDIAL);
        firstMolar46Surfaces.add(Surfaces.DISTAl);
        firstMolar46Surfaces.add(Surfaces.BUCCAL);
        firstMolar46Surfaces.add(Surfaces.LINGUAL);
        firstMolar46Surfaces.add(Surfaces.CHEWING);
        firstMolar46.setSurfaces(firstMolar46Surfaces);

    Root root46a = new Root();
    Channel channel46a1 = new Channel();
    List<Localizations> channel46a1Localizations = new ArrayList<>();
                channel46a1Localizations.add(Localizations.MEDIAL);
                channel46a1Localizations.add(Localizations.BUCCAL);
                channel46a1.setLocalizations(channel46a1Localizations);
    Channel channel46a2 = new Channel();
    List<Localizations> channel46a2Localizations = new ArrayList<>();
                channel46a2Localizations.add(Localizations.MEDIAL);
                channel46a2Localizations.add(Localizations.LINGUAL);
                channel46a2.setLocalizations(channel46a2Localizations);
    List<Channel> channels46a = new ArrayList();
            channels46a.add(channel46a1);
            channels46a.add(channel46a2);
            root46a.setChannels(channels46a);

    List<Localizations> root46aLocalizations = new ArrayList<>();
                root46aLocalizations.add(Localizations.MEDIAL);
                root46a.setLocalizations(root46aLocalizations);

    Root root46b = new Root();
    Channel channel46b1 = new Channel();
    List<Localizations> channel46b1Localizations = new ArrayList<>();
                channel46b1Localizations.add(Localizations.DISTAL);
                channel46b1Localizations.add(Localizations.BUCCAL);
                channel46b1.setLocalizations(channel46b1Localizations);
    Channel channel46b2 = new Channel();
    List<Localizations> channel46b2Localizations = new ArrayList<>();
                channel46b2Localizations.add(Localizations.DISTAL);
                channel46b2Localizations.add(Localizations.LINGUAL);
                channel46b2.setLocalizations(channel46b2Localizations);
    List<Channel> channels46b = new ArrayList();
            channels46b.add(channel46b1);
            channels46b.add(channel46b2);
            root46b.setChannels(channels46b);

    List<Localizations> root46bLocalizations = new ArrayList<>();
                root46bLocalizations.add(Localizations.DISTAL);
                root46b.setLocalizations(root46bLocalizations);

    List<Channel> firstMolar46totChann = new ArrayList<>();
            firstMolar46totChann.addAll(channels46a);
            firstMolar46totChann.addAll(channels46b);
            firstMolar46.setChannels(firstMolar46totChann);

    List<Root> firstMolar46TotRoots = new ArrayList<>();
            firstMolar46TotRoots.add(root46a);
            firstMolar46TotRoots.add(root46b);
            firstMolar46.setRoots(firstMolar46TotRoots);

            return firstMolar46;
     }

}
