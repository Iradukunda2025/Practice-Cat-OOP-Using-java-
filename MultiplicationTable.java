import java.awt.*;
import java.awt.event.*;


public class MultiplicationTable extends Frame {
    private TextField numberField;
    private TextArea resultArea;
    private Button displayButton;

    public MultiplicationTable() {
        // Set up the main frame
        setTitle("AWT Practice - Multiplication Table");
        setSize(300, 400);
        setLayout(new BorderLayout(10, 10));


        Panel inputPanel = new Panel(new FlowLayout());
        Label numberLabel = new Label("Enter number:");
        numberField = new TextField(5);
        displayButton = new Button("DISPLAY");

        inputPanel.add(numberLabel);
        inputPanel.add(numberField);
        inputPanel.add(displayButton);

        // Create result area for displaying table
        resultArea = new TextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 12));


        add(inputPanel, BorderLayout.NORTH);
        add(resultArea, BorderLayout.CENTER);


        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generateMultiplicationTable();
            }
        });

        numberField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generateMultiplicationTable();
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });


        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void generateMultiplicationTable() {
        try {
            int number = Integer.parseInt(numberField.getText());
            StringBuilder table = new StringBuilder();

            // Generate multiplication table from 1 to 10
            for (int i = 1; i <= 10; i++) {
                table.append(number).append(" * ").append(i).append(" = ")
                        .append(number * i).append("\n");
            }

            resultArea.setText(table.toString());
        } catch (NumberFormatException ex) {
            resultArea.setText("Please enter a valid number!");
        }
    }

    public static void main(String[] args) {
        new MultiplicationTable();
    }
}