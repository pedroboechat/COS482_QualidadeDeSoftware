package com.ufrj.cos482.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JudgeMapperTest {

    private JudgeMapper judgeMapper;

    @BeforeEach
    public void setUp() {
        judgeMapper = new JudgeMapperImpl();
    }
}
