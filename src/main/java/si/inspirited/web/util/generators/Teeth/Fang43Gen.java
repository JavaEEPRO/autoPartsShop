package si.inspirited.web.util.generators.Teeth;

import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class Fang43Gen {

    public Tooth initNew() {
        Tooth fang43 = new Tooth();
        fang43.setIndex(43);
        fang43.setName(Teeth.FANG);

        List<Surfaces> fang43Surfaces = new ArrayList<>();
        fang43Surfaces.add(Surfaces.MEDIAL);
        fang43Surfaces.add(Surfaces.DISTAl);
        fang43Surfaces.add(Surfaces.LABIAL);
        fang43Surfaces.add(Surfaces.LINGUAL);
        fang43.setSurfaces(fang43Surfaces);

        Root root43a = new Root();
        Channel channel43a1 = new Channel();
        List<Channel> channels43a = new ArrayList();
        channels43a.add(channel43a1);
        root43a.setChannels(channels43a);

        List<Channel> fang43totChann = new ArrayList<>();
        fang43totChann.addAll(channels43a);
        fang43.setChannels(fang43totChann);

        List<Root> fang43TotRoots = new ArrayList<>();
        fang43TotRoots.add(root43a);
        fang43.setRoots(fang43TotRoots);

        return fang43;
    }
}
