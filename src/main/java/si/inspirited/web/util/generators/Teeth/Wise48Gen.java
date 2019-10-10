package si.inspirited.web.util.generators.Teeth;

import si.inspirited.persistence.model.registry.enums.Localizations;
import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class Wise48Gen {

    public Tooth initNew() {

        Tooth wisdom48 = new Tooth();
        wisdom48.setIndex(48);
        wisdom48.setName(Teeth.WISDOM_TOOTH);

        List<Surfaces> wisdom48Surfaces = new ArrayList<>();
        wisdom48Surfaces.add(Surfaces.MEDIAL);
        wisdom48Surfaces.add(Surfaces.DISTAl);
        wisdom48Surfaces.add(Surfaces.BUCCAL);
        wisdom48Surfaces.add(Surfaces.LINGUAL);
        wisdom48Surfaces.add(Surfaces.CHEWING);
        wisdom48.setSurfaces(wisdom48Surfaces);

        Root root48a = new Root();
        Channel channel48a1 = new Channel();
        List<Localizations> channel48a1Localizations = new ArrayList<>();
        channel48a1Localizations.add(Localizations.MEDIAL);
        channel48a1Localizations.add(Localizations.BUCCAL);
        channel48a1.setLocalizations(channel48a1Localizations);
        Channel channel48a2 = new Channel();
        List<Localizations> channel48a2Localizations = new ArrayList<>();
        channel48a2Localizations.add(Localizations.MEDIAL);
        channel48a2Localizations.add(Localizations.LINGUAL);
        channel48a2.setLocalizations(channel48a2Localizations);
        List<Channel> channels48a = new ArrayList();
        channels48a.add(channel48a1);
        channels48a.add(channel48a2);
        root48a.setChannels(channels48a);

        List<Localizations> root48aLocalizations = new ArrayList<>();
        root48aLocalizations.add(Localizations.MEDIAL);
        root48aLocalizations.add(Localizations.BUCCAL);
        root48a.setLocalizations(root48aLocalizations);

        Root root48b = new Root();
        Channel channel48b1 = new Channel();
        List<Localizations> channel48b1Localizations = new ArrayList<>();
        channel48b1Localizations.add(Localizations.MEDIAL);
        channel48b1Localizations.add(Localizations.LINGUAL);
        channel48b1.setLocalizations(channel48b1Localizations);
        Channel channel48b2 = new Channel();
        List<Localizations> channel48b2Localizations = new ArrayList<>();
        channel48b2Localizations.add(Localizations.MEDIAL);
        channel48b2Localizations.add(Localizations.BUCCAL);
        channel48b2.setLocalizations(channel48b2Localizations);
        List<Channel> channels48b = new ArrayList();
        channels48b.add(channel48b1);
        channels48b.add(channel48b2);
        root48b.setChannels(channels48b);

        List<Localizations> root48bLocalizations = new ArrayList<>();
        root48bLocalizations.add(Localizations.DISTAL);
        root48bLocalizations.add(Localizations.BUCCAL);
        root48b.setLocalizations(root48bLocalizations);

        List<Channel> wisdom48totChann = new ArrayList<>();
        wisdom48totChann.addAll(channels48a);
        wisdom48totChann.addAll(channels48b);
        wisdom48.setChannels(wisdom48totChann);

        List<Root> wisdom48TotRoots = new ArrayList<>();
        wisdom48TotRoots.add(root48a);
        wisdom48TotRoots.add(root48b);
        wisdom48.setRoots(wisdom48TotRoots);

        return wisdom48;
    }
}
