import java.awt.Color;
import java.awt.Point;

/**
 * This class maintains information for drawing a Diamond and extends Polygon.
 * 
 * @author Stephen
 * @version 2018-04-02
 * Lab 11
 */
public class Diamond extends MyPolygon
{
    /**
     * Add to make java happy.
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Constructor for Diamond shape
     * 
     * @param center Point for the center the shape
     * @param diagonalLength Length of a diagonal of the diamond (vertex to vertex, crossing the center point).
     *                       Keep in mind that any vertex is diagonalLength/2 away from the center point.
     * @param color Color of the shape.
     * @param filled Boolean value determining whether the shape is filled.
     */
    public Diamond(Point center, int width, int height, Color color, boolean filled)
    {
        super(color, filled);
        location = new Point[4];
        
        // Assemble the 4 points
        location[0] = new Point(center.x, center.y - height/2);
        location[1] = new Point(center.x + width/2, center.y);
        location[2] = new Point(center.x, center.y + height/2);
        location[3] = new Point(center.x - width/2, center.y);
    }
}
