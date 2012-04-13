package com.KernelLover.mtb.objects;

import org.andengine.extension.physics.box2d.PhysicsFactory;

import com.badlogic.gdx.physics.box2d.FixtureDef;

public class Const 
{
	public static final short CATEGORYBIT_CIRCLE = 4;
	public static final short CATEGORYBIT_WALL = 1;
	
	
	public static final short MASKBITS_CIRCLE = CATEGORYBIT_WALL + CATEGORYBIT_CIRCLE;
	public static final short MASKBITS_WALL = CATEGORYBIT_WALL + CATEGORYBIT_CIRCLE;
	
	
	public static final FixtureDef CIRCLE_FIXTURE = 
			PhysicsFactory.createFixtureDef(2, 0.1f, 50, false, CATEGORYBIT_CIRCLE, MASKBITS_CIRCLE, (short)0);
	public static final FixtureDef WALL_FIXTURE_DEF = 
			PhysicsFactory.createFixtureDef(0, 0.5f, 0.5f, false, CATEGORYBIT_WALL, MASKBITS_WALL, (short)0);
}
