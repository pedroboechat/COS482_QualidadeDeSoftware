package com.ufrj.cos482.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.ufrj.cos482.IntegrationTest;
import com.ufrj.cos482.domain.Judge;
import com.ufrj.cos482.repository.JudgeRepository;
import com.ufrj.cos482.service.dto.JudgeDTO;
import com.ufrj.cos482.service.mapper.JudgeMapper;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link JudgeResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class JudgeResourceIT {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_CPF = "AAAAAAAAAA";
    private static final String UPDATED_CPF = "BBBBBBBBBB";

    private static final String DEFAULT_OAB = "AAAAAAAAAA";
    private static final String UPDATED_OAB = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/judges";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private JudgeRepository judgeRepository;

    @Autowired
    private JudgeMapper judgeMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restJudgeMockMvc;

    private Judge judge;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Judge createEntity(EntityManager em) {
        Judge judge = new Judge().name(DEFAULT_NAME).cpf(DEFAULT_CPF).oab(DEFAULT_OAB);
        return judge;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Judge createUpdatedEntity(EntityManager em) {
        Judge judge = new Judge().name(UPDATED_NAME).cpf(UPDATED_CPF).oab(UPDATED_OAB);
        return judge;
    }

    @BeforeEach
    public void initTest() {
        judge = createEntity(em);
    }

    @Test
    @Transactional
    void createJudge() throws Exception {
        int databaseSizeBeforeCreate = judgeRepository.findAll().size();
        // Create the Judge
        JudgeDTO judgeDTO = judgeMapper.toDto(judge);
        restJudgeMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(judgeDTO)))
            .andExpect(status().isCreated());

        // Validate the Judge in the database
        List<Judge> judgeList = judgeRepository.findAll();
        assertThat(judgeList).hasSize(databaseSizeBeforeCreate + 1);
        Judge testJudge = judgeList.get(judgeList.size() - 1);
        assertThat(testJudge.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testJudge.getCpf()).isEqualTo(DEFAULT_CPF);
        assertThat(testJudge.getOab()).isEqualTo(DEFAULT_OAB);
    }

    @Test
    @Transactional
    void createJudgeWithExistingId() throws Exception {
        // Create the Judge with an existing ID
        judge.setId(1L);
        JudgeDTO judgeDTO = judgeMapper.toDto(judge);

        int databaseSizeBeforeCreate = judgeRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restJudgeMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(judgeDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Judge in the database
        List<Judge> judgeList = judgeRepository.findAll();
        assertThat(judgeList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllJudges() throws Exception {
        // Initialize the database
        judgeRepository.saveAndFlush(judge);

        // Get all the judgeList
        restJudgeMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(judge.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].cpf").value(hasItem(DEFAULT_CPF)))
            .andExpect(jsonPath("$.[*].oab").value(hasItem(DEFAULT_OAB)));
    }

    @Test
    @Transactional
    void getJudge() throws Exception {
        // Initialize the database
        judgeRepository.saveAndFlush(judge);

        // Get the judge
        restJudgeMockMvc
            .perform(get(ENTITY_API_URL_ID, judge.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(judge.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.cpf").value(DEFAULT_CPF))
            .andExpect(jsonPath("$.oab").value(DEFAULT_OAB));
    }

    @Test
    @Transactional
    void getNonExistingJudge() throws Exception {
        // Get the judge
        restJudgeMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewJudge() throws Exception {
        // Initialize the database
        judgeRepository.saveAndFlush(judge);

        int databaseSizeBeforeUpdate = judgeRepository.findAll().size();

        // Update the judge
        Judge updatedJudge = judgeRepository.findById(judge.getId()).get();
        // Disconnect from session so that the updates on updatedJudge are not directly saved in db
        em.detach(updatedJudge);
        updatedJudge.name(UPDATED_NAME).cpf(UPDATED_CPF).oab(UPDATED_OAB);
        JudgeDTO judgeDTO = judgeMapper.toDto(updatedJudge);

        restJudgeMockMvc
            .perform(
                put(ENTITY_API_URL_ID, judgeDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(judgeDTO))
            )
            .andExpect(status().isOk());

        // Validate the Judge in the database
        List<Judge> judgeList = judgeRepository.findAll();
        assertThat(judgeList).hasSize(databaseSizeBeforeUpdate);
        Judge testJudge = judgeList.get(judgeList.size() - 1);
        assertThat(testJudge.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testJudge.getCpf()).isEqualTo(UPDATED_CPF);
        assertThat(testJudge.getOab()).isEqualTo(UPDATED_OAB);
    }

    @Test
    @Transactional
    void putNonExistingJudge() throws Exception {
        int databaseSizeBeforeUpdate = judgeRepository.findAll().size();
        judge.setId(count.incrementAndGet());

        // Create the Judge
        JudgeDTO judgeDTO = judgeMapper.toDto(judge);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restJudgeMockMvc
            .perform(
                put(ENTITY_API_URL_ID, judgeDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(judgeDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Judge in the database
        List<Judge> judgeList = judgeRepository.findAll();
        assertThat(judgeList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchJudge() throws Exception {
        int databaseSizeBeforeUpdate = judgeRepository.findAll().size();
        judge.setId(count.incrementAndGet());

        // Create the Judge
        JudgeDTO judgeDTO = judgeMapper.toDto(judge);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restJudgeMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(judgeDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Judge in the database
        List<Judge> judgeList = judgeRepository.findAll();
        assertThat(judgeList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamJudge() throws Exception {
        int databaseSizeBeforeUpdate = judgeRepository.findAll().size();
        judge.setId(count.incrementAndGet());

        // Create the Judge
        JudgeDTO judgeDTO = judgeMapper.toDto(judge);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restJudgeMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(judgeDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Judge in the database
        List<Judge> judgeList = judgeRepository.findAll();
        assertThat(judgeList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateJudgeWithPatch() throws Exception {
        // Initialize the database
        judgeRepository.saveAndFlush(judge);

        int databaseSizeBeforeUpdate = judgeRepository.findAll().size();

        // Update the judge using partial update
        Judge partialUpdatedJudge = new Judge();
        partialUpdatedJudge.setId(judge.getId());

        partialUpdatedJudge.name(UPDATED_NAME).oab(UPDATED_OAB);

        restJudgeMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedJudge.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedJudge))
            )
            .andExpect(status().isOk());

        // Validate the Judge in the database
        List<Judge> judgeList = judgeRepository.findAll();
        assertThat(judgeList).hasSize(databaseSizeBeforeUpdate);
        Judge testJudge = judgeList.get(judgeList.size() - 1);
        assertThat(testJudge.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testJudge.getCpf()).isEqualTo(DEFAULT_CPF);
        assertThat(testJudge.getOab()).isEqualTo(UPDATED_OAB);
    }

    @Test
    @Transactional
    void fullUpdateJudgeWithPatch() throws Exception {
        // Initialize the database
        judgeRepository.saveAndFlush(judge);

        int databaseSizeBeforeUpdate = judgeRepository.findAll().size();

        // Update the judge using partial update
        Judge partialUpdatedJudge = new Judge();
        partialUpdatedJudge.setId(judge.getId());

        partialUpdatedJudge.name(UPDATED_NAME).cpf(UPDATED_CPF).oab(UPDATED_OAB);

        restJudgeMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedJudge.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedJudge))
            )
            .andExpect(status().isOk());

        // Validate the Judge in the database
        List<Judge> judgeList = judgeRepository.findAll();
        assertThat(judgeList).hasSize(databaseSizeBeforeUpdate);
        Judge testJudge = judgeList.get(judgeList.size() - 1);
        assertThat(testJudge.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testJudge.getCpf()).isEqualTo(UPDATED_CPF);
        assertThat(testJudge.getOab()).isEqualTo(UPDATED_OAB);
    }

    @Test
    @Transactional
    void patchNonExistingJudge() throws Exception {
        int databaseSizeBeforeUpdate = judgeRepository.findAll().size();
        judge.setId(count.incrementAndGet());

        // Create the Judge
        JudgeDTO judgeDTO = judgeMapper.toDto(judge);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restJudgeMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, judgeDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(judgeDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Judge in the database
        List<Judge> judgeList = judgeRepository.findAll();
        assertThat(judgeList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchJudge() throws Exception {
        int databaseSizeBeforeUpdate = judgeRepository.findAll().size();
        judge.setId(count.incrementAndGet());

        // Create the Judge
        JudgeDTO judgeDTO = judgeMapper.toDto(judge);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restJudgeMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(judgeDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Judge in the database
        List<Judge> judgeList = judgeRepository.findAll();
        assertThat(judgeList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamJudge() throws Exception {
        int databaseSizeBeforeUpdate = judgeRepository.findAll().size();
        judge.setId(count.incrementAndGet());

        // Create the Judge
        JudgeDTO judgeDTO = judgeMapper.toDto(judge);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restJudgeMockMvc
            .perform(patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(judgeDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Judge in the database
        List<Judge> judgeList = judgeRepository.findAll();
        assertThat(judgeList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteJudge() throws Exception {
        // Initialize the database
        judgeRepository.saveAndFlush(judge);

        int databaseSizeBeforeDelete = judgeRepository.findAll().size();

        // Delete the judge
        restJudgeMockMvc
            .perform(delete(ENTITY_API_URL_ID, judge.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Judge> judgeList = judgeRepository.findAll();
        assertThat(judgeList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
