package com.ufrj.cos482.service.mapper;

import com.ufrj.cos482.domain.*;
import com.ufrj.cos482.service.dto.JudicialProcedureDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link JudicialProcedure} and its DTO {@link JudicialProcedureDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface JudicialProcedureMapper extends EntityMapper<JudicialProcedureDTO, JudicialProcedure> {}
