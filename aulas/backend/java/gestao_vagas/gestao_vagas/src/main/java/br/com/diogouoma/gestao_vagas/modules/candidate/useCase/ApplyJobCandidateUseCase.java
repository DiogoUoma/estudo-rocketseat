package br.com.diogouoma.gestao_vagas.modules.candidate.useCase;

import br.com.diogouoma.gestao_vagas.exceptions.JobNotFoundException;
import br.com.diogouoma.gestao_vagas.exceptions.UserNotFoundException;
import br.com.diogouoma.gestao_vagas.modules.candidate.repository.CandidateRepository;
import br.com.diogouoma.gestao_vagas.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplyJobCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    //Id candidato
    //id da vaga
    public void execute(UUID idCandidate, UUID idJob) {
        // validar se o candidato existe
        this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> {
                    throw new UserNotFoundException();
                });

        // validar se a vaga existe
        this.jobRepository.findById(idJob)
                .orElseThrow(() -> {
                    throw new JobNotFoundException();
                });

        // candidato se inscreve na vaga
    }

}
