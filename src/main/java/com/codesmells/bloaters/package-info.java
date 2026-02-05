/**
 * BLOATERS - Code Smells Related to Code Size and Complexity
 * 
 * <h2>What are Bloaters?</h2>
 * Bloaters are code smells that represent code, methods, or classes that have grown 
 * so large that they become difficult to work with, understand, and maintain.
 * 
 * <h2>Why are Bloaters Problematic?</h2>
 * <ul>
 *   <li>Difficult to understand and navigate</li>
 *   <li>Hard to maintain and modify</li>
 *   <li>Prone to bugs due to complexity</li>
 *   <li>Violate the Single Responsibility Principle</li>
 *   <li>Reduce code reusability</li>
 * </ul>
 * 
 * <h2>Types of Bloaters in this Package</h2>
 * <ol>
 *   <li><b>Long Method</b> - Methods that try to do too much</li>
 *   <li><b>Large Class</b> - Classes with too many responsibilities</li>
 *   <li><b>Primitive Obsession</b> - Using primitives instead of small objects</li>
 *   <li><b>Long Parameter List</b> - Methods with too many parameters</li>
 *   <li><b>Data Clumps</b> - Groups of data that always appear together</li>
 * </ol>
 * 
 * <h2>General Refactoring Approaches</h2>
 * <ul>
 *   <li>Extract Method - Break down large methods into smaller ones</li>
 *   <li>Extract Class - Split large classes into focused classes</li>
 *   <li>Introduce Parameter Object - Replace parameter lists with objects</li>
 *   <li>Replace Primitive with Object - Create value objects for primitives</li>
 * </ul>
 * 
 * <h2>Learning Objectives</h2>
 * Students will learn to:
 * <ul>
 *   <li>Identify bloated code in real-world scenarios</li>
 *   <li>Understand why bloaters harm code quality</li>
 *   <li>Apply appropriate refactoring techniques</li>
 *   <li>Write cleaner, more maintainable code</li>
 * </ul>
 * 
 * @see <a href="https://refactoring.guru/refactoring/smells/bloaters">Refactoring Guru - Bloaters</a>
 */
package com.codesmells.bloaters;
