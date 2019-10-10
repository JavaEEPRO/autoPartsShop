package si.inspirited.web.util.generators.Teeth;

import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class FirstPremolar44Gen {

    public Tooth initNew() {
        Tooth firstPremolar44 = new Tooth();
        firstPremolar44.setIndex(44);
        firstPremolar44.setName(Teeth.FIRST_PREMOLAR);

        List<Surfaces> firstPremolar44Surfaces = new ArrayList<>();
        firstPremolar44Surfaces.add(Surfaces.MEDIAL);
        firstPremolar44Surfaces.add(Surfaces.DISTAl);
        firstPremolar44Surfaces.add(Surfaces.BUCCAL);
        firstPremolar44Surfaces.add(Surfaces.LINGUAL);
        firstPremolar44Surfaces.add(Surfaces.CHEWING);
        firstPremolar44.setSurfaces(firstPremolar44Surfaces);

        Root root44a = new Root();
        Channel channel44a1 = new Channel();
        List<Channel> channels44a = new ArrayList();
        channels44a.add(channel44a1);
        root44a.setChannels(channels44a);

        List<Channel> firstPremolar44totChann = new ArrayList<>();
        firstPremolar44totChann.addAll(channels44a);
        firstPremolar44.setChannels(firstPremolar44totChann);

        List<Root> firstPremolar44TotRoots = new ArrayList<>();
        firstPremolar44TotRoots.add(root44a);
        firstPremolar44.setRoots(firstPremolar44TotRoots);

        return firstPremolar44;
    }
}
