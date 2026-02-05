/**
 * OBJECT-ORIENTATION ABUSERS - Incorrect Use of OOP Principles
 * 
 * <h2>What are Object-Orientation Abusers?</h2>
 * These code smells indicate that object-oriented programming principles are
 * being used incorrectly or not at all, leading to code that doesn't leverage
 * the power of polymorphism, encapsulation, and inheritance properly.
 * 
 * <h2>Why are OOP Abusers Problematic?</h2>
 * <ul>
 *   <li>Miss opportunities to use polymorphism</li>
 *   <li>Lead to rigid, hard-to-extend code</li>
 *   <li>Violate Open/Closed Principle</li>
 *   <li>Create unnecessary coupling</li>
 *   <li>Make code harder to test</li>
 * </ul>
 * 
 * <h2>Types of OOP Abusers in this Package</h2>
 * <ol>
 *   <li><b>Switch Statements</b> - Complex conditionals that should use polymorphism</li>
 *   <li><b>Temporary Field</b> - Fields only used in certain circumstances</li>
 *   <li><b>Refused Bequest</b> - Subclass doesn't use inherited behavior</li>
 *   <li><b>Alternative Classes with Different Interfaces</b> - Similar classes with different method names</li>
 * </ol>
 * 
 * <h2>General Refactoring Approaches</h2>
 * <ul>
 *   <li>Replace Type Code with Polymorphism</li>
 *   <li>Replace Conditional with Polymorphism</li>
 *   <li>Extract Class for temporary fields</li>
 *   <li>Use Composition over Inheritance</li>
 *   <li>Rename Methods for consistency</li>
 * </ul>
 * 
 * @see <a href="https://refactoring.guru/refactoring/smells/oo-abusers">Refactoring Guru - OO Abusers</a>
 */
package com.codesmells.oopabusers;
