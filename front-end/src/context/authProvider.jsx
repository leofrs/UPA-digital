import { useState } from "react";
import { AuthContext } from "./authContext";

export const AuthProvider = ({ children }) => {
    const [user, setUser] = useState({ role: "patient" });

    const login = (userData) => setUser(userData);
    const logout = () => setUser(null);

    return <AuthContext.Provider value={{ user, login, logout }}>{children}</AuthContext.Provider>;
};
