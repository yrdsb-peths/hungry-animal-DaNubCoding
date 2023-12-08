/**
 * Stores the data of a singular style
 * 
 * @param name The name of the field as a string
 * @param value The value of the field
 */
public record Style(String name, Object value) {
    /**
     * An abstract superclass for all modifiers that modify a style dynamically
     */
    private static abstract class Modifier<T> {
        protected T modification;
        
        /**
         * Abstract method for applying the modifications to an input value
         * 
         * @param value The value to be modified
         */
        public abstract T apply(T value);
    }
    
    /**
     * A modifier that adds an integer to the target style value
     */
    private static class Add extends Modifier<Integer> {
        public Add(int addend) {
            this.modification = addend;
        }
        
        public Integer apply(Integer value) {
            return value + this.modification;
        }
    }
    
    /**
     * Factory method that initializes an Add modifier for addition
     * 
     * @param addend The number to add
     * @return A new Add object
     */
    public static Add add(int addend) {
        return new Add(addend);
    }
    
    /**
     * Factory method that initializes an Add modifier with a negative value for subtraction
     * 
     * @param subtrahend The number to subtract
     * @return A new Add object
     */
    public static Add subtract(int subtrahend) {
        return new Add(-subtrahend);
    }
    
    /**
     * A modifier that multiplies the target style value by a percentage
     */
    private static class Percent extends Modifier<Integer> {
        public Percent(int percentage) {
            this.modification = percentage;
        }
        
        public Integer apply(Integer value) {
            return value * this.modification / 100;
        }
    }
    
    /**
     * Factory method that initializes a percent modifier
     * 
     * @param percentage The percentage to multiply by
     * @return A new Percent object
     */
    public static Percent percent(int percentage) {
        return new Percent(percentage);
    }
    
    /**
     * Factory method that initializes a percent modifier for multiplication
     * 
     * @param multiplier The number to multiply by
     * @return A new Percent object
     */
    public static Percent multiply(double multiplier) {
        return new Percent((int) (multiplier * 100));
    }
    
    /**
     * Factory method that initializes a percent modifier for division
     * 
     * @param divisor The number to divide by
     * @return A new Percent object
     */
    public static Percent divide(double divisor) {
        return new Percent((int) (100 / divisor));
    }
    
    /**
     * Intializes the style with a name and a value
     * 
     * @param name The name of the style as a String, used to get the field in a UI element
     * @param value The value to set to (can be a value or a modifier)
     */
    public Style(String name, Object value) {
        this.name = name;
        this.value = value;
    }
}