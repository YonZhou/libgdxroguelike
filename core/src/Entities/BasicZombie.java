package Entities;

import com.badlogic.gdx.graphics.Texture;

public class BasicZombie extends Enemy{
    public static Texture Character = new Texture("enemies/basic_zombie.png");
    public BasicZombie(int x, int y) {
        super(x, y);
        this.maxhealth = 100;
        this.speed = 5;
    }
}