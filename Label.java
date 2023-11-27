import greenfoot.*;

public class Label extends Actor {
    private String text;
    private int size;

    public Label(String text, int size) {
        this.text = text;
        this.size = size;
        updateImage(this.text);
    }

    public Label(int text, int size) {
        this.text = Integer.toString(text);
        this.size = size;
        updateImage(this.text);
    }

    public void setText(String text) {
        this.text = text;
        updateImage(this.text);
    }

    public void setText(int text) {
        this.text = Integer.toString(text);
        updateImage(this.text);
    }

    private void updateImage(String text) {
        setImage(new GreenfootImage(text, size, new Color(0, 0, 0), new Color(0, 0, 0, 0)));
    }
}