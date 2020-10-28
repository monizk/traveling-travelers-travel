import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TravProfInterface {
    private JEditorPane editorPane1;
    private JTabbedPane tabbedPane1;
    private JButton travelAgentButton;
    private JButton businessButton;
    private JButton travelerButton;
    private JFormattedTextField selectTheRoleThatFormattedTextField;
    private JFormattedTextField theIntegratedTravelSystemFormattedTextField;

    public TravProfInterface() {
        travelAgentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hello, does this work?");
            }
        });
    }
    public static void main(String[] args){
        JFrame frame = new JFrame("TravProfInterface");
        frame.setContentPane(new TravProfInterface().editorPane1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
