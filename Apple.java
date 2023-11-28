import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Apple extends Sprite {
    public void tick() {
        this.setLocation(this.getX(), this.getY() + 3);
        if (this.getY() > 400) {
            this.world.removeObjects(this.world.getObjects(Apple.class));
            this.world.endGame();
        }
    }
}
