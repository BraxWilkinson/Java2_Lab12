import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 * This class extends JFrame and contains the main method. The frame includes
 * all the key components for our GUI.
 * 
 * @author CS2334. Modified by: ?????
 * @version 2018-04-16
 */

public class DrawFrame extends JFrame
{
    /**
     * Makes Eclipse happy
     */
    protected static final long serialVersionUID = 1L;
    /** Panel for drawing */
    protected DrawPanel drawPanel;
    /** Panel for the set of controls */
    protected ControlPanel controlPanel;

    /** Flag to indicate shape is being edited */
    protected boolean editFlag;
    /** Flag to indicate shape is being deleted */
    protected boolean deleteFlag;

    /** Random object */
    protected Random rand = new Random();

    ////////////////////////////////////////////////////////////////////////////
    /**
     * Defines the panel that contains the drawing controls
     * 
     * Sub-panels: 1. Shape 2. Color 3. Action
     * 
     *
     */
    public class ControlPanel extends JPanel
    {
        /**
         * Added to get rid of Eclipse warnings
         */
        protected static final long serialVersionUID = 1L;
        /** Shape Panel */
        protected JPanel shapePanel;
        /** Color Panel */
        protected JPanel colorPanel;
        /** Action Panel */
        protected JPanel actionPanel;

        /** Button for oval */
        protected JRadioButton ovalButton;
        /** Button for rectangle */
        protected JRadioButton rectangleButton;
        /** Button for triangle */
        protected JRadioButton triangleButton;
        /** Button for diamond */
        protected JRadioButton diamondButton;
        /** Group for the shape buttons */
        protected ButtonGroup group;

        /** Check box for filled shapes. */
        protected JCheckBox fillBox;
        /** Button for choosing a color. */
        protected JButton colorChooser;
        /** Color that has been chosen. */
        protected Color color;

        /** Undo button */
        protected JButton deleteButton;
        /** Edit button */
        protected JButton editButton;
        /** Random button */
        protected JButton randomButton;

        /**
         * Constructor
         */
        public ControlPanel()
        {
                        
            // Create a border for the panels
            Border blackline = BorderFactory.createLineBorder(Color.black);
            this.setBorder(blackline);

            // Sub-panels with titles
            shapePanel = new JPanel();
            TitledBorder title = new TitledBorder(blackline, "Shape");
            shapePanel.setBorder(title);

            colorPanel = new JPanel();
            title = new TitledBorder(blackline, "Color");
            colorPanel.setBorder(title);

            actionPanel = new JPanel();
            title = new TitledBorder(blackline, "Actions");
            actionPanel.setBorder(title);

            // Add sub-panels to this panel
            this.setLayout(new GridBagLayout());
            GridBagConstraints layoutConst = new GridBagConstraints();
            layoutConst.gridx = 0;
            layoutConst.gridy = 0;
            layoutConst.insets = new Insets(10, 10, 10, 10);
            this.add(shapePanel, layoutConst);

            layoutConst = new GridBagConstraints();
            layoutConst.gridx = 0;
            layoutConst.gridy = 1;
            layoutConst.insets = new Insets(10, 10, 10, 10);
            this.add(colorPanel, layoutConst);

            layoutConst = new GridBagConstraints();
            layoutConst.gridx = 0;
            layoutConst.gridy = 2;
            layoutConst.insets = new Insets(10, 10, 10, 10);
            this.add(actionPanel, layoutConst);

            /////////////////////////
            // Create the radio buttons
            ovalButton = new JRadioButton("oval");
            rectangleButton = new JRadioButton("rectangle");
            triangleButton = new JRadioButton("triangle");
            diamondButton = new JRadioButton("diamond");

            // Group the radio buttons
            group = new ButtonGroup();
            group.add(ovalButton);
            group.add(rectangleButton);
            group.add(triangleButton);
            group.add(diamondButton);

            // Default to oval
            ovalButton.setSelected(true);

            // Layout manager
            shapePanel.setLayout(new GridLayout(0, 1));

            // Add shape label
            shapePanel.add(ovalButton);

            // Add rectangle button
            shapePanel.add(rectangleButton);

            // Add triangle button
            shapePanel.add(triangleButton);

            // Add diamond button
            shapePanel.add(diamondButton);

            //////////
            // Color
            // Default color
            color = new Color(50, 100, 50);

            colorPanel.setLayout(new GridLayout(0, 1));
            // Fill check box
            fillBox = new JCheckBox("fill");
            colorPanel.add(fillBox);

            // Add action listener to fill box for editing
            fillBox.addActionListener(new ActionListener()
            {

                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if (editFlag)
                    {
                        int chosenShape = drawPanel.getShapeIndex();
                        drawPanel.getShapeList().get(chosenShape)
                                        .setFilled(fillBox.isSelected());
                    }
                    drawPanel.repaint();

                }

            });

            // Color button
            colorChooser = new JButton(" ");
            colorChooser.setBackground(color);
            colorPanel.add(colorChooser);

