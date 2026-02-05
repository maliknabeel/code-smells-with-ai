/**
 * COUPLERS - Excessive Coupling Between Code Elements
 * 
 * <h2>What are Couplers?</h2>
 * Code smells that indicate excessive coupling between classes.
 * When classes know too much about each other or chain too many method calls,
 * it becomes difficult to make changes without affecting many parts of the system.
 * 
 * <h2>Why are Couplers Problematic?</h2>
 * <ul>
 *   <li>Changes in one class ripple through many others</li>
 *   <li>Difficult to test classes in isolation</li>
 *   <li>Hard to reuse classes independently</li>
 *   <li>Reduces maintainability</li>
 *   <li>Violates Law of Demeter</li>
 * </ul>
 * 
 * <h2>Types of Couplers in this Package</h2>
 * <ol>
 *   <li><b>Feature Envy</b> - Method uses more features from another class</li>
 *   <li><b>Inappropriate Intimacy</b> - Classes know too much about each other</li>
 *   <li><b>Message Chains</b> - Long chains of method calls (a.b().c().d())</li>
 *   <li><b>Middle Man</b> - Class delegates most of its work to other classes</li>
 * </ol>
 * 
 * <h2>General Refactoring Approaches</h2>
 * <ul>
 *   <li>Move Method to the class that uses it most</li>
 *   <li>Extract Class to separate responsibilities</li>
 *   <li>Hide Delegate to reduce message chains</li>
 *   <li>Remove Middle Man if class is just delegating</li>
 * </ul>
 * 
 * @see <a href="https://refactoring.guru/refactoring/smells/couplers">Refactoring Guru - Couplers</a>
 */
package com.codesmells.couplers;
