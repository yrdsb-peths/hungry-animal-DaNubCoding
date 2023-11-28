import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Sprite extends Actor {
    protected MyWorld world;

    public Sprite(MyWorld world, int x, int y) {
        this.world = world;
        this.world.addObject(this, x, y);
    }

    public void act() {
        this.tick();
    }

    public abstract void tick();
}
