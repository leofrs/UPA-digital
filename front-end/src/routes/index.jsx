import { createBrowserRouter } from "react-router-dom";
import AuthRoute from "./authRouter"; // Wrapper de autenticação
import { AuthProvider } from "@/context/authProvider"; // Contexto de autenticação
import LoginPage from "@/pages/LoginPage"; // Página de login
import DashboardPage from "@/app/dashboard/page"; // Página de dashboard
import HomePageDoctor from "@/pages/doctor"; // Página para médicos
import HomePagePatient from "@/pages/patient"; // Página para pacientes
import HomePaceRecepptionist from "@/pages/recepptionist"; // Página para recepcionistas
import MakeAnAppointment from "@/pages/patient/makeAnAppointment";
import AllDoctors from "@/pages/patient/allDoctors";
import HealthPosts from "@/pages/patient/healthPosts";
import Calendar from "@/pages/patient/Calendar";
import Perfil from "@/pages/patient/Perfil";

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
                path: "patient/home",
                element: (
                    <AuthRoute requiredRole="patient">
                        <HomePagePatient />
                    </AuthRoute>
                ),
                children: [
                    {
                        path: "all-doctors",
                        element: <AllDoctors />,
                    },
                    {
                        path: "health-posts",
                        element: <HealthPosts />,
                    },
                    {
                        path: "make-appointment",
                        element: <MakeAnAppointment />,
                    },
                    {
                        path: "calendar",
                        element: <Calendar />,
                    },
                    {
                        path: "perfil",
                        element: <Perfil />,
                    },
                ],
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
