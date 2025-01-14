export const doctorNavBar = {
  navMain: [
      {
          title: "Acesso Rapído",
          url: "#",
          items: [
              {
                  title: "Pacientes",
                  url: "/doctor/home/all-patient",
                  isActive: false,
              },
              {
                  title: "Historico Pacientes",
                  url: "/doctor/home/history-patient",
                  isActive: false,
              },
          ],
      },
      {
          title: "Menu",
          url: "#",
          items: [
              {
                  title: "Dashboard",
                  url: "/doctor/home",
                  isActive: true,
              },
              
              {
                  title: "Calendário",
                  url: "/doctor/home/calendar",
              },
              {
                  title: "Perfil",
                  url: "/doctor/home/perfil",
              },
              {
                  title: "Sair",
                  url: "#",
              },
          ],
      },
  ],
};
