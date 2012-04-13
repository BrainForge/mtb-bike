package com.KernelLover.mtb;

import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.scene.CameraScene;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.extension.physics.box2d.PhysicsWorld;

import android.util.Log;

import com.KernelLover.mtb.objects.Const;
import com.KernelLover.mtb.objects.Wheel;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class Game_Scene extends CameraScene
{
	private PhysicsWorld world;
	
	public Game_Scene(PhysicsWorld world) 
	{
		super(MtbActivity._Camera);	
		Log.v("gameState", "create_game_scene");
		
		this.world = world;
		
		final Rectangle ground = 
				new Rectangle(0, MtbActivity.CAMERA_HEIGHT - 2, MtbActivity.CAMERA_WIDTH, 2, MtbActivity.main.getVertexBufferObjectManager());
		
		PhysicsFactory.createBoxBody(this.world, ground, BodyType.StaticBody, Const.WALL_FIXTURE_DEF);
		
		attachChild(ground);
		
		
		attachChild(new Wheel(0, 0, this.world));
		
		attachChild(new Wheel(200, 0, this.world));
	}
	
	public void Show() 
	{
		setVisible(true);
		setIgnoreUpdate(false);
	}
	
	public void Hide() 
	{
		setVisible(false);
		setIgnoreUpdate(true);
	}
}
