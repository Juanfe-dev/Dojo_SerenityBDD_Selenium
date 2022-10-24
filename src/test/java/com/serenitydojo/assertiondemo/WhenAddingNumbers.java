package com.serenitydojo.assertiondemo;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenAddingNumbers {

    @Test
    public void shouldAddTwoIntegerCorrectly(){
        int a = 1;
        int b = 2 ;
        int sum = a + b;

        //Assert.assertEquals(sum, 3);
        //Using AssertJ
        assertThat(sum).isEqualTo(4);
    }
}
