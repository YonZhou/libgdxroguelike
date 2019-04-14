package Entities;

import Animations.BasicZombieAnimations;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BasicZombie extends Enemy{
    //TODO: change this back to correct path
    public static Texture Character = new Texture("basic_zombie.png");

    public static BasicZombieAnimations zanimations = new BasicZombieAnimations();
    public BasicZombie(int x, int y) {
        super(x, y);
        this.maxhealth = 100;
        this.speed = 5;
        this.width = 50;
        this.height = 100;
        this.animations = zanimations;
        this.currentState = State.WALKING_DOWN;
    }

    @Override
    public Animation<TextureRegion> getCurrentAnimation(){
        if(this.currentState == State.WALKING_DOWN)
            return this.animations.getWalking_down_animation();
        if(this.currentState == State.WALKING_LEFT)
            return this.animations.getWalking_left_animation();
        if(this.currentState == State.WALKING_RIGHT)
            return this.animations.getWalking_right_animation();
        if(this.currentState == State.WALKING_UP)
            return this.animations.getWalking_up_animation();
        else{
            return null;
        }
    }
}
