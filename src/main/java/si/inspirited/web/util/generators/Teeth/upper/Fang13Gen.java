package si.inspirited.web.util.generators.Teeth.upper;

import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class Fang13Gen {

    public Tooth initNew() {

        Tooth fang13 = new Tooth();
        fang13.setIndex(13);
        fang13.setName(Teeth.FANG);

        List<Surfaces> fang13Surfaces = new ArrayList<>();
        fang13Surfaces.add(Surfaces.MEDIAL);
        fang13Surfaces.add(Surfaces.DISTAl);
        fang13Surfaces.add(Surfaces.LABIAL);
        fang13Surfaces.add(Surfaces.LINGUAL);
        fang13.setSurfaces(fang13Surfaces);

        Root root13a = new Root();
        Channel channel13a1 = new Channel();
        List<Channel> channels13a = new ArrayList();
        channels13a.add(channel13a1);
        root13a.setChannels(channels13a);

        List<Channel> fang13totChann = new ArrayList<>();
        fang13totChann.addAll(channels13a);
        fang13.setChannels(fang13totChann);

        List<Root> fang13TotRoots = new ArrayList<>();
        fang13TotRoots.add(root13a);
        fang13.setRoots(fang13TotRoots);

        return fang13;
    }
}
