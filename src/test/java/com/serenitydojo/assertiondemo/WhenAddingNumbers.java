package com.serenitydojo.assertiondemo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

    @DisplayName("When adding numbers")
    class WhenAddingNumbers {

    @DisplayName("When adding two integer correctly")
    @Test
    void shouldAddTwoIntegerCorrectly(){
        int a = 1;
        int b = 2 ;
        int sum = a + b;

        //Assert.assertEquals(sum, 3);
        //Using AssertJ
        assertThat(sum).isEqualTo(4);
    }
}
