import DashboardPage from "@/app/dashboard/page";
import HomePageDoctor from "@/pages/doctor";
import HomePagePatient from "@/pages/patient";
import HomePaceRecepptionist from "@/pages/recepptionist";
import { createBrowserRouter } from "react-router-dom";
import AuthRoute from "./authRouter";
import { AuthProvider } from "@/context/authProvider";
import LoginPage from "@/pages/LoginPagae";

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
