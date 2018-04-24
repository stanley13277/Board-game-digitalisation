/**
 * this task is done by Yen Wen Li(u6149684)
 */

package comp1110.ass2.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;// the idea of using javafx.scene.shape.Circle is come from "https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Circle.html".(Yen-Wei, Li)
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A very simple viewer for piece placements in the steps game.
 *
 * NOTE: This class is separate from your main game class.  This
 * class does not play a game, it just illustrates various piece
 * placements.
 */
public class Viewer extends Application {

    //this part is done by u6149684(Yen-Wei, Li)
    /* board layout */
    private static final int VIEWER_WIDTH = 750;
    private static final int VIEWER_HEIGHT = 500;
    private static int change = 0;

    private static final String URI_BASE = "assets/";

    private final Group root = new Group();
    private final Group controls = new Group();
    TextField textField;


    /**
     * Draw a placement in the window, removing any previously drawn one
     *
     * @param placement  A valid placement string
     */
    //The idea of using substring for below code is from "http://www.homeandlearn.co.uk/java/substring.html"
    void makePlacement(String placement) {
        int x = placement.length() / 3;
        //convert placement into each pieces
        for (int i = 0; i < x; i++) {
            draw(placement.substring(3 * i, 3 * i + 3));
            // FIXME Task 4: implement the simple placement viewer
        }
    }

    public void drawBoard(){//the idea of how to construct this method is from "Zhang Jun u6122372"
        int gap = 50;
        //initialize the board
        for (int i=0;i<5;i++){//row
            for (int j=0;j<3;j++){//column
                Circle circle1 = new Circle(140+gap*i,40+gap*j,8);
                circle1.getFill();
                root.getChildren().add(circle1);
            }
        }
        for (int i=0;i<5;i++) {//row
            for (int j = 0; j < 2; j++) {//column
                Circle circle2 = new Circle(165 + gap * i, 65 + gap * j, 8);
                root.getChildren().add(circle2);
            }
        }
    }

    public void draw(String piece){//the idea of how to construct this method is from "Zhang Jun u6122372"
        ImageView Piece = new ImageView();
        String char1 = piece.substring(0,1);String char2 = piece.substring(1,2);
        String location=piece.substring(2,3);
        String imageName; String ImageChar2 = "ABCD";

        if (ImageChar2.contains(char2)){
            imageName=char1+"A";
        }else{
            imageName=char1+"E";
        }

        //get image
        //The idea of below's code getResource is come from "https://stackoverflow.com/questions/2593154/get-a-resource-using-getresource" (Yen-Wei, Li)
        Image name = new Image(Viewer.class.getResource(URI_BASE+imageName+".png").toString());
        Piece.setImage(name);
        Piece.setFitHeight(100);
        Piece.setFitWidth(100);

        //rotate the image

        Map<String, Integer> Rotation = new HashMap<>();
        Rotation.put("BF", 90); Rotation.put("CG", 180); Rotation.put("DH", 270);
        List<String> List = new ArrayList<>(Rotation.keySet());
        for (String m: List){
            if (m.contains(char2)){
                Piece.setRotate(Rotation.get(m));
            }
        }

        //set piece x axis

        Map<String, Integer> X = new HashMap<>();
        X.put("AKUfp", 90); X.put("BLVgq",115); X.put("CMWhr", 140); X.put("DNXis", 165);X.put("EOYjt", 190);
        X.put("FPaku", 215); X.put("GQblv", 240); X.put("HRcmw",265); X.put("ISdnx", 290); X.put("JTeoy", 215);
        List<String> XPosition = new ArrayList<>(X.keySet());
        for (String n: XPosition){
            if (n.contains(location)){
                Piece.setX(X.get(n));
            }
        }

        //set piece y axis

        Map<String, Integer> Y = new HashMap<>();
        Y.put("ABCDEFGHIJ",-10); Y.put("KLMNOPQRST", 15); Y.put("UVWXYabcde",40); Y.put("fghijklmno", 65); Y.put("pqrstuvwxy", 90);
        List<String> YPosition = new ArrayList<>(Y.keySet());

        for (String o: YPosition){
            if (o.contains(location)){
                Piece.setY(Y.get(o));
            }
        }
        controls.getChildren().add(Piece);
    }

    /**
     * Create a basic text field for input and a refresh button.
     */
    private void makeControls() {
        Label label1 = new Label("Placement:");
        textField = new TextField ();
        textField.setPrefWidth(300);
        Button button = new Button("Refresh");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //this part will refresh the board when there is new input placement
                if(change==0){
                    makePlacement(textField.getText());
                    textField.clear();
                    change = change+1;
                }else{
                    controls.getChildren().clear();
                    makePlacement(textField.getText());
                    textField.clear();
                }
            }
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField, button);
        hb.setSpacing(10);
        hb.setLayoutX(130);
        hb.setLayoutY(VIEWER_HEIGHT - 50);
        root.getChildren().add(hb);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("StepsGame Viewer");
        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);

        drawBoard();
        makeControls();
        
        root.getChildren().add(controls);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


