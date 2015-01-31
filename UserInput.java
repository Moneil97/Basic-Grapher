
import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JOptionPane;


public class UserInput {
	
	ArrayList<Integer> xxx = new ArrayList<Integer>();
	ArrayList<Double> yyy = new ArrayList<Double>();
	String equation = "";
	int height, width;
	
	public UserInput(int width, int height)
	{
		this.width = width;
		this.height = height;
		String s = JOptionPane.showInputDialog("y=", "1/9000*x*x*x - 4*x - 20");
		equation = ("f(x) = " + s);
		
		for (int x=-width; x < width+1; x++)
		{
			xxx.add(x);
			yyy.add(Double.parseDouble(f(s.replaceAll("x", "" + x))));
		}
	}
	
	public String f(String s)
	{
		String y = "error";
		
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		String infix = s;
		try {
			y = String.valueOf(engine.eval(infix));
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return y;
	}
	
	public void say(String s)
	{
		System.out.println(s);
	}
}
