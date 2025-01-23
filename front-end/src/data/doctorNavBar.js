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
                title: "Calendário",
                url: "/doctor/home/calendar-doctor",
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
                  url: "/doctor/home/calendar-doctor",
              },
              {
                title: "Pacientes",
                url: "/doctor/home/all-patient",
                isActive: false,
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
