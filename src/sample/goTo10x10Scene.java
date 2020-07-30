package sample;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


import java.util.ArrayList;

public class goTo10x10Scene implements goToScene {

    private Button button = new Button();
    private ImageView logoImage;
    private Scene mainScene;
    private GridButton bombSetOff;


    private ArrayList<GridButton> buttons = new ArrayList<>();
    private ArrayList<GridButton> buttonsWithBombs = new ArrayList<>();
    private ArrayList<GridButton> clearedButtons = new ArrayList<>();



    @Override
    public void goToScene(Scene selectScene, Stage stage) throws Exception {

        StackPane pane = new StackPane();
        pane.getChildren().add(logoImage);
        for (int heightPos = -100; heightPos < 200; heightPos += 30)
        {
            for (int widthPos = -150; widthPos < 150; widthPos += 30)
            {
                this.button = new Button();
                addButtons.addButtonToPane(this.button,pane,30,30,widthPos,heightPos);
                GridButton gridButton = new GridButton(this.button);
                gridButton.setHeightPosition(heightPos);
                gridButton.setWidthPosition(widthPos);
                var randomN = Math.floor(Math.random()*4);
                if (randomN == 3)
                {
                    gridButton.setHasBomb(true);
                }
                buttons.add(gridButton);
            }
        }


        Button quitButton = new Button();
        quitButton.setText("Stop the game");
        addButtons.addButtonToPane(quitButton,pane,100,15,190,220);




        for (GridButton button : this.buttons)
        {
            button.getButton().setOnMouseClicked(e ->
            {
                MouseButton mouseButton = e.getButton();

                if (mouseButton == MouseButton.PRIMARY)
                {
                    if (bombSetOff == null)
                    {
                        if (button.isHasBomb())
                        {
                            button.getButton().setStyle("-fx-background-color: #ff0000; ");
                            buttonsWithBombs.add(button);
                            bombSetOff = button;
                            for (GridButton button1 : this.buttons)
                            {
                                if ((button1.isHasBomb() && (!button1.equals(bombSetOff))))
                                {
                                    button1.getButton().setStyle("-fx-background-color: #800080; ");
                                }
                            }
                        }
                        if (!buttonsWithBombs.contains(button))
                        {
                            int height = button.getHeightPosition();
                            int countAdjacent = 0;

                            while (height > -100)
                            {
                                for (GridButton b : buttons)
                                {
                                    if (b.getHeightPosition() == height)
                                    {
                                        if ((b.isHasBomb() == false) && (countAdjacent < 5))
                                        {
                                            b.getButton().setStyle("-fx-background-color: #dcdcdc; ");
                                            clearedButtons.add(b);
                                        }
                                    }
                                }
                                height -= 30;
                                countAdjacent ++;
                            }
                        }
                    }
                }

                if (mouseButton == MouseButton.SECONDARY)
                {
                    if (!clearedButtons.contains(button))
                    {
                        int heightPosition = button.getHeightPosition();
                        int widthPosition = button.getWidthPosition();
                        Button button1 = new Button();


                        if ((button.isColorChanged() == false))
                        {
                            button.setColorChanged(true);
                            button.getButton().setStyle("-fx-background-color: #0000ff; ");

                        }
                        else
                        {
                            button.setColorChanged(false);
                            pane.getChildren().remove(button.getButton());
                            addButtons.addButtonToPane(button1, pane,30,30,widthPosition,heightPosition);
                            button.setButton(button1);
                            this.buttons.add(button);
                        }
                    }
                }

            });
        }



        quitButton.setOnAction(e ->
        {
            bombSetOff = null;
            Pane subPane1 = new Pane();
            subPane1.getChildren().add(logoImage);

            addButtons.modifyButtonSize(main2.getButton5x5(),150,40,0,0);
            subPane1.getChildren().add(main2.getButton5x5());

            addButtons.modifyButtonSize(main2.getButton10x10(),150,40,0,70);
            subPane1.getChildren().add(main2.getButton10x10());

            addButtons.modifyButtonSize(main2.getButton20x20(), 150,40,0,140);
            subPane1.getChildren().add(main2.getButton20x20());

            main2.getMainClassPane().getChildren().addAll(subPane1);
            stage.setScene(mainScene);
            stage.show();
        });

        selectScene = new Scene(pane,600,500);
        stage.setScene(selectScene);
    }



    public void setLogoImage(ImageView logoImage) {
        this.logoImage = logoImage;
    }

    public void setMainScene(Scene mainScene) {
        this.mainScene = mainScene;
    }

}
