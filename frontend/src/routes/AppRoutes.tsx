import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "../pages/Login";
import Register from "../pages/Register";
// we import compoenet which we link with routes and that gets loaded 
// this is the defauklt function that gets called when the component is called 
export default function AppRoutes() { 
    return (
        <BrowserRouter>
            <Routes> 
                {/* login route  */}
                <Route path = "/" element = {<Login />}/>
                <Route path = "/register" element = {<Register />} />
            </Routes>
        
        </BrowserRouter>
    )
}