# 📝 Notes App (Spring Boot + MongoDB + JWT)

A simple, clean, and secure Notes Web Application built with **Spring Boot**, **MongoDB**, **JWT Authentication**, and a **modern UI**.  
Users can register, log in, create notes, view notes, and delete notes securely.

---
🔗 [https://notes-app-iw8p.onrender.com]


## 🚀 Features

### 🔐 Authentication
- Register
- Login
- Reset Password
- JWT Token-based Authentication
- Secure API endpoints
- Logout & Session handling

### 📝 Notes
- Create Note
- View Notes
- Delete Note
- Each user sees **only their own notes**

### 🎨 Modern UI
- Clean, modern card-based UI
- Smooth animations and shadows
- Improved forms and buttons
- Responsive layout
- Modern login / register / notes pages

---

## 🛠 Tech Stack

### Backend
- **Spring Boot**
- **Spring Security**
- **JWT Authentication**
- **MongoDB / MongoDB Atlas**
- **Maven**

### Frontend
- Plain HTML
- CSS (modernized)
- JavaScript (fetch API)

### Deployment
- **Render Web Service**
- GitHub for CI/CD integration

---

## 📁 Project Structure
notes-app/
├── src/main/java/com/example/Learner/
│ ├── controller/
│ ├── filter/
│ ├── model/
│ ├── repository/
│ ├── service/
│ └── config/
├── src/main/resources/
│ ├── templates/ (HTML UI)
│ ├── static/style.css
│ └── application.properties
└── pom.xml

## ⚙️ Setup (Local)

### 1️⃣ Clone Repo


git clone https://github.com/ManNotAwesome/notes-app.git
cd notes-app
2️⃣ Set MongoDB (Choose one)
Local MongoDB

spring.data.mongodb.uri=mongodb://localhost:27017/notesdb
MongoDB Atlas

spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster.mongodb.net/notesdb
3️⃣ Run the App

mvn spring-boot:run
Your app runs at:


http://localhost:8080
