package top.lconcise.design_demo.design_mode.creaction.prototype.cloneable;

import lombok.Data;

/**
 * @author: liusj
 * @date: 2022/3/25
 */
@Data
public class Address implements Cloneable{
    private String address;

    public Address(String address) {
        this.address = address;
    }

    @Override
    protected Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }
}
