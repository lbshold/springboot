package top.lconcise.design_demo.design_mode.behavior.memo.improve;

/**
 * @author: liusj
 * @date: 2022/3/30
 */
public class InputText {
    private StringBuilder text = new StringBuilder();

    public String getText() {
        return text.toString();
    }

    public void append(String input) {
        text.append(input);
    }

    public SnapShot createSnapshot() {
        return new SnapShot(text.toString());
    }

    public void restoreSnapshot(SnapShot snapShot) {
        this.text.replace(0, this.text.length(), snapShot.getText());
    }

    @Override
    public String toString() {
        return text.toString();
    }
}
