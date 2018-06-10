package model;

import java.awt.Color;

public class NodeFormat {
	private String[] name;
	private String[] parentName;
	private int[] x;
	private int[] y;
	private int[] width;
	private int[] height;
	private Color[] color;
	private int[] depth;
	private int number=0;
	
	public NodeFormat(int i){
		name = new String[i];
		parentName = new String[i];
		x=new int[i];
		y=new int[i]; 
		depth=new int[i];
		width=new int[i];
		height=new int[i];
		color = new Color[i];
		setNumber(i);
	}
	
	public void changeNode(NodeFormat a) {
		int  i=a.getNumber();
		name = new String[i];
		parentName = new String[i];
		x=new int[i];
		y=new int[i]; 
		depth=new int[i];
		width=new int[i]; 
		height=new int[i];
		color = new Color[i];
		setNumber(i);
		
		this.name = a.getNames();
		this.parentName = a.getParentNames();
		this.x = a.getXs();
		this.y=a.getYs();
		this.width = a.getWidths();
		this.height = a.getHeights();
		this.color = a.getColors();
		this.depth=a.getDepths();
		this.number=a.number;
	}
	
	public void extendNode(String a, String b, int c, int d, int e, int f,int de, Color g) {
		int newNumber=number+1;
		String[] newName = new String[newNumber];
		String[] newParentName = new String[newNumber];
		int[] newX=new int[newNumber];
		int[] newY=new int[newNumber]; 
		int[] newDepth=new int[newNumber];
		int[] newWidth=new int[newNumber]; 
		int[] newHeight=new int[newNumber];
		Color[] newColor = new Color[newNumber];
		
		System.arraycopy(this.name, 0, newName, 0, number);
		System.arraycopy(this.parentName, 0, newParentName, 0, number);
		System.arraycopy(this.x, 0, newX, 0, number);
		System.arraycopy(this.y, 0, newY, 0, number);
		System.arraycopy(this.width, 0, newWidth, 0, number);
		System.arraycopy(this.height, 0, newHeight, 0,number);
		System.arraycopy(this.depth, 0, newDepth, 0, number);
		System.arraycopy(this.color, 0, newColor, 0, number);
		
		newName[number] = a;
		newParentName[number] = b;
		newX[number] = c;
		newY[number] = d;
		newWidth[number] = e;
		newHeight[number] = f;
		newDepth[number] = de;
		newColor[number] = g;
		
		this.name = newName;
		this.parentName = newParentName;
		this.x = newX;
		this.y= newY;
		this.width = newWidth;
		this.height = newHeight;
		this.color = newColor;
		this.depth= newDepth;
		this.number=newNumber;
	}
	
	private int[] getDepths() {
		return depth;
	}
	
	public String[] getNames() {
		return name;
	}
	
	public String[] getParentNames() {
		return parentName;
	}
	
	public int[] getXs() {
		return x;
	}
	
	public int[] getYs() {
		return y;
	}
	
	public int[] getWidths() {
		return width;
	}
	
	public int[] getHeights() {
		return height;
	}
	
	public Color[] getColors() {
		return color;
	}
	
	public int getX(int i) {
		return x[i];
	}
	
	public void setX(int i,int x) {
		this.x[i] = x;
	}
	
	public int getY(int i) {
		return y[i];
	}
	
	public void setY(int i,int y) {
		this.y[i] = y;
	}
	
	public int getWidth(int i) {
		return width[i];
	}
	
	public void setWidth(int i,int width) {
		this.width[i] = width;
	}
	
	public int getHeight(int i) {
		return height[i];
	}
	
	public void setHeight(int i,int height) {
		this.height[i] = height;
	}
	
	public Color getColor(int i) {
		return color[i];
	}
	
	public void setColor(int i,Color color) {
		this.color[i] = color;
	}

	public String getName(int i) {
		return name[i];
	}

	public void setName(int i,String name) {
		if(name.charAt(name.length()-1)=='\n')
			name=name.substring(0, name.length()-1);
		this.name[i] = name;
		
	}

	public String getParentName(int i) {
		return parentName[i];
	}

	public void setParentName(int i,String parentName) {
		this.parentName[i] = parentName;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getDepth(int i) {
		return depth[i];
	}
	
	public void setDepth(int i, int depth) {
		this.depth[i] = depth;
	}
}