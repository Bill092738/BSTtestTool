# BSTtestTool

A Java-based, cross-platform, and cross-language tool for generating test cases for Binary Search Tree (BST) implementations. This tool allows users to create test cases in a text file (`Input.txt`) with either worst-case ordered or random unique numbers.

## Features

- **Cross-Platform**: Runs on any platform with Java installed.
- **Flexible Modes**:
  - **Worst-Case Ordered Mode**: Generates numbers in ascending order for testing edge cases in BST implementations.
  - **Random Mode**: Generates unique random numbers within a specified range.
- **Customizable Input**:
  - Specify the range of numbers (e.g., `1-10000`).
  - Specify the quantity of unique numbers to generate.
- **Robust Input Validation**: Ensures all user inputs are valid and provides meaningful error messages for invalid inputs.
- **Output**: Generates a text file (`Input.txt`) containing the test cases.

## How to Use

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-repo/BSTtestTool.git
   cd BSTtestTool
   ```

2. **Compile the Program**:
   Ensure you have Java installed. Compile the program using:
   ```bash
   javac BSTtestGenerator.java
   ```

3. **Run the Program**:
   Execute the program with:
   ```bash
   java BSTtestGenerator
   ```

4. **Follow the Prompts**:
   - Choose the mode:
     - `1` for worst-case ordered test case.
     - `2` for random test case.
   - Enter the range of numbers (e.g., `1-10000`).
   - Enter the quantity of unique numbers to generate.

5. **Check the Output**:
   - The generated test cases will be saved in a file named `Input.txt` in the same directory.

## Example

### Input:
```
Choose mode (1 for worst-case ordered, 2 for random): 1
Enter the range of numbers (e.g., 1-10000): 1-50
Enter the quantity of unique numbers to generate: 10
```

### Output (`Input.txt`):
```
1,2,3,4,5,6,7,8,9,10
```

### Input:
```
Choose mode (1 for worst-case ordered, 2 for random): 2
Enter the range of numbers (e.g., 1-10000): 1-50
Enter the quantity of unique numbers to generate: 10
```

### Output (`Input.txt`):
```
23,45,12,34,7,9,50,1,8,19
```

## Requirements

- **Java**: JDK 8 or higher.

## Error Handling

The program includes robust input validation to handle invalid inputs gracefully:
- Invalid mode selection.
- Invalid range format (e.g., `1-10000` is required).
- Invalid quantity (must be greater than `0` and less than or equal to the range size).

## Contributing

Contributions are welcome! If you have suggestions for improvements or new features, feel free to open an issue or submit a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Main Contributor: **Bill092738**
- Assisted by: **GitHub Copilot**