import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class Game extends JFrame
{
	Model model;
	View view;
	Bird bird;
	public Game() throws IOException
	{
		model = new Model();
		Controller controller = new Controller(model);
		view = new View(controller, model);
		this.setTitle("Discount Flappy Bird");
		this.setSize(500, 500);
		this.getContentPane().add(view);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) throws IOException
	{
		Game g = new Game();
		g.run();
	}
	
	public void run()
	{
		while(true)
		{
			model.update();
			view.repaint(); // Indirectly calls View.paintComponent

			// Go to sleep for 50 miliseconds
			try
			{
				Thread.sleep(40);
			} catch(Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
			// System.out.println("hi");
		}
	}
}
