package Weapons;

import Entities.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Sword extends Weapon {
    private static Texture basicSword = new Texture("Weapons/basic_sword.jpg");

    public Sword(int x, int y) {
        super(x, y);
        this.texture = basicSword;
    }
}
