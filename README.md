
# 📊 Numerical Methods Calculator

A Java-based desktop application that provides a comprehensive suite of numerical methods tools, including matrix operations, root-finding algorithms, and graphical visualizations. Designed with a user-friendly GUI and step-by-step solution display, this calculator is ideal for students, educators, and engineers working with numerical analysis.

## 🚀 Features

- **Matrix Calculator**
  - Addition, subtraction, multiplication
  - Determinant and inverse calculation
  - Gauss and Gauss-Jordan elimination

- **Root-Finding Algorithms**
  - Newton-Raphson method
  - Bisection method
  - Secant method

- **Graphical Visualization**
  - Plot functions and iterations
  - Highlight convergence steps

- **Step-by-Step Solutions**
  - Detailed breakdown of each computational step
  - Intermediate matrices and iterations shown

- **Intuitive GUI**
  - Built with Java Swing (or JavaFX)
  - Responsive layout and input validation

## 🛠️ Technologies Used

- Java 11+
- Swing / JavaFX (for GUI)
- JFreeChart (for graphing)
- Apache Commons Math (optional for advanced math operations)

## 📦 Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/numerical-methods-calculator.git
   ```

2. Navigate to the project directory:
   ```bash
   cd numerical-methods-calculator
   ```

3. Compile and run the application:
   ```bash
   javac -d bin src/**/*.java
   java -cp bin Main
   ```

> Alternatively, open the project in an IDE like IntelliJ IDEA or Eclipse and run `Main.java`.

## 📈 Usage

1. Launch the application.
2. Select the desired numerical method from the menu.
3. Input the required parameters (e.g., matrix values, function expression, initial guess).
4. Click "Solve" to view:
   - Step-by-step solution
   - Graphical representation (if applicable)
   - Final result

## 📚 Example Problems

- **Gauss-Jordan Elimination**
  - Input: Augmented matrix
  - Output: Reduced row echelon form and solution vector

- **Newton-Raphson**
  - Input: Function `f(x)`, derivative `f'(x)`, initial guess
  - Output: Iterative steps, convergence graph, root approximation

## 🧪 Testing

Unit tests are located in the `test/` directory. To run tests:
```bash
javac -d bin test/**/*.java
java -cp bin org.junit.runner.JUnitCore MatrixCalculatorTest
```

## 📄 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## 🙌 Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss what you’d like to change.

---

Made with ❤️ by ITEC TEAM
```

