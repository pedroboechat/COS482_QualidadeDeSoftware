package com.ufrj.cos482.process.judicialProcedureProcess;

import com.ufrj.cos482.domain.JudicialProcedure;
import com.ufrj.cos482.domain.JudicialProcedureProcess;
import com.ufrj.cos482.service.dto.JudicialProcedureDTO;
import com.ufrj.cos482.service.dto.JudicialProcedureProcessDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class })
public interface AssignReporterMapper {
    @Mapping(target = "processInstance", source = "processInstance", qualifiedByName = "loadTaskContext")
    JudicialProcedureProcessDTO toJudicialProcedureProcessDTO(JudicialProcedureProcess judicialProcedureProcess);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "laudista", source = "laudista")
    @Mapping(target = "dataDaVisita", source = "dataDaVisita")
    @Mapping(target = "endereco", source = "endereco")
    JudicialProcedureDTO toJudicialProcedureDTO(JudicialProcedure judicialProcedure);
}
