package cmsc420_s21;

// YOU SHOULD NOT MODIFY THIS FILE

/**
 * Airport object. An airport is represented by its:
 *   - 3-letter IATA airport code (e.g., "LAX")
 *   - name (e.g., "Los Angeles International")
 *   - city (e.g., "Los Angeles")
 *   - country (e.g., "USA")
 *   - coordinates (x,y), given as longitude (-180...180) and latitude (-90...+90)
 */
public class Airport implements LabeledPoint2D {

	// Private data (The x,y coordinates are provided by the Point2D class)
	
    private final String code; // IATA code
    private final String name; // name
    private final String city; // city
    private final String country; // country
	private final Point2D location; // coordinates

    /** Basic constructor.
     * @param code IATA code (String)
     * @param name airport's name (String)
     * @param city airport's city (String)
     * @param country airport's country (String)
     * @param x x-coordinate [longitude] (float)
     * @param y y-coordinate [latitude] (float)
     */
    public Airport(String code, String name, String city, String country, float x, float y) {
        this.code = code;
        this.name = name;
        this.city = city;
        this.country = country;
        this.location = new Point2D(x, y);
    }
    
    // Standard functions - Getters and toString
    public String getCode() { return code; }

    public String getName() { return name; }

    public String getCity() { return city; }
    
    public String getCountry() { return country; }

    public String toString() { return code; }
    
    // Required by NamedPoint2D interface

    public String getLabel() { return code; }

	public float getX() { return location.getX(); }
	
	public float getY() { return location.getY(); }
	
	public float getCoord(int i) { return location.getCoord(i); }
	
	public Point2D getPoint2D() { return location; }

}