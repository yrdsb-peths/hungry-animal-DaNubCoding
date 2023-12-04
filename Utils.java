public class Utils  
{
    public static String String(String s) { return s; }
    public static String String(int i) { return Integer.toString(i); }
    public static String String(double d) { return Double.toString(d); }
    public static String String(boolean b) { return Boolean.toString(b); }
    public static <T> String String(T x) { return x.toString(); }
}
