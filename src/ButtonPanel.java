import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
	public ButtonPanel(DrawingPanel drawingPanel) {
		this.setLayout(new FlowLayout());
		this.setBackground(Color.green);

		JButton button1 = new JButton("Ellipse");
		button1.setSize(50, 50);

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// each time button is clicked, code in here is run
				// System.out.println("You clicked me!");

			}
		});

		JButton button2 = new JButton("Rectangle");
		button2.setSize(50, 50);

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// each time button is clicked, code in here is run
				// System.out.println("You clicked me!");

			}
		});

		JButton button3 = new JButton("Rounded Rectangle");
		button3.setSize(50, 50);

		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// each time button is clicked, code in here is run

				System.out.println("You clicked me!");
			}
		});

		this.add(button1);
		this.add(button2);
		this.add(button3);

		// TODO: Add buttons
	}
}
