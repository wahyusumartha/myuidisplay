package com.framework.ui.component;

import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.container.HorizontalFieldManager;

public class IconContainer extends HorizontalFieldManager {
	/*
	 * PADDING Variable for this Manager
	 */
	private static final int TOP_PADDING = 1;
	private static final int RIGHT_PADDING = 1;
	private static final int BOTTOM_PADDING = 1;
	private static final int LEFT_PADDING = 1;

	/*
	 * SET HEIGHT
	 */
	private int fieldHeight;

	public IconContainer() {
		super(Manager.NO_HORIZONTAL_SCROLL | Manager.NO_VERTICAL_SCROLL);
		setPadding();
		fieldHeight = 50;
	}

	protected void sublayout(int arg0, int arg1) {
		super.sublayout(Display.getWidth(), fieldHeight);
		setExtent(Display.getWidth(), fieldHeight);
	}

	protected void paintBackground(Graphics graphics) {
		/*
		 * Draw Background Color
		 */
		// graphics.setColor(0xa3d1f3);
		// graphics.fillRect(0, 0, Display.getWidth(), 50);

		/*
		 * Draw Border Color
		 */
		graphics.setColor(Color.SILVER);
		graphics.drawRect(1, 0, Display.getWidth()
				- (LEFT_PADDING + RIGHT_PADDING), fieldHeight
				+ (TOP_PADDING + BOTTOM_PADDING));
	}

	/*
	 * Setting Icon Container Height
	 */
	public void setIconContainerHeight(int height) {
		this.fieldHeight = height;
	}

	private void setPadding() {
		setPadding(TOP_PADDING, RIGHT_PADDING, BOTTOM_PADDING, LEFT_PADDING);
	}
}
