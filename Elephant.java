import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Elephant extends Sprite {
    static private GreenfootImage[] frames = new GreenfootImage[8];

    private GreenfootSound eatSound = new GreenfootSound("elephantcub.mp3");
    private boolean mirrored = false;
    private int currentFrame = 0;
    
    public Elephant(Game game) {
        super(game, 300, 300);
        for (int i = 0; i < this.frames.length; i++) {
            frames[i] = new GreenfootImage("elephant_idle/idle" + i + ".png");
            frames[i].scale(frames[i].getWidth() * 2, frames[i].getHeight() * 2);
        }
    }

    public void tick() {
        if (Greenfoot.isKeyDown("left")) {
            this.setLocation(this.getX() - 3, this.getY());
            if (!this.mirrored) {
                this.image.mirrorHorizontally();
                this.mirrored = true;
            }
        }
        if (Greenfoot.isKeyDown("right")) {
            this.setLocation(this.getX() + 3, this.getY());
            if (this.mirrored) {
                this.image.mirrorHorizontally();
                this.mirrored = false;
            }
        }
        
        if (this.getX() < 0) {
            this.setLocation(this.game.getWidth(), this.getY());
        } else if (this.getX() > this.game.getWidth()) {
            this.setLocation(0, this.getY());
        }
        
        if (isTouching(Apple.class)) {
            this.eatApple();
        }
    }
    
    private void eatApple() {
        this.removeTouching(Apple.class);
        this.game.increaseScore(1);
        this.eatSound.play();
    }
}
