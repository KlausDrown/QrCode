package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.entity.QrCode;

public interface QrCodeRepository extends JpaRepository<QrCode, Long> {
}
