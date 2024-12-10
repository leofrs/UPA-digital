import React, { useState } from "react";
import { useForm } from "react-hook-form";
import { z } from "zod";
import { zodResolver } from "@hookform/resolvers/zod";
import { Navigate, useNavigate } from "react-router-dom";
import axios from "axios";

function LoginDoctor(){
    const URL_API = 'http://localhost:3500/api/auth';
    const [activeLogin, setActiveLogin] = useState("usuario");
    const [redirectToDashboard, setRedirectToDashboard] = useState(false);

    const toggleLoginType = (type) => {
        setActiveLogin(type);
    };

    // Crie o schema de validação APÓS definir activeLogin
    const loginSchema = z.object({
        cpf: z
            .string()
            .length(15, "O cartão do SUS deve conter exatamente 15 números")
            .regex(/^\d+$/, "O cartão do SUS deve conter apenas números"),
        password: z.string().min(6, "A senha deve conter pelo menos 6 caracteres"),
        crm: 
             z.string().min(1, "CRM é obrigatório para médicos")
             
      
    });

    const {
        register,
        handleSubmit,
        formState: { errors },
    } = useForm({
        resolver: zodResolver(loginSchema),
        defaultValues: {
            cpf: "",
            password: "",
            crm: ""
            
        }
    });
    const navigate = useNavigate()

    const onSubmit =  (data) => {
       if( data.cpf==="123456789012345"&& data.crm=== "123" && data.password=== "123456"){
        navigate("doctor/home")
        
       }

       console.log(data)
       
       
       
    } 
    return(
        <div className="flex justify-center items-center bg-gray-100">
            <div className="w-full max-w-md bg-white rounded-lg shadow-lg p-8">
                <h1 className="text-2xl font-bold text-center text-blue-700 mb-6">Login SUS</h1>

                

                <form
                    onSubmit={handleSubmit(onSubmit)}
                    className="w-full max-w-md p-8 bg-white rounded-2xl shadow-2xl border border-gray-100"
                >
                    <div className="space-y-6">
                        <div>
                            <label htmlFor="cpf" className="block text-sm font-medium text-gray-600 mb-2">
                               CPF
                            </label>
                            <input
                                id="cpf"
                                type="text"
                                {...register("cpf")}
                                className={`w-full px-4 py-3 bg-gray-50 border-2 rounded-xl 
                                ${errors.cpf
                                    ? "border-red-400"
                                    : "border-gray-200"
                                }`}
                                placeholder="Digite seu número do cartão"
                            />
                            {errors.cpf && (
                                <div className="text-red-500 text-sm mt-2">
                                    {errors.cpf.message}
                                </div>
                            )}
                        </div>

                        <div>
                            <label htmlFor="password" className="block text-sm font-medium text-gray-600 mb-2">
                                Senha
                            </label>
                            <input
                                id="password"
                                type="password"
                                {...register("password")}
                                className={`w-full px-4 py-3 bg-gray-50 border-2 rounded-xl 
                                ${errors.password
                                    ? "border-red-400"
                                    : "border-gray-200"
                                }`}
                                placeholder="Digite sua senha"
                            />
                            {errors.password && (
                                <div className="text-red-500 text-sm mt-2">
                                    {errors.password.message}
                                </div>
                            )}
                        </div>

                        
                            <div>
                                <label htmlFor="crm" className="block text-sm font-medium text-gray-600 mb-2">
                                    CRM
                                </label>
                                <input
                                    type="text"
                                    id="crm"
                                    {...register("crm")}
                                    className={`w-full px-4 py-3 bg-gray-50 border-2 rounded-xl 
                                    ${errors.crm
                                        ? "border-red-400"
                                        : "border-gray-200"
                                    }`}
                                    placeholder="Digite seu CRM"
                                />
                                {errors.crm && (
                                    <div className="text-red-500 text-sm mt-2">
                                        {errors.crm.message}
                                    </div>
                                )}
                            </div>
                       

                        

                        <button
                            type="submit"
                            className="w-full py-3 px-4 bg-blue-600 text-white font-bold rounded-xl 
                            hover:bg-green-700 transition-all duration-300"
                        >
                            Entrar
                        </button>
                    </div>
                </form>
            </div>
        </div>
    )
}

export default LoginDoctor;