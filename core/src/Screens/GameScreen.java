package Screens;

import Animations.PlayerAnimations;
import Entities.Enemy;
import Entities.Entity;
import Entities.Player;
import Entities.State;
import Input.Direction;
import Input.GameInput;
import Tiles.BasicMap;
import Tiles.gameMap;
import Weapons.Sword;
import Weapons.Weapon;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
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


    public GameScreen(Game g){
        super(g);
        deltaTime = 0;

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
        // this called first
        currentMap.render(cam);

        gui.sBatch.setProjectionMatrix(gui.stage.getCamera().combined);

        gui.render();

        sBatch.setProjectionMatrix(cam.combined);
        sBatch.begin();
        drawObjects();
        drawPlayer();
        updateEnemies();
        //sBatch.draw(test.getWalking_down_animation().getKeyFrame(deltaTime,true),0,0);
        sBatch.end();

    }

    private void updateEnemies() {
        // draw each enemy onto the screen, maybe check if they're within bounds of the screen first
        // also need to update enemy locations
        for(Enemy e : this.world.getCurrentLevel().getEnemies()) {
            if(!isWithinScreen(e.getX(), e.getY())){
                continue;
            }
            Animation<TextureRegion> eAnimation = e.getCurrentAnimation();
            //Animation<TextureRegion> eAnimation = playerEntity.getCurrentAnimation();

            sBatch.draw(eAnimation.getKeyFrame(deltaTime, true), e.getX(), e.getY(), e.getWidth(), e.getHeight());
        }
    }

    // draws the player sprite along with healthbar
    private void drawPlayer() {
        Animation<TextureRegion> a = playerEntity.getCurrentAnimation();
        //assert(a.getKeyFrame(deltaTime, true) != null);
        //System.out.println(a);
        sBatch.draw(a.getKeyFrame(deltaTime, true), playerEntity.getX(), playerEntity.getY(), playerEntity.getWidth(), playerEntity.getHeight());
    }

    private void drawObjects() {
        Weapon wep = playerEntity.getWeapon();

        // handle the logic for cooldowns and if weapon is ready
        if(!wep.isReady()){
            wep.addRunTime(Gdx.graphics.getDeltaTime());
            wep.updateCooldown();
        }

        // handle update for animating weapon motion and drawing it
        if(wep.isActive()){
            wep.getSprite().draw(sBatch);
            wep.updateWeapon();
        }
    }

    private void drawPlayerHealth() {
        
    }

    private void drawPlayers() {

    }

    public void processLeftClick(int screenx, int screeny) {
//        double relativeX = Gdx.graphics.getWidth()/(double)screenx;
//        double relativeY = Gdx.graphics.getHeight()/(double)screeny;
//        System.out.println("x at " + relativeX + ", y at " + relativeY);
        double midx = Gdx.graphics.getWidth()/2;
        double midy = Gdx.graphics.getHeight()/2;
        double relativeX = screenx-midx;
        double relativeY = midy-screeny;

        if(playerEntity.getWeapon() != null && playerEntity.getWeapon().isReady()){
            playerEntity.attack((int)relativeX, (int)relativeY);
        }
    }

    private void updateCamera(Entity e){
        cam.position.set(e.getPosition().x, e.getPosition().y, 0);
        cam.update();
    }

    private boolean isWithinScreen(double x, double y){
        return true;
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
