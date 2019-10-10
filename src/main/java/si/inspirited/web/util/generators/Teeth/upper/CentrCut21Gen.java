package si.inspirited.web.util.generators.Teeth.upper;

import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class CentrCut21Gen {

    public Tooth initNew() {

        Tooth centralCutter21 = new Tooth();
        centralCutter21.setIndex(21);
        centralCutter21.setName(Teeth.CENTRAL_CUTTER);

        List<Surfaces> centralCutter21Surfaces = new ArrayList<>();
        centralCutter21Surfaces.add(Surfaces.MEDIAL);
        centralCutter21Surfaces.add(Surfaces.DISTAl);
        centralCutter21Surfaces.add(Surfaces.LABIAL);
        centralCutter21Surfaces.add(Surfaces.LINGUAL);
        centralCutter21.setSurfaces(centralCutter21Surfaces);

        Root root21a = new Root();
        Channel channel21a1 = new Channel();
        List<Channel> channels21a = new ArrayList();
        channels21a.add(channel21a1);
        root21a.setChannels(channels21a);

        List<Channel> centralCutter21totChann = new ArrayList<>();
        centralCutter21totChann.addAll(channels21a);
        centralCutter21.setChannels(centralCutter21totChann);

        List<Root> centralCutter21TotRoots = new ArrayList<>();
        centralCutter21TotRoots.add(root21a);
        centralCutter21.setRoots(centralCutter21TotRoots);

        return centralCutter21;
    }
}
