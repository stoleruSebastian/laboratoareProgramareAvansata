import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image;  //the offscreen image
    Graphics2D graphics;  //the "tools" needed to draw in the image
    String shape;
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }
    public void getShape(String s){
        shape=s;
    }
    public void checkShape(){

    }
    private void init() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
    }


     private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }

    private void drawShape(int x, int y) {
        Random rand = new Random();
        int radius = rand.nextInt(100);
        int sides = (int) frame.configPanel.sidesField.getValue();
        Color color = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
        String selectedColor = (String) frame.configPanel.colorCombo.getSelectedItem();
        if(selectedColor=="Random")
            graphics.setColor(color);
         if(selectedColor=="Black")
             graphics.setColor(Color.BLACK);
        if(shape=="Polygon")
            graphics.fill(new RegularPolygon(x, y, radius, sides));
        if(shape=="Rectangle")
            graphics.fill(new Rectangle(x, y, rand.nextInt(W), rand.nextInt(H)));
        if(shape=="Circle")
            graphics.fill(new Circle(rand.nextInt(W) - 2*radius, rand.nextInt(H) - radius, radius, radius));
    }

    @Override
    public void update(Graphics g) {
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}

