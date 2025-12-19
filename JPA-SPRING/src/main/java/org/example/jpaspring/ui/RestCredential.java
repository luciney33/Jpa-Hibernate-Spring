package org.example.jpaspring.ui;
import org.example.jpaspring.domain.model.CredentialDTO;
import org.example.jpaspring.domain.service.CredentialService;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestCredential {

    private final CredentialService credentialService;

    public RestCredential(CredentialService credentialService) {
        this.credentialService = credentialService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public boolean login(@RequestBody CredentialDTO userCredentialsUI) {
        return credentialService.checkLogin(userCredentialsUI);
    }
}
