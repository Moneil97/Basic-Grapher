import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Runner extends JFrame{

	private static final long serialVersionUID = 1L;

	public Runner()
	{
		super("Grapher");
		
		int tableWidth = 210;
		int graphWidth, graphHeight, graphScale;
		
		try{
			String s1 = JOptionPane.showInputDialog("Window width", 820);
			graphWidth = Integer.parseInt(s1) - tableWidth;
			String s2 = JOptionPane.showInputDialog("Window height", 600);
			graphHeight = Integer.parseInt(s2);
			String s3 = JOptionPane.showInputDialog("Graph X-Scale", 1);
			graphScale = Integer.parseInt(s3);
		}
		catch (Exception e)
		{
			graphWidth = 600;
			graphHeight = 600;
			graphScale = 1;
		}

		setSize(graphWidth + tableWidth +12,graphHeight+40);
		
		UserInput u = new UserInput(graphWidth,graphHeight);
		
		Table3 t = new Table3(u.xxx, u.yyy, graphWidth,graphHeight);
		Graph3 g = new Graph3(u.xxx, u.yyy, graphWidth, graphHeight, u.equation, graphScale);
		
		add(t, "East");
		add(g, "Center");
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) 
	{
		new Runner();
	}
}
