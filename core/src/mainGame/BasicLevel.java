package mainGame;

import Tiles.BasicMap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.SpriteCache;

public class BasicLevel extends Level{
    public BasicLevel(SpriteCache sc) {
        this.currentMap = new BasicMap(sc);
        level = 1;
    }
}
