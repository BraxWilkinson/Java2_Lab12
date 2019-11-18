import java.awt.Color;
import java.awt.Point;

/**
 * This class maintains information for drawing a Circle and extends Oval.
 * 
 * @author Stephen
 * @version 2018-04-02
 * Lab 11
 */
public class Circle extends Oval
{
    /**
     * Add to make java happy.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor creating an Oval with equal major and minor radii (i.e. diameters are the same)
     * 
     * @param pointCenter Center point of the circle
     * @param diameter Diameter of the circle
     * @param color Desired color for the circle
     * @param filled True if the circle should be filled solid
     */
    public Circle(Point pointCenter, int diameter, Color color, boolean filled)
    {
        super(pointCenter, diameter, diameter, color, filled);
    }

    /**
     * Get the diameter of the circle
     * 
     * @return diameter1 (or diameter2) The diameter
     */
    public int getDiameter()
    {
        return getDiameter1();
    }
}
