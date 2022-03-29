package top.lconcise.design_demo.design_mode.behavior.state.improve;

/**
 * @author: liusj
 * @date: 2022/3/28
 */
public class FireMario implements IMario {

    private static final FireMario instance = new FireMario();

    public static FireMario getInstance() {
        return instance;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine03 marioStateMachine) {

    }

    @Override
    public void obtainCape(MarioStateMachine03 marioStateMachine) {

    }

    @Override
    public void obtainFireFlower(MarioStateMachine03 marioStateMachine) {

    }

    @Override
    public void meetMonster(MarioStateMachine03 marioStateMachine) {

    }
}
