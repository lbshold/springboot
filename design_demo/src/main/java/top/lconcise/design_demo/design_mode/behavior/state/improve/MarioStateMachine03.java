package top.lconcise.design_demo.design_mode.behavior.state.improve;

/**
 * @author: liusj
 * @date: 2022/3/28
 */
public class MarioStateMachine03 {
    private int score;
    private IMario currentState; // 不在使用枚举来表示状态

    public MarioStateMachine03() {
        this.score = 0;
        this.currentState = SmallMario.getInstance();
    }

    public void obtainMushRoom() {
        this.currentState.obtainMushRoom(this);
    }

    public void obtainCape() {
        this.currentState.obtainCape(this);
    }

    public void obtainFireFlower() {
        this.currentState.obtainFireFlower(this);
    }

    public void meetMonster() {
        this.currentState.meetMonster(this);
    }

    public int getScore() {
        return score;
    }

    public IMario getCurrentState() {
        return currentState;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCurrentState(IMario currentState) {
        this.currentState = currentState;
    }
}
