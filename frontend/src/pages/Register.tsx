import { useState } from "react";
import {register} from "../services/AuthServices";

export default function Register() { 
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [emailAddress, setEmailAddress] = useState("");
    const [password, setPassword] = useState("");

    const handleClearFields = () => { 
        console.log(" clear all fields cause of validation fail");
        setFirstName("");
        setLastName("");
        setEmailAddress("");
        setPassword("");
    }
    const handleRegister = async() => {
        // check if first name , last name , email and password field is filled or not 
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        // 1. Check empty fields
        if (!firstName.trim()) {
            alert("First name is required");
            handleClearFields();
            return;
        }

        if (!lastName.trim()) {
            alert("Last name is required");
            handleClearFields();
            return;
        }

        if (!emailAddress.trim()) {
            alert("Email is required");
            handleClearFields();
            return;
        }

        if (!password.trim()) {
            alert("Password is required");
            handleClearFields();
            return;
        }

        // 2. Email format validation
        if (!emailRegex.test(emailAddress)) {
            alert("Invalid email format");
            handleClearFields();
            return;
        }

        // 3. Password strength check (basic)
        if (password.length < 6) {
            alert("Password must be at least 6 characters");
            return;
        }
        try { 
            // call register api and handle new user registeration 
            const res = await register({firstName, lastName, emailAddress, password});
            // hanlde response 
            if (res.status = 200) { 
                // handle jwt token validation ad 
            }
        }
        catch (err) { 
            alert("error hanlding register request")
        }
    }

    return (
        <div style={{ maxWidth: 400, margin: "100px auto" }}>
            <input 
            placeholder = "First Name"
            value = {firstName}
            onChange = {(e) => setFirstName(e.target.value)}>
            </input>

            <input 
            placeholder = "Last Name"
            value = {lastName}
            onChange = {(e) => setLastName(e.target.value)}>
            </input>

            <input 
            placeholder = "jonCarter@gmail.com"
            value = {emailAddress}
            onChange = {(e) => setEmailAddress(e.target.value)}>
            </input>

            <input
            placeholder = "*******"
            value = {password}
            onChange = {(e) => setPassword(e.target.value)}>
            </input>
            <button 
            type = "submit"
            onClick = {handleRegister}>
                Submit
            </button>
        </div> 
    );
}