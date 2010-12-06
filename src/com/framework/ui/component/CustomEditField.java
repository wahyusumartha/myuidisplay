package com.framework.ui.component;

import com.framework.ui.preferences.FontPreference;

import net.rim.device.api.i18n.ResourceBundleFamily;
import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.component.EditField;

public class CustomEditField extends EditField {

	private FontPreference fontPreference;

	private int backgroundColor = Color.WHITE;
	private int borderColor = Color.SILVER;
	private int foregroundColor = Color.BLACK;

	private static final int TOP_PADDING = 5;
	private static final int RIGHT_PADDING = 10;
	private static final int BOTTOM_PADDING = 5;
	private static final int LEFT_PADDING = 20;

	/*
	 * Default Constructor
	 */
	public CustomEditField() {
		super();
		fontPreference.setFontPreference("System", Font.PLAIN, 7);
		setFontPreference(fontPreference);
		setPaddingPreference();
	}

	protected void paintBackground(Graphics graphics) {
		roundRectBorder(graphics);

	}

	public boolean isFocus() {
		return true;
	}

	protected void onFocus(int direction) {
		borderColor = Color.ORANGE;
		invalidate();
	}

	protected void onUnfocus() {
		borderColor = Color.SILVER;
		invalidate();
	}

	private void roundRectBorder(Graphics graphics) {
		/*
		 * Fill Round Rectangle in EditField
		 */
		graphics.setColor(backgroundColor);
		graphics.fillRoundRect(10, 0, Display.getWidth() - 20, getHeight(), 10,
				10);

		/*
		 * Drawing RoundRectangle in EditField
		 */
		graphics.setColor(borderColor);
		graphics.drawRoundRect(10, 0, Display.getWidth() - 20, getHeight(), 10,
				10);

		/*
		 * Drawing Font Preference
		 */
		graphics.setColor(foregroundColor);
		super.setFont(getFontPreference());

	}

	/*
	 * Set Font Preference
	 */
	private void setFontPreference(FontPreference fontPreference) {
		this.fontPreference = fontPreference;
	}

	/*
	 * Get Font Preference
	 */
	private Font getFontPreference() {
		return fontPreference.getFontPreference();
	}

	/*
	 * Set Padding Preference
	 */
	private void setPaddingPreference() {
		setPadding(TOP_PADDING, RIGHT_PADDING, BOTTOM_PADDING, LEFT_PADDING);

	}
}
