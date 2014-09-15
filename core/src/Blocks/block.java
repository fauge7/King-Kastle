package Blocks;


public abstract class block {
	
	private float xPos;
	private float yPos;
	private int layer;
	private final int ID;
	boolean shouldremove = false;
	
	public block(int id)
	{
		ID = id;
	}
	public int getID() {
		return ID;
	}
	public void setX(float x)
	{
		xPos = x;	
	}
	public float getX()
	{
		return xPos;
	}
	public void setY(float y)
	{
		yPos = y;
	}
	public float getY()
	{
		return yPos;
	}
	public void update()
	{
		
	}
	public int getLayer() {
		return layer;
	}
	public void setLayer(int layer) {
		this.layer = layer;
	}
}
