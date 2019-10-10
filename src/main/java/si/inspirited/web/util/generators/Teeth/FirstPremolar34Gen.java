package si.inspirited.web.util.generators.Teeth;

import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class FirstPremolar34Gen {

    public Tooth initNew() {
        Tooth firstPremolar34 = new Tooth();
        firstPremolar34.setIndex(34);
        firstPremolar34.setName(Teeth.FIRST_PREMOLAR);

        List<Surfaces> firstPremolar34Surfaces = new ArrayList<>();
        firstPremolar34Surfaces.add(Surfaces.MEDIAL);
        firstPremolar34Surfaces.add(Surfaces.DISTAl);
        firstPremolar34Surfaces.add(Surfaces.BUCCAL);
        firstPremolar34Surfaces.add(Surfaces.LINGUAL);
        firstPremolar34Surfaces.add(Surfaces.CHEWING);
        firstPremolar34.setSurfaces(firstPremolar34Surfaces);

        Root root34a = new Root();
        Channel channel34a1 = new Channel();
        List<Channel> channels34a = new ArrayList();
        channels34a.add(channel34a1);
        root34a.setChannels(channels34a);

        List<Channel> firstPremolar34totChann = new ArrayList<>();
        firstPremolar34totChann.addAll(channels34a);
        firstPremolar34.setChannels(firstPremolar34totChann);

        List<Root> firstPremolar34TotRoots = new ArrayList<>();
        firstPremolar34TotRoots.add(root34a);
        firstPremolar34.setRoots(firstPremolar34TotRoots);

        return firstPremolar34;
    }
}
