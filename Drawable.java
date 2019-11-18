import java.awt.Graphics;

/**
 * Interface implemented by Shape
 * <P>
 * 
 * DO NOT MODIFY THIS CLASS
 * 
 * @author CS2334.
 * @version 2018-04-16
 */

public interface Drawable
{
    /**
     * Force all classes that implement this interface to have this method that
     * draws the object.
     * 
     * @param g A Graphics object.
     */
    public abstract void draw(Graphics g);
}
