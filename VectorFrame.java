import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.lang.Math;

public class VectorFrame extends JFrame{
	private Timer t;
	private Vector test;

	public static final int WIDTH = 1300;
	public static final int HEIGHT = 700;

	private JFrame thisFrame = this;

	public VectorFrame(){
		this.setSize(WIDTH, HEIGHT + 25);
		this.setTitle("Visuals");
		addComponents();		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	this.setVisible(true);
  	}

  	public void go(){
  		t.start();
  	}

  	public void addComponents(){
  		test = new Vector(WIDTH/2, HEIGHT/2, 45);
		this.add(test);

		t = new Timer(10, new MovementListener());
		this.addMouseMotionListener(new MouseMovementListener());
  		this.setFocusable(true);
  	}

  	class MouseMovementListener implements MouseMotionListener{
  		public void mouseMoved(MouseEvent me){
  			double rotation = Math.atan(-(me.getY()-test.getyLoc()) / (me.getX() - test.getxLoc()));
        	
        	if ((me.getX() - test.getxLoc()) < 0){
        		if (-(me.getY()-test.getyLoc()) < 0){
        			//3 quadrant
        			rotation -= Math.PI;
        		} else {
        			//2 quadrant
        			rotation += Math.PI/2;
        		}
        	} else {
        		if (-(me.getY()-test.getyLoc()) < 0){
        			//4 quadrant
        			rotation -= 2*Math.PI;
        		} else {
        			//1 quadrant
        		
        		}
        	}
        	
        	test.setRotation(rotation);
      		test.changePoints();
      	}
      	public void mouseDragged(MouseEvent me){
      		test.changePoints();
      	}
  	}

  	class MovementListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
        	repaint();
    	}
   	}
	
}