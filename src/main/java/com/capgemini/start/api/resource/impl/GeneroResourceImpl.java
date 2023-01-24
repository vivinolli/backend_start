package com.capgemini.start.api.resource.impl;

public class GeneroResourceImpl {
	import java.net.URI;
	import java.util.List;
	import java.util.stream.Collectors;

	import javax.validation.Valid;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpHeaders;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

	import com.capgemini.start.api.dto.input.GeneroInputDTO;
	import com.capgemini.start.api.dto.output.GeneroDTO;
	import com.capgemini.start.api.mapper.GeneroMapper;
	import com.capgemini.start.api.resource.GeneroResource;
	import com.capgemini.start.domain.entity.Genero;
	import com.capgemini.start.domain.service.GeneroService;

	import lombok.RequiredArgsConstructor;

	@RequiredArgsConstructor
	@RestController
	@RequestMapping(value = "/api/genero")
	public class GeneroResourceImpl implements GeneroResource{
		
		private final GeneroService service;
		
		@Autowired
		private GeneroMapper mapper;
		
		@Override
		public ResponseEntity<GeneroDTO> findById(Long id) {
			Genero genero = this.service.findById(id);
			GeneroDTO dto = mapper.toDTO(genero);
			return ResponseEntity.ok(dto);
		}

		@Override
		public ResponseEntity<List<GeneroDTO>> findAll() {
			return ResponseEntity.ok(
						this.service.findAll()
						.stream()
						.map(tipo -> mapper.toDTO(genero))
						.collect(Collectors.toList())
					);
}
