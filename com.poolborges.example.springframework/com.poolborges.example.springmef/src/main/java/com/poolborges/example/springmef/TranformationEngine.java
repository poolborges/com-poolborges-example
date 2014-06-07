/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.springmef;

import java.util.Collection;

/**
 *
 * @author Borges
 */
public class TranformationEngine {
    
    private IGenerator Generator;
    private Collection<ITransformer> Transformers;

    public IGenerator getGenerator() {
        return Generator;
    }

    public void setGenerator(IGenerator Generator) {
        this.Generator = Generator;
    }

    public Collection<ITransformer> getTransformers() {
        return Transformers;
    }

    public void setTransformers(Collection<ITransformer> Transformers) {
        this.Transformers = Transformers;
    }

    public TranformationEngine(IGenerator Generator, Collection<ITransformer> Transformers) {
        this.Generator = Generator;
        this.Transformers = Transformers;
    }
    
    
}
