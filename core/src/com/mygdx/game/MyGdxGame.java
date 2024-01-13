package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.TimeUtils;

public class MyGdxGame extends ApplicationAdapter { //public enam
	public static final float SCR_WIDTH= 1280, SCR_HEIGHT = 720;

	SpriteBatch batch;
	BitmapFont font;

	Vector3 touch;

	OrthographicCamera camera;

	Texture menuKapy;
	Texture bttPlay, bttDangerous;
	Texture bcgSakuraKapy, bcgWin, bcg_settings, bcgPause, bcgSad;
	Texture texture_kapy_min, texture_kapy_min_mand;
	Texture bttSettings, bttRestart;
	Texture bttMyLove, texture_loves;
	Texture texture_kapy_min_happy;
	Texture texture_frog_min;
	Texture bttSoundON, bttSoundOFF;
	Texture soundON_text, soundOFF_text;
	Texture bttNotes, bttNotesOFF;
	Texture musicON_text, musicOFF_text;
	Texture bttBack;
	Texture level1, level2, level2Red, min2Level, min1Lvel;
	Texture pause, play;

	Music sndBcgMusic;

	MyButton buttonPlay, buttonDangerous;
	MyButton buttonSettings;
	MyButton buttonLove;
	MyButton buttonSound, buttonMusic;
	MyButton buttonBack, buttonRestart;
	MyButton buttonLevel1, buttonLevel2;
	MyButton buttonPause, ButtonPlay;
	MyButton buttonBack2;

	String type_kapyMin;

	public typeScreen type;

	boolean GameOver = false;
	boolean loves = false;
	boolean sound = true, music = true;
	boolean level_1 = true, hit2 = false;

	long startGame, time;
	long durationGame = 7000;
	long tKh;
	long timeK;
	long tKs;

	int counter = 0, countKapy = 0, countFrog = 0;
	int MINKapy = 6, MINFrog = 2;


	Kapy kapy, kapy_mand;
	Frog frog, frog2;

	@Override
	public void create () {
		batch = new SpriteBatch();



		menuKapy = new Texture("capybara_menu.png");
		bttPlay = new Texture("img_play.png");
		bttDangerous = new Texture("img_dangerous.png");
		bcgSakuraKapy = new Texture("sakura_kary.png");
		texture_kapy_min = new Texture("Kapy_min.png");
		bttSettings = new Texture("button_setting.png");
		bcg_settings = new Texture("bcg_settings.png");
		bttMyLove = new Texture("my_love_btt.png");
		texture_loves = new Texture("loves.png");
		texture_kapy_min_happy = new Texture("Kapy_min_happy.png");
		texture_frog_min = new Texture("Frog_minnnn2.png");
		bttSoundON = new Texture("sound/sound_on.png");
		bttSoundOFF = new Texture("sound/sound_off.png");
		soundON_text = new Texture("sound/sound_on_text.png");
		soundOFF_text = new Texture("sound/sound_off_text.png");
		bttNotes = new Texture("sound/notes.png");
		bttNotesOFF = new Texture("sound/notes_off.png");
		musicON_text = new Texture("sound/music_on_text.png");
		musicOFF_text = new Texture("sound/music_off_text.png");
		bttBack = new Texture("button_back.png");
		texture_kapy_min_mand = new Texture("Kapy_min_mand.png");
		bcgWin = new Texture("bcgWin.png");
		bcgPause = new Texture("bcgPause.png");
		bttRestart = new Texture("btt_restart.png");
		bcgSad = new Texture("bcgSad.png");
		//buttonPause = new MyButton();
		//buttonPlay = new MyButton();
		level1 = new Texture("levels/1_level.png");
		level2 = new Texture("levels/2_level.png");
		level2Red = new Texture("levels/2_level_red.png");
		pause = new Texture("levels/txt_pause.png");
		play = new Texture("levels/txt_play.png");
		min2Level = new Texture("levels/min2Level.png");
		min1Lvel = new Texture("levels/min1Level.png");


		sndBcgMusic = Gdx.audio.newMusic(Gdx.files.internal("sound/audio_gameKapy.mp3"));



		buttonPlay = new MyButton(110, 318, 211, 57);
		buttonDangerous = new MyButton(120, 220, 123, 39);
		buttonSettings = new MyButton(0, 600,100,100);
		buttonLove = new MyButton((int)SCR_WIDTH*2/3, (int)SCR_HEIGHT/3, 200, 200);
		buttonSound = new MyButton(0, 400, 200, 200);
		buttonMusic = new MyButton(0, 220, 245, 205);
		buttonBack = new MyButton(0, 620, 150, 100);
		buttonRestart = new MyButton((int)SCR_WIDTH/2-201, 20, 403, 107);
		buttonLevel1 = new MyButton((int)SCR_WIDTH/2-201-76, 150, 192, 82);
		buttonLevel2 = new MyButton(660, 150, 192, 83);
		buttonBack2 = new MyButton(0, 620, 150, 100);

		touch = new Vector3();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);

