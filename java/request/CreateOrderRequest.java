package com.minor.project.request;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateOrderRequest {

	@NotNull
	UUID userId;
	@NotNull
	UUID bookId;
}
