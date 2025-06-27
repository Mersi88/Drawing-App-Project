import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DrawingApp {
    private JFrame frame;
    private DrawingPanel drawingPanel;
    private JComboBox<String> colorBox;
    private JRadioButton circleButton, rectButton;
    private JButton clearButton;
    private String currentColor = "Red";
    private String currentShape = "Circle";
    private int shapeSize = 50;

    public DrawingApp() {
        frame = new JFrame("Pixel Painter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Top control panel
        JPanel controlPanel = new JPanel();

        circleButton = new JRadioButton("Circle", true);
        rectButton = new JRadioButton("Rectangle");
        ButtonGroup shapeGroup = new ButtonGroup();
        shapeGroup.add(circleButton);
        shapeGroup.add(rectButton);

        colorBox = new JComboBox<>(new String[] {"Red", "Green", "Blue", "Black"});
        clearButton = new JButton("Clear Canvas");

        controlPanel.add(new JLabel("Shape:"));
        controlPanel.add(circleButton);
        controlPanel.add(rectButton);
        controlPanel.add(new JLabel("Color:"));
        controlPanel.add(colorBox);
        controlPanel.add(clearButton);

        frame.add(controlPanel, BorderLayout.NORTH);

        // Drawing panel
        drawingPanel = new DrawingPanel();
        frame.add(drawingPanel, BorderLayout.CENTER);

        // Listeners
        circleButton.addActionListener(e -> currentShape = "Circle");
        rectButton.addActionListener(e -> currentShape = "Rectangle");

        colorBox.addActionListener(e -> currentColor = (String) colorBox.getSelectedItem());

        clearButton.addActionListener(e -> {
            drawingPanel.clearShapes();
        });

        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawingPanel.addShape(new ShapeInfo(currentShape, currentColor, e.getX(), e.getY(), shapeSize));
            }
        });

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    shapeSize += 10;
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    shapeSize = Math.max(10, shapeSize - 10);
                } else if (e.getKeyCode() == KeyEvent.VK_C) {
                    drawingPanel.clearShapes();
                }
            }
        });

        frame.setFocusable(true);
        frame.setVisible(true);
    }

    // Shape info model
    private static class ShapeInfo {
        String type, color;
        int x, y, size;

        public ShapeInfo(String type, String color, int x, int y, int size) {
            this.type = type;
            this.color = color;
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }

    // Drawing panel
    private class DrawingPanel extends JPanel {
        private ArrayList<ShapeInfo> shapes = new ArrayList<>();

        public void addShape(ShapeInfo shape) {
            shapes.add(shape);
            repaint();
        }

        public void clearShapes() {
            shapes.clear();
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (ShapeInfo s : shapes) {
                g.setColor(getAWTColor(s.color));
                if (s.type.equals("Circle")) {
                    g.fillOval(s.x - s.size / 2, s.y - s.size / 2, s.size, s.size);
                } else if (s.type.equals("Rectangle")) {
                    g.fillRect(s.x - s.size / 2, s.y - s.size / 2, s.size, s.size);
                }
            }
        }

        private Color getAWTColor(String colorName) {
            switch (colorName) {
                case "Red": return Color.RED;
                case "Green": return Color.GREEN;
                case "Blue": return Color.BLUE;
                case "Black": return Color.BLACK;
                default: return Color.BLACK;
            }
        }
    }
}
