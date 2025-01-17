package Project.controller;

import Project.DAO.QrCodeService;
import Project.object.QrCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/code")
public class ControllerForJson {

    private final QrCodeService qrCode_service;

    @Autowired
    public ControllerForJson(QrCodeService qrCode_service) {
        this.qrCode_service = qrCode_service;
    }

    @GetMapping(value = "/{id}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QrCode> getUser(@PathVariable(value = "id") int id){
        try {
            return ResponseEntity.ok(qrCode_service.index(id).get(0));
        }catch (Exception e){
            QrCode qrCode = new QrCode();
            qrCode.setId(0);
            qrCode.setQrValue("ERROR, there is no such element in the database.");
            return ResponseEntity.ok(qrCode);
        }
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QrCode> createUser(@RequestBody QrCode qrCode) {
        int requestId = qrCode_service.save(qrCode);
        qrCode.setId(requestId);
        return ResponseEntity.ok(qrCode);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateUser(
            @PathVariable(value = "id") int id,
            @RequestBody QrCode qrCode){
        if(qrCode_service.update(id, qrCode.getQrValue()) == 1){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("ERROR, there is no such element in the database.");
        }
    }

    @DeleteMapping(value = "/{id}", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") int id){
        try {
            qrCode_service.index(id).get(0);
            qrCode_service.delete(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("ERROR, there is no such element in the database.");
        }

    }
}
