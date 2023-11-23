import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Main extends Sprite
{
    long appleTimer;
    
    public void init() {
        super.init();
        this.appleTimer = System.currentTimeMillis();
    }
    
    public void tick()
    {
        if (System.currentTimeMillis() - this.appleTimer > 2000) {
            this.world.spawnApple();
            this.appleTimer = System.currentTimeMillis();
        }
    }
}
