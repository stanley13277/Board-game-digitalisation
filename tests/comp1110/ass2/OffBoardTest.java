package comp1110.ass2;

/**
 * This test is used to test whether the piece is off board.
 * To test this, the two side and four corner position have been considered in this situation
 Create by PENG YONG 26/09/2016
*/


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Random;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OffBoardTest {
    final String[] WORNGPLACEMENTS = {
            "CEQEHuGEOBDxFGSHCiAALDBg",
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

    final String[] PIECES = {
            "AA","AB","AC","AD","AE","AF","AG","AH",
            "BA","BB","BC","BD","BE","BF","BG","BH",
            "CA","CB","CC","CD","CE","CF","CG","CH",
            "DA","DB","DC","DD","DE","DF","DG","DH",
            "EA","EB","EC","ED","DE","EF","EG","EH",
            "FA","FB","FC","FD","FE","FF","FG","FH",
            "GA","GB","GC","GD","GE","GF","GG","GH",
            "HA","HB","HC","HD","FE","HF","HG","HH"};
    String[] NotSides = {
            "AA","AB","AC","AD","AE","AF","AG","AH",
            "CA","CB","CC","CD","CE","CF","CG","CH",
            "DA","DB","DC","DD","DE","DF","DG","DH",
            "FA","FB","FC","FD","FE","FF","FG","FH",
            "GA","GB","GC","GD","GE","GF","GG","GH",
            "HA","HB","HC","HD","FE","HF","HG","HH"};

    final String[] SIDES = {"BA","BB","BC","BD","BE","BF","BG","BH",
            "EA","EB","EC","ED","DE","EF","EG","EH"};
    final String[] corner = {"A","J","p","y"};
    final String[] InsideLocation = {
            "L","M","N","O","P","Q","R","S",
            "V","W","X","Y","a","b","c","d",
            "g","h","i","j","k","l","m","n"};

    final String[] SIDELOCATION = {
            "A","B","C","D","E","F","G","H","I","J","T","K","U","e","f","o","p","q","r","s","t","u","v","w","x","y"};
    /*
     *The test should be finished within 2 seconds
     */
    @Rule
    public Timeout globalTime = Timeout.seconds(2);

    /*
     *Once the pieces contain corner position, the piece must be off the board.
     */
    @Test
    public void pieceCorner(){
        String test = new String();
        for (String m: PIECES){
            for (String n: corner){
                test = m + n;
                assertFalse(StepsGame.OffBoard(test));
            }
        }
    }

    /*
     * Below shows that the placements that contains corner position must be off the board.
     * the number of piece is from 1 to 8 and all test in below.
     */

    @Test
    public void PlacementCorner(){
        Random R = new Random();
        int m = R.nextInt(PIECES.length);
        int n = R.nextInt(InsideLocation.length);
        int p = R.nextInt(corner.length);
        for (int i = 0; i < 1000; i++){
            String one = PIECES[m] + InsideLocation[n] + PIECES[m] + corner[p];
            assertFalse(StepsGame.OffBoard(one));
        }
        for (int i = 0; i < 1000; i++){
            String two = PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + corner[p];
            assertFalse(StepsGame.OffBoard(two));
        }
        for (int i = 0; i < 1000; i++){
            String three = PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + corner[p];
            assertFalse(StepsGame.OffBoard(three));
        }
        for (int i = 0; i < 1000; i++){
            String four =  PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + corner[p];
            assertFalse(StepsGame.OffBoard(four));
        }

        for (int i = 0; i < 1000; i++){
            String five =   PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + corner[p];
            assertFalse(StepsGame.OffBoard(five));
        }
        for (int i = 0; i < 1000; i++){
            String six =   PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n]+PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + corner[p];
            assertFalse(StepsGame.OffBoard(six));
        }

        for (int i = 0; i < 1000; i++){
            String eight =   PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + corner[p];
            assertFalse(StepsGame.OffBoard(eight));
        }
        for (int i = 0; i < 1000; i++){
            String eight =   PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + corner[p];
            assertFalse(StepsGame.OffBoard(eight));
        }


    }

    /*
     * the sides tests is to test that when piece is placed on the side of board, whether it is off the board.
     * the number of pieces is form 1 to 8 and all have been tested in the below.
     */

    @Test
    public void testSides(){
        Random R = new Random();
        int n = R.nextInt(InsideLocation.length);
        int m = R.nextInt(NotSides.length);
        int p = R.nextInt(SIDELOCATION.length);
        for (int i = 0; i < 1000; i++){
            String testone =  NotSides[m] +  SIDELOCATION[p];
            assertFalse(StepsGame.OffBoard(testone));
        }
        for (int i = 0; i < 1000; i++){
            String two =  PIECES[m] + InsideLocation[n] + NotSides[m] +  SIDELOCATION[p];
            assertFalse(StepsGame.OffBoard(two));
        }
        for (int i = 0; i < 1000; i++){
            String three =  PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + NotSides[m] +  SIDELOCATION[p];
            assertFalse(StepsGame.OffBoard(three));
        }
        for (int i = 0; i < 1000; i++){
            String four =  PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + NotSides[m] +  SIDELOCATION[p];
            assertFalse(StepsGame.OffBoard(four));
        }
        for (int i = 0; i < 1000; i++){
            String four =  PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + NotSides[m] +  SIDELOCATION[p];
            assertFalse(StepsGame.OffBoard(four));
        }
        for (int i = 0; i < 1000; i++){
            String four =  PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + NotSides[m] +  SIDELOCATION[p];
            assertFalse(StepsGame.OffBoard(four));
        }
        for (int i = 0; i < 1000; i++){
            String five =  PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + NotSides[m] +  SIDELOCATION[p];
            assertFalse(StepsGame.OffBoard(five));
        }
        for (int i = 0; i < 1000; i++){
            String eight =  PIECES[m] + InsideLocation[n]+ PIECES[m] + InsideLocation[n]+ PIECES[m] + InsideLocation[n]+PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + PIECES[m] + InsideLocation[n] + NotSides[m] +  SIDELOCATION[p];
            assertFalse(StepsGame.OffBoard(eight));
        }
    }

    /*
     * The test below is used to test whether the placement is off the board.
     * If the placement off the board, testFalse will pass and OffBoard will return true.
     */
    @Test
    public void testFalse(){
        for (String m: WORNGPLACEMENTS)
        assertTrue(StepsGame.OffBoard(m));
    }

    /*
     * The test below is used to test whether the placement is off the board.
     * If the placement off the board, testFalse will pass and OffBoard will return false.
     */


}
