package com.challenge.endpoints;

import com.challenge.entity.Candidate;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping("/{userId}/{companyId}/{accelerationId}")
    public Optional<Candidate> findById(@PathVariable("userId") Long userId,
                                        @PathVariable("companyId") Long companyId,
                                        @PathVariable("accelerationId") Long accelerationId) {
        return this.candidateService.findById(userId, companyId, accelerationId);
    }

    @GetMapping
    public Iterable<Candidate> findAll(@PathParam("companyId") Long companyId) {
        return candidateService.findByCompanyId(companyId);
    }

}
