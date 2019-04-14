package Animations;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class LivingAnimation {
    protected Animation animation;
    protected Animation<TextureRegion> standing_animation;
    protected Animation<TextureRegion> walking_up_animation;
    protected Animation<TextureRegion> walking_down_animation;
    protected Animation<TextureRegion> walking_left_animation;
    protected Animation<TextureRegion> walking_right_animation;
    protected Animation<TextureRegion> walking_up_left_animation;
    protected Animation<TextureRegion> walking_up_right_animation;
    protected Animation<TextureRegion> walking_down_left_animation;
    protected Animation<TextureRegion> walking_down_right_animation;
    protected Animation<TextureRegion> idle_up_animation;
    protected Animation<TextureRegion> idle_down_animation;
    protected Animation<TextureRegion> idle_left_animation;
    protected Animation<TextureRegion> idle_right_animation;
    protected Animation<TextureRegion> idle_up_left_animation;
    protected Animation<TextureRegion> idle_up_right_animation;
    protected Animation<TextureRegion> idle_down_left_animation;
    protected Animation<TextureRegion> idle_down_right_animation;

    public Animation getAnimation() {
        return this.animation;
    }


    public Animation<TextureRegion> getWalking_down_animation(){
        return this.walking_down_animation;
    }
    public Animation<TextureRegion> getWalking_up_animation() {
        return walking_up_animation;
    }

    public Animation<TextureRegion> getWalking_left_animation() {
        return walking_left_animation;
    }

    public Animation<TextureRegion> getWalking_right_animation() {
        return walking_right_animation;
    }

    public Animation<TextureRegion> getIdle_up_animation() {
        return idle_up_animation;
    }

    public Animation<TextureRegion> getIdle_down_animation() {
        return idle_down_animation;
    }

    public Animation<TextureRegion> getIdle_left_animation() {
        return idle_left_animation;
    }

    public Animation<TextureRegion> getIdle_right_animation() {
        return idle_right_animation;
    }


    public Animation<TextureRegion> getWalking_up_left_animation() {
        return walking_up_left_animation;
    }

    public Animation<TextureRegion> getWalking_up_right_animation() {
        return walking_up_right_animation;
    }

    public Animation<TextureRegion> getWalking_down_left_animation() {
        return walking_down_left_animation;
    }

    public Animation<TextureRegion> getWalking_down_right_animation() {
        return walking_down_right_animation;
    }


    public Animation<TextureRegion> getIdle_up_left_animation() {
        return idle_up_left_animation;
    }

    public Animation<TextureRegion> getIdle_up_right_animation() {
        return idle_up_right_animation;
    }

    public Animation<TextureRegion> getIdle_down_left_animation() {
        return idle_down_left_animation;
    }

    public Animation<TextureRegion> getIdle_down_right_animation() {
        return idle_down_right_animation;
    }
}
