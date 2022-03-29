package top.lconcise.design_demo.design_mode.behavior.state.improve;

import top.lconcise.design_demo.design_mode.behavior.state.State;

/**
 * @author: liusj
 * @date: 2022/3/28
 */
public class SmallMario implements IMario {

    private static final SmallMario instance = new SmallMario();

    private SmallMario() {
    }

    public static SmallMario getInstance() {
        return instance;
    }

    @Override
    public String getName() {
        return State.SMALL.name();
    }

    @Override
    public void obtainMushRoom(MarioStateMachine03 marioStateMachine) {
        marioStateMachine.setScore(marioStateMachine.getScore() + 100);
        marioStateMachine.setCurrentState(SuperMario.getInstance());
    }

    @Override
    public void obtainCape(MarioStateMachine03 marioStateMachine) {
        marioStateMachine.setScore(marioStateMachine.getScore() + 200);
        marioStateMachine.setCurrentState(CapeMario.getInstance());
    }

    @Override
    public void obtainFireFlower(MarioStateMachine03 marioStateMachine) {
        marioStateMachine.setScore(marioStateMachine.getScore() + 300);
        marioStateMachine.setCurrentState(FireMario.getInstance());
    }

    @Override
    public void meetMonster(MarioStateMachine03 marioStateMachine) {
        // do nothing
    }
}
