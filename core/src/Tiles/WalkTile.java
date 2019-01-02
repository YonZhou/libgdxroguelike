package Tiles;

import com.badlogic.gdx.graphics.Texture;

public class WalkTile extends Tile{
    public static Texture text = new Texture("basicTile.png");

    public WalkTile(){
        this.setTexture(text);
        this.setId(0);
        this.blocked = false;
    }
}
