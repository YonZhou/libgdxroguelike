package Weapons;

import Entities.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Sword extends Weapon {
    private static Texture basicSword = new Texture("Weapons/basic_sword.png");
    protected int reach;


    public Sword(int x, int y) {
        super(x, y);
        this.texture = basicSword;
        this.width = 100;
        this.height = 100;
    }
}
