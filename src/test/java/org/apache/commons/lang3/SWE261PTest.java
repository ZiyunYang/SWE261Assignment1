package org.apache.commons.lang3;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/*
SWE 261P Part1
 */
public class SWE261PTest {

    @Test
    public void testNullOrNot() {
        assertNull(StringUtils.capitalize(null));
        assertEquals("Cat", StringUtils.capitalize("cat"), "capitalize(non-null-string) failed");
    }

    @Test
    public void testFirstCharacter() {
        //lowercase
        assertEquals("Cat", StringUtils.capitalize("cat"));
        assertEquals("CAt", StringUtils.capitalize("cAt"));
        //uppercase
        assertEquals("Cat", StringUtils.capitalize("Cat"));
        assertEquals("CAt", StringUtils.capitalize("CAt"));
        assertEquals("Dog", StringUtils.capitalize("Dog"));
        assertEquals("DOg", StringUtils.capitalize("DOg"));
        //number
        assertEquals("1at", StringUtils.capitalize("1at"));
        assertEquals("2Og", StringUtils.capitalize("2Og"));

        //symbol: !@#$%^&*
        assertEquals("", StringUtils.capitalize(""));
        assertEquals("!", StringUtils.capitalize("!"));
        assertEquals("@", StringUtils.capitalize("@"));
        assertEquals("#", StringUtils.capitalize("#"));
        assertEquals("$", StringUtils.capitalize("$"));
        assertEquals("%", StringUtils.capitalize("%"));
        assertEquals("^", StringUtils.capitalize("^"));
        assertEquals("&", StringUtils.capitalize("&"));
        assertEquals("*", StringUtils.capitalize("*"));
        assertEquals("'cat'", StringUtils.capitalize("'cat'"));

    }


    @Test
    public void testStringEncodingFirstCharacter() throws UnsupportedEncodingException {

        // encoding: utf-8, gbk

        assertEquals("One", StringUtils.capitalize(new String("one".getBytes("UTF-8"))), "capitalize(different-encoding) success");

        assertEquals("?", StringUtils.capitalize(new String("?".getBytes("GBK"))), "capitalize(different-encoding) failed");

        assertEquals("\u01C8", StringUtils.capitalize("\u01C9"), "capitalize(String) is not using TitleCase");


    }

    @Test
    public void testStringLength() {
        // length = 0
        String s1 = "";
        assertEquals("", StringUtils.capitalize(s1));

        // length = 10
        String s2 = "aaaaa";
        assertEquals("Aaaaa", StringUtils.capitalize(s2));

        // length = 65534 (max string length in javac compiler)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65534; i++) {
            sb.append('a');
        }
        String s3 = sb.toString();
        assertEquals(65534, s3.length());
        assertEquals("A", StringUtils.capitalize(s3).substring(0, 1));
    }

}
