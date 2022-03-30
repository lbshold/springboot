package top.lconcise.design_demo.design_mode.behavior.memo.improve;

import java.util.Scanner;

/**
 * @author: liusj
 * @date: 2022/3/30
 */
public class Demo {
    public static void main(String[] args) {
        InputText inputText = new InputText();
        SnapshotHolder snapshotHolder = new SnapshotHolder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equalsIgnoreCase(":list")) {
                System.out.println(inputText.toString());
            } else if (input.equalsIgnoreCase(":undo")) {
                SnapShot snapShot = snapshotHolder.popSnapshot();
                inputText.restoreSnapshot(snapShot);
            } else {
                snapshotHolder.pushSnapshot(inputText.createSnapshot());
                inputText.append(input);
            }
        }
    }
}
