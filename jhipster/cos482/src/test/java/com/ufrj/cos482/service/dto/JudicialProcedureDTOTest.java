package com.ufrj.cos482.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.ufrj.cos482.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class JudicialProcedureDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(JudicialProcedureDTO.class);
        JudicialProcedureDTO judicialProcedureDTO1 = new JudicialProcedureDTO();
        judicialProcedureDTO1.setId(1L);
        JudicialProcedureDTO judicialProcedureDTO2 = new JudicialProcedureDTO();
        assertThat(judicialProcedureDTO1).isNotEqualTo(judicialProcedureDTO2);
        judicialProcedureDTO2.setId(judicialProcedureDTO1.getId());
        assertThat(judicialProcedureDTO1).isEqualTo(judicialProcedureDTO2);
        judicialProcedureDTO2.setId(2L);
        assertThat(judicialProcedureDTO1).isNotEqualTo(judicialProcedureDTO2);
        judicialProcedureDTO1.setId(null);
        assertThat(judicialProcedureDTO1).isNotEqualTo(judicialProcedureDTO2);
    }
}
