package top.lconcise.design_demo.design_mode.behavior.state.improve;

/**
 * @author: liusj
 * @date: 2022/3/28
 */
public class SuperMario implements IMario {

    private static final SuperMario instance = new SuperMario();

    public static SuperMario getInstance() {
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
