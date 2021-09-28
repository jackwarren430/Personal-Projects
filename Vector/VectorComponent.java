import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.lang.Math;

public class VectorComponent extends JComponent{
	public static int density = 30;
	private Vector[][] test;

	public VectorComponent(){
		test = new Vector[density][density * 2];

		for (int i = 0; i < density; i++){
  			for (int j = 0; j < density*2; j++){
  				int xPos = (VectorFrame.WIDTH/(density*2)) * (j);
  				int yPos = (VectorFrame.HEIGHT/density) * (i);
  				test[i][j] = new Vector(xPos, yPos , 40);
  				
  			}
  		}
	}

	/*
int x = me.getX()-test[i][j].getxLoc();
  					int y = me.getY() - test[i][j].getyLoc();
  					if (Math.sqrt(x*x + y*y) > test[i][j].getScal()){
	*/

  	public int getxLoc(int i, int j){
  		return test[i][j].getxLoc();
  	}

  	public int getyPoint(int i, int j){
  		return test[i][j].getYPoint();
  	}

  	public int getyLoc(int i, int j){
  		return test[i][j].getyLoc();
  	}

  	public double getScal(int i, int j){
  		return test[i][j].getScal();
  	}
	public void changePoints(int i, int j, int x, int y){
		test[i][j].changePoints(x, y);
	}

	public void changePoints2(int i, int j, int x, int y){
		test[i][j].changePoints2(x, y);
	}

	public void paintComponent(Graphics g){
		for (Vector[] row : test){
			for (Vector v : row){
				v.draw(g);
			}
		}
	}

}