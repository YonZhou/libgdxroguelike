package Screens;

import Animations.PlayerAnimations;
import Entities.Entity;
import Entities.Player;
import Entities.State;
import Input.GameInput;
import Tiles.BasicMap;
import Tiles.gameMap;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import gui.mainGUI;
import mainGame.Platformer;
import mainGame.World;

public class GameScreen extends AbstractScreen{
    private OrthographicCamera cam;
    private Viewport gamePort;
    private Stage mainStage;
    private gameMap currentMap;
    private SpriteBatch sBatch;
    private Player playerEntity;
    private World world;
    private mainGUI gui;
    private GameInput gameInput;
    private float deltaTime;
    private PlayerAnimations test;


    public GameScreen(Game g){
        super(g);
        deltaTime = 0;
        this.test = new PlayerAnimations();

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
        this.currentMap = world.generateNewBasicLevel().getMap();
        this.playerEntity = ((Platformer)game).getPlayer() ;

        this.gui = new mainGUI(sBatch, ((Platformer)game).getPlayer());

        this.gameInput = new GameInput(playerEntity, this);
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
        deltaTime += Gdx.graphics.getDeltaTime();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        playerEntity.updateMove();

        updateCamera(playerEntity);
        currentMap.render(cam);

        gui.sBatch.setProjectionMatrix(gui.stage.getCamera().combined);

        gui.render();

        sBatch.setProjectionMatrix(cam.combined);
        sBatch.begin();
        drawPlayer();
        //sBatch.draw(test.getWalking_down_animation().getKeyFrame(deltaTime,true),0,0);
        sBatch.end();

    }

    // draws the player sprite along with healthbar
    private void drawPlayer() {
        Animation<TextureRegion> a = playerEntity.getCurrentAnimation();
        //assert(a.getKeyFrame(deltaTime, true) != null);
        //System.out.println(a);
        sBatch.draw(a.getKeyFrame(deltaTime, true), playerEntity.getX(), playerEntity.getY(), playerEntity.getWidth(), playerEntity.getHeight());
    }

    private void drawPlayerHealth() {
        
    }

    public void processLeftClick(int screenx, int screeny) {
//        double relativeX = Gdx.graphics.getWidth()/(double)screenx;
//        double relativeY = Gdx.graphics.getHeight()/(double)screeny;
//        System.out.println("x at " + relativeX + ", y at " + relativeY);
        double midx = Gdx.graphics.getWidth()/2;
        double midy = Gdx.graphics.getHeight()/2;
        double relativeX = screenx-midx;
        double relativeY = midy-screeny;
        System.out.println(relativeX + ", " + relativeY);
        double angle = Math.atan2(relativeY, relativeX);
        System.out.println(angle);
        if(angle >= Math.PI/4 && angle < Math.PI/4 * 3){
            System.out.println("top quadrant");
            playerEntity.attack(1);
        } else if (angle >= -Math.PI/4 && angle < Math.PI/4) {
            System.out.println("right quadrant");
        } else if (angle < -Math.PI/4 && angle >= -Math.PI/4 * 3) {
            System.out.println("bottom quadrant");
        } else {
            System.out.println("left quadrant");
        }
    }

    private void updateCursor() {

    }

    private void updateCamera(Entity e){
        cam.position.set(e.getPosition().x, e.getPosition().y, 0);
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
