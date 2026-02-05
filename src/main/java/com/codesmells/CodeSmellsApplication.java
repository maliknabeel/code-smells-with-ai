package com.codesmells;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main Spring Boot Application for Code Smells Educational Project
 * 
 * This application demonstrates various code smells and their refactoring solutions
 * based on the catalog from https://refactoring.guru/refactoring/smells
 * 
 * The code smells are organized into five main categories:
 * 1. Bloaters - Code that has grown too large
 * 2. Object-Orientation Abusers - Incorrect application of OOP principles
 * 3. Change Preventers - Code that makes changes difficult
 * 4. Dispensables - Unnecessary code elements
 * 5. Couplers - Excessive coupling between code elements
 * 
 * Each category contains multiple code smell examples with both bad (problematic)
 * and good (refactored) implementations for educational purposes.
 * 
 * @author Code Smells Educational Team
 * @version 1.0
 */
@SpringBootApplication
public class CodeSmellsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeSmellsApplication.class, args);
    }
}
