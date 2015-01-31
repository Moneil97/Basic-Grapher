
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;

public class Table3 extends JPanel 
{
	private static final long serialVersionUID = 1L;
    
    public Table3(ArrayList<Integer> xxx, ArrayList<Double> yyy, int graphWidth, int graphHeight) {
    	super(new GridLayout(1,0));
    	
    	String[] columnNames = {"x", "f(x)"};
    	//Object[][] data = {{1,2},{2,4},{4,8},{8,16}, {16,32}};
    	Object[][] data = new Object[xxx.size()][2];
    	
    	for (int i=0; i<xxx.size();i++)
    	{
    		data [i][0] = xxx.get(i);
    		data [i][1] = yyy.get(i);
    	}
    	
    	final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(200, 200));
        table.setFillsViewportHeight(true);
    	
    	//JTable table = new JTable(dataModel);
        JScrollPane scrollpane = new JScrollPane(table);
        scrollThisToTop(table, graphWidth/*-17*/ - graphHeight/38, 2);
        add(scrollpane);
        
        setOpaque(true);
        setVisible(true);
	}
    
	public static void scrollThisToTop(JTable table, int rowIndex, int vColIndex) {
        if (!(table.getParent() instanceof JViewport)) {
          return;
        }
        JViewport viewport = (JViewport) table.getParent();
        Rectangle rect = table.getCellRect(rowIndex, vColIndex, true);
        Rectangle viewRect = viewport.getViewRect();
        rect.setLocation(rect.x - viewRect.x, rect.y - viewRect.y);

        int centerX = (viewRect.width - rect.width) / 2;
        int centerY = (viewRect.height - rect.height) / 2;
        if (rect.x < centerX) {
          centerX = -centerX;
        }
        if (rect.y < centerY) {
          centerY = -centerY;
        }
        rect.translate(centerX, centerY);
        viewport.scrollRectToVisible(rect);
        //http://www.java2s.com/Tutorial/Java/0240__Swing/ScrollingaCelltotheCenterofaJTableComponent.htm
	}
}
