import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class MyFrame extends JFrame {
    public MyFrame() {
        ImageIcon showIcon = new ImageIcon("C:\\Users\\Danila\\Java\\PasswordGenerator\\assets\\icons\\show.png");
        ImageIcon hideIcon = new ImageIcon("C:\\Users\\Danila\\Java\\PasswordGenerator\\assets\\icons\\hide.png");
        ImageIcon copyIcon = new ImageIcon("C:\\Users\\Danila\\Java\\PasswordGenerator\\assets\\icons\\copy.png");
        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 8, 8));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Password Generator");

        String[] options = {"Apple Easy to Type", "Passcode", "Password"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        getContentPane().add(comboBox);
        JButton generateButton = new JButton("Generate");
        getContentPane().add(generateButton);
        generateButton.addActionListener(_ -> {
            Generator generator = new Generator();
            Password password = new Password();
            if (comboBox.getSelectedItem() == options[0]) {
                password.setValue(generator.generateAppleEasyToTypePassword());
            } else if (comboBox.getSelectedItem() == options[1]) {
                password.setValue(generator.generatePasscode(6));
            } else if (comboBox.getSelectedItem() == options[2]) {
                password.setValue(generator.generatePassword(20));
            }
            JDialog jDialog = new JDialog(this, "Password", true);
            jDialog.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 8));
            JPasswordField passwordField = new JPasswordField(password.getValue());
            jDialog.add(passwordField);
            JButton showButton = new JButton(showIcon);
            jDialog.add(showButton);
            showButton.addActionListener(_ -> {
                if (password.isVisible()) {
                    passwordField.setEchoChar('*');
                    password.setVisible(false);
                    showButton.setIcon(showIcon);
                } else {
                    passwordField.setEchoChar((char) 0);
                    password.setVisible(true);
                    showButton.setIcon(hideIcon);
                }
            });
            JButton copyButton = new JButton(copyIcon);
            jDialog.add(copyButton);
            copyButton.addActionListener(_ -> {
                StringSelection stringSelection = new StringSelection(passwordField.getText());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
            });
            jDialog.pack();
            jDialog.setLocationRelativeTo(this);
            jDialog.setVisible(true);
        });
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}