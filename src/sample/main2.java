package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.FileInputStream;


public class main2 extends Application{


    private goTo5x5Scene goTo5x5Scene = new goTo5x5Scene();
    private goTo10x10Scene goTo10x10Scene = new goTo10x10Scene();
    private goTo20x20Scene goTo20x20Scene = new goTo20x20Scene();

    private Scene scene5x5;
    private Scene scene10x10;
    private Scene scene20x20;

    private static Button button5x5;
    private static Button button10x10;
    private static Button button20x20;

    private static StackPane mainClassPane;


    public static void main (String[] args)
    {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setTitle("Minesweeper");
        StackPane pane = new StackPane();
        this.mainClassPane = pane;

        //Creating the image
        Image image = new Image(new FileInputStream("C:\\Users\\antek\\OneDrive\\Bureau\\IMPORTANT_JAVA_STUFF\\ASSIGNMENT_3_JAVA2\\MINESWEEPER\\src\\Minesweeper_Logo.png"));


        //Setting the image view
        ImageView imageView = new ImageView(image);

        //Setting the position of the image
        imageView.setTranslateX(0);
        imageView.setTranslateY(-200);


        //Setting the size of the image
        imageView.setFitHeight(150);
        imageView.setFitWidth(300);


        //Setting the size preservation of the original image to true
        imageView.setPreserveRatio(true);

        //Adding the imageView to the Pane
        pane.getChildren().add(imageView);

        //Creating the buttons
        Button grid25Squares = new Button();
        this.button5x5 = grid25Squares;
        grid25Squares.setText("5x5 Board");
        addButtons.addButtonToPane(grid25Squares,pane,150,40,0, 0);

        Button grid100Squares = new Button();
        this.button10x10 = grid100Squares;
        grid100Squares.setText("10x10 Board");
        addButtons.addButtonToPane(grid100Squares,pane,150,40,0, 70);

        Button grid400Squares = new Button();
        this.button20x20 = grid400Squares;
        grid400Squares.setText("20x20 Board");
        addButtons.addButtonToPane(grid400Squares,pane, 150, 40, 0, 140);



        Scene scene = new Scene(pane,600,500);
        goTo5x5Scene.setMainScene(scene);
        goTo10x10Scene.setMainScene(scene);
        goTo20x20Scene.setMainScene(scene);


        grid25Squares.setOnAction(e ->
        {
            goTo5x5Scene.setLogoImage(imageView);
            try
            {
                goTo5x5Scene.goToScene(scene5x5, stage);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        });

        grid100Squares.setOnAction(e ->
        {
            goTo10x10Scene.setLogoImage(imageView);
            try
            {
                goTo10x10Scene.goToScene(scene10x10, stage);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        });


        grid400Squares.setOnAction(e ->
        {
            goTo20x20Scene.setLogoImage(imageView);
            try
            {
                goTo20x20Scene.goToScene(scene5x5, stage);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        });



        stage.setScene(scene);
        stage.show();
    }


    public static Button getButton5x5() {
        return button5x5;
    }

    public static Button getButton10x10() {
        return button10x10;
    }

    public static Button getButton20x20() {
        return button20x20;
    }

    public static StackPane getMainClassPane() {
        return mainClassPane;
    }
}
