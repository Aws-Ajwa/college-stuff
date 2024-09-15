
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

# code reviews
Performing a thorough code review involves several key steps, including pulling the branch from GitHub, testing the branch, and reviewing the code against various standards. Here's how to approach each step:

### 1. Pull the Branch from GitHub

1. **Open Terminal:**
    - Navigate to your project directory.
2. **Fetch and Checkout the Branch:**
    - Use the following commands to pull the branch:
        bash
        Copy code
        `git fetch origin git checkout <branch-name> git pull origin <branch-name>`
    - Replace `<branch-name>` with the name of the branch you want to review.
3. **Update Your Local Repository:**
    - Ensure your local branch is up-to-date with the remote branch:
        bash
        Copy code
        `git pull origin <branch-name>`
### 2. Test the Branch
1. **Run Unit Tests:**
    - Execute the project's unit tests to ensure the code works as expected:
        bash
        Copy code
        `npm test`
    - If the project is using a specific testing framework like Jest, Mocha, etc., run the appropriate command.
2. **Test Manually (if necessary):**
    - Run the application locally and perform manual testing, especially for UI changes or features that require user interaction.
3. **Check Code Coverage:**
    - Review the code coverage reports to ensure the new code is adequately tested:
        bash
        Copy code
        `npm run coverage`

### 3. Review Coding Standards
#### **a. Best Practices**
- **Variable Naming:** Ensure variable names are descriptive and follow the naming conventions (e.g., camelCase for JavaScript).
- **Function Names:** Functions should have meaningful names that describe their purpose.
- **Avoid Magic Numbers:** Replace magic numbers with named constants.
- **Error Handling:** Ensure proper error handling is in place using try-catch blocks or error-first callbacks.
#### **b. Company Standards**
- **Coding Style:** Adhere to the company’s specific coding style guidelines (e.g., indentation, line length, etc.).
- **Security Practices:** Ensure the code adheres to security best practices, such as input validation, avoiding SQL injection, etc.
- **Documentation:** Verify that all public methods and classes are properly documented with comments or JSDoc.

#### **c. SOLID Principles**

- **Single Responsibility Principle (SRP):** Each class or module should have one responsibility.
- **Open/Closed Principle (OCP):** Classes should be open for extension but closed for modification.
- **Liskov Substitution Principle (LSP):** Subtypes should be substitutable for their base types.
- **Interface Segregation Principle (ISP):** Clients should not be forced to depend on interfaces they do not use.
- **Dependency Inversion Principle (DIP):** High-level modules should not depend on low-level modules but on abstractions.

#### **d. Maintainability**

- **Modularization:** Ensure the code is modular and components are reusable.
- **Commenting:** Code should be self-explanatory; use comments sparingly for complex logic.
- **Refactoring:** Look for code smells and suggest refactoring where necessary (e.g., long methods, deep nesting).

#### **e. Readability**

- **Code Structure:** Ensure the code is organized logically with clear separation of concerns.
- **Naming Conventions:** Use consistent naming conventions across the codebase.
- **Formatting:** Ensure the code is properly formatted using tools like ESLint or Prettier:
    
    bash
    
    Copy code
    
    `npm run lint npm run format`
    

### 4. Final Steps
1. **Provide Feedback:**
    - Leave constructive comments on the pull request, suggesting improvements or asking questions where necessary.
2. **Approve/Request Changes:**
    - If the code meets the standards, approve the pull request. If not, request changes and provide specific guidance.
3. **Merge the Branch (if authorized):**
    - After approval, merge the branch into the main branch:
        bash
        Copy code
        `git checkout main git pull origin main git merge <branch-name> git push origin main`

By following these steps, you ensure that the code is well-tested, adheres to coding standards, and is maintainable and readable. This process helps maintain high-quality code in the project and aligns with best practices and company standards.

