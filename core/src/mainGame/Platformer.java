package mainGame;

import Entities.Player;
import Screens.MenuScreen;
import Tiles.BasicMap;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.SpriteCache;

public class Platformer extends Game {

    public SpriteBatch batch;
    public SpriteCache cache;
    private InputMultiplexer mainMultiplexer;
    private World world;
    private Player player;

    @Override
    public void create () {
        batch = new SpriteBatch();
        cache = new SpriteCache(BasicMap.basic_height * BasicMap.basic_width * 10, false);

        setScreen(new MenuScreen(this));

        this.player = new Player(0, 0);
        player.setSize(Player.BASE_WIDTH, Player.BASE_HEIGHT);

        this.world = new World(cache, player) ;

//        mainMultiplexer = new InputMultiplexer();
//        mainMultiplexer.addProcessor(new MenuInput()) ;
//        Gdx.input.setInputProcessor(mainMultiplexer);
    }

    public Player getPlayer() {
        return this.player;
    }

    public World getWorld() { return this.world ; }

    @Override
    public void render () {
//        Gdx.gl.glClearColor(0, 1, 0, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        batch.begin();
//        batch.draw(img, 0, 0);
//        batch.end();
        super.render();
    }

    @Override
    public void dispose () {
//        batch.dispose();
//        img.dispose();
        super.dispose();
    }

    @Override
    public void pause(){
        super.pause();
    }

    @Override
    public void resume(){
        super.resume();
    }

    @Override
    public void resize(int width, int height){
        super.resize(width,height);
    }
}
