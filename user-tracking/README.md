**User Activity Tracking System Documentation**
_(Spring Boot + Kafka Implementation)_

----------

## **1. System Overview**

This project implements a  **real-time user activity tracking system**  using:

-   **Spring Boot**  (Backend service)
    
-   **Apache Kafka**  (Event streaming platform)
    

### **Key Features**

-   Captures user interactions (page views, clicks) as structured events.
    
-   Processes events asynchronously for scalability.
    
-   Decouples event producers from consumers.

## **2. Architecture**

### **Data Flow**

1.  **Event Generation**: User actions are captured as JSON payloads.
    
2.  **Producing**: The Spring Boot app sends events to a Kafka topic.
    
3.  **Consuming**: A separate service reads and processes these events.

## **3. Setup Instructions**

### **Kafka Setup**

1.  **Download & Install**  Kafka from the official website.
    
2.  **Start Services**:
    
    -   ZooKeeper (if required)
        
    -   Kafka broker
        
3.  **Create Topic**:

    kafka-topics --create --topic user-activity --bootstrap-server localhost:9092

### **Spring Boot Application**

1.  **Configuration**:
    
    -   Kafka server connection details.
        
    -   Serialization settings for message formats.
        
2.  **Dependencies**:
    
    -   Spring Kafka (for producer/consumer logic).
        
    -   Lombok (optional, for cleaner code).

## **4. Core Components**

### **1. Event Model**

-   **Fields**: User ID, page URL, action type, timestamp.
    
-   **Format**: JSON.
    

### **2. Producer Service**

-   Accepts HTTP POST requests with event data.
    
-   Validates and forwards events to Kafka.
    

### **3. Consumer Service**

-   Listens to the Kafka topic.
    
-   Logs events (or stores them in a database).

## **5. API Reference**

### **Endpoint**

 -   **Path**:  `/api/activity`
    
 -   **Method**:  `POST`
    
 -   **Request Body**:

    {
          "userId": "string",
          "pageUrl": "string",
          "action": "string"
    }

## **6. Conclusion**

This system provides a  **scalable foundation**  for tracking user activity. Future enhancements could include  **analytics pipelines**  or  **anomaly detection**.

