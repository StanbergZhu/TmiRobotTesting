package com.zjq.springboot.enums;

public interface BaseEnum {
    int getCode();

    String getMessage();

    static <T extends BaseEnum> T getEnumByCode(Class<T> enumClass, int code) {
        for (T t : enumClass.getEnumConstants()) {
            if (t.getCode() == code) {
                return t;
            }
        }
        throw new IllegalArgumentException("No enum constant " + enumClass.getSimpleName() + " with code " + code);
    }

    static <T extends BaseEnum> T getEnumByMessage(Class<T> enumClass, String message) {
        for (T t : enumClass.getEnumConstants()) {
            if (t.getMessage().equals(message)) {
                return t;
            }
        }
        throw new IllegalArgumentException("No enum constant " + enumClass.getSimpleName() + " with message " + message);
    }
}
