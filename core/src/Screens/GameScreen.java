package Screens;

import Entities.Entity;
import Input.GameInput;
import Tiles.BasicMap;
import Tiles.gameMap;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.SpriteCache;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import gui.mainGUI;
import mainGame.Platformer;
import mainGame.World;

public class GameScreen extends AbstractScreen{
    private Sprite playerSprite;
    private OrthographicCamera cam;
    private Viewport gamePort;
    private Stage mainStage;
    private gameMap currentMap;
    private SpriteBatch sBatch;
    private Entity playerEntity;
    private World world;
    private mainGUI gui;
    private GameInput gameInput;


    public GameScreen(Game g){
        super(g);

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        this.cam = new OrthographicCamera(1280,720);
        this.gamePort = new FitViewport(1280, 720, cam);

        cam.position.set(w/2f, h/2f, 0);
        cam.update();


        this.sBatch = ((Platformer)(game)).batch;

        this.mainStage = new Stage();

//        this.testChar = new Sprite(new Texture("basicChar.png"));
//        testChar.setSize(100,100);
        this.world = ((Platformer)(game)).getWorld();
        this.currentMap = world.generateNewBasicMap();
        this.playerSprite = ((Platformer)game).getPlayer().getSprite() ;
        this.playerEntity = ((Platformer)game).getPlayer() ;

        this.gui = new mainGUI(sBatch, ((Platformer)game).getPlayer());

        this.gameInput = new GameInput(playerEntity);
    }


    @Override
    public void resize(int width, int height) {
        gamePort.update(width,height);

    }

    @Override
    public void show() {
        sBatch.setProjectionMatrix(cam.combined);
        Gdx.input.setInputProcessor(gameInput);
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        playerEntity.updateMove();

        updateCamera(playerSprite);
        currentMap.render(cam);

        gui.sBatch.setProjectionMatrix(gui.stage.getCamera().combined);

        gui.render();

        sBatch.setProjectionMatrix(cam.combined);
        sBatch.begin();
        playerSprite.draw(sBatch);
        sBatch.end();

    }

    private void updateCamera(Sprite s){
        cam.position.set(s.getX(), s.getY(), 0);
        cam.update();
    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

}
