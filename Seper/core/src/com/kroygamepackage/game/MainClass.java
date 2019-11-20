package com.kroygamepackage.game;

import com.kroygamepackage.game.MainClass;
import com.badlogic.gdx.assets.*;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MainClass extends ApplicationAdapter 
	{
	//constants
	private final int WINDOW_WIDTH = 1280;
	private final int WINDOW_HEIGHT = 720;
	private final int MAP_WIDTH = 2;
	private final int MAP_HEIGHT = 2;
	
	private AssetManager manager = new AssetManager();
	private SpriteBatch batch;
	
	
	
	
	//variables
	Tile[][] mapData = new Tile[MAP_HEIGHT][MAP_WIDTH];
	
	
	
	@Override
	public void create () 
	{
		
		batch = new SpriteBatch();
		Gdx.graphics.setWindowedMode(WINDOW_WIDTH, WINDOW_HEIGHT);
		loadTexture();
		generateMap();
		
	}

	@Override
	public void render( ) 
	{
	
		Gdx.gl.glClearColor(0.7f, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		renderMap();
		
		
		
		
		batch.end();
		
		
		
		
	}
	
	@Override
	public void dispose () 
	{
		Gdx.app.exit();
		
	}
	
	
	public void renderMap()
	{
		int tileWidth = WINDOW_WIDTH / MAP_WIDTH;
		int tileHeight = WINDOW_HEIGHT / MAP_HEIGHT;
		
		
		//Texture tileTex = manager.get("ranbow.png", Texture.class);
		Texture tileTex = new Texture("ranbow.png");
		for(int height = 0; height < MAP_HEIGHT; height++) {
			for(int width = 0; width < MAP_WIDTH; width++)
			{
				int w = width * tileWidth;
				int h = height * tileHeight;
				
				batch.draw(tileTex, height * tileHeight, width * tileWidth, tileWidth,tileHeight);
			}
		}
		
		
		
	}
	
	public Tile[][] generateMap()
	{
		Tile[][] mapData = new Tile[MAP_HEIGHT][MAP_WIDTH];
		for(int height = 0; height < MAP_HEIGHT; height++) {
			for(int width = 0; width < MAP_WIDTH; width++)
			{
				mapData[height][width] = new Tile(width, height);
			}
		}
		
		
		
		return mapData;
		
	}
	
	public void loadTexture() 
	{
		
		manager.load("grassTile.png", Texture.class);
		
	}
	
	
}
