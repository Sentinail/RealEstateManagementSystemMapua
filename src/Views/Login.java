package Views;

import javax.swing.*;
import java.awt.*;
import Theme.Theme;

public class Login extends JPanel {
    public Login() {
        this.setLayout(new FlowLayout());
        this.setBackground(Theme.BACKGROUND);

        this.setPreferredSize(new Dimension(800, 600));
        this.setMinimumSize(new Dimension(800, 600));
        this.setMaximumSize(new Dimension(800, 600));
        this.setName("login");
    }
}
