import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Button extends Actor
{
    private World world;
    private int x;
    private int y;
    private int w;
    private int h;
    private String text;
    private Label label;
    private int size;
    private GreenfootImage image;
    
    public Button(World world, int x, int y, int w, int h, String text, int size) {
        this.world = world;
        this.world.addObject(this, x, y);
        
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.text = text;
        this.size = size;
        
        this.image = new GreenfootImage(this.w, this.h);
        this.image.setColor(new Color(0, 255, 255));
        this.image.fill();
        this.setImage(this.image);
        
        GreenfootImage textImage = new GreenfootImage(this.text, this.size, new Color(0, 0, 0), new Color(0, 0, 0, 0));
        this.image.drawImage(textImage, this.w / 2 - textImage.getWidth() / 2, this.h / 2 - textImage.getHeight() / 2);
    }

    public void act() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse == null) return;

        if (mouse.getActor() == this && mouse.getButton() == 1) {
            Greenfoot.setWorld(new Game());
        }
    }
}
