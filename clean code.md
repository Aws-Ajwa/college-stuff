
# [[how to write clean code]]
# [[principles]]
# thing to bare in mind
###  **1. Naming "Things" Properly**
#### **Why It Matters:**

- Names are the primary way we communicate the purpose of code. Well-named variables, functions, classes, and properties make your code self-documenting, reducing the need for additional comments.

#### **Guidelines:**

- **Be Descriptive**: Names should clearly describe the purpose of the variable or function. For instance, use `totalCost` instead of `tc` or `x`.
- **Use Meaningful Distinctions**: Avoid generic names like `data`, `item`, or `temp`. Instead, use names that convey the specific role of the variable, like `userData`, `invoiceItem`, or `temporaryFile`.
- **Avoid Noise Words**: Words like `Manager`, `Helper`, or `Data` add little meaning. Focus on what the entity does or represents.
- **Use Consistent Naming Conventions**: Stick to a single naming convention (e.g., camelCase for variables, PascalCase for classes) across your codebase.
- **Avoid Abbreviations**: Unless an abbreviation is well-known (e.g., `URL`, `HTML`), avoid them. Names like `numPts` are less clear than `numberOfPoints`.

#### **Common Pitfalls:**

- **Ambiguous Names**: Avoid names that are too generic or could be misunderstood. For example, `getData` doesn't convey what data is being retrieved.
- **Single-Letter Variables**: Unless in a very limited scope (e.g., loop counters like `i`), single-letter names should be avoided.

### **2. Common Pitfalls and Mistakes in Naming**

#### **Pitfalls to Avoid:**

- **Inconsistent Naming**: Inconsistency can confuse other developers and make the code harder to follow. If you name a function `fetchData` in one part of your code, don’t name a similar function `getData` elsewhere.
- **Misleading Names**: A variable named `isActive` should store a boolean value, not a complex object.
- **Overloading Names**: Reusing the same name in different contexts (e.g., a function `filter` and a variable `filter`) can lead to confusion.

### **3. Comments and Why Most of Them Are Bad**

#### **Why Most Comments Are Bad:**

- **Redundancy**: Comments that merely restate what the code is doing add clutter without providing additional value.
- **Drift**: As code changes, comments can become outdated, leading to misinformation.
- **Code Smell**: Excessive comments may indicate that the code is too complex or poorly named.

#### **Good Comments:**

- **Explain "Why", Not "What"**: Only add comments to explain why something is done a certain way if it's not immediately obvious. For instance, note why you’ve chosen a specific algorithm due to performance considerations.
    
- **Legal or Metadata**: Comments for licensing information, or to explain the intent of a tricky regular expression.
    
- **TODOs**: Comments indicating areas of code that need further work or refactoring.
    
    Example:
    
    javascriptCopy code
    
    `// Use binary search for performance reasons due to large dataset`
    

### **4. Code Formatting**

#### **Horizontal Formatting:**

- **Keep Lines Short**: Aim for a line length of 80-120 characters. This improves readability, especially on smaller screens.
- **Consistent Indentation**: Use spaces or tabs consistently across your project. Most teams prefer 2 or 4 spaces per indentation level.
- **Whitespace**: Use whitespace to improve readability. For example, separate operators with spaces (`a + b` instead of `a+b`), and leave blank lines between unrelated sections of code.

#### **Vertical Formatting:**

- **Group Related Code**: Keep related code close together. For instance, if a function and its helper functions are closely related, place them near each other.
- **Limit Function Length**: Functions should ideally fit within a single screen. This often means aiming for functions that are 20-50 lines long.
- **Logical Separation**: Use blank lines to separate logical blocks of code.

### **5. Functions and How to Limit Parameters**

#### **Why Limit Parameters?**

- **Complexity**: Functions with many parameters are harder to understand, use, and maintain.
- **Testing**: Functions with fewer parameters are easier to test because they have fewer possible combinations of inputs.

#### **Strategies to Limit Parameters:**

- **Use Objects for Parameters**: Instead of passing multiple parameters, pass a single object with named properties. This also makes the function call more self-documenting.
    
    javascriptCopy code
    
    `function createUser({ name, age, email }) { /* ... */ }`
    
- **Use Default Values**: If some parameters are optional, provide default values.
    
    javascriptCopy code
    
    `function createUser({ name, age = 18, email }) { /* ... */ }`
    
- **Split Functions**: If a function requires many parameters, consider whether it can be split into smaller functions, each with fewer parameters.
    