            // Force the size of the panel to be equal to that of the shapePanel
            colorPanel.setPreferredSize(shapePanel.getPreferredSize());

            // Set up color selection dialog box
            colorChooser.addActionListener(new ActionListener()
            {
                /**
                 * Method called when the color button is pressed
                 * 
                 * @param e Action event that is raised
                 */
                public void actionPerformed(ActionEvent e)
                {
                    // Prompt the user for a color (use JColorChooser for this.)
                    // TODO
                    
                    // If a valid color was chosen, assign it to color (the variable).
                    // TODO
                    
                    // Set the background of the button (colorChooser) to match the color chosen
                    // TODO
                    
                    // If we're in edit mode, set the color of the chosen shape
                    // to that of the chosen color (You'll need to look at the code drawPanel provides)
                    // TODO
                    
                    // Repaint the frame and panel. A bit more info is on page 5 of:
                    // https://web.stanford.edu/class/archive/cs/cs108/cs108.1092/handouts/27PaintRepaint.pdf
                    // TODO
                }
            });

            ///////////
            // Action Panel
            actionPanel.setLayout(new GridLayout(0, 1));
            deleteButton = new JButton("Delete");
            editButton = new JButton("Edit");
            randomButton = new JButton("Random");
            actionPanel.add(deleteButton);
            actionPanel.add(editButton);
            actionPanel.add(randomButton);

