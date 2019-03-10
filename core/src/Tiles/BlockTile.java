package Tiles;

import com.badlogic.gdx.graphics.Texture;

public class BlockTile extends Tile{
    //change this texture
    public static Texture text = new Texture("basicTile.png");
    public BlockTile(){
        this.setTexture(text);
        this.setId(0);
        this.blocked = true;
    }

}
