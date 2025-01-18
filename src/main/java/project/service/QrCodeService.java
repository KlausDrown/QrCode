package project.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.domain.QrCodeDto;
import project.entity.QrCode;
import project.exception.EntityNotFoundException;
import project.mapper.QrCodeMapper;
import project.repository.QrCodeRepository;

@Service
@RequiredArgsConstructor
public class QrCodeService {

    private final QrCodeRepository qrCodeRepository;
    private final QrCodeMapper qrCodeMapper;


    public QrCodeDto save(QrCodeDto qrCode) {
        return qrCodeMapper.mapToDto(
                qrCodeRepository.save(qrCodeMapper.mapToEntity(qrCode))
        );
    }


    public QrCodeDto getById(Long id) {
        return qrCodeMapper.mapToDto(qrCodeRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    public QrCodeDto update(Long id, String newValue) {
        QrCode qrCode = qrCodeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        qrCode.setQr(newValue);

        return qrCodeMapper.mapToDto(qrCodeRepository.save(qrCode));
    }

    public void delete(Long id) {
        qrCodeRepository.deleteById(id);
    }
}
