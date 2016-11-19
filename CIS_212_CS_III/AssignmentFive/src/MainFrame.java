import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MainFrame extends JFrame{
	
	public MainFrame(final ArrayList<ContactEntry> n){
		super("Contact Sort");
		setPreferredSize(new Dimension(500, 200));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout( new BorderLayout());
		final JLabel labels = new JLabel("");
		final JLabel labelm = new JLabel("");
		
		JButton selectionButton = new JButton("Selection Sort");
		selectionButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ev) {
				long startTime = System.nanoTime();
				ArrayList<ContactEntry> sorted = Main.SelectionSort(n);
				long endTime = System.nanoTime();
				if(Main.isSorted(sorted))
				{
					labels.setText(endTime-startTime + " nanoseconds or " + .000000001*(endTime-startTime) + "seconds" );
				}
				else
				{
					labels.setText("Error");
				}
			}
		});
		
		JButton mergeButton = new JButton("Merge Sort");
		mergeButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ev) {
				long startTime = System.nanoTime();
				ArrayList<ContactEntry> sorted = Main.mergeSort(n);
				long endTime = System.nanoTime();
				if(Main.isSorted(sorted))
				{
					labelm.setText(endTime-startTime + " nanoseconds or " + .000000001*(endTime-startTime) + "seconds" );
				}
				else
				{
					labelm.setText("Error");
				}
			}
		});
		
		JPanel buttonpanel = new JPanel();
		buttonpanel.setLayout(new GridLayout(2,1));
		buttonpanel.add(selectionButton);
		buttonpanel.add(mergeButton);
		add(buttonpanel,BorderLayout.WEST);
		
		JPanel timepanel = new JPanel();
		timepanel.setLayout(new GridLayout(2,1));
		timepanel.add(labels);
		timepanel.add(labelm);
		add(timepanel,BorderLayout.EAST);
		
		pack();
		
	}

}
