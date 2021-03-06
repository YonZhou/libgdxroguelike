package Entities;

import Input.Direction;

public enum State {
    STANDING (State_Type.IDLE),
    WALKING_UP (State_Type.MOVING),
    WALKING_DOWN(State_Type.MOVING),
    WALKING_RIGHT(State_Type.MOVING),
    WALKING_LEFT(State_Type.MOVING),
    WALKING_UP_RIGHT(State_Type.MOVING),
    WALKING_UP_LEFT(State_Type.MOVING),
    WALKING_DOWN_RIGHT(State_Type.MOVING),
    WALKING_DOWN_LEFT(State_Type.MOVING),
    UP_IDLE(State_Type.IDLE),
    DOWN_IDLE(State_Type.IDLE),
    LEFT_IDLE(State_Type.IDLE),
    RIGHT_IDLE(State_Type.IDLE),
    UP_RIGHT_IDLE(State_Type.IDLE),
    UP_LEFT_IDLE(State_Type.IDLE),
    DOWN_RIGHT_IDLE(State_Type.IDLE),
    DOWN_LEFT_IDLE(State_Type.IDLE),
    NOT_ATTACKING(State_Type.IDLE),
    SWORD_SWINGING(State_Type.ATTACKING);

    private State_Type type;
    private Direction dir;
    State(State_Type type){
        this.type = type;
    }

    public boolean isType(State_Type type){
        return this.type == type;
    }

    public enum State_Type{
        MOVING,
        IDLE,
        ATTACKING,

    }
}
