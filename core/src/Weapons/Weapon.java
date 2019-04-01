package Weapons;

import Entities.Entity;
import com.badlogic.gdx.graphics.Texture;

public class Weapon extends Entity {
    protected Texture texture;
    public int width;
    public int height;

    public Weapon(int x, int y) {
        super(x, y);
    }
    public Texture getTexture() {return this.texture;}
}
