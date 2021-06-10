package org.max.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

// example

public class TestList {
     List <Integer> numbers;

    @BeforeClass
    public void init (){
        numbers = new ArrayList<>();
    }

    @Test
    public void testAdd(){
        numbers.add(2);
        numbers.add(3);
        Assert.assertEquals(2, numbers.size());
    }

    @Test
    public void getNumber (){
        numbers.get(0);
    }
}
