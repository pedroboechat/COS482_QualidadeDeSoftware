package com.ufrj.cos482.service.mapper;

import com.ufrj.cos482.domain.*;
import com.ufrj.cos482.service.dto.JudgeDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Judge} and its DTO {@link JudgeDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface JudgeMapper extends EntityMapper<JudgeDTO, Judge> {
    @Named("name")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    JudgeDTO toDtoName(Judge judge);
}
