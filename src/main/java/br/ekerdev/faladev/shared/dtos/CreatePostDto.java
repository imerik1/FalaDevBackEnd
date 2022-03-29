package br.ekerdev.faladev.shared.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePostDto {
    @Size(min = 2, max = 15, message = "Username must to have a length between 2 and 15 characters.")
    private String username = "Unknown";

    @Size(min = 15, max = 600, message = "Body must to have a length between 15 and 600 characters.")
    @NotNull(message = "Body cannot be null.")
    @NotEmpty(message = "Body cannot be empty.")
    private String body;

    @NotEmpty(message = "Tags must to have a minimum one tag.")
    private List<String> tags = new ArrayList<String>();
}
