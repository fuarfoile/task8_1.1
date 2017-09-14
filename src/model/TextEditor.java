package model;

public class TextEditor {
    public static String getText (int rows) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int row = 0; row < rows; row++) {
            stringBuilder.append("row ").append(row + 1).append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();
    }
}
