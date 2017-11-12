package ai.cleaner;

import ai.Obj;
import java.awt.*;

/**
 * Dirt that appears in the Vacuum world.
 *
 */

public class Dirt extends Obj
{
    public void draw(Graphics g, Point p, int cellSize)
    {
	g.setColor(Color.gray);
	g.fillRect(p.x+1,p.y+1,cellSize-1,cellSize-1);
    }
}
