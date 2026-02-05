/**
 * DISPENSABLES - Unnecessary Code Elements
 * 
 * <h2>What are Dispensables?</h2>
 * Code elements that are unnecessary and could be removed to make the code cleaner.
 * These include duplicate code, dead code, lazy classes, and overly simplistic data classes.
 * 
 * <h2>Why are Dispensables Problematic?</h2>
 * <ul>
 *   <li>Increase code size without adding value</li>
 *   <li>Make code harder to maintain</li>
 *   <li>Can cause inconsistencies (duplicate code)</li>
 *   <li>Waste developers' time and attention</li>
 *   <li>Reduce code readability</li>
 * </ul>
 * 
 * <h2>Types of Dispensables in this Package</h2>
 * <ol>
 *   <li><b>Duplicate Code</b> - Same code in multiple places</li>
 *   <li><b>Lazy Class</b> - Class that doesn't do enough to justify its existence</li>
 *   <li><b>Data Class</b> - Class with only fields and getters/setters, no behavior</li>
 *   <li><b>Dead Code</b> - Unused code that can be deleted</li>
 *   <li><b>Speculative Generality</b> - Code for features that don't exist yet</li>
 * </ol>
 * 
 * <h2>General Refactoring Approaches</h2>
 * <ul>
 *   <li>Extract Method to eliminate duplication</li>
 *   <li>Pull Up Method to base class</li>
 *   <li>Inline Class for lazy classes</li>
 *   <li>Move Method to add behavior to data classes</li>
 *   <li>Delete dead code</li>
 * </ul>
 * 
 * @see <a href="https://refactoring.guru/refactoring/smells/dispensables">Refactoring Guru - Dispensables</a>
 */
package com.codesmells.dispensables;
