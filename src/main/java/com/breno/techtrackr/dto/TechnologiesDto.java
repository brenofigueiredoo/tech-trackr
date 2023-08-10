package com.breno.techtrackr.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class TechnologiesDto {

    @NotEmpty(message = "Name cannot be empty")
    @Size(max = 92, message = "Name must be lower than 92 characters long")
    private String name;

    @NotEmpty(message = "Status cannot be empty")
    @Pattern(regexp = "(Iniciante|Intermediario|Avancado)", message = "Technologies status must be Iniciante, Intermediario or Avancado")
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
