package si.inspirited.web.util.generators.Teeth;

import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class CentrCut31Gen {

    public Tooth initNew() {
        Tooth centralCutter31 = new Tooth();
        centralCutter31.setIndex(31);
        centralCutter31.setName(Teeth.CENTRAL_CUTTER);

        List<Surfaces> centralCutter31Surfaces = new ArrayList<>();
        centralCutter31Surfaces.add(Surfaces.MEDIAL);
        centralCutter31Surfaces.add(Surfaces.DISTAl);
        centralCutter31Surfaces.add(Surfaces.LABIAL);
        centralCutter31Surfaces.add(Surfaces.LINGUAL);
        centralCutter31.setSurfaces(centralCutter31Surfaces);

        Root root31a = new Root();
        Channel channel31a1 = new Channel();
        List<Channel> channels31a = new ArrayList();
        channels31a.add(channel31a1);
        root31a.setChannels(channels31a);

        List<Channel> centralCutter31totChann = new ArrayList<>();
        centralCutter31totChann.addAll(channels31a);
        centralCutter31.setChannels(centralCutter31totChann);

        List<Root> centralCutter31TotRoots = new ArrayList<>();
        centralCutter31TotRoots.add(root31a);
        centralCutter31.setRoots(centralCutter31TotRoots);

        return centralCutter31;
    }
}
