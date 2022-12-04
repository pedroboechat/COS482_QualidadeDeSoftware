package com.ufrj.cos482.service.mapper;

import com.ufrj.cos482.domain.*;
import com.ufrj.cos482.service.dto.JudicialProcedureDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link JudicialProcedure} and its DTO {@link JudicialProcedureDTO}.
 */
@Mapper(componentModel = "spring", uses = { JudgeMapper.class })
public interface JudicialProcedureMapper extends EntityMapper<JudicialProcedureDTO, JudicialProcedure> {
    @Mapping(target = "judge", source = "judge", qualifiedByName = "name")
    JudicialProcedureDTO toDto(JudicialProcedure s);
}
