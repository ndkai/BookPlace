package com.example.bookplace.utils;

public class MyUtil {
    public static String cutTitle(String title) {
        if (title.length() <= 34) return title;
        else return title.substring(0, 33) + "...";
    }

    public static String formatToPriceString(float price) {
        String priceString = String.valueOf((int)price);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(priceString);
        int i = priceString.length() - 3;
        while (i >= 1) {
            stringBuilder.insert(i, '.');
            i -= 3;
        }
        return stringBuilder.toString() + "đ";
    }
}
