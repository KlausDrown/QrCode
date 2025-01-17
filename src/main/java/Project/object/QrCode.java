package Project.object;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QrCode {
    private int id;
    private String qrValue;

    public QrCode(String qrValue){
        this.qrValue = qrValue;
    }

    public QrCode(){

    }
}
