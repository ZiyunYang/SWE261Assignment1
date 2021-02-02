package org.apache.commons.lang3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/*
SWE 261P Part1
 */
public class SWE261PTest {

    @Test
    public void testNullOrNot(){
        assertNull(StringUtils.capitalize(null));
        assertEquals("Cat", StringUtils.capitalize("cat"), "capitalize(non-null-string) failed");
    }

    @Test
    public void testFirstCharacter(){
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
        assertEquals("!",StringUtils.capitalize("!"));
        assertEquals("@", StringUtils.capitalize("@"));
        assertEquals("#", StringUtils.capitalize("#"));
        assertEquals("$", StringUtils.capitalize("$"));
        assertEquals("%", StringUtils.capitalize("%"));
        assertEquals("^", StringUtils.capitalize("^"));
        assertEquals("&", StringUtils.capitalize("&"));
        assertEquals("*", StringUtils.capitalize("*"));
        assertEquals("'cat'", StringUtils.capitalize("'cat'"));

    }


}
