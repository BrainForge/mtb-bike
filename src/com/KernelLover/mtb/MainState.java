package com.KernelLover.mtb;

import org.andengine.entity.scene.Scene;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.input.touch.TouchEvent;

import android.view.KeyEvent;

public class MainState extends Scene
{
	public static Game_Scene _Game_Scene;
	private static int _GameState;	//Текущая сцена на экране
	private static final int GAME_RUNNING_STATE = 0;
	
	private PhysicsWorld world;
	
	public MainState(PhysicsWorld world) 
	{
		this.world = world;
		_Game_Scene = new Game_Scene(world);
		
		attachChild(_Game_Scene);
		ShowGameScene();
	}
	
	//показать игровую сцену
	public static void ShowGameScene() 
	{
		_Game_Scene.Show();
		_GameState = GAME_RUNNING_STATE;
	}
	
	//рассылка события нажатия клавиш на сцены
	@Override
	public boolean onSceneTouchEvent(TouchEvent pSceneTouchEvent) 
	{
		switch (_GameState)
		{
		case GAME_RUNNING_STATE:
			_Game_Scene.onSceneTouchEvent(pSceneTouchEvent);
			break;
			
		}
		return super.onSceneTouchEvent(pSceneTouchEvent);
	}

	//обработка нажатия клавиш 
	public void KeyPressed(int keyCode, KeyEvent event) 
	{
		switch (_GameState)
		{
		case GAME_RUNNING_STATE:
			android.os.Process.killProcess(android.os.Process.myPid());
			break;
		}
	}
}
