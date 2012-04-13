package com.KernelLover.mtb;

import org.andengine.engine.Engine;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;

import android.content.Context;

public class Resources
{
	/////
	private static BitmapTextureAtlas texture;
	/////
	public static ITextureRegion wheel;
	
	private static Resources object;

	public static void LoadTextures(Context context, Engine engine)
	{
		 texture = new BitmapTextureAtlas(engine.getTextureManager(),2048, 2048, TextureOptions.BILINEAR_PREMULTIPLYALPHA);
		 wheel = BitmapTextureAtlasTextureRegionFactory.createFromAsset(texture, context, "gfx/wheel.png", 0, 0);
		 engine.getTextureManager().loadTexture(texture);
	}
}
