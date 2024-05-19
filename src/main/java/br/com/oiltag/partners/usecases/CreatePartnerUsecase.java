package br.com.oiltag.partners.usecases;

import br.com.oiltag.partners.entrypoint.PartnerDTO;
import br.com.oiltag.partners.model.Partner;
import br.com.oiltag.partners.repository.PartnerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CreatePartnerUsecase {
    private final PartnerRepository partnerRepository;

    public CreatePartnerUsecase(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    public PartnerDTO createPartner(PartnerDTO partnerDTO) {

        Partner partner = new Partner();
        partner.setCnpj(partnerDTO.getCnpj());
        partner.setEmail(partnerDTO.getEmail());
        partner.setNomeComercial(partnerDTO.getNomeComercial());
        partner = partnerRepository.save(partner);

        partnerDTO.setCnpj(partner.getCnpj());
        partnerDTO.setEmail(partner.getEmail());
        partnerDTO.setNomeComercial(partner.getNomeComercial());

        return partnerDTO;
    }
}
