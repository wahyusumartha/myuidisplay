package com.framework.ui.screen;

import com.framework.ui.component.CustomEditField;
import com.framework.ui.preferences.FontPreference;

import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.MainScreen;

public class HomeScreen extends MainScreen {

	private CustomEditField customEditField = new CustomEditField();
	private FontPreference fontPreference;

	public HomeScreen() {
		HorizontalFieldManager horizontalFieldManager = new HorizontalFieldManager();
		horizontalFieldManager.add(customEditField);
		ButtonField button = new ButtonField();
		horizontalFieldManager.add(button);
		add(horizontalFieldManager);
	}
}
