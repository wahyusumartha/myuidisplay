package com.framework.ui.component;

import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.Graphics;

public class CustomObjectChoiceField extends Field {

	/*
	 * Setting Height and Width Size
	 */
	private int fieldHeight;
	private int fieldWidth;

	/*
	 * Component Margin
	 */
	private static final int TOP_MARGIN = 2;
	private static final int LEFT_MARGIN = 2;
	private static final int BOTTOM_MARGIN = 2;
	private static final int RIGHT_MARGIN = 2;

	/*
	 * Component Padding
	 */
	private static final int TOP_PADDING = 2;
	private static final int LEFT_PADDING = 2;
	private static final int BOTTOM_PADDING = 2;
	private static final int RIGHT_PADDING = 2;

	/*
	 * Color Setting
	 */
	private int backgroundColor = Color.WHITE;
	private int foregroundColor = Color.WHITE;
	private int borderColor = Color.SILVER;

	private String text;

	public CustomObjectChoiceField(String text) {
		this.text = text;
	}

	protected void layout(int width, int height) {
		// TODO Auto-generated method stub

	}

	protected void paint(Graphics graphics) {
		// TODO Auto-generated method stub

	}

	public int getPreferredHeight() {
		// TODO Auto-generated method stub
		return super.getPreferredHeight();
	}

	public int getPreferredWidth() {
		// TODO Auto-generated method stub
		return super.getPreferredWidth();
	}

	private void setPreferencePadding() {
		setPadding(TOP_PADDING, RIGHT_PADDING, BOTTOM_PADDING, LEFT_PADDING);
	}

	private void setPreferenceMargin() {
		setMargin(TOP_MARGIN, RIGHT_MARGIN, BOTTOM_MARGIN, LEFT_MARGIN);
	}

}
