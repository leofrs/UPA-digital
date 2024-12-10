import { createBrowserRouter } from "react-router-dom";
import AuthRoute from "./authRouter"; // Wrapper de autenticação
import { AuthProvider } from "@/context/authProvider"; // Contexto de autenticação
import LoginPage from "@/pages/LoginPage"; // Página de login
import DashboardPage from "@/app/dashboard/page"; // Página de dashboard
import HomePageDoctor from "@/pages/doctor"; // Página para médicos
import HomePagePatient from "@/pages/patient"; // Página para pacientes
import HomePaceRecepptionist from "@/pages/recepptionist"; // Página para recepcionistas

export const router = createBrowserRouter([
    {
        path: "/",
        element: <LoginPage />,
    },
    {
        element: (
            <AuthProvider>
                <DashboardPage />
            </AuthProvider>
        ),
        children: [
            {
                path: "/patient/home",
                element: (
                    <AuthRoute requiredRole="patient">
                        <HomePagePatient />
                    </AuthRoute>
                ),
            },
            {
                path: "/doctor/home",
                element: (
                    <AuthRoute requiredRole="doctor">
                        <HomePageDoctor />
                    </AuthRoute>
                ),
            },
            {
                path: "/recepptionist/home",
                element: (
                    <AuthRoute requiredRole="recepptionist">
                        <HomePaceRecepptionist />
                    </AuthRoute>
                ),
            },
        ],
    },
]);