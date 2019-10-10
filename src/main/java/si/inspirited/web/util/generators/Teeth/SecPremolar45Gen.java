package si.inspirited.web.util.generators.Teeth;

import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class SecPremolar45Gen {

    public Tooth initNew() {
        Tooth secondPremolar45 = new Tooth();
        secondPremolar45.setIndex(45);
        secondPremolar45.setName(Teeth.SECOND_PREMOLAR);

        List<Surfaces> secondPremolar45Surfaces = new ArrayList<>();
        secondPremolar45Surfaces.add(Surfaces.MEDIAL);
        secondPremolar45Surfaces.add(Surfaces.DISTAl);
        secondPremolar45Surfaces.add(Surfaces.BUCCAL);
        secondPremolar45Surfaces.add(Surfaces.LINGUAL);
        secondPremolar45Surfaces.add(Surfaces.CHEWING);
        secondPremolar45.setSurfaces(secondPremolar45Surfaces);

        Root root45a = new Root();
        Channel channel45a1 = new Channel();
        List<Channel> channels45a = new ArrayList();
        channels45a.add(channel45a1);
        root45a.setChannels(channels45a);

        List<Channel> secondPremolar45totChann = new ArrayList<>();
        secondPremolar45totChann.addAll(channels45a);
        secondPremolar45.setChannels(secondPremolar45totChann);

        List<Root> secondPremolar45TotRoots = new ArrayList<>();
        secondPremolar45TotRoots.add(root45a);
        secondPremolar45.setRoots(secondPremolar45TotRoots);

        return secondPremolar45;
    }
}
