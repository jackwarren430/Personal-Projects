import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.lang.Math;

public class VectorFrame extends JFrame{
	private Timer t;

	public static final int WIDTH = 1300;
	public static final int HEIGHT = 700;

	private JFrame thisFrame = this;
	private VectorComponent comp;

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
  		comp = new VectorComponent();
  		this.add(comp);

		t = new Timer(10, new MovementListener());
		this.addMouseMotionListener(new MouseMovementListener());
  		this.setFocusable(true);
  	}

  	class MouseMovementListener implements MouseMotionListener{
  		public void mouseMoved(MouseEvent me){
  			
  			for (int i = 0; i < VectorComponent.density; i++){
  				for (int j = 0; j < VectorComponent.density*2; j++){
  					int x = me.getX()-comp.getxLoc(i, j);
  					int y = me.getY() - comp.getyLoc(i, j) - 25;
  					if (Math.sqrt(x*x + y*y) > comp.getScal(i, j)){
  						comp.changePoints(i, j, x, y);
  					} else {
  						comp.changePoints2(i, j, x, y);
  					}
  				}
  			}
      		
      	}
      	public void mouseDragged(MouseEvent me){
      		
      	}
  	}
  	//not working
  	public void simpleWave(){
  		while (true){
	  		for (int i = 0; i < VectorComponent.density; i++){
	  			for (int j = 0; j < VectorComponent.density * 2; j++){
					int x = comp.getxLoc(i, j) + 100;
					int dy = 1;
					if (comp.getyPoint(i, j) - comp.getyLoc(i, j) >= 100){
						dy = -1;
					} else if (comp.getyPoint(i, j) - comp.getyLoc(i, j) <= -100){
						dy = 1;
					} else if (comp.getyPoint(i, j) - comp.getyLoc(i, j) > 0 ){
						dy = -1;
					} else if (comp.getyPoint(i, j) - comp.getyLoc(i, j) < 0){
						dy = 1;
					}
					int y = comp.getyPoint(i, j) + dy;
					
					comp.changePoints(i, j, x, y);
	  			}
	  		}
  		}
  	}

  	class MovementListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
        	repaint();
    	}
   	}
	
}