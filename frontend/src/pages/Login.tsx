// import useState hook to set the values of email and password 
import { useState } from "react";
import { login } from "../services/AuthServices"; 

export default function Login() { 
    // we are going to have two fields email and password for signup 
    const [email,setEmail] = useState("") // by default fix  email is the variable 
    const [password,setPassword] = useState(""); // field setup 

    const handleClearFields = async() => {
        console.log("not working ");
        setEmail("");
        setPassword("");
    };

    const handleLogin = async() => { 
        try { 
            // check if either of the fields is not filled raise message 
            if (!email.trim()) { 
                // clear the email iid and password fields 
                alert("Email is Required");
                handleClearFields();
                return;
            }

            if (!password.trim()) {
                // clear the email id and password fields 
                alert("Password is Required");
                handleClearFields();
                return;
            }
            // validate email field 

            // call the api 
            // this is not working cause the backend is not running ad need to implement full service 
            const res = await login({email, password});
            console.log("");
            if (res.status === 200) { 
                // ok status 
                alert("login success");
            }else { 
                if (res.status === 404) { 
                    // user not found 
                    alert("user not found");
                }
            }
        }
        catch (err) { 
            alert("invalid credentials");
        }
    };
    return (
        <div style={{ maxWidth: 400, margin: "100px auto" }}>
        <h2>Login</h2>

        <input
        placeholder = "Email"
        value = {email}
        // e stands for event object containing multiple things , target is htmlElement - e.target === <input />
        onChange = {(e) => setEmail(e.target.value)}> 
        </input>
        <input
        placeholder = "Password"
        value = {password}
        onChange = {(e) => setPassword(e.target.value)}> 
        </input>
        {/*  npow we have the login button after clicking on which we takes action  */}
        <button onClick={handleLogin}> 
            Login    
        </button>
    </div>
    );
}