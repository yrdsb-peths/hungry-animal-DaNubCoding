import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Elephant extends Actor
{
    public void act()
    {
        if (Greenfoot.isKeyDown("left")) {
            move(-3);
        }
        if (Greenfoot.isKeyDown("right")) {
            move(3);
        }
    }
}
