import React, { useState } from "react";
import { useForm } from "react-hook-form";
import { z } from "zod";
import { zodResolver } from "@hookform/resolvers/zod";
import { Navigate, useNavigate } from "react-router-dom";
import axios from "axios";
import LoginPatient from "@/components/auth/Login-Patient";
import LoginDoctor from "@/components/auth/Login-Doctor";
import LoginRecepptionist from "@/components/auth/Login-Recepptionist";


function LoginPage() {
    const infos = [{id:1, nome:"patient"},{id:2, nome:"doctor"}, {id:3, nome:"recepptionist"}]
    const[open, setOpen] = useState("patient")
    const URL_API = 'http://localhost:3500/api/auth';
    const [activeLogin, setActiveLogin] = useState("patient");
    const [redirectToDashboard, setRedirectToDashboard] = useState(false);

    const toggleLoginType = (type) => {
        activeLogin == type;
        setActiveLogin(type);
    };

    // Crie o schema de validação APÓS definir activeLogin
    const loginSchema = z.object({
        cartaoSus: z
            .string()
            .length(15, "O cartão do SUS deve conter exatamente 15 números")
            .regex(/^\d+$/, "O cartão do SUS deve conter apenas números"),
        password: z.string().min(6, "A senha deve conter pelo menos 6 caracteres"),
        crm: activeLogin === "médico"
            ? z.string().min(1, "CRM é obrigatório para médicos")
            : z.string().optional(),
        coren: activeLogin === "enfermeiro"
            ? z.string().min(1, "COREN é obrigatório para enfermeiros")
            : z.string().optional()
    });

    const {
        register,
        handleSubmit,
        formState: { errors },
    } = useForm({
        resolver: zodResolver(loginSchema),
        defaultValues: {
            cartaoSus: "",
            password: "",
            crm: activeLogin === "médico" ? "" : undefined,
            coren: activeLogin === "enfermeiro" ? "" : undefined
        }
    });
    

   
      
    

    return (
        <div className="flex flex-col justify-center items-center h-screen bg-gray-100">
           
                

                 <div className="flex justify-center mb-2">
                    {infos.map((type) => (
                        <button onClick={() => (setOpen(type.nome))}
                            key={type.id}
                        
                            className={`${
                                activeLogin === type
                                    ? 'bg-blue-500 text-white'
                                    : 'bg-blue-300 text-white'
                            } px-4 py-2 rounded-md mr-2 mb-2 transition-colors hover:opacity-90`}
                        >
                            {type.nome}
                            
                        </button>
                    ))}
                </div> 
                
                
                {open == "patient" ? <LoginPatient/> : open =="doctor" ? <LoginDoctor/> : open == "recepptionist" ? <LoginRecepptionist/> : <LoginPatient/>}

                
                
        </div>
    );
}

export default LoginPage;
