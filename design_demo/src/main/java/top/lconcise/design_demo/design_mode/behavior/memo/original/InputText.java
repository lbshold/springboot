package top.lconcise.design_demo.design_mode.behavior.memo.original;

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

    public void setText(String text) {
        this.text.replace(0, this.text.length(), text);
    }
}
