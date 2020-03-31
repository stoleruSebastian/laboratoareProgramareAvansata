import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel sidesLabel;          // we’re drawing regular polygons
    JSpinner sidesField;        // number of sides
    JComboBox colorCombo;       // the color of the shape
    JComboBox chooseShape;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    public JLabel getSidesLabel() {
        return sidesLabel;
    }

    public void setSidesLabel(JLabel sidesLabel) {
        this.sidesLabel = sidesLabel;
    }

    public JSpinner getSidesField() {
        return sidesField;
    }

    public void setSidesField(JSpinner sidesField) {
        this.sidesField = sidesField;
    }

    public JComboBox getColorCombo() {
        return colorCombo;
    }

    public void setColorCombo(JComboBox colorCombo) {
        this.colorCombo = colorCombo;
    }


    private void init() {
        //create the label and the spinner
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6); //default number of sides
        String[] colors = {"Random", "Black"};
        colorCombo = new JComboBox(colors);
        add(sidesLabel); //JPanel uses FlowLayout by default
        add(sidesField);
        add(colorCombo);
        String[] shapes = {"Polygon", "Rectangle","Circle"};
        chooseShape = new JComboBox(shapes);
        add(chooseShape);
        frame.canvas.getShape("Polygon");//default
        chooseShape.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JComboBox<String> x = (JComboBox<String>) event.getSource();
                String selectedShape = (String) x.getSelectedItem();

                if (selectedShape.equals("Polygon")) {
                    frame.canvas.getShape("Polygon");
                } else if (selectedShape.equals("Rectangle")) {
                    frame.canvas.getShape("Rectangle");
                } else if (selectedShape.equals("Circle")) {
                    frame.canvas.getShape("Circle");
                }
            }
        });


    }
}
