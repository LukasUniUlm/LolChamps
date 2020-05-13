public class Stats {
    double hp;
    double hpperlevel;
    double mp;
    double mpperlevel;
    double armor;
    double armorperlevel;
    double spellbook;
    double spellblockperlevel;
    double attackrange;
    double hpregen;
    double hpregenperlevel;
    double mpregen;
    double mpregenperlevel;
    double crit;
    double critperlevel;
    double attackdamage;
    double attackdamageperlevel;
    double attackspeedoffset;
    double attackspeedperlevel;

    @Override
    public String toString() {
        return "Stats{" +
                "hp=" + hp +
                ", hpperlevel=" + hpperlevel +
                ", mp=" + mp +
                ", mpperlevel=" + mpperlevel +
                ", armor=" + armor +
                ", armorperlevel=" + armorperlevel +
                ", spellbook=" + spellbook +
                ", spellblockperlevel=" + spellblockperlevel +
                ", attackrange=" + attackrange +
                ", hpregen=" + hpregen +
                ", hpregenperlevel=" + hpregenperlevel +
                ", mpregen=" + mpregen +
                ", mpregenperlevel=" + mpregenperlevel +
                ", crit=" + crit +
                ", critperlevel=" + critperlevel +
                ", attackdamage=" + attackdamage +
                ", attackdamageperlevel=" + attackdamageperlevel +
                ", attackspeedoffset=" + attackspeedoffset +
                ", attackspeedperlevel=" + attackspeedperlevel +
                '}';
    }
}
