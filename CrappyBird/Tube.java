import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
class Tube
{
	boolean isUp = true;
	int tube_x = 560;
	Random rand = new Random();
	int tube_y = rand.nextInt(300 - 200 + 1) + 200;
	int speed;
	int counter;
	Random length;
	Model model;
	static Image tube_1 = null;
	static Image tube_2 = null;
	
	Tube() throws IOException
	{
		if(tube_1 == null)
			tube_1 = ImageIO.read(new File("tube_up.png"));
		
		if(tube_2 == null)
			tube_2 = ImageIO.read(new File("tube_down.png"));
	}
	
	public boolean update()
	{
		length = new Random();
		speed = 3;
		tube_x -= speed;
		counter++;
		int top = 250;
		int bottom = -100;
		
		if (counter > 220)
		{
			tube_x = 560;
			int counter_2 = 0;
			counter = 0;
			
			
			if (counter_2 % 2 == 0)
			{
				tube_y = length.nextInt(100)- top;
			}
			else if (counter_2 % 2 != 0)
			{
				tube_y = length.nextInt(top)- bottom;
			}
			return false;
		}
		return true;
	}
}