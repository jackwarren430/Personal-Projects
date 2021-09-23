import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.lang.Math;

public class VectorComponent extends JComponent{
	
	private Vector[][] test;

	public VectorComponent(){

		test = new Vector[10][20];

		for (int i = 0; i < 10; i++){
  			for (int j = 0; j < 20; j++){
  				test[i][j] = new Vector((VectorFrame.WIDTH/20) * (j), (VectorFrame.HEIGHT/10) * (i));
  				
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