package Weapons;

import Entities.Entity;
import Entities.Living;
import Entities.State;
import Input.Direction;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Weapon extends Entity {
    protected Texture texture;

    protected Sprite sprite;
    public int width;
    public int height;
    protected State state;
    protected Living equippedE;

    public Weapon(int x, int y, Living e) {
        super(x, y);
        this.state = State.NOT_ATTACKING;
        this.equippedE = e;
    }
    public Texture getTexture() {return this.texture;}
    public Sprite getSprite() { return sprite;}

    public void attack(int x, int y){};
    public void updateWeapon(double deltaTime) {
    }
}
