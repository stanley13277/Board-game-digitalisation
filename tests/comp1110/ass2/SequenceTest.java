package comp1110.ass2;

/**
 * This test is used to check the method sequence() in StepsGame, Full right, wrong placement, random right and random wrong are created below.
 * Created by PENG YONG 26/09/2017
 */

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class SequenceTest {

    final String[] WRONGPLACEMENTS = {
            "AALBDxCEQDBgEHuFGSGEOHEc",
            "AALBAkCGODBgEDIFHnGGQHCi",
            "ADgBAkCGODAiEDIFHnGGQHBL",
            "AALBBgCAkDFQEBxFDNGGSHCi",
            "AALBAmCAkDFQEAgFDNGGSHCi",
            "AALBBgCAkDFQEHwFDNGGSHCi",
            "ADgBBGCDkDAiEAoFCLGHSHBN",
            "ADgBBGCDkDAiEAoFDNGHSHBL",
            "AALBBGCAkDBgEAoFDNGHSHCi",
            "ADgBBGCDkDAiEAoFDNGFSHBL",
            "ADgBBGCDkDAiEAoFCLGFSHBN",
            "AALBBGCAkDBgEAoFDNGFSHCi",
            "AALBBgCAkDFOEDIFHnGGQHCi",
            "AALBAkCAgDFOEDIFHnGGQHCi",
            "AALBAkCGQDBgEGOFGSGEnHCi",
            "ADgBCTCGQDAiEGOFElGEnHBL",
            "AALBCTCGQDBgEGOFElGEnHCi",
            "ADgBAkCGQDAiEGOFGSGEnHBL"
    };
    final String[] RIGHTPLACEMENTS = {
            "CEQEHuGEOBDxFGSHCiAALDBg",
            "BGKEGOCGQAGlHCiDBgGGnFGS",
            "BHFFCLHBNAGlCAiDBgGGnEDI",
            "CHSAHQGFjHCNBGKDBgFHlEAo",
            "GDLADgHAiEFFCGcDAkBDxFGS",
            "DFOCGQGDLADgHFjBGSFHlEAo",
            "HBLADgBHnCGODAiGElFGQEDI",
            "BGKFCNCHSAHQHFnEBvGAiDBg",
            "DFOAALHHnGAkFGQCAiBBgEDI",
    };
    final String[] ONE = {"EEf", "CHS","BGK","FCN"};

    final String[] RandomTrue = {"BGKFCNCFl","BGKFCNCFlAFnHHSGAiECPDBg","BGKFCNCFlAFnHHSGAi","CFjBGKGAg","EEfDHnBCT",
            "EGOHBL","CEQEHu","GEOBDx","EGOCGQ","EGOHBL"};

    final String[] RandomFasle = {"AALBAkCGODBgEDIFHnGGQ",
            "ADgBAkCGODAiEDIFHnGGQ",
            "AALBBgCAkDFQEBxFDN",
            "AALBAmCAkDFQEAg",
            "AALBBgCAkDFQ",
            "ADgBBGCDkDAi",
            "AALBBgCAkDFOEDI",
            "AALBAkCAgDFOEDIFHn",
            "AALBAkCGQDBgEGO",
            "ADgBCTCGQDAiEGO",
            "AALBCTCGQDBgEGOFEl",
            "ADgBAkCGQDAiEGO"};

    @Rule
    public Timeout globalTime = Timeout.seconds(2);

    /*
     * WRONGPLACEMENTS contain full 8 piece in the string but they are overlap.
     * Therefore, the StepsGame.sequence(m) will return false when m is overlap.
     * The test below will pass if all StepsGame.sequence(m) return false because all m is overlap
     */

    @Test
    public void testFalse() {
        for (String m : WRONGPLACEMENTS)
            assertFalse(StepsGame.sequence(m));
    }
    /*
     * RIGHTPLACEMENTS contain full 8 piece in the string and they are not overlap.
     * Therefore, the StepsGame.sequence(m) will return true when m is not overlap.
     * The test below will pass if all StepsGame.sequence(m) return true because all m is not overlap
     */

    @Test
    public void testTrue() {
        for (String m : RIGHTPLACEMENTS)
            assertTrue(StepsGame.sequence(m));
    }

    /*
     * when one piece is placed, the method must return true. The test should pass.
     */
    @Test
    public void testone(){
        for (String m: ONE){
            assertTrue(StepsGame.sequence(m));
        }
    }

    /*
     * RandomTrue contains random pieces and the placement is not overlap.
     * The tests should pass all the tests if the method is right.
     */

    @Test
    public void TestRandomTrue(){
        for (String m: RandomTrue){
            assertTrue(StepsGame.sequence(m));
        }
    }

    /*
     * RandomFalse contains random pieces and the placement is overlap.
     * The method will return false if the placement is overlap.
     * The tests should pass all the tests if the method is right.
     */

    @Test
    public void TestRandomFasle(){
        for (String m: RandomFasle){
            assertFalse(StepsGame.sequence(m));
        }
    }
}
