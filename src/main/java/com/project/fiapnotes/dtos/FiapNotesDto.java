package com.project.fiapnotes.dtos;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FiapNotesDto {

    private String text;

    private Boolean priority;

}
