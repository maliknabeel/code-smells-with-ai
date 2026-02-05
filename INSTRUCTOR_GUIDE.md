# Instructor Guide - Teaching Code Smells

## 📋 Course Overview

This repository provides comprehensive teaching materials for code smells and refactoring in Java SpringBoot. Designed for 6th semester software engineering students, it includes bad/good code examples, detailed documentation, and practical exercises.

## 🎯 Learning Outcomes

By the end of this module, students should be able to:
1. **Identify** at least 10 common code smells in Java code
2. **Explain** why each smell is problematic for software maintenance
3. **Apply** appropriate refactoring techniques to fix code smells
4. **Write** cleaner, more maintainable code following SOLID principles
5. **Critique** code quality in peer reviews

## 📚 Suggested Course Integration

### Module 1: Introduction to Code Quality (Week 1)
**Topics:**
- What are code smells?
- Why code quality matters
- Technical debt concept
- SOLID principles overview

**Activities:**
- Lecture: Show examples of messy vs clean code
- Discussion: Share experiences with hard-to-maintain code
- Demo: Live coding - write bad code, then refactor

**Assignment:** Have students find code smells in a provided codebase

### Module 2: Bloaters (Weeks 2-3)
**Day 1-2: Long Method**
- Lecture: Single Responsibility Principle
- Live Demo: Refactor a 100-line method in class
- Exercise: Students refactor provided long methods
- Homework: Find and fix long methods in their projects

**Day 3-4: Large Class**
- Lecture: Class cohesion and coupling
- Group Activity: Diagram how to split a large class
- Lab: Extract classes from provided examples
- Homework: Analyze class responsibilities in their code

**Day 5-6: Primitive Obsession**
- Lecture: Value objects and domain modeling
- Demo: Create Email, Money, PhoneNumber objects
- Exercise: Create value objects for specific domains
- Homework: Replace primitives in their projects

**Day 7-8: Long Parameter List & Data Clumps**
- Lecture: Parameter objects and cohesion
- Exercise: Identify data clumps in code
- Lab: Create parameter objects
- Homework: Clean up method signatures

### Module 3: Object-Orientation Abusers (Week 4)
**Switch Statements**
- Lecture: Polymorphism and Open/Closed Principle
- Demo: Convert switch to polymorphism
- Exercise: Implement Strategy pattern
- Homework: Find and refactor switch statements

### Module 4: Dispensables (Week 5)
**Duplicate Code**
- Lecture: DRY principle
- Exercise: Find duplicated code in provided examples
- Lab: Extract methods to eliminate duplication
- Homework: Reduce duplication in their projects

**Data Class**
- Lecture: Tell, Don't Ask principle
- Discussion: Anemic vs Rich domain models
- Exercise: Add behavior to data classes
- Homework: Enrich their domain models

### Module 5: Couplers (Week 6)
**Feature Envy & Message Chains**
- Lecture: Law of Demeter
- Demo: Refactor tightly coupled code
- Exercise: Move methods to appropriate classes
- Homework: Reduce coupling in their projects

## 🎓 Teaching Strategies

### Effective Lecture Techniques

#### 1. Start with Pain Points
Begin each topic by showing the problems:
```
"Imagine debugging this 200-line method at 2 AM.
Which line has the bug? How long to find it?"
```

#### 2. Use Real-World Examples
- Show actual production code (anonymized)
- Discuss famous software failures caused by poor code quality
- Share your own refactoring experiences

#### 3. Live Coding Sessions
- Write bad code intentionally
- Ask students to spot problems
- Refactor together step by step
- Use version control to show before/after

#### 4. Visual Aids
- Draw class diagrams showing coupling
- Use colors to highlight duplicated code
- Create flowcharts of complex methods
- Show metrics (cyclomatic complexity, etc.)

### Interactive Activities

#### Activity 1: Code Smell Scavenger Hunt (45 min)
**Setup:**
- Provide a 500-line codebase with multiple smells
- Students work in pairs
- Find and document as many smells as possible

**Debrief:**
- Each pair shares their findings
- Discuss which smells are most critical
- Vote on refactoring priorities

#### Activity 2: Refactoring Competition (60 min)
**Setup:**
- Divide class into teams
- Each team gets the same messy code
- 30 minutes to refactor
- Judge on code quality, not speed

**Scoring Criteria:**
- Code clarity (40%)
- Test coverage (30%)
- Smell elimination (20%)
- Explanation quality (10%)

#### Activity 3: Code Review Workshop (90 min)
**Setup:**
- Students bring their own code
- Form review pairs
- Each reviews the other's code
- Document findings

