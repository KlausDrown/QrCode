package project.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class QrCodeDto {
    private String id;
    private String qr;
}
