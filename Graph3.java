import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

public class Graph3 extends Canvas{

	private static final long serialVersionUID = 1L;
	
	ArrayList<Integer> xxx;
	ArrayList<Double> yyy;
	String equation;
	int height, width, scale;
	
	public Graph3(ArrayList<Integer> xxx, ArrayList<Double> yyy, int width, int height, String equation, int scale)
	{
		this.xxx = xxx;
		this.yyy = yyy;
		this.width = width;
		this.height = height;
		this.equation = equation;
		this.scale = scale;
		setBackground(Color.WHITE);
	}
	
	public void paint(Graphics g1)
	{
		Graphics2D g = (Graphics2D) g1;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.drawLine(width/2, 0, width/2, height);
		g.drawLine(0,height/2,width,height/2);
		
		g.setColor(Color.BLUE);
		g.setFont(new Font("Arial", Font.PLAIN, 20));
		g.drawString(equation, 10, 20);
		g.setFont(new Font("Arial", Font.PLAIN, 16));
		g.drawString("X-Window: [" + -width/2 + "," + width/2 + "]",10,40);
		g.drawString("Y-Window: [" + -height/2 + "," + height/2 + "]",10,60);
		g.drawString("X-Scale: " + scale, 10, 80);
		
		g.setColor(Color.RED);
		int xOffset = width/2;
		int yOffset = height/2;

		for (int x=0;x < xxx.size()-1; x++)
		{
			try{
				g.drawLine(xxx.get(x)+ xOffset, height-yyy.get(x).intValue() - yOffset, xxx.get(x+1) + xOffset, height- yyy.get(x+1).intValue() - yOffset);
			}catch(IndexOutOfBoundsException e ){say("out of bounds");};
		}
	}
	
	public void say(String s)
	{
		System.out.println(s);
	}
}
