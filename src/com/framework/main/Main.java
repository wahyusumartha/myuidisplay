package com.framework.main;

import com.framework.ui.screen.HomeScreen;

import net.rim.device.api.ui.UiApplication;

public class Main extends UiApplication {

	public Main() {
		HomeScreen homeScreen = new HomeScreen();
		pushScreen(homeScreen);
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.enterEventDispatcher();
	}

}
