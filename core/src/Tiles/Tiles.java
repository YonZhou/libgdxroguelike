package Tiles;

import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;

public class Tiles {
    public static HashMap<Integer, Texture> textureMap;
    public static final int TILE_SIZE = 256;

    public Tiles(){
        this.textureMap = new HashMap<Integer, Texture>();
    }

    public static void putInMap(){

    }

    public static Texture getTileTexture(int i){
        return textureMap.get(i);
    }

}
