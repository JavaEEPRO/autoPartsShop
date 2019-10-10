package si.inspirited.web.util.generators.Teeth.upper;

import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class CentrCut11Gen {

    public Tooth initNew() {

        Tooth centralCutter11 = new Tooth();
        centralCutter11.setIndex(11);
        centralCutter11.setName(Teeth.CENTRAL_CUTTER);

        List<Surfaces> centralCutter11Surfaces = new ArrayList<>();
        centralCutter11Surfaces.add(Surfaces.MEDIAL);
        centralCutter11Surfaces.add(Surfaces.DISTAl);
        centralCutter11Surfaces.add(Surfaces.LABIAL);
        centralCutter11Surfaces.add(Surfaces.LINGUAL);
        centralCutter11.setSurfaces(centralCutter11Surfaces);

        Root root11a = new Root();
        Channel channel11a1 = new Channel();
        List<Channel> channels11a = new ArrayList();
        channels11a.add(channel11a1);
        root11a.setChannels(channels11a);

        List<Channel> centralCutter11totChann = new ArrayList<>();
        centralCutter11totChann.addAll(channels11a);
        centralCutter11.setChannels(centralCutter11totChann);

        List<Root> centralCutter11TotRoots = new ArrayList<>();
        centralCutter11TotRoots.add(root11a);
        centralCutter11.setRoots(centralCutter11TotRoots);

        return centralCutter11;
    }
}
