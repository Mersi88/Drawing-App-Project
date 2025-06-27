public class Project2Runner {

    /*
     * Name: <Your Name>
     * Student ID: <Your Student ID>
     * 
     ******** Project Description ********
     *
     * Pixel Painter is a simple interactive drawing app that lets the user draw either
     * rectangles or circles on a canvas using mouse clicks. The user can choose the shape
     * type using radio buttons and select a fill color from a drop-down combo box.
     * Additionally, users can clear the canvas using a button, and press keyboard shortcuts
     * to change the size of the shapes. This program demonstrates GUI interactivity, 2D graphics,
     * and multiple event listeners all integrated into a clean, object-oriented design.
     *
     * Users interact with the program by:
     * - Selecting a shape (circle or rectangle)
     * - Selecting a color
     * - Clicking the canvas to draw the shape
     * - Pressing keyboard keys to increase/decrease shape size or clear the canvas
     * - Clicking a "Clear" button to wipe the canvas
     *
     ******** Swing Requirement ********
     *
     * The program uses three unique Swing components:
     * 1. JRadioButton – to select the shape (line 42 in DrawingApp.java)
     * 2. JComboBox – to select the drawing color (line 47 in DrawingApp.java)
     * 3. JButton – to clear the canvas (line 52 in DrawingApp.java)
     * These components are placed inside a JPanel that sits on top of the drawing canvas.
     *
     ******** 2D Graphics Requirement ********
     *
     * The drawing area is implemented using a custom JPanel subclass called DrawingPanel
     * (defined at line 70 in DrawingApp.java). The panel overrides paintComponent(Graphics g)
     * to draw all shapes from an internal list of ShapeInfo objects. When the user clicks,
     * a new shape is added and the panel is repainted, showing all the shapes.
     *
     ******** Event Listener Requirement ********
     *
     * The program uses multiple listeners:
     * - An ActionListener for the Clear button to remove all shapes (line 56 in DrawingApp.java)
     * - An ActionListener for the JComboBox to change color (line 49 in DrawingApp.java)
     * - A MouseListener on the canvas to draw shapes on click (line 95 in DrawingApp.java)
     * - A KeyListener for keyboard shortcuts like changing size or clearing canvas (line 101 in DrawingApp.java)
     * These listeners trigger graphical updates by modifying the shape list and repainting the panel.
     */

    public static void main(String[] args) {
        new DrawingApp();
    }
}
