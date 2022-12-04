package com.ufrj.cos482.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.ufrj.cos482.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class JudgeDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(JudgeDTO.class);
        JudgeDTO judgeDTO1 = new JudgeDTO();
        judgeDTO1.setId(1L);
        JudgeDTO judgeDTO2 = new JudgeDTO();
        assertThat(judgeDTO1).isNotEqualTo(judgeDTO2);
        judgeDTO2.setId(judgeDTO1.getId());
        assertThat(judgeDTO1).isEqualTo(judgeDTO2);
        judgeDTO2.setId(2L);
        assertThat(judgeDTO1).isNotEqualTo(judgeDTO2);
        judgeDTO1.setId(null);
        assertThat(judgeDTO1).isNotEqualTo(judgeDTO2);
    }
}
