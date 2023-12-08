/**
 * Stores the data of a singular style
 * 
 * @param name The name of the field as a string
 * @param value The value of the field
 */
public record Style(String name, Object value) {
    public static abstract class Modifier<T> {
        protected T modification;
        public abstract T apply(T value);
    }
    
    public static class Add extends Modifier<Integer> {
        public Add(int addend) {
            this.modification = addend;
        }
        
        public Integer apply(Integer value) {
            return value + this.modification;
        }
    }
    
    public static Add add(int addend) {
        return new Add(addend);
    }
    
    public static Add subtract(int subtrahend) {
        return new Add(-subtrahend);
    }
    
    public static class Percent extends Modifier<Integer> {
        public Percent(int percentage) {
            this.modification = percentage;
        }
        
        public Integer apply(Integer value) {
            return value * this.modification / 100;
        }
    }
    
    public static Percent percent(int percentage) {
        return new Percent(percentage);
    }
    
    public static Percent multiply(double multiplier) {
        return new Percent((int) (multiplier * 100));
    }
    
    public static Percent divide(double divisor) {
        return new Percent((int) (100 / divisor));
    }
    
    public Style(String name, Object value) {
        this.name = name;
        this.value = value;
    }
}