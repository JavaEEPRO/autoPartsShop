package si.inspirited.web.util.generators.Teeth;

import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class MedCutter42Gen {

    public Tooth initNew() {
        Tooth medialCutter42 = new Tooth();
        medialCutter42.setIndex(42);
        medialCutter42.setName(Teeth.MEDIAL_CUTTER);

        List<Surfaces> medialCutter42Surfaces = new ArrayList<>();
        medialCutter42Surfaces.add(Surfaces.MEDIAL);
        medialCutter42Surfaces.add(Surfaces.DISTAl);
        medialCutter42Surfaces.add(Surfaces.LABIAL);
        medialCutter42Surfaces.add(Surfaces.LINGUAL);
        medialCutter42.setSurfaces(medialCutter42Surfaces);

        Root root42a = new Root();
        Channel channel42a1 = new Channel();
        List<Channel> channels42a = new ArrayList();
        channels42a.add(channel42a1);
        root42a.setChannels(channels42a);

        List<Channel> medialCutter42totChann = new ArrayList<>();
        medialCutter42totChann.addAll(channels42a);
        medialCutter42.setChannels(medialCutter42totChann);

        List<Root> medialCutter42TotRoots = new ArrayList<>();
        medialCutter42TotRoots.add(root42a);
        medialCutter42.setRoots(medialCutter42TotRoots);

        return medialCutter42;
    }
}
