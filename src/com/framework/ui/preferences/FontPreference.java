package com.framework.ui.preferences;

import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.FontFamily;
import net.rim.device.api.ui.Ui;

public class FontPreference {
	private static Font preferredFont;
	private static FontFamily preferredFontFamily;

	/*
	 * Set Your Font Preference
	 * 
	 * @name Font Name
	 * 
	 * @style Font Style
	 * 
	 * @height Font Size
	 */
	public static void setFontPreference(String name, int style, int height) {
		try {
			preferredFontFamily = FontFamily.forName(name);
			preferredFont = preferredFontFamily.getFont(style, height,
					Ui.UNITS_pt);
		} catch (ClassNotFoundException e) {
			System.out.println("Error : ClassNotFoundException : "
					+ e.getMessage());
		}
	}

	public static Font getFontPreference() {
		return preferredFont;
	}
}
