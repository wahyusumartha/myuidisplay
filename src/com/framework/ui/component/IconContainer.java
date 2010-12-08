package com.framework.ui.component;

import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.container.HorizontalFieldManager;

public class IconContainer extends HorizontalFieldManager {

	public IconContainer() {
		super(Manager.NO_HORIZONTAL_SCROLL | Manager.NO_VERTICAL_SCROLL);
	}

	protected void sublayout(int arg0, int arg1) {
		super.sublayout(Display.getWidth(), 50);
		setExtent(Display.getWidth(), 50);
	}

	protected void paintBackground(Graphics graphics) {
		graphics.setColor(0xa3d1f3);
		graphics.fillRect(0, 0, Display.getWidth(), 50);

	}

}
