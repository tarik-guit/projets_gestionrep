package com.gest.gestions.jpaauditing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class Auditor implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor(){
        return Optional.of("mahdia & tarik & amine ");
    }
    
    //apres on va utiliser le principal de spring security qui va être le created by et modified by
}
