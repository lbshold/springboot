package top.lconcise.design_demo.design_mode.structure.composite.demo01;

/**
 * HumanResource 是部门类(Department)和员工类(Employee)抽象出来的父类。
 *
 * @author: liusj
 * @date: 2022/3/24
 */
public abstract class HumanResource {
    protected long id;
    protected double salary;

    public HumanResource(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public abstract double calculateSalary();
}
