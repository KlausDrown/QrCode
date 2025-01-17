package project.mapper;

import org.springframework.stereotype.Component;
import project.domain.QrCodeDto;
import project.entity.QrCode;
import project.util.QrUtil;

@Component
public class QrCodeMapper {
    public QrCodeDto mapToDto(QrCode qrCode) {
        return QrCodeDto.builder().id(QrUtil.long2string(qrCode.getId()))
                .qr(qrCode.getQr()).build();
    }

    public QrCode mapToEntity(QrCodeDto qrCodeDto) {
        return QrCode.builder().id(QrUtil.string2long(qrCodeDto.getId()))
                .qr(qrCodeDto.getQr()).build();
    }
}
