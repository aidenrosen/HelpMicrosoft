
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
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

		JButton button1 = new JButton("GO!");
		button1.setLocation(225, 150);
		button1.setSize(80, 50);
		this.add(button1);

		JButton disclaimer = new JButton("Disclaimer");
		disclaimer.setLocation(400, 150);
		disclaimer.setSize(100, 30);
		this.add(disclaimer);

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

		JLabel linkText = new JLabel("URL:");
		linkText.setBounds(20, 200, 80, 25);
		this.add(linkText);

		JTextField link = new JTextField(20);
		link.setBounds(50, 200, 450, 25);
		this.add(link);

		JTextArea disclaimerText = new JTextArea();
		disclaimerText.setBounds(400, 80, 80, 25);
		disclaimerText.setWrapStyleWord(true);
		disclaimerText.setLineWrap(true);
		disclaimerText.setEditable(false);

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				

				String path = filepathText.getText();
				String token = passwordText.getText();
				String username = userText.getText();

				GithubHelper helper = new GithubHelper(username, token);
				helper.createRepo(path);
				link.setText(helper.getLink());

				System.out.println(link.getText());  //DEBUG

				if (link.getText().isBlank()) {
					JTextArea errorMessage = new JTextArea();
					errorMessage.setBounds(400, 80, 80, 25);
					errorMessage.setWrapStyleWord(true);
					errorMessage.setLineWrap(true);
					errorMessage.setEditable(false);

					errorMessage.setText("Error, please try again. ");
					JFrame frame = new JFrame();

					frame.setSize(200, 100);
					frame.setLocation(200, 100);

					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
					JPanel panel1 = new JPanel();
					frame.add(panel1);
					frame.add(errorMessage);

				} else {
					link.setText(helper.getLink());
					System.out.println("Good");
				}

//						try {
//							Desktop.getDesktop().browse(new URI(link.getText()));
//						} catch (IOException | URISyntaxException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
//					

				// TODO: Make this link appear on GUI
			}

		});

		disclaimer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();

				frame.setSize(550, 300);
				frame.setLocation(600, 0);

				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
				JPanel panel1 = new JPanel();
				frame.add(panel1);
//				JButton button3 = new JButton("OK");
//				button3.setLocation(300, 200);
//				button3.setSize(50, 50);
//
//				panel1.add(button3);

				frame.add(disclaimerText);
				disclaimerText.setText("This app was made for the purpose of "
						+ "CSC109 and is in no way actually affliated with Micrsoft.");
				disclaimerText.setBounds(0, 0, 400, 400);

				;
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
