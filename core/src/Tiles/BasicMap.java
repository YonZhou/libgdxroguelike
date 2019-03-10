package Tiles;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteCache;

public class BasicMap extends gameMap{
    public static int basic_height = 10;
    public static int basic_width = 10;

    public BasicMap(SpriteCache sb) {
        super(sb);
        this.height = basic_height;
        this.width = basic_width;
        this.map = new Tile[height][width];
        batch = sb;
        cID = 0;
        generateNewMap();
        cache();
    }

    public void generateNewMap() {
        for(int i=0; i<height; i++) {
            for (int j = 0; j < width; j++) {
//                if(i == 5 && j == 5) {
//                    map[i][j] = new BlockTile();
//                } else {
                    map[i][j] = new WalkTile();
//                }
                //System.out.println("i at " + i);
            }
        }
    }

    public void cache(){

        batch.beginCache();

        for(int i=0; i<height; i++) {
            for (int j = 0; j < width; j++) {
                Tile t = map[i][j];
                batch.add(t.getTexture(), j*Tiles.TILE_SIZE, i* Tiles.TILE_SIZE);
                //System.out.println("i at " + i);
            }
        }

        cID = batch.endCache();

    }

    public void render(OrthographicCamera cam) {
        batch.setProjectionMatrix(cam.combined);

        batch.begin();
        batch.draw(0);
        batch.end();
    }
}
