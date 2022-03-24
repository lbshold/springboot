package top.lconcise.design_demo.design_mode.structure.composite.demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liusj
 * @date: 2022/3/24
 */
public class Department extends HumanResource {

    private List<HumanResource> subNodes = new ArrayList<>();

    public Department(long id) {
        super(id);
    }

    @Override
    public double calculateSalary() {
        double totalSalary = 0;
        for (HumanResource subNode : subNodes) {
            totalSalary += subNode.calculateSalary();
        }
        this.salary = totalSalary;
        return totalSalary;
    }

    public void addSubNode(HumanResource hr) {
        subNodes.add(hr);
    }
}
