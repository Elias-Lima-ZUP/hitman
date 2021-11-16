package io.hitman.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.hitman.exception.ResourceNotFoundException;
import io.hitman.model.Hitman;
import io.hitman.repository.HitmanRepository;

@RestController
@RequestMapping("/api/v1")
public class HitmanController {
	@Autowired
	private HitmanRepository hitmanRepository;

	@GetMapping("/hitmans")
	public List<Hitman> getAllHitmans() {
		return hitmanRepository.findAll();
	}

	@GetMapping("/hitmans/{id}")
	public ResponseEntity<Hitman> getHitmanById(@PathVariable(value = "id") Long hitmanId)
			throws ResourceNotFoundException {
		Hitman hitman = hitmanRepository.findById(hitmanId)
				.orElseThrow(() -> new ResourceNotFoundException("hitman not found for this id :: " + hitmanId));
		return ResponseEntity.ok().body(hitman);
	}

	@PostMapping("/hitmans")
	public Hitman createHitman(@Valid @RequestBody Hitman hitman) {
		return hitmanRepository.save(hitman);
	}

	@PutMapping("/hitmans/{id}")
	public ResponseEntity<Hitman> updateHitman(@PathVariable(value = "id") Long hitmanId,
					@Valid @RequestBody Hitman hitmanDetails) throws ResourceNotFoundException {
		Hitman hitman = hitmanRepository.findById(hitmanId)
				.orElseThrow(() -> new ResourceNotFoundException("hitman not found for this id :: " + hitmanId));

		hitman.setemail(hitmanDetails.getemail());
		hitman.setLastName(hitmanDetails.getLastName());
		hitman.setFirstName(hitmanDetails.getFirstName());
		final Hitman updatedHitman = hitmanRepository.save(hitman);
		return ResponseEntity.ok(updatedHitman);
	}

	@DeleteMapping("/hitmans/{id}")
	public Map<String, Boolean> deleteHitman(@PathVariable(value = "id") Long hitmanId)
			throws ResourceNotFoundException {
		Hitman hitman = hitmanRepository.findById(hitmanId)
				.orElseThrow(() -> new ResourceNotFoundException("hitman not found for this id :: " + hitmanId));

		hitmanRepository.delete(hitman);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}