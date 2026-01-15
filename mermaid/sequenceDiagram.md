
#### **Sequence Diagram**
```mermaid
sequenceDiagram
    rect rgb(200, 200, 255)
    participant A as User
    end
    rect rgb(200, 255, 200)
    participant B as Server
    end
    A->>B: Request Data
    B->>A: Respond with Data
