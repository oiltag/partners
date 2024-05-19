package br.com.oiltag.partners.entrypoint;

import br.com.oiltag.partners.usecases.CreatePartnerUsecase;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@Tag(name = "Partner")
@RequestMapping("/api/v1")
public class CreatePartnerController {

    private final CreatePartnerUsecase createPartnerUsecase;

    public CreatePartnerController(CreatePartnerUsecase createPartnerUsecase) {
        this.createPartnerUsecase = createPartnerUsecase;
    }

    @PostMapping("/partners")
    public ResponseEntity<PartnerDTO> create(@RequestBody @Valid PartnerDTO partnerDTO) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", String.format("/api/v1/partners/%s", partnerDTO.getCnpj()));
        PartnerDTO createdPartner = createPartnerUsecase.createPartner(partnerDTO);
        return new ResponseEntity<>(createdPartner, headers, HttpStatus.CREATED);
    }
}
