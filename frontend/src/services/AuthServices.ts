import api from "../axios/Login";
import type { LoginRequest } from "../types/LoginRequest";
import type { RegisterRequest } from "../types/RegisterRequest";

export const login = (data: LoginRequest) => {
    return api.post("/auth/login", data);
};

export const register = (data: RegisterRequest) => {
    return api.post("/auth/register", data);
};