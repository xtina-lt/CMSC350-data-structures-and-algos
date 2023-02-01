/*
 *
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.EmptyStackException;

public class Project extends JFrame {
    private String expression;
    private String sum;
    private Evaluation evaluation = new Evaluation();

    /* PUBLIC CONSTRUCTOR:
     * allows for creation of new instance.
     * We only need one gui for our program. */
    public Project() {
        /* 1 ) Create Panels or Window
         * JPanel is a generic lightweight container.
         * MAIN BOX (title aka super)
         *  Input
         * Results */
        super("Expression Converter");
        JPanel main = new JPanel();
        JPanel inputPanel = new JPanel();
        JPanel submit = new JPanel();
        JPanel resultPanel = new JPanel();

        /* 2 ) Create components inside of window.
         * MAIN BOX
         *  Input
         * Results */
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS)); 
        // input
        JLabel inputLabel = new JLabel("Enter Expression");
        JTextField userInput = new JTextField(null, 20);
        inputPanel.add(inputLabel);
        inputPanel.add(userInput);
        // submit or evaluation button
        JButton submitBtn = new JButton("evaluate");
        submit.add(submitBtn);
        // results
        JLabel resultLabel = new JLabel("Result");
        JTextField resultText = new JTextField(null, 20);
        resultText.setEditable(false);
        resultPanel.add(resultLabel);
        resultPanel.add(resultText);
        
        // 3 ) Add components to panels
        main.add(inputPanel);
        main.add(submit);
        main.add(resultPanel);
        // main to JFrame
        add(main);

        // 4 ) Change window(JFrame) size settings
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 150);
        setLocation(300, 400);
        setResizable(false);
        setVisible(true);


        // 5 ) Button Handler for evaluation.
        submitBtn.addActionListener((ActionEvent e) -> {
            // get input from Text Field
            expression = userInput.getText();

            // 6) tests for errors
            try {
                if ( expression.isEmpty() ) {
                    throw new NullPointerException();
                } else {
                    // 7 ) if no errors evaluate
                    resultText.setText( evaluation.eval(expression) );
                }
            // shows errors with new messages
            } catch (NullPointerException exception) {
                JOptionPane.showMessageDialog(null, "Let's try an expression.... :(", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (EmptyStackException exception) {
                JOptionPane.showMessageDialog(null,
                        "Err wrong! Lets add some numbers...", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch (DivideByZeroException exception) {
                JOptionPane
                        .showMessageDialog(null, "Cannot divide by zero. Answer would be nothing :(", "Error",
                                JOptionPane.ERROR_MESSAGE);
            } catch (InvalidCharException exception) {
                JOptionPane.showMessageDialog(null,
                        "Errr wrong! Try a valid character :)", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } 
        // end of action listener
        });
    // end of constructor    
    }

    public static void main(String[] args) {
        // RUNS PROGRAM
        Project proj = new Project();
    }
}