package Entities;

import Input.Direction;
import Tiles.gameMap;
import Tiles.Tiles;
import Weapons.Weapon;
import com.badlogic.gdx.math.Vector2;
import mainGame.Level;


public class Entity {
    //protected Sprite s;
    protected Vector2 position;
    protected int width;
    protected int height;
    protected Level currentLevel;
    public Direction direction;


    public Entity(int x, int y){
        this.position = new Vector2(x,y);
    }
//    public Entity(int x, int y, Sprite s){
//        this.position = new Vector2(x,y);
//        this.s = s;
//    }

    public void setSize(int x, int y){
        this.width = x;
        this.height = y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


//    public void setSprite(Sprite s){
//        this.s = s;
//    }

    public void move(int x, int y){
        this.position.set(this.position.x + x, this.position.y + y);
        //moveSprite(x, y);
    }

//    public Sprite getSprite(){ return this.s; }

//    public void moveSprite(int x, int y){
//        this.s.setPosition(this.position.x, this.position.y ) ;
//    }


    public boolean collision(int x, int y) {
        gameMap currentMap = this.currentLevel.getMap();
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

    public Vector2 getPosition() { return this.position; }
    public void setLevel(Level level) {
        this.currentLevel = level;
    }
    public int getX() { return (int) this.position.x; }
    public int getY() { return (int) this.position.y; }

}
