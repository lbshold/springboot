package top.lconcise.design_demo.design_mode.creaction.prototype.serialiazable;

/**
 * @author: liusj
 * @date: 2022/3/25
 */
public class Demo {

    public static void main(String[] args) {
        Student student = new Student(1, "刘德华");
        Address address = new Address("北京");
        student.setAddress(address);

        Student cp = student.myClone();
        cp.getAddress().setAddress("西安");
        cp.setName("马化腾");

        System.out.println(student);
        System.out.println(cp);

    }
}
