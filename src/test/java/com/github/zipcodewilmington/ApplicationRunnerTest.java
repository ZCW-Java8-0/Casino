package com.github.zipcodewilmington;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 7/21/2020.
 */
public class ApplicationRunnerTest {
    @Test
    public void test() { // TODO - replace boiler-plate logic with business logic
        // given
        Runnable runnable = new Casino();

        // when
        runnable.run();

        // then
        Assert.assertNotNull(runnable.toString());
    }
}
