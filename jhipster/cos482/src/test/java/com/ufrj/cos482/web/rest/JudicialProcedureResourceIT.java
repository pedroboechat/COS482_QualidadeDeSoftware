package com.ufrj.cos482.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.ufrj.cos482.IntegrationTest;
import com.ufrj.cos482.domain.JudicialProcedure;
import com.ufrj.cos482.repository.JudicialProcedureRepository;
import com.ufrj.cos482.service.dto.JudicialProcedureDTO;
import com.ufrj.cos482.service.mapper.JudicialProcedureMapper;
import java.time.LocalDate;
import java.time.ZoneId;
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
 * Integration tests for the {@link JudicialProcedureResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class JudicialProcedureResourceIT {

    private static final String DEFAULT_NUMERO_DO_PROCESSO = "AAAAAAAAAA";
    private static final String UPDATED_NUMERO_DO_PROCESSO = "BBBBBBBBBB";

    private static final String DEFAULT_TRIBUNAL = "AAAAAAAAAA";
    private static final String UPDATED_TRIBUNAL = "BBBBBBBBBB";

    private static final String DEFAULT_JUIZ = "AAAAAAAAAA";
    private static final String UPDATED_JUIZ = "BBBBBBBBBB";

    private static final Boolean DEFAULT_NECESSITA_LAUDO = false;
    private static final Boolean UPDATED_NECESSITA_LAUDO = true;

    private static final String DEFAULT_LAUDISTA = "AAAAAAAAAA";
    private static final String UPDATED_LAUDISTA = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DATA_DA_VISITA = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATA_DA_VISITA = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_ENDERECO = "AAAAAAAAAA";
    private static final String UPDATED_ENDERECO = "BBBBBBBBBB";

    private static final String DEFAULT_LINK_LAUDO = "AAAAAAAAAA";
    private static final String UPDATED_LINK_LAUDO = "BBBBBBBBBB";

    private static final Boolean DEFAULT_LAUDO_VALIDO = false;
    private static final Boolean UPDATED_LAUDO_VALIDO = true;

    private static final LocalDate DEFAULT_PROTOCOLADO_EM = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_PROTOCOLADO_EM = LocalDate.now(ZoneId.systemDefault());

    private static final String ENTITY_API_URL = "/api/judicial-procedures";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private JudicialProcedureRepository judicialProcedureRepository;

    @Autowired
    private JudicialProcedureMapper judicialProcedureMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restJudicialProcedureMockMvc;

    private JudicialProcedure judicialProcedure;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static JudicialProcedure createEntity(EntityManager em) {
        JudicialProcedure judicialProcedure = new JudicialProcedure()
            .NumeroDoProcesso(DEFAULT_NUMERO_DO_PROCESSO)
            .Tribunal(DEFAULT_TRIBUNAL)
            .Juiz(DEFAULT_JUIZ)
            .NecessitaLaudo(DEFAULT_NECESSITA_LAUDO)
            .Laudista(DEFAULT_LAUDISTA)
            .DataDaVisita(DEFAULT_DATA_DA_VISITA)
            .Endereco(DEFAULT_ENDERECO)
            .LinkLaudo(DEFAULT_LINK_LAUDO)
            .LaudoValido(DEFAULT_LAUDO_VALIDO)
            .ProtocoladoEm(DEFAULT_PROTOCOLADO_EM);
        return judicialProcedure;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static JudicialProcedure createUpdatedEntity(EntityManager em) {
        JudicialProcedure judicialProcedure = new JudicialProcedure()
            .NumeroDoProcesso(UPDATED_NUMERO_DO_PROCESSO)
            .Tribunal(UPDATED_TRIBUNAL)
            .Juiz(UPDATED_JUIZ)
            .NecessitaLaudo(UPDATED_NECESSITA_LAUDO)
            .Laudista(UPDATED_LAUDISTA)
            .DataDaVisita(UPDATED_DATA_DA_VISITA)
            .Endereco(UPDATED_ENDERECO)
            .LinkLaudo(UPDATED_LINK_LAUDO)
            .LaudoValido(UPDATED_LAUDO_VALIDO)
            .ProtocoladoEm(UPDATED_PROTOCOLADO_EM);
        return judicialProcedure;
    }

    @BeforeEach
    public void initTest() {
        judicialProcedure = createEntity(em);
    }

    @Test
    @Transactional
    void getAllJudicialProcedures() throws Exception {
        // Initialize the database
        judicialProcedureRepository.saveAndFlush(judicialProcedure);

        // Get all the judicialProcedureList
        restJudicialProcedureMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(judicialProcedure.getId().intValue())))
            .andExpect(jsonPath("$.[*].NumeroDoProcesso").value(hasItem(DEFAULT_NUMERO_DO_PROCESSO)))
            .andExpect(jsonPath("$.[*].Tribunal").value(hasItem(DEFAULT_TRIBUNAL)))
            .andExpect(jsonPath("$.[*].Juiz").value(hasItem(DEFAULT_JUIZ)))
            .andExpect(jsonPath("$.[*].NecessitaLaudo").value(hasItem(DEFAULT_NECESSITA_LAUDO.booleanValue())))
            .andExpect(jsonPath("$.[*].Laudista").value(hasItem(DEFAULT_LAUDISTA)))
            .andExpect(jsonPath("$.[*].DataDaVisita").value(hasItem(DEFAULT_DATA_DA_VISITA.toString())))
            .andExpect(jsonPath("$.[*].Endereco").value(hasItem(DEFAULT_ENDERECO)))
            .andExpect(jsonPath("$.[*].LinkLaudo").value(hasItem(DEFAULT_LINK_LAUDO)))
            .andExpect(jsonPath("$.[*].LaudoValido").value(hasItem(DEFAULT_LAUDO_VALIDO.booleanValue())))
            .andExpect(jsonPath("$.[*].ProtocoladoEm").value(hasItem(DEFAULT_PROTOCOLADO_EM.toString())));
    }

    @Test
    @Transactional
    void getJudicialProcedure() throws Exception {
        // Initialize the database
        judicialProcedureRepository.saveAndFlush(judicialProcedure);

        // Get the judicialProcedure
        restJudicialProcedureMockMvc
            .perform(get(ENTITY_API_URL_ID, judicialProcedure.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(judicialProcedure.getId().intValue()))
            .andExpect(jsonPath("$.NumeroDoProcesso").value(DEFAULT_NUMERO_DO_PROCESSO))
            .andExpect(jsonPath("$.Tribunal").value(DEFAULT_TRIBUNAL))
            .andExpect(jsonPath("$.Juiz").value(DEFAULT_JUIZ))
            .andExpect(jsonPath("$.NecessitaLaudo").value(DEFAULT_NECESSITA_LAUDO.booleanValue()))
            .andExpect(jsonPath("$.Laudista").value(DEFAULT_LAUDISTA))
            .andExpect(jsonPath("$.DataDaVisita").value(DEFAULT_DATA_DA_VISITA.toString()))
            .andExpect(jsonPath("$.Endereco").value(DEFAULT_ENDERECO))
            .andExpect(jsonPath("$.LinkLaudo").value(DEFAULT_LINK_LAUDO))
            .andExpect(jsonPath("$.LaudoValido").value(DEFAULT_LAUDO_VALIDO.booleanValue()))
            .andExpect(jsonPath("$.ProtocoladoEm").value(DEFAULT_PROTOCOLADO_EM.toString()));
    }

    @Test
    @Transactional
    void getNonExistingJudicialProcedure() throws Exception {
        // Get the judicialProcedure
        restJudicialProcedureMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }
}
