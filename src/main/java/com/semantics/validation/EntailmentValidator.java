package com.semantics.validation;

import org.semanticweb.HermiT.Reasoner;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLOntology;

import java.util.HashSet;
import java.util.Set;

public class EntailmentValidator {


    public boolean validateEntailment(OWLOntology ontology, OWLOntology instances) {

        Set<OWLAxiom> axiom_set = new HashSet<OWLAxiom>();

        // Adding individual assertions to the base ontology object, so that single object will be checked for inconsistency.
        for ( final OWLAxiom one_axiom : instances.getAxioms() ) {

            axiom_set.add(one_axiom);

            //System.out.println( "Added Axiom: " + one_axiom );
        }

        Reasoner reasoner = new Reasoner(ontology);

        return reasoner.isEntailed(axiom_set);
    }
}
