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
    protected double rotation;
    protected double cooldown;
    protected boolean ready = true;
    // time passed since attack started
    public double runTime;

    // time to use in seconds
    protected int timeToUse = 1;

    protected boolean active = false;


    public Weapon(int x, int y, Living e) {
        super(x, y);
        this.state = State.NOT_ATTACKING;
        this.equippedE = e;
        rotation = 0;
    }
    public Texture getTexture() { return this.texture;}
    public Sprite getSprite() { return sprite;}
    public boolean isReady() { return this.ready;}
    public boolean isActive() { return this.active;}

    public void updateCooldown() {
        if(runTime > timeToUse + cooldown) {
            this.ready = true;
        }
    }

    public void addRunTime(double time) {
        this.runTime += time;
    }

    // called when weapon attacks
    public void attack(int x, int y){}

    // called during every timestep of game, runs while weapon is active
    public void updateWeapon() {
    }
}
