package sample;

import javafx.scene.control.Button;

public class GridButton {

    private Button button;
    private boolean colorChanged;
    private boolean hasBomb;
    private int heightPosition;
    private int widthPosition;


    public GridButton(Button button)
    {
        this.button = button;
        this.colorChanged = false;
    }



    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public boolean isColorChanged() {
        return colorChanged;
    }

    public void setColorChanged(boolean colorChanged) {
        this.colorChanged = colorChanged;
    }

    public boolean isHasBomb() {
        return hasBomb;
    }

    public void setHasBomb(boolean hasBomb) {
        this.hasBomb = hasBomb;
    }

    public int getHeightPosition() {
        return heightPosition;
    }

    public void setHeightPosition(int heightPosition) {
        this.heightPosition = heightPosition;
    }

    public int getWidthPosition() {
        return widthPosition;
    }

    public void setWidthPosition(int widthPosition) {
        this.widthPosition = widthPosition;
    }
}
