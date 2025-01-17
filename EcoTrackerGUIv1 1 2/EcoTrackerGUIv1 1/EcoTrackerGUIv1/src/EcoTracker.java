import com.sun.net.httpserver.Authenticator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EcoTracker {
    private String name;
    private String output = "";
    private int age;

    private JPanel mainPanel;
    private JPanel detailPanel;
    private JPanel controlPanel;
    private JButton nextBtn;
    private JButton backBtn;
    private JPanel welcomePanel;
    private JPanel habitPanel;
    private JPanel additionalPanel;
    private JPanel welcomeCtrlsPanel;
    private JTextField txtName;
    private JTextField txtAge;
    private JLabel nameLbl;
    private JLabel ageLbl;
    private JLabel logoLbl;
    private JComboBox bottleBox;
    private JPanel titleLbl;
    private JLabel title2Lbl;
    private JLabel screen2usageLbl;
    private JComboBox coffeBox;
    private JComboBox bagsBox;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JButton summaryBtn;
    private JButton saveBtn;
    private JLabel txt1Lbl;
    private JLabel txt2Lbl;
    private JLabel txt4Lbl;
    private JLabel summaryOutputLbl;
    private JPanel leftSide;
    private JLabel logooLbl;
    private JButton resetBtn;
    private JLabel coffeLbl;
    private JLabel bagLbl;
    private JLabel bottleLbl;
    private JLabel coffeeLbl;
    private JLabel strawsLbl;
    private JPanel picsPanel;
    private JLabel walkLbl;
    private JPanel summaryPanel;
    private JButton awesomeBtn;
    private JButton greatBtn;
    private JButton averageBtn;
    private JButton notEcoBtn;
    private JLabel outcomeLbl;
    private JLabel avesomeLbl;
    private JLabel greatLbl;
    private JLabel averageLbl;
    private JLabel notEcoLbl;
    private JLabel savingsWLbl;
    private JLabel hintLbl;
    private JLabel savingsYLbl;
    private JLabel savLbl;
    private JLabel totalLbl;
    private JTextArea weekYearTotalTxt;
    private JTextArea hintTxt;
    private JPanel leftLogoPanel;
    private JPanel titleLastLbl;
    private JLabel knowLbl;
    private JPanel titleeLBL;
    private JPanel picturesPanel;
    private JLabel item1PicLbl;
    private JLabel item2PicLbl;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JLabel leftLogoLbl;
    private JButton bulbBtn;
    private JButton paperBtn;
    private JTextArea bulbOutArea;
    private JTextArea paperOutArea;
    private JTextArea funFactArea;
    private JButton funFactButton;
    private final JFileChooser filePicker = new JFileChooser();
    public String summaryMessage;

    /**
     * Main method to launch the application
     *
     * @param args
     */
    public static void main(String[] args) {
        EcoTracker myApp = new EcoTracker();
        myApp.setupGUI();

    }

    /**
     * Constructor for the Reset button
     */
    private void resetForm() {
        // Reset combo boxes to default value (0)
        bottleBox.setSelectedIndex(0);
        coffeBox.setSelectedIndex(0);
        bagsBox.setSelectedIndex(0);
        comboBox3.setSelectedIndex(0);
        comboBox4.setSelectedIndex(0);

        // Hide all summary labels
        avesomeLbl.setVisible(false);
        greatLbl.setVisible(false);
        averageLbl.setVisible(false);
        notEcoLbl.setVisible(false);
        averageBtn.setVisible(false);
        awesomeBtn.setVisible(false);
        greatBtn.setVisible(false);
        notEcoBtn.setVisible(false);
        //Clear all the labels
        weekYearTotalTxt.setText("");
        hintTxt.setText("");
    }


    /**
     * Method to set up the main GUI window
     */
    public static void setupGUI() {
        JFrame myApp = new JFrame("Eco Tracker Application v1");
        myApp.setContentPane(new EcoTracker().mainPanel); // Set the main panel
        myApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close app on window close
        myApp.pack(); // Automatically resize components
        myApp.setSize(900, 750);

        // Set fixed window size
        // Center the window on the screen
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - myApp.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - myApp.getHeight()) / 2);
        myApp.setLocation(x, y);
        myApp.setResizable(false); // Prevent resizing
        myApp.setVisible(true); // Make the window visible
    }


    /**
     * Method to resize static images for icons
     */

    private ImageIcon resizeIcon(String resourcePath, int width, int height) {
        ImageIcon originalIcon = new ImageIcon(getClass().getResource(resourcePath)); // Load the image
        Image resizedImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH); // Resize the image
        return new ImageIcon(resizedImage); // Return resized image
    }

    /**
     * Method for GIFs
     *
     * @param resourcePath
     * @return
     */
    private ImageIcon loadGif(String resourcePath) {
        return new ImageIcon(getClass().getResource(resourcePath));
    }

    /**
     * Constructor to initialize the application and set up event listeners
     */
    public EcoTracker() {
        //  createUIComponents();
        // Hide all summary labels initially
        avesomeLbl.setVisible(false);
        greatLbl.setVisible(false);
        averageLbl.setVisible(false);
        notEcoLbl.setVisible(false);
        //Same for buttons
        awesomeBtn.setVisible(false);
        greatBtn.setVisible(false);
        averageBtn.setVisible(false);
        notEcoBtn.setVisible(false);
        // Back button functionality: Navigate to the previous screen
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gotoPreviousScreen();
            }
        });

        // Next button functionality: Navigate to the next screen
        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gotoNextScreen();
            }

        });

        // Set icons for different eco habits
        bagLbl.setIcon(resizeIcon("images/Bag.jpg", 50, 50));
        bottleLbl.setIcon(resizeIcon("images/WaterBottle.jpg", 50, 50));
        coffeeLbl.setIcon(resizeIcon("images/CoffeeCup.jpg", 50, 50));
        strawsLbl.setIcon(resizeIcon("images/straws.jpg", 50, 50));
        walkLbl.setIcon(resizeIcon("images/walk.jpg", 50, 50));
        item2PicLbl.setIcon(resizeIcon("images/paperless.jpg", 300, 100));
        item1PicLbl.setIcon(resizeIcon("images/bulb.jpg", 300, 100));
        leftLogoLbl.setIcon(resizeIcon("images/logo.png", 80, 80));

        // Set icons for summary buttons with animated GIFs
        avesomeLbl.setIcon(loadGif("images/awesome.gif"));
        greatLbl.setIcon(loadGif("images/great.gif"));
        averageLbl.setIcon(loadGif("images/average.gif"));
        notEcoLbl.setIcon(loadGif("images/noteco.gif"));
        summaryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSummary();
            }
        });

        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetForm();
            }
        });
        saveBtn.addActionListener(new ActionListener() {
            //
            @Override
            public void actionPerformed(ActionEvent e) {
                int answer = JOptionPane.showConfirmDialog(null, "Do you want the current list saved to file?", "Confirm list", JOptionPane.OK_CANCEL_OPTION);
                if (answer == JOptionPane.OK_OPTION) {
                    //Show file chooser dialog to let user save to desired destination
                    int returnVal = filePicker.showSaveDialog(habitPanel);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        //get selected file
                        File file = filePicker.getSelectedFile();
                        //System.out.println(file);
                        try {
                            FileWriter myWriter = null;
                            try {
                                myWriter = new FileWriter(file);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                            myWriter.write(summaryMessage);
                            myWriter.flush();
                            myWriter.close();
                            JOptionPane.showConfirmDialog(null, "File Saved Successfully", "Success", JOptionPane.OK_CANCEL_OPTION);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }

                    }
                }
            }
        });
        bulbBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int outputBulb = (Integer) spinner1.getValue();//get number from spinner
                double standardBulb = 1.29;
                double ledBulb = 5.40;
                double savingPerBulb = (20 * standardBulb) - ledBulb;
                String textBulb;
                textBulb = "BENEFITS OF USING LED BULBS:\n" +
                        "Energy Saving: Use much less electricity than traditional bulbs.\n" +
                        "Long Life: Lasts 20x longer than standard bulbs.\n" +
                        "Cost-Effective: Higher price upfront but saves money over time.\n" +
                        "Eco-Friendly: No harmful chemicals, less energy use.\n" +
                        "Durable: Tougher and less likely to break.\n" +
                        "Instant Light: Turns on immediately with no delay.\n" +
                        "Cooler: Produces little heat, safer to use.\n" +
                        "DOWNSIZES OF LED BULBS:\n" +
                        "Expensive Initially: Costs more to buy.\n" +
                        "Light Direction: May not spread light as evenly.\n" +
                        "Not Always Compatible: Some don’t work with old dimmers or fixtures.\n" +
                        "Blue Light: Can strain eyes if used too much at night.\n" +
                        "Quality Varies: Cheap LEDs may not perform well.";

                // Display the result in a text area
                double totalSavings = outputBulb * savingPerBulb;
                //print savings onto the screen
                String savingsMessage = String.format("Total savings for replacing %d bulbs: £%.2f", outputBulb, totalSavings);
                bulbOutArea.setText(savingsMessage + "\n" + textBulb);


            }
        });
        paperBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int packUse = (Integer) spinner2.getValue();
                int sheetsPack = 5000;//sheets per each pack
                int sheetsTree = 10000;//produced sheets by one tree
                // Calculate total sheets and trees chopped
                int totalSheets = packUse * sheetsPack;
                int treesChopped = (int) Math.ceil((double) totalSheets / sheetsTree); // round up to the nearest whole number

                // Information about benefits of going digital
                String textPaper = "BENEFITS OF REDUCING PAPER\n" +
                        " Saves Trees: Preserves forests by reducing paper demand.\n" +
                        " Cost-Effective: Less money spent on paper, ink, and printing.\n" +
                        " Space Saving: Digital documents take no physical space.\n" +
                        " Convenient: Access files anywhere, anytime.\n" +
                        " Eco-Friendly: Reduces waste and energy consumption.\n" +
                        " Enhanced Collaboration: Easier to share and collaborate online.\n" +
                        " Long-Term Storage: Digital files last longer without deterioration.\n" +
                        "DOWNSIDES OF USING PAPER\n" +
                        "Deforestation: Leads to loss of forests and biodiversity.\n" +
                        "Expensive in Bulk: Continuous cost for paper and printing.\n" +
                        "Storage Issues: Requires physical storage and organization.\n" +
                        "Waste: Large amounts of paper end up in landfills.\n" +
                        "Limited Accessibility: Hard to access remotely.\n";

                // Display the result in a text area
                String resultMessage = String.format("Total sheets used: %,d\nNumber of trees chopped: %d", totalSheets, treesChopped);
                paperOutArea.setText(resultMessage + "\n" + textPaper);
            }
        });
        funFactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Fun fact 1: Trees planted over the lifetime
                int treesPlanted = age * 2; // Assuming they plant 2 trees per year on average
                // Fun fact 2: Water saved by using a water-efficient showerhead
                int waterSaved = age * 365 * 50; // Saves 50 liters per day

                // Build the fun fact message
                String funFact = String.format("Wow! At age of %d:\n1.You could have planted %d trees in your lifetime.\n" +
                                "2.Using a water-efficient showerhead, you could have saved \n%d liters of water!",
                        age, treesPlanted, waterSaved
                );
                funFactArea.setText(funFact);

            }
        });
    }

    /**
     * Method for calculating summary
     */
    private void showSummary() {
        // Get the values from the combo boxes
        int reusableBottleUsage = Integer.parseInt(bottleBox.getSelectedItem().toString());
        int reusableCoffeeCupUsage = Integer.parseInt(coffeBox.getSelectedItem().toString());
        int reusableBagUsage = Integer.parseInt(bagsBox.getSelectedItem().toString());
        int strawsUsage = Integer.parseInt(comboBox3.getSelectedItem().toString());
        int walkingBikingUsage = Integer.parseInt(comboBox4.getSelectedItem().toString());

        // Calculate the total eco score
        int totalScore = reusableBottleUsage + reusableCoffeeCupUsage + reusableBagUsage + strawsUsage + walkingBikingUsage;

        // Debug print statements
        System.out.println("Total Score: " + totalScore);
//Calculate savings week
        double savingsWeek = (reusableBottleUsage * 0.50) + // Savings per use of a water bottle
                (reusableCoffeeCupUsage * 1.00) + // Savings per use of a coffee cup
                (reusableBagUsage * 0.3) + // Savings per use of a shopping bag
                (strawsUsage * 0.10) + // Savings per use of reusable straws
                (walkingBikingUsage * 2.00); // Savings per walking/biking trip instead of driving
        // Calculate savings year
        double savings = (reusableBottleUsage * 0.50 * 365) + // Savings per use of a water bottle
                (reusableCoffeeCupUsage * 1.00 * 365) + // Savings per use of a coffee cup
                (reusableBagUsage * 0.3 * 365) + // Savings per use of a shopping bag
                (strawsUsage * 0.10 * 365) + // Savings per use of reusable straws
                (walkingBikingUsage * 2.00 * 365); // Savings per walking/biking trip instead of driving

        // Debug print statement for savings
        System.out.println("Total Savings: £" + String.format("%.2f", savings) + String.format("%.2f", savingsWeek));

        // Debug print to confirm which label is shown
        System.out.println("Visible labels after summary calculation:");
        System.out.println("Awesome: " + avesomeLbl.isVisible());
        System.out.println("Great: " + greatLbl.isVisible());
        System.out.println("Average: " + averageLbl.isVisible());
        System.out.println("Not Eco: " + notEcoLbl.isVisible());

        // Show the message dialog with a summary
        String ecoStatus;
        if (totalScore >= 25 && totalScore <= 35) {
            ecoStatus = "Awesome! You are very eco-friendly!";
            avesomeLbl.setVisible(true);// Show only the 'Awesome' GIF
            awesomeBtn.setVisible(true);
            hintTxt.setText("You're an Eco Superstar!" + "\nKeep rocking!!!!\n This lifestyle is inspiring");
        } else if ((totalScore >= 15 && totalScore <= 24)) {
            ecoStatus = "Great! You are eco-conscious!";
            greatLbl.setVisible(true); // Show only the 'Great' GIF
            greatBtn.setVisible(true);
            hintTxt.setText("Fantastic progress! 🌱 \nKeep up the good work and aim even higher.");
        } else if ((totalScore >= 10 && totalScore <= 14)) {
            ecoStatus = "Average. You're doing okay, but there is room for improvement!";
            averageLbl.setVisible(true); // Show only the 'Average' GIF
            averageBtn.setVisible(true);
            hintTxt.setText("Not bad, but you can do better! 🌿 \nTry a few more eco-friendly choices today.");
        } else {
            ecoStatus = "Not Eco-friendly.\n You should make an effort to use more sustainable habits!";
            notEcoLbl.setVisible(true); // Show only the 'Not Eco-friendly' GIF
            notEcoBtn.setVisible(true);
            hintTxt.setText("Oops! 🌍 It’s time to make some planet-friendly changes.\nYou’ve got this!");
        }
        // Show the summary in a dialog box including savings
        summaryMessage = String.format(
                "Summary of Your Eco Habits:\n" +
                        "- Reusable Water Bottle: %d times per week\n" +
                        "- Reusable Coffee Cup: %d times per week\n" +
                        "- Reusable Shopping Bag: %d times per week\n" +
                        "- Using Reusable Straws: %d times per week\n" +
                        "- Walking/Biking for Short Trips: %d times per week\n\n" +
                        "Total Eco Score: %d\n" +
                        "Eco Status: %s\n" +
                        "Total Savings: £%.2f"
                , reusableBottleUsage, reusableCoffeeCupUsage, reusableBagUsage, strawsUsage, walkingBikingUsage, totalScore, ecoStatus, savings);

        JOptionPane.showMessageDialog(null, summaryMessage, "Your Eco Summary", JOptionPane.INFORMATION_MESSAGE);
        weekYearTotalTxt.setText(summaryMessage);

    }

    /**
     * Method to navigate to the next screen
     */
    public void gotoNextScreen() {
        // Get the current panel name
        String currentPanel = getCurrentPanelName();

        if (currentPanel.equals("WelcomePanel")) {
            // Will remove leading and trailing spaces
            String name = txtName.getText().trim();

            // Validates that name field is not blank when user tries to go next
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(detailPanel, "Please enter your name to proceed!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Checks that name is at least 2 letters long
            else if (name.length() < 2) {
                JOptionPane.showMessageDialog(detailPanel, "Name must be at least 2 characters long.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Check that name contains only letters and spaces
            else if (!name.matches("[a-zA-Z ]+")) {
                JOptionPane.showMessageDialog(detailPanel, "Enter a valid name! (Letters and spaces only)", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Proceed with age validation and transition to the next panel
            validateAndProceed();
        }
        // If it's HabitPanel, go to the next panel (e.g., AdditionalPanel)
        else if (currentPanel.equals("HabitPanel")) {
            // Proceed to the next panel (e.g., AdditionalPanel)
            CardLayout cardLayout = (CardLayout) detailPanel.getLayout();
            cardLayout.next(detailPanel);
        } else if (currentPanel.equals("AdditionalPanel")) {
            // Handle Finish button
            int confirm = JOptionPane.showConfirmDialog(
                    detailPanel,
                    "Are you sure you want to finish?",
                    "Confirmation",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (confirm == JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(null, "Thank you for using the program! Goodbye!");
                System.exit(0); // Exit the program if confirmed
            }
            return; // Do nothing if the user cancels
        }

        // Update button states after navigation
        String newCurrentPanel = getCurrentPanelName(); // Ensure to get the panel after the transition
        if (newCurrentPanel.equals("WelcomePanel")) {
            backBtn.setEnabled(false);  // Disable the Back button on the WelcomePanel
            nextBtn.setEnabled(true);   // Enable the Next button
            nextBtn.setText("Next");    // Ensure the button text is "Next"
        } else if (newCurrentPanel.equals("HabitPanel")) {
            backBtn.setEnabled(true);   // Enable the Back button on the HabitPanel
            nextBtn.setEnabled(true);   // Enable the Next button
            nextBtn.setText("Next");    // Ensure the button text is "Next"
        } else if (newCurrentPanel.equals("AdditionalPanel")) {
            backBtn.setEnabled(true);   // Enable the Back button on the AdditionalPanel
            nextBtn.setEnabled(true);  // Disable the Next button on the last panel
            nextBtn.setText("Finish");  // Change the button text to "Finish"
        }
    }

    /**
     * Method for validation and proceeding to the next screen
     */
    private void validateAndProceed() {
        // Validate age after the name validation
        String ageStr = txtAge.getText().trim(); // Ensure no leading/trailing spaces
        if (ageStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You need to enter an age", "Blank age!", JOptionPane.WARNING_MESSAGE);
            return; // Wait for user to correct input
        }

        try {
            int age = Integer.parseInt(ageStr);

            // Check if age is within the valid range
            if (age <= 0 || age > 100) { // Ensure age is greater than 0 and less than or equal to 100
                JOptionPane.showMessageDialog(null, "Age must be between 1 and 100", "Invalid age!", JOptionPane.WARNING_MESSAGE);
                return; // Wait for user to correct input
            }

            // Valid age entered; save and proceed
            this.age = age;

            // Proceed to the next panel (HabitPanel)
            CardLayout cardLayout = (CardLayout) detailPanel.getLayout();
            cardLayout.next(detailPanel);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "You need to enter a number for the age", "Invalid input!", JOptionPane.WARNING_MESSAGE);
        }
    }
    /**
     * Method to navigate to the previous screen
     */
    public void gotoPreviousScreen() {
        CardLayout cardLayout = (CardLayout) detailPanel.getLayout();
        cardLayout.previous(detailPanel);  // Navigate to previous panel

        // Check which panel is currently on and enable or disable the buttons
        String currentPanel = getCurrentPanelName();
        if (currentPanel.equals("WelcomePanel")) {
            backBtn.setEnabled(false);  // Disable the Back button on the WelcomePanel
            nextBtn.setEnabled(true);   // Enable the Next button
        } else if (currentPanel.equals("HabitPanel")) {
            backBtn.setEnabled(true);   // Enable the Back button on the HabitPanel
            nextBtn.setEnabled(true);   // Enable the Next button on the HabitPanel
            nextBtn.setText("Next");
        } else if (currentPanel.equals("AdditionalPanel")) {
            backBtn.setEnabled(true);   // Enable the Back button on the AdditionalPanel
            nextBtn.setEnabled(false);  // Disable the Next button on the last panel
        }
    }

    /**
     * Used to check what the current panel is for the next and back buttons
     *
     * @return CurrentPanel or nothing
     */
    private String getCurrentPanelName() {
        CardLayout cardLayout = (CardLayout) detailPanel.getLayout();
        //Used to check what card you're on for the next and back buttons to be enabled or disabled
        if (detailPanel.getComponent(0).isVisible()) {
            return "WelcomePanel";  //WelcomePanel is at index 0
        } else if (detailPanel.getComponent(1).isVisible()) {
            return "HabitPanel";  //HabitPanel is at index 1
        } else if (detailPanel.getComponent(2).isVisible()) {
            return "AdditionalPanel";  //AdditionalPanel is at index 2
        }
        return "";
    }

    private void createUIComponents() {
        // Create separate models for each spinner
        SpinnerNumberModel model1 = new SpinnerNumberModel(1, 0, 100, 1); // For spinner1
        SpinnerNumberModel model2 = new SpinnerNumberModel(1, 0, 100, 1); // For spinner2

        // Initialize spinner1
        spinner1 = new JSpinner(model1);

        // Set up the editor for spinner1
        JSpinner.DefaultEditor editor1 = (JSpinner.DefaultEditor) spinner1.getEditor();
        JFormattedTextField textField1 = editor1.getTextField();
        textField1.setHorizontalAlignment(JTextField.RIGHT);
        textField1.setEditable(false); // Prevent user typing
        spinner1.setEditor(editor1);

        // Initialize spinner2
        spinner2 = new JSpinner(model2);

        // Set up the editor for spinner2
        JSpinner.DefaultEditor editor2 = (JSpinner.DefaultEditor) spinner2.getEditor();
        JFormattedTextField textField2 = editor2.getTextField();
        textField2.setHorizontalAlignment(JTextField.RIGHT);
        textField2.setEditable(false); // Prevent user typing
        spinner2.setEditor(editor2);
    }
}






