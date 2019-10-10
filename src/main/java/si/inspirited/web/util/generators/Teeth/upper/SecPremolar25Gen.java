package si.inspirited.web.util.generators.Teeth.upper;

import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class SecPremolar25Gen {

    public Tooth initNew() {

        Tooth secondPremolar25 = new Tooth();
        secondPremolar25.setIndex(25);
        secondPremolar25.setName(Teeth.SECOND_PREMOLAR);

        List<Surfaces> secondPremolar25Surfaces = new ArrayList<>();
        secondPremolar25Surfaces.add(Surfaces.MEDIAL);
        secondPremolar25Surfaces.add(Surfaces.DISTAl);
        secondPremolar25Surfaces.add(Surfaces.BUCCAL);
        secondPremolar25Surfaces.add(Surfaces.LINGUAL);
        secondPremolar25Surfaces.add(Surfaces.CHEWING);
        secondPremolar25.setSurfaces(secondPremolar25Surfaces);

        Root root25a = new Root();
        Channel channel25a1 = new Channel();
        List<Channel> channels25a = new ArrayList();
        channels25a.add(channel25a1);
        root25a.setChannels(channels25a);

        List<Channel> secondPremolar25totChann = new ArrayList<>();
        secondPremolar25totChann.addAll(channels25a);
        secondPremolar25.setChannels(secondPremolar25totChann);

        List<Root> secondPremolar25TotRoots = new ArrayList<>();
        secondPremolar25TotRoots.add(root25a);
        secondPremolar25.setRoots(secondPremolar25TotRoots);

        return secondPremolar25;
    }
}
