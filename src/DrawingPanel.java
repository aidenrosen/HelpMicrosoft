
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class DrawingPanel extends JPanel {

	private BufferedImage image, image2;

	public DrawingPanel() {
		super();
		setLayout(null);
		this.setBackground(Color.white);

		try {
			image = ImageIO.read(new File("./quinnipiacLogo1.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			image2 = ImageIO.read(new File("Microsoft-Logo.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ImageIcon icon = new ImageIcon("./quinnipiacLogo1.png");

		JButton button1 = new JButton("GO!");
		button1.setLocation(225, 150);
		button1.setSize(80, 50);

		this.add(button1);

		JLabel label = new JLabel("Filepath");
		label.setBounds(135, 20, 80, 25);
		this.add(label);

		JTextField filepathText = new JTextField(20);
		filepathText.setBounds(190, 20, 165, 25);
		this.add(filepathText);

		JLabel token = new JLabel("Token");
		token.setBounds(142, 50, 80, 25);
		this.add(token);

		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(190, 50, 165, 25);
		this.add(passwordText);

		JLabel user = new JLabel("Username");
		user.setBounds(120, 80, 80, 25);
		this.add(user);

		JTextField userText = new JTextField(20);
		userText.setBounds(190, 80, 165, 25);
		this.add(userText);

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D brush = (Graphics2D) g;

		g.drawImage(image, 10, 0, 100, 100, null);

		g.drawImage(image2, 380, 0, 150, 100, null);

	}

}
