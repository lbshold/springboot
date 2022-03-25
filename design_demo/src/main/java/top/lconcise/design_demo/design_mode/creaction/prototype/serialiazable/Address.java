package top.lconcise.design_demo.design_mode.creaction.prototype.serialiazable;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: liusj
 * @date: 2022/3/25
 */
@Data
public class Address implements Serializable {

    private static final long serialVersionUID = 250889343870122120L;

    private String address;

    public Address(String address) {
        this.address = address;
    }
}
