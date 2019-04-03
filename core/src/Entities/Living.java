package Entities;

import Weapons.Weapon;

public class Living extends Entity{
    private boolean movingUp, movingDown, movingRight, movingLeft;
    protected State currentState;
    protected int speed = 10;
    protected int health = 100;
    protected int maxhealth = 100;
    protected Weapon equippedWeapon;
    public State attackingState;

    public Living(int x, int y) {
        super(x, y);
    }

    public Weapon getWeapon() {
        return this.equippedWeapon;
    }

    public void updateMove(){
        updateDirection();
        //System.out.println(currentState);
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

    public void setAttackingState(State s) {this.attackingState = s;}

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
    public State getCurrentState() { return this.currentState; }
    public void drawHealthBar() {
        double percent = (double)this.health / this.maxhealth;
    }
}
