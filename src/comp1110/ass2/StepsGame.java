/**
 * this is done by Yen-Wei, Li (u6149684), PENG YONG (u5934120), and Shashank Chary(u6352431).
 */

package comp1110.ass2;


import java.util.*;


/**
 * This class provides the text interface for the Steps Game
 *
 * The game is based directly on Smart Games' IQ-Steps game
 * (http://www.smartgames.eu/en/smartgames/iq-steps)
 */
public class StepsGame {

    /**
     * Determine whether a piece placement is well-formed according to the following:
     * - it consists of exactly three characters
     * - the first character is in the range A .. H (shapes)
     * - the second character is in the range A .. H (orientations)
     * - the third character is in the range A .. Y and a .. y (locations)
     *
     * @param piecePlacement A string describing a   piece placement
     * @return True if the piece placement is well-formed
     */
    public static boolean isPiecePlacementWellFormed(String piecePlacement) {
        String first = "ABCDEFGH";
        String second = "ABCDEFGH";
        String third = "ABCDEFGHIJKLMNOPQRSTUVWXYabcdefghijklmnopqrstuvwxy";
        if (first.contains(piecePlacement.substring(0,1)) && second.contains(piecePlacement.substring(1,2)) && third.contains(piecePlacement.substring(2,3))){
            return true;
        }
        // FIXME Task 2: determine whether a piece placement is well-formed
        return false;
    }
    // task2,3 is done by our group

    /**
     * Determine whether a placement string is well-formed:
     *  - it consists of exactly N three-character piece placements (where N = 1 .. 8);
     *  - each piece placement is well-formed
     *  - no shape appears more than once in the placement
     *
     * @param placement A string describing a placement of one or more pieces
     * @return True if the placement is well-formed
     */
    public static boolean isPlacementWellFormed(String placement) {
        // check the empty and null.
        if (placement == null||placement==""){
            return false;
        }
        if (placement.length() % 3 != 0){
            return false;
        }
        String element = new String();
        for (int i = 0; i < placement.length(); i++){
            if ( i % 3 == 0){
                element = element + placement.substring(i,i+1);
            }
        }
        // use set to get rid of duplicate piece.
        Set<Character> set=new LinkedHashSet<Character>();
        for(char c: element.toCharArray())
        {
            set.add(Character.valueOf(c));
        }
        if (element.length() != set.size()){
            return false;
        }
        for (int i=0; i < placement.length()/3; i++){
            if (! isPiecePlacementWellFormed(placement.substring(i*3, i*3 + 3))){
                return false;
            }
        }
        // FIXME Task 3: determine whether a placement is well-formed
        return true;
    }



    /**
     * Determine whether a placement sequence is valid.  To be valid, the placement
     * sequence must be well-formed and each piece placement must be a valid placement
     * (with the pieces ordered according to the order in which they are played).
     *
     * @param placement A placement sequence string
     * @return True if the placement sequence is valid
     */


