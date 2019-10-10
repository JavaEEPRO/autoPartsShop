package si.inspirited.web.util.generators.Teeth.upper;

import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class Fang23Gen {

    public Tooth initNew() {

        Tooth fang23 = new Tooth();
        fang23.setIndex(23);
        fang23.setName(Teeth.FANG);

        List<Surfaces> fang23Surfaces = new ArrayList<>();
        fang23Surfaces.add(Surfaces.MEDIAL);
        fang23Surfaces.add(Surfaces.DISTAl);
        fang23Surfaces.add(Surfaces.LABIAL);
        fang23Surfaces.add(Surfaces.LINGUAL);
        fang23.setSurfaces(fang23Surfaces);

        Root root23a = new Root();
        Channel channel23a1 = new Channel();
        List<Channel> channels23a = new ArrayList();
        channels23a.add(channel23a1);
        root23a.setChannels(channels23a);

        List<Channel> fang23totChann = new ArrayList<>();
        fang23totChann.addAll(channels23a);
        fang23.setChannels(fang23totChann);

        List<Root> fang23TotRoots = new ArrayList<>();
        fang23TotRoots.add(root23a);
        fang23.setRoots(fang23TotRoots);

        return fang23;
    }
}
