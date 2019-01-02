package Tiles;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class MapGenerator {
    private SpriteBatch sb;
    public final int tileWidth = 16;
    public final int tileHeight = 16;


    public MapGenerator(SpriteBatch sb){
        this.sb = sb;
    }

    public int[][] generateIntMap(int w, int h){
        int[][] map = new int[w][h];

        for(int i=0; i<w; i++){
            for(int j=0; j<h; j++){
                map[i][j] = 1;
            }
        }


        return map;
    }

//    public BasicMap generateMap(){
//        int width = 200;
//        int height = 200;
//
//
//
//
//        int[][] map = new int[width][height];
//        //BasicMap finalMap = new BasicMap(sb);
//        TiledMapTileLayer mainLayer = new TiledMapTileLayer(width, height, tileWidth, tileHeight);
//
//        for(int i=0; i<width; i++){
//            for(int j=0; j<height; j++){
//                TiledMapTileLayer.Cell c = new TiledMapTileLayer.Cell();
//                //c.setTile();
//
//                mainLayer.setCell(i,j,c);
//            }
//        }
//
//
//
//        return finalMap;
//    }


}
