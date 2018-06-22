package com.milkyway.flappybird.ZBHelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.Map;

public class AssetLoader{

	public static Texture texture, logoTexture, textureBird, textureGrass,
			textureBg, textureFlappy, texturePlayOff, texturePlayOn, textureReady, textureMenu;
	public static TextureRegion logo, zbLogo, bg, grass, bird, birdDown,
			birdUp, skullUp, skullDown, bar, playButtonUp, playButtonDown,
			ready, gameOver, highScore, scoreboard, star, noStar, retry, menu;
	public static Animation birdAnimation;
	public static Sound dead, flap, coin, fall;
	public static BitmapFont font, shadow, whiteFont;
	private static Preferences prefs;

	public static void load() {

		logoTexture = new Texture(Gdx.files.internal("data/logo.png"));
		logoTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		logo = new TextureRegion(logoTexture, 0, 0, 512, 114);

		texture = new Texture(Gdx.files.internal("data/texture.png"));
		textureBird = new Texture(Gdx.files.internal("data/birdanimation.png"));
		textureGrass = new Texture(Gdx.files.internal("data/ground.png"));
		textureBg = new Texture(Gdx.files.internal("data/bg.png"));
		textureFlappy = new Texture(Gdx.files.internal("data/flappy.png"));
		texturePlayOff = new Texture(Gdx.files.internal("data/btnplay.png"));
		texturePlayOn = new Texture(Gdx.files.internal("data/btnplayon.png"));
		textureReady = new Texture(Gdx.files.internal("data/getready.png"));
		textureMenu = new Texture(Gdx.files.internal("data/menu.png"));


		TextureRegion tmp[][] = TextureRegion.split(textureBird, textureBird.getWidth() / 3, textureBird.getHeight());

		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		playButtonUp = new TextureRegion(texturePlayOff);
		playButtonDown = new TextureRegion(texturePlayOn);
		playButtonUp.flip(false, true);
		playButtonDown.flip(false, true);

		menu = new TextureRegion(textureMenu);
		menu.flip(false, true);

		ready = new TextureRegion(textureReady);
		ready.flip(false, true);

		retry = new TextureRegion(texture, 59, 110, 33, 7);
		retry.flip(false, true);
		
		gameOver = new TextureRegion(texture, 59, 92, 46, 7);
		gameOver.flip(false, true);

		scoreboard = new TextureRegion(texture, 111, 83, 97, 37);
		scoreboard.flip(false, true);

		star = new TextureRegion(texture, 152, 70, 10, 10);
		noStar = new TextureRegion(texture, 165, 70, 10, 10);

		star.flip(false, true);
		noStar.flip(false, true);

		highScore = new TextureRegion(texture, 59, 101, 48, 7);
		highScore.flip(false, true);

		zbLogo = new TextureRegion(textureFlappy);
		zbLogo.flip(false, true);

		bg = new TextureRegion(textureBg);
		bg.flip(false, true);

		grass = new TextureRegion(textureGrass);
		grass.flip(false, true);


		birdDown = tmp[0][0];
		birdDown.flip(false, true);

		bird = tmp[0][1];
		bird.flip(false, true);

		birdUp = tmp[0][2];
		birdUp.flip(false, true);

		TextureRegion[] birds = { birdDown, bird, birdUp };
		birdAnimation = new Animation(0.06f, birds);
		birdAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

		skullUp = new TextureRegion(texture, 192, 0, 24, 14);
		// Create by flipping existing skullUp
		skullDown = new TextureRegion(skullUp);
		skullDown.flip(false, true);

		bar = new TextureRegion(texture, 136, 16, 22, 3);
		bar.flip(false, true);

		dead = Gdx.audio.newSound(Gdx.files.internal("data/dead.wav"));
		flap = Gdx.audio.newSound(Gdx.files.internal("data/flap.wav"));
		coin = Gdx.audio.newSound(Gdx.files.internal("data/coin.wav"));
		fall = Gdx.audio.newSound(Gdx.files.internal("data/fall.wav"));

		font = new BitmapFont(Gdx.files.internal("data/text.fnt"));
		font.getData().setScale(0.25f, -0.25f);


		whiteFont = new BitmapFont(Gdx.files.internal("data/whitetext.fnt"));
		whiteFont.getData().setScale(.1f, -.1f);

		shadow = new BitmapFont(Gdx.files.internal("data/shadow.fnt"));
		shadow.getData().setScale(.25f, -.25f);

		// Create (or retrieve existing) preferences file
		prefs = Gdx.app.getPreferences("ZombieBird");

		if (!prefs.contains("highScore")) {
			prefs.putInteger("highScore", 0);
		}
		if (!prefs.contains("1Score")) {
			prefs.putInteger("1Score", 0);
		}
		if (!prefs.contains("2Score")) {
			prefs.putInteger("2Score", 0);
		}
		if (!prefs.contains("3Score")) {
			prefs.putInteger("3Score", 0);
		}
		if (!prefs.contains("4Score")) {
			prefs.putInteger("4Score", 0);
		}
		if (!prefs.contains("5Score")) {
			prefs.putInteger("5Score", 0);
		}
		if (!prefs.contains("6Score")) {
			prefs.putInteger("6Score", 0);
		}
		if (!prefs.contains("7Score")) {
			prefs.putInteger("7Score", 0);
		}
		if (!prefs.contains("8Score")) {
			prefs.putInteger("8Score", 0);
		}
		if (!prefs.contains("9Score")) {
			prefs.putInteger("9Score", 0);
		}
	}

	public static void setHighScore(int val) {
		prefs.putInteger("highScore", val);
		prefs.flush();
	}
	public static void setScore(int val){
		for (int i = 1; i < 10; i++) {
			prefs.putInteger(i + "Score", prefs.getInteger((i + 1) + "Score"));
		}
		prefs.putInteger("9Score", val);
		prefs.flush();
	}

	public static int getHighScore() {
		return prefs.getInteger("highScore");
	}
    public static ArrayList getScores() {
		if (prefs == null){
			makePrefs();
		}
		ArrayList<Integer> scores = new ArrayList();
		for (int i = 1; i < 10; i++) {
			scores.add(prefs.getInteger(i + "Score"));
		}
		return scores;

    }
    public static void makePrefs(){
		prefs = Gdx.app.getPreferences("ZombieBird");
		if (!prefs.contains("1Score")) {
			prefs.putInteger("1Score", 0);
		}
		if (!prefs.contains("2Score")) {
			prefs.putInteger("2Score", 0);
		}
		if (!prefs.contains("3Score")) {
			prefs.putInteger("3Score", 0);
		}
		if (!prefs.contains("4Score")) {
			prefs.putInteger("4Score", 0);
		}
		if (!prefs.contains("5Score")) {
			prefs.putInteger("5Score", 0);
		}
		if (!prefs.contains("6Score")) {
			prefs.putInteger("6Score", 0);
		}
		if (!prefs.contains("7Score")) {
			prefs.putInteger("7Score", 0);
		}
		if (!prefs.contains("8Score")) {
			prefs.putInteger("8Score", 0);
		}
		if (!prefs.contains("9Score")) {
			prefs.putInteger("9Score", 0);
		}
	}

	public static void dispose() {
		// We must dispose of the texture when we are finished.
		texture.dispose();

		// Dispose sounds
		dead.dispose();
		flap.dispose();
		coin.dispose();

		font.dispose();
		shadow.dispose();
	}

}