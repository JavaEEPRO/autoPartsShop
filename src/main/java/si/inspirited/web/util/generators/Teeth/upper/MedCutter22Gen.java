package si.inspirited.web.util.generators.Teeth.upper;

import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class MedCutter22Gen {

    public Tooth initNew() {

        Tooth medialCutter22 = new Tooth();
        medialCutter22.setIndex(22);
        medialCutter22.setName(Teeth.MEDIAL_CUTTER);

        List<Surfaces> medialCutter22Surfaces = new ArrayList<>();
        medialCutter22Surfaces.add(Surfaces.MEDIAL);
        medialCutter22Surfaces.add(Surfaces.DISTAl);
        medialCutter22Surfaces.add(Surfaces.LABIAL);
        medialCutter22Surfaces.add(Surfaces.LINGUAL);
        medialCutter22.setSurfaces(medialCutter22Surfaces);


        Root root22a = new Root();
        Channel channel22a1 = new Channel();
        List<Channel> channels22a = new ArrayList();
        channels22a.add(channel22a1);
        root22a.setChannels(channels22a);

        List<Channel> medialCutter22totChann = new ArrayList<>();
        medialCutter22totChann.addAll(channels22a);
        medialCutter22.setChannels(medialCutter22totChann);

        List<Root> medialCutter22TotRoots = new ArrayList<>();
        medialCutter22TotRoots.add(root22a);
        medialCutter22.setRoots(medialCutter22TotRoots);

        return medialCutter22;
    }
}
