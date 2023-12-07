/**
 * A class that stores the data of a singular style
 */
public class Style {
    private String name;
    private Object value;
    
    /**
     * Initializes the style
     * 
     * @param name The name of the field (must be a valid field of a Button if used)
     * @param value The value of the field
     */
    public Style(String name, Object value) {
        this.name = name;
        this.value = value;
    }
    
    public String name() {
        return this.name;
    }
    
    public Object value() {
        return this.value;
    }
    
    public static Style $(String name, Object value) {
        return new Style(name, value);
    }
}
