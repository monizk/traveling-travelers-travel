import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingGUI {
    /** variables **/
    TravProfDB db;
    String file = "out/Database.txt";
    String[] travOptions = {"Business", "Pleasure"};
    String[] payOptions = {"Credit", "Check", "Debit", "Invoice"};
    String[] allOptions = {"None", "Food", "Medication", "Other"};
    String[] illOptions = {"None", "Heart", "Diabetes", "Asthma", "Other"};
    String[] options = {"First Name", "Last Name", "Address", "Phone Number", "Trip Cost", "Travel Type", "Payment Type", "Doctor Name", "Doctor Phone", "Allergy Type", "Illness Type"};

    /** constructor **/
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

        // create components
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

    public void create(TravProfDB db) {
        JFrame create = new JFrame();

        // create components
        JPanel p;
        JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13;
        JTextField travID, first, last, address, phone, tcost, docName, docPhone;
        JComboBox travType, payType, allType, illType;
        JButton submit;

        // configure panel
        p = new JPanel();
        p.setLayout(new GridBagLayout());
        p.setBackground(Color.BLACK);

        // configure title
        l1 = new JLabel("Create a Traveler Profile", SwingConstants.CENTER);
        l1.setForeground(Color.WHITE);
        l1.setBackground(Color.BLACK);

        // initialize variables for orientation of components
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 5;
        c.ipady = 5;

        // fill p1
        c.gridx = 0;
        c.gridy = 0;
        p.add(l1,c);
        p.setSize(600, 30);

        c.gridx = 0;
        c.gridy = 1;
        l2 = new JLabel("Travel ID:");
        l2.setForeground(Color.ORANGE);
        p.add(l2,c);

        c.gridx = 1;
        c.gridy = 1;
        travID = new JTextField("Enter Travel ID");
        travID.setBackground(Color.ORANGE);
        p.add(travID,c);

        c.gridx = 0;
        c.gridy = 2;
        l3 = new JLabel("First Name:");
        l3.setForeground(Color.PINK);
        p.add(l3,c);

        c.gridx = 1;
        c.gridy = 2;
        first = new JTextField("Enter First Name");
        first.setBackground(Color.PINK);
        p.add(first,c);

        c.gridx = 0;
        c.gridy = 3;
        l4 = new JLabel("Last Name:");
        l4.setForeground(Color.MAGENTA);
        p.add(l4,c);

        c.gridx = 1;
        c.gridy = 3;
        last = new JTextField("Enter Last Name");
        last.setBackground(Color.MAGENTA);
        p.add(last,c);

        c.gridx = 0;
        c.gridy = 4;
        l5 = new JLabel("Address:");
        l5.setForeground(Color.CYAN);
        p.add(l5,c);

        c.gridx = 1;
        c.gridy = 4;
        address = new JTextField("Enter Address");
        address.setBackground(Color.CYAN);
        p.add(address,c);

        c.gridx = 0;
        c.gridy = 5;
        l6 = new JLabel("Phone Number:");
        l6.setForeground(Color.BLUE);
        p.add(l6,c);

        c.gridx = 1;
        c.gridy = 5;
        phone = new JTextField("Enter Phone Number");
        phone.setBackground(Color.BLUE);
        p.add(phone,c);

        c.gridx = 0;
        c.gridy = 6;
        l7 = new JLabel("Trip Cost:");
        l7.setForeground(Color.ORANGE);
        p.add(l7,c);

        c.gridx = 1;
        c.gridy = 6;
        tcost = new JTextField("Enter Trip Cost");
        tcost.setBackground(Color.ORANGE);
        p.add(tcost,c);

        c.gridx = 0;
        c.gridy = 7;
        l8 = new JLabel("Travel Type:");
        l8.setForeground(Color.PINK);
        p.add(l8,c);

        c.gridx = 1;
        c.gridy = 7;
        travType = new JComboBox(travOptions);
        travType.setBackground(Color.PINK);
        p.add(travType,c);

        c.gridx = 0;
        c.gridy = 8;
        l9 = new JLabel("Payment Type:");
        l9.setForeground(Color.MAGENTA);
        p.add(l9,c);

        c.gridx = 1;
        c.gridy = 8;
        payType = new JComboBox(payOptions);
        payType.setBackground(Color.MAGENTA);
        p.add(payType,c);

        c.gridx = 0;
        c.gridy = 9;
        l10 = new JLabel("Doctor Name:");
        l10.setForeground(Color.CYAN);
        p.add(l10,c);

        c.gridx = 1;
        c.gridy = 9;
        docName = new JTextField("Enter Doctor Name");
        docName.setBackground(Color.CYAN);
        p.add(docName,c);

        c.gridx = 0;
        c.gridy = 10;
        l11 = new JLabel("Doctor Phone Number:");
        l11.setForeground(Color.BLUE);
        p.add(l11,c);

        c.gridx = 1;
        c.gridy = 10;
        docPhone = new JTextField("Enter Doctor Phone Number");
        docPhone.setBackground(Color.BLUE);
        p.add(docPhone,c);

        c.gridx = 0;
        c.gridy = 11;
        l12 = new JLabel("Allergy Type:");
        l12.setForeground(Color.ORANGE);
        p.add(l12,c);

        c.gridx = 1;
        c.gridy = 11;
        allType = new JComboBox(allOptions);
        allType.setBackground(Color.ORANGE);
        p.add(allType,c);

        c.gridx = 0;
        c.gridy = 12;
        l13 = new JLabel("Illness Type:");
        l13.setForeground(Color.PINK);
        p.add(l13,c);

        c.gridx = 1;
        c.gridy = 12;
        illType = new JComboBox(illOptions);
        illType.setBackground(Color.PINK);
        p.add(illType,c);

        // configure button
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.PAGE_END;
        c.gridx = 0;
        c.gridy = 13;
        p.add(submit,c);

        // listener
        submit.addActionListener(e -> {
            // create TravProf & MedCond objects
            MedCond mc = new MedCond(docName.getText(), docPhone.getText(), allType.getSelectedItem().toString(), illType.getSelectedItem().toString());
            TravProf newProf = new TravProf(travID.getText(), first.getText(), last.getText(), address.getText(), phone.getText(), Float.parseFloat(tcost.getText()), (String) travType.getSelectedItem(), (String) payType.getSelectedItem(), mc);

            // initialize the database, insert the new profile, write the profile to the database, and display confirmation
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

        //configure panel
        p = new JPanel();
        p.setLayout(new GridBagLayout());
        p.setBackground(Color.BLACK);

        // configure title
        l1 = new JLabel("Delete a Traveler Profile", SwingConstants.CENTER);
        l1.setForeground(Color.WHITE);
        l1.setBackground(Color.BLACK);

        // initialize variables for layout of components
        GridBagConstraints c = new GridBagConstraints();
        c.fill  = GridBagConstraints.HORIZONTAL;
        c.ipadx = 5;
        c.ipady = 5;

        // fill the panel
        c.gridx = 0;
        c.gridy = 0;
        p.add(l1,c);
        p.setSize(600, 30);

        c.gridx = 0;
        c.gridy = 1;
        l2 = new JLabel("Travel ID: ");
        l2.setForeground(Color.ORANGE);
        p.add(l2,c);

         c.gridx = 1;
         c.gridy = 1;
        travID = new JTextField("Enter Travel ID");
        travID.setBackground(Color.ORANGE);
        p.add(travID,c);

         c.gridx = 0;
         c.gridy = 2;
        l3 = new JLabel("Last Name:");
        l3.setForeground(Color.PINK);
        p.add(l3,c);

         c.gridx = 1;
         c.gridy = 2;
        last = new JTextField("Enter Last Name");
        last.setBackground(Color.PINK);
        p.add(last,c);

        // configure button
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.PAGE_END;
        c.gridx = 0;
        c.gridy = 3;
        p.add(submit,c);

        // listener
        submit.addActionListener(e -> {
            // initialize the database
            db.initializeDatabase("out/Database.txt");
            // delete the profile & send a confirmation--otherwise, communicate the problem
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
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 5;
        c.ipady = 5;

        // fill the panel
        c.gridx = 0;
        c.gridy = 0;
        p.add(l1,c);
        p.setSize(600, 30);

        c.gridx = 0;
        c.gridy = 1;
        l2 = new JLabel("Travel ID:");
        l2.setForeground(Color.ORANGE);
        p.add(l2,c);

        c.gridx = 1;
        c.gridy = 1;
        travID = new JTextField("Enter Travel ID");
        travID.setBackground(Color.ORANGE);
        p.add(travID,c);

        c.gridx = 0;
        c.gridy = 2;
        l3 = new JLabel("Last Name:");
        l3.setForeground(Color.PINK);
        p.add(l3,c);

        c.gridx = 1;
        c.gridy = 2;
        last = new JTextField("Enter Last Name");
        last.setBackground(Color.PINK);
        p.add(last,c);

        c.gridx = 0;
        c.gridy = 3;
        l4 = new JLabel("Attribute to Update:");
        l4.setForeground(Color.MAGENTA);
        p.add(l4,c);

        c.gridx = 1;
        c.gridy = 3;
        attribute = new JComboBox(options);
        attribute.setBackground(Color.MAGENTA);
        p.add(attribute,c);

        // configure button
        find = new JButton("Find");
        find.setBackground(Color.BLACK);
        find.setForeground(Color.WHITE);
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.PAGE_END;
        c.gridx = 0;
        c.gridy = 4;
        p.add(find,c);

        // listener
        find.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                // initialize database
                db.initializeDatabase(file);
                // check if the profile exists--if not, communicate that, if so, update the information accordingly
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

                    // configure panel
                    p1 = new JPanel();
                    p1.setLayout(new GridBagLayout());
                    p1.setBackground(Color.BLACK);

                    // configure title
                    l11 = new JLabel("Update a Traveler Profile");
                    l11.setForeground(Color.WHITE);
                    l11.setBackground(Color.BLACK);

                    // initialize variables for orientation of components
                    GridBagConstraints c = new GridBagConstraints();
                    c.fill = GridBagConstraints.HORIZONTAL;
                    c.ipadx = 5;
                    c.ipady = 5;

                    // fill the panel
                    c.gridx = 0;
                    c.gridy = 0;
                    p1.add(l11,c);
                    p1.setSize(600, 30);

                    c.gridx = 0;
                    c.gridy = 1;
                    l21 = new JLabel("Travel ID:");
                    l21.setForeground(Color.ORANGE);
                    p1.add(l21,c);

                    c.gridx = 1;
                    c.gridy = 1;
                    l31 = new JLabel(travID.getText());
                    l31.setForeground(Color.ORANGE);
                    p1.add(l31,c);

                    c.gridx = 0;
                    c.gridy = 2;
                    l31 = new JLabel("Last Name:");
                    l31.setForeground(Color.PINK);
                    p1.add(l31,c);

                    c.gridx = 1;
                    c.gridy = 2;
                    l41 = new JLabel(last.getText());
                    l41.setForeground(Color.PINK);
                    p1.add(l41,c);

                    c.gridx = 0;
                    c.gridy = 3;

                    // check the input & generate the proper corresponding attribute input text/combo box
                    if(attribute.getSelectedItem().equals("First Name")){
                        l5 = new JLabel("First Name");
                        c.gridx = 1;
                        c.gridy = 3;
                        newEntry = new JTextField("Enter First Name");
                        newEntryC = null;
                        p1.add(newEntry,c);
                    }else if(attribute.getSelectedItem().equals("Last Name")){
                        l5 = new JLabel("Last Name");
                        c.gridx = 1;
                        c.gridy = 3;
                        newEntry = new JTextField("Enter Last Name");
                        newEntryC = null;
                        p1.add(newEntry,c);
                    }else if(attribute.getSelectedItem().equals("Address")){
                        l5 = new JLabel("Address");
                        c.gridx = 1;
                        c.gridy = 3;
                        newEntry = new JTextField("Enter Address");
                        newEntryC = null;
                        p1.add(newEntry,c);
                    }else if(attribute.getSelectedItem().equals("Phone Number")){
                        l5 = new JLabel("Phone Number");
                        c.gridx = 1;
                        c.gridy = 3;
                        newEntry = new JTextField("Enter Phone Number");
                        newEntryC = null;
                        p1.add(newEntry,c);
                    }else if(attribute.getSelectedItem().equals("Trip Cost")){
                        l5 = new JLabel("Trip Cost");
                       c.gridx = 1;
                       c.gridy = 3;
                        newEntry = new JTextField("Enter Trip Cost");
                        newEntryC = null;
                        p1.add(newEntry,c);
                    } else if (attribute.getSelectedItem().equals("Travel Type")) {
                        l5 = new JLabel("Travel Type");
                        c.gridx = 1;
                        c.gridy = 3;
                        newEntryC = new JComboBox(travOptions);
                        newEntry = null;
                        p1.add(newEntryC,c);
                    }else if(attribute.getSelectedItem().equals("Payment Type")){
                        l5 = new JLabel("Payment Type");
                        c.gridx = 1;
                        c.gridy = 3;
                        newEntryC = new JComboBox(payOptions);
                        newEntry = null;
                        p1.add(newEntryC,c);
                    }else if(attribute.getSelectedItem().equals("Doctor Name")){
                        l5 = new JLabel("Doctor Name");
                        c.gridx = 1;
                        c.gridy = 3;
                        newEntry = new JTextField("Enter Doctor Name");
                        newEntryC = null;
                        p1.add(newEntry,c);
                    }else if(attribute.getSelectedItem().equals("Doctor Phone")){
                        l5 = new JLabel("Doctor Phone");
                        c.gridx = 1;
                        c.gridy = 3;
                        newEntry = new JTextField("Enter Doctor Phone");
                        newEntryC = null;
                        p1.add(newEntry,c);
                    }else if(attribute.getSelectedItem().equals("Allergy Type")){
                        l5 = new JLabel("Allergy Type");
                        c.gridx = 1;
                        c.gridy = 3;
                        newEntryC = new JComboBox(allOptions);
                        newEntry = null;
                        p1.add(newEntryC,c);
                    }else{
                        l5 = new JLabel("Illness Type");
                        c.gridx = 1;
                        c.gridy = 3;
                        newEntryC = new JComboBox(illOptions);
                        newEntry = null;
                        p1.add(newEntryC,c);
                    }
                    l5.setForeground(Color.MAGENTA);
                    p1.add(l5,c);

                    // configure button
                    submit = new JButton("Submit");
                    submit.setBackground(Color.BLACK);
                    submit.setForeground(Color.WHITE);
                    c.gridwidth = 2;
                    c.anchor = GridBagConstraints.PAGE_END;
                    c.gridx = 0;
                    c.gridy = 4;
                    p1.add(submit,c);

                    //listener
                    submit.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            // create the TravProf & MedCond objects
                            TravProf prof = db.findProfile(travID.getText(), last.getText());
                            MedCond mc = new MedCond(prof.getMedCondInfo().getMdContact(), prof.getMedCondInfo().getMdPhone(), prof.getMedCondInfo().getAlgType(), prof.getMedCondInfo().getIllType());

                            // update the selected attribute
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
                            }else if(l5.getText().equals("Doctor Name")){
                                mc.updateMdContact(newEntry.getText());
                            }else if(l5.getText().equals("Doctor Phone Number")){
                                mc.updateMdPhone(newEntry.getText());
                            }else if(l5.getText().equals("Allergy Type")){
                                mc.updateAlgType(newEntryC.getSelectedItem().toString());
                            }else{
                                mc.updateAlgType(newEntryC.getSelectedItem().toString());
                            }
                            // write changes to the database & show confirmation
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
        JFrame find = new JFrame();

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
        l1 = new JLabel("Find a Traveler Profile", SwingConstants.CENTER);
        l1.setForeground(Color.WHITE);
        l1.setBackground(Color.BLACK);

        // initialize variables for orientation of components
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 5;
        c.ipady = 5;

        // fill p1
        c.gridx = 0;
        c.gridy = 0;
        p.add(l1,c);
        p.setSize(600, 30);

        c.gridx = 0;
        c.gridy = 1;
        l2 = new JLabel("Travel ID:");
        l2.setForeground(Color.ORANGE);
        p.add(l2,c);

        c.gridx = 1;
        c.gridy = 1;
        travID = new JTextField("Enter Travel ID");
        travID.setBackground(Color.ORANGE);
        p.add(travID,c);

        c.gridx = 0;
        c.gridy = 2;
        l3 = new JLabel("Last Name:");
        l3.setForeground(Color.PINK);
        p.add(l3,c);

        c.gridx = 1;
        c.gridy = 2;
        last = new JTextField("Enter Last Name");
        last.setBackground(Color.PINK);
        p.add(last,c);

        // configure button
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.PAGE_END;
        c.gridx = 0;
        c.gridy = 3;
        p.add(submit,c);

        // listener
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // check if the profile exists, if not, communicate that, if so, display the information
                if(db.findProfile(travID.getText(), last.getText()) == null){
                    JOptionPane.showMessageDialog(null,"This Profile Does Not Exist");
                }else{
                    JFrame info = new JFrame();

                    // create components
                    JPanel p;
                    JLabel title, fname, xfname, lname, xlname, address, xaddress, phone, xphone, tcost, xtcost, travType, xtravType, payType, xpayType, docName, xdocName, docPhone, xdocPhone, allergies, xallergies, ill, xill;
                    TravProf prof = db.findProfile(travID.getText(), last.getText());

                    // configure panel
                    p = new JPanel();
                    p.setLayout(new GridBagLayout());
                    p.setBackground(Color.BLACK);

                    // configure title
                    title = new JLabel("Profile Information");
                    title.setForeground(Color.WHITE);
                    title.setBackground(Color.BLACK);

                    // initialize variables for orientation of components
                    GridBagConstraints c = new GridBagConstraints();
                    c.fill = GridBagConstraints.HORIZONTAL;
                    c.ipadx = 5;
                    c.ipady = 5;

                    // fill p
                    c.gridx = 0;
                    c.gridy = 0;
                    p.add(title,c);
                    p.setSize(600, 30);

                    c.gridx = 0;
                    c.gridy = 1;
                    fname = new JLabel("First Name:");
                    fname.setForeground(Color.ORANGE);
                    p.add(fname,c);

                    c.gridx = 1;
                    c.gridy = 1;
                    xfname = new JLabel(prof.getFirstName());
                    xfname.setForeground(Color.ORANGE);
                    p.add(xfname,c);

                    c.gridx = 0;
                    c.gridy = 2;
                    lname = new JLabel("Last Name:");
                    lname.setForeground(Color.PINK);
                    p.add(lname,c);

                    c.gridx = 1;
                    c.gridy = 2;
                    xlname = new JLabel(prof.getLastName());
                    xlname.setForeground(Color.PINK);
                    p.add(xlname,c);

                    c.gridx = 0;
                    c.gridy = 3;
                    address = new JLabel("Address:");
                    address.setForeground(Color.MAGENTA);
                    p.add(address,c);

                    c.gridx = 1;
                    c.gridy = 3;
                    xaddress = new JLabel(prof.getAddress());
                    xaddress.setForeground(Color.MAGENTA);
                    p.add(xaddress,c);

                    c.gridx = 0;
                    c.gridy = 4;
                    phone = new JLabel("Phone Number:");
                    phone.setForeground(Color.CYAN);
                    p.add(phone,c);

                    c.gridx = 1;
                    c.gridy = 4;
                    xphone = new JLabel(prof.getPhone());
                    xphone.setForeground(Color.CYAN);
                    p.add(xphone,c);

                    c.gridx = 0;
                    c.gridy = 5;
                    tcost = new JLabel("Trip Cost:");
                    tcost.setForeground(Color.BLUE);
                    p.add(tcost,c);

                    c.gridx = 1;
                    c.gridy = 5;
                    xtcost = new JLabel(String.valueOf(prof.getCost()));
                    xtcost.setForeground(Color.BLUE);
                    p.add(xtcost,c);

                    c.gridx = 0;
                    c.gridy = 6;
                    travType = new JLabel("Travel Type:");
                    travType.setForeground(Color.ORANGE);
                    p.add(travType,c);

                    c.gridx = 1;
                    c.gridy = 6;
                    xtravType = new JLabel(prof.getTravelType());
                    xtravType.setForeground(Color.ORANGE);
                    p.add(xtravType,c);

                    c.gridx = 0;
                    c.gridy = 7;
                    payType = new JLabel("Payment Type:");
                    payType.setForeground(Color.PINK);
                    p.add(payType,c);

                    c.gridx = 1;
                    c.gridy = 7;
                    xpayType = new JLabel(prof.getPaymentType());
                    xpayType.setForeground(Color.PINK);
                    p.add(xpayType,c);

                    c.gridx = 0;
                    c.gridy = 8;
                    docName = new JLabel("Doctor Name:");
                    docName.setForeground(Color.MAGENTA);
                    p.add(docName,c);

                    c.gridx = 1;
                    c.gridy = 8;
                    xdocName = new JLabel(prof.getMedCondInfo().getMdContact());
                    xdocName.setForeground(Color.MAGENTA);
                    p.add(xdocName,c);

                    c.gridx = 0;
                    c.gridy = 9;
                    docPhone = new JLabel("Doctor Phone Number:");
                    docPhone.setForeground(Color.CYAN);
                    p.add(docPhone,c);

                    c.gridx = 1;
                    c.gridy = 9;
                    xdocPhone = new JLabel(prof.getMedCondInfo().getMdPhone());
                    xdocPhone.setForeground(Color.CYAN);
                    p.add(xdocPhone, c);

                    c.gridx = 0;
                    c.gridy = 10;
                    allergies = new JLabel("Allergy Type:");
                    allergies.setForeground(Color.BLUE);
                    p.add(allergies, c);

                    c.gridx = 1;
                    c.gridy = 10;
                    xallergies = new JLabel(prof.getMedCondInfo().getAlgType());
                    xallergies.setForeground(Color.BLUE);
                    p.add(xallergies, c);

                    c.gridx = 0;
                    c.gridy = 11;
                    ill = new JLabel("Illness Type:");
                    ill.setForeground(Color.ORANGE);
                    p.add(ill, c);

                    c.gridx = 1;
                    c.gridy = 11;
                    xill = new JLabel(prof.getMedCondInfo().getIllType());
                    xill.setForeground(Color.ORANGE);
                    p.add(xill, c);

                    info.add(p);
                    info.pack();
                    info.setBackground(Color.BLACK);
                    info.setTitle("Profile Information");
                    info.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    info.setVisible(true);
                }
            }
        });

        find.add(p);
        find.pack();
        find.setBackground(Color.BLACK);
        find.setTitle("Find Profile");
        find.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        find.setVisible(true);
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
