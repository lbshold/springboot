package top.lconcise.design_demo.design_mode.behavior.state.improve;

/**
 * @author: liusj
 * @date: 2022/3/28
 */
public interface IMario {
    String getName();

    // 以下是定义的事件
    void obtainMushRoom(MarioStateMachine03 marioStateMachine03);

    void obtainCape(MarioStateMachine03 marioStateMachine03);

    void obtainFireFlower(MarioStateMachine03 marioStateMachine03);

    void meetMonster(MarioStateMachine03 marioStateMachine03);
}