**Process:**
1. Silent reading (15 min)
2. Write review comments (15 min)
3. Discussion with partner (30 min)
4. Refactoring planning (30 min)

#### Activity 4: Refactoring Relay (45 min)
**Setup:**
- Team activity
- One student starts refactoring
- After 5 minutes, next student continues
- Each must explain their changes

**Learning:**
- Incremental refactoring
- Clear communication
- Building on others' work

### Demonstration Scripts

#### Demo 1: Long Method Refactoring
```
"Let me show you a real method from a project I worked on..."

[Show 80-line method on screen]

"First, let's identify what this method does..."
[Walk through with students]

"Now, let's extract the validation..."
[Live refactor]

"Notice how the main method is now readable?"
[Show refactored version]

"Each small method is testable independently."
[Show unit tests]
```

#### Demo 2: Switch to Polymorphism
```
"Here's a classic switch statement smell..."

[Show payment processing switch]

"Every time we add a payment type, we modify this class.
That violates the Open/Closed Principle."

[Implement polymorphic solution]

"Now we can add payment types without modifying existing code."
[Add new payment type without touching existing code]
```

## 📊 Assessment Strategies

### Formative Assessments (During Module)

#### Weekly Quizzes (10 min each)
**Week 1:** Identify code smells in snippets
**Week 2:** Match smells to refactorings
**Week 3:** Explain why code is problematic
**Week 4:** Choose best refactoring approach

#### Code Review Assignments
- Students review classmates' code
- Must identify 3 smells and suggest fixes
- Points for thoroughness and accuracy

#### Refactoring Labs
- Provide code with specific smells
- Students refactor and submit
- Auto-grade with tests
- Manual review for code quality

### Summative Assessments

#### Midterm Exam (100 points)
**Part A: Identification (30 points)**
- Given 6 code snippets
- Identify the code smell (5 points each)

**Part B: Explanation (30 points)**
- Choose 3 smells
- Explain why they're problematic (10 points each)

**Part C: Refactoring (40 points)**
- Given messy code
- Refactor to eliminate smells
- Write brief explanation

#### Final Project (200 points)
**Requirements:**
- Take a 500+ line codebase (provided or own project)
- Identify and document all code smells
- Create refactoring plan
- Implement refactorings
- Show before/after metrics
- Present to class (10 min)

**Rubric:**
- Smell identification (40 points)
- Refactoring quality (60 points)
- Code improvement metrics (40 points)
- Documentation (30 points)
- Presentation (30 points)

#### Practical Exam (50 points)
- Live coding session
- Given code with smells
- 30 minutes to refactor
- Must explain changes

### Grading Rubrics

#### Code Quality Rubric
| Criteria | Excellent (5) | Good (4) | Fair (3) | Poor (2) |
|----------|---------------|----------|----------|----------|
| **Smell Identification** | All smells found | Most found | Some found | Few found |
| **Refactoring Correctness** | Perfect application | Minor issues | Some mistakes | Major issues |
| **Code Clarity** | Very clear | Clear | Somewhat clear | Unclear |
| **Explanation** | Comprehensive | Good | Basic | Inadequate |
| **Testing** | Full coverage | Good coverage | Some tests | No tests |

## 🛠️ Lab Exercises

### Lab 1: Long Method Surgery (60 min)
**Objective:** Practice Extract Method refactoring

**Materials Provided:**
- OrderProcessorService with 100-line method
- Test suite (should pass before and after)

**Steps:**
1. Read and understand the code (10 min)
2. Identify logical sections (10 min)
3. Extract methods one by one (30 min)
4. Run tests to verify (5 min)
5. Peer review (5 min)

**Submission:**
- Refactored code
- List of extracted methods
- Reflection (what was hard? what did you learn?)

### Lab 2: Large Class Decomposition (90 min)
**Objective:** Practice Extract Class refactoring

**Materials:**
- UserManager class (300 lines)
- Diagram showing desired class structure

**Steps:**
1. Analyze class responsibilities (15 min)
2. Plan the extraction (15 min)
3. Create new classes (30 min)
4. Move methods and fields (20 min)
5. Test and verify (10 min)

### Lab 3: Primitive Obsession Cure (60 min)
**Objective:** Create and use value objects

**Task:**
Create value objects for:
- Email (with validation)
- PhoneNumber (with formatting)
- Money (with currency)

**Requirements:**
- Immutable objects
- Validation in constructor
- Appropriate equals/hashCode
- Unit tests for each

