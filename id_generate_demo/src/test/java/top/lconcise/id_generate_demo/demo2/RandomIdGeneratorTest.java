package top.lconcise.id_generate_demo.demo2;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

/**
 * @author: liusj
 * @date: 2022/3/2
 */
public class RandomIdGeneratorTest {

    @Test
    public void testGetLastSubstrSplitByDot(){
        RandomIdGenerator idGenerator = new RandomIdGenerator();
        String actualSubStr = idGenerator.getLastSubstrSplitByDot("filed1.filed2.filed3");
    }
}
