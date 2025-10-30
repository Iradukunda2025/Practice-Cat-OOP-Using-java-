import java.awt.*;
import java.awt.event.*;


public class ShapesWindow extends Frame {

    public ShapesWindow() {
        // Set up the main frame
        setTitle("My Shapes");
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Create a panel for drawing shapes (placeholder)
        Panel shapesPanel = new Panel() {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                // Draw some sample shapes
                g.setColor(Color.RED);
                g.fillRect(50, 50, 100, 100); // Square
                g.setColor(Color.BLUE);
                g.fillOval(200, 50, 100, 100); // Circle
                g.setColor(Color.GREEN);
                g.fillRect(125, 175, 150, 50); // Rectangle
            }
        };

        shapesPanel.setBackground(Color.WHITE);
        add(shapesPanel, BorderLayout.CENTER);


        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ShapesWindow();
    }
}