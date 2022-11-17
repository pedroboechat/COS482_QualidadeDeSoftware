package com.ufrj.cos482.service.mapper;

import com.ufrj.cos482.domain.*;
import com.ufrj.cos482.service.dto.JudicialProcedureProcessDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link JudicialProcedureProcess} and its DTO {@link JudicialProcedureProcessDTO}.
 */
@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class, JudicialProcedureMapper.class })
public interface JudicialProcedureProcessMapper extends EntityMapper<JudicialProcedureProcessDTO, JudicialProcedureProcess> {
    @Mapping(target = "processInstance", source = "processInstance")
    @Mapping(target = "judicialProcedure", source = "judicialProcedure")
    JudicialProcedureProcessDTO toDto(JudicialProcedureProcess s);
}
