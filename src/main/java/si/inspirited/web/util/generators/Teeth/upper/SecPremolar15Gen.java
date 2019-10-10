package si.inspirited.web.util.generators.Teeth.upper;

import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class SecPremolar15Gen {

    public Tooth initNew() {
        Tooth secondPremolar15 = new Tooth();
        secondPremolar15.setIndex(15);
        secondPremolar15.setName(Teeth.SECOND_PREMOLAR);

        List<Surfaces> secondPremolar15Surfaces = new ArrayList<>();
        secondPremolar15Surfaces.add(Surfaces.MEDIAL);
        secondPremolar15Surfaces.add(Surfaces.DISTAl);
        secondPremolar15Surfaces.add(Surfaces.BUCCAL);
        secondPremolar15Surfaces.add(Surfaces.LINGUAL);
        secondPremolar15Surfaces.add(Surfaces.CHEWING);
        secondPremolar15.setSurfaces(secondPremolar15Surfaces);

        Root root15a = new Root();
        Channel channel15a1 = new Channel();
        List<Channel> channels15a = new ArrayList();
        channels15a.add(channel15a1);
        root15a.setChannels(channels15a);

        List<Channel> secondPremolar15totChann = new ArrayList<>();
        secondPremolar15totChann.addAll(channels15a);
        secondPremolar15.setChannels(secondPremolar15totChann);

        List<Root> secondPremolar15TotRoots = new ArrayList<>();
        secondPremolar15TotRoots.add(root15a);
        secondPremolar15.setRoots(secondPremolar15TotRoots);

        return secondPremolar15;
    }
}
