package si.inspirited.web.util.generators.Teeth;

import si.inspirited.persistence.model.registry.enums.Localizations;
import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class SecMolar47Gen {

    public Tooth initNew() {

        Tooth secondMolar47 = new Tooth();
        secondMolar47.setIndex(47);
        secondMolar47.setName(Teeth.SECOND_MOLAR);

        List<Surfaces> secondMolar47Surfaces = new ArrayList<>();
        secondMolar47Surfaces.add(Surfaces.MEDIAL);
        secondMolar47Surfaces.add(Surfaces.DISTAl);
        secondMolar47Surfaces.add(Surfaces.BUCCAL);
        secondMolar47Surfaces.add(Surfaces.LINGUAL);
        secondMolar47Surfaces.add(Surfaces.CHEWING);
        secondMolar47.setSurfaces(secondMolar47Surfaces);

        Root root47a = new Root();
        Channel channel47a1 = new Channel();
            List<Localizations> channel47a1Localizations = new ArrayList<>();
        channel47a1Localizations.add(Localizations.MEDIAL);
        channel47a1Localizations.add(Localizations.BUCCAL);
        channel47a1.setLocalizations(channel47a1Localizations);
        Channel channel47a2 = new Channel();
        List<Localizations> channel47a2Localizations = new ArrayList<>();
        channel47a2Localizations.add(Localizations.MEDIAL);
        channel47a2Localizations.add(Localizations.LINGUAL);
        channel47a2.setLocalizations(channel47a2Localizations);
        List<Channel> channels47a = new ArrayList();
        channels47a.add(channel47a1);
        channels47a.add(channel47a2);
        root47a.setChannels(channels47a);

        List<Localizations> root47aLocalizations = new ArrayList<>();
        root47aLocalizations.add(Localizations.MEDIAL);
        root47aLocalizations.add(Localizations.BUCCAL);
        root47a.setLocalizations(root47aLocalizations);

        Root root47b = new Root();
        Channel channel47b1 = new Channel();
            List<Localizations> channel47b1Localizations = new ArrayList<>();
            channel47b1Localizations.add(Localizations.DISTAL);
            channel47b1Localizations.add(Localizations.BUCCAL);
            channel47b1.setLocalizations(channel47b1Localizations);
        Channel channel47b2 = new Channel();
            List<Localizations> channel47b2Localizations = new ArrayList<>();
            channel47b2Localizations.add(Localizations.DISTAL);
            channel47b2Localizations.add(Localizations.LINGUAL);
            channel47b2.setLocalizations(channel47b2Localizations);
        List<Channel> channels47b = new ArrayList();
        channels47b.add(channel47b1);
        channels47b.add(channel47b2);
        root47b.setChannels(channels47b);

        List<Localizations> root47bLocalizations = new ArrayList<>();
        root47bLocalizations.add(Localizations.DISTAL);
        root47bLocalizations.add(Localizations.BUCCAL);
        root47b.setLocalizations(root47bLocalizations);


        List<Channel> secondMolar47totChann = new ArrayList<>();
        secondMolar47totChann.addAll(channels47a);
        secondMolar47totChann.addAll(channels47b);
        secondMolar47.setChannels(secondMolar47totChann);

        List<Root> secondMolar47TotRoots = new ArrayList<>();
        secondMolar47TotRoots.add(root47a);
        secondMolar47TotRoots.add(root47b);
        secondMolar47.setRoots(secondMolar47TotRoots);

        return secondMolar47;
    }

}
