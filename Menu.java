import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Menu extends World
{
    public Menu() {
        super(600, 400, 1);
        new Label(this,
            this.getWidth() / 2, this.getHeight() / 2 - 60, // Position
            "Hungry Animal", 80                             // Text
        );
        
        Style[] buttonIdleStyle = {
            new Style("bgColor", new Color(0, 255, 255))
        };
        Style[] buttonHoverStyle = {
            new Style("w", 220 + 30),
            new Style("h", 70 + 30),
            new Style("fontSize", 46),
            new Style("bgColor", new Color(255, 0, 0))
        };
        Style[] buttonClickStyle = {
            new Style("bgColor", new Color(255, 255, 0)),
            new Style("textColor", new Color(255, 0, 0))
        };
        
        new Button(this,
            this.getWidth() / 2, this.getHeight() / 2 + 60, // Position
            220, 70,                                        // Size
            "Start Game", 40,                               // Text
            this::newGame                                   // Function
        ).applyStyles(buttonIdleStyle, buttonHoverStyle, buttonClickStyle);
        
        new Button(this,
            this.getWidth() / 2, this.getHeight() / 2 + 160, // Position
            220, 70,                                         // Size
            "idk", 40,                                       // Text
            this::newGame                                    // Function
        ).applyStyles(buttonIdleStyle, buttonHoverStyle, buttonClickStyle);
    }
    
    private void newGame() {
        Greenfoot.setWorld(new Game());
    }
}
