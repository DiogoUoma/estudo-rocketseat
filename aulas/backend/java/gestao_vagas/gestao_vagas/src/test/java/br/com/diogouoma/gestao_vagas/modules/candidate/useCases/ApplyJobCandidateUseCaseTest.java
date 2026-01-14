package br.com.diogouoma.gestao_vagas.modules.candidate.useCases;

import br.com.diogouoma.gestao_vagas.exceptions.UserNotFoundException;
import br.com.diogouoma.gestao_vagas.modules.candidate.repository.CandidateRepository;
import br.com.diogouoma.gestao_vagas.modules.candidate.useCase.ApplyJobCandidateUseCase;
import br.com.diogouoma.gestao_vagas.modules.company.repositories.JobRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ApplyJobCandidateUseCaseTest {

    @InjectMocks
    private ApplyJobCandidateUseCase applyJobCandidateUseCase;

    @Mock
    private CandidateRepository candidateRepository;

    @Mock
    private JobRepository jobRepository;

    @Test
    @DisplayName("Should not be able to aplly job with candidate not found")
    public void should_not_be_able_to_apply_job_with_candidate_not_found(){
        try {
            applyJobCandidateUseCase.execute(null, null);
        } catch(Exception e) {
            assertThat(e).isInstanceOf(UserNotFoundException.class);
        }

    }



}