### **6. Writing Clean Functions by Focusing on "One Thing"**

#### **Single Responsibility Principle (SRP)**:

- **One Function, One Task**: Each function should perform one well-defined task. If your function is doing multiple things, it’s a candidate for refactoring.
- **Why It Matters**: Functions that do one thing are easier to understand, test, and reuse.

#### **Example**:

Bad:

javascriptCopy code

`function processOrder(order) {   validateOrder(order);   calculateTotals(order);   saveOrder(order);   sendConfirmationEmail(order); }`

Good:

javascriptCopy code

`function processOrder(order) {   validateOrder(order);   calculateTotals(order);   saveOrder(order);   sendConfirmationEmail(order); }  function validateOrder(order) { /*...*/ } function calculateTotals(order) { /*...*/ } function saveOrder(order) { /*...*/ } function sendConfirmationEmail(order) { /*...*/ }`

### **7. Levels of Abstraction to Split Functions**

#### **Why Abstraction Levels Matter**:

- **Clarity**: Functions should operate at a single level of abstraction. Mixing high-level logic with low-level details makes code harder to follow.
- **Example**:
    - **High-Level Function**: Manages business logic.
    - **Low-Level Function**: Handles specific tasks like calculations or API calls.

#### **Example**:

Bad:

javascriptCopy code

`function generateReport(data) {   // High-level: Report title   const title = "Monthly Sales Report";    // Low-level: Formatting data   data = data.map(item => formatData(item));    // High-level: Generating report   createPDF(title, data); }  function formatData(item) { /*...*/ }`

Good:

javascriptCopy code

`function generateReport(data) {   const formattedData = formatData(data);   const title = createTitle();   createPDF(title, formattedData); }  function formatData(data) { /*...*/ } function createTitle() { /*...*/ }`

### **8. Writing DRY Functions and Avoiding Side Effects**

#### **DRY Principle**:

- **Don’t Repeat Yourself**: If you find similar or identical code blocks, refactor them into a single function. Repeated code increases the risk of bugs and makes maintenance harder.

#### **Avoiding Side Effects**:

- **What Are Side Effects?**: A side effect is any change to the state or observable interaction with external systems that occurs outside of a function's return value.
- **Why Avoid Them?**: Side effects can make code unpredictable and harder to test.
- **Strategy**: Use pure functions where possible, i.e., functions that always produce the same output for the same input and have no side effects.

#### **Example**:

Bad:

javascriptCopy code

`function updateOrder(order) {   order.status = 'processed';  // Modifies the input object   saveToDatabase(order); }`

Good:

javascriptCopy code

`function updateOrder(order) {   const updatedOrder = { ...order, status: 'processed' };   saveToDatabase(updatedOrder); }`

### **9. Avoiding Deeply Nested Control Structures**

#### **Why Avoid Nesting?**

- **Readability**: Deeply nested code is hard to read and maintain.
- **Error-Prone**: It’s easy to miss conditions or logic in heavily nested code.

#### **Use Guards**:

- **Guard Clauses**: Return early from a function when a condition is met, instead of wrapping the entire function in a nested if-statement.
    
    javascriptCopy code
    
    `function processOrder(order) {   if (!order.isValid) {     return 'Invalid order';   }   // Continue with order processing }`
    

#### **Extract Functionality**:

- **Break Down**: If a block of code inside a loop or condition is complex, extract it into its own function.
    
    javascriptCopy code
    
    `function validateOrder(order) {   if (!order) return false;    return isPaymentValid(order) && isStockAvailable(order); }`
    

### **10. Errors and Error Handling as a Replacement for If-Statements**

#### **Why Use Exceptions?**

- **Cleaner Code**: Using exceptions for error handling can make code cleaner by separating the "happy path" from error-handling logic.
- **Avoid Nested Ifs**: Instead of checking for errors with nested `if` statements, throw errors when something goes wrong and handle them in one place.

#### **Example**:

Bad:

javascriptCopy code

`function`

processOrder(order) { if (order.isValid) { if (order.isPaid) { if (order.isInStock) { shipOrder(order); } else { console.error('Out of stock'); } } else { console.error('Payment not received'); } } else { console.error('Invalid order'); } }

Copy code

