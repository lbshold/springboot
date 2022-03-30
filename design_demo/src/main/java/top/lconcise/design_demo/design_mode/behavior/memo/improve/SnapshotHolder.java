package top.lconcise.design_demo.design_mode.behavior.memo.improve;

import java.util.Stack;

/**
 * @author: liusj
 * @date: 2022/3/30
 */
public class SnapshotHolder {
    private Stack<SnapShot> snapShots = new Stack<>();

    public SnapShot popSnapshot() {
        return snapShots.pop();
    }

    public void pushSnapshot(SnapShot snapShot) {
        snapShots.push(snapShot);
    }
}
