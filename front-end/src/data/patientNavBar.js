export const patientNavBar = {
    navMain: [
        {
            title: "Acesso Rapído",
            url: "#",
            items: [
                {
                    title: "Marcar Consulta",
                    url: "/patient/home/make-appointment",
                    isActive: false,
                },
                {
                    title: "Historico Médico",
                    url: "/patient/home/history",
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
                    url: "/patient/home",
                    isActive: true,
                },
                {
                    title: "Médicos",
                    url: "/patient/home/all-doctors",
                   
                },
                {
                    title: "Postos",
                    url: "/patient/home/health-posts",
                    
                    
                },
                {
                    title: "Marcar Consulta",
                    url: "/patient/home/make-appointment",
                    
                },
                {
                    title: "Calendário",
                    url: "/patient/home/calendar-patient",
                },
                {
                    title: "Historico Médico",
                    url: "/patient/home/history",
                    
                },
                {
                    title: "Perfil",
                    url: "/patient/home/perfil",
                },
                {
                    title: "Sair",
                    url: "#",
                },
            ],
        },
    ],
};
