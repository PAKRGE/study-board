package com.example.demo.web.view;

import com.example.demo.model.Page;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PageTest {
    @Test
    void test() {
        Page<Integer> page = new Page<>(
                1,
                11,
                4
        );

        assertThat(page.getCurrentPage()).isEqualTo(0);
        assertThat(page.getTotalPage()).isEqualTo(3);
        assertThat(page.getList()).isEqualTo(1);
    }
}