import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

/**
 * This is the abstract class that represents a polygon
 * 
 * @author Daniel
 * @version 2018-04-16
 *
 */
public abstract class MyPolygon extends Shape
{

    /**
     * Make Eclipse happy
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor for MyPolygon
     * 
     * @param color Color of polygon
     * @param filled Indicate filled/unfilled
     */
    public MyPolygon(Color color, boolean filled)
    {
        // call to Shape constructor
        super(color, filled);
    }

    @Override
    public void draw(Graphics g)
    {
        // obtain the number of points in the polygon
        int numOfPoints = location.length;
        // initialize arrays of x and y coords
        int[] xPoints = new int[numOfPoints];
        int[] yPoints = new int[numOfPoints];
        // fill the arrays with the x and y coords of the points
        for (int i = 0; i < numOfPoints; i++)
        {
            xPoints[i] = location[i].x;
            yPoints[i] = location[i].y;
        }
        // set the color
        g.setColor(this.getColor());
        if (this.isFilled())
        {
            // if filled, draw filled polygon
            g.fillPolygon(xPoints, yPoints, numOfPoints);
        }
        else
        {
            // unfilled, draw outline of polygon
            g.drawPolygon(xPoints, yPoints, numOfPoints);
        }
    }

    @Override
    public boolean contains(Point p)
    {
        // get number of points in polygon
        int numOfPoints = location.length;
        // initialize arrays of x and y coords
        int[] xPoints = new int[numOfPoints];
        int[] yPoints = new int[numOfPoints];
        // fill the arrays with x and y coords of the points
        for (int i = 0; i < numOfPoints; i++)
        {
            xPoints[i] = location[i].x;
            yPoints[i] = location[i].y;
        }
        // create awt.Polygon with the same points as MyPolygon
        Polygon poly = new Polygon(xPoints, yPoints, numOfPoints);
        // does the awt.Polygon contain the point?
        return poly.contains(p);
    }

}