### Lab 4: Polymorphism Power (90 min)
**Objective:** Replace conditionals with polymorphism

**Materials:**
- Shape calculator with big switch
- Requirements for new shapes

**Steps:**
1. Create Shape interface
2. Implement shape classes
3. Remove switch statements
4. Add new shape (no modifying existing code!)
5. Demonstrate Open/Closed Principle

## 💡 Discussion Topics

### Topic 1: When to Refactor?
**Questions:**
- Is it always worth fixing code smells?
- How do you balance refactoring with feature development?
- What if refactoring introduces bugs?

**Learning Goals:**
- Understand trade-offs
- Learn to prioritize refactorings
- Appreciate value of tests

### Topic 2: Technical Debt
**Questions:**
- What is technical debt?
- When is it acceptable to incur technical debt?
- How do we measure and track it?

**Case Study:**
Present a scenario where team had to choose between quick feature and clean code.

### Topic 3: Code Reviews
**Questions:**
- How do you give constructive code review feedback?
- How do you receive criticism of your code?
- What makes a good code review?

**Activity:**
Practice code reviews with sample pull requests.

## 📈 Measuring Success

### Student Success Indicators
- **Before/After Code Metrics:**
  - Lines per method average
  - Cyclomatic complexity
  - Code duplication percentage
  - Class coupling metrics

- **Skill Development:**
  - Can identify 80%+ of smells in code
  - Can explain problems clearly
  - Can apply refactorings correctly
  - Can write cleaner code from scratch

### Course Effectiveness Metrics
- Pre/post assessment scores
- Code quality in final projects
- Student satisfaction surveys
- Peer review quality

## 🔧 Technical Setup

### Required Tools
- Java 17+
- Maven 3.6+
- IDE (IntelliJ IDEA recommended)
- Git

### Recommended IDE Plugins
- SonarLint (code smell detection)
- Checkstyle
- PMD
- SpotBugs

### Lab Environment
```bash
# Students should run:
git clone https://github.com/maliknabeel/code-smells-with-ai
cd code-smells-with-ai
mvn clean install
mvn spring-boot:run
```

## 📝 Sample Assignments

### Assignment 1: Code Smell Hunting (20 points)
**Due:** End of Week 2

**Task:**
Find one example of each bloater in an open-source project:
- Long Method
- Large Class
- Primitive Obsession
- Long Parameter List
- Data Clumps

**Deliverables:**
- Document with links to code
- Explanation of why it's a smell
- Suggested refactoring

### Assignment 2: Refactoring Practice (40 points)
**Due:** End of Week 4

**Task:**
Refactor provided codebase to eliminate all bloaters.

**Requirements:**
- All tests must still pass
- Code quality metrics must improve
- Document what you changed and why

### Assignment 3: Teaching Presentation (30 points)
**Due:** Throughout semester

**Task:**
Each student teaches one code smell to the class (10 min).

**Requirements:**
- Explain the smell
- Show bad example
- Demonstrate refactoring
- Answer questions

### Assignment 4: Final Refactoring Project (100 points)
**Due:** End of semester

**Task:**
Choose a project (your own or approved open-source) and:
1. Analyze for code smells
2. Create refactoring plan
3. Implement top 10 refactorings
4. Measure improvements
5. Present results

## 🎯 Tips for Success

### Do's
✅ Use real-world examples
✅ Live code in class
✅ Encourage experimentation
✅ Celebrate improvements
✅ Provide immediate feedback
✅ Connect to professional practice

### Don'ts
❌ Just lecture without demos
❌ Grade on perfection
❌ Ignore student code
❌ Skip the "why" behind refactorings
❌ Move too fast
❌ Make students feel bad about their code

### Common Challenges

**Challenge 1:** "My code works, why refactor?"
**Response:** Show maintenance scenarios, bug fixing time, feature addition difficulty

**Challenge 2:** "This takes too much time"
**Response:** Demonstrate time saved in long run, reduced debugging time

**Challenge 3:** "I don't know where to start"
**Response:** Provide clear step-by-step refactoring guides

## 📚 Additional Resources

### For You (Instructor)
- Martin Fowler's "Refactoring" book
- Robert Martin's "Clean Code" book
- Refactoring Guru website
- "Working Effectively with Legacy Code" by Feathers

### For Students
- Provide reading lists
- Link to video tutorials
- Share code quality tools
- Create practice repositories

---

**Remember:** Teaching code quality is about changing mindsets, not just teaching techniques. Help students see messy code as an opportunity to learn and improve, not a personal failing.

**Good luck with your course! 👨‍🏫**
