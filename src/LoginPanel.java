import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginDemo extends JFrame implements ActionListener {

    JPanel panel;
    JLabel user_label, password_label, message;
    JTextField userName_text;
    JPasswordField password_text;
    JButton submit, cancel,newUser;

    LoginDemo() {

        // Username Label
        user_label = new JLabel();
        user_label.setText("User Name :");
        userName_text = new JTextField();

        // Password Label

        password_label = new JLabel();
        password_label.setText("Password :");
        password_text = new JPasswordField();

        //newUser label
        newUser = new JButton("SIGN UP");

        // Submit

        submit = new JButton("SUBMIT");

        panel = new JPanel(new GridLayout(3, 1));
        panel.add(user_label);
        panel.add(userName_text);
        panel.add(password_label);
        panel.add(password_text);

        message = new JLabel();
        panel.add(message);
        panel.add(submit);
        //panel.add(newUser); uncomment this when read to test to see how it changes the window's format and size

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding the listeners to components..
        submit.addActionListener(this);
        newUser.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("Please Login Here !");
        setSize(450,350);
        setVisible(true);
    }

    @Override// might need to take this out. the override might make it the action for both submit and newUser buttons
    public void actionPerformed(ActionEvent ae) {
        // needs safe input - needs to loop till correct.
        String userName = userName_text.getText();
        String password = password_text.getText();// idk why this is crossed out "is deprecated"
        message.setText(User.login(userName.trim(),password.trim()));
    }
    // action listener goes here for create user. the last thing in this needs to be to call login()
    //login(userName, password);// has them login after creating it.
}
