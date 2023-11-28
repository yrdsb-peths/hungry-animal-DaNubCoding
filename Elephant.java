import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Elephant extends Sprite {
    public Elephant(Game game) {
        super(game, 300, 300);
    }

    public void tick() {
        if (Greenfoot.isKeyDown("left")) {
            this.setLocation(getX() - 3, getY());
        }
        if (Greenfoot.isKeyDown("right")) {
            this.setLocation(getX() + 3, getY());
        }
        
        if (isTouching(Apple.class)) {
            this.removeTouching(Apple.class);
            this.game.increaseScore(1);
        }
    }
}
