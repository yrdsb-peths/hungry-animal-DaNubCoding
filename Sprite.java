import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Sprite extends Actor {
    protected World world;

    public Sprite(World world, int x, int y) {
        this.world = world;
        this.world.addObject(this, x, y);
    }

    public void act() {
        this.tick();
    }

    public abstract void tick();
}
