package net.itarray.sikuli.api.visual;

import net.itarray.sikuli.api.DesktopScreenRegion;

/**
 * The DesktopCanvas class represents a canvas (frame) to be displayed on a screen region.
 *
 */
public class DesktopCanvas extends ScreenRegionCanvas {
	/**
	 * Constructs a new DesktopCanvas whose screen region
	 * is in full screen, and whose screen is the default screen (i.e., screen 0)
	 */
	public DesktopCanvas() {
		super(new DesktopScreenRegion());
	}
	
	public DesktopCanvas(int id) {
		super(new DesktopScreenRegion(id));
	}


}
