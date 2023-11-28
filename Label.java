import greenfoot.*;

public class Label extends Sprite {
    private String text;
    private int size;

    public Label(Game game, int x, int y, String text, int size) {
        super(game, x, y);
        this.text = text;
        this.size = size;
        this.updateImage(this.text);
    }

    public Label(Game game, int x, int y, int num, int size) {
        this(game, x, y, Integer.toString(num), size);
    }

    public Label(Game game, int x, int y, double num, int size) {
        this(game, x, y, Double.toString(num), size);
    }
    
    public void tick() {
        // No logic
    }

    public void setText(String text) {
        this.text = text;
        this.updateImage(this.text);
    }

    public void setText(int num) {
        this.setText(Integer.toString(num));
    }

    public void setText(double num) {
        this.setText(Double.toString(num));
    }

    private void updateImage(String text) {
        this.setImage(new GreenfootImage(text, size, new Color(0, 0, 0), new Color(0, 0, 0, 0)));
    }
}