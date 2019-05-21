package modern.challenge.service;

import modern.challenge.repository.PatientRepository;
import java.util.List;
import modern.challenge.projection.PatientNameAndMedicalHistoryDto;
import org.springframework.stereotype.Service;

@Service
public class ClinicService {

    private final PatientRepository playerRepository;

    public ClinicService(PatientRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    // Query all patients names and medical history with no current treatment (JPQL)
    public List<PatientNameAndMedicalHistoryDto> fetchAllPatientsNameAndMedicalHistoryNoTreatmentInnerJoinJpql() {
        return playerRepository.fetchAllPatientsNameAndMedicalHistoryNoTreatmentInnerJoinJpql();
    }

}
