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
    private int width;
    private int height;
    private Animation movingUpAnimation;
    private Animation movingDownAnimation;
    private Animation movingRightAnimation;
    private Animation movingLeftAnimation;
    private gameMap currentMap;

    public Player(int x, int y, Sprite s) {
        super(x, y, s);
        this.width = BASE_WIDTH;
        this.height = BASE_HEIGHT;
        this.currentState = State.STANDING;
        TextureRegion[][] frames = TextureRegion.split(Character, 200, 200);
        this.animations = new PlayerAnimations();
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

    public void setSize(int x, int y){
        getSprite().setSize(x, y);
    }


}
