package mainGame;

import Entities.Entity;
import Tiles.gameMap;

public class Level {
    protected int height;
    protected int width;
    protected Entity[][] map;
    protected gameMap currentMap;

    public Level() {

    }

    public gameMap getMap() {
        return this.currentMap;
    }
}
