package net.itarray.sikuli.api.visual.element;

import edu.umd.cs.piccolo.PNode;

import javax.swing.event.EventListenerList;
import java.awt.*;
import java.util.EventListener;

/**
 * Element is an abstraction for objects to be displayed on the screen.
 *
 */
public class Element {
	/**
	 * The vertical alignment of the Element.
	 */
	public enum VerticalAlignment {
		/**
		 * Vertical alignment at the top.
		 */
		TOP,
		/**
		 * Vertical alignment in the middle.
		 */
		MIDDLE,
		/**
		 * Vertical alignment at the bottom.
		 */
		BOTTOM
	};
	/**
	 * The horizontal alignment of the Element.
	 */
	public enum HorizontalAlignment {
		/**
		 * Horizontal alignment on the left.
		 */
		LEFT,
		/**
		 * Horizontal alignment at the center.
		 */
		CENTER,
		/**
		 * Horizontal alignment on the right.
		 */
		RIGHT
	};	
	
	public int x;
	public int y;
	public int width;
	public int height;	

	private Color lineColor = Color.red;
	private Color color = Color.black;
	private Color backgroundColor = Color.yellow;
	private int lineWidth = 2;
	private float fontSize = 12;
	public VerticalAlignment verticalAlignment = VerticalAlignment.TOP;
	public HorizontalAlignment horizontalAlignment = HorizontalAlignment.LEFT;
	private float transparency = 1f;
	/**
	 * Creates a new PNode, the central abstraction in Piccolo.
	 * 
	 * @return a new PNode object.
	 * @see PNode
	 */
	public PNode createPNode(){
		return new PNode();
	}
	/**
	 * Returns the Color of this Element.
	 * 
	 * @return the Color of this Element.
	 */
	public Color getColor() {
		return color;
	}
	/**
	 * Sets the color of this Element
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	/**
	 * Returns the line color of this Element.
	 * 
	 * @return the line color of this Element.
	 */
	public Color getLineColor() {
		return lineColor;
	}
	/**
	 * Sets the line color of this Element.
	 * 
	 * @param lineColor the specified the line color.
	 */
	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}
	/**
	 * Returns the background color of this Element.
	 * 
	 * @return the background color of this Element.
	 */
	public Color getBackgroundColor() {
		return backgroundColor;
	}
	/**
	 * Sets the background color of this Element.
	 * 
	 * @return the background color of this Element.
	 */
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	/**
	 * Returns the line width of this Element in points.
	 * 
	 * @return the line width of this Element.
	 */
	public int getLineWidth() {
		return lineWidth;
	}
	/**
	 * Sets the line width of this Element in points.
	 * 
	 * @param lineWidth the specified line width in points.
	 */
	public void setLineWidth(int lineWidth) {
		this.lineWidth = lineWidth;
	}
	/**
	 * Returns the font size of this Element in points.
	 * 
	 * @return the font size of this Element.
	 */
	public float getFontSize() {
		return fontSize;
	}
	/**
	 * Sets the font size of this Elements in points.
	 * 
	 * @param fontSize the font size in points.
	 */
	public void setFontSize(float fontSize) {
		this.fontSize = fontSize;
	}
	/**
	 * Returns the transparency (alpha component) value of this Element.
	 * 
	 * @return the transparency value of this Element.
	 */
	public float getTransparency() {
		return transparency;
	}
	/**
	 * Sets the transparency (alpha component) value of this Element.
	 * 
	 * @param transparency the specified transparency value [0..1].
	 */
	public void setTransparency(float transparency) {
		this.transparency = transparency;
	}
	

	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
		fireMoved(x,y);
	}
	
	public interface Listener extends EventListener {
		public void moved(int x, int y);
	}
	
	EventListenerList listenerList = new EventListenerList();
	public void addListener(Listener l) {
		listenerList.add(Listener.class, l);
	}

	public void removeListener(Listener l) {
		listenerList.remove(Listener.class, l);
	}
	
	protected void fireMoved(int x, int y) {
		// Guaranteed to return a non-null array
		Object[] listeners = listenerList.getListenerList();
		// Process the listeners last to first, notifying
		// those that are interested in this event
		for (int i = listeners.length-2; i>=0; i-=2) {
			if (listeners[i]==Listener.class) {
				// Lazily create the event:
				((Listener)listeners[i+1]).moved(x, y);
			}
		}
	}
	
	
	public ElementStyleSetter styleWith(){
		return new ElementStyleSetter(this);
	}
}

