package com.framework.ui.screen;

import com.framework.ui.component.CustomEditField;
import com.framework.ui.component.CustomLabelField;
import com.framework.ui.component.IconButton;
import com.framework.ui.component.IconContainer;
import com.framework.ui.preferences.FontPreference;

import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.container.VerticalFieldManager;

public class HomeScreen extends MainScreen implements FieldChangeListener {

	private CustomEditField customEditField = new CustomEditField();
	private CustomLabelField customLabelField = new CustomLabelField(
			"Selamat Datang");

	IconButton iconButton1 = new IconButton("tweet-blue.png");
	IconButton iconButton2 = new IconButton("tweet-blue.png");
	IconButton iconButton3 = new IconButton("NeedleWhite.png");

	public HomeScreen() {
		VerticalFieldManager verticalFieldManager = new VerticalFieldManager();
		ButtonField button = new ButtonField("Default Button");

		verticalFieldManager.add(customEditField);
		verticalFieldManager.add(button);
		verticalFieldManager.add(customLabelField);

		HorizontalFieldManager horizontalFieldManager = new HorizontalFieldManager() {

			protected void paint(Graphics graphics) {
				graphics.setColor(0xa3d1f3);
				graphics.fillRect(0, 0, Display.getWidth(), 50);
				super.paint(graphics);
			}

		};
		iconButton1.setChangeListener(this);
		iconButton2.setChangeListener(this);
		// horizontalFieldManager.add(iconButton1);
		// horizontalFieldManager.add(iconButton2);
		// horizontalFieldManager.add(iconButton3);
		IconContainer iconContainer = new IconContainer();
		iconContainer.add(iconButton1);
		iconContainer.add(iconButton2);
		iconContainer.add(iconButton3);
		add(verticalFieldManager);
		 add(iconContainer);
		//add(horizontalFieldManager);
	}

	public void fieldChanged(Field field, int context) {
		if (field == iconButton1) {
			Dialog.alert("Hallo this is iconbutton1");
		} else if (field == iconButton2) {
			Dialog.alert("Hallo this is iconbutton 2");
		}

	}
}
