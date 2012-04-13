package com.KernelLover.mtb;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.Scene;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import android.hardware.SensorManager;
import android.util.Log;
import android.view.KeyEvent;

import com.KernelLover.mtb.objects.Const;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class MtbActivity extends SimpleBaseGameActivity
{
	public static MainState _MainState;
	public static Camera _Camera;
	private boolean _GameLoaded = false;
	public static MtbActivity main;
	
	private PhysicsWorld mPhysicsWorld;
	
	public static int CAMERA_WIDTH = 800;
	public static int CAMERA_HEIGHT = 480;
	
	@Override
	public EngineOptions onCreateEngineOptions() 
	{
		Log.v("gameState", "create_engine");
		main = this;
		_Camera = new Camera(0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		final EngineOptions opt = new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED,
				new RatioResolutionPolicy(CAMERA_WIDTH, CAMERA_HEIGHT), _Camera);
		return opt;
	}

	@Override
	protected void onCreateResources() 
	{
		Log.v("gameState", "create_resources");
		Resources.LoadTextures(this,mEngine); 
	}

	@Override
	protected Scene onCreateScene() 
	{
		Log.v("gameState", "create_scene");
		
		_MainState = new MainState(createPhysic());
		_MainState.registerUpdateHandler(mPhysicsWorld);
		
		_GameLoaded = true;
		return _MainState;
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{
		
		if (keyCode == KeyEvent.KEYCODE_BACK)
		{
			if (!_GameLoaded ) return true;
			if (_MainState != null && _GameLoaded) 
			{
				_MainState.KeyPressed(keyCode, event);
				return true;
			}
			return true;
		}
	    return super.onKeyDown(keyCode, event);
	}
	
	private PhysicsWorld createPhysic()
	{
		mPhysicsWorld = new PhysicsWorld(new Vector2(0, SensorManager.GRAVITY_EARTH), false);

		return mPhysicsWorld;
	}
	
	@Override
	protected void onDestroy() 
	{
		super.onDestroy();
		android.os.Process.killProcess(android.os.Process.myPid());
	}

}