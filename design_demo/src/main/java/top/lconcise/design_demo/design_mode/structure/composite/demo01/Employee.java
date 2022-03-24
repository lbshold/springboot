package top.lconcise.design_demo.design_mode.structure.composite.demo01;

/**
 * @author: liusj
 * @date: 2022/3/24
 */
public class Employee extends HumanResource {

    public Employee(long id, double salary) {
        super(id);
        this.salary = salary;
    }

    @Override
    public double calculateSalary() {
        return salary;
    }
}
