import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;

/**
 * @author CS2334
 * @version 2018-04-16 This class holds the location and color of the shape, as
 *          well as whether the shape is filled.
 */

public abstract class Shape implements Drawable, Serializable
{
    /**
     * Make Eclipse happy
     */
    private static final long serialVersionUID = 1L;
    /**
     * The array of points that define the location of the shape object.
     */
    protected Point[] location;
    /**
     * The color of the shape object.
     */
    private Color color;
    /**
     * The boolean indicating if the shape is filled or just an outline.
     */
    private boolean filled;

    /**
     * Force children to have contains method.
     * 
     * This method indicates whether the point is contained within the shape.
     * 
     * @param p The point being tested.
     * @return Whether point is contained in shape.
     */
    public abstract boolean contains(Point p);

    /**
     * Constructor
     * 
     * @param color Color of the shape.
     * @param filled Boolean value determining whether the shape is filled.
     */
    public Shape(Color color, boolean filled)
    {
        this.color = color;
        this.filled = filled;
    }

    /**
     * Get the color of the shape
     * 
     * @return color The shape's color
     */
    public Color getColor()
    {
        return color;
    }

    /**
     * See whether the shape is filled with color or not
     * 
     * @return filled True if the shape if filled.
     */
    public boolean isFilled()
    {
        return filled;
    }

    /**
     * Get the location of the shape
     * 
     * @return location The array representing the shape's location
     */
    public Point[] getLocation()
    {
        return location;
    }

    /**
     * Set the color of the shape.
     * 
     * @param color The color the shape is being set to.
     */
    public void setColor(Color color)
    {
        this.color = color;
    }

    /**
     * Set the fill of the shape
     * 
     * @param filled The boolean indicating fill of the shape.
     */
    public void setFilled(boolean filled)
    {
        this.filled = filled;
    }

}