# System Design (C4 Model)
1. A set of hierarchical abstractions (software systems, containers, components, and code).  
2. A set of hierarchical diagrams (system context, containers, components, and code).  
3. Notation independent.  
4. Tooling independent
The C4 model is an easy to learn, developer friendly approach to software architecture diagramming. Good software architecture diagrams assist with communication inside/outside of software development/product teams, efficient onboarding of new staff, architecture reviews/evaluations, risk identification (e.g. [risk-storming](https://riskstorming.com/)), threat modelling, etc.
### Maps of your code

The C4 model was created as a way to help software development teams describe and communicate software architecture, both during up-front design sessions and when retrospectively documenting an existing codebase. It's a way to create maps of your code, at various levels of detail, in the same way you would use something like Google Maps to zoom in and out of an area you are interested in.
The C4 model is an "abstraction-first" approach to diagramming software architecture, based upon abstractions that reflect how software architects and developers think about and build software. The small set of abstractions and diagram types makes the C4 model easy to learn and use. Please note that you don't need to use all 4 levels of diagram; only those that add value - the System Context and Container diagrams are sufficient for many software development teams.

  

[![An overview of the C4 model](https://c4model.com/img/c4-overview.png)](https://c4model.com/img/c4-overview.png)
Different levels of zoom allow you to tell different stories to different audiences.
## Abstractions

In order to create these maps of your code, we first need a common set of abstractions to create a ubiquitous language that we can use to describe the static structure of a software system. A **software system** is made up of one or more **containers** (applications and data stores), each of which contains one or more **components**, which in turn are implemented by one or more **code elements** (classes, interfaces, objects, functions, etc). And **people** may use the software systems that we build.

  

[![Abstractions](https://c4model.com/img/abstractions.png)](https://c4model.com/img/abstractions.png)

### Person

A person represents one of the human users of your software system (e.g. actors, roles, personas, etc).

  

### Software System

A software system is the highest level of abstraction and describes something that delivers value to its users, whether they are human or not. This includes the software system you are modelling, and the other software systems upon which your software system depends (or vice versa).

Unfortunately the term "software system" is the hardest of the C4 model abstractions to define, and this isn't helped by the fact that each organisation will also have their own terminology for describing the same thing, typically using terms such as "application", "product", "service", etc. One way to think about it is that a software system is something a single software development team is building, owns, has responsibility for, and can see the internal implementation details of. Perhaps the code for that software system resides in a single source code repository, and anybody on the team is entitled to modify it. In many cases, the boundary of a software system will correspond to the boundary of a single team. It may also be the case that everything inside the boundary of a software system is deployed at the same time.

  

### Container (applications and data stores)

Not Docker! In the C4 model, a container represents an **application** or a **data store**. A container is something that needs to be running in order for the overall software system to work. In real terms, a container is something like:

- **Server-side web application**: A Java EE web application running on Apache Tomcat, an ASP.NET MVC application running on Microsoft IIS, a Ruby on Rails application running on WEBrick, a Node.js application, etc.
- **Client-side web application**: A JavaScript application running in a web browser using Angular, Backbone.JS, jQuery, etc.
- **Client-side desktop application**: A Windows desktop application written using WPF, an OS X desktop application written using Objective-C, a cross-platform desktop application written using JavaFX, etc.
- **Mobile app**: An Apple iOS app, an Android app, a Microsoft Windows Phone app, etc.
- **Server-side console application**: A standalone (e.g. "public static void main") application, a batch process, etc.
- **Serverless function**: A single serverless function (e.g. Amazon Lambda, Azure Function, etc).
- **Database**: A schema or database in a relational database management system, document store, graph database, etc such as MySQL, Microsoft SQL Server, Oracle Database, MongoDB, Riak, Cassandra, Neo4j, etc.
- **Blob or content store**: A blob store (e.g. Amazon S3, Microsoft Azure Blob Storage, etc) or content delivery network (e.g. Akamai, Amazon CloudFront, etc).
- **File system**: A full local file system or a portion of a larger networked file system (e.g. SAN, NAS, etc).
- **Shell script**: A single shell script written in Bash, etc.
- **etc**

  

### Component

The word "component" is a hugely overloaded term in the software development industry, but in this context a component is a grouping of related functionality encapsulated behind a well-defined interface. If you're using a language like Java or C#, the simplest way to think of a component is that it's a collection of implementation classes behind an interface. Aspects such as how those components are packaged (e.g. one component vs many components per JAR file, DLL, shared library, etc) is a separate and orthogonal concern.

An important point to note here is that all components inside a container typically execute in the same process space. **In the C4 model, components are not separately deployable units.**

## 1. System Context diagram 

[![A System Context diagram](https://static.structurizr.com/workspace/76748/diagrams/SystemContext.png)](https://static.structurizr.com/workspace/76748/diagrams/SystemContext.png)

[![Diagram key](https://static.structurizr.com/workspace/76748/diagrams/SystemContext-key.png)](https://static.structurizr.com/workspace/76748/diagrams/SystemContext-key.png)

A System Context diagram is a good starting point for diagramming and documenting a software system, allowing you to step back and see the big picture. Draw a diagram showing your system as a box in the centre, surrounded by its users and the other systems that it interacts with.

Detail isn't important here as this is your zoomed out view showing a big picture of the system landscape. The focus should be on people (actors, roles, personas, etc) and software systems rather than technologies, protocols and other low-level details. It's the sort of diagram that you could show to non-technical people.

**Scope**: A single software system.

**Primary elements**: The software system in scope.  
**Supporting elements**: People (e.g. users, actors, roles, or personas) and software systems (external dependencies) that are directly connected to the software system in scope. Typically these other software systems sit outside the scope or boundary of your own software system, and you don't have responsibility or ownership of them.

**Intended audience**: Everybody, both technical and non-technical people, inside and outside of the software development team.

**Recommended for most teams**: Yes.

## 2. Container diagram https:

[![A Container diagram](https://static.structurizr.com/workspace/76748/diagrams/Containers.png)](https://static.structurizr.com/workspace/76748/diagrams/Containers.png)

[![Diagram key](https://static.structurizr.com/workspace/76748/diagrams/Containers-key.png)](https://static.structurizr.com/workspace/76748/diagrams/Containers-key.png)

Once you understand how your system fits in to the overall IT environment, a really useful next step is to zoom-in to the system boundary with a Container diagram. A "container" is something like a server-side web application, single-page application, desktop application, mobile app, database schema, file system, etc. Essentially, a container is a separately runnable/deployable unit (e.g. a separate process space) that executes code or stores data.

The Container diagram shows the high-level shape of the software architecture and how responsibilities are distributed across it. It also shows the major technology choices and how the containers communicate with one another. It's a simple, high-level technology focussed diagram that is useful for software developers and support/operations staff alike.

**Scope**: A single software system.

**Primary elements**: Containers within the software system in scope.  
**Supporting elements**: People and software systems directly connected to the containers.

**Intended audience**: Technical people inside and outside of the software development team; including software architects, developers and operations/support staff.

**Recommended for most teams**: Yes.

**Notes**: This diagram says nothing about clustering, load balancers, replication, failover, etc because it will likely vary across different environments (e.g. production, staging, development, etc). This information is better captured via one or more [deployment diagrams](https://c4model.com/#DeploymentDiagram).

## 3. Component diagram

[![A Component diagram](https://static.structurizr.com/workspace/76748/diagrams/Components.png)](https://static.structurizr.com/workspace/76748/diagrams/Components.png)

[![Diagram key](https://static.structurizr.com/workspace/76748/diagrams/Components-key.png)](https://static.structurizr.com/workspace/76748/diagrams/Components-key.png)

Next you can zoom in and decompose each container further to identify the major structural building blocks and their interactions.

The Component diagram shows how a container is made up of a number of "components", what each of those components are, their responsibilities and the technology/implementation details.

**Scope**: A single container.

**Primary elements**: Components within the container in scope.  
**Supporting elements**: Containers (within the software system in scope) plus people and software systems directly connected to the components.

**Intended audience**: Software architects and developers.

**Recommended for most teams**: No, only create component diagrams if you feel they add value, and consider automating their creation for long-lived documentation.

## 4. Code diagram

[![A UML class diagram](https://c4model.com/img/class-diagram.png)](https://c4model.com/img/class-diagram.png)

Finally, you can zoom in to each component to show how it is implemented as code; using UML class diagrams, entity relationship diagrams or similar.

This is an optional level of detail and is often available on-demand from tooling such as IDEs. Ideally this diagram would be automatically generated using tooling (e.g. an IDE or UML modelling tool), and you should consider showing only those attributes and methods that allow you to tell the story that you want to tell. This level of detail is not recommended for anything but the most important or complex components.

**Scope**: A single component.

**Primary elements**: Code elements (e.g. classes, interfaces, objects, functions, database tables, etc) within the component in scope.

**Intended audience**: Software architects and developers.

**Recommended for most teams**: No, particularly for long-lived documentation because most IDEs can generate this level of detail on demand.

## System Landscape diagram 


[![A System Landscape diagram](https://static.structurizr.com/workspace/28201/diagrams/SystemLandscape.png)](https://static.structurizr.com/workspace/28201/diagrams/SystemLandscape.png)

[![Diagram key](https://static.structurizr.com/workspace/28201/diagrams/SystemLandscape-key.png)](https://static.structurizr.com/workspace/28201/diagrams/SystemLandscape-key.png)

The C4 model provides a static view of a **single software system** but, in the real-world, software systems never live in isolation. For this reason, and particularly if you are responsible for a collection/portfolio of software systems, it's often useful to understand how all of these software systems fit together within a given enterprise, organisation, department, etc. Essentially this is a map of the software systems within the chosen scope, with a C4 drill-down for each software system of interest.

From a practical perspective, a system landscape diagram is really just a system context diagram without a specific focus on a particular software system.

**Scope**: An enterprise/organisation/department/etc.

**Primary elements**: People and software systems related to the chosen scope.

**Intended audience**: Technical and non-technical people, inside and outside of the software development team.

## Dynamic diagram 

[![A dynamic diagram](https://static.structurizr.com/workspace/76748/diagrams/SignIn.png)](https://static.structurizr.com/workspace/76748/diagrams/SignIn.png)

[![Diagram key](https://static.structurizr.com/workspace/76748/diagrams/SignIn-key.png)](https://static.structurizr.com/workspace/76748/diagrams/SignIn-key.png)

A dynamic diagram can be useful when you want to show how elements in the static model collaborate at runtime to implement a user story, use case, feature, etc. This dynamic diagram is based upon a [UML communication diagram](https://en.wikipedia.org/wiki/Communication_diagram) (previously known as a "UML collaboration diagram"). It is similar to a [UML sequence diagram](https://en.wikipedia.org/wiki/Sequence_diagram) although it allows a free-form arrangement of diagram elements with numbered interactions to indicate ordering.

**Scope**: A particular feature, story, use case, etc.

**Primary and supporting elements**: Your choice - you can show software systems, containers, or components interacting at runtime.

**Intended audience**: Technical and non-technical people, inside and outside of the software development team.

**Notes**: Feel free to use a UML sequence diagram if you prefer that visual style.

## Deployment diagram 
[![A deployment diagram](https://static.structurizr.com/workspace/76748/diagrams/LiveDeployment.png)](https://static.structurizr.com/workspace/76748/diagrams/LiveDeployment.png)

[![Diagram key](https://static.structurizr.com/workspace/76748/diagrams/LiveDeployment-key.png)](https://static.structurizr.com/workspace/76748/diagrams/LiveDeployment-key.png)

[![An example AWS deployment diagram](https://static.structurizr.com/workspace/54915/diagrams/AmazonWebServicesDeployment.png)](https://static.structurizr.com/workspace/54915/diagrams/AmazonWebServicesDeployment.png)

A deployment diagram allows you to illustrate how instances of software systems and/or containers in the static model are deployed on to the infrastructure within a given **deployment environment** (e.g. production, staging, development, etc). It's based upon a [UML deployment diagram](https://en.wikipedia.org/wiki/Deployment_diagram).

A **deployment node** represents where an instance of a software system/container is running; perhaps physical infrastructure (e.g. a physical server or device), virtualised infrastructure (e.g. IaaS, PaaS, a virtual machine), containerised infrastructure (e.g. a Docker container), an execution environment (e.g. a database server, Java EE web/application server, Microsoft IIS), etc. Deployment nodes can be nested.

You may also want to include **infrastructure nodes** such as DNS services, load balancers, firewalls, etc.

Feel free to use icons provided by Amazon Web Services, Azure, etc to complement your deployment diagrams ... just make sure any icons you use are included in your diagram key/legend.

**Scope**: One or more software systems within a single deployment environment (e.g. production, staging, development, etc).

**Primary elements**: Deployment nodes, software system instances, and container instances.  
**Supporting elements**: Infrastructure nodes used in the deployment of the software system.

**Intended audience**: Technical people inside and outside of the software development team; including software architects, developers, infrastructure architects, and operations/support staff.

## Notation

The C4 model is **notation independent**, and doesn't prescribe any particular notation. As a starting point though, a simple notation that works well on whiteboards, paper, sticky notes, index cards and a variety of diagraming tools is as follows.

[![Person](https://c4model.com/img/notation-person.png)](https://c4model.com/img/notation-person.png)

Person

[![Software System](https://c4model.com/img/notation-software-system.png)](https://c4model.com/img/notation-software-system.png)

Software System

[![Container](https://c4model.com/img/notation-container.png)](https://c4model.com/img/notation-container.png)

Container

[![Component](https://c4model.com/img/notation-component.png)](https://c4model.com/img/notation-component.png)

Component

[![Relationship](https://c4model.com/img/notation-relationship.png)](https://c4model.com/img/notation-relationship.png)

Relationship

You can then use colour and shapes to supplement the diagram, either to add additional information or simply to make the diagram more aesthetically pleasing.

### C4 and UML

Although the example diagrams above are created using a "boxes and lines" notation, the core diagrams can be illustrated using UML with the appropriate use of packages, components and stereotypes. The resulting UML diagrams do tend to lack the same degree of descriptive text though, because adding such text isn't possible (or easy) with some UML tools.

Here are three examples of a System Context, Container and Component diagram for comparison.

[![A system context diagram](https://c4model.com/img/spring-petclinic-system-context.png)](https://c4model.com/img/spring-petclinic-system-context.png)

[![A container diagram](https://c4model.com/img/spring-petclinic-containers.png)](https://c4model.com/img/spring-petclinic-containers.png)

[![A component diagram](https://c4model.com/img/spring-petclinic-components.png)](https://c4model.com/img/spring-petclinic-components.png)

System Context diagram

Container diagram

Component diagram

[![A system context diagram](https://c4model.com/img/spring-petclinic-system-context-plantuml.png)](https://c4model.com/img/spring-petclinic-system-context-plantuml.png)

[![A container diagram](https://c4model.com/img/spring-petclinic-containers-plantuml.png)](https://c4model.com/img/spring-petclinic-containers-plantuml.png)

[![A component diagram](https://c4model.com/img/spring-petclinic-components-plantuml.png)](https://c4model.com/img/spring-petclinic-components-plantuml.png)

[![A system context diagram](https://c4model.com/img/spring-petclinic-system-context-staruml.png)](https://c4model.com/img/spring-petclinic-system-context-staruml.png)

[![A container diagram](https://c4model.com/img/spring-petclinic-containers-staruml.png)](https://c4model.com/img/spring-petclinic-containers-staruml.png)

[![A component diagram](https://c4model.com/img/spring-petclinic-components-staruml.png)](https://c4model.com/img/spring-petclinic-components-staruml.png)

### C4 and ArchiMate

See [C4 Model, Architecture Viewpoint and Archi 4.7](https://www.archimatetool.com/blog/2020/04/18/c4-model-architecture-viewpoint-and-archi-4-7/) for details of how to create C4 model diagrams with ArchiMate.

  
  

### Diagram key/legend

Any notation used should be as self-describing as possible, but **all diagrams should have a key/legend** to make the notation explicit. This applies to diagrams created with notations such as UML, ArchiMate and SysML too, as not everybody will know the notation being used.

[![Diagram key](https://static.structurizr.com/workspace/76748/diagrams/Containers-key.png)](https://static.structurizr.com/workspace/76748/diagrams/Containers-key.png)

  
  

### Notation, notation, notation

Although the C4 model is an abstraction-first approach and notation independent, you still need to ensure that your diagram notation makes sense, and that the diagrams are comprehensible. A good way to think about this is to ask yourself whether each diagram can stand alone, and be (mostly) understood without a narrative. You can use this short [software architecture diagram review checklist](https://c4model.com/review) to help. And here are some recommendations related to notation.

#### Diagrams

- Every diagram should have a title describing the diagram type and scope (e.g. "System Context diagram for My Software System").
- Every diagram should have a key/legend explaining the notation being used (e.g. shapes, colours, border styles, line types, arrow heads, etc).
- Acronyms and abbreviations (business/domain or technology) should be understandable by all audiences, or explained in the diagram key/legend.

#### Elements

- The type of every element should be explicitly specified (e.g. Person, Software System, Container or Component).
- Every element should have a short description, to provide an "at a glance" view of key responsibilities.
- Every container and component should have a technology explicitly specified.

#### Relationships

- Every line should represent a unidirectional relationship.
- Every line should be labelled, the label being consistent with the direction and intent of the relationship (e.g. dependency or data flow). Try to be as specific as possible with the label, ideally avoiding single words like, "Uses".
- Relationships between containers (typically these represent inter-process communication) should have a technology/protocol explicitly labelled.

  
  

### Alternative visualisations

Finally, don't feel that you need to always use a traditional "boxes and arrows" diagram. Although this is usually the default approach, there are other, often interactive, visualisations that can be used to show the same C4 model abstractions in very different ways.

[![](https://c4model.com/img/alternative-1.png)](https://structurizr.com/dsl?example=microservices)

Traditional "boxes and arrows" diagrams are the default approach for documentation and presentations.

[![](https://c4model.com/img/alternative-2.png)](https://structurizr.com/dsl?example=microservices&renderer=graph)

A D3.js force-directed graph is a very concise way to visualise larger software architectures, also providing an easy way to explore dependencies.

[![](https://c4model.com/img/alternative-3.png)](https://structurizr.com/dsl?example=microservices&renderer=ilograph)

Ilograph's interactive diagrams provide a way to selectively zoom in and out, allowing you to explore your entire software architecture model.

## Tooling

For design sessions, you might find a whiteboard or flip chart paper better for collaboration, and iterating quickly. For long-lived documentation, there are a number of tools can help create software architecture diagrams based upon the C4 model.

Don't forget to ask yourself some questions when looking at tooling, to understand the features you need. Who are the diagram authors, and how technical are they? A "drag and drop" UI vs "diagrams as code"? Data stored in git next to your source code vs stored in the tool/cloud service? Closed vs open data format? Interactive vs static diagrams? Free vs paid vs open source? Short-lived vs long-lived documentation? Team only diagramming vs enterprise-wide modelling? Who is the diagram audience, and how would they access the diagrams/documentation?

  

 Static diagrams

(e.g. system context, container, and component diagrams)

 Dynamic diagrams

(e.g. collaboration or sequence diagrams)

 Deployment diagrams

(e.g. diagrams showing deployment and infrastructure concerns)

 Open source

(free, fork/customize, etc)

 Diagrams and models as code

(for easy version control and integration into build pipelines/other tools)

 Reuse elements across multiple diagrams

(to keep multiple diagrams in sync automatically when you rename elements)

Recommended

 Rendering tool independent

(to render diagrams with different tools or visualisation formats such as [diagrams, graphs, etc](https://c4model.com/#AlternativeVisualisations))

[Archi](https://www.archimatetool.com/blog/2020/04/18/c4-model-architecture-viewpoint-and-archi-4-7/)

 

[Archinsight](https://github.com/lonely-lockley/archinsight)

 

[Archipeg](https://www.archipeg.com/learn/c4-model-v1-metamodel)

 

[Astah](https://github.com/ChangeVision/astah-c4model-plugin)

 

[C4-PlantUML](https://github.com/plantuml-stdlib/C4-PlantUML)

 

[c4builder](https://adrianvlupu.github.io/C4-Builder)

 

[C4InterFlow](https://github.com/SlavaVedernikov/C4InterFlow)

 

[C4Sharp](https://github.com/8T4/c4sharp)

 

[Carbide](https://carbide.dev/)

 

[CUE4Puml4C4](https://owulveryck.github.io/cue4puml4c4/)

 

[Diagrams](https://diagrams.mingrammer.com/docs/nodes/c4)

 

[diagrams.net](https://www.diagrams.net/blog/c4-modelling)

 

[Excalidraw](https://libraries.excalidraw.com/#dmitry-burnyshev-c4-architecture)

 

[Figma](https://www.figma.com/templates/c4-model-examples/)

 

[Gaphor](https://gaphor.org/)

 

[Gliffy](https://www.gliffy.com/blog/c4-model)

 

[IcePanel](https://icepanel.io/c4-model)

 

[Keadex Mina](https://keadex.dev/en/projects/keadex-mina)

 

[Lucidchart](https://www.lucidchart.com/pages/templates/c-4-model-example)

 

[Microsoft Visio](https://github.com/pihalve/c4model-visio-stencil)

 

[Mermaid](https://mermaid.js.org/syntax/c4.html)

 

[Miro](https://miro.com/miroverse/c4-architecture/)

 

[Model](https://github.com/goadesign/model)

 

[MooD](https://supportportal.moodinternational.com/hc/en-us/articles/360015465100-MooD-and-the-C4-model)

 

[OmniGraffle](https://stenciltown.omnigroup.com/stencils/c4/)

 

[Overarch](https://github.com/soulspace-org/overarch)

 

[pumla](https://github.com/DrMarkusVoss/pumla/blob/main/test/examples/C4example/pumlaC4Example.md)

 

[PyStructurizr](https://github.com/nielsvanspauwen/pystructurizr)

 

[Sparx Enterprise Architect](http://www.sparxsystems.eu/c4/)

 

[RDB modeling](https://rdbmodel.github.io/)

 

[Structurizr](https://structurizr.org/)

 

[Visual Paradigm](https://online.visual-paradigm.com/diagrams/features/c4-model-tool/)

 

[yEd](https://github.com/Ferhat67/C4-yEd)

## Frequently asked questions

#### What's the background behind the C4 model?

The C4 model was created by [Simon Brown](http://simonbrown.je/), who started teaching people about software architecture, while working as a software developer/architect in London. Part of Simon's training course was a design exercise, where groups of people were given some requirements, asked to do some design, and to draw some diagrams to express that design.

Although this was a design focussed exercise, the wide variety of diagrams made it evident that the visualisation of ideas was a skill that most people sorely lacked. The C4 model is essentially a formalisation of how Simon used to visualise software architecture, which has evolved over the years.

#### What's the inspiration behind the C4 model?

The C4 model was inspired by the [Unified Modeling Language](https://en.wikipedia.org/wiki/Unified_Modeling_Language) and the [4+1 model for software architecture](https://en.wikipedia.org/wiki/4%2B1_architectural_view_model). In summary, you can think of the C4 model as a simplified version of the underlying concepts, designed to (1) make it easier for software developers to describe and understand how a software system works and (2) to minimise the gap between the software architecture model/description and the source code.

The roots of the C4 model, and the various diagram types within it, can be traced back to somewhere in the region of 2006, although the "C4" name came much later, around the end of 2011. It was created during a time where teams, influenced by the agile movement, were less than enthusiastic about using UML.

#### Isn't the C4 model a step backwards? Why are you reinventing UML? Why not just use UML?

Whether you see the C4 model as a step forwards or a step backwards depends upon where you are. If you're using UML (or SysML, ArchiMate, etc) and it's working for you, stick with it. Unfortunately, UML usage seems to be in decline, and many teams have reverted to using ad hoc boxes and lines diagrams once again. Given that many of those teams don't want to use UML (for various reasons), the C4 model helps introduce some structure and discipline into the way software architecture is communicated. For many teams, the C4 model is sufficient. And for others, perhaps it's a stepping stone to UML.

#### How many people use the C4 model?

The honest answer is that nobody knows. Simon has personally taught the C4 model to somewhere over 10,000 people in more than 30 countries; with conference talks, videos, books and articles reaching many more than this. Other people are also teaching, speaking and writing about the C4 model too. It's definitely being used though, in organisations ranging from startups to global household names.

#### Why "container"?

Terms like "process", "application", "app", "server", "deployable unit", etc all have associated implications, so the name "container" was chosen as a generic way to describe something in which components live. From one perspective, it's unfortunate that containerisation has become popular, because many software developers now associate the term "container" with Docker. From another perspective though, there is sometimes a nice parity between a container in the C4 model and an infrastructure (e.g. Docker) container.

While many teams successfully use the C4 model as is, feel free to change the terminology if needed.

#### Can we change the terminology?

This terminology (context, containers, components and code) works for many organisations and many types of software. However, sometimes an organisation will have an existing terminology that people are already familiar with. Or perhaps "components" and "classes" don't easily map on to the technology being used (e.g. functional languages often use the terms "module" and "function").

Feel free to modify the terminology that you use to describe software architecture at different levels of abstraction. Just make sure that everybody explicitly understands it.

#### How do you model microservices and serverless?

Broadly speaking, there are two options for diagramming microservices when using the C4 model, although it depends what you mean by "microservice".

**Approach 1: Each "microservice" is owned by a separate team**  
If your software system has a dependency upon a number of microservices that are outside of your control (e.g. they are owned and/or operated by a separate team), model these microservices as external software systems, that you can't see inside of.

**Approach 2: A single team owns multiple "microservices"**

Imagine that you have an API app (e.g. Spring Boot, ASP.NET MVC, etc) that reads/writes to a relational database schema. Regardless of whether you consider the term "microservice" to refer to just the API app, or the combination of the API app and database schema ... if the microservices are a part of a software system that you are building (i.e. you own them), model every deployable thing as a container. In other words, you'd show two containers: the API app, and the database schema. Feel free to draw a box around these two containers to indicate they are related/grouped.

The same is true for serverless functions/lambdas/etc; treat them as software systems or containers based upon ownership.

#### How do you diagram large and complex software systems?

Even with a relatively small software system, it's tempting to try and include the entire story on a single diagram. For example, if you have a web application, it seems logical to create a single component diagram that shows all of the components that make up that web application. Unless your software system really is that small, you're likely to run out of room on the diagram canvas or find it difficult to discover a layout that isn't cluttered by a myriad of overlapping lines. Using a larger diagram canvas can sometimes help, but large diagrams are usually hard to interpret and comprehend because the cognitive load is too high. And if nobody understands the diagram, nobody is going to look at it.

Instead, don't be afraid to split that single complex diagram into a larger number of simpler diagrams, each with a specific focus around a business area, functional area, functional grouping, bounded context, use case, user interaction, feature set, etc. The key is to ensure that each of the separate diagrams tells a different part of the same overall story, at the same level of abstraction. You can also use an [alternative visualisation](https://c4model.com/#AlternativeVisualisations).

#### Will the diagrams become outdated quickly?

Due to the hierarchical nature of the C4 model, each diagram will change at a different rate.

- **System Context diagram**: In most cases, the system context diagram will change very slowly, as this describes the landscape that the software system is operating within.
- **Container diagram**: Unless you're building a software system that makes heavy use of microservices or serverless lambdas/functions/etc, the container diagram will also change relatively slowly.
- **Component diagram**: For any software system under active development, the component diagrams may change frequently as the team adds, removes or restructures the code into cohesive components. Automating the generation of this level of detail with tooling can help.
- **Code diagram**: The level 4 code (e.g. class) diagrams will potentially become outdated very quickly if the codebase is under active development. For this reason, the recommendation is to (1) not create them at all or (2) generate them on-demand using tooling such as your IDE.

#### Why doesn't the C4 model cover business processes, workflows, state machines, domain models, data models, etc?

The focus of the C4 model is the static structures that make up a software system, at different levels of abstraction. If you need to describe other aspects, feel free to supplement the C4 diagrams with UML diagrams, BPML diagrams, ArchiMate diagrams, entity relationship diagrams, etc.

#### The C4 model vs UML, ArchiMate and SysML?

Although existing notations such as UML, ArchiMate and SysML already exist, many software development teams don't seem to use them. Often this is because teams don't know these notations well enough, perceive them to be too complicated, think they are not compatible with agile approaches or don't have the required tooling.

If you are already successfully using one of these notations to communicate software architecture and it's working, stick with it. If not, try the C4 model. And don't be afraid to supplement the C4 diagrams with UML state diagrams, timing diagrams, etc if you need to.

#### Can we combine C4 and arc42?

Yes, many teams do, and the C4 model is compatible with the [arc42 documentation template](http://arc42.org/) as follows.

- Context and Scope => System Context diagram
- Building Block View (level 1) => Container diagram
- Building Block View (level 2) => Component diagram
- Building Block View (level 3) => Code (e.g. class) diagram

#### Does the C4 model imply a design process or team structure?

A common misconception is that a team's design process should follow the levels in the C4 model hierarchy, perhaps with different people on the team being responsible for different levels of diagrams. For example, a business analyst creates the system context diagram, the architect creates the container diagram, while the developers look after the remaining levels of detail.

Although you can certainly use the C4 model in this way, this is not the intended or recommended usage pattern. The C4 model is just a way to describe a software system, from different levels of abstraction, and it implies nothing about the process of delivering software.

#### Using C4 to describe libraries, frameworks and SDKs?

The C4 model is really designed to model a software system, at various levels of abstraction. To document a library, framework or SDK, you might be better off using something like UML. Alternatively, you could use the C4 model to describe a usage example of your framework, library or SDK; perhaps using colour coding to signify which parts of the software system are bespoke vs those provided for you.

#### Web applications; one container or two?

If you're building a server-side web application (e.g. Spring MVC, ASP.NET, Ruby on Rails, Django, etc) that is predominantly generating static HTML content, then that's a single container. If there's a significant quantity of JavaScript being delivered by the server-side web application (e.g. a single-page application built using Angular), then that's two containers. [Here's an example](https://static.structurizr.com/workspace/76748/diagrams/Containers.png).

Although, at deployment time, the server-side web application includes both the server-side and client-side code, treating the client and server as two separate containers makes it explicit that these are two separate process spaces, communicating via an inter-process/remote communication mechanism (e.g. JSON/HTTPS). It also provides a basis for zooming in to each container separately to show the components inside them.

#### Should the lines represent dependencies or data flow?

This is your choice. Sometimes diagrams work better showing dependency relationships (e.g. uses, reads from, etc), and sometimes data flow (e.g. customer update events) works better. Whichever you choose, make sure that the description of the line matches the direction of the arrow.

It's also worth remembering that most relationships can be expressed either way, and the more explicit you can be, the better. For example, describing a relationship as "sends customer update events to" can be more descriptive than simply "customer update events".

#### Is a Java JAR, C# assembly, DLL, module, etc a container?

Typically not. A container is a runtime construct, like an application; whereas Java JAR files, C# assemblies, DLLs, modules, etc are used to organise the code within those applications.

#### Is a Java JAR, C# assembly, DLL, module, package, namespace, folder etc a component?

Perhaps but, again, typically not. The C4 model is about showing the runtime units (containers) and how functionality is partitioned across them (components), rather than organisational units such as Java JAR files, C# assemblies, DLLs, modules, packages, namespaces or folder structures.

Of course, there may be a one-to-one mapping between these constructs and a component; e.g. if you're building a hexagonal architecture, you may create a single Java JAR file or C# assembly per component. On the other hand, a single component might be implemented using code from a number of JAR files, which is typically what happens when you start to consider third-party frameworks/libraries, and how they become embedded in your codebase.

#### Should you include message buses, API gateways, service meshes, etc?

If you have two services, A and B, that communicate by sending a message via a message bus (irrespective of topics, queues, p2p, pub/sub, etc) or another intermediary (e.g. an API gateway or service mesh), you have a couple of options. The first option is to show service A sending a message to the intermediary, and the intermediary subsequently forwarding that message to service B. While accurate, the "hub and spoke" nature of the diagram tends to obscure the notion that there's coupling between the message producer and consumer.

The other approach is to omit the intermediary, and instead use notation (e.g. a textual description, colour coding, line style, etc) to signify that the interaction between service A and B happens via an intermediary. This approach tends to result in diagrams that tell a clearer story.

#### Should data storage services be shown as software systems or containers?

A frequently asked question is whether services like Amazon S3, Amazon RDS, Azure SQL Database, content delivery networks, etc should be shown as software systems or containers. After all, these are external services that most of us don't own or run ourselves.

If you're building a software system that is using Amazon S3 for storing data, it's true that you don't run S3 yourself, but you do have ownership and responsibility for the buckets you are using. Similarly with Amazon RDS, you have (more or less) complete control over any database schemas that you create. For this reason, treat them as containers because they are an integral part of your software architecture, although they are hosted elsewhere.

#### Is the C4 model universally applicable?

The C4 model was designed to help describe, document, and diagram custom-built, bespoke software systems. From this perspective, the C4 model can be used to describe a variety of software architectures (monolithic or distributed), built in a variety of programming languages, deployed on a variety of platforms (on-premises or cloud).

Solutions that are perhaps less suited to the C4 model include embedded systems/firmware, and solutions that rely on heavy customization rather than bespoke development (e.g. SAP and Salesforce). Even with these solutions, you still may find the System Context and Container diagrams useful.




# some clean code prienceples
### 1. **YAGNI (You Aren’t Gonna Need It)**

- **Principle:** Don’t add functionality until it is necessary.
- **Example:**
    
    javascript
    
    Copy code
    
    `// Bad: Adding unnecessary functionality upfront function calculateDiscount(price, discountType) {     if (discountType === 'SEASONAL') {         return price * 0.9;     } else if (discountType === 'BLACK_FRIDAY') {         return price * 0.7;     } else if (discountType === 'FUTURE_EVENT') {         return price * 0.8; // Unnecessary, not required yet     }     return price; }  // Good: Implement only what's needed function calculateDiscount(price, discountType) {     if (discountType === 'SEASONAL') {         return price * 0.9;     } else if (discountType === 'BLACK_FRIDAY') {         return price * 0.7;     }     return price; }`
    
- **Explanation:** The "FUTURE_EVENT" discount was not required, adding it upfront adds complexity that might not be necessary. Following YAGNI, you should avoid implementing it until it's actually needed.

### 2. **Avoid Premature Optimization**

- **Principle:** Focus on writing clear, correct code first, and optimize later only when necessary.
- **Example:**
    
    javascript
    
    Copy code
    
    `// Bad: Prematurely optimized but harder to understand function sumArray(arr) {     let sum = 0;     for (let i = arr.length - 1; i >= 0; i--) {         sum += arr[i];     }     return sum; }  // Good: Simple and readable function sumArray(arr) {     let sum = 0;     for (let i = 0; i < arr.length; i++) {         sum += arr[i];     }     return sum; }`
    
- **Explanation:** The first version is optimized for performance by iterating the array backward, but it's harder to understand. The second version is straightforward and easier to maintain. Optimize only if the performance is a proven bottleneck.

### 3. **Encapsulation**

- **Principle:** Encapsulate code by limiting access to its components.
- **Example:**
    
    javascript
    
    Copy code
    
    `// Bad: Exposing internal state directly class User {     constructor(name, age) {         this.name = name;         this.age = age;     } }  // Good: Encapsulating internal state with private fields class User {     #name;     #age;     constructor(name, age) {         this.#name = name;         this.#age = age;     }      getName() {         return this.#name;     }      getAge() {         return this.#age;     }      setName(name) {         this.#name = name;     }      setAge(age) {         if (age > 0) {             this.#age = age;         }     } }`
    
- **Explanation:** In the "good" example, the internal state of the `User` class is encapsulated using private fields. Access to these fields is controlled through getter and setter methods, protecting the internal state from unwanted modifications.

### 4. **Composition Over Inheritance**

- **Principle:** Prefer composition over inheritance to extend functionalities.
- **Example:**
    
    javascript
    
    Copy code
    
    `// Bad: Using inheritance to add behavior class Animal {     speak() {         console.log('Generic animal sound');     } }  class Dog extends Animal {     speak() {         console.log('Bark');     } }  // Good: Using composition to add behavior class Animal {     constructor(soundBehavior) {         this.soundBehavior = soundBehavior;     }      speak() {         this.soundBehavior.makeSound();     } }  class BarkSound {     makeSound() {         console.log('Bark');     } }  const dog = new Animal(new BarkSound()); dog.speak(); // Outputs: Bark`
    
- **Explanation:** Composition allows greater flexibility by enabling different sound behaviors without modifying the `Animal` class directly. This avoids tight coupling and makes the code more maintainable.

### 5. **Separation of Concerns**

- **Principle:** Separate different concerns into distinct sections or modules.
- **Example:**
    
    javascript
    
    Copy code
    
    `// Bad: Mixing UI logic with business logic function submitOrder(order) {     if (order.isValid()) {         console.log('Order submitted: ', order);         document.querySelector('#orderStatus').innerText = 'Order Submitted';     } }  // Good: Separate business logic from UI logic function submitOrder(order) {     if (order.isValid()) {         console.log('Order submitted: ', order);         return true;     }     return false; }  function updateOrderStatus(isSubmitted) {     const statusElement = document.querySelector('#orderStatus');     statusElement.innerText = isSubmitted ? 'Order Submitted' : 'Order Failed'; }`
    
- **Explanation:** The "good" example separates the business logic (`submitOrder`) from the UI logic (`updateOrderStatus`). This makes the code more modular and easier to test.

### 6. **Minimize Side Effects**

- **Principle:** Functions or methods should avoid modifying the state of other objects or relying on the global state.
- **Example:**
    
    javascript
    
    Copy code
    
    `// Bad: Function with side effects let globalCounter = 0;  function incrementCounter() {     globalCounter++;     return globalCounter; }  // Good: Function without side effects function incrementCounter(counter) {     return counter + 1; }`
    
- **Explanation:** The "good" example avoids modifying a global variable (`globalCounter`), which could lead to unpredictable behavior. Instead, the function is pure, only relying on its input and returning a result.

### 7. **DRY (Don't Repeat Yourself)**

- **Principle:** Avoid duplication of code by abstracting repeated logic.
- **Example:**
    
    javascript
    
    Copy code
    
    `// Bad: Repeating the same logic function calculateCircleArea(radius) {     return Math.PI * radius * radius; }  function calculateSphereVolume(radius) {     return (4 / 3) * Math.PI * radius * radius * radius; }  // Good: Abstracting repeated logic function calculateAreaOfCircle(radius) {     return Math.PI * radius * radius; }  function calculateVolumeOfSphere(radius) {     return (4 / 3) * calculateAreaOfCircle(radius) * radius; }`
    
- **Explanation:** The "good" example avoids repeating the formula for calculating the area of a circle by abstracting it into a separate function. This reduces duplication and makes the code more maintainable.

### 8. **Fail Fast**

- **Principle:** Write code that fails as soon as something goes wrong.
- **Example:**
    
    javascript
    
    Copy code
    
    `// Bad: Delayed failure function divide(a, b) {     if (b === 0) {         console.error('Division by zero');         return null;     }     return a / b; }  // Good: Failing fast function divide(a, b) {     if (b === 0) {         throw new Error('Division by zero');     }     return a / b; }`
    
- **Explanation:** The "good" example fails immediately by throwing an error when trying to divide by zero, making it easier to identify and handle the problem.

### 9. **Favor Immutable Data**

- **Principle:** Prefer using immutable data structures where possible.
- **Example:**
    
    javascript
    
    Copy code
    
    `// Bad: Modifying mutable data const person = { name: 'John', age: 30 }; person.age = 31;  // Good: Using immutable data const person = { name: 'John', age: 30 }; const olderPerson = { ...person, age: 31 };`
    
- **Explanation:** The "good" example avoids modifying the original `person` object by creating a new object with the updated age. This prevents unintended side effects and makes the code easier to reason about.

### 10. **Use Meaningful Names**

- **Principle:** Names of variables, functions, and classes should be descriptive and convey the purpose or intent.
- **Example:**
    
    javascript
    
    Copy code
    
    `// Bad: Using generic names function process(data) {     return data.map((d) => d * 2); }  // Good: Using meaningful names function doubleNumbers(numbers) {     return numbers.map((number) => number * 2); }`
    
- **Explanation:** The "good" example uses meaningful names like `doubleNumbers` and `number`, making the purpose of the function and its variables clear.

### 11. **Write Small Functions**

- **Principle:** Keep functions short and focused on a single task.
- **Example:**
    
    javascript
    
    Copy code
    
    `// Bad: Large, unfocused function function processOrder(order) {     if (!order.isValid()) {         return 'Invalid order';     }      const discount = order.calculateDiscount();     const total = order.getTotal() - discount;     order.updateTotal(total);     return 'Order processed'; }  // Good: Small, focused functions function validateOrder(order) {     return order.isValid(); }  function applyDiscount(order) {     const discount = order.calculateDiscount();     const total = order.getTotal() - discount;     order.updateTotal(total); }  function processOrder(order) {     if (!validateOrder(order)) {         return 'Invalid order';     }      applyDiscount(order);     return 'Order processed'; }`
    
- **Explanation:** The "good" example breaks down a large function into smaller, focused functions. Each function has a single responsibility, making the code easier to understand, test, and maintain.

### 12. **Principle of Least Astonishment**

- **Principle:** The behavior of your code should not surprise other developers.
- **Example:**
    
    javascript
    
    Copy code
    
    ``// Bad: Surprising behavior function getUserInfo(user) {     return user.name + ' is ' + (user.age || 'unknown') + ' years old'; }  // Good: Expected behavior function getUserInfo(user) {     const age = user.age ? user.age : 'unknown';     return `${user.name} is ${age} years old`; }``
    
- **Explanation:** The "good" example ensures that the behavior of the `getUserInfo` function is predictable and consistent, following common expectations for handling undefined values.

### 13. **Use Domain-Specific Language (DSL)**

- **Principle:** Create or use domain-specific language to make code more expressive and easier to understand.
- **Example:**
    
    javascript
    
    Copy code
    
    `// Bad: General-purpose code, hard to understand in context function calculate(value, factor) {     return value * factor; }  // Good: Domain-specific language function applyInterest(principal, interestRate) {     return principal * interestRate; }`
    
- **Explanation:** The "good" example uses domain-specific terms like `applyInterest`, `principal`, and `interestRate`, making the code more readable and understandable within the financial domain.

### 14. **Use Guard Clauses**

- **Principle:** Handle special cases or errors early in a function to avoid deep nesting.
- **Example:**
    
    javascript
    
    Copy code
    
    `// Bad: Deeply nested code function processOrder(order) {     if (order.isValid()) {         if (order.hasItems()) {             if (order.hasPayment()) {                 return 'Order processed';             } else {                 return 'Payment missing';             }         } else {             return 'No items in order';         }     } else {         return 'Invalid order';     } }  // Good: Using guard clauses function processOrder(order) {     if (!order.isValid()) {         return 'Invalid order';     }     if (!order.hasItems()) {         return 'No items in order';     }     if (!order.hasPayment()) {         return 'Payment missing';     }     return 'Order processed'; }`
    
- **Explanation:** The "good" example uses guard clauses to handle errors early, reducing nesting and making the main logic of the function easier to follow.

### 15. **Write Tests First (TDD - Test-Driven Development)**

- **Principle:** Write tests before writing the code to ensure that the code is testable and meets the requirements.
- **Example:**
    
    javascript
    
    Copy code
    
    `// TDD approach // 1. Write the test test('should calculate the area of a circle', () => {     const radius = 5;     const area = calculateArea(radius);     expect(area).toBeCloseTo(78.54, 2); });  // 2. Write the minimal code to pass the test function calculateArea(radius) {     return Math.PI * radius * radius; }`
    
- **Explanation:** TDD encourages writing only the necessary code to pass the tests, leading to simpler, more focused code. It also ensures that the code meets the required functionality from the start.

### 16. **Favor Dependency Injection**

- **Principle:** Pass dependencies into a class or function rather than hard-coding them inside.
- **Example:**
    
    javascript
    
    Copy code
    
    ``// Bad: Hard-coding dependencies class UserService {     constructor() {         this.apiClient = new ApiClient();     }      getUser(userId) {         return this.apiClient.fetch(`/users/${userId}`);     } }  // Good: Using dependency injection class UserService {     constructor(apiClient) {         this.apiClient = apiClient;     }      getUser(userId) {         return this.apiClient.fetch(`/users/${userId}`);     } }``
    
- **Explanation:** The "good" example uses dependency injection to pass the `ApiClient` as a dependency, making the `UserService` class more flexible and easier to test.

### 17. **Use Interfaces and Abstract Classes Wisely**

- **Principle:** Define clear interfaces or abstract classes to outline the contract for implementing classes.
- **Example:**
    
    typescript
    
    Copy code
    
    `// TypeScript Example // Defining an interface interface Shape {     area(): number; }  // Implementing the interface class Circle implements Shape {     radius: number;      constructor(radius: number) {         this.radius = radius;     }      area(): number {         return Math.PI * this.radius * this.radius;     } }  class Square implements Shape {     side: number;      constructor(side: number) {         this.side = side;     }      area(): number {         return this.side * this.side;     } }`
    
- **Explanation:** The "good" example defines a clear interface (`Shape`) that outlines the contract for implementing classes (`Circle`, `Square`). This promotes loose coupling and ensures that all shapes have a consistent structure.

### 18. **Document As You Code**

- **Principle:** Maintain up-to-date documentation or comments that explain the reasoning behind complex logic.
- **Example:**
    
    javascript
    
    Copy code
    
    `// Bad: No documentation or comments function calculateTax(income) {     return income > 50000 ? income * 0.3 : income * 0.2; }  // Good: Using comments to explain complex logic /**  * Calculate the tax based on income.  * - If income is greater than 50,000, apply a 30% tax.  * - Otherwise, apply a 20% tax.  * @param {number} income - The income amount.  * @return {number} The calculated tax.  */ function calculateTax(income) {     return income > 50000 ? income * 0.3 : income * 0.2; }`
    
- **Explanation:** The "good" example includes comments that explain the logic behind the tax calculation, making it easier for other developers to understand the reasoning behind the code.

### 19. **Favor Asynchronous Programming**

- **Principle:** Use asynchronous programming to handle operations that might take time without blocking the main thread.
- **Example:**
    
    javascript
    
    Copy code
    
    `// Bad: Blocking code function fetchData() {     const response = fetch('/data'); // This blocks the main thread     return response.json(); }  // Good: Asynchronous code async function fetchData() {     const response = await fetch('/data'); // Non-blocking     return await response.json(); }`
    
- **Explanation:** The "good" example uses async/await to handle asynchronous operations, ensuring that the main thread is not blocked while waiting for the data to be fetched.

### 20. **Consistency**

- **Principle:** Be consistent in coding style, naming conventions, and architectural decisions across the codebase.
- **Example:**
    
    javascript
    
    Copy code
    
    `// Bad: Inconsistent naming conventions function getUserInfo() {} function fetch_user_data() {} function RetrieveUser() {}  // Good: Consistent naming conventions function getUserInfo() {} function getUserData() {} function retrieveUser() {}`
    
- **Explanation:** The "good" example maintains consistency in naming conventions (`getUserInfo`, `getUserData`, `retrieveUser`), making the code easier to read and follow.