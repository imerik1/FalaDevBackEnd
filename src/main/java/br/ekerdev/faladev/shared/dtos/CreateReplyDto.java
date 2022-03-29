package br.ekerdev.faladev.shared.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateReplyDto {
    @Size(min = 15, max = 600, message = "Body must to have a length between 15 and 600 characters.")
    @NotNull(message = "Body cannot be null.")
    @NotEmpty(message = "Body cannot be empty.")
    private String body;
}
