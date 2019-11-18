import java.awt.Color;
import java.awt.Point;

/**
 * This class maintains information for drawing a Square and extends Rectangle.
 * 
 * @author Stephen
 * @version 2018-04-02
 * Lab 11
 */
public class Square extends Rectangle
{
    /**
     * Add to make java happy.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor for a Rectangle with equal length and widths
     * 
     * @param center Center point of the square
     * @param width Width (and height) of the square
     * @param color Desired color for the square
     * @param filled True if the square should be filled solid
     */
    public Square(Point center, int width, Color color, boolean filled)
    {
        super(center, width, width, color, filled);
    }
}
