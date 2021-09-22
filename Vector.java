import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.lang.Math;

public class Vector extends JComponent{
	private int xLoc, yLoc;
	private int scal;
	private int xPoint, yPoint;
	private double rotation;


	public Vector(int xLoc, int yLoc){
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		rotation = 0;
		this.scal = 50;
		changePoint();
	}

	public Vector(int xLoc, int yLoc, double rotation){
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.rotation = rotation;
		this.xScal = 50;
		this.yScal = 50;
		changePoints();
	}

	public void changePoints(){
		xPoint = scal * (int) Math.round(Math.sin(rotation));
		yPoint =  (scal * (int) Math.round(Math.cos(rotation)));
	}

	public void setRotation(double rotation){
		this.rotation = rotation;
	}

	public void setScal(int scal){
		this.scal = scal;
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

	public void paintComponent(Graphics g){
		Graphics2D pen = (Graphics2D) g;

		Point2D.Double origin = new Point2D.Double(xLoc, yLoc);
      	Point2D.Double point = new Point2D.Double(xLoc + xPoint, yLoc + yPoint);
      	Line2D.Double line = new Line2D.Double(origin, point);
      	pen.draw(line);
	}
}










