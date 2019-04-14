package mainGame;

import Entities.Player;
import Tiles.BasicMap;
import Tiles.gameMap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.SpriteCache;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class World {
    private Level currentLevel;
    private Player player;
    private SpriteCache sb;

    public World(SpriteCache sb, Player p) {
        this.sb = sb;
        this.player = p;
    }

    public Level generateNewBasicLevel() {
        this.currentLevel = new BasicLevel(sb) ;
        this.player.setLevel(currentLevel);
        currentLevel.generateEnemies();
        return this.currentLevel;
    }

    public void setLevel(Level level) {
        this.currentLevel = level;
    }

    public gameMap getCurrentMap() {
        return this.currentLevel.getMap() ;
    }

    public Level getCurrentLevel() { return this.currentLevel; }
}
