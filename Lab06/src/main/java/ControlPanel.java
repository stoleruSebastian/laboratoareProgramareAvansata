import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 4));
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);

    }

    private void save(ActionEvent e) {
            JFrame parentFrame = new JFrame();
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save image");
            int userSelection = fileChooser.showSaveDialog(parentFrame);
            fileChooser.setFileFilter(new FileNameExtensionFilter("*.png", "png"));
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                System.out.println("Save as file: " + fileToSave.getAbsolutePath());
                try {
                    ImageIO.write(frame.canvas.image, "PNG", new File(fileToSave.getAbsolutePath()));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }


    }

    private void load(ActionEvent e) {
        JFrame parentFrame = new JFrame();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Load image");
        int userSelection = fileChooser.showSaveDialog(parentFrame);
        fileChooser.setFileFilter(new FileNameExtensionFilter("*.png", "png"));
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToLoad = fileChooser.getSelectedFile();
            try {
                frame.canvas.image = ImageIO.read(fileToLoad);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        frame.canvas.graphics = frame.canvas.image.createGraphics();
        frame.canvas.repaint();
    }


    private void reset(ActionEvent e) {
        frame.canvas.image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        frame.canvas.graphics = frame.canvas.image.createGraphics();
        frame.canvas.graphics.setColor(Color.WHITE);
        frame.canvas.graphics.fillRect(0, 0, 800, 600);
        frame.canvas.repaint();
    }

    private void exit(ActionEvent e) {
        System.exit(0);

    }
}