# Student Learning Guide - Code Smells

## 📚 Welcome!

This guide will help you learn about code smells and how to write better code. Whether you're a 6th semester student or learning on your own, this guide will walk you through everything step by step.

## 🎯 What You'll Learn

By the end of this guide, you will:
- Recognize 15+ common code smells in real Java code
- Understand why these patterns are problematic
- Know how to refactor bad code into good code
- Write cleaner, more maintainable code
- Apply SOLID principles in practice

## 📖 How to Use This Repository

### Week-by-Week Study Plan

#### Week 1: Introduction and Bloaters
**Day 1-2: Understanding the Basics**
- Read the main README.md
- Understand what code smells are and why they matter
- Study the SOLID principles overview

**Day 3-4: Long Method**
- Location: `com.codesmells.bloaters.longmethod`
- Read `bad/OrderProcessorService.java` - Identify problems yourself
- Then read `good/OrderProcessorService.java` - See the solution
- Exercise: Find a long method in your own code and refactor it

**Day 5-7: Large Class**
- Location: `com.codesmells.bloaters.largeclass`
- Study the bad `UserManager.java` - note how many responsibilities it has
- Study the good version split into 5 focused classes
- Exercise: Identify a large class in a project and plan how to split it

#### Week 2: More Bloaters
**Day 1-2: Primitive Obsession**
- Location: `com.codesmells.bloaters.primitiveobsession`
- Study how primitives are used in the bad example
- See how value objects (Email, PhoneNumber, Money) improve the code
- Exercise: Create your own value object (e.g., for ISBN, CreditCard)

**Day 3-4: Long Parameter List**
- Location: `com.codesmells.bloaters.longparameterlist`
- Count parameters in the bad example (10!)
- See how parameter objects clean it up (3 parameters)
- Exercise: Find methods with many parameters and create parameter objects

**Day 5-7: Data Clumps**
- Location: `com.codesmells.bloaters.dataclumps`
- Notice parameters that always appear together
- See how grouping them simplifies the code
- Practice: Review your code for data clumps

#### Week 3: Object-Orientation Abusers
**Day 1-3: Switch Statements**
- Location: `com.codesmells.oopabusers.switchstatements`
- Study the bad example with multiple switch statements
- See how polymorphism eliminates all switches
- Exercise: Convert a switch statement to polymorphism

**Day 4-7: Review and Practice**
- Try to find these smells in open source projects
- Discuss with classmates what you've learned
- Start applying these principles in your assignments

#### Week 4: Dispensables
**Day 1-3: Duplicate Code**
- Location: `com.codesmells.dispensables.duplicatecode`
- See how duplication causes maintenance problems
- Learn the Extract Method refactoring
- Exercise: Find and eliminate duplication in your code

**Day 4-7: Data Class**
- Location: `com.codesmells.dispensables.dataclass`
- Understand "Tell, Don't Ask" principle
- See how to add behavior to data classes
- Exercise: Find anemic domain models and add behavior

#### Week 5: Couplers
**Day 1-3: Feature Envy**
- Location: `com.codesmells.couplers.featureenvy`
- Identify methods that are too interested in other classes
- Learn to move methods to where they belong
- Exercise: Find feature envy in your projects

**Day 4-7: Message Chains**
- Location: `com.codesmells.couplers.messagechain`
- Study the Law of Demeter violations
- See how to hide delegates
- Exercise: Eliminate message chains in your code

## 🎓 Learning Tips

### Before You Start Studying
1. **Set up your environment**: Clone the repo and open it in your IDE
2. **Build the project**: Run `mvn clean install`
3. **Have a notebook**: Take notes as you study
4. **Study with peers**: Discuss examples with classmates

### While Studying Each Example
1. **Read the bad example first**: Try to identify problems yourself before reading comments
2. **Ask yourself**: "Why is this bad? What could go wrong?"
3. **Read the JavaDoc**: It explains the problems and solutions
4. **Compare side by side**: Open both bad and good versions in split screen
5. **Type the code**: Don't just read - actually type the examples yourself
6. **Modify and experiment**: Change the code to see what happens

### After Studying Each Example
1. **Summarize**: Write a one-paragraph summary of what you learned
2. **Practice**: Find similar code in your projects
3. **Teach someone**: Explain the concept to a friend
4. **Create your own example**: Make up a scenario with this smell

## 📝 Study Exercises

### Exercise 1: Code Smell Identification
Look at this code and identify ALL the code smells:

```java
public class OrderProcessor {
    public double process(String custId, String n, String e, String addr, 
                         List<String> items, String pmt) {
        // ... 100 lines of code doing everything
    }
}
```

**Smells to find**: Long Method, Long Parameter List, Primitive Obsession

### Exercise 2: Refactoring Practice
Take the UserManager from `bloaters.largeclass.bad` and:
1. List all the responsibilities it has
2. Draw a diagram showing how to split it
3. Write the refactored code yourself before looking at the good version

### Exercise 3: Code Review
Review a classmate's code and:
1. Identify 3 code smells
2. Explain why they're problematic
3. Suggest specific refactorings
4. Discuss your findings with them

### Exercise 4: Real-World Application
In your current project:
1. Find at least one code smell from each category
2. Refactor it using the techniques learned
3. Document the before/after
4. Share your experience with the class

## 🤔 Self-Assessment Questions

After each topic, ask yourself:

### Understanding
- [ ] Can I explain this code smell in my own words?
- [ ] Can I recognize this smell in unfamiliar code?
- [ ] Do I understand WHY this is a problem?

