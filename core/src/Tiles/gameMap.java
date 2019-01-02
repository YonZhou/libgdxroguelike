package Tiles;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.SpriteCache;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.maps.tiled.TiledMap;

public abstract class gameMap {
    public SpriteCache batch;
    public Tile[][] map;
    protected int cID;
    protected int height;
    protected int width;

    public gameMap(SpriteCache sb){
        batch = sb;
    }

    public void generateNewMap() {
    }

    public void cache(){

    }

    public void render(OrthographicCamera cam){
//        batch.setProjectionMatrix(cam.combined);
//
//
//        batch.begin();
//
//        for(int i=0; i<height; i++){
//            for(int j=0; j<width; j++){
//                //int t = getTileTypeAt(j,i);
//                //batch.draw(Tiles.getTileTexture(t), j*Tiles.TILE_SIZE, i*Tiles.TILE_SIZE);
//                batch.draw(new Texture("basicTile.png"), j*Tiles.TILE_SIZE, i*Tiles.TILE_SIZE);
//            }
//        }
//        batch.end();
    }

    public int getTileTypeAt(int x, int y){
        return map[x][y].getId();
    }
    public Tile getTileAt(int x, int y) {return map[x][y]; }

    public int getTileTypePixels(int x, int y) {
        int newX = x/Tiles.TILE_SIZE;
        int newY = y/Tiles.TILE_SIZE;
        return getTileTypeAt(newX, newY);
    }

    public Tile getTilePixels(int x, int y) {
        int newX = x/Tiles.TILE_SIZE;
        int newY = y/Tiles.TILE_SIZE;
        return getTileAt(newX, newY);
    }

    public int getWidth() {
        return this.width;
    }
    public int getHeight() {
        return this.height;
    }

}
