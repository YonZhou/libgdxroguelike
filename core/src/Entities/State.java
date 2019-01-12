package Entities;

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
    RIGHT_IDLE(State_Type.IDLE);

    private State_Type type;
    State(State_Type type){
        this.type = type;
    }

    public boolean isType(State_Type type){
        return this.type == type;
    }

    public enum State_Type{
        MOVING,
        IDLE
    }
}
