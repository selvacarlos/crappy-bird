import java.io.IOException;
import java.util.*;
class Model
{
	Bird bird;
	Tube tube;
	LinkedList<Tube> tubes;
	int counter = 1;

	Model() throws IOException
	{
		bird = new Bird();
		tube = new Tube();
		tubes = new LinkedList<Tube>();
		tubes.add(new Tube());
	}

	public void update()
	{
		Iterator<Tube> iterator = tubes.iterator();
		while(iterator.hasNext())
		{
			Tube T = iterator.next();
			T.update();
			
			if (!T.update())
			{
				iterator.remove();
			}
		}
		bird.update();
	}
	
	public void onClick()
	{
		bird.flap();
	}
	
	public void add() throws IOException
	{
		tubes.add(new Tube());
	}
}