package si.inspirited.web.util.generators.Teeth.upper;

import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class MedCutter12Gen {

    public Tooth initNew() {

        Tooth medialCutter12 = new Tooth();
        medialCutter12.setIndex(12);
        medialCutter12.setName(Teeth.MEDIAL_CUTTER);

        List<Surfaces> medialCutter12Surfaces = new ArrayList<>();
        medialCutter12Surfaces.add(Surfaces.MEDIAL);
        medialCutter12Surfaces.add(Surfaces.DISTAl);
        medialCutter12Surfaces.add(Surfaces.LABIAL);
        medialCutter12Surfaces.add(Surfaces.LINGUAL);
        medialCutter12.setSurfaces(medialCutter12Surfaces);


        Root root12a = new Root();
        Channel channel12a1 = new Channel();
        List<Channel> channels12a = new ArrayList();
        channels12a.add(channel12a1);
        root12a.setChannels(channels12a);

        List<Channel> medialCutter12totChann = new ArrayList<>();
        medialCutter12totChann.addAll(channels12a);
        medialCutter12.setChannels(medialCutter12totChann);

        List<Root> medialCutter12TotRoots = new ArrayList<>();
        medialCutter12TotRoots.add(root12a);
        medialCutter12.setRoots(medialCutter12TotRoots);


        return medialCutter12;
    }
}
