import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates a button, customizable with various style fields
 */
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
    
    public StyleField<Integer> x = new StyleField();
    public StyleField<Integer> y = new StyleField();
    public StyleField<Integer> w = new StyleField();
    public StyleField<Integer> h = new StyleField();
    public StyleField<String> text = new StyleField();
    public StyleField<Integer> fontSize = new StyleField();
    public StyleField<Color> textColor = new StyleField();
    public StyleField<Color> bgColor = new StyleField();
    
    /**
     * Intializes the Button
     * 
     * @param world The world in which to create the button
     * @param x The x coordinate that the button will be placed at
     * @param y The y coordinate that the button will be placed at
     * @param w The width of the button
     * @param h The height of the button
     * @param text The text to display on the button (can be any type that can be represented as a String)
     * @param fontSize The size of the font to display the text with
     * @param func Reference to the function to run when the button is clicked
     */
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
    
    /**
     * Update the image of the corresponding state based on the current style fields
     * 
     * @param state The state to have its image be modified as a string
     */
    private void updateImage(String state) {
        GreenfootImage image = new GreenfootImage(this.w.get(state), this.h.get(state));
        try {
            this.getClass().getField(state + "Image").set(this, image);
        } catch (Exception e) {
            System.out.println("Unable to access field: " + state + "Image");
            return;
        }

        image.setColor(this.bgColor.get(state));
        image.fill();
        
        GreenfootImage textImage = new GreenfootImage(
            this.text.get(state),      // Text
            this.fontSize.get(state),  // Font Size
            this.textColor.get(state), // Text Color
            new Color(0, 0, 0, 0)      // Background Color
        );
        image.drawImage(
            textImage,
            this.w.get(state) / 2 - textImage.getWidth() / 2, // x position
            this.h.get(state) / 2 - textImage.getHeight() / 2 // y position
        );
    }
    
    /**
     * Update the image of all three states based on the current style fields
     */
    private void updateAllImages() {
        this.updateImage("idle");
        this.updateImage("hover");
        this.updateImage("click");
    }
    
    /**
     * Determine if the mouse is hovering over the button
     * 
     * @return A boolean representing whether the mouse is hovering over the button
     */
    private boolean mouseOver(MouseInfo mouse) {
        int x = this.x.get(this.state), y = this.y.get(this.state);
        int w = this.w.get(this.state), h = this.h.get(this.state);
        return mouse.getX() > x - w / 2 && mouse.getX() < x + w / 2 && mouse.getY() > y - h / 2 && mouse.getY() < y + h / 2;
    }
    
    /**
     * Set the styles of the button when it is idle (no interaction)
     * 
     * @param styles A series of styles to be used when the button is idle
     * @return The current object (useful for chaining calls)
     */
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
    
    /**
     * Set the styles of the button when it is being hovered over
     * 
     * @param styles A series of styles to be used when the button is hovered
     * @return The current object (useful for chaining calls)
     */
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
    
    /**
     * Set the styles of the button when it is clicked
     * 
     * @param styles A series of styles to be used when the button is clicked
     * @return The current object (useful for chaining calls)
     */
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
    
    /**
     * Apply a series of styles for the idle state
     * 
     * @param idle An array of styles to be used when the button is idle
     * @return The current object (useful for chaining calls)
     */
    public Button applyStyles(Style[] idle) {
        this.onIdle(idle);
        return this;
    }
    
    /**
     * Apply a series of styles for the idle and hover states
     * 
     * @param idle An array of styles to be used when the button is idle
     * @param hover An array of styles to be used when the button is hovered
     * @return The current object (useful for chaining calls)
     */
    public Button applyStyles(Style[] idle, Style[] hover) {
        this.onIdle(idle);
        this.onHover(hover);
        return this;
    }
    
    /**
     * Apply a series of styles for all three states
     * 
     * @param idle An array of styles to be used when the button is idle
     * @param hover An array of styles to be used when the button is hovered
     * @param click An array of styles to be used when the button is clicked
     * @return The current object (useful for chaining calls)
     */
    public Button applyStyles(Style[] idle, Style[] hover, Style[] click) {
        this.onIdle(idle);
        this.onHover(hover);
        this.onClick(click);
        return this;
    }
    
    /**
     * Get the current state of the button
     * 
     * @return The current state as a string
     */
    public String getState() {
        return this.state;
    }
    
    /**
     * Handle the mouse logic of the button (i.e. whether the mouse is hovering over it)
     */
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
