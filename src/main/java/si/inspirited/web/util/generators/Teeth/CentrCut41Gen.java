package si.inspirited.web.util.generators.Teeth;

import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class CentrCut41Gen {

    public Tooth initNew() {
        Tooth centralCutter41 = new Tooth();
        centralCutter41.setIndex(41);
        centralCutter41.setName(Teeth.CENTRAL_CUTTER);

        List<Surfaces> centralCutter41Surfaces = new ArrayList<>();
        centralCutter41Surfaces.add(Surfaces.MEDIAL);
        centralCutter41Surfaces.add(Surfaces.DISTAl);
        centralCutter41Surfaces.add(Surfaces.LABIAL);
        centralCutter41Surfaces.add(Surfaces.LINGUAL);
        centralCutter41.setSurfaces(centralCutter41Surfaces);

        Root root41a = new Root();
        Channel channel41a1 = new Channel();
        List<Channel> channels41a = new ArrayList();
        channels41a.add(channel41a1);
        root41a.setChannels(channels41a);

        List<Channel> centralCutter41totChann = new ArrayList<>();
        centralCutter41totChann.addAll(channels41a);
        centralCutter41.setChannels(centralCutter41totChann);

        List<Root> centralCutter41TotRoots = new ArrayList<>();
        centralCutter41TotRoots.add(root41a);
        centralCutter41.setRoots(centralCutter41TotRoots);

        return centralCutter41;
    }
}
