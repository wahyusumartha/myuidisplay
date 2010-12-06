package com.framework.ui.screen;

import com.framework.ui.component.CustomEditField;
import com.framework.ui.preferences.FontPreference;

import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.container.VerticalFieldManager;

public class HomeScreen extends MainScreen {

	private CustomEditField customEditField = new CustomEditField();

	public HomeScreen() {
		VerticalFieldManager verticalFieldManager = new VerticalFieldManager();
		ButtonField button = new ButtonField("Default Button");

		verticalFieldManager.add(customEditField);
		verticalFieldManager.add(button);

		add(verticalFieldManager);
	}
}
