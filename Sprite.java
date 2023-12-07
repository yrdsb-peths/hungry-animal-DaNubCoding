import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Sprite extends Actor {
    protected Game game;
    protected GreenfootImage image;

    public Sprite(Game game, int x, int y) {
        this.game = game;
        this.game.addObject(this, x, y);
        this.image = this.getImage();
    }

    public void act() {
        this.tick();
    }
    
    public void setImage(GreenfootImage image) {
        super.setImage(image);
        this.image = this.getImage();
    }

    public abstract void tick();
}
