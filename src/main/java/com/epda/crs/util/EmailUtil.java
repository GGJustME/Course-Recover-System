package com.epda.crs.util;

public final class EmailUtil {
    private EmailUtil() {
    }

    public static void sendEmail(String recipient, String subject, String message) {
        System.out.printf("Sending email to %s | Subject: %s | Message: %s%n", recipient, subject, message);
    }
}
