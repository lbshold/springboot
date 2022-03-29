package top.lconcise.design_demo.design_mode.behavior.state;

/**
 * @author: liusj
 * @date: 2022/3/28
 * <p>
 * 分支逻辑法.
 * <p>
 * 状态、事件(吃了蘑菇)、动作(增加积分)
 */
public class MarioStateMachine {
    private int score;
    private State state;

    public MarioStateMachine(int score, State state) {
        this.score = score;
        this.state = state;
    }

    public void obtainMushRoom() {
        if (state.equals(State.SMALL)) {
            state = State.SUPER;
            score += 100;
        }
    }

    public void obtainCape() {
        if (state.equals(State.SMALL) || state.equals(State.SUPER)) {
            state = State.CAPE;
            score += 200;
        }
    }

    public void obtainFireFlower() {
        if (state.equals(State.SMALL) || state.equals(State.SUPER)) {
            state = State.FIRE;
            score += 300;
        }
    }

    public void meetMonster() {
        if (state.equals(State.CAPE)) {
            state = State.SMALL;
            score -= 200;
        }
        if (state.equals(State.SUPER)) {
            state = State.SMALL;
            score -= 100;
        }
        if (state.equals(State.FIRE)) {
            state = State.SMALL;
            score -= 300;
        }
    }

    public int getScore() {
        return score;
    }

    public State getCurrentState() {
        return state;
    }
}


