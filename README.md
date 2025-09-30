# Exercise 1 – Design Pattern Demonstrations

The first part of the coding exercise asked for **six use cases** that show my understanding of different design patterns:

* **2 Behavioral**
* **2 Creational**
* **2 Structural**

Instead of writing abstract code, I tried to come up with **small but practical scenarios** for each pattern. The focus was on clarity and reusability.

---

## ✅ Behavioral Patterns

1. **Observer Pattern**

   * I used this to simulate a simple notification system.
   * Example: when the subject changes state, multiple observers (listeners) are notified automatically.
   * In my project: I implemented it in `BehavioralPatterns_Observer_Pattern.java`.

2. **Strategy Pattern**

   * I demonstrated this by creating a simple calculator that can switch between different operations (like add, subtract, multiply) without changing the core logic.
   * This shows how behavior can be selected at runtime.

---

## ✅ Creational Patterns

1. **Factory Pattern**

   * Implemented in `CreationalPatterns_FactoryPattern.java`.
   * I used it to create objects (for example, different types of shapes or tasks) without exposing the creation logic to the client.
   * It helps centralize validation and ensures consistent object creation.

2. **Singleton Pattern**

   * I showed how to restrict a class to a single instance (used later in Exercise 2 as well).
   * A common use case is configuration management or a central logger.

---

## ✅ Structural Patterns

1. **Adapter Pattern**

   * I wrote a small example to demonstrate how you can make incompatible classes work together by adding an adapter in between.
   * Think of it as a plug converter.

2. **Decorator Pattern**

   * I demonstrated how to add extra responsibilities to an object dynamically without modifying its structure.
   * Example: wrapping a basic notification system to also send email or SMS.

---

## 📂 Files for Exercise 1

```
BehavioralPatterns_Observer_Pattern.java
BehavioralPatterns_Strategy_Pattern.java
CreationalPatterns_FactoryPattern.java
CreationalPatterns_Singleton_Pattern.java
StructuralPatterns_Adapter_Pattern.java
StructuralPatterns_Decorator_Pattern.java
```

Each file is a **standalone Java class with a `main` method** so it can be compiled and run directly.

---

## ▶️ How to Run

1. Compile any example:

   ```bash
   javac BehavioralPatterns_Observer_Pattern.java
   ```

2. Run it:

   ```bash
   java BehavioralPatterns_Observer_Pattern
   ```

Each file will show console output demonstrating how the design pattern works.

---

## 🎯 Why I chose these patterns

* I didn’t just pick random patterns. I chose **commonly used, easy-to-explain patterns** so I can confidently walk through them in an interview.
* They also tie in nicely with **Exercise 2** (e.g., Singleton and Factory are reused in the Astronaut Scheduler).
* This way the repo feels consistent and practical rather than just academic.

---

👉 Would you like me to also **merge Exercise 1 and Exercise 2 into one README.md file** (a single combined project README), or do you prefer having **two separate READMEs** (one inside `ex1/` and one inside `ex2/` folders)?

EX2
# Astronaut Daily Schedule Organizer

This project is part of the **Human Capital 2025-26 coding exercises**.
The idea was to build a simple console program in **Java** that can help astronauts manage their daily schedules.

I focused less on fancy UI and more on **clean code, design patterns, SOLID principles, and error handling**. The project is also structured so that I can easily walk someone through the design choices and code flow.

---

## What the project does

* Lets you **add, view, edit, and remove tasks** from a daily schedule.
* Each task has a **description, start time, end time, and priority** (High/Medium/Low).
* Tasks are stored in memory and always shown **sorted by start time**.
* Prevents **overlapping tasks** by checking conflicts before adding.
* You can also **mark tasks as completed** and **filter by priority**.

---

## Design choices & patterns

* **Singleton** → `ScheduleManager` is the central class that manages all tasks. There should only ever be one schedule in the application.
* **Factory** → `TaskFactory` creates tasks, while also handling validation of inputs like time format and priority.
* **Observer** → I added a notification system (`TaskObserver` + `ConsoleNotifier`) so the app can react whenever a task is added, removed, updated, or conflicts with another.

I picked these three patterns because they made sense for the problem and also matched the expectations in the exercise.

---

## How to run

1. Clone the repo or download the files.
2. Compile everything:

   ```bash
   javac *.java
   ```
3. Run the main program:

   ```bash
   java AstronautScheduler
   ```

That’s it — it runs completely in the terminal.

---

## Commands inside the app

* `add` → Add a new task (it asks for details interactively).
* `remove <id>` → Remove task by its ID.
* `remove_desc <desc>` → Remove task by its description.
* `view` → Show all tasks, sorted by start time.
* `view_priority <High|Medium|Low>` → Show only tasks with a specific priority.
* `edit_time <id>` → Change the start/end time of an existing task.
* `complete <id>` → Mark a task as completed.
* `help` → Show all available commands.
* `exit` → Quit the application.

---

## Example run

```
> add
Description: Morning Exercise
Start (HH:mm): 07:00
End (HH:mm): 08:00
Priority (High/Medium/Low): High
Task added: 07:00 - 08:00: Morning Exercise [HIGH]

> add
Description: Team Meeting
Start (HH:mm): 09:00
End (HH:mm): 10:00
Priority (High/Medium/Low): Medium
Task added: 09:00 - 10:00: Team Meeting [MEDIUM]

> add
Description: Training Session
Start (HH:mm): 09:30
End (HH:mm): 10:30
Priority (High/Medium/Low): High
CONFLICT: Task 'Training Session' conflicts with existing 'Team Meeting'
ERROR: Task conflicts with existing task: Team Meeting

> view
07:00 - 08:00: Morning Exercise [HIGH]
09:00 - 10:00: Team Meeting [MEDIUM]
```

---

## Why this matters

The focus of this exercise was not just to make it work, but to make it **robust, maintainable, and explainable**.

* I avoided shortcuts like `while(true)` loops.
* I used proper **logging** and **exception handling**.
* The code is split into logical classes so it’s easy to follow.

If I had more time, I’d extend it to persist tasks to a file or database, and maybe add recurring tasks or reminders.

---
