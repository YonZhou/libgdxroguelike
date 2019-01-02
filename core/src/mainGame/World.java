package mainGame;

import Entities.Player;
import Tiles.BasicMap;
import Tiles.gameMap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.SpriteCache;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class World {
    private gameMap currentMap;
    private Player player;
    private SpriteCache sb;

    public World(SpriteCache sb, Player p) {
        this.sb = sb;
        this.player = p;
    }




    public BasicMap generateNewBasicMap() {
        this.currentMap = new BasicMap(sb) ;
        this.player.setMap(currentMap);
        return (BasicMap) this.currentMap;
    }

    public void setMap(gameMap map) {
        this.currentMap = map;
    }

    public gameMap getCurrentMap() {
        return this.currentMap ;
    }
}
