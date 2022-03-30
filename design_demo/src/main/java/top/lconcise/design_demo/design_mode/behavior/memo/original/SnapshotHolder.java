package top.lconcise.design_demo.design_mode.behavior.memo.original;

import jdk.internal.util.xml.impl.Input;

import java.util.Stack;

/**
 * @author: liusj
 * @date: 2022/3/30
 */
public class SnapshotHolder {
    private Stack<InputText> snapshots = new Stack<>();

    public InputText popSnapshot() {
        return snapshots.pop();
    }

    public void pushSnapshot(InputText inputText){
        InputText deepClonedInputText = new InputText();
        deepClonedInputText.setText(inputText.getText());
        snapshots.push(deepClonedInputText);
    }
}
