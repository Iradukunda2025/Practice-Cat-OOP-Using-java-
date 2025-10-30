import java.awt.*;
import java.awt.event.*;

public class MenuNavigation extends Frame {
    private CardLayout cardLayout;
    private Panel mainPanel;

    public MenuNavigation() {
        setTitle("AWT MENU Practice");
        setSize(500, 400);
        setLayout(new BorderLayout());

        MenuBar menuBar = new MenuBar();

        Menu pagesMenu = new Menu("Pages");
        MenuItem loginItem = new MenuItem("login");
        MenuItem studentItem = new MenuItem("student");

        pagesMenu.add(loginItem);
        pagesMenu.add(studentItem);

        Menu editMenu = new Menu("Edit");
        Menu helpMenu = new Menu("Help");

        menuBar.add(pagesMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        setMenuBar(menuBar);

        cardLayout = new CardLayout();
        mainPanel = new Panel(cardLayout);

        Panel loginPage = createLoginPage();
        mainPanel.add(loginPage, "login");

        Panel studentPage = createStudentPage();
        mainPanel.add(studentPage, "student");

        add(mainPanel, BorderLayout.CENTER);

        loginItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "login");
            }
        });

        studentItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "student");
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

    private Panel createLoginPage() {
        Panel loginPanel = new Panel();
        loginPanel.setLayout(new BorderLayout());

        Label title = new Label("MY JAVA AWT LAYOUT", Label.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        loginPanel.add(title, BorderLayout.NORTH);


        Panel formPanel = new Panel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Label pageTitle = new Label("LOGIN PAGE", Label.CENTER);
        pageTitle.setFont(new Font("Arial", Font.BOLD, 14));

        Label usernameLabel = new Label("Username");
        Label passwordLabel = new Label("Password");
        TextField usernameField = new TextField(20);
        TextField passwordField = new TextField(20);
        passwordField.setEchoChar('*');
        Button loginButton = new Button("LOGIN");


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        formPanel.add(pageTitle, gbc);


        gbc.gridy = 1;
        gbc.gridwidth = 2;
        formPanel.add(new Label(" "), gbc);


        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        formPanel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        formPanel.add(usernameField, gbc);

        gbc.gridy = 3;
        gbc.gridwidth = 2;
        formPanel.add(new Label(" "), gbc); //


        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        formPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        formPanel.add(passwordField, gbc);


        gbc.gridy = 5;
        gbc.gridwidth = 2;
        formPanel.add(new Label(" "), gbc);


        gbc.gridy = 6;
        gbc.gridwidth = 2;
        formPanel.add(loginButton, gbc);

        loginPanel.add(formPanel, BorderLayout.CENTER);

        return loginPanel;
    }

    private Panel createStudentPage() {
        Panel studentPanel = new Panel();
        studentPanel.setLayout(new BorderLayout());

        Label title = new Label("STUDENT PAGE", Label.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        studentPanel.add(title, BorderLayout.NORTH);

        Label content = new Label("IRADUKUNDA Jean De Dieu_24rp04674", Label.CENTER);
        studentPanel.add(content, BorderLayout.CENTER);

        return studentPanel;
    }

    public static void main(String[] args) {
        new MenuNavigation();
    }
}