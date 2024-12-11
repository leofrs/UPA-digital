import { useContext, createContext } from "react";

export const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);
