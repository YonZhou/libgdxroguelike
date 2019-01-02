package Tiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMapTile;

public class Tile implements TiledMapTile {
    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;
    public static Tile[] tiles = new Tile[256];
    private int id;
    protected boolean blocked;
    private Texture texture;


    @Override
    public int getId() {
        return this.id;
    }

    public Texture getTexture() { return this.texture; }
    public void setTexture(Texture tex) { this.texture = tex; }
    public boolean isBlocked() { return blocked; }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public BlendMode getBlendMode() {
        return null;
    }

    @Override
    public void setBlendMode(BlendMode blendMode) {

    }

    @Override
    public TextureRegion getTextureRegion() {
        return null;
    }

    @Override
    public void setTextureRegion(TextureRegion textureRegion) {

    }

    @Override
    public float getOffsetX() {
        return 0;
    }

    @Override
    public void setOffsetX(float offsetX) {

    }

    @Override
    public float getOffsetY() {
        return 0;
    }

    @Override
    public void setOffsetY(float offsetY) {

    }

    @Override
    public MapProperties getProperties() {
        return null;
    }

    @Override
    public MapObjects getObjects() {
        return null;
    }
}
