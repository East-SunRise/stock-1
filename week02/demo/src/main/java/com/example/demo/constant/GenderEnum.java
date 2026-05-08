package com.example.demo.constant;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import java.util.Arrays;

/**
 * @author hhx
 * @date 2005/5/20
 * @description:GenderEnum
 */

@Getter
public enum GenderEnum {
        MALE("男"),
        FEMALE("女"),
        SECRET("保密");

        private final String description;

    GenderEnum(String description) {
        this.description = description;
    }

    @JsonValue
        public String getDescription() {
                return this.name();
        }

        public static GenderEnum fromDescription(String description) {
                return Arrays.stream(values())
                        .filter(gender -> gender.description.equals(description))
                        .findFirst()
                        .orElse(null);
        }
}
