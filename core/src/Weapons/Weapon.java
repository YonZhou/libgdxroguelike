package Weapons;

import Entities.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Weapon extends Entity {
    protected Texture texture;

    protected Sprite sprite;
    public int width;
    public int height;

    public Weapon(int x, int y) {
        super(x, y);
    }
    public Texture getTexture() {return this.texture;}
    public Sprite getSprite() { return sprite;}
}
