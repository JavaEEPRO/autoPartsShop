package si.inspirited.web.util.generators.Teeth;

import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class Fang33Gen {

    public Tooth initNew() {
        Tooth fang33 = new Tooth();
        fang33.setIndex(33);
        fang33.setName(Teeth.FANG);

        List<Surfaces> fang33Surfaces = new ArrayList<>();
        fang33Surfaces.add(Surfaces.MEDIAL);
        fang33Surfaces.add(Surfaces.DISTAl);
        fang33Surfaces.add(Surfaces.LABIAL);
        fang33Surfaces.add(Surfaces.LINGUAL);
        fang33.setSurfaces(fang33Surfaces);

        Root root33a = new Root();
        Channel channel33a1 = new Channel();
        List<Channel> channels33a = new ArrayList();
        channels33a.add(channel33a1);
        root33a.setChannels(channels33a);

        List<Channel> fang33totChann = new ArrayList<>();
        fang33totChann.addAll(channels33a);
        fang33.setChannels(fang33totChann);

        List<Root> fang33TotRoots = new ArrayList<>();
        fang33TotRoots.add(root33a);
        fang33.setRoots(fang33TotRoots);

        return fang33;
    }
}
