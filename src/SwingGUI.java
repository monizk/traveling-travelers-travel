import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingGUI {
    public static void mainMenu(){
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

        select.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               if (create.isSelected()){
                   create();
               } else if (delete.isSelected()){
                   delete();
               } else if (update.isSelected()){
                   update();
               } else if (find.isSelected()){
                   find();
               } else if (display.isSelected()){
                   display();
               } else {
                   JOptionPane.showMessageDialog(main, "Please select an option.");
               }
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

    public static void create(){
        JFrame create = new JFrame();

        JPanel p1, p2;
        JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13;
        JTextField travID, first, last, address, phone, tcost, rewards, rID, rbal;
        JComboBox travType, payType, mode;
        JButton submit;

        p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.setBackground(Color.BLACK);

        p2 = new JPanel();
        p2.setLayout(new GridBagLayout());

        l1 = new JLabel("Create a Traveler Profile", SwingConstants.CENTER);
        l1.setPreferredSize(new Dimension(100, 30));
        l1.setForeground(Color.WHITE);

        // lists of necessary options
        String[] travOptions = {"Business", "Pleasure"};
        String[] payOptions = {"Credit", "Check", "Debit", "Invoice"};
        String[] modeOptions = {"Car", "Train", "Plane"};

        // initialize variables
        GridBagConstraints con = new GridBagConstraints();

        // initialize labels, fields, & drop downs
        con.gridx = 0;
        con.gridy = 0;
        l2 = new JLabel("Travel ID:");
        p2.add(l2, con);

        con.gridx = 1;
        con.gridy = 0;
        travID = new JTextField("Enter Travel ID");
        p2.add(travID, con);

        con.gridx = 0;
        con.gridy = 1;
        l3 = new JLabel("First Name:");
        p2.add(l3, con);

        con.gridx = 1;
        con.gridy = 1;
        first = new JTextField("Enter First Name");
        p2.add(first, con);

        con.gridx = 0;
        con.gridy = 2;
        l4 = new JLabel("Last Name:");
        p2.add(l4, con);

        con.gridx = 1;
        con.gridy = 2;
        last = new JTextField("Enter Last Name");
        p2.add(last, con);

        con.gridx = 0;
        con.gridy = 3;
        l5 = new JLabel("Address:");
        p2.add(l5, con);

        con.gridx = 1;
        con.gridy = 3;
        address = new JTextField("Enter Address");
        p2.add(address, con);

        con.gridx = 0;
        con.gridy = 4;
        l6 = new JLabel("Phone Number:");
        p2.add(l6, con);

        con.gridx = 1;
        con.gridy = 4;
        phone = new JTextField("Enter Phone Number");
        p2.add(phone, con);

        con.gridx = 0;
        con.gridy = 5;
        l7 = new JLabel("Trip Cost:");
        p2.add(l7, con);

        con.gridx = 1;
        con.gridy = 5;
        tcost = new JTextField("Enter Trip Cost");
        p2.add(tcost, con);

        con.gridx = 0;
        con.gridy = 6;
        l8 = new JLabel("Travel Type:");
        p2.add(l8, con);

        con.gridx = 1;
        con.gridy = 6;
        travType = new JComboBox(travOptions);
        p2.add(travType, con);

        con.gridx = 0;
        con.gridy = 7;
        l9 = new JLabel("Payment Type:");
        p2.add(l9, con);

        con.gridx = 1;
        con.gridy = 7;
        payType = new JComboBox(payOptions);
        p2.add(payType, con);

        con.gridx = 0;
        con.gridy = 8;
        l10 = new JLabel("Mode of Travel:");
        p2.add(l10, con);

        con.gridx = 1;
        con.gridy = 8;
        mode = new JComboBox(modeOptions);
        p2.add(mode, con);

        con.gridx = 0;
        con.gridy = 9;
        l11 = new JLabel("Rewards Company:");
        p2.add(l11, con);

        con.gridx = 1;
        con.gridy = 9;
        rewards = new JTextField("Enter Rewards Company");
        p2.add(rewards, con);

        con.gridx = 0;
        con.gridy = 10;
        l12 = new JLabel("Rewards ID:");
        p2.add(l12, con);

        con.gridx = 1;
        con.gridy = 10;
        rID = new JTextField("Enter Rewards ID");
        p2.add(rID, con);

        con.gridx = 0;
        con.gridy = 11;
        l13 = new JLabel("Rewards Balance:");
        p2.add(l13, con);

        con.gridx = 1;
        con.gridy = 11;
        rbal = new JTextField("Enter Rewards Balance");
        p2.add(rbal, con);

        // fill p1
        p1.add(l1, BorderLayout.CENTER);

        create.add(p1, BorderLayout.NORTH);
        create.add(p2, BorderLayout.CENTER);

        // display the window
        create.pack();
        create.setSize(600, 900);
        create.setBackground(Color.BLACK);
        create.setTitle("Create Profile");
        create.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        create.setVisible(true);
    }

    public static void delete(){
        JOptionPane.showMessageDialog(null,"delete!");
    }

    public static void update(){
        JOptionPane.showMessageDialog(null,"update!");
    }

    public static void find(){
        JOptionPane.showMessageDialog(null,"find!");
    }

    public static void display(){
        JOptionPane.showMessageDialog(null,"display!");
    }

    public static void useGUI(){
        mainMenu();
    }

    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                useGUI();
            }
        });
    }
}
