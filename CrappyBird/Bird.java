import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
class Bird
{
	int bird_x;
	int bird_y;
	int counter;
	double gravity;
	static Image bird_1 = null;
	static Image bird_2 = null;
	
	Bird() throws IOException
	{	
		if(bird_1 == null)
			bird_1 = ImageIO.read(new File("bird1.png"));
		
		if(bird_2 == null)
			bird_2 = ImageIO.read(new File("bird2.png"));
	}
	
	public void update()
	{
		gravity += .6;
		bird_y += gravity;
		counter++;
		if(this.bird_y > 400) {
			System.exit(0);
		}
	}
	
	public void flap()
	{
		gravity = -7;
		counter = 0;
	}
}