`Good: ```javascript function processOrder(order) {   if (!order.isValid) throw new Error('Invalid order');   if (!order.isPaid) throw new Error('Payment not received');   if (!order.isInStock) throw new Error('Out of stock');    shipOrder(order); }`

### **11. Objects & Data Containers/Data Structures**

#### **Objects**:

- **Encapsulation**: Objects encapsulate related data and behavior, making them useful for modeling real-world entities.
- **Methods**: Objects contain methods that operate on their data, promoting high cohesion.

#### **Data Structures**:

- **Collections**: Data structures like arrays, sets, and maps are used to store and manipulate collections of data.
- **Purpose**: Use data structures when you need to store multiple items without associating them with behaviors (methods).

#### **Why Differentiation Matters**:

- **Clarity**: Use objects for entities with behavior (methods), and data structures for passive data. This differentiation can help avoid overcomplicating your data models.

### **12. Cohesion and Writing Good Classes**

#### **Cohesion**:

- **Definition**: Cohesion refers to how closely related the responsibilities of a module (e.g., class, function) are.
- **Why It Matters**: High cohesion within a class means its methods are closely related, making it easier to understand and maintain.

#### **Strategies**:

- **Small, Focused Classes**: Each class should represent a single concept. Avoid classes that do too much, which can lead to low cohesion and high coupling.
- **SRP**: Follow the Single Responsibility Principle, ensuring each class has one reason to change.

#### **Example**:

Bad:

javascriptCopy code

`class OrderManager {   createOrder() { /*...*/ }   validateOrder() { /*...*/ }   calculateTotals() { /*...*/ }   sendEmail() { /*...*/ } }`

Good:

javascriptCopy code

`class Order {   validate() { /*...*/ }   calculateTotals() { /*...*/ } }  class EmailService {   sendOrderConfirmation(order) { /*...*/ } }`

### **13. The Law of Demeter**

#### **What Is It?**

- **Definition**: The Law of Demeter (LoD) advises that a module should only interact with its immediate dependencies and not “reach through” to interact with dependencies of dependencies.

#### **Why It Matters**:

- **Loose Coupling**: Following LoD helps reduce coupling, making your code more modular and easier to maintain.
- **Encapsulation**: It preserves encapsulation by preventing objects from knowing too much about the structure of other objects.

#### **Example**:

Bad:

javascriptCopy code

`order.getCustomer().getAddress().getZipCode();`

Good:

javascriptCopy code

`order.getCustomerZipCode();`

### **14. SOLID Principles**

#### **S - Single Responsibility Principle (SRP)**:

- **Definition**: A class should have one, and only one, reason to change.
- **Example**: A `User` class should not handle data validation, which can be delegated to a separate `UserValidator` class.

#### **O - Open/Closed Principle (OCP)**:

- **Definition**: Software entities should be open for extension, but closed for modification.
- **Example**: Use inheritance or composition to add new functionality rather than modifying existing code.

#### **L - Liskov Substitution Principle (LSP)**:

- **Definition**: Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.
- **Example**: If you have a `Bird` superclass and a `Penguin` subclass, the `Penguin` class should not violate expectations set by `Bird`, such as the ability to fly (if flying is a method in `Bird`).

#### **I - Interface Segregation Principle (ISP)**:

- **Definition**: No client should be forced to depend on methods it does not use.
- **Example**: Instead of one large interface, break it into smaller, more specific ones.

#### **D - Dependency Inversion Principle (DIP)**:

- **Definition**: High-level modules should not depend on low-level modules; both should depend on abstractions.
- **Example**: Use interfaces or abstract classes so that high-level components don't rely on low-level component implementations.

### **15. KISS (Keep It Stupid Simple)**

#### **What Is It?**

- **Definition**: The KISS principle advocates for simplicity in design. Avoid unnecessary complexity, and make your code as straightforward as possible.

#### **Why It Matters**:

- **Maintenance**: Simpler code is easier to maintain, debug, and extend.
- **Performance**: Simple solutions are often more performant because they involve fewer operations and less overhead.

#### **Strategies**:

- **Avoid Over-Engineering**: Don't add features or complexity that aren't needed right now.
- **Use Simple Constructs**: Stick to basic, well-known constructs unless a more complex solution is absolutely necessary.
- **Refactor**: Regularly refactor to simplify code that has become complex.

#### **Example**:

Bad:

javascriptCopy code

`function calculateDiscount(price) {   if (price > 100) {     return price * 0.10;   } else {     return 0;   } }`

Good:

javascriptCopy code

`function calculateDiscount(price) {   return price > 100 ? price * 0.10 : 0; }`
