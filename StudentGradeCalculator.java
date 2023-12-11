import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGradeCalculator extends JFrame {
    private JTextField[] subjectFields;
    private JLabel totalMarksLabel, averagePercentageLabel, gradeLabel;

    public StudentGradeCalculator() {
        setTitle("Student Grade Calculator");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        initializeComponents();
        addComponents();

        setLocationRelativeTo(null); 
        setVisible(true);
    }

    private void initializeComponents() {
        subjectFields = new JTextField[5]; // Assuming 5 subjects for simplicity

        for (int i = 0; i < subjectFields.length; i++) {
            subjectFields[i] = new JTextField(5);
        }

        totalMarksLabel = new JLabel("Total Marks: ");
        averagePercentageLabel = new JLabel("Average Percentage: ");
        gradeLabel = new JLabel("Grade: ");

        JButton calculateButton = new JButton("Calculate Grades");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGrades();
            }
        });
    }

    private void addComponents() {
        
            add(new JLabel("English Marks: "));
            add(subjectFields[0]);
            add(new JLabel("Mathematics Marks: "));
            add(subjectFields[1]);
            add(new JLabel("Science Marks: "));
            add(subjectFields[2]);
            add(new JLabel("History Marks: "));
            add(subjectFields[3]);
            add(new JLabel("Geography Marks: "));
            add(subjectFields[4]);
      
        add(totalMarksLabel);
        add(averagePercentageLabel);
        add(gradeLabel);

        JButton calculateButton = new JButton("Calculate Grades");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGrades();
            }
        });
        add(calculateButton);
    }

    private void calculateGrades() {
        int totalMarks = 0;
        int numSubjects = subjectFields.length;

        for (int i = 0; i < numSubjects; i++) {
            try {
                int marks = Integer.parseInt(subjectFields[i].getText());
                totalMarks += marks;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid input for subject " + (i + 1), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        double averagePercentage = (double) totalMarks / numSubjects;
        String grade = calculateGrade(averagePercentage);

        totalMarksLabel.setText("Total Marks: " + totalMarks);
        averagePercentageLabel.setText("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        gradeLabel.setText("Grade: " + grade);
    }

    private String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A";
        } else if (averagePercentage >= 80) {
            return "B";
        } else if (averagePercentage >= 70) {
            return "C";
        } else if (averagePercentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentGradeCalculator();
            }
        });
    }
}
