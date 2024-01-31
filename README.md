# guidernas-guide

This is my exam project done in January 2024.

It consists of a Next.js frontend and an Springboot backend
integrated with a MySql database.



## Getting started

This project requires Docker to containerize and run both 
backend and frontend in composition with `docker-compose`

To install docker globally on your computer

```
npm i -g docker
```

Then clone the repo with `git clone` to your computer 

---

### Running the application

In the root folder run: 

```
DB_PASSWORD=root docker-compose up --build
``` 

Then access the application on http://localhost:3000
