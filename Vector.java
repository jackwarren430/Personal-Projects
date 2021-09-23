import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.lang.Math;

public class Vector{
	private int xLoc, yLoc;
	private double scal;
	private int xPoint, yPoint;

	public Vector(int xLoc, int yLoc){
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.scal = 70;
		changePoints(1, 1);
	}

	public void changePoints(int x, int y){
		double magnitude  = Math.sqrt(x*x + y*y);
		double xUnit = x/magnitude;
		double yUnit = y/magnitude;
		xPoint = (int) Math.round(scal * xUnit);
		yPoint = (int) Math.round(scal * yUnit);
	}
	public void changePoints2(int x, int y){
		xPoint = x;
		yPoint = y;
	}


	public void setScal(double scal){
		this.scal = scal;
	}

	public double getScal(){
		return scal;
	}

	public void setLoc(int xLoc, int yLoc){
		this.xLoc = xLoc;
		this.yLoc = yLoc;
	}

	public int getxLoc(){
		return xLoc;
	}

	public int getyLoc(){
		return yLoc;
	}

	public void draw(Graphics g){
		Graphics2D pen = (Graphics2D) g;

		Point2D.Double origin = new Point2D.Double(xLoc, yLoc);
      	Point2D.Double point = new Point2D.Double(xLoc + xPoint, yLoc + yPoint);
      	Line2D.Double line = new Line2D.Double(origin, point);
      	pen.draw(line);
	}
}










