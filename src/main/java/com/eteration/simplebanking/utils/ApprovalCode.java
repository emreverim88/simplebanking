package com.eteration.simplebanking.utils;

import java.util.UUID;

public class ApprovalCode {
    public static String generateRandomStringByUUID() {
        return UUID.randomUUID().toString();
    }
}
