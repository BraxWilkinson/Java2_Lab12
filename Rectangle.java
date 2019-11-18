import java.awt.Color;
import java.awt.Point;

/**
 * This class maintains information for drawing a Rectangle and extends Polygon.
 * 
 * @author Stephen
 * @version 2018-04-02
 * Lab 11
 */
public class Rectangle extends MyPolygon
{
    /**
     * Add to make java happy.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor for the Rectangle class
     * 
     * @param center Center point of the rectangle
     * @param width Width of the rectangle
     * @param height Height of the rectangle
     * @param color Desired color for the rectangle
     * @param filled Whether or not the rectangle should be filled solid
     */
    public Rectangle(Point center, int width, int height, Color color, boolean filled)
    {
        super(color, filled);
        
        this.location = new Point[4];
        
        // Define the 4 points Remember that we generally start from the upper-left corner
        this.location[0] = new Point(center.x - width/2, center.y - height/2);
        this.location[1] = new Point(center.x + width/2, center.y - height/2);
        this.location[2] = new Point(center.x + width/2, center.y + height/2);
        this.location[3] = new Point(center.x - width/2, center.y + height/2);
    }
}