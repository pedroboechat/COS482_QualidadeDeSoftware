package com.ufrj.cos482.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.ufrj.cos482.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class JudicialProcedureTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(JudicialProcedure.class);
        JudicialProcedure judicialProcedure1 = new JudicialProcedure();
        judicialProcedure1.setId(1L);
        JudicialProcedure judicialProcedure2 = new JudicialProcedure();
        judicialProcedure2.setId(judicialProcedure1.getId());
        assertThat(judicialProcedure1).isEqualTo(judicialProcedure2);
        judicialProcedure2.setId(2L);
        assertThat(judicialProcedure1).isNotEqualTo(judicialProcedure2);
        judicialProcedure1.setId(null);
        assertThat(judicialProcedure1).isNotEqualTo(judicialProcedure2);
    }
}
