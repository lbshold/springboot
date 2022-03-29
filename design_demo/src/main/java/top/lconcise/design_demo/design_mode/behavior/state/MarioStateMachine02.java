package top.lconcise.design_demo.design_mode.behavior.state;

/**
 * @author: liusj
 * @date: 2022/3/28
 */
public class MarioStateMachine02 {
    private int score;
    private State currentState;

    private static final State[][] transition = {
            {State.SUPER, State.CAPE, State.FIRE, State.SMALL},
            {State.SUPER, State.CAPE, State.FIRE, State.SMALL},
            {State.CAPE, State.CAPE, State.CAPE, State.SMALL},
            {State.FIRE, State.FIRE, State.FIRE, State.SMALL}
    };

    private static final int[][] actionTable = {
            {100, 200, 300, 0},
            {0, 200, 300, -100},
            {0, 0, 0, -200},
            {0, 0, 0, -300}
    };

    public MarioStateMachine02(int score, State currentState) {
        this.score = score;
        this.currentState = currentState;
    }

    public void obtainMushRoom() {
        executeEvent(Event.GOT_MUSHROOM);
    }

    public void obtainCape() {
        executeEvent(Event.GOT_CAPE);
    }

    public void obtainFireFlower() {
        executeEvent(Event.GOT_FIRE);
    }

    public void meetMonster() {
        executeEvent(Event.MET_MONSTER);
    }

    private void executeEvent(Event event) {
        int stateValue = currentState.getValue();
        int eventValue = event.getValue();
        this.currentState = transition[stateValue][eventValue];
        this.score += actionTable[stateValue][eventValue];
    }
}
