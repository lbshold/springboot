package top.lconcise.design_demo.design_mode.creaction.prototype.cloneable;

/**
 * @author: liusj
 * @date: 2022/3/25
 */
public class Demo {

    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student(1, "刘德华");
        Address address = new Address("北京");
        student.setAddress(address);

        Student cpStudent = student.clone();

        cpStudent.setName("马化腾");
        Address address1 = cpStudent.getAddress();
        address1.setAddress("西安");
        cpStudent.setAddress(address1);

        System.out.println(student.toString());
        System.out.println(cpStudent.toString());
    }
}
