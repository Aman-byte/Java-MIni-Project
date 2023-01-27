import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Mcq extends Frame implements ActionListener, ItemListener {
    Frame f1 = new Frame("MCQ TEST");
    Button submit, next, prev;
    Checkbox c1, c2, c3, c4;
    Label l1;
    String ques[] = { "Who developed java?", "What was the first name of java?",
            "Which package contains the Random class?", "Which of the following is not a Java features?",
            "Select the valid statement to declare and initialize an array.",
            "When is the object created with new keyword?" };
    String op1[] = { "Tim", "Coffee", "java.util package", "Dynamic", "int[] A = []", "At run time." };
    String op2[] = { "steve", "Oak", "java.lang package", "Architecture Neutral", "int[] A = {1, 2, 3}",
            "At compile time" };
    String op3[] = { "mark", "Green Light", "java.awt package", "Use of pointers", "int[] A = (1. 2. 3)",
            "Depends on the code" };
    String op4[] = { "james", "Tea", "java.io package", "Object-oriented", "int[][] A = {1, 2, 3}", "None" };
    String ans[] = { "james", "Oak", "java.util package", "Use of pointers", "int[] A = {1, 2, 3}", "At run time" };
    int qn, on, score;
    CheckboxGroup cbg = new CheckboxGroup();

    Mcq() {
        f1.setLayout(null);
        f1.setVisible(true);
        f1.setSize(800, 600);
        l1 = new Label(ques[qn]);
        l1.setBounds(80, 80, 580, 30);
        l1.setFont(new Font("chiller", Font.BOLD, 25));
        f1.add(l1);
        // set up the checkboxes
        c1 = new Checkbox(op1[on], cbg, false);
        c1.setBounds(100, 150, 580, 30);
        c1.setFont(new Font("chiller", Font.ITALIC, 25));
        f1.add(c1);
        c2 = new Checkbox(op2[on], cbg, false);
        c2.setBounds(100, 200, 580, 30);
        c2.setFont(new Font("chiller", Font.ITALIC, 25));
        f1.add(c2);
        c3 = new Checkbox(op3[on], cbg, false);
        c3.setFont(new Font("chiller", Font.ITALIC, 25));
        c3.setBounds(100, 250, 580, 30);
        f1.add(c3);
        c4 = new Checkbox(op4[on], cbg, false);
        c4.setFont(new Font("chiller", Font.ITALIC, 25));
        c4.setBounds(100, 300, 580, 30);
        f1.add(c4);
        // prev button
        prev = new Button("Previous");
        prev.setFont(new Font("chiller", Font.BOLD, 20));
        prev.setBounds(100, 400, 100, 30);
        prev.addActionListener(this);
        f1.add(prev);
        // next button
        next = new Button("Next");
        next.setFont(new Font("chiller", Font.BOLD, 20));
        next.setBounds(300, 400, 100, 30);
        next.addActionListener(this);
        f1.add(next);
        f1.repaint();
        // submit button
        submit = new Button("Submit");
        submit.setFont(new Font("chiller", Font.BOLD, 25));
        submit.setBounds(400, 400, 150, 30);
        submit.addActionListener(this);
        f1.add(submit);
        submit.setVisible(false);
        c1.addItemListener(this);
        c2.addItemListener(this);
        c3.addItemListener(this);
        c4.addItemListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            if (qn <= 4) {
                qn++;
                on++;
                l1.setText(ques[qn]);
                c1.setLabel(op1[on]);
                c2.setLabel(op2[on]);
                c3.setLabel(op3[on]);
                c4.setLabel(op4[on]);
            } else {
                JOptionPane.showMessageDialog(f1, "! This is the last page !");
            }
        } else if (e.getSource() == prev) {
            if (qn >= 0) {
                qn--;
                on--;
                l1.setText(ques[qn]);
                c1.setLabel(op1[on]);
                c2.setLabel(op2[on]);
                c3.setLabel(op3[on]);
                c4.setLabel(op4[on]);
            } else {
                JOptionPane.showMessageDialog(f1, "! This is the first page !");
            }
        }
        cbg.setSelectedCheckbox(null);
        if (e.getSource() == submit) {
            JOptionPane.showMessageDialog(f1, "! Are you sure you want to submit !");
            f1.removeAll();
            Label lff = new Label("Your Score is : " + score);
            lff.setFont(new Font("chiller", Font.BOLD, 60));
            lff.setBounds(150, 200, 600, 80);
            f1.add(lff);
            prev.setVisible(false);
            submit.setVisible(false);
        }
        if (qn == 3) {
            submit.setVisible(true);
            next.setVisible(false);
        } else {
            submit.setVisible(false);
            next.setVisible(true);
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String answer = "";
        Checkbox cc = cbg.getSelectedCheckbox();
        if (cc.getLabel().equals(ans[on])) {
            score += 4;
        } else {
            score -= 1;
        }

    }

    public static void main(String[] args) {
        Mcq test = new Mcq();
    }

}