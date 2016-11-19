import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;


public class PaintPanel extends JPanel {
	private static int POINT_SIZE;
	
	private ArrayList<PaintPoint> _points;
	private Color _color;
	private static int _size = 10;;
	
	public PaintPanel() {
		setPreferredSize(new Dimension(800, 500));
		_points = new ArrayList<PaintPoint>();
		_color = Color.RED;
		
		MousePaintAdapter mpa = new MousePaintAdapter();
		addMouseMotionListener(mpa);
	}
	
	private class PaintPoint {
		private final int _x;
		private final int _y;
		private Color _colorp;
		private final int _sizep;
	
			public  PaintPoint (int x, int y, Color color, int size) {
				_x = x;
				_y = y;
				_colorp = color;
				_sizep = size;
			}
	}
	
	public void setColor(Color color) {
		_color = color;
	}
	
	public void setSize(int size) {
		_size = size;
	}
	
	public void clearP()
	{
		_points.clear();
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		
		
		for (PaintPoint point : _points) {
			graphics.setColor(point._colorp);
			POINT_SIZE = point._sizep;
			//Added some code to center the brush stroke
			graphics.fillOval((point._x-(POINT_SIZE/2)), (point._y-(POINT_SIZE/2)), POINT_SIZE, POINT_SIZE);
		}
	}
	
	private class MousePaintAdapter extends MouseAdapter {
		@Override
		public void mouseDragged(MouseEvent ev) {
			Point n = ev.getPoint();
			_points.add(new PaintPoint(n.x,n.y,_color,_size));
			repaint();
		}
	}
}
		

		
