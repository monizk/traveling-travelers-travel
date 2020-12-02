import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class SwingGUI {
    /** variables **/
    TravProfDB db;
    String file = "out/Database.txt";
    String[] travelOptions = {"Business", "Pleasure"};
    String[] payOptions = {"Credit", "Check", "Debit", "Invoice"};
    String[] allOptions = {"None", "Food", "Medication", "Other"};
    String[] illOptions = {"None", "Heart", "Diabetes", "Asthma", "Other"};
    String[] options = {"First Name", "Last Name", "Address", "Phone Number", "Trip Cost", "Travel Type", "Payment Type", "Doctor Name", "Doctor Phone", "Allergy Type", "Illness Type"};

    /** constructor **/
    public SwingGUI () {
        db = new TravProfDB(file);
    }

    /** generate text box components & get the input **/
    public JTextField setGridVariablesField (GridBagConstraints c, int col, int row, String text, JPanel p) {
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = col;
        c.gridy = row;

        JTextField field = new JTextField(text);
        if (row % 5 == 1) {
            field.setBackground(Color.ORANGE);
        } else if (row % 5 == 2) {
            field.setBackground(Color.PINK);
        } else if (row % 5 == 3) {
            field.setBackground(Color.MAGENTA);
        } else if (row % 5 == 4) {
            field.setBackground(Color.CYAN);
        } else if (row % 5 == 0) {
            field.setBackground(Color.BLUE);
        }

        p.add(field, c);

        return field;
    }

    /** generate label components **/
    public void setGridVariablesLabel (GridBagConstraints c, int col, int row, String label, JPanel p) {
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = col;
        c.gridy = row;

        JLabel l = new JLabel(label);
        if (row == 0) {
            l.setForeground(Color.WHITE);
            l.setBackground(Color.BLACK);
        } else if (row % 5 == 1) {
            l.setForeground(Color.ORANGE);
        } else if (row % 5 == 2) {
            l.setForeground(Color.PINK);
        } else if (row % 5 == 3) {
            l.setForeground(Color.MAGENTA);
        } else if (row % 5 == 4) {
            l.setForeground(Color.CYAN);
        } else if (row % 5 == 0) {
            l.setForeground(Color.BLUE);
        }
        p.add(l, c);
    }

    /** generate combo box components **/
    public JComboBox setGridVariablesCombo (GridBagConstraints c, int col, int row, String[] combo, JPanel p) {
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = col;
        c.gridy = row;

        JComboBox box = new JComboBox(combo);
        if (row % 5 == 1) {
            box.setBackground(Color.ORANGE);
        } else if (row % 5 == 2) {
            box.setBackground(Color.PINK);
        } else if (row % 5 == 3) {
            box.setBackground(Color.MAGENTA);
        } else if (row % 5 == 4) {
            box.setBackground(Color.CYAN);
        } else if (row % 5 == 0) {
            box.setBackground(Color.BLUE);
        }
        p.add(box, c);
        return Objects.requireNonNull(box);
    }

    /** generate submit buttons & return the button object **/
    public JButton setGridVariableButton (GridBagConstraints c, int col, int row, String label, JButton button, JPanel p) {
        button.setText(label);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        c.gridx = col;
        c.gridy = row;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.PAGE_END;
        p.add(button, c);

        return button;
    }

    /** provides the visual aspect of locating a profile (for viewing or deleting) **/
    public void findProfile (TravProfDB db, String title, String window) {
        JFrame prompt = new JFrame();
        JPanel p = new JPanel();
        GridBagConstraints c = new GridBagConstraints();
        JTextField ID, last;
        JButton button = new JButton();

        // configure panel
        p.setLayout(new GridBagLayout());
        p.setBackground(Color.BLACK);
        p.setSize(600, 30);

        // configure labels
        setGridVariablesLabel(c, 0, 0, title, p);
        setGridVariablesLabel(c, 0, 1, "Travel ID: ", p);
        setGridVariablesLabel(c, 0, 2, "Last Name: ", p);

        // configure text fields
        ID = setGridVariablesField(c, 1, 1,"Enter Travel ID", p);
        last = setGridVariablesField(c, 1, 2, "Enter Last Name", p);

        // configure button
        button = setGridVariableButton(c, 0, 3, "Submit", button, p);

        // put a listener on the button
        button.addActionListener(e -> {
            if (title.contains("Delete")) {
                delete(db, ID.getText(), last.getText());
            } else if (title.contains("Find")) {
                find(db, ID.getText(), last.getText());
            }
        });

        // configure prompt window
        pack(prompt, p, window);
    }

    /** provides the visual aspect of displaying a profile **/
    public ArrayList<Object> display (TravProf prof, JFrame info, JPanel p) {
        GridBagConstraints c = new GridBagConstraints();
        ArrayList<Object> packParam = new ArrayList<>();

        // configure panel
        p.removeAll();
        p.setLayout(new GridBagLayout());
        p.setBackground(Color.BLACK);
        p.setSize(600, 30);

        // configure left column
        setGridVariablesLabel(c, 0, 0, "Profile Information", p);
        setGridVariablesLabel(c, 0, 1, "First Name: ", p);
        setGridVariablesLabel(c, 0, 2, "Last Name: ", p);
        setGridVariablesLabel(c, 0, 3, "Address: ", p);
        setGridVariablesLabel(c, 0, 4, "Phone Number: ", p);
        setGridVariablesLabel(c, 0, 5, "Trip Cost: ", p);
        setGridVariablesLabel(c, 0, 6, "Travel Type: ", p);
        setGridVariablesLabel(c, 0, 7, "Payment Type: ", p);
        setGridVariablesLabel(c, 0, 8, "Doctor Name: ", p);
        setGridVariablesLabel(c, 0, 9, "Doctor Phone Number: ", p);
        setGridVariablesLabel(c, 0, 10, "Allergy Type: ", p);
        setGridVariablesLabel(c, 0, 11, "Illness Type: ", p);

        // configure right column
        setGridVariablesLabel(c, 1, 1, prof.getFirstName(), p);
        setGridVariablesLabel(c, 1, 2, prof.getLastName(), p);
        setGridVariablesLabel(c, 1, 3, prof.getAddress(), p);
        setGridVariablesLabel(c, 1, 4, prof.getPhone(), p);
        setGridVariablesLabel(c, 1, 5, String.valueOf(prof.getCost()), p);
        setGridVariablesLabel(c, 1, 6, prof.getTravelType(), p);
        setGridVariablesLabel(c, 1, 7, prof.getPaymentType(), p);
        setGridVariablesLabel(c, 1, 8, prof.getMedCondInfo().getMdContact(), p);
        setGridVariablesLabel(c, 1, 9, prof.getMedCondInfo().getMdPhone(), p);
        setGridVariablesLabel(c, 1, 10, prof.getMedCondInfo().getAlgType(), p);
        setGridVariablesLabel(c, 1, 11, prof.getMedCondInfo().getIllType(), p);

        // revalidate & repaint
        p.revalidate();
        p.repaint();

        // add important components to array list
        packParam.add(info);
        packParam.add(p);
        packParam.add("Profile Information");

        // return important components to pack
        return packParam;
    }

    /** pack frame **/
    public void pack(JFrame f, JPanel p, String t) {
        f.add(p);
        f.pack();
        f.setBackground(Color.BLACK);
        f.setTitle(t);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
    }

    /** provides the functionality of the delete option **/
    public void delete (TravProfDB db, String ID, String last) {
        // initialize the database
        db.initializeDatabase("out/Database.txt");
        // delete the profile & send a confirmation--otherwise, communicate the problem
        if(db.deleteProfile(ID, last)){
            db.writeAllTravProf("out/Database.txt");
            JOptionPane.showMessageDialog(null, "Profile Successfully Deleted");
        }else{
            JOptionPane.showMessageDialog(null, "Profile Could Not Be Deleted");
        }
    }

    /** provides the functionality of the find option **/
    public void find (TravProfDB db, String ID, String last) {
        JFrame f = new JFrame();
        JPanel p = new JPanel();
        TravProf prof = db.findProfile(ID, last);

        // check if the profile exists, if not, communicate that, if so, display the information
        if(prof == null){
            JOptionPane.showMessageDialog(null,"This Profile Does Not Exist");
        }else {
            ArrayList<Object> info = display(prof, f, p);
            pack((JFrame) info.get(0), (JPanel) info.get(1), (String) info.get(2));
        }
    }

    /** provides the visual aspect of creating a profile **/
    public void createPrompt (TravProfDB db) {
        JFrame create = new JFrame();
        GridBagConstraints c = new GridBagConstraints();

        // create components
        JPanel p = new JPanel();
        JButton button = new JButton();
        JTextField ID, first, last, address, phone, cost, doc, docPhone;
        JComboBox travel, payment, allergy, ill;

        // configure panel
        p.setLayout(new GridBagLayout());
        p.setBackground(Color.BLACK);
        p.setSize(600, 30);

        // configure labels
        setGridVariablesLabel(c, 0, 0, "Create Traveler Profile", p);
        setGridVariablesLabel(c, 0, 1, "Travel ID: ", p);
        setGridVariablesLabel(c, 0, 2, "First Name: ", p);
        setGridVariablesLabel(c, 0, 3, "Last Name: ", p);
        setGridVariablesLabel(c, 0, 4, "Address: ", p);
        setGridVariablesLabel(c, 0, 5, "Phone Number: ", p);
        setGridVariablesLabel(c, 0, 6, "Trip Cost: ", p);
        setGridVariablesLabel(c, 0, 7, "Travel Type: ", p);
        setGridVariablesLabel(c, 0, 8, "Payment Type", p);
        setGridVariablesLabel(c, 0, 9, "Doctor Name: ", p);
        setGridVariablesLabel(c, 0, 10, "Doctor Phone Number: ", p);
        setGridVariablesLabel(c, 0, 11, "Allergy Type: ", p);
        setGridVariablesLabel(c, 0, 12, "Illness Type: ", p);

        // configure fields
        ID = setGridVariablesField(c, 1, 1, "Enter Travel ID", p);
        first = setGridVariablesField(c, 1, 2, "Enter First Name", p);
        last = setGridVariablesField(c, 1, 3, "Enter Last Name", p);
        address = setGridVariablesField(c, 1, 4, "Enter Address", p);
        phone = setGridVariablesField(c, 1, 5, "Enter Phone Number", p);
        cost = setGridVariablesField(c, 1, 6, "Enter Trip Cost", p);
        doc = setGridVariablesField(c, 1, 9, "Enter Doctor Name", p);
        docPhone = setGridVariablesField(c, 1, 10, "Enter Doctor Phone Number", p);

        // configure combo boxes
        travel = setGridVariablesCombo(c, 1, 7, travelOptions, p);
        payment = setGridVariablesCombo(c, 1, 8, payOptions, p);
        allergy = setGridVariablesCombo(c, 1, 11, allOptions, p);
        ill = setGridVariablesCombo(c, 1, 12, illOptions, p);

        // configure button
        button = setGridVariableButton(c, 0, 13, "Submit", button, p);

        // listener
        button.addActionListener(e -> {
            // generate necessary objects
            MedCond mc = new MedCond(doc.getText(), docPhone.getText(), allergy.getSelectedItem().toString(), ill.getSelectedItem().toString());
            TravProf prof = new TravProf(ID.getText(), first.getText(), last.getText(), address.getText(), phone.getText(), Float.parseFloat(cost.getText()), travel.getSelectedItem().toString(), payment.getSelectedItem().toString(), mc);
            create(db, prof);
        });

        // display & fill the window
        pack(create, p, "Create Profile");
    }

    /** prov ides the functionality of the create option **/
    public void create (TravProfDB db, TravProf prof){
        // initialize the database, insert the new profile, write the profile to the database, and display confirmation
        db.initializeDatabase(file);
        db.insertNewProfile(prof);
        db.writeAllTravProf(file);
        JOptionPane.showMessageDialog(null, "Profile Successfully Created!");
    }

    /** provides the visual aspect of the update option **/
    public void updatePrompt (TravProfDB db) {
        JFrame update = new JFrame();
        GridBagConstraints c = new GridBagConstraints();
        JTextField ID, last;
        JComboBox selection;

        // create components
        JPanel p = new JPanel();
        JButton button = new JButton();

        // configure panel
        p.setLayout(new GridBagLayout());
        p.setBackground(Color.BLACK);
        p.setSize(600, 30);

        // configure labels
        setGridVariablesLabel(c, 0, 0, "Update a Traveler Profile", p);
        setGridVariablesLabel(c, 0, 1, "Travel ID: ", p);
        setGridVariablesLabel(c, 0, 2, "Last Name: ", p);
        setGridVariablesLabel(c, 0, 3, "Attribute to Update: ", p);

        // configure text boxes
        ID = setGridVariablesField(c, 1, 1, "Enter Travel ID", p);
        last = setGridVariablesField(c, 1, 2, "Enter Last Name", p);

        // configure combo box
        selection = setGridVariablesCombo(c, 1, 3, options, p);

        // configure button
        button = setGridVariableButton(c, 0, 4, "Find", button, p);

        // listener
        button.addActionListener(e -> update(db, ID.getText(), last.getText(), selection.getSelectedItem().toString()));

        // display & fill the window
        pack(update, p, "Update Profile");
    }

    /** provides the visual & functionality for update **/
    public void update (TravProfDB db, String ID, String last, String selection) {
        db.initializeDatabase(file);
        // check if the profile exists--if not, communicate that, if so, update the information accordingly
        if (db.findProfile(ID, last) == null) {
            JOptionPane.showMessageDialog(null, "Profile Does Not Exist!");
        } else {
            JFrame update = new JFrame();
            GridBagConstraints c = new GridBagConstraints();

            // create components
            JPanel p = new JPanel();
            JButton button = new JButton();
            JTextField valueF;
            JComboBox valueC;

            // configure panel
            p.setLayout(new GridBagLayout());
            p.setBackground(Color.BLACK);
            p.setSize(600, 30);

            // configure labels
            setGridVariablesLabel(c, 0, 0, "Update a Traveler Profile", p);
            setGridVariablesLabel(c, 0, 1, "Travel ID: ", p);
            setGridVariablesLabel(c, 0, 2, "Last Name: ", p);
            setGridVariablesLabel(c, 1, 1, ID, p);
            setGridVariablesLabel(c, 1, 2, last, p);

            // check the input & generate the proper corresponding attribute input text/combo box
            switch (selection) {
                case "First Name" -> {
                    setGridVariablesLabel(c, 0, 3, "First Name: ", p);
                    valueF = setGridVariablesField(c, 1, 3, "Enter First Name", p);
                    valueC = null;
                }
                case "Last Name" -> {
                    setGridVariablesLabel(c, 0, 3, "Last Name: ", p);
                    valueF = setGridVariablesField(c, 1, 3, "Enter Last Name", p);
                    valueC = null;
                }
                case "Address" -> {
                    setGridVariablesLabel(c, 0, 3, "Address: ", p);
                    valueF = setGridVariablesField(c, 1, 3, "Enter Address", p);
                    valueC = null;
                }
                case "Phone Number" -> {
                    setGridVariablesLabel(c, 0, 3, "Phone Number: ", p);
                    valueF = setGridVariablesField(c, 1, 3, "Enter Phone Number", p);
                    valueC = null;
                }
                case "Trip Cost" -> {
                    setGridVariablesLabel(c, 0, 3, "Trip Cost: ", p);
                    valueF = setGridVariablesField(c, 1, 3, "Enter Trip Cost", p);
                    valueC = null;
                }
                case "Travel Type" -> {
                    setGridVariablesLabel(c, 0, 3, "Travel Type: ", p);
                    valueC = setGridVariablesCombo(c, 1, 3, travelOptions, p);
                    valueF = null;
                }
                case "Payment Type" -> {
                    setGridVariablesLabel(c, 0, 3, "Payment Type: ", p);
                    valueC = setGridVariablesCombo(c, 1, 3, payOptions, p);
                    valueF = null;
                }
                case "Doctor Name" -> {
                    setGridVariablesLabel(c, 0, 3, "Doctor Name: ", p);
                    valueF = setGridVariablesField(c, 1, 3, "Enter Doctor Name", p);
                    valueC = null;
                }
                case "Doctor Phone" -> {
                    setGridVariablesLabel(c, 0, 3, "Doctor Phone: ", p);
                    valueF = setGridVariablesField(c, 1, 3, "Enter Doctor Phone", p);
                    valueC = null;
                }
                case "Allergy Type" -> {
                    setGridVariablesLabel(c, 0, 3, "Allergy Type: ", p);
                    valueC = setGridVariablesCombo(c, 1, 3, allOptions, p);
                    valueF = null;
                }
                default -> {
                    setGridVariablesLabel(c, 0, 3, "Illness Type: ", p);
                    valueC = setGridVariablesCombo(c, 1, 3, illOptions, p);
                    valueF = null;
                }
            }

            // configure button
            button = setGridVariableButton(c, 0, 4, "Submit", button, p);

            //listener
            button.addActionListener(e -> {
                // create the travel profiles & MedCond objects
                TravProf prof = db.findProfile(ID, last);
                MedCond mc = new MedCond(prof.getMedCondInfo().getMdContact(), prof.getMedCondInfo().getMdPhone(), prof.getMedCondInfo().getAlgType(), prof.getMedCondInfo().getIllType());

                // update the selected attribute
                switch (selection) {
                    case "First Name" -> prof.updateFirstName(valueF.getText());
                    case "Last Name" -> prof.updateLastName(valueF.getText());
                    case "Address" -> prof.updateAddress(valueF.getText());
                    case "Phone Number" -> prof.updatePhone(valueF.getText());
                    case "Trip Cost" -> prof.updateTripCost(Float.parseFloat(valueF.getText()));
                    case "Travel Type" -> prof.updateTravelType(valueC.getSelectedItem().toString());
                    case "Payment Type" -> prof.updatePaymentType(valueC.getSelectedItem().toString());
                    case "Doctor Name" -> {
                        mc.updateMdContact(valueF.getText());
                        prof.updateMedCondInfo(mc);
                    }
                    case "Doctor Phone Number" -> {
                        mc.updateMdPhone(valueF.getText());
                        prof.updateMedCondInfo(mc);
                    }
                    case "Allergy Type" -> {
                        mc.updateAlgType(valueC.getSelectedItem().toString());
                        prof.updateMedCondInfo(mc);
                    }
                    default -> {
                        mc.updateIllType(valueC.getSelectedItem().toString());
                        prof.updateMedCondInfo(mc);
                    }
                }

                // write changes to the database & show confirmation
                db.writeAllTravProf(file);
                JOptionPane.showMessageDialog(null, "Profile Successfully Updated!");
            });

            // display & fill the window
            pack(update, p, "Update Profile");
        }
    }

    /** provides part of the visual and functionality for display all **/
    public void displayFirst (TravProfDB db) {
        JFrame prompt = new JFrame();
        JPanel p = new JPanel();
        GridBagConstraints c = new GridBagConstraints();
        JTextField ID;
        JButton button = new JButton();

        // configure panel
        p.setLayout(new GridBagLayout());
        p.setBackground(Color.BLACK);
        p.setSize(600, 30);

        // configure labels
        setGridVariablesLabel(c, 0, 0, "Find All Profiles", p);
        setGridVariablesLabel(c, 0, 1, "Travel ID: ", p);

        // configure text fields
        ID = setGridVariablesField(c, 1, 1, "Enter Travel ID", p);

        // configure button
        button = setGridVariableButton(c, 0, 2, "Submit", button, p);

        // put a listener on the button
        button.addActionListener(e -> {
            // find initial profile, regardless of associated travel agent & declare necessary objects/variables(?)
            TravProf prof = db.findFirstProfile();
            ArrayList<Object> info;
            JButton next = new JButton();
            JFrame f = new JFrame();
            JPanel p1 = new JPanel();

            if (prof != null && prof.getTravAgentID().equals(ID.getText())) {
                // display the first profile IF it matches
                info = display(prof, f, p1);
                next = setGridVariableButton(c, 1, 13, "Next", next, (JPanel) info.get(1));
                pack((JFrame) info.get(0), (JPanel) info.get(1), (String) info.get(2));

                // put a listener here
                next.addActionListener(e2 -> {
                    findRest(db, c, ID.getText(), f, p1);
                });
            } else {
                // otherwise, check the rest
                findRest(db, c, ID.getText(), f, p1);
            }
        });
        // configure window
        pack(prompt, p, "Display All Profiles");
    }

    public void findRest(TravProfDB db, GridBagConstraints c, String ID, JFrame f, JPanel p) {
        TravProf prof = db.findNextProfile();

        // checks if the current profile exists & has matching travel agent ID
        if (prof != null && prof.getTravAgentID().equals(ID)) {
            ArrayList<Object> info = display(prof, f, p);
            JButton next = new JButton();
            next = setGridVariableButton(c, 1, 13, "Next", next, p);
            pack(f, p, (String) info.get(2));

            // put a listener on the button
            next.addActionListener(e -> {
                findRest(db, c, ID, f, p);
            });
        } else if (prof == null) {
            JOptionPane.showMessageDialog(null, "No More Profiles to Display");
        } else {
            findRest(db, c, ID, f, p);
        }
    }

    /** provides the visual & functionality for the main menu **/
    public void mainMenu (TravProfDB db) {
        JFrame main = new JFrame();

        // create components
        JPanel p1, p2, p3;
        JLabel l1;
        ButtonGroup options = new ButtonGroup();
        JRadioButton create, delete, update, find, display;
        JButton select;

        // initialize panels
        p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.setBackground(Color.BLACK);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 8, 5, 0));
        p2.setBackground(Color.BLACK);

        p3 = new JPanel();
        p3.setLayout(new BorderLayout());
        p3.setBackground(Color.BLACK);

        // initialize buttons
        select = new JButton("Select");
        select.setBackground(Color.BLACK);
        select.setForeground(Color.WHITE);

        create = new JRadioButton("Create Profile");
        create.setBackground(Color.ORANGE);
        create.setForeground(Color.WHITE);

        delete = new JRadioButton("Delete Profile");
        delete.setBackground(Color.PINK);
        delete.setForeground(Color.WHITE);

        update = new JRadioButton("Update Profile");
        update.setBackground(Color.MAGENTA);
        update.setForeground(Color.WHITE);

        find = new JRadioButton("Find Profile");
        find.setBackground(Color.CYAN);
        find.setForeground(Color.WHITE);

        display = new JRadioButton("Display Profiles");
        display.setBackground(Color.BLUE);
        display.setForeground(Color.WHITE);

        // add RJRadioButtons to group
        options.add(create);
        options.add(delete);
        options.add(update);
        options.add(find);
        options.add(display);

        // initialize label(s)
        l1 = new JLabel("Welcome to the Integrated Travel System", SwingConstants.CENTER);
        l1.setPreferredSize(new Dimension(100, 30));
        l1.setForeground(Color.WHITE);

        // add all components to respective panels
        p1.add(l1, BorderLayout.CENTER);
        p2.add(create);
        p2.add(delete);
        p2.add(update);
        p2.add(find);
        p2.add(display);
        p3.add(select, BorderLayout.SOUTH);

        // listener
        select.addActionListener(e -> {
            if (create.isSelected()){
                createPrompt(db);
            } else if (delete.isSelected()){
                findProfile(db, "Delete a Traveler Profile", "Delete Profile");
            } else if (update.isSelected()){
                updatePrompt(db);
            } else if (find.isSelected()){
                findProfile(db, "Find a Traveler Profile", "Find Profile");
            } else if (display.isSelected()){
                displayFirst(db);
            } else {
                JOptionPane.showMessageDialog(main, "Please select an option.");
            }
        });

        // add all components to the frame
        main.add(p1, BorderLayout.NORTH);
        main.add(p2, BorderLayout.CENTER);
        main.add(p3, BorderLayout.SOUTH);

        // display the window
        main.pack();
        main.setSize(600, 200);
        main.setBackground(Color.BLACK);
        main.setTitle("Integrated Travel System");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setVisible(true);
    }

    /** start the gui **/
    public void useGUI () {
        // initialize the database & open the main menu
        db.initializeDatabase(file);
        mainMenu(db);
    }

    /** test/run the gui **/
    public static void main (String[] args) {
        // javax.swing.SwingUtilities.invokeLater(SwingGUI::useGUI);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SwingGUI gui = new SwingGUI();
                gui.useGUI();
            }
        });
    }
}