package Screens;
import Input.MenuInput;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import mainGame.Platformer;

public class MenuScreen extends AbstractScreen {
//    private Sprite mainLogo;
//    private SpriteBatch spriteB;

    private Stage mainStage;
    private TextButton playButton;
    private Label heading;
    private Image mainLogo;
    private BitmapFont whiteFont;
    private TextureAtlas atlas;
    private Skin skin;
    private SpriteBatch batch;
    private Sprite testChar;


    public MenuScreen(Game g){
        super(g);
        this.batch = ((Platformer)(game)).batch;
        this.mainStage = new Stage(new ScreenViewport(), ((Platformer)(g)).batch);
        this.mainLogo = new Image(new Texture("titleimg1.png"));

        //true for flipped axis, y increases downwards
        this.whiteFont = new BitmapFont(Gdx.files.internal("fonts/bitmapGothicFont.fnt"), false);

        this.atlas = new TextureAtlas("buttons/button.pack");
        this.skin = new Skin(atlas);

    }

    @Override
    public void show(){
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = whiteFont;
        textButtonStyle.up = skin.getDrawable("button.up");
        textButtonStyle.down = skin.getDrawable("button.down");


        playButton = new TextButton("Play", textButtonStyle);
        playButton.setPosition(720/2, 1080/2);

        playButton.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeListener.ChangeEvent event, Actor actor) {
                System.out.println("Changed to game mode");
                game.setScreen(new GameScreen(game));
            }
        });

        mainStage.addActor(mainLogo);
        mainStage.addActor(playButton);

//        MenuInput menuInput = new MenuInput();
//        Gdx.input.setInputProcessor(menuInput);

        Gdx.input.setInputProcessor(mainStage);

    }

    @Override
    public void render(float delta){

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(Gdx.input.isKeyPressed(Input.Keys.ENTER)){
            game.setScreen(new GameScreen(game));
        }


        mainStage.addActor(mainLogo);
        mainStage.act();
        mainStage.draw();

    }


    @Override
    public void hide(){
        dispose();
    }

    @Override
    public void dispose(){
        mainStage.dispose();
    }


}
