package com.ufrj.cos482.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JudicialProcedureMapperTest {

    private JudicialProcedureMapper judicialProcedureMapper;

    @BeforeEach
    public void setUp() {
        judicialProcedureMapper = new JudicialProcedureMapperImpl();
    }
}
