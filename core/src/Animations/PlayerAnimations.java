package Animations;

import Entities.Player;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class PlayerAnimations {
    private Texture frames;
    public static float FRAME_DURATION = 1f/4f;
    public static int FRAMES_WIDTH = 4;
    public static int FRAMES_HEIGHT = 8;
    private Animation<TextureRegion> standing_animation;
    private Animation<TextureRegion> walking_up_animation;
    private Animation<TextureRegion> walking_down_animation;
    private Animation<TextureRegion> walking_left_animation;
    private Animation<TextureRegion> walking_right_animation;
    private Animation<TextureRegion> walking_up_left_animation;
    private Animation<TextureRegion> walking_up_right_animation;
    private Animation<TextureRegion> walking_down_left_animation;
    private Animation<TextureRegion> walking_down_right_animation;
    private Animation<TextureRegion> idle_up_animation;
    private Animation<TextureRegion> idle_down_animation;
    private Animation<TextureRegion> idle_left_animation;
    private Animation<TextureRegion> idle_right_animation;
    private Animation<TextureRegion> idle_up_left_animation;
    private Animation<TextureRegion> idle_up_right_animation;
    private Animation<TextureRegion> idle_down_left_animation;
    private Animation<TextureRegion> idle_down_right_animation;


    public PlayerAnimations() {
        this.frames = Player.Character;
        TextureRegion[][] splitRegion = TextureRegion.split(frames, frames.getWidth()/FRAMES_WIDTH, frames.getHeight()/FRAMES_HEIGHT);
        this.idle_down_animation = new Animation<TextureRegion>(FRAME_DURATION, splitRegion[0][0]);
        this.idle_left_animation = new Animation<TextureRegion>(FRAME_DURATION, splitRegion[1][0]);
        this.idle_right_animation = new Animation<TextureRegion>(FRAME_DURATION, splitRegion[2][0]);
        this.idle_up_animation = new Animation<TextureRegion>(FRAME_DURATION, splitRegion[3][0]);
        this.idle_down_right_animation = new Animation<TextureRegion>(FRAME_DURATION, splitRegion[4][0]);
        this.idle_down_left_animation = new Animation<TextureRegion>(FRAME_DURATION, splitRegion[5][0]);
        this.idle_up_left_animation = new Animation<TextureRegion>(FRAME_DURATION, splitRegion[6][0]);
        this.idle_up_right_animation = new Animation<TextureRegion>(FRAME_DURATION, splitRegion[7][0]);



        // initialize walking down animation
        TextureRegion[] walking_down_frames = new TextureRegion[FRAMES_WIDTH];
        for(int j = 0; j < FRAMES_WIDTH; j++){
            walking_down_frames[j] = splitRegion[0][j];
        }
        this.walking_down_animation = new Animation(FRAME_DURATION, walking_down_frames);

        //initialize walking left animation
        TextureRegion[] walking_left_frames = new TextureRegion[FRAMES_WIDTH];
        for(int j = 0; j < FRAMES_WIDTH; j++){
            walking_left_frames[j] = splitRegion[1][j];
        }
        this.walking_left_animation = new Animation(FRAME_DURATION, walking_left_frames);

        //initialize walking right animation
        TextureRegion[] walking_right_frames = new TextureRegion[FRAMES_WIDTH];
        for(int j = 0; j < FRAMES_WIDTH; j++){
            walking_right_frames[j] = splitRegion[2][j];
        }
        this.walking_right_animation = new Animation(FRAME_DURATION, walking_right_frames);

        // initialize walking up animation
        TextureRegion[] walking_up_frames = new TextureRegion[FRAMES_WIDTH];
        for(int j = 0; j < FRAMES_WIDTH; j++){
            walking_up_frames[j] = splitRegion[3][j];
        }
        this.walking_up_animation = new Animation(FRAME_DURATION, walking_up_frames);

        //initialize walking down right animation
        TextureRegion[] walking_down_right_frames = new TextureRegion[FRAMES_WIDTH];
        for(int j = 0; j < FRAMES_WIDTH; j++){
            walking_down_right_frames[j] = splitRegion[4][j];
        }
        this.walking_down_right_animation = new Animation(FRAME_DURATION, walking_down_right_frames);

        //initialize walking down left animation
        TextureRegion[] walking_down_left_frames = new TextureRegion[FRAMES_WIDTH];
        for(int j = 0; j < FRAMES_WIDTH; j++){
            walking_down_left_frames[j] = splitRegion[5][j];
        }
        this.walking_down_left_animation = new Animation(FRAME_DURATION, walking_down_left_frames);

        //initialize walking up left animation
        TextureRegion[] walking_up_left_frames = new TextureRegion[FRAMES_WIDTH];
        for(int j = 0; j < FRAMES_WIDTH; j++){
            walking_up_left_frames[j] = splitRegion[6][j];
        }
        this.walking_up_left_animation = new Animation(FRAME_DURATION, walking_up_left_frames);

        //initialize walking up right animation
        TextureRegion[] walking_up_right_frames = new TextureRegion[FRAMES_WIDTH];
        for(int j = 0; j < FRAMES_WIDTH; j++){
            walking_up_right_frames[j] = splitRegion[7][j];
        }
        this.walking_up_right_animation = new Animation(FRAME_DURATION, walking_up_right_frames);

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
