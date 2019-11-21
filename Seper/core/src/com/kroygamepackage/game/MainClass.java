package com.kroygamepackage.game;

import com.kroygamepackage.game.MainClass;
import com.badlogic.gdx.assets.*;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.*;


public class MainClass extends ApplicationAdapter 
	{
	//constants
	private final int WINDOW_WIDTH = 640;
	private final int WINDOW_HEIGHT = 360;
	private final int MAP_WIDTH = 2;
	private final int MAP_HEIGHT = 2;
	
	private AssetManager manager = new AssetManager();
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	
	
	//variables
	Tile[][] mapData = new Tile[MAP_HEIGHT][MAP_WIDTH];
	
	
	
	@Override
	public void create () 
	{
		
		batch = new SpriteBatch();
		texture = new Texture(Gdx.files.internal("pat.jpg"));
		//Gdx.graphics.setWindowedMode(WINDOW_WIDTH, WINDOW_HEIGHT);
		loadTexture();
		generateMap();
		System.out.println(Gdx.graphics.getWidth());
		System.out.println(Gdx.graphics.getHeight());
		sprite = new Sprite(texture, 0, 0 ,256 ,256);
		//sprite.setPosition(x, y);
		//sprite.setRotation(45);
		
		
		
	}
	
	
	
	

	@Override
	public void render( ) 
	{
	
		Gdx.gl.glClearColor(0.7f, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
		batch.begin();
		//renderMap();
		sprite.draw(batch);
		
		sprite.d;
			
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
		
		
		//Texture tileTex = manager.get("pat.jpg", Texture.class);
		Texture tileTex = new Texture("pat.jpg");
		for(int height = 0; height < MAP_HEIGHT; height++) {
			for(int width = 0; width < MAP_WIDTH; width++)
			{
				int w = width * tileWidth;
				int h = height * tileHeight;
				
				//batch.draw(tileTex, height * tileHeight, width * tileWidth, tileWidth,tileHeight);
				//batch.draw(tileTex, width* tileWidth, height * tileHeight, tileWidth,tileHeight);
				//batch.draw(tileTex, width* tileWidth, height * tileHeight);
				
			}
		}
		
		//batch.draw(tileTex, WINDOW_WIDTH/2, WINDOW_HEIGHT/2,WINDOW_WIDTH/2,WINDOW_HEIGHT/2);
		//batch.draw(tileTex, 0, 0,WINDOW_WIDTH/2,WINDOW_HEIGHT);
		//batch.draw(tileTex, WINDOW_WIDTH/2, 0,WINDOW_WIDTH/2,WINDOW_HEIGHT/2);
		//batch.draw(tileTex, WINDOW_WIDTH/2, WINDOW_HEIGHT/2,WINDOW_WIDTH/2,WINDOW_HEIGHT/2);

		
		
		
		
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
