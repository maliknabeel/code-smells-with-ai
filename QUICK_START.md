# Quick Start Guide

## 🚀 Get Started in 5 Minutes!

### Step 1: Clone the Repository
```bash
git clone https://github.com/maliknabeel/code-smells-with-ai.git
cd code-smells-with-ai
```

### Step 2: Build the Project
```bash
mvn clean install
```

### Step 3: Open in Your IDE
- **IntelliJ IDEA**: File → Open → Select the project folder
- **Eclipse**: File → Import → Maven → Existing Maven Projects
- **VS Code**: File → Open Folder → Select the project folder

### Step 4: Start Learning!

#### For Students:
1. Read **README.md** for overview (5 min)
2. Open **STUDENT_GUIDE.md** for your learning path (start with Week 1)
3. Navigate to `src/main/java/com/codesmells/bloaters/longmethod/`
4. Open `bad/OrderProcessorService.java` - Read and identify problems
5. Open `good/OrderProcessorService.java` - See the solution
6. Repeat for other examples!

#### For Instructors:
1. Read **README.md** for overview
2. Open **INSTRUCTOR_GUIDE.md** for teaching strategies
3. Review the examples you want to teach
4. Use the provided activities and assessments
5. Adapt materials to your course

## 📖 What to Learn First

### Beginners Start Here:
1. **Long Method** (`bloaters.longmethod`)
   - Easiest to understand
   - Clear before/after comparison
   - Shows Extract Method refactoring

2. **Duplicate Code** (`dispensables.duplicatecode`)
   - Very common problem
   - Easy to spot
   - Simple to fix

3. **Long Parameter List** (`bloaters.longparameterlist`)
   - Clear problem
   - Easy solution
   - Introduces parameter objects

### Intermediate Level:
4. **Large Class** (`bloaters.largeclass`)
   - More complex
   - Shows Extract Class
   - Multiple new classes

5. **Switch Statements** (`oopabusers.switchstatements`)
   - Introduces polymorphism
   - Shows Open/Closed Principle
   - SpringBoot dependency injection

### Advanced Level:
6. **Primitive Obsession** (`bloaters.primitiveobsession`)
   - Value objects concept
   - Domain modeling
   - Type safety

7. **Feature Envy** (`couplers.featureenvy`)
   - Subtle smell
   - Requires good judgment
   - Move Method refactoring

## 🎯 Quick Reference

### All Code Smell Locations

```
Bloaters:
  Long Method:           bloaters.longmethod.bad/good
  Large Class:           bloaters.largeclass.bad/good
  Primitive Obsession:   bloaters.primitiveobsession.bad/good
  Long Parameter List:   bloaters.longparameterlist.bad/good
  Data Clumps:           bloaters.dataclumps.bad/good

OOP Abusers:
  Switch Statements:     oopabusers.switchstatements.bad/good

Dispensables:
  Duplicate Code:        dispensables.duplicatecode.bad/good
  Data Class:            dispensables.dataclass.bad/good

Couplers:
  Feature Envy:          couplers.featureenvy.bad/good
  Message Chains:        couplers.messagechain.bad/good
```

## 🔍 How to Read the Examples

### Step 1: Open the BAD Example
- Located in `bad/` package
- Read the JavaDoc at the top
- Try to find problems yourself
- Note how the code feels to read

### Step 2: Open the GOOD Example
- Located in `good/` package
- Compare with the bad version
- Read the JavaDoc explaining benefits
- Notice how much clearer it is

### Step 3: Type It Yourself
- Don't just read - TYPE the code
- Try modifying it
- Break it and fix it
- Make it your own

## 💡 Pro Tips

### For Learning:
- ✅ Study one smell at a time
- ✅ Take notes in your own words
- ✅ Find examples in real code
- ✅ Discuss with classmates
- ✅ Practice with exercises

### For Teaching:
- ✅ Show bad code first, let students spot problems
- ✅ Live code the refactoring
- ✅ Use the provided activities
- ✅ Have students review each other's code
- ✅ Connect to real-world scenarios

## 📚 Documentation Guide

| Document | Purpose | When to Read |
|----------|---------|--------------|
| **README.md** | Project overview | First - 10 min |
| **STUDENT_GUIDE.md** | Learning plan | For studying - ongoing |
| **INSTRUCTOR_GUIDE.md** | Teaching materials | For instructors - before course |
| **PROJECT_SUMMARY.md** | Complete details | For deep understanding |

## 🛠️ Common Commands

```bash
# Build the project
mvn clean install

# Compile only
mvn compile

# Run the application
mvn spring-boot:run

# Package as JAR
mvn package

# Clean build artifacts
mvn clean
```

## 🎓 Study Schedule

### Week 1: Foundation
- Day 1: Read README, setup project
- Day 2-3: Long Method
- Day 4-5: Duplicate Code
- Day 6-7: Review and practice

### Week 2: Bloaters
- Day 1-2: Large Class
- Day 3-4: Primitive Obsession
- Day 5-6: Long Parameter List & Data Clumps
- Day 7: Review

### Week 3-4: Advanced Topics
- Switch Statements
- Data Class
- Feature Envy
- Message Chains

### Week 5: Practice
- Find smells in real code
- Refactor your own projects
- Review peer code
- Create your own examples

## 🆘 Need Help?

### Understanding Issues
- Re-read the JavaDoc comments
- Compare bad and good versions side by side
- Read STUDENT_GUIDE.md for deeper explanations
- Discuss with classmates or instructor

### Technical Issues
- Ensure Java 17+ is installed
- Ensure Maven 3.6+ is installed
- Check IDE is configured for Maven projects
- Try `mvn clean install` to rebuild

### Learning Struggles
- Start with easier examples (Long Method, Duplicate Code)
- Type the code yourself - don't just read
- Take breaks - learning takes time
- Connect concepts to code you've written

## 📊 Track Your Progress

Create a checklist for yourself:

```
Bloaters:
  [ ] Long Method - Understood and practiced
  [ ] Large Class - Understood and practiced
  [ ] Primitive Obsession - Understood and practiced
  [ ] Long Parameter List - Understood and practiced
  [ ] Data Clumps - Understood and practiced

OOP Abusers:
  [ ] Switch Statements - Understood and practiced

Dispensables:
  [ ] Duplicate Code - Understood and practiced
  [ ] Data Class - Understood and practiced

Couplers:
  [ ] Feature Envy - Understood and practiced
  [ ] Message Chains - Understood and practiced

Skills:
  [ ] Can identify code smells
  [ ] Can explain why they're bad
  [ ] Can apply refactorings
  [ ] Can write cleaner code from scratch
```

## 🎉 You're Ready!

Now you have everything you need to:
- ✅ Learn about code smells
- ✅ Improve your coding skills
- ✅ Write cleaner code
- ✅ Do better in your coursework
- ✅ Be prepared for professional work

**Start with README.md and then dive into the code!**

**Good luck! 🚀**