### Application
- [ ] Can I refactor code with this smell?
- [ ] Do I know which refactoring technique to use?
- [ ] Can I explain the benefits of the refactoring?

### Mastery
- [ ] Can I teach this concept to someone else?
- [ ] Can I identify this smell in my own code?
- [ ] Do I naturally avoid this smell when writing new code?

## 🔍 Deep Dive: Understanding One Example

Let's deeply analyze **Long Method** as an example:

### Step 1: Read the Bad Code
Open: `bloaters.longmethod.bad.OrderProcessorService.java`

**What to look for:**
- How many lines is the `processOrder` method? (Over 60!)
- How many different things does it do? (At least 7)
- Could you easily add a new feature? (No - would make it even longer)

### Step 2: Identify Problems
**Make a list:**
1. Hard to understand - need to read entire method
2. Hard to test - can't test parts independently
3. Hard to reuse - calculation logic trapped in this method
4. Violates Single Responsibility - does too many things
5. Hard to maintain - changes in one part affect the whole method

### Step 3: Study the Solution
Open: `bloaters.longmethod.good.OrderProcessorService.java`

**Key observations:**
- Main method is now ~15 lines and reads like a story
- Each small method does ONE thing
- Each method is easy to understand
- Each method can be tested independently
- Each method can be reused elsewhere

### Step 4: Apply the Pattern
Now YOU do it! Write a long method (30+ lines) and refactor it:

```java
// Your turn: Create a calculateGrade method that:
// 1. Validates student ID
// 2. Loads assignments
// 3. Calculates homework average
// 4. Calculates exam average
// 5. Applies curve
// 6. Determines letter grade
// 7. Sends notification

// First write it as one long method (BAD)
// Then refactor using Extract Method (GOOD)
```

## 💡 Key Principles to Remember

### DRY (Don't Repeat Yourself)
- Every piece of knowledge should have a single representation
- Duplication is the root of many evils

### SOLID Principles
- **S**ingle Responsibility: One class, one reason to change
- **O**pen/Closed: Open for extension, closed for modification
- **L**iskov Substitution: Subclasses should be substitutable
- **I**nterface Segregation: Many specific interfaces > one general
- **D**ependency Inversion: Depend on abstractions

### Law of Demeter
- "Only talk to your immediate friends"
- Avoid: `a.getB().getC().doSomething()`
- Prefer: `a.doSomething()`

### Tell, Don't Ask
- Tell objects what to do
- Don't ask for data and manipulate it yourself
- Avoid: Getting all data and making decisions externally
- Prefer: Asking object to perform action

## 🎯 Practice Projects

### Project 1: Refactoring Challenge
Take any small project (100-500 lines) and:
1. Identify all code smells
2. Create a refactoring plan
3. Refactor one smell at a time
4. Test after each refactoring
5. Document your changes

### Project 2: Code Smell Detector
Build a simple tool that:
- Counts method lines (detect long methods)
- Counts parameters (detect long parameter lists)
- Identifies duplicated code blocks
- Generates a report

### Project 3: Teaching Materials
Create teaching materials:
- Make your own code smell examples
- Create flashcards for each smell
- Make a quiz for your classmates
- Present a code smell to the class

## 📚 Additional Resources

### Books
- "Clean Code" by Robert Martin
- "Refactoring" by Martin Fowler
- "Effective Java" by Joshua Bloch

### Online
- [Refactoring Guru](https://refactoring.guru) - Excellent visual guide
- [SourceMaking](https://sourcemaking.com) - Design patterns and smells
- [Code Smell Cheat Sheet](https://www.jetbrains.com/idea/docs/refactoring-guide.pdf)

### Videos
- Search YouTube for "Clean Code" talks
- Martin Fowler's refactoring videos
- Conference talks on code quality

## 🤝 Study Groups

### Weekly Study Group Format
**Meeting 1: Introduction (1 hour)**
- Everyone shares one code smell they found
- Discuss why it's a problem
- Brainstorm solutions

**Meeting 2: Deep Dive (1.5 hours)**
- Pick one category (e.g., Bloaters)
- Each person presents one smell
- Do a live refactoring together

**Meeting 3: Practice (2 hours)**
- Bring code with smells (yours or open source)
- Peer review each other's code
- Refactor together

**Meeting 4: Quiz & Discussion (1 hour)**
- Quiz each other on identifying smells
- Discuss real-world examples
- Plan next week's topics

## ✅ Checklist for Success

Before moving to the next category:
- [ ] I can identify this smell in code
- [ ] I understand why it's problematic
- [ ] I know how to refactor it
- [ ] I've practiced refactoring it myself
- [ ] I've found this smell in real code
- [ ] I can explain it to someone else

## 🎓 For Exam Preparation

### Know These for Each Smell
1. **Definition**: What is this code smell?
2. **Identification**: How do I recognize it?
3. **Problems**: Why is it bad?
4. **Refactoring**: How do I fix it?
5. **Example**: Can I give a simple example?

### Common Exam Questions
1. Identify the code smell in given code
2. Explain why it's problematic (3-4 points)
3. Describe the refactoring technique
4. Write refactored code
5. Compare before and after

### Quick Reference
Create a one-page cheat sheet with:
- Smell name
- Key indicator
- Main problem
- Refactoring technique
- One-line example

---

**Remember**: Learning to write clean code is a journey, not a destination. Be patient with yourself, practice regularly, and don't be afraid to make mistakes. Every piece of messy code you refactor makes you a better developer!

**Good luck with your studies! 🚀**
