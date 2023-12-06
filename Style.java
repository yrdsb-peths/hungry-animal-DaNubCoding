/**
 * A record of a name and value pair representing a style field a Button can have
 * 
 * @param name The name of the field (must be a valid field of a Button if used)
 * @param value The value of the field
 */
public record Style (String name, Object value) {}