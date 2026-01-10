package com.tysystems.pms.global.utils;

public class CommUtil {

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static String remove(String str, char remove) {
        if (isEmpty(str) || str.indexOf(remove) == -1) {
            return str;
        }
        char[] chars = str.toCharArray();
        int pos = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != remove) {
                chars[pos++] = chars[i];
            }
        }
        return new String(chars, 0, pos);
    }

    public static String removeMinusChar(String str) {
        return remove(str, '-');
    }

    public static String validChkDate(String dateStr) {
        if (dateStr.equals(""))
            return new String("");
        //System.out.println("dateStr : " + dateStr);

        if (dateStr == null || !(dateStr.trim().length() == 8 || dateStr.trim().length() == 10)) {
            throw new IllegalArgumentException("Invalid date format: " + dateStr);
        }

        if (dateStr.length() == 10) {
            return removeMinusChar(dateStr);
        }

        return dateStr;
    }


    public static String getFormatDate(String sDate, String ch) {

        if (sDate == null || ch == null || sDate.equals("")) {
            return null;
        }

        String dateStr = validChkDate(sDate);

        String str = dateStr.trim();
        String yyyy = "";
        String mm = "";
        String dd = "";

        if (str.length() == 8) {
            yyyy = str.substring(0, 4);
            if (yyyy.equals("0000")) {
                return "";
            }

            mm = str.substring(4, 6);
            if (mm.equals("00")) {
                return yyyy;
            }

            dd = str.substring(6, 8);
            if (dd.equals("00")) {
                return yyyy + ch + mm;
            }

            return yyyy + ch + mm + ch + dd;

        } else if (str.length() == 6) {
            yyyy = str.substring(0, 4);
            if (yyyy.equals("0000")) {
                return "";
            }

            mm = str.substring(4, 6);
            if (mm.equals("00")) {
                return yyyy;
            }

            return yyyy + ch + mm;

        } else if (str.length() == 4) {
            yyyy = str.substring(0, 4);
            if (yyyy.equals("0000")) {
                return "";
            } else {
                return yyyy;
            }
        } else {
            return "";
        }
    }

    public static String getYMDFormatDate(String dateStr) {
        if (dateStr == null) {
            return null;
        }
        return validChkDate(dateStr);

    }

}
