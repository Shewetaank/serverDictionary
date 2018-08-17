package com.shewetai.server.enums;

/**
 * Enum used to create the server and client files
 */
public enum FileType {
    CLIENT("client"),
    SERVER("server");

    private String text;

    FileType(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public static FileType fromString(String text) {
        for (FileType b : FileType.values()) {
            if (b.text.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}