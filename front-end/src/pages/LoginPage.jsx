import React, { useState } from "react";
import { AppSidebar } from "@/components/app-sidebar";
import LoginPatient from "@/components/auth/Login-Patient";
import LoginDoctor from "@/components/auth/Login-Doctor";
import LoginRecepptionist from "@/components/auth/Login-Recepptionist";

function LoginPage() {
    const infos = [{ id: 1, nome: "patient" }, { id: 2, nome: "doctor" }, { id: 3, nome: "recepptionist" }];
    const [open, setOpen] = useState("patient");

    return (
        <div className="flex flex-col justify-center items-center h-screen bg-gray-100">
            {/* Renderiza os botões de login para os tipos de usuário */}
            <div className="flex justify-center mb-2">
                {infos.map((type) => (
                    <button
                        onClick={() => setOpen(type.nome)} // Altera o tipo de usuário selecionado
                        key={type.id}
                        className={`${
                            open === type.nome ? 'bg-blue-500 text-white' : 'bg-blue-300 text-white'
                        } px-4 py-2 rounded-md mr-2 mb-2 transition-colors hover:opacity-90`}
                    >
                        {type.nome}
                    </button>
                ))}
            </div>

            {/* Exibe o formulário de login correspondente ao tipo de usuário selecionado */}
            {open === "patient" ? <LoginPatient /> : open === "doctor" ? <LoginDoctor /> : <LoginRecepptionist />}
            
            
           
        </div>
    );
}

export default LoginPage;
