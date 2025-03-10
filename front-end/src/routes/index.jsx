import { createBrowserRouter } from "react-router-dom";
import LoginPage from "@/pages/LoginPage"; // Página de login
import DashboardPage from "@/app/dashboard/page"; // Página de dashboard
import HomePageDoctor from "@/pages/doctor"; // Página para médicos
import HomePagePatient from "@/pages/patient"; // Página para pacientes
import HomePaceRecepptionist from "@/pages/recepptionist"; // Página para recepcionistas
import MakeAnAppointment from "@/pages/patient/makeAnAppointment";
import AllDoctors from "@/pages/patient/allDoctors";
import HealthPosts from "@/pages/patient/healthPosts";
import CalendarDoctor from "@/pages/doctor/CalendarDoctor";
import CalendarPatient from "@/pages/patient/CalendarPatient";
import Perfil from "@/pages/patient/Perfil";
import AllPatient from "@/pages/doctor/AllPatient";
import HistoryPatient from "@/pages/doctor/HistoryDoctor";
import History from "@/pages/patient/History";

import { AuthProvider } from "@/context/authProvider";
import ProtectedRoute from "./protectedRoute";

export const router = createBrowserRouter([
  {
    path: "/",
    element: (
      <AuthProvider>
        <LoginPage />
      </AuthProvider>
    ),
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
          <ProtectedRoute allowedRoles={["ADMIN"]}>
            <HomePagePatient />
          </ProtectedRoute>
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
            path: "calendar-patient",
            element: <CalendarPatient />,
          },
          {
            path: "perfil",
            element: <Perfil />,
          },
          {
            path: "history",
            element: <History />,
          },
        ],
      },
      {
        path: "doctor/home",
        element: <HomePageDoctor />,
        children: [
          {
            path: "all-patient",
            element: <AllPatient />,
          },
          {
            path: "history-patient",
            element: <HistoryPatient />,
          },

          {
            path: "calendar-doctor",
            element: <CalendarDoctor />,
          },
          {
            path: "perfil",
            element: <Perfil />,
          },
        ],
      },
      {
        path: "recepptionist/home",
        element: <HomePaceRecepptionist />,
        children: [
          {
            path: "make-appointment",
            element: <MakeAnAppointment />,
          },

          {
            path: "perfil",
            element: <Perfil />,
          },
        ],
      },
    ],
  },
]);
