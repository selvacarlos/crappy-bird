import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Iterator;
import java.awt.Graphics;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;

class View extends JPanel
{
	//JButton b1;
	/*Image bird_image;
	Image bird_image2;
	Image tube_up;
	Image tube_down;*/
	Image heart_1;
	Image heart_2;
	Image heart_3;
	Image heart_4;
	Image hand_1;
	Image hand_2;
	Model model;
	Bird bird;
	Tube tube;
	int k = 4;
	int z = 0;
	int count = 0;
	int regen = 0;
	int handspeed;
	int hand = -100;
	View(Controller c, Model m)
	{
		c.setView(this);
		model = m;
		//b1 = new JButton("Never push me");
		//b1.addActionListener(c);
		//this.add(b1);
		
		/*try
		{
			this.bird_image =
				ImageIO.read(new File("bird1.png"));
		} catch(Exception e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}
		
		try
		{
			this.bird_image2 =
				ImageIO.read(new File("bird2.png"));
		} catch(Exception e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}
		
		try
		{
			this.tube_up =
				ImageIO.read(new File("tube_up.png"));
		} catch(Exception e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}
		
		try
		{
			this.tube_down =
				ImageIO.read(new File("tube_down.png"));
		} catch(Exception e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}*/
		try
		{
			this.heart_4 =
				ImageIO.read(new File("heart_4.png"));
		} catch(Exception e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}
		try
		{
			this.heart_3 =
				ImageIO.read(new File("heart_3.png"));
		} catch(Exception e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}
		try
		{
			this.heart_2 =
				ImageIO.read(new File("heart_2.png"));
		} catch(Exception e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}
		try
		{
			this.heart_1 =
				ImageIO.read(new File("heart_1.png"));
		} catch(Exception e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}
		try
		{
			this.hand_1 =
				ImageIO.read(new File("hand1.png"));
		} catch(Exception e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}
		try
		{
			this.hand_2 =
				ImageIO.read(new File("hand2.png"));
		} catch(Exception e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}
	
	/*void removeButton()
	{
		this.remove(b1);
		this.repaint();
	}*/
	
	public void paintComponent(Graphics g)
	{
		g.setColor(new Color(128, 255, 255));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		if (model.bird.counter > k)
		{
			g.drawImage(Bird.bird_1, model.bird.bird_x, model.bird.bird_y, null);
		}
		else
			g.drawImage(Bird.bird_2, model.bird.bird_x, model.bird.bird_y, null);
		
		Iterator<Tube> iterator = model.tubes.iterator();
		while(iterator.hasNext())
		{
			Tube T = iterator.next();
			if (T.tube_y > 0)
			{
				g.drawImage(Tube.tube_1, T.tube_x, T.tube_y, null);
			}
			else 
			{
				g.drawImage(Tube.tube_2, T.tube_x, T.tube_y, null);
			}
			hitBox(T.tube_x, T.tube_y);
		}
		
		z++;
		regen++;
		try{
			createTube();
		} catch (IOException e){
			e.printStackTrace();
		}
		
		if(count < 20)
		{
			g.drawImage(this.heart_4, 1, 1, null);
			if(regen > 40)
			{
				count = 0;
			}
		}
		else if(count < 40)
		{
			g.drawImage(this.heart_3, 1, 1, null);
			if(regen > 40)
			{
				count = 0;
				regen = 0;
			}
		}
		else if(count < 60)
		{
			g.drawImage(this.heart_2, 1, 1, null);
			if(regen > 40)
			{
				count = 0;
				regen = 0;
			}
		}
		else if(count < 80)
		{
			g.drawImage(this.heart_1, 1, 1, null);
			if(regen > 40)
			{
				count = 0;
				regen = 0;
			}
		}
		else if(count > 80)
		{
			if(hand < 0 && model.bird.bird_y > 20 )
			{
				handspeed = 10;
				g.drawImage(this.hand_1, 0, model.bird.bird_y - hand, null);
				hand += 10;
			} else if(model.bird.bird_y > 30)
			{
				g.drawImage(this.hand_2, 0, model.bird.bird_y, null);
			}
		}	
	}
	
	public boolean hitBox(int x, int y)
	{
		if(model.bird.bird_x + 64 < x)
		{
			return false;
		}
		
		if(model.bird.bird_x > x + 55)
		{
			return false;
		}
		
		if(model.bird.bird_y + 64 < y)
		{
			return false;
		}
		
		if(model.bird.bird_y > y + 400)
		{
			return false;
		}
		
		System.out.println("Collision Detected! \n");
		regen = 0;
		count++;
		return true;
	}
	
	public void createTube() throws IOException
	{
		if(z == 75)
		{
			model.add();
			z = 0;
		}
	}
}