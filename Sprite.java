import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Sprite extends Actor {
    protected Game game;

    public Sprite(Game game, int x, int y) {
        this.game = game;
        this.game.addObject(this, x, y);
    }

    public void act() {
        this.tick();
    }

    public abstract void tick();
}
