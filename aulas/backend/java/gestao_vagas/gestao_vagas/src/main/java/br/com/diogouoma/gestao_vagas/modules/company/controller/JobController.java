package br.com.diogouoma.gestao_vagas.modules.company.controller;

import br.com.diogouoma.gestao_vagas.modules.company.dto.CreateJobDTO;
import br.com.diogouoma.gestao_vagas.modules.company.entities.JobEntity;
import br.com.diogouoma.gestao_vagas.modules.company.useCase.CreateJobUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/company/job")
public class JobController {

    @Autowired
    private CreateJobUseCase createJobUseCase;

    @PostMapping("/")
    @PreAuthorize("hasRole('COMPANY')")
    @Tag(name = "Vagas", description = "Informações das vagas")
    @Operation(summary = "Cadastro de vagas", description = "Função responsavel por cadastro de vagas dentro da empresa")
    public ResponseEntity<Object> create(@Valid @RequestBody CreateJobDTO createJobDTO, HttpServletRequest request) {
        var companyId = request.getAttribute("company_id");

        try {

            //createJobDTO.setCompanyId(UUID.fromString(companyId.toString()));

            var jobEntity = JobEntity.builder()
                    .benefits(createJobDTO.getBenefit())
                    .companyId(UUID.fromString(companyId.toString()))
                    .description(createJobDTO.getDescription())
                    .level(createJobDTO.getLevel())
                    .build();

            var result =  this.createJobUseCase.execute(jobEntity);
            return ResponseEntity.ok().body(result);

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
