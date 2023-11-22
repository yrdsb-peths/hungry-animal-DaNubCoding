import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Sprite extends Actor {
    protected boolean initialized;
    protected MyWorld world;

    public void act() {
        if (!this.initialized) {
            this.init();
            this.initialized = true;
        }
        this.tick();
    }

    public void init() {
        world = getWorldOfType(MyWorld.class);
    }
    
    public abstract void tick();
}
