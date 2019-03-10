package Animations;

import Entities.BasicZombie;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BasicZombieAnimations {
    public static float FRAME_DURATION = 1f/4f;
    public static int FRAMES_WIDTH = 3;
    public static int FRAMES_HEIGHT = 4;
    private Animation<TextureRegion> walking_up_animation;
    private Animation<TextureRegion> walking_down_animation;
    private Animation<TextureRegion> walking_left_animation;
    private Animation<TextureRegion> walking_right_animation;

    public BasicZombieAnimations() {
        TextureRegion[][] animationRegions = TextureRegion.split(BasicZombie.Character,
                BasicZombie.Character.getWidth()/FRAMES_WIDTH,
                BasicZombie.Character.getHeight()/FRAMES_HEIGHT);

        TextureRegion[] down_frames = new TextureRegion[3];
        for(int i = 0; i < FRAMES_WIDTH; i++){
            down_frames[i] = animationRegions[0][i];
        }
        this.walking_down_animation = new Animation<TextureRegion>(FRAME_DURATION, down_frames);
    }
}
