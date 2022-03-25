package top.lconcise.design_demo.design_mode.creaction.prototype.cloneable;

import lombok.Data;

/**
 * @author: liusj
 * @date: 2022/3/25
 */
@Data
public class Student implements Cloneable {
    private int id;
    private String name;
    private Address address;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    protected Student clone() throws CloneNotSupportedException {
        Student cp = (Student) super.clone();
        cp.address = address.clone();
        return cp;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
