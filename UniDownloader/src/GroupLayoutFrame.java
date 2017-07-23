import static javax.swing.GroupLayout.Alignment.*;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
 
@SuppressWarnings("serial")

public class GroupLayoutFrame extends JFrame {
   
    public GroupLayoutFrame() {
   
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
       
        JLabel label = new JLabel("Label:");;
        JTextField textField = new JTextField();
        JButton button = new JButton("Button");
        JButton button2 = new JButton("previous");
        JButton button3 = new JButton("next");
        JButton button4 = new JButton("quit");
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Tab1", panel1);
        tabbedPane.addTab("Tab2", panel2);
        tabbedPane.addTab("Tab3", panel3);
       
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
 
        layout.setHorizontalGroup(
                layout.createParallelGroup(TRAILING)
                    .addGroup(layout.createSequentialGroup()
                            .addComponent(label)
                            .addComponent(textField)
                            .addComponent(button)
                    )
                    .addComponent(tabbedPane)
                    .addGroup(layout.createSequentialGroup()
                                .addComponent(button2)
                                .addComponent(button3)
                                .addComponent(button4)
                    )
        );
       
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(BASELINE)
                            .addComponent(label)
                            .addComponent(textField)
                            .addComponent(button)
                    )
                    .addComponent(tabbedPane)
                    .addGroup(layout.createParallelGroup(BASELINE)
                            .addComponent(button2)
                            .addComponent(button3)
                            .addComponent(button4)
                    )
        );
       
       
        setMinimumSize(new Dimension(340, 200));
        setPreferredSize(new Dimension(640, 480));
        setTitle("GUI Test");
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
     
    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                new GroupLayoutFrame().setVisible(true);
            }
        });
    }
}