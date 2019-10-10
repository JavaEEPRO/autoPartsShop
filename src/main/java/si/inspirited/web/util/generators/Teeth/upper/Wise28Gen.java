package si.inspirited.web.util.generators.Teeth.upper;

import si.inspirited.persistence.model.registry.enums.Localizations;
import si.inspirited.persistence.model.registry.enums.Surfaces;
import si.inspirited.persistence.model.registry.enums.Teeth;
import si.inspirited.persistence.model.registry.teeth.Channel;
import si.inspirited.persistence.model.registry.teeth.Root;
import si.inspirited.persistence.model.registry.teeth.Tooth;

import java.util.ArrayList;
import java.util.List;

public class Wise28Gen {

    public Tooth initNew() {

        Tooth wisdom28 = new Tooth();
        wisdom28.setIndex(28);
        wisdom28.setName(Teeth.WISDOM_TOOTH);

        List<Surfaces> wisdom28Surfaces = new ArrayList<>();
        wisdom28Surfaces.add(Surfaces.MEDIAL);
        wisdom28Surfaces.add(Surfaces.DISTAl);
        wisdom28Surfaces.add(Surfaces.BUCCAL);
        wisdom28Surfaces.add(Surfaces.LINGUAL);
        wisdom28Surfaces.add(Surfaces.CHEWING);
        wisdom28.setSurfaces(wisdom28Surfaces);

        Root root28a = new Root();
        Channel channel28a1 = new Channel();

        List<Localizations> channel28a1Localizations = new ArrayList<>();
        channel28a1Localizations.add(Localizations.MEDIAL);
        channel28a1Localizations.add(Localizations.LINGUAL);
        channel28a1.setLocalizations(channel28a1Localizations);
        Channel channel28a2 = new Channel();
        List<Localizations> channel28a2Localizations = new ArrayList<>();
        channel28a2Localizations.add(Localizations.MEDIAL);
        channel28a2Localizations.add(Localizations.BUCCAL);
        channel28a2.setLocalizations(channel28a2Localizations);

        List<Channel> channels28a = new ArrayList();
        channels28a.add(channel28a1);
        channels28a.add(channel28a2);
        root28a.setChannels(channels28a);

        List<Localizations> root28aLocalizations = new ArrayList<>();
        root28aLocalizations.add(Localizations.MEDIAL);
        root28aLocalizations.add(Localizations.BUCCAL);
        root28a.setLocalizations(root28aLocalizations);

        Root root28b = new Root();
        Channel channel28b1 = new Channel();
        //List<Localizations> channel28b1Localizations = new ArrayList<>();
        //channel28b1Localizations.add(Localizations.DISTAL);
        //channel28b1Localizations.add(Localizations.BUCCAL);
        //channel28b1.setLocalizations(channel28b1Localizations);
        //Channel channel28b2 = new Channel();
        //List<Localizations> channel28b2Localizations = new ArrayList<>();
        //channel28b2Localizations.add(Localizations.DISTAL);
        //channel28b2Localizations.add(Localizations.LINGUAL);
        //channel28b2.setLocalizations(channel28b2Localizations);

        List<Channel> channels28b = new ArrayList();
        channels28b.add(channel28b1);
        //channels28b.add(channel28b2);
        root28b.setChannels(channels28b);

        List<Localizations> root28bLocalizations = new ArrayList<>();
        root28bLocalizations.add(Localizations.DISTAL);
        root28bLocalizations.add(Localizations.BUCCAL);
        root28b.setLocalizations(root28bLocalizations);

        Root root28c = new Root();
        Channel channel28c1 = new Channel();

//        List<Localizations> channel28c1Localizations = new ArrayList<>();
//        channel28c1Localizations.add(Localizations.DISTAL);
//        channel28c1Localizations.add(Localizations.BUCCAL);
//        channel28c1.setLocalizations(channel28c1Localizations);
//        Channel channel28c2 = new Channel();
//        List<Localizations> channel28c2Localizations = new ArrayList<>();
//        channel28c2Localizations.add(Localizations.DISTAL);
//        channel28c2Localizations.add(Localizations.LINGUAL);
//        channel28c2.setLocalizations(channel28c2Localizations);

        List<Channel> channels28c = new ArrayList();
        channels28c.add(channel28c1);
        //channels28c.add(channel28c2);
        root28c.setChannels(channels28c);

        List<Localizations> root28cLocalizations = new ArrayList<>();
        root28cLocalizations.add(Localizations.LINGUAL);
        root28c.setLocalizations(root28cLocalizations);

        List<Channel> wisdom28totChann = new ArrayList<>();
        wisdom28totChann.addAll(channels28a);
        wisdom28totChann.addAll(channels28b);
        wisdom28totChann.addAll(channels28c);
        wisdom28.setChannels(wisdom28totChann);

        List<Root> wisdom28TotRoots = new ArrayList<>();
        wisdom28TotRoots.add(root28a);
        wisdom28TotRoots.add(root28b);
        wisdom28TotRoots.add(root28c);
        wisdom28.setRoots(wisdom28TotRoots);

        return wisdom28;
    }
}
