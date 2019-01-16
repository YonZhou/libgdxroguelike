package Entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Entity {
    protected Sprite s;
    protected Vector2 position;
    private boolean movingUp, movingDown, movingRight, movingLeft;
    protected State currentState;
    private int speed = 10;
    protected int health = 100;
    protected int maxhealth = 100;
    protected int width;
    protected int height;

    public Entity(int x, int y){
        this.position = new Vector2(x,y);
    }
    public Entity(int x, int y, Sprite s){
        this.position = new Vector2(x,y);
        this.s = s;
    }


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

    public State getCurrentState() { return this.currentState; }

    public void setSprite(Sprite s){
        this.s = s;
    }

    public void move(int x, int y){
        this.position.set(this.position.x + x, this.position.y + y);
        //moveSprite(x, y);
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
        // omni
        if(movingUp && !movingRight && !movingDown && movingLeft) {
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
        else if(movingUp && !movingDown) {
            changeDirection(State.WALKING_UP);
        }
        else if(movingRight && !movingLeft) {
            changeDirection(State.WALKING_RIGHT);
        }
        else if(!movingUp && movingDown) {
            changeDirection(State.WALKING_DOWN);
        }
        else if(!movingRight && movingLeft) {
            changeDirection(State.WALKING_LEFT);
        }
        else if(!movingUp && !movingRight && !movingDown && !movingLeft && this.currentState.isType(State.State_Type.MOVING)){
            State previousDirection = this.currentState;
            switch(previousDirection){
                case WALKING_UP:
                    changeDirection(State.UP_IDLE);
                    break;
                case WALKING_DOWN:
                    changeDirection(State.DOWN_IDLE);
                    break;
                case WALKING_LEFT:
                    changeDirection(State.LEFT_IDLE);
                    break;
                case WALKING_RIGHT:
                    changeDirection(State.RIGHT_IDLE);
                    break;
                case WALKING_UP_LEFT:
                    changeDirection(State.UP_LEFT_IDLE);
                    break;
                case WALKING_UP_RIGHT:
                    changeDirection(State.UP_RIGHT_IDLE);
                    break;
                case WALKING_DOWN_LEFT:
                    changeDirection(State.DOWN_LEFT_IDLE);
                    break;
                case WALKING_DOWN_RIGHT:
                    changeDirection(State.DOWN_RIGHT_IDLE);
                    break;
                default:
                    changeDirection(State.STANDING);
                    break;
            }
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
    public int getX() { return (int) this.position.x; }
    public int getY() { return (int) this.position.y; }
}
