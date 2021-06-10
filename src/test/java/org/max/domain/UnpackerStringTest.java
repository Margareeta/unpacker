package org.max.domain;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.max.exceptions.MyValidationException;

import static org.junit.Assert.*;

public class UnpackerStringTest {
   static UnpackerString unpackerString;

   /*
   Аннотация @BeforeClass говорит о том, что данный метод выполняется 1 раз
     при запуске класса.
    Аннотация @Before будет запускаться перед каждым тестом
    */
   @BeforeClass
    public static void init() {
        unpackerString = new UnpackerString();

    }
    @Test
    public void testMutiplyer (){

        String actual = unpackerString.stringMultiplyer("3[xyz]");
        String expected = "xyzxyzxyz";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUnpack () throws MyValidationException {

        String actual = unpackerString.unpack("2[4[ab]c]3[2[z]xy]");
        String expected = "ababababcababababczzxyzzxyzzxy";

        Assert.assertEquals(expected,actual);

    }
    @Test
    public void testUnpack1 () throws MyValidationException {

        String actual = unpackerString.unpack("3[ab]4[cde]");
        String expected = "abababcdecdecdecde";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUnpack2() throws MyValidationException {

        String actual = unpackerString.unpack("3[2[ab]]");
        String expected = "abababababab";

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testUnpack3 () throws MyValidationException {

        String actual = unpackerString.unpack("2[2[2[a]c]]");
        String expected = "aacaacaacaac";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUnpack4() throws MyValidationException {

        String actual = unpackerString.unpack("abc");
        String expected = "abc";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUnpack5 () throws MyValidationException {

        String actual = unpackerString.unpack("7[a]");
        String expected = "aaaaaaa";

        Assert.assertEquals(expected, actual);
    }
}
