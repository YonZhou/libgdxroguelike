package Entities;

import Animations.PlayerAnimations;
import Tiles.*;
import Tiles.gameMap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player extends Entity{
    public static int BASE_HEIGHT = 100;
    public static int BASE_WIDTH = 100;
    public static Texture Character = new Texture("stella_walk.png");
    private PlayerAnimations animations;
    private int gridX;
    private int gridY;
    private State attackingState;
    private gameMap currentMap;

    public Player(int x, int y) {
        super(x, y);
        this.width = BASE_WIDTH;
        this.height = BASE_HEIGHT;
        this.maxhealth = 100;
        this.health = maxhealth;
        this.currentState = State.STANDING;
        this.attackingState = State.NOT_ATTACKING;
        TextureRegion[][] frames = TextureRegion.split(Character, 200, 200);
        this.animations = new PlayerAnimations();
    }

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

    public void setMap(gameMap map) {
        this.currentMap = map;
    }

    @Override
    public void move(int x, int y){
        if(!collision(x, y)){
            super.move(x, y);
        }
    }

    public void attack(int direction){
        sword_swing_1(direction);

    }
    public void sword_swing_1(int direction){
        switch(direction){
            case 0:
                return;
            case 1:
                return;
            case 2:
                return;
            case 3:
                return;
        }
    }


    public void updatePlayerLocation() {

    }

    public boolean collision(int x, int y) {
        int px = (int) position.x + x;
        int py = (int) position.y + y;
        if(px < 0 || py < 0){
            return true;
        }

        if(px + width >= (currentMap.getWidth() )* Tiles.TILE_SIZE || py + height>= (currentMap.getHeight()) * Tiles.TILE_SIZE) {
            return true;
        }
        if(currentMap.getTilePixels(px, py).isBlocked()){
            return true;
        }
        if(currentMap.getTilePixels(px+width, py).isBlocked()){
            return true;
        }
        if(currentMap.getTilePixels(px+width, py+height).isBlocked()){
            return true;
        }
        if(currentMap.getTilePixels(px, py+height).isBlocked()){
            return true;
        }
        return false;
    }

    public int getHealth() {
        return this.health;
    }

}
