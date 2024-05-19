package br.com.oiltag.partners.repository;

import br.com.oiltag.partners.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartnerRepository extends JpaRepository<Partner, String> {
}
