package net.deimon.abc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by IntelliJ IDEA.
 * User: deimon
 * Date: 4/8/12
 * Time: 8:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainWindow{

    private JPanel root;
    private JLabel questinArea;
    private Memorable memorable;
    private ProgressPanel progressPanel;

    public MainWindow(final Lesson lesson) {
        root = new JPanel(new BorderLayout());
        questinArea = new JLabel("");
        questinArea.setHorizontalAlignment(SwingConstants.CENTER);
        questinArea.setFont(questinArea.getFont().deriveFont(200.0f));
        root.add(questinArea, BorderLayout.CENTER);
        JButton yesButton = new JButton(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                memorable.attempt(true);
                next(lesson);
            }
        });
        yesButton.setText("Yes");
        root.add(yesButton, BorderLayout.WEST);
        JButton noButton = new JButton(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                memorable.attempt(false);
                next(lesson);
            }
        });
        noButton.setText("No");
        root.add(noButton, BorderLayout.EAST);
        progressPanel = new ProgressPanel(lesson.getMemorables());
        root.add(progressPanel.getRoot(), BorderLayout.SOUTH);
        next(lesson);

    }

    private void next(Lesson lesson) {
        memorable=lesson.next(memorable);
        questinArea.setText(memorable.getValue());
        progressPanel.update();
    }

    public JPanel getRoot() {
        return root;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ABC");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MainWindow(new Lesson(
                "A","B","C","D","E",
                "F","G","H","I","J",
                "K","L","M","N","O",
                "P","Q","R","S","T",
                "U","V","W"/*,"X","Y","Z"*/)).getRoot());
        frame.setSize(400,400);
        frame.setVisible(true);
    }
}
