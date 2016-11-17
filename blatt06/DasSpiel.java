/**
 * Created by abraining on 16.11.2016.
 */
public class DasSpiel {
    public static void main(String[] args){
        GefDilemma gd=new GefDilemma(new Random(), new Random());
        gd.spiele(100);
    }
}
