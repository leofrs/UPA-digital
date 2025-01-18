import { Navigate } from "react-router-dom";
import { useAuth } from "@/context/authContext";

// eslint-disable-next-line react/prop-types
const AuthRoute = ({ children, requiredRole }) => {
  const { user } = useAuth();

  if (!user) {
    return <Navigate to="/" replace />;
   
    
  }

  if (requiredRole && user.role !== requiredRole) {
    return <Navigate to="/" replace />;
    
  }

  return children

  
};

export default AuthRoute;
