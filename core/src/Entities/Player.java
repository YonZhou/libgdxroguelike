package Entities;

import Animations.PlayerAnimations;
import Input.Direction;
import Tiles.*;
import Tiles.gameMap;
import Weapons.Sword;
import Weapons.Weapon;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player extends Living{
    public static int BASE_HEIGHT = 100;
    public static int BASE_WIDTH = 100;
    protected int stamina = 100;
    protected int maxStamina = 100;
    public static Texture Character = new Texture("stella_walk.png");
    private int gridX;
    private int gridY;

    public Player(int x, int y) {
        super(x, y);
        this.width = BASE_WIDTH;
        this.height = BASE_HEIGHT;
        this.maxhealth = 100;
        this.health = maxhealth;
        this.currentState = State.STANDING;
        this.attackingState = State.NOT_ATTACKING;
        this.equippedWeapon = new Sword(0,0, this);
        this.animations = new PlayerAnimations();
        TextureRegion[][] frames = TextureRegion.split(Character, 200, 200);
    }

    @Override
    public Animation<TextureRegion> getCurrentAnimation() {
        if(this.currentState == State.WALKING_DOWN)
            return this.animations.getWalking_down_animation();
        if(this.currentState == State.WALKING_LEFT)
            return this.animations.getWalking_left_animation();
        if(this.currentState == State.WALKING_RIGHT)
            return this.animations.getWalking_right_animation();
        if(this.currentState == State.WALKING_UP)
            return this.animations.getWalking_up_animation();
        if(this.currentState == State.DOWN_IDLE)
            return this.animations.getIdle_down_animation();
        if(this.currentState == State.LEFT_IDLE)
            return this.animations.getIdle_left_animation();
        if(this.currentState == State.RIGHT_IDLE)
            return this.animations.getIdle_right_animation();
        if(this.currentState == State.UP_IDLE)
            return this.animations.getIdle_up_animation();
        if(this.currentState == State.WALKING_UP_LEFT)
            return this.animations.getWalking_up_left_animation();
        if(this.currentState == State.WALKING_UP_RIGHT)
            return this.animations.getWalking_up_right_animation();
        if(this.currentState == State.WALKING_DOWN_LEFT)
            return this.animations.getWalking_down_left_animation();
        if(this.currentState == State.WALKING_DOWN_RIGHT)
            return this.animations.getWalking_down_right_animation();
        if(this.currentState == State.DOWN_LEFT_IDLE)
            return this.animations.getIdle_down_left_animation();
        if(this.currentState == State.DOWN_RIGHT_IDLE)
            return this.animations.getIdle_down_right_animation();
        if(this.currentState == State.UP_LEFT_IDLE)
            return this.animations.getIdle_up_left_animation();
        if(this.currentState == State.UP_RIGHT_IDLE)
            return this.animations.getIdle_up_right_animation();
        else{
            //System.out.println("else invoked");
            return this.animations.getIdle_down_animation();
        }
    }

    @Override
    public void move(int x, int y){
        if(!collision(x, y)){
            super.move(x, y);
        }
    }

    public void attack(int x, int y){
        this.equippedWeapon.attack(x, y);
    }

    public void updatePlayerLocation() {

    }


    public int getHealth() {
        return this.health;
    }

    public int getStamina() {
        return this.stamina;
    }

    public int getMaxStaminaStamina() {
        return this.maxStamina;
    }

}
