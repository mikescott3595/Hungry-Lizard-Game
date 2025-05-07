
public class Snackaroo extends HungryLizardGame
{
	private Fly[][] flies; //creates array of flies 
	
	public Snackaroo(int rows, int columns)
	{
		flies = new Fly[rows][columns];
		spawnFlies();
	}
	
	public void spawnFlies()
	{
		for (int row = 0; row < flies.length; row++)
		{
			for (int col = 0; col < flies[row].length; col++)
			{
			flies[row][col] = new Fly(col * 50, row * 50);
			
			}
		}
	}
	
	
	public Snackaroo(int i, int j)
	{
		// TODO Auto-generated constructor stub
	}

}
