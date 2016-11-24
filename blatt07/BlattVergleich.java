import java.util.Comparator;

/**
 * Created by abraining on 23.11.2016.
 */
public class BlattVergleich implements Comparator<Blatt> {
    /**
     * compare(Blatt o1, Blatt o2) vergleicht das Blatt o1 mit o2
     * @param o1 Blatt von dem ausgegangen wird
     * @param o2 Blatt mit dem verglichen wird
     * @return wenn o1 einen höheren Wert als o2 hat, wird 1 zurückgegeben
     * wenn o1 einen niedrigeren Wert als o2 hat, wird -1 zurückgegeben
     * wenn o1 und o2 äquivalent sind, dann wird 0 ausgegeben
     */
    @Override
    public int compare(Blatt o1, Blatt o2) {
        //Drilling Handling
        if(o1.isDrilling() && !o2.isDrilling()) return 1; //o1 Drilling, o2 nicht
        else if(!o1.isDrilling() && o2.isDrilling()) return -1; //o1 kein Drilling, o2 doch
        //---------------------------------------------------------
        //Paar Handling
        else if(o1.isPaar() && o2.isPaar()){ //untershiedliche Paare
            int[] paarStellen1 = o1.gibPaarStellen();
            int[] paarStellen2 = o2.gibPaarStellen();

            if(o1.getBlatt()[paarStellen1[0]] != o2.getBlatt()[paarStellen2[0]])
                return o1.getBlatt()[paarStellen1[0]] - o2.getBlatt()[paarStellen2[0]];
        }
        else if(o1.isPaar() && !o2.isPaar()) return 1; //o1 Paar, o2 nicht
        else if(!o1.isPaar() && o2.isPaar()) return -1; //o1 kein Paar, o2 doch
        //----------------------------------------------------------
        //Rest: Komplett unterschiedlich, gleiche Paare/ Drillinge
        int sum1 = 0;
        int sum2 = 0;
        for(int i:o1.getBlatt()) sum1 += i;
        for(int i:o2.getBlatt()) sum2 += i;

        if(sum1 > sum2) return 1;
        else if(sum1  < sum2) return -1;
        return 0;
    }
}
