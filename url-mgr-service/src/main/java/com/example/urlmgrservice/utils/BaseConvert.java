package com.example.urlmgrservice.utils;

public class BaseConvert {
    private static final char[] digits = {
            '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b',
            'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F',
            'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z', '_', '-'
    };

    public static String longToBase64String(long val) {
        return toUnsignedString(val, 6);
    }

    public static String longToHexString(long val) {
        return toUnsignedString(val, 4);
    }

    public static String longToBinaryString(long val) {
        return toUnsignedString(val, 1);
    }

    private static String toUnsignedString(long val, int shift) {
        // assert shift > 0 && shift <=5 : "Illegal shift value";
        int mag = Long.SIZE - Long.numberOfLeadingZeros(val);
        int chars = Math.max(((mag + (shift - 1)) / shift), 1);

        byte[] buf = new byte[chars];
        formatUnsignedLong(val, shift, buf, 0, chars);
        return new String(buf);
    }

    private static void formatUnsignedLong(long val, int shift, byte[] buf, int offset, int len) {
        int charPos = offset + len;
        int radix = 1 << shift;
        int mask = radix - 1;
        do {
            buf[--charPos] = (byte) digits[((int) val) & mask];
            val >>>= shift;
        } while (charPos > offset);
    }
}
