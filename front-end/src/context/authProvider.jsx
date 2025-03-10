import { useState, useEffect } from "react";
import { AuthContext } from "./authContext";
import { jwtDecode } from "jwt-decode";
import { useNavigate } from "react-router-dom";

// eslint-disable-next-line react/prop-types
export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(() => {
    const token = localStorage.getItem("token");
    if (token) {
      try {
        const decoded = jwtDecode(token);
        return { token, role: decoded.role };
      } catch (erro) {
        console.log("Erro ao decodificar o token: ", erro);
        return null;
      }
    }
    return null;
  });

  const navigate = useNavigate();

  useEffect(() => {
    if (!user) {
      navigate("/", { replace: true });
    }
  }, [user, navigate]);

  const login = (token) => {
    localStorage.setItem("token", token);
    const decoded = jwtDecode(token);
    setUser({ token, role: decoded.role });
    if (decoded.role === "ADMIN") {
      navigate("/patient/home", { replace: true });
    } else {
      navigate("/");
    }
  };

  const logout = () => {
    localStorage.removeItem("token");
    setUser(null);
    navigate("/");
  };

  return (
    <AuthContext.Provider value={{ user, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
};
