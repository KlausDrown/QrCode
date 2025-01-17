package project.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import project.domain.QrCodeUpdateDto;
import project.service.QrCodeService;
import project.domain.QrCodeDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/code")
@RequiredArgsConstructor
public class QrCodeController {

    private final QrCodeService qrCodeService;

    @ApiOperation(value = "Get qr by id", tags = "qr")
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "ok", response = QrCodeDto.class),
                    @ApiResponse(code = 404, message = "not_found")
            }
    )
    @GetMapping(value = "/{id}", consumes = MediaType.ALL_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<QrCodeDto> get(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(qrCodeService.getById(id));
    }

    @ApiOperation(value = "create qr", tags = "qr")
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "ok", response = QrCodeDto.class),
            }
    )
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<QrCodeDto> create(@RequestBody QrCodeDto qrCodeDto) {
        return ResponseEntity.ok(qrCodeService.save(qrCodeDto));
    }

    @ApiOperation(value = "update qr", tags = "qr")
    @ApiResponses(value =
            {
                    @ApiResponse(code = 200, message = "ok", response = QrCodeDto.class),
                    @ApiResponse(code = 404, message = "not_found")
            }
    )
    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<QrCodeDto> update(
            @PathVariable(value = "id") Long id,
            @RequestBody QrCodeUpdateDto qrCodeDto) {
        return ResponseEntity.ok().body(qrCodeService.update(id, qrCodeDto.getQr()));

    }

    @ApiOperation(value = "delete qr", tags = "qr")
    @ApiResponses(value =
            {
                    @ApiResponse(code = 204, message = "ok"),
                    @ApiResponse(code = 404, message = "not_found")
            }
    )
    @DeleteMapping(value = "/{id}", consumes = MediaType.ALL_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long id) {
        qrCodeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
