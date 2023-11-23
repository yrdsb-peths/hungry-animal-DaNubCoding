import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public MyWorld()
    {
        super(600, 400, 1, false);
        Main main = new Main();
        addObject(main, -100, -100);
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        spawnApple();
    }
    
    public void spawnApple() {
        Apple apple = new Apple();
        addObject(apple, Greenfoot.getRandomNumber(600), 0);
    }
}
