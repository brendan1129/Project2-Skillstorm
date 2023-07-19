package com.skillstorm.group8.taxprep.models;

import com.fasterxml.jackson.annotation.JsonFormat;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MaritalStatus {
    SINGLE,
    MARRIED_FILING_JOINTLY,
    MARRIED_FILING_SEPARATELY,
    HEAD_OF_HOUSEHOLD,
    QUALIFYING_SURVIVING_SPOUSE;

}
