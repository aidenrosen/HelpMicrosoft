
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class App extends JFrame {	
    public App() {
        super("Microsoft App");
       
        this.setLayout(new BorderLayout());

        JLabel label = new JLabel("Beta");
        
        
        DrawingPanel drawingPanel = new DrawingPanel();
        
  
        ControlPanel controlPanel = new ControlPanel(drawingPanel);
        
        this.setSize(550, 300);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.add(controlPanel, BorderLayout.SOUTH);
        this.add(drawingPanel, BorderLayout.CENTER);
        this.add(label, BorderLayout.NORTH);

        this.setVisible(true);

    }

    public static void main(String[] args) {
        new App();
    }
}
