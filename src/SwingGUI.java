import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingGUI {
    /** variables **/
    TravProfDB db;
    String file = "out/Database.txt";

    /** fucking constructor!! **/
    public SwingGUI() {
        db = new TravProfDB(file);
    }

    /** start the gui **/
    public void useGUI(){
        // initialize the database & open the main menu
        db.initializeDatabase(file);

        mainMenu(db);
    }

    public void mainMenu(TravProfDB db){
        JFrame main = new JFrame();

        // create panels
        JPanel p1, p2, p3;
        JLabel l1;
        ButtonGroup options = new ButtonGroup();
        JRadioButton create, delete, update, find, display;
        JButton select;

        // initialize panes
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

        // initialize labels
        l1 = new JLabel("Welcome to the Integrated Travel System", SwingConstants.CENTER);
        l1.setPreferredSize(new Dimension(100, 30));
        l1.setForeground(Color.WHITE);

        // add all buttons to respective panels
        p2.add(create);
        p2.add(delete);
        p2.add(update);
        p2.add(find);
        p2.add(display);
        p3.add(select, BorderLayout.SOUTH);

        // add label
        p1.add(l1, BorderLayout.CENTER);

        select.addActionListener(e -> {
            if (create.isSelected()){
                create(db);
            } else if (delete.isSelected()){
                delete(db);
            } else if (update.isSelected()){
                update(db);
            } else if (find.isSelected()){
                find(db);
            } else if (display.isSelected()){
                display(db);
            } else {
                JOptionPane.showMessageDialog(main, "Please select an option.");
            }
        });

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

    public void create(TravProfDB db){
        JFrame create = new JFrame();

        // create components
        JPanel p;
        JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13;
        JTextField travID, first, last, address, phone, tcost, rewards, rID, rbal;
        JComboBox travType, payType, mode;
        JButton submit;

        // configure panel
        p = new JPanel();
        p.setLayout(new GridBagLayout());
        p.setBackground(Color.BLACK);

        // configure title
        l1 = new JLabel("Create a Traveler Profile", SwingConstants.CENTER);
        l1.setForeground(Color.WHITE);
        l1.setBackground(Color.BLACK);

        // lists of necessary options
        String[] travOptions = {"Business", "Pleasure"};
        String[] payOptions = {"Credit", "Check", "Debit", "Invoice"};
        String[] modeOptions = {"Car", "Train", "Plane"};

        // initialize variables for orientation of components
        GridBagConstraints con = new GridBagConstraints();
        con.fill = GridBagConstraints.HORIZONTAL;
        con.ipadx = 5;
        con.ipady = 5;

        // fill p1
        con.gridx = 0;
        con.gridy = 0;
        p.add(l1, con);
        p.setSize(600, 30);

        con.gridx = 0;
        con.gridy = 1;
        l2 = new JLabel("Travel ID:");
        l2.setForeground(Color.ORANGE);
        p.add(l2, con);

        con.gridx = 1;
        con.gridy = 1;
        travID = new JTextField("Enter Travel ID");
        travID.setBackground(Color.ORANGE);
        p.add(travID, con);

        con.gridx = 0;
        con.gridy = 2;
        l3 = new JLabel("First Name:");
        l3.setForeground(Color.PINK);
        p.add(l3, con);

        con.gridx = 1;
        con.gridy = 2;
        first = new JTextField("Enter First Name");
        first.setBackground(Color.PINK);
        p.add(first, con);

        con.gridx = 0;
        con.gridy = 3;
        l4 = new JLabel("Last Name:");
        l4.setForeground(Color.MAGENTA);
        p.add(l4, con);

        con.gridx = 1;
        con.gridy = 3;
        last = new JTextField("Enter Last Name");
        last.setBackground(Color.MAGENTA);
        p.add(last, con);

        con.gridx = 0;
        con.gridy = 4;
        l5 = new JLabel("Address:");
        l5.setForeground(Color.CYAN);
        p.add(l5, con);

        con.gridx = 1;
        con.gridy = 4;
        address = new JTextField("Enter Address");
        address.setBackground(Color.CYAN);
        p.add(address, con);

        con.gridx = 0;
        con.gridy = 5;
        l6 = new JLabel("Phone Number:");
        l6.setForeground(Color.BLUE);
        p.add(l6, con);

        con.gridx = 1;
        con.gridy = 5;
        phone = new JTextField("Enter Phone Number");
        phone.setBackground(Color.BLUE);
        p.add(phone, con);

        con.gridx = 0;
        con.gridy = 6;
        l7 = new JLabel("Trip Cost:");
        l7.setForeground(Color.ORANGE);
        p.add(l7, con);

        con.gridx = 1;
        con.gridy = 6;
        tcost = new JTextField("Enter Trip Cost");
        tcost.setBackground(Color.ORANGE);
        p.add(tcost, con);

        con.gridx = 0;
        con.gridy = 7;
        l8 = new JLabel("Travel Type:");
        l8.setForeground(Color.PINK);
        p.add(l8, con);

        con.gridx = 1;
        con.gridy = 7;
        travType = new JComboBox(travOptions);
        travType.setBackground(Color.PINK);
        p.add(travType, con);

        con.gridx = 0;
        con.gridy = 8;
        l9 = new JLabel("Payment Type:");
        l9.setForeground(Color.MAGENTA);
        p.add(l9, con);

        con.gridx = 1;
        con.gridy = 8;
        payType = new JComboBox(payOptions);
        payType.setBackground(Color.MAGENTA);
        p.add(payType, con);

        con.gridx = 0;
        con.gridy = 9;
        l10 = new JLabel("Mode of Travel:");
        l10.setForeground(Color.CYAN);
        p.add(l10, con);

        con.gridx = 1;
        con.gridy = 9;
        mode = new JComboBox(modeOptions);
        mode.setBackground(Color.CYAN);
        p.add(mode, con);

        con.gridx = 0;
        con.gridy = 10;
        l11 = new JLabel("Rewards Company:");
        l11.setForeground(Color.BLUE);
        p.add(l11, con);

        con.gridx = 1;
        con.gridy = 10;
        rewards = new JTextField("Enter Rewards Company");
        rewards.setBackground(Color.BLUE);
        p.add(rewards, con);

        con.gridx = 0;
        con.gridy = 11;
        l12 = new JLabel("Rewards ID:");
        l12.setForeground(Color.ORANGE);
        p.add(l12, con);

        con.gridx = 1;
        con.gridy = 11;
        rID = new JTextField("Enter Rewards ID");
        rID.setBackground(Color.ORANGE);
        p.add(rID, con);

        con.gridx = 0;
        con.gridy = 12;
        l13 = new JLabel("Rewards Balance:");
        l13.setForeground(Color.PINK);
        p.add(l13, con);

        con.gridx = 1;
        con.gridy = 12;
        rbal = new JTextField("Enter Rewards Balance");
        rbal.setBackground(Color.PINK);
        p.add(rbal, con);

        // configure button
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        con.gridwidth = 2;
        con.anchor = GridBagConstraints.PAGE_END;
        con.gridx = 0;
        con.gridy = 13;
        p.add(submit, con);

        // listener
        submit.addActionListener(e -> {
            rewards.getText();
            rID.getText();
            rbal.getText();
            mode.getSelectedItem();

            // my problem here is that we are not collecting the information that
            // we need--like..she wants us to prompt for rewards information?
            // but we didn't write the code for that when we created the TravProf
            // file for the first part of the project...so I just made a temp
            // MedCond object in order to test to see if I could properly
            // create accounts and such
            // also will probably create a constructor or SOMETHING for this class
            // at some point so that I don't have a bunch of different object
            // declarations (like I did in the last one..I just optimize better after
            // I get it to function first)

            MedCond mc = new MedCond("temp", "123", "1", "2");
            TravProf newProf = new TravProf(travID.getText(), first.getText(), last.getText(), address.getText(), phone.getText(), Float.parseFloat(tcost.getText()), (String) travType.getSelectedItem(), (String) payType.getSelectedItem(), mc);

            db.initializeDatabase(file);
            db.insertNewProfile(newProf);
            db.writeAllTravProf(file);

            JOptionPane.showMessageDialog(null, "Profile Successfully Created!");
        });

        // display & fill the window
        create.add(p);
        create.pack();
        create.setBackground(Color.BLACK);
        create.setTitle("Create Profile");
        create.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        create.setVisible(true);
    }

    public void delete(TravProfDB db){
        JFrame delete = new JFrame();

        // create components
        JPanel p;
        JLabel l1, l2, l3;
        JTextField travID, last;
        JButton submit;

        // configure panel
        p = new JPanel();
        p.setLayout(new GridBagLayout());
        p.setBackground(Color.BLACK);

        // configure title
        l1 = new JLabel("Delete a Traveler Profile", SwingConstants.CENTER);
        l1.setForeground(Color.WHITE);
        l1.setBackground(Color.BLACK);

        // initialize variables for orientation of components
        GridBagConstraints con = new GridBagConstraints();
        con.fill  = GridBagConstraints.HORIZONTAL;
        con.ipadx = 5;
        con.ipady = 5;

        // fill the panel
        con.gridx = 0;
        con.gridy = 0;
        p.add(l1, con);
        p.setSize(600, 30);

        con.gridx = 0;
        con.gridy = 1;
        l2 = new JLabel("Travel ID: ");
        l2.setForeground(Color.ORANGE);
        p.add(l2, con);

        con.gridx = 1;
        con.gridy = 1;
        travID = new JTextField("Enter Travel ID");
        travID.setBackground(Color.ORANGE);
        p.add(travID, con);

        con.gridx = 0;
        con.gridy = 2;
        l3 = new JLabel("Last Name:");
        l3.setForeground(Color.PINK);
        p.add(l3, con);

        con.gridx = 1;
        con.gridy = 2;
        last = new JTextField("Enter Last Name");
        last.setBackground(Color.PINK);
        p.add(last, con);

        // configure button
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        con.gridwidth = 2;
        con.anchor = GridBagConstraints.PAGE_END;
        con.gridx = 0;
        con.gridy = 3;
        p.add(submit, con);

        // listener
        submit.addActionListener(e -> {
            db.initializeDatabase("out/Database.txt");
            if(db.deleteProfile(travID.getText(), last.getText())){
                db.writeAllTravProf("out/Database.txt");
                JOptionPane.showMessageDialog(null, "Profile Successfully Deleted");
            }else{
                JOptionPane.showMessageDialog(null, "Profile Could Not Be Deleted");
            }
        });

        // display & fill the window
        delete.add(p);
        delete.pack();
        delete.setBackground(Color.BLACK);
        delete.setTitle("Delete Profile");
        delete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        delete.setVisible(true);
    }

    public void update(TravProfDB db){
        JFrame update = new JFrame();

        // create components
        JPanel p;
        JLabel l1, l2, l3, l4;
        JTextField travID, last;
        JComboBox attribute;
        JButton find;

        // configure panel
        p = new JPanel();
        p.setLayout(new GridBagLayout());
        p.setBackground(Color.BLACK);

        // configure title
        l1 = new JLabel("Update a Traveler Profile", SwingConstants.CENTER);
        l1.setForeground(Color.WHITE);
        l1.setBackground(Color.BLACK);

        // initialize variables for orientation of components
        GridBagConstraints con = new GridBagConstraints();
        con.fill = GridBagConstraints.HORIZONTAL;
        con.ipadx = 5;
        con.ipady = 5;

        // list of necessary options
        String[] options = {"First Name", "Last Name", "Address", "Phone Number", "Trip Cost", "Travel Type", "Payment Type", "Mode of Travel", "Rewards Company", "Rewards ID", "Rewards Balance"};

        // fill the panel
        con.gridx = 0;
        con.gridy = 0;
        p.add(l1, con);
        p.setSize(600, 30);

        con.gridx = 0;
        con.gridy = 1;
        l2 = new JLabel("Travel ID:");
        l2.setForeground(Color.ORANGE);
        p.add(l2, con);

        con.gridx = 1;
        con.gridy = 1;
        travID = new JTextField("Enter Travel ID");
        travID.setBackground(Color.ORANGE);
        p.add(travID, con);

        con.gridx = 0;
        con.gridy = 2;
        l3 = new JLabel("Last Name:");
        l3.setForeground(Color.PINK);
        p.add(l3, con);

        con.gridx = 1;
        con.gridy = 2;
        last = new JTextField("Enter Last Name");
        last.setBackground(Color.PINK);
        p.add(last, con);

        con.gridx = 0;
        con.gridy = 3;
        l4 = new JLabel("Attribute to Update:");
        l4.setForeground(Color.MAGENTA);
        p.add(l4, con);

        con.gridx = 1;
        con.gridy = 3;
        attribute = new JComboBox(options);
        // background test
        attribute.setBackground(Color.MAGENTA);
        p.add(attribute, con);

        // configure button
        find = new JButton("Find");
        find.setBackground(Color.BLACK);
        find.setForeground(Color.WHITE);
        con.gridwidth = 2;
        con.anchor = GridBagConstraints.PAGE_END;
        con.gridx = 0;
        con.gridy = 4;
        p.add(find, con);

        // listener
        find.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                db.initializeDatabase(file);
                if (db.findProfile(travID.getText(), last.getText()) == null) {
                    JOptionPane.showMessageDialog(null, "Profile Does Not Exist!");
                }else{
                    JFrame update2 = new JFrame();

                    // create components
                    JPanel p1;
                    JLabel l11, l21, l31, l41, l5;
                    JTextField newEntry;
                    JComboBox newEntryC;
                    JButton submit;
                    String updatedAttribute;

                    // configure panel
                    p1 = new JPanel();
                    p1.setLayout(new GridBagLayout());
                    p1.setBackground(Color.BLACK);

                    // configure title
                    l11 = new JLabel("Update a Traveler Profile");
                    l11.setForeground(Color.WHITE);
                    l11.setBackground(Color.BLACK);

                    // lists of necessary options
                    String[] travOptions = {"Business", "Pleasure"};
                    String[] payOptions = {"Credit", "Check", "Debit", "Invoice"};
                    String[] modeOptions = {"Car", "Train", "Plane"};

                    // initialize variables for orientation of components
                    GridBagConstraints con1 = new GridBagConstraints();
                    con1.fill = GridBagConstraints.HORIZONTAL;
                    con1.ipadx = 5;
                    con1.ipady = 5;

                    // fill the panel
                    con1.gridx = 0;
                    con1.gridy = 0;
                    p1.add(l11, con1);
                    p1.setSize(600, 30);

                    con1.gridx = 0;
                    con1.gridy = 1;
                    l21 = new JLabel("Travel ID:");
                    l21.setForeground(Color.ORANGE);
                    p1.add(l21, con1);

                    con1.gridx = 1;
                    con1.gridy = 1;
                    l31 = new JLabel(travID.getText());
                    l31.setForeground(Color.ORANGE);
                    p1.add(l31, con1);

                    con1.gridx = 0;
                    con1.gridy = 2;
                    l31 = new JLabel("Last Name:");
                    l31.setForeground(Color.PINK);
                    p1.add(l31, con1);

                    con1.gridx = 1;
                    con1.gridy = 2;
                    l41 = new JLabel(last.getText());
                    l41.setForeground(Color.PINK);
                    p1.add(l41, con1);

                    con1.gridx = 0;
                    con1.gridy = 3;

                    // check the input & generate the proper corresponding attribute input text/combo box
                    if(attribute.getSelectedItem().equals("First Name")){
                        l5 = new JLabel("First Name");
                        con1.gridx = 1;
                        con1.gridy = 3;
                        newEntry = new JTextField("Enter First Name");
                        newEntryC = null;
                        p1.add(newEntry, con1);
                        updatedAttribute = newEntry.getText();
                    }else if(attribute.getSelectedItem().equals("Last Name")){
                        l5 = new JLabel("Last Name");
                        con1.gridx = 1;
                        con1.gridy = 3;
                        newEntry = new JTextField("Enter Last Name");
                        newEntryC = null;
                        p1.add(newEntry, con1);
                        updatedAttribute = newEntry.getText();
                    }else if(attribute.getSelectedItem().equals("Address")){
                        l5 = new JLabel("Address");
                        con1.gridx = 1;
                        con1.gridy = 3;
                        newEntry = new JTextField("Enter Address");
                        newEntryC = null;
                        p1.add(newEntry, con1);
                        updatedAttribute = newEntry.getText();
                    }else if(attribute.getSelectedItem().equals("Phone Number")){
                        l5 = new JLabel("Phone Number");
                        con1.gridx = 1;
                        con1.gridy = 3;
                        newEntry = new JTextField("Enter Phone Number");
                        newEntryC = null;
                        p1.add(newEntry, con1);
                        updatedAttribute = newEntry.getText();
                    }else if(attribute.getSelectedItem().equals("Trip Cost")){
                        l5 = new JLabel("Trip Cost");
                        con1.gridx = 1;
                        con1.gridy = 3;
                        newEntry = new JTextField("Enter Trip Cost");
                        newEntryC = null;
                        p1.add(newEntry, con1);
                        updatedAttribute = newEntry.getText();
                    } else if (attribute.getSelectedItem().equals("Travel Type")) {
                        l5 = new JLabel("Travel Type");
                        con1.gridx = 1;
                        con1.gridy = 3;
                        newEntryC = new JComboBox(travOptions);
                        newEntry = null;
                        p1.add(newEntryC, con1);
                        updatedAttribute = newEntryC.getSelectedItem().toString();
                    }else if(attribute.getSelectedItem().equals("Payment Type")){
                        l5 = new JLabel("Payment Type");
                        con1.gridx = 1;
                        con1.gridy = 3;
                        newEntryC = new JComboBox(payOptions);
                        newEntry = null;
                        p1.add(newEntryC, con1);
                        updatedAttribute = newEntryC.getSelectedItem().toString();
                    }else if(attribute.getSelectedItem().equals("Mode of Travel")){
                        l5 = new JLabel("Mode of Travel");
                        con1.gridx = 1;
                        con1.gridy = 3;
                        newEntryC = new JComboBox(modeOptions);
                        newEntry = null;
                        p1.add(newEntryC, con1);
                        updatedAttribute = newEntryC.getSelectedItem().toString();
                    }else if(attribute.getSelectedItem().equals("Rewards Company")){
                        l5 = new JLabel("Rewards Company");
                        con1.gridx = 1;
                        con1.gridy = 3;
                        newEntry = new JTextField("Enter Rewards Company");
                        newEntryC = null;
                        p1.add(newEntry, con1);
                        updatedAttribute = newEntry.getText();
                    }else if(attribute.getSelectedItem().equals("Rewards ID")){
                        l5 = new JLabel("Rewards ID");
                        con1.gridx = 1;
                        con1.gridy = 3;
                        newEntry = new JTextField("Enter Rewards ID");
                        newEntryC = null;
                        p1.add(newEntry, con1);
                        updatedAttribute = newEntry.getText();
                    }else{
                        l5 = new JLabel("Rewards Balance");
                        con1.gridx = 1;
                        con1.gridy = 3;
                        newEntry = new JTextField("Enter Rewards Balance");
                        newEntryC = null;
                        p1.add(newEntry, con1);
                        updatedAttribute = newEntry.getText();
                    }
                    l5.setForeground(Color.MAGENTA);
                    p1.add(l5, con1);

                    // configure button
                    submit = new JButton("Submit");
                    submit.setBackground(Color.BLACK);
                    submit.setForeground(Color.WHITE);
                    con1.gridwidth = 2;
                    con1.anchor = GridBagConstraints.PAGE_END;
                    con1.gridx = 0;
                    con1.gridy = 4;
                    p1.add(submit, con1);

                    //listener
                    submit.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            TravProf prof = db.findProfile(travID.getText(), last.getText());

                            if(l5.getText().equals("First Name")){
                                prof.updateFirstName(newEntry.getText());
                            }else if(l5.getText().equals("Last Name")){
                                prof.updateLastName(newEntry.getText());
                            }else if(l5.getText().equals("Address")){
                                prof.updateAddress(newEntry.getText());
                            }else if(l5.getText().equals("Phone Number")){
                                prof.updatePhone(newEntry.getText());
                            }else if(l5.getText().equals("Trip Cost")){
                                prof.updateTripCost(Float.parseFloat(newEntry.getText()));
                            }else if(l5.getText().equals("Travel Type")){
                                prof.updateTravelType(newEntryC.getSelectedItem().toString());
                            }else if(l5.getText().equals("Payment Type")){
                                prof.updatePaymentType(newEntryC.getSelectedItem().toString());
                            }else if(l5.getText().equals("Mode of Travel")){
                                // idk what to do with this yet bc we don't have functionality written for this
                            }else if(l5.getText().equals("Rewards Company")){
                                // idk what to do with this yet bc we don't have functionality written for this
                            }else if(l5.getText().equals("Rewards ID")){
                                // idk what to do with this yet bc we don't have functionality written for this
                            }else{
                                // idk what to do with this yet bc we don't have functionality written for this
                            }

                            db.writeAllTravProf(file);
                            JOptionPane.showMessageDialog(null, "Profile Successfully Updated!");
                        }
                    });
                    // display & fill the window
                    update2.add(p1);
                    update2.pack();
                    update2.setBackground(Color.BLACK);
                    update2.setTitle("Update Profile");
                    update2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    update2.setVisible(true);
                }
            }
        });

        // display & fill the window
        update.add(p);
        update.pack();
        update.setBackground(Color.BLACK);
        update.setTitle("Update Profile");
        update.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        update.setVisible(true);
    }

    public void find(TravProfDB db){
        JOptionPane.showMessageDialog(null,"find!");
    }

    public void display(TravProfDB db){
        JOptionPane.showMessageDialog(null,"display!");
    }

    public static void main(String[] args){
        // javax.swing.SwingUtilities.invokeLater(SwingGUI::useGUI);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SwingGUI gui = new SwingGUI();
                gui.useGUI();
            }
        });
    }
}