            // Set up undo behavior
            deleteButton.addActionListener(new ActionListener()
            {
                /**
                 * Method called when the Delete button is pressed
                 * 
                 * @param e Action event that is raised
                 */
                public void actionPerformed(ActionEvent e)
                {
                    if (deleteButton.getText().equals("Delete"))
                    {
                        // set deleteButton to say "Complete"
                        deleteButton.setText("Complete");
                        // disable other buttons and boxes
                        editButton.setEnabled(false);
                        ovalButton.setEnabled(false);
                        rectangleButton.setEnabled(false);
                        triangleButton.setEnabled(false);
                        diamondButton.setEnabled(false);
                        colorChooser.setEnabled(false);
                        fillBox.setEnabled(false);
                        randomButton.setEnabled(false);

                        // Indicate that delete mode has been activated
                        deleteFlag = true;
                    }
                    else if (deleteButton.getText().equals("Complete"))
                    {
                        // set deleteButton to say "Delete"
                        deleteButton.setText("Delete");
                        // enable other buttons and boxes
                        editButton.setEnabled(true);
                        ovalButton.setEnabled(true);
                        rectangleButton.setEnabled(true);
                        triangleButton.setEnabled(true);
                        diamondButton.setEnabled(true);
                        colorChooser.setEnabled(true);
                        fillBox.setEnabled(true);
                        randomButton.setEnabled(true);

                        // Indicate that delete mode has been deactivated
                        deleteFlag = false;
                    }
                }
            });
            editButton.addActionListener(new ActionListener()
            {
                /**
                 * Method called when the button is pressed
                 * 
                 * @param e Action even that is raised
                 */
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if (editButton.getText().equals("Edit"))
                    {
                        // set editButton to "Complete"
                        editButton.setText("Complete");
                        // disable other buttons
                        deleteButton.setEnabled(false);
                        ovalButton.setEnabled(false);
                        rectangleButton.setEnabled(false);
                        triangleButton.setEnabled(false);
                        diamondButton.setEnabled(false);
                        randomButton.setEnabled(false);

                        // Indicate that edit mode has been activated
                        editFlag = true;
                    }
                    else if (editButton.getText().equals("Complete"))
                    {
                        // set editButton to "Edit"
                        editButton.setText("Edit");
                        // enable other buttons
                        deleteButton.setEnabled(true);
                        ovalButton.setEnabled(true);
                        rectangleButton.setEnabled(true);
                        triangleButton.setEnabled(true);
                        diamondButton.setEnabled(true);
                        randomButton.setEnabled(true);

                        // Indicate that edit mode has been deactivated
                        editFlag = false;
                    }
                }
            });
            randomButton.addActionListener(new ActionListener()
            {
                /**
                 * Method called when the button is pressed
                 * 
                 * @param e Action even that is raised
                 */
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    // choose random shape {diamond, rectangle, oval, triangle}
                    int randShapeChoice = rand.nextInt() % 4;

                    // get random point
                    int randX = rand.nextInt(501) + 100; // 100 - 600
                    int randY = rand.nextInt(401) + 100; // 100 - 500
                    Point randPoint = new Point(randX, randY);
                    
                    // get random color
                    int randR = rand.nextInt(256); // 0 - 255
                    int randG = rand.nextInt(256); // 0 - 255
                    int randB = rand.nextInt(256); // 0 - 255
                    Color randColor = new Color(randR, randG, randB);

                    // coin flip for filled/unfilled
                    boolean randFill = rand.nextBoolean();

                    // get two random values for shape
                    int randInverser = rand.nextInt(2) == 0 ? 1 : -1; // +- 1
                    // +- (25..200)
                    int randVal1 = randInverser * rand.nextInt(176) + 25;

                    randInverser = rand.nextInt(2) == 0 ? 1 : -1; // +- 1
                    // +- (25..200)
                    int randVal2 = randInverser * rand.nextInt(176) + 25;

                    if (randShapeChoice == 0) // Diamond
                    {
                        // TODO: create a diamond with the random values and add it to the drawpanel.
                    }
                    else if (randShapeChoice == 1) // Rectangle
                    {
                        // TODO: create a rectangle with the random values and add it to the drawpanel.
                    }
                    else if (randShapeChoice == 2) // Oval
                    {
                        // TODO: create a oval with the random values and add it to the drawpanel.
                    }
                    else // Triangle
                    {
                        // TODO: create a triangle with the random values and add it to the drawpanel.
                    }
                    // repaint panel
                    drawPanel.repaint();
                }

            });
            
            ////////////////////////////////////////////////////////////////////
            // THIS IS FOR TESTING PURPOSES ////////////////////////////////////
            // DO NOT DELETE ///////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////
            shapePanel.setName("shapePanel");
            colorPanel.setName("colorPanel");
            actionPanel.setName("actionPanel");
            ovalButton.setName("ovalButton");
            rectangleButton.setName("rectangleButton");
            triangleButton.setName("triangleButton");
            diamondButton.setName("diamondButton");
            fillBox.setName("fillBox");
            colorChooser.setName("colorChooser");
            deleteButton.setName("deleteButton");
            editButton.setName("editButton");
            randomButton.setName("randomButton");
            ////////////////////////////////////////////////////////////////////

        }

        /**
         * Return action panel of the control panel.
         * 
         * @return The control panel's action panel.
         */
        public JPanel getActionPanel()
        {
            return actionPanel;
        }

        /**
         * Return fill box
         * 
         * @return Fill box
         */
        public JCheckBox getFillBox()
        {
            return fillBox;
        }

        /**
         * Set the color to be drawn.
         * 
         * @param color The chosen color.
         */
        public void setColor(Color color)
        {
            colorChooser.setBackground(color);
            this.color = color;
        }
    }

    /////////////////////////////////////////////////////////////////////////
    // Public interface by the Frame class: gives access to the state of the
    // control panel.

    /**
     * Check to see if the oval Button has been selected
     * 
     * @return true if the oval radio button is currently selected
     */
    public boolean isOval()
    {
        // TODO: implement this => check info on the correct graphical component.
    }

    /**
     * Check to see if the rectangle Button has been selected
     * 
     * @return true if the rectangle radio button is currently selected
     */
    public boolean isRectangle()
    {
        // TODO: implement this => check info on the correct graphical component.
    }

    /**
     * Check to see if the triangle Button has been selected
     * 
     * @return true if the triangle radio button is currently selected
     */
    public boolean isTriangle()
    {
        // TODO: implement this => check info on the correct graphical component.
    }

    /**
     * Check to see if the triangle Button has been selected
     * 
     * @return true if the triangle radio button is currently selected
     */
    public boolean isDiamond()
    {
        // TODO: implement this => check info on the correct graphical component.
    }

    /**
     * Check to see if the "filled" checkbox has been selected
     * 
     * @return true if the filled checkbox is currently selected
     */
    public boolean isFilled()
    {
        // TODO: implement this => check info on the correct graphical component.
    }

    /**
     * Return the currently selected color
     * 
     * @return The currently selected color
     */
    public Color getColor()
    {
        return this.controlPanel.color;
    }

    /**
     * Return boolean indicating edit mode
     * 
     * @return The edit flag.
     */
    public boolean isEditing()
    {
        return this.editFlag;
    }

    /**
     * Return the boolean indicating deletion mode
     * 
     * @return The delete flag.
     */
    public boolean isDeleting()
    {
        return this.deleteFlag;
    }

    /**
     * Constructor for the frame
     */
    public DrawFrame()
    {
        // set title of frame
        super("OU Draw");
       
        // Create the 3 main components
        drawPanel = new DrawPanel(this);
        controlPanel = new ControlPanel();

        // Layout the components
        this.setLayout(new BorderLayout());
        this.add(drawPanel, BorderLayout.CENTER);
        this.add(controlPanel, BorderLayout.EAST);

        // Set size and location of the frame
        this.setSize(800, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        // Define closing response
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Make visible
        this.setVisible(true);

        ////////////////////////////////////////////////////////////////////////
        // THIS IS FOR TESTING PURPOSES ////////////////////////////////////////
        // DO NOT DELETE ///////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////
        drawPanel.setName("drawPanel");
        controlPanel.setName("controlPanel");
        ////////////////////////////////////////////////////////////////////////

    }

    /**
     * Main method: creating the Drawing Frame
     * 
     * @param args Not used
     */
    public static void main(String[] args)
    {
        DrawFrame frame = new DrawFrame();
        // Added to make WebCat happy
        frame.isActive();
    }

    /**
     * Return control panel of the frame.
     * 
     * @return The frame's control panel
     */
    public ControlPanel getControlPanel()
    {
        return controlPanel;
    }

}
