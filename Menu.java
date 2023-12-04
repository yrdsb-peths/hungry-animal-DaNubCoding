import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Menu extends World
{
    public Menu() {
        super(600, 400, 1);
        new Label(this,
            this.getWidth() / 2, this.getHeight() / 2 - 60, // Position
            "Hungry Animal", 80                             // Text
        );
        new Button(this,
            this.getWidth() / 2, this.getHeight() / 2 + 60, // Position
            220, 70,                                        // Size
            "Start Game", 40,                               // Text
            this::newGame                                   // Function
        );
    }
    
    private void newGame() {
        Greenfoot.setWorld(new Game());
    }
}
