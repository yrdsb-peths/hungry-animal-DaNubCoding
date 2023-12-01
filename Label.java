import greenfoot.*;

public class Label extends Actor {
    private World world;
    private String text;
    private int size;

    public <T> Label(World world, int x, int y, T text, int size) {
        this.world = world;
        this.world.addObject(this, x, y);
        this.text = Utils.String(text);
        this.size = size;
        this.updateImage(this.text);
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