package br.com.diogouoma.gestao_vagas.modules.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateJobDTO {

    @Schema(example = "Vaga para pessoa desenvovledora junior", requiredMode = Schema.RequiredMode.REQUIRED)
    private String description;

    @Schema(example = "Gympass, Plano de Saude", requiredMode = Schema.RequiredMode.REQUIRED)
    private String benefit;

    @Schema(example = "JUNIOR", requiredMode = Schema.RequiredMode.REQUIRED)
    private String level;

}
