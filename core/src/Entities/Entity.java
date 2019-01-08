package Entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Entity {
    protected Sprite s;

    protected Vector2 position;
    private boolean movingUp, movingDown, movingRight, movingLeft;
    protected State currentState;
    private int speed = 10;

    public Entity(int x, int y, Sprite s){
        this.position = new Vector2(x,y);
        this.s = s;
    }

    public void setSprite(Sprite s){
        this.s = s;
    }

    public void move(int x, int y){
        this.position.set(this.position.x + x, this.position.y + y);
        moveSprite(x, y);
    }

    public Sprite getSprite(){ return this.s; }

    public void moveSprite(int x, int y){
        this.s.setPosition(this.position.x, this.position.y ) ;
    }

    public void updateMove(){
        updateDirection();
        System.out.println(currentState);
        if(movingDown)
            move(0, -speed);
        if(movingUp)
            move(0, +speed);
        if(movingLeft)
            move(-speed, 0);
        if(movingRight)
            move(speed,0);

    }
    public void changeDirection(State s) {
        this.currentState = s;
    }

    public void updateDirection() {
        if(movingUp && !movingRight && !movingDown && !movingLeft) {
            changeDirection(State.WALKING_UP);
        }
        else if(!movingUp && movingRight && !movingDown && !movingLeft) {
            changeDirection(State.WALKING_RIGHT);
        }
        else if(!movingUp && !movingRight && movingDown && !movingLeft) {
            changeDirection(State.WALKING_DOWN);
        }
        else if(!movingUp && !movingRight && !movingDown && movingLeft) {
            changeDirection(State.WALKING_LEFT);
        }
        // omni
        else if(movingUp && !movingRight && !movingDown && movingLeft) {
            changeDirection(State.WALKING_UP_LEFT);
        }
        else if(movingUp && movingRight && !movingDown && !movingLeft) {
            changeDirection(State.WALKING_UP_RIGHT);
        }
        else if(!movingUp && !movingRight && movingDown && movingLeft) {
            changeDirection(State.WALKING_DOWN_LEFT);
        }
        else if(!movingUp && movingRight && movingDown && !movingLeft) {
            changeDirection(State.WALKING_DOWN_RIGHT);
        }

//        else {
//            changeDirection(State.STANDING);
//        }

    }

    public void setMovingUp(Boolean set){
        movingUp = set;
    }
    public void setMovingDown(Boolean set){
        movingDown = set;
    }
    public void setMovingRight(Boolean set){
        movingRight = set;
    }
    public void setMovingLeft(Boolean set){
        movingLeft = set;
    }

    public Vector2 getPosition() { return this.position; }
}
