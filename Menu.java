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
            new Style("fontSize", 40),
            new Style("bgColor", new Color(0, 255, 255)),
            new Style("borderWidth", 8),
            new Style("borderColor", new Color(0, 255, 0))
        };
        Style[] buttonHoverStyle = {
            new Style("w", Style.multiply(1.2)),
            new Style("h", Style.multiply(1.5)),
            new Style("fontSize", Style.add(20)),
            new Style("borderWidth", Style.divide(2)),
            new Style("bgColor", new Color(255, 0, 0))
        };
        Style[] buttonClickStyle = {
            new Style("borderWidth", Style.multiply(3)),
            new Style("bgColor", new Color(255, 255, 0)),
            new Style("textColor", new Color(255, 0, 0))
        };
        
        new Button(this, this.getWidth() / 2, this.getHeight() / 2 + 60, 260, 70, "Start Game", this::newGame)
            .applyStyles(buttonIdleStyle, buttonHoverStyle, buttonClickStyle)
            .onIdle(new Style("image", new GreenfootImage("wood.jpeg")));
        
        new Button(this, this.getWidth() / 2, this.getHeight() / 2 + 150, 220, 70, "idk", this::newGame)
            .applyStyles(buttonIdleStyle, buttonHoverStyle, buttonClickStyle)
            .onHover(new Style("text", "lol"))
            .onClick(new Style("text", "lmao"));
    }
    
    private void newGame() {
        Greenfoot.setWorld(new Game());
    }
}
