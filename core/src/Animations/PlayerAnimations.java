package Animations;

import Entities.Player;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class PlayerAnimations {
    private Texture frames;
    public static int FRAMES_WIDTH = 4;
    public static int FRAMES_HEIGHT = 8;
    private Animation<TextureRegion> standing_animation;
    private Animation walking_up_animation;
    private Animation<TextureRegion> walking_down_animation;
    private Animation walking_left_animation;
    private Animation walking_right_animation;

    public PlayerAnimations() {
        this.frames = Player.Character;
        TextureRegion[][] splitRegion = TextureRegion.split(frames, frames.getWidth()/4, frames.getHeight()/8);

        TextureRegion[] walking_down_frames = new TextureRegion[FRAMES_WIDTH];
        for(int j = 0; j < FRAMES_WIDTH; j++){
            walking_down_frames[j] = splitRegion[0][j];
        }
        this.walking_down_animation = new Animation(1f/2f, walking_down_frames);
    }

    public Animation<TextureRegion> getWalking_down_animation(){
        return this.walking_down_animation;
    }
}