    public static boolean OffBoard(String placement){
        String up = "BDFH"; String uppeg = "CEGI";   String left = "Kf";     String leftpeg = "U";
        String right = "e"; String rightpeg = "To";  String down = "qsuw";   String downpeg = "rtvx";
        // the code below is to get rid of the situation when origin of piece is in the four corner of board
        for (int i = 2; i < placement.length(); i = i + 3){
            if (placement.charAt(i) == 'A' || placement.charAt(i) == 'p' || placement.charAt(i) == 'J' || placement.charAt(i) == 'y'){
                return false;
            }
        }
        /* For four sides, we just need to consider piece E and B. The eight for loop is to get rid of all situation that piece B and E can
         put into side of board*/
        Map<String, String> mapping = new HashMap<>();
        mapping.put(up,"BHEF"); mapping.put(uppeg,"BBED");mapping.put(left,"BGEE");mapping.put(leftpeg,"BAEC");
        mapping.put(right,"BEEG");mapping.put(rightpeg,"BCEA");mapping.put(down,"BFEH");mapping.put(downpeg,"BDEB");
        List<String> list = new ArrayList<>(8);
        list.add(up);list.add(uppeg);list.add(left);list.add(leftpeg);
        list.add(right);list.add(rightpeg);list.add(down);list.add(downpeg);
        for (int i = 0; i < placement.length(); i = i + 3) {
            String NEWPiece = placement.substring(i, i + 3);
            for (String m : list) {
                if (m.contains(NEWPiece.substring(2, 3))) {
                    if (!NEWPiece.substring(0, 2).equals(mapping.get(m).substring(0, 2)) && !NEWPiece.substring(0, 2).equals(mapping.get(m).substring(2, 4))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean sequence(String placement){
        String board = "ABCDEFGHIJKLMNOPQRSTUVWXYabcdefghijklmnopqrstuvwxy";
        String Upboard = "BDFHJKMOQSVXacefhjlnqsuwy";
        String bottomBoard = "ACEGILNPRTUWYbdgikmoprtvx";
        Map<String, String> upToBottom= new HashMap<>();
        //upToBottom has the key for each up layer of board and the value that the bottom layer of the board around key.
        upToBottom.put("B","ALC");upToBottom.put("D","CNE");upToBottom.put("F","EPG");upToBottom.put("H","GRI");upToBottom.put("J","IT");
        upToBottom.put("K","ALU");upToBottom.put("M","CLNW");upToBottom.put("O","ENPY");upToBottom.put("Q","GPRb");upToBottom.put("S","IRTd");
        upToBottom.put("V","LUWg");upToBottom.put("X","NWYi");upToBottom.put("a","PYbk");upToBottom.put("c","Rbdm");upToBottom.put("e","Tdo");
        upToBottom.put("f","Ugp");upToBottom.put("h","Wgir");upToBottom.put("j","Yikt");upToBottom.put("l","bkmv");upToBottom.put("n","dmox");
        upToBottom.put("q","gpr");upToBottom.put("s","irt");upToBottom.put("u","ktv");upToBottom.put("w","mvx");upToBottom.put("y","ox");
        //we give each piece a index position (put the piece in the top left) and bottom layer position first and up layer position at the end.
        int[][][] occupy = {{{0,11,20,12,1,10},{0,2,11,1,12,21}, {2,11,22,12,21,10},{20,22,11,1,10,21},{1,10,12,11,2,22},{1,12,21,20,11,22},{21,10,12,11,20,0},{10,1,21,0,11,2}},
                {{22,11,12,21,1}, {20,11,12,10,21},{0,11,10,1,21},{11,2,10,1,12},{1,10,21,20,11},{1,12,10,11,0},{1,12,21,11,2},{10,21,12,11,22}},
                {{11,20,1,12,21},{0,11,10,12,21},{2,11,1,10,21},{11,22,1,10,12},{1,10,21,11,22},{1,10,12,11,20},{1,12,21,0,11},{10,12,21,2,11}},
                {{22,11,10,1,21},{11,20,1,10,12},{0,11,1,12,21},{2,11,10,12,21},{1,21,12,20,11}, {12,10,21,11,0}, {1,21,10,11,2},{1,10,12,11,22}},
                {{11,20,1,10,21},{0,11,10,1,12},{2,11,1,12,21},{22,11,12,21,10},{1,12,21,11,22},{10,21,12,20,11},{21,1,10,11,0},{1,12,10,11,2}},
                {{2,11,20,12,21},{0,22,11,21,10},{11,20,2,1,10},{0,11,22,1,12},{21,10,11,0,22},{1,10,2,11,20}, {12,1,0,11,22},{12,21,11,20,2}},
                {{2,11,20,21,1,12},{0,11,22,10,12,21},{2,11,20,1,10,21},{0,11,22,1,10,12},{10,1,21,11,0,22},{1,10,12,11,2,20},{1,12,21,0,11,22},{21,10,12,2,11,20}},
                {{2,11,22,1,10,21},{22,20,11,1,10,12},{0,20,11,12,1,21},{0,2,11,10,12,21},{1,12,21,0,11,20}, {10,12,21,0,2,11},{1,10,21,2,11,22}, {1,10,12,11,20,22}}};
        // create String array contain pieces
        String[] pieces = new String[(placement.length())/3];
        for (int i = 0; i < placement.length(); i = i + 3){
            pieces[i/3] = placement.substring(i, i+3);
        }
        // create a int array contain difference between actual original index position and the index position we  have created above.
        int[] position = new int[(placement.length())/3];
        for (int i = 0; i < placement.length()/3; i++){
            position[i] = board.indexOf(Character.toString(pieces[i].charAt(2))) - 11; // reference should be stated here.
        }
        // create the String array that contains shape information.
        String[] shape = new String[(placement.length())/3];
        for (int i = 0; i < placement.length(); i = i + 3){
            shape[i/3] = placement.substring(i, i+ 2);
        }
        // the actual index position of pieces in the board.
        int[][] index = new int[shape.length][];
        for (int i = 0; i < shape.length; i++){
            index[i] = occupy[shape[i].charAt(0)-65][shape[i].charAt(1)-65];
        }
        for (int i = 0; i < index.length; i++){
            for (int r = 0; r < index[i].length; r++){
                index[i][r] = index[i][r] + position[i];
            }
        }
        // we replace the occupied position with Char '.', before each piece put into the board, if its position is '.', it will return false;
        for (int i = 0; i < index.length; i++) {
            for (int r = 0; r < index[i].length; r++) {
                if (board.charAt(index[i][r]) == '.') {
                    return false;
                } else {
                    if (bottomBoard.contains(Character.toString(board.charAt(index[i][r])))) {
                        board = board.replace(board.charAt(index[i][r]), '.');
                    }
                    if (Upboard.contains(Character.toString(board.charAt(index[i][r])))) {
                        for (int No = 0; No < upToBottom.get(Character.toString(board.charAt(index[i][r]))).length(); No++) {
                            if (board.charAt(index[i][r]) != '.') {
                                board = board.replace(upToBottom.get(Character.toString(board.charAt(index[i][r]))).toCharArray()[No], '.');
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    public static boolean isPlacementSequenceValid(String placement) {
        if (! isPlacementWellFormed((placement))) {
            return false;
        }
        if (! OffBoard(placement)){
            return false;
        }
        if (! sequence(placement)) {
            return false;
        }
        // FIXME Task 5: determine whether a placement sequence is valid
        return true;
    }
    /**
     * Given a string describing a placement of pieces and a string describing
     * an (unordered) objective, return a set of all possible next viable
     * piece placements.   A viable piece placement must be a piece that is
     * not already placed (ie not in the placement string), and which will not
     * obstruct any other unplaced piece.
     *
     * @param placement A valid sequence of piece placements where each piece placement is drawn from the objective
     * @param objective A valid game objective, but not necessarily a valid placement string
     * @return An set of viable piece placements
     */

// FIXME Task 6: determine the correct order of piece placements

    // task 6 and task 9 done by PENG YONG(u5934120)

    // this step is used to check the next one recursively and the method is used in the task9 again.

    public static boolean testTrue(String piece, String placement, Set<String> pieces){
        Set<String> UNUSED = new HashSet<>();
        for (String m: pieces){
            UNUSED.add(m);
        }
        UNUSED.remove(piece);// for the recursion, once the piece is used and it will be removed
        if (sequence(placement)){ // check the placement with task 5
            if (UNUSED.size() == 0){
                return true;
            }
            for (String m: UNUSED) {
                if (testTrue(m, placement + m, UNUSED)) {
                    return true;
                }// check the placement recursively, once all eight placement satisfied the condition, is will return true.
            }
        }
        // when there are no solution for the next piece, false will return
        return false;
    }

    static Set<String> getViablePiecePlacements(String placement, String objective) {
        Set<String> result = new HashSet<>();
        Set<String> OBJ = new HashSet<>();
        Set<String> USED = new HashSet<>();
        for (int i = 0; i < (placement.length())/3; i++){
            USED.add(placement.substring((i+1)*3-3,(i+1)*3));
        }
        for (int i = 0; i < (objective.length())/3; i++){
            OBJ.add(objective.substring((i+1)*3-3,(i+1)*3));
        }
        Set<String> ChooseFrom = new HashSet<>();
        for (String m: OBJ){
            if (! USED.contains(m)){
                ChooseFrom.add(m);
            }
        }
        for (String m: ChooseFrom){
            if (testTrue(m,placement+m,ChooseFrom)){
                result.add(m);
            }
        }
        // FIXME Task 6: determine the correct order of piece placements
        return result;
    }

    /**
     * Return an array of all unique (unordered) solutions to the game, given a
     * starting placement.   A given unique solution may have more than one than
     * one placement sequence, however, only a single (unordered) solution should
     * be returned for each such case.
     *
     * @param placement  A valid piece placement string.
     * @return An array of strings, each describing a unique unordered solution to
     * the game given the starting point provided by placement.
     */

    /**
     * Task9 done by PENG YONG below with discussion with YiLun Hou(u6147476)
     */

    // This is the orientation for piece
    static public String[] orientation = {"A","B","C","D","E","F","G","H"};
    static public String[] LocationForBE= {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V",
            "d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y"};
    static public String[] LocationForACDFGH = {"L","M","N","O","P","Q","R","S","g","h","i","j","k","l","m","n"};
    static public String[] piece = {"A","B","C","D","E","F","G","H"};

    // the location is different between piece BE and ACDFGH, the four side can not be used for ACDFGH.
    // the location in the middle can not be used for both pieces, once the middle line location is used, the game can not be finished.

    static public Set<String> LocationNowBE(String placement){
        // once the location is used, the 3 * 3 around location will be deleted out because it can not be used again.
        Map<String, String> upToBottom= new HashMap<>();
        upToBottom.put("A","BKL");upToBottom.put("B","ALCKM");upToBottom.put("C","BKLMN");upToBottom.put("D","CMNOE");upToBottom.put("E","DNOPF");
        upToBottom.put("F","EOPQG");upToBottom.put("G","FPQRH");upToBottom.put("H","GQRSI");upToBottom.put("I","HRSTJ");upToBottom.put("J","IST");
        upToBottom.put("K","ABLVU");upToBottom.put("L","ABCKMUVW");upToBottom.put("M","BCDLNVWX");upToBottom.put("N","CDEMOWXY");upToBottom.put("O","DEFNPXYa");
        upToBottom.put("P","EFGOQYab");upToBottom.put("Q","FGHPQRabc");upToBottom.put("R","GHIQSbcd");upToBottom.put("S","HIJRTcde");upToBottom.put("T","IJSde");
        upToBottom.put("f","UVgqp");upToBottom.put("g","UVWfhpqr");upToBottom.put("h","VWXgiqrs");upToBottom.put("i","WXYhjrst");upToBottom.put("j","XYaikstu");
        upToBottom.put("k","Yabjltuv");upToBottom.put("l","abckmuvw");upToBottom.put("m","bcdlnvwx");upToBottom.put("n","cdemowxy");upToBottom.put("o","denxy");
        upToBottom.put("p","fgq");upToBottom.put("q","fghpr");upToBottom.put("r","ghiqs");upToBottom.put("s","hijrt");upToBottom.put("t","ijksu");
        upToBottom.put("u","jkltv");upToBottom.put("v","klmuw");upToBottom.put("w","lmnvx");upToBottom.put("x","mnowy");upToBottom.put("y","nox");upToBottom.put("C","BDLMN");


        Set<String> used = new HashSet<>();
        for (int i = 0; i < placement.length() / 3; i++){
            used.add(placement.substring(i * 3 + 2, (i + 1) * 3));
        }
        Set<String> Reference= new HashSet<>();
        for (String  l: used){
            Reference.add(l);
        }
        for (String m: used){
            if (upToBottom.containsKey(m)){
                String occupy = upToBottom.get(m);
                for (int i= 0; i < occupy.length(); i++){
                    Reference.add(occupy.substring(i, i +1));
                }
            }
        }
        Set<String> result = new HashSet<>();
        for (String m: LocationForBE){
            if (! Reference.contains(m)){
                result.add(m);
            }
        }
        return result;
    }
    // return the set<String>, which is the available location that can be used now.
    // the occupied location can not be used.

    static public Set<String> LocationNowACDFGH(String placement){
        Map<String, String> upToBottom= new HashMap<>();
        upToBottom.put("A","BKL");upToBottom.put("B","ALCKM");upToBottom.put("C","BCDLMN");upToBottom.put("D","CMNOE");upToBottom.put("E","DNOPF");
        upToBottom.put("F","EOPQG");upToBottom.put("G","FPQRH");upToBottom.put("H","GQRSI");upToBottom.put("I","HRSTJ");upToBottom.put("J","IST");
        upToBottom.put("K","ABLVU");upToBottom.put("L","ABCKMUVW");upToBottom.put("M","BCDLNVWX");upToBottom.put("N","CDEMOWXY");upToBottom.put("O","DEFNPXYa");
        upToBottom.put("P","EFGOQYab");upToBottom.put("Q","FGHPQRabc");upToBottom.put("R","GHIQSbcd");upToBottom.put("S","HIJRTcde");upToBottom.put("T","IJSde");
        upToBottom.put("f","UVgqp");upToBottom.put("g","UVWfhpqr");upToBottom.put("h","VWXgiqrs");upToBottom.put("i","WXYhjrst");upToBottom.put("j","XYaikstu");
        upToBottom.put("k","Yabjltuv");upToBottom.put("l","abckmuvw");upToBottom.put("m","bcdlnvwx");upToBottom.put("n","cdemowxy");upToBottom.put("o","denxy");
        upToBottom.put("p","fgq");upToBottom.put("q","fghpr");upToBottom.put("r","ghiqs");upToBottom.put("s","hijrt");upToBottom.put("t","ijksu");
        upToBottom.put("u","jkltv");upToBottom.put("v","klmuw");upToBottom.put("w","lmnvx");upToBottom.put("x","mnowy");upToBottom.put("y","nox");

        Set<String> used = new HashSet<>();
        for (int i = 0; i < placement.length() / 3; i++){
            used.add(placement.substring(i * 3 + 2, (i + 1) * 3));
        }
        Set<String> Reference= new HashSet<>();
        for (String  l: used){
            Reference.add(l);
        }
        for (String m: used){
            if (upToBottom.containsKey(m)){
                String occupy = upToBottom.get(m);
                for (int i= 0; i < occupy.length(); i++){
                    Reference.add(occupy.substring(i, i +1));
                }
            }
        }
        Set<String> result = new HashSet<>();
        for (String m: LocationForACDFGH){
            if (! Reference.contains(m)){
                result.add(m);
            }
        }
        return result;
    }

    /* this method is find next piece contains shape, orientation and location */

    static public List<String> AllPossibleNext(String NowPlacement){
        List<String> result = new ArrayList<>();
        List<String> UsedPiece = new ArrayList<>();
        for (int i = 0; i < NowPlacement.length() / 3; i++){
            UsedPiece.add(NowPlacement.substring(i * 3, i * 3 + 1));
        }
        List<String> NeverUsed = new ArrayList<>();
        for (String n: piece){
            if (! UsedPiece.contains(n)){
                NeverUsed.add(n);
            }
        }
        for (String piece: NeverUsed){
            for (String orie: orientation){
                if (piece == "B" || piece == "E"){
                    for (String location: LocationNowBE(NowPlacement)){
                        String one = piece + orie+ location;
                        result.add(one);
                    }
                }
                if (piece != "B" && piece != "E"){
                    for (String location: LocationNowACDFGH(NowPlacement)){
                        String one = piece + orie + location;
                        result.add(one);
                    }
                }
            }
        }
        return result;
    }

    /* if adding is appeared before, return false, else return true */
    static public Boolean clear(String Target, String test){
        for (int i = 0; i < Target.length() / 3; i ++){
            if (Target.substring(i * 3, (i + 1)* 3) == test){
                return false;
            }
        }
        return true;
    }
    /* do the next piece */

    static  public List<String> DoNext(List<String> placement, int LeftPiece){
        if (LeftPiece == 0){ // base condition
            return placement;
        }
        else{
            List<String> result = new ArrayList<>();
            for (String Q: placement){
                for (String P: AllPossibleNext(Q)){
                    if (clear(Q, P)){
                        String Wanted = Q + P;
                        if (isPlacementSequenceValid(Wanted)){
                            result.add(Wanted);
                        }
                    }
                }
            }
            return DoNext(result, LeftPiece - 1);
        }
    }
    // To remove the duplicate result. The result in the below method return the all the ordered results, which is not we want

    static public String[] Duplicate(List<String> target){
        Set<Set<String>>  ClearDuplicate = new HashSet<>();
        for (String Near: target){
            Set<String>  everytime = new HashSet<>();
            for (int i = 0; i < Near.length()/3; i++){
                everytime.add(Near.substring(i*3, (i+1)*3));
            }
            ClearDuplicate.add(everytime);
        }
        String[] end = new String[ClearDuplicate.size()];
        int i = 0;
        for (Set<String> result : ClearDuplicate){
            String Objec = "";
            for (String three: result){
                Objec = Objec + three;
            }
            end[i] = Objec;
            i += 1;
        }
        return end;
    }
    public static String[] getSolutions(String placement) {
        List<String> Next = AllPossibleNext(placement);
        List<String> Spec = new ArrayList<>();
        if (placement.length() == 21){
            for (String S: Next){
                if (isPlacementSequenceValid(placement + S)){
                    Spec.add(placement+S);
                }
            }
            return Duplicate(Spec);
        }else{
            List<String> start = new ArrayList<>();
            for (String next : Next) {
                if (isPlacementSequenceValid(placement + next)) {
                    start.add(placement + next);
                }
            }
            int LeftPiece = (24 - placement.length()) / 3 - 1;
            List<String> NearEnd = DoNext(start, LeftPiece);
            return Duplicate(NearEnd);
            System.out.println();
        }
        // FIXME Task 9: determine all solutions to the game, given a particular starting placement
    }


}