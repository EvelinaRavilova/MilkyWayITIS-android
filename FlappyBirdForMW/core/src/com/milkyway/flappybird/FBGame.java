package com.milkyway.flappybird;


import com.badlogic.gdx.Game;

import com.milkyway.flappybird.Screens.SplashScreen;
import com.milkyway.flappybird.ZBHelpers.AssetLoader;

public class FBGame extends Game {

	@Override
	public void create() {
		AssetLoader.load();
		setScreen(new SplashScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
		AssetLoader.dispose();
	}
}
