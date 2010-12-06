package com.framework.ui.component;

import com.framework.ui.preferences.FontPreference;

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

	/*
	 * PADDING SETTINGS
	 */
	private static final int TOP_PADDING = 5;
	private static final int RIGHT_PADDING = 10;
	private static final int BOTTOM_PADDING = 5;
	private static final int LEFT_PADDING = 20;

	/*
	 * MARGIN SETTING
	 */
	private static final int TOP_MARGIN = 5;
	private static final int RIGHT_MARGIN = 5;
	private static final int BOTTOM_MARGIN = 5;
	private static final int LEFT_MARGIN = 5;

	/*
	 * BORDER TYPE
	 */
	private static final int RECT_BORDER = 0;
	private static final int ROUND_RECT_BORDER = 1;

	private int borderShape = -1;

	/*
	 * Default Constructor
	 */
	public CustomEditField() {
		super();
		fontPreference.setFontPreference("System", Font.PLAIN, 7);
		setFontPreference(fontPreference);
		setPaddingPreference();
		setMarginPreference();
		setBorderShape(0);
	}

	protected void paintBackground(Graphics graphics) {

		switch (borderShape) {
		case RECT_BORDER:
			rectBorder(graphics);
			invalidate();
			break;
		case ROUND_RECT_BORDER:
			roundRectBorder(graphics);
			invalidate();
			break;
		default:
			break;
		}
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

	/*
	 * Drawing ROUND RECT BORDER
	 */
	private void roundRectBorder(Graphics graphics) {
		/*
		 * Fill Round Rectangle in EditField
		 */
		graphics.setColor(backgroundColor);
		graphics.fillRoundRect(10, 0, Display.getWidth()
				- (LEFT_MARGIN + RIGHT_MARGIN + LEFT_PADDING + RIGHT_PADDING),
				getHeight(), 20, 20);

		/*
		 * Drawing RoundRectangle in EditField
		 */
		graphics.setColor(borderColor);
		graphics.drawRoundRect(10, 0, Display.getWidth()
				- (LEFT_MARGIN + RIGHT_MARGIN + LEFT_PADDING + RIGHT_PADDING),
				getHeight(), 20, 20);

		/*
		 * Drawing Font Preference
		 */
		graphics.setColor(foregroundColor);
		super.setFont(getFontPreference());

	}

	/*
	 * Drawing RECT BORDER
	 */
	private void rectBorder(Graphics graphics) {
		/*
		 * Fill Round Rectangle in EditField
		 */
		graphics.setColor(backgroundColor);
		graphics.fillRoundRect(10, 0, Display.getWidth()
				- (LEFT_MARGIN + RIGHT_MARGIN + LEFT_PADDING + RIGHT_PADDING),
				getHeight(), 10, 10);

		/*
		 * Drawing RoundRectangle in EditField
		 */
		graphics.setColor(borderColor);
		graphics.drawRoundRect(10, 0, Display.getWidth()
				- (LEFT_MARGIN + RIGHT_MARGIN + LEFT_PADDING + RIGHT_PADDING),
				getHeight(), 10, 10);

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

	/*
	 * Set Margin Preference
	 */
	private void setMarginPreference() {
		setMargin(TOP_MARGIN, RIGHT_MARGIN, BOTTOM_MARGIN, LEFT_MARGIN);
	}

	/*
	 * Set Border Shape Type
	 * 
	 * @borderShape is Integer Value to set BorderShape
	 * 
	 * @0 == RECT_BORDER
	 * 
	 * @1 == ROUND_RECT_BORDER
	 * 
	 * @Default is RECT_BORDER
	 */
	private void setBorderShape(int borderShape) {
		if (borderShape == -1) {
			/*
			 * Use RECT_BORDER as default
			 */
			this.borderShape = RECT_BORDER;
		} else if (borderShape == 0) {
			this.borderShape = RECT_BORDER;
		} else if (borderShape == 1) {
			this.borderShape = ROUND_RECT_BORDER;
		}
	}
}
