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
    
    public static class Subtract extends Modifier<Integer> {
        public Subtract(int subtrahend) {
            this.modification = subtrahend;
        }
        
        public Integer apply(Integer value) {
            return value - this.modification;
        }
    }
    
    public static Subtract subtract(int subtrahend) {
        return new Subtract(subtrahend);
    }
    
    public static class Multiply extends Modifier<Double> {
        public Multiply(double multiplier) {
            this.modification = multiplier;
        }
        
        public Double apply(Double value) {
            return value * this.modification;
        }
    }
    
    public static Multiply multiply(double multiplier) {
        return new Multiply(multiplier);
    }
    
    public static class Divide extends Modifier<Double> {
        public Divide(double divisor) {
            this.modification = divisor;
        }
        
        public Double apply(Double value) {
            return value / this.modification;
        }
    }
    
    public static Divide divide(double divisor) {
        return new Divide(divisor);
    }
    
    public Style(String name, Object value) {
        this.name = name;
        this.value = value;
    }
}