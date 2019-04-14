package Animations;

import Entities.BasicZombie;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

// Class to handle zombie animations, note they can only move in 4 directions
public class BasicZombieAnimations extends LivingAnimation{
    public static float FRAME_DURATION = 1f/4f;
    public static int FRAMES_WIDTH = 3;
    public static int FRAMES_HEIGHT = 4;


    public BasicZombieAnimations() {
        TextureRegion[][] animationRegions = TextureRegion.split(BasicZombie.Character,
                BasicZombie.Character.getWidth()/FRAMES_WIDTH,
                BasicZombie.Character.getHeight()/FRAMES_HEIGHT);

        TextureRegion[] down_frames = new TextureRegion[3];
        for(int i = 0; i < FRAMES_WIDTH; i++){
            down_frames[i] = animationRegions[0][i];
        }
        this.walking_down_animation = new Animation<TextureRegion>(FRAME_DURATION, down_frames);

        TextureRegion[] up_frames = new TextureRegion[3];
        for(int i = 0; i < FRAMES_WIDTH; i++){
            up_frames[i] = animationRegions[3][i];
        }
        this.walking_up_animation = new Animation<TextureRegion>(FRAME_DURATION, up_frames);

        TextureRegion[] left_frames = new TextureRegion[3];
        for(int i = 0; i < FRAMES_WIDTH; i++){
            left_frames[i] = animationRegions[1][i];
        }
        this.walking_left_animation = new Animation<TextureRegion>(FRAME_DURATION, left_frames);

        TextureRegion[] right_frames = new TextureRegion[3];
        for(int i = 0; i < FRAMES_WIDTH; i++){
            right_frames[i] = animationRegions[2][i];
        }
        this.walking_right_animation = new Animation<TextureRegion>(FRAME_DURATION, right_frames);

        Texture frames = BasicZombie.Character;
        TextureRegion[][] splitRegion = TextureRegion.split(frames, frames.getWidth()/FRAMES_WIDTH, frames.getHeight()/FRAMES_HEIGHT);
        this.idle_down_animation = new Animation<TextureRegion>(FRAME_DURATION, splitRegion[0][0]);

    }
}
