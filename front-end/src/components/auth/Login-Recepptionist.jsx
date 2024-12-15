import React, { useState } from "react";
import { useForm } from "react-hook-form";
import { z } from "zod";
import { zodResolver } from "@hookform/resolvers/zod";
import { Navigate, useNavigate } from "react-router-dom";
import { Axios } from "axios";


function LoginRecepptionist(){
    const URL_API = 'http://localhost:8080/api/v1/login/login';
    const loginSchema = z.object({
        email: z
            .string()
            .regex(/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/, "O email precisa ser válido"),
        password: z.string().min(6, "A senha deve conter pelo menos 6 caracteres"),

    });
    const {
        register,
        handleSubmit,
        formState: { errors },
    } = useForm({
        resolver: zodResolver(loginSchema),
        defaultValues: {
            email: "",
            password: "",
            
        }
    });
    const onSubmit = async (data) => {
        try {
            // Fazer a requisição POST para o back-end
            const response = await axios.post(`${URL_API}/login`, {
                username: data.cpf,
                password: data.password,
                crm: data.crm
            });

            // Armazenar o token no localStorage
            localStorage.setItem('token', response.data.token);
            
            // Definir o cabeçalho Authorization para as próximas requisições
            axios.defaults.headers.common['Authorization'] = `Bearer ${response.data.token}`;
            
            // Redirecionar para a página do doutor
            navigate("/doctor/home");

        } catch (err) {
            // Exibir mensagem de erro caso o login falhe
            setErrMsg('Falha no login, verifique as credenciais');
            console.error(err);
        }
    }

    
    const navigate = useNavigate()

    
    return(
        <div className="flex justify-center items-center  bg-gray-100">
        <div className="w-full max-w-md bg-white rounded-lg shadow-lg p-8">
            <h1 className="text-2xl font-bold text-center text-blue-700 mb-6">Login SUS</h1>

          

            <form
                onSubmit={handleSubmit(onSubmit)}
                className="w-full max-w-md p-8 bg-white rounded-2xl shadow-2xl border border-gray-100"
            >
                <div className="space-y-6">
                    <div>
                        <label htmlFor="email" className="block text-sm font-medium text-gray-600 mb-2">
                            Email
                        </label>
                        <input
                            id="email"
                            type="text"
                            {...register("email")}
                            className={`w-full px-4 py-3 bg-gray-50 border-2 rounded-xl 
                            ${errors.email
                                ? "border-red-400"
                                : "border-gray-200"
                            }`}
                            placeholder="Digite seu número do cartão"
                        />
                        {errors.cpf && (
                            <div className="text-red-500 text-sm mt-2">
                                {errors.email.message}
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

export default LoginRecepptionist