package Entities;

import Tiles.*;
import Tiles.gameMap;
import com.badlogic.gdx.graphics.g2d.Sprite;
import mainGame.World;

public class Player extends Entity{
    public static int BASE_HEIGHT = 100;
    public static int BASE_WIDTH = 100;
    private int gridX;
    private int gridY;
    private int width;
    private int height;
    private gameMap currentMap;

    public Player(int x, int y, Sprite s) {
        super(x, y, s);
        this.width = BASE_WIDTH;
        this.height = BASE_HEIGHT;
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
