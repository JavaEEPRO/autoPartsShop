package si.inspirited.web.util.generators.Teeth;

import si.inspirited.persistence.model.registry.enums.Localizations;
import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class FirstMolar36Gen {

    public Tooth initNew() {
        Tooth firstMolar36 = new Tooth();
        firstMolar36.setIndex(36);
        firstMolar36.setName(Teeth.FIRST_MOLAR);

        List<Surfaces> firstMolar36Surfaces = new ArrayList<>();
        firstMolar36Surfaces.add(Surfaces.MEDIAL);
        firstMolar36Surfaces.add(Surfaces.DISTAl);
        firstMolar36Surfaces.add(Surfaces.BUCCAL);
        firstMolar36Surfaces.add(Surfaces.LINGUAL);
        firstMolar36Surfaces.add(Surfaces.CHEWING);
        firstMolar36.setSurfaces(firstMolar36Surfaces);

        Root root36a = new Root();
        Channel channel36a1 = new Channel();
        List<Localizations> channel36a1Localizations = new ArrayList<>();
        channel36a1Localizations.add(Localizations.MEDIAL);
        channel36a1Localizations.add(Localizations.BUCCAL);
        channel36a1.setLocalizations(channel36a1Localizations);
        Channel channel36a2 = new Channel();
        List<Localizations> channel36a2Localizations = new ArrayList<>();
        channel36a2Localizations.add(Localizations.MEDIAL);
        channel36a2Localizations.add(Localizations.LINGUAL);
        channel36a2.setLocalizations(channel36a2Localizations);
        List<Channel> channels36a = new ArrayList();
        channels36a.add(channel36a1);
        channels36a.add(channel36a2);
        root36a.setChannels(channels36a);

        List<Localizations> root36aLocalizations = new ArrayList<>();
        root36aLocalizations.add(Localizations.MEDIAL);
        root36a.setLocalizations(root36aLocalizations);

        Root root36b = new Root();
        Channel channel36b1 = new Channel();
        List<Localizations> channel36b1Localizations = new ArrayList<>();
        channel36b1Localizations.add(Localizations.DISTAL);
        channel36b1Localizations.add(Localizations.BUCCAL);
        channel36b1.setLocalizations(channel36b1Localizations);
        Channel channel36b2 = new Channel();
        List<Localizations> channel36b2Localizations = new ArrayList<>();
        channel36b2Localizations.add(Localizations.DISTAL);
        channel36b2Localizations.add(Localizations.LINGUAL);
        channel36b2.setLocalizations(channel36b2Localizations);
        List<Channel> channels36b = new ArrayList();
        channels36b.add(channel36b1);
        channels36b.add(channel36b2);
        root36b.setChannels(channels36b);

        List<Localizations> root36bLocalizations = new ArrayList<>();
        root36bLocalizations.add(Localizations.DISTAL);
        root36b.setLocalizations(root36bLocalizations);


        List<Channel> firstMolar36totChann = new ArrayList<>();
        firstMolar36totChann.addAll(channels36a);
        firstMolar36totChann.addAll(channels36b);
        firstMolar36.setChannels(firstMolar36totChann);

        List<Root> firstMolar36TotRoots = new ArrayList<>();
        firstMolar36TotRoots.add(root36a);
        firstMolar36TotRoots.add(root36b);
        firstMolar36.setRoots(firstMolar36TotRoots);

        return firstMolar36;
    }
}
