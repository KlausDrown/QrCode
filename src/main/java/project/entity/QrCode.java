package project.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(schema = "qr", name = "code")
@Data
@Builder
public class QrCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String qr;
}
