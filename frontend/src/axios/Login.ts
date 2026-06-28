import axios from "axios";

// here we are going to set some basic things needed in each API call from frontend 
// Axios is a JavaScript HTTP client used in React (frontend) to communicate with your backend (Spring Boot APIs).
// automatic json hanlding , cleaner than fetch and json.stringify things , better error handling 
// can set base url and headers and then use this 
const api = axios.create({
        baseURL: "http://localhost:8080/api",
        headers: {
            "Content-Type": "application/json"
        }
    });    
export default api;