		Gdx.input.setInputProcessor(new MyInputProcessor());



		type = typeScreen.MenuKapy;





		kapy = new Kapy((int)(SCR_WIDTH), 155, 5, 206, 255);
		kapy_mand = new Kapy(-563, 0, 0, 209, 223);
		kapy_mand.respawn_mand();
		frog = new Frog(0, 0, 2, 2, 110, 98);
		frog2 = new Frog(0, 0, 2, 2, 110, 98);
		frog2.respawnUp();
		frog.respawn();

		generateFont();

		sndBcgMusic.setLooping(true);
		sndBcgMusic.play();

	}

	@Override
	public void render () {
		//отрисовка:
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		//меню
		if (type == typeScreen.MenuKapy){
			batch.draw(menuKapy, 0, 0, SCR_WIDTH, SCR_HEIGHT);
			batch.draw(bttPlay, 110, 318, 211, 57);
			batch.draw(bttDangerous, 120, 220, 123, 39);
		}
		//игра капи
		if(type == typeScreen.PlayKapy && !GameOver){
			batch.draw(bcgSakuraKapy, 0, 0, SCR_WIDTH, SCR_HEIGHT);


			time = TimeUtils.millis() - startGame;  //время игры
			if(time > durationGame) {
				GameOver = true;
				System.out.println("GameOver");
			}
			font.draw(batch, getTimeString(), 0, SCR_HEIGHT-10, SCR_WIDTH, Align.center, true);


			font.draw(batch, "Count: "+counter, SCR_WIDTH-190, SCR_HEIGHT-10);//счетчик
			font.draw(batch, "Kapy: "+countKapy, SCR_WIDTH-190, SCR_HEIGHT-30);
			font.draw(batch, "Frog: "+countFrog, SCR_WIDTH-190, SCR_HEIGHT-50);
			font.draw(batch, "level"+((level_1) ? "1" : "2"), SCR_WIDTH-190, SCR_HEIGHT-70);

			kapy.move();
			batch.draw(texture_kapy_min, kapy.x, kapy.y);
			if(kapy.x < -564) {
				kapy.respawn();
			}

			batch.draw(texture_kapy_min_mand, kapy_mand.x, kapy_mand.y);


			frog.move();
			batch.draw(texture_frog_min, frog.x, frog.y);
			if(frog.y < -98 || frog.y > 0) {
				frog.respawn();
			}

			frog2.moveUp();
			batch.draw(texture_frog_min, frog2.x, frog2.y); //z
			if(frog.y < SCR_WIDTH-98 || frog2.y > SCR_WIDTH+2) {
				frog2.respawnUp();
				System.out.println("frog");
			}
		}

		if(GameOver) {
			if(level_1 && countKapy > MINKapy && countFrog > MINFrog || !level_1 && countKapy > MINKapy && countFrog > MINFrog) {
				type = typeScreen.WinKapy;
			}else type = typeScreen.GameOverKapy;
		}

		if(type == typeScreen.WinKapy) {
			batch.draw(bcgPause, 0, 0, SCR_WIDTH, SCR_HEIGHT);
			batch.draw(bcgWin, 0, 0, SCR_WIDTH, SCR_HEIGHT);
			font.draw(batch, "Count: "+counter, SCR_WIDTH-190, SCR_HEIGHT-10);//счетчик
			font.draw(batch, "Kapy: "+countKapy, SCR_WIDTH-190, SCR_HEIGHT-30);
			font.draw(batch, "Frog: "+countFrog, SCR_WIDTH-190, SCR_HEIGHT-50);
			font.draw(batch, "level"+((level_1) ? "1" : "2"), SCR_WIDTH-190, SCR_HEIGHT-70);
			batch.draw(bttRestart, SCR_WIDTH/2-201, 20);
			batch.draw(level1, SCR_WIDTH/2-201-76, 150);
			batch.draw(level2, 660, 150);
			batch.draw(bttBack, 0, 620);
		}

		if(type == typeScreen.GameOverKapy) {
			batch.draw(bcgPause, 0, 0, SCR_WIDTH, SCR_HEIGHT);
			batch.draw(bcgSad, 0, 0, SCR_WIDTH, SCR_HEIGHT);
			font.draw(batch, "Count: "+counter, SCR_WIDTH-190, SCR_HEIGHT-10);//счетчик
			font.draw(batch, "Kapy: "+countKapy, SCR_WIDTH-190, SCR_HEIGHT-30);
			font.draw(batch, "Frog: "+countFrog, SCR_WIDTH-190, SCR_HEIGHT-50);
			font.draw(batch, "level"+((level_1) ? "1" : "2"), SCR_WIDTH-190, SCR_HEIGHT-70);
			batch.draw(bttRestart, SCR_WIDTH/2-201, 20);
			batch.draw(level1, SCR_WIDTH/2-201-76, 150);
			batch.draw(bttBack, 0, 620);
			if(level_1) {
				batch.draw(level2Red, 660, 150);
				if(hit2){
					batch.draw(min2Level, 0, 0);
					font.draw(batch, "7", 250, 125);
					font.draw(batch, "3", 220, 40);
				}
			} else {
				batch.draw(level2, 660, 150);
			}

		}


		//отрисовка кнопки сеттингов
		if(type == typeScreen.PauseKapy || type == typeScreen.MenuKapy){
			batch.draw(bttSettings, 0, 610, 100,100);
		}
		//меню сеттингов
		if(type == typeScreen.SettingKapy) {
			batch.draw(bcg_settings, 0, 0, SCR_WIDTH, SCR_HEIGHT);
			batch.draw(min1Lvel, 0, 0);
			batch.draw(min2Level, 238, 0);
			batch.draw(bttBack, 0, 620);

			if(loves == false) {
				batch.draw(bttMyLove, SCR_WIDTH*2/3, SCR_HEIGHT/3, 200, 200);
			}
			else {
				batch.draw(texture_loves, SCR_WIDTH-500,0, 500, 300);
			}
			if (sound) {
				batch.draw(bttSoundON, 0, 400);
				batch.draw(soundON_text, 230, 400);
			}
			else {
				batch.draw(bttSoundOFF, 0 ,400);
				batch.draw(soundOFF_text, 230, 400);
			}
			if (music) {
				batch.draw(bttNotes, 0, 220);
				batch.draw(musicON_text, 245, 220);
				sndBcgMusic.play();
			}
			else {
				batch.draw(bttNotesOFF, 0, 220);
				batch.draw(musicOFF_text, 245, 220);
				sndBcgMusic.pause();
			}
		}


		batch.end();
	}




	@Override
	public void dispose () {
		batch.dispose();
		menuKapy.dispose();
	}

	void generateFont(){
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("main_font.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = 20;
		parameter.color = Color.valueOf("#fdb2f5");
		parameter.borderColor = Color.valueOf("#f266e4");
		parameter.borderWidth = 2;
		font = generator.generateFont(parameter);
		generator.dispose();
	}

	String getTimeString(){
		long msec = time%1000;
		long sec = time/1000%60;
		long min = time/1000/60%60;
		long hour = time/1000/60/60;
		return ""+min/10+min%10+":"+sec/10+sec%10+":"+msec/100;
	}

	class MyInputProcessor implements InputProcessor {

		@Override
		public boolean keyDown(int keycode) {
			return false;
		}

		@Override
		public boolean keyUp(int keycode) {
			return false;
		}

		@Override
		public boolean keyTyped(char character) {
			return false;
		}

		@Override
		public boolean touchDown(int screenX, int screenY, int pointer, int button) {
			touch.set(screenX, screenY, 0);
			camera.unproject(touch);
			if(type == typeScreen.MenuKapy) {
				if(buttonPlay.hit(touch.x, touch.y)){
					type = typeScreen.PlayKapy;
					startGame = TimeUtils.millis();
				}
			}
			if(type == typeScreen.PlayKapy) {
				if(kapy.hit(touch.x, touch.y)){
					counter += 1; countKapy += 1;
					kapy.vx *= 5;
				}
				if(frog.hit(touch.x, touch.y)) {
					counter += 1; countFrog += 1;
					frog.vy *= -1;
				}
				if(kapy_mand.hit(touch.x, touch.y)) {
					counter += 1; countKapy += 1;
					kapy_mand.respawn_mand();
				}
				if(frog2.hit(touch.x, touch.y)) {
					countFrog += 1;
					counter += 1;
				}
			}



			if(type == typeScreen.WinKapy || type == typeScreen.GameOverKapy) {
				if(buttonRestart.hit(touch.x, touch.y)) {
					type = typeScreen.PlayKapy;
					counter = 0; countKapy = 0; countFrog = 0;
					GameOver = false;
					startGame = TimeUtils.millis();
				}
				if(!level_1 & buttonLevel1.hit(touch.x, touch.y)) {
					level_1 = true;
					MINKapy = 6; MINFrog = 2;
					durationGame = 7000;
				}
				if(buttonBack2.hit(touch.x, touch.y)) {
					type = typeScreen.MenuKapy;
					GameOver = false;
				}
			} else {
				if(type == typeScreen.PauseKapy || type == typeScreen.MenuKapy) {
					if(buttonSettings.hit(touch.x, touch.y)){
						type = typeScreen.SettingKapy;
					}
				}else if(type == typeScreen.SettingKapy){
					if(buttonMusic.hit(touch.x, touch.y)) {
						music = !music;
					}
					if(buttonSound.hit(touch.x, touch.y)){
						sound = !sound;
					}
					if(buttonLove.hit(touch.x, touch.y)){
						loves = true;
					}
					if(buttonBack.hit(touch.x, touch.y)){
						type = typeScreen.MenuKapy;
					}
				}
			}

			if(type == typeScreen.WinKapy & level_1) {
				if(buttonLevel2.hit(touch.x, touch.y)) {
					level_1 = false;
					MINKapy = 11; MINFrog = 5;
					durationGame = 15000;
				}
			}

			if(type == typeScreen.GameOverKapy & level_1) {
				if(buttonLevel2.hit(touch.x, touch.y)) {
					hit2 = !hit2;
				}
			}
			return false;
		}

		@Override
		public boolean touchUp(int screenX, int screenY, int pointer, int button) {
			return false;
		}

		@Override
		public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
			return false;
		}

		@Override
		public boolean touchDragged(int screenX, int screenY, int pointer) {
			return false;
		}

		@Override
		public boolean mouseMoved(int screenX, int screenY) {
			return false;
		}

		@Override
		public boolean scrolled(float amountX, float amountY) {
			return false;
		}
	}


	public enum typeScreen {
		MenuKapy,
		PlayKapy,
		SettingKapy,
		PauseKapy,
		WinKapy,
		GameOverKapy
	}
}



