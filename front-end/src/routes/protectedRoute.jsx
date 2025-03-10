import { useAuth } from "@/context/authContext";
import { useEffect } from "react";
import { Navigate } from "react-router-dom";

const ProtectedRoute = ({ children, allowedRoles }) => {
  const { user } = useAuth();

  useEffect(() => {
    if (!user) {
      <Navigate to="/" />;
    }
  }, [allowedRoles, user]);

  return children;
};

export default ProtectedRoute;
