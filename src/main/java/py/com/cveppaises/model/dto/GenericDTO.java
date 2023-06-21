package py.com.cveppaises.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import py.com.cveppaises.model.enums.Estado;

import java.time.LocalDateTime;

@Data
public class GenericDTO {
    private Long id;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    @JsonProperty("created_by")
    private String createdBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @JsonProperty("updated_by")
    private String updatedBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
    private boolean deleted;
    @JsonProperty("deleted_by")
    private String deletedBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deletedAt;
}
