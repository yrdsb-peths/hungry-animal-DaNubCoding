import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Elephant extends Sprite {
    private GreenfootSound eatSound = new GreenfootSound("elephantcub.mp3");
    private boolean mirrored = false;
    
    public Elephant(Game game) {
        super(game, 300, 300);
        this.image.scale(this.image.getWidth() * 2, this.image.getHeight() * 2);
    }

    public void tick() {
        if (Greenfoot.isKeyDown("left")) {
            this.setLocation(getX() - 3, getY());
            if (!this.mirrored) {
                this.image.mirrorHorizontally();
                this.mirrored = true;
            }
        }
        if (Greenfoot.isKeyDown("right")) {
            this.setLocation(getX() + 3, getY());
            if (this.mirrored) {
                this.image.mirrorHorizontally();
                this.mirrored = false;
            }
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
