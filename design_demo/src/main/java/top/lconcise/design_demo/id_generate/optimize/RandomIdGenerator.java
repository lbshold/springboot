package top.lconcise.design_demo.id_generate.optimize;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * @author: liusj
 * @date: 2022/3/2
 */
public class RandomIdGenerator implements LogTraceIdGenerator {

    private static final Logger logger = LoggerFactory.getLogger(RandomIdGenerator.class);

    @Override
    public String generate() {
        String subStrHostName = null;
        try {
            subStrHostName = getLastFieldOfHostName();
        } catch (UnknownHostException e) {
            throw new RuntimeException("...", e);
        }
        long currentTimeMillis = System.currentTimeMillis();
        String randomAlphameric = generateRandomAlphameric(8);
        String id = String.format("%s-%d-%s", subStrHostName, currentTimeMillis, randomAlphameric);
        return id;
    }

    private String getLastFieldOfHostName() throws UnknownHostException {
        String subStrHostName = null;
        String hostName = InetAddress.getLocalHost().getHostName();
        if (hostName == null || hostName.isEmpty()) {
            throw new UnknownHostException("...");
        }
        subStrHostName = getLastSubstrSplitByDot(hostName);
        return subStrHostName;
    }

    //@VisibleForTesting
    protected String getLastSubstrSplitByDot(String hostName) {
        if (hostName == null || hostName.isEmpty()) {
            throw new IllegalArgumentException("...");
        }

        String[] tokens = hostName.split("\\.");
        String subStrOfHostName = tokens[tokens.length - 1];
        return subStrOfHostName;
    }

    //@VisibleForTestin
    protected String generateRandomAlphameric(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("...");
        }
        char[] randomChars = new char[length];
        int count = 0;
        Random random = new Random();
        while (count < length) {
            int maxAscii = 'z';
            int randomAscii = random.nextInt(maxAscii);
            boolean isDigit = randomAscii >= '0' && randomAscii <= '9';
            boolean isUppercase = randomAscii >= 'A' && randomAscii <= 'Z';
            boolean isLowercase = randomAscii >= 'a' && randomAscii <= 'z';
            if (isDigit || isUppercase || isLowercase) {
                randomChars[count] = (char) randomAscii;
                ++count;
            }
        }
        return new String(randomChars);
    }
}
