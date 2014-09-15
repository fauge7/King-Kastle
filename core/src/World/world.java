package World;

import Blocks.Grass;
import Blocks.block;
import Blocks.claybrick;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class world {

	public boolean needsupdate = true;
	private block world[][][];
	Texture block1;
	Texture block2;
	public world(int World_Width,int World_Height)
	{
		block1 = new Texture("grass.png");
		block2 = new Texture("clay wall.png");
		world = new block[World_Width][World_Width][World_Height];
		for(int x = 0; x < world.length;x++){
			for(int y = 0; y < world.length;y++){
				for(int z = 0; z <1;z++){
					world[x][y][z] = new Grass(x*64, y*64);
				}
			}	
		}
	}
	
	public block[][][] getWorld()
	{
		return world;
	}
	public void setWorld(int x,int y,int z,int id)
	{
		world[x][y][z] = getBlock(id,x,y);
	}
	public void update(float x,float y,int z,int id)
	{
		
	}	
	public void draw(SpriteBatch batch/*int z*/)
	{
	int z = 0;
	batch.begin();
	for(int x = 0;x < world.length;x++)
	{
		for(int y = 0;y < world[x].length;y++)
		{
			switch(world[x][y][z].getID())
			{
			
			case 1 : 
				batch.draw(block1,world[x][y][z].getX(),world[x][y][z].getY());
				break;
			case 2 : 
				batch.draw(block2,world[x][y][z].getX(),world[x][y][z].getY());
				break;
			}
		}
	}
	batch.end();
	}
	public block getBlock(int ID,int x,int y)
	{
		switch(ID)
		{
		case 1 : 
			return new Grass(x*64, y*64);
		case 2 : 
			return new claybrick(x*64, y*64);
		default :
			return new Grass(-500,-500);
		}
	}
}
