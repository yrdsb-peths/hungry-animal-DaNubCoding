public class StyleField<T> {
    private String name;
    public T idle;
    public T hover;
    public T click;
    
    public StyleField(String name) {
        this.name = name;
    }
    
    public T getIdle() {
        return this.idle;
    }
    
    public void setIdle(T value) {
        this.idle = value;
    }
    
    public T getHover() {
        return this.hover;
    }
    
    public void setHover(T value) {
        this.hover = value;
    }
    
    public T getClick() {
        return this.click;
    }
    
    public void setClick(T value) {
        this.click = value;
    }
    
    public T get(String type) throws IllegalArgumentException {
        try {
            return (T) this.getClass().getField(type).get(this);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid type! (can be: 'idle', 'hover', 'click')");
        }
    }
    
    public void setAll(T value) {
        this.setIdle(value);
        this.setHover(value);
        this.setClick(value);
    }
}