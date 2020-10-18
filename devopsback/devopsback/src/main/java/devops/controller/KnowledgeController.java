package devops.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import devops.model.DevopsKnowledge;
import devops.repository.KnowlegeRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")

public class KnowledgeController {

	@Autowired
	KnowlegeRepository knwoledgeRepository;

	@GetMapping("/knwoledges")
	public ResponseEntity<List<DevopsKnowledge>> getAllDevopsKnowledges(
			@RequestParam(required = false) String ejemplo) {
		try {
			List<DevopsKnowledge> devopsKnowledges = new ArrayList<DevopsKnowledge>();

			if (ejemplo == null)
				knwoledgeRepository.findAll().forEach(devopsKnowledges::add);
			else
			// knwoledgeRepository.findByTitleContaining(ejemplo).forEach(devopsKnowledges::add);

			if (devopsKnowledges.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(devopsKnowledges, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/knwoledges")
	public ResponseEntity<DevopsKnowledge> ceateKnowledge(@RequestBody DevopsKnowledge devops) {
		try {
			DevopsKnowledge _devopsKnowledge = knwoledgeRepository
					.save(new DevopsKnowledge(devops.getSkill(), devops.getNivel(), devops.getArea()));
			return new ResponseEntity<>(_devopsKnowledge, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	  @PutMapping("/knowledges/{id}")
	  public ResponseEntity<DevopsKnowledge> updateKnowledge(@PathVariable("id") long id, @RequestBody DevopsKnowledge devops) {
	    Optional<DevopsKnowledge> knowledgeData = knwoledgeRepository.findById(id);

	    if (knowledgeData.isPresent()) {
	    	DevopsKnowledge _knowledge = knowledgeData.get();
	    	_knowledge.setSkill(devops.getSkill());
	    	_knowledge.setNivel(devops.getNivel());

	      return new ResponseEntity<>(knwoledgeRepository.save(_knowledge), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
}
