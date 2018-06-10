package model;

import java.awt.Color;

public class PaneInfo {

	private Color fontColor;
	private Color color;
	private String font;
	private int fontSize;
	public PaneInfo(Color background, String font, int fontSize,Color color){
		this.color=color;
		this.fontColor=background;
		this.font = font;
		this.fontSize=fontSize;
	}
	
	public Color getfontColor() {
		return this.fontColor;
	}
	
	public void setfontColor(Color fontColor) {
		this.fontColor=fontColor;
	}
	
	public String getFont() {
		return font;
	}
	
	public void setFont(String font) {
		this.font = font;
	}
	
	public int getFontSize() {
		return fontSize;
	}
	
	public void setFontSize(int fontSize){
		this.fontSize=fontSize;
	}

	public Color getColor() {
		return color;
	}
	
	public void setColor(Color a) {
		this.color=a;
	}
}