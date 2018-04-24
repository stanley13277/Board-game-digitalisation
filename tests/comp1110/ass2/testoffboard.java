package comp1110.ass2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * Created by u6149684
 * OffBoard function in StepsGame should return false when piece is placed outside of board
 * Test objective:
 * Determine whether a piece is place inside the board or not:
 * - a piece is not allow to place at four corners
 * - the pieces start with "A,C,D,,F,G,H" is not allow to be placed at the side of the board
 * - any piece can be placed at "L,M,N,O,P,Q,R,S,V,W,X,Y,a,b,c,d,g,h,i,j,k,l,m,n" location
 */

public class testoffboard {


    @Rule
    public Timeout globalTimeout = Timeout.millis(2000);

    @Test
    public void testSimple(){
        String [] simple = {"BAK","BAU","BAf","EBq","EBr","EBs","EBt","EBu","ABY","BDI"};
        for (int i=0;i<10;i++) {
            int random = 0 + (int) (Math.random() * 10);
            String testString = simple[random];
            assertTrue("Piece '" + testString + "', is placed at valid location, but return false", StepsGame.OffBoard(testString));
        }
    }


    @Test
    public void testFourCorner() {
        String corner = "AJpy";
        String piece = "ABCDEFGH";
        for(int i=0;i<10;i++){
            int randomNum1 = 0 + (int) (Math.random() * 7);
            int randomNum2 = 0 + (int) (Math.random() * 7);
            int randomNum3 = 0 + (int) (Math.random() * 2);
            String testString = Character.toString(piece.charAt(randomNum1)) + Character.toString(piece.charAt(randomNum2)) + Character.toString(corner.charAt(randomNum3));
            assertFalse("Piece '"+ testString + "', is placed at corner, which is off board, but return true", StepsGame.OffBoard(testString));
        }

    }

    @Test
    public void testInvalidFourSides() {
        String side = "ABCDEFGHIJTeoyxwvutsrqpfUK";//26 characters
        String pieceCh1 = "ACDFGH";
        String pieceCh2 = "ABCDEFGH";
        for(int i=0;i<5;i++) {
            int randomNum1 = 0 + (int) (Math.random() * 4);
            int randomNum2 = 0 + (int) (Math.random() * 7);
            int randomNum3 = 0 + (int) (Math.random() * 25);
            String testString = Character.toString(pieceCh1.charAt(randomNum1)) + Character.toString(pieceCh2.charAt(randomNum2)) + Character.toString(side.charAt(randomNum3));
            assertFalse("Piece '" + testString + "', is placed at " + testString.charAt(2) + " which is off board, but return true", StepsGame.OffBoard(testString));
        }
    }
    @Test
    public void testInsidelocation(){
        String location = "LMNOPQRSVWXYabcdghijklmn";//24 characters
        String piece = "ABCDEFGH";
        int randomNum1 = 0 + (int) (Math.random() * 7);
        int randomNum2 = 0 + (int) (Math.random() * 7);
        int randomNum3 = 0 + (int) (Math.random() * 23);
        String testString = Character.toString(piece.charAt(randomNum1)) + Character.toString(piece.charAt(randomNum2)) + Character.toString(location.charAt(randomNum3));
        assertTrue("Piece '"+ testString + "', is placed at "+ testString.charAt(2) + " which is not off-board, but return false", StepsGame.OffBoard(testString));
    }
    @Test
    public void testValidFourSidesTop() {
        String top = "BCDEFGHI";
        String[] allowTop = {"BB", "BH", "ED", "EF"};
        for (int i = 0; i < 10; i++) {
            int randomNum1 = 0 + (int) (Math.random() * 3);
            int randomNum2 = 0 + (int) (Math.random() * 7);
            String testString = allowTop[randomNum1] + Character.toString(top.charAt(randomNum2));
            assertTrue("Piece '" + testString + "', is placed at " + testString.charAt(2) + " which is not off-board, but return false", StepsGame.OffBoard(testString));
        }
    }
    @Test
    public void testValidFourSidesDown(){
        String down = "trstuvwx";
        String [] allowDown = {"BD","BF","EB","EH"};
        for (int i = 0; i < 10; i++) {
            int randomNum1 = 0 + (int) (Math.random() * 3);
            int randomNum2 = 0 + (int) (Math.random() * 7);
            String testString = allowDown[randomNum1] + Character.toString(down.charAt(randomNum2));
            assertTrue("Piece '" + testString + "', is placed at " + testString.charAt(2) + " which is not off-board, but return false", StepsGame.OffBoard(testString));
        }
    }
    @Test
    public void testValidFourSidesLeft(){
        String left = "KUf";
        String [] allowLeft = {"BA","BG","EC","EE"};
        for (int i = 0; i < 10; i++) {
            int randomNum1 = 0 + (int) (Math.random() * 3);
            int randomNum2 = 0 + (int) (Math.random() * 2);
            String testString = allowLeft[randomNum1] + Character.toString(left.charAt(randomNum2));
            assertTrue("Piece '" + testString + "', is placed at " + testString.charAt(2) + " which is not off-board, but return false", StepsGame.OffBoard(testString));
        }
    }
    @Test
    public void testValidFourSidesRight(){
        String right = "Teo";
        String [] allowright = {"BC","BE","EA","EG"};
        for (int i = 0; i < 10; i++) {
            int randomNum1 = 0 + (int) (Math.random() * 3);
            int randomNum2 = 0 + (int) (Math.random() * 2);
            String testString = allowright[randomNum1] + Character.toString(right.charAt(randomNum2));
            assertTrue("Piece '" + testString + "', is placed at " + testString.charAt(2) + " which is not off-board, but return false", StepsGame.OffBoard(testString));
        }
    }


}
