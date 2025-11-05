package br.com.fiap.cashiq_backend.infrastructure.helper;

import java.util.UUID;

public class ConverterHelper {
    public static UUID uuidFromHexString(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("UUID string is null or empty");
        }

        if (str.contains("-") && str.length() == 36) {
            return UUID.fromString(str);
        }

        if (str.length() == 32) {
            StringBuilder sb = new StringBuilder(str);
            sb.insert(8, '-');
            sb.insert(13, '-');
            sb.insert(18, '-');
            sb.insert(23, '-');
            return UUID.fromString(sb.toString());
        }
        throw new IllegalArgumentException("Invalid UUID hex string: " + str);
    }
}
