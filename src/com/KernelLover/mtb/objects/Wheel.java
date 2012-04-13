package com.KernelLover.mtb.objects;

import org.andengine.entity.sprite.Sprite;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.extension.physics.box2d.PhysicsWorld;

import com.KernelLover.mtb.MtbActivity;
import com.KernelLover.mtb.Resources;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class Wheel extends Sprite
{
	
	public Wheel(int x, int y, PhysicsWorld pPhysicsWorld)
	{
		super(x, y, Resources.wheel, MtbActivity.main.getVertexBufferObjectManager());
		
		if(pPhysicsWorld != null)
		{
			Body wheel = PhysicsFactory.createCircleBody(pPhysicsWorld,this, BodyType.DynamicBody, Const.CIRCLE_FIXTURE);
			
			pPhysicsWorld.registerPhysicsConnector(
					new PhysicsConnector(this, wheel, true, true));
		}
		
	}

}
