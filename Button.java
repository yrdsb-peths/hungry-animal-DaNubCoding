import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Button extends Actor
{
    static private Actor mouseOver;

    private World world;
    private Label label;
    private GreenfootImage image;
    public GreenfootImage idleImage;
    public GreenfootImage hoverImage;
    public GreenfootImage clickImage;
    private Runnable func;
    
    // Whether the mouse down event occurred on the button
    private boolean mouseDownOnThis = false;
    private boolean hovering = false;
    // Hovering does this weird thing where it flickers between on and off
    private boolean hoverSustain = false;
    private String state = "idle";
    
    public StyleField<Integer> x = new StyleField("x");
    public StyleField<Integer> y = new StyleField("y");
    public StyleField<Integer> w = new StyleField("w");
    public StyleField<Integer> h = new StyleField("h");
    public StyleField<String> text = new StyleField("text");
    public StyleField<Integer> fontSize = new StyleField("fontSize");
    public StyleField<Color> textColor = new StyleField("textColor");
    public StyleField<Color> bgColor = new StyleField("bgColor");
    
    public <T> Button(World world, int x, int y, int w, int h, T text, int fontSize, Runnable func) {
        this.world = world;
        this.world.addObject(this, x, y);
        
        this.func = func;
        
        this.x.setAll(x);
        this.y.setAll(y);
        this.w.setAll(w);
        this.h.setAll(h);
        this.text.setAll(Utils.String(text));
        this.fontSize.setAll(fontSize);
        
        this.textColor.setAll(new Color(0, 0, 0));
        this.bgColor.setAll(new Color(222, 222, 222));
        
        this.updateAllImages();
    }
    
    private void updateImage(String type) {
        GreenfootImage image = new GreenfootImage(this.w.get(type), this.h.get(type));
        try {
            this.getClass().getField(type + "Image").set(this, image);
        } catch (Exception e) {
            System.out.println("Unable to access field: " + type + "Image");
            return;
        }

        image.setColor(this.bgColor.get(type));
        image.fill();
        
        GreenfootImage textImage = new GreenfootImage(
            this.text.get(type),      // Text
            this.fontSize.get(type),  // Font Size
            this.textColor.get(type), // Text Color
            new Color(0, 0, 0, 0)     // Background Color
        );
        image.drawImage(
            textImage,
            this.w.get(type) / 2 - textImage.getWidth() / 2, // x position
            this.h.get(type) / 2 - textImage.getHeight() / 2 // y position
        );
    }
    
    private void updateAllImages() {
        this.updateImage("idle");
        this.updateImage("hover");
        this.updateImage("click");
    }
    
    private boolean mouseOver(MouseInfo mouse) {
        int x = this.x.get(this.state), y = this.y.get(this.state);
        int w = this.w.get(this.state), h = this.h.get(this.state);
        return mouse.getX() > x - w / 2 && mouse.getX() < x + w / 2 && mouse.getY() > y - h / 2 && mouse.getY() < y + h / 2;
    }
    
    public Button onIdle(Style... styles) {
        for (Style style : styles) {
            try {
                StyleField field = (StyleField) this.getClass().getField(style.name()).get(this);
                field.setAll(style.value());
            } catch (Exception e) {
                System.out.println("Invalid field '" + style.name() + "'!" + e);
            }
        }
        this.updateAllImages();
        this.setImage(this.idleImage);
        return this;
    }
    
    public Button onHover(Style... styles) {
        for (Style style : styles) {
            try {
                StyleField field = (StyleField) this.getClass().getField(style.name()).get(this);
                field.setHover(style.value());
                field.setClick(style.value());
            } catch (Exception e) {
                System.out.println("Invalid field '" + style.name() + "'!");
            }
        }
        this.updateImage("hover");
        this.updateImage("click");
        this.setImage(this.idleImage);
        return this;
    }
    
    public Button onClick(Style... styles) {
        for (Style style : styles) {
            try {
                StyleField field = (StyleField) this.getClass().getField(style.name()).get(this);
                field.setClick(style.value());
            } catch (Exception e) {
                System.out.println("Invalid field '" + style.name() + "'!");
            }
        }
        this.updateImage("click");
        this.setImage(this.idleImage);
        return this;
    }
    
    public Button applyStyles(Style[] idle) {
        this.onIdle(idle);
        return this;
    }
    
    public Button applyStyles(Style[] idle, Style[] hover) {
        this.onIdle(idle);
        this.onHover(hover);
        return this;
    }
    
    public Button applyStyles(Style[] idle, Style[] hover, Style[] click) {
        this.onIdle(idle);
        this.onHover(hover);
        this.onClick(click);
        return this;
    }
    
    public String getState() {
        return this.state;
    }
    
    private void handleMouseLogic() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse == null) return;
        
        // Handle hovering logic
        this.hovering = this.mouseOver(mouse);

        // Handle clicking logic
        if (!this.hovering) this.mouseDownOnThis = false;
        if (mouse.getButton() == 1) {
            if (Greenfoot.mousePressed(this)) { // mouse down
                this.mouseDownOnThis = true;
            } else if (Greenfoot.mouseClicked(this)) { // mouse up
                if (this.mouseDownOnThis) {
                    this.func.run();
                }
            }
        }
    }

    public void act() {
        this.state = "idle";
        this.setImage(this.idleImage);
        if (this.hovering) {
            this.state = "hover";
            this.setImage(this.hoverImage);
        }
        if (this.mouseDownOnThis) {
            this.state = "click";
            this.setImage(this.clickImage);
        }
        
        this.handleMouseLogic();
    }
}
