import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 * This demonstrates the controller in a model-view-controller pattern.
 * Adapted from Figures 14.23 and 14.34.
 * @author Tom Bylander
 */
public class DemoController implements ListSelectionListener, MouseMotionListener {
    /** 
     * The model of this MVC example 
     */
	private DemoModel model;
	
	/** 
	 * The view of this MVC example 
	 */
	private DemoView view;

	public DemoController(DemoModel model, DemoView view) {
		this.model = model;
		this.view = view;
	}

	/**
	 * Add a point to the model when the user drags the mouse, and
	 * repaint the window.  Need more logic to draw solid lines.
	 */
	public void mouseDragged(MouseEvent event) {
		Point lastPoint = null; // find point
		Point newPoint = event.getLocationOnScreen();
		
		
		// I know this code won't work-- but it's a start
		
		// The idea is to grab the newest point, then find the slope of the last point it remembered
		// Then, use the slope to draw a line from both points.
		// It may be simpler than this, but uhhhh who knows
			//Calculate slope-- draw each point between thisPoint and the last remembered one
			double slope = lastPoint.getY() - newPoint.getY() / lastPoint.getX() - newPoint.getX();
			model.addPoint(new Point((int)newPoint.getY(), (int)newPoint.getX()));
		
		//model.addPoint(newPoint);
		lastPoint = newPoint;
		view.repaint();
		
		// get current point
		// get last point of where it stopped
		// get slope (y= mx+b)
		// draw line of that slope
		
	} // end method mouseDragged

	/**
	 * This method doesn't do anything, but it needs to be
	 * here to implement MouseMotionListener.
	 */
	public void mouseMoved(MouseEvent event) {
	}

	/**
	 * Update the model when the user selects a color, and repaint the 
	 * window.
	 */
	public void valueChanged(ListSelectionEvent event) {
		Color color = view.getSelectedColor();
		model.setSelectedColor(color);
		view.repaint();
	}
}
