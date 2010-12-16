package com.framework.ui.component;

import java.util.Vector;

import com.framework.test.model.Post;
import com.framework.ui.preferences.FontPreference;

import net.rim.device.api.system.Display;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Manager;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.ListField;
import net.rim.device.api.ui.component.ListFieldCallback;

public class CustomListFieldTextPhoto extends ListField implements
		ListFieldCallback {

	/*
	 * Preparing component that would be fill in a manager
	 */
	private String statusText;
	private String likeText;
	private String commentText;

	private LabelField statusTextLabel;
	private LabelField likeTextLabel;
	private LabelField commentTextLabel;

	/*
	 * Vector Container for every rows
	 */
	private Vector rows;

	/*
	 * Font Preference
	 */
	private FontPreference fontPreference;

	private TableRowManager rowManager;

	public CustomListFieldTextPhoto() {
		super();
		// setRowHeight(50);
		setCallback(this);
		rows = new Vector();
	}

	/*
	 * Starting Implement ListField Callback
	 */
	public void drawListRow(ListField listField, Graphics graphics, int index,
			int y, int width) {
		rowManager = new TableRowManager();
		if (index < rows.size()) {

			int rowHeight = 0;
			/*
			 * This Line Just For Purpose Testing
			 */
			Post post = (Post) rows.elementAt(index);

			fontPreference.setFontPreference("System", Font.PLAIN, 5);
			graphics.setFont(fontPreference.getFontPreference());

			statusText = post.getStatus();
			commentText = post.getComment() + "Comments";

			int totalWidth = fontPreference.getFontPreference().getAdvance(
					statusText);
			// + fontPreference.getFontPreference().getAdvance(likeText);
			int totalHeight = fontPreference.getFontPreference().getHeight();

			if (totalWidth < Display.getWidth()) {
				rowHeight = totalHeight * 10;
			} else {
				int temporaryHeight = fontPreference.getFontPreference()
						.getAdvance(statusText);
				rowHeight = totalWidth * (totalWidth / Display.getWidth());
			}

			statusTextLabel = new LabelField();
			statusTextLabel.setFont(fontPreference.getFontPreference());
			statusTextLabel.setText(statusText);

			rowManager.add(statusTextLabel);

			commentTextLabel = new LabelField();
			commentTextLabel.setFont(fontPreference.getFontPreference());
			commentTextLabel.setText(commentText + " : ");
			rowManager.add(commentTextLabel);

			// listField.setRowHeight(index, rowHeight);

			rowManager.drawRow(graphics, 0, y + 1, width, rowHeight);

		}

	}

	public Object get(ListField listField, int index) {
		if (index < rows.size()) {
			return rows.elementAt(index);
		}
		return null;
	}

	public int getPreferredWidth(ListField listField) {
		return Display.getWidth() - 2;
	}

	public int indexOfList(ListField listField, String prefix, int start) {
		for (int i = 0; i < rows.size(); i++) {
			Object object = rows.elementAt(i);
			if (object.toString().indexOf(prefix) > -1) {
				return i;
			}
		}
		return -1;
	}

	/*
	 * End of Implement ListFieldCallBack
	 */

	/*
	 * Methods Handle Data in a Vector
	 */
	public void add(Object object) {
		rows.addElement(object);
	}

	public void clear() {
		rows.removeAllElements();
	}

	public void insert(Object object, int index) {
		rows.insertElementAt(object, index);
	}

	/*
	 * End of Methods to Handle Data in Vector
	 */

	private class TableRowManager extends Manager {

		public TableRowManager() {
			super(VERTICAL_SCROLL);
		}

		/*
		 * Arrange This manager's controlled fields from left to rightwithin the
		 * enclosing table's column
		 */
		protected void sublayout(int width, int height) {

			/*
			 * Status Text Field Placement
			 */
			Field field = getField(0);
			layoutChild(field, getPreferredWidth(), getPreferredHeight());
			setPositionChild(field, 0, 0);

			/*
			 * Comment Text Field Placement
			 */
			field = getField(1);
			layoutChild(field, getPreferredWidth(), getPreferredHeight());
			setPositionChild(field, 0, getField(0).getHeight() + 1);

			/*
			 * Set Width and Height this manager
			 */
			setExtent(getPreferredWidth(), getPreferredHeight());

		}

		/*
		 * Cause the fields within this row manager to be layed out then painted
		 */
		public void drawRow(Graphics graphics, int x, int y, int width,
				int height) {
			// arrange the cell with this layout
			layout(width, height);

			// Place this row manager with its enclosing list
			setPosition(x, y);

			// Apply translating/clipping transformation to the graphics
			// context so that this row paints in the right area
			graphics.pushRegion(getExtent());

			// paint this manager
			subpaint(graphics);

			graphics.setColor(0x00CACACA);
			graphics.drawLine(0, 0, getPreferredWidth(), 0);

			// Restore the graphics context
			graphics.popContext();

		}

		public int getPreferredHeight() {
			return Graphics.getScreenHeight();
		}

		public int getPreferredWidth() {
			return Graphics.getScreenWidth();
		}

	}

}
