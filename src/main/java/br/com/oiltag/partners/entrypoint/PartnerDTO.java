package br.com.oiltag.partners.entrypoint;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PartnerDTO {
    @Size(min = 14, max = 14)
    private String cnpj;
    private String email;
    private String nomeComercial;
}
