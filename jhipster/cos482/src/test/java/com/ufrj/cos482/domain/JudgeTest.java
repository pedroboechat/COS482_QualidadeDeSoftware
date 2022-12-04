package com.ufrj.cos482.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.ufrj.cos482.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class JudgeTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Judge.class);
        Judge judge1 = new Judge();
        judge1.setId(1L);
        Judge judge2 = new Judge();
        judge2.setId(judge1.getId());
        assertThat(judge1).isEqualTo(judge2);
        judge2.setId(2L);
        assertThat(judge1).isNotEqualTo(judge2);
        judge1.setId(null);
        assertThat(judge1).isNotEqualTo(judge2);
    }
}
