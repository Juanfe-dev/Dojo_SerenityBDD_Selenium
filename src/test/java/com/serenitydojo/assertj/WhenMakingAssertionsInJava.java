package com.serenitydojo.assertj;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

 class WhenMakingAssertionsInJava {

    @Test
    void traditionalAssertions(){
        int age = 40;
        List<Integer> ages = Arrays.asList(10,20,21,30);
        //assertEquals(21,age);
        assertTrue("The list of ages should contain 40" , ages.contains(age));
    }

    @Test
    void assertJAssertions(){
        int age = 30;
        List<Integer> ages = Arrays.asList(10,20,21,30);

        assertThat(age).isGreaterThanOrEqualTo(21);
        assertThat(ages).contains(age);
        assertThat(ages)
                .contains(10)
                .hasSize(4)
                .allMatch(a -> a >= 0 && a <= 100); //Assert all collection from 0 to 100
    }
}
