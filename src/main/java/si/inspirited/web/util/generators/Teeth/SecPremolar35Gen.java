package si.inspirited.web.util.generators.Teeth;

import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class SecPremolar35Gen {

    public Tooth initNew() {
        Tooth secondPremolar35 = new Tooth();
        secondPremolar35.setIndex(35);
        secondPremolar35.setName(Teeth.SECOND_PREMOLAR);

        List<Surfaces> secondPremolar35Surfaces = new ArrayList<>();
        secondPremolar35Surfaces.add(Surfaces.MEDIAL);
        secondPremolar35Surfaces.add(Surfaces.DISTAl);
        secondPremolar35Surfaces.add(Surfaces.BUCCAL);
        secondPremolar35Surfaces.add(Surfaces.LINGUAL);
        secondPremolar35Surfaces.add(Surfaces.CHEWING);
        secondPremolar35.setSurfaces(secondPremolar35Surfaces);

        Root root35a = new Root();
        Channel channel35a1 = new Channel();
        List<Channel> channels35a = new ArrayList();
        channels35a.add(channel35a1);
        root35a.setChannels(channels35a);

        List<Channel> secondPremolar35totChann = new ArrayList<>();
        secondPremolar35totChann.addAll(channels35a);
        secondPremolar35.setChannels(secondPremolar35totChann);

        List<Root> secondPremolar35TotRoots = new ArrayList<>();
        secondPremolar35TotRoots.add(root35a);
        secondPremolar35.setRoots(secondPremolar35TotRoots);

        return secondPremolar35;
    }
}
