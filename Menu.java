import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Menu extends World
{
    public Menu() {
        super(600, 400, 1);
        new Label(this, this.getWidth() / 2, this.getHeight() / 2 - 60, "Hungry Animal", 80);
        new Button(this, this.getWidth() / 2, this.getHeight() / 2 + 60, 220, 70, "Start Game", 40);
    }
}
