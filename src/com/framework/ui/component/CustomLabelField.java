/*
 *  CustomLabelField.java 
 * UI Framework for Blackberry
 * by : Wahyu Sumartha
 * Date : 6 December 2012
 */
package com.framework.ui.component;

import com.framework.ui.preferences.FontPreference;

import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.Graphics;

public class CustomLabelField extends Field {

	private FontPreference fontPreference;

	/*
	 * Font Costumization
	 */
	private static final String FONT_NAME = "BBSerif";
	private static final int FONT_STYLE = Font.PLAIN;
	private static final int FONT_HEIGHT = 7;

	/*
	 * Color Setting
	 */
	private int textColor = 0x424546;
	private int embossedColor = Color.GRAY;

	/*
	 * Label Width and Height
	 */
	private int labelWidth;
	private int labelHeight;

	/*
	 * Custom Label Style Setting
	 * 
	 * @Emboss or Original
	 */
	private static final int ORIGINAL_STYLE = 0;
	private static final int EMBOSSED_STYLE = 1;

	private String text;

	private int preferredLabelStyle = -1;

	public CustomLabelField(String text) {
		fontPreference.setFontPreference(FONT_NAME, FONT_STYLE, FONT_HEIGHT);
		setLabelStyle(0);
		setFontPreference(fontPreference);
		this.text = text;
		labelHeight = getFontPreference().getHeight();
		labelWidth = getFontPreference().getAdvance(this.text);
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

	public int getPreferredHeight() {
		return labelHeight;
	}

	public int getPreferredWidth() {
		return labelWidth;
	}

	protected void layout(int width, int height) {
		setExtent(getPreferredWidth(), getPreferredHeight());

	}

	protected void paint(Graphics graphics) {
		switch (preferredLabelStyle) {
		case ORIGINAL_STYLE:
			drawOriginalColor(graphics);
			break;
		case EMBOSSED_STYLE:
			drawEmbossedStyle(graphics);
			break;
		default:
			break;
		}
	}

	public void setText(String text) {
		this.text = text;
	}

	/*
	 * Draw Original Style Label (without embossed)
	 */
	private void drawOriginalColor(Graphics graphics) {
		graphics.setFont(getFontPreference());

		graphics.setColor(textColor);
		graphics.drawText(this.text, 0, 0);
	}

	/*
	 * Draw Embossed Style Label
	 */
	private void drawEmbossedStyle(Graphics graphics) {
		graphics.setFont(getFontPreference());

		/*
		 * Draw embossed Style
		 */
		graphics.setColor(textColor);
		graphics.drawText(this.text, 0, 0 - 2);

		/*
		 * Draw Foreground Color
		 */
		graphics.setColor(embossedColor);
		graphics.drawText(this.text, 0, 0);

	}

	/*
	 * Set Preferred Label Style
	 */
	private void setLabelStyle(int labelStyle) {
		if (labelStyle == -1) {
			this.preferredLabelStyle = 0;
		} else if (labelStyle == 0) {
			this.preferredLabelStyle = ORIGINAL_STYLE;
		} else if (labelStyle == 1) {
			this.preferredLabelStyle = EMBOSSED_STYLE;
		}

	}

}
