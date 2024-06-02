import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JListGui extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JButton addButton;
    private JList<String> list1;
    private JList<String> list2;
    private JButton removeButton;


    public JListGui() {
        setTitle("JList App");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();



        DefaultListModel<String> model1 = new DefaultListModel<>();
        DefaultListModel<String> model2 = new DefaultListModel<>();


        list1.setModel(model1);
        list2.setModel(model2);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseName = textField1.getText();
                if (!courseName.isEmpty()) {
                    model1.addElement(courseName);
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list1.getSelectedIndex();
                if (selectedIndex != -1) {
                    String selectedCourse = model1.remove(selectedIndex);
                    model2.addElement(selectedCourse);
                    list1.setBackground(Color.RED);
                    list2.setBackground(Color.GREEN);
                }
            }
        });
    }
}