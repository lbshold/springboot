package top.lconcise.design_demo.design_mode.behavior.state;

/**
 * @author: liusj
 * @date: 2022/3/28
 */
public enum State {
    SMALL(1),
    SUPER(2),
    FIRE(3),
    CAPE(4);

    private int value;

    State(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
