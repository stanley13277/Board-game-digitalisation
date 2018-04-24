package comp1110.ass2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestTrueTest {
    final String[] WRONG = {
            "AALBDxCEQDBgEHuFGSGEOHEc"
    };
    final String[] one = {"BDx","CEQ","DBg","EHu","FGS","GEO","HEc"};
    final String wrongPlcament = "AAL";



    final String[][] right = {
            {"HCi","AAL","DBg"}, {"FGS","GGn","DBg"},{"EDI","GGn","DBg","CAi","AGl"},{"BGK","DBg","FHl","EAo"},
            {"DAk","BDx","FGS"},{"GDL","ADg","HFj","BGS","FHl","EAo"},{"GEl","FGQ","EDI"},{"HFn","EBv","GAi","DBg"},{"BBg","EDI"}};


    final String[] RIGHTPlacement = {
            "CEQEHuGEOBDxFGS", "BGKEGOCGQAGlHCi", "BHFFCLHBN", "CHSAHQGFjHCN", "GDLADgHAiEFFCGc",
            "DFOCGQ", "HBLADgBHnCGODAi", "BGKFCNCHSAHQ", "DFOAALHHnGAkFGQCAi"};
    @Rule
    public Timeout globalTime = Timeout.seconds(2);

    /*
     * The test use the string (all placements are right ) in the right above.
     * The tests will pass if the method is right. All placements are not overlap.
     */
    @Test
    public void testRight(){
        List<Set<String>> one =new ArrayList<>();
        Set<String> two = new HashSet<>();
        for (int i = 0; i < right.length; i++){
            for (int m = 0; m < right[i].length; m++){
                two.add(right[i][m]);
            }
            two.clear();
            one.add(two);
        }
        for (int i = 0; i < right.length; i++){
            for (int m = 0; m < right[i].length; m++){
                assertTrue(StepsGame.testTrue(right[i][m],RIGHTPlacement[i], one.get(i)));
            }
        }
    }

    /*
     * The test use the string (all placements are wrong ) in the wrongPlacement above.
     * The tests will pass if the method is right. The placement is overlap.
     */

    @Test
    public void testWrong(){
        Set<String> two = new HashSet<>();
        for (String l: one){
            two.add(l);
        }
        for (String m: one){
            assertFalse(StepsGame.testTrue(m, wrongPlcament,two));
        }
    }
}
