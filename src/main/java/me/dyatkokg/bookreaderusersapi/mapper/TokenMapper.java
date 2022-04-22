package me.dyatkokg.bookreaderusersapi.mapper;

import me.dyatkokg.bookreaderusersapi.dto.TokenDTO;
import me.dyatkokg.bookreaderusersapi.entity.Token;
import me.dyatkokg.bookreaderusersapi.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface TokenMapper {

    @Mapping(source = "value", target = "token")
    TokenDTO toDTO(Token token);

    @Mapping(target = "owner", ignore = true)
    Token toEntity(User owner, String value, LocalDateTime expireAt);


}
