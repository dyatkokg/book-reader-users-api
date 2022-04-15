package me.dyatkokg.bookreaderusersapi.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.LocalDateTime;

@Data
@Document
public class Token {

    @Id
    @Field(targetType = FieldType.OBJECT_ID)
    private String id;

    private String value;

    private LocalDateTime expireAt;

    private User owner;
}
