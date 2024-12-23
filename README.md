# Design Patterns in Java

This repository is dedicated to learning and implementing various design patterns in Java. Each pattern includes an example implementation, use cases, and step-by-step explanations to help understand the concepts thoroughly.

## Getting Started

To get started with this repository:

1. Clone the repository:
   ```bash
   git clone https://github.com/sanjaykumar-777/design-patterns.git
   cd design-patterns
   ```

2. Open the project in your favorite IDE (e.g., IntelliJ IDEA or Eclipse).

3. Navigate to the specific design pattern you want to explore.

---

## Design Patterns Covered

### 1. Singleton Pattern
- Ensures that a class has only one instance.
- Provides a global point of access to that instance.

#### Steps to Implement Singleton Pattern

1. **Private Constructor**
   - Prevents instantiation of the class from outside.
   - Prevents new object creation from reflections attack.

   ```java
   private Browser() {
     if(browser!= null){
                throw new IllegalArgumentException("object already exists");
        }
   }
   ```

2. **Static Instance**
   - Use a static field to hold the single instance.
   ```java
   private volatile static Browser browser;
   ```

3. **Public Access Method**
   - Provide a public method to access the instance, creating it if necessary.
   ```java
   public static Browser getInstance() {
       if (browser == null) {
           browser = new Browser();
       }
       return browser;
   }
   ```

4. **Thread Safety**
   - Ensure thread safety in multithreaded environments using synchronization.
   ```java
   public static synchronized Browser getInstance() {
       if (browser == null) {
           browser = new Browser();
       }
       return browser;
   }

   public static Browser getInstance() {
       if (browser == null) {
           synchronized (Browser.class) {
                if (browser == null) {
                    browser = new Browser();
                }
            }
       }
       return browser;
   }
   ```

#### Use Cases
- Database connection management.
- Configuration or settings management.
- Logging services.

---

## Planned Design Patterns

- Factory Pattern
- Builder Pattern
- Strategy Pattern
- Observer Pattern
- Adapter Pattern

---

## How to Contribute

1. Fork the repository.
2. Create a new branch for your changes:
   ```bash
   git checkout -b new-pattern
   ```
3. Commit your changes and push them to your forked repository.
4. Open a pull request to the main repository.

---

Feel free to explore, learn, and contribute to this repository as you dive deeper into the world of design patterns!
