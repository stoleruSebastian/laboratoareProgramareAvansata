import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);//create the components
        canvas = new DrawingPanel(this);
        configPanel=new ConfigPanel(this);
        controlPanel=new ControlPanel(this);
        add(configPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        pack();
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }
}
