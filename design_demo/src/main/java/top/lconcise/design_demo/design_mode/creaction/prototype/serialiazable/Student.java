package top.lconcise.design_demo.design_mode.creaction.prototype.serialiazable;

import lombok.Data;

import java.io.*;

/**
 * @author: liusj
 * @date: 2022/3/25
 */
@Data
public class Student implements Serializable {
    private static final long serialVersionUID = -2098701537861068949L;

    private int id;
    private String name;
    private Address address;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student myClone() {
        Student student = null;
        try {
            ByteArrayOutputStream byteOs = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(byteOs);
            oos.writeObject(this);

            ByteArrayInputStream byteIs = new ByteArrayInputStream(byteOs.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(byteIs);
            student = (Student) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return student;
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
