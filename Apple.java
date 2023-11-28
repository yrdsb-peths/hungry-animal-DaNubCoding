import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Apple extends Sprite {
    public Apple(Game game) {
        super(game, Greenfoot.getRandomNumber(600), 0);
    }
    
    public void tick() {
        this.setLocation(this.getX(), this.getY() + 3);
        if (this.getY() > 400) {
            this.game.clearApples();
            this.game.endGame();
        }
    }
}
