package si.inspirited.web.util.generators.Teeth;

import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class MedCutter32Gen {

    public Tooth initNew() {
        Tooth medialCutter32 = new Tooth();
        medialCutter32.setIndex(32);
        medialCutter32.setName(Teeth.MEDIAL_CUTTER);

        List<Surfaces> medialCutter32Surfaces = new ArrayList<>();
        medialCutter32Surfaces.add(Surfaces.MEDIAL);
        medialCutter32Surfaces.add(Surfaces.DISTAl);
        medialCutter32Surfaces.add(Surfaces.LABIAL);
        medialCutter32Surfaces.add(Surfaces.LINGUAL);
        medialCutter32.setSurfaces(medialCutter32Surfaces);

        Root root32a = new Root();
        Channel channel32a1 = new Channel();
        List<Channel> channels32a = new ArrayList();
        channels32a.add(channel32a1);
        root32a.setChannels(channels32a);

        List<Channel> medialCutter32totChann = new ArrayList<>();
        medialCutter32totChann.addAll(channels32a);
        medialCutter32.setChannels(medialCutter32totChann);

        List<Root> medialCutter32TotRoots = new ArrayList<>();
        medialCutter32TotRoots.add(root32a);
        medialCutter32.setRoots(medialCutter32TotRoots);

        return medialCutter32;
    }
}
