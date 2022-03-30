package top.lconcise.design_demo.design_mode.behavior.memo.improve;

/**
 * @author: liusj
 * @date: 2022/3/30
 */
public class SnapShot {
    private String text;

    public SnapShot(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
