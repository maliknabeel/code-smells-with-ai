/**
 * CHANGE PREVENTERS - Code Smells that make modifications difficult.
 * 
 * Concepts:
 * - Divergent Change: one class changes for multiple reasons.
 * - Shotgun Surgery: one change requires edits in many classes.
 * - Parallel Inheritance Hierarchies: adding a subtype forces parallel subtypes.
 * 
 * Learning Objectives:
 * - Identify reasons-for-change and split responsibilities.
 * - Centralize logic to avoid widespread edits.
 * - Prefer composition over parallel hierarchies.
 * 
 * Examples:
 * - divergentchange.bad/good
 * - shotgunsurgery.bad/good
 * - parallelinheritance.bad/good
 * 
 * Reference: Refactoring techniques from industry-standard guides.
 */
package com.codesmells.changepreventers;
