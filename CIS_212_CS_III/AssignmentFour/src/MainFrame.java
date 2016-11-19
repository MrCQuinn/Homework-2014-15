
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	private PaintPanel _paintPanel;
	public MainFrame() {
		super("Hello Frame!!!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout( new BorderLayout());
		
		_paintPanel = new PaintPanel();
		add(_paintPanel, BorderLayout.CENTER);
		
		JButton colorButton = new JButton("Custom Color");
		colorButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ev) {
				Color color = JColorChooser.showDialog(null, "Pick a color!", Color.RED);
				_paintPanel.setColor(color);
			}
		});
		
		JButton greenButton = new JButton("Green");
		greenButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ev) {
				Color color = Color.GREEN;
				_paintPanel.setColor(color);
			}
		});
		
		JButton yellowButton = new JButton("Yellow");
		yellowButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ev) {
				_paintPanel.setColor(Color.YELLOW);;
			}
		});
		
		JButton purpleButton = new JButton("Dat Purp");
		purpleButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ev) {
				_paintPanel.setColor(Color.MAGENTA);;
			}
		});
		
		JButton sizeButton = new JButton ("Custom Size");
		
		sizeButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ev) {
				int l = 0;
				
				
				while (l == 0)
						{
						String sizeInput =JOptionPane.showInputDialog("Custom Brush Size: ");
							try{
								int sizeInputInt = Integer.parseInt(sizeInput);
								_paintPanel.setSize(sizeInputInt);
								l = 1;
							}
							catch(NumberFormatException e){
								System.out.println("Enter a number.");
							}
						}
				}
		});
		
		JButton bigButton = new JButton ("Large");
		
		bigButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ev) {
				
				_paintPanel.setSize(50);
				}
		});
		
		JButton mediumButton = new JButton("Medium");
		
		mediumButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ev) {
				
				_paintPanel.setSize(30);
			}
		});
		
		JButton smallButton = new JButton("Small");
		
		smallButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ev) {
				
				_paintPanel.setSize(10);
			}
		});
		
		JButton clearButton = new JButton("Clear");
		
		clearButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ev) {
				
				_paintPanel.clearP();
			}
		});
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5,1));
		buttonPanel.add(colorButton);
		buttonPanel.add(greenButton);
		buttonPanel.add(yellowButton);
		buttonPanel.add(purpleButton);
		buttonPanel.add(clearButton);
		add(buttonPanel,BorderLayout.WEST);
		
		JPanel sizePanel = new JPanel();
		sizePanel.setLayout(new GridLayout(4,1));
		sizePanel.add(sizeButton);
		sizePanel.add(bigButton);
		sizePanel.add(mediumButton);
		sizePanel.add(smallButton);
		add(sizePanel,BorderLayout.EAST);
		
		pack();
	}

}
