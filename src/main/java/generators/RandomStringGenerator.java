package generators;

import java.util.UUID;

public class RandomStringGenerator {
    public static String randomName() {
        String randomString = usingUUID();
        return "name_" + randomString.substring(0, 8);
    }

    public static String randomKey() {
        String randomString = usingUUID();
        return "key_" + randomString.substring(0, 8);
    }
    static String usingUUID() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString().replaceAll("-", "");
    }
